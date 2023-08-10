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
<title>🧳💰</title>
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
<link rel="stylesheet" href="/css/main.css">
<!-- change to match your file/naming structure -->
<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
<script type="text/javascript" src="/js/app.js"></script>
<!-- change to match your file/naming structure -->
</head>
<body>
	<div class="container text-center mt-5">
		<h1 class="display-2">
			Save Travels <span class="emoji">🧳💰</span>
		</h1>
	</div>
	<div class="container mt-5">
		<table class="table">
			<thead>
				<tr>
					<th scope="col">Expenses </th>
					<th scope="col">Vendor </th>
					<th scope="col">Amount</th>
					<th scope="col">notes</th>
					   <th>Actions</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${Expenses}" var="one">
					<tr>
						<th scope="row"><a href="expenses/${one.id}"> ${one.name}</a> </th>
						<td>${one.vendor}</td>
						<td>${one.amount} $</td>
						<td>${one.description}</td>
						   <td class="d-flex"><a class="btn btn-secondary" href="expenses/edit/${one.id }">Edit</a> 
							<form action="/destroy/${one.id}" method="post">
								<input type="hidden" name="_method" value="delete"> <input
									type="submit" value="Delete" class="btn btn-danger">
							</form></td>
					</tr>
					
			</tbody>
			</c:forEach>

		</table>
	</div>
	<hr>
	<hr>
	<div class="container mt-5">
		<div class="row justify-content-center">
			<h2 class="display-5">Add an Expense 💰</h2>
			
			<%-- Form Display --%>
			<form:form action="/process" method="post" modelAttribute="Expense"
					class="mt-4">
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
	</div>

</body>
</html>