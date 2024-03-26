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
 
	<tr>
		<td>${collo.mittente}</td>
		<td>${collo.destinatario} </td>
		<td>${collo.codice} </td>
		<td>${collo.peso} </td>
		<td>${collo.stato} </td>
		
	</tr>
 

</table>

<a href="tracciamento.jsp">HOME</a>

</body>
</html>