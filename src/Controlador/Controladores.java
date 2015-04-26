/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Funcionalidad.BaseDatosOdb;
import Funcionalidad.ConsultarInformacion;
import Funcionalidad.DescargarWeb;
import java.util.ArrayList;


/**
 *
 * @author Familia
 */
public class Controladores {
    
    /**
     * 
     * @param url Es la url de la pagina que vamos a descargar
     * @param etiquetas Son las etiquetas html que queremos obterner ej:h2
     * @param clase Son las clases css especificas que se quieren descargar
     * 
     * Es el controlador que se encarga de conectar la funcionalidad de
     * descarga con la interfaz grafica
     */
    public static void ControladorDescarga(String url,
            ArrayList<String> etiquetas,String clase){
        
        DescargarWeb.Descargar(url,etiquetas,clase);
        //ConsultarInformacion.ConsultarTodo();
    }
    
    /**
     * Es el controlador que se encarga de conectar la funcionalidad de crear
     * la hoja de calculo con la interfaz
     */
    public static void controladorLeer(){
        BaseDatosOdb bd = new BaseDatosOdb(".");
        bd.leerBaseDeDatos();
        //ConsultarInformacion.ConsultarTodo();
    }
}
