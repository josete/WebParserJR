/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Funcionalidad;

import java.io.File;
import java.util.ArrayList;
import org.neodatis.odb.ODB;
import org.neodatis.odb.ODBFactory;
import org.neodatis.odb.Objects;
import org.neodatis.odb.core.query.IQuery;
import org.neodatis.odb.impl.core.query.criteria.CriteriaQuery;

/**
 *
 * @author Usuario
 */
public class BaseDatosOdb {

    private static ODB odb;
    private static String nombreBase = "Informacion";
    private String ruta = System.getProperty("user.home") + "/Desktop/Informacion.xls";
    private File XLS;

    public BaseDatosOdb(String nombre, String ruta) {
        //nombreBase = nombre;
        //this.ruta = ruta;
        //odb = ODBFactory.open(nombreBase + ".odb");
        XLS = new File(this.ruta);
    }

    public void insertarEnBaseDeDatos(ArrayList<Informacion> info) {
        odb = ODBFactory.open(nombreBase + ".odb");
        for(Informacion i: info){
            odb.store(i);
        }
        odb.close();
    }
    
    public void leerBaseDeDatos(){
        odb = ODBFactory.open(nombreBase + ".odb");
        IQuery query = new CriteriaQuery(Informacion.class);
        Objects<Informacion> info = odb.getObjects(query);
        GenerarExcel.generarHojaDeCalculo(info, XLS);
        int i = 1;
            while (info.hasNext()) {
                System.out.println((i++) + "\t: " + info.next().getUrl());
            } 
    }

}
