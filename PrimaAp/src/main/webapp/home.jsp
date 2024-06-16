<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<!DOCTYPE html>

<html lang="en">

<head>
  <meta charset="utf-8">
  <meta content="width=device-width, initial-scale=1.0" name="viewport">

  <title>GestioneColli</title>
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
        <h1>GestioneColli<span>.</span></h1>
      </a>  

      <a class="btn-getstarted scrollto" href="Logout">Logout</a>

    </div>
  </header><!-- End Header -->

  <section id="hero-animated" class="hero-animated d-flex align-items-center">
    <div class="container d-flex flex-column justify-content-center align-items-center text-center position-relative" data-aos="zoom-out">
      
      <h5 id ="messaggiotitolo">${success} ${error}</h5>
      <h2>Welcome to <span>GestioneColli</span></h2>
      <p>Questa è una WebApp che permette la Gestione di tutto ciò che riguarda le aziende di spedizioni, a partire dai corrieri fino ad arrivare ai pacchi.</p>
      <div class="d-flex">
     
      </div>
    </div>
  </section>

  <main id="main">

 <c:if test = "${permesso == 'guest'}"> <!-- se il permesso corrisponde a quello di guest si va ad una pagina dedicata alle funzionalità del guest -->

    <!-- ======= Services Section ======= -->
    <section id="services" class="services">
      <div class="container" data-aos="fade-up">
     	<div class="row gy-5">

          <div class="col-xl-4 col-md-6" data-aos="zoom-in" data-aos-delay="200">
            <div class="service-item">
              <div class="img">
                <img src="img/InserisciVeicoli.jpg" class="img-fluid" width="500" height="400">
              </div>
              <div class="details position-relative" >
                <div class="icon">
                  <i class="bi bi-activity"></i>
                </div>
                <a href="form_inserimento_veicolo.jsp" class="stretched-link">
                  <h3>Inserisci Veicolo</h3>
                </a>
                <p>Tramite questa pagina è possibile inserire nuovi veicoli a cui associare colli</p>
              </div>
            </div>
          </div><!-- End Service Item -->

          <div class="col-xl-4 col-md-6" data-aos="zoom-in" data-aos-delay="300">
            <div class="service-item">
              <div class="img">
                <img src="assets/img/services-2.jpg" class="img-fluid" width="500" height="400">
              </div>
              <div class="details position-relative">
                <div class="icon">
                  <i class="bi bi-broadcast"></i>
                </div>
                <a href="InserimentoVeicolo" class="stretched-link">
                  <h3>Gestione veicoli</h3>
                </a>
                <p>Tramite questa pagina è possibile gestire tutti i veicoli già esistenti ed è possibile accedere ad una pagina per gestire i colli in un determinato veicolo</p>
              </div>
            </div>
          </div><!-- End Service Item -->

          <div class="col-xl-4 col-md-6" data-aos="zoom-in" data-aos-delay="400">
            <div class="service-item">
              <div class="img">
                <img src="img/InserisciCollo.jpg" class="img-fluid" width="500" height="400">
              </div>
              <div class="details position-relative">
                <div class="icon">
                  <i class="bi bi-easel"></i>
                </div>
                <a href="form_inserimento_collo.jsp" class="stretched-link">
                  <h3>Inserisci Collo</h3>
                </a>
                <p>Tramite questa pagina è possibile inserire nuovi colli nel primo veicolo abbastanza grande per contenerli</p>
              </div>
            </div>
          </div><!-- End Service Item -->


        </div>

      </div>
    </section><!-- End Services Section -->

</c:if>
    
    
 
 
 <c:if test = "${permesso == 'admin'}"> <!-- se il permesso corrisponde a quello di guest si va ad una pagina dedicata alle funzionalità del guest -->

    <!-- ======= Services Section ======= -->
    <section id="services" class="services">
      <div class="container" data-aos="fade-up">
     	<div class="row gy-5">

          <div class="col-xl-6 col-md-6" data-aos="zoom-in" data-aos-delay="200">
            <div class="service-item">
              <div class="img">
                <img src="img/InserisciCorriere.jpg" class="img-fluid" alt="" width = "500" height = "400">
              </div>
              <div class="details position-relative">
                <div class="icon">
                  <i class="bi bi-activity"></i>
                </div>
                <a href="form_inserimento_corriere.jsp" class="stretched-link">
                  <h3>Inserisci Corriere</h3>
                </a>
                <p>Tramite questa pagina è possibile inserire nuovi corrieri (azienda di spedizioni)</p>
              </div>
            </div>
          </div><!-- End Service Item -->

          <div class="col-xl-6 col-md-6" data-aos="zoom-in" data-aos-delay="300">
            <div class="service-item">
              <div class="img">
                <img src="assets/img/services-2.jpg" class="img-fluid" alt="">
              </div>
              <div class="details position-relative">
                <div class="icon">
                  <i class="bi bi-broadcast"></i>
                </div>
                <a href="InserimentoCorriere" class="stretched-link">
                  <h3>Gestione Corrieri</h3>
                </a>
                <p>Tramite questa pagina è possibile gestire tutti i corrieri già esistenti</p>
              </div>
            </div>
          </div><!-- End Service Item -->

        </div>

      </div>
    </section><!-- End Services Section -->

</c:if>   
    
    
    
  <!-- ======= Footer ======= -->
  <footer id="footer" class="footer">
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

<script type="text/javascript">
timeout_id = setTimeout(function(){document.getElementById('messaggiotitolo').style.display="none"}, 6000);
</script>

</body>

</html>