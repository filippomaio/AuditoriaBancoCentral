<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.List" %> 
<!DOCTYPE HTML>

<html lang="pt-br">
	<head>
		<title>Processos</title>
		<meta charset="utf-8" />
		<meta name="viewport" content="width=device-width, initial-scale=1, user-scalable=no" />
		<link rel="stylesheet" href="assets/css/main.css" />
		<noscript><link rel="stylesheet" href="assets/css/noscript.css" /></noscript>
	</head>
	<body class="is-preload">

		<!-- Header -->
			<header id="header">
				<a href="index.html" class="title">Processos</a>
				<nav>
					<ul>
						<li><a href="Home.jsp">Home</a></li>
					</ul>
				</nav>
			</header>

		<!-- Wrapper -->
			<div id="wrapper">

				<!-- Main -->
						<section>
									<h2>Processos</h2>
									<div class="table-wrapper">
										<table>
											<thead>
												<tr>
													<th>Id</th>
													<th>Nome</th>
													<th>Descrição</th>
													<th>Editar</th>
													<th>Remover</th>
												</tr>
											</thead>
											<tbody>
											<%
											List listaIdProcesso = (List)session.getAttribute("idProcessos");
											List listaNomeProcesso = (List)session.getAttribute("nomeProcessos");
											List listaDescricaoProcesso = (List)session.getAttribute("descricaoProcessos");
											for(int i = 0; i < listaIdProcesso.size(); i++) {
												String idProcesso = listaIdProcesso.get(i).toString();
												String nomeProcesso = listaNomeProcesso.get(i).toString();
												String descricaoProcesso = listaDescricaoProcesso.get(i).toString();
 											%>
 											<tr>
 												<td><%=idProcesso%></td>
                  								<td><%=nomeProcesso%></td>
                  								<td><%=descricaoProcesso%></td>
                  								<td><button type="button" class="btn btn-secondary"><a href="Processo.do?acao=editar&idProcesso=<%=idProcesso%>">Editar</a></button></td> 
                  								<td><button type="button" class="btn btn-secondary"><a href="Processo.do?acao=remover&idProcesso=<%=idProcesso%>">Remover</a></button></td> 
                  							</tr>															
 											<% } //fecha for
											%>
											</tbody>
										</table>
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