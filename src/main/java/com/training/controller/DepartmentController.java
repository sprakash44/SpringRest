package com.training.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.imcs.model.Department;
import com.imcs.model.Employee;
import com.training.service.DepartmentService;

/**
 * Handles requests for the Employee service.
 */
@RestController
@RequestMapping("/dept")
public class DepartmentController {
	@Autowired
	DepartmentService departmentService;

	@RequestMapping(value = RestURIConstants.GET_DEPT, method = RequestMethod.GET)
	public @ResponseBody Department getDepartment(@PathVariable("id") int deptno) {
		return departmentService.getDepartment(deptno);
		// return empData.get(empId);
	}
	@RequestMapping(method = RequestMethod.GET, value = "{id}", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> getEmployeeById(@PathVariable("id") int deptno) {
		Department department= departmentService.getDepartment(deptno);
		
		if (department != null && department.getId() != 0) {
			return new ResponseEntity<>(department, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	@RequestMapping(value = "", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody List<Department> getAllDepartments() {
		// System.out.println(""+employeeService.getEmployeeWithDeptNo(deptNo));
		List<Department> depts = departmentService.getAllDepartments();
		return depts;

	}

}
