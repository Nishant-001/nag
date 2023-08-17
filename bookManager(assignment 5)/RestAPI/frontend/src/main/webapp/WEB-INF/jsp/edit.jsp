<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"
	import="java.io.*,java.util.*, javax.servlet.*" isELIgnored="false"%>
	
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
	crossorigin="anonymous">
<link rel="stylesheet" type="text/css" href="/css/editbook.css"/>

<title>Login</title>
</head>
<body>
	<%
		response.setHeader("Cache-Control", "no-cache, no-store , must-revalidate");
	%>
	
	<div class="container">
		<div id="cont_header" class="row">
			<div class="col"  id="headerdiv">
				<h3 style="text-align: center;">Fresher Training</h3>
			</div>
			<div class="row">
				<h6 style="">welcome ${username}</h6>
				<form action="logout" method="post">
					<button id="btn_logout" type="submit" value="Logout" class="btn btn-outline-primary">logout</button>
				</form>
			</div>
		</div>
		<div class="row">
			<div class="col">
				<div  id="bookmargin" >
					<div id="div_h2" style="margin-bottom: 50px;">
						<h2>Edit Book Details</h2>
					</div>
					<h5>${msg}</h5>
					<form action="editbook" method="post">
						<label>Book Code </label> <input type="text" id="code" value="${book.getBcode()}"
						 name="bcode"><br> <br>
						<label>Book Name </label> <input type="text" id="name" value="${book.getBname()}"
							 name="bname"><br> <br>
						<label id="labelauth" style="">Author </label> <select id="bookAuthor"
							 name="bauthor">
							<option value="Robert Cecil">Robert Cecil</option>
							<option value="Andy Hunt">Andy Hunt</option>
							<option value="Erich Gamma">Erich Gamma</option>
							<option value="E.M. Forster">E.M. Forster</option>
						</select><br><br>
						<label>Added on</label> <input type="text" id="date"
							 name="bdate" value="${strdate}" readonly></input><br> <br>
						<div id="submitcancel">
						<button  id="submitid" class="btn btn-primary" type="submit">submit</button>
						<a id="cancelid" href="cancel" class="btn btn-danger">cancel</a>
						
						</div>
						
					</form>
				</div>
			</div>
		</div>
		<div id="footid" class="row">
			<div id="footdiv" class="col">
				<h3><small>&copy; Copyright freshertraining</small></h3>
			</div>
		</div>
	</div>	




		<script type=”text/javascript” src=”bootstrap/js/bootstrap.min.js”></script>
</body>
</html>