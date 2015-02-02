/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Funcionalidad.ConsultarInformacion;
import java.util.ArrayList;


/**
 *
 * @author Familia
 */
public class Controladores {
    
    public static void ControladorDescarga(String url, String formatoSeleccionado,ArrayList<String> etiquetas){
        
        //DescargarWeb.Descargar(url, formatoSeleccionado);
        ConsultarInformacion.ConsultarTodo();
    }
}
