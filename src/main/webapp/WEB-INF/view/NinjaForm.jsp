<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> 
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>New Ninja</title>
</head>
<body>
<form:form action="/ninjas" method="POST" modelAttribute="ninja">
	<p>
        <form:label path="firstName">First Name</form:label>
        <form:errors path="firstName"/>
        <form:input path="firstName"/>
    </p>
    <p>
        <form:label path="lastName">Last Name</form:label>
        <form:errors path="lastName"/>
        <form:input path="lastName"/>
    </p>
    <form:select  path="belt">
			<c:forEach items="${belts}" var="belt">
				 <form:option value="${belt}">
				 	${belt.name}
				 </form:option>
	    	</c:forEach>
	</form:select>
    <input type="submit" value="Submit"/>
 </form:form>
</body>
</html>