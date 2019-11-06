package com.swalikh.demo.quartz.service.impl;


import com.swalikh.demo.quartz.job.BaseJob;
import com.swalikh.demo.quartz.service.JobService;
import org.quartz.*;
import org.quartz.impl.triggers.CronTriggerImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class JobPlusServiceImpl  implements JobService {


    @Autowired
    private Scheduler scheduler;

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
    public void rescheduleJob(String jobName, String jobGroupName, String cronExpression,String desc) {
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
    public List queryJob(String queryKey, String status) {
        return null;
    }


    @Override
    public Boolean checkExistsJobKey(String name,String group) {
        try {
            return scheduler.checkExists(new JobKey(name,group));
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
            BaseJob job =(BaseJob)clazz.newInstance();
            return job;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
