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

    public Informacion(String informacion,String tipo) {
        this.informacion = informacion;
        this.tipoInformacion = tipo;
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
    
    
    
    
}
