package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class Objeto {

    private final Connection cn;
    
    private int idObjeto;
    private String nome;
    private String descricao;
    private int idProcesso;
    
    public Objeto(Connection cn) {
        this.cn = cn;
    }

    public int getIdObjeto() {
        return idObjeto;
    }

    public String getNome() {
        return nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public int getIdProcesso() {
            return idProcesso;
        }


    public boolean createObjeto(String nome, String descricao, int idProcesso){
        String query = "INSERT INTO auditoria.objeto(nome, descricao, idProcesso) VALUES (?,?,?)";
        
        try {
            PreparedStatement ps = cn.prepareStatement(query);
            ps.setString(1, nome);
            ps.setString(2, descricao);
            ps.setInt(3, idProcesso);
            ps.executeUpdate();
            System.out.println("Add");
        }catch(SQLException ex){
            System.out.println("Um erro aconteceu: " + ex);
        }
        
        return false;
    }
    
    public Objeto readObjeto(int idObjeto){
        String query = "SELECT * FROM auditoria.objeto WHERE idObjeto = (?)";
        
        try{
            PreparedStatement ps = cn.prepareStatement(query);
            ps.setInt(1, idObjeto);
            ResultSet rs = ps.executeQuery();
            rs.next();
            this.idObjeto = rs.getInt("idObjeto");
            this.nome = rs.getString("nome");
            this.descricao = rs.getString("descricao");
            this.idProcesso = rs.getInt("idProcesso");
            return this;
        }catch(SQLException ex){
            System.out.println("Um erro aconteceu: " + ex);
        }
        
        
        return null;
    }
    
    public Objeto readObjeto(String nome){
        String query = "SELECT * FROM auditoria.objeto WHERE nome = (?)";
        
        try{
            PreparedStatement ps = cn.prepareStatement(query);
            ps.setString(1, nome);
            ResultSet rs = ps.executeQuery();
            rs.next();
            this.idObjeto = rs.getInt("idObjeto");
            this.nome = rs.getString("nome");
            this.descricao = rs.getString("descricao");
            this.idProcesso = rs.getInt("idProcesso");
            return this;
        }catch(SQLException ex){
            System.out.println("Um erro aconteceu: " + ex);
        }
        
        
        return null;
    }
    
    public boolean updateProcesso(String nome, String descricao,int idProcesso, int idObjeto){
        String query = "UPDATE auditoria.objeto SET nome = ?, descricao = ?, idProcesso = ? WHERE auditoria.objeto.idObjeto = (?)";
        
        try {
            PreparedStatement ps = cn.prepareStatement(query);
            ps.setString(1, nome);
            ps.setString(2, descricao);
            ps.setInt(3, idProcesso);
            ps.setInt(4, idObjeto);
            ps.executeUpdate();
            System.out.println("Alterado");
        }catch(SQLException ex){
            System.out.println("Um erro aconteceu: " + ex);
        }
        
        return false;
    }
    
    public boolean deleteObjeto(int idObjeto){
        String query = "DELETE FROM auditoria.objeto WHERE auditoria.objeto.idObjeto = (?)";
        try {
            PreparedStatement ps = cn.prepareStatement(query);
            ps.setInt(1, idObjeto);
            ps.executeUpdate();
            System.out.println("Deletado");
            return true;
        }catch(SQLException ex){
            System.out.println("Um erro aconteceu: " + ex);
        }
        
        return false;
    }
    
    public boolean associateObjetoRisco(int idObjeto, int idRisco){
        String query = "INSERT INTO auditoria.objetorisco(idObjeto, idRisco) VALUES (?,?)";
        
        try {
            PreparedStatement ps = cn.prepareStatement(query);
            ps.setInt(1, idObjeto);
            ps.setInt(2, idRisco);
            ps.executeUpdate();
            System.out.println("Add");
        }catch(SQLException ex){
            System.out.println("Um erro aconteceu: " + ex);
        }
        
        return false;  
    }
    
    public boolean readObjetoRisco(int idObjeto, int idRisco){
        String query = "SELECT * FROM auditoria.objetorisco WHERE idObjeto = (?) and idRisco = (?)";
        
        try{
            PreparedStatement ps = cn.prepareStatement(query);
            ps.setInt(1, idObjeto);
            ps.setInt(2, idRisco);
            ResultSet rs = ps.executeQuery();
            rs.next();
            return true;
        }catch(SQLException ex){
            System.out.println("Um erro aconteceu: " + ex);
        }
        return false;
    }

    /*
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

        
    public ArrayList<Objeto> getObjetos(){
        String query = "SELECT * FROM auditoria.objeto";
        
        try{
            PreparedStatement ps = cn.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            ArrayList<Objeto> objetos = new ArrayList<Objeto>();
            while(rs.next()){
                Objeto objeto = new Objeto(cn);
                objeto.idObjeto = rs.getInt("idObjeto");
                objeto.nome = rs.getString("nome");
                objeto.descricao = rs.getString("descricao");
                objeto.idProcesso = rs.getInt("idProcesso");
                objetos.add(objeto);
            }
            return objetos;
        }catch(SQLException ex){
            System.out.println("Um erro aconteceu: " + ex);
        }
        return null;
    }

    
}
