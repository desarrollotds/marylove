
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
package marylove.controlador;
//
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
//import java.sql.Connection;
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import marylove.conexion.ConexionHi;
//import marylove.vista.VistaReportes;
//import net.sf.jasperreports.engine.JasperFillManager;
//import net.sf.jasperreports.engine.JasperPrint;
//import net.sf.jasperreports.engine.JasperReport;
//
///**
// *
// * @author ubuntu
// */


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import marylove.vista.VistaReportes;

public class ControlReporte implements ActionListener {
//
    private VistaReportes vreportes;

    public ControlReporte(VistaReportes vreportes) {
        this.vreportes = vreportes;
        this.vreportes.setVisible(true);
        this.vreportes.getjBn_Anual().addActionListener(this);
        this.vreportes.getPnlEspecificacion().setVisible(false);
    }
    
//    PreparedStatement ps;
//    ResultSet re = null;
//
//    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource().equals(this.vreportes.getjBn_Anual())){
            this.vreportes.getPnlEspecificacion().setVisible(true);
        }

    }
//
//    public ControlReporte(VistaReportes vreportes) {
//        this.vreportes = vreportes;
//    }
//
//    public void reporte_anio() throws SQLException {
//        con = new ConexionHi();
//        Connection conn = con.getConnection();
//JasperReport reporte=null;
//String path="src/marylove/reports/report_anio.jasper";
////   reporte = (JasperReport) LRLoadObjectFromFile(path);
////JasperPrint jprint =JasperFillManager.fillReport(path);
//
//    
//    
//    
//    }
//
}

