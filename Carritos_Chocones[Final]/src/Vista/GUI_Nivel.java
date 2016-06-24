/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import Controlador.Controlador_Menu;
import Controlador.Controlador_Nivel;
import Controlador.Controlador_Personaje;
import Modelo.ArchivoPuntuacion;
import Modelo.Hilo_Enemigo;
import Modelo.Hilo_Fondo;
import Modelo.Hilo_Generador_Enemigo;
import Modelo.Hilo_NuevoPersonaje;
import Modelo.Hilo_Personaje;
import Modelo.Hilo_Puntuacion;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

/**
 *
 * @author franp
 */
public class GUI_Nivel extends javax.swing.JFrame {

    Hilo_Fondo hiloFondo;
    Hilo_Personaje hiloPersonaje;
    Controlador_Personaje controladorPersonaje;
    Controlador_Nivel controladorNivel;
    public static ArrayList<JLabel> enemigos;
    Hilo_Enemigo hiloEnemigo;
    Hilo_Puntuacion hiloPuntuacion;
    Hilo_Generador_Enemigo hiloGeneradorEnemigo;
    GUI_Menu guiMenu;
    ArchivoPuntuacion archivo;
    public static int indice = 0;
    Hilo_NuevoPersonaje hiloNuevoPersonaje;

    /**
     * Creates new form GUI_Nivel
     */
    public GUI_Nivel(GUI_Menu guiMenu, ArchivoPuntuacion archivo) {
        initComponents();
        this.guiMenu = guiMenu;
        this.archivo = archivo;
        this.hiloFondo = new Hilo_Fondo(this);
        this.hiloEnemigo = new Hilo_Enemigo(this);
        this.hiloPuntuacion = new Hilo_Puntuacion(this, this.archivo, this.guiMenu);
        this.hiloGeneradorEnemigo = new Hilo_Generador_Enemigo(this);
        this.hiloPersonaje = new Hilo_Personaje(this, this.hiloFondo, this.hiloPersonaje, this.hiloEnemigo,
                this.hiloPuntuacion, this.hiloGeneradorEnemigo, this.guiMenu);
        this.hiloNuevoPersonaje = new Hilo_NuevoPersonaje(this);
//        hiloFondo.start();// esto ejecuta el método run de hiloFondo
        this.setSize(861, 805);
        this.jPanelCapas.setSize(861, 805);
        this.setTitle("Carritos Chocones");
        this.controladorPersonaje = new Controlador_Personaje(this, this.hiloPersonaje, this.hiloFondo);
        this.addKeyListener(controladorPersonaje);
        this.controladorNivel = new Controlador_Nivel(this, this.hiloFondo, this.hiloEnemigo, this.hiloPuntuacion,
                this.hiloGeneradorEnemigo, this.hiloPersonaje, this.hiloNuevoPersonaje);
        this.addComponentListener(controladorNivel);
        this.addWindowListener(controladorNivel);
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.setResizable(false);
        this.enemigos = new ArrayList<>();
        this.jPanelCapas.add(jl_Personaje, new Integer(10));
        this.jl_Personaje.setSize(86, 116);
    }

    public void setNuevoPersonaje() {
        int identificador = 1 + (int) (Math.random() * 4);
        switch (identificador) {

            case 1:
                this.jl_Personaje.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/carro_azul.png")));

                break;
            case 2:
                this.jl_Personaje.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/carro_amarillo.png")));

                break;
            case 3:
                this.jl_Personaje.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/carro_morado.png")));

                break;
            case 4:
                this.jl_Personaje.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/carro_verde.png")));

                break;
            default:
                this.jl_Personaje.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/carro_azul.png")));

        }
    }

    public JLabel getFondo() {
        return this.jl_Fondo;
    }

    public JLabel getPersonaje() {
        return this.jl_Personaje;
    }

    public static ArrayList arrayEnemigos() {
        return enemigos;
    }

    public JLabel getJL_Puntuacion() {
        return this.jl_Puntuacion;
    }

    public void moverEnemigoAbajo() {
        for (int indice = 0; indice < enemigos.size(); indice++) {
            if (Controlador_Menu.velocidadNivel == 100) {
                enemigos.get(indice).setLocation(enemigos.get(indice).getX(), enemigos.get(indice).getY() + 35);
            }
            if (Controlador_Menu.velocidadNivel == 75) {
                enemigos.get(indice).setLocation(enemigos.get(indice).getX(), enemigos.get(indice).getY() + 35);
            }
            if (Controlador_Menu.velocidadNivel == 25) {
                enemigos.get(indice).setLocation(enemigos.get(indice).getX(), enemigos.get(indice).getY() + 35);
            }

        }
    }

    public void setFondo() {
        if (Controlador_Menu.velocidadNivel == 100) {
            jl_Fondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Fondo_juego_Final.png")));
        }
        if (Controlador_Menu.velocidadNivel == 75) {
            jl_Fondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Fondo juego 2_Final.png")));
        }
        if (Controlador_Menu.velocidadNivel == 25) {
            jl_Fondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Fondo juego 3_Final.png")));
        }
    }

    public void setNuevoEnemigo() {
        JLabel jl_Enemigo = new JLabel();
        int identificador = 1 + (int) (Math.random() * 4);
        int ubicacionRandomX = 0;
        int random = 1 + (int) (Math.random() * 3);
        switch (random) {
            case 1:
                ubicacionRandomX = 230;
                break;
            case 2:
                ubicacionRandomX = 390;
                break;
            case 3:
                ubicacionRandomX = 550;
                break;
            default:;
        }
        switch (identificador) {
            case 1:
                jl_Enemigo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/carro_verde_enemigo.png")));
                this.jPanelCapas.add(jl_Enemigo, new Integer(10));
                jl_Enemigo.setBounds(ubicacionRandomX, -100, 86, 116); //setBounds(x, y, width, height)
                jl_Enemigo.setLocation(ubicacionRandomX, -100);
                jl_Enemigo.setSize(86, 122);
                JLabel label = jl_Enemigo;
                enemigos.add(label);
                break;
            case 2:
                jl_Enemigo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/carro_azul_enemigo.png")));
                getContentPane().add(jl_Enemigo);
                this.jPanelCapas.add(jl_Enemigo, new Integer(10));
                jl_Enemigo.setBounds(ubicacionRandomX, -100, 86, 116); //setBounds(x, y, width, height)
                jl_Enemigo.setLocation(ubicacionRandomX, -100);
                jl_Enemigo.setSize(86, 122);
                JLabel label1 = jl_Enemigo;
                enemigos.add(label1);
                break;
            case 3:
                jl_Enemigo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/carro_morado_enemigo.png")));
                getContentPane().add(jl_Enemigo);
                this.jPanelCapas.add(jl_Enemigo, new Integer(10));
                jl_Enemigo.setBounds(ubicacionRandomX, -100, 86, 116); //setBounds(x, y, width, height)
                jl_Enemigo.setLocation(ubicacionRandomX, -100);
                jl_Enemigo.setSize(86, 122);
                JLabel label2 = jl_Enemigo;
                enemigos.add(label2);
                break;
            case 4:
                jl_Enemigo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/carro_amarillo_enemigo.png")));
                this.jPanelCapas.add(jl_Enemigo, new Integer(10));
                jl_Enemigo.setBounds(ubicacionRandomX, -100, 86, 116); //setBounds(x, y, width, height)
                jl_Enemigo.setLocation(ubicacionRandomX, -100);
                JLabel label3 = jl_Enemigo;
                enemigos.add(label3);
                break;
            default:;
        }
    }

    // [0]= file:/C:/Users/DKMRFCB_rlz/Documents/NetBeansProjects/         [1]= Carritos_Chocones/build/classes/Imagenes/carro_azul.png
    public String getStringIcon(JLabel personaje) {
        String identificador = "";
        identificador = personaje.getIcon().toString();
        /*
        En este punto el toString() devuelve algo como: 
        "file:/C:/Users/DKMRFCB_rlz/Documents/NetBeansProjects/Carritos_Chocones/build/classes/Imagenes/carro_verde_enemigo.png":
        Lo cual no es dinámico
         */
        identificador = identificador.split("classes/")[1];
        switch (identificador) {
            case "Imagenes/carro_azul.png":
                /* AZUL */
                identificador = "azul";
                break;
            case "Imagenes/carro_azul_enemigo.png":
                /* AZUL */
                identificador = "azul";
                break;
            case "Imagenes/carro_amarillo.png":
                /* AMARILLO */
                identificador = "amarillo";
                break;
            case "Imagenes/carrol_amarillo_enemigo.png":
                /* AMARILLO */
                identificador = "amarillo";
                break;
            case "Imagenes/carro_morado.png":
                /* MORADO */
                identificador = "morado";
                break;
            case "Imagenes/carro_morado_enemigo.png":
                /* MORADO */
                identificador = "morado";
                break;
            case "Imagenes/carro_verde.png":
                /* VERDE */
                identificador = "verde";
                break;
            case "Imagenes/carro_verde_enemigo.png":
                /* VERDE */
                identificador = "verde";
                break;
        }
        return identificador;
    }

//            if (getPersonaje().getY() - (116 / 2) == enemigos.get(contador).getY() + (116 / 2)
//                    || getPersonaje().getY() + (116 / 2) == enemigos.get(contador).getY() - (116 / 2)) {
//
//                if (getStringIcon(getPersonaje()).equals(getStringIcon(enemigos.get(contador)))) {
//
//                } else {
//                    System.out.println("Colisión O.O");
//                    perdio = true;
//                    return perdio;
//                }
//
//            } else {
//                perdio = false;
//                return perdio;
//            }
    public boolean colision() {
        boolean perdio = false;
        for (int contador = 0; contador < GUI_Nivel.enemigos.size(); contador++) {
//            if (getPersonaje().getY() - 116 < enemigos.get(contador).getY()
//                    && enemigos.get(contador).getY() + 116 > getPersonaje().getY()
//                    && getPersonaje().getX() == enemigos.get(contador).getX()
//                    && getPersonaje().getY()>enemigos.get(contador).getY()-118) {

            if (getPersonaje().getBounds().intersects(enemigos.get(contador).getBounds())) {
                if (getStringIcon(getPersonaje()).equals(getStringIcon(enemigos.get(contador)))) {

                } else {
                    perdio = true;
                    indice = contador;
                    return perdio;
                }
            } else {
                perdio = false;
                return perdio;
            }
        }
        return perdio;
    }

    public int mensajeConInput(String mensaje) {
        int respuesta = JOptionPane.showConfirmDialog(null, mensaje);
        return respuesta;
    }

    public void mensaje(String mensaje) {
        JOptionPane.showMessageDialog(null, mensaje);
    }

    public void haciaAtras() {
        this.toBack();
    }

    public void haciaDelante() {
        this.toFront();
    }

    public void esconder() {
        this.dispose();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanelCapas = new javax.swing.JLayeredPane();
        jl_Personaje = new javax.swing.JLabel();
        jl_Puntuacion = new javax.swing.JLabel();
        jl_Fondo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setAlwaysOnTop(false);
        setResizable(false);

        jl_Personaje.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/carro_azul.png"))); // NOI18N
        jPanelCapas.add(jl_Personaje);
        jl_Personaje.setBounds(390, 570, 80, 120);

        jl_Puntuacion.setFont(new java.awt.Font("Oduda Bold", 1, 36)); // NOI18N
        jl_Puntuacion.setText("00");
        jPanelCapas.add(jl_Puntuacion);
        jl_Puntuacion.setBounds(690, 44, 130, 60);

        jl_Fondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Fondo_juego_Final.png"))); // NOI18N
        jl_Fondo.setText("jLabel1");
        jPanelCapas.add(jl_Fondo);
        jl_Fondo.setBounds(0, -1890, 860, 2640);

        getContentPane().add(jPanelCapas, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLayeredPane jPanelCapas;
    private javax.swing.JLabel jl_Fondo;
    private javax.swing.JLabel jl_Personaje;
    private javax.swing.JLabel jl_Puntuacion;
    // End of variables declaration//GEN-END:variables
}
