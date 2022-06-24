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
   	<h1>Welcome user: ${user_id} - ${thisUser.userName }</h1>
   	<a href="/logout">logout</a>
   	<a href="/books/new">new book</a>
	<table>
		<thead>
			<tr>
				<td>ID</td>
				<td>Title</td>
				<td>Author Name</td>
				<td>Posted By</td>
				<td>action</td>

			</tr>
		</thead>
		<tbody>
			<c:forEach items="${allDaBooks }" var="b">

					<tr>

						<td>${b.id }</td>
						<td><a href="/show/${b.getId() }"> ${b.getTitle() } </a></td>
						<td>${b.author }</td>
						<td>${b.user.userName }</td>
						<td>
							<c:if test="${b.user.id eq user_id }">
							
							<a href="/edit/${thisBook.getId() }"> Edit </a>
		<form action="/delete/${thisBook.id}" method="post">
			    <input type="hidden" name="_method" value="delete"> <input
				type="submit" value="Delete">
		</form>
							
							
							</c:if>
						</td>
					</tr>


			</c:forEach>

		</tbody>
	</table>
</body>
</html>