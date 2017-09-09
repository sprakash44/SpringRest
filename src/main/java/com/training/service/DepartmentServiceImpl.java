package com.training.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.imcs.dao.DepartmentDao;
import com.imcs.model.Department;

@Service
public class DepartmentServiceImpl implements DepartmentService {
	@Autowired
	DepartmentDao departmentDao;

	public Department getDepartment(int deptNo) {
		// TODO Auto-generated method stub
		return departmentDao.getDepartment(deptNo);
	}

	public List<Department> getAllDepartments() {
		// TODO Auto-generated method stub
		System.out.println("Entered to getAllDepartments");
		return departmentDao.getAllDepartments();
	}

}
