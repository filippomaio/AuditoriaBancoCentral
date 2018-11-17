package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Mitigacao {
    
    private Connection cn;
    
    private int idMitigacao;
    private String nome;
    private String descricao;

    public Mitigacao(Connection cn) {
        this.cn = cn;
    }
    
    public int getIdMitigacao() {
		return idMitigacao;
	}

	public String getNome() {
		return nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public boolean createMitigacao(String nome, String descricao){
        String query = "INSERT INTO auditoria.mitigacao(nome, descricao) VALUES (?,?)";
        
        try {
            PreparedStatement ps = cn.prepareStatement(query);
            ps.setString(1, nome);
            ps.setString(2, descricao);
            ps.executeUpdate();
            System.out.println("Add");
            return true;
        }catch(SQLException ex){
            System.out.println("Um erro aconteceu: " + ex);
        }
        
        return false;
    }
    
    public Mitigacao readMitigacao(String nome){
        String query = "SELECT * FROM auditoria.mitigacao WHERE nome = (?)";
        
        try{
            PreparedStatement ps = cn.prepareStatement(query);
            ps.setString(1, nome);
            ResultSet rs = ps.executeQuery();
            rs.next();
            System.out.println("Result Set: " + rs.getString("nome"));
            this.idMitigacao = rs.getInt("idMitigacao");
            this.nome = rs.getString("nome");
            this.descricao = rs.getString("descricao");
            return this;
        }catch(SQLException ex){
            System.out.println("Um erro aconteceu: " + ex);
        }
        
        
        return null;
    }
    
    public Mitigacao readMitigacao(int idMitigacao){
        String query = "SELECT * FROM auditoria.mitigacao WHERE idMitigacao = (?)";
        
        try{
            PreparedStatement ps = cn.prepareStatement(query);
            ps.setInt(1, idMitigacao);
            ResultSet rs = ps.executeQuery();
            rs.next();
            System.out.println("Result Set: " + rs.getString("nome"));
            this.idMitigacao = rs.getInt("idMitigacao");
            this.nome = rs.getString("nome");
            this.descricao = rs.getString("descricao");
            return this;
        }catch(SQLException ex){
            System.out.println("Um erro aconteceu: " + ex);
        }
        
        
        return null;
    }
    
    public boolean updateMitigacao(String nome, String descricao, int idMitigacao){
        String query = "UPDATE auditoria.mitigacao SET nome = (?), descricao = (?) WHERE auditoria.mitigacao.idMitigacao = (?)";
        
        try {
            PreparedStatement ps = cn.prepareStatement(query);
            ps.setString(1, nome);
            ps.setString(2, descricao);
            ps.setInt(3, idMitigacao);
            ps.executeUpdate();
            System.out.println("Alterado");
            return true;
        }catch(SQLException ex){
            System.out.println("Um erro aconteceu: " + ex);
        }
        
        return false;
    
    }
    
    public boolean deleteMitigacao(int idMitigacao){
        String query = "DELETE FROM auditoria.mitigacao WHERE auditoria.mitigacao.idMitigacao = (?)";
        try {
            PreparedStatement ps = cn.prepareStatement(query);
            ps.setInt(1, idMitigacao);
            ps.executeUpdate();
            System.out.println("Deletado");
            return true;
        }catch(SQLException ex){
            System.out.println("Um erro aconteceu: " + ex);
        }
        
        return false;
    }
    
}
