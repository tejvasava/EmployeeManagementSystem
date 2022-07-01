package com.kcs.ems.service;

import java.util.List;

import com.kcs.ems.core.Department;
import com.kcs.ems.dto.DepartmentVO;
import com.kcs.ems.dto.ResponseVO;

public interface DepartmentService {

	ResponseVO<?> deleteDepartment(String departmentId);

	ResponseVO<?> addDepartment(DepartmentVO departmentvo);

	List<Department> getAllDepartments();

}
