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
	<form:form action="/edit/${thisName.id}" method="post"
		modelAttribute="thisName">
		<%-- <form:errors path="*"/> --%>
		<input type="hidden" name="_method" value="put" />
		<form:hidden path="user" value="${thisName.user.getId()}" />
		<p>
			<form:label path="babyName">babyName</form:label>
			<form:errors path="babyName" />
			<form:input path="babyName" />
		</p>
		Gender
 <select name="gender">
    <option value="neutral">neutral</option>
    <option value="male">male</option>
    <option value="female">female</option>
  </select>
		<p>
			<form:label path="origin">origin</form:label>
			<form:errors path="origin" />
			<form:input path="origin" />
		</p>
				<p>
			<form:label path="meaning">meaning</form:label>
			<form:errors path="meaning" />
			<form:input path="meaning" />
		</p>

		<input type="submit" value="Submit" />
	</form:form>
	
	<form action="/delete/${thisName.id}" method="post">
			    <input type="hidden" name="_method" value="delete"> <input
				type="submit" value="Delete">
		</form>
<a href="/home">cancel</a>
</body>
</html>