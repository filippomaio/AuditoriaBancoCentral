<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Matriz 1</title>
</head>
<body>
<div >${d11}</div>
<div >${d12}</div>
<div >${d13}</div>
<div >${d21}</div>
<div >${d22}</div>
<div >${d23}</div>
<div >${d31}</div>
<div >${d32}</div>
<div >${d33}</div>
<form action="Risco.do?acao=matriz" method="POST">
	<input type="submit" value="Carregar" name="btnCarregar">
</form>

</body>
</html>