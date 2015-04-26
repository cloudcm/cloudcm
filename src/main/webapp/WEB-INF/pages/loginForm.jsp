<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" 
	"http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
<c:import url="includes/head.jsp"></c:import>
</head>

<body>
	<div class="container">
		<form name='f' action="j_spring_security_check" class="form-signin"
			method='POST'>
			<h2 class="form-signin-heading">Please sign in</h2>
			<div class="row">
				<div class="col-xs-12">
					<label for="inputEmail" class="sr-only">Email address</label>
				</div>
				<div class="col-xs-12">
					<input type="text" id="inputEmail" class="form-control"
						placeholder="Email address" required="" autofocus="">
				</div>
			</div>
			<div class="row">
				<div class="col-xs-12">
					<label for="inputPassword" class="sr-only">Password</label>
				</div>
				<div class="col-xs-12">
					<input type="password" id="inputPassword" class="form-control"
						placeholder="Password" required="">
				</div>
			</div>
			<div class="row">
				<div class="col-xs-6">
				<button class="btn btn-lg btn-primary btn-block" type="submit"
					value="Login">Sign in</button>
				</div>
			</div>
			<h4>
				Don't have an account? <a href="<c:url value="/signup" />">Sign
					Up</a>
			</h4>
		</form>
	</div>
</body>
</html>