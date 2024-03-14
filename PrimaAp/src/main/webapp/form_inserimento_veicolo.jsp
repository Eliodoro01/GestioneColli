<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Inserimento veicolo</title>
</head>
<body>


<form method="post" action="InserimentoVeicolo">

<label>capienza:</label>
<input type="text" name="capienza" placeholder="inserisci la capienza">
<br>
<label>codice:</label>
<input type="text" name="codice" placeholder="inserisci il codice">
<br>
<label>tipo:</label>
<input type="text" name="tipo" placeholder="inserisci il tipo">
<br>


<button type="reset">Cancella</button>

<input type="hidden" name="pold" value="${corriere.piva}">
<button type="submit">Invia</button>


</form>


</body>
</html>