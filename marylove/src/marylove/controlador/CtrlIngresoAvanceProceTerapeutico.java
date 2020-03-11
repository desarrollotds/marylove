/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package marylove.controlador;

import java.util.Calendar;
import java.util.GregorianCalendar;
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
    private HistorialClinicoDB modelHistCliDB;

    public CtrlIngresoAvanceProceTerapeutico(IngresoAvanceProceTerapeuticoDB modelo, IngresoAvancesProcesoTerapeutico vista) {
        this.modelo = modelo;
        this.vista = vista;
    }
  
    public void iniciarControl() {
        vista.getBtnGuardar().addActionListener(e-> ingresoAvance());
        abrirVentana();
        obtenerFechaSistema();
    }

    public void ingresoAvance() {
        modelo.setAvancesFecha(obtenerFecha(vista.getDcFecha()));
        modelo.setAvances_intervencion(vista.getTxaIntervencion().getText());
        modelo.setAvances_situacion(vista.getTxaSituacion().getText());
        if (vista.getTxaIntervencion().getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Llene todos los campos.");
        } else if (modelo.insetarAvance()) {
            JOptionPane.showMessageDialog(null, "Datos insertados correctamente.");
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
    //
     public void obtenerID() {
//metodo obtenerID inexistente!!!!! .... ^^

         
//         
//            modelHistCliDB.obtenerID(Integer.parseInt(vista.getTxtCodigo().getText()));
//        System.out.println("llega al obtner Id");
    }
}
