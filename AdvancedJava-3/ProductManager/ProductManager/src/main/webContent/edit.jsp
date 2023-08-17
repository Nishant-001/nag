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
<form action="EditProduct" method="post" enctype="multipart/form-data" style="margin-right:25%; margin-left:25%; margin-bottom:10%">
		<input type = "hidden" name = "id" value = "${param.id}">
	    <div>
	    	 <label for="id">Id : </label>
	      	<input type="text" name="eid" value="${param.id}" disabled>
	    </div>
	    <div>
	      <label for="name">Title : </label>
	      <input type="text" name="title" placeholder="Enter Title Here" required>
	  	</div>
	  	<div>
	    <label for="size">Size : </label>
	    <input type="text" name="size" placeholder="Enter size Here" required>
	  	</div>
	 	<div>
			<label for="quantity">Quantity : </label>
	    	<input type="text" name="quantity" placeholder="Enter quantity Here" required>
	  	</div>
	  	<div>
			<label for="image">Image : </label>
	    	<input type="file" name="image" placeholder="Image here" required>
	  	</div>
	  	<button type="submit">Save Changes</button>
	  	<a href="PMT.jsp">
	  		<button type="button">Cancel</button>
	  	</a>
</body>
</html>