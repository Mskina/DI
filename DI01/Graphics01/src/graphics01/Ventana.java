/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graphics01;

import java.awt.Dimension;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author Iván Estévez Sabucedo
 */
public class Ventana extends JFrame {
    
    public Ventana() {
        JPanel panel = new DrawPanel();
        add(panel); // Añado el panel al JFrame
        panel.setPreferredSize(new Dimension(800, 600)); // Dimensiones del panel

        setTitle("Ejemplo");
        setSize(800, 600);
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }

}
