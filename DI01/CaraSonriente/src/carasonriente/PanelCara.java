/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package carasonriente;

import javax.swing.JPanel;
import java.awt.*;

/**
 *
 * @author Iván Estévez Sabucedo
 */
public class PanelCara extends JPanel {

    private boolean sonrie;

    PanelCara() {
        sonrie = true;
    }

    public boolean isSonrie() {
        return sonrie;
    }

    public void setSonrie(boolean sonrie) {
        this.sonrie = sonrie;
    }

    public void paint(Graphics g) {
        // TODO Auto-generated method stub
        super.paint(g);
        System.out.println("Estoy en el método paint del JPanel");
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        System.out.println("Estoy en el método paintComponent del JPanel");
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
        if (sonrie) {
            g.drawArc(118, 125, 75, 30, 180, 180);
        } else {
            g.drawArc(118, 125, 75, 30, 180, -180);
        }
    }

}
