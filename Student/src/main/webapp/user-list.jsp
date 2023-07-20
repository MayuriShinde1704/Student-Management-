<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
<head>

<title>student Management Application</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
</head>
<body>

		<header>
		<div class="col-lg-12">
		<nav class="navbar navbar-expand-md navbar-dark"
			style="background-color: blue">
		
				<div class="text-align:right"><a href="LogOutServlet">  <Button>Logout</Button></a>
		</div>
				
			</nav></div>
		
	</header>
	<br>

		<div class="container">
		<div class="row">
		<div class="col-lg-12">
			<h3 class="text-center">List of Users</h3>
			</div>
			<br>
			<br>
			<hr>
			<hr>
<div class="row">		
<a href="<%=request.getContextPath()%>/new" class="btn btn-success">Add
					New User</a></td><td>
					<br>
			<br>
			
					
	</div>			
	<div class="row">	
	</div>	
			<br>
			<table class="table table-bordered">
				<thead>
					<tr>
						<th>ID</th>
						<th>Name</th>
						<th>Email</th>
						  <th>Marks</th>
						   <th>Registration Date</th>
					     <th>DOB</th>
					     <th>Age</th>
					      <th>State</th>
					       <th>City</th>
					       
				
						<th>Actions</th>
					</tr>
				</thead>
				<tbody>
					
					<c:forEach var="user" items="${listUser}">

						<tr>
							<td>&nbsp;&nbsp;<c:out value="${user.id}" /></td>
							<td>&nbsp;&nbsp;<c:out value="${user.name}" /></td>
							<td>&nbsp;&nbsp;<c:out value="${user.email}" /></td>
						    <td>&nbsp;&nbsp;<c:out value="${user.marks}" /></td>
						    <td>&nbsp;&nbsp;<c:out value="${user.registrationdate}" /></td>
						    <td>&nbsp;&nbsp;<c:out value="${user.birthdate}" /></td>
						    <td>&nbsp;&nbsp;<c:out value="${user.age}" /></td>
						    <td>&nbsp;&nbsp;<c:out value="${user.state}" /></td>
						    <td>&nbsp;&nbsp;<c:out value="${user.city}" /></td>
							<td>&nbsp;&nbsp;<a href="edit?id=<c:out value='${user.id}' />">Edit</a>
								&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <a
								href="delete?id=<c:out value='${user.id}' />">Delete</a></td>
						</tr>
					</c:forEach>	
				</tbody>
			</table>
		</div>
	</div>
</body>
</html>
