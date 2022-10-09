/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejemplo_borderlayout;

/**
 *
 * @author mskin
 */
import javax.swing.*;
import java.awt.*;

public class Ejemplo_BorderLayout extends JFrame {

    public static void main(String[] args) {
        Ejemplo_BorderLayout frame = new Ejemplo_BorderLayout();
        Container Mipanel = frame.getContentPane();
        JButton norte = new JButton("Norte");
        JButton sur = new JButton("Sur");
        JButton este = new JButton("Este");
        JButton oeste = new JButton("Oeste");
        JButton centro = new JButton("Centro");
        Mipanel.add(norte, BorderLayout.NORTH);
        Mipanel.add(sur, BorderLayout.SOUTH);
        Mipanel.add(este, BorderLayout.EAST);
        Mipanel.add(oeste, BorderLayout.WEST);
        Mipanel.add(centro, BorderLayout.CENTER);
        frame.setSize(350, 150);
        frame.setTitle("Prueba de BorderLayout");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
