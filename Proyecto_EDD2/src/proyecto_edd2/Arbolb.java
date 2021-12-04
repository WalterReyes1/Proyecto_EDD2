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
public class Arbolb {
    Nodo raiz;
    int T;

    
    public Arbolb(int T) {
        this.T = T;
        raiz = new Nodo(T);
    }

    public Nodo getRaiz() {
        return raiz;
    }

    public void setRaiz(Nodo raiz) {
        this.raiz = raiz;
    }

    public int getT() {
        return T;
    }

    public void setT(int T) {
        this.T = T;
    }
    public LLave buscarLlave(Nodo x, int llave) {
        //i es cont utilizado para saber donde esta la llave 
        int i = 0;
        Nodo temp = x;
        //while  si el indice es menor al numero de llaves
        //y si la llave es mayor que la llave del indice del contador

        while (i < temp.getCant_llaves() && llave > temp.getLlaves()[i].getLlave()) {
            //incremento el indice buscar
            i = i + 1;
        }

        //si el indice es menor que cant llaves
        //y si la llave del nodo en indice es igual a la llave 
        //del indice es igual a la llave a buscar entonces devuelve true
        if (i < temp.getCant_llaves() && llave == temp.getLlaves()[i].getLlave()) {
            return temp.getLlaves()[i];//retornamos llave
        }

        //si es hoja no existe llave 
        if (temp.esHoja) {
            return null;
        } else {
            //recursive
            return buscarLlave(x.getHijos()[i], llave);
        }

    }
    public void insert(LLave llave) {
        Nodo r = raiz;//el nodo primero sera la raiz

        if (r.getCant_llaves()== ((2 * T) - 1)) {//formula repetida
            //nueva llave a subir sera guardada
            Nodo s = new Nodo(T);
            raiz = s;
            s.setEsHoja(false);
            s.setCant_llaves(0);
            s.hijos[0] = r;
            Split(s, 0, r);
            //insertar despues de split
            insert_nonFull(s, llave);
        } else {
            //si hay espacio no ocupa split
            insert_nonFull(r, llave);
        }
    }

    public void insert_nonFull(Nodo x, LLave llave) {
        
        int i = 0;//empezamos a cont en 0

        if (x.esHoja) {

            i = x.getCant_llaves();
            //llaves left to rightt
            //depende si vmaos a insertar segun la llave mayor
            while (i >= 1 && llave.getLlave() < x.getLlaves()[i - 1].getLlave()) {
                x.getLlaves()[i] = x.getLlaves()[i - 1];
                i--;
            }
            x.getLlaves()[i] = llave;
            x.cant_llaves++;

        } else {
            
            for (i = x.getCant_llaves() - 1; i >= 0 && llave.getLlave() < x.getLlaves()[i].getLlave(); i--) {
                //ciclo que mueve a i
            }

            i++;

            //si esta lleno hacer split
            if (x.getHijos()[i].getCant_llaves() == (2 * T - 1)) {///FORMULA REPETIDA
                Split(x, i, x.hijos[i]);

                //si la llave  a insert es menor , aumentar indice cont
                if (llave.getLlave() > x.getLlaves()[i].getLlave()) {
                    i++;
                }
            }
            insert_nonFull(x.getHijos()[i], llave);
        }
    }
    
    public void Split(Nodo x, int i, Nodo y) {
        Nodo z = new Nodo(T);// Nodo temp
        z.esHoja = y.esHoja;
        z.setCant_llaves(T - 1);//CANTIDAD DE LLAVES

        //asignacion de llaves 
        for (int j = 0; j < (T - 1); j++) {//dividir por 2
            z.llaves[j] = y.llaves[j + T];
        }

        
        if (!y.esHoja) {
            //si no es hoja asigna las llaves hasta llegar a k
            for (int k = 0; k < T; k++) {
                z.hijos[k] = y.hijos[k + T];
            }
        }

        //setear numerop de llaves en nodo
        y.setCant_llaves(T - 1);

        //for to insert left to right 
        for (int j = x.getCant_llaves(); j >= (i + 1); j--) {
            x.hijos[j + 1] = x.hijos[j];
        }

        // nodo z hijo de x en la posicion i + 1
        x.hijos[i + 1] = z;

        
        for (int j = x.getCant_llaves() - 1; j >= i; j--) {
            x.llaves[(j + 1)] = x.llaves[j];
        }

        //llave promovida a x a la anterior t-1
        x.llaves[i] = y.llaves[(T - 1)];
        //aumento en el numero de llaves de x, para saber que ocurre split
        x.cant_llaves++;
        System.out.println("SPLIT OCURRIO");
    }
    
   

    //Print en preorder
    public void print(Nodo n) {
        n.imprimir();

        //Si no es hoja
        if (!n.esHoja) {
            //recorre los nodos para saber si tiene hijos
            for (int j = 0; j <= n.cant_llaves; j++) {
                if (n.hijos[j] != null) {
                    
                    System.out.println();
                    print(n.hijos[j]);
                }
            }
        }
    }
    public void Show() {
    Show(raiz);
  }

  // Display
  private void Show(Nodo x) {
    assert (x == null);
    for (int i = 0; i < x.cant_llaves; i++) {
      System.out.print(x.llaves[i].getLlave() + " ");
    }
    if (!x.esHoja) {
      for (int i = 0; i < x.cant_llaves + 1; i++) {
        Show(x.hijos[i]);
      }
    }
  }
  //ELIMINAR
  public boolean eliminar(Nodo x, LLave llave) {

        //encuentra el indice de la llave a eliminar adentro del nodo
        int indice = x.indice(llave);
        //verifica si el nodo es una hoja
        if (indice != -1) {
            if (x.esHoja) {
                //si el indice de la llave se ubica al final al reemplaza con un valor nulo
                if (indice == x.getLlaves().length - 1) {
                    x.getLlaves()[indice] = null;
                    x.setCant_llaves(x.getCant_llaves() - 1);
                    return true;
                } else {

                    //si el valor esta dentro del arreglo hace un corrimiento
                    //eliminando la llave en el proceso
                    for (int j = indice; j < x.getLlaves().length - 1; j++) {
                        x.getLlaves()[j] = x.getLlaves()[j + 1];
                    }
                    x.setCant_llaves(x.getCant_llaves() - 1);
                    return true;
                }
            }

            //caso # 2
            if (!x.isEsHoja()) {
                //Caso donde hijo predecesor tiene T llaves
                //declaracion de un nuevo nodo
                Nodo p = x.hijos[indice];
                //declaracion de llave predecesora
                LLave llaveP;
                //valida que el nodo tenga arriba del minimo de llaves
                if (p.getCant_llaves() >= T) {

                    //busca en un for infinito la llave predecesora
                    for (;;) {

                        if (p.esHoja) {
                            llaveP= p.llaves[p.getCant_llaves() - 1];
                            break;

                        } else {
                            p = p.hijos[p.cant_llaves];
                        }
                    }

                    //llamado recursivo al metodo de eliminar hasta dar al caso base
                    eliminar(p, llaveP);
                    x.llaves[indice] = llaveP;
                    return true;
                }

                //caso donde hijo sucesor tiene T llaves
                //declaracion de un nodo sucesor
                Nodo s= x.hijos[indice + 1];

                //verifica que el nodo sucesor tenga mas del minimo de llaves
                if (s.cant_llaves >= T) {

                    LLave llaveA = s.llaves[0];

                    //verifica si el nodo sucesor es hoja
                    if (!s.esHoja) {

                        s = s.hijos[0];

                        //for busca la llave sucesora dentro de los nodos sucesor
                        for (;;) {

                            //valida si el nodo sucesor es hoja
                            if (s.esHoja) {
                                llaveA= s.llaves[s.cant_llaves - 1];
                                break;

                            } else {
                                s = s.hijos[s.cant_llaves];
                            }
                        }
                    }

                    //llamada recursiva a la funcion eliminar
                    eliminar(s, llaveA);
                    x.llaves[indice] = llaveA;
                }

                //Caso #3 Merges y mas
                int temp = p.cant_llaves + 1;
                p.llaves[p.cant_llaves++] = x.llaves[indice];

                for (int i = 0, j = p.cant_llaves; i < s.cant_llaves; i++) {
                    p.llaves[j + 1] = s.llaves[i];
                    p.cant_llaves++;
                }

                for (int i = 0; i < s.cant_llaves + 1; i++) {
                    p.hijos[temp+ 1] = s.hijos[i];
                }

                x.hijos[indice] = p;

                //corrimiento de llaves
                for (int i = indice; i < x.cant_llaves; i++) {

                    //si i es diferente que el numero que el grado menos 2
                    if (i != (2 * T - 2)) {
                        x.llaves[i] = x.llaves[i + 1];
                    }
                }

                //corrimiento en el arreglo de hijos
                for (int i = indice + 1; i < x.cant_llaves + 1; i++) {

                    if (i != (2 * T - 1)) {
                        x.hijos[i] = x.hijos[i + 1];
                    }
                }

                x.cant_llaves--;

                if (x.cant_llaves == 0) {

                    if (x == raiz) {
                        raiz = x.hijos[0];
                    }

                    x = x.hijos[0];
                }

                eliminar(p, llave);
                return true;

            }
        } else {
            //caso donde no encuentra la posicion de la llave a insertar
            for (indice = 0; indice < x.cant_llaves; indice++) {

                if (x.llaves[indice].llave > llave.llave) {
                    break;
                }
            }

            Nodo temporal = x.hijos[indice];

            if (temporal.cant_llaves >= T) {
                eliminar(temporal, llave);
                return true;
            }

            if (true) {
                Nodo newNode = null;
                LLave llaved;

                if (indice != x.cant_llaves && x.hijos[indice + 1].cant_llaves >= T) {

                    llaved= x.llaves[indice];
                    newNode = x.hijos[indice + 1];

                    x.llaves[indice] = newNode.llaves[0];

                    temporal.llaves[temporal.cant_llaves++] = llaved;
                    temporal.hijos[temporal.cant_llaves] = newNode.hijos[0];

                    for (int i = 1; i < newNode.cant_llaves; i++) {
                        newNode.llaves[i - 1] = newNode.llaves[i];
                    }

                    for (int i = 1; i <= newNode.cant_llaves; i++) {
                        newNode.hijos[i - 1] = newNode.hijos[i];
                    }

                    newNode.cant_llaves--;
                    eliminar(temporal, llave);
                    return true;

                } else if (indice != 0 && x.hijos[indice - 1].cant_llaves >= T) {

                    llaved = x.llaves[indice - 1];

                    newNode = x.hijos[indice - 1];

                    x.llaves[indice - 1] = newNode.llaves[newNode.cant_llaves - 1];

                    Nodo hijo = newNode.hijos[newNode.cant_llaves];
                    newNode.cant_llaves--;

                    for (int i = temporal.cant_llaves; i > 0; i--) {
                        temporal.llaves[i] = temporal.llaves[i - 1];
                    }

                    temporal.llaves[0] = llaved;

                    for (int i = temporal.cant_llaves + 1; i > 0; i--) {
                        temporal.hijos[i] = temporal.hijos[i - 1];
                    }

                    temporal.hijos[0] = hijo;

                    temporal.cant_llaves++;
                    eliminar(temporal, llave);

                } else {
                    Nodo nodoIzquierdo = null;
                    Nodo nodoDerecho = null;
                    boolean ultimo = false;

                    if (indice != x.cant_llaves) {
                        llaved = x.llaves[indice];
                        nodoIzquierdo = x.hijos[indice];
                        nodoDerecho = x.hijos[indice + 1];

                    } else {
                        llaved = x.llaves[indice - 1];
                        nodoDerecho = x.hijos[indice];
                        nodoIzquierdo = x.hijos[indice - 1];
                        ultimo = true;
                        indice--;
                    }

                    for (int i = indice; i < x.cant_llaves - 1; i++) {
                        x.llaves[i] = x.llaves[i + 1];
                    }

                    for (int i = indice + 1; i < x.cant_llaves; i++) {
                        x.hijos[i] = x.hijos[i + 1];
                    }

                    x.cant_llaves--;

                    nodoIzquierdo.llaves[nodoIzquierdo.cant_llaves++] = llaved;

                    for (int i = 0, j = nodoIzquierdo.cant_llaves; i < nodoDerecho.cant_llaves + 1; i++, j++) {

                        if (i < nodoDerecho.cant_llaves) {
                            nodoIzquierdo.llaves[j] = nodoDerecho.llaves[i];
                        }
                        nodoIzquierdo.hijos[j] = nodoDerecho.hijos[i];
                    }

                    nodoIzquierdo.cant_llaves += nodoDerecho.cant_llaves;

                    if (x.cant_llaves == 0) {
                        if (x == raiz) {
                            raiz = x.hijos[0];
                        }
                        x = x.hijos[0];
                    }

                    eliminar(nodoIzquierdo, llave);
                    return true;

                }
            }
        }
        return false;
    }

    public Nodo buscarEliminado(Nodo x, int llave) {
        //Contador utilizado para evaluar indice de llaves y nodos hijo
        int contador = 0;
        Nodo nodo = x;
        //Ciclo while que evalua si el indice es menor al numero de llaves
        //y si la llave es mayor que la llave del indice del contador
        while (contador < nodo.getCant_llaves()&& llave > nodo.getLlaves()[contador].getLlave()) {
            //incremento al contador
            contador = contador + 1;
        }
        //si el contador es menor que el numero de llaves y la llave 
        //del indice es igual a la llave a buscar entonces devuelve true
        if (contador < nodo.getCant_llaves() && llave == nodo.getLlaves()[contador].getLlave()) {
            return nodo;
        }
        //si en caso el nodo es hoja significa que la llave no existe y devuelve false
        if (nodo.esHoja) {
            return null;
        } else {
            //caso recursivo que evaluara las llaves del hijo del nodo actual
            return buscarEliminado(x.getHijos()[contador], llave);
        }
    }
  

    
}
