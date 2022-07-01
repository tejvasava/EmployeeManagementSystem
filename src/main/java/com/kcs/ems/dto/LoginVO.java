package com.kcs.ems.dto;

import lombok.Data;

@Data
public class LoginVO {

	private Long userId;
	
	private String password;
	
	private String role;
}
