<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" 
	"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>New/Edit Product</title>
</head>
<body>
	<c:import url="includes/header.jsp"></c:import>
	
	<div align="center">
		<h1>New/Edit Product</h1>
		<form:form action="saveProduct" method="post" commandName="product">
			<table>
				<form:hidden path="id" />
				<tr>
					<td>Name:</td>
					<td><form:input path="name" /></td>
					<td><form:errors path="name" /></td>
				</tr>
				<tr>
					<td>Price:</td>
					<td><form:input path="price" /></td>
					<td><form:errors path="price" /></td>
				</tr>
				<tr>
					<td>Description:</td>
					<td><form:textarea path="description" /></td>
					<td><form:errors path="description" /></td>
				</tr>
				<tr>
					<td colspan="2" align="center">
						<input type="submit" value="Save">
					</td>
				</tr>
			</table>
		</form:form>
	</div>
</body>
</html>