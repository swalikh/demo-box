package com.swalikh.demo.quartz.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Data
@Entity
@Table(name = "QRTZ_TRIGGERS")
public class QrtzTriggers implements Serializable {
  private static final long serialVersionUID = 1L;

  @Id
  @Column(name = "SCHED_NAME", insertable = false, nullable = false)
  private String schedName;

  @Column(insertable = false, name = "TRIGGER_NAME", nullable = false)
  private String triggerName;

  @Column(name = "TRIGGER_GROUP", insertable = false, nullable = false)
  private String triggerGroup;

  @Column(name = "JOB_NAME", nullable = false)
  private String jobName;

  @Column(name = "JOB_GROUP", nullable = false)
  private String jobGroup;

  @Column(name = "DESCRIPTION")
  private String DESCRIPTION;

  @Column(name = "NEXT_FIRE_TIME")
  private Long nextFireTime;

  @Column(name = "PREV_FIRE_TIME")
  private Long prevFireTime;

  @Column(name = "PRIORITY")
  private Integer PRIORITY;

  @Column(name = "TRIGGER_STATE", nullable = false)
  private String triggerState;

  @Column(name = "TRIGGER_TYPE", nullable = false)
  private String triggerType;

  @Column(name = "START_TIME", nullable = false)
  private Long startTime;

  @Column(name = "END_TIME")
  private Long endTime;

  @Column(name = "CALENDAR_NAME")
  private String calendarName;

  @Column(name = "MISFIRE_INSTR")
  private Integer misfireInstr;

  @Column(name = "JOB_DATA")
  private byte[] jobData;

  
}