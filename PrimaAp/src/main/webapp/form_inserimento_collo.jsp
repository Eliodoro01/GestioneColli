<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Inserimento collo</title>
</head>
<body>


<form method="post" action="InserimentoCollo">

<label>mittente:</label>
<input type="text" name="mittente" placeholder="inserisci il mittente">
<br>
<label>destinatario:</label>
<input type="text" name="destinatario" placeholder="inserisci il destinatario">
<br>
<label>codice:</label>
<input type="text" name="codice" placeholder="inserisci il codice">
<br>
<label>peso:</label>
<input type="text" name="peso" placeholder="inserisci il peso">
<br>


<button type="reset">Cancella</button>

<!-- <input type="hidden" name="pold" value="${corriere.piva}"> -->
<button type="submit">Invia</button>


</form>


</body>
</html>