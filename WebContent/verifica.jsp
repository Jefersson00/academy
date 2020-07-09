<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>verifica</title>
</head>
<body>
<%
String vrf=request.getParameter("verifica");
// request.getSession().removeAttribute("verifica");
%>
<% out.print(vrf); %>
<br>
<a href="/corso/index.html">ritorna alla home </a>

</body>
</html>