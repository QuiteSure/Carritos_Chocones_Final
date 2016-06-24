/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import Vista.GUI_Menu;
import Vista.GUI_Nivel;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 *
 * @author franp
 */
public class Hilo_Personaje extends Thread {

    GUI_Nivel guiNivel;
    Hilo_Fondo hiloFondo;
    Hilo_Personaje hiloPersonaje;
    Hilo_Enemigo hiloEnemigo;
    Hilo_Puntuacion hiloPuntuacion;
    Hilo_Generador_Enemigo hiloGeneradorEnemigo;
    GUI_Menu guiMenu;
    public static boolean perdio = false;

    public Hilo_Personaje(GUI_Nivel gui, Hilo_Fondo hiloFondo, Hilo_Personaje personaje, Hilo_Enemigo hiloEnemigo,
            Hilo_Puntuacion hiloPuntuacion, Hilo_Generador_Enemigo hiloGeneradorEnemigo, GUI_Menu guiMenu) {
        this.guiNivel = gui;
        this.hiloFondo = hiloFondo;
        this.hiloPersonaje = personaje;
        this.hiloEnemigo = hiloEnemigo;
        this.hiloPuntuacion = hiloPuntuacion;
        this.hiloGeneradorEnemigo = hiloGeneradorEnemigo;
        this.guiMenu = guiMenu;
    }

    public JLabel getPersonaje() {
        return guiNivel.getPersonaje();
    }

    public void moverDerecha() {
        if (getPersonaje().getX() + 175 >= 670) {

        } else {
            getPersonaje().setLocation(getPersonaje().getX() + 160, getPersonaje().getY()); //390 (default) + 160= 550 [230][390][550]
        }
    }

    public void moverIzquierda() {
        if (getPersonaje().getX() - 175 <= 160) {

        } else {
            getPersonaje().setLocation(getPersonaje().getX() - 160, getPersonaje().getY()); //390 (default) - 160= 230 [230][390][550]
        }
    }

    public void run() {
        int respuesta = -1;
        try {
            while (true) {
                sleep(10);
                if (guiNivel.colision()) {
                    this.perdio = true;
                    GUI_Nivel.enemigos.get(GUI_Nivel.indice).removeAll();
                    if (Hilo_Personaje.perdio) {
                        guiNivel.haciaAtras();
                        respuesta = guiNivel.mensajeConInput("¡Perdiste! ¿Quieres volver a intentarlo?");
                        if (respuesta == 0) {
                            sleep(4000);
                            perdio=false;
//                            guiNivel.esconder();
                        } else {
                            GUI_Menu.cerrarJuego();
                        }
//                        wait();
                        sleep(1000);
                    } else {

                        /*this.hiloEnemigo.interrupt();
                    this.hiloFondo.interrupt();
                    this.hiloGeneradorEnemigo.interrupt();*/
 /* this.hiloPuntuacion.aumentarPuntuacion(false);
                    this.hiloPuntuacion.interrupt();
                    GUI_Menu.cerrarJuego();*/
//                     String volver= guiNivel.mensajeConInput("Perdiste ¿Quieres volver a intentarlo? si/no");
//                    if (volver.equalsIgnoreCase("si")) {
//                        GUI_Menu.cerrarJuego();  
//                    } else {                      
//                        GUI_Menu.cerrarJuego();
//                    }
                    }
                } else {
//                    this.perdio=false;
                }
            }
        } catch (Exception e) {
            System.out.println("Excepcion en Hilo_Personaje.run(): " + e);
        }
    }
}
