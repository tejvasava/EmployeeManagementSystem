package com.kcs.ems.service;

import com.kcs.ems.dto.LoginVO;
import com.kcs.ems.dto.ResponseVO;

public interface LoginMasterService {

	ResponseVO addLoginDetails(LoginVO loginvo);

	ResponseVO<?> deleteRole(String userId);

}
