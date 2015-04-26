<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" 
	"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<c:import url="includes/head.jsp"></c:import>
</head>
<body>
	<div class="container">
		<h1>Sign Up for your Shopping List</h1>

		<form:form action="signupUser" method="post" commandName="user">
			<form:hidden path="id" />
			<div class="row">
				<div class="col-xs-12 col-sm-6">
					<div class="row">
						<div class="col-xs-12 col-sm-4 padding-left-zero">
							<h4 class="text-align-right">First Name*</h4>
						</div>
						<div class="col-xs-12 col-sm-8">
							<form:input path="firstName" />
							<b style="color: red"><form:errors path="firstName" /></b>
						</div>
					</div>
					<div class="row">
						<div class="col-xs-12 col-sm-4 padding-left-zero">
							<h4 class="text-align-right">Last Name*</h4>
						</div>
						<div class="col-xs-12 col-sm-8">
							<form:input path="lastName" />
							<b style="color: red"><form:errors path="lastName" /></b>
						</div>
					</div>
					<div class="row">
						<div class="col-xs-12 col-sm-4 padding-left-zero">
							<h4 class="text-align-right">Username*</h4>
						</div>
						<div class="col-xs-12 col-sm-8">
							<form:input path="username" />
							<b style="color: red"><form:errors path="username" /></b>
						</div>
					</div>
					<div class="row">
						<div class="col-xs-12 col-sm-4 padding-left-zero">
							<h4 class="text-align-right">Password*</h4>
						</div>
						<div class="col-xs-12 col-sm-8">
							<form:input path="password" />
							<b style="color: red"><form:errors path="password" /></b>
						</div>
					</div>
					<div class="row">
						<div class="col-xs-6 col-sm-4 padding-left-zero">
							<button class="btn btn-lg btn-primary btn-block" type="submit"
								value="Sign Up">Sign Up</button>
						</div>
					</div>
				</div>
			</div>
		</form:form>

		<h2>
			Already have an account? <a href="<c:url value="/login" />">Sign
				In</a>
		</h2>
	</div>
</body>
</html>