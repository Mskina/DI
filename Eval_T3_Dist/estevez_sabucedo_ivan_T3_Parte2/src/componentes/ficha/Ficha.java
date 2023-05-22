/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Beans/Bean.java to edit this template
 */
package componentes.ficha;

import java.awt.Color;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.ListIterator;
import java.util.Random;
import javax.swing.JButton;
import javax.swing.border.BevelBorder;

/**
 *
 * @author Iván Estévez Sabucedo
 */
public class Ficha extends JButton implements Serializable {

    private int index;
    private ArrayList<FichaEventListener> listeners;

    public Ficha() {        
        super.setText(String.valueOf(getIndex()));
        super.setBackground(Color.blue);
        super.setForeground(Color.white);
        super.setFont(new java.awt.Font("Segoe UI", 1, 18));
        
        this.listeners = new ArrayList<>();
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public int getIndex() {
        return this.index;
    }

    public void reset() {
        super.setText(String.valueOf(getIndex()));
        super.setBackground(Color.blue);
        super.setForeground(Color.white);
        super.setFont(new java.awt.Font("Segoe UI", 1, 18));
    }

    public void mostrarNumero() {
        this.setText(String.valueOf(index));
    }

    public void ocultarNumero() {
        this.setText("");
    }

    public void cambiarAspecto() {
        int numero = numeroRandom();
        super.setText(String.valueOf(numero));
        super.setBackground(colorFondo(numero));
    }
    
    public void remarcarCoincidencia() {    
        super.setBorder(javax.swing.BorderFactory.createMatteBorder(5, 5, 5, 5, Color.BLUE));
    }

    private int numeroRandom() {
        Random rn = new Random();
        int numero = rn.nextInt(10);
        if (numero == this.index) {
            System.out.println("Coincidencia en " + this.index);
            remarcarCoincidencia();
            notifyEnd();
        }
        return numero;
    }

    private Color colorFondo(int numero) {
        Color colorFondo;
        switch (numero) {
            case 0:
                colorFondo = Color.RED;
                break;
            case 1:
                colorFondo = Color.BLACK;
                break;
            case 2:
                colorFondo = Color.CYAN;
                break;
            case 3:
                colorFondo = Color.GRAY;
                break;
            case 4:
                colorFondo = Color.GREEN;
                break;
            case 5:
                colorFondo = Color.MAGENTA;
                break;
            case 6:
                colorFondo = Color.ORANGE;
                break;
            case 7:
                colorFondo = Color.PINK;
                break;
            case 8:
                colorFondo = Color.YELLOW;
                break;
            case 9:
                colorFondo = Color.DARK_GRAY;
                break;
            default:
                colorFondo = Color.blue;
                ;
        }

        return colorFondo;
    }
    
    public void addFichaEventListener(FichaEventListener listener) {
        listeners.add(listener);
    }
    
    private void notifyStart() {
        ListIterator<FichaEventListener> li = listeners.listIterator();
        while (li.hasNext()) {
            li.next().startGame();
        }
    }
    
    private void notifyEnd() {
        ListIterator<FichaEventListener> li = listeners.listIterator();
        while (li.hasNext()) {
            li.next().endGame();
        }
    }

}
