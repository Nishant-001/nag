<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"
	import="java.io.*,java.util.*, javax.servlet.*" isELIgnored="false"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
	crossorigin="anonymous">

<link rel="stylesheet" type="text/css" href="/css/welcome.css" />
<title>Login</title>
</head>
<body>
	<%
		response.setHeader("Cache-Control", "no-cache, no-store , must-revalidate");
	%>

	<div class="container">
		<div id="header_id" class="row">
			<div class="col">
				<h3 id="heading_id">Fresher Training</h3>
			</div>
			<div class="row">
				<h6 id="userheading">welcome ${username}</h6>
				<form id="userheadingform" style="" action="logout" method="post">
					<button class="btn btn-outline-primary" type="submit"
						value="Logout">logout</button>
				</form>

			</div>

		</div>


		<div class="row">
			<div class="col">
				<div>
					<div id="tableheading">
						<h2>
							<b>Book Listing</b> <a style="" href="bookpage">
								<button class="btn btn-primary">Add a book</button>
							</a>
						</h2>

					</div>
					<div class="scrollit" style="">
						<table align="center" cellpadding="15%" border="1">

							<tr>
								<td><b>Book Code</b></td>
								<td><b>Book Name</b></td>
								<td><b>Book Author</b></td>
								<td><b>Data Added</b></td>
								<td><b>Action</b></td>

							</tr>
							<c:forEach var="book" items="${books}">
								<tr>

									<td style="text-align: center;">${book.getBcode()}</td>
									<td style="text-align: center;">${book.getBname()}</td>
									<td style="text-align: center;">${book.getBauthor()}</td>
									<td style="text-align: center;">${book.getBdate()}</td>
									<td style="text-align: center;"><a id="editbtn"
										href="edit?id=${book.getBcode()}">
											<button class="btn btn-outline-primary">edit</button>
									</a> <a id="deletebtn" href="delete?id=${book.getBcode()}">
											<button class="btn btn-outline-danger">delete</button>
									</a></td>


								</tr>

							</c:forEach>
						</table>
					</div>

				</div>
			</div>
		</div>
		<div id="footerid" class="row">
			<div class="col">
				<h3><small>&copy; Copyright freshertraining</small>
</h3>
			</div>
		</div>
	</div>




	<script type=”text/javascript” src=”bootstrap/js/bootstrap.min.js”></script>
</body>
</html>