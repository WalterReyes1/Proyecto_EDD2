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
        Nodo x=new Nodo();
        x.setEsHoja(true);
        x.setCant_llaves(0);
        raiz=x;
        System.out.println("CREO PERF");
 
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
        z.esHoja=h.esHoja;
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
    /*
    public void Insert(Nodo T,int k){
        System.out.println("ESTOY EN INSERT 1");
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
            Insert2(s,k);
        }else{
            Insert2(r,k);
        }
        System.out.println("PERFECTO INGRESO");
    }  
    public void Insert2(Nodo x,int k){
        System.out.println("ESTOY EN INSERT 2");
        int i=x.getCant_llaves();
        if(x.isEsHoja()){
            while(i>=1&&k<x.getLlaves()[i].getLlave()){
                //x.getLlaves()[i+1]=x.getLlaves()[i];
                x.llaves[i+1].llave=x.llaves[i].llave;//me jode y no estoy seguro
                i=i-1;
            }
            x.llaves[i+1].llave=k;////me jode  no estoy seguro
            x.setCant_llaves(i+1);
           //
        }else {
            while(i>=1&&k<x.llaves[i].getLlave()){
                i=i-1;
                
            }
            i=i+1;
            if(x.hijos[i].cant_llaves==(2*Grado)-1){
                Split(x,i,x.hijos[i]);
                if(k>x.llaves[i].getLlave()){
                    i=i+1;
                }
            }
            Insert2(x.hijos[i],k);
        }
        System.out.println("PERFECTO INGRESO");
        
        
    }*/
    // Inserting a value
    /*
  public void Insert(final int key) {
    Nodo r = raiz;
    if (r.getCant_llaves() == 2 * Grado- 1) {
      Nodo s = new Nodo();
      raiz = s;
      s.esHoja = false;
      s.cant_llaves = 0;
      s.hijos[0] = r;
      Split(s, 0, r);
      insertValue(s, key);
    } else {
      insertValue(r, key);
    }
  }

  // Insert the node
  final private void insertValue(Nodo x, int k) {

    if (x.esHoja) {
      int i = 0;
      for (i = x.cant_llaves - 1; i >= 0 && k < x.llaves[i].llave; i--) {
        x.llaves[i + 1].llave = x.llaves[i].llave;//esto tambien
      }
      x.llaves[i + 1].llave = k;//esto me falla a mi
      x.cant_llaves= x.cant_llaves+ 1;
    } else {
      int i = 0;
      for (i = x.cant_llaves - 1; i >= 0 && k < x.llaves[i].llave; i--) {
      }
      ;
      i++;
      Nodo tmp = x.hijos[i];
      if (tmp.cant_llaves == 2 * Grado - 1) {
        Split(x, i, tmp);
        if (k > x.llaves[i].llave) {
          i++;
        }
      }
      insertValue(x.hijos[i], k);
    }

  }*/
    //no estoy seguro ni pija 
    public void Print(Nodo x) {
    assert (x == null);
    for (int i = 0; i < x.getCant_llaves(); i++) {
      System.out.print(x.llaves[i].getLlave() + " ");
    }
    if (!x.isEsHoja()) {
      for (int i = 0; i < x.getCant_llaves()+ 1; i++) {
          System.out.println(x.hijos[i].llaves[i].getLlave());
      }
    }
  
  }
    
}
