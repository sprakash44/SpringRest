package com.training.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.imcs.model.Employee;
import com.training.service.EmployeeService;

/**
 * Handles requests for the Employee service.
 */
@RestController
@RequestMapping("/employee")
public class EmployeeController {
	@Autowired
	EmployeeService employeeService;

	@RequestMapping(method = RequestMethod.GET, value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> getEmployeeById(@PathVariable("id") int empId) {
		Employee employee = employeeService.getEmployee(empId);
		if (employee != null && employee.getId() != 0) {
			return new ResponseEntity<>(employee, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody boolean updateEmployee(@PathVariable("id") int empno, @RequestBody Employee emp) {

		return employeeService.updateEmployee(empno, emp);
	}

	@RequestMapping(value = "/dept/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody List<Employee> getAllEmployees(@PathVariable("id") int deptNo) {
		// System.out.println(""+employeeService.getEmployeeWithDeptNo(deptNo));
		List<Employee> emps = employeeService.getEmployeeWithDeptNo(deptNo);
		return emps;

	}

	@RequestMapping(method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody void createEmployee(@RequestBody Employee emp) {
		//
		employeeService.addEmployee(emp);
	}

	@RequestMapping(value = "/deleteemp/{id}", method = RequestMethod.PUT)
	public @ResponseBody boolean deleteEmployee(@PathVariable("id") int empId) {

		return employeeService.deleteEmployee(empId);
	}

}
