package com.swalikh.demo.quartz.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Data
@Table(name = "QRTZ_CALENDARS")
public class QrtzCalendars implements Serializable {
  private static final long serialVersionUID = 1L;

  @Id
  @Column(name = "SCHED_NAME", insertable = false, nullable = false)
  private String schedName;

  @Column(insertable = false, name = "CALENDAR_NAME", nullable = false)
  private String calendarName;

  @Column(name = "CALENDAR", nullable = false)
  private byte[] CALENDAR;

  
}