package proyecto_edd2;

import java.io.Serializable;

/**
 *
 * @author Luis Carlos Flores
 */
public class LLave implements Serializable  {
    private static final long SerialVersionUID=777L;
    long offset;
    int llave;

    public LLave() {
    }
    //luis,12
    //walter,12
    ;
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
