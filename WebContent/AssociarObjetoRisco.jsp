<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.List" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Associar Objeto Risco</title>
</head>
<body>
<form action="Objeto.do?acao=associar" method="POST">
	Objetos:<select name="idObjeto">
	<%
  	List lista1 = (List)session.getAttribute("idObjetos");
  	List lista2 = (List)session.getAttribute("nomeObjetos");
  	for(int i = 0; i < lista1.size(); i++) {
  		String idObjeto = lista1.get(i).toString();
    	String nomeObjeto = lista2.get(i).toString();
 	%>
	<option value=<%=idObjeto%>><%=idObjeto%> - <%=nomeObjeto%> </option>																
 	<% } //fecha for
	%>
	</select><br>
	Riscos:<select name="idRisco">
	<%
  	List lista3 = (List)session.getAttribute("idRiscos");
  	List lista4 = (List)session.getAttribute("nomeRiscos");// ou codigo riscos?
  	for(int i = 0; i < lista3.size(); i++) {
  		String idRisco = lista3.get(i).toString();
    	String nomeRisco = lista4.get(i).toString();
 	%>
	<option value=<%=idRisco%>><%=idRisco%> - <%=nomeRisco%> </option>																
 	<% } //fecha for
	%>
	</select><br>
	<input type="submit" value="Cadastrar" name="btnCadastrar">
</form>

</body>
</html>