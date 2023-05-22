
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.io.ObjectInputStream;
import java.io.*;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class VentanaPrueba extends JFrame{
    JPanel j_PanelContador;
    JPanel j_PanelCronometro;
    JPanel j_Panel;
    JPanel j_PanelBotones;
    Boton bStart,bStop,bReset;
    Cronometro miCrono,miContador;
    VentanaPrueba(){
       this.setTitle("Cronometro ");
        j_Panel = new JPanel(); //Panel superior que muestra contador y cronometro
        j_PanelCronometro = new JPanel(); //Panel para cronometro
        j_PanelContador = new JPanel();//Panel para contador
        j_PanelBotones=new JPanel();

        j_Panel.setLayout(new GridLayout(1,1));

        j_PanelCronometro.setLayout(new GridBagLayout()); 
        j_PanelCronometro.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        j_PanelContador.setLayout(new GridBagLayout());  
        j_PanelContador.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        j_Panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        
        j_Panel.add(j_PanelContador);
        j_Panel.add(j_PanelCronometro);//Aquí el cronometro debe parar cuando llega a un valor determinado

        bStart = new Boton("Start");
        bStop = new Boton("Stop");
        
        j_PanelBotones.setLayout(new GridLayout(1,3));
        j_PanelBotones.add(bStart);
        j_PanelBotones.add(bStop);
        

        //Poner los botones a la escucha
        bStart.addActionListener(new Manejador(this));;
        bStop.addActionListener(new Manejador(this));
        

        try {
           
            miCrono=new Cronometro(); 
            miContador=new Cronometro(); 
          
            miCrono.addCronometroEventListener(new ManejadorCronometroEventListener());
             //Lanza el evento que hace que el contador empiece a contar. 
            miCrono.setContador(true);
            //Añadir el cronometro a la ventana
            j_PanelCronometro.add(miCrono);
            j_PanelContador.add(miContador);
          
           // flujoEntrada.close();
        } catch (Exception e) {
            // TODO: handle exception

            System.out.println("Este es mi primer error"+ e.getMessage());
        }

        this.add(j_PanelBotones,BorderLayout.SOUTH);
        this.add(j_Panel,BorderLayout.CENTER);
    }

    public static void main(String[] args) {
        
        VentanaPrueba ventana=new VentanaPrueba();
         
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);// finaliza el programa cuando se da click en la X
        ventana.setSize(290, 150);// configurando tamaño de la ventana
        ventana.setVisible(true);// configurando visualización de la ventana
        

    }
}
