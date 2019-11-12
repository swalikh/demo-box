package com.swalikh.demo.quartz.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Data
@Entity
@Table(name = "QRTZ_CRON_TRIGGERS")
public class QrtzCronTriggers implements Serializable {
  private static final long serialVersionUID = 1L;

  @Id
  @Column(name = "SCHED_NAME", insertable = false, nullable = false)
  private String schedName;

  @Column(insertable = false, name = "TRIGGER_NAME", nullable = false)
  private String triggerName;

  @Column(name = "TRIGGER_GROUP", insertable = false, nullable = false)
  private String triggerGroup;

  @Column(name = "CRON_EXPRESSION", nullable = false)
  private String cronExpression;

  @Column(name = "TIME_ZONE_ID")
  private String timeZoneId;

  
}