package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class Mitigacao {
    
    private Connection cn;
    
    private int idMitigacao;
    private String nome;
    private String descricao;
    
    private int idObjeto;
    private int idObjetoRisco;
    private int idObjetoRiscoMitigacao;
    private int idRisco;
    private int avaliacao;
    private String comentarios;
    private String nomeProcesso;
    private String nomeObjeto;
    private String nomeRisco;
    private int probabilidade;
    private int impacto;

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
	
	public int getIdObjeto() {
		return idObjeto;
	}
	
	public int getIdRisco() {
		return idRisco;
	}
	
	public int getIdObjetoRisco() {
		return idObjetoRisco;
	}
	
	public int getIdObjetoRiscoMitigacao() {
		return idObjetoRiscoMitigacao;
	}
	
	public int getAvaliacao() {
		return avaliacao;
	}
	
	public int getImpacto() {
		return impacto;
	}
	
	public int getProbabilidade() {
		return probabilidade;
	}
	
	public String getComentarios() {
		return comentarios;
	}
	
	public String getNomeObjeto() {
		return nomeObjeto;
	}
	
	public String getNomeRisco() {
		return nomeRisco;
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
    
    public ArrayList<Mitigacao> getMitigacoes(){
        String query = "SELECT * FROM auditoria.mitigacao";
        
        try{
            PreparedStatement ps = cn.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            ArrayList<Mitigacao> mitigacoes = new ArrayList<Mitigacao>();
            while(rs.next()){
                Mitigacao mitigacao = new Mitigacao(cn);
                mitigacao.idMitigacao = rs.getInt("idMitigacao");
                mitigacao.nome = rs.getString("nome");
                mitigacao.descricao = rs.getString("descricao");
                mitigacoes.add(mitigacao);
            }
            return mitigacoes;
        }catch(SQLException ex){
            System.out.println("Um erro aconteceu: " + ex);
        }
        return null;
    }
    
    public Mitigacao readObjetoMitigacao(int idObjetoRisco, int idMitigacao){
        String query = "SELECT * FROM auditoria.mitigacao WHERE idObjetoRisco = (?) and idMitigacao = (?)";
        
        try{
            PreparedStatement ps = cn.prepareStatement(query);
            ps.setInt(1, idObjetoRisco);
            ps.setInt(2, idMitigacao);
            ResultSet rs = ps.executeQuery();
            rs.next();
            this.idMitigacao = rs.getInt("idMitigacao");
            return this;
        }catch(SQLException ex){
            System.out.println("Um erro aconteceu: " + ex);
        }        
        
        return null;
    }
    
    public boolean associateMitigacao(int idObjetoRisco, int idMitigacao){
        String query = "INSERT INTO auditoria.objetoriscomitigacao(idObjetoRisco, idMitigacao) VALUES (?,?)";
        
        try {
            PreparedStatement ps = cn.prepareStatement(query);
            ps.setInt(1, idObjetoRisco);
            ps.setInt(2, idMitigacao);
            ps.executeUpdate();
            System.out.println("Add");
            return true;
        }catch(SQLException ex){
            System.out.println("Um erro aconteceu: " + ex);
        }
        
        return false;  
    }
    
    public boolean updateAssociateMitigacao(int avaliacao, String comentarios, int idObjetoRiscoMitigacao){
        String query = "UPDATE auditoria.objetoriscomitigacao SET avaliacao = (?), comentarios = (?) WHERE auditoria.objetoriscomitigacao.idObjetoRiscoMitigacao = (?)";
        
        try {
            PreparedStatement ps = cn.prepareStatement(query);
            ps.setInt(1, avaliacao);
            ps.setString(2, comentarios);
            ps.setInt(3, idObjetoRiscoMitigacao);
            ps.executeUpdate();
            System.out.println("Alterado");
            return true;
        }catch(SQLException ex){
            System.out.println("Um erro aconteceu: " + ex);
        }
        
        return false;
    
    }
    
    public ArrayList<Mitigacao> getObjetosRiscosMitigacoes(){
        String query = "SELECT * FROM auditoria.objetoriscomitigacao INNER JOIN auditoria.objetorisco ON auditoria.objetorisco.idObjetoRisco = auditoria.objetoriscomitigacao.idObjetoRisco INNER JOIN auditoria.objeto ON auditoria.objetorisco.idObjeto = auditoria.objeto.idObjeto INNER JOIN auditoria.risco ON auditoria.objetorisco.idRisco = auditoria.risco.idRisco INNER JOIN auditoria.mitigacao ON auditoria.mitigacao.idMitigacao = auditoria.objetoriscomitigacao.idMitigacao ";
        
        try{
            PreparedStatement ps = cn.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            ArrayList<Mitigacao> mitigacoes = new ArrayList<Mitigacao>();
            while(rs.next()){
                Mitigacao mitigacao = new Mitigacao(cn);
                System.out.println(rs.getInt("idObjetoRiscoMitigacao"));
                mitigacao.idObjetoRiscoMitigacao = rs.getInt("idObjetoRiscoMitigacao");
                mitigacao.idMitigacao = rs.getInt("idMitigacao");
                mitigacao.idObjeto = rs.getInt("idObjeto");
                mitigacao.idRisco = rs.getInt("idRisco");
                mitigacao.idObjetoRisco = rs.getInt("idObjetoRisco");
                mitigacao.avaliacao = rs.getInt("avaliacao");
                mitigacao.comentarios = rs.getString("comentarios");
                mitigacao.nome = rs.getString("mitigacao.nome");
                mitigacao.nomeObjeto = rs.getString("objeto.nome");
                mitigacao.nomeRisco = rs.getString("risco.nome");
                mitigacao.probabilidade = rs.getInt("probabilidade");
                mitigacao.impacto = rs.getInt("impacto");
                mitigacoes.add(mitigacao);
            }
            return mitigacoes;
        }catch(SQLException ex){
            System.out.println("Um erro aconteceu: " + ex);
        }
        return null;
    }
    }
