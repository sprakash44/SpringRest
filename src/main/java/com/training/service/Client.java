package com.training.service;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.imcs.model.Department;
import com.imcs.model.Employee;

public class Client {

	public static void main(String[] args) {
		ApplicationContext context = new AnnotationConfigApplicationContext("com.training");
		DepartmentService dept = context.getBean(DepartmentServiceImpl.class);
		EmployeeService emp = context.getBean(EmployeeServiceImpl.class);
		
		List<Department> departments = dept.getAllDepartments();
		if (!departments.isEmpty()) {
			for(Department department:departments) {
				System.out.println("dep name A:"+department.getName());
			}
		}
		System.out.println("dept data :"+dept.getDepartment(222).toString());
		System.out.println("emp name :"+emp.getEmployee(101));
		List<Employee> employee = emp.getEmployeeWithDeptNo(111);
		if (!employee.isEmpty()) {
			for(Employee emp1:employee) {
				System.out.println("emps of dep 111 A:"+employee.toString());
			}
		}
		System.out.println("delete :"+emp.deleteEmployee(101));
		
		
	}

}
