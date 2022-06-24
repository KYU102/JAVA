<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!-- c:out ; c:forEach etc. -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!-- Formatting (dates) -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
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
	<h1>This is one book</h1>

	<a href="/home"> Back to Shelves </a>
	<h1>${thisBook.getTitle() }</h1>

	<h2>${thisBook.getUser().userName }read ${thisBook.getTitle() } by
		${thisBook.getAuthor() }</h2>

	<h2>Thoughts: ${thisBook.getThoughts()}</h2>

	<c:if test=" ${user_id eq thisBook.user.id}">
		<a href="/edit/${thisBook.getId() }"> Edit </a>
		<form action="/delete/${thisBook.id}" method="post">
			    <input type="hidden" name="_method" value="delete"> <input
				type="submit" value="Delete">
		</form>
	</c:if>
	<hr />
	<c:if test="${2 == 3}">
	yes
	</c:if>
	
	${user_id} - ${thisBook.user.id} - ${thisBook.user}
	<hr />
	<c:if test=" ${user_id eq thisBook.user.id}">
	yes!!!
	</c:if>
	




</body>
</html>