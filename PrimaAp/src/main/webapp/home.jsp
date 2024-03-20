<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="css/miostile.css">

</head>
<body>

<h2 class="stiletitolo">${success} ${error} <!-- per vedere il contenuto del parametro passato nella request--></h2>


<c:if test = "${permesso == 'admin'}"> <!-- se il permesso corrisponde a quello di admin si va ad una pagina dedicata alle funzionalità dell'admin -->

<a href="form_inserimento_corriere.jsp">Inserisci corriere</a>

<a href="InserimentoCorriere"><!-- ?nome=sebastiano&&cognome=apuzzo-->Gestione corrieri</a> <!-- il link è sempre una richiesta di tipo GET-->

<a href = "Logout"> Logout</a>

</c:if>

<c:if test = "${permesso == 'guest'}"> <!-- se il permesso corrisponde a quello di guest si va ad una pagina dedicata alle funzionalità del guest -->
<p>${id} </p>
<a href="form_inserimento_veicolo.jsp">Inserisci Veicolo</a>

<a href="InserimentoVeicolo">Gestione veicoli</a>

<a href="form_inserimento_collo.jsp">Inserisci Collo</a>

<a href = "Logout"> Logout</a>
</c:if>

</body>
</html>