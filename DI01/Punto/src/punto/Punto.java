/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package punto;

/**
 *
 * @author Iván Estévez Sabucedo
 */
public class Punto {
	
    //Atributos
    private double x;
    private double y;
    
    //Constructores
    public Punto() {}
    
    public Punto(double coordenadaX, double coordenadaY) {
       x = coordenadaX;
       y = coordenadaY;
    }
    
    //Resto de m�todos
    
    /**
     * Devuelve la coordenada x
     */       
    public double obtenerX() {
       return x;
    }
    
    /**
     * Devuelve la coordenada y
     */
    public double obtenerY() {
       return y;
    }   
    
    public void asignarX(double x){
        this.x=x;
    }
    
    public void asignarY(double y){
        this.y=y;
    }
    
    /**
     * Devuelve la distancia entre 2 puntos: el punto que recibe el mensaje
     * y el punto que recibe como argumento    
     */       
    public double calcularDistancia(Punto p) {
       double disX, disY;
       
       disX = p.obtenerX() - x;
       disY = p.obtenerY() - y;
       return (Math.sqrt(disX * disX + disY * disY));
    }
}
