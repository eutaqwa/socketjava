package com.esa.inter.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.esa.inter.dao.DataAccessObject;
import com.esa.inter.model.EmployeeDataModel;
import com.esa.inter.model.SalaryDataModel;


/**
 * Servlet implementation class Controller
 */
@WebServlet("/Controller")
public class Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Controller() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void process(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		
		PrintWriter out = response.getWriter();
		EmployeeDataModel datagetter = new EmployeeDataModel();
		datagetter.setName(request.getParameter("name"));
		datagetter.setEmployeeId(Integer.parseInt(request.getParameter("employeeid")));
		datagetter.setCategory(request.getParameter("category"));
		DataAccessObject datasaver = new DataAccessObject();
		if (datasaver.insertData(datagetter)){
			//out.print("Your Employee Data Has Been Registered Successfully");
			response.sendRedirect("EmployeeDataController");
		} else {
			out.print("Error");
		}
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		DataAccessObject daosalary = new DataAccessObject();
		List<SalaryDataModel> salary = new ArrayList<SalaryDataModel>();
		salary = daosalary.getSalary();
		request.setAttribute("salary", salary);
		RequestDispatcher rd = request.getRequestDispatcher("/InputEmployee.jsp");
		rd.forward(request, response);
		
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		process(request, response);
	}

}
