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
<h1>Welcome , ${loggedUser.userName }</h1>
<a href="/logout" class=" btn btn-danger">LOG OUT</a>
</div>
<div class="container">
<div class="d-flex justify-content-between">
<h2>All projects</h2>
<a class="btn btn-secondary" href="/project/new"> + new project </a>

</div>
 <table class="table">
  <thead class="thead-dark">
    <tr>
      <th scope="col">Project</th>
      <th scope="col">Team lead</th>
      <th scope="col">Due Date</th>
      <th scope="col">Actions</th>
    </tr>
  </thead>
  <tbody>
    <c:forEach items="${AllProjects}" var="one" >
          <c:if test="${!one.users.contains(loggedUser) && loggedUser.id != one.teamlead.id}">
        <tr>
      <td> <a href="/show/project/${one.id }">${one.title }  </a>  </td>
      <td>${one.teamlead.userName }</td>
      <td> ${one.duedate }</td>
      <td>
      <a href="/join/${one.id }">Join Team</a>
      </td>
    </tr>
      </c:if>
    </c:forEach>
 </tbody>
</table>
<hr>
<h2>Your projects</h2>
<table class="table">
  <thead class="thead-dark">
    <tr>
      <th scope="col">Project</th>
      <th scope="col">Team lead</th>
      <th scope="col">Due Date</th>
      <th scope="col">Actions</th>
    </tr>
  </thead>
  <tbody>
    <c:forEach items="${AllProjects}" var="one" >
         	 <c:if test="${one.users.contains(loggedUser) || loggedUser.id == one.teamlead.id}">
        <tr>
      <td> <a href="/show/project/${one.id }">${one.title }  </a>  </td>
      <td>${one.teamlead.userName }</td>
      <td> ${one.duedate }</td>
      <c:if test = "${one.teamlead.id == loggedUser.id}">
		       <td><a href="/edit/${one.id }">Edit Project</a></td>
		    </c:if>
	  <c:if test = "${one.teamlead.id != loggedUser.id}">
		       <td>
		       <a href="/remove/${one.id}">Leave Team</a>
		       </td>
		    </c:if>
    </tr>
     </c:if>
    
    </c:forEach>
 </tbody>
</table>


</div>

</body>
</html>