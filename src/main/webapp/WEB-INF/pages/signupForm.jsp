<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
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

		<div class="row">
			<div class="col-xs-4 col-xs-offset-4">

				<form:form action="signupUser" method="post" commandName="user" cssClass="form-signinUp">
					<div class="login-panel panel panel-default">
						<div class="panel-heading">
							<h3 class="panel-title">Sign Up for your Shopping List</h3>
						</div>

						<div class="panel-body">
							<form:hidden path="id" />

							<div class="row form-group">
								<div class="col-xs-12">
									<label for="firstName" class="sr-only">First Name</label>
								</div>

								<div class="col-xs-12">
									<form:input path="firstName" cssClass="form-control" placeholder="First Name" required="true" autofocus="true" />
								</div>
								
								<div class="col-xs-12">
									<form:errors path="firstName" />
								</div>
							</div>

							<div class="row form-group">
								<div class="col-xs-12">
									<label for="lastName" class="sr-only">Last Name</label>
								</div>

								<div class="col-xs-12">
									<form:input path="lastName" cssClass="form-control" placeholder="Last Name" required="true" />
								</div>
								
								<div class="col-xs-12">
									<form:errors path="lastName" />
								</div>
							</div>
							
							<div class="row form-group">
								<div class="col-xs-12">
									<label for="username" class="sr-only">Username</label>
								</div>

								<div class="col-xs-12">
									<form:input path="username" cssClass="form-control" placeholder="Username" required="true" />
								</div>
								
								<div class="col-xs-12">
									<form:errors path="username" />
								</div>
							</div>
							
							<div class="row form-group">
								<div class="col-xs-12">
									<label for="password" class="sr-only">Password</label>
								</div>

								<div class="col-xs-12">
									<form:password path="password" cssClass="form-control" placeholder="Password" required="true" />
								</div>
								
								<div class="col-xs-12">
									<form:errors path="password" />
								</div>
							</div>

							<div class="row">
								<div class="col-xs-12">
									<button class="btn btn-lg btn-success btn-block" type="submit" value="Sign Up">Sign Up</button>
								</div>
							</div>

						</div>
					</div>

				</form:form>

				<h4 class="text-center">
					Already have an account? <a href="<c:url value="/login" />">Sign In</a>
				</h4>
			</div>
		</div>
	</div>
</body>
</html>