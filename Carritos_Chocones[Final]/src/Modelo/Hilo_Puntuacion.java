/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import Vista.GUI_Menu;
import Vista.GUI_Nivel;

/**
 *
 * @author franp
 */
public class Hilo_Puntuacion extends Thread {

    GUI_Nivel guiNivel;
    ArchivoPuntuacion archivo;
    GUI_Menu guiMenu;
    public static int puntuacion = 0;

    public Hilo_Puntuacion(GUI_Nivel guiNivel, ArchivoPuntuacion archivo, GUI_Menu guiMenu) {
        this.guiNivel = guiNivel;
        this.archivo = archivo;
        this.puntuacion = 0;
        this.guiMenu = guiMenu;
    }

    public void aumentarPuntuacion(boolean perdio) {
        if (perdio) { //Si el usuario perdió (true) entonces no se debe seguir aumentando a la cantidad
            if (this.puntuacion > archivo.getPuntuacion()) {
                if (archivo.comprobarArchivo()) {
                    archivo.eliminarAllPuntuaciones();
                    archivo.agregarPuntuacion(guiMenu.getJtf_nombreJugador().getText(), this.puntuacion + "".trim());//Modificar con un método de GUI
                } else {
                    archivo.crearArchivo();
                    archivo.agregarPuntuacion(guiMenu.getJtf_nombreJugador().getText(), this.puntuacion + "".trim());//Modificar con un método de GUI
                }
            }
        } else {
            this.puntuacion += 5;
            guiNivel.getJL_Puntuacion().setText("" + puntuacion);
        }
    }

    public void run() {
        try {
            while (true) {
                if (Hilo_Personaje.perdio) {
//                    wait();
                    sleep(1);
                } else {
                    sleep(1000);
                    aumentarPuntuacion(Hilo_Personaje.perdio);//Cambiar esta variable cuando hayan colisiones y demás
                }
            }
        } catch (Exception exception) {
            System.out.println("Excepción en el método run() de Hilo_Puntuacion " + exception);
        }
    }
}
