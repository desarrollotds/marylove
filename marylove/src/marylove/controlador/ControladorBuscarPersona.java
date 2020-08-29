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
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;
import marylove.DBmodelo.personaDB;
import marylove.models.Persona;
import marylove.vista.Ficharegistroyreferencia;
import marylove.vista.VistaConsultaPersona;

/**
 *
 * @author AlexanderGuzman
 */
public class ControladorBuscarPersona implements MouseListener {

    VistaConsultaPersona vcp;
    DefaultTableModel personTabla;
    Ficharegistroyreferencia fryr;
    personaDB pdb;

    public ControladorBuscarPersona(VistaConsultaPersona vcp) {
        this.vcp = vcp;
//        this.vcp.setVisible(true);
        this.vcp.getTablaBuscarPersona().addMouseListener(this);
        inicializador();
        this.vcp.getBtnBuscar().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                limpiarTabla();

                busqueda();
            }
        });
        this.vcp.getBtnMostT().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    limpiarTabla();
                    personaDB person = new personaDB();
                    pdb.getListaPersona().clear();
                    person.buscarPersonaTotal();
                    insertarTabla();
                } catch (SQLException ex) {
                    Logger.getLogger(ControladorBuscarPersona.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
        this.vcp.getBtnCancelar().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                vcp.dispose();
            }
        });

    }

    public void limpiarTabla() {
        try {
            personaDB person = new personaDB();
            int fila = personTabla.getRowCount();
            for (int i = 0; i < fila; i++) {
                personTabla.removeRow(0);
            }
            int cantfila = vcp.getTablaBuscarPersona().getRowCount();
            for (int i = cantfila - 1; i >= 0; i--) {
                personTabla.removeRow(i);
            }
        } catch (Exception e) {
            System.out.println("Sin Datos ");
        }

    }

    public void busqueda() {

        try {
            personaDB person = new personaDB();
            pdb.getListaPersona().clear();
            System.out.println(vcp.getTxtNombre().getText() + vcp.getTxtApellido().getText());
            person.buscarPorParametroPersona(vcp.getTxtNombre().getText(), vcp.getTxtApellido().getText());

            insertarTabla();

        } catch (SQLException ex) {
            Logger.getLogger(ControladorBuscarPersona.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void insertarTabla() {

        personaDB person = new personaDB();

        String[] datos;
        for (Persona elem : pdb.getListaPersona()) {
            datos = new String[5];
            datos[0] = elem.getPersona_codigo() + "";
            datos[1] = elem.getPersona_cedula() + "";
            datos[2] = elem.getPersona_nombre() + "";
            datos[3] = elem.getPersona_apellido() + "";
            personTabla.addRow(datos);
        }
        vcp.getTablaBuscarPersona().setModel(personTabla);

    }

    public void inicializador() {

        personTabla = new DefaultTableModel();
        personTabla.addColumn("Codigo");
        personTabla.addColumn("Cedula");
        personTabla.addColumn("Nombre");
        personTabla.addColumn("Apellido");
        this.vcp.getTablaBuscarPersona().setModel(personTabla);

    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if (vcp.getTablaBuscarPersona().getSelectedRow() >= 0) {
            int fila = vcp.getTablaBuscarPersona().getSelectedRow();
            String[] datosL
                    = {
                        String.valueOf(vcp.getTablaBuscarPersona().getValueAt(fila, 0)),
                        String.valueOf(vcp.getTablaBuscarPersona().getValueAt(fila, 1)),
                        String.valueOf(vcp.getTablaBuscarPersona().getValueAt(fila, 2)),
                        String.valueOf(vcp.getTablaBuscarPersona().getValueAt(fila, 3))
                    };
            fryr.getTxtCedulaGeneral().setText(datosL[1]);
            fryr.txtCodigoPersona.setText(datosL[0]);
            
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }

}
