<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" 
	"http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
<c:import url="includes/head.jsp"></c:import>
</head>

<body>
	<c:import url="includes/header.jsp"></c:import>
	
	<div class="container">

		<div class="row">
			<div class="col-md-4 col-md-offset-4">
				<form name='f' action="j_spring_security_check" class="form-signinUp" method='POST'>

					<div class="login-panel panel panel-default">
						<div class="panel-heading">
							<h3 class="panel-title text-bold">Please Sign In</h3>
						</div>

						<div class="panel-body">
							<c:if test="${not empty error}">
								<div class="row">
									<div class="col-xs-12 ">
										<div class="alert alert-danger alert-dismissable">
											<button type="button" class="close" data-dismiss="alert" aria-hidden="true">×</button>
											${error}
										</div>
									</div>
								</div>
							</c:if>

							<div class="row form-group">
								<div class="col-xs-12">
									<label for="username" class="sr-only">Username</label>
								</div>
								<div class="col-xs-12">
									<input type="text" name="username" class="form-control" placeholder="Username" required="" autofocus="">
								</div>
							</div>

							<div class="row form-group">
								<div class="col-xs-12">
									<label for="password" class="sr-only">Password</label>
								</div>
								<div class="col-xs-12">
									<input type="password" name="password" class="form-control" placeholder="Password" required="">
								</div>
							</div>

							<div class="row">
								<div class="col-xs-12">
									<button class="btn btn-lg btn-success btn-block" type="submit" value="Login">Sign in</button>
								</div>
							</div>
						</div>
					</div>

					<h4 class="text-center">
						Don't have an account? <a href="<c:url value="/signup" />">Sign Up</a>
					</h4>

				</form>
			</div>
		</div>
	</div>
</body>
</html>