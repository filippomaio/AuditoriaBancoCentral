<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.List"%>
<%if(!session.getAttribute("cargo").toString().equals("1")){%>
	<META http-equiv="refresh" content="1;URL=http://localhost:8080/AuditoriaBancoCentral/Login.jsp"> 
<%}%>
<!DOCTYPE HTML>
<html lang="pt-br">
<head>
<title>Mitigação</title>
<meta charset="utf-8" />
<meta name="viewport"
	content="width=device-width, initial-scale=1, user-scalable=no" />
<link rel="stylesheet" href="assets/css/main.css" />
<noscript>
	<link rel="stylesheet" href="assets/css/noscript.css" />
</noscript>
</head>
<body class="is-preload">

	<!-- Header -->
	<header id="header">
		<a href="Home.jsp" class="title">Mitigação</a>
		<nav>
			<ul>
				<li><a href="Home.jsp">Home</a></li>
			</ul>
		</nav>
	</header>

	<!-- Wrapper -->
	<div id="wrapper">

		<!-- Main -->
		<section id="main" class="wrapper">
			<div class="inner">
				<h2>Auditar</h2>
				<form method="post" action="Mitigacao.do?acao=auditar">
					<div class="row gtr-uniform">
						<div class="col-12">
							<select name="selectIdObjetoRiscoMitigacao" id="demo-category">
								<option value="">- Objeto - Risco - Mitigação -</option>
								<%
									//Id cada Tabela
									List lista1 = (List) session.getAttribute("idObjetosRiscosMitigacoesM");
									List lista2 = (List) session.getAttribute("idObjetosM");
									List lista3 = (List) session.getAttribute("idRiscosM");
									List lista4 = (List) session.getAttribute("idMitigacoesM");
									
									//Nome cada Tabela
									List lista5 = (List) session.getAttribute("nomeObjetosM");
									List lista6 = (List) session.getAttribute("nomeRiscosM");
									List lista7 = (List) session.getAttribute("nomeMitigacoesM");
									
									//Atributos unificados na tabela ObjetoRiscoMitigacao
									List lista8 = (List) session.getAttribute("avaliacoesM");
									
									for (int i = 0; i < lista1.size(); i++) {
										String idObjetoRiscoMitigacao = lista1.get(i).toString();
										String avaliacaoMitigacao = lista8.get(i).toString();
										if (avaliacaoMitigacao.equals("0")){
											String nomeObjeto = lista5.get(i).toString();
											String nomeRisco = lista6.get(i).toString();
											String nomeMitigacao = lista7.get(i).toString();

								%>
								<option value=<%=idObjetoRiscoMitigacao%>><%=nomeObjeto%> - <%=nomeRisco%> - <%=nomeMitigacao%></option>
								<%
									}} //fecha for
								%>
							</select>
						</div>
						<div class="col-12">
							<select name="avaliacaoMitigacao" id="demo-category">
								<option value="">- Avaliação -</option>
								<option value="5">Inexistente</option>
								<option value="4">Fraco</option>
								<option value="3">Insatisfatório</option>
								<option value="2">Satisfatório</option>
								<option value="1">Forte</option>
							</select>
						</div>
						<div class="col-12">
							<textarea name="comentarios" id="demo-message"
								placeholder="Comentários da Mitigação" rows="6"></textarea>
						</div>
						<div class="col-12">
							<ul class="actions">
								<li><input type="submit" value="Enviar" class="primary" /></li>
								<li><input type="reset" value="Limpar" /></li>
							</ul>
							${message}
						</div>
					</div>
				</form>
			</div>
		</section>

	</div>

	<!-- Footer -->
	<footer id="footer" class="wrapper style1-alt">
		<div class="inner">
			<ul class="menu">
				<li>&copy; Trabalho de analise.</li>
				<li>Integrantes : Arihel Secron, Filippo Maio e Sidney Alves</li>
			</ul>
		</div>
	</footer>

	<!-- Scripts -->
	<script src="assets/js/jquery.min.js"></script>
	<script src="assets/js/jquery.scrollex.min.js"></script>
	<script src="assets/js/jquery.scrolly.min.js"></script>
	<script src="assets/js/browser.min.js"></script>
	<script src="assets/js/breakpoints.min.js"></script>
	<script src="assets/js/util.js"></script>
	<script src="assets/js/main.js"></script>

</body>
</html>