/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.ArrayList;

/**
 *
 * @author franp
 */
public class ArchivoPuntuacion {

    /*
    String nombre;
    String puntuacion;
     */
    public void agregarPuntuacion(String nombre, String puntuacion) {
        try {
            File file = new File("puntuacion.txt");
            FileWriter writer;
            BufferedWriter buffWriter;
            if (file.exists()) {
                writer = new FileWriter(file, true);
                buffWriter = new BufferedWriter(writer);

                FileReader reader = new FileReader(file);
                BufferedReader buffReader = new BufferedReader(reader);
                String linea;
                if ((linea = buffReader.readLine()) == null) {
                    buffWriter.write(nombre + "%" + puntuacion);
                } else {
                    buffWriter.newLine();
                    buffWriter.write(nombre + "%" + puntuacion);
                }
            } else {
                writer = new FileWriter(file);
                buffWriter = new BufferedWriter(writer);
                buffWriter.write(nombre + "%" + puntuacion);
            }
            buffWriter.close();
            writer.close();
        } catch (Exception e) {
            System.out.println("Error al agregar puntuacion en agregarPuntuacion()" + e);
        }
    }

    public void imprimir() {
        try {
            File file = new File("puntuacion.txt");
            if (file.exists()) {
                FileReader reader = new FileReader(file);
                BufferedReader buffReader = new BufferedReader(reader);
                String linea;
                while ((linea = buffReader.readLine()) != null) {
                    String[] atributos = linea.split("%");

//                    System.out.println("Jugador: " + atributos[0] + " Puntuacion: " + atributos[1]);
                }
            } else {
                System.out.println("No existen datos dentro de puntuacion.txt");
            }
        } catch (Exception e) {
            System.out.println("Error en imprimir()" + e);
        }
    }

    public String[] getDatosPuntuacionVector() {
        String[] datosJugador = new String[2];
        try {
            File file = new File("puntuacion.txt");
            if (file.exists()) {
                FileReader reader = new FileReader(file);
                BufferedReader buffReader = new BufferedReader(reader);
                String linea;
                while ((linea = buffReader.readLine()) != null) {
                    String[] atributos = linea.split("%");

                    datosJugador[0] = atributos[0];
                    datosJugador[1] = atributos[1];
                }
            } else {
                System.out.println("No existen datos dentro de puntuacion.txt");
            }
        } catch (Exception e) {
            System.out.println("Error en imprimir()" + e);
        }

        return datosJugador;
    }

    public boolean comprobarArchivo() {
        boolean existe = false;

        try {
            File file = new File("puntuacion.txt");
            if (file.exists()) {
                existe = true;
                System.out.println("Existe puntuacion.txt");
            } else {
                existe = false;
                System.out.println("No existe  puntuacion.txt");
            }
        } catch (Exception e) {
            System.out.println("Error en imprimir()" + e);
        }
        return existe;
    }

    public void crearArchivo() {
        try {
            Writer writer = new BufferedWriter(new OutputStreamWriter(
                    new FileOutputStream("puntuacion.txt"), "utf-8"));
            File file = new File("puntuacion.txt");
        } catch (Exception e) {
            System.out.println("Error en imprimir()" + e);
        }
    }

    public int getPuntuacion() {
        int puntuacion = 0;
        try {
            File file = new File("puntuacion.txt");
            if (file.exists()) {
                FileReader reader = new FileReader(file);
                BufferedReader buffReader = new BufferedReader(reader);
                String linea;
                while ((linea = buffReader.readLine()) != null) {
                    String[] atributos = linea.split("%");
                    System.out.println(puntuacion);
                    puntuacion = Integer.parseInt(atributos[1]);

                }
            } else {
//                Writer writer = new BufferedWriter(new OutputStreamWriter(
//                        new FileOutputStream("puntuacion.txt"), "utf-8"));

                System.out.println("No existen datos dentro de puntuacion.txt");
            }
        } catch (Exception e) {
            System.out.println("Error en imprimir()" + e);
        }

        return puntuacion;
    }

    public void eliminarAllPuntuaciones() {
        try {
            File file = new File("puntuacion.txt");
            if (file.exists()) {
                FileReader reader = new FileReader(file);
                BufferedReader buffReader = new BufferedReader(reader);
                String linea;
                int contador = 0;
                while ((linea = buffReader.readLine()) != null) {
                    contador++;
                }
                String atributosUnidos[] = new String[contador];
                buffReader = new BufferedReader(new FileReader(file));
                int indice = 0;
                while ((linea = buffReader.readLine()) != null) {
                    atributosUnidos[indice] = linea;
                    indice++;
                }
                reader.close();
                buffReader.close();
                FileWriter writer = new FileWriter(file);
                BufferedWriter buffWriter = new BufferedWriter(writer);

                for (int indice2 = 0; indice2 < atributosUnidos.length; indice2++) {
                    String[] atributos = atributosUnidos[indice2].split("%");
                    if (!atributos[0].isEmpty()) {
                        System.out.println("Se encontró y se elimina exitosamente");
                    } else {

                    }
                }
                writer.close();
                buffWriter.close();
            } else {
                System.out.println("No existen datos dentro de puntuacion.txt");
            }
        } catch (Exception e) {
            System.out.println("Error al eliminar la puntuacion en eliminarAllPuntuaciones()" + e);
        }
    }

}
