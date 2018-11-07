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
	Código do Risco: <input type="text" name="codigo"><br>
	Descrição: <input type="text" name="descricao"><br>
	Processos:<select name="pergunta1" class="combobox">
    <option value="">..</option>
    <c:forEach var="processos" items="${processos}">
        <option value="${processos.id}">
            ${processos.nomeObjeto}
        </option>
     </c:forEach>
	</select>
	<input type="submit" value="Cadastrar" name="btnCadastrar">
</form>
</body>
</html>