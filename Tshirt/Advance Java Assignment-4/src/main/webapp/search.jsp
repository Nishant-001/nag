<%@page import="java.util.List"%>
<%@page import="com.nagarro.advancedJava.controller.SearchController"%>
<%@page import="com.nagarro.advancedJava.domain.TShirtDetails"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Product Search Web Application</title>
<style>
<%@include file="css/SearchPage.css"%>
</style>
</head>
<body>

	<div class="admin-page-wrapper">
		<div class="admin-header">
			<div class="hdr-title">
				<h2>T-Shirt Search Tool</h2>
				<nav class="right-hdr-item">
					<%
					String username = (String) session.getAttribute("username");

								if (username == null) {
									response.sendRedirect("index.jsp");
								} else {
					%>

					<h3>Hi!! <%=session.getAttribute("username")%></h3>
					<%
					}
					%>
				</nav>
			</div>
		</div>
		<div class="col-lg-5">
					<form action="logout" method="post">
						<input type="submit" value="Logout" class="btn btn-danger"></input>
					</form>
				</div>
		<div class="admin-form">
			<h4>Please enter the details here to search</h4>
			<form action="search" method="post">
				<input type="hidden" name="operation" value="addproduct" />
				<table class="form-table" border="0" cellpadding="10px"
					cellspacing="5px">
					<tr>
						<td>Color : </td>
						<td><input type="text" name="color"
							placeholder="colour(ex:Black)" required></td>
					</tr>
					<tr>
						<td>Size : </td>
						<td><input type="text" name="size"
							placeholder="Size(ex:S,M,L)" required></td>
					</tr>
					<tr>
						<td>Gender : </td>
						<td><input type="text" name="gender" placeholder="Size(M,F)" required></td>
					</tr>
					<tr>
						<td>Preference :</td>
						<td><input type="text" name="preference"
							placeholder="(ex:Price,Rating, Both)" required></td>
						<td><input type="submit" name="submit"></td>
					</tr>
				</table>
			</form>
		</div>
	</div>
	<br>
	 <%                  
     %>
	<%List<TShirtDetails> list = SearchController.getList();%>
	<%if(list.isEmpty()){%>
			<h1 style="color: red">${notFound}</h1>
	<%}%>
	

	<div class="show-content">
		<table class="content-table" border="1" cellpadding="10px"
			cellspacing="5px">
			<tr>
				<th>Id</th>
				<th>Name</th>
				<th>Size</th>
				<th>Color</th>
				<th>Gender</th>
				<th>Price</th>
				<th>Rating</th>
				<th>Availability</th>
			</tr>
			<%
			//List<TShirtDetails> list = SearchController.getList();
				for (TShirtDetails itr : list) {
			%>
			<tr>

				<td><%=itr.getId()%></td>
				<td><%=itr.getName()%></td>
				<td><%=itr.getSize()%></td>
				<td><%=itr.getColor()%></td>
				<td><%=itr.getGender()%></td>
				<td><%=itr.getPrice()%></td>
				<td><%=itr.getRating()%></td>
				<td><%=itr.getAvailability()%></td>

			</tr>
			<%
			}
			%>
			<tr>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td>Total number of products found</td>
				<%
				if (list.size() == 0) {
				%>
				<td style="color: red;"><%=list.size()%></td>
				<%
				} else {
				%>
				<td style="color: green;"><%=list.size()%></td>
				<%
				}
				%>
			</tr>
		</table>
	</div>

</body>
</html>