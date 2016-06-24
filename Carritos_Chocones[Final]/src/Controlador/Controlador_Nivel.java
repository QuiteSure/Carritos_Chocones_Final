/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.Hilo_Enemigo;
import Modelo.Hilo_Fondo;
import Modelo.Hilo_Generador_Enemigo;
import Modelo.Hilo_NuevoPersonaje;
import Modelo.Hilo_Personaje;
import Modelo.Hilo_Puntuacion;
import Vista.GUI_Nivel;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

/**
 *
 * @author franp
 */
public class Controlador_Nivel implements ComponentListener, WindowListener {

    GUI_Nivel guiNivel;
    Hilo_Fondo hiloFondo;
    Hilo_Enemigo hiloEnemigo;
    Hilo_Puntuacion hiloPuntuacion;
    Hilo_Generador_Enemigo hiloGeneradorEnemigo;
    Hilo_Personaje personaje;
    String control = "no";
    Hilo_NuevoPersonaje hiloNuevoPersonaje;

    public Controlador_Nivel(GUI_Nivel guiNivel, Hilo_Fondo hiloFondo, Hilo_Enemigo hiloEnemigo,
            Hilo_Puntuacion hiloPuntuacion, Hilo_Generador_Enemigo hiloGeneradorEnemigo, Hilo_Personaje personaje,
            Hilo_NuevoPersonaje hiloNuevoPersonaje) {
        this.guiNivel = guiNivel;
        this.hiloFondo = hiloFondo;
        this.hiloEnemigo = hiloEnemigo;
        this.hiloPuntuacion = hiloPuntuacion;
        this.hiloGeneradorEnemigo = hiloGeneradorEnemigo;
        this.personaje = personaje;
        this.hiloNuevoPersonaje = hiloNuevoPersonaje;
    }

    @Override
    public void componentResized(ComponentEvent componentEvent) {

    }

    @Override
    public void componentMoved(ComponentEvent componentEvent) {

    }

    @Override
    public void componentShown(ComponentEvent componentEvent) {
        try {
            if (control.equals("no")) {
//                this.guiNivel.setFondo();
//                this.hiloFondo.start();
//                this.hiloEnemigo.start();
//                this.hiloPuntuacion.start();
//                this.hiloGeneradorEnemigo.start();
//                this.personaje.start();
            } else {
                this.guiNivel.setFondo();

            }
        } catch (Exception e) {
            System.out.println("Exception en componentShown()" + e);
        }
    }

    @Override
    public void componentHidden(ComponentEvent componentEvent) {
        Hilo_Personaje.perdio = false;
        control = "si";
    }

    @Override
    public void windowOpened(WindowEvent eventoVentana) {
        try {
            if (control.equals("no")) {
                this.guiNivel.setFondo();
                this.hiloFondo.start();
                this.hiloEnemigo.start();
                this.hiloPuntuacion.start();
                this.hiloGeneradorEnemigo.start();
                this.personaje.start();
                this.hiloNuevoPersonaje.start();
            } else {
                this.guiNivel.setFondo();

            }
        } catch (Exception e) {
            System.out.println("Exception en componentShown() -> hiloFondo.start() " + e);
        }
    }

    @Override
    public void windowClosing(WindowEvent eventoVentana) {
        Hilo_Personaje.perdio = false;
        control = "si";
    }

    @Override
    public void windowClosed(WindowEvent eventoVentana) {
        Hilo_Personaje.perdio = false;
        control = "si";
    }

    @Override
    public void windowIconified(WindowEvent eventoVentana) {
    }

    @Override
    public void windowDeiconified(WindowEvent eventoVentana) {
    }

    @Override
    public void windowActivated(WindowEvent eventoVentana) {
    }

    @Override
    public void windowDeactivated(WindowEvent eventoVentana) {
    }

}
