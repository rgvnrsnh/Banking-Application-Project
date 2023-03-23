package com.indianbank.controller;

import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import com.indianbank.DAO.CustomerDao;
import com.indianbank.DAO.Customers;
import com.indianbank.bean.IfscBean;



public class UpdateDetailsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		String email = (String) session.getAttribute("emailString");

		CustomerDao cDao = new CustomerDao();
		Customers customers = cDao.getUserData(email);
		
		String nameString = request.getParameter("customer_name").trim().toLowerCase();
		String fatherNameString = request.getParameter("father_name").trim().toLowerCase();
		String uidString = request.getParameter("uid").trim().toLowerCase();
		String emailString = request.getParameter("email").trim().toLowerCase();
		String passwordString = request.getParameter("password");
		String mobile =  (request.getParameter("mobile_number"));
		String branchString = request.getParameter("branch");
		String ifscString = "";
		
		if(nameString == "") nameString = customers.getName();
		if(fatherNameString == "") fatherNameString = customers.getFather_name();
		if(uidString == "") uidString = customers.getUid();
		if(emailString == "") emailString = customers.getEmail();
		if(passwordString == "") passwordString = customers.getPassword();
		if(mobile == "") mobile = customers.getMobile_number();

		
		
		
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
		
		 customers = new Customers(nameString, fatherNameString, uidString, mobile, emailString, passwordString , ifscString , branchString);
				
		
		try {
			
			int dataUpdated = cDao.updateDetails(customers, session);
			
			if(dataUpdated >= 1) {
				session.removeAttribute("emailString");
				response.sendRedirect("login.jsp");
				return;
			}
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
