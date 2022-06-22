<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!-- c:out ; c:forEach etc. -->
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!-- for rendering errors on PUT routes -->
<%@ page isErrorPage="true"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>All Expenses: ${allDaExpenses }</h1>
	<h2>${deleteSuccess}</h2>

	<table>
		<thead>
			<tr>
				<td>Expenses</td>
				<td>Vendor</td>
				<td>Amount</td>
				<td>Actions</td>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${allDaExpenses }" var="b">

				<tr>
					<td><a href="/show/${b.getId() }"> ${b.getTitle() } </a></td>
					<td>${b.vendor }</td>
					<td>${b.price }</td>
					<td><a href="/edit/${b.getId() }"> edit </a> |
						<form action="/${b.id}" method="post">
							    <input type="hidden" name="_method" value="delete">
							    <input type="submit" value="Delete">
						</form></td>
				</tr>
			</c:forEach>

		</tbody>
	</table>
	<form:form action="/" method="post" modelAttribute="expense">
		<%-- <form:errors path="*"/> --%>
		<p>
			<form:label path="title">Title</form:label>
			<form:errors path="title" />
			<form:input path="title" />
		</p>
		<p>
			<form:label path="vendor">vendor</form:label>
			<form:errors path="vendor" />
			<form:textarea path="vendor" />
		</p>
		<p>
			<form:label path="price">price</form:label>
			<form:errors path="price" />
			<form:input type="number" path="price" />
		</p>
		<p>
			<form:label path="description">description</form:label>
			<form:errors path="description" />
			<form:input path="description" />
		</p>
		<input type="submit" value="Submit" />
	</form:form>
</body>
</html>