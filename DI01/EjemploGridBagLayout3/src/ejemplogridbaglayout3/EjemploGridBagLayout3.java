/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejemplogridbaglayout3;

import javax.swing.*;
import java.awt.*;

/**
 *
 * @author Iván Estévez Sabucedo
 */
public class EjemploGridBagLayout3 extends JFrame
 {
     /**
      * Constructor por defecto.
      */
     public EjemploGridBagLayout3()
     {
         super ("Ejemplo 3 GridBagLayout");
         this.getContentPane().setLayout(new GridBagLayout());
         
         GridBagConstraints constraints = new GridBagConstraints();
         
         JTextArea cajaTexto = new JTextArea("Area texto");
         constraints.gridx = 0;
         constraints.gridy = 0;
         constraints.gridwidth = 2;
         constraints.gridheight = 2;
         
	 // El area de texto debe estirarse en ambos sentidos.
         constraints.fill = GridBagConstraints.BOTH; 
         constraints.weighty = 1.0;
         this.getContentPane().add (cajaTexto, constraints);
         constraints.weighty = 0.0;
         
         
         JButton boton1 = new JButton ("Boton 1");
         constraints.gridx = 2;
         constraints.gridy = 0;
         constraints.gridwidth = 1;
         constraints.gridheight = 1;
         constraints.weighty = 1.0;
         
	 // El botón 1 debe ocupar la posición NORTH de su celda
         constraints.anchor = GridBagConstraints.NORTH; 
         
	 // El botón 1 no debe estirarse. Habíamos cambiado este valor en el
	 // area de texto, asi que lo restauramos.
         constraints.fill = GridBagConstraints.NONE;
         this.getContentPane().add (boton1, constraints);
         constraints.anchor = GridBagConstraints.CENTER;
         constraints.weighty = 0.0;
         
         JButton boton2 = new JButton ("Boton 2");
         constraints.gridx = 2;
         constraints.gridy = 1;
         constraints.gridwidth = 1;
         constraints.gridheight = 1;
         constraints.weighty = 1.0;
         
	 // El boton 2 debe ocupar la posición NORTH de su celda.
         constraints.anchor = GridBagConstraints.NORTH;
         this.getContentPane().add (boton2, constraints);
         constraints.weighty = 0.0;
         constraints.anchor = GridBagConstraints.CENTER;
         
         JButton boton3 = new JButton ("Boton 3");
         constraints.gridx = 0;
         constraints.gridy = 2;
         constraints.gridwidth = 1;
         constraints.gridheight = 1;
         this.getContentPane().add (boton3, constraints);
         
         JButton boton4 = new JButton ("Boton 4");
         constraints.gridx = 2;
         constraints.gridy = 2;
         constraints.gridwidth = 1;
         constraints.gridheight = 1;
         this.getContentPane().add (boton4, constraints);
         
         JTextField campoTexto = new JTextField ("Campo texto");
         constraints.gridx = 1;
         constraints.gridy = 2;
         constraints.gridwidth = 1;
         constraints.gridheight = 1;
         constraints.weightx = 1.0;
         
	 // El campo de texto debe estirarse sólo en horizontal.
         constraints.fill = GridBagConstraints.HORIZONTAL;
         this.getContentPane().add (campoTexto, constraints);
     }
 
     
     public static void main( String args[]) {
         EjemploGridBagLayout3 miVentana = new EjemploGridBagLayout3();
         miVentana.setSize(300,200);
         miVentana.setVisible(true);
     }
          
}

