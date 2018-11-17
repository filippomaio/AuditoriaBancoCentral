<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Auditoria</title>
</head>
<body>
<form action="Login.do" method="POST">
	Usuario: <input type="text" name="login"><br>
	Senha: <input type="text" name="senha"><br>
	${message}<br>
	<input type="submit" value="Logar" name="btnLogar">
</form>
</body>
</html>