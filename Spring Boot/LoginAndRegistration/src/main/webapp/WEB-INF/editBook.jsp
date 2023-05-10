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
    <title>Book Share</title>
    <link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
    <script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</head>
<body>
	<div class="container-fluid">
		<div class="row d-flex justify-content-between">
			<div class="col">
				<h1>Change Your Entry </h1>
			</div>
			<div class="col">
				<p><a href="/books">back to the shelves</a></p>
			</div>
		</div>
		
		<form:form action="/handle/${book.id}" method="put" modelAttribute="book">
		        <div class="form-group">
		            <label>Title:</label>
		            <form:input path="title" class="form-control" />
		            <form:errors path="title" class="text-danger" />
		        </div>
		        <div class="form-group">
		            <label>Author:</label>
		            <form:input path="author" class="form-control" />
		            <form:errors path="author" class="text-danger" />
		        </div>
		        <div class="form-group">
		            <label>My Thoughts:</label>
		            <form:textarea path="myThoughts" rows="4" cols="50" class="form-control" />
		            <form:errors path="myThoughts" class="text-danger" />
		        </div>
		        <div class="form-group">
		            <form:input type="hidden" path="owner"  value="${user_id}"  class="form-control" />
		            <form:input type="hidden" path="borrower"  value="${thisBook.borrower.id }"  class="form-control" />
		        </div>
		        <input type="submit" value="Submit" class="btn btn-success"/>
		    </form:form>
	</div>
</body>
</html>

