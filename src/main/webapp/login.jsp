<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login</title>
</head>
<body>
<c:choose>
        <c:when test="${not empty param.nickname}">
            <h1>Ciao e benvenuto, ${param.nickname}</h1>
        </c:when>
        <c:otherwise>
        <h1>Credenziali non valide</h1>
    </c:otherwise>
    </c:choose>
</body>
</html>