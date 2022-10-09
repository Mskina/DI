/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package di01_tarea01;

import java.awt.Color;
import java.awt.Font;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;

/**
 * Clase propia para la creación de botones, hereando de JButton
 * @author Iván Estévez Sabucedo
 */
public class Boton extends JButton {

    Boton() {
        super.setFont(new Font("Monoespaced", Font.BOLD, 18));
        super.setHorizontalAlignment(JLabel.CENTER);
        super.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, Color.gray));
        super.setOpaque(true);
    }

    Boton(String texto) {
        super(texto);
        super.setHorizontalAlignment(JLabel.CENTER);
        super.setFont(new Font("Monoespaced", Font.BOLD, 18));
        super.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, Color.gray));

        super.setOpaque(true);
    }

}
