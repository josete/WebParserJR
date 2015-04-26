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

    //Base de datos
    private static ODB odb;
    //Nombre de la base de datos
    private static String nombreBase = "Informacion";
    //Direcorio de creacion del excel
    private String ruta = System.getProperty("user.home") + "/Desktop/Informacion.xls";
    //Ficehro excel
    private File XLS;

    /**
     * Constructor de la clase
     * @param ruta Ruta de la base de datos
     */
    public BaseDatosOdb(String ruta) {
        XLS = new File(this.ruta);
    }

    /**
     * Método que se encarga de insertar en la base de datos
     * @param info ArrayList con la informacion que se va a insertar
     */
    public void insertarEnBaseDeDatos(ArrayList<Informacion> info) {
        //Se abre la conexion
        odb = ODBFactory.open(nombreBase + ".odb");
        //Se recorre el arraylist y se guarda la informacion
        for(Informacion i: info){
            odb.store(i);
        }
        //Se cierra la base de datos
        odb.close();
    }
    
    /**
     * Metodo para leer de la base de datos y generar el excel
     */
    public void leerBaseDeDatos(){
        //Se abre la conexion
        odb = ODBFactory.open(nombreBase + ".odb");
        //Sentencia para obtener los datoss de la bases de datos
        IQuery query = new CriteriaQuery(Informacion.class);
        //Obtencion de los datos
        Objects<Informacion> info = odb.getObjects(query);
        //Generar el excel
        GenerarExcel.generarHojaDeCalculo(info, XLS);
        int i = 1;
            while (info.hasNext()) {
                System.out.println((i++) + "\t: " + info.next().getUrl());
            } 
    }

}
