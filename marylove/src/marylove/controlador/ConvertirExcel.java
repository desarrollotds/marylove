/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package marylove.controlador;

import java.awt.FileDialog;
import java.io.FileOutputStream;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

/**
 *
 * @author usuario
 */
public class ConvertirExcel {

    public ConvertirExcel() {
    }
    public void exportar(JFrame vista, DefaultTableModel model,String titulo){
         String rutatotal="";
          String nombreArchivo="";
         try {
              FileDialog dialogoArchivo;
        dialogoArchivo = new FileDialog(vista, "Lista de Archivos desde Frame", FileDialog.LOAD);
        dialogoArchivo.setVisible(true);
        if (dialogoArchivo.getFile() != null) {
            /* Validar que se haya Seleccionado un Archivo*/
            String directorio = dialogoArchivo.getDirectory();
             nombreArchivo = dialogoArchivo.getFile();
            rutatotal = directorio + nombreArchivo+".xls";
        } else {
            System.out.println("No Seleccionó Archivo");
            JOptionPane.showMessageDialog(null, "No Seleccionó Archivo");
        }
            
            HSSFWorkbook workbook = new HSSFWorkbook();
            HSSFSheet sheet = workbook.createSheet(nombreArchivo);
             HSSFRow rowhead = sheet.createRow(0);
            rowhead.createCell(0).setCellValue(titulo);
          
            for (int r = 0; r < model.getRowCount(); r++) {
                HSSFRow row = sheet.createRow(r+1);
                for (int c = 0; c < model.getColumnCount(); c++) {
                    HSSFCell celda = row.createCell(c);
                    celda.setCellValue(String.valueOf(model.getValueAt(r, c)));
                }
            }
            
            FileOutputStream fileOut = new FileOutputStream(rutatotal);
            workbook.write(fileOut);
            fileOut.close();
            System.out.println("Your excel file has been generated!");
            JOptionPane.showMessageDialog(null, "Documento generado en: "+rutatotal);

        } catch (Exception ex) {
            System.out.println(ex);
        }
    }
}
