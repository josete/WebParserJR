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

    public static void Descargar(String url, String formatoSeleccionado, ArrayList<String> etiquetas, String clase) {
        try {
            Document doc = Jsoup.connect(url).get();
            BaseDatosOdb db = new BaseDatosOdb("Informacion", ".");
            //boolean tiene contenido?
            //newsHeadlines.hasText()
            String[] partes = clase.split("\\.");
            System.out.println(partes[0]);
            ArrayList<Elements> elementos = new ArrayList<>();
            for (String etiqueta : etiquetas) {
                if (partes[0].equals(etiqueta)) {
                    elementos.add(PasearWeb.Parsear(clase, doc));
                    //GuardarInformacion.Guardar(crearInformacion(PasearWeb.Parsear(clase, doc),etiqueta),formatoSeleccionado);
                } else {
                    elementos.add(PasearWeb.Parsear(etiqueta, doc));
                    //GuardarInformacion.Guardar(crearInformacion(PasearWeb.Parsear(etiqueta, doc),etiqueta),formatoSeleccionado);
                }
            }
            //GuardarInformacion.Guardar(crearInformacion(elementos, etiquetas), formatoSeleccionado);
            //if(elementos.size() == etiquetas.size()){
                db.insertarEnBaseDeDatos(crearInformacion(elementos, etiquetas));
            
        } catch (IOException ex) {
            Logger.getLogger(GUI.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static ArrayList<Informacion> crearInformacion(ArrayList<Elements> elementos, ArrayList<String> etiquetas) {
        ArrayList<Informacion> informacion = new ArrayList<>();
        for (Elements e : elementos) {
            for (String s : etiquetas) {
                System.out.println("Tamaño de los elemetos: "+e.size());
                for (int i = 0; i < e.size(); i++) {
                    informacion.add(new Informacion(e.get(i).text(), s));
                }
            }
        }
        return informacion;
    }
}
