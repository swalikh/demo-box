package com.swalikh.demo.quartz.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import com.swalikh.demo.quartz.entity.QrtzJobDetails;
import org.springframework.stereotype.Repository;

@Repository
public interface QrtzJobDetailsRepository extends JpaRepository<QrtzJobDetails, String>, JpaSpecificationExecutor<QrtzJobDetails> {

}