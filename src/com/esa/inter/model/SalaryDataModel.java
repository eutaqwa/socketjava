package com.esa.inter.model;

public class SalaryDataModel {
	private String grade;
	private int monthlySalary;
	
	public SalaryDataModel() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public SalaryDataModel(String grade, int monthlySalary) {
		super();
		this.grade = grade;
		this.monthlySalary = monthlySalary;
	}

	public String getGrade() {
		return grade;
	}
	public void setGrade(String grade) {
		this.grade = grade;
	}
	public int getMonthlySalary() {
		return monthlySalary;
	}
	public void setMonthlySalary(int monthlySalary) {
		this.monthlySalary = monthlySalary;
	}
	
}
