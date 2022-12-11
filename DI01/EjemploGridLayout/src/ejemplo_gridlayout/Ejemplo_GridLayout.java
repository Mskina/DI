/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejemplo_gridlayout;

import javax.swing.*;
import java.awt.*;

public class Ejemplo_GridLayout extends JFrame {

    public static void main(String[] args) {
        Ejemplo_GridLayout frame = new Ejemplo_GridLayout();
        Container miContenedor = frame.getContentPane();
        int X = 3;
        int Y = 3;
        miContenedor.setLayout(new GridLayout(X, Y));
        for (int i = 0; i < X; i++) {
            for (int j = 0; j < Y; j++) {
                miContenedor.add(new JButton(i + " x " + j));
            }
        }
        frame.setSize(400, 300);
        frame.setTitle("Prueba de GridLayout");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
