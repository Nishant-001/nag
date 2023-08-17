<%@ page language="java" contentType="text/html; charset=ISO-8859-1" 
    pageEncoding="ISO-8859-1" isELIgnored="false" %>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login_Page</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
</head>
<body>
	<nav class="navbar navbar-light bg-light">
        <div class="container-fluid">
            <a class=" navbar-brand"><b><h3>Product Management Tool</h3></b></a>
            <a class="navbar-brand">WELCOME "${username}"</a>
            <form class="d-flex" action="Logout" method="post">
            <button class="btn btn-outline-success" type="submit">Logout</button>
            </form>
        </div>
    </nav>
	<form action="AddProduct" method="post" enctype="multipart/form-data" style="margin-right:10%; margin-left:10%; margin-top:10%">
	    <div>
	      <label for="title">Title :</label>
	      <input type="text" name="title" placeholder="Enter Title Here" required>
	  	</div>
	  	<br>
	  	<div>
	    <label for="quantity">Quantity :</label>
	    <input type="text" name="quantity" placeholder="Enter Quantity Here" required>
	  	</div>
	  	<br>
	  	<div>
	    <label for="size">Size : </label>
	    <input type="text" name="size" placeholder="Enter Size Here" required>
	  	</div>
	  	<br>
	  	<div>
	    <label for="image">Image : </label>
	    <input type="file" name="image" placeholder="Enter Image Here" required>
	    <button type="submit">Add >> </button>
	  	</div>
	  	<br>
	</form>
	
	<br>
	<br>
	
	<table class="table table-bordered" >
				<thead>
				    <tr>
					    <th scope="col">#</th>
					    <th scope="col">Product Name</th>
					    <th scope="col">Size</th>
					    <th scope="col">Quantity</th>
					    <th scope="col">Image</th>
					    <th scope="col">Actions</th>
				    </tr>
			  	</thead>
			  	<tbody>
			  		<c:forEach var="product" items="${productList}" varStatus="status">
				  		<tr>
					        <th scope="row">${status.count}</th>
					        <td>${product.getTitle_c()}</td>
					        <td>${product.getSize_c()}</td>
					        <td>${product.getQuantity_c()}</td>
					        <td>${product.getImagePath_c()}</td>
					        <td>
								<a href="edit.jsp?id=<c:out value='${product.getId()}' />">
									edit
								</a>
								<a href ="DeleteProduct?id=<c:out value='${product.getId()}' />">
									delete
								</a>
							</td>
					     </tr>
					</c:forEach>
				</tbody>
		</table>	
</body>
</html>