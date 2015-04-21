<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Product Manager Home</title>
</head>
<body>
	<div align="center">
		<h1>Product List</h1>
		<h3>
			<a href="newProduct">New Product</a>
		</h3>
		<table border="1">
			<tr>
				<th>No</th>
				<th>Name</th>
				<th>Price</th>
				<th>Detail</th>
				<th>Action</th>
			</tr>

			<c:forEach var="product" items="${productList}" varStatus="status">
				<tr>
					<td>${status.index + 1}</td>
					<td>${product.name}</td>
					<td>${product.price}</td>
					<td>${product.detail}</td>
					<td><a href="editProduct?id=${product.id}">Edit</a> &nbsp;&nbsp;&nbsp;&nbsp; <a href="deleteProduct?id=${product.id}">Delete</a></td>

				</tr>
			</c:forEach>
		</table>
	</div>
</body>
</html>
