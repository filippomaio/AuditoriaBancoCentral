<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="CadastrarProcesso.do" method="POST">
	Nome do Objeto: <input type="text" name="nomeObjeto"><br>
	Objetivo: <input type="text" name="objetivo"><br>
	Descrição: <input type="text" name="descricao"><br>
	<input type="submit" value="Cadastrar" name="btnCadastrar">
</form>
</body>
</html>