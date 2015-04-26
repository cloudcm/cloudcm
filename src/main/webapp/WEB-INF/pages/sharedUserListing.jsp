<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Lists Shared to You</title>
<c:import url="includes/head.jsp"></c:import>

<script>
	$(document).ready(function() {
		showDataTable();
	});
</script>

</head>

<body>
	<c:import url="includes/header.jsp">
		<c:param name="activeClass" value="sharedList"/>
	</c:import>

	<div class="container" style="margin-top: 7em;">

		<h1 class="text-center">Lists Shared with You</h1>

		<h4 class="text-center">
			<a href="<c:url value="/user/userList" />">Go Back</a>
		</h4>

		<c:if test="${empty sharedUserLists}">
			<div class="row">
				<div class="col-xs-12 ">
					<div class="alert alert-info">No one shared his list with you. <a class="alert-link" href="<c:url value="/user/userList" />">Go Back</a></div>
				</div>
			</div>
		</c:if>

		<input id="markUserListItemUrl" type="hidden" value="${pageContext.request.contextPath}/user/markUserListItem" />

		<c:forEach var="userList" items="${sharedUserLists}" varStatus="externalStatus">
			<div class="row">
				<div class="col-xs-12">
					<div class="panel panel-default">
						<div class="panel-heading">
							<h3 class="panel-title text-bold">${externalStatus.index + 1}.${userList.name}</h3>
						</div>

						<!-- /.panel-heading -->
						<div class="panel-body">
							<div class="table-responsive">
								<table class="listDataTable table table-striped table-bordered table-hover">
									<thead>
										<tr>
											<th>No</th>
											<th>Purchased</th>
											<th>Item</th>
										</tr>
									</thead>
									<tbody>
										<c:forEach var="userListItem" items="${userList.userListItems}" varStatus="status">
											<tr>
												<td>${status.index + 1}</td>
												<td class="text-center"><input type="checkbox" ${userListItem.purchased ? 'checked' : ''} value="${userListItem.id}"
													onclick="markUnmarkItem(this)"></td>
												<td>${userListItem.item}</td>
											</tr>
										</c:forEach>
									</tbody>
								</table>
							</div>
						</div>
						<!-- /.panel-body -->
					</div>
					<!-- /.panel -->
				</div>
				<!-- /.col-lg-12 -->
			</div>
		</c:forEach>
	</div>
</body>
</html>
