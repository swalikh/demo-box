package com.swalikh.demo.quartz.repository;

import com.swalikh.demo.quartz.entity.QrtzFiredTriggers;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface QrtzFiredTriggersRepository extends JpaRepository<QrtzFiredTriggers, String>, JpaSpecificationExecutor<QrtzFiredTriggers> {

}