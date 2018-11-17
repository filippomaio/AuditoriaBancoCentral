package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Login {

    private String hostname;
    private Connection cn;
    @SuppressWarnings("unused")
	private Statement stmt;
    private String query;
    private ResultSet rs;
    private PreparedStatement ps;
    
    private String login;
    @SuppressWarnings("unused")
	private String senha;
    private int cargo;
    
    
    
    public boolean conectar(String hostname){
        try{
           Class.forName("com.mysql.jdbc.Driver");
           this.hostname = hostname;
           String address = "jdbc:mysql://"+this.hostname+":3306";
           
           this.cn = DriverManager.getConnection(address, "root", "");
           this.stmt = this.getCn().createStatement();
           
           System.out.println("Conectou no banco");
           System.out.println(cn);
           
           return true;
           
        }catch(ClassNotFoundException | SQLException e){
            System.out.println("Erro: "+ e);
        }
        return false;
        
        
    }
    
    public boolean desconectar(){
        try {
            getCn().close();
            ps.close();
            rs.close();
            return true;
        } catch (SQLException ex) {
            System.out.println("Erro ao desconectar");
        }
        
        return false;
    }
    
    
    public boolean logar(String login, String senha){
    
        query = "select * from auditoria.login where login=? and senha=?";
        
        try {
            ps = getCn().prepareStatement(query);
            ps.setString(1, login);
            ps.setString(2, senha);
            rs = ps.executeQuery();
            rs.next();
            this.login = rs.getString("login");
            this.senha = rs.getString("senha");
            this.cargo = rs.getInt("cargo");
            System.out.println("Login: " + rs.getString("login"));
            return true;
        } catch (SQLException ex) {
            System.out.println("Erro: " + ex);
        }

        return false;
    }    

    public Connection getCn() {
        return cn;
    }
    
    public String getLogin() {
    	return login;
    }
    
    public int getCargo() {
    	return cargo;
    }
}