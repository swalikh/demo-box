package com.swalikh.demo.quartz.entity;

import com.swalikh.demo.quartz.config.JobDetailPrimaryKey;
import lombok.Data;
import lombok.experimental.Accessors;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "QRTZ_JOB_DETAILS")
@Data
@IdClass(JobDetailPrimaryKey.class)
@Accessors(chain = true)
public class QrtzJobDetails implements Serializable {
  private static final long serialVersionUID = 1L;

  @Id
  @Column(name = "SCHED_NAME", insertable = false, nullable = false)
  private String schedName;

  @Id
  @Column(insertable = false, name = "JOB_NAME", nullable = false)
  private String jobName;

  @Id
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