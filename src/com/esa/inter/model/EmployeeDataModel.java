package com.esa.inter.model;

import java.util.Date;

public class EmployeeDataModel {
	private String name;
	private int employeeId; 
	private String category;
	public Date entryDate;
	private String entryDateFormatted;
	private int salary;
	
	public EmployeeDataModel() {
		super();
		// TODO Auto-generated constructor stub
	}
	public EmployeeDataModel(String name, int employeeId, String category, Date entryDate, String entryDateFormatted, int salary) {
		super();
		this.name = name;
		this.employeeId = employeeId;
		this.category = category;
		this.entryDate = entryDate;
		this.entryDateFormatted = entryDateFormatted;
		this.salary = salary;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public Date getEntryDate() {
		return entryDate;
	}
	public void setEntryDate(Date entryDate) {
		this.entryDate = entryDate;
	}
	public String getEntryDateFormatted() {
		return entryDateFormatted;
	}
	public void setEntryDateFormatted(String entryDateFormatted) {
		this.entryDateFormatted = entryDateFormatted;
	}
	public int getSalary() {
		return salary;
	}
	public void setSalary(int salary) {
		this.salary = salary;
	}
	
	
	
}
