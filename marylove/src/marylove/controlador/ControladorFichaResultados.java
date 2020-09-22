/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package marylove.controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import marylove.DBmodelo.ResultadosDB;
import marylove.conexion.ConexionHi;
import marylove.models.Resultados;
import marylove.vista.VistaResultados;

/**
 *
 * @author usuario
 */
public class ControladorFichaResultados implements ActionListener {

    VistaResultados vista;
    DefaultTableModel modelotabla;
    private ConexionHi conectar = new ConexionHi();
    ResultadosDB resul = new ResultadosDB();

    public ControladorFichaResultados(VistaResultados vista) {
        this.vista = vista;
        this.vista.setVisible(true);
        this.vista.setResizable(false);
        this.vista.getBtnBuscar().addActionListener(this);
        this.vista.getBtngenerar().addActionListener(this);
//        this.vista.getTablaResultados().setVisible(false);
        inicializador();

    }

    public void inicializador() {

        modelotabla = new DefaultTableModel();
        modelotabla.addColumn("Compañera");
        modelotabla.addColumn("Tipo de Encuesta");
        modelotabla.addColumn("Total");
        this.vista.getTablaResultados().setModel(modelotabla);

    }

    public void CargarResultados() throws SQLException {
        modelotabla = resul.ListarResultados(vista.getTxtCedula().getText());
        vista.getTablaResultados().setModel(modelotabla);
        int[] anchos = {50, 200, 40};
        for (int i = 0; i < vista.getTablaResultados().getColumnCount(); i++) {
            vista.getTablaResultados().getColumnModel().getColumn(i).setPreferredWidth(anchos[i]);
        }

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(vista.getBtnBuscar())) {
            try {
                CargarResultados();
                this.vista.getBtngenerar().setEnabled(true);
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(vista, "Surgió un error", "Información", JOptionPane.ERROR_MESSAGE);
            }
        }
        if (e.getSource().equals(vista.getBtngenerar())) {
            SentenciasSelect sentencias = new SentenciasSelect();
            ConvertirExcel excel = new ConvertirExcel();
            if (vista.getTxtCedula().getText().isEmpty()) {
                JOptionPane.showMessageDialog(vista, "Ingrese una cedula", "Información", JOptionPane.ERROR_MESSAGE);
            } else {
                modelotabla = new DefaultTableModel();
                modelotabla = sentencias.ReporteFormularios(vista.getTxtCedula().getText());
                excel.exportar(vista, modelotabla, "REPORTE DE FORMULARIOS");
            }
        }
    }

}
