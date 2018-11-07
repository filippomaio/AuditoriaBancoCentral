package controller;

import model.*;
import java.sql.Connection;

public class MitigacaoController {
    
    private Mitigacao mitigacao;
    private String mitigacao_;
    private String comentario;

    public MitigacaoController(Connection cn) {
        this.mitigacao = new Mitigacao(cn);
    }

    public boolean validarMitigacao(){
        return this.mitigacao.readMitigacao(mitigacao_) == null;
        
    }
    
    
    public boolean cadastrarMitigacao(String mitigacao){      
        this.mitigacao_ = mitigacao;
        if(validarMitigacao()){
            this.mitigacao.createMitigacao(mitigacao);
            return true;
        }
        //JOptionPane.showMessageDialog(null, "Mitigação já cadastrada!");
        return false;
        
    }
    
    public Mitigacao pesquisarMitigacao(String mitigacao_){        
        mitigacao = this.mitigacao.readMitigacao(mitigacao_);
        return mitigacao;
    }
    
    public boolean atualizarMitigacao(String novo, String antigo){
        return this.mitigacao.updateMitigacao(novo, antigo);
        
    }
    
    public boolean apagarMitigacao(String mitigacao){
        return this.mitigacao.deleteMitigacao(mitigacao);
        
    }
    
}
