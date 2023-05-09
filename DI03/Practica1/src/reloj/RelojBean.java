/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Beans/Bean.java to edit this template
 */
package reloj;

import java.awt.event.ActionEvent;
import java.io.Serializable;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.EventListener;
import java.util.Timer;
import java.util.TimerTask;
import javax.swing.JLabel;

/**
 *
 * @author Iván Estévez Sabucedo
 */
public class RelojBean extends JLabel implements Serializable {

    private Timer timer;
    private LocalTime localTime;
    private boolean hora24; // propiedad para definir 12 o 24h
    private boolean activarAlarma;
    private int horaAlarma;
    private int minutoAlarma;
    private String mensajeAlarma;
    private FinAlarmaListener listener;

    /**
     * Constructor sin parámetros. Se deben iniciar
     */
    public RelojBean() {
        this.timer = new Timer();
        this.localTime = LocalTime.now();
        this.hora24 = true;
    }

    public RelojBean(Timer timer, LocalTime localTime, boolean hora24) {
        this.timer = timer;
        this.localTime = localTime;
        this.hora24 = hora24;
    }

    public Timer getTimer() {
        return timer;
    }

    public void setTimer(Timer timer) {
        this.timer = timer;
    }

    public LocalTime getLocalTime() {
        return localTime;
    }

    public void setLocalTime(LocalTime localTime) {
        this.localTime = localTime;
    }

    public boolean isHora24() {
        return hora24;
    }

    public void setHora24(boolean hora24) {
        this.hora24 = hora24;
    }

    public boolean isActivarAlarma() {
        return activarAlarma;
    }

    public void setActivarAlarma(boolean activarAlarma) {
        this.activarAlarma = activarAlarma;
    }

    public String formateoHora() {
        String patron12 = "hh:mm:ss a";
        String patron24 = "HH:mm:ss";
        String hora = "";
        if (hora24) { // 24 horas
            hora = this.localTime.format(DateTimeFormatter.ofPattern(patron24));
        } else { // 12 horas
            hora = this.localTime.format(DateTimeFormatter.ofPattern(patron12));
        }
        return hora;
    }

    public void iniciarReloj() {
        this.timer.schedule(new TimerTask() {
            @Override
            public void run() {
                System.out.println("Running: " + formateoHora());
                checkAlarma();
                setText(formateoHora());
                repaint();
                localTime = localTime.plusSeconds(1);
            }

        }, 0, 1000);
    }

    public void detenerReloj() {
        this.timer.cancel();
    }

    public void crearAlarma(int hora, int minuto) {
        setActivarAlarma(true);
        this.horaAlarma = hora;
        this.minutoAlarma = minuto;
    }

    private void checkAlarma() {
        if (isActivarAlarma()
                && this.localTime.getHour() == this.horaAlarma
                && this.localTime.getMinute() == this.minutoAlarma
                && this.localTime.getSecond() == 0) {
            //System.out.println("ALARM! ALARM!");
            this.listener.actionFinAlarma();
        }
    }
    
    public void addFinAlarmaListener(FinAlarmaListener listener) {
        this.listener = listener;
    }

}
