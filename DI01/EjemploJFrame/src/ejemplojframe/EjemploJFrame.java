/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejemplojframe;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JComboBox;

/**
 *
 * @author Iván Estévez Sabucedo
 */
public class EjemploJFrame extends JFrame implements ItemListener {

    // Declaracion de las propiedades de la ventana
    Color colorLinea;
    Color colorRelleno;
    JLabel jlinea;
    JLabel jrelleno;
    listaColores colores;
    listaColores colores1;
    JPanel panelSup;

    public EjemploJFrame() {

        // Iniciarlizar las propiedades de la ventana
        colorLinea = new Color(0, 0, 0);
        colorRelleno = new Color(0, 0, 0);
        jlinea = new JLabel("Color linea");

        jrelleno = new JLabel("Color relleno");

        colores = new listaColores();

        colores1 = new listaColores();

        panelSup = new JPanel();
        // panelInf = new PanelFiguras1();

        panelSup.setLayout(new GridLayout(1, 4));
        panelSup = new JPanel();

        panelSup.add(jlinea);
        panelSup.add(colores);
        panelSup.add(jrelleno);
        panelSup.add(colores1);

        add(panelSup, BorderLayout.NORTH);

        // Poner a la escucha las listas desplegables
        colores.addItemListener(this);
        colores1.addItemListener(this);

    }

    @Override
    public void paint(Graphics g) {
        // TODO Auto-generated method stub
        super.paint(g);

        System.out.println("estoy en el paint " + this.getClass().getCanonicalName());
        this.setBackground(Color.gray);

        g.drawString("DIBUJAR FIGURAS", this.getWidth() / 2, 140);
        g.setColor(colorLinea);
        g.drawLine(0, 170, 100, 170);
        g.drawRect(150, 170, 50, 70);
        g.drawRoundRect(250, 170, 50, 70, 6, 6);
        g.drawOval(350, 170, 50, 70);
        int[] vx1 = {500, 550, 450};
        int[] vy1 = {170, 220, 220};
        g.drawPolygon(vx1, vy1, 3);

        g.setColor(colorRelleno);
        g.fillRect(150, 270, 50, 70);
        g.fillRoundRect(250, 270, 50, 70, 6, 6);
        g.fillOval(350, 270, 50, 70);
        int[] vx2 = {500, 550, 450};
        int[] vy2 = {270, 320, 320};
        g.fillPolygon(vx2, vy2, 3);

    }

    @Override
    public void paintAll(Graphics g) {
        // TODO Auto-generated method stub
        super.paintAll(g);
        System.out.println("Es el metodo paintAll");
    }

    public void itemStateChanged(ItemEvent arg0) {

        // TODO Auto-generated method stub
        if (arg0.getSource() == colores) {
            colorLinea = colores.devolverColor(arg0.getItem().toString());
        }
        if (arg0.getSource() == colores1) {
            colorRelleno = colores1.devolverColor(arg0.getItem().toString());
        }

        // Tenemos que llamar a la funcion que vuelve a pintar el JFrame
        repaint();

    }

    public static void main(String[] args) {
        EjemploJFrame miVentana = new EjemploJFrame();
        miVentana.setSize(600, 600);
        miVentana.setVisible(true);
        miVentana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

}

class listaColores extends JComboBox<String> {

    listaColores() {
        super();
        addItem("Negro");
        addItem("Gris obscuro");
        addItem("Gris");
        addItem("Gris claro");
        addItem("Rojo");
        addItem("Azul");
        addItem("Verde");
        addItem("Amarillo");
        addItem("Naranja");
        addItem("Blanco");
    }

    Color devolverColor(String name) {

        if (name.equals("Negro")) {
            return Color.black;
        }
        if (name.equals("Gris oscuro")) {
            return Color.darkGray;
        }
        if (name.equals("Gris")) {
            return Color.gray;
        }
        if (name.equals("Gris claro")) {
            return Color.lightGray;
        }
        if (name.equals("Rojo")) {
            return Color.red;
        }
        if (name.equals("Azul")) {
            return Color.blue;
        }
        if (name.equals("Verde")) {
            return Color.green;
        }
        if (name.equals("Amarillo")) {
            return Color.yellow;
        }
        if (name.equals("Naranja")) {
            return Color.orange;
        }
        if (name.equals("Blanco")) {
            return Color.white;
        } else {
            return Color.black;
        }
    }
}
