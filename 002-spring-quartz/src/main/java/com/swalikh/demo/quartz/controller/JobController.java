package com.swalikh.demo.quartz.controller;

import com.swalikh.demo.quartz.service.JobService;
import com.swalikh.kernel.exception.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by lcy on 2017/11/8.
 */
@Api(value = "任务", tags = "任务管理服务的api")
@RequestMapping("/job-admin")
@RestController
public class JobController {

    @Autowired
    private JobService jobServiceImpl;

    @ApiOperation("创建任务")
    @RequestMapping(value = "/job", method = RequestMethod.POST)
    @ResponseBody
    public Result addJob(@RequestParam(value = "jobName") String jobName,
                         @RequestParam(value = "jobClassName") String jobClassName,
                         @RequestParam(value = "jobGroupName") String jobGroupName,
                         @RequestParam(value = "cronExpression") String cronExpression, @RequestParam(value = "desc") String desc) {
        jobServiceImpl.addJob(jobName, jobClassName, jobGroupName, cronExpression, desc);
        return Result.ok("OK");
    }

    @ApiOperation("异常")
    @RequestMapping(value = "/test", method = RequestMethod.POST)
    @ResponseBody
    public Result addJob() {
        int a = 1/0;
        return Result.ok("OK");
    }

    @ApiOperation("暂停任务")
    @RequestMapping(value = "/job/pause", method = RequestMethod.POST)
    @ResponseBody
    public Result pauseJob(@RequestParam(value = "jobName") String jobName,
                           @RequestParam(value = "jobGroupName") String jobGroupName) {
        jobServiceImpl.pauseJob(jobName, jobGroupName);
        return Result.ok("OK");
    }

    @ApiOperation("重启任务")
    @RequestMapping(value = "/job/resume", method = RequestMethod.POST)
    @ResponseBody
    public Result resumeJob(@RequestParam(value = "jobName") String jobName,
                            @RequestParam(value = "jobGroupName") String jobGroupName) {
        jobServiceImpl.resumeJob(jobName, jobGroupName);
        return Result.ok("OK");
    }

    @ApiOperation("重新设置任务")
    @RequestMapping(value = "/job/reschedule", method = RequestMethod.POST)
    @ResponseBody
    public Result rescheduleJob(@RequestParam(value = "jobName") String jobName,
                                @RequestParam(value = "jobGroupName") String jobGroupName,
                                @RequestParam(value = "cronExpression") String cronExpression, @RequestParam(value = "desc") String desc) {
        jobServiceImpl.rescheduleJob(jobName,jobGroupName,cronExpression,desc);
        return Result.ok("OK");
    }

    @ApiOperation("删除任务")
    @RequestMapping(value = "/job", method = RequestMethod.DELETE)
    @ResponseBody
    public Result deleteJob(@RequestParam(value = "jobName") String jobName,
                            @RequestParam(value = "jobGroupName") String jobGroupName) {
        jobServiceImpl.deleteJob(jobName, jobGroupName);
        return Result.ok("OK");
    }

    @ApiOperation("查询任务")
    @RequestMapping(value = "/job", method = RequestMethod.GET)
    @ResponseBody
    public Result queryJob(@RequestParam(value = "queryKey") String queryKey,
                           @RequestParam(value = "status") String status) {
        List list = jobServiceImpl.queryJob(queryKey, status);
        return Result.buildOk("OK",list);
    }

    @ApiOperation("校验任务是否重复")
    @RequestMapping(value = "/job/validate", method = RequestMethod.GET)
    @ResponseBody
    public Result validateJob(@RequestParam(value = "jobName") String jobName,
                              @RequestParam(value = "jobGroupName") String jobGroupName) {
        boolean flag = jobServiceImpl.checkExistsJobKey(jobName, jobGroupName);
        if(flag){
            return Result.err("重复了！");
        }
        return Result.ok("没有重复！");
    }

    @ApiOperation("校验是否有类名")
    @RequestMapping(value = "/job/validateClass", method = RequestMethod.GET)
    @ResponseBody
    public Result checkExistsClass(@RequestParam(value = "className") String className) {
        boolean flag = jobServiceImpl.checkExistsClass(className);
        if(flag){
            return Result.ok("有该类！");
        }
        return Result.err("没有该类！");
    }

    @ApiOperation("校验corn表达式")
    @RequestMapping(value = "/job/validateCornExpression", method = RequestMethod.GET)
    @ResponseBody
    public Result checkExistsCornExpression(@RequestParam(value = "cornExpression") String cornExpression) {
        boolean flag = jobServiceImpl.checkExistsCornExpression(cornExpression);
        if(flag){
            return Result.ok("cron表达式正确！");
        }
        return Result.err("cron表达式错误！");
    }
}