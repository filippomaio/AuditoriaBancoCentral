<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Cadastrar Risco</title>
</head>
<body>
<form action="Risco.do?acao=cadastrar" method="POST">
	Código do Risco: <input type="text" name="codigo"><br>
	Nome: <input type="text" name="nome"><br>
	Descrição: <input type="text" name="descricao"><br>
	Impacto: <input type="text" name="impacto"><br>
	Probabilidade: <input type="text" name="probabilidade"><br>
	${message }<br>
	<input type="submit" value="Cadastrar" name="btnCadastrar">
</form>
</body>
</html>