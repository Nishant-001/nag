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

<link rel="stylesheet" type="text/css" href="/css/login.css" />
<title>Login</title>
</head>
<body>
	<div class="container">
		<div id="cont_header" class="row">
			<div class="col"  id="headerdiv">
				<h3 style="text-align: center;">Fresher Training</h3>
			</div>
		</div>
		<div class="row justify-content-center">

			<div class="row">
				<div class="col-md-12">
					<div class="panel col-md-102">
						<h5>${failed}</h5>
						<form 
							id="form_id" action="login" method="post">
							<fieldset>
								<div style="" id="username_id"
									class="form-group" style="">
									<mark>UserId:</mark>
									<input  type="text" minlength="5"
										maxlength="50" name="username"></input>
								</div>
								<div id="password_id"
									class="form-group" style="">
									<mark>Password:</mark>
									<input type="password" name="password" minlength="5"
										maxlength="10"></input>

								</div>
								<div style="" id="login">
									<button
										style=""
										type="submit" value="login">Login</button>
								</div>


								<h5 style="color: #62b854; text-align: center;">${logout}</h5>
								<h5 style="color: #62b854; text-align: center;">${success}</h5>
								<h5 style="color: #ff9578; text-align: center;">${msg}</h5>
							</fieldset>
						</form>
					</div>
				</div>
			</div>
		</div>
		<div id="footid" class="row">
			<div id="footdiv" class="col">
				<h3><small><small>&copy; Copyright freshertraining</small></h3>
			</div>
		</div>

		<script type=”text/javascript” src=”bootstrap/js/bootstrap.min.js”></script>
</body>
</html>