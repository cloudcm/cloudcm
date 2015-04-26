<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<div class="panel panel-default">
	<div class="panel-heading">Add items to your list</div>
	<div class="panel-body">
		<form:form action="addUserListItem" method="post"
			commandName="userListItem">
			<form:hidden path="id" />
			<div class="col-lg-2">
				<label for="item" class="sr-only">Username</label>
			</div>
			<div class="col-lg-6">
				<form:input cssClass="form-control" placeholder="enter item name" path="item" autofocus="true" />
			</div>
			<div class="col-lg-3">
				<input class="btn btn-success btn-block" type="submit"
					value="Add Item">
			</div>
			<form:hidden path="userListId" />
			<b style="color: red"><c:out value="${userListItemMessage}" /></b>
		</form:form>
	</div>
</div>


