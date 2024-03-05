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

<h2 class="stiletitolo">${success} <!-- per vedere il contenuto del parametro passato nella request--></h2>

<c:if test = "${permesso == 'admin'}">

<a href="Inserimento">Gestione</a>

<a href="form_inserimento_corriere.jsp">Inserisci corriere</a>


<a href = "Logout">
Logout</a>

</c:if>

<c:if test = "${permesso == 'guest'}">
<a href="Inserimento">Gestione</a>

<a href = "Logout">
Logout</a>
</c:if>

</body>
</html>