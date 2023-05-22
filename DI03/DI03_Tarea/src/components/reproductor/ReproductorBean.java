package components.reproductor;

import components.contador.ContadorBean;
import components.contador.ContadorEventListener;
import java.awt.Dimension;
import java.awt.GridBagLayout;
import java.io.Serializable;
import java.util.List;
import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import ui.ContadorListenerImpl;

/**
 *
 * @author Iván Estévez Sabucedo
 */
public class ReproductorBean extends JPanel implements Serializable, ContadorEventListener {

    private JLabel escena1;
    private JLabel escena2;
    private JLabel escena3;
    private ContadorBean contador;
    private int numImagen;
    private List<Imagen> imagenes;

    public ReproductorBean() {
        initComponents();
    }

    private void initComponents() {
        escena1 = new JLabel();
        escena1.setPreferredSize(new Dimension(250, 250));
        escena1.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 2));

        escena2 = new JLabel();
        escena2.setPreferredSize(new Dimension(250, 250));
        escena2.setBorder(BorderFactory.createEmptyBorder(0, 2, 0, 2));

        escena3 = new JLabel();
        escena3.setPreferredSize(new Dimension(250, 250));
        escena3.setBorder(BorderFactory.createEmptyBorder(0, 2, 0, 0));

        this.setLayout(new GridBagLayout());

        this.add(escena1);
        this.add(escena2);
        this.add(escena3);
    }

    public void setContador(ContadorBean contador) {
        this.contador = contador;
        this.contador.addContadorEventListener(this);
        this.contador.addContadorEventListener(new ContadorListenerImpl()); // Como prueba para añadir 2 listeners
    }
    
    public void cargarEscena(List<Imagen> imagenes) {
        this.limpiarEscena();
        
        this.imagenes = imagenes;
        this.numImagen = 0;

        empezarNuevoContador();
    }

    private void empezarNuevoContador() {
        System.out.println("Iniciando contador escena " + this.numImagen);

        contador.reset();
        contador.start(imagenes.get(this.numImagen).getDuracion());
    }

    @Override
    public void startContador() {
        switch (this.numImagen) {
            case 0:
                this.escena1.setIcon(imagenes.get(this.numImagen).getIcon());
                break;
            case 1:
                this.escena2.setIcon(imagenes.get(this.numImagen).getIcon());
                break;
            case 2:
                this.escena3.setIcon(imagenes.get(this.numImagen).getIcon());
                break;
        }
    }

    @Override
    public void endContador() {
        System.out.println("Fin contador escena " + this.numImagen);
        this.numImagen++;

        if (this.numImagen <= 2) {
            empezarNuevoContador();
        }
    }

    @Override
    public void resetContador() {
        // Nunca lo llamamos porque al resetear, reiniciamos el contador.
    }

    public void resetEscena() {
        this.cargarEscena(this.imagenes);
    }
    
    private void limpiarEscena() {
        contador.reset();

        this.escena1.setIcon(null);
        this.escena2.setIcon(null);
        this.escena3.setIcon(null);
    }
}
