<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Game Concepts</title>
</head>
<body>
${theGame.name}
<table class="table table-hover table-dark">
    <thead>
        <tr>
            <th><h3>Description</h3></th>
            <th><h3>Action</h3></th>
        </tr>
    </thead>
    <tbody>
        <c:forEach items="${theGame.gameConcepts}" var="singleGameConcept">
        <tr>
        	<td><a href="/games/${theGame.id}/gameConcept"><c:out value="${singleGameConcept.description}"/></a></td>
        	<td>
            <form action="/games/${theGame.id}/${singleGameConcept.id}" method="post">
			    <input type="hidden" name="_method" value="delete">
			    <input type="submit" value="Delete">
			</form>
			</td>
        </tr>
        </c:forEach>
    </tbody>
</table>
<form:form action="/games/${theGame.id}/" method="POST" modelAttribute="gameConcept">
    <p>
        <form:label path="description">Description</form:label>
        <form:errors path="description"/>
        <form:input path="description"/>
    </p>
    <input type="submit" value="Submit"/>
 </form:form>
</body>
</html>