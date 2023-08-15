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
    <meta charset="UTF-8">
    <title>Le JAVA</title>
    <link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="/css/main.css"> <!-- change to match your file/naming structure -->
    <script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
    <script type="text/javascript" src="/js/app.js"></script><!-- change to match your file/naming structure -->
</head>
<body>
<div class="d-flex justify-content-between">
<h1>Project Details</h1>
<a href="/dashboard" class=" btn btn-secondary">back to dashboard</a>
</div>
<div class="container mt-3">
<div class="d-flex">
<p class="text-uppercase">Project:</p>
<p>${project.title }</p>
</div>
<div class="d-flex">
<p class="text-uppercase ">Description:</p>
<p>${project.description} </p>
</div>
<div class="d-flex">
<p class="text-uppercase">Due Date:</p>
<p>${project.duedate} </p>
</div>
</div>
<c:if test="${LoggedUserId == project.teamlead.id }">
<form action="/destroy/${project.id}" method="post">
<input type="hidden" name="_method" value="delete">
<input type="submit" value="Delete Project" class="btn btn-danger">
</form>
</c:if>

<a href="/projects/${project.id }/tasks">See Tasks</a>
</body>
</html>