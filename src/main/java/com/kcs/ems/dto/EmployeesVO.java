package com.kcs.ems.dto;

import com.kcs.ems.core.Department;

import lombok.Data;

@Data
public class EmployeesVO {

	private Long empId;
	
	private String firstName;
	
	private String lastName;
	
	private String dob;
	
	private String email;
	
	private Department department;

}
