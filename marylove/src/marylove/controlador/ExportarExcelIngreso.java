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
public class ExportarExcelIngreso {
    public void Exportar(DefaultTableModel modelip, DefaultTableModel modeldor,DefaultTableModel modelab, DefaultTableModel modelaf,JFrame vista) {
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
             JOptionPane.showMessageDialog(null, "No Seleccionó Archivo","Información",JOptionPane.ERROR_MESSAGE);
        }
            HSSFWorkbook workbook = new HSSFWorkbook();
            HSSFSheet sheet = workbook.createSheet("Información Principal");
            HSSFSheet sheet2 = workbook.createSheet("Dormitorio");
            HSSFSheet sheet3 = workbook.createSheet("Articulos Beneficiaria");
            HSSFSheet sheet4 = workbook.createSheet("Articulos Fundación");
            HSSFRow rowhead = sheet.createRow(0);
            rowhead.createCell(0).setCellValue("REPORTE DE FICHA INGRESO");
            
            
            for (int r = 0; r < modelip.getRowCount(); r++) {
                HSSFRow row = sheet.createRow(r+1);
                for (int c = 0; c < modelip.getColumnCount(); c++) {
                    HSSFCell celda = row.createCell(c);
                    celda.setCellValue(String.valueOf(modelip.getValueAt(r, c)));
                }

            }
            for (int r = 0; r < modeldor.getRowCount(); r++) {
                HSSFRow row = sheet2.createRow(r);
                for (int c = 0; c < modeldor.getColumnCount(); c++) {
                    HSSFCell celda = row.createCell(c);
                    celda.setCellValue(String.valueOf(modeldor.getValueAt(r, c)));
                }

            }
            
            for (int r = 0; r < modelab.getRowCount(); r++) {
                HSSFRow row = sheet3.createRow(r);
                for (int c = 0; c < modelab.getColumnCount(); c++) {
                    HSSFCell celda = row.createCell(c);
                    celda.setCellValue(String.valueOf(modelab.getValueAt(r, c)));
                }

            }
            
            for (int r = 0; r < modelaf.getRowCount(); r++) {
                HSSFRow row = sheet4.createRow(r);
                for (int c = 0; c < modelaf.getColumnCount(); c++) {
                    HSSFCell celda = row.createCell(c);
                    celda.setCellValue(String.valueOf(modelaf.getValueAt(r, c)));
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
