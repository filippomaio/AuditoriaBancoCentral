package controller;

import model.*;
import java.sql.Connection;
import java.util.ArrayList;

public class RiscoController {
    private Risco risco;
    private int id;
    private int cod;
    private String descricao;
    private int impacto;
    private int probabilidade;
    
    
    public RiscoController(Connection cn) {
        this.risco = new Risco(cn);
    }
    
    public boolean validarCod(){
        return this.risco.readRisco(cod) == null;
    }
    
    public boolean cadastrarRisco(int cod, String descricao, int impacto, int probabilidade){      
        this.cod = cod;
        if(validarCod()){
            this.risco.createRisco(cod, descricao, impacto, probabilidade);
            return true;
        } 
       //JOptionPane.showMessageDialog(null, "Código de Risco já cadastrado!");
       return false; 
    }
    
    public Risco pesquisarRisco(int cod){
        risco = this.risco.readRisco(cod);
        return risco; 
    }
    
    public boolean atualizarRisco(String descricao, int impacto, int probabilidade, int cod){
        return this.risco.updateRisco(descricao, impacto, probabilidade, cod);
    }
    
    public boolean apagarRisco(int cod){
        return this.risco.deleteRisco(cod);
    }
    
    public ArrayList<Risco> carregarRiscos(){
        return this.risco.getRiscos();
    }
    
    
}
