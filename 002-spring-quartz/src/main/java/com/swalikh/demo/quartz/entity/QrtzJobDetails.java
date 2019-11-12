package com.swalikh.demo.quartz.entity;

import lombok.Data;
import lombok.experimental.Accessors;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "QRTZ_JOB_DETAILS")
@Data
@Accessors(chain = true)
public class QrtzJobDetails implements Serializable {
  private static final long serialVersionUID = 1L;

  @Id
  @Column(name = "SCHED_NAME", insertable = false, nullable = false)
  private String schedName;

  @Column(insertable = false, name = "JOB_NAME", nullable = false)
  private String jobName;

  @Column(insertable = false, name = "JOB_GROUP", nullable = false)
  private String jobGroup;

  @Column(name = "DESCRIPTION")
  private String DESCRIPTION;

  @Column(name = "JOB_CLASS_NAME", nullable = false)
  private String jobClassName;

  @Column(name = "IS_DURABLE", nullable = false)
  private String durable;

  @Column(name = "IS_NONCONCURRENT", nullable = false)
  private String nonconcurrent;

  @Column(name = "IS_UPDATE_DATA", nullable = false)
  private String updateData;

  @Column(name = "REQUESTS_RECOVERY", nullable = false)
  private String requestsRecovery;

  @Column(name = "JOB_DATA")
  private byte[] jobData;

  
}