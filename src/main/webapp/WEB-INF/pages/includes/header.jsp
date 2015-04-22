<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<div style="text-align: center">
	<c:if test="${pageContext.request.userPrincipal.name != null}">
		<h3>
			User Info : ${pageContext.request.userPrincipal.name} | <a href="<c:url value="/logout" />">Logout</a>
		</h3>
	</c:if>
</div>
