import java.awt.event.*;

public class Manejador implements ActionListener {
    VentanaPrueba interfaz;
    // Crear constructor

    Manejador() {
        this.interfaz = new VentanaPrueba();
    }

    Manejador(VentanaPrueba mInterfaz_VentanaPrueba) {
        this.interfaz = mInterfaz_VentanaPrueba;

    }

    public void actionPerformed(ActionEvent e) {
          
        try {
           if (e.getActionCommand()=="Start") {
            //Iniciar el cronometro
            System.out.println("Iniciar el cronometro con el botón Start");
            this.interfaz.miContador.iniciarCronometro(); 
           }

            if (e.getActionCommand()=="Stop") {
            //Parar el cronometro
            System.out.println("Parar el cronometro con el botón Start");
            this.interfaz.miContador.pararCronometro();
            }

        } catch (Exception ex) {
            // TODO: handle exception
            System.out.println(ex.getMessage());
        }

    }

   

}
