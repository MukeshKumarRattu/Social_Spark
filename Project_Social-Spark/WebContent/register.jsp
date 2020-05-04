<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="tag" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Social Spark</title>
<link rel="stylesheet" href="CSS/style_register.css">
<link href="https://fonts.googleapis.com/css?family=Cinzel|Sarpanch|Comfortaa|Francois+One&display=swap" rel="stylesheet">
</head>
<body>

	<h1>Social Spark</h1>
	<fieldset>
		<form action="Register" method="POST">
		    <input type="firstname" name="first_name" placeholder="Enter your firstname">
			<br><br>
			<input type="lastname" name="last_name" placeholder="Enter your lastname">
			<br><br>
			<input type="email" name="email_id" placeholder="Enter your Email">
			<br><br>
			<input type="password" name="passwd" placeholder="Enter your Password">
			<br><br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			<button type="submit">Sign Up</button>	
		</form>
	</fieldset>
	
		<tag:if test="${registersuccess}">
		  <span>Account Created</span>
		</tag:if><br>
    <a href="index.jsp">Already have one! Sign in</a>
</body>
</html>