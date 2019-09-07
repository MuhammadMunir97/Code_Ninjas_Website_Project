<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>All Ninjas</title>
</head>
<body>
<h1>Ninja Dashboard</h1> <br>
<a href="/ninjas/new">New Ninja</a>
<a href="/belts">Belts</a>
<table>
    <thead>
        <tr>
            <th><h3>First Name</h3></th>
            <th><h3>Last Name</h3></th>
            <th><h3>Time Spent Coding</h3></th>
            <th><h3>Stars Achieved</h3></th>
            <th><h3>Action</h3></th>
            <th><h3>Edit</h3></th>
        </tr>
    </thead>
    <tbody>
        <c:forEach items="${ninjas}" var="ninja">
        <tr>
        	<td><a href="/ninjas/${ninja.id}"><c:out value="${ninja.firstName}"/></a></td>
        	<td>${ninja.lastName}</td>
        	<td>${ninja.timeSpentCoding}</td>
        	<td>${ninja.starsAchieved}</td>
            <td>
            <form action="/ninjas/${ninja.id}" method="post">
			    <input type="hidden" name="_method" value="delete">
			    <input type="submit" value="Delete">
			</form>
			</td>
			<td><a href="/ninjas/edit/${ninja.id}">Edit Profile</a></td>
        </tr>
        </c:forEach>
    </tbody>
</table>
</body>
</html>