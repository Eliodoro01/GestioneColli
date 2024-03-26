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

<h2 class="stiletitolo">${success} ${error}</h2>

<h1> Gestione Colli </h1>
<table>
<tr>
	<td><b>MITTENTE</b></td>
	<td><b>DESTINATARIO</b></td>
	<td><b>CODICE</b></td>
	<td><b>PESO</b></td>
	<td><b>STATO</b></td>
	
</tr>
 
<c:forEach var="list" items="${lista}"> <!-- IN ITEM METTIAMO L'ARRAY LIST PASSATA DALLA SERVLET MENTRE IN VAR UN NOME GENERICO -->
	<tr>
		<td>${list.mittente}</td>
		<td>${list.destinatario} </td>
		<td>${list.codice} </td>
		<td>${list.peso} </td>
		<td>${list.stato} </td>
		
		<td>
			<form method = "POST" action = "GestioneColli">
					<select name = "stato">
							<option value = 0>Aggiorna Stato</option>
							<option value = "inlavorazione">In Lavorazione</option>
							<option value = "spedito">Spedito</option>
					</select>
					<input type = "hidden" value = "${list.id}" name = "idcollo">
					<input type = "hidden" value = "${list.idveicolo}" name = "idveicolo"> 
					<button type = "submit">Conferma</button>
			</form>
		</td>
	</tr>
 
</c:forEach>
</table>

<a href="home.jsp">HOME</a>


</body>
</html>