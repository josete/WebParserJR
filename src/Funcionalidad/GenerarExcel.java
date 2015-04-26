/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Funcionalidad;

import java.awt.Desktop;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.neodatis.odb.Objects;

/**
 *
 * @author PC-Portatil
 */
public class GenerarExcel {
    
    /**
     * Metodo que crea el archivo excel
     * @param informacion Informacion que se va a escribir
     * @param XLS Ficgero excel
     */
    public static void generarHojaDeCalculo(Objects<Informacion> informacion,File XLS){
        
        //Si existe el documento lo borra
        try {
            if (XLS.exists()) {
                XLS.delete();
            }
            //Se crea el archivo
            XLS.createNewFile();
            
            //Crea libro en la hoja de excel
            Workbook libro = new HSSFWorkbook();
            
            FileOutputStream archivo = new FileOutputStream(XLS);
            
            //Crea la hoja dentro del libro
            Sheet hoja = libro.createSheet("Informacion");
            //Encabezados de las columnas
            String[] encabezados = {"Datos","Tipo de datos","URL"};
            
            String[] datosTabla;
            Informacion info = null;
            
            //+1 porque el 0 es la fila del encabezado
            for (int i = 0; i < informacion.size()+1; i++) {
                Row fila = hoja.createRow(i);
                if(i==0)info = informacion.getFirst();
                for (int j = 0; j < 3; j++) {
                    Cell celda = fila.createCell(j);
                    if (i == 0) {
                        celda.setCellValue(encabezados[j]);
                    } else {
                        datosTabla =info.getDatosCompuesto();
                        celda.setCellValue(datosTabla[j]);
                    }
                }
               if(informacion.hasNext()) info=informacion.next();
            }
            
            //Se escribe en el libro
            libro.write(archivo);
            //Se cierra el archivo
            archivo.close();
            
            //Abre el archivo recien creado
            Desktop.getDesktop().open(XLS);
        } catch (IOException ex) {
            Logger.getLogger(GenerarExcel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
