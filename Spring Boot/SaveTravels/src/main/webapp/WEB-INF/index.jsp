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
<title>Save Travels</title>
</head>
<body>
	<h1>Save Travels</h1>
	<table>
    <thead>
        <tr>
            <th>Expense</th>
            <th>Vendor</th>
            <th>Amount</th>
            <th>Actions</th>
        </tr>
    </thead>
    <tbody>
		<!-- Iterate over the list and display each element as a separate paragraph -->
		<c:forEach items="${allexpenses}" var="expense">
    <tr>
      <td><a href="/expenses/${expense.id}">${expense.expenseName}</a></td>
      <td>${expense.vendor}</td>
      <td>${expense.amount}</td>
      <td><a href="/edit/${expense.id}">edit<a/></td>
      <td><form action="/delete/${expense.id}" method="post">
    		<input type="hidden" name="_method" value="delete">
    		<input type="submit" value="Delete">
		</form></td>
      

    </tr>
  </c:forEach>
    </tbody>
</table>


<h1>Add an Expense:</h1>
<form:form action="/new" method="post" modelAttribute="expense">
    <p>
        <form:label path="expenseName">Expense Name </form:label>
        <form:input path="expenseName"/>
        <form:errors path="expenseName"/>
    </p>
    <p>
        <form:label path="vendor">Vendor</form:label>
        <form:input  path="vendor"/>
        <form:errors path="vendor"/>
    </p>
    <p>
        <form:label path="amount">Amount</form:label>
        <form:input type="number" path="amount"/>
        <form:errors path="amount"/>
    </p>
    <p>
        <form:label path="description">Description</form:label>     
        <form:textarea path="description"/>
        <form:errors path="description"/>
    </p>    
    <input type="submit" value="Submit"/>
</form:form> 
</body>
</html>