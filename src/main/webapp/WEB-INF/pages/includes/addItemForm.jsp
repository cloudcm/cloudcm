<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<div class="panel panel-default">
	<div class="panel-heading">Add items to your list</div>
	<div class="panel-body">
		<form:form action="addUserListItem" method="post"
			commandName="userListItem">

			<table>
				<form:hidden path="id" />
				<tr>
					<td><form:input path="item" /></td>
					<td><input type="submit" value="Add Item"></td>
				</tr>
			</table>

			<form:hidden path="userListId" />

			<b style="color: red"><c:out value="${userListItemMessage}" /></b>

		</form:form>
	</div>
</div>


