<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE HTML>

<html lang="pt-br">
	<head>
		<title>Login</title>
		<meta charset="utf-8" />
		<meta name="viewport" content="width=device-width, initial-scale=1, user-scalable=no" />
		<link rel="stylesheet" href="assets/css/main.css" />
		<noscript><link rel="stylesheet" href="assets/css/noscript.css" /></noscript>
	</head>
	<body class="is-preload">


		<!-- Wrapper -->
			<div id="wrapper">

				<!-- Main -->
					<section id="main" class="wrapper">
						<div class="inner">
							<h2>Login</h2>
									<form method="post" action="Login.do">
										<div class="row gtr-uniform">
											<div class="fields">
												<input type="text" name="login" id="demo-name" value="" placeholder="Nome" />
											</div>
											<div class="fields">
												<input type="password" name="senha" id="demo-email" value="" placeholder="Senha" />
											</div>
											<div class="col-12">
												<ul class="actions">
													<li><input type="submit" value="Entrar" class="primary" /></li>
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