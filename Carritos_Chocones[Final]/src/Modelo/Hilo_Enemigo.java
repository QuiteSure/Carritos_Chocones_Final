/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import Controlador.Controlador_Menu;
import Vista.GUI_Nivel;
import java.util.ArrayList;
import javax.swing.JLabel;

/**
 *
 * @author franp
 */
public class Hilo_Enemigo extends Thread {

    GUI_Nivel guiNivel;

    public Hilo_Enemigo(GUI_Nivel guiNivel) {
        this.guiNivel = guiNivel;
    }

    public void desecharEnemigo() {
        ArrayList<JLabel> enemigos = guiNivel.arrayEnemigos();
        for (int indice = 0; indice < enemigos.size(); indice++) {
            if (enemigos.get(indice).getY() >= 805) {
                enemigos.get(indice).remove(guiNivel);
                guiNivel.arrayEnemigos().remove(indice);
            }
        }
    }

    public void run() {
        try {
            while (true) {
                if (Hilo_Personaje.perdio) {
//                    wait();
                    sleep(1);
                } else {
                    sleep(Controlador_Menu.velocidadNivel);
//                guiNivel.setNuevoEnemigo();
                    guiNivel.moverEnemigoAbajo();
//                 guiNivel.imprimama();
                    desecharEnemigo();
                }
            }
        } catch (Exception exception) {
            System.out.println("Excepción en el método run de HiloEnemigo" + exception);
        }
    }
}
