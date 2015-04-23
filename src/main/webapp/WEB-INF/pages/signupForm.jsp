<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" 
	"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>User Sign Up</title>
</head>
<body>

	<div align="center">
		<h1>Sign Up for Your Shopping List</h1>
		
		<form:form action="user/signupUser" method="post" commandName="user">
			<table>
				<form:hidden path="id" />
				
				<tr>
					<td>First Name:</td>
					<td><form:input path="firstName" /></td>
					<td><form:errors path="firstName" /></td>
				</tr>
				<tr>
					<td>Last Name:</td>
					<td><form:input path="lastName" /></td>
					<td><form:errors path="lastName" /></td>
				</tr>
				<tr>
					<td>Username:</td>
					<td><form:input path="username" /></td>
					<td><form:errors path="username" /></td>
				</tr>
				<tr>
					<td>Password:</td>
					<td><form:password path="password" /></td>
					<td><form:errors path="password" /></td>
				</tr>
				<tr>
					<td colspan="2" align="center"><input type="submit" value="Sign Up"></td>
				</tr>
			</table>
		</form:form>
		
		<h2>Already have an account? <a href="<c:url value="/login" />">Sign In</a></h2>
	</div>
</body>
</html>