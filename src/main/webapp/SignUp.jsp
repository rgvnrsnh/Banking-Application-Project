<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>signUp</title>
</head>
<body bgcolor="orange">
	<div >
		<form action="signupdetails" method="post">
		
		 <label for="customer_name">Enter your name</label><br>
		 <input type="text" name="customer_name" ><br>
		 
		 <label for="father_name">Enter your father name</label><br>
		 <input type="text" name="father_name" ><br>
		
		<label for="uid">Enter your UID number</label><br>
		<input type="text" name="uid" ><br>
		
		<label for="mobile_number">Enter your mobile number</label><br>
		<input type="text" name="mobile_number" ><br>
		
		<label for="email">Enter your email</label><br>
		<input type="text" name="email"> <br>
		
		<label for="password">Set your new password</label><br>
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