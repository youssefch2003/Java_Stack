<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
  <!-- Include Bootstrap CSS link -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
</head>
<body> 
<h1>Your Gold: ${gold}</h1>
<div class="d-flex justify-content-between">

    <form class="border border-primary" action="/process" method="post">
         <h2>Farm</h2>
        <input type="hidden" name="action" value="farm">
        <p>(earns 10-20 gold)</p>
        <button type="submit">Find Gold</button>
    </form>
      <form class="border border-primary" action="/process" method="post">
         <h2>Cave</h2>
        <input type="hidden" name="action" value="cave">
        <p>(earns 5-10 gold)</p>
        <button type="submit">Find Gold</button>
    </form>
      <form  class="border border-primary" action="/process" method="post">
         <h2>House</h2>
        <input type="hidden" name="action" value="house">
        <p>(earns 2-5 gold)</p>
        <button type="submit">Find Gold</button>
    </form>
      <form class="border border-primary" action="/process" method="post">
         <h2>Quest</h2>
        <input type="hidden" name="action" value="quest">
        <p>(earns/takes 0-50 gold)</p>
        <button type="submit">Find Gold</button>
    </form>
    </div>
    
    <h2>Activities</h2>
    <div class="border border-danger  text-center overflow-auto m-3" style="max-height: 200px;">
            <c:forEach var="one" items="${activities}">
        <c:set var="activityLower" value="${one.toLowerCase()}" />
        <c:set var="isLost" value="${activityLower.indexOf('lost') != -1}" />
        
        <p class="${isLost ? 'text-danger' : 'text-success'}">${one }</p> 
       </c:forEach>
    </div>
</body>
</html>