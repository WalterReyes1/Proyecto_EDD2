/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto_edd2;

/**
 *
 * @author Luis Carlos Flores
 */
public class Nodo {
    int cant_llaves;
    boolean esHoja;
    Nodo hijos[];
    LLave llaves[];

    public Nodo() {
    }
    public Nodo(int g){
        this.cant_llaves=0;
        this.llaves=new LLave[(2*g)-1];
        this.esHoja=true;
        this.hijos=new Nodo[2*g];
    }
    /*
    public BTree(int t) {
    T = t;
    root = new Node();
    root.n = 0;
    root.leaf = true;
  }
    */

    public int getCant_llaves() {
        return cant_llaves;
    }

    public void setCant_llaves(int cant_llaves) {
        this.cant_llaves = cant_llaves;
    }

    public boolean isEsHoja() {
        return esHoja;
    }

    public void setEsHoja(boolean esHoja) {
        this.esHoja = esHoja;
    }

    public Nodo[] getHijos() {
        return hijos;
    }

    public void setHijos(Nodo[] hijos) {
        this.hijos = hijos;
    }

    public LLave[] getLlaves() {
        return llaves;
    }

    public void setLlaves(LLave[] llaves) {
        this.llaves = llaves;
    }
    
    
}
