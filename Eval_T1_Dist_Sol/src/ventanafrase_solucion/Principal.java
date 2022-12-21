/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ventanafrase_solucion;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.JColorChooser;

import java.awt.Color;

public class Principal implements ActionListener,FocusListener {

	Frase miFrase;
	Ventanafrase_solucion ventanaPrincipal;

	public Principal() {
		ventanaPrincipal = new Ventanafrase_solucion();
		miFrase = new Frase();
		ventanaPrincipal.cuadroFrase.addFocusListener(this);
		ventanaPrincipal.botonProcesar.addActionListener(this);
		ventanaPrincipal.botonLimpiar.addActionListener(this);
		ventanaPrincipal.botonSalir.addActionListener(this);
		ventanaPrincipal.botonMostrar.addActionListener(this);
		ventanaPrincipal.botonPintar.addActionListener(this);

	}

	public static void main(String[] args) {
		// TODO code application logic here
		Principal ventana = new Principal();

		ventana.ventanaPrincipal.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		String[] palabras;

		String cadena = new String();

		if (arg0.getActionCommand().equals("Procesar frase")) {
			miFrase.setCadena(ventanaPrincipal.cuadroFrase.getText());

			ventanaPrincipal.panelCentral.cuadros[0].setText(Integer.toString(miFrase.contarLetras()));
			ventanaPrincipal.panelCentral.cuadros[1].setText(Integer.toString(miFrase.contarPalabras()));

			ventanaPrincipal.panelCentral.cuadros[2].setText(miFrase.invertirFrase().toString());
			palabras = miFrase.separarPalabras();

			for (int i = 0; i < palabras.length; i++)
				cadena = cadena + (palabras[i] + "-");

			ventanaPrincipal.panelCentral.cuadros[3].setText(cadena);
			ventanaPrincipal.panelCentral.cuadros[4].setText(Integer.toString(miFrase.primeraVocal()));
		}
		if (arg0.getActionCommand().equals("Salir"))
			System.exit(0);

		if (arg0.getActionCommand().equals("Limpiar")) {
			for (int i = 0; i < ventanaPrincipal.panelCentral.cuadros.length; i++) {
				ventanaPrincipal.panelCentral.cuadros[i].setText("");
				ventanaPrincipal.cuadroFrase.setText("");
				ventanaPrincipal.cuadroFrase.requestFocus();
				ventanaPrincipal.botonMostrar.setEnabled(false);
				ventanaPrincipal.botonPintar.setEnabled(false);
			}

		}

		if (arg0.getActionCommand().equals("Mostrar")) {
			ventanaPrincipal.panelDibujo.setTexto(ventanaPrincipal.cuadroFrase.getText());
			ventanaPrincipal.panelDibujo.repaint();

		}

		if (arg0.getActionCommand().equals("Pintar")) {

			Color initialcolor = Color.RED;
			Color color = JColorChooser.showDialog(ventanaPrincipal, "Elige el color", initialcolor);

			ventanaPrincipal.panelDibujo.setColor(color);
			ventanaPrincipal.repaint();

		}

	}

	@Override
	public void focusGained(FocusEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void focusLost(FocusEvent e) {
		// TODO Auto-generated method stub
		
			ventanaPrincipal.botonMostrar.setEnabled(true);
			ventanaPrincipal.botonPintar.setEnabled(true);
		}
		
	
}
