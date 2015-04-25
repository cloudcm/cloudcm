<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<div style="border: 1px solid #000; width: 60%; padding: 1em;">

	<form:form action="addUserListItem" method="post" commandName="newUserListItem">

		<table>
			<form:hidden path="id" />
			<tr>
				<td>Insert Item in List:</td>
				<td><form:input path="item" /></td>
				<td><input type="submit" value="Add Item"></td>
			</tr>
		</table>

		<form:hidden path="userListId" />

		<b style="color: red"><c:out value="${userListItemMessage}" /></b>

	</form:form>
</div>