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
public class Campos {
    private String nombre;
    private String data_type;
    private int size;
    private boolean isKey;

    public Campos() {
    }

    public Campos(String nombre, String data_type, int size, boolean isKey) {
        this.nombre = nombre;
        this.data_type = data_type;
        this.size = size;
        this.isKey = isKey;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getData_type() {
        return data_type;
    }

    public void setData_type(String data_type) {
        this.data_type = data_type;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public boolean isIsKey() {
        return isKey;
    }

    public void setIsKey(boolean isKey) {
        this.isKey = isKey;
    }

    @Override
    public String toString() {
        return this.nombre;
    }
    
    
}
