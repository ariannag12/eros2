<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css">
<link rel="stylesheet" href="css/index.css">
<link rel="stylesheet" href="css/home.css">
</head>
<body>
<div class="immagine">
  <img src="img/image.png" class="card-img-top" alt="utente">
  </div>
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