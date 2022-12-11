/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package punto;

import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.BasicStroke;

/**
 *
 * @author Iván Estévez Sabucedo
 */
public class PanelDibujo extends JPanel{
    private Punto p1;
    private Punto p2;
    private Boolean limpiar;

    public PanelDibujo(){
        p1=new Punto();
        p2=new Punto();
        this.limpiar=false;
    }

    public PanelDibujo(Punto p1,Punto p2){
        this.p1=p1;
        this.p2=p2;
        this.limpiar=false;
    }

    public void asignarPunto(Punto p1,Punto p2){
        this.p1.asignarX(p1.obtenerX());
        this.p1.asignarY(p1.obtenerY());
        this.p2.asignarX(p2.obtenerX());
        this.p2.asignarY(p2.obtenerY());
    }

    public void setLimpiar(Boolean limpiar){
        this.limpiar=limpiar;
    }

    public boolean getLimpiar(){
        return this.limpiar;
    }

    @Override
    public void paintComponent(Graphics g) {
        // TODO Auto-generated method stub
        super.paintComponent(g);
      
        int width=0;
        String figura="RECTANGULO";
        g.setFont(new Font("Arial",Font.BOLD+Font.ITALIC,22));
        
        try {
            width=(int)(this.p2.obtenerX())-(int)(this.p1.obtenerX());
            
        } catch (Exception e) {
            // TODO: handle exception
            System.out.println("El punto 2 debe ser mayor que el punto 1");
        }
        if (this.limpiar){
            g.setColor(Color.gray);
            g.fillRect((int)(p1.obtenerX()), (int)(p1.obtenerY()), width, width);
        }
        else{
        g.setColor(Color.RED);
        g.drawString(figura, (figura.length()+this.getWidth()/4), 40);

        g.setColor(Color.yellow);
        g.drawRect((int)(p1.obtenerX()), (int)(p1.obtenerY()), width, width);
        g.setColor(Color.blue);
        g.fillRect((int)(p1.obtenerX()+2), (int)(p1.obtenerY()+2), width-2, width-2);
        }
        
     }
}

