package com.indianbank.controller;


import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import com.indianbank.DAO.CustomerDao;
import com.indianbank.DAO.Customers;


public class LoginServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

	public void doPost(HttpServletRequest request , HttpServletResponse response) throws IOException, ServletException {
		
		String emailString = request.getParameter("email");
		String pswdString = request.getParameter("pswd");
		
		CustomerDao cDao = new CustomerDao();
		
		boolean flag = cDao.authenticate(emailString, pswdString);
		
		if(flag) {
			
			Customers customer = new Customers();
			
			customer = cDao.getUserData(emailString);
			
			HttpSession session = request.getSession();
			session.setAttribute("emailString", emailString);
			
			request.setAttribute("customer", customer);

			RequestDispatcher requestDispatcher = request.getRequestDispatcher("userdetails.jsp");
			requestDispatcher.forward(request, response);
			return;
	    }
		else {
		response.sendRedirect("errorPage.jsp");
		return;
		}
	}
}
