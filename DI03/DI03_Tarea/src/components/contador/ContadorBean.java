package components.contador;

import java.awt.Color;
import java.awt.Font;
import java.io.Serializable;
import java.time.Duration;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.ListIterator;
import java.util.Timer;
import java.util.TimerTask;
import javax.swing.JLabel;

/**
 * Componente Contador.
 *
 * @author Iván Estévez Sabucedo
 */
public class ContadorBean extends JLabel implements Serializable {

    private Timer timer; // utilidad contador per se
    private TimerTask task;
    private LocalTime inicio; // instante que se empieza a contar
    private boolean activo; // indica el estado del contador
    private int tiempo; // indica el tiempo a cronometrar
    private ArrayList<ContadorEventListener> listeners; // lista de listeners que están atentos a cambios

    /**
     * Constructor. Establecemos sus propiedades estéticas e iniciamos el
     * ArrayList de listeners y el Timer.
     */
    public ContadorBean() {
        // Propiedades estéticas
        super.setFont(new Font("TimesRoman", Font.BOLD, 22));
        super.setForeground(Color.blue);
        super.setText(" ");

        // Creación del array de listeners
        this.listeners = new ArrayList<>();

        // Creación del timer
        this.timer = new Timer();
    }

    /**
     * Agregamos a nuestro ArrayList de listener el recibido por parámetro.
     *
     * @param listener
     */
    public void addContadorEventListener(ContadorEventListener listener) {
        listeners.add(listener);
    }

    /**
     *
     * @param tiempo que durará el contador
     */
    public void start(int tiempo) {
        this.tiempo = tiempo;
        this.inicio = LocalTime.now(); // guardamos la hora en la que iniciamos
        this.activo = true; // establecemos que el contador está activo
        notifyEventStart();
        
        

        this.task = new TimerTask() {
            @Override
            public void run() {
                LocalTime ahora = LocalTime.now(); // hora cada period establecido en el timer
                Duration duracion = Duration.between(inicio, ahora);

                setText(String.valueOf(duracion.toSeconds()));

                if (duracion.toSeconds() == tiempo) {                    
                    setText("Fin");
                    reset();
                    notifyEventEnd();
                }
                
            }
        };

        this.timer.schedule(this.task, 0, 1000);
    }
    
    public void reset() {
        this.activo = false;
        
        if (this.task != null) this.task.cancel();
    }
    
    private void notifyEventStart() {
        ListIterator<ContadorEventListener> li = listeners.listIterator();
        while (li.hasNext()) {
            li.next().startContador();
        }
    }
    
    private void notifyEventEnd() {
        ListIterator<ContadorEventListener> li = listeners.listIterator();
        while (li.hasNext()) {
            li.next().endContador();
        }
    }
}
