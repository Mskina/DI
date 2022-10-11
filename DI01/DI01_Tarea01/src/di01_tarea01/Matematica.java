/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package di01_tarea01;

/**
 * Operaciones matemáticas (multiplicación y suma)
 * @author Iván Estévez Sabucedo
 */
public class Matematica {
    private int num;
    
    /**
     * Constructor sin parámetros
     */
    public Matematica() {        
    }
    
    /**
     * Constructor pasándole un número
     * @param num 
     */
    public Matematica (int num) {
        this.num = num;
    }

    /**
     * Getter de número
     * @return el número guardado
     */
    public int getNum() {
        return num;
    }

    /**
     * Setter de número
     * @param num el número para guardar
     */
    public void setNum(int num) {
        this.num = num;
    }
    
    /**
     * Operación de suma
     * @param sumando valor con el que sumo
     * @return devuelve el resultado de la suma
     */
    public int sumar(int sumando) {
        return num + sumando;
    }
    
    
    /**
     * Operación de multiplicación
     * @param coeficiente valor por el que multiplico
     * @return resultado de la multiplicación
     */
    public int multiplicar(int coeficiente) {
        return num*coeficiente;
    }
}
