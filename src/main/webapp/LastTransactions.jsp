<%@page import="java.util.List"%>
<%@page import="com.indianbank.controller.BalanceServlet"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body bgcolor="green">
	<h1> your last 5 transactions are :</h1>
	
		<%
			 BalanceServlet balanceServlet = new BalanceServlet();

	    	 List<Double> ls = balanceServlet.allTransactions(request); 
		%>	
		
		<h3> <%
			if(ls.size() - 1 >= 0) 
			out.println(ls.get(ls.size()-1));
		%></h3>
		
		<h3> <%
			if(ls.size() - 2 >= 0) 
			out.println(ls.get(ls.size()-2));
		%></h3>
		
		<h3> <%
			if(ls.size() - 3 >= 0) 
			out.println(ls.get(ls.size()-3));
		%></h3>
		
		<h3> <%
			if(ls.size() - 4 >= 0) 
			out.println(ls.get(ls.size()-4));
		%></h3>
		
	
		<h3> <%
			if(ls.size() - 5 >= 0) 
			out.println(ls.get(ls.size()-5));
		%></h3>
</body>
</html>