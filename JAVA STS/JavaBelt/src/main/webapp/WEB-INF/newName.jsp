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
<title>Cool JAVA APP</title>
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
<link rel="stylesheet" href="/css/main.css">
<!-- change to match your file/naming structure -->
<script src="/webjars/jquery/jquery.min.js"></script>
<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</head>
<body>
	<div class="container">
		<h1>New Name</h1>

		<hr />
		<a href="/home">/home</a>
		<p></p>

		<form:form action="/books/new" method="post" modelAttribute="name1">
			<form:errors path="*" />


			<form:input type="hidden" path="user" value="${user_id }" />
			<p>
				<form:label path="babyName">name</form:label>
				<form:errors path="babyName" />
				<form:input path="babyName" placeholder="give book title" />
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
		<hr />


	</div>
	<a href="/home">cancel</a>
</body>
</html>