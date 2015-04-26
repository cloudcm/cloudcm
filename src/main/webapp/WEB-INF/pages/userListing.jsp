<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<c:import url="includes/head.jsp"></c:import>

<script>
    $(document).ready(function() {
        $('#dataTables-example').dataTable();
    });
    </script>
</head>
<body>
	<c:import url="includes/navigationbar.jsp"></c:import>
	
	<div class="container"  style="margin-top: 7em;">

		<c:import url="includes/listSharingForm.jsp"></c:import>

		<br /> <br />

		<c:import url="includes/addItemForm.jsp"></c:import>

		<h1>Your Shopping List</h1>

		<input id="markUserListItemUrl" type="hidden"
			value="${pageContext.request.contextPath}/user/markUserListItem" />

		<div class="row">
			<div class="col-lg-12">
				<div class="panel panel-default">
					<div class="panel-heading">DataTables Advanced Tables</div>
					<!-- /.panel-heading -->
					<div class="panel-body">
						<div class="table-responsive">
							<table class="table table-striped table-bordered table-hover" id="dataTables-example">
								<thead>
									<tr>
										<th>No</th>
										<th>Purchased</th>
										<th>Item</th>
										<th>Action</th>
									</tr>
								</thead>
								<tbody>
									<c:forEach var="userListItem" items="${userListItems}"
										varStatus="status">
										<tr>
											<td>${status.index + 1}</td>
											<td style="text-align: center;"><input type="checkbox"
												${userListItem.purchased ? 'checked' : ''}
												value="${userListItem.id}" onclick="markUnmarkItem(this)"></td>
											<td>${userListItem.item}</td>
											<td style="text-align: center;">
												<!--  <a href="editProduct?id=${product.id}">Edit</a> &nbsp;&nbsp; -->
												<a href="deleteUserListItem?id=${userListItem.id}">Delete</a>
											</td>

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

	</div>

</body>
</html>
