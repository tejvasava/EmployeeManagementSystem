package com.kcs.ems.controller;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.kcs.ems.dto.LoginVO;
import com.kcs.ems.dto.ResponseVO;
import com.kcs.ems.service.LoginMasterService;

@RestController
@RequestMapping("/login")
public class LoginMasterController {
	private static final Logger LOGGER = LoggerFactory.getLogger(LoginMasterController.class);

	@Autowired
	private LoginMasterService loginMasterService;
	
	@PostMapping("")
	public ResponseVO<?> login(LoginVO Loginvo) throws IOException {
		LOGGER.info("In login controller");
		return loginMasterService.addLoginDetails(Loginvo);
	}
	
	@DeleteMapping("/deleteRole")
	public ResponseVO<?> deleteRole(@RequestParam("userId") String userId) throws IOException {
		LOGGER.info("In login controller");
		return loginMasterService.deleteRole(userId);
	}
}
