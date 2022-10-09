/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejemplo_flowlayout;

import javax.swing.*;
public class Ejemplo_FlowLayout extends JFrame{
public static void main(String args[]){
 Ejemplo_FlowLayout frame = new Ejemplo_FlowLayout();
 JPanel panel = new JPanel();
 JButton boton1 = new JButton("Boton 1");
 JButton boton2 = new JButton("Este es el boton 2");
 JButton boton3 = new JButton("Boton 3");
 panel.add(boton1);
 panel.add(boton2);
 panel.add(boton3);
 frame.setContentPane(panel);
 frame.setSize(350,150);
 frame.setTitle("Prueba de FlowLayout");
 frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
 frame.setVisible(true);
} }

