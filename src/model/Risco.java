package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class Risco {
    
    private final Connection cn;
    private int idRisco;
    private int codigo;
    private String nome;
	private String descricao;
    private int impacto;
    private int probabilidade;

    public Risco(Connection cn) {
        this.cn = cn;
    }
    
    public boolean createRisco(int codigo, String nome, String descricao, int impacto, int probabilidade){
        String query = "INSERT INTO auditoria.risco(codigo, nome, descricao, impacto, probabilidade)"
                + " VALUES (?,?,?,?,?)";
        
        try {
            PreparedStatement ps = cn.prepareStatement(query);
            ps.setInt(1, codigo);
            ps.setString(2, nome);
            ps.setString(3, descricao);
            ps.setInt(4, impacto);
            ps.setInt(5, probabilidade);
            ps.executeUpdate();
            System.out.println("Add");
        }catch(SQLException ex){
            System.out.println("Um erro aconteceu: " + ex);
        }
        
        return false;
    }
    
    public ArrayList<Risco> getRiscos(){
        String query = "SELECT * FROM auditoria.risco";
        
        try{
            PreparedStatement ps = cn.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            ArrayList<Risco> riscos = new ArrayList<Risco>();
            while(rs.next()){
                Risco risco = new Risco(cn);
                risco.idRisco = rs.getInt("idRisco");
                risco.codigo = rs.getInt("codigo");
                risco.nome = rs.getString("nome");
                risco.descricao = rs.getString("descricao");
                risco.impacto = rs.getInt("impacto");
                risco.probabilidade = rs.getInt("probabilidade");
                riscos.add(risco);
            }
            System.out.println(riscos);
            return riscos;
        }catch(SQLException ex){
            System.out.println("Um erro aconteceu: " + ex);
        }
        return null;
    }

    public ArrayList<Risco> getObjetoRiscos(){
        String query = "SELECT * FROM auditoria.objetorisco INNER JOIN auditoria.risco ON auditoria.objetorisco.idRisco = auditoria.risco.idRisco";
        
        try{
            PreparedStatement ps = cn.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            ArrayList<Risco> riscos = new ArrayList<Risco>();
            while(rs.next()){
                Risco risco = new Risco(cn);
                risco.idRisco = rs.getInt("idRisco");
                risco.codigo = rs.getInt("codigo");
                risco.nome = rs.getString("nome");
                risco.descricao = rs.getString("descricao");
                risco.impacto = rs.getInt("impacto");
                risco.probabilidade = rs.getInt("probabilidade");
                riscos.add(risco);
            }
            System.out.println(riscos);
            return riscos;
        }catch(SQLException ex){
            System.out.println("Um erro aconteceu: " + ex);
        }
        return null;
    }

    
    public ArrayList<Risco> getRiscos(int impacto, int probabilidade){
        String query = "SELECT * FROM auditoria.risco WHERE impacto = (?) and probabilidade = (?)";
        
        try{
            PreparedStatement ps = cn.prepareStatement(query);
            ps.setInt(1, impacto);
            ps.setInt(2, probabilidade);
            ResultSet rs = ps.executeQuery();
            ArrayList<Risco> riscos = new ArrayList<Risco>();
            while(rs.next()){
                Risco risco = new Risco(cn);
                risco.idRisco = rs.getInt("idRisco");
                risco.codigo = rs.getInt("codigo");
                risco.nome = rs.getString("nome");
                risco.descricao = rs.getString("descricao");
                risco.impacto = rs.getInt("impacto");
                risco.probabilidade = rs.getInt("probabilidade");
                riscos.add(risco);
            }
            System.out.println(riscos);
            return riscos;
        }catch(SQLException ex){
            System.out.println("Um erro aconteceu: " + ex);
        }
        return null;
    }
    
    public Risco readRisco(int cod){
        String query = "SELECT * FROM auditoria.risco WHERE codigo = (?)";
        
        try{
            PreparedStatement ps = cn.prepareStatement(query);
            ps.setInt(1, cod);
            ResultSet rs = ps.executeQuery();
            rs.next();
            System.out.println("Result Set: " + rs.getInt("idRisco"));
            System.out.println("Result Set: " + rs.getString("codigo"));
            System.out.println("Result Set: " + rs.getString("nome"));
            System.out.println("Result Set: " + rs.getString("descricao"));
            System.out.println("Result Set: " + rs.getString("impacto"));
            System.out.println("Result Set: " + rs.getString("probabilidade"));
            this.idRisco = rs.getInt("idRisco");
            this.codigo = rs.getInt("codigo");
            this.nome = rs.getString("nome");
            this.descricao = rs.getString("descricao");
            this.impacto = rs.getInt("impacto");
            this.probabilidade = rs.getInt("probabilidade");
            return this;
        }catch(SQLException ex){
            System.out.println("Um erro aconteceu: " + ex);
        }
        
        return null;
    }

    
    public Risco readRisco(String nome){
        String query = "SELECT * FROM auditoria.risco WHERE nome = (?)";
        
        try{
            PreparedStatement ps = cn.prepareStatement(query);
            ps.setString(1, nome);
            ResultSet rs = ps.executeQuery();
            rs.next();
            System.out.println("Result Set: " + rs.getInt("idRisco"));
            System.out.println("Result Set: " + rs.getString("codigo"));
            System.out.println("Result Set: " + rs.getString("nome"));
            System.out.println("Result Set: " + rs.getString("descricao"));
            System.out.println("Result Set: " + rs.getString("impacto"));
            System.out.println("Result Set: " + rs.getString("probabilidade"));
            this.idRisco = rs.getInt("idRisco");
            this.codigo = rs.getInt("codigo");
            this.nome = rs.getString("nome");
            this.descricao = rs.getString("descricao");
            this.impacto = rs.getInt("impacto");
            this.probabilidade = rs.getInt("probabilidade");
            return this;
        }catch(SQLException ex){
            System.out.println("Um erro aconteceu: " + ex);
        }
        
        return null;
    }

    
    public boolean updateRisco(String nome, String descricao, int impacto, int probabilidade, int codigo){
        String query = "UPDATE auditoria.risco SET nome = ?, descricao = ?,"
                + " impacto = ?, probabilidade = ? WHERE auditoria.risco.codigo = ?";

         try {
             PreparedStatement ps = cn.prepareStatement(query);
             ps.setString(1, nome);
             ps.setString(2, descricao);
             ps.setInt(3, impacto);
             ps.setInt(4, probabilidade);
             ps.setInt(5, codigo);
             ps.executeUpdate();
             System.out.println("Alterado");
         }catch(SQLException ex){
             System.out.println("Um erro aconteceu: " + ex);
         }

         return false;
    }
    
    public boolean deleteRisco(int codigo){
        String query = "DELETE FROM auditoria.risco WHERE auditoria.risco.codigo = (?)";
        try {
            PreparedStatement ps = cn.prepareStatement(query);
            ps.setInt(1, codigo);
            ps.executeUpdate();
            System.out.println("Deletado");
            return true;
        }catch(SQLException ex){
            System.out.println("Um erro aconteceu: " + ex);
        }
        
        return false;
    }

    public int getIdRisco() {
        return idRisco;
    }
    
    public int getCodigo() {
		return codigo;
	}
    
    public String getNome() {
    	return nome;
    }

	public String getDescricao() {
		return descricao;
	}

	public int getImpacto() {
		return impacto;
	}

	public int getProbabilidade() {
		return probabilidade;
	}
    
}
