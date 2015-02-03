/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Funcionalidad;

import InterfazGrafica.GUI;
import java.io.IOException;
import java.util.ArrayList;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.jsoup.select.Elements;

/**
 *
 * @author Familia
 */
public class DescargarWeb {
    
    public static void Descargar(String url, String formatoSeleccionado,ArrayList<String> etiquetas,String clase){
         try {
            Document doc = Jsoup.connect(url).get();
                //boolean tiene contenido?
                //newsHeadlines.hasText()
            String[] partes = clase.split("\\.");
                System.out.println(partes[0]);
                for(String etiqueta: etiquetas){
                    if(partes[0].equals(etiqueta)){
                        GuardarInformacion.Guardar(crearInformacion(PasearWeb.Parsear(clase, doc)),formatoSeleccionado);
                    }else{
                        GuardarInformacion.Guardar(crearInformacion(PasearWeb.Parsear(etiqueta, doc)),formatoSeleccionado);
                    }
                }
        } catch (IOException ex) {
            Logger.getLogger(GUI.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static ArrayList<Informacion> crearInformacion(Elements elementos){
        ArrayList<Informacion> informacion = new ArrayList<>();
        for(int i=0;i<elementos.size();i++){
            informacion.add(new Informacion(elementos.get(i).text()));
            System.out.println(elementos.get(i).text());
        }
        return informacion;
    }
}
