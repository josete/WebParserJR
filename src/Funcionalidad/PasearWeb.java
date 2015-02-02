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
    
    public static Elements Parsear(String filtro, Document doc){
        Elements newsHeadlines = doc.select(filtro);
        System.out.println(newsHeadlines);
        return newsHeadlines;
    }
}
