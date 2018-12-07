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
@WebServlet("/Risco.do")
public class RiscoController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Risco risco;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RiscoController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String acao = request.getParameter("acao");
		int codigoRisco = Integer.parseInt(request.getParameter("codigoRisco"));
		//System.out.println(codigoRisco);
		if (acao.equals("editar")){
			preencherRisco(codigoRisco,request,response);
		}else if (acao.equals("remover")){
			removerRisco(codigoRisco,request,response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String acao = request.getParameter("acao");
		if (acao.equals("cadastrar")){
			cadastrarRisco(request,response);
		}
		if (acao.equals("editar")){
			editarRisco(request,response);
		}
	}
	
	protected void editarRisco(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession sessao = request.getSession();
		LoginController usuario = (LoginController)sessao.getAttribute("usuario");
		risco = new Risco(usuario.getCn());
        
		int codigoRisco = Integer.parseInt(request.getParameter("codigoRisco"));
        String nome = request.getParameter("nome");
        String descricao = request.getParameter("descricao");
        int impacto = Integer.parseInt(request.getParameter("impacto"));
        int probabilidade = Integer.parseInt(request.getParameter("probabilidade"));
        
        if (!hasRisco(nome,sessao)) {        	
        	risco.updateRisco(nome, descricao,impacto, probabilidade, codigoRisco);
        	request.setAttribute("message", "Risco editado com sucesso!");
        	usuario.carregarListas(request,response);
            request.getRequestDispatcher("GerenciarRisco.jsp").forward(request, response);
        }else {
        	request.setAttribute("message", "Erro ao editar Risco");
            request.getRequestDispatcher("GerenciarRisco.jsp").forward(request, response);
        }
	}
	
	protected void removerRisco(int codigoRisco, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession sessao = request.getSession();
		LoginController usuario = (LoginController)sessao.getAttribute("usuario");
		risco = new Risco(usuario.getCn());
		
		if(risco.readRisco(codigoRisco)!= null) {
			risco.deleteRisco(codigoRisco);
			request.setAttribute("message", "Risco removido com sucesso!");
			usuario.carregarListas(request,response);			
			request.getRequestDispatcher("GerenciarRisco.jsp").forward(request, response);
		}
	}
	
	protected void preencherRisco(int codigoRisco, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession sessao = request.getSession();
		LoginController usuario = (LoginController)sessao.getAttribute("usuario");
		risco = new Risco(usuario.getCn());
		
		if(risco.readRisco(codigoRisco)!= null) {
			sessao.setAttribute("idRiscoEditar", risco.getIdRisco());
			sessao.setAttribute("codigoRiscoEditar", risco.getCodigo());
			sessao.setAttribute("nomeRiscoEditar", risco.getNome());
			sessao.setAttribute("descricaoRiscoEditar", risco.getDescricao());
			sessao.setAttribute("impactoRiscoEditar", risco.getImpacto());
			sessao.setAttribute("probabilidadeRiscoEditar", risco.getProbabilidade());
            request.getRequestDispatcher("EditarRisco.jsp").forward(request, response);
		}
	}

	
	protected void cadastrarRisco(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession sessao = request.getSession();
		LoginController usuario = (LoginController)sessao.getAttribute("usuario");
		risco = new Risco(usuario.getCn());
        
		int codigo = Integer.parseInt(request.getParameter("codigo"));
        String nome = request.getParameter("nome");
        String descricao = request.getParameter("descricao");
        int impacto = Integer.parseInt(request.getParameter("impacto"));
        int probabilidade = Integer.parseInt(request.getParameter("probabilidade"));
        
        if (!hasRisco(nome,sessao)) {        	
        	risco.createRisco(codigo, nome, descricao, impacto, probabilidade);
        	request.setAttribute("message", "Risco cadastrado com sucesso!");
        	carregarRiscos(request);
        	carregarMatrizRisco(request,response);
            request.getRequestDispatcher("CadastrarRisco.jsp").forward(request, response);
        }else {
        	request.setAttribute("message", "Risco já existe");
            request.getRequestDispatcher("CadastrarRisco.jsp").forward(request, response);
        }
	}
	
	public boolean hasRisco(String nome, HttpSession sessao) {
		LoginController usuario = (LoginController)sessao.getAttribute("usuario");
        risco = new Risco(usuario.getCn());
        if(risco.readRisco(nome) != null) {
        	return true;
        }
        return false;
	}
	
	public void carregarMatrizRisco(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		HttpSession sessao = request.getSession();
		
		sessao.setAttribute("d11", separarMatriz(1, 1, request));
		sessao.setAttribute("d12", separarMatriz(1, 2, request));
		sessao.setAttribute("d13", separarMatriz(1, 3, request));
		sessao.setAttribute("d14", separarMatriz(1, 4, request));
		sessao.setAttribute("d15", separarMatriz(1, 5, request));
		sessao.setAttribute("d21", separarMatriz(2, 1, request));
		sessao.setAttribute("d22", separarMatriz(2, 2, request));
		sessao.setAttribute("d23", separarMatriz(2, 3, request));
		sessao.setAttribute("d24", separarMatriz(2, 4, request));
		sessao.setAttribute("d25", separarMatriz(2, 5, request));
		sessao.setAttribute("d31", separarMatriz(3, 1, request));
		sessao.setAttribute("d32", separarMatriz(3, 2, request));
		sessao.setAttribute("d33", separarMatriz(3, 3, request));
		sessao.setAttribute("d34", separarMatriz(3, 4, request));
		sessao.setAttribute("d35", separarMatriz(3, 5, request));
		sessao.setAttribute("d41", separarMatriz(4, 1, request));
		sessao.setAttribute("d42", separarMatriz(4, 2, request));
		sessao.setAttribute("d43", separarMatriz(4, 3, request));
		sessao.setAttribute("d44", separarMatriz(4, 4, request));
		sessao.setAttribute("d45", separarMatriz(4, 5, request));
		sessao.setAttribute("d51", separarMatriz(5, 1, request));
		sessao.setAttribute("d52", separarMatriz(5, 2, request));
		sessao.setAttribute("d53", separarMatriz(5, 3, request));
		sessao.setAttribute("d54", separarMatriz(5, 4, request));
		sessao.setAttribute("d55", separarMatriz(5, 5, request));
	    
		//request.getRequestDispatcher("Matriz1.jsp").forward(request, response);
	}
	
	protected ArrayList<String> separarMatriz(int imp, int pro, HttpServletRequest request){
		HttpSession sessao = request.getSession();
		LoginController usuario = (LoginController)sessao.getAttribute("usuario");
		risco = new Risco(usuario.getCn());
		List<Risco> riscos = new ArrayList<Risco>();
		riscos = risco.getRiscos(imp,pro);
		ArrayList<String> codigoRiscos = new ArrayList<>();
		for(int i=0;i<riscos.size();i++) {
			codigoRiscos.add(Integer.toString(riscos.get(i).getCodigo()));
		}
		return codigoRiscos;
	}
	
	public void carregarRiscos(HttpServletRequest request) {
		HttpSession sessao = request.getSession();
		LoginController usuario = (LoginController)sessao.getAttribute("usuario");
		List<Risco> riscos = new ArrayList<Risco>();
		risco = new Risco(usuario.getCn());
		riscos = risco.getRiscos();
		ArrayList<String> idRiscos = new ArrayList<>();
		ArrayList<String> codigoRiscos = new ArrayList<>();
		ArrayList<String> nomeRiscos = new ArrayList<>();
		ArrayList<String> descricaoRiscos = new ArrayList<>();
		ArrayList<String> impactoRiscos = new ArrayList<>();
		ArrayList<String> probabilidadeRiscos = new ArrayList<>();
		for(int i=0;i<riscos.size();i++) {
			idRiscos.add(Integer.toString(riscos.get(i).getIdRisco()));
			codigoRiscos.add(Integer.toString(riscos.get(i).getCodigo()));
			nomeRiscos.add(riscos.get(i).getNome());
			descricaoRiscos.add(riscos.get(i).getDescricao());
			impactoRiscos.add(Integer.toString(riscos.get(i).getImpacto()));
			probabilidadeRiscos.add(Integer.toString(riscos.get(i).getProbabilidade()));
		}
		sessao.setAttribute("idRiscos", idRiscos);
		sessao.setAttribute("codigoRiscos", codigoRiscos);
		sessao.setAttribute("nomeRiscos", nomeRiscos);
		sessao.setAttribute("descricaoRiscos", descricaoRiscos);
		sessao.setAttribute("impactoRiscos", impactoRiscos);
		sessao.setAttribute("probabilidadeRiscos", probabilidadeRiscos);
		//System.out.println(nomeRiscos);
	}
	
	public void carregarObjetoRiscos(HttpServletRequest request) {
		HttpSession sessao = request.getSession();
		LoginController usuario = (LoginController)sessao.getAttribute("usuario");
		List<Risco> riscos = new ArrayList<Risco>();
		risco = new Risco(usuario.getCn());
		riscos = risco.getObjetoRiscos();
		ArrayList<String> idRiscos = new ArrayList<>();
		ArrayList<String> codigoRiscos = new ArrayList<>();
		ArrayList<String> nomeRiscos = new ArrayList<>();
		ArrayList<String> descricaoRiscos = new ArrayList<>();
		ArrayList<String> impactoRiscos = new ArrayList<>();
		ArrayList<String> probabilidadeRiscos = new ArrayList<>();
		for(int i=0;i<riscos.size();i++) {
			idRiscos.add(Integer.toString(riscos.get(i).getIdRisco()));
			codigoRiscos.add(Integer.toString(riscos.get(i).getCodigo()));
			nomeRiscos.add(riscos.get(i).getNome());
			descricaoRiscos.add(riscos.get(i).getDescricao());
			impactoRiscos.add(Integer.toString(riscos.get(i).getImpacto()));
			probabilidadeRiscos.add(Integer.toString(riscos.get(i).getProbabilidade()));
		}
		sessao.setAttribute("idRiscosObjetos", idRiscos);
		sessao.setAttribute("codigoRiscosObjetos", codigoRiscos);
		sessao.setAttribute("nomeRiscosObjetos", nomeRiscos);
		sessao.setAttribute("descricaoRiscosObjetos", descricaoRiscos);
		sessao.setAttribute("impactoRiscosObjetos", impactoRiscos);
		sessao.setAttribute("probabilidadeRiscosObjetos", probabilidadeRiscos);
		//System.out.println(nomeRiscos);
	}

	
	public String getNome() {
		return risco.getNome();
	}

	public int getCodigo() {
		return risco.getCodigo();
	}
}
