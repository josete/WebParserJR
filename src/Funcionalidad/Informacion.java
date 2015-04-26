/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Funcionalidad;

import java.io.Serializable;

/**
 *
 * @author Familia
 */
public class Informacion implements Serializable{
    
    //Informacion que se va a guardar
    private String informacion;
    //Tipo de informacion
    private String tipoInformacion;
    //Url de la pagina
    private String url;

    /**
     * Constructor de la clase
     * @param informacion Contenido que se va a guardar
     * @param tipo tipo del contenido
     * @param url direccion de la pagina
     */
    public Informacion(String informacion,String tipo,String url) {
        this.informacion = informacion;
        this.tipoInformacion = tipo;
        this.url = url;
    }

    public String getInformacion() {
        return informacion;
    }

    public void setInformacion(String informacion) {
        this.informacion = informacion;
    }

    public String getTipoInformacion() {
        return tipoInformacion;
    }

    public void setTipoInformacion(String tipoInformacion) {
        this.tipoInformacion = tipoInformacion;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
    
    /**
     * SE encarga de componer los datos
     * @return devuelve un array con los datos para poder ser escritos en el
     * documento excel
     */
    public String[] getDatosCompuesto(){
        String[] datos = {informacion,tipoInformacion,url};
        return datos;
    }
    
    
    
    
    
    
}
