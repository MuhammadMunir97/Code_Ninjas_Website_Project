<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    <%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>All Belts</title>
</head>
<body>
<h1>Belts Dashboard</h1> <br>
<a href="/belts/new">New Belts</a>
<table>
    <thead>
        <tr>
            <th><h3>Name</h3></th>
            <th><h3>Description</h3></th>
            <th><h3>Students</h3></th>
            <th><h3>Games</h3></th>
            <th><h3>Action</h3></th>
        </tr>
    </thead>
    <tbody>
        <c:forEach items="${belts}" var="belt">
        <tr>
        	<td><a href="/belts/${belt.id}/games"><c:out value="${belt.name}"/></a></td>
        	<td>${belt.description}</td>
        	<td>${fn:length(belt.ninjas)}</td>
        	<td>${fn:length(belt.games)}</td>
        	<td>
            <form action="/belts/${belt.id}" method="post">
			    <input type="hidden" name="_method" value="delete">
			    <input type="submit" value="Delete">
			</form>
			</td>
        </tr>
        </c:forEach>
    </tbody>
</table>
</body>
</html>