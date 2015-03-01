/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Funcionalidad.ConsultarInformacion;
import Funcionalidad.DescargarWeb;
import java.util.ArrayList;


/**
 *
 * @author Familia
 */
public class Controladores {
    
    public static void ControladorDescarga(String url, String formatoSeleccionado,
            ArrayList<String> etiquetas,String clase){
        
        DescargarWeb.Descargar(url, formatoSeleccionado,etiquetas,clase);
        //ConsultarInformacion.ConsultarTodo();
    }
    
    public static void controladorLeer(){
        ConsultarInformacion.ConsultarTodo();
    }
}
