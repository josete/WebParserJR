/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Funcionalidad;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Familia
 */
public class GuardarInformacion {
    
    //Cambiar contenido por un objeto, pero para la primera aproxiamcion esta bien
    public static void Guardar(ArrayList<Informacion> info, String formato){
        /*try {
            PrintWriter out = new PrintWriter(new FileWriter("Fichero"+formato));
            out.println(contenido);
            out.close();
        } catch (IOException ex) {
            Logger.getLogger(GuardarInformacion.class.getName()).log(Level.SEVERE, null, ex);
        }   */
        OperacionesSerializado.Serializar(info, "Fichero"+formato);
    }
}
