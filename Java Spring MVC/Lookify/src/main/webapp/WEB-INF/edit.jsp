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
    <title>🐱‍👤🐱‍👤</title>
    <link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="/css/main.css"> <!-- change to match your file/naming structure -->
    <script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
    <script type="text/javascript" src="/js/app.js"></script><!-- change to match your file/naming structure -->
</head>
<body>
<div class="container text-center mt-5">
		<h1 class="display-2">
			Edit Expences   🛠🛠 
		</h1>
	</div>
   <hr />
   
  <div class="container mt-5">
		<div class="row justify-content-center">
			<h2 class="display-5">Edit an Expense 💰</h2>
			
			<%-- Form Display --%>
			<form:form action="/expenses/edit/${Expense.id}" method="post" modelAttribute="Expense"
					class="mt-4">
					   <input type="hidden" name="_method" value="put">
				<%-- Error Display --%>
				<form:errors path="*" class="text-danger" />
				<%--End Error Display --%>
				<div class="form-group">
						<form:label path="name">Expenses Name</form:label>
						<form:input path="name" class="form-control" />

					</div>
					<div class="form-group">
						<form:label path="vendor">vendor </form:label>
						<form:textarea path="vendor" class="form-control"></form:textarea>

					</div>
					<div class="form-group">
						<form:label path="amount">amount</form:label>
						<form:input path="amount" type="number" class="form-control" />

					</div>
					<div class="form-group">
						<form:label path="description">description</form:label>
						<form:textarea path="description" type="text" class="form-control" />

					</div>
					<button type="submit" class="btn btn-primary">Submit</button>
				</form:form>
				<%-- End Form Display --%>
			</div>
		</div>
</body>
</html>