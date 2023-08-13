<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Success Page</title>
    <link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="/css/main.css"> <!-- adjust the path as needed -->
    <style>
        /* Additional styles specific to this page */
        body {
            background-color: #f7f7f7;
        }
        .success-container {
            text-align: center;
            margin-top: 100px;
        }
        .success-icon {
            font-size: 72px;
            color: #28a745;
        }
        .success-message {
            font-size: 24px;
            margin-top: 20px;
            color: #333;
        }
    </style>
    <script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
    <script type="text/javascript" src="/js/app.js"></script> <!-- adjust the path as needed -->
</head>
<body>
    <div class="container success-container">
        <div class="row">
            <div class="col-md-12">
                <div class="success-icon">
                    <i class="fas fa-check-circle"></i> <!-- You can use the appropriate icon class from Font Awesome or other libraries -->
                </div>
                <div class="success-message">
                    <p>Your request was successfully processed.</p>
                    <p>Thank you for using our service!</p>
                </div>
            </div>
        </div>
    </div>
</body>
</html>
