package com.emids.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.emids.dao.EmployeeDao;
import com.emids.model.Employee;

@Service("employeeService")
@Transactional()
public class EmployeeServiceImpl implements EmployeeService{
	
	@Autowired
	private EmployeeDao employeeDao;
	
	public void addEmployee(Employee employee) {
		employeeDao.addEmployee(employee);
	}
	
	public List<Employee> listEmployeess() {
		return employeeDao.listEmployeess();
	}
	
	public Employee getEmployee(int empid) {
		return employeeDao.getEmployee(empid);
	}
	
	public void deleteEmployee(int empid) {
		employeeDao.deleteEmployee(empid);
	}
	
	public Employee updateEmployee(Employee employee) {
        // TODO Auto-generated method stub
        return employeeDao.updateEmployee(employee);
    }
	 public void setEmployeeDAO(EmployeeDao employeeDAO) {
	        this.employeeDao = employeeDAO;
	    }

	
	 
}
