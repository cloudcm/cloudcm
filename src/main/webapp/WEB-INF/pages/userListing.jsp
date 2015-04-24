<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Welcome to Shopping List App</title>
</head>
<body>
	<c:import url="includes/header.jsp"></c:import>
	
	<div align="center">
	
		<h3>Want to See Lists Shared with You? <a href="<c:url value="/user/sharedUserList" />">Click Here</a></h3>
		
		<div style="border: 1px solid #000; width:60%; padding: 1em;">
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
				
				<form:hidden path="userListId"/>
				<form:hidden path="sharedByUserId"/>
				
				<b style="color:red"><c:out value="${shareToUsernameMessage}"/></b>
			</form:form>
		</div>
		
		<br/><br/>
		
		<div style="border: 1px solid #000; width:60%; padding: 1em;">
			<form:form action="addUserListItem" method="post" commandName="newUserListItem">
				
				<table>
					<form:hidden path="id" />
					<tr>
						<td>Insert Item in List:</td>
						<td><form:input path="item" /></td>
						<td><input type="submit" value="Add Item"></td>
					</tr>
				</table>
				
				<form:hidden path="userListId"/>
				
				<b style="color:red"><c:out value="${userListItemMessage}"/></b>
				
			</form:form>
		</div>
		
		
		
		<h1>Your Shopping List</h1>
		
		<table border="1" cellpadding="5" cellspacing="3" style="width: 50%;">
			<tr>
				<th>No</th>
				<th>Purchased</th>
				<th>Item</th>
				<th>Action</th>
			</tr>

			<c:forEach var="userListItem" items="${userListItems}" varStatus="status">
				<tr>
					<td>${status.index + 1}</td>
					<td>${userListItem.purchased}</td>
					<td>${userListItem.item}</td>
					<td style=" text-align: center;">
						<!--  <a href="editProduct?id=${product.id}">Edit</a> &nbsp;&nbsp; -->
						<a href="deleteUserListItem?id=${userListItem.id}">Delete</a>
					</td>

				</tr>
			</c:forEach>
		</table>
	</div>
</body>
</html>
