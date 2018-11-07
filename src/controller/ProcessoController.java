package controller;

import model.*;
import java.sql.Connection;
import java.util.ArrayList;

public class ProcessoController {
    private Processo processo;
    private int id;
    private String objetivo;
    private String nomeObj;
    private String descObjProcesso;
    private Connection cn;

    public ProcessoController(Connection cn) {
        this.cn = cn;
        this.processo = new Processo(cn);
    }
    
    public boolean validarNomeObj(){
        return this.processo.readProcesso(getNomeObj()) == null;
    }
    
    
    
    
    
    public boolean cadastrarProcesso(String nomeObj, String objetivo, String descObjProcesso){      
        this.nomeObj = nomeObj;
        if(validarNomeObj()){
            this.processo.createProcesso(nomeObj, objetivo, descObjProcesso);
            return true;
        } 
       //JOptionPane.showMessageDialog(null, "Objeto com o mesmo nome já cadastrado!");
       return false; 
    }
    
    public Processo pesquisarProcesso(int id){
        processo = this.processo.readProcesso(id);
        return processo; 
    }
    
    public boolean atualizarProcesso(String nomeObj, String objetivo, String descObjProcesso, int id){
        return processo.updateProcesso(nomeObj, objetivo, descObjProcesso, id);
    }
    
    public boolean apagarProcesso(int id){
        return this.processo.deleteProcesso(id);
    }
    
    public boolean fazerProcessoRisco(String nomeObj, int codRisco){
        processo = this.processo.readProcesso(nomeObj);
        Risco risco = new Risco(cn);
        risco = risco.readRisco(codRisco);
        
        this.processo.doProcessoRisco(processo.getId(),risco.getId());
        return true;
    }
    
    public boolean desfazerProcessoRisco(String nomeObj, int codRisco){
        processo = this.processo.readProcesso(nomeObj);
        Risco risco = new Risco(cn);
        risco = risco.readRisco(codRisco);
        
        this.processo.undoProcessoRisco(processo.getId(),risco.getId());
        return true;
    }
    
    public ArrayList<String> listarProcessosPorNome(){
        ArrayList<Processo> processos = this.processo.getProcessos();
        ArrayList<String> lista = new ArrayList<String>();
        for(int i=0;i<processos.size();i++){
            lista.add(processos.get(i).getNomeObj());
        }
        return lista;
    }   

    /**
     * @return the nomeObj
     */
    public String getNomeObj() {
        return nomeObj;
    }
    
    
    
}
