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
    <title>Read Share</title>
    <link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="/css/main.css"> <!-- change to match your file/naming structure -->
    <script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
    <script type="text/javascript" src="/js/app.js"></script><!-- change to match your file/naming structure -->
</head>
<body>
	<div class="container-fluid">
		<div class="row d-flex justify-content-between">
			<div class="col">
				<h1>Welcome ${thisUser.userName} </h1>
				<p>Books from everyone's shelves</p>
			</div>
			<div class="col">
				<p><a href="/logout">Logout</a></p>
				<p><a href="/books/new">Add a book to my shelf!</a></p>
			</div>
		</div>
		<table class="table">
  <thead>
    <tr>
      <th scope="col">ID</th>
      <th scope="col">Title</th>
      <th scope="col">Author Name</th>
      <th scope="col">Posted By</th>
    </tr>
  </thead>
  <tbody>
  <c:forEach items="${allbooks}" var="book">
    <tr>
      <th scope="row">${book.id}</th>
      <td><a href="/books/${book.id}">${book.title}</a></td>
      <td>${book.author}</td>
      <td>${book.user.userName}</td>
    </tr>
    </c:forEach>
    
  </tbody>
</table>
	</div>
</body>
</html>











	