/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graphics01;

import java.awt.Graphics;
import javax.swing.JPanel;

/**
 *
 * @author Iván Estévez Sabucedo
 */
public class DrawPanel extends JPanel {

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g); //To change body of generated methods, choose Tools | Templates.
        g.drawLine(0, 0, 800, 600);
    }
    
}
