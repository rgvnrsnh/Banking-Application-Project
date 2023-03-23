<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body bgcolor="red">
	<h1>Thanks</h1><br>

	
	<h1>  <% 
	String msg = (String) request.getAttribute("message");
	if(msg != null || msg != "" )
		out.println(msg); %>  
	</h1>

</body>
</html>