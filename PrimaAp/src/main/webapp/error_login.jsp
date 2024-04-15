<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" http-equiv="refresh" content="3; url=login.jsp" charset="ISO-8859-1">
  <title>Error Page</title>
  <!-- Bootstrap CSS -->
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet">
  <!-- Font Awesome for icons -->
  <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/css/all.min.css" rel="stylesheet">
  <style>
    /* Custom styles for this template */
    body {
      background-color: #f8f9fa;
      height: 100vh;
    }
    .error-container {
      height: 100%;
      display: flex;
      flex-direction: column;
      justify-content: center;
      align-items: center;
    }
    .error-title {
      font-size: 6rem;
      color: #dc3545;
    }
    .error-message {
      font-size: 1.5rem;
    }
  </style>
</head>
<body>
  <div class="error-container">
    <div class="error-title">
      <i class="fas fa-exclamation-triangle"></i>     
    </div>
    <h2 class="stiletitolo">${error} <!-- per vedere il contenuto del parametro passato nella request--></h2>
    <!--  <a href="login.jsp" class="btn btn-primary mt-3">Torna alla Homepage</a>-->
  </div>
  <!-- Bootstrap JS (optional) -->
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
