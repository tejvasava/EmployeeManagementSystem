package com.kcs.ems.service.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import com.kcs.ems.core.Compliance;
@Repository
public interface ComplianceRepository extends JpaRepository<Compliance, Long>, JpaSpecificationExecutor<Compliance> {

}
