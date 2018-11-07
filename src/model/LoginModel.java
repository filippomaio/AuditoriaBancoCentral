package model;

import java.sql.*;

public class LoginModel {
	
	private String hostname;
    private Connection cn;
    private Statement stmt;
    private String login;
    private String senha;
    private String query;
    private ResultSet rs;
    private PreparedStatement ps;
    
	
	public boolean conectar(String hostname) {
		try{
	           Class.forName("com.mysql.jdbc.Driver");
	           this.hostname = hostname;
	           String address = "jdbc:mysql://"+this.hostname+":3306";
	           
	           this.cn = DriverManager.getConnection(address, "root", "");
	           this.stmt = this.cn.createStatement();
	           
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
            this.login = login;
            this.senha = senha;
            rs = ps.executeQuery();
            rs.next();
            System.out.println("Login: " + rs.getString("login"));
            return true;
        } catch (SQLException ex) {
            System.out.println("Erro: " + ex);
        }
        return false;
    }    

    /**
     * @return the cn
     */
    public Connection getCn() {
        return cn;
    }
    
}
