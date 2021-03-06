<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%if(session.getAttribute("cargo").toString().equals("2")){%> 
<%}else if(session.getAttribute("cargo").toString().equals("1")){%>
<%}else{%>
	<META http-equiv="refresh" content="1;URL=http://localhost:8080/AuditoriaBancoCentral/Login.jsp">
<%}%>
<!DOCTYPE HTML>
<html lang="pt-br">
	<head>
		<title>Auditoria</title>
		<meta charset="utf-8" />
		<meta name="viewport" content="width=device-width, initial-scale=1, user-scalable=no" />
		<link rel="stylesheet" href="assets/css/main.css" />
		<noscript><link rel="stylesheet" href="assets/css/noscript.css" /></noscript>
	</head>
	<body class="is-preload">

		<!-- Sidebar -->
			<section id="sidebar">
				<div class="inner">
					<nav>
						<ul>
							<li><a href="#intro">Bem vindo!</a></li>
                            <li><a href="#one">Processos</a>
                            <li><a href="#onetwo">Objetos</a>
							<li><a href="#two">Riscos</a></li>
							<li><a href="#three">Mitiga��es</a></li>
                            <li><a href="#four">Paints</a></li>
						</ul>
					</nav>
				</div>
			</section>

		<!-- Wrapper -->
			<div id="wrapper">

				<!-- Intro -->
					<section id="intro" class="wrapper style1 fullscreen fade-up">
						<div class="inner">
							<h1>Bem vindo!</h1>
							<p>Aqui voc� pode fazer suas opera��es para a auditoria!<br/>
							</p>
							<ul class="actions">
								<li><a href="#one" class="button scrolly">Possiveis opera��es</a></li>
							</ul>
						</div>
					</section>

				<!-- One -->
					<section id="one" class="wrapper style2 spotlights">
						<section>
							<div class="content">
								<div class="inner">
									<h2>Processos</h2>
									<p>Opera��es envolvendo os processos</p>
									<ul class="actions">
										<li><a href="VisualizarProcesso.jsp" class="button">Visualizar</a>
											<%if(session.getAttribute("cargo").toString().equals("2")){ %>
                                            	<a href="CadastrarProcesso.jsp" class="button">Cadastrar</a>
                                            	<a href="GerenciarProcesso.jsp" class="button">Gerenciar</a>
                                        	<%}else{ %>
                                        		<a href="CadastrarProcesso.jsp" class="button disabled">Cadastrar</a>
                                           		<a href="GerenciarProcesso.jsp" class="button disabled">Gerenciar</a>
                                        	<%} %>
                                        </li>
									</ul>
								</div>
							</div>
						</section>
                        
						
                        <section id="onetwo" class="wrapper style2 spotlights">
							<div class="content">
								<div class="inner">
									<h2>Objetos</h2>
									<p>Opera��es envolvendo os Objetos</p>
									<ul class="actions">
										<li><a href="VisualizarObjeto.jsp" class="button">Visualizar</a>
											<%if(session.getAttribute("cargo").toString().equals("2")){ %>
                                            	<a href="CadastrarObjeto.jsp" class="button">Cadastrar</a>
                                            	<a href="GerenciarObjeto.jsp" class="button">Gerenciar</a>
                                            	<br><br>                                            
                                            	<a href="AssociarObjetoRisco.jsp" class="button">Associar Objeto - Risco</a>                                            
                                            	<a href="AssociarObjetoRiscoMitigacao.jsp" class="button">Associar Objeto - Risco - Mitigacao</a>
                                            <%}else{ %>
                                            	<a href="CadastrarObjeto.jsp" class="button disabled">Cadastrar</a>
                                            	<a href="GerenciarObjeto.jsp" class="button disabled">Gerenciar</a>
                                            	<br><br>                                            
                                            	<a href="AssociarObjetoRisco.jsp" class="button disabled">Associar Objeto - Risco</a>                                            
                                            	<a href="AssociarObjetoRiscoMitigacao.jsp" class="button disabled">Associar Objeto - Risco - Mitigacao</a>
                                            <%} %>
                                            
                                        </li>
									</ul>
								</div>
							</div>
						</section>
                        
                        <section id="two" class="wrapper style2 spotlights">
							<div class="content">
								<div class="inner">
									<h2>Riscos</h2>
									<p>Opera��es envolvendo os Riscos</p>
									<ul class="actions">
										<li><a href="VisualizarRisco.jsp" class="button">Visualizar</a>
											<%if(session.getAttribute("cargo").toString().equals("1")){ %>
                                            	<a href="CadastrarRisco.jsp" class="button">Cadastrar</a>
                                            	<a href="GerenciarRisco.jsp" class="button">Gerenciar</a>
                                            <%}else{ %>
                                            	<a href="CadastrarRisco.jsp" class="button disabled">Cadastrar</a>
                                            	<a href="GerenciarRisco.jsp" class="button disabled">Gerenciar</a>                                            
                                            <%} %>
                                        </li>
									</ul>
								</div>
							</div>
						</section>
						
                        <section id="three" class="wrapper style2 spotlights" >
							<div class="content">
								<div class="inner">
									<h2>Mitiga��es</h2>
									<p>Opera��es envolvendo as mitiga��es</p>
									<ul class="actions">
										<li><a href="VisualizarMitigacao.jsp" class="button">Visualizar</a>
											<%if(session.getAttribute("cargo").toString().equals("1")){ %>
                                            	<a href="CadastrarMitigacao.jsp" class="button disabled">Cadastrar</a>
                                            	<a href="GerenciarMitigacao.jsp" class="button disabled">Gerenciar</a>
                                            	<br>                                            
                                            	<a href="AuditarMitigacao.jsp" class="button">Auditar</a>
                                            <%}else if(session.getAttribute("cargo").toString().equals("2")){ %>
                                                <a href="CadastrarMitigacao.jsp" class="button">Cadastrar</a>
                                            	<a href="GerenciarMitigacao.jsp" class="button">Gerenciar</a>
                                            	<br>                                            
                                            	<a href="AuditarMitigacao.jsp" class="button disabled">Auditar</a>
                                            <%} %>
                                        </li>
									</ul>
								</div>
							</div>
						</section>
                        
                        <section id="four" class="wrapper style3 spotlights">
							<div class="content">
								<div class="inner">
									<h2>Paints</h2>
									<p>Acesso aos paints de controle</p>
									<ul class="actions">
										<li><a href="MatrizRisco.jsp" class="button">Matriz de Risco</a>
                                            <a href="MatrizControle.jsp" class="button">Matriz Hiato de Controle</a>
                                        </li>
									</ul>
								</div>
							</div>
						</section>
					</section>

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