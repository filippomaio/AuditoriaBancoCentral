package controller;

import model.*;
import view.*;

import java.sql.*;

public class LoginController {
	private String login;
    private String senha;
    private LoginModel sessao;
    
    private LoginView loginView;
    //private MenuView menuView;
    
    public LoginController(){
        sessao = new LoginModel();
        conectar();
        //ProcessoController processo = new ProcessoController(sessao.getCn());
        //RiscoController risco = new RiscoController(sessao.getCn());
        //MitigacaoController mitigacao = new MitigacaoController(sessao.getCn());
        
        loginView = new LoginView();
        
        //menuView = new MenuView(this);
        System.out.println("foi");
        
        //processo.desfazerProcessoRisco("alterado", 1);
        
        //loginView.show();
        
        
    }
    
    public Connection getCn(){
        return sessao.getCn();
    }
    
    public boolean conectar(){
        return sessao.conectar("localhost");
    }
    
    public boolean autenticar(String login, String senha){
        if(sessao.logar(login, senha)){
            //redirect
            return true;
        }else{
            //JOptionPane.showMessageDialog(null, "Login ou Senha incorretos!");
            return false;
        }
    }
    
    public boolean logoff(){
        //loginView.show();
        return sessao.desconectar();
        
    }
}
