<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Styled Form</title>
    <!-- Include Bootstrap CSS link -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
</head>
<body>

    <div class="container mt-5">
        <h1>Here's your Omikuji!</h1>
        <p style="background-color: blue; color: white;">
            In <span><c:out value="${userDataList[0]}"/></span>years, <br>
            you will live in <span><c:out value="${userDataList[1]}"/></span> <br>
            with <span><c:out value="${userDataList[2]}"/></span> <br>
            as your roommate, <span><c:out value="${userDataList[3]}"/></span><br>
            for a living. The next time you see a <span><c:out value="${userDataList[4]}"/></span> <br>
            you will have good luck. Also, <span><c:out value="${userDataList[5]}"/></span><br>
        </p>
        <a href="/" style="font-size: 25px"> go back </a>
    </div>
    
    <!-- Include Bootstrap JS scripts (optional) -->
    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.1/dist/umd/popper.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>
