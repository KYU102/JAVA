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
	<h1>Send an Omikuji</h1>
	<form action="/create" method="post">
	<p>
		Pick any number from 5 through 25: 
		<input type="number" name="number"
			min="5" max="25">
	</p>
	<p>
		Enter the name of any city 
		<input type="text" name="city">
	</p>
		<p>
		Enter the name of any real person 
		<input type="text" name="person">
	</p>
		<p>
		Enter professional endeavor or hobby
		<input type="text" name="hobby">
	</p>
		<p>
		Enter any type of living thing
		<input type="text" name="livingThing">
	</p>
		<p>
		Say something nice to someone
		<input type="text" name="quote">
	</p>
	<button>Send</button>
	</form>
	<p>Send and show a friend</p>
</body>
</html>