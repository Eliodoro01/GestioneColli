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

<c:if test="${corriere==null}">
<form method="post" action="InserimentoCorriere">
</c:if>

<c:if test="${corriere!=null}">
<form method="post" action="ModificaCorriere">
</c:if>

<label>nome:</label>
<input type="text" name="nome" placeholder="inserisci il nome" value="${corriere.nome}">
<br>
<label>partita iva:</label>
<input type="text" name="piva" placeholder="inserisci la partita iva" value="${corriere.piva}">
<br>
<label>indirizzo:</label>
<input type="text" name="indirizzo" placeholder="inserisci l'indirizzo" value="${corriere.indirizzo}">
<br>
<label>telefono:</label>
<input type="text" name="telefono" placeholder="inserisci il telefono" value="${corriere.telefono}">
<br>
<label>città:</label>
<input type="text" name="citta" placeholder="inserisci la città" value="${corriere.citta}">
<br>
<label>CAP:</label>
<input type="text" name="cap" placeholder="inserisci il cap" value="${corriere.cap}">
<br>
<label>username:</label>
<input type="text" name="username" placeholder="inserisci l'username" value="${corriere.username}">
<br>
<label>email:</label>
<input type="text" name="email" placeholder="inserisci l'email" value="${corriere.email}">
<br>
<label>password:</label>
<input type="text" name="password" placeholder="inserisci la password" value="${corriere.password}">
<br>


<button type="reset">Cancella</button>

<c:if test="${corriere==null}">
<button type="submit">Invia</button>
</c:if>

<c:if test="${corriere!=null}">
<input type="hidden" name="pold" value="${corriere.piva}">
<input type="hidden" name="idaccount" value="${corriere.idaccount}">
<button type="submit">Modifica</button>
</c:if>

</form>



</body>
</html>