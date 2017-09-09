package com.training.service;

import java.util.List;

import com.imcs.model.Department;

public interface DepartmentService {
	Department getDepartment(int deptNo);

	List<Department> getAllDepartments();

}
