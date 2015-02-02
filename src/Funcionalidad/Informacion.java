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

    public Informacion(String informacion) {
        this.informacion = informacion;
    }

    public String getInformacion() {
        return informacion;
    }

    public void setInformacion(String informacion) {
        this.informacion = informacion;
    }
    
    
}
