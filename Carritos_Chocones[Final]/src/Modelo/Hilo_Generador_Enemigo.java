/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import Controlador.Controlador_Menu;
import Vista.GUI_Nivel;
import static java.lang.Thread.sleep;
import static java.lang.Thread.sleep;
import static java.lang.Thread.sleep;
import static java.lang.Thread.sleep;

/**
 *
 * @author franp
 */
public class Hilo_Generador_Enemigo extends Thread {

    GUI_Nivel guiNivel;

    public Hilo_Generador_Enemigo(GUI_Nivel guiNivel) {
        this.guiNivel = guiNivel;
    }

    public void run() {
        try {
            while (true) {
                if (Hilo_Personaje.perdio){
//                    wait();
                   sleep(1);
                }else{
                if (Controlador_Menu.velocidadNivel == 100) {
                    sleep(1000);
                    guiNivel.setNuevoEnemigo();
                }
                if (Controlador_Menu.velocidadNivel == 75) {
                    sleep(750);
                    guiNivel.setNuevoEnemigo();
                }
                if (Controlador_Menu.velocidadNivel == 25) {
                    sleep(500);
                    guiNivel.setNuevoEnemigo();
                }
                }
            }
        } catch (Exception exception) {
            System.out.println("Excepción en el método run de Hilo_Generador_Enemigo" + exception);
        }
    }
}
