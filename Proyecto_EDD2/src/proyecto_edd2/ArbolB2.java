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
public class ArbolB2 {
    int T;
    Nodo raiz;

    public int getT() {
        return T;
    }

    public void setT(int T) {
        this.T = T;
    }

    public Nodo getRaiz() {
        return raiz;
    }

    public void setRaiz(Nodo raiz) {
        this.raiz = raiz;
    }

    public ArbolB2(int T, Nodo raiz) {
        this.T = T;
        this.raiz = raiz;
    }

    public ArbolB2() {
    }
    public ArbolB2(int t){
        this.T=t;
        raiz=new Nodo(t);
        System.out.println("CREA ARBOL");
    }
    // Search key
  private Nodo Busca(Nodo x,LLave k) {
    int i = 0;
    if (x == null)
      return x;
    for (i = 0; i < x.cant_llaves; i++) {
      if (k.llave < x.llaves[i].llave) {
        break;
      }
      if (k.llave== x.llaves[i].llave) {
        return x;
      }
    }
    if (x.esHoja) {
      return null;
    } else {
      return Busca(x.hijos[i], k);
    }
  }
  // Splitting the node
  private void Split(Nodo x, int pos, Nodo y) {
    Nodo z = new Nodo();
    z.esHoja = y.esHoja;
    z.cant_llaves = T - 1;
    for (int j = 0; j < T - 1; j++) {
      z.llaves[j].llave = y.llaves[j + T].llave;
    }
    if (!y.esHoja) {
      for (int j = 0; j < T; j++) {
        z.hijos[j] = y.hijos[j + T];
      }
    }
    y.cant_llaves = T - 1;
    for (int j = x.cant_llaves; j >= pos + 1; j--) {
      x.hijos[j + 1] = x.hijos[j];
    }
    x.hijos[pos + 1] = z;

    for (int j = x.cant_llaves - 1; j >= pos; j--) {
      x.llaves[j + 1].llave = x.llaves[j].llave;
    }
    x.llaves[pos].llave = y.llaves[T - 1].llave;
    x.cant_llaves = x.cant_llaves + 1;
  }
  // Inserting a value
  public void Insert( LLave k) {
    Nodo r = raiz;
    if (r.cant_llaves == 2 * T - 1) {
      Nodo s = new Nodo();
      
      raiz = s;
      s.esHoja = false;
      s.cant_llaves = 0;
      s.hijos[0] = r;
      Split(s, 0, r);
      insertValue(s, k);
    } else {
      insertValue(r, k);
    }
    //System.out.println("ESTOY AFUERA INSERT 1");
  }

  // Insert the node
  final private void insertValue(Nodo x, LLave k) {

    if (x.esHoja) {
      int i = 0;
      //System.out.println("LLAVE X: "+x.llaves[0].llave);
      for (i = x.cant_llaves - 1; i >= 0 && k.getLlave() < x.llaves[i].llave; i--) {
        x.llaves[i + 1].llave = x.llaves[i].llave;
        //System.out.println("LLAVE X: "+x.llaves[0].llave);
      }
      //System.out.println("LLAVE X: "+x.llaves[0].llave);
      x.llaves[i + 1].llave = k.getLlave();
      x.cant_llaves = x.cant_llaves + 1;
    } else {
      int i = 0;
      for (i = x.cant_llaves - 1; i >= 0 && k.getLlave() < x.llaves[i].llave; i--) {
      }
      ;
      i++;
      Nodo tmp = x.hijos[i];
      if (tmp.cant_llaves == 2 * T - 1) {
        Split(x, i, tmp);
        if (k.getLlave() > x.llaves[i].llave) {
          i++;
        }
      }
      insertValue(x.hijos[i], k);
    }
      //System.out.println("ESTOY AFUERA INSERT 2");

  }
  public void Show() {
    Show(raiz);
  }

  // Display
  private void Show(Nodo x) {
    assert (x == null);
      System.out.println("HELLO IM PRINT");
    for (int i = 0; i < x.cant_llaves; i++) {
      if(x.isEsHoja()){
          System.out.println("HOLA SOY HOJA ");
          System.out.print("SHOWING: "+x.llaves[i].llave + " ");
      }else{
          System.out.print("SHOWING: "+x.llaves[i].llave + " ");
      }
      
    }
    if (!x.esHoja) {
      for (int i = 0; i < x.cant_llaves + 1; i++) {
        Show(x.hijos[i]);
      }
    }
  }

  
    
}
