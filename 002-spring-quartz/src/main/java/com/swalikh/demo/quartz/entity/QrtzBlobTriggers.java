package com.swalikh.demo.quartz.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Table(name = "QRTZ_BLOB_TRIGGERS")
@Entity
@Data
public class QrtzBlobTriggers implements Serializable {
  private static final long serialVersionUID = 1L;

  @Id
  @Column(name = "SCHED_NAME", insertable = false, nullable = false)
  private String schedName;

  @Column(insertable = false, name = "TRIGGER_NAME", nullable = false)
  private String triggerName;

  @Column(name = "TRIGGER_GROUP", insertable = false, nullable = false)
  private String triggerGroup;

  @Column(name = "BLOB_DATA")
  private byte[] blobData;

  
}