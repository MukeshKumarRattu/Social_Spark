<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="tag" %> 

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Social Spark</title>
<link rel="stylesheet" href="CSS/style.css">
<link href="https://fonts.googleapis.com/css?family=Cinzel|Sarpanch|Comfortaa|Francois+One&display=swap" rel="stylesheet">
</head>
<body>

	<h1>Social Spark</h1>
	<fieldset>
		<form action="Login" method="POST">
			<input type="email" name="email" placeholder="Enter your Email">
			<br><br>
			<input type="password" name="pass" placeholder="Enter your Password">
			<br><br>&nbsp;&nbsp;&nbsp;
			<button type="submit">Login</button>
			<button type="reset">Reset</button>		
		</form>
	</fieldset>
	
	<tag:if test="${loginError}">
					<br>
					<span> incorrect email or password </span>	
	</tag:if><br>
    <a href="register.jsp">Create an Account!</a>
</body>
</html>