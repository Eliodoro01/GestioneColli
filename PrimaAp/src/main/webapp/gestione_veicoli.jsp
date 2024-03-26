<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<h1> Gestione Veicoli </h1>
<table>
<tr>
	<td><b>TIPO</b></td>
	<td><b>CODICE</b></td>
	<td><b>CAPIENZA</b></td>
	<td><b>CARICO ATTUALE</b></td>
	
</tr>


 
<c:forEach var="list" items="${lista}"> <!-- IN ITEM METTIAMO L'ARRAY LIST PASSATA DALLA SERVLET MENTRE IN VAR UN NOME GENERICO -->
	<tr>
		<td>${list.tipo}</td>
		<td>${list.codice} </td>
		<td>${list.capienza} </td>
		<td>${list.caricoAttuale} </td>
		
		<td><a href="EliminaVeicolo?codice=${list.codice}"><b>elimina</b> </a></td>
		<td><a href="GestioneColli?id=${list.id}"><b>gestisciColli</b> </a></td>
	</tr>
 
</c:forEach>
</table>

<a href="home.jsp">HOME</a>


</body>
</html>