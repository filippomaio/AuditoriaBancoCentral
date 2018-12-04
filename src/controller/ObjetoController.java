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
@WebServlet("/Objeto.do")
public class ObjetoController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Objeto objeto;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ObjetoController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String acao = request.getParameter("acao");
		int idObjeto = Integer.parseInt(request.getParameter("idObjeto"));
		if (acao.equals("editar")){
			//editarObjeto(idObjeto,request,response);
		}else if (acao.equals("remover")){
			//removerObjeto(idObjeto,request,response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String acao = request.getParameter("acao");
		if (acao.equals("cadastrar")){
			cadastrarObjeto(request,response);
		}
		if (acao.equals("associar")) {
			associarObjetoRisco(request,response);
		}
	}
	
	protected void cadastrarObjeto(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession sessao = request.getSession();
		LoginController usuario = (LoginController)sessao.getAttribute("usuario");
		objeto = new Objeto(usuario.getCn());
        
        String nome = request.getParameter("nome");
        String descricao = request.getParameter("descricao");
        int idProcesso = Integer.parseInt(request.getParameter("idProcesso"));
        
        if (!hasObjeto(nome,sessao)) {        	
        	objeto.createObjeto(nome, descricao, idProcesso);
        	request.setAttribute("message", "Objeto cadastrado com sucesso!");
        	carregarObjetos(request);
            request.getRequestDispatcher("CadastrarObjeto.jsp").forward(request, response);
        }else {
        	request.setAttribute("message", "Objeto já existe");
            request.getRequestDispatcher("CadastrarObjeto.jsp").forward(request, response);
        }
	}
	
	public void carregarObjetos(HttpServletRequest request) {
		HttpSession sessao = request.getSession();
		LoginController usuario = (LoginController)sessao.getAttribute("usuario");
		List<Objeto> objetos = new ArrayList<Objeto>();
		objeto = new Objeto(usuario.getCn());
		objetos = objeto.getObjetos();
		ArrayList<String> idObjetos = new ArrayList<>();
		ArrayList<String> nomeObjetos = new ArrayList<>();
		ArrayList<String> descricaoObjetos = new ArrayList<>();
		ArrayList<String> idProcessoObjetos = new ArrayList<>();
		for(int i=0;i<objetos.size();i++) {
			idObjetos.add(Integer.toString(objetos.get(i).getIdObjeto()));
			nomeObjetos.add(objetos.get(i).getNome());
			descricaoObjetos.add(objetos.get(i).getDescricao());
			idProcessoObjetos.add(Integer.toString(objetos.get(i).getIdProcesso()));
		}
		sessao.setAttribute("idObjetos", idObjetos);
		sessao.setAttribute("nomeObjetos", nomeObjetos);
		sessao.setAttribute("descricaoObjetos", descricaoObjetos);
		sessao.setAttribute("idProcessoObjetos", idProcessoObjetos);
	}
	
	public void carregarObjetosRisco(HttpServletRequest request) {
		HttpSession sessao = request.getSession();
		LoginController usuario = (LoginController)sessao.getAttribute("usuario");
		List<Objeto> objetos = new ArrayList<Objeto>();
		objeto = new Objeto(usuario.getCn());
		objetos = objeto.getObjetosRisco();
		ArrayList<String> idObjetosRiscos = new ArrayList<>();
		ArrayList<String> idObjetos = new ArrayList<>();
		ArrayList<String> nomeObjetos = new ArrayList<>();
		ArrayList<String> descricaoObjetos = new ArrayList<>();
		ArrayList<String> idProcessoObjetos = new ArrayList<>();
		for(int i=0;i<objetos.size();i++) {
			idObjetosRiscos.add(Integer.toString(objetos.get(i).getIdObjetoRisco()));
			idObjetos.add(Integer.toString(objetos.get(i).getIdObjeto()));
			nomeObjetos.add(objetos.get(i).getNome());
			descricaoObjetos.add(objetos.get(i).getDescricao());
			idProcessoObjetos.add(Integer.toString(objetos.get(i).getIdProcesso()));
		}
		sessao.setAttribute("idObjetosObjetosRiscos", idObjetosRiscos);
		sessao.setAttribute("idObjetosRiscos", idObjetos);
		sessao.setAttribute("nomeObjetosRiscos", nomeObjetos);
		sessao.setAttribute("descricaoObjetosRiscos", descricaoObjetos);
		sessao.setAttribute("idProcessoObjetosRiscos", idProcessoObjetos);
	}
	
	protected void associarObjetoRisco(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession sessao = request.getSession();
		LoginController usuario = (LoginController)sessao.getAttribute("usuario");
		objeto = new Objeto(usuario.getCn());
        		
		int idObjeto = Integer.parseInt(request.getParameter("selectIdObjeto"));
		int idRisco = Integer.parseInt(request.getParameter("selectIdRisco"));
        
		if (!hasObjetoRisco(idObjeto, idRisco, sessao)) {        	
			objeto.associateObjetoRisco(idObjeto, idRisco);
			request.setAttribute("message", "Objeto e Risco associado com sucesso!");
			carregarObjetos(request);
			carregarObjetosRisco(request);

			//Carregar Listas
			ProcessoController processo = new ProcessoController();
			processo.carregarProcessos(request);
			
			carregarObjetos(request);
			carregarObjetosRisco(request);
			
			RiscoController risco = new RiscoController();
			risco.carregarRiscos(request);
			risco.carregarObjetoRiscos(request);			
			risco.carregarMatrizRisco(request, response);
			
			MitigacaoController mitigacao = new MitigacaoController();
			mitigacao.carregarMitigacoes(request);
			mitigacao.carregarObjetosRiscosMitigacoes(request);
			mitigacao.carregarMatrizControle(request, response);
			
			
            request.getRequestDispatcher("AssociarObjetoRisco.jsp").forward(request, response);
        }else {
        	request.setAttribute("message", "Objeto já está associado com esse Risco");
            request.getRequestDispatcher("AssociarObjetoRisco.jsp").forward(request, response);
        }		
		
	}
	
	public boolean hasObjeto(String nome, HttpSession sessao) {
		LoginController usuario = (LoginController)sessao.getAttribute("usuario");
        objeto = new Objeto(usuario.getCn());
        if(objeto.readObjeto(nome) != null) {
        	return true;
        }
        return false;
	}
	
	public boolean hasObjetoRisco(int idObjeto, int idRisco, HttpSession sessao) {
		LoginController usuario = (LoginController)sessao.getAttribute("usuario");
        objeto = new Objeto(usuario.getCn());
        if(objeto.readObjetoRisco(idObjeto,idRisco) != null) {
        	return true;
        }
        return false;
	}
	
	public String getNome() {
		return objeto.getNome();
	}

}
