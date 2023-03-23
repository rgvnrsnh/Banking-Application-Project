package com.indianbank.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import com.indianbank.DAO.CustomerDao;
import com.indianbank.DAO.Customers;
import com.indianbank.DAO.TransactionsDao;


public class DeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String email = (String) session.getAttribute("emailString");

		CustomerDao cDao = new CustomerDao();
		Customers customers = cDao.getUserData(email);
		
		try {
			
			TransactionsDao tDao = new TransactionsDao();

			int transactionsDeleted = tDao.deleteTransactions(customers.getAccount_num());
			int rowsaffected = 0;
			
			System.out.println(transactionsDeleted);
			if(transactionsDeleted >= 1) {
				rowsaffected= cDao.deleteData(customers.getEmail());
			}
						
			if(rowsaffected >= 1) {
				response.sendRedirect("login.jsp");
			 	return;
			}
		}
		catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}
