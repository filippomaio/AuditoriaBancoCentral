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
		String acao = request.getParameter("acao");
		int idMitigacao = Integer.parseInt(request.getParameter("idMitigacao"));
		if (acao.equals("editar")){
			preencherMitigacao(idMitigacao,request,response);
		}else if (acao.equals("remover")){
			removerMitigacao(idMitigacao,request,response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String acao = request.getParameter("acao");
		if (acao.equals("cadastrar")){
			cadastrarMitigacao(request,response);
		}else if (acao.equals("associar")){
			associarMitigacao(request,response);
		}else if (acao.equals("auditar")){
			auditarMitigacao(request,response);
		}else if (acao.equals("editar")){
			editarMitigacao(request,response);
		}
	}
	
	protected void editarMitigacao(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession sessao = request.getSession();
		LoginController usuario = (LoginController)sessao.getAttribute("usuario");
		mitigacao = new Mitigacao(usuario.getCn());
        
		int idMitigacao = Integer.parseInt(request.getParameter("idMitigacao"));
        String nome = request.getParameter("nome");
        String descricao = request.getParameter("descricao");
        
        if (!hasMitigacao(nome,sessao)) {        	
        	mitigacao.updateMitigacao(nome, descricao, idMitigacao);
        	request.setAttribute("message", "Mitigacao editado com sucesso!");
        	usuario.carregarListas(request,response);
            request.getRequestDispatcher("GerenciarMitigacao.jsp").forward(request, response);
        }else {
        	request.setAttribute("message", "Erro ao editar Mitigacao");
            request.getRequestDispatcher("GerenciarMitigacao.jsp").forward(request, response);
        }
	}
	
	protected void removerMitigacao(int idMitigacao, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession sessao = request.getSession();
		LoginController usuario = (LoginController)sessao.getAttribute("usuario");
		mitigacao = new Mitigacao(usuario.getCn());
		
		if(mitigacao.readMitigacao(idMitigacao)!= null) {
			mitigacao.deleteMitigacao(idMitigacao);
			request.setAttribute("message", "Mitigacao removido com sucesso!");
			usuario.carregarListas(request,response);
			request.getRequestDispatcher("GerenciarMitigacao.jsp").forward(request, response);
		}
	}
	
	protected void preencherMitigacao(int idMitigacao, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession sessao = request.getSession();
		LoginController usuario = (LoginController)sessao.getAttribute("usuario");
		mitigacao = new Mitigacao(usuario.getCn());
		
		if(mitigacao.readMitigacao(idMitigacao)!= null) {
			sessao.setAttribute("idMitigacaoEditar", mitigacao.getIdMitigacao());
			sessao.setAttribute("nomeMitigacaoEditar", mitigacao.getNome());
			sessao.setAttribute("descricaoMitigacaoEditar", mitigacao.getDescricao());
            request.getRequestDispatcher("EditarMitigacao.jsp").forward(request, response);
		}
	}
	
	protected void auditarMitigacao(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession sessao = request.getSession();
		LoginController usuario = (LoginController)sessao.getAttribute("usuario");
		mitigacao = new Mitigacao(usuario.getCn());
        
        int idObjetoRiscoMitigacao = Integer.parseInt(request.getParameter("selectIdObjetoRiscoMitigacao"));
        String comentarios = request.getParameter("comentarios");
        int avaliacao = Integer.parseInt(request.getParameter("avaliacaoMitigacao"));
                	
        mitigacao.updateAssociateMitigacao(avaliacao, comentarios, idObjetoRiscoMitigacao);
        request.setAttribute("message", "Mitigacao cadastrada com sucesso!");
        carregarMitigacoes(request);
        carregarObjetosRiscosMitigacoes(request);
        request.getRequestDispatcher("AuditarMitigacao.jsp").forward(request, response);
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
			carregarMatrizControle(request, response);
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
	
	public boolean hasObjetoRiscoMitigacao(int idObjetoRisco, int idMitigacao, HttpSession sessao) {
		LoginController usuario = (LoginController)sessao.getAttribute("usuario");
		mitigacao = new Mitigacao(usuario.getCn());
        if(mitigacao.readObjetoMitigacao(idObjetoRisco, idMitigacao) != null) {
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
		ArrayList<String> descricaoMitigacoes = new ArrayList<>();
		for(int i=0;i<mitigacoes.size();i++) {
			idMitigacoes.add(Integer.toString(mitigacoes.get(i).getIdMitigacao()));
			nomeMitigacoes.add(mitigacoes.get(i).getNome());
			descricaoMitigacoes.add(mitigacoes.get(i).getDescricao());
		}
		sessao.setAttribute("idMitigacoes", idMitigacoes);
		sessao.setAttribute("nomeMitigacoes", nomeMitigacoes);
		sessao.setAttribute("descricaoMitigacoes", descricaoMitigacoes);
	}
	
	protected void associarMitigacao(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession sessao = request.getSession();
		LoginController usuario = (LoginController)sessao.getAttribute("usuario");
		mitigacao = new Mitigacao(usuario.getCn());
        		
		int idObjetoRisco = Integer.parseInt(request.getParameter("idObjetoRisco"));
		int idMitigacao = Integer.parseInt(request.getParameter("idMitigacao"));
        
		if (!hasObjetoRiscoMitigacao(idObjetoRisco, idMitigacao, sessao)) {        	
			mitigacao.associateMitigacao(idObjetoRisco, idMitigacao);
			request.setAttribute("message", "Mitigacao associada com sucesso!");
			carregarObjetosRiscosMitigacoes(request);
            request.getRequestDispatcher("AssociarObjetoRiscoMitigacao.jsp").forward(request, response);
        }else {
        	request.setAttribute("message", "Mitigacao já está associado com esse Objeto e Risco");
            request.getRequestDispatcher("AssociarObjetoRiscoMitigacao.jsp").forward(request, response);
        }		
		
	}
	
	public void carregarObjetosRiscosMitigacoes(HttpServletRequest request) {
		HttpSession sessao = request.getSession();
		LoginController usuario = (LoginController)sessao.getAttribute("usuario");
		List<Mitigacao> mitigacoes = new ArrayList<Mitigacao>();
		mitigacao = new Mitigacao(usuario.getCn());
		mitigacoes = mitigacao.getObjetosRiscosMitigacoes();
		ArrayList<String> idObjetosRiscosMitigacoes = new ArrayList<>();
		ArrayList<String> idObjetosRiscos = new ArrayList<>();
		ArrayList<String> idObjetos = new ArrayList<>();
		ArrayList<String> idRiscos = new ArrayList<>();
		ArrayList<String> idMitigacoes = new ArrayList<>();
		ArrayList<String> avaliacoes = new ArrayList<>();
		ArrayList<String> comentarios = new ArrayList<>();
		ArrayList<String> nomeMitigacoes = new ArrayList<>();
		ArrayList<String> nomeObjetos = new ArrayList<>();
		ArrayList<String> nomeRiscos = new ArrayList<>();
		
		for(int i=0;i<mitigacoes.size();i++) {
			idObjetosRiscosMitigacoes.add(Integer.toString(mitigacoes.get(i).getIdObjetoRiscoMitigacao()));
			idObjetosRiscos.add(Integer.toString(mitigacoes.get(i).getIdObjetoRisco()));
			idObjetos.add(Integer.toString(mitigacoes.get(i).getIdObjeto()));
			idRiscos.add(Integer.toString(mitigacoes.get(i).getIdRisco()));
			idMitigacoes.add(Integer.toString(mitigacoes.get(i).getIdMitigacao()));
			avaliacoes.add(Integer.toString(mitigacoes.get(i).getAvaliacao()));
			comentarios.add(mitigacoes.get(i).getComentarios());
			nomeMitigacoes.add(mitigacoes.get(i).getNome());
			nomeObjetos.add(mitigacoes.get(i).getNomeObjeto());
			nomeRiscos.add(mitigacoes.get(i).getNomeRisco());
		}
		sessao.setAttribute("idObjetosRiscosMitigacoesM", idObjetosRiscosMitigacoes);
		sessao.setAttribute("idObjetosRiscosM", idObjetosRiscos);
		sessao.setAttribute("idObjetosM", idObjetos);
		sessao.setAttribute("idRiscosM", idRiscos);
		
		sessao.setAttribute("avaliacoesM", avaliacoes);
		sessao.setAttribute("comentariosM", comentarios);
		
		sessao.setAttribute("nomeMitigacoesM", nomeMitigacoes);
		sessao.setAttribute("nomeObjetosM", nomeObjetos);
		sessao.setAttribute("nomeRiscosM", nomeRiscos);
		
		//System.out.println(avaliacoes);
	}
	
	public void carregarMatrizControle(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		HttpSession sessao = request.getSession();
		
		//Ranking
		
		sessao.setAttribute("b11", separarMatriz(1, 1, request));
		sessao.setAttribute("b12", separarMatriz(1, 2, request));
		sessao.setAttribute("b13", separarMatriz(1, 3, request));
		sessao.setAttribute("b14", separarMatriz(1, 4, request));
		sessao.setAttribute("b15", separarMatriz(1, 5, request));
		sessao.setAttribute("b21", separarMatriz(2, 1, request));
		sessao.setAttribute("b22", separarMatriz(2, 2, request));
		sessao.setAttribute("b23", separarMatriz(2, 3, request));
		sessao.setAttribute("b24", separarMatriz(2, 4, request));
		sessao.setAttribute("b25", separarMatriz(2, 5, request));
		sessao.setAttribute("b31", separarMatriz(3, 1, request));
		sessao.setAttribute("b32", separarMatriz(3, 2, request));
		sessao.setAttribute("b33", separarMatriz(3, 3, request));
		sessao.setAttribute("b34", separarMatriz(3, 4, request));
		sessao.setAttribute("b35", separarMatriz(3, 5, request));
		sessao.setAttribute("b41", separarMatriz(4, 1, request));
		sessao.setAttribute("b42", separarMatriz(4, 2, request));
		sessao.setAttribute("b43", separarMatriz(4, 3, request));
		sessao.setAttribute("b44", separarMatriz(4, 4, request));
		sessao.setAttribute("b45", separarMatriz(4, 5, request));
		sessao.setAttribute("b51", separarMatriz(5, 1, request));
		sessao.setAttribute("b52", separarMatriz(5, 2, request));
		sessao.setAttribute("b53", separarMatriz(5, 3, request));
		sessao.setAttribute("b54", separarMatriz(5, 4, request));
		sessao.setAttribute("b55", separarMatriz(5, 5, request));
	    
		//request.getRequestDispatcher("Matriz1.jsp").forward(request, response);
	}
	
	protected ArrayList<String> separarMatriz(int ranking, int avaliacao, HttpServletRequest request){
		HttpSession sessao = request.getSession();
		LoginController usuario = (LoginController)sessao.getAttribute("usuario");
		mitigacao = new Mitigacao(usuario.getCn());
		List<Mitigacao> mitigacoes = new ArrayList<Mitigacao>();
		mitigacoes = mitigacao.getObjetosRiscosMitigacoes();
		ArrayList<String> idObjetos = new ArrayList<>();
		
		int[][] ranks = { {1, 3, 4, 5, 5},
						  {1, 3, 4, 4, 5},
						  {1, 2, 3, 4, 5},
						  {1, 2, 3, 3, 4},
						  {1, 1, 2, 3 ,4}};
		
		for(int i=0;i<mitigacoes.size();i++) {
			if(mitigacoes.get(i).getAvaliacao() == avaliacao) {
				int x = mitigacoes.get(i).getProbabilidade()-1;
				int y = mitigacoes.get(i).getImpacto()-1;
				if(ranks[x][y] == ranking) {
					idObjetos.add(Integer.toString(mitigacoes.get(i).getIdObjeto()));
				}
			}
		}
		return idObjetos;
	}
	
	public String getNome() {
		return mitigacao.getNome();
	}

}
