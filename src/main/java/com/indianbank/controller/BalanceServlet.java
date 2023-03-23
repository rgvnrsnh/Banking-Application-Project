package com.indianbank.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
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


public class BalanceServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	public List<Double> allTransactions(HttpServletRequest request){
		
		HttpSession session = request.getSession();
		
		String emailString = (String) session.getAttribute("emailString");
		
		Customers customers = new Customers();
		CustomerDao cDao = new CustomerDao();
		
		customers = cDao.getUserData(emailString);
		
		Transactions transactions = new Transactions();
		
		transactions.setAccount_num(customers.getAccount_num());
		
		List<Double> ls = new ArrayList<>();
		
		String queryString = "select * from transactions where account_num = ?";
		
		try {
			Connection connection = cDao.createConnection();
			
			PreparedStatement pStatement = connection.prepareStatement(queryString);
			pStatement.setLong(1, transactions.getAccount_num());
			
			ResultSet rs = pStatement.executeQuery();
			
			
			while(rs.next()) {
				if(customers.getAccount_num() == rs.getLong(1)) {
					ls.add(rs.getDouble(2));
				}
			}	
		}
		catch (Exception e) {
			System.out.println(e.getMessage());
		}
	  return ls;	
	}

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Double> ls = this.allTransactions(request);
		
		double balance = 0;
		
		for(Double entries : ls) {
			balance += entries;
		}
	  
		
		String messageString = "your current bank balance is " + balance;
		
		request.setAttribute("message", messageString);
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("UserSuccess.jsp");
		requestDispatcher.forward(request, response);
		return;
	}
}
