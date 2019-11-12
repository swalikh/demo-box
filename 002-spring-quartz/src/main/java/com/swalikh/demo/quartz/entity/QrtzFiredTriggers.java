package com.swalikh.demo.quartz.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Data
@Table(name = "QRTZ_FIRED_TRIGGERS")
public class QrtzFiredTriggers implements Serializable {
  private static final long serialVersionUID = 1L;

  @Id
  @Column(name = "SCHED_NAME", insertable = false, nullable = false)
  private String schedName;

  @Column(name = "ENTRY_ID", insertable = false, nullable = false)
  private String entryId;

  @Column(name = "TRIGGER_NAME", nullable = false)
  private String triggerName;

  @Column(name = "TRIGGER_GROUP", nullable = false)
  private String triggerGroup;

  @Column(name = "INSTANCE_NAME", nullable = false)
  private String instanceName;

  @Column(name = "FIRED_TIME", nullable = false)
  private Long firedTime;

  @Column(name = "SCHED_TIME", nullable = false)
  private Long schedTime;

  @Column(name = "PRIORITY", nullable = false)
  private Integer PRIORITY;

  @Column(name = "STATE", nullable = false)
  private String STATE;

  @Column(name = "JOB_NAME")
  private String jobName;

  @Column(name = "JOB_GROUP")
  private String jobGroup;

  @Column(name = "IS_NONCONCURRENT")
  private String nonconcurrent;

  @Column(name = "REQUESTS_RECOVERY")
  private String requestsRecovery;

  
}