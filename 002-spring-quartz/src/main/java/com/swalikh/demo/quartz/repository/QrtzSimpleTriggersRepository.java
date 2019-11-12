package com.swalikh.demo.quartz.repository;

import com.swalikh.demo.quartz.entity.QrtzSimpleTriggers;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface QrtzSimpleTriggersRepository extends JpaRepository<QrtzSimpleTriggers, String>, JpaSpecificationExecutor<QrtzSimpleTriggers> {

}