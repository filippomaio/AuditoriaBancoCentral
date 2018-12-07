<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.List" %>
<%if(session.getAttribute("cargo").toString().equals("2")){%> 
<%}else if(session.getAttribute("cargo").toString().equals("1")){%>
<%}else{%>
	<META http-equiv="refresh" content="1;URL=http://localhost:8080/AuditoriaBancoCentral/Login.jsp">
<%}%>
<!DOCTYPE HTML>

<html lang="pt-br">
	<head>
		<title>Mitigacao</title>
		<meta charset="utf-8" />
		<meta name="viewport" content="width=device-width, initial-scale=1, user-scalable=no" />
		<link rel="stylesheet" href="assets/css/main.css" />
		<noscript><link rel="stylesheet" href="assets/css/noscript.css" /></noscript>
	</head>
	<body class="is-preload">

		<!-- Header -->
			<header id="header">
				<a href="index.html" class="title">Mitigacao</a>
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
									<h2>Mitigacao</h2>
									<div class="table-wrapper">
										<table>
											<thead>
												<tr>
													<th>Id</th>
													<th>Nome</th>
													<th>Descrição</th>													
												</tr>
											</thead>
											<tbody>
											<%
											List listaIdMitigacao = (List)session.getAttribute("idMitigacoes");
											List listaNomeMitigacao = (List)session.getAttribute("nomeMitigacoes");
											List listaDescricaoMitigacao = (List)session.getAttribute("descricaoMitigacoes");
											for(int i = 0; i < listaIdMitigacao.size(); i++) {
												String idMitigacao = listaIdMitigacao.get(i).toString();												
												String nomeMitigacao = listaNomeMitigacao.get(i).toString();
												String descricaoMitigacao = listaDescricaoMitigacao.get(i).toString();
 											%>
 											<tr>
 												<td><%=idMitigacao%></td>
                  								<td><%=nomeMitigacao%></td>
                  								<td><%=descricaoMitigacao%></td>
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