package com.swalikh.demo.quartz.job;

import org.quartz.Job;
import org.quartz.JobExecutionContext;

public class BaseJob implements Job {
    @Override
    public void execute(JobExecutionContext jobExecutionContext){
        System.out.println( "hello job 001");
    }
}
