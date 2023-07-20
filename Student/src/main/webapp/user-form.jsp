<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<title>Student Data</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
</head>
<script src="js/user.js" text="text/JavaScript"></script>
<body>

	<header>
		<nav class="navbar navbar-expand-md navbar-dark"
			style="background-color: blue">
			<div>
				<a href="list" class="navbar-brand"> back </a>
			</div>
		</nav>
	</header>
	<br>
	<div class="container col-md-5">
		<div class="card">
			<div class="card-body">
				<c:if test="${user != null}">
					<form action="update" method="post" name="myForm" onsubmit="return validateUserDetails()">
				</c:if>
				<c:if test="${user == null}">
					<form action="insert" method="post" name="myForm"  onsubmit="return validateUserDetails()">
				</c:if>
				<caption>
					<h2>
						<c:if test="${user != null}">
            			Edit User
            		</c:if>
						<c:if test="${user == null}">
            			Add New User
            		</c:if>
					</h2>
				</caption>

				<c:if test="${user != null}">
					<input type="hidden" name="id" value="<c:out value='${user.id}' />" />
				</c:if>

				<fieldset class="form-group">
					<label>User Name</label> <input type="text"
						value="<c:out value='${user.name}' />" class="form-control"
						name="name">
				</fieldset>

				<fieldset class="form-group">
					<label>User Email</label> <input type="email"
						value="<c:out value='${user.email}' />" class="form-control"
						name="email" >
				</fieldset>
				<fieldset class="form-group">
					<label>User Marks</label> <input type="number"
						value="<c:out value='${user.marks}' />" class="form-control"
						name="marks">
						</fieldset>
						<fieldset class="form-group">
					<label>User BirthDate</label> <input type="date"
						value="<c:out value='${user.birthdate}' />" class="form-control"
						name="birthdate">
						</fieldset>
						
			   <fieldset class="form-group">
					<label>State</label> <select name="state">
					<option value="0" selected>Select State</option>
					<c:forEach var="st" items="${stateList}">
					<c:choose>
					<c:when test="${user.stateid eq st.state_id}">
					<option value="${st.state_id}" selected >${st.state}</option>
					</c:when>
					<c:otherwise>
					<option value="${st.state_id}">${st.state}</c:otherwise>
					</c:choose>
					</c:forEach>
					</select>
					</fieldset>
					
				
				<fieldset class="form-group">
					<label>City</label> <select name="city">
						<option value="0" selected>Select City</option>
					<c:forEach var="ct" items="${cityList}">
					<c:choose>
					<c:when test="${user.cityid eq ct.city_id}">
					<option value="${ct.city_id}" selected >${ct.city}</option>
					</c:when>
					<c:otherwise>
					<option value="${ct.city_id }">${ct.city}</c:otherwise>
					</c:choose>
					</c:forEach>
					</select>
					</fieldset>
				<button type="submit" class="btn btn-success">Save</button>
				</form>
			</div>
		</div>
	</div>
	
</body>
</html>
