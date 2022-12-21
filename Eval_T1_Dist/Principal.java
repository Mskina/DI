

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.JColorChooser;

import java.awt.Color;

public class Principal  {

	Frase miFrase;
	VentanaFrase ventanaPrincipal;

	public Principal() {
		ventanaPrincipal = new VentanaFrase();
		miFrase = new Frase();
		

	}

	public static void main(String[] args) {
		// TODO code application logic here
		Principal ventana = new Principal();

		ventana.ventanaPrincipal.setVisible(true);
	}
}

	