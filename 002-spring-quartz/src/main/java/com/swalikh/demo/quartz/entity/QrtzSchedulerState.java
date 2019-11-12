package com.swalikh.demo.quartz.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Data
@Table(name = "QRTZ_SCHEDULER_STATE")
public class QrtzSchedulerState implements Serializable {
  private static final long serialVersionUID = 1L;

  @Id
  @Column(name = "SCHED_NAME", insertable = false, nullable = false)
  private String schedName;

  @Column(name = "INSTANCE_NAME", insertable = false, nullable = false)
  private String instanceName;

  @Column(name = "LAST_CHECKIN_TIME", nullable = false)
  private Long lastCheckinTime;

  @Column(name = "CHECKIN_INTERVAL", nullable = false)
  private Long checkinInterval;

  
}