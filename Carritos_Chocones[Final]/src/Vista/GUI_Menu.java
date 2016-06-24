/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import Controlador.Controlador_Menu;
import Modelo.ArchivoPuntuacion;
import java.awt.Color;
import static java.awt.Color.blue;
import static java.awt.Color.green;
import static java.awt.Color.red;
import java.awt.event.ActionListener;
import java.awt.event.KeyListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;

/**
 *
 * @author franp
 */
public class GUI_Menu extends javax.swing.JFrame {

    GUI_Nivel guiNivel;
    Controlador_Menu controladorMenu;
    ArchivoPuntuacion archivo;

    /**
     * Creates new form GUI_Menu
     */
    public GUI_Menu() {
        initComponents();
        this.archivo = new ArchivoPuntuacion();
        this.guiNivel = new GUI_Nivel(this, this.archivo);
        this.controladorMenu = new Controlador_Menu(this, this.guiNivel);
        this.setSize(861, 679);
        this.setTitle("Carritos Chocones");
        this.addKeyListener(this.controladorMenu);
        this.setActionControlador(controladorMenu);
        this.setKeyControlador(controladorMenu);
        this.setResizable(false);
        this.jtf_MayorPuntuacion.setEditable(false);
        this.jtf_nombreJugador.addFocusListener(this.controladorMenu);
        this.jtf_MayorPuntuacion.setText(archivo.getPuntuacion()+ " - " +archivo.getDatosPuntuacionVector()[0]);
        this.setAcciones();
        this.eliminarBordesBotones();
        this.jtf_MayorPuntuacion.setOpaque(false);
        this.jtf_nombreJugador.setOpaque(false);
        this.jtf_MayorPuntuacion.setBackground(new Color(0,0,0,0));
        this.jtf_nombreJugador.setBackground(new Color(0,0,0,0));
         this.jtf_MayorPuntuacion.setBorder(null);
        this.jtf_nombreJugador.setBorder(null);
    }
    
    public void eliminarBordesBotones(){
//        this.jb_Nivel1.setOpaque(false);
        this.jb_Nivel1.setContentAreaFilled(false);
        this.jb_Nivel1.setBorderPainted(false);
        
//         this.jb_Nivel2.setOpaque(false);
        this.jb_Nivel2.setContentAreaFilled(false);
        this.jb_Nivel2.setBorderPainted(false);
        
//        this.jb_Nivel3.setOpaque(false);
        this.jb_Nivel3.setContentAreaFilled(false);
        this.jb_Nivel3.setBorderPainted(false);
    }

    public static void reiniciar() {
        new GUI_Menu().setVisible(true);
    }

    public JFrame getMenu() {
        return this;
    }

    public static void cerrarJuego() {
        new GUI_Menu().setVisible(true);
        System.exit(0);
    }

    public JTextField getJtf_MayorPuntuacion() {
        return jtf_MayorPuntuacion;
    }

    public JTextField getJtf_nombreJugador() {
        return jtf_nombreJugador;
    }

    public void setActionControlador(ActionListener controladorMenu) {
        jb_Nivel1.addActionListener(controladorMenu);
        jb_Nivel2.addActionListener(controladorMenu);
        jb_Nivel3.addActionListener(controladorMenu);
    }

    public void setAcciones(){
        jb_Nivel1.setActionCommand("Nivel 1");
        jb_Nivel2.setActionCommand("Nivel 2");
        jb_Nivel3.setActionCommand("Nivel 3");
    }
    public void setKeyControlador(KeyListener controladorMenu) {
        jb_Nivel1.addKeyListener(controladorMenu);
        jb_Nivel2.addKeyListener(controladorMenu);
        jb_Nivel3.addKeyListener(controladorMenu);
    }

    public JButton getJb_Nivel1() {
        return jb_Nivel1;
    }

    public JButton getJb_Nivel2() {
        return jb_Nivel2;
    }

    public JButton getJb_Nivel3() {
        return jb_Nivel3;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jb_Nivel1 = new javax.swing.JButton();
        jb_Nivel2 = new javax.swing.JButton();
        jb_Nivel3 = new javax.swing.JButton();
        jtf_MayorPuntuacion = new javax.swing.JTextField();
        jtf_nombreJugador = new javax.swing.JTextField();
        jl_FondoMenu = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        jb_Nivel1.setBackground(new java.awt.Color(240, 234, 166));
        jb_Nivel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/boton_facil.png"))); // NOI18N
        jb_Nivel1.setBorder(null);
        jb_Nivel1.setBorderPainted(false);
        jb_Nivel1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jb_Nivel1ActionPerformed(evt);
            }
        });
        getContentPane().add(jb_Nivel1);
        jb_Nivel1.setBounds(390, 178, 180, 50);

        jb_Nivel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/boton_normal.png"))); // NOI18N
        jb_Nivel2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jb_Nivel2ActionPerformed(evt);
            }
        });
        getContentPane().add(jb_Nivel2);
        jb_Nivel2.setBounds(390, 278, 180, 50);

        jb_Nivel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/boton_dificil.png"))); // NOI18N
        getContentPane().add(jb_Nivel3);
        jb_Nivel3.setBounds(390, 378, 180, 50);

        jtf_MayorPuntuacion.setFont(new java.awt.Font("Oduda Bold", 0, 18)); // NOI18N
        getContentPane().add(jtf_MayorPuntuacion);
        jtf_MayorPuntuacion.setBounds(80, 260, 190, 30);

        jtf_nombreJugador.setFont(new java.awt.Font("Oduda Bold", 0, 18)); // NOI18N
        jtf_nombreJugador.setText("Sin nombre");
        getContentPane().add(jtf_nombreJugador);
        jtf_nombreJugador.setBounds(80, 400, 180, 30);

        jl_FondoMenu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Fondo_menu_final.png"))); // NOI18N
        getContentPane().add(jl_FondoMenu);
        jl_FondoMenu.setBounds(0, 0, 860, 630);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jb_Nivel1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jb_Nivel1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jb_Nivel1ActionPerformed

    private void jb_Nivel2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jb_Nivel2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jb_Nivel2ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;

                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(GUI_Menu.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GUI_Menu.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GUI_Menu.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GUI_Menu.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GUI_Menu().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jb_Nivel1;
    private javax.swing.JButton jb_Nivel2;
    private javax.swing.JButton jb_Nivel3;
    private javax.swing.JLabel jl_FondoMenu;
    private javax.swing.JTextField jtf_MayorPuntuacion;
    private javax.swing.JTextField jtf_nombreJugador;
    // End of variables declaration//GEN-END:variables
}
