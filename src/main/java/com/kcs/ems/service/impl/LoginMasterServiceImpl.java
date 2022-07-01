package com.kcs.ems.service.impl;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.kcs.ems.core.LoginMaster;
import com.kcs.ems.dto.LoginVO;
import com.kcs.ems.dto.ResponseVO;
import com.kcs.ems.enums.ResponseStatus;
import com.kcs.ems.service.LoginMasterService;
import com.kcs.ems.service.repository.LoginMasterRepository;
import com.kcs.ems.utils.Messages;

@Service
public class LoginMasterServiceImpl implements LoginMasterService {
	private static final Logger LOGGER = LoggerFactory.getLogger(LoginMasterServiceImpl.class);
	@Autowired
	private LoginMasterRepository loginMasterRepository;

	@Override
	public ResponseVO addLoginDetails(LoginVO loginvo) {
		try {
			LoginMaster appReqStatusId = null;
			ResponseVO vo = validateRequest(loginvo);
			if (vo == null) {
				LoginMaster loginMaster = new LoginMaster();
				loginMaster.setRole(loginvo.getRole());
				loginMaster.setPassword(loginvo.getPassword());
				appReqStatusId = loginMasterRepository.save(loginMaster);
				return ResponseVO.create(HttpStatus.OK.value(), "SUCCESS", Messages.ROLE_SUBMIT_SUCCESS);
			}
		} catch (Exception e) {

			LOGGER.error(e.getMessage(), e);
			return ResponseVO.create(HttpStatus.INTERNAL_SERVER_ERROR.value(), ResponseStatus.FAIL.name(),
					e.getMessage());
		}
		return null;
	}

	private ResponseVO validateRequest(LoginVO loginvo) {

		if (StringUtils.isBlank(loginvo.getPassword())) {
			return ResponseVO.create(HttpStatus.INTERNAL_SERVER_ERROR.value(), ResponseStatus.FAIL.name(),
					Messages.APP_SUBMIT_FAILURE);
		}
		if (StringUtils.isBlank(loginvo.getRole())) {
			return ResponseVO.create(HttpStatus.INTERNAL_SERVER_ERROR.value(), ResponseStatus.FAIL.name(),
					Messages.APP_SUBMIT_FAILURE);
		}
		return null;
	}

	@Override
	public ResponseVO<?> deleteRole(String userId) {
		Long id= Long.parseLong(userId);
		
		loginMasterRepository.deleteById(id);
		return ResponseVO.create(HttpStatus.OK.value(), "SUCCESS", "Role is deleted!!"); 
	}

}
