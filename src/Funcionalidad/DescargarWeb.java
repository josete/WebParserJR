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

    /**
     * 
     * @param url Es la url de la pagina que vamos a descargar
     * @param etiquetas Son las etiquetas html que queremos obterner ej:h2
     * @param clase Son las clases css especificas que se quieren descargar
     * 
     * El metodo que se encarga de descargar la pagina web
     */
    public static void Descargar(String url, ArrayList<String> etiquetas, String clase) {
        try {
            // Realiza la conexion con la pagina para descargarla
            Document doc = Jsoup.connect(url).get();
            //Crea un objeto base de datos para poder usarla
            BaseDatosOdb db = new BaseDatosOdb(".");
            String[] partes = clase.split("\\.");
            System.out.println(partes[0]);
            ArrayList<Elements> elementos = new ArrayList<>();
            for (String etiqueta : etiquetas) {
                if (partes[0].equals(etiqueta)) {
                    elementos.add(PasearWeb.Parsear(clase, doc));
                } else {
                    elementos.add(PasearWeb.Parsear(etiqueta, doc));
                }
            }
            //Inserta en la base de datos la informacion que se genera en el
            //metodo crearInformacion()
                db.insertarEnBaseDeDatos(crearInformacion(elementos, etiquetas,url));
            
        } catch (IOException ex) {
            Logger.getLogger(GUI.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Se encarga de recibir la informacion procedente de la base de datos
     * y generar un objeto informacion para guardarlo en la base de datos
     * 
     * @param elementos Es el contenido que se obtiene
     * @param etiquetas La etiqueta del contenido
     * @param url Url a la que pertenece el contenido
     * @return ArrayList con los objetos informacion que van a ser guardados
     */
    public static ArrayList<Informacion> crearInformacion(ArrayList<Elements> elementos, ArrayList<String> etiquetas,String url) {
        ArrayList<Informacion> informacion = new ArrayList<>();
        for (Elements e : elementos) {
            for (String s : etiquetas) {
                System.out.println("Tamaño de los elemetos: "+e.size());
                for (int i = 0; i < e.size(); i++) {
                    informacion.add(new Informacion(e.get(i).text(), s,url));
                }
            }
        }
        return informacion;
    }
}
