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
						<section>
									<h2>Objetos</h2>
									<div class="table-wrapper">
										<table>
											<thead>
												<tr>
													<th>Id</th>
													<th>Nome</th>
													<th>Descrição</th>
													<th>Processo</th>
												</tr>
											</thead>
											<tbody>
											<%
											List listaIdObjeto = (List)session.getAttribute("idObjetos");
											List listaNomeObjeto = (List)session.getAttribute("nomeObjetos");
											List listaDescricaoObjeto = (List)session.getAttribute("descricaoObjetos");
											List listaIdProcessoObjeto = (List)session.getAttribute("idProcessoObjetos");
											
											List listaIdProcesso = (List)session.getAttribute("idProcessos");
											List listaNomeProcesso = (List)session.getAttribute("nomeProcessos");
											
											for(int i = 0; i < listaIdObjeto.size(); i++) {
												String idObjeto = listaIdObjeto.get(i).toString();
												String nomeObjeto = listaNomeObjeto.get(i).toString();
												String descricaoObjeto = listaDescricaoObjeto.get(i).toString();
												String idProcessoObjeto = listaIdProcessoObjeto.get(i).toString();
												String nomeProcessoObjeto = "";
												for(int j = 0; j < listaIdProcesso.size(); j++){
													String idProcesso = listaIdProcesso.get(j).toString();
													String nomeProcesso = listaNomeProcesso.get(j).toString();													
													if (idProcessoObjeto.equals(idProcesso)){
														nomeProcessoObjeto = nomeProcesso;
													}
												}
 											%>
 											<tr>
 												<td><%=idObjeto%></td>
                  								<td><%=nomeObjeto%></td>
                  								<td><%=descricaoObjeto%></td>
                  								<td><%=nomeProcessoObjeto%></td>
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