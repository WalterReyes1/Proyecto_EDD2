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

        if (r.getCant_llaves()== ((2 * T) - 1)) {
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
            if (x.getHijos()[i].getCant_llaves() == (2 * T - 1)) {
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
        z.setCant_llaves(T - 1);

        //asignacion de llaves 
        for (int j = 0; j < (T - 1); j++) {
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
   

    
}
