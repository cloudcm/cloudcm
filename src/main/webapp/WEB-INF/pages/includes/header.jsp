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
			
			<a class="navbar-brand text-bold text-white" href="#">Shopping List</a>
		</div>
		
		<div id="navbar" class="collapse navbar-collapse">
			<c:if test="${pageContext.request.userPrincipal.name != null}">
				<ul class="nav navbar-nav">
					<li class=" <c:out value="${param.activeClass eq 'myList'? 'active' : ''}"/>"><a href="<c:url value="/user/userList" />">My List</a></li>
					<li class=" <c:out value="${param.activeClass eq 'sharedList'? 'active' : ''}"/>"><a href="<c:url value="/user/sharedUserList" />">Shared List</a></li>
				</ul>
			</c:if>
			
			<div class="pull-right">
				<c:if test="${pageContext.request.userPrincipal.name != null}">
					<h4 style="margin-top: 1.1em;">
						<small class="text-white">Welcome <b style="margin: 0 0.5em 0 0.25em;">
							<c:out value="${loggedInUser.firstName}" /> <c:out value="${loggedInUser.lastName}" /></b> | <a style="margin-left:0.5em;" class="text-bold" href="<c:url value="/logout" />">Logout</a></small>
					</h4>
				</c:if>
			</div>
		</div>
		<!--/.nav-collapse -->
		
	</div>
</nav>