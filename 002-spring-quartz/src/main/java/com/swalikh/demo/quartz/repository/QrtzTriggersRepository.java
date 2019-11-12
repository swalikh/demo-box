package com.swalikh.demo.quartz.repository;

import com.swalikh.demo.quartz.entity.QrtzTriggers;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface QrtzTriggersRepository extends JpaRepository<QrtzTriggers, String>, JpaSpecificationExecutor<QrtzTriggers> {

}