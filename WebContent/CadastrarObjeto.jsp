<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.List" %>    
<!DOCTYPE HTML>

<html lang="pt-br">
	<head>
		<title>Objetos</title>
		<meta charset="utf-8" />
		<meta name="viewport" content="width=device-width, initial-scale=1, user-scalable=no" />
		<link rel="stylesheet" href="assets/css/main.css" />
		<noscript><link rel="stylesheet" href="assets/css/noscript.css" /></noscript>
	</head>
	<body class="is-preload">

		<!-- Header -->
			<header id="header">
				<a href="index.html" class="title">Objetos</a>
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
							<h2>Cadastrar Objetos</h2>
									<form method="post" action="Objeto.do?acao=cadastrar">
										<div class="row gtr-uniform">
											<div class="col-6 col-12-xsmall">
												<input type="text" name="nome" id="demo-name" value="" placeholder="Nome" />
											</div>
											<div class="col-12">
												<textarea name="descricao" id="demo-message" placeholder="Descrição do Objeto" rows="6"></textarea>
											</div>
											<div class="col-12">
												<select name="idProcesso">
													<option value="">- Nome do Processo -</option>
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
												</select>
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
						<li>&copy; Trabalho de analise.</li><li>Integrantes : Arihel Secron, Filippo Maio e Sidney Alves</li>
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