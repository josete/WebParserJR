/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Funcionalidad;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Familia
 */
public class OperacionesSerializado {

    public static void Serializar(ArrayList<Informacion> informacion, String documento) {
        ObjectOutputStream out = null;
        try {
            out = new ObjectOutputStream(new FileOutputStream("Datos.txt"));
            for (Informacion in : informacion) {
                out.writeObject(in);
            }
            out.close();
            System.out.println("Datos guardados en fichero");
        } catch (IOException ex) {
            Logger.getLogger(OperacionesSerializado.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                out.close();
            } catch (IOException ex) {
                Logger.getLogger(OperacionesSerializado.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public static void DesSerializar() {
        ObjectInputStream in = null;
        try {
            in = new ObjectInputStream(new FileInputStream("Datos.txt"));
            Informacion i;
            try {
                while (true) {
                    i = (Informacion) in.readObject();
                    System.out.println("-->" + i.getInformacion() + " "+i.getTipoInformacion());
                }
            } catch (EOFException ef) {

            }
        } catch (IOException ex) {
            Logger.getLogger(OperacionesSerializado.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(OperacionesSerializado.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                in.close();
            } catch (IOException ex) {
                Logger.getLogger(OperacionesSerializado.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }
}
