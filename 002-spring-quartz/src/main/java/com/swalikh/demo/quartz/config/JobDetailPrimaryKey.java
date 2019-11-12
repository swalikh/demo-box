package com.swalikh.demo.quartz.config;

import lombok.Data;

import java.io.Serializable;

@Data
public class JobDetailPrimaryKey implements Serializable {

    private String schedName;

    private String jobName;

    private String jobGroup;

}
