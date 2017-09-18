package com.emids.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.emids.model.Employee;
import com.emids.model.EmployeeAddr;

@Repository("employeeDao")
public class EmployeeDaoImpl implements EmployeeDao {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	public void addEmployee(Employee employee) {
		 Session session = sessionFactory.getCurrentSession();
		 EmployeeAddr address = employee.getEmpAddress();
		 EmployeeAddr add = new EmployeeAddr(address.getStreet(),address.getArea(), address.getCity(),address.getPincode());
		 Employee emp = new Employee(employee.getEmpName(), employee.getEmpDesign(), employee.getEmpSal(), add);
		 session.save(emp);
	}
	
	@SuppressWarnings("unchecked")
	public List<Employee> listEmployeess() {
		return (List<Employee>) sessionFactory.getCurrentSession().createCriteria(Employee.class).list();
	}

	
	public Employee getEmployee(int empid) {
		
		return (Employee) sessionFactory.getCurrentSession().get(Employee.class, empid);
	}

	public void deleteEmployee(int empid) {
		sessionFactory.getCurrentSession().createQuery("DELETE FROM Employee WHERE emp_id = "+ empid).executeUpdate();
	}
	
	 @Override
	    public Employee updateEmployee(Employee employee) {
	        sessionFactory.getCurrentSession().update(employee);
	        return employee;
	    }

}
