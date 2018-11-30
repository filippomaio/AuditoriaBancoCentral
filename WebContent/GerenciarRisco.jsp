<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.List" %> 
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
						<section>
									<h2>Riscos</h2>
									<div class="table-wrapper">
										<table>
											<thead>
												<tr>
													<th>Codigo</th>
													<th>Nome</th>
													<th>Descri��o</th>
													<th>Impacto</th>
													<th>Probabilidade</th>
													<th>Editar</th>
													<th>Remover</th>
												</tr>
											</thead>
											<tbody>
											<%
											List listaIdRisco = (List)session.getAttribute("idRiscos");
											List listaCodigoRisco = (List)session.getAttribute("codigoRiscos");
											List listaNomeRisco = (List)session.getAttribute("nomeRiscos");
											List listaDescricaoRisco = (List)session.getAttribute("descricaoRiscos");
											List listaImpactoRisco = (List)session.getAttribute("impactoRiscos");
											List listaProbabilidadeRisco = (List)session.getAttribute("probabilidadeRiscos");
											for(int i = 0; i < listaIdRisco.size(); i++) {
												String idRisco = listaIdRisco.get(i).toString();
												String codigoRisco = listaIdRisco.get(i).toString();
												String nomeRisco = listaNomeRisco.get(i).toString();
												String descricaoRisco = listaDescricaoRisco.get(i).toString();
												String impactoRisco = listaImpactoRisco.get(i).toString();
												String probabilidadeRisco = listaProbabilidadeRisco.get(i).toString();
 											%>
 											<tr>
 												<td><%=codigoRisco%></td>
                  								<td><%=nomeRisco%></td>
                  								<td><%=descricaoRisco%></td>
                  								<td><%=impactoRisco%></td>
                  								<td><%=probabilidadeRisco%></td>
                  								<td><button type="button" class="btn btn-secondary"><a href="Risco.do?acao=editar&idRisco=<%=idRisco%>">Editar</a></button></td> 
                  								<td><button type="button" class="btn btn-secondary"><a href="Risco.do?acao=remover&idRisco=<%=idRisco%>">Remover</a></button></td> 
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