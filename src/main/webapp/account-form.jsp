<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Registrazione</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css">
<link rel="stylesheet" href="css/index.css">
<link rel="stylesheet" href="css/account-form.css">
</head>
<body>
<div class="container">
<form action="/eros2/profile" method="post">  <!-- Aggiunta l'azione e il metodo -->
  <div class="card">
    <img src="img/image.png" class="card-img-top" alt="utente">
  </div>
  <div class="card-body">
    <p class="card-text">Raccontaci qualcosa di te</p>
  </div>
  <div class="mb-3">
    <textarea class="form-control" id="bio" name="bio" rows="5" placeholder="Qualcosa su di te..."></textarea>
  </div>
  <h2>Quali sono i tuoi hobby?</h2>
  <div class="form-check">
    <input class="form-check-input" type="checkbox" value="Sport" name="hobby" id="sport">
    <label class="form-check-label" for="sport">
      Sport
    </label>
  </div>
  <div class="form-check">
    <input class="form-check-input" type="checkbox" value="Viaggiare" name="hobby" id="viaggiare">
    <label class="form-check-label" for="viaggiare">
      Viaggiare
    </label>
  </div>
  <div class="form-check">
    <input class="form-check-input" type="checkbox" value="Lettura" name="hobby" id="lettura">
    <label class="form-check-label" for="lettura">
      Lettura
    </label>
  </div>
  <h2>Sei un fumatore?</h2>
  <div class="form-check">
    <input class="form-check-input" type="radio" name="fumatore" id="si" value="Si">
    <label class="form-check-label" for="si">
      Si
    </label>
  </div>
  <div class="form-check">
    <input class="form-check-input" type="radio" name="fumatore" id="no" value="No">
    <label class="form-check-label" for="no">
      No
    </label>
  </div>
  <div class="form-check">
    <input class="form-check-input" type="radio" name="fumatore" id="indifferente" value="Indifferente">
    <label class="form-check-label" for="indifferente">
      Indifferente
    </label>
  </div>
  <div class="form-check">
    <input class="form-check-input" type="radio" name="fumatore" id="mattina" value="Solo la mattina">
    <label class="form-check-label" for="mattina">
      Sola la mattina
    </label>
  </div>
  <div class="form-check">
    <input class="form-check-input" type="radio" name="fumatore" id="pomeriggio" value="Solo il pomeriggio">
    <label class="form-check-label" for="pomeriggio">
      Solo il pomeriggio
    </label>
  </div>
  <div>
    <button type="submit" class="btn btn-secondary">Invia</button>
  </div>
</form>
<div class="registration-container">
  <a href="index.html">
    <button type="button" class="btn btn-secondary">Logout</button>
  </a>
</div>
</div>
</body>
</html>