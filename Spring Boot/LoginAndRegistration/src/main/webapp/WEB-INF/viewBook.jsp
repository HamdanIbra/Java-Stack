<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!-- c:out ; c:forEach etc. --> 
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!-- Formatting (dates) --> 
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"  %>
<!-- form:form -->
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!-- for rendering errors on PUT routes -->
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Book Read</title>
    <link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="/css/main.css"> <!-- change to match your file/naming structure -->
    <script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
    <script type="text/javascript" src="/js/app.js"></script><!-- change to match your file/naming structure -->
</head>
<body>
	<div class="container-fluid">
		<div class="row d-flex justify-content-between">
			<div class="col">
				<h1>${book1.title} </h1>
			</div>
			<div class="col">
				<p><a href="/books">back to the shelves</a></p>
			</div>
		</div>
		<h2>${book1.owner.userName} read ${book1.title} by ${book1.author}</h2>
		<h3>Here are ${book1.owner.userName}'s thoughts:</h3>
		<p>${book1.myThoughts}  ${thisUser.userName}</p>
	</div>
	${thisUser.userName}
</body>
</html>

