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


<h1> Gestione Dipendenti </h1>
<table>
<tr>
	<td><b>NOME</b></td>
	<td><b>COGNOME</b></td>
	<td><b>CF</b></td>
	<td><b>ETA'</b></td>
</tr>
 
<c:forEach var="list" items="${arraydip}">
	<tr>
		<td>${list.nome}</td>
		<td>${list.cognome} </td>
		<td>${list.cf} </td>
		<td>${list.eta} </td>
		
			
		<td><a href="Modifica?cf=${list.cf}"><b>modifica</b></a></td>
		<td><a href="Elimina?cf=${list.cf}"><b>elimina</b> </a></td>
	</tr>
 
</c:forEach>
</table>

<a href="home.jsp">HOME</a>


</body>
</html>