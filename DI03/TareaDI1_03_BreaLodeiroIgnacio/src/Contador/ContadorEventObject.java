package Contador;

import java.util.EventObject;

/**
 *
 * @author Ignacio Brea Lodeiro
 */
public class ContadorEventObject extends EventObject {
    Contador contador;
    
    public ContadorEventObject(Object source){
        super(source);
    }
    
    public ContadorEventObject(Object source, Contador contador){
        super(source);
        this.contador = contador;
    }
    
    public Contador getContador(){
        return contador;
    }
    
    public void setContador(Contador contador){
        this.contador = contador;
    }
    
}
