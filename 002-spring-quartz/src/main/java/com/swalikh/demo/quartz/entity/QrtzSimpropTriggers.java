package com.swalikh.demo.quartz.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.math.BigDecimal;

@Entity
@Table(name = "QRTZ_SIMPROP_TRIGGERS")
@Data
public class QrtzSimpropTriggers implements Serializable {
  private static final long serialVersionUID = 1L;

  @Id
  @Column(name = "SCHED_NAME", insertable = false, nullable = false)
  private String schedName;

  @Column(insertable = false, name = "TRIGGER_NAME", nullable = false)
  private String triggerName;

  @Column(name = "TRIGGER_GROUP", insertable = false, nullable = false)
  private String triggerGroup;

  @Column(name = "STR_PROP_1")
  private String strProp1;

  @Column(name = "STR_PROP_2")
  private String strProp2;

  @Column(name = "STR_PROP_3")
  private String strProp3;

  @Column(name = "INT_PROP_1")
  private Integer intProp1;

  @Column(name = "INT_PROP_2")
  private Integer intProp2;

  @Column(name = "LONG_PROP_1")
  private Long longProp1;

  @Column(name = "LONG_PROP_2")
  private Long longProp2;

  @Column(name = "DEC_PROP_1")
  private BigDecimal decProp1;

  @Column(name = "DEC_PROP_2")
  private BigDecimal decProp2;

  @Column(name = "BOOL_PROP_1")
  private String boolProp1;

  @Column(name = "BOOL_PROP_2")
  private String boolProp2;

  
}