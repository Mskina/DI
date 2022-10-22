/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Beatriz
 */
import java.awt.*;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

class MiBoton extends JButton{
	MiBoton(){
		super();
	}
	
	MiBoton(String titulo){
		super(titulo);
	}
}


public class GUIEventoRaton extends JFrame{
	JFrame miVentana;
    JPanel MiPanel;
    JTextField CampoTexto;
    JButton MiBotonHola,MiBotonVentana,MiBotonLimpiar;
    
    //Constructor de la interfaz

    GUIEventoRaton(){
        
        MiPanel=new JPanel();
        MiBotonHola  = new MiBoton("Hola");
        MiBotonVentana = new MiBoton("Ventana");
        MiBotonLimpiar = new MiBoton("Limpiar");

        CampoTexto = new JTextField(20);

        MiPanel.setLayout(new FlowLayout());

        MiPanel.add(MiBotonHola);
        MiPanel.add(MiBotonVentana);
        MiPanel.add(MiBotonLimpiar);

        this.add(MiPanel);
        this.add(CampoTexto,BorderLayout.NORTH);

        MiBotonHola.addActionListener(new TratarEventos(CampoTexto)); 
        MiBotonVentana.addActionListener(new TratarEventos(CampoTexto));
        MiBotonLimpiar.addActionListener(new TratarEventos(CampoTexto));

        this.setTitle("Formulario1");
        this.setSize(400,200);
        

    }


}
