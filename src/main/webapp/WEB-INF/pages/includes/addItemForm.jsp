<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<div class="panel panel-default">
	<div class="panel-heading text-bold">
		<h3 class="panel-title text-bold">Add items to your list</h3>
	</div>

	<div class="panel-body">
		<form:form action="addUserListItem" method="post" commandName="userListItem">
			<form:hidden path="id" />
			<div class="col-xs-12">
				<label for="item" class="sr-only">Enter List item</label>
			</div>

			<div class="col-xs-12">
				<div class="form-group input-group">
					<form:input cssClass="form-control" placeholder="Enter List item" path="item" required="true" />

					<span class="input-group-btn">
						<input class="btn btn-success btn-block" type="submit" value="Add Item">
					</span>
				</div>

				<h5 class="text-danger mr-zero">
					<c:out value="${userListItemMessage}" />
				</h5>
			</div>

			<form:hidden path="userListId" />
		</form:form>
	</div>
</div>


