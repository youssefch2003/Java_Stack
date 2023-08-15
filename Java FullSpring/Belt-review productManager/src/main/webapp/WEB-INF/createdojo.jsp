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

<div>
<h1>
New Dojos
</h1>
</div>
			<%-- Form Display --%>
			<form:form action="/process/project" method="post" modelAttribute="project"
					class="mt-4">
				<%-- Error Display --%>
				<form:errors path="*" class="text-danger" />
				<%--End Error Display --%>
	

    <div class="form-group">
        <form:label path="title">Title</form:label>
        <form:input path="title" class="form-control" />
    </div>

    <div class="form-group">
        <form:label path="description">Description</form:label>
        <form:textarea path="description" class="form-control" rows="5" />
    </div>
    
    			 <div class="form-group">
        <form:label path="duedate">Date</form:label>
        <form:input path="duedate" type="date" class="form-control" />
    </div>
				
				
			
					<button type="submit" class="btn btn-primary">create</button>
					<a href="/dashboard" class="btn btn-secondary">cancel</a>
				</form:form>
				<%-- End Form Display --%>

</body>
</html>