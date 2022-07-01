package com.kcs.ems.service.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import com.kcs.ems.core.LoginMaster;
@Repository
public interface LoginMasterRepository  extends JpaRepository<LoginMaster, Long>, JpaSpecificationExecutor<LoginMaster> {

}
