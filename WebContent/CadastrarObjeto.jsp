<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.List" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Cadastrar Objeto</title>
</head>
<body>
<form action="Objeto.do?acao=cadastrar" method="POST">
	Nome: <input type="text" name="nome"><br>
	Descrição: <input type="text" name="descricao"><br>
	Processos:<select name="idProcesso">
	<%
  	List lista1 = (List)session.getAttribute("idProcessos");
  	List lista2 = (List)session.getAttribute("nomeProcessos");
  	for(int i = 0; i < lista1.size(); i++) {
  		String idProcesso = lista1.get(i).toString();
    	String nome = lista2.get(i).toString();
 	%>
	<option value=<%=idProcesso%>> <%=nome%> </option>																
 	<% } //fecha for
	%>
	</select><br>
	<input type="submit" value="Cadastrar" name="btnCadastrar">
</form>
</body>
</html>