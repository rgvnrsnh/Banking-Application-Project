package com.indianbank.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class TransactionsDao {
	
	private CustomerDao cDao = new CustomerDao();
	
	public int addMoney(long account_num , double amount) throws ClassNotFoundException, SQLException {
	 
		Connection connection = cDao.createConnection();
	 
		String query = "INSERT INTO transactions VALUES (?,?)";
		
		PreparedStatement pStatement = connection.prepareStatement(query);
		
		pStatement.setLong(1, account_num);
		pStatement.setDouble(2, amount);
		
		int rowsaffected = pStatement.executeUpdate();
		
		return rowsaffected;
	}
	
///// delete userData
	
		public int deleteTransactions(long accout_num) throws ClassNotFoundException, SQLException {
			
			String queryString = "DELETE FROM transactions WHERE account_num=?";
			
			CustomerDao cDao = new CustomerDao();
			
			Connection connection = cDao.createConnection();
			
			PreparedStatement pStatement = connection.prepareStatement(queryString);
			pStatement.setLong(1, accout_num);
			
			int rowAffected = pStatement.executeUpdate();
			return rowAffected;
		}
}

