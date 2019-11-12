package com.swalikh.demo.quartz.repository;

import com.swalikh.demo.quartz.entity.QrtzCalendars;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface QrtzCalendarsRepository extends JpaRepository<QrtzCalendars, String>, JpaSpecificationExecutor<QrtzCalendars> {

}