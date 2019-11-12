package com.swalikh.demo.quartz.repository;

import com.swalikh.demo.quartz.entity.QrtzBlobTriggers;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface QrtzBlobTriggersRepository extends JpaRepository<QrtzBlobTriggers, String>, JpaSpecificationExecutor<QrtzBlobTriggers> {

}