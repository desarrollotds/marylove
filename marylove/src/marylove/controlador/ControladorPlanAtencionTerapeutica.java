/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//falta completar el controlador
package marylove.controlador;

import marylove.DBmodelo.SentenciasSelectReportesDB;
import java.awt.Cursor;
import static java.awt.Cursor.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Calendar;
import java.util.GregorianCalendar;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
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

    PlanAtencionTerapeutica pAT = new PlanAtencionTerapeutica();
    static int histID;

    public ControladorPlanAtencionTerapeutica(FichaPlanAtencionTerapeutica vista, PlanAtencionTerapeuticoDB modelo) throws Exception {
        this.vista = vista;
        this.modelo = modelo;
    }

    public void iniciarControlador() {
        obtenerFechaSistema();
        obtenerDatos();
        // validaciones 
        vista.getTxtCodigo().addKeyListener(validarNumeros(vista.getTxtCodigo()));
        vista.getTxtNombre().addKeyListener(validarTodo(vista.getTxtNombre()));
        vista.getTxtNombre().setToolTipText("Antes de buscar debe limpiar los campos");
        vista.getTxtNombre().addKeyListener(enter2(vista.getTxtNombre(), vista.getTxtCodigo()));
        vista.getTxtNombre().addKeyListener(comprobarDatos());

//        abrirVentana();
        vista.getBtnGuardar().addActionListener(e -> {
            vista.getBtnGuardar().setCursor(new Cursor(WAIT_CURSOR));
            agregarFicha();
            vista.getBtnGuardar().setCursor(new Cursor(DEFAULT_CURSOR));
        });
        vista.getBtnCancelar().addActionListener(e -> limpiar());
        vista.getBtngenerarreporte().addActionListener(e->GenerarReporte());
    }

    public void agregarFicha() {
        if (histID != 0) {
            if (vista.getTxtNombre().getText().equals("") && vista.getTxtCodigo().getText().equals("")) {
                JOptionPane.showMessageDialog(null, "datos necesarios no ingresados");
            } else {
                if (vista.getBtnGuardar().getText().equals("Editar")) {
                    if (modelo.actualizar(datos())) {
                        JOptionPane.showMessageDialog(null, "Datos editados");
                        limpiar();
                    } else {
                        JOptionPane.showMessageDialog(null, "Error al editadar");
                    }
                } else {
                    datos();
                    if (modelo.insertarArtEntregados()) {
                        JOptionPane.showMessageDialog(null, "Datos guardados");
                        limpiar();
                    } else {
                        JOptionPane.showMessageDialog(null, "Error al ingresar los datos");
                    }
                }
            }
        } else {
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

    public PlanAtencionTerapeutica datos() {
        try {
            modelo.setPlan_at_fecha(obtenerFecha(vista.getDcFecha()));
        } catch (Exception e) {
            System.out.println("ERROR ingreso FECHA " + e.getMessage());
        }
        controlArea(vista.getTxaEncuadre());
        modelo.setPlan_at_encuadre_terapeuta(vista.getTxaEncuadre().getText());
        controlArea(vista.getTxaObjetivos());
        modelo.setPlan_at_obj_atencion(vista.getTxaObjetivos().getText());
        controlArea(vista.getTxaDerechosConcuicados());
        modelo.setPlan_at_derechos_victima(vista.getTxaDerechosConcuicados().getText());
        controlArea(vista.getTxaEstrategias());
        modelo.setPlan_at_estrategias_rep(vista.getTxaEstrategias().getText());
        controlArea(vista.getTxaCompromisos());
        modelo.setPlan_at_compromisos_terep(vista.getTxaCompromisos().getText());
        modelo.setHist_id(histID);
        return modelo;
    }

    public void obtenerDatos() {
        if (modelo.planATID(histID) != 0) {
            pAT = modelo.planATDatos(histID);
            vista.getTxaEncuadre().setText(pAT.getPlan_at_encuadre_terapeuta());
            ingreDATE(vista.getDcFecha(), pAT.getPlan_at_fecha());
            vista.getTxaObjetivos().setText(pAT.getPlan_at_obj_atencion());
            vista.getTxaDerechosConcuicados().setText(pAT.getPlan_at_derechos_victima());
            vista.getTxaEstrategias().setText(pAT.getPlan_at_estrategias_rep());
            vista.getTxaCompromisos().setText(pAT.getPlan_at_compromisos_terep());
            vista.getBtnGuardar().setText("Editar");
        }
    }

    public void limpiar() {
        vista.getTxtCodigo().setText("");
        vista.getTxtNombre().setText("");
        vista.getTxaEncuadre().setText("");
        vista.getTxaObjetivos().setText("");
        vista.getTxaDerechosConcuicados().setText("");
        vista.getTxaEstrategias().setText("");
        vista.getTxaCompromisos().setText("");
        vista.getBtnGuardar().setText("Guardar");
    }

    public KeyListener comprobarDatos() { // al hacer un enter realizar una acción 
        KeyListener kn = new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
            }

            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    vista.getTxtNombre().setCursor(new Cursor(WAIT_CURSOR));
                    if (!vista.getTxtCodigo().getText().equals("")) {
                        HistorialClinicoDB hcDB = new HistorialClinicoDB();
                        int cod = Integer.parseInt(vista.getTxtCodigo().getText());
                        histID = hcDB.HistId(cod);
                        if (histID == 0) {
                            JOptionPane.showMessageDialog(null, "No se a ingresado el Historial Clinico");
                        } else {
                            obtenerDatos();
                        }
                    }
                    vista.getTxtNombre().setCursor(new Cursor(DEFAULT_CURSOR));
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {

            }
        };
        return kn;
    }
    
    public void GenerarReporte(){
        DefaultTableModel modelotabla = new DefaultTableModel();
        SentenciasSelectReportesDB sentencias = new SentenciasSelectReportesDB();
        ConvertirExcel excel = new ConvertirExcel();
         if (vista.getTxtNombre().getText().isEmpty()) {
                    JOptionPane.showMessageDialog(vista, "Ingrese una cedula", "Información", JOptionPane.ERROR_MESSAGE);
                } else {
                    modelotabla = new DefaultTableModel();
                    modelotabla = sentencias.PlanAtencion(vista.getTxtNombre().getText());
                    excel.exportar(vista, modelotabla, "REPORTE PLAN ATENCIÓN TEAPEUTICA");
                }
    }
}
