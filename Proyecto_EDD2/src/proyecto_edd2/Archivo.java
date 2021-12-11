/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto_edd2;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.LinkedList;

/**
 *
 * @author hp
 */
public class Archivo {

    File archivo = null;
    String name;

    boolean save;
    Registros r1;
    Arbolb btree;
    boolean primero;
    LinkedList availList = new LinkedList();
    ArrayList<Integer> avail1 = new ArrayList();

    public Arbolb getBtree() {
        return btree;
    }

    public void setBtree(Arbolb btree) {
        this.btree = btree;
    }

    public boolean isPrimero() {
        return primero;
    }

    public void setPrimero(boolean primero) {
        this.primero = primero;
    }

    public Archivo() {
    }

    public Archivo(String path, String name2) {
        archivo = new File(path);
        name = name2;

    }

    public ArrayList<Integer> getAvail1() {
        return avail1;
    }

    public void setAvail1(ArrayList<Integer> avail1) {
        this.avail1 = avail1;
    }

    public Registros getR1() {
        return r1;
    }

    public void setR1(Registros r1) {
        this.r1 = r1;
    }

    public File getArchivo() {
        return archivo;
    }

    public void setArchivo(File archivo) {
        this.archivo = archivo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.primero = false;
        this.name = name;
    }

    public boolean isSave() {
        return save;
    }

    public void setSave(boolean save) {
        this.save = save;
    }

    public LinkedList getAvailList() {
        return availList;
    }

    public void setAvailList(LinkedList availList) {
        this.availList = availList;
    }

    public void crearArchivo(String path, String name) throws IOException {
        try {
            this.archivo = new File(path + ".txt");
            if (this.archivo.createNewFile()) {
                System.out.println("File created: " + this.archivo.getName());
            } else {
                System.out.println("File already exists.");
            }
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

    }

    public void escribirArchivo(String word) throws IOException {
        try {

            FileWriter myWriter = new FileWriter(this.name);
            myWriter.write(word);
            myWriter.close();
            //System.out.println("Successfully wrote to the file.");
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    public void close(String name) {

    }

    public void escribirArchivo2(String word) throws IOException {

        try {

            FileWriter fileWriter = new FileWriter(this.name, true);

            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            bufferedWriter.write(word);
            bufferedWriter.close();
        } catch (IOException e) {
            System.out.println("COULD NOT LOG!!");
        }
    }
    
}
