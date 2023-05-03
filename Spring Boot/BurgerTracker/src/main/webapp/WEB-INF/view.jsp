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
<title>Show Expense</title>
</head>
<body>
	<a href="/">Go back</a>
	<h1>Expense Details</h1>
	<p>Expense Name : ${expense.expenseName}</p>
	<p>Expense Description :${expense.description}</p>
	<p>Vendor : ${expense.vendor}</p>
	<p>Amount spent: $ ${expense.amount}</p>


 
</body>
</html>