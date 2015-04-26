<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<div class="panel panel-default">
	<div class="panel-heading">
		<h3 class="panel-title text-bold">Share your list with others</h3>
	</div>

	<div class="panel-body">
		<form:form action="shareUserList" method="post" commandName="sharedUserList">
			<form:hidden path="id" />
			<div class="col-xs-2">
				<label for="shareToUsername" class="sr-only">Enter Username</label>
			</div>

			<div class="col-xs-12">
				<div class="form-group input-group">
					<form:input cssClass="form-control" placeholder="Enter username" path="shareToUsername" required="true" />

					<span class="input-group-btn">
						<input class="btn btn-success btn-block" type="submit" value="Share">
					</span>
				</div>

				<h5 class="text-danger mr-zero">
					<c:out value="${shareToUsernameMessage}" />
				</h5>
			</div>

			<form:hidden path="userListId" />
			<form:hidden path="sharedByUserId" />

		</form:form>
	</div>
</div>


