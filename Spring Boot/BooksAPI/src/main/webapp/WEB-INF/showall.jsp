<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!-- c:out ; c:forEach etc. --> 
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

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
<title>Books</title>
</head>
<body>   
<h1>All Books</h1>
<table>
    <thead>
        <tr>
            <th>ID</th>
            <th>Title</th>
            <th>Language</th>
            <th>Number of Pages</th>
        </tr>
    </thead>
    <tbody>
		<!-- Iterate over the list and display each element as a separate paragraph -->
		<c:forEach items="${allbooks}" var="book">
    <tr>
      <td>${book.id}</td>
      <td>${book.title}</td>
      <td>${book.language}</td>
      <td>${book.numberOfPages}</td>
    </tr>
  </c:forEach>
    </tbody>
</table>
	
</body>
</html>