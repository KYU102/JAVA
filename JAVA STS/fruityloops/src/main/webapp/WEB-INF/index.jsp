<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Hello</h1>
	<hr />
	<p>
		<c:out value="${fruitList }" />
	</p>
	<table>
		<tr>
			<th>Item</th>
			<th>Price</th>
		</tr>
		<c:forEach items="${fruitList }" var="d">
			<tr>
				<td>${d.name }</td>
				<td>${d.price }</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>
