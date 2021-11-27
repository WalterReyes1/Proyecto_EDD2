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
        this.cant_llaves=0;//al principio no tendra llaves
        this.llaves=new LLave[(2*g)-1];//dar numero de llaves max
        this.esHoja=true;//es hoja pq es insert at leaf
        this.hijos=new Nodo[2*g];//numero de hijos
        System.out.println("NODO CREADO");
        
    }
    
    

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
    
     public void imprimir() {
        System.out.print("[");
        for (int i = 0; i < this.cant_llaves; i++) {
            if (i < this.cant_llaves - 1) {
                System.out.print(llaves[i].llave + " | ");
            } else {
                System.out.print(llaves[i].llave);
            }
        }
        System.out.print("]");
    }
     public int indice(LLave llave) {

        for (int i = 0; i < llaves.length; i++) {

            if (llaves[i].llave == llave.getLlave()) {
                return i;
            }
        }

        return -1;
    }
}
