package Contador;

import javax.swing.JLabel;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;
import java.time.LocalTime;
import java.time.Duration;
import java.util.ListIterator;
import java.awt.*;

/**
 *
 * @author Ignacio Brea Lodeiro
 */
public class Contador extends JLabel implements Serializable {
    
    private ArrayList<ContadorEventListener> listeners; //Lista de manejadores de eventos
    private TimerTask task; //Aun no se muy bien para que se necesita esto
    private Timer timer; //A ver para que usaremos esto
    private LocalTime time, inicio; //Para saber cuando empezo el contador y el tiempo actual
    private int tiempo; //Propiedad que indica los segundos a contar
    
    
    //Constructor vacio
    public Contador(){
        this.inicio = LocalTime.now(); //anotamos la hora de creación del objeto
        //No olvidemos que el contador hereda de JLabel para que se muestre la cuenta donde la pongamos
        super.setFont(new Font("TimesRoman", Font.BOLD, 22)); //Establecemos el tipo de letra y tamaño 
        super.setForeground(Color.blue); //Le establecemos el color 
        super.setText(" ");
        //Creamos el almacen de los listeners
        listeners = new ArrayList<>();
        //Creamos el temporizador
        timer = new Timer();
    }
// <editor-fold defaultstate="collapsed" desc="Getters y Setters de todas las propiedades"> 
    
    public TimerTask getTask(){
        return task;
    }
    
    public void setTask(TimerTask task){
        this.task = task;
    }
    
    public Timer getTimer(){
        return timer;
    }
    
    public void setTimer(Timer timer){
        this.timer = timer;
    }
    
    public LocalTime getTime(){
        return time;
    }
    
    public void setTime(LocalTime time){
        this.time = time;
    }
    
    public LocalTime getInicio(){
        return inicio;
    }
    
    public void setInicio(LocalTime inicio){
        this.inicio = inicio;
    }
    
    public int getTiempo(){
        return tiempo;
    }
    
    public void setTiempo(int tiempo){
        this.tiempo = tiempo;
    }

    
    
    // </editor-fold>
    

    public void addContadorEventListener(ContadorEventListener listener){
        //Añadimos el manejador de evento a nuestra lista de listeners
        listeners.add(listener);
    }
    
    private void notificaInicioCuenta(){
        ListIterator<ContadorEventListener> li = listeners.listIterator();
        while (li.hasNext()){ //Recorremos la lista de manejadores
            li.next().inicioCuenta(new ContadorEventObject(this)); //Ejecutamos para cada uno su implementación del manejador del evento
        }
    }
    private void notificaFinCuenta(){
        ListIterator<ContadorEventListener> li = listeners.listIterator();
        while (li.hasNext()){ //Recorremos la lista de manejadores
            li.next().finCuenta(new ContadorEventObject(this)); //Ejecutamos para cada uno su implementación del manejador del evento
        }
    }
    
    //Metodo para iniciar una cuenta de X segundos
    public final void iniciarCuenta(int tiempo){
        notificaInicioCuenta();
        inicio = LocalTime.now(); //Anotamos la hora de inicio
       //timer = new Timer(); //Creamos un nuevo objeto cronómetro de Java
        task = new TimerTask() //Y creamos una nueva tarea para el cronómetro
            {
                @Override
                public void run()
                {
                    time = LocalTime.now(); //Anotamos la hora actual
                    
                    Duration duracion = Duration.between(inicio, time); //recogemos la duración entre tiempos
                    long seconds = duracion.toSeconds();
                    String formattedTime = String.format("%02d:%02d", seconds / 60, seconds % 60);
                    setText(formattedTime); //Establecemos el valor del texto de la etiqueta al número de segundos transcurridos formateados como "00:00"
                    //setText(String.valueOf(duracion.toSeconds())); //Establecemos el valor del texto de la etiqueta al número de segundos transcurridos
                    if (tiempo == (int) duracion.toSeconds()){ //Si los segundos transcurridos llegan a los que queremos contar
                        notificaFinCuenta(); //Avisamos a los listeners de que terminó la cuenta
                        //pararCuenta(); //Paramos el cronómetro de Java
                    }
                }
            };
        timer.schedule(task, 0, 1000);
    }
    
    //Metodo para detener el cronómetro de Java
    public void pararCuenta(){
        if (task != null){
            task.cancel();
        }
    }
}
