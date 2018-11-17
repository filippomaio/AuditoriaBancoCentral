<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Cadastrar Processo</title>
</head>
<body>
<form action="Processo.do?acao=cadastrar" method="POST">
	Nome do Processo: <input type="text" name="nome"><br>
	Descrição: <input type="text" name="descricao"><br>
	${message}
	<input type="submit" value="Cadastrar" name="btnCadastrar">
</form>
</body>
</html>