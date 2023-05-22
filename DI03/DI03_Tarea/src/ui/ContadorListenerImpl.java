/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ui;

import components.contador.ContadorEventListener;

/**
 * Si fuese necesario tener una clase aparte. Realmente complica todo ya que
 * habría que enviar/recibir los datos de ReproductorBean.
 *
 * @author Iván Estévez Sabucedo
 */
public class ContadorListenerImpl implements ContadorEventListener {

    @Override
    public void startContador() {
        System.out.println("Empieza contador");
    }

    @Override
    public void endContador() {
        System.out.println("Acaba contador");
    }

    @Override
    public void resetContador() {
        System.out.println("Reset contador");
    }

}
