<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Le JAVA</title>
    <link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="/css/main.css"> <!-- Change to match your file/naming structure -->
</head>
<body style="background-color: #f3e6f5;"> <!-- Set background color to a soothing pink -->

<div class="container  text-center mt-5">
    <h1 class="display-4">Welcome to Lookify!</h1>
    <p class="lead">Discover and enjoy your favorite music.</p>
    <a href="/dashboard" class="btn btn-primary btn-lg">Start Exploring</a>
</div>

<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
<script type="text/javascript" src="/js/app.js"></script> <!-- Change to match your file/naming structure -->
</body>
</html>