package com.esa.inter.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.URL;

import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



/**
 * Servlet implementation class InterRequestController
 */
@WebServlet("/InterRequestController")
public class InterRequestController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InterRequestController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		final String USER_AGENT = "Mozilla/5.0";
		PrintWriter pw = response.getWriter();
		String name = request.getParameter("name");
		String grade = request.getParameter("grade");
		String salary = request.getParameter("salary");
		String salaryencoder = URLEncoder.encode(salary, "UTF-8");
		String url = "http://localhost:8080/InsentifCalculator/IncentiveCalculatorController?grade="+grade+"&salary="+salaryencoder;
		URL object = new URL(url);
		HttpURLConnection urlcon = (HttpURLConnection) object.openConnection(); 
		urlcon.setRequestMethod("GET");
		urlcon.setRequestProperty("User-Agent", USER_AGENT);
		urlcon.getResponseCode();
		
		BufferedReader input = new BufferedReader(new InputStreamReader(urlcon.getInputStream()));
		
		String inputline;
		StringBuffer result = new StringBuffer();
		while((inputline = input.readLine())!=null){
			result.append(inputline);
		}
		input.close();
		String incentive = result.toString();
		pw.println(name+", "+incentive);
		

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
