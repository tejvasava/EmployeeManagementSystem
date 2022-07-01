package com.kcs.ems.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.kcs.ems.core.Department;
import com.kcs.ems.dto.DepartmentVO;
import com.kcs.ems.dto.ResponseVO;
import com.kcs.ems.service.DepartmentService;

@RestController
@RequestMapping("/department")
public class DepartmentController {


	@Autowired
	private DepartmentService departmentService;
	
	@PostMapping("/add")
	public ResponseVO<?> addDepartment(DepartmentVO departmentvo) throws IOException {
		System.out.println("test jenkins again");
		return departmentService.addDepartment(departmentvo);
	}
	
	@DeleteMapping("/delete")
	public ResponseVO<?> deleteDepartment(@RequestParam("departmentId") String departmentId) throws IOException {
		return departmentService.deleteDepartment(departmentId);
	}
	
	
	@GetMapping("/getDepartments")
	public List<Department> getDepartments()
	{
		return departmentService.getAllDepartments();
	}
	
}

