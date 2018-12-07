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
@WebServlet("/Processo.do")
public class ProcessoController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Processo processo;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProcessoController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String acao = request.getParameter("acao");
		int idProcesso = Integer.parseInt(request.getParameter("idProcesso"));
		if (acao.equals("editar")){
			preencherProcesso(idProcesso,request,response);
		}else if (acao.equals("remover")){
			removerProcesso(idProcesso,request,response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String acao = request.getParameter("acao");
		if (acao.equals("cadastrar")){
			cadastrarProcesso(request,response);
		}else if (acao.equals("editar")){
			editarProcesso(request,response);
		}
	}
	
	protected void editarProcesso(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession sessao = request.getSession();
		LoginController usuario = (LoginController)sessao.getAttribute("usuario");
		processo = new Processo(usuario.getCn());
        
		int idProcesso = Integer.parseInt(request.getParameter("idProcesso"));
        String nome = request.getParameter("nome");
        String descricao = request.getParameter("descricao");
        
        if (!hasProcesso(nome,sessao)) {        	
        	processo.updateProcesso(nome, descricao, idProcesso);
        	request.setAttribute("message", "Processo editado com sucesso!");
        	carregarProcessos(request);
            request.getRequestDispatcher("GerenciarProcesso.jsp").forward(request, response);
        }else {
        	request.setAttribute("message", "Erro ao editar Processo");
            request.getRequestDispatcher("GerenciarProcesso.jsp").forward(request, response);
        }
	}
	
	protected void removerProcesso(int idProcesso, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession sessao = request.getSession();
		LoginController usuario = (LoginController)sessao.getAttribute("usuario");
		processo = new Processo(usuario.getCn());
		
		if(processo.readProcesso(idProcesso)!= null) {
			processo.deleteProcesso(idProcesso);
			request.setAttribute("message", "Processo removido com sucesso!");
			carregarProcessos(request);
			request.getRequestDispatcher("GerenciarProcesso.jsp").forward(request, response);
		}
	}
	
	protected void preencherProcesso(int idProcesso, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession sessao = request.getSession();
		LoginController usuario = (LoginController)sessao.getAttribute("usuario");
		processo = new Processo(usuario.getCn());
		
		if(processo.readProcesso(idProcesso)!= null) {
			sessao.setAttribute("idProcessoEditar", processo.getIdProcesso());
			sessao.setAttribute("nomeProcessoEditar", processo.getNome());
			sessao.setAttribute("descricaoProcessoEditar", processo.getDescricao());
            request.getRequestDispatcher("EditarProcesso.jsp").forward(request, response);
		}
	}
	
	protected void cadastrarProcesso(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession sessao = request.getSession();
		LoginController usuario = (LoginController)sessao.getAttribute("usuario");
		processo = new Processo(usuario.getCn());
        
        String nome = request.getParameter("nome");
        String descricao = request.getParameter("descricao");
        
        if (!hasProcesso(nome,sessao)) {        	
        	processo.createProcesso(nome, descricao);
        	request.setAttribute("message", "Processo cadastrado com sucesso!");
        	carregarProcessos(request);
            request.getRequestDispatcher("CadastrarProcesso.jsp").forward(request, response);
        }else {
        	request.setAttribute("message", "Processo já existe");
            request.getRequestDispatcher("CadastrarProcesso.jsp").forward(request, response);
        }
	}
	
	public boolean hasProcesso(String nome, HttpSession sessao) {
		LoginController usuario = (LoginController)sessao.getAttribute("usuario");
        processo = new Processo(usuario.getCn());
        if(processo.readProcesso(nome) != null) {
        	return true;
        }
        return false;
	}
	
	public void carregarProcessos(HttpServletRequest request) {
		HttpSession sessao = request.getSession();
		LoginController usuario = (LoginController)sessao.getAttribute("usuario");
		List<Processo> processos = new ArrayList<Processo>();
		processo = new Processo(usuario.getCn());
		processos = processo.getProcessos();
		ArrayList<String> idProcessos = new ArrayList<>();
		ArrayList<String> nomeProcessos = new ArrayList<>();
		ArrayList<String> descricaoProcessos = new ArrayList<>();
		for(int i=0;i<processos.size();i++) {
			idProcessos.add(Integer.toString(processos.get(i).getIdProcesso()));
			nomeProcessos.add(processos.get(i).getNome());
			descricaoProcessos.add(processos.get(i).getDescricao());
		}
		sessao.setAttribute("idProcessos", idProcessos);
		sessao.setAttribute("nomeProcessos", nomeProcessos);
		sessao.setAttribute("descricaoProcessos", descricaoProcessos);
		//System.out.println(nomeProcessos);
	}
	
	public String getNome() {
		return processo.getNome();
	}

}
