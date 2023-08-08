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
        <form action="/process" method="post">
            <div class="form-group">
                <label for="num">Pick any number from 5 to 25</label>
                <input type="number" class="form-control" min="5" max="25" id="num" name="num">
            </div>
            <div class="form-group">
                <label for="city">Enter the name of any city</label>
                <input type="text" class="form-control" id="city" name="city">
            </div>
            <div class="form-group">
                <label for="real">Enter the name of any real person</label>
                <input type="text" class="form-control" id="real" name="real">
            </div>
            <div class="form-group">
                <label for="hobby">Enter professional endeavor or hobby</label>
                <input type="text" class="form-control" id="hobby" name="hobby">
            </div>
            <div class="form-group">
                <label for="living">Enter any type of living thing</label>
                <input type="text" class="form-control" id="living" name="living">
            </div>
            <div class="form-group">
                <label for="nice">Say something nice to someone</label>
                <textarea class="form-control" rows="4" id="nice" name="nice"></textarea>
            </div>
            <button type="submit" class="btn btn-primary">SEND</button>
        </form>
    </div>

    <!-- Include Bootstrap JS scripts (optional) -->
    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.1/dist/umd/popper.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>
