package com.boot.database.test.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "emp")
public class Employee implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8272473660096426375L;
	
	@Id
	@Column(name = "emp_id")
	private Integer employeeId;
	
	@Column(name = "emp_name")
	private String employeeName;

	public Integer getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(Integer employeeId) {
		this.employeeId = employeeId;
	}

	public String getEmployeeName() {
		return employeeName;
	}

	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}

	public Employee(Integer employeeId, String employeeName) {
		super();
		this.employeeId = employeeId;
		this.employeeName = employeeName;
	}

	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}
	
    
}
