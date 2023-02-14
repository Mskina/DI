/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graphics01;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import javax.swing.JFrame;
import javax.swing.JPanel;
import static javax.swing.WindowConstants.EXIT_ON_CLOSE;

/**
 *
 * @author Iván Estévez Sabucedo
 */
public class Cara extends JFrame {
    
    public Cara() {
        JPanel panel = new JPanel();
        add(panel); // Añado el panel al JFrame
        panel.setPreferredSize(new Dimension(800, 600)); // Dimensiones del panel

        setTitle("Ejemplo");
        setSize(800, 600);
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }

    public void paint(Graphics g) {
        super.paint(g);
        
        //Dibujo el contorno de la cara
        g.setColor(Color.BLACK);
        g.fillOval(105, 70, 100, 100);
        
        
        //Dibujo de los ojos
        g.setColor(Color.GREEN);
        g.fillOval(125, 100, 10, 10);
        g.fillOval(175, 100, 10, 10);
        
        //Dibujo de la nariz
        g.drawLine(150, 100, 150, 130);
        
        //Dibujo de la boca
        g.drawArc(118, 120, 75, 30, 180, 180);
    }

}
