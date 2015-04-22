<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Welcome to Shopping List App</title>
</head>
<body>
	<c:import url="includes/header.jsp"></c:import>
	
	<div align="center">
		<h1>Your Shopping List</h1>
		<h3>
			<a href="newProduct">Add New Item</a>
		</h3>
		<%-- <table border="1">
			<tr>
				<th>No</th>
				<th>Name</th>
				<th>Price</th>
				<th>Description</th>
				<th>Action</th>
			</tr>

			<c:forEach var="product" items="${productList}" varStatus="status">
				<tr>
					<td>${status.index + 1}</td>
					<td>${product.name}</td>
					<td>${product.price}</td>
					<td>${product.description}</td>
					<td><a href="editProduct?id=${product.id}">Edit</a> &nbsp;&nbsp;&nbsp;&nbsp; <a href="deleteProduct?id=${product.id}">Delete</a></td>

				</tr>
			</c:forEach>
		</table> --%>
		
		<a href="<c:url value="/admin/products" />">Show Products</a>
	</div>
</body>
</html>
