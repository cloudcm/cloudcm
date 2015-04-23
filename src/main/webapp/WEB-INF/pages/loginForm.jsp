<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" 
	"http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
	<title>Login</title>
</head>

<body>
	<div align="center">
		<h1 style="text-align: center">Login</h1>

		<form name='f' action="j_spring_security_check" method='POST'>
			<table>
				<tr>
					<td colspan="2"><h2>Enter your username/password:</h2></td>
				</tr>

				<tr>
					<td>User:</td>
					<td><input type='text' name='username' value=''></td>
				</tr>
				<tr>
					<td>Password:</td>
					<td><input type='password' name='password' /></td>
				</tr>
				<tr>
					<td colspan="2" style="text-align: center"><input name="submit" type="submit" value="Login" /></td>
				</tr>
			</table>
		</form>

		<h3>
			Don't have an account? <a href="<c:url value="/signup" />">Sign Up</a>
		</h3>
	</div>

</body>

</html>