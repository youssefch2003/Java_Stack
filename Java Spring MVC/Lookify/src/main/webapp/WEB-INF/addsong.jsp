<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Le JAVA</title>
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
<script type="text/javascript" src="/js/app.js"></script>
</head>
<body class="bg-light d-flex align-items-center justify-content-center" style="min-height: 100vh; margin: 0;">

<div class="container">
    <div class="card p-4">
       
		<div class="text-center mt-3 d-flex align-items-center justify-content-between">
		 <h1 class=" display-5 text-center mb-4">
            Add Song<span class="emoji">➕➕</span>
        </h1>
            <a href="/dashboard" class="btn btn-secondary">Dashboard</a>
        </div>
        <form:form action="/process/create" method="post" modelAttribute="song" class="mt-4">

            <form:errors path="*" class="text-danger mb-3" />

            <div class="form-group">
                <form:label path="title">Title</form:label>
                <form:input path="title" class="form-control" />
            </div>

            <div class="form-group">
                <form:label path="artist">Artist Name</form:label>
                <form:input path="artist" class="form-control" />
            </div>

            <div class="form-group">
                <form:label path="rating">Rating</form:label>
                <form:input path="rating" type="number" class="form-control" />
            </div>

            <button type="submit" class="btn btn-primary btn-block">Submit</button>
        </form:form>
        
        
    </div>
</div>

</body>
</html>
