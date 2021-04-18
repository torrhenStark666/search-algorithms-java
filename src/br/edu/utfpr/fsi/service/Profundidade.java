package br.edu.utfpr.fsi.service;

import br.edu.utfpr.fsi.model.Nodo;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author Andrade
 */
public class Profundidade {
    
    private List<Nodo> visitados = new ArrayList<>();
    private boolean finalizado;
    List<List<Nodo>> grafo;
    int i;
    
    public Profundidade(List<List<Nodo>> grafo){
        this.grafo = grafo;
        this.i = 0;
        this.finalizado = false;
        this.visitados = new ArrayList<>();
    }

    public List<List<Nodo>> getGrafo() {
        return grafo;
    }
    
    public List<String>  busca(String destino){
        Nodo inicial = this.grafo.get(0).get(0);
        List<String> caminho = new ArrayList<>();
        
        profundidade(inicial, destino);
        
        if(finalizado){
            visitados.forEach( (Nodo it) ->{
                caminho.add(it.getId());
            });
        }else{
            JOptionPane.showMessageDialog(null, "Caminho Impossivel");
            caminho.add(this.grafo.get(0).get(0).getId());
        }
            
        
        return caminho;
    }
    
    private void profundidade(Nodo no, String objetivo){
        
        if(finalizado)
            return;
        
        visitados.add(no);
        this.i++;
           
        if(no.getId().equals(objetivo)){
            finalizado = true;
        }else if(no.getFilhos() != null && !no.getFilhos().isEmpty()){
            
            no.getFilhos().forEach((Nodo e) ->{
                    if(!visitados.contains(e)){
                        profundidade(e, objetivo);
                    }
            });
        }else{
            finalizado = false;
        }
        
    }
    public int getI() {
        return i;
    }

}
