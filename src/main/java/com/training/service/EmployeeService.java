package com.training.service;

import java.util.List;

import com.imcs.model.Employee;

public interface EmployeeService {
	public List<Employee> getEmployeeWithDeptNo(int deptNo);

	public Employee getEmployee(int empId);

	public boolean deleteEmployee(int empId);

	public boolean updateEmployee(int empno,Employee emp);

	public int addEmployee(Employee emp);

}
