<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>🧳💰</title>
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
<link rel="stylesheet" href="/css/main.css">
<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
<script type="text/javascript" src="/js/app.js"></script>
</head>
<body>
			<h1 class="display-5">
				Songs by : ${artist}<span class="emoji">🎵</span>
			</h1>
	
		
<div class="container mt-5">
		<table class="table ">
			<thead>
				<tr>
					<th scope="col">Name</th>
					<th scope="col">Rating</th>
					<th>Actions</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${Songs}" var="one">
					<tr>
						<th scope="row"><a href="expenses/${one.id}">${one.title}</a></th>
						<td scope="row">${one.rating}</td>
						<td scope="row">
							<form action="/destroy/${one.id}" method="post">
								<input type="hidden" name="_method" value="delete">
								<input type="submit" value="Delete" class="btn btn-danger">
							</form>
						</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		<a href="/dashboard" class="btn btn-secondary">Dashboard</a>
	</div>
</body>
</html>
