<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<p> You have visited <a href="/yourserver">http://your_server</a> <c:out value="${counter}"/> times</p>	 
 <a href="/yourserver">test another visit?</a>
</body>
</html>