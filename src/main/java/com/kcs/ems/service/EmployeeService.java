package com.kcs.ems.service;

import com.kcs.ems.dto.EmployeesVO;
import com.kcs.ems.dto.ResponseVO;

public interface EmployeeService {

	ResponseVO<?> addDepartment(EmployeesVO employeesvo);

	ResponseVO<?> getEmployee(String id);

	ResponseVO<?> getAllEmployee();

	ResponseVO<?> removeEmployee(String empid);

}
