<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<nav class="navbar navbar-inverse navbar-fixed-top">
	<div class="container">
		<div class="navbar-header">
			<c:if test="${pageContext.request.userPrincipal.name != null}">
				<button type="button" class="navbar-toggle collapsed"
					data-toggle="collapse" data-target="#navbar" aria-expanded="false"
					aria-controls="navbar">
					<span class="sr-only">Toggle navigation</span> <span
						class="icon-bar"></span> <span class="icon-bar"></span> <span
						class="icon-bar"></span>
				</button>
			</c:if>
			
			<a class="navbar-brand" href="#">Shopping List</a>
		</div>
		
		<div id="navbar" class="collapse navbar-collapse">
			<c:if test="${pageContext.request.userPrincipal.name != null}">
				<ul class="nav navbar-nav">
					<li><a href="<c:url value="/user/userList" />">My List</a></li>
					<li><a href="<c:url value="/user/sharedUserList" />">Shared List</a></li>
				</ul>
			</c:if>
			
			<div class="pull-right">
				<c:if test="${pageContext.request.userPrincipal.name != null}">
					<h3 style="color: #fff; margin-top: 0.75em;">
						<small>Welcome <b><c:out value="${loggedInUser.firstName}" /> <c:out value="${loggedInUser.lastName}" /></b> | <a href="<c:url value="/logout" />">Logout</a></small>
					</h3>
				</c:if>
			</div>
		</div>
		<!--/.nav-collapse -->
		
	</div>
</nav>