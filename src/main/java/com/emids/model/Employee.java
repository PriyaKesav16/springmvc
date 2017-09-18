package com.emids.model;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
//import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name = "Employeetbl")
public class Employee implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	@Column(name = "emp_id")
	private int empId;

	@Column(name = "emp_name")
	@NotEmpty()
	@Size(min = 2, max = 30)
	private String empName;

	@Column(name = "emp_desig")
	@NotEmpty()
	private String empDesign;

	@Column(name = "emp_sal")
	@NotNull(message = "feild  is required.")
	private int empSal;

	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name = "emp_addr_id")
	@JsonBackReference
	private EmployeeAddr empAddress;

	public int getEmpId() {
		return empId;
	}

	public void setEmpId(int empId) {
		this.empId = empId;
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public String getEmpDesign() {
		return empDesign;
	}

	public void setEmpDesign(String empDesign) {
		this.empDesign = empDesign;
	}

	public int getEmpSal() {
		return empSal;
	}

	public void setEmpSal(int empSal) {
		this.empSal = empSal;
	}

	public EmployeeAddr getEmpAddress() {
		return empAddress;
	}

	public void setEmpAddress(EmployeeAddr empAddress) {
		this.empAddress = empAddress;
	}

	@Override
	public String toString() {
		return "Employee [empId=" + empId + ", empName=" + empName + ", empDesign=" + empDesign + ", empSal=" + empSal
				+ ", empAddress=" + empAddress + "]";
	}

	public Employee() {
		super();
	}

	public Employee(String empName, String empDesign, int empSal, EmployeeAddr empAddress) {
		super();
		this.empName = empName;
		this.empDesign = empDesign;
		this.empSal = empSal;
		this.empAddress = empAddress;
	}
}
