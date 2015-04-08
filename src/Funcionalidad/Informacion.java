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
    
    private String informacion;
    private String tipoInformacion;
    private String url;

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
    
    public String[] getDatosCompuesto(){
        String[] datos = {informacion,tipoInformacion,url};
        return datos;
    }
    
    
    
    
    
    
}
