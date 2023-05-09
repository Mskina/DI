/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Beans/Bean.java to edit this template
 */
package temporizador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.Serializable;
import java.util.EventListener;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.Timer;

/**
 *
 * @author Iván Estévez Sabucedo
 */
public class TemporizadorBean extends JLabel implements ActionListener, Serializable {

    protected int tiempo;
    private final Timer timer;
    public static final String PROP_TIEMPO = "tiempo";
    private FinCuentaAtrasListener receptor;

    public interface FinCuentaAtrasListener extends EventListener {
        public void capturarFinCuentaAtras(FinCuentaAtrasEvent ev);
    }

    /**
     * Constructor sin argumentos. Se establece como tiempo por defecto 5
     * segundos.
     */
    public TemporizadorBean() {
        tiempo = 5;
        timer = new Timer(1000, this);
        setText(Integer.toString(tiempo));
        setActivo(true);
    }

    public int getTiempo() {
        return tiempo;
    }

    public void setTiempo(int tiempo) {
        this.tiempo = tiempo;
        setText(Integer.toString(tiempo));
        repaint();
    }

    public boolean getActivo() {
        return timer.isRunning();
    }

    /**
     * Activo es en sí mismo una propiedad, sin atributo subyacente. Gestiona si
     * el temporizador está o no funcionando.
     *
     * @param valor
     */
    public final void setActivo(boolean valor) {
        if (valor) {
            timer.start();
        } else {
            timer.stop();
        }
    }

    /**
     * Acción que se realiza cada vez que se cumplen los milisegundos
     * establecidos para timer. Se modifica el valor del texto de la etiqueta,
     * se repita y se actualiza el tiempo restante. Cuando el tiempo llega a
     * cero, se detiene el timer y se muestra un mensaje de tiempo terminado.
     *
     * @param e
     */
//    @Override
//    public void actionPerformed(ActionEvent e) {
//        setText(Integer.toString(tiempo));
//        repaint();
//        tiempo--;
//        if (tiempo == 0) {
//            setActivo(false);
//            JOptionPane.showMessageDialog(null, "Terminado", "Aviso",
//                    JOptionPane.INFORMATION_MESSAGE);
//        }
//    }
    @Override
    public void actionPerformed(ActionEvent e) {
        setText(Integer.toString(tiempo));
        repaint();
        tiempo--;
        if (tiempo == 0) {
            setActivo(false);
            receptor.capturarFinCuentaAtras(new FinCuentaAtrasEvent(this));
        }
    }

    public void addFinCuentaAtrasListener(FinCuentaAtrasListener receptor) {
        this.receptor = receptor;
    }

    public void removeFinCuentaAtrasListener(FinCuentaAtrasListener receptor) {
        this.receptor = null;
    }
}
