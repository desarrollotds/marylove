/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package marylove.controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import marylove.DBmodelo.AgresorDB;
import marylove.DBmodelo.HijosDB;
import marylove.DBmodelo.victimaDB;
import marylove.models.Hijos;
import marylove.models.Victima;
import marylove.vista.FichaAnamnesis;
import marylove.vista.VistaFiltroVistaVictima;

/**
 *
 * @author AlexanderGuzman
 */
public class FiltroHijosVictima implements ActionListener, MouseListener {

    VistaFiltroVistaVictima vfv;
    DefaultTableModel tablaVictima;
    DefaultTableModel tablaHijos;
    FichaAnamnesis anam;

    public FiltroHijosVictima(VistaFiltroVistaVictima vfv) {
        this.vfv = vfv;
        this.vfv.getTablavictima().addMouseListener(this);
        this.vfv.getTablahijos().addMouseListener(this);
        this.vfv.getBtnbuscar().addActionListener(this);
        inicializador();
    }

    public void insertarTablaVictima() {
        limpiarTabla2();
        victimaDB vdb = new victimaDB();
        vdb.datosVictima(vfv.getTxtnombre().getText().toString(), vfv.getTxtcedula().getText().toString());
        String[] datos;

        for (Victima e : vdb.getArrayvictima()) {
            datos = new String[5];
            datos[0] = e.getVictima_codigo() + "";
            datos[1] = e.getPersona_cedula() + "";
            datos[2] = e.getPersona_nombre() + " " + e.getPersona_apellido();

            this.tablaVictima.addRow(datos);
        }
        vdb.getArrayvictima().clear();
        vfv.getTablavictima().setModel(this.tablaVictima);
    }

    public void agregarTablaHijos(int num) {
        limpiarTabla();
        System.out.println("numero" + num);
        HijosDB vdb = new HijosDB();
        vdb.BusquedaHijos(num);
        String[] datos;

        for (Hijos e : vdb.getBuscaHijos()) {
            datos = new String[5];
            datos[0] = e.getHijo_codigo() + "";
            datos[1] = e.getPersona_cedula() + "";
            datos[2] = e.getPersona_nombre() + " " + e.getPersona_apellido();

            this.tablaHijos.addRow(datos);
        }

        vfv.getTablahijos().setModel(this.tablaHijos);
        vdb.getBuscaHijos().clear();
    }

    public void limpiarTabla2() {
        try {
            tablaVictima.setRowCount(0);
        } catch (Exception e) {
            e.getStackTrace();
        }
    }

    public void limpiarTabla() {
        try {
            tablaHijos.setRowCount(0);
        } catch (Exception e) {
            e.getStackTrace();
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(vfv.getBtnbuscar())) {
            limpiarTabla2();
            insertarTablaVictima();

        }
    }

    public void inicializador() {
        tablaHijos = new DefaultTableModel();
        tablaHijos.addColumn("Codigo");
        tablaHijos.addColumn("Cedula");
        tablaHijos.addColumn("Nombre y Apellido");

        this.vfv.getTablahijos().setModel(tablaHijos);
        tablaVictima = new DefaultTableModel();
        tablaVictima.addColumn("Codigo");
        tablaVictima.addColumn("Cedula");
        tablaVictima.addColumn("Nombre y Apellido");

        this.vfv.getTablavictima().setModel(tablaVictima);
        limpiarTabla2();
        insertarTablaVictima();
    }

    void TablaVictima() {

    }

    void TablaHijos() {

    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if (vfv.getTablavictima().getSelectedRow() >= 0) {
            int fila = vfv.getTablavictima().getSelectedRow();
            String[] datosL
                    = {
                        String.valueOf(vfv.getTablavictima().getValueAt(fila, 0))
                    };
            System.out.println(datosL[0]);
            agregarTablaHijos(Integer.parseInt(datosL[0]));
        } else if (vfv.getTablahijos().getSelectedRow() >= 0) {
            int fila = vfv.getTablahijos().getSelectedRow();
            String[] datosL
                    = {
                        String.valueOf(vfv.getTablahijos().getValueAt(fila, 0))
                    };
            anam.txtCodigo.setText(datosL[0]);
        }
    }

    @Override
    public void mousePressed(MouseEvent e
    ) {
    }

    @Override
    public void mouseReleased(MouseEvent e
    ) {
    }

    @Override
    public void mouseEntered(MouseEvent e
    ) {
    }

    @Override
    public void mouseExited(MouseEvent e
    ) {
    }
}
