package marylove.controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import static javax.swing.WindowConstants.DISPOSE_ON_CLOSE;
import marylove.DBmodelo.IngresoDB;
import marylove.conexion.ConexionHi;
import marylove.vista.VistaReportes;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;

public class ControlReporte implements ActionListener {

    private VistaReportes vreportes;
    private ArrayList<String> anios;
    private DefaultComboBoxModel modelo;
    private IngresoDB i;

    private ConexionHi conn;

    public ControlReporte(VistaReportes vreportes) {
        this.vreportes = vreportes;
        this.vreportes.setVisible(true);
        this.vreportes.getjBn_Anual().addActionListener(this);
        this.vreportes.getBtn_General().addActionListener(this);
        this.vreportes.getBtnCompaniera().addActionListener(this);
        this.vreportes.getBtnHijos().addActionListener(this);
        this.vreportes.getPnlEspecificacion().setVisible(false);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(this.vreportes.getjBn_Anual())) {
            this.vreportes.getPnlEspecificacion().setVisible(true);
            this.vreportes.getBtnHijos().setEnabled(false);
            this.vreportes.getBtnCompaniera().setEnabled(false);
            try {
                llenarComboAnio();
            } catch (SQLException ex) {
                Logger.getLogger(ControlReporte.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        if (e.getSource().equals(this.vreportes.getBtn_General())) {
            this.vreportes.getPnlEspecificacion().setVisible(true);
            this.vreportes.getBtnHijos().setEnabled(true);
            this.vreportes.getBtnCompaniera().setEnabled(true);
            try {
                llenarComboAnio();
            } catch (SQLException ex) {
                Logger.getLogger(ControlReporte.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        if (e.getSource().equals(vreportes.getjButtReportAnio())) {
            try {
//
                ConexionHi con = new ConexionHi();
                Connection conn = con.getConnection();
                JasperReport reporte = null;
                String path = "src//marylove/reports/report_anio.jasper";
                Map parametro = new HashMap();
                parametro.put("estadocli", vreportes.jComboBoxAnios.toString());

                reporte = (JasperReport) JRLoader.loadObject(path);
                JasperPrint jprint = JasperFillManager.fillReport(path, parametro, conn);

                JasperViewer view = new JasperViewer(jprint, false);
                view.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
                view.setVisible(true);
            } catch (JRException ex) {
                Logger.getLogger(ControlReporte.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex) {
                Logger.getLogger(ControlReporte.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        if (e.getSource().equals(this.vreportes.getBtnHijos())) {
            ReporteHijos();
        }
        if (e.getSource().equals(this.vreportes.getBtnCompaniera())) {
            ReporteCompañera();
        }

    }

    public void llenarComboAnio() throws SQLException {
        i = new IngresoDB();
        anios = i.obtenerAnio();
        modelo = new DefaultComboBoxModel();
        for (String o : anios) {
            modelo.addElement(o);
        }
        vreportes.getjComboBoxAnios().setModel(modelo);
    }

    public void ReporteHijos() {
        try {
//
            ConexionHi con = new ConexionHi();
            Connection conn = con.getConnection();
            JasperReport reporte = null;
            String path = "src//marylove/reports/ReporteHijos.jasper";
            Map parametro = new HashMap();
            parametro.put("anio", vreportes.getjComboBoxAnios().getSelectedIndex());

            reporte = (JasperReport) JRLoader.loadObject(path);
            JasperPrint jprint = JasperFillManager.fillReport(path, parametro, conn);

            JasperViewer view = new JasperViewer(jprint, false);
            view.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
            view.setVisible(true);
        } catch (JRException ex) {
            Logger.getLogger(ControlReporte.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ControlReporte.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception e) {

        }
    }

    public void ReporteCompañera() {
        try {
//
            ConexionHi con = new ConexionHi();
            Connection conn = con.getConnection();
            JasperReport reporte = null;
            String path = "src//marylove/reports/Reportevictima.jasper";
            Map parametro = new HashMap();
            parametro.put("anio", vreportes.getjComboBoxAnios().getSelectedIndex());

            reporte = (JasperReport) JRLoader.loadObject(path);
            JasperPrint jprint = JasperFillManager.fillReport(path, parametro, conn);

            JasperViewer view = new JasperViewer(jprint, false);
            view.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
            view.setVisible(true);
        } catch (JRException ex) {
            Logger.getLogger(ControlReporte.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ControlReporte.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception e) {

        }
    }

    public void reporteAnio() {
        try {
            ConexionHi con = new ConexionHi();
            Connection conn = con.getConnection();
            JasperReport reporte = null;
            String path = "src//marylove/reports/report_anio.jasper";
            Map parametro = new HashMap();
            parametro.put("anio", vreportes.getjComboBoxAnios().getSelectedIndex());

            reporte = (JasperReport) JRLoader.loadObject(path);
            JasperPrint jprint = JasperFillManager.fillReport(path, parametro, conn);

            JasperViewer view = new JasperViewer(jprint, false);
            view.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
            view.setVisible(true);
        } catch (JRException ex) {
            Logger.getLogger(ControlReporte.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ControlReporte.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception e) {

        }

    }
}
