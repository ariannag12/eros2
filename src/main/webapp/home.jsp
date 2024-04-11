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
		<c:when test="${not empty user}">
			<h1>Ciao e benvenuto, ${user.firstName}</h1>
		</c:when>
				<c:otherwise>
			<h1>Credenziali non valide</h1>
		</c:otherwise>
	</c:choose>
 <main  class="d-flex p-2">
 <div class="card" style="width: 18rem; margin-right:15px;">
  <img src="img/chat.jpg" class="card-img-top" alt="...">
  <div class="card-body">
    <h5 class="card-title">Chat</h5>
    <p class="card-text">Inizia a chattare con i tuoi match.</p>
    <a href="#" class="btn btn-primary">Entra</a>
  </div>
</div>
<div class="card" style="width: 18rem;">
  <img src="img/image.png" class="card-img-top" alt="...">
  <div class="card-body">
    <h5 class="card-title">Cerca Profili</h5>
    <p class="card-text">Scopri profili vicino a te.</p>
    <a href="#" class="btn btn-primary">Entra</a>
  </div>
</div>
        </main>
</body>
</html>