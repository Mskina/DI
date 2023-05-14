package components.reproductor;

import javax.swing.ImageIcon;

/**
 *
 * @author Iván Estévez Sabucedo
 */
public class Imagen {

    private ImageIcon icon;
    private int duracion;

    public Imagen(ImageIcon icon, int duracion) {
        this.icon = icon;
        this.duracion = duracion;
    }

    public ImageIcon getIcon() {
        return icon;
    }

    public void setIcon(ImageIcon icon) {
        this.icon = icon;
    }

    public int getDuracion() {
        return duracion;
    }

    public void setDuracion(int duracion) {
        this.duracion = duracion;
    }
    
}