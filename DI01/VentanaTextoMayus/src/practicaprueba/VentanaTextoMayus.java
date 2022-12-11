/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practicaprueba;

import javax.swing.*;
import java.awt.*;

/**
 *
 * @author mskin
 */
public class VentanaTextoMayus extends JFrame {

    Font letra;
    JLabel JLtexto;
    JCheckBox JChBmayuscula;
    JTextField JTFtexto;
    Container conpane;

    //Constructor
    public VentanaTextoMayus() {

        //LLama al constructor del JFrame
        super("Ejemplo de uso de JCheckBox");

        conpane = getContentPane();
        letra = new Font("SansSerif", Font.BOLD, 18);
        JLtexto = new JLabel("Introduce un texto cualquiera");
        JLtexto.setFont(letra);
        JLtexto.setAlignmentX(Label.CENTER_ALIGNMENT);
        JTFtexto = new JTextField(40);
        JTFtexto.setFont(new Font("SansSerif", Font.ITALIC, 14));
        JChBmayuscula = new JCheckBox("Convertir el texto a mayúsculas");
        JChBmayuscula.setFont(letra);

        try {
            JChBmayuscula.setDisplayedMnemonicIndex(0);
        } catch (IllegalArgumentException e) {
            System.err.print(e.getMessage());
        }

        conpane.setLayout(new FlowLayout());

        //Añade los componentes al contenedor del JFrame
        conpane.add(JLtexto);
        conpane.add(JTFtexto);
        conpane.add(JChBmayuscula);

        this.setSize(550, 150);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //Modificar la propiedad de la ventana para que no se pueda redimensionar
        this.setResizable(false);
    }
}
