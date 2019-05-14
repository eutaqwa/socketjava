package com.esa.inter.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.esa.inter.model.EmployeeDataModel;
import com.esa.inter.model.SalaryDataModel;
import com.esa.inter.services.Connect;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DataAccessObject {
	private Connection conn = null;
	
	public DataAccessObject(){
		conn = new Connect().getConnected();
	}
	
	public boolean insertSalary(SalaryDataModel insertsalary){
		boolean salary = false;
		PreparedStatement ps =null;
		try{
			String insertquery = "INSERT INTO salary(grade,salary) VALUES(?,?)";
			ps = conn.prepareStatement(insertquery);
			ps.setString(1, insertsalary.getGrade());
			ps.setInt(2, insertsalary.getMonthlySalary());
			ps.execute();
			salary = true;
		}catch(SQLException e){
			Logger.getLogger(DataAccessObject.class.getName()).log(Level.SEVERE, null, e);
		}
		finally{
			if(conn!=null)try{
				conn.close();
			}catch(SQLException se){
				Logger.getLogger(DataAccessObject.class.getName()).log(Level.SEVERE, null, se);
			}
			if(ps!=null) try{
				ps.close();
			}catch(SQLException se){
				Logger.getLogger(DataAccessObject.class.getName()).log(Level.SEVERE, null, se);
			}
		}
		return salary;
	}
	
	public boolean insertData(EmployeeDataModel insertdata){
		boolean insert = false;
		EmployeeDataModel employee = new EmployeeDataModel();
		employee.setEntryDate(new Date());
		SimpleDateFormat date = new SimpleDateFormat("EEEE, dd/MM/yyyy, HH:mm:ss");
		String dateformatted = date.format(employee.getEntryDate());
		employee.setEntryDateFormatted(dateformatted);
		PreparedStatement ps = null;
		try{
			String query = "INSERT INTO employee(idemployee,name,entrydate,category) VALUES (?,?,?,?)";
			ps = conn.prepareStatement(query);
			ps.setInt(1, insertdata.getEmployeeId());
			ps.setString(2, insertdata.getName());
			ps.setString(3, employee.getEntryDateFormatted());
			ps.setString(4, insertdata.getCategory());
			ps.execute();
			insert = true;
		}catch (SQLException e){
			Logger.getLogger(DataAccessObject.class.getName()).log(Level.SEVERE, null, e);
		}
		finally{
			if(conn!=null)try{
				conn.close();
			}catch (Exception e2) {
				Logger.getLogger(DataAccessObject.class.getName()).log(Level.SEVERE, null, e2);
			}
			if(ps!=null) try{
				ps.close();
			}catch (Exception e2) {
				Logger.getLogger(DataAccessObject.class.getName()).log(Level.SEVERE, null, e2);
			}
		}
		return insert;
	}
	
	
	public List<EmployeeDataModel> getEmployeeData(){
		List<EmployeeDataModel> listEmployee = new ArrayList<EmployeeDataModel>();
		ResultSet rs = null;
		try{
			String selectquery = "SELECT e.idemployee, e.name, e.category, e.entrydate, s.salary FROM employee AS e LEFT JOIN salary AS s ON e.category=s.grade ORDER BY e.entrydate";
			Statement stmt =conn.createStatement();
			rs = stmt.executeQuery(selectquery);
			while (rs.next()){
				EmployeeDataModel employee = new EmployeeDataModel();
				employee.setEmployeeId(rs.getInt(1));
				employee.setName(rs.getString(2));
				employee.setCategory(rs.getString(3));
				employee.setEntryDateFormatted(rs.getString(4));
				employee.setSalary(rs.getInt(5));
				listEmployee.add(employee);
			}
		}catch(SQLException e){
			Logger.getLogger(DataAccessObject.class.getName()).log(Level.SEVERE, null, e);
		}
		finally{
			if(conn!=null)try{
				conn.close();
			}catch(SQLException se){
				Logger.getLogger(DataAccessObject.class.getName()).log(Level.SEVERE, null, se);
			}
			if(rs!= null) try{
				rs.close();
			}catch (Exception e2) {
				Logger.getLogger(DataAccessObject.class.getName()).log(Level.SEVERE, null, e2);
			}
		}
		return listEmployee;
	}
	
	public List<SalaryDataModel> getSalary(){
		List<SalaryDataModel> listsalary = new ArrayList<SalaryDataModel>();
		ResultSet rs = null;
		try{
			String selectsalary = "SELECT * FROM salary";
			Statement stmt = conn.createStatement();
			rs = stmt.executeQuery(selectsalary);
			while(rs.next()){
				SalaryDataModel salary = new SalaryDataModel();
				salary.setGrade(rs.getString("grade"));
				Object qtySalary = rs.getObject("salary");
				salary.setMonthlySalary((int) qtySalary);
				listsalary.add(salary);
			}
			
		}catch (SQLException e){
			Logger.getLogger(DataAccessObject.class.getName()).log(Level.SEVERE, null, e);
		}
		finally {
			if(conn!=null) try{
				conn.close();
			}catch (SQLException e){
				Logger.getLogger(DataAccessObject.class.getName()).log(Level.SEVERE, null, e);
			}
			if(rs!=null) try{
				rs.close();
			}catch (Exception e2) {
				Logger.getLogger(DataAccessObject.class.getName()).log(Level.SEVERE, null, e2);
			}
		}return listsalary;
	}
}
	
