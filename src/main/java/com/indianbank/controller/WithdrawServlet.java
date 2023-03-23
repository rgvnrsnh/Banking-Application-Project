package com.indianbank.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

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

public class WithdrawServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)  throws ServletException, IOException {
		
			
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
			
			BalanceServlet bServlet = new BalanceServlet();
			
			List<Double> ls = bServlet.allTransactions(request);
			
			
				
		Double totalBalance = 0.0;
		
		for(Double values : ls) {
			totalBalance += values;
		}
		
		
			
		if(amount  <= totalBalance && amount >= 1) {
				tDao.addMoney(customers.getAccount_num(), amount * -1);
					
				String messageString = amount + " rupees has been debited from your account";
				request.setAttribute("message", messageString);
				RequestDispatcher requestDispatcher = request.getRequestDispatcher("UserSuccess.jsp");
				requestDispatcher.forward(request, response);
				return;
			}
		else
			{
			
				String messageString = "";
				 if(amount < 1) 	messageString = "can't withdraw less than 1 rupees";
				 else               messageString= "can't withdraw " + amount + " rupees as your bank balance is only " + totalBalance + " rupees" ;
			
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
;