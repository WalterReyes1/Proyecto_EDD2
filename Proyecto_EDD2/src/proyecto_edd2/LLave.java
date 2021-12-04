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
public class LLave {
    long offset;
    int llave;

    public LLave() {
    }
    //luis,12
    //walter,12

    public LLave(long offset, int llave) {
        this.offset = offset;
        this.llave = llave; 
    }

    public long getOffset() {
        return offset;
    }

    public void setOffset(long offset) {
        this.offset = offset;
    }

    public int getLlave() {
        return llave;
    }

    public void setLlave(int llave) {
        this.llave = llave;
    }
    
    
}
