package com.swalikh.demo.quartz.repository;

import com.swalikh.demo.quartz.entity.QrtzLocks;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface QrtzLocksRepository extends JpaRepository<QrtzLocks, String>, JpaSpecificationExecutor<QrtzLocks> {

}