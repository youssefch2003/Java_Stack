<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"  %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Le JAVA</title>
    <link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="/css/main.css"> <!-- change to match your file/naming structure -->
    <style>
        /* Custom CSS for vertical table layout */
        body {
            background-color: #fd0d0dab; /* Dark background color */
            color: #fff; /* Light text color */
        }
        .vertical-table-container {
            display: flex;
            justify-content: space-between;
            align-items: flex-start;
        }
        .table-container {
            flex: 1;
            overflow-y: auto;
            max-height: 400px; /* Adjust the maximum height as needed */
            background-color: #343a40; /* Dark background color */
            border: 1px solid #17a2b8; /* Info color */
            padding: 10px;
        }
        .table-container table {
            background-color: #343a40; /* Dark background color */
            color: #fff; /* Light text color */
        }
        .table-container th, .table-container td {
            border: none;
            color: #fff; /* Light text color */
        }
    </style>
</head>
<body>
<div class="container mt-5">
   <div class="d-flex justify-content-between align-items-center mb-3 bg-primary  p-1 shadow-lg p-3  rounded">
    <h1 class="display-4">Expense Details <span class="emoji">💰🛑</span></h1>
    <a href="/" class="btn btn-secondary">Go Back</a>
</div>
    <div class="vertical-table-container col-6">
        <div class="table-container">
            <table class="table table-bordered ">
                <tbody>
                    <tr>
                        <td>Expense Name:</td>
                        <td>${Expense.name}</td>
                    </tr>
                    <tr>
                        <td>Description:</td>
                        <td>${Expense.description}</td>
                    </tr>
                    <tr>
                        <td>Vendor:</td>
                        <td>${Expense.vendor}</td>
                    </tr>
                    <tr>
                        <td>Amount Spent:</td>
                        <td>${Expense.amount}💲</td>
                    </tr>
                    <!-- Add more rows as needed -->
                </tbody>
            </table>
        </div>
      
    </div>
</div>

<script src="/webjars/jquery/jquery.min.js"></script>
<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
<script type="text/javascript" src="/js/app.js"></script><!-- change to match your file/naming structure -->
</body>
</html>
