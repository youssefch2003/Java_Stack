<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!-- c:out ; c:forEach etc. -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!-- Formatting (dates) -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!-- form:form -->
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!-- for rendering errors on PUT routes -->
<%@ page isErrorPage="true"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Le JAVA</title>
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
<link rel="stylesheet" href="/css/main.css">
<!-- change to match your file/naming structure -->
<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
<script type="text/javascript" src="/js/app.js"></script>
<!-- change to match your file/naming structure -->
</head>
<body>

	<div>
		<h1>New ninjas</h1>
	</div>
	<%-- Form Display --%>
	<form:form action="/process/ninja" method="post" modelAttribute="ninja"
		class="mt-4">
		<%-- Error Display --%>
		<form:errors path="*" class="text-danger" />
		<%--End Error Display --%>
		<div class="form-group">
			<form:label path="first_name">first Name</form:label>
			<form:input path="first_name" class="form-control" />

		</div>
		<div class="form-group">
			<form:label path="last_name">last_name </form:label>
			<form:input path="last_name" class="form-control" />

		</div>
		<div class="form-group">
			<form:label path="age">age age</form:label>
			<form:input path="age" class="form-control" />

		</div>
		<div class="mb-3">
			<form:label path="dojo" class="form-label">Dojo:</form:label>
			<form:select path="dojo" class="form-select">
				<c:forEach var="eachDojo" items="${dojos }">
					<form:option value="${eachDojo.id}">
						<c:out value="${eachDojo.name}" />
					</form:option>
				</c:forEach>
			</form:select>
			<p class="form-text text-danger">
				<form:errors path="dojo" />
			</p>
		</div>

		<button type="submit" class="btn btn-primary">create</button>
	</form:form>
	<%-- End Form Display --%>

</body>
</html>