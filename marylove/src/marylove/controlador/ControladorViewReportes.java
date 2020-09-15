/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package marylove.controlador;

import com.toedter.calendar.JDateChooser;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
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
public class ControladorViewReportes  implements ActionListener {

    ViewReports vreportes;
    private ArrayList<String> anios;
    private DefaultComboBoxModel modelo;
    private IngresoDB i;
    private int bandera;
    private Validaciones validaciones;
    private ConexionHi conn = new ConexionHi();
    private DefaultTableModel modelotabla;
    private SentenciasSelect sentencias = new SentenciasSelect();
    ConvertirExcel excel = new ConvertirExcel();

    public ControladorViewReportes(ViewReports vreportes) {
        this.vreportes = vreportes;
        this.vreportes.setVisible(true);
        CargarCombo();
        this.vreportes.setIconImage(new ImageIcon(getClass().getResource("/iconos/logoml.png")).getImage());
        this.vreportes.getPnlEspecificacion().setVisible(false);
        this.vreportes.getBtnReport().addActionListener(this);
        this.vreportes.getCbxTipoReporte().addActionListener(this);
        this.vreportes.getPnlEspecificacion().setVisible(false);
        this.vreportes.getTxtID().setVisible(false);
        this.vreportes.getLbid().setVisible(false);
        this.vreportes.getTxtCedula().setVisible(false);
        this.vreportes.getLbcedula().setVisible(false);
        this.vreportes.getjComboBoxAnios().setVisible(false);
        this.vreportes.getLbanio().setVisible(false);
        this.vreportes.getLbFecha().setVisible(false);
        this.vreportes.getDate().setVisible(false);
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
                    HabilitarFecha();
                    bandera = 2;
                }
                if (vreportes.getCbxTipoReporte().getSelectedIndex() == 3) {
                    HabilitarCedula();
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
                    Habilitar();
                    HabilitarFecha();
                    bandera = 6;
                }
                if (vreportes.getCbxTipoReporte().getSelectedIndex() == 7) {
                    Habilitar();
                    bandera = 7;
                }
                if (vreportes.getCbxTipoReporte().getSelectedIndex() == 8) {
                    HabilitarCedula();
                    bandera = 8;
                }
                if (vreportes.getCbxTipoReporte().getSelectedIndex() == 9) {
                    HabilitarCedula();
                    HabilitarFecha();
                    bandera = 9;
                }
                if (vreportes.getCbxTipoReporte().getSelectedIndex() == 10) {
                    HabilitarCedula();
                    bandera = 10;
                }
                if (vreportes.getCbxTipoReporte().getSelectedIndex() == 11) {
                    HabilitarCedula();
                    bandera = 11;
                }
            }
        }
        if (e.getSource().equals(vreportes.getBtnReport())) {
            if (bandera == 1) {
                modelotabla = new DefaultTableModel();
                modelotabla = sentencias.ReporteGeneral(vreportes.getjComboBoxAnios().getSelectedItem().toString());
                excel.exportar(vreportes, modelotabla, "REORTE GENERAL");
            }
            if (bandera == 2) {
                if (vreportes.getTxtCedula().getText().isEmpty()) {
                    JOptionPane.showMessageDialog(vreportes, "Ingrese una cedula", "Información", JOptionPane.ERROR_MESSAGE);
                } else {
                    modelotabla = new DefaultTableModel();
                    modelotabla = sentencias.ReporteBitacora(vreportes.getTxtCedula().getText(),obtenerFecha(vreportes.getDate()));
                    excel.exportar(vreportes, modelotabla, "REPORTE BITACORA");
                }
            }
            if (bandera == 3) {
                if (vreportes.getTxtCedula().getText().isEmpty()) {
                    JOptionPane.showMessageDialog(vreportes, "Ingrese una cedula", "Información", JOptionPane.ERROR_MESSAGE);
                } else {
                    modelotabla = new DefaultTableModel();
                    modelotabla = sentencias.ReporteFormularios(vreportes.getTxtCedula().getText());
                    excel.exportar(vreportes, modelotabla, "REPORTE DE FORMULARIOS");
                }
            }
            if (bandera == 4) {
                modelotabla = new DefaultTableModel();
                modelotabla = sentencias.ReporteAnio(vreportes.getjComboBoxAnios().getSelectedItem().toString());
                excel.exportar(vreportes, modelotabla, "REPORTE POR AÑO");
            }
            if (bandera == 5) {
                if (vreportes.getTxtCedula().getText().isEmpty()) {
                    JOptionPane.showMessageDialog(vreportes, "Ingrese una cedula", "Información", JOptionPane.ERROR_MESSAGE);
                } else {
                    modelotabla = new DefaultTableModel();
                    modelotabla = sentencias.PrimerEncuentro(vreportes.getTxtCedula().getText());
                    excel.exportar(vreportes, modelotabla, "REPORTE PRIMER ENCUENTRO");
                }
            }
            if (bandera == 6) {
                if (vreportes.getTxtCedula().getText().isEmpty()) {
                    JOptionPane.showMessageDialog(vreportes, "Ingrese una cedula", "Información", JOptionPane.ERROR_MESSAGE);
                } else {
                    modelotabla = new DefaultTableModel();
                    modelotabla = sentencias.Avances_Terapeuticos(vreportes.getTxtCedula().getText(),obtenerFecha(vreportes.getDate()));
                    excel.exportar(vreportes, modelotabla, "REPORTE PRIMER ENCUENTRO");
                }
            }
            if (bandera == 7) {
                if (vreportes.getTxtID().getText().isEmpty()) {
                    JOptionPane.showMessageDialog(vreportes, "Ingrese un ID", "Información", JOptionPane.ERROR_MESSAGE);
                } else {
                  GenerarAnamnesis();
                }
                
            }
            if (bandera == 8) {
                if (vreportes.getTxtCedula().getText().isEmpty()) {
                    JOptionPane.showMessageDialog(vreportes, "Ingrese una cedula", "Información", JOptionPane.ERROR_MESSAGE);
                } else {
                    modelotabla = new DefaultTableModel();
                    modelotabla = sentencias.PlanAtencion(vreportes.getTxtCedula().getText());
                    excel.exportar(vreportes, modelotabla, "REPORTE PLAN ATENCIÓN TEAPEUTICA");
                }
            }
             if (bandera == 9) {
                if (vreportes.getTxtCedula().getText().isEmpty()) {
                    JOptionPane.showMessageDialog(vreportes, "Ingrese una cedula", "Información", JOptionPane.ERROR_MESSAGE);
                } else {
                    modelotabla = new DefaultTableModel();
                    modelotabla = sentencias.PlanEmergente(vreportes.getTxtCedula().getText(),obtenerFecha(vreportes.getDate()));
                    excel.exportar(vreportes, modelotabla, "REPORTE PLAN EMERGENTE");
                }
            }
             if (bandera == 10) {
                if (vreportes.getTxtCedula().getText().isEmpty()) {
                    JOptionPane.showMessageDialog(vreportes, "Ingrese una cedula", "Información", JOptionPane.ERROR_MESSAGE);
                } else {
                    modelotabla = new DefaultTableModel();
                    modelotabla = sentencias.HistorialClinico(vreportes.getTxtCedula().getText());
                    excel.exportar(vreportes, modelotabla, "REPORTE HISTORIAL CLINICO");
                }
            }
             if (bandera == 11) {
                if (vreportes.getTxtCedula().getText().isEmpty()) {
                    JOptionPane.showMessageDialog(vreportes, "Ingrese una cedula", "Información", JOptionPane.ERROR_MESSAGE);
                } else {
                    modelotabla = new DefaultTableModel();
                    modelotabla = sentencias.FichaLegal(vreportes.getTxtCedula().getText());
                    excel.exportar(vreportes, modelotabla, "REPORTE FICHA LEGAL");
                }
            }

            
        }
    }

    public void CargarCombo() {
        String[] items = {"Seleccione el tipo de reporte...", "Reporte General", "Reporte de Bitacora", "Reporte de Formularios",
            "Reporte por Año", "Primer Encuentro", "Avances Terapeuticos", "Anamnesis",
            "Plan Terapeutico", "Plan Emergente", "Historial Clinico", "Ficha Legal"};
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

    public void Habilitar() {
        this.vreportes.getTxtID().setVisible(true);
        this.vreportes.getLbid().setVisible(true);
        this.vreportes.getTxtCedula().setVisible(false);
        this.vreportes.getLbcedula().setVisible(false);
        this.vreportes.getjComboBoxAnios().setVisible(false);
        this.vreportes.getLbanio().setVisible(false);
    }

    public void HabilitarAnio() {
        this.vreportes.getTxtID().setVisible(false);
        this.vreportes.getLbid().setVisible(false);
        this.vreportes.getTxtCedula().setVisible(false);
        this.vreportes.getLbcedula().setVisible(false);
        this.vreportes.getjComboBoxAnios().setVisible(true);
        this.vreportes.getLbanio().setVisible(true);
        this.vreportes.getLbFecha().setVisible(false);
        this.vreportes.getDate().setVisible(false);
    }

    public void HabilitarCedula() {
        this.vreportes.getTxtID().setVisible(false);
        this.vreportes.getLbid().setVisible(false);
        this.vreportes.getTxtCedula().setVisible(true);
        this.vreportes.getLbcedula().setVisible(true);
        this.vreportes.getjComboBoxAnios().setVisible(false);
        this.vreportes.getLbanio().setVisible(false);
        this.vreportes.getLbFecha().setVisible(false);
        this.vreportes.getDate().setVisible(false);
    }

    public void HabilitarFecha() {
        this.vreportes.getLbFecha().setVisible(true);
        this.vreportes.getDate().setVisible(true);
        Date date = new Date();
        this.vreportes.getDate().setDate(date);
    }
    
     public String obtenerFecha(JDateChooser fech) {
        Date fechaN = fech.getDate();
        String fecha2 = "";
        SimpleDateFormat NFormat = new SimpleDateFormat("yyyy/MM/dd");
        fecha2 = NFormat.format(fechaN);
        return fecha2;
    }
     
     public void GenerarAnamnesis(){
        ExportarExcelAnamnesis exc = new ExportarExcelAnamnesis();
        DefaultTableModel modeldi;
        DefaultTableModel modeldpm;
        DefaultTableModel modelpe;
        DefaultTableModel modelcn;
        DefaultTableModel modelpdv;
        DefaultTableModel modelaa;
        DefaultTableModel modeldm;
        DefaultTableModel modelsce;
        DefaultTableModel modelenna;
        DefaultTableModel modelsnna;
        DefaultTableModel modelrf;
        DefaultTableModel modelo;
        SentenciasSelect sentencias = new SentenciasSelect();
        modeldi=sentencias.ReporteAnamnesisDP(vreportes.getTxtID().getText());
        modeldpm=sentencias.AnamnesisDPM(vreportes.getTxtID().getText());
        modelpe=sentencias.AnamnesisPE(vreportes.getTxtID().getText());
        modelcn=sentencias.AnamnesisCN(vreportes.getTxtID().getText());
        modelpdv=sentencias.AnamnesisPDV(vreportes.getTxtID().getText());
        modelaa=sentencias.AnamnesisAA(vreportes.getTxtID().getText());
        modeldm=sentencias.AnamnesisDM(vreportes.getTxtID().getText());
        modelsce=sentencias.AnamnesisSCE(vreportes.getTxtID().getText());
        modelenna=sentencias.AnamnesisENNA(vreportes.getTxtID().getText());
        modelsnna=sentencias.AnamnesisSNNA(vreportes.getTxtID().getText());
        modelrf=sentencias.AnamnesisRF(vreportes.getTxtID().getText());
        modelo=sentencias.AnamnesisO(vreportes.getTxtID().getText());
        exc.Exportar(modeldi, modeldpm, modelpe, modelcn, modelpdv, modelaa, modeldm, modelsce, modelenna, modelsnna, modelrf, modelo,vreportes);
     }
}
