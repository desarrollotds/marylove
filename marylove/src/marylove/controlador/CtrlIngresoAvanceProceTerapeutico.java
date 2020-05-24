/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package marylove.controlador;

import java.sql.SQLException;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import marylove.DBmodelo.HistorialClinicoDB;
import marylove.DBmodelo.IngresoAvanceProceTerapeuticoDB;
import marylove.vista.IngresoAvancesProcesoTerapeutico;

/**
 *
 * @author LENOVO
 */
public class CtrlIngresoAvanceProceTerapeutico extends Validaciones {

    private IngresoAvanceProceTerapeuticoDB modelo;
    private IngresoAvancesProcesoTerapeutico vista;

    public CtrlIngresoAvanceProceTerapeutico(IngresoAvanceProceTerapeuticoDB modelo, IngresoAvancesProcesoTerapeutico vista)throws Exception {
        this.modelo = modelo;
        this.vista = vista;
    }

    public void iniciarControl() {
        vista.getBtnGuardar().addActionListener(e -> {
            try {
                ingresoAvance();
            } catch (SQLException ex) {
                Logger.getLogger(CtrlIngresoAvanceProceTerapeutico.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
//        abrirVentana();
        obtenerFechaSistema();
    }

    public void ingresoAvance() throws SQLException {
        if (vista.getTxaIntervencion().getText().isEmpty() ) {
            System.out.println("Llene todos los campos");
        } else {
            modelo.setAvancesFecha(obtenerFecha(vista.getDcFecha()));
            modelo.setAvances_intervencion(vista.getTxaIntervencion().getText());
            modelo.setAvances_situacion(vista.getTxaSituacion().getText());
            if (vista.getTxaIntervencion().getText().equals("")) {
                JOptionPane.showMessageDialog(null, "Llene todos los campos.");
            } else if (modelo.insetarAvance()) {
                JOptionPane.showMessageDialog(null, "Datos insertados correctamente.");
            }
        }

    }

    public void abrirVentana() {
        vista.setVisible(true);
        vista.setLocationRelativeTo(null);
    }

    public void obtenerFechaSistema() {
        Calendar c2 = new GregorianCalendar();
        vista.getDcFecha().setCalendar(c2);
    }

}
