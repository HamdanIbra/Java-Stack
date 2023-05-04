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
<title>New Ninja</title>
</head>
<body>
	


<h1>New Ninja</h1>
<form:form action="/newninja" method="post" modelAttribute="ninja">
	<p>
        <form:label path="dojo">Dojo: </form:label>
        <form:select path="dojo">
            <c:forEach items="${alldojos}" var="dojo">
                <form:option value="${dojo.id}">${dojo.name}</form:option>
            </c:forEach>
        </form:select>
    </p>
    <p>
        <form:label path="firstName">First Name </form:label>
        <form:input path="firstName"/>
        <form:errors path="firstName"/>
    </p>
    <p>
        <form:label path="lastName">Last Name </form:label>
        <form:input path="lastName"/>
        <form:errors path="lastName"/>
    </p>
    <p>
        <form:label path="age">age </form:label>
        <form:input type="number" path="age"/>
        <form:errors path="age"/>
    </p>
    <input type="submit" value="Create"/>
</form:form> 
</body>
</html>