
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<!DOCTYPE html>

<html lang="en">

<head>
  <meta charset="utf-8">
  <meta content="width=device-width, initial-scale=1.0" name="viewport">

  <title>Gestione Colli</title>
  <meta content="" name="description">
  <meta content="" name="keywords">

  <!-- Favicons -->
  <link href="assets/img/favicon.png" rel="icon">
  <link href="assets/img/apple-touch-icon.png" rel="apple-touch-icon">

  <!-- Google Fonts -->
  <link rel="preconnect" href="https://fonts.googleapis.com">
  <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
  <link href="https://fonts.googleapis.com/css2?family=Open+Sans:ital,wght@0,300;0,400;0,500;0,600;0,700;1,300;1,400;1,500;1,600;1,700&family=Poppins:ital,wght@0,300;0,400;0,500;0,600;0,700;1,300;1,400;1,500;1,600;1,700&family=Source+Sans+Pro:ital,wght@0,300;0,400;0,600;0,700;1,300;1,400;1,600;1,700&display=swap" rel="stylesheet">

  <!-- Vendor CSS Files -->
  <link href="assets/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
  <link href="assets/vendor/bootstrap-icons/bootstrap-icons.css" rel="stylesheet">
  <link href="assets/vendor/aos/aos.css" rel="stylesheet">
  <link href="assets/vendor/glightbox/css/glightbox.min.css" rel="stylesheet">
  <link href="assets/vendor/swiper/swiper-bundle.min.css" rel="stylesheet">

  <!-- Variables CSS Files. Uncomment your preferred color scheme -->
  <link href="assets/css/variables.css" rel="stylesheet">
 

  <!-- Template Main CSS File -->
  <link href="assets/css/main.css" rel="stylesheet">

 
</head>

<body>

  <!-- ======= Header ======= -->
  <header id="header" class="header fixed-top" data-scrollto-offset="0">
    <div class="container-fluid d-flex align-items-center justify-content-between">

      <a href="home.jsp" class="logo d-flex align-items-center scrollto me-auto me-lg-0">
        <!-- Uncomment the line below if you also wish to use an image logo -->
        <!-- <img src="assets/img/logo.png" alt=""> -->
        <h1>Gestione Corrieri<span>.</span></h1>
      </a>

      <a class="btn-getstarted scrollto" href="Logout">Logout</a>

    </div>
  </header><!-- End Header -->

  <main id="main">




<div style="border:1px solid #0ea2bd" class="container" id = "formcorriere">

          

<table class="table">
  <thead>
    <tr>
      <th scope="col">Nome</th>
      <th scope="col">Cap</th>
      <th scope="col">Città</th>
      <th scope="col">Indirizzo</th>
      <th scope="col">Partita Iva</th>
      <th scope="col">Telefono</th>
      <th scope="col">Email</th>
      <th scope="col">Username</th>
    </tr>
  </thead>

<tbody>
<c:forEach var="list" items="${lista}"> <!-- IN ITEM METTIAMO L'ARRAY LIST PASSATA DALLA SERVLET MENTRE IN VAR UN NOME GENERICO -->
	<tr>
		<td>${list.nome}</td>
		<td>${list.cap} </td>
		<td>${list.citta} </td>
		<td>${list.indirizzo} </td>
		<td>${list.piva} </td>
		<td>${list.telefono} </td>
		<td>${list.email} </td>
		<td>${list.username} </td>
		
			
		<td><a href="ModificaCorriere?piva=${list.piva}"><b>modifica</b></a></td>
		<td><a href="EliminaCorriere?piva=${list.piva}"><b>elimina</b> </a></td>
	</tr>
 
</c:forEach>
</tbody> 
</table>


</div>


 
    
  <!-- ======= Footer ======= -->
  <footer id="footer" class="footer" style="margin-top: 25%">
    <div class="footer-legal text-center">
      <div class="container d-flex flex-column flex-lg-row justify-content-center justify-content-lg-between align-items-center">

        <div class="d-flex flex-column align-items-center align-items-lg-start">
          <div class="copyright">
            &copy; Copyright <strong><span>Eliodoro Mascolo</span></strong>. All Rights Reserved
          </div>
          <div class="credits">      
            Designed by me
          </div>
        </div>

   

      </div>
    </div>

  </footer><!-- End Footer -->

  <a href="#" class="scroll-top d-flex align-items-center justify-content-center"><i class="bi bi-arrow-up-short"></i></a>

  <div id="preloader"></div>

  <!-- Vendor JS Files -->
  <script src="assets/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>
  <script src="assets/vendor/aos/aos.js"></script>
  <script src="assets/vendor/glightbox/js/glightbox.min.js"></script>
  <script src="assets/vendor/isotope-layout/isotope.pkgd.min.js"></script>
  <script src="assets/vendor/swiper/swiper-bundle.min.js"></script>
  <script src="assets/vendor/php-email-form/validate.js"></script>

  <!-- Template Main JS File -->
  <script src="assets/js/main.js"></script>


</body>

</html>

