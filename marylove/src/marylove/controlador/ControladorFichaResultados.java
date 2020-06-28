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

    public ControladorFichaResultados(VistaResultados vista) {
        this.vista = vista;
        this.vista.setVisible(true);
        this.vista.getBtnBuscar().addActionListener(this);
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
        ResultadosDB resul = new ResultadosDB();
        resul.ListarResultados(vista);
        String[] datos;
        for (Resultados elem : resul.getListaPersona()) {
                datos = new String[3];
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

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(vista.getBtnBuscar())) {
            try {
                CargarResultados();
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(vista, "Surgió un error", "Información", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

}
