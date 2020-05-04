<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="tag" %> 

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>HOME</title>
</head>
<body>

<h1>Home</h1>
<a href="Profile">Profile</a>
<form action="Home" method="post">
	<tag:forEach var="post" items= "${allPosts}">
		<span>${post.getEmail()}</span><br>
		<span>${post.getContent()}</span><br>
		<span>${post.getPostDate()}</span><br>
		<span>${post.getLikes()}</span><br>
		 <img src="data:image/jpg;base64,${post.getImage()}" width="240" height="300"/>


	</tag:forEach>
	</form>
</body>
</html>