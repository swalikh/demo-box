package com.swalikh.demo.quartz.service;

import java.util.List;


public interface JobService {
    //new job
    void addJob(String jobName, String jobClassName, String jobGroupName, String cronExpression, String desc);

    //暂停 job
    void pauseJob(String jobName, String jobGroupName);

    //重启 job
    void resumeJob(String jobName, String jobGroupName);

    //重新设置 job
    void rescheduleJob(String jobName, String jobGroupName, String cronExpression, String desc);

    //删除job
    void deleteJob(String jobName, String jobGroupName);

    //查询job
    List queryJob(String queryKey, String status);

    //校验job key
    Boolean checkExistsJobKey(String name, String group);

    //校验class name
    Boolean checkExistsClass(String className);

    //校验CornExpression
    Boolean checkExistsCornExpression(String cronExpression);

}
