/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto_edd2;

import java.util.ArrayList;

/**
 *
 * @author Luis Carlos Flores
 */
public class Registros extends Campos {
    private ArrayList<Campos> listaCampo=new ArrayList();

    public Registros() {
    }

    public ArrayList<Campos> getListaCampo() {
        return listaCampo;
    }

    public void setListaCampo(ArrayList<Campos> listaCampo) {
        this.listaCampo = listaCampo;
    }
    
}
