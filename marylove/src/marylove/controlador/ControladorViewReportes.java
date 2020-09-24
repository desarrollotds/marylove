/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package marylove.controlador;

import marylove.DBmodelo.SentenciasSelectReportesDB;
import com.toedter.calendar.JDateChooser;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import marylove.DBmodelo.IngresoDB;
import marylove.conexion.ConexionHi;
import marylove.vista.ViewReports;

/**
 *
 * @author usuario
 */
public class ControladorViewReportes implements ActionListener {

    ViewReports vreportes;
    private ArrayList<String> anios;
    private DefaultComboBoxModel modelo;
    private IngresoDB i;
    private int bandera;
    private String id_ingreso;
    private ConexionHi conn = new ConexionHi();
    private DefaultTableModel modelotabla;
    private SentenciasSelectReportesDB sentencias = new SentenciasSelectReportesDB();
    ConvertirExcel excel = new ConvertirExcel();

    public ControladorViewReportes() {
    }

    public ControladorViewReportes(ViewReports vreportes) {
        this.vreportes = vreportes;
        this.vreportes.setVisible(true);
        CargarCombo();
        this.vreportes.setIconImage(new ImageIcon(getClass().getResource("/iconos/logoml.png")).getImage());
        this.vreportes.getPnlEspecificacion().setVisible(false);
        this.vreportes.getBtnReport().addActionListener(this);
        this.vreportes.getCbxTipoReporte().addActionListener(this);
        this.vreportes.getPnlEspecificacion().setVisible(false);
        this.vreportes.getTxtCedula().setVisible(false);
        this.vreportes.getLbcedula().setVisible(false);
        this.vreportes.getjComboBoxAnios().setVisible(false);
        this.vreportes.getLbanio().setVisible(false);
        this.vreportes.getLbFecha().setVisible(false);
        this.vreportes.getDate().setVisible(false);
        this.vreportes.getDatefinal().setVisible(false);
        this.vreportes.getLbfechafinal().setVisible(false);
        this.vreportes.getLblTipoReporte().setText(this.vreportes.getCbxTipoReporte().getSelectedItem().toString());

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(this.vreportes.getCbxTipoReporte())) {
            if (vreportes.getCbxTipoReporte().getSelectedIndex() == 0) {
                JOptionPane.showMessageDialog(vreportes, "Seleccione un area de reporte", "Mensaje de Información", JOptionPane.WARNING_MESSAGE);
            } else {
                try {
                    llenarComboAnio();
                    this.vreportes.getLblTipoReporte().setText(this.vreportes.getCbxTipoReporte().getSelectedItem().toString());
                    this.vreportes.getPnlEspecificacion().setVisible(true);

                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(vreportes, "Se ha producido un error inesperado con la base de datos",
                            "MENSAJE DE ERROR", JOptionPane.ERROR_MESSAGE);
                }
                if (vreportes.getCbxTipoReporte().getSelectedIndex() == 1) {
                    HabilitarAnio();
                    bandera = 1;
                }
                if (vreportes.getCbxTipoReporte().getSelectedIndex() == 2) {
                    HabilitarCedula();
                    bandera = 2;
                }
                if (vreportes.getCbxTipoReporte().getSelectedIndex() == 3) {
                    HabilitarFecha();
                    bandera = 3;
                }
                if (vreportes.getCbxTipoReporte().getSelectedIndex() == 4) {
                    HabilitarAnio();
                    bandera = 4;
                }
                if (vreportes.getCbxTipoReporte().getSelectedIndex() == 5) {
                    HabilitarCedula();
                    bandera = 5;
                }
                if (vreportes.getCbxTipoReporte().getSelectedIndex() == 6) {
                    HabilitarFecha();
                    bandera = 6;
                }
                if (vreportes.getCbxTipoReporte().getSelectedIndex() == 7) {
                    HabilitarAnio();
                    bandera = 7;
                }
                if (vreportes.getCbxTipoReporte().getSelectedIndex() == 8) {
                    HabilitarCedula();
                    bandera = 8;
                }
                if (vreportes.getCbxTipoReporte().getSelectedIndex() == 9) {
                    HabilitarFecha();
                    bandera = 9;
                }
                if (vreportes.getCbxTipoReporte().getSelectedIndex() == 10) {
                    HabilitarCedulayFecha();
                    bandera = 10;
                }
                if (vreportes.getCbxTipoReporte().getSelectedIndex() == 11) {
                    HabilitarAnio();
                    bandera = 11;
                }

                if (vreportes.getCbxTipoReporte().getSelectedIndex() == 12) {
                    HabilitarCedulayFecha();
                    bandera = 12;
                }
                if (vreportes.getCbxTipoReporte().getSelectedIndex() == 13) {
                    HabilitarAnio();
                    bandera = 13;
                }
                if (vreportes.getCbxTipoReporte().getSelectedIndex() == 14) {
                    HabilitarCedula();
                    bandera = 14;
                }
                if (vreportes.getCbxTipoReporte().getSelectedIndex() == 15) {
                    HabilitarFecha();
                    bandera = 15;
                }
                if (vreportes.getCbxTipoReporte().getSelectedIndex() == 16) {
                    HabilitarCedula();
                    bandera = 16;
                }

            }
        }
        if (e.getSource().equals(vreportes.getBtnReport())) {
            if (bandera == 1) {
                modelotabla = new DefaultTableModel();
                modelotabla = sentencias.ReporteGeneral(vreportes.getjComboBoxAnios().getSelectedItem().toString());
                excel.exportar(vreportes, modelotabla, "REPORTE GENERAL POR AÑO");
            }
            if (bandera == 2) {
                if (vreportes.getTxtCedula().getText().isEmpty()) {
                    JOptionPane.showMessageDialog(vreportes, "Ingrese una cedula", "Información", JOptionPane.ERROR_MESSAGE);
                } else {

                    modelotabla = new DefaultTableModel();
                    modelotabla = sentencias.ReporteGeneralporVictima(vreportes.getTxtCedula().getText());
                    excel.exportar(vreportes, modelotabla, "REPORTE GENERAL POR BENEFICIARIA");
                }
            }
            if (bandera == 3) {
                modelotabla = new DefaultTableModel();
                modelotabla = sentencias.ReporteGeneralporFechas(obtenerFecha(vreportes.getDate()), obtenerFecha(vreportes.getDatefinal()));
                excel.exportar(vreportes, modelotabla, "REPORTE GENERAL ENTRE FECHAS");
            }
            if (bandera == 4) {
                modelotabla = new DefaultTableModel();
                modelotabla = sentencias.ReporteGeneralVictimas(vreportes.getjComboBoxAnios().getSelectedItem().toString());
                excel.exportar(vreportes, modelotabla, "REPORTE GENERAL-BENEFICIARIAS POR AÑO");
            }
            if (bandera == 5) {
                if (vreportes.getTxtCedula().getText().isEmpty()) {
                    JOptionPane.showMessageDialog(vreportes, "Ingrese una cedula", "Información", JOptionPane.ERROR_MESSAGE);
                } else {

                    modelotabla = new DefaultTableModel();
                    modelotabla = sentencias.ReporteGeneralVictimasporVictima(vreportes.getTxtCedula().getText());
                    excel.exportar(vreportes, modelotabla, "REPORTE GENERAL- BENEFICIARIA");
                }
            }
            if (bandera == 6) {
                modelotabla = new DefaultTableModel();
                modelotabla = sentencias.ReporteGeneralVictimasporFechas(obtenerFecha(vreportes.getDate()), obtenerFecha(vreportes.getDatefinal()));
                excel.exportar(vreportes, modelotabla, "REPORTE GENERAL-BENEFICIARIA ");
            }
            if (bandera == 7) {
                modelotabla = new DefaultTableModel();
                modelotabla = sentencias.ReporteGeneralNNA(vreportes.getjComboBoxAnios().getSelectedItem().toString());
                excel.exportar(vreportes, modelotabla, "REPORTE GENERAL-NNA POR AÑO");
            }
            if (bandera == 8) {
                if (vreportes.getTxtCedula().getText().isEmpty()) {
                    JOptionPane.showMessageDialog(vreportes, "Ingrese una cedula", "Información", JOptionPane.ERROR_MESSAGE);
                } else {

                    modelotabla = new DefaultTableModel();
                    modelotabla = sentencias.ReporteGeneralNNAporVictima(vreportes.getTxtCedula().getText());
                    excel.exportar(vreportes, modelotabla, "REPORTE GENERAL- NNA POR BENEFICIARIA");
                }
            }
            if (bandera == 9) {
                modelotabla = new DefaultTableModel();
                modelotabla = sentencias.ReporteGeneralNNAporFechas(obtenerFecha(vreportes.getDate()), obtenerFecha(vreportes.getDatefinal()));
                excel.exportar(vreportes, modelotabla, "REPORTE GENERAL-NNA ");
            }

            if (bandera == 10) {
                if (vreportes.getTxtCedula().getText().isEmpty()) {
                    JOptionPane.showMessageDialog(vreportes, "Ingrese una cedula", "Información", JOptionPane.ERROR_MESSAGE);
                } else {

                    modelotabla = new DefaultTableModel();
                    modelotabla = sentencias.ReporteBitacora(obtenerFecha(vreportes.getDate()), obtenerFecha(vreportes.getDatefinal()), vreportes.getTxtCedula().getText());
                    excel.exportar(vreportes, modelotabla, "REPORTE BITACORA");
                }
            }

            if (bandera == 11) {
                modelotabla = new DefaultTableModel();
                modelotabla = sentencias.ReporteAnio(vreportes.getjComboBoxAnios().getSelectedItem().toString());
                excel.exportar(vreportes, modelotabla, "REPORTE POR AÑO");
            }
            if (bandera == 12) {
                if (vreportes.getTxtCedula().getText().isEmpty()) {
                    JOptionPane.showMessageDialog(vreportes, "Ingrese una cedula", "Información", JOptionPane.ERROR_MESSAGE);
                } else {
                    modelotabla = new DefaultTableModel();
                    modelotabla = sentencias.PlanEmergente(obtenerFecha(vreportes.getDate()), obtenerFecha(vreportes.getDatefinal()), vreportes.getTxtCedula().getText());
                    excel.exportar(vreportes, modelotabla, "REPORTE PLAN EMERGENTE");
                }
            }
            if (bandera == 13) {
                modelotabla = new DefaultTableModel();
                modelotabla = sentencias.EgresoporAnio(vreportes.getjComboBoxAnios().getSelectedItem().toString());
                excel.exportar(vreportes, modelotabla, "REPORTE EGRESOS");
            }
            if (bandera == 14) {
                modelotabla = new DefaultTableModel();
                modelotabla = sentencias.EgresoporVictima(vreportes.getjComboBoxAnios().getSelectedItem().toString());
                excel.exportar(vreportes, modelotabla, "REPORTE EGRESO POR BENEFICIARIA");
            }
            if (bandera == 15) {
                modelotabla = new DefaultTableModel();
                modelotabla = sentencias.EgresoporFechas(obtenerFecha(vreportes.getDate()), obtenerFecha(vreportes.getDatefinal()));
                excel.exportar(vreportes, modelotabla, "REPORTE EGRESO POR FECHAS");
            }
            if (bandera == 16) {
                if (vreportes.getTxtCedula().getText().isEmpty()) {
                    JOptionPane.showMessageDialog(vreportes, "Ingrese una cedula", "Información", JOptionPane.ERROR_MESSAGE);
                } else {
                    if (ConsultarVictima(vreportes.getTxtCedula().getText())) {
                        ReporteIngreso();
                    } else {
                        JOptionPane.showMessageDialog(vreportes, "No existen datos registrados", "Información", JOptionPane.WARNING_MESSAGE);
                    }
                }
            }

        }
    }

    public void CargarCombo() {
        String[] items = {"Seleccione el tipo de reporte...", "Reporte General  por año", "Reporte General por Beneficiaria", "Reporte General entre fechas",
            "Reporte General - Beneficiarias  por año", "Reporte General -Beneficiaria ", "Reporte General Beneficiarias entre fechas",
            "Reporte General - NNA por año", "Reporte General-NNA por beneficiaria", "Reporte General - NNA entre fechas",
            "Reporte Bitacora", "Reporte por Año", "Plan Emergente", "Reporte Egresos por año", "Reporte Egresos por Beneficiaria", "Reporte Egresos entre fechas", "Ficha Ingreso"};
        for (int i = 0; i < items.length; i++) {
            vreportes.getCbxTipoReporte().addItem(items[i]);
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

    public void HabilitarAnio() {

        this.vreportes.getTxtCedula().setVisible(false);
        this.vreportes.getLbcedula().setVisible(false);
        this.vreportes.getjComboBoxAnios().setVisible(true);
        this.vreportes.getLbanio().setVisible(true);
        this.vreportes.getLbFecha().setVisible(false);
        this.vreportes.getDate().setVisible(false);
        this.vreportes.getDatefinal().setVisible(false);
        this.vreportes.getLbfechafinal().setVisible(false);
    }

    public void HabilitarCedula() {
        this.vreportes.getTxtCedula().setVisible(true);
        this.vreportes.getLbcedula().setVisible(true);
        this.vreportes.getjComboBoxAnios().setVisible(false);
        this.vreportes.getLbanio().setVisible(false);
        this.vreportes.getLbFecha().setVisible(false);
        this.vreportes.getDate().setVisible(false);
        this.vreportes.getDatefinal().setVisible(false);
        this.vreportes.getLbfechafinal().setVisible(false);
    }

    public void HabilitarFecha() {
        this.vreportes.getTxtCedula().setVisible(false);
        this.vreportes.getLbcedula().setVisible(false);
        this.vreportes.getjComboBoxAnios().setVisible(false);
        this.vreportes.getLbanio().setVisible(false);
        this.vreportes.getLbFecha().setVisible(true);
        this.vreportes.getDate().setVisible(true);
        this.vreportes.getDatefinal().setVisible(true);
        this.vreportes.getLbfechafinal().setVisible(true);
        Date date = new Date();
        this.vreportes.getDate().setDate(date);
        this.vreportes.getDatefinal().setDate(date);

    }

    public void HabilitarCedulayFecha() {
        this.vreportes.getTxtCedula().setVisible(true);
        this.vreportes.getLbcedula().setVisible(true);
        this.vreportes.getjComboBoxAnios().setVisible(false);
        this.vreportes.getLbanio().setVisible(false);
        this.vreportes.getLbFecha().setVisible(true);
        this.vreportes.getDate().setVisible(true);
        this.vreportes.getDatefinal().setVisible(true);
        this.vreportes.getLbfechafinal().setVisible(true);
        Date date = new Date();
        this.vreportes.getDate().setDate(date);
        this.vreportes.getDatefinal().setDate(date);
    }

    public String obtenerFecha(JDateChooser fech) {
        Date fechaN = fech.getDate();
        String fecha2 = "";
        SimpleDateFormat NFormat = new SimpleDateFormat("yyyy/MM/dd");
        fecha2 = NFormat.format(fechaN);
        return fecha2;
    }

    public boolean ConsultarVictima(String cedula) {
        boolean existe = false;
        String sql = "select ingreso_id, p.persona_cedula from ingreso i\n"
                + "join victima v\n"
                + "using(victima_codigo)\n"
                + "JOIN persona p\n"
                + "using(persona_codigo)\n"
                + "WHERE i.ingreso_estado='a'\n"
                + "AND p.persona_cedula ='" + cedula + "' ";
        try {
            ResultSet res = conn.query(sql);
            while (res.next()) {
                existe = true;
                id_ingreso = res.getString(1);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Surgió un error inesperado", "Información", JOptionPane.ERROR_MESSAGE);
        }

        return existe;
    }

    public void ReporteIngreso() {
        SentenciasSelectReportesDB sentencias = new SentenciasSelectReportesDB();
        ExportarExcelIngreso excel = new ExportarExcelIngreso();
        DefaultTableModel modelip = new DefaultTableModel();
        DefaultTableModel modeldor = new DefaultTableModel();
        DefaultTableModel modelab = new DefaultTableModel();
        DefaultTableModel modelaf = new DefaultTableModel();
        modelip = sentencias.IngresoIP(id_ingreso);
        modeldor=sentencias.IngresoD(id_ingreso);
        modelab = sentencias.IngresoAEB(id_ingreso);
        modelaf= sentencias.IngresoAEF(id_ingreso);
        excel.Exportar(modelip, modeldor, modelab, modelaf, vreportes);
    }
}
