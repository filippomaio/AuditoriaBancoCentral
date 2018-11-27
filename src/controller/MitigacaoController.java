package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.*;

/**
 * Servlet implementation class ProcessoController
 */
@WebServlet("/Mitigacao.do")
public class MitigacaoController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Mitigacao mitigacao;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MitigacaoController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String acao = request.getParameter("acao");
		if (acao.equals("cadastrar")){
			cadastrarMitigacao(request,response);
		}
	}
	
	protected void cadastrarMitigacao(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession sessao = request.getSession();
		LoginController usuario = (LoginController)sessao.getAttribute("usuario");
		mitigacao = new Mitigacao(usuario.getCn());
        
        String nome = request.getParameter("nome");
        String descricao = request.getParameter("descricao");
        
        if (!hasMitigacao(nome,sessao)) {        	
        	mitigacao.createMitigacao(nome, descricao);
        	request.setAttribute("message", "Mitigacao cadastrada com sucesso!");
        	carregarMitigacoes(request);
            request.getRequestDispatcher("CadastrarMitigacao.jsp").forward(request, response);
        }else {
        	request.setAttribute("message", "Mitigacao já existe");
            request.getRequestDispatcher("CadastrarMitigacao.jsp").forward(request, response);
        }
	}
	
	public boolean hasMitigacao(String nome, HttpSession sessao) {
		LoginController usuario = (LoginController)sessao.getAttribute("usuario");
		mitigacao = new Mitigacao(usuario.getCn());
        if(mitigacao.readMitigacao(nome) != null) {
        	return true;
        }
        return false;
	}
	
	public void carregarMitigacoes(HttpServletRequest request) {
		HttpSession sessao = request.getSession();
		LoginController usuario = (LoginController)sessao.getAttribute("usuario");
		List<Mitigacao> mitigacoes = new ArrayList<Mitigacao>();
		mitigacao = new Mitigacao(usuario.getCn());
		mitigacoes = mitigacao.getMitigacoes();
		ArrayList<String> idMitigacoes = new ArrayList<>();
		ArrayList<String> nomeMitigacoes = new ArrayList<>();
		for(int i=0;i<mitigacoes.size();i++) {
			idMitigacoes.add(Integer.toString(mitigacoes.get(i).getIdMitigacao()));
			nomeMitigacoes.add(mitigacoes.get(i).getNome());
		}
		sessao.setAttribute("idMitigacoes", idMitigacoes);
		sessao.setAttribute("nomeMitigacoes", nomeMitigacoes);
	}
	
	public String getNome() {
		return mitigacao.getNome();
	}

}
