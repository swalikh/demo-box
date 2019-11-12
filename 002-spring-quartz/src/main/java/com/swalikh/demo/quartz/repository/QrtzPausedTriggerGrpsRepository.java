package com.swalikh.demo.quartz.repository;

import com.swalikh.demo.quartz.entity.QrtzPausedTriggerGrps;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface QrtzPausedTriggerGrpsRepository extends JpaRepository<QrtzPausedTriggerGrps, String>, JpaSpecificationExecutor<QrtzPausedTriggerGrps> {

}