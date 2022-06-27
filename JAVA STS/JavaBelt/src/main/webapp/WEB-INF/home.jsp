<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!-- c:out ; c:forEach etc. --> 
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!-- Formatting (dates) --> 
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!-- form:form -->
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!-- for rendering errors on PUT routes -->
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Tacos</title>
    <link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="/css/main.css"> <!-- change to match your file/naming structure -->
    <script src="/webjars/jquery/jquery.min.js"></script>
    <script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</head>
<body>
   	<h1>Hello, ${thisUser.userName }. Here are some name suggestions </h1>
   	<a href="/logout"> Log Out </a>
   	<h2>Baby Names</h2>

   	<a href="/books/new">new name</a>
	<table>
		<thead>
			<tr>
				<td>Name</td>
				<td>Gender</td>
				<td>origin</td>
				<td>actions</td>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${allDaNames }" var="b">

					<tr>

						<%-- <td>${b.babyName }</td> --%>
						<td><a href="/show/${b.getId() }"> ${b.babyName } </a></td>
						<td>${b.gender }</td>
						<td> Origin: ${b.origin }</td>
							<c:if test="${user_id eq b.user.id}">
						<td><a href="/edit/${b.getId() }"> Edit </a></td>
							</c:if>
							
						
					

						
						
						
					<%-- 		<c:if test="${b.user.id eq user_id }">
							
							<a href="/edit/${thisBook.getId() }"> Edit </a>
		<form action="/delete/${thisBook.id}" method="post">
			    <input type="hidden" name="_method" value="delete"> <input
				type="submit" value="Delete">
		</form>
							
							
							</c:if> --%>
						</td>
					</tr>


			</c:forEach>

		</tbody>
	</table>
	
</body>
</html>