<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<c:import url="includes/head.jsp"></c:import>
<c:import url="includes/header.jsp"></c:import>
</head>
<body>
	
	<c:import url="includes/navigationbar.jsp"></c:import>
	<div class="container">
	
		<h3>Want to See Lists Shared with You? <a href="<c:url value="/user/sharedUserList" />">Click Here</a></h3>
		
		<c:import url="includes/listSharingForm.jsp"></c:import>
		
		<br/><br/>
		
		<c:import url="includes/addItemForm.jsp"></c:import>
		
		<h1>Your Shopping List</h1>
		
		<input id="markUserListItemUrl" type="hidden" value="${pageContext.request.contextPath}/user/markUserListItem" /> 
		
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
					<td style=" text-align: center;"><input type="checkbox" ${userListItem.purchased ? 'checked' : ''} value="${userListItem.id}" onclick="markUnmarkItem(this)"></td>
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
