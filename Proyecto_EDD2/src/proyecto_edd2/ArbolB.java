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
    public ArbolB(int T){
        this.Grado=T;
        raiz=new Nodo(T);
        raiz.setCant_llaves(0);
        raiz.esHoja=true;
        System.out.println("CREO ARBOL");
        
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
   
    // Search key
    private LLave Search(Nodo x, LLave l1) {
        int i=1;
        
        while(i<=x.getCant_llaves()&&l1.getLlave()>x.llaves[i].getLlave()){
            i=i+1;
        }
        if(i<=x.getCant_llaves()&&l1.getLlave()==x.getLlaves()[i].getLlave()){
            
            return(x.getLlaves()[i]);
        }
        if(x.isEsHoja()){
            return null;
        }else{
           return Search(x.getHijos()[i],l1); 
            
        }
    }
    public void Split(Nodo x,int i,Nodo h){
        Nodo z=new Nodo();
        z.esHoja=h.esHoja;
        z.setCant_llaves((Grado-1)/2);
        for (int j = 1; j < Grado-1; j++) {
            z.llaves[j].llave=h.llaves[j+Grado].llave;
        }
        if(h.isEsHoja()==false){
            for (int j = 1; j < Grado; j++) {
                z.hijos[j]=h.hijos[j+Grado];
            }
        }
        
        h.setCant_llaves(Grado-1);
        
        for (int j = x.getCant_llaves()+1; j >= i+1; j--) {
            //x.getHijos()[j+1]=x.getHijos()[j]; 
            x.hijos[j+1]=x.hijos[j];
        }
        x.hijos[i+1]=z;
        for (int j = x.getCant_llaves(); j >= i; j--) {
            x.llaves[j+1].llave=x.llaves[j].llave; 
        }
        x.llaves[i].llave=h.llaves[Grado].llave;
        x.cant_llaves=x.cant_llaves+1;
        System.out.println("SPLIT SUCCESFUL");
    }
   
  public void Insert(Nodo T, LLave l1) {
      System.out.println("Adentro Insert 1");
    Nodo r = T;
    if (r.getCant_llaves() == 2 * Grado- 1) {
      Nodo s = new Nodo();
      raiz = s;
      s.esHoja = false;
      s.cant_llaves = 0;
      s.hijos[1] = r;
      Split(s, 1, r);
      insertValue(s, l1);
    } else {
      insertValue(r, l1);
    }
    System.out.println("Afuera Insert 1");
  }

  // Insert the node
  
  public void insertValue(Nodo x, LLave l1) {
        System.out.println("ESTOY EN INSERT 2");
        int i=x.getCant_llaves();
        System.out.println("I: "+i);
        System.out.println("LLAVE X: "+x.llaves[i].getLlave());
        if(x.isEsHoja()){
            System.out.println("LLAVE recibida "+l1.getLlave());
            //LLave l2=x.llaves[i];
            //System.out.println("LLAVE x "+l2.getLlave());
            while(i>=1&&l1.getLlave()<x.getLlaves()[i].getLlave()){
                
                x.llaves[i + 1].llave = x.llaves[i].llave;
                i=i-1;
            }
           // x.llaves[i+1].llave=k;////me jode  no estoy seguro
            System.out.println("LLAVES: "+x.getLlaves().length);
            System.out.println("LLAVE X: "+x.llaves[i+1].getLlave());
            x.llaves[i + 1].setLlave(l1.getLlave());
            x.setCant_llaves(i+1);
           //
        }else {
            while(i>=1&&l1.getLlave()<x.llaves[i].getLlave()){
                i=i-1;
                
            }
            i=i+1;
            if(x.hijos[i].cant_llaves==(2*Grado)-1){
                Split(x,i,x.hijos[i]);
                if(l1.getLlave()>x.llaves[i].getLlave()){
                    i=i+1;
                }
            }
            insertValue(x.hijos[i],l1);
        }
        System.out.println("PERFECTO INGRESO 2");
  }
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
    
     /*
    public void Insert(Nodo T,LLave l1){
        System.out.println("ESTOY EN INSERT 1");
        Nodo r=T;
        if(r.getCant_llaves()==(2*Grado)-1){
            Nodo s=new Nodo();
            raiz=s;
            s.setEsHoja(false);
            s.setCant_llaves(0);
            s.getHijos()[1]=r;
            Split(s,1,r);
            //full(s,k)
            //else(r,k)
            Insert2(s,l1);
        }else{
            Insert2(r,l1);
        }
        System.out.println("PERFECTO INGRESO 1");
    }  
    public void Insert2(Nodo x,LLave l1){
        System.out.println("ESTOY EN INSERT 2");
        int i=x.getCant_llaves();
        if(x.isEsHoja()){
            while(i>=1&&l1.getLlave()<x.getLlaves()[i].getLlave()){
                //x.getLlaves()[i+1]=x.getLlaves()[i];
                //x.llaves[i+1].llave=x.llaves[i].llave;//me jode y no estoy seguro
                x.llaves[i + 1].llave = x.llaves[i].llave;
                i=i-1;
            }
           // x.llaves[i+1].llave=k;////me jode  no estoy seguro
            System.out.println("LLAVES: "+x.getLlaves().length);
            x.llaves[i + 1].setLlave(l1.getLlave());
            x.setCant_llaves(i+1);
           //
        }else {
            while(i>=1&&l1.getLlave()<x.llaves[i].getLlave()){
                i=i-1;
                
            }
            i=i+1;
            if(x.hijos[i].cant_llaves==(2*Grado)-1){
                Split(x,i,x.hijos[i]);
                if(l1.getLlave()>x.llaves[i].getLlave()){
                    i=i+1;
                }
            }
            Insert2(x.hijos[i],l1);
        }
        System.out.println("PERFECTO INGRESO 2");
        
        
    }
    */
    // Inserting a value
   
    
}
