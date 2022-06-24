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
	<a href="/home"> Home </a>
	<form:form action="/edit/${thisBook.id}" method="post"
		modelAttribute="thisBook">
		<%-- <form:errors path="*"/> --%>
		<input type="hidden" name="_method" value="put" />
		<form:hidden path="user" value="${thisBook.user.getId()}" />
		<p>
			<form:label path="title">Title</form:label>
			<form:errors path="title" />
			<form:input path="title" />
		</p>
		<p>
			<form:label path="author">vendor</form:label>
			<form:errors path="author" />
			<form:textarea path="author" />
		</p>
		<p>
			<form:label path="thoughts">price</form:label>
			<form:errors path="thoughts" />
			<form:input path="thoughts" />
		</p>

		<input type="submit" value="Submit" />
	</form:form>

</body>
</html>