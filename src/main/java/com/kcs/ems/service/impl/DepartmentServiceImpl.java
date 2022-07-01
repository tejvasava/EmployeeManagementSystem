package com.kcs.ems.service.impl;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.kcs.ems.core.Department;
import com.kcs.ems.dto.DepartmentVO;
import com.kcs.ems.dto.ResponseVO;
import com.kcs.ems.enums.ResponseStatus;
import com.kcs.ems.service.DepartmentService;
import com.kcs.ems.service.repository.DepartmentRepository;
import com.kcs.ems.utils.Messages;

@Service
public class DepartmentServiceImpl implements DepartmentService{

	private static final Logger LOGGER = LoggerFactory.getLogger(DepartmentServiceImpl.class);
	@Autowired
	private DepartmentRepository departmentRepository;
	
	@Override
	public ResponseVO<?> deleteDepartment(String departmentId) {
		// TODO Auto-generated method stub
		Long id= Long.parseLong(departmentId);
		departmentRepository.deleteById(id);
		return ResponseVO.create(HttpStatus.OK.value(), "SUCCESS", "department is deleted!!");
	}

	@Override
	public ResponseVO<?> addDepartment(DepartmentVO departmentvo) {
		// TODO Auto-generated method stub
		try
		{
			System.out.println("departmentimpl");
			Department deparmentAppId=null;
			
			ResponseVO vo = validateRequest(departmentvo);
			if(vo==null)
			{
				Department dpartMent=new Department();
				dpartMent.setDepartmentName(departmentvo.getDepartmentName());
				deparmentAppId=departmentRepository.save(dpartMent);
				System.out.println("departmentimpl"+dpartMent.toString());
				return ResponseVO.create(HttpStatus.OK.value(), "SUCCESS", "department Added succssfully!!");
			}
		}
		catch(Exception e)
		{
			LOGGER.error(e.getMessage(), e);
			return ResponseVO.create(HttpStatus.INTERNAL_SERVER_ERROR.value(), ResponseStatus.FAIL.name(),
					e.getMessage());
		}
		return null;
	}

	private ResponseVO validateRequest(DepartmentVO departmentvo) {
		// TODO Auto-generated method stub
		if(StringUtils.isBlank(departmentvo.getDepartmentName()))
		{
			return ResponseVO.create(HttpStatus.INTERNAL_SERVER_ERROR.value(), ResponseStatus.FAIL.name(),
					Messages.APP_SUBMIT_FAILURE);
		}
		return null;
	}

	@Override
	public List<Department> getAllDepartments() {
		// TODO Auto-generated method stub
		return departmentRepository.findAll();
	}

}
