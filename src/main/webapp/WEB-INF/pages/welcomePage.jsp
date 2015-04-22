<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page session="false"%>
<html>

<head>
	<title>${title}</title>
</head>

<body>
	<h1>Message : ${message}</h1>
	
	<a href="<c:url value="/login" />">Login</a>
</body>

</html>