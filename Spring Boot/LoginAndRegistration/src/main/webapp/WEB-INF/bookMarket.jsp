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
    <title>Book Lender Dashboard</title>
    <link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="/css/main.css"> <!-- change to match your file/naming structure -->
    <script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
    <script type="text/javascript" src="/js/app.js"></script><!-- change to match your file/naming structure -->
</head>
<body>
	<div class="container-fluid">
		<div class="row d-flex justify-content-between">
			<div class="col">
				<h1>Hello, ${thisUser.userName}.Welcome to... </h1>
				<h1>The Book Broker </h1>
				<p>Available books to borrow</p>
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
      <th scope="col">Owner</th>
      <th scope="col">Actions</th>
    </tr>
  </thead>
  <tbody>
  <c:forEach items="${allbooks}" var="book">
    <tr>
      <th scope="row">${book.id}</th>
      <td><a href="/books/${book.id}">${book.title}</a></td>
      <td>${book.author}</td>
      <td>${book.owner.userName}</td>
      <c:if test="${book.owner.id == user_id}">
  		<td><a href="/edit/${book.id}">edit</a> <a href="/delete/${book.id}">delete</a></td>
	  </c:if>
      <c:if test="${book.owner.id != user_id}">
  		<td><a href="/borrow/${book.id}">borrow</a></td>
	  </c:if>
    </tr>
    </c:forEach>
    
  </tbody>
</table>
<table class="table">
  <thead>
    <tr>
      <th scope="col">ID</th>
      <th scope="col">Title</th>
      <th scope="col">Author Name</th>
      <th scope="col">Owner</th>
      <th scope="col">Actions</th>
    </tr>
  </thead>
  <tbody>
  <c:forEach items="${user1.borrowedBooks}" var="book">
    <tr>
      <th scope="row">${book.id}</th>
      <td><a href="/books/${book.id}">${book.title}</a></td>
      <td>${book.author}</td>
      <td>${book.owner.userName}</td>
	  <td><a href="/return/${book.id}">return</a></td>
    </tr>
    </c:forEach>
  </tbody>
</table>
	</div>
</body>
</html>











	