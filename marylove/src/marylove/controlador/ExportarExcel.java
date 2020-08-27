/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package marylove.controlador;

import java.awt.FileDialog;
import java.io.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import jxl.write.*;
import jxl.*;

/**
 *
 * @author RUBEN
 */
public class ExportarExcel {

    private File file;// archivo que manejaremos
    private DefaultTableModel model; //la tabla que recibira
    private String nombreTab; //nombre del archivo
//constructor ( inicializa las variables)
    String nombreArchivo;
     String rutatotal;

    public ExportarExcel() {
    }

     
    public ExportarExcel(DefaultTableModel model, File file, String nombreTab) {
        this.file = file;
        this.model=model;
        this.nombreTab = nombreTab;
    }
//metodo para exportar

    public boolean export() {
        try {
            System.out.print("iniciando proceso de exportar");
//hacemos referencia al archivo deseado
            DataOutputStream out = new DataOutputStream(new FileOutputStream(file));
//Representa nuestro archivo en excel y necesita un OutputStream para saber donde va locoar los datos
            WritableWorkbook w = Workbook.createWorkbook(out);
            System.out.print("colocando nombre");
//Coloca el nombre del "tab"(el nombre del arcchivo en el archivo y tambien en la hoja de excel)
            WritableSheet s = w.createSheet(nombreTab, 0);
//ocupamos dos ciclos para recorrer nuestra tabla y escribir en las celdas de excel
            System.out.print("recorriendo la tabla");
            for (int i = 0; i < model.getRowCount(); i++) {
                for (int j = 0; j < model.getColumnCount(); j++) {
                    Object objeto = model.getValueAt(i, j);
                    s.addCell(new Label(j, i, String.valueOf(objeto)));
                }
            }
//escribimos en el archivo
            w.write();
            System.out.print("Cerramos el WritableWorkbook y DataOutputStream");
            w.close();
            out.close();
            return true;
        } catch (IOException ex) {
            ex.printStackTrace();
        } catch (WriteException ex) {
            ex.printStackTrace();
        }
        System.out.print("ocurrio un error");
        return false;
    }
    
    public void Impresion(JFrame vista, DefaultTableModel model) {
        FileDialog dialogoArchivo;
        dialogoArchivo = new FileDialog(vista, "Lista de Archivos desde Frame", FileDialog.LOAD);
        dialogoArchivo.setVisible(true);
        if (dialogoArchivo.getFile() != null) {
            /* Validar que se haya Seleccionado un Archivo*/
            String directorio = dialogoArchivo.getDirectory();
            nombreArchivo = dialogoArchivo.getFile();
            rutatotal = directorio + nombreArchivo+".xls";
            System.out.println(nombreArchivo);
            File file = new File(rutatotal);
        ExportarExcel excel = new ExportarExcel(model, file,nombreArchivo);
        excel.export();
        } else {
            System.out.println("No Seleccionó Archivo");
        }
    }

    
}
