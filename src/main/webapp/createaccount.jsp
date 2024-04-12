<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css">
<meta charset="UTF-8">
<link rel="stylesheet" href="css/login.css">
<link rel="stylesheet" href="css/createaccount.css">
<title>Crea account</title>
</head>
<body>
	<div class="container">
		<h1>Crea il tuo Account</h1>
		<form method="post" action="/eros2/register">
			<div class="mb-3">
				<label for="firstName" class="form-label">Nome</label> <input
					type="text" name="firstName" id="nome" class="form-control"
					placeholder="Scrivi il tuo nome" required>
			</div>
			<div class="mb-3">
				<label for="lastName" class="form-label">Cognome</label> <input
					type="text" name="lastName" id="cognome" class="form-control"
					placeholder="Scrivi il tuo cognome" required>
			</div>
			<div class="mb-3">
				<label for="userName" class="form-label">Nickname</label> <input
					type="text" name="username" id="nickname" class="form-control"
					placeholder="Scrivi il tuo nickname" required>
				<c:if test="${not empty errorMessage}">
					<div class="alert alert-danger">Nickname già in uso</div>
				</c:if>
			</div>
			<div class="mb-3">
				<label for="password" class="form-label">Password</label> <input
					type="password" id="password" name="password" class="form-control"
					placeholder="Scrivi la tua password" required>
			</div>
			<div class="mb-3">
				<label for="email" class="form-label">Email</label> <input
					type="email" name="email" id="email" class="form-control"
					placeholder="Scrivi la tua email" required>
				<c:if test="${not empty errorMessage}">
					<div class="alert alert-danger">Email già in uso</div>
				</c:if>
			</div>
			<div class="form-group">
				<label class="active" for="birthdate">Data di nascita</label> <input
					type="date" id="birthdate" name="birthDate" class="form-control"
					required>
			</div>
			<div class="card-body">
				<h5>Come ti identifichi?</h5>
			</div>
			<div class="form-check">
				<input class="form-check-input" type="radio" name="gender" id="male"
					value="Maschio"> <label class="form-check-label" for="male">
					Maschio </label>
			</div>
			<div class="form-check">
				<input class="form-check-input" type="radio" name="gender"
					id="female" value="Femmina"> <label
					class="form-check-label" for="female"> Femmina </label>
			</div>
			<div class="form-check">
				<input class="form-check-input" type="radio" name="gender"
					id="non-binary" value="Non-binary"> <label
					class="form-check-label" for="non-binary"> Non-binary </label>
			</div>
			<div class=button>
				<button type="submit" class="btn btn-secondary">Registrati</button>
			</div>
		</form>
	</div>
	<div class="registration-container">
		<a href="index.html">
			<button type="button" class="btn btn-secondary">Torna alla
				home</button>
		</a>
	</div>
</body>
</html>