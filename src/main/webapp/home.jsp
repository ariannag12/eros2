<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login</title>
<link rel="stylesheet" href="css/index.css">
<link rel="stylesheet" href="css/home.css">
</head>
<body>
<div class="card" style="width: 18rem;">
  <img src="img/image.png" class="card-img-top" alt="...">
  <div class="card-body">
 <c:choose>
		<c:when test="${not empty param.nickname}">
			<h1>Ciao e benvenuto, ${param.nickname}</h1>
		</c:when>
				<c:otherwise>
			<h1>Credenziali non valide</h1>
		</c:otherwise>
	</c:choose>
    <p class="card-text">Some quick example text to build on the card title and make up the bulk of the card's content.</p>
  </div>
  <ul class="list-group list-group-flush">
    <li class="list-group-item">An item</li>
    <li class="list-group-item">A second item</li>
    <li class="list-group-item">A third item</li>
  </ul>
  <div class="card-body">
    <a href="#" class="card-link">Card link</a>
    <a href="#" class="card-link">Another link</a>
  </div>
</div>

</body>
</html>