<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!-- c:out ; c:forEach etc. -->
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!-- Formatting (dates) -->
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!-- form:form -->
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!-- for rendering errors on PUT routes -->
<%@ page isErrorPage="true"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Tacos</title>
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
<link rel="stylesheet" href="/css/main.css">
<!-- change to match your file/naming structure -->
<script src="/webjars/jquery/jquery.min.js"></script>
<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</head>
<body>
	<h1>Location data</h1>
	<h1>${thisDojo.getName()}Location Ninjas</h1>


	<table>
		<thead>
			<tr>
				<td>First Name</td>
				<td>Last Name</td>
				<td>Age</td>
				<td>ID</td>

			</tr>
		</thead>
		<tbody>
			<c:forEach items="${allDaNinjas }" var="n">
				<c:if test="${n.dojo.id == thisDojo.id}">
					<tr>

						<td>${n.firstName }</td>
						<td>${n.lastName }</td>
						<td>${n.age }</td>
						<td>${n.id }</td>
					</tr>
				</c:if>

			</c:forEach>

		</tbody>
	</table>
	

</body>
</html>