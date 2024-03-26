<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Tracciamento</title>
</head>
<body>


<form method="post" action="Tracciamento">


<label>codice:</label>
<input type="text" name="codice" placeholder="inserisci il codice del collo">
<br>

<!-- <input type="hidden" name="pold" value="${corriere.piva}"> -->
<button type="reset">Cancella</button>
<button type="submit">Invia</button>


</form>

</body>
</html>