<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!-- New line below to use the JSP Standard Tag Library -->
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="windows-1256">
<title>Insert title here</title>
</head>
<body>
	<h1>Your Gold: <input type="number" value="${total }"></h1>
	<div style="display: flex;">
		<div >
			<h3>Farm</h3>
			<p>(earns 10-20 gold)</p>
			<form action="/handle" method="post">
				<input type="hidden" name="location" value="farm">
				<input type="submit" value="Find Gold!">
			</form>
		</div>
		<div>
			<h3>Cave</h3>
			<p>(earns 5-10 gold)</p>
			<form action="/handle" method="post">
				<input type="hidden" name="location" value="cave">
				<input type="submit" value="Find Gold!">
			</form>
		</div>
		<div>
			<h3>House</h3>
			<p>(earns 2-5 gold)</p>
			<form action="/handle" method="post">
				<input type="hidden" name="location" value="house">
				<input type="submit" value="Find Gold!">
			</form>
		</div>
		<div>
			<h3>Quest</h3>
			<p>(earns/take 0-50 gold)</p>
			<form action="/handle" method="post">
				<input type="hidden" name="location" value="quest">
				<input type="submit" value="Find Gold!">
			</form>
		</div>
	</div>
	<h1>Activities:</h1>
	<div>
		<!-- Retrieve the list from the HttpSession -->
	



<c:set var="list" value="${sessionScope.list}" />
		
		<!-- Iterate over the list and display each element as a separate paragraph -->
		<c:forEach var="string" items="${list}">
		  <c:if test="${fn:contains(string, 'earned')}">
		    <p style="color: green;">${string}</p>
		  </c:if>
		  <c:if test="${not fn:contains(string, 'earned')}">
    		<p style="color: red;">${string}</p>
		</c:if>
		</c:forEach>






	</div>
</body>
</html>