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
<title>Dojo Page</title>
</head>
<body>
	<h1>${dojo.name} Location Ninjas</h1>
	<table>
    <thead>
        <tr>
            <th>First Name</th>
            <th>Last Name</th>
            <th>Age</th>
        </tr>
    </thead>
    <tbody>
		<!-- Iterate over the list and display each element as a separate paragraph -->
		<c:forEach items="${dojo.ninjas}" var="ninja">
    <tr>
      <td>${ninja.firstName}</td>
      <td>${ninja.lastName}</td>
      <td>${ninja.age}</td>
    </tr>
  </c:forEach>
    </tbody>
</table>



</body>
</html>