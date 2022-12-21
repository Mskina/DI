package ventanafrase_solucion;


import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import javax.swing.*;
import javax.swing.border.Border;
import java.awt.Color;





class PanelDibujo extends JPanel{
	String texto;
	Color color;
	PanelDibujo(){
		texto=new String();
		color=Color.blue;
	}
	PanelDibujo(String texto,Color color){
		this.texto=texto;
		this.color=color;
	}

	public void setTexto(String texto){
		this.texto=texto;
	}

	public void setColor(Color color){
		this.color=color;
	}

	@Override
	public void paintComponent(Graphics g) {
		// TODO Auto-generated method stub
		super.paintComponent(g);
		
		try {
			g.setFont(new Font("Arial",Font.BOLD,24));
			g.setColor(color);
			g.drawString(texto,this.getWidth()/6,this.getHeight()/3);
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}
}

class PanelCentral extends JPanel {
	JLabel[] etiquetas = new JLabel[5];
	JTextField[] cuadros = new JTextField[5];

	private static GridBagConstraints createConstraints(int gridx, int gridy, int gridwidth, int gridheight,
			double weightx, double weighty, int fill, int anchor, Insets insets) {
		GridBagConstraints constraints = new GridBagConstraints();
		constraints.gridx = gridx;
		constraints.gridy = gridy;
		constraints.gridwidth = gridwidth;
		constraints.gridheight = gridheight;
		constraints.weightx = weightx;
		constraints.weighty = weighty;
		constraints.fill = fill;
		constraints.anchor = anchor;
		constraints.insets = insets;
		return constraints;
	}

	PanelCentral() {
		this.setBorder(BorderFactory.createTitledBorder("Procesar Frase"));
		this.setLayout(new GridBagLayout());

		for (int i = 0; i < etiquetas.length; i++) {
			etiquetas[i] = new JLabel();
			etiquetas[i].setFont(new Font("SansSerif", Font.BOLD, 12));
			etiquetas[i].setAlignmentX(JLabel.CENTER_ALIGNMENT);
			this.add(etiquetas[i], createConstraints(0, i, 1, 1, 0.0, 1.0,
					GridBagConstraints.BOTH, GridBagConstraints.CENTER, new Insets(4, 5, 10, 4)));

			cuadros[i] = new JTextField(40);
			cuadros[i].setEditable(false);
			Border border = BorderFactory.createRaisedSoftBevelBorder();

			cuadros[i].setBorder(border);
			this.add(cuadros[i], createConstraints(1, i, 1, 1, 1.0, 1.0, GridBagConstraints.HORIZONTAL,
					GridBagConstraints.CENTER, new Insets(4, 5, 10, 4)));

		}
		etiquetas[0].setText("Numero de letras");
		cuadros[0].setToolTipText("Muestra el numero de letras de la frase");
		etiquetas[1].setText("Numero de palabras");
		cuadros[1].setToolTipText("Muestra el numero de palabras de la frase");
		etiquetas[2].setText("Invertir frase");
		cuadros[2].setToolTipText("Muestra la frase al revés");
		etiquetas[3].setText("Separar palabras");
		cuadros[3].setToolTipText("Separa las palabras de la frase");
		etiquetas[4].setText("Primera posición vocal");
		cuadros[4].setToolTipText("Muestra la posición de la primera de la frase");
	}

}

public class Ventanafrase_solucion extends JFrame {
	GridBagConstraints restricciones = new GridBagConstraints();
	Container contenedor;
	JLabel JlFrase;
	JTextField cuadroFrase;
	JButton botonProcesar, botonSalir, botonLimpiar;
	JButton botonMostrar,botonPintar;
	
	PanelCentral panelCentral;
	PanelDibujo panelDibujo;

	public Ventanafrase_solucion() {

		super("Interface Frase");
		contenedor = this.getContentPane();
		contenedor.setLayout(new GridBagLayout());
		restricciones = new GridBagConstraints();

		// Restricciones de la etiqueta

		restricciones.insets = new Insets(10, 10, 10, 4);
		JlFrase = new JLabel("Introduce una frase");
		JlFrase.setFont(new Font("SansSerif", Font.BOLD, 18));
		JlFrase.setAlignmentX(JLabel.CENTER_ALIGNMENT);

		anadeGrid(JlFrase, 0, 0, 0.0, 1.0, GridBagConstraints.NONE, GridBagConstraints.CENTER, 1, 1);

		// Restricciones del cuadro de texto

		restricciones.insets = new Insets(0, 10, 10, 4);

		cuadroFrase = new JTextField();
		cuadroFrase.setFont(new Font("SansSerif", Font.BOLD, 18));
		Border border = BorderFactory.createLineBorder(Color.BLUE, 2);
		cuadroFrase.setBorder(border);
		anadeGrid(cuadroFrase, 1, 0, 1.0, 1.0, GridBagConstraints.HORIZONTAL, GridBagConstraints.CENTER, 1, 3);
		
		// Restricciones del boton

		restricciones.insets = new Insets(2, 20, 20, 2);

		botonProcesar = new JButton("Procesar frase");
		botonProcesar.setFont(new Font("SansSerif", Font.BOLD, 18));
		botonProcesar.setAlignmentX(JButton.CENTER_ALIGNMENT);

		try {
			botonProcesar.setDisplayedMnemonicIndex(0);
		} catch (IllegalArgumentException e) {
			System.err.print(e.getMessage());
		}

		anadeGrid(botonProcesar, 0, 1, 1.0, 1.0, GridBagConstraints.VERTICAL, GridBagConstraints.CENTER, 4, 1);

		// Añade el panel de los resultados
		panelCentral = new PanelCentral();
		anadeGrid(panelCentral, 1, 1, 1.0, 1.0, GridBagConstraints.BOTH, GridBagConstraints.NORTHWEST, 3, 1);
		
		// Añade el panel dibujo
		panelDibujo = new PanelDibujo();
		panelDibujo.setBorder(BorderFactory.createTitledBorder("Dibujar Frase"));
		anadeGrid(panelDibujo, 2, 1, 1.0, 1.0, GridBagConstraints.BOTH, GridBagConstraints.NORTHWEST, 3, 2);

		// Añade los botones
		restricciones.insets = new Insets(5, 20, 5, 5);
		botonSalir = new JButton("Salir");
		botonSalir.setFont(new Font("SansSerif", Font.BOLD, 18));
		botonSalir.setAlignmentX(JButton.CENTER_ALIGNMENT);

		anadeGrid(botonSalir, 0, 5, 1.0, 1.0, GridBagConstraints.HORIZONTAL, GridBagConstraints.NORTHEAST, 3, 1);

		setSize(new Dimension(800, 400));
		setMinimumSize(new Dimension(320, 200));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		restricciones.insets = new Insets(5, 20, 5, 5);

		botonLimpiar = new JButton("Limpiar");
		botonLimpiar.setFont(new Font("SansSerif", Font.BOLD, 18));
		botonLimpiar.setAlignmentX(JButton.CENTER_ALIGNMENT);
		anadeGrid(botonLimpiar, 1, 5, 1.0, 1.0, GridBagConstraints.HORIZONTAL, GridBagConstraints.NORTHWEST, 3, 1);


		restricciones.insets = new Insets(5, 20, 5, 5);

		botonPintar = new JButton();
		botonPintar = new JButton("Pintar");
		botonPintar.setFont(new Font("SansSerif", Font.BOLD, 18));
		botonPintar.setAlignmentX(JButton.CENTER_ALIGNMENT);
		botonPintar.setEnabled(false);

		anadeGrid(botonPintar, 2, 5, 1.0, 1.0, GridBagConstraints.HORIZONTAL, GridBagConstraints.NORTHEAST, 3, 1);

		restricciones.insets = new Insets(5, 20, 5, 5);

		botonMostrar = new JButton("Mostrar");
		botonMostrar.setFont(new Font("SansSerif", Font.BOLD, 18));
		botonMostrar.setAlignmentX(JButton.CENTER_ALIGNMENT);
		botonMostrar.setEnabled(false);
		anadeGrid(botonMostrar, 3, 5, 1.0, 1.0, GridBagConstraints.HORIZONTAL, GridBagConstraints.NORTHEAST, 3, 1);

		setSize(new Dimension(1200, 400));
		setMinimumSize(new Dimension(320, 200));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

	// Metodo para añadir restricciones
	private void anadeGrid(Component c, int x, int y, double wx, double wy, int fi, int an, int gh, int gw) {
		restricciones.gridx = x;
		restricciones.gridy = y;

		restricciones.weightx = wx;
		restricciones.weighty = wy;

		restricciones.fill = fi;
		restricciones.anchor = an;
		restricciones.gridheight = gh;
		restricciones.gridwidth = gw;

		add(c, restricciones);
	}

	

}
