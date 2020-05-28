/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package marylove.controlador;

import java.awt.Cursor;
import static java.awt.Cursor.*;
import java.util.Calendar;
import java.util.GregorianCalendar;
import javax.swing.JOptionPane;
import marylove.DBmodelo.IngresoAvanceProceTerapeuticoDB;
import marylove.models.IngresoAvanceProceTeraputico;
import marylove.vista.FichaEvolucionProcesoTerapeutico;
import marylove.vista.IngresoAvancesProcesoTerapeutico;

/**
 *
 * @author LENOVO
 */
public class CtrlIngresoAvanceProceTerapeutico extends Validaciones {

    private IngresoAvanceProceTerapeuticoDB modelo2;
    private IngresoAvancesProcesoTerapeutico vista;
    private FichaEvolucionProcesoTerapeutico vEPT;

    IngresoAvanceProceTeraputico iaPT = new IngresoAvanceProceTeraputico();

    int plan = CtrlFichaEvaluacionProcesoTerapeutico.planID;
    public static boolean proc;

    public CtrlIngresoAvanceProceTerapeutico(IngresoAvanceProceTerapeuticoDB modelo2, IngresoAvancesProcesoTerapeutico vista, FichaEvolucionProcesoTerapeutico vEPT) throws Exception {
        this.modelo2 = modelo2;
        this.vista = vista;
        this.vEPT = vEPT;
    }

    public void iniciarControl() {
        obtenerFechaSistema();
        obtener();
        vista.getBtnGuardar().addActionListener(e -> {
            vista.getBtnGuardar().setCursor(new Cursor(WAIT_CURSOR));
            ingresoAvance();
            vista.getBtnGuardar().setCursor(new Cursor(DEFAULT_CURSOR));
        });
        vista.getBtnCancelar().addActionListener(e -> limpiar());
        vEPT.getBtnEanvance().addActionListener(e -> obtener());
        
        
    }

    public void ingresoAvance() {
        System.out.println("nombre " + vista.getBtnGuardar().getText());
        plan = CtrlFichaEvaluacionProcesoTerapeutico.planID;
        if (vista.getTxaIntervencion().getText().equals("") && vista.getTxaIntervencion().getText().equals("") && plan == 0) {
            JOptionPane.showMessageDialog(null, "Llene todos los campos");
        } else {
            if (vista.getBtnGuardar().getText().equals("Editar")) {
                if (modelo2.editar(datso())) {
                    JOptionPane.showMessageDialog(null, "Datos editados correctamente");
                    vista.setVisible(false);
                    limpiar();
                } else {
                    JOptionPane.showMessageDialog(null, "Datos no editados");
                }
            } else if (vista.getBtnGuardar().getText().equals("Guardar")) {
                datso();
                if (modelo2.insetarAvance()) {
                    JOptionPane.showMessageDialog(null, "Datos ingresados correctamente");
                    vista.setVisible(false);
                    limpiar();
                } else {
                    JOptionPane.showMessageDialog(null, "Datos no ingresados");
                }
            }
        }

    }

    public IngresoAvanceProceTeraputico datso() {
        modelo2.setPlan_at_codigo(plan);
        modelo2.setAvances_codigo(Integer.parseInt(vista.getTxtCodigoAvance().getText()));
        modelo2.setAvancesFecha(obtenerFecha(vista.getDcFecha()));
        modelo2.setAvances_intervencion(vista.getTxaIntervencion().getText());
        modelo2.setAvances_situacion(vista.getTxaSituacion().getText());
        return modelo2;
    }

    public void obtener() {
        int cod = Integer.parseInt(vista.getTxtCodigoAvance().getText());
        if (cod != modelo2.maxID()) {
            iaPT = modelo2.obtenerDatos(cod);
            ingreDATE(vista.getDcFecha(), iaPT.getAvancesFecha());
            vista.getTxaIntervencion().setText(iaPT.getAvances_intervencion());
            vista.getTxaSituacion().setText(iaPT.getAvances_situacion());
            vista.getBtnGuardar().setText("Editar");
            vista.setLocationRelativeTo(null);
            vista.setVisible(true);
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

    public void limpiar() {
        obtenerFechaSistema();
        vista.getTxaIntervencion().setText("");
        vista.getTxaSituacion().setText("");
        vista.getBtnGuardar().setText("Guardar");
        vista.getTxtCodigoAvance().setText(modelo2.maxID() + "");
    }
}
