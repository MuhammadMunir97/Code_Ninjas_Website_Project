<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    <%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Ninja Report</title>
</head>
<body>
<a href="/ninjas">All Ninjas</a>
<table>
    <thead>
        <tr>
            <th><h3>First Name</h3></th>
            <th><h3>Last Name</h3></th>
            <th><h3>Time Spent Coding</h3></th>
            <th><h3>Stars Achieved</h3></th>
            <th><h3>Completed Games</h3></th>
            <th><h3>Sessions</h3></th>
            <th><h3>Action</h3></th>
        </tr>
    </thead>
    <tbody>
        <tr>
        	<td><a href="/ninja/${currentNinja.id}"><c:out value="${currentNinja.firstName}"/></a></td>
        	<td>${currentNinja.lastName}</td>
        	<td>${currentNinja.timeSpentCoding}</td>
        	<td>${currentNinja.starsAchieved}</td>
        	<td>${fn:length(currentNinja.completedGames)}</td>
        	<td>${fn:length(currentNinja.session)}</td>
            <td>
            <form action="/ninjas/${currentNinja.id}" method="post">
			    <input type="hidden" name="_method" value="delete">
			    <input type="submit" value="Delete">
			</form>
			</td>
        </tr>
    </tbody>
    </table>
    <h1>Completed Games</h1>
    <table>
	    <thead>
	        <tr>
	            <th><h3>Name</h3></th>
	            <th><h3>Stars Achieved</h3></th>
	            <th><h3>Time Spent Coding</h3></th>
	            <th><h3>Belt</h3></th>
	        </tr>
	    </thead>
	    <tbody>
	    	<c:forEach items="${completedGames}" var="completedGame">
		    	<tr>
		    		<td>${completedGame.game.name}</td>
		    		<td>${completedGame.starsAchieved}</td>
		    		<td>${completedGame.timeSpent}</td>
		    		<td>${completedGame.game.belt.name}</td>
		    	</tr>
	    	</c:forEach>
	    </tbody>
	</table>
  <form:form action="/ninjas/${currentNinja.id}" method="post" modelAttribute="completedGame">
    	<form:select  path="game">
			<c:forEach items="${games}" var="singleGame">
				 <form:option value="${singleGame}">
				 	${singleGame.name}
				 </form:option>
	    	</c:forEach>
		</form:select>
	<p>
        <form:label path="starsAchieved">Stars Achieved</form:label>
        <form:errors path="starsAchieved"/>
        <form:input path="starsAchieved"/>
    </p>
    <p>
        <form:label path="timeSpent">timeSpent</form:label>
        <form:errors path="timeSpent"/>
        <form:input path="timeSpent"/>
    </p>
	    <input type="submit" value="Submit"/>
	</form:form>
</body>
</html>