package com.swalikh.demo.quartz.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "QRTZ_SIMPLE_TRIGGERS")
@Data
public class QrtzSimpleTriggers implements Serializable {
  private static final long serialVersionUID = 1L;

  @Id
  @Column(name = "SCHED_NAME", insertable = false, nullable = false)
  private String schedName;

  @Column(insertable = false, name = "TRIGGER_NAME", nullable = false)
  private String triggerName;

  @Column(name = "TRIGGER_GROUP", insertable = false, nullable = false)
  private String triggerGroup;

  @Column(name = "REPEAT_COUNT", nullable = false)
  private Long repeatCount;

  @Column(name = "REPEAT_INTERVAL", nullable = false)
  private Long repeatInterval;

  @Column(name = "TIMES_TRIGGERED", nullable = false)
  private Long timesTriggered;

  
}