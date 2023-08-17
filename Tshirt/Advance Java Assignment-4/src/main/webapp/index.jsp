<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"
	crossorigin="anonymous">
<title>Login</title>
<style>
<%@include file="css/LoginPage.css"%>
</style>
</head>
<body>

	<form action="login" method="post">
		<div class="imgcontainer">
			<img src="https://cdn-icons-png.flaticon.com/512/236/236832.png"
				alt="Avatar" class="avatar">
		</div>

		<div class="container">
			<%@include file="components/errorMessage.jsp"%>
			<label for="uname"><b>Username:</b></label> 
				<input type="text" placeholder="Enter Username" name="username" required> 
				<label for="psw"><b>Password:</b></label> 
				<input type="password" placeholder="Enter Password" name="password" required>

			<button type="submit">Login</button>
		</div>
	</form>
</body>
</html>
