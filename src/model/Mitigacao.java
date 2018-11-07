package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Mitigacao {
    
    private Connection cn;
    private int id;
    private String mitigacao_;        

    public Mitigacao(Connection cn) {
        this.cn = cn;
    }
    
    public boolean createMitigacao(String mitigacao){
        String query = "INSERT INTO auditoria.mitigacao(mitigacao) VALUES (?)";
        
        try {
            PreparedStatement ps = cn.prepareStatement(query);
            ps.setString(1, mitigacao);
            ps.executeUpdate();
            System.out.println("Add");
            return true;
        }catch(SQLException ex){
            System.out.println("Um erro aconteceu: " + ex);
        }
        
        return false;
    }
    
    public Mitigacao readMitigacao(String mitigacao_){
        String query = "SELECT * FROM auditoria.mitigacao WHERE mitigacao = (?)";
        
        try{
            PreparedStatement ps = cn.prepareStatement(query);
            ps.setString(1, mitigacao_);
            ResultSet rs = ps.executeQuery();
            rs.next();
            System.out.println("Result Set: " + rs.getString("mitigacao"));
            this.id = rs.getInt("id");
            this.mitigacao_ = rs.getString("mitigacao");
            return this;
        }catch(SQLException ex){
            System.out.println("Um erro aconteceu: " + ex);
        }
        
        
        return null;
    }
    
    public boolean updateMitigacao(String novo, String antigo){
        String query = "UPDATE auditoria.mitigacao SET mitigacao = (?) WHERE auditoria.mitigacao.mitigacao = (?)";
        
        try {
            PreparedStatement ps = cn.prepareStatement(query);
            ps.setString(1, novo);
            ps.setString(2, antigo);
            ps.executeUpdate();
            System.out.println("Alterado");
            return true;
        }catch(SQLException ex){
            System.out.println("Um erro aconteceu: " + ex);
        }
        
        return false;
    
    }
    
    public boolean deleteMitigacao(String mitigacao){
        String query = "DELETE FROM auditoria.mitigacao WHERE auditoria.mitigacao.mitigacao = (?)";
        try {
            PreparedStatement ps = cn.prepareStatement(query);
            ps.setString(1, mitigacao);
            ps.executeUpdate();
            System.out.println("Deletado");
            return true;
        }catch(SQLException ex){
            System.out.println("Um erro aconteceu: " + ex);
        }
        
        return false;
    }
    
}
