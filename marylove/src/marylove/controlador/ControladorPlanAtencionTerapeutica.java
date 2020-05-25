/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//falta completar el controlador
package marylove.controlador;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import marylove.DBmodelo.HistorialClinicoDB;
import marylove.DBmodelo.PlanAtencionTerapeuticoDB;
import marylove.models.PlanAtencionTerapeutica;
import marylove.vista.FichaPlanAtencionTerapeutica;

/**
 *
 * @author LENOVO
 */
public class ControladorPlanAtencionTerapeutica extends Validaciones {

    private final FichaPlanAtencionTerapeutica vista;
    private final PlanAtencionTerapeuticoDB modelo;

    static int histID;

    public ControladorPlanAtencionTerapeutica(FichaPlanAtencionTerapeutica vista, PlanAtencionTerapeuticoDB modelo) throws Exception {
        this.vista = vista;
        this.modelo = modelo;
    }

    public void iniciarControlador() {
        obtenerFechaSistema();
        // validaciones 
        vista.getTxtCodigo().addKeyListener(validarNumeros(vista.getTxtCodigo()));
        vista.getTxtNombre().addKeyListener(validarCedula(vista.getTxtNombre()));

        vista.getTxtNombre().addKeyListener(enter2(vista.getTxtNombre(), vista.getTxtCodigo()));
        vista.getTxtNombre().addKeyListener(comprobarDatos());

//        abrirVentana();
        vista.getBtnGuardar().addActionListener(e -> agregarFicha());

    }

    //agregar la fecha
    public void agregarFicha() {
        if (histID != 0) {
            if (vista.getTxtNombre().getText().equals("") && vista.getTxtCodigo().getText().equals("")) {
                JOptionPane.showMessageDialog(null, "datos necesarios no ingresados");
            } else {
                modelo.setPlan_at_fecha(obtenerFecha(vista.getDcFecha()));
                modelo.setPlan_at_encuadre_terapeuta(vista.getTxaEncuadre().getText());
                modelo.setPlan_at_obj_atencion(vista.getTxaObjetivos().getText());
                modelo.setPlan_at_derechos_victima(vista.getTxaDerechosConcuicados().getText());
                modelo.setPlan_at_estrategias_rep(vista.getTxaEstrategias().getText());
                modelo.setPlan_at_compromisos_terep(vista.getTxaCompromisos().getText());
                modelo.setHist_id(histID);
                if (modelo.insertarArtEntregados()) {
                    JOptionPane.showMessageDialog(null, "datos guardados");
                } else {
                    JOptionPane.showMessageDialog(null, "error");
                }
            }
        }else{
            JOptionPane.showMessageDialog(null, "No se a ingresado el Historial Clinico");
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

    public KeyListener comprobarDatos() { // al hacer un enter realizar una acción 
        KeyListener kn = new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
            }

            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    if (!vista.getTxtCodigo().getText().equals("")) {
                        HistorialClinicoDB hcDB = new HistorialClinicoDB();
                        int cod = Integer.parseInt(vista.getTxtCodigo().getText());
                        histID = hcDB.HistId(cod);
                        if (histID == 0) {
                            JOptionPane.showMessageDialog(null, "No se a ingresado el Historial Clinico");
                        }
                    }
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {

            }
        };
        return kn;
    }

}
