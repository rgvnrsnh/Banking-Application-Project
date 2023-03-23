<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body bgcolor="green">
	<h1>Thanks</h1><br>

<%
		String msg = (String) request.getAttribute("message");
	%> 
	
	<h1>  <% 
	if(msg != null || msg != "" )
		out.println(msg); %>  
	</h1>

</body>
</html>