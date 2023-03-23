package com.indianbank.DAO;

import java.sql.*;
import javax.servlet.http.HttpSession;

public class CustomerDao {
	
/// CONNECTION :-	
	public Connection createConnection() throws ClassNotFoundException, SQLException {
		
		Class.forName("com.mysql.jdbc.Driver");
		
		String urlString = "jdbc:mysql://localhost:3306/bankapplication";
		String pswdString = "welcome1";
		String userString = "root";
		
		Connection conn = DriverManager.getConnection(urlString, userString, pswdString);	
		return conn;
	}
	
	
/// AUTHENTICATION	
	public boolean authenticate(String email, String pswd) {
		try {		
			
		Connection conn = this.createConnection();
		
		String queryString ="select user_password from customers where email=" +"\'" +email+"\'" ;
		
		Statement stk = conn.createStatement();
		
		ResultSet rs = stk.executeQuery(queryString); 
		String pswdString = "";
		
		if(rs.next()) {
			pswdString = rs.getString(1);
			
			if(pswd.equals(pswdString)) {
				return true;
			}
		}
		
		return false;
		
	
		} catch (ClassNotFoundException | SQLException e) { 
			System.out.println(e); 
			}
		
		return false;
		
	}
	
/////// SAVING CUSTOMER DATA
	public boolean saveCustomer(Customers cust) throws ClassNotFoundException, SQLException {
		
		try {
			Connection conn = this.createConnection();
			
			String queryString = "insert into customers (customer_name , father_name , uid , mobile_number , email , user_password , account_num , branch_name, IFSC_code) values (?,?,?,?,?,?,?,?,?)";
			
			PreparedStatement pStatement = conn.prepareStatement(queryString);
			
			System.out.println(cust.toString());
			
			pStatement.setString(1, cust.getName());
			pStatement.setString(2, cust.getFather_name());
			pStatement.setString(3, cust.getUid());
			pStatement.setString(4, cust.getMobile_number());
			pStatement.setString(5, cust.getEmail());
			pStatement.setString(6, cust.getPassword());
			pStatement.setLong(7, cust.getAccount_num());
			pStatement.setString(8, cust.getBranch());
			pStatement.setString(9, cust.getIFSC_code());
			
			int rowaffected = pStatement.executeUpdate();
			
			if(rowaffected == 1)
				return true;
		}
		catch (Exception e) {
			System.out.println(e);
		}
	  return false;	
	}
	
////// GET CUSTOMER DATA
		public Customers getUserData(String email) {
			
			Customers customer = new Customers();
			
			try {
				Connection conn = this.createConnection();
				
				String query = "select * from customers where email=?";
				
				PreparedStatement pStatement = conn.prepareStatement(query);
				
				pStatement.setString(1, email);
				ResultSet rSet = pStatement.executeQuery();
				
				if(rSet.next()) {
				customer.setName(rSet.getString(1));
				customer.setFather_name(rSet.getString(2));
				customer.setUid(rSet.getString(3));
				customer.setMobile_number(rSet.getString(4));
				customer.setEmail(rSet.getString(5));
				customer.setPassword(rSet.getString(6));
				customer.setAccount_num(rSet.getLong(7));
				customer.setIFSC_code(rSet.getString(8));
				customer.setBranch(rSet.getString(9));
				}
				return customer;	
			} 
			catch (Exception e) {
				System.out.println(e.getMessage());
			}
			
			return customer;
		}
	
	
///// update details
		
		public int updateDetails(Customers cust , HttpSession session) throws ClassNotFoundException, SQLException {
			Connection connection = this.createConnection();
			
			String emailString = (String) session.getAttribute("emailString");
			
			String query = "UPDATE customers SET customer_name =?, father_name = ? , uid = ? , mobile_number=? , email=? , user_password=? , branch_name=? , IFSC_code = ? WHERE email=?";
			
			PreparedStatement pStatement = connection.prepareStatement(query);
			
			pStatement.setString(1, cust.getName());
			pStatement.setString(2, cust.getFather_name());
			pStatement.setString(3, cust.getUid());
			pStatement.setString(4, cust.getMobile_number());
			pStatement.setString(5, cust.getEmail());
			pStatement.setString(6, cust.getPassword());
			pStatement.setString(7, cust.getBranch());
			pStatement.setString(8, cust.getIFSC_code());
			pStatement.setString(9, emailString );
			
			int rowsAffected = pStatement.executeUpdate(); 
			
			return rowsAffected;
		}
	
///// delete userData
		
		public int deleteData(String email) throws ClassNotFoundException, SQLException {
			
			String queryString = "DELETE FROM customers WHERE email=?";
			
			Connection connection = this.createConnection();
			
			PreparedStatement pStatement = connection.prepareStatement(queryString);
			pStatement.setString(1, email);
			
			int rowAffected = pStatement.executeUpdate();
			return rowAffected;
		}
	
}
