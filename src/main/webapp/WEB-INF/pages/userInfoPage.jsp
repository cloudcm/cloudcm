<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page session="true"%>

<html>

<head>
	<title>${title}</title>
</head>

<body>
	<c:import url="includes/header.jsp"></c:import>

	<h2>Message : ${message}</h2>
	
	<a href="<c:url value="/admin/products" />">Show Products</a>
	
</body>

</html>