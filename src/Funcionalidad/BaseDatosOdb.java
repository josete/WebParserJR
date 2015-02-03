/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Funcionalidad;

import java.io.File;
import org.neodatis.odb.ODB;
import org.neodatis.odb.ODBFactory;

/**
 *
 * @author Usuario
 */
public class BaseDatosOdb {

    private static ODB odb;
    private static String nombreBase = null;
    private String ruta;
    private static File XLS;

    public BaseDatosOdb(String nombre, String ruta) {
        nombreBase = nombre;
        this.ruta = ruta;
        odb = ODBFactory.open(nombreBase + ".odb");
        XLS = new File(this.ruta);

    }

    public static void insertarEnBaseDeDatos() {
        //odb = ODBFactory.open(nombreBase + ".odb");
        //  odb.store();
        //   odb.close();
    }

}
