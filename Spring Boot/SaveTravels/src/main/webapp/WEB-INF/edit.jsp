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
<title>Edit Expense</title>
</head>
<body>
	

<a href="/">Go Back</a>
<h1>Edit Expense:</h1>
<form:form action="/handle" method="post" modelAttribute="expense">
 <input type="hidden" name="_method" value="put">
    <p>
        <form:label path="expenseName">Expense Name </form:label>
        <form:input path="expenseName" value="${expense.expenseName}"/>
        <form:errors path="expenseName"/>
    </p>
    <p>
        <form:label path="vendor">Vendor</form:label>
        <form:input  path="vendor" value="${expense.vendor}"/>
        <form:errors path="vendor"/>
    </p>
    <p>
        <form:label path="amount">Amount</form:label>
        <form:input type="number" path="amount" value="${expense.amount}"/>
        <form:errors path="amount"/>
    </p>
    <p>
        <form:label path="description">Description</form:label>     
        <form:textarea path="description" value="${expense.description}"/>
        <form:errors path="description"/>
    </p>    
    <input type="submit" value="Submit"/>
</form:form>
</body>
</html>