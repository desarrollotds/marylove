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
        String[] datos;
        if (resul.isValidacion_resultados()) {
            datos = new String[3];
            for (Resultados elem : resul.getListaPersona()) {
                datos[0] = elem.getNombre() + "";
                datos[1] = elem.getTipo() + "";
                datos[2] = elem.getTotal() + "";
                modelotabla.addRow(datos);
            }
            int[] anchos = {50, 200, 40};
            vista.getTablaResultados().setModel(modelotabla);
            for (int i = 0; i < vista.getTablaResultados().getColumnCount(); i++) {
                vista.getTablaResultados().getColumnModel().getColumn(i).setPreferredWidth(anchos[i]);
            }         
            vista.getTablaResultados().setVisible(true);
        } else {
            vista.getTablaResultados().setVisible(false);
            JOptionPane.showMessageDialog(vista, "No existe resultados de la persona ingresada", "Información", JOptionPane.WARNING_MESSAGE);
        }

    }
    
    public void LimpiarTabla(){
        try {
            int filas = modelotabla.getRowCount();
        for(int i=0;i<=filas;i++){
            modelotabla.removeRow(i);
        }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(vista, "ERROR");
        }
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(vista.getBtnBuscar())) {
            try {              
                 resul.ListarResultados(vista);
                CargarResultados();
//                  LimpiarTabla();
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(vista, "Surgió un error", "Información", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

}
