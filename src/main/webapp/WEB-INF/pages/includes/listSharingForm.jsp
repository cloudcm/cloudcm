<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<div style="border: 1px solid #000; width: 60%; padding: 1em;">
	<h2 style="margin-top: 0;">Share your list with others</h2>
	<form:form action="shareUserList" method="post" commandName="sharedUserList">
		<table>
			<form:hidden path="id" />
			<tr>
				<td>Type Username to share your list:</td>
				<td><form:input path="shareToUsername" /></td>
				<td><input type="submit" value="Share"></td>
			</tr>
		</table>

		<form:hidden path="userListId" />
		<form:hidden path="sharedByUserId" />

		<b style="color: red"><c:out value="${shareToUsernameMessage}" /></b>
	</form:form>
</div>