<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css">
<meta charset="UTF-8">
 <link rel="stylesheet" href="css/login.css">
<title>Login</title>
</head>
<body>
<div class="container">
<h1>Accedi</h1>
<form method="post" action="login">
 <div class="mb-3">
    <label for="nickname" class="form-label">Nickname</label>
    <input name="username" id="nickname" class="form-control" placeholder="Scrivi il tuo nickname" value="${userName}">
    </div>
  <div class="mb-3">
    <label for="password" class="form-label">Password</label>
    <input type="password" id="password" name="password" class="form-control" placeholder="Scrivi la tua password">   
  </div>
  <c:if test="${userName}"><p>nickname o password errati!</p></c:if>
 	
   <button type="submit" class="btn btn-secondary">Entra</button>
   <button type="submit" class="btn btn-primary">Registrazione</button>

</form>
</div>
</body>
</html>