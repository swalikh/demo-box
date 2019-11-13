package com.swalikh.demo.quartz.service.impl;


import com.swalikh.demo.quartz.entity.QrtzJobDetails;
import com.swalikh.demo.quartz.entity.QrtzTriggers;
import com.swalikh.demo.quartz.job.BaseJob;
import com.swalikh.demo.quartz.repository.QrtzJobDetailsRepository;
import com.swalikh.demo.quartz.repository.QrtzTriggersRepository;
import com.swalikh.demo.quartz.service.JobService;
import com.swalikh.kernel.utils.TimeUtils;
import org.quartz.*;
import org.quartz.impl.triggers.CronTriggerImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class JobPlusServiceImpl implements JobService {


    @Autowired
    private Scheduler scheduler;

    @Autowired
    private QrtzJobDetailsRepository jobDetailsRepository;

    @Autowired
    private QrtzTriggersRepository qrtzTriggersRepository;

    /**
     * 创建任务
     */
    @Override
    public void addJob(String jobName, String jobClassName, String jobGroupName, String cronExpression, String desc) {
        try {
            // 启动调度器
            scheduler.start();
            //构建job信息
            JobDetail jobDetail = JobBuilder.newJob(getClass(jobClassName).getClass()).withIdentity(jobName, jobGroupName).withDescription(desc).build();
            //表达式调度构建器(即任务执行的时间)
            CronScheduleBuilder scheduleBuilder = CronScheduleBuilder.cronSchedule(cronExpression);
            //按新的cronExpression表达式构建一个新的trigger
            CronTrigger trigger = TriggerBuilder.newTrigger().withIdentity(jobName, jobGroupName)
                    .withSchedule(scheduleBuilder).build();
            scheduler.scheduleJob(jobDetail, trigger);
        } catch (SchedulerException e) {
            e.printStackTrace();
        }
    }

    /**
     * 暂停任务
     */
    @Override
    public void pauseJob(String jobName, String jobGroupName) {
        try {
            scheduler.pauseJob(JobKey.jobKey(jobName, jobGroupName));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 重启任务
     */
    @Override
    public void resumeJob(String jobName, String jobGroupName) {
        try {
            scheduler.resumeJob(JobKey.jobKey(jobName, jobGroupName));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 重新设置任务
     */
    @Override
    public void rescheduleJob(String jobName, String jobGroupName, String cronExpression, String desc) {
        try {
            TriggerKey triggerKey = TriggerKey.triggerKey(jobName, jobGroupName);
            // 表达式调度构建器
            CronScheduleBuilder scheduleBuilder = CronScheduleBuilder.cronSchedule(cronExpression);
            CronTrigger trigger = (CronTrigger) scheduler.getTrigger(triggerKey);
            // 按新的cronExpression表达式重新构建trigger
            trigger = trigger.getTriggerBuilder().withIdentity(triggerKey).withSchedule(scheduleBuilder).build();
            // 按新的trigger重新设置job执行
            scheduler.rescheduleJob(triggerKey, trigger);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 删除任务
     */
    @Override
    public void deleteJob(String jobName, String jobGroupName) {
        try {
            scheduler.pauseTrigger(TriggerKey.triggerKey(jobName, jobGroupName));
            scheduler.unscheduleJob(TriggerKey.triggerKey(jobName, jobGroupName));
            scheduler.deleteJob(JobKey.jobKey(jobName, jobGroupName));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public List queryJob(String groupName, String jobName, String status) {
        List<Map<String, String>> list = queryAllJobs();
        Stream<Map<String, String>> stream = list.stream();
        if(!StringUtils.isEmpty(groupName)){
            stream = stream.filter(map -> map.get("groupName").equals(groupName));
        }
        if(!StringUtils.isEmpty(jobName)){
            stream = stream.filter(map -> map.get("jobName").equals(jobName));
        }
        if(!StringUtils.isEmpty(status)){
            stream = stream.filter(map -> map.get("status").equals(status));
        }
        return stream.collect(Collectors.toList());
    }

    @Override
    public List<Map<String, String>> queryAllJobs() {
        List<QrtzJobDetails> list = jobDetailsRepository.findAll(Example.of(new QrtzJobDetails()));
        List<Map<String, String>> result = new ArrayList<>();
        list.forEach(ele -> {
            String jobName = ele.getJobName();
            String groupName = ele.getJobGroup();
            Map<String, String> job = new HashMap<>();
            try {
                JobDetail jobDetail = scheduler.getJobDetail(new JobKey(jobName, groupName));
                TriggerKey triggerKey = TriggerKey.triggerKey(jobName, groupName);
                CronTrigger trigger = (CronTrigger) scheduler.getTrigger(triggerKey);
                job.put("jobName", jobName);                             // 1.jobName 名字
                job.put("groupName", groupName);                         // 2.groupName 组名
                job.put("jobClass", jobDetail.getJobClass().getName());  // 3.jobClass
                job.put("cron", trigger.getCronExpression());            // 4.cron 表达式
                job.put("desc", ele.getDESCRIPTION());                   // 5.desc 描述
                job.put("status", getJobStatus(jobName, groupName));     // 6.status 当前job状态
                job.put("lastFire", TimeUtils.
                        forMatTime(trigger.getPreviousFireTime(),
                                "yyyy-MM-dd HH:ss"));               // 7.上次触发时间
                job.put("nextFire", TimeUtils.
                        forMatTime(trigger.getNextFireTime(),
                                "yyyy-MM-dd HH:ss"));               // 8.下次触发时间

                result.add(job);
            } catch (SchedulerException e) {
                e.printStackTrace();
            }
        });
        return result;
    }

    @Override
    public String getJobStatus(String jobName, String groupName) {
        Optional<QrtzTriggers> one = qrtzTriggersRepository.findOne(Example.of(new QrtzTriggers().setJobGroup(groupName).setJobName(jobName)));
        if (one.isPresent()) {
            String state = one.get().getTriggerState();
            if ("PAUSED".equals(state)) {
                return "暂停执行";
            } else if ("ACQUIRED".equals(state)) {
                return "正在执行";
            } else if ("WAITING".equals(state)) {
                return "等待执行";
            } else {
                return "其他";
            }
        }
        return "异常";
    }


    @Override
    public Boolean checkExistsJobKey(String name, String group) {
        try {
            return scheduler.checkExists(new JobKey(name, group));
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public Boolean checkExistsClass(String className) {
        Class<?> clazz;
        try {
            clazz = Class.forName(className);
            clazz.newInstance();
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public Boolean checkExistsCornExpression(String cronExpression) {
        CronTriggerImpl trigger = new CronTriggerImpl();
        try {
            trigger.setCronExpression(cronExpression);
            Date date = trigger.computeFirstFireTime(null);
            return date != null && date.after(new Date());
        } catch (Exception e) {
            return false;
        }
    }

    private BaseJob getClass(String classname) {
        Class<?> clazz;
        try {
            clazz = Class.forName(classname);
            BaseJob job = (BaseJob) clazz.newInstance();
            return job;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
