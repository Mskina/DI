/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package formularioinicio;

import javax.swing.*;
import java.awt.*;

public class FormularioInicio {

    public static void main(String[] args) {
        JFrame f = new JFrame();
        Container contenedor = f.getContentPane();
        contenedor.setLayout(new GridBagLayout());
        ((JPanel) contenedor).setBorder(BorderFactory.createTitledBorder("Entrada al sistema"));
        GridBagConstraints c = new GridBagConstraints();
        c.weightx = 0.4;
        c.weighty = 1.0;
        
        //Título usuario
        c.gridwidth = GridBagConstraints.RELATIVE;
        c.gridheight = GridBagConstraints.RELATIVE;
        c.fill = GridBagConstraints.BOTH;
        c.anchor = GridBagConstraints.WEST;
        c.insets = new Insets(2, 5, 2, 0);
        contenedor.add(new JLabel("Usuario"), c);
        
        //Cuadro para escribir usuario
        c.gridwidth = GridBagConstraints.REMAINDER;
        c.gridheight = GridBagConstraints.RELATIVE;
        c.weightx = 1.0;
        c.insets = new Insets(2, 0, 2, 5);
        contenedor.add(new JTextField(), c);
        
        //Título contraseña
        c.gridwidth = GridBagConstraints.RELATIVE;
        c.gridheight = GridBagConstraints.REMAINDER;
        c.weightx = 0.4;
        c.insets = new Insets(2, 5, 2, 0);
        contenedor.add(new JLabel("Contraseña"), c);
        
        //Cuadro para escribir contraseña
        c.gridwidth = GridBagConstraints.REMAINDER;
        c.gridheight = GridBagConstraints.REMAINDER;
        c.weightx = 1.0;
        c.insets = new Insets(2, 0, 2, 5);
        contenedor.add(new JTextField(), c);
        
        f.setSize(220, 110);
        f.setTitle("Login");
        f.setVisible(true);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
