/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Beans/Bean.java to edit this template
 */
package componentes.boton;

import java.awt.Color;
import java.awt.Font;
import java.io.Serializable;
import javax.swing.JButton;

/**
 *
 * @author Iván Estévez Sabucedo
 */
public class Boton extends JButton implements Serializable {
    
    private boolean estado;
    
    public Boton() {
        estado = false;
        super.setText("Start");
        super.setFont(new Font("SansSerif",Font.BOLD,16)); 
        super.setBackground(Color.GREEN);
        super.setForeground(Color.WHITE);
    }

    public boolean isEstado() {
        return estado;
    }

    public void cambiarEstado() {
        this.estado = !estado;
        if (this.estado) {
            this.setText("Stop");
            this.setBackground(Color.RED);
        } else {
            this.setText("Start");
            this.setBackground(Color.GREEN);
        }
    }   
    
    
    
    
}
