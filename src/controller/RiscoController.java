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
		int idRisco = Integer.parseInt(request.getParameter("idRisco"));
		if (acao.equals("editar")){
			//editarRisco(idRisco,request,response);
		}else if (acao.equals("remover")){
			//removerRisco(idRisco,request,response);
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
		if (acao.equals("matriz")){
			matrizRisco(request,response);
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
	
	public void matrizRisco(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		HttpSession sessao = request.getSession();
		
		sessao.setAttribute("d11", separarMatriz(1, 1, request));
		sessao.setAttribute("d12", separarMatriz(1, 2, request));
		sessao.setAttribute("d13", separarMatriz(1, 3, request));
		sessao.setAttribute("d21", separarMatriz(2, 1, request));
		sessao.setAttribute("d22", separarMatriz(2, 2, request));
		sessao.setAttribute("d23", separarMatriz(2, 3, request));
		sessao.setAttribute("d31", separarMatriz(3, 1, request));
		sessao.setAttribute("d32", separarMatriz(3, 2, request));
		sessao.setAttribute("d33", separarMatriz(3, 3, request));
	    
		request.getRequestDispatcher("Matriz1.jsp").forward(request, response);
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
	
	public String getNome() {
		return risco.getNome();
	}

	public int getCodigo() {
		return risco.getCodigo();
	}
}
