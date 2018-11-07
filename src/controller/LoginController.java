package controller;

import model.*;
import view.*;
import java.sql.Connection;
import java.sql.SQLException;

public class LoginController {
    private String login;
    private String senha;
    private Login sessao;
    
    private LoginView loginView;
    //private MenuView menuView;
    
    public LoginController(){
        sessao = new Login();
        conectar();
        ProcessoController processo = new ProcessoController(sessao.getCn());
        RiscoController risco = new RiscoController(sessao.getCn());
        MitigacaoController mitigacao = new MitigacaoController(sessao.getCn());
        
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
            //loginView.setVisible(false);
            //menuView.show();
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
