package com.swalikh.demo.quartz.repository;

import com.swalikh.demo.quartz.entity.QrtzSchedulerState;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface QrtzSchedulerStateRepository extends JpaRepository<QrtzSchedulerState, String>, JpaSpecificationExecutor<QrtzSchedulerState> {

}