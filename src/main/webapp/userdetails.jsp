<%@page import="com.indianbank.DAO.Customers"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Indian Bank</title>
</head>
<body bgcolor="#28857b">

	<%
	
		Customers customers = new Customers();
		
		customers = (Customers) request.getAttribute("customer");
		
		if(customers == null){
			response.sendRedirect("errorPage.jsp");
			return;
		}
	%>
	<h1>Hello, <% out.println(customers.getName()); %></h1>
	
	<form action="http://localhost:8080/bankingapplication/addmoney" method="post" >
	
	<label for="amount">Enter the amount to add</label>
	<input type = "number" name ="amount"  value = "0">
	
    <input type="submit" value="Add Money" />
	</form><br>
	
	
	<form action="http://localhost:8080/bankingapplication/withdrawmoney" method="post">
	
	<label for="amount">Enter the amount to withdraw</label>
	<input type = "number" name ="amount" value="0">
	
    <input type="submit" value="Withdraw Money" />
	</form>
<br>
	<form action="http://localhost:8080/bankingapplication/balance">
    <input type="submit" value="your bank balance" />
	</form>
<br>
	<form action="http://localhost:8080/bankingapplication/transactions">
    <input type="submit" value="know last 5 transactions" />
	</form>
<br>
	<form action="http://localhost:8080/bankingapplication/updatedetails" method="post">
    <input type="submit" value="update account details" />
	</form>	
<br>
	<form action="http://localhost:8080/bankingapplication/deleteuser" method="post">
    <input type="submit" value="delete customer account" />
	</form>	


</body>
</html>