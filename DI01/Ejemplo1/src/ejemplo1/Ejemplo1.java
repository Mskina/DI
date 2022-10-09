/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejemplo1;

import javax.swing.*;

public class Ejemplo1 extends JFrame {

    public static void main(String args[]) {

        Ejemplo1 miVentana = new Ejemplo1();
        JPanel miPanel = new JPanel();
        JButton boton1 = new JButton("Boton 1");
        JButton boton2 = new JButton("Este es el boton 2");
        JButton boton3 = new JButton("Boton 3");
        miPanel.add(boton1);
        miPanel.add(boton2);
        miPanel.add(boton3);
        
        JLabel label1 = new JLabel("Etiqueta");
        miPanel.add(label1);
        
        JCheckBox chkbox1 = new JCheckBox("¿Celíaco?");
        miPanel.add(chkbox1);
        
        JRadioButton radio = new JRadioButton("Prueba botón", true);
        miPanel.add(radio);

        miVentana.setContentPane(miPanel);
        miVentana.setSize(350, 150);
        miVentana.setTitle("Prueba de FlowLayout");
        miVentana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        miVentana.setVisible(true);
    }
}
