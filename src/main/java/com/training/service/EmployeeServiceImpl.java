package com.training.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.imcs.dao.EmployeeDao;
import com.imcs.model.Employee;
@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	EmployeeDao employeeDao;

	public List<Employee> getEmployeeWithDeptNo(int deptNo) {
		// TODO Auto-generated method stub
		return employeeDao.getEmployeeWithDeptNo(deptNo);
	}

	public Employee getEmployee(int empId) {
		// TODO Auto-generated method stub
		return employeeDao.getEmployee(empId);
	}

	public boolean deleteEmployee(int empId) {
		// TODO Auto-generated method stub
		return employeeDao.deleteEmployee(empId);
	}

	public boolean updateEmployee(int empno,Employee emp) {
		// TODO Auto-generated method stub
		return employeeDao.updateEmployee(empno,emp);
	}

	public int addEmployee(Employee emp) {
		// TODO Auto-generated method stub
		return employeeDao.addEmployee(emp);
	}

}
