package com.emids.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "Address")
public class EmployeeAddr implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "address_id")
	private int empAddrId;

	@Column(name = "street")
	@NotEmpty(message = "{NotEmpty.empAddress.street}")
	private String street;

	@Column(name = "area")
	@NotEmpty
	private String area;

	@Column(name = "city")
	@NotEmpty
	private String city;

	@Column(name = "pincode")
	@NotNull
	private int pincode;

	public int getEmpAddrId() {
		return empAddrId;
	}

	public void setEmpAddrId(int empAddrId) {
		this.empAddrId = empAddrId;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public int getPincode() {
		return pincode;
	}

	public void setPincode(int pincode) {
		this.pincode = pincode;
	}

	@Override
	public String toString() {
		return "EmployeeAddr [empAddrId=" + empAddrId + ", street=" + street + ", area=" + area + ", city=" + city
				+ ", pincode=" + pincode + "]";
	}

	public EmployeeAddr(String street, String area, String city, int pincode) {
		super();
		this.street = street;
		this.area = area;
		this.city = city;
		this.pincode = pincode;
	}

	public EmployeeAddr() {
		super();
	}

	@OneToOne(mappedBy = "empAddress")
	@JsonManagedReference
	private Employee employee;

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

}
