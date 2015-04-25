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
			<label for="inputEmail" class="sr-only">Email address</label> <input
				type="email" id="inputEmail" class="form-control"
				placeholder="Email address" required="" autofocus=""> <label
				for="inputPassword" class="sr-only">Password</label> <input
				type="password" id="inputPassword" class="form-control"
				placeholder="Password" required="">
			<button class="btn btn-lg btn-primary btn-block" type="submit"
				value="Login">Sign in</button>

			<h3>
				Don't have an account? <a href="<c:url value="/signup" />">Sign
					Up</a>
			</h3>
		</form>
	</div>

</body>

</html>