/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Vista.GUI_Menu;
import Vista.GUI_Nivel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 *
 * @author franp */
public class Controlador_Menu implements KeyListener, ActionListener, FocusListener{

    GUI_Menu guiMenu;
    GUI_Nivel guiNivel;
    public static int velocidadNivel = 300;

    public Controlador_Menu(GUI_Menu guiMenu, GUI_Nivel guiNivel) {
        this.guiMenu = guiMenu;
        this.guiMenu.addKeyListener(this);
        this.guiNivel = guiNivel;
    }

    @Override
    public void actionPerformed(ActionEvent event) {
        if (event.getActionCommand().equals("Nivel 1")) {
            velocidadNivel = 100;
            guiNivel.setVisible(true);
            guiNivel.setAlwaysOnTop(true);
        }
        if (event.getActionCommand().equals("Nivel 2")) {

            velocidadNivel = 75;
            guiNivel.setVisible(true);
            guiNivel.setAlwaysOnTop(true);
        }
        if (event.getActionCommand().equals("Nivel 3")) {

            velocidadNivel = 25;
            guiNivel.setVisible(true);
            guiNivel.setAlwaysOnTop(true);
        }
    }

    @Override
    public void keyTyped(KeyEvent keyEvent2) {
        if (keyEvent2.getKeyCode() == KeyEvent.VK_ENTER) {
            if (keyEvent2.getSource() == guiMenu.getJb_Nivel1()) {
                velocidadNivel = 100;
                guiNivel.setVisible(true);
                guiNivel.setAlwaysOnTop(true);
            }
            if (keyEvent2.getSource() == guiMenu.getJb_Nivel2()) {
                velocidadNivel = 75;
                guiNivel.setVisible(true);
                guiNivel.setAlwaysOnTop(true);
            }
            if (keyEvent2.getSource() == guiMenu.getJb_Nivel3()) {
                velocidadNivel = 25;
                guiNivel.setVisible(true);
                guiNivel.setAlwaysOnTop(true);
            }
        }
    }

    @Override
    public void keyPressed(KeyEvent keyEvent2) {
    }

    @Override
    public void keyReleased(KeyEvent keyEvent2) {

    }

    @Override
    public void focusGained(FocusEvent eventoFocus) {
        this.guiMenu.getJtf_nombreJugador().setText("");
    }

    @Override
    public void focusLost(FocusEvent eventoFocus) {
        
    }

}
