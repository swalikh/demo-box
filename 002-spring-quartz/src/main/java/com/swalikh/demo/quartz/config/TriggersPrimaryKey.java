package com.swalikh.demo.quartz.config;

import lombok.Data;

import java.io.Serializable;

@Data
public class TriggersPrimaryKey implements Serializable {

    private String schedName;

    private String triggerGroup;

    private String triggerName;

}
