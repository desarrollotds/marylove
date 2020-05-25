/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package marylove.controlador;

import java.sql.SQLException;
import java.util.Calendar;
import java.util.GregorianCalendar;
import javax.swing.JOptionPane;
import marylove.DBmodelo.IngresoAvanceProceTerapeuticoDB;
import marylove.vista.IngresoAvancesProcesoTerapeutico;

/**
 *
 * @author LENOVO
 */
public class CtrlIngresoAvanceProceTerapeutico extends Validaciones {

    private IngresoAvanceProceTerapeuticoDB modelo;
    private IngresoAvancesProcesoTerapeutico vista;

    int plan = CtrlFichaEvaluacionProcesoTerapeutico.planID;

    public CtrlIngresoAvanceProceTerapeutico(IngresoAvanceProceTerapeuticoDB modelo, IngresoAvancesProcesoTerapeutico vista) throws Exception {
        this.modelo = modelo;
        this.vista = vista;
    }

    public void iniciarControl() {
        
        vista.getBtnGuardar().addActionListener(e -> ingresoAvance());
//        abrirVentana();
        obtenerFechaSistema();
    }

    public void ingresoAvance() {

        if (vista.getTxaIntervencion().getText().isEmpty()
                || vista.getTxaIntervencion().getText().equals("") || plan == 0) {
            JOptionPane.showMessageDialog(null, "Llene todos los campos.");
            System.out.println("Llene todos los campos");
        } else {
            try {
                modelo.setPlan_at_codigo(plan);
                modelo.setAvancesFecha(obtenerFecha(vista.getDcFecha()));
                modelo.setAvances_intervencion(vista.getTxaIntervencion().getText());
                modelo.setAvances_situacion(vista.getTxaSituacion().getText());
                modelo.insetarAvance();
                JOptionPane.showMessageDialog(null, "Datos insertados correctamente.");
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Datos no insertados " + ex.getMessage());
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
