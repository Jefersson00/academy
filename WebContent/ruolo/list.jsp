<%@page import="model.Ruolo"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!--     			request.getSession().removeAttribute(name); -->

<!DOCTYPE html>
<html>
<head>
<%
ArrayList<Ruolo> tmp = (ArrayList<Ruolo>) session.getAttribute("listRuoli"); 
request.getSession().removeAttribute("listRuoli");
%>

<meta charset="ISO-8859-1">
<title>List Ruolo</title>


</head>
<body>


	<h1>List Ruoli</h1>
	<br>
	<br>
	<br>
	<table>
	<%
		for(int i=0; i< tmp.size(); i++) { 
  				Ruolo r = tmp.get(i); 		
	%>
		<tr>
			<td>
				<% out.print(r.getIdruolo()); %><br />
			</td>
			<td>
				<% out.print(r.getDescrizione()); %><br />
			</td>
			<td><a href="/corso/RuoloSrv?op=g&id=<%out.print(r.getIdruolo());%>"><button>update</button></a></td>
			<td><a href="/corso/RuoloSrv?op=d&id=<%out.print(r.getIdruolo());%>"><button>delete</button></a></td>

		</tr>

	<% }%>
	</table>


</body>
</html>