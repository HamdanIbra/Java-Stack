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
<meta charset="windows-1256">
<title>Insert title here</title>
</head>
<body>
	<h1>Burger Tracker</h1>
	<table>
    <thead>
        <tr>
            <th>Burger Name</th>
            <th>Restaurant Name</th>
            <th>Rating(out of 5)</th>
            <th>Action</th>
        </tr>
    </thead>
    <tbody>
		<!-- Iterate over the list and display each element as a separate paragraph -->
		<c:forEach items="${allburgers}" var="burger">
    <tr>
      <td>${burger.burgerName}</td>
      <td>${burger.restaurantName}</td>
      <td>${burger.rating}</td>
      <td><a href="/edit/${burger.id}">edit<a/></td>
    </tr>
  </c:forEach>
    </tbody>
</table>


<h1>Add a Burger:</h1>
<form:form action="/new" method="post" modelAttribute="burger">
    <p>
        <form:label path="burgerName">Burger Name </form:label>
        <form:input path="burgerName"/>
        <form:errors path="burgerName"/>
    </p>
    <p>
        <form:label path="restaurantName">Restaurant Name</form:label>
        <form:input  path="restaurantName"/>
        <form:errors path="restaurantName"/>
    </p>
    <p>
        <form:label path="rating">Rating</form:label>
        <form:input type="number" path="rating"/>
        <form:errors path="rating"/>
    </p>
    <p>
        <form:label path="notes">Notes</form:label>     
        <form:textarea path="notes"/>
        <form:errors path="notes"/>
    </p>    
    <input type="submit" value="Submit"/>
</form:form> 
</body>
</html>