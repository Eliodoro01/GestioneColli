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


<h1> Gestione Corrieri </h1>
<table>
<tr>
	<td><b>NOME</b></td>
	<td><b>CAP</b></td>
	<td><b>CITTÀ</b></td>
	<td><b>INDIRIZZO</b></td>
	<td><b>PARTITA IVA</b></td>
	<td><b>TELEFONO</b></td>
	<td><b>EMAIL</b></td>
	<td><b>USERNAME</b></td>
	
</tr>
 
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
</table>

<a href="home.jsp">HOME</a>


</body>
</html>