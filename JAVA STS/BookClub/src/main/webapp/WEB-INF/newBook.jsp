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
		<h1>New Book</h1>

		<hr />
		<a href="/home">/home</a> <a href="/books">/books</a>
		<p></p>

		<form:form action="/books/new" method="post" modelAttribute="book">
			<form:errors path="*" />


			<form:input type="hidden" path="user" value="${user_id }" />
			<p>
				<form:label path="title">Title</form:label>
				<form:errors path="title" />
				<form:input path="title" placeholder="give book title" />
			</p>
			<p>
				<form:label path="author">author</form:label>
				<form:errors path="author" />
				<form:input path="author" />
			</p>
			<p>
				<form:label path="thoughts">thoughts</form:label>
				<form:errors path="thoughts" />
				<form:input path="thoughts" />
			</p>



			<input type="submit" value="Submit" />
		</form:form>
		<hr />


	</div>

</body>
</html>