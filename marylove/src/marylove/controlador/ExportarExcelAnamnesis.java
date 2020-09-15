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
public class ExportarExcelAnamnesis {

    public void Exportar(DefaultTableModel modeldi, DefaultTableModel modeldpm, DefaultTableModel modelpe, DefaultTableModel modelcn, DefaultTableModel modelpdv,
            DefaultTableModel modelaa, DefaultTableModel modeldm, DefaultTableModel modelsce, DefaultTableModel modelenna, DefaultTableModel modelsnna,
            DefaultTableModel modelrf, DefaultTableModel modelo,JFrame vista) {
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
             JOptionPane.showMessageDialog(null, "No Seleccionó Archivo","Información",JOptionPane.ERROR_MESSAGE);
        }
            HSSFWorkbook workbook = new HSSFWorkbook();
            HSSFSheet sheet = workbook.createSheet("Datos Identificación");
            HSSFSheet sheet2 = workbook.createSheet("Datos de Padre y Madre");
            HSSFSheet sheet3 = workbook.createSheet("Periodo de Embarazo");
            HSSFSheet sheet4 = workbook.createSheet("Condiciones de Nacimiento");
            HSSFSheet sheet5 = workbook.createSheet("Primero Dias de Vida");
            HSSFSheet sheet6 = workbook.createSheet("Alimentación Actual");
            HSSFSheet sheet7 = workbook.createSheet("Desarrollo Motor");
            HSSFSheet sheet8 = workbook.createSheet("Sueño y Control de Esfinteres ");
            HSSFSheet sheet9 = workbook.createSheet("Escolarización NNA");
            HSSFSheet sheet10 = workbook.createSheet("Salud NNA");
            HSSFSheet sheet11 = workbook.createSheet("Relación Familiar");
            HSSFSheet sheet12 = workbook.createSheet("Observaciones");
            HSSFRow rowhead = sheet.createRow(0);
            rowhead.createCell(0).setCellValue("REPORTE DE FICHA ANAMNESIS");
            
            
            for (int r = 0; r < modeldi.getRowCount(); r++) {
                HSSFRow row = sheet.createRow(r+1);
                for (int c = 0; c < modeldi.getColumnCount(); c++) {
                    HSSFCell celda = row.createCell(c);
                    celda.setCellValue(String.valueOf(modeldi.getValueAt(r, c)));
                }

            }
            for (int r = 0; r < modeldpm.getRowCount(); r++) {
                HSSFRow row = sheet2.createRow(r);
                for (int c = 0; c < modeldpm.getColumnCount(); c++) {
                    HSSFCell celda = row.createCell(c);
                    celda.setCellValue(String.valueOf(modeldpm.getValueAt(r, c)));
                }

            }
            
            for (int r = 0; r < modelpe.getRowCount(); r++) {
                HSSFRow row = sheet3.createRow(r);
                for (int c = 0; c < modelpe.getColumnCount(); c++) {
                    HSSFCell celda = row.createCell(c);
                    celda.setCellValue(String.valueOf(modelpe.getValueAt(r, c)));
                }

            }
            
            for (int r = 0; r < modelcn.getRowCount(); r++) {
                HSSFRow row = sheet4.createRow(r);
                for (int c = 0; c < modelcn.getColumnCount(); c++) {
                    HSSFCell celda = row.createCell(c);
                    celda.setCellValue(String.valueOf(modelcn.getValueAt(r, c)));
                }

            }
            
            for (int r = 0; r < modelpdv.getRowCount(); r++) {
                HSSFRow row = sheet5.createRow(r);
                for (int c = 0; c < modelpdv.getColumnCount(); c++) {
                    HSSFCell celda = row.createCell(c);
                    celda.setCellValue(String.valueOf(modelpdv.getValueAt(r, c)));
                }

            }
            
            for (int r = 0; r < modelaa.getRowCount(); r++) {
                HSSFRow row = sheet6.createRow(r);
                for (int c = 0; c < modelaa.getColumnCount(); c++) {
                    HSSFCell celda = row.createCell(c);
                    celda.setCellValue(String.valueOf(modelaa.getValueAt(r, c)));
                }

            }
            for (int r = 0; r < modeldm.getRowCount(); r++) {
                HSSFRow row = sheet7.createRow(r);
                for (int c = 0; c < modeldm.getColumnCount(); c++) {
                    HSSFCell celda = row.createCell(c);
                    celda.setCellValue(String.valueOf(modeldm.getValueAt(r, c)));
                }

            }
            for (int r = 0; r < modelsce.getRowCount(); r++) {
                HSSFRow row = sheet8.createRow(r);
                for (int c = 0; c < modelsce.getColumnCount(); c++) {
                    HSSFCell celda = row.createCell(c);
                    celda.setCellValue(String.valueOf(modelsce.getValueAt(r, c)));
                }

            }
            
            for (int r = 0; r < modelenna.getRowCount(); r++) {
                HSSFRow row = sheet9.createRow(r);
                for (int c = 0; c < modelenna.getColumnCount(); c++) {
                    HSSFCell celda = row.createCell(c);
                    celda.setCellValue(String.valueOf(modelenna.getValueAt(r, c)));
                }

            }
            for (int r = 0; r < modelsnna.getRowCount(); r++) {
                HSSFRow row = sheet10.createRow(r);
                for (int c = 0; c < modelsnna.getColumnCount(); c++) {
                    HSSFCell celda = row.createCell(c);
                    celda.setCellValue(String.valueOf(modelsnna.getValueAt(r, c)));
                }

            }
            
            for (int r = 0; r < modelrf.getRowCount(); r++) {
                HSSFRow row = sheet11.createRow(r);
                for (int c = 0; c < modelrf.getColumnCount(); c++) {
                    HSSFCell celda = row.createCell(c);
                    celda.setCellValue(String.valueOf(modelrf.getValueAt(r, c)));
                }

            }
            for (int r = 0; r < modelo.getRowCount(); r++) {
                HSSFRow row= sheet12.createRow(r);
                for (int c = 0; c < modelo.getColumnCount(); c++) {
                    HSSFCell celda = row.createCell(c);
                    celda.setCellValue(String.valueOf(modelo.getValueAt(r, c)));
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
