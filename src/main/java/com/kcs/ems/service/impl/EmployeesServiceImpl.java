package com.kcs.ems.service.impl;

import java.util.List;
import java.util.Optional;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.kcs.ems.core.Employees;
import com.kcs.ems.dto.EmployeesVO;
import com.kcs.ems.dto.ResponseVO;
import com.kcs.ems.enums.ResponseStatus;
import com.kcs.ems.service.EmployeeService;
import com.kcs.ems.service.repository.EmployeeRepository;
import com.kcs.ems.utils.Messages;

@Service
public class EmployeesServiceImpl implements EmployeeService {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(EmployeesServiceImpl.class);
	
	@Autowired
	private EmployeeRepository employeeRepository;

	@Override
	public ResponseVO<?> addDepartment(EmployeesVO employeesvo) {
		// TODO Auto-generated method stub
		try {
			Employees employeesAppId = null;
			@SuppressWarnings("rawtypes")
			ResponseVO vo = validateRequest(employeesvo);
			if (vo == null) {
				System.out.println("in imple add");
				Employees emp = new Employees();
				emp.setDepartment(employeesvo.getDepartment());
				emp.setFirstName(employeesvo.getFirstName());
				emp.setLastName(employeesvo.getLastName());
				emp.setEmail(employeesvo.getEmail());
				emp.setDob(employeesvo.getDob());
				employeesAppId=employeeRepository.save(emp);
				//return ResponseVO.create(HttpStatus.OK.value(), "SUCCESS", "employees Added succssfully!!");
				return ResponseVO.create(HttpStatus.OK.value(), "SUCCESS", employeesAppId);
			}

		} catch (Exception e) {
			LOGGER.error(e.getMessage(), e);
			return ResponseVO.create(HttpStatus.INTERNAL_SERVER_ERROR.value(), ResponseStatus.FAIL.name(),
					e.getMessage());
		}
		return null;
	}

	private ResponseVO validateRequest(EmployeesVO employeesvo) {
		// TODO Auto-generated method stub
		System.out.println("in validate request");
		if(StringUtils.isBlank(employeesvo.getDob())
				&& StringUtils.isBlank(employeesvo.getFirstName())
				&& StringUtils.isBlank(employeesvo.getLastName())
				&& StringUtils.isBlank(employeesvo.getEmail()))
		{
			return ResponseVO.create(HttpStatus.INTERNAL_SERVER_ERROR.value(), ResponseStatus.FAIL.name(),
					Messages.APP_SUBMIT_FAILURE);
		}
		
		if(employeesvo.getDepartment()==null)
		{
			return ResponseVO.create(HttpStatus.INTERNAL_SERVER_ERROR.value(), ResponseStatus.FAIL.name(),
					Messages.APP_SUBMIT_FAILURE);
		}
		return null;
	}

	@Override
	public ResponseVO<?> getEmployee(String id) {
		// TODO Auto-generated method stub
		Long idpass= Long.parseLong(id);
		Optional<Employees> emp= employeeRepository.findById(idpass);
		return ResponseVO.create(HttpStatus.OK.value(), "SUCCESS", emp);
	}

	@Override
	public ResponseVO<?> getAllEmployee() {
		// TODO Auto-generated method stub
		List<Employees> emp=employeeRepository.findAll();
		return ResponseVO.create(HttpStatus.OK.value(), "SUCCESS", emp);
	}

	@Override
	public ResponseVO<?> removeEmployee(String empid) {
		// TODO Auto-generated method stub
		Long idpass= Long.parseLong(empid);
		Optional<Employees> emp= employeeRepository.findById(idpass);
		 employeeRepository.deleteById(idpass);
		 return ResponseVO.create(HttpStatus.OK.value(), "SUCCESS DELETED", emp);
	}

}
