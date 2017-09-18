package com.emids.service;

import java.util.List;

import com.emids.model.Employee;

public interface  EmployeeService {
	
	public void addEmployee(Employee employee);
	
	public List<Employee> listEmployeess();
	
	public Employee getEmployee(int empid);
	
	public void deleteEmployee(int empid);
	
	 public Employee updateEmployee(Employee employee);

}
