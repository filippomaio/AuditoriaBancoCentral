<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%if(!session.getAttribute("cargo").toString().equals("1")){%>
	<META http-equiv="refresh" content="1;URL=http://localhost:8080/AuditoriaBancoCentral/Login.jsp"> 
<%}%>
<!DOCTYPE HTML>

<html lang="pt-br">
	<head>
		<title>Riscos</title>
		<meta charset="utf-8" />
		<meta name="viewport" content="width=device-width, initial-scale=1, user-scalable=no" />
		<link rel="stylesheet" href="assets/css/main.css" />
		<noscript><link rel="stylesheet" href="assets/css/noscript.css" /></noscript>
	</head>
	<body class="is-preload">

		<!-- Header -->
			<header id="header">
				<a href="index.html" class="title">Riscos</a>
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
							<h2>Cadastrar Riscos</h2>
									<form method="post" action="Risco.do?acao=cadastrar">
										<div class="row gtr-uniform">
											<div class="col-6 col-12-xsmall">
												<input type="text" name="nome" id="demo-name" value="" placeholder="Nome" />
											</div>
                                            <div class="col-6 col-12-xsmall">
												<input type="text" name="codigo" id="demo-codigo" value="" placeholder="Código do Risco" />
											</div>
											<div class="col-12">
												<textarea maxlenght="10" name="descricao" id="demo-message" placeholder="Descrição do Risco" rows="6"></textarea>
											</div>
                                            <div class="col-12">
												<select name="impacto" id="demo-category">
													<option value="">- Impacto -</option>
													<option value="1">Nulo</option>
													<option value="2">Baixo</option>
													<option value="3">Médio</option>
													<option value="4">Alto</option>
													<option value="5">Muito Alto</option>
												</select>
											</div>
                                            <div class="col-12">
												<select name="probabilidade" id="demo-category">
													<option value="">- Probabilidade -</option>
													<option value="1">Improvável</option>
													<option value="2">Baixa</option>
													<option value="3">Média</option>
													<option value="4">Alta</option>
													<option value="5">Muito Alta</option>
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