/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Funcionalidad;

import InterfazGrafica.GUI;
import java.io.IOException;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Familia
 */
public class DescargarWeb {
    
    public static void Descargar(String url, String formatoSeleccionado){
         try {
            Document doc = Jsoup.connect(url).get();
                //boolean tiene contenido?
                //newsHeadlines.hasText()
                GuardarInformacion.Guardar(PasearWeb.Parsear("h2", doc).toString(),formatoSeleccionado);
        } catch (IOException ex) {
            Logger.getLogger(GUI.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
