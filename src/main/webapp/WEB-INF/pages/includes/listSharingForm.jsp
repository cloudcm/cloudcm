<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<div class="panel panel-default">
	<div class="panel-heading">Share your list with others</div>
	<div class="panel-body">
		<form:form action="shareUserList" method="post"
			commandName="sharedUserList">
			<form:hidden path="id" />
			<div class="col-lg-2">
				<label for="shareToUsername" class="sr-only">Username</label>
			</div>
			<div class="col-lg-6">
				<form:input cssClass="form-control" placeholder="enter username" path="shareToUsername" autofocus="true" />
			</div>
			<div class="col-lg-3">
				<input class="btn btn-success btn-block" type="submit" value="Share">
			</div>

			<form:hidden path="userListId" />
			<form:hidden path="sharedByUserId" />

			<b style="color: red"><c:out value="${shareToUsernameMessage}" /></b>
		</form:form>
	</div>
</div>


