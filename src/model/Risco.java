package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class Risco {
    
    private final Connection cn;
    private int id;
    private int cod;
    private String descricao;
    private int impacto;
    private int probabilidade;

    public Risco(Connection cn) {
        this.cn = cn;
    }
    
    public boolean createRisco(int cod, String descricao, int impacto, int probabilidade){
        String query = "INSERT INTO auditoria.risco(cod, descricao, impacto, probabilidade)"
                + " VALUES (?,?,?,?)";
        
        try {
            PreparedStatement ps = cn.prepareStatement(query);
            ps.setInt(1, cod);
            ps.setString(2, descricao);
            ps.setInt(3, impacto);
            ps.setInt(4, probabilidade);
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
                this.id = rs.getInt("id");
                this.cod = rs.getInt("cod");
                this.descricao = rs.getString("descricao");
                this.impacto = rs.getInt("impacto");
                this.probabilidade = rs.getInt("probabilidade");
                riscos.add(this);
            }
            return riscos;
        }catch(SQLException ex){
            System.out.println("Um erro aconteceu: " + ex);
        }
        
        
        return null;
    }
    
    public Risco readRisco(int cod){
        String query = "SELECT * FROM auditoria.risco WHERE cod = (?)";
        
        try{
            PreparedStatement ps = cn.prepareStatement(query);
            ps.setInt(1, cod);
            ResultSet rs = ps.executeQuery();
            rs.next();
            System.out.println("Result Set: " + rs.getInt("id"));
            System.out.println("Result Set: " + rs.getString("cod"));
            System.out.println("Result Set: " + rs.getString("descricao"));
            System.out.println("Result Set: " + rs.getString("impacto"));
            System.out.println("Result Set: " + rs.getString("probabilidade"));
            this.id = rs.getInt("id");
            this.cod = rs.getInt("cod");
            this.descricao = rs.getString("descricao");
            this.impacto = rs.getInt("impacto");
            this.probabilidade = rs.getInt("probabilidade");
            return this;
        }catch(SQLException ex){
            System.out.println("Um erro aconteceu: " + ex);
        }
        
        
        return null;
    }
    
    public boolean updateRisco(String descricao, int impacto, int probabilidade, int cod){
        String query = "UPDATE auditoria.risco SET descricao = ?,"
                + " impacto = ?, probabilidade = ? WHERE auditoria.risco.cod = ?";

         try {
             PreparedStatement ps = cn.prepareStatement(query);
             ps.setString(1, descricao);
             ps.setInt(2, impacto);
             ps.setInt(3, probabilidade);
             ps.setInt(4, cod);
             ps.executeUpdate();
             System.out.println("Alterado");
         }catch(SQLException ex){
             System.out.println("Um erro aconteceu: " + ex);
         }

         return false;
    }
    
    public boolean deleteRisco(int cod){
        String query = "DELETE FROM auditoria.risco WHERE auditoria.risco.cod = (?)";
        try {
            PreparedStatement ps = cn.prepareStatement(query);
            ps.setInt(1, cod);
            ps.executeUpdate();
            System.out.println("Deletado");
            return true;
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
    
    
    
}
