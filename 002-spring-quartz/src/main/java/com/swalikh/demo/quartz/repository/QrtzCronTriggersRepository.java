package com.swalikh.demo.quartz.repository;

import com.swalikh.demo.quartz.entity.QrtzCronTriggers;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface QrtzCronTriggersRepository extends JpaRepository<QrtzCronTriggers, String>, JpaSpecificationExecutor<QrtzCronTriggers> {

}