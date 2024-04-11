<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Error Page</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css">
</head>
<body>
    <div class="container mt-5">
        <h1>Oops! An error occurred.</h1>
        <div class="alert alert-danger">
            <strong>Error:</strong> ${errorMessage}
        </div>
        <a href="createaccount.jsp" class="btn btn-primary">Try Again</a>
    </div>
</body>
</html>
