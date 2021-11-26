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
public class ArbolB {
    Nodo raiz;
    int Grado;

    public ArbolB(Nodo raiz, int Grado) {
        this.raiz = raiz;
        this.Grado = Grado;
    }

    public ArbolB() {
    }

    public Nodo getRaiz() {
        return raiz;
    }

    public void setRaiz(Nodo raiz) {
        this.raiz = raiz;
    }

    public int getGrado() {
        return Grado;
    }

    public void setGrado(int Grado) {
        this.Grado = Grado;
    }
    public void create(int T){
         
        this.Grado = T;
        raiz = new Nodo();
        raiz.setCant_llaves(0);
        raiz.setEsHoja(true);
 
    }
    // Search key
    private LLave Search(Nodo x, int key) {
        int i=1;
        
        while(i<=x.getCant_llaves()&&key>x.llaves[i].getLlave()){
            i=i+1;
        }
        if(i<=x.getCant_llaves()&&key==x.getLlaves()[i].getLlave()){
            
            return(x.getLlaves()[i]);
        }
        if(x.isEsHoja()){
            return null;
        }else{
           return Search(x.getHijos()[i],key); 
            
        }
    }
    public void Split(Nodo x,int i,Nodo h){
        Nodo z=new Nodo();
        z.esHoja=z.esHoja;
        z.setCant_llaves((Grado-1)/2);
        for (int j = 1; j < Grado-1; j++) {
            z.getLlaves()[j]=h.getLlaves()[j+Grado];
        }
        if(h.isEsHoja()==false){
            for (int j = 1; j < Grado; j++) {
                z.getHijos()[j]=h.getHijos()[j+Grado];
            }
        }
        
        h.setCant_llaves(Grado-1);
        
        for (int j = x.getCant_llaves()+1; j > i+1; j--) {
            x.getHijos()[j+1]=x.getHijos()[j]; 
        }
        x.getHijos()[i+1]=z;
        for (int j = x.getCant_llaves(); j > i; j--) {
            x.getHijos()[j+1]=x.getHijos()[j]; 
        }
        x.getLlaves()[i]=h.getLlaves()[Grado];
        x.setCant_llaves(z.getCant_llaves()+1);
    }
    public void Insert(Nodo T,int k){
        Nodo r=raiz;
        if(r.getCant_llaves()==(2*Grado)-1){
            Nodo s=new Nodo();
            raiz=s;
            s.setEsHoja(false);
            s.setCant_llaves(0);
            s.setHijos(r.getHijos());
            Split(s,1,r);
            //full(s,k)
            //else(r,k)
        }
    }  
    public void Insert2(Nodo x,int k){
        int i=x.getCant_llaves();
        if(x.isEsHoja()){
            while(i>=1&&k<x.getLlaves()[i].getLlave()){
                x.getLlaves()[i+1]=x.getLlaves()[i];
                i=i-1;
            }
           //
        }
        
    }
    
}
