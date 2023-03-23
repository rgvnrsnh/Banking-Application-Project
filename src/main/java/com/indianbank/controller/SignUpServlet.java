package com.indianbank.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.indianbank.DAO.CustomerDao;
import com.indianbank.DAO.Customers;
import com.indianbank.bean.IfscBean;



public class SignUpServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter out = response.getWriter();
		
		String nameString = request.getParameter("customer_name").trim().toLowerCase();
		String fatherNameString = request.getParameter("father_name").trim().toLowerCase();
		String uidString = request.getParameter("uid").trim().toLowerCase();
		String emailString = request.getParameter("email").trim().toLowerCase();
		String passwordString = request.getParameter("password");
		String mobile =  (request.getParameter("mobile_number"));
		String branchString = request.getParameter("branch");
		
		String ifscString = "";
		
		switch (branchString) {
		case "noida" : {
			ifscString = IfscBean.getNoidaString();
			break;
		}
		case "delhi" : {
			ifscString = IfscBean.getDelhiString();
			break;
		}
		case "kanpur" : {
			ifscString = IfscBean.getKanpurString();
			break;
		}
		case "gurgaon" : {
			ifscString = IfscBean.getGuraonString();
			break;
		}
		case "benaras" : {
			ifscString = IfscBean.getBenarasString();
			break;
		}
		case "lucknow" : {
			ifscString = IfscBean.getLucknowString();
			break;
		}
		case "hyderabad" : {
			ifscString = IfscBean.getHyderabadString();
			break;
		}
		case "mumbai" : {
			ifscString = IfscBean.getMumbaiString();
			break;
		}
		case "pune" : {
			ifscString = IfscBean.getPuneString();
			break;
		}
		case "bangalore" : {
			ifscString = IfscBean.getBanglaloreString();
			break;
		}
		default:
			ifscString = IfscBean.getMumbaiString();
		}
		

		long account_num = (long) ( Math.random() * 100000000.0);
		
		Customers customers = new Customers(nameString, fatherNameString, uidString, mobile, emailString, passwordString, account_num, ifscString, branchString);
		
		CustomerDao cDao = new CustomerDao();
		
		if(nameString == "" || fatherNameString == "" || uidString == "" || mobile == "" || emailString == "" ) {
			response.sendRedirect("FailedSignupPage.jsp");
			return;
		}
		
		try {
			boolean dataSaved = cDao.saveCustomer(customers);
			
			if(dataSaved) {
				out.println("account opened successfully");
				response.sendRedirect("successPage.jsp");
				return;			}
			else {
				System.out.println("some error occured");
			}
		} 
		catch (ClassNotFoundException | SQLException e)
		{
			
			System.out.println(e.getMessage());
			
		}
		
	}

}
