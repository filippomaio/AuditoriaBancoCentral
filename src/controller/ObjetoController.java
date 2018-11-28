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
	
	protected void associarObjetoRisco(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession sessao = request.getSession();
		LoginController usuario = (LoginController)sessao.getAttribute("usuario");
		objeto = new Objeto(usuario.getCn());
        		
		int idObjeto = Integer.parseInt(request.getParameter("idObjeto"));
		int idRisco = Integer.parseInt(request.getParameter("idRisco"));
        
		if (!hasObjetoRisco(idObjeto, idRisco, sessao)) {        	
			objeto.associateObjetoRisco(idObjeto, idRisco);
			request.setAttribute("message", "Objeto e Risco associado com sucesso!");
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
        if(objeto.readObjetoRisco(idObjeto,idRisco)) {
        	return true;
        }
        return false;
	}
	
	public String getNome() {
		return objeto.getNome();
	}

}
