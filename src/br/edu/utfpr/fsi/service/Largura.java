package br.edu.utfpr.fsi.service;

import br.edu.utfpr.fsi.model.Nodo;
import br.edu.utfpr.fsi.repository.Queue;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author Nogueira
 */
public class Largura {
    List<List<Nodo>> grafo;
    int i;
    
    public Largura(List<List<Nodo>> grafo){
        this.grafo = grafo;
        this.i = 0;
    }

    public List<List<Nodo>> getGrafo() {
        return grafo;
    }
    public List<String> largura(String destino) throws InterruptedException{
      Nodo inicial = this.grafo.get(0).get(0);
        List<String> caminho = new ArrayList<>();
        Queue<Nodo> fila = new Queue<>();
        List<Nodo> fechada = new ArrayList<>();
        
        fila.enqueue(inicial);
        Nodo atual = fila.dequeue();
        fechada.add(atual);
        while(true){
            
             //System.out.println(atual.getId());
            
            if(atual.getId().equals("9x9")){
                while(true){
                    //System.out.println(atual.getValor());
                    caminho.add(atual.getId());
                    atual = atual.getPai();

                    if(atual.getId().equals("0x0")){

                        Collections.reverse(caminho);
                        atual = grafo.get(0).get(0);
                        
                        System.out.println("largura");
                        
                        return caminho;
                    }
                }
            }
            
               
            for(Nodo x: atual.getFilhos()){
               
                if(fechada.contains(x))
                    continue;
                this.i++;
                x.setPai(atual);
                fila.enqueue(x);
                fechada.add(x);
            }
            if(fila.isEmpty()){
                JOptionPane.showMessageDialog(null, "Caminho Impossivel");
                caminho.add(this.grafo.get(0).get(0).getId());
                System.out.println("largura");
                return caminho;
            }
            atual = fila.dequeue();
            

            
        }
        
    }     //return caminho;

    public int getI() {
        return i;
    }
    
}
