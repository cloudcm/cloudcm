<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Lists Shared to You</title>

<script type="text/javascript" src="<c:url value="/assets/js/jquery-1.11.1.min.js" />"></script>
<script type="text/javascript" src="<c:url value="/assets/js/common.js" />"></script>
 
</head>

<body>
	<c:import url="includes/header.jsp"></c:import>
	
	<div align="center">
		
		<h1>Lists Shared with You</h1>
		
		<h4><a href="<c:url value="/user/userList" />">Go Back</a></h4>
		
		<input id="markUserListItemUrl" type="hidden" value="${pageContext.request.contextPath}/user/markUserListItem" /> 
		
		<c:forEach var="userList" items="${sharedUserLists}" varStatus="externalStatus">
			<h3>${externalStatus.index + 1}. ${userList.name} </h3>
			
			<table border="1" cellpadding="5" cellspacing="3" style="width: 50%;">
				<tr>
					<th>No</th>
					<th>Purchased</th>
					<th>Item</th>
					<!-- <th>Action</th> -->
				</tr>
	
				<c:forEach var="userListItem" items="${userList.userListItems}" varStatus="status">
					<tr>
						<td>${status.index + 1}</td>
						<td style=" text-align: center;"><input type="checkbox" ${userListItem.purchased ? 'checked' : ''} value="${userListItem.id}" onclick="markUnmarkItem(this)"></td>
						<td>${userListItem.item}</td>
						
						<%-- <td>
							<!--  <a href="editProduct?id=${product.id}">Edit</a> &nbsp;&nbsp; -->
							<a href="deleteUserListItem?id=${userListItem.id}">Delete</a>
						</td> --%>
	
					</tr>
				</c:forEach>
			</table>
		</c:forEach>
	</div>
</body>
</html>
