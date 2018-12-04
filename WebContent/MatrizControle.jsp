<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.List" %> 
<!DOCTYPE HTML>

<html lang="pt-br">
	<head>
		<title>Matriz de Controle</title>
		<meta charset="utf-8" />
		<meta name="viewport" content="width=device-width, initial-scale=1, user-scalable=no" />
		<link rel="stylesheet" href="assets/css/main.css" />
		<link rel="stylesheet" href="assets/css/style.css" />
		<noscript><link rel="stylesheet" href="assets/css/noscript.css" /></noscript>
	</head>
	<body class="is-preload">

		<!-- Header -->
			<header id="header">
				<a href="Home.jsp" class="title">Matriz de Controle</a>
				<nav>
					<ul>
						<li><a href="Home.jsp">Home</a></li>
					</ul>
				</nav>
			</header>

			<h1 style="text-align: center; margin: 0px;">Matriz de Controle</h1>
		<!-- Wrapper -->
			<div id="wrapper" class="wrapper">
				<h2 class="impactoText">Ranking do Risco</h2>
				<!-- Main -->
					<section id="main" class="wrapper matriz">
						<!-- Linha 5 -->
						<div class="itemMatriz m15">
							<%
								List lista15 = (List)session.getAttribute("b15");
											for(int i = 0; i < lista15.size(); i++) {
												String idObjeto = lista15.get(i).toString();
 											%>
 											<a href="Objeto.do?acao=editar&idObjeto=<%=idObjeto%>"><%=idObjeto%></a>															
 											<% } //fecha for
											%>
						</div>
						<div class="itemMatriz m25">
							<%
								List lista25 = (List)session.getAttribute("b25");
											for(int i = 0; i < lista25.size(); i++) {
												String idObjeto = lista25.get(i).toString();
 											%>
 											<a href="Objeto.do?acao=editar&idObjeto=<%=idObjeto%>"><%=idObjeto%></a>															
 											<% } //fecha for
											%>
						</div>
						<div class="itemMatriz m35">
							<%
								List lista35 = (List)session.getAttribute("b35");
											for(int i = 0; i < lista35.size(); i++) {
												String idObjeto = lista35.get(i).toString();
 											%>
 											<a href="Objeto.do?acao=editar&idObjeto=<%=idObjeto%>"><%=idObjeto%></a>															
 											<% } //fecha for
											%>
						</div>
						<div class="itemMatriz m45">
							<%
								List lista45 = (List)session.getAttribute("b45");
											for(int i = 0; i < lista45.size(); i++) {
												String idObjeto = lista45.get(i).toString();
 											%>
 											<a href="Objeto.do?acao=editar&idObjeto=<%=idObjeto%>"><%=idObjeto%></a>															
 											<% } //fecha for
											%>
						</div>
						<div class="itemMatriz m55">
							<%
								List lista55 = (List)session.getAttribute("b55");
											for(int i = 0; i < lista55.size(); i++) {
												String idObjeto = lista55.get(i).toString();
 											%>
 											<a href="Objeto.do?acao=editar&idObjeto=<%=idObjeto%>"><%=idObjeto%></a>															
 											<% } //fecha for
											%>
						</div>

						<!-- Linha 4 -->
						<div class="itemMatriz m14">
							<%
								List lista14 = (List)session.getAttribute("b14");
											for(int i = 0; i < lista14.size(); i++) {
												String idObjeto = lista14.get(i).toString();
 											%>
 											<a href="Objeto.do?acao=editar&idObjeto=<%=idObjeto%>"><%=idObjeto%></a>															
 											<% } //fecha for
											%>
						</div>
						<div class="itemMatriz m24">
							<%
								List lista24 = (List)session.getAttribute("b24");
											for(int i = 0; i < lista24.size(); i++) {
												String idObjeto = lista24.get(i).toString();
 											%>
 											<a href="Objeto.do?acao=editar&idObjeto=<%=idObjeto%>"><%=idObjeto%></a>															
 											<% } //fecha for
											%>
						</div>
						<div class="itemMatriz m34">
							<%
								List lista34 = (List)session.getAttribute("b34");
											for(int i = 0; i < lista34.size(); i++) {
												String idObjeto = lista34.get(i).toString();
 											%>
 											<a href="Objeto.do?acao=editar&idObjeto=<%=idObjeto%>"><%=idObjeto%></a>															
 											<% } //fecha for
											%>
						</div>
						<div class="itemMatriz m44">
							<%
								List lista44 = (List)session.getAttribute("b44");
											for(int i = 0; i < lista44.size(); i++) {
												String idObjeto = lista44.get(i).toString();
 											%>
 											<a href="Objeto.do?acao=editar&idObjeto=<%=idObjeto%>"><%=idObjeto%></a>															
 											<% } //fecha for
											%>
						</div>
						<div class="itemMatriz m54">
							<%
								List lista54 = (List)session.getAttribute("b54");
											for(int i = 0; i < lista54.size(); i++) {
												String idObjeto = lista54.get(i).toString();
 											%>
 											<a href="Objeto.do?acao=editar&idObjeto=<%=idObjeto%>"><%=idObjeto%></a>															
 											<% } //fecha for
											%>
						</div>

						<!-- Linha 3 -->
						<div class="itemMatriz m13">
							<%
								List lista13 = (List)session.getAttribute("b13");
											for(int i = 0; i < lista13.size(); i++) {
												String idObjeto = lista13.get(i).toString();
 											%>
 											<a href="Objeto.do?acao=editar&idObjeto=<%=idObjeto%>"><%=idObjeto%></a>															
 											<% } //fecha for
											%>
						</div>
						<div class="itemMatriz m23">
							<%
								List lista23 = (List)session.getAttribute("b23");
											for(int i = 0; i < lista23.size(); i++) {
												String idObjeto = lista23.get(i).toString();
 											%>
 											<a href="Objeto.do?acao=editar&idObjeto=<%=idObjeto%>"><%=idObjeto%></a>															
 											<% } //fecha for
											%>
						</div>
						<div class="itemMatriz m33">
							<%
								List lista33 = (List)session.getAttribute("b33");
											for(int i = 0; i < lista33.size(); i++) {
												String idObjeto = lista33.get(i).toString();
 											%>
 											<a href="Objeto.do?acao=editar&idObjeto=<%=idObjeto%>"><%=idObjeto%></a>															
 											<% } //fecha for
											%>
						</div>
						<div class="itemMatriz m43">
							<%
								List lista43 = (List)session.getAttribute("b43");
											for(int i = 0; i < lista43.size(); i++) {
												String idObjeto = lista43.get(i).toString();
 											%>
 											<a href="Objeto.do?acao=editar&idObjeto=<%=idObjeto%>"><%=idObjeto%></a>															
 											<% } //fecha for
											%>
						</div>
						<div class="itemMatriz m53">
							<%
								List lista53 = (List)session.getAttribute("b53");
											for(int i = 0; i < lista53.size(); i++) {
												String idObjeto = lista53.get(i).toString();
 											%>
 											<a href="Objeto.do?acao=editar&idObjeto=<%=idObjeto%>"><%=idObjeto%></a>															
 											<% } //fecha for
											%>
						</div>

						<!-- Linha 2 -->
						<div class="itemMatriz m12">
							<%
								List lista12 = (List)session.getAttribute("b12");
											for(int i = 0; i < lista12.size(); i++) {
												String idObjeto = lista12.get(i).toString();
 											%>
 											<a href="Objeto.do?acao=editar&idObjeto=<%=idObjeto%>"><%=idObjeto%></a>															
 											<% } //fecha for
											%>
						</div>
						<div class="itemMatriz m22">
							<%
								List lista22 = (List)session.getAttribute("b22");
											for(int i = 0; i < lista22.size(); i++) {
												String idObjeto = lista22.get(i).toString();
 											%>
 											<a href="Objeto.do?acao=editar&idObjeto=<%=idObjeto%>"><%=idObjeto%></a>															
 											<% } //fecha for
											%>
						</div>
						<div class="itemMatriz m32">
							<%
								List lista32 = (List)session.getAttribute("b32");
											for(int i = 0; i < lista32.size(); i++) {
												String idObjeto = lista32.get(i).toString();
 											%>
 											<a href="Objeto.do?acao=editar&idObjeto=<%=idObjeto%>"><%=idObjeto%></a>															
 											<% } //fecha for
											%>
						</div>
						<div class="itemMatriz m42">
							<%
								List lista42 = (List)session.getAttribute("b42");
											for(int i = 0; i < lista42.size(); i++) {
												String idObjeto = lista42.get(i).toString();
 											%>
 											<a href="Objeto.do?acao=editar&idObjeto=<%=idObjeto%>"><%=idObjeto%></a>															
 											<% } //fecha for
											%>

						</div>
						<div class="itemMatriz m52">
							<%
								List lista52 = (List)session.getAttribute("b52");
											for(int i = 0; i < lista52.size(); i++) {
												String idObjeto = lista52.get(i).toString();
 											%>
 											<a href="Objeto.do?acao=editar&idObjeto=<%=idObjeto%>"><%=idObjeto%></a>															
 											<% } //fecha for
											%>
						</div>

						<!-- Linha 1 -->
						<div class="itemMatriz m11">
							<%
								List lista11 = (List)session.getAttribute("b11");
											for(int i = 0; i < lista11.size(); i++) {
												String idObjeto = lista11.get(i).toString();
 											%>
 											<a href="Objeto.do?acao=editar&idObjeto=<%=idObjeto%>"><%=idObjeto%></a>															
 											<% } //fecha for
											%>
						</div>
						<div class="itemMatriz m21">
							<%
								List lista21 = (List)session.getAttribute("b21");
											for(int i = 0; i < lista21.size(); i++) {
												String idObjeto = lista21.get(i).toString();
 											%>
 											<a href="Objeto.do?acao=editar&idObjeto=<%=idObjeto%>"><%=idObjeto%></a>															
 											<% } //fecha for
											%>
						</div>
						<div class="itemMatriz m31">
							<%
								List lista31 = (List)session.getAttribute("b31");
											for(int i = 0; i < lista31.size(); i++) {
												String idObjeto = lista31.get(i).toString();
 											%>
 											<a href="Objeto.do?acao=editar&idObjeto=<%=idObjeto%>"><%=idObjeto%></a>															
 											<% } //fecha for
											%>
						</div>
						<div class="itemMatriz m41">
							<%
								List lista41 = (List)session.getAttribute("b41");
											for(int i = 0; i < lista41.size(); i++) {
												String idObjeto = lista41.get(i).toString();
 											%>
 											<a href="Objeto.do?acao=editar&idObjeto=<%=idObjeto%>"><%=idObjeto%></a>															
 											<% } //fecha for
											%>
						</div>
						<div class="itemMatriz m51">
							<%
								List lista51 = (List)session.getAttribute("b51");
											for(int i = 0; i < lista51.size(); i++) {
												String idObjeto = lista51.get(i).toString();
 											%>
 											<a href="Objeto.do?acao=editar&idObjeto=<%=idObjeto%>"><%=idObjeto%></a>															
 											<% } //fecha for
											%>
						</div>

					</section>
			
			<h2 style="text-align: center; margin: 0px; padding: 0px;" >Eficacia do Controle</h2>
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