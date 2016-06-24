/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import Vista.GUI_Nivel;

/**
 *
 * @author franp
 */
public class Hilo_NuevoPersonaje extends Thread {

    GUI_Nivel guiNivel;

    public Hilo_NuevoPersonaje(GUI_Nivel guiNivel) {
        this.guiNivel = guiNivel;
    }

    public void run() {

        try {
            while (true) {

                if (Hilo_Personaje.perdio) {
//                    wait();
                    sleep(1);
                } else {
                    sleep(5000);
                    this.guiNivel.setNuevoPersonaje();
                }
            }
        } catch (Exception exception) {
            System.out.println("Excepción en el método run de Hilo_NuevoPersonaje" + exception);
        }
    }
}
