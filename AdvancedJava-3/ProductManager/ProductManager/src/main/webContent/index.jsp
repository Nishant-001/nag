<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
<title>Login_page</title>
</head>
<body>
<form action="Login" method="post" style="margin-right:25%; margin-left:25%; margin-bottom:10%">
	    <div>
	      <label for="name">Username : </label>
	      <input type="text" name="name" placeholder="Enter Username Here" required>
	  	</div>
	  	<div>
	    <label for="password">Password : </label>
	    <input type="password" name="password" placeholder="Enter Password Here" required>
	  	</div>
	 	<div>
	    <a href="">Forgotten your Password?</a>
	  	</div>
	  	<button type="submit">Login >> </button>
	</form>
</body>
</html>