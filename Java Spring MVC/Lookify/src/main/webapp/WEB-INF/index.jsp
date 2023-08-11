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
	<div class="container text-center mt-5 d-flex justify-content-between bg-danger p-1 shadow-lg p-3  rounded" style="width=100vh ">
		<div class="d-flex">
			<h1 class="display-5">
			<span class="emoji">🆕🎵</span>	<a href="/songs/new"> Add New   </a>
			</h1>
			<h1 class="display-5">
				<span class="emoji">🔝🎵</span> <a href="/songs/top-ten"> Top Songs   </a> 
			</h1>
		</div>
		
		<form action="/process" method="post" class=" d-flex justify-content-between align-items-sm-center">
			<div class="form-group d-flex d-flex justify-content-between">
				<label >Expenses Name</label>
				<input class="form-control" name="artist" />
			</div>
			<button type="submit" class="btn btn-primary ">Submit</button>
		</form>
	</div>
	
	<div class="container mt-5">
		<table class="table table-dark">
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
						<th scope="row"><a href="/songs/${one.id}">${one.title}</a></th>
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
	</div>
</body>
</html>
