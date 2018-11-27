package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class Processo {

    private Connection cn;
    
    private int idProcesso;
    private String nome;
    private String descricao;

    public Processo(Connection cn) {
        this.cn = cn;
    }

    
    public int getIdProcesso() {
        return idProcesso;
    }

    public String getNome() {
        return nome;
    }
    
    public String getDescricao() {
        return descricao;
    }

    
    public boolean createProcesso(String nome, String descricao){
        String query = "INSERT INTO auditoria.processo(nome, descricao)"
                + " VALUES (?,?)";
        
        try {
            PreparedStatement ps = cn.prepareStatement(query);
            ps.setString(1, nome);
            ps.setString(2, descricao);
            ps.executeUpdate();
            System.out.println("Add");
        }catch(SQLException ex){
            System.out.println("Um erro aconteceu: " + ex);
        }
        
        return false;
    }
    
    public Processo readProcesso(int idProcesso){
        String query = "SELECT * FROM auditoria.processo WHERE idProcesso = (?)";
        
        try{
            PreparedStatement ps = cn.prepareStatement(query);
            ps.setInt(1, idProcesso);
            ResultSet rs = ps.executeQuery();
            rs.next();
            this.idProcesso = rs.getInt("idProcesso");
            this.nome = rs.getString("nome");
            this.descricao = rs.getString("descricao");
            return this;
        }catch(SQLException ex){
            System.out.println("Um erro aconteceu: " + ex);
        }
        
        
        return null;
    }
    
    public Processo readProcesso(String nome){
        String query = "SELECT * FROM auditoria.processo WHERE nome = (?)";
        
        try{
            PreparedStatement ps = cn.prepareStatement(query);
            ps.setString(1, nome);
            ResultSet rs = ps.executeQuery();
            rs.next();
            this.idProcesso = rs.getInt("idProcesso");
            this.nome = rs.getString("nome");
            this.descricao = rs.getString("descricao");
            return this;
        }catch(SQLException ex){
            System.out.println("Um erro aconteceu: " + ex);
        }
        
        
        return null;
    }
    
    public boolean updateProcesso(String nome, String descricao, int idProcesso){
        String query = "UPDATE auditoria.processo SET nome = ?, descricao = ? WHERE auditoria.processo.idProcesso = (?)";
        
        try {
            PreparedStatement ps = cn.prepareStatement(query);
            ps.setString(1, nome);
            ps.setString(2, descricao);
            ps.setInt(3, idProcesso);
            ps.executeUpdate();
            System.out.println("Alterado");
        }catch(SQLException ex){
            System.out.println("Um erro aconteceu: " + ex);
        }
        
        return false;
    }
    
    public boolean deleteProcesso(int idProcesso){
        String query = "DELETE FROM auditoria.processo WHERE auditoria.processo.idProcesso = (?)";
        try {
            PreparedStatement ps = cn.prepareStatement(query);
            ps.setInt(1, idProcesso);
            ps.executeUpdate();
            System.out.println("Deletado");
            return true;
        }catch(SQLException ex){
            System.out.println("Um erro aconteceu: " + ex);
        }
        
        return false;
    }
    /*
    public boolean doProcessoRisco(int idProcesso, int idRisco){
        String query = "INSERT INTO auditoria.processorisco(idProcesso, idRisco)"
                + " VALUES (?,?)";
        
        try {
            PreparedStatement ps = cn.prepareStatement(query);
            ps.setInt(1, idProcesso);
            ps.setInt(2, idRisco);
            ps.executeUpdate();
            System.out.println("Add");
        }catch(SQLException ex){
            System.out.println("Um erro aconteceu: " + ex);
        }
        
        return false;  
    }
    
    public boolean undoProcessoRisco(int idProcesso, int idRisco){
        String query = "DELETE FROM auditoria.processorisco WHERE auditoria.processorisco.idProcesso = ? AND auditoria.processorisco.idRisco = ?";
        
        try {
            PreparedStatement ps = cn.prepareStatement(query);
            ps.setInt(1, idProcesso);
            ps.setInt(2, idRisco);
            ps.executeUpdate();
            System.out.println("Apagado");
        }catch(SQLException ex){
            System.out.println("Um erro aconteceu: " + ex);
        }
        
        return false;  
    }*/

        
    public ArrayList<Processo> getProcessos(){
        String query = "SELECT * FROM auditoria.processo";
        
        try{
            PreparedStatement ps = cn.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            ArrayList<Processo> processos = new ArrayList<Processo>();
            while(rs.next()){
                Processo processo = new Processo(cn);
                processo.idProcesso = rs.getInt("idProcesso");
                processo.nome = rs.getString("nome");
                processo.descricao = rs.getString("descricao");
                processos.add(processo);
            }
            System.out.println(processos);
            return processos;
        }catch(SQLException ex){
            System.out.println("Um erro aconteceu: " + ex);
        }
        return null;
    }

    
}
