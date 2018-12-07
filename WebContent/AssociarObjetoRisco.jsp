<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.List"%>
<%if(!session.getAttribute("cargo").toString().equals("2")){%>
	<META http-equiv="refresh" content="1;URL=http://localhost:8080/AuditoriaBancoCentral/Login.jsp"> 
<%}%>
<!DOCTYPE HTML>

<html lang="pt-br">
<head>
<title>Associar Objeto e Risco</title>
<meta charset="utf-8" />
<meta name="viewport"
	content="width=device-width, initial-scale=1, user-scalable=no" />
<link rel="stylesheet" href="assets/css/main.css" />
<link rel="stylesheet" href="assets/css/style.css" />
<noscript>
	<link rel="stylesheet" href="assets/css/noscript.css" />
</noscript>
</head>
<body class="is-preload">

	<!-- Header -->
	<header id="header">
		<a href="Home.jsp" class="title">Associar Objeto e Risco</a>
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
				<h2>Associar Objeto e Risco</h2>
				<form action="Objeto.do?acao=associar" method="POST">
					<div class="row gtr-uniform">
						<div class="col-12">
							<select name="selectIdObjeto" id="demo-category">
								<option value="">- Objeto -</option>
								<%
									List lista1 = (List) session.getAttribute("idObjetos");
									List lista2 = (List) session.getAttribute("nomeObjetos");
									for (int i = 0; i < lista1.size(); i++) {
										String idObjeto = lista1.get(i).toString();
										String nomeObjeto = lista2.get(i).toString();
								%>
								<option value=<%=idObjeto%>><%=idObjeto%> -
									<%=nomeObjeto%>
								</option>
								<%
									} //fecha for
								%>
							</select>
						</div>
						<div class="col-12">
							<select name="selectIdRisco" id="demo-category">
								<option value="">- Risco -</option>
								<%
									List lista3 = (List) session.getAttribute("idRiscos");
									List lista4 = (List) session.getAttribute("nomeRiscos");
									List lista5 = (List) session.getAttribute("codigoRiscos");
									for (int i = 0; i < lista3.size(); i++) {
										String idRisco = lista3.get(i).toString();
										String nomeRisco = lista4.get(i).toString();
										String codigoRisco = lista5.get(i).toString();
								%>
								<option value=<%=idRisco%>><%=codigoRisco%> -
									<%=nomeRisco%>
								</option>
								<%
									} //fecha for
								%>
							</select>
						</div>
						<div class="col-12">
							<ul class="actions">
								<li><input type="submit" value="Associar" class="button"
									name="btnAssociar"></li>
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