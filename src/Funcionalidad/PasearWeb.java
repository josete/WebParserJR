/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Funcionalidad;

import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

/**
 *
 * @author Familia
 */
public class PasearWeb {
    
    /**
     * Se encarga de obtener los elmentos de la pagina
     * @param filtro Que es lo que se quiere descargar
     * @param doc Pagina de la que se quiere obtener la informacion
     * @return Devuelve los elementos de la pagina
     */
    public static Elements Parsear(String filtro, Document doc){
        Elements newsHeadlines = doc.select(filtro);
        //System.out.println(newsHeadlines);
        return newsHeadlines;
    }
}
