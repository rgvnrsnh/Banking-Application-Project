<%@page import="com.indianbank.DAO.CustomerDao"%>
<%@page import="com.indianbank.DAO.Customers"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Indian Bank</title>
</head>
<body bgcolor="orange">
	<div >
	
		<form action="detailsupdate" method="post">
		
		 <label for="customer_name">Update your name</label><br>
		 <input type="text" name="customer_name" ><br>
		 
		 <label for="father_name">Update your father name</label><br>
		 <input type="text" name="father_name" ><br>
		
		<label for="uid">Update your UID number</label><br>
		<input type="text" name="uid" ><br>
		
		<label for="mobile_number">Update your mobile number</label><br>
		<input type="text" name="mobile_number"><br>
		
		<label for="email">Update your email</label><br>
		<input type="text" name="email"> <br>
		
		<label for="password">Update your password</label><br>
		<input type="password" name="password" ><br>
		
		<label for="branch">Choose a branch:</label><br>
			<select name="branch" >
 			 	<option value="noida">noida</option>
 				 <option value="delhi">delhi</option>
 				 <option value="kanpur">kanpur</option>
 				 <option value="gurgaon">gurgaon</option>
 				 <option value="benaras">benaras</option>
 				 <option value="lucknow">lucknow</option>
 				 <option value="hyderabad">hyderabad</option>
 				 <option value="mumbai">mumbai</option>
 				 <option value="pune">pune</option>
 				 <option value="bangalore">bangalore</option>
			</select><br>
			
		<input type="submit">
		</form>
	</div>



</body>
</html>