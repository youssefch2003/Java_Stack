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
<h1> Project: ${project.title }</h1>
<p> Project Lead : ${project.teamlead.userName }</p>
</div>
              <%-- Form Display --%>
			<form:form action="/process/task/${project.id }" method="post" modelAttribute="task" 
					class="mt-4 col-8">
				
				<%--End Error Display --%>
				<div class="form-group d-flex">
						<form:label path="thetask">task Name</form:label>
						<form:input path="thetask" class="form-control" />
						<%-- Error Display --%>
				        <form:errors path="thetask" class="text-danger" />
				</div>
<%-- 				<form:input path="user_id" type="hidden" /> --%>
<%-- 				<form:input path="project_id" type="hidden" /> --%>
				
					<button type="submit" class="btn btn-primary">Submit</button>
				</form:form>
				<%-- End Form Display --%>
<div>

	<c:forEach items = "${alltas }" var = "one">
		<p>Added by ${one.user.userName } at <fmt:formatDate pattern="h:mma MMM d" value="${one.createdAt}"/> </p>
		
		<p>❤❤❤❤❤❤❤❤❤❤</p>
		<p>${one.thetask }</p>
		<p>💚💚💚💚💚💚💚</p>
	
	
	</c:forEach>

</div>
</body>
</html>