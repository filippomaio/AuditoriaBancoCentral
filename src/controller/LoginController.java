package controller;

import java.io.IOException;
import java.sql.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.*;

/**
 * Servlet implementation class LoginView
 */
@WebServlet("/Login.do")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Login usuario;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginController() {
        super();
        usuario = new Login();
        usuario.conectar("localhost");
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession sessao  = request.getSession();
	    sessao.removeAttribute("usuario");
	    response.sendRedirect("login.jsp");		    	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html;charset=UTF-8");
        String login = request.getParameter("login");
        String senha = request.getParameter("senha");

		if (usuario.logar(login, senha)) {
			HttpSession sessao = request.getSession();
            sessao.setAttribute("usuario", this);
			request.setAttribute("usuario", this);
			
			//Carregar Listas
			ProcessoController processo = new ProcessoController();
			processo.carregarProcessos(request);
			ObjetoController objeto = new ObjetoController();
			objeto.carregarObjetos(request);
			RiscoController risco = new RiscoController();
			risco.carregarRiscos(request);
			MitigacaoController mitigacao = new MitigacaoController();
			mitigacao.carregarMitigacoes(request);
			
			request.getRequestDispatcher("Home.jsp").forward(request,response);
        }else {
        	request.setAttribute("message", "Login e/ou Senha inválidos");
            request.getRequestDispatcher("Login.jsp").forward(request, response);
        }

	}
	
	public Connection getCn() {
		return usuario.getCn();
	}
	
	public String getNome() {
		return usuario.getLogin();
	}
	
	public int getCargo() {
		return usuario.getCargo();
	}

}
