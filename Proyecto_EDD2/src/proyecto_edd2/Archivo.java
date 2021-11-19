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
    LinkedList availList = new LinkedList();

    public Archivo() {
    }

    public Archivo(String path, String name2) {
        archivo = new File(path);
        name = name2;

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

    public void crearArchivo() throws IOException {
        try {
            this.archivo= new File("filename.txt");
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
            FileWriter myWriter = new FileWriter("filename.txt");
            myWriter.write(word);
            myWriter.close();
            System.out.println("Successfully wrote to the file.");
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
}
