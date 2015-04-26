<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<div class="panel panel-default">
	<div class="panel-heading">Share your list with others</div>
	<div class="panel-body">
		<form:form action="shareUserList" method="post"
			commandName="sharedUserList">
			<table>
				<form:hidden path="id" />
				<tr>
					<td><form:input path="shareToUsername" /></td>
					<td><input type="submit" value="Share"></td>
				</tr>
			</table>

			<form:hidden path="userListId" />
			<form:hidden path="sharedByUserId" />

			<b style="color: red"><c:out value="${shareToUsernameMessage}" /></b>
		</form:form>
	</div>
</div>


