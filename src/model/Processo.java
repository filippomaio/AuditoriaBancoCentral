package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class Processo {

    private final Connection cn;
    private int id;
    private String objetivo;
    private String nomeObj;
    private String descObjProcesso;

    public Processo(Connection cn) {
        this.cn = cn;
    }

    
    public boolean createProcesso(String nomeObj, String objetivo, String descObjProcesso){
        String query = "INSERT INTO auditoria.processo(nomeObj, objetivo, descricao)"
                + " VALUES (?,?,?)";
        
        try {
            PreparedStatement ps = cn.prepareStatement(query);
            ps.setString(1, nomeObj);
            ps.setString(2, objetivo);
            ps.setString(3, descObjProcesso);
            ps.executeUpdate();
            System.out.println("Add");
        }catch(SQLException ex){
            System.out.println("Um erro aconteceu: " + ex);
        }
        
        return false;
    }
    
    public Processo readProcesso(int id){
        String query = "SELECT * FROM auditoria.processo WHERE id = (?)";
        
        try{
            PreparedStatement ps = cn.prepareStatement(query);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            rs.next();
            System.out.println("Result Set: " + rs.getString("id"));
            System.out.println("Result Set: " + rs.getString("nomeObj"));
            System.out.println("Result Set: " + rs.getString("descricao"));
            this.id = rs.getInt("id");
            this.objetivo = rs.getString("objetivo");
            this.nomeObj = rs.getString("nomeObj");
            this.descObjProcesso = rs.getString("descricao");
            return this;
        }catch(SQLException ex){
            System.out.println("Um erro aconteceu: " + ex);
        }
        
        
        return null;
    }
    
    public Processo readProcesso(String nomeObj){
        String query = "SELECT * FROM auditoria.processo WHERE nomeObj = (?)";
        
        try{
            PreparedStatement ps = cn.prepareStatement(query);
            ps.setString(1, nomeObj);
            ResultSet rs = ps.executeQuery();
            rs.next();
            System.out.println("Result Set: " + rs.getString("id"));
            System.out.println("Result Set: " + rs.getString("nomeObj"));
            System.out.println("Result Set: " + rs.getString("descricao"));
            this.id = rs.getInt("id");
            this.objetivo = rs.getString("objetivo");
            this.nomeObj = rs.getString("nomeObj");
            this.descObjProcesso = rs.getString("descricao");
            return this;
        }catch(SQLException ex){
            System.out.println("Um erro aconteceu: " + ex);
        }
        
        
        return null;
    }
    
    public boolean updateProcesso(String nomeObj, String objetivo, String descObjProcesso, int id){
        String query = "UPDATE auditoria.processo SET nomeObj = ?, objetivo = ?, descricao = ? WHERE auditoria.processo.id = (?)";
        
        try {
            PreparedStatement ps = cn.prepareStatement(query);
            ps.setString(1, nomeObj);
            ps.setString(2, objetivo);
            ps.setString(3, descObjProcesso);
            ps.setInt(4, id);
            ps.executeUpdate();
            System.out.println("Alterado");
        }catch(SQLException ex){
            System.out.println("Um erro aconteceu: " + ex);
        }
        
        return false;
    }
    
    public boolean deleteProcesso(int id){
        String query = "DELETE FROM auditoria.processo WHERE auditoria.processo.id = (?)";
        try {
            PreparedStatement ps = cn.prepareStatement(query);
            ps.setInt(1, id);
            ps.executeUpdate();
            System.out.println("Deletado");
            return true;
        }catch(SQLException ex){
            System.out.println("Um erro aconteceu: " + ex);
        }
        
        return false;
    }
    
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
    }

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }
    
    public ArrayList<Processo> getProcessos(){
        String query = "SELECT * FROM auditoria.processo";
        
        try{
            PreparedStatement ps = cn.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            ArrayList<Processo> processos = new ArrayList<Processo>();
            while(rs.next()){
                Processo processo = new Processo(cn);
                processo.id = rs.getInt("id");
                //System.out.println(id);
                processo.objetivo = rs.getString("objetivo");
                processo.nomeObj = rs.getString("nomeObj");
                processo.descObjProcesso = rs.getString("descricao");
                processos.add(processo);
            }
            System.out.println(processos);
            return processos;
        }catch(SQLException ex){
            System.out.println("Um erro aconteceu: " + ex);
        }
        return null;
    }

    /**
     * @return the nomeObj
     */
    public String getNomeObj() {
        return nomeObj;
    }
    
}
