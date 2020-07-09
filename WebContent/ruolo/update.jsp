<%@page import="model.Ruolo"%>
<%@page import="java.util.Optional"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Update</title>
</head>
<body>
<%
Optional<Ruolo> tmp = (Optional<Ruolo>)session.getAttribute("getRuolo"); 
request.getSession().removeAttribute("getRuolo");
%>

<h1>Update</h1>

<form action="/corso/RuoloSrv" method="post">

	<input type="hidden" name="op" value="u">
	<input type="hidden" name="id" value="<%out.print(tmp.get().getIdruolo());%>">
  	<label for="descrizione">Descrizione:</label>
  	<input type="text" id="descrizione" name="descrizione" value="<%out.print(tmp.get().getDescrizione());%>" required><br><br>
  	
  	<input type="submit" value="Submit">
</form> 

</body>
</html>