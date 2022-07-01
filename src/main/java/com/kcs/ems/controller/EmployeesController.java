package com.kcs.ems.controller;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.kcs.ems.dto.EmployeesVO;
import com.kcs.ems.dto.ResponseVO;
import com.kcs.ems.service.EmployeeService;

@RestController
@RequestMapping("/employees")
public class EmployeesController {
	
	
	private static final Logger LOGGER = LoggerFactory.getLogger(EmployeesController.class);
	
	@Autowired
	private EmployeeService employeesService;
	
	@PostMapping("/add")
	public ResponseVO<?> addEmployee(EmployeesVO employeesvo) throws IOException {
		LOGGER.info("In login controller"+employeesvo.toString());
		return employeesService.addDepartment(employeesvo);
	}

	@GetMapping("/getEmp")   
	public ResponseVO<?> getEmployee(@RequestParam("empid")String empid)
	{
		System.out.println("'in controller empid");
		return employeesService.getEmployee(empid);
	}
	
	
	@GetMapping("/getAllEmp")
	public ResponseVO<?> getAllEmployee()
	{
		return employeesService.getAllEmployee();
	}
	
	@DeleteMapping("/delete")   
	public ResponseVO<?> deleteEmployee(@RequestParam("empid")String empid)
	{
		System.out.println("'in controller empid");
		return employeesService.removeEmployee(empid);
	}
	
}
