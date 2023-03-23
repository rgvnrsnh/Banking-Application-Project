package com.indianbank.controller;

import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import com.indianbank.DAO.CustomerDao;
import com.indianbank.DAO.Customers;
import com.indianbank.DAO.Transactions;
import com.indianbank.DAO.TransactionsDao;



public class AddMoneyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		double amount = Double.parseDouble(request.getParameter("amount"));
		
		String emailString = (String) session.getAttribute("emailString");
		
		Customers customers = new Customers();
		CustomerDao cDao = new CustomerDao();
		TransactionsDao tDao = new TransactionsDao();
		
		customers = cDao.getUserData(emailString);
		   
		Transactions transactions = new Transactions();
		
		transactions.setAccount_num(customers.getAccount_num());
		transactions.setTransactions(amount);
		
		try {
			
			if(amount < 100000.0 && amount >= 1.0) {
				tDao.addMoney(customers.getAccount_num(), amount);
				
				String messageString = amount + " rupees has been credited to your account";
				request.setAttribute("message", messageString);
				RequestDispatcher requestDispatcher = request.getRequestDispatcher("UserSuccess.jsp");
				requestDispatcher.forward(request, response);
				return;
			}
			else {
				String messageString= "can't add less than rupees 1 and more than 100000 at a time";
				request.setAttribute("message", messageString);
				RequestDispatcher requestDispatcher = request.getRequestDispatcher("addMoneyerror.jsp");
				requestDispatcher.forward(request, response);
				return;
			}
			
		} catch (ClassNotFoundException | SQLException e) {
			System.out.println(e.getMessage());
		}
		
	}

}
