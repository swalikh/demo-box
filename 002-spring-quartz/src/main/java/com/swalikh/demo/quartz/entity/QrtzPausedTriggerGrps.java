package com.swalikh.demo.quartz.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "QRTZ_PAUSED_TRIGGER_GRPS")
@Data
public class QrtzPausedTriggerGrps implements Serializable {
  private static final long serialVersionUID = 1L;

  @Id
  @Column(name = "SCHED_NAME", insertable = false, nullable = false)
  private String schedName;

  @Column(name = "TRIGGER_GROUP", insertable = false, nullable = false)
  private String triggerGroup;

  
}