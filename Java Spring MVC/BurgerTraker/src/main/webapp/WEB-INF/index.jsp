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
<title>BURGER 🍔</title>
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
			Burger Tracker <span class="emoji">🍔🍔</span>
		</h1>
	</div>
	<div class="container mt-5">
		<table class="table">
			<thead>
				<tr>
					<th scope="col">Burger Name</th>
					<th scope="col">restaurant Name</th>
					<th scope="col">rating</th>
					<th scope="col">notes</th>
					   <th>Actions</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${Burgers}" var="oneBurger">
					<tr>
						<th scope="row">${oneBurger.name}</th>
						<td>${oneBurger.restaurantName}</td>
						<td>${oneBurger.rating}</td>
						<td>${oneBurger.notes}</td>
						   <td class="d-flex"><a class="btn btn-secondary" href="edit/${oneBurger.id }">Edit</a> 
							<form action="/destroy/${oneBurger.id}" method="post">
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
			<h2 class="display-5">Add a burger ➕➕➕➕</h2>
			
			<%-- Form Display --%>
			<form:form action="/process" method="post" modelAttribute="burger"
					class="mt-4">
				<%-- Error Display --%>
				<form:errors path="*" class="text-danger" />
				<%--End Error Display --%>
				<div class="form-group">
						<form:label path="name">Burger Name</form:label>
						<form:input path="name" class="form-control" />

					</div>
					<div class="form-group">
						<form:label path="restaurantName">Restaurant Name</form:label>
						<form:textarea path="restaurantName" class="form-control"></form:textarea>

					</div>
					<div class="form-group">
						<form:label path="rating">Rating</form:label>
						<form:input path="rating" type="number" class="form-control" />

					</div>
					<div class="form-group">
						<form:label path="notes">Notes</form:label>
						<form:input path="notes" type="text" class="form-control" />

					</div>
					<button type="submit" class="btn btn-primary">Submit</button>
				</form:form>
				<%-- End Form Display --%>
			</div>
		</div>
	</div>

</body>
</html>