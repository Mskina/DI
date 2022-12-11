/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package carasonriente;

import java.awt.Graphics;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import java.awt.*;
import java.awt.event.ActionEvent;

/**
 *
 * @author Iván Estévez Sabucedo
 */
public class CaraGraphics extends JFrame implements ActionListener {

    BotonCara botonCara;
    PanelCara panel;
    Container c;

    CaraGraphics() {
        panel = new PanelCara();
        botonCara = new BotonCara("Sonrie");

        // Poner el botón a la escucha
        botonCara.addActionListener(this);
        c = this.getContentPane();
        c.add(panel);
        c.add(botonCara, BorderLayout.SOUTH);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    @Override
    public void paint(Graphics g) {
        // TODO Auto-generated method stub
        super.paint(g);
        System.out.println("Estoy en el método paint del JFrame");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("sonrie :" + panel.isSonrie());
        panel.setSonrie(!panel.isSonrie());
        repaint();
    }

}

class BotonCara extends JButton {

    BotonCara() {
        super();
    }

    BotonCara(String titulo) {
        super(titulo);
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        System.out.println("Estoy en el método paint del botón");
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        System.out.println("Estoy en el método paintComponent del botón");
    }
}
