/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package marylove.controlador;

import java.awt.Cursor;
import static java.awt.Cursor.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import marylove.DBmodelo.HistorialClinicoDB;
import marylove.DBmodelo.IngresoAvanceProceTerapeuticoDB;
import marylove.DBmodelo.PlanAtencionTerapeuticoDB;
import marylove.models.IngresoAvanceProceTeraputico;
import marylove.vista.FichaEvolucionProcesoTerapeutico;
import marylove.vista.IngresoAvancesProcesoTerapeutico;

/**
 *
 * @author LENOVO
 */
public class CtrlFichaEvaluacionProcesoTerapeutico extends Validaciones {

    private IngresoAvanceProceTerapeuticoDB modelo;
    private FichaEvolucionProcesoTerapeutico vista;
    private IngresoAvancesProcesoTerapeutico vista2;
    DefaultTableModel tabla;

    public static int planID;
    int histID;

    int start = 0;
    PlanAtencionTerapeuticoDB plan = new PlanAtencionTerapeuticoDB();
    IngresoAvanceProceTeraputico iaPT = new IngresoAvanceProceTeraputico();

    public CtrlFichaEvaluacionProcesoTerapeutico(IngresoAvanceProceTerapeuticoDB modelo, FichaEvolucionProcesoTerapeutico vista, IngresoAvancesProcesoTerapeutico vista2) throws Exception {
        this.modelo = modelo;
        this.vista = vista;
        this.vista2 = vista2;
    }

    public void iniciarControlador() {
        // validaciones 
        vista.getTxtCodigo().addKeyListener(validarNumeros(vista.getTxtCodigo()));
        vista.getTxtCedula().addKeyListener(validarTodo(vista.getTxtCedula()));
        vista.getTxtNombre().addKeyListener(validarLetras(vista.getTxtNombre()));

        vista.getBtnAgregar().addActionListener(e -> abrirVentana2(1));
        vista.getBtnEanvance().addActionListener(e -> {
            if (seleccion() != 0) {
                abrirVentana2(2);
            }
        });
        vista.getBtnElim().addActionListener(e -> {
            if (seleccion() != 0) {
                eliminarAT();
            }
        });
        vista.getTxtCedula().addKeyListener(enter1(vista.getTxtCedula(), vista.getTxtNombre(), vista.getTxtCodigo()));
        vista.getTxtCedula().addKeyListener(mostrarDatos());
        vista.getTxtNombre().addKeyListener(enter1(vista.getTxtCedula(), vista.getTxtNombre(), vista.getTxtCodigo()));
        vista.getTxtNombre().addKeyListener(mostrarDatos());

        vista2.getBtnGuardar().addActionListener(e -> {
            vista2.getBtnGuardar().setCursor(new Cursor(WAIT_CURSOR));
            ingresoAvance();
            vista2.getBtnGuardar().setCursor(new Cursor(DEFAULT_CURSOR));
        });
        vista2.getBtnCancelar().addActionListener(e -> limpiar());
        vista.getBtnlimpiar().addActionListener(e -> limpiar2());
    }

    public void abrirVentana() {
        vista.setVisible(true);
        vista.setLocationRelativeTo(null);

    }

    public void cargarLista(int cod) {
        int canFilas = vista.getTablaAvances().getRowCount();
        for (int a = canFilas - 1; a >= 0; a--) {
            tabla.removeRow(a);
        }
        tabla = (DefaultTableModel) vista.getTablaAvances().getModel();
        List< IngresoAvanceProceTeraputico> lista;
        try {
            lista = modelo.listar(cod);
            if (lista != null) {
                int columnas = tabla.getColumnCount();
                for (int i = 0; i < lista.size(); i++) {
                    tabla.addRow(new Object[columnas]);
                    vista.getTablaAvances().setValueAt(lista.get(i).getAvances_codigo(), i, 0);
                    vista.getTablaAvances().setValueAt(lista.get(i).getAvances_situacion(), i, 1);
                    vista.getTablaAvances().setValueAt(lista.get(i).getAvances_intervencion(), i, 2);
                    vista.getTablaAvances().setValueAt(lista.get(i).getAvancesFecha(), i, 3);
                }
            }
        } catch (Exception ex) {
            System.out.println("error: " + ex);
            Logger.getLogger(ControladorFichaIngreso.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void abrirVentana2(int opc) {
        if (!vista.getTxtCodigo().getText().equals("") && histID != 0) {
            planID = plan.planATID(histID);
            if (opc == 1) {
                limpiar();
                vista2.setLocationRelativeTo(null);
                vista2.setVisible(true);
            } else {
                vista2.getTxtCodigoAvance().setText(seleccion() + "");
                obtener();
            }
        } else {
            JOptionPane.showMessageDialog(null, "Deben ingresar datos en las fichas anteriores");
        }
    }

    public int seleccion() {
        int avance = 0;
        vista.getBtnEanvance().setCursor(new Cursor(WAIT_CURSOR));
        DefaultTableModel moTablaRA = (DefaultTableModel) vista.getTablaAvances().getModel();
        int fsel = vista.getTablaAvances().getSelectedRow();
        if (fsel == -1) {
            JOptionPane.showMessageDialog(null, "Seleccione una fila lista", "Verificación", JOptionPane.WARNING_MESSAGE);
        } else {
            avance = Integer.parseInt(moTablaRA.getValueAt(vista.getTablaAvances().getSelectedRow(), 0).toString());
        }
        vista.getBtnEanvance().setCursor(new Cursor(DEFAULT_CURSOR));
        return avance;
    }

    public void ingresoAvance() {
        if (vista2.getTxaIntervencion().getText().equals("") && vista2.getTxaIntervencion().getText().equals("") && planID == 0) {
            JOptionPane.showMessageDialog(null, "Llene todos los campos");
        } else {
            if (vista2.getBtnGuardar().getText().equals("Editar")) {
                if (modelo.editar(datso())) {
                    cargarLista(Integer.parseInt(vista.getTxtCodigo().getText()));
                    JOptionPane.showMessageDialog(null, "Datos editados correctamente");
                    vista2.setVisible(false);
                    limpiar();
                } else {
                    JOptionPane.showMessageDialog(null, "Datos no editados");
                }
            } else if (vista2.getBtnGuardar().getText().equals("Guardar")) {
                datso();
                if (modelo.insetarAvance()) {
                    cargarLista(Integer.parseInt(vista.getTxtCodigo().getText()));
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
        modelo.setPlan_at_codigo(planID);
        modelo.setAvances_codigo(Integer.parseInt(vista2.getTxtCodigoAvance().getText()));
        modelo.setAvancesFecha(obtenerFecha(vista2.getDcFecha()));
        modelo.setAvances_intervencion(vista2.getTxaIntervencion().getText());
        modelo.setAvances_situacion(vista2.getTxaSituacion().getText());
        return modelo;
    }

    public void obtener() {
        int cod = Integer.parseInt(vista2.getTxtCodigoAvance().getText());
        if (cod != modelo.maxID()) {
            iaPT = modelo.obtenerDatos(cod);
            ingreDATE(vista2.getDcFecha(), iaPT.getAvancesFecha());
            vista2.getTxaIntervencion().setText(iaPT.getAvances_intervencion());
            vista2.getTxaSituacion().setText(iaPT.getAvances_situacion());
            vista2.getBtnGuardar().setText("Editar");
            vista2.setLocationRelativeTo(null);
            vista2.setVisible(true);
        }
    }

    public void obtenerFechaSistema() {
        Calendar c2 = new GregorianCalendar();
        vista2.getDcFecha().setCalendar(c2);
    }

    public void limpiar() {
        obtenerFechaSistema();
        vista2.getTxaIntervencion().setText("");
        vista2.getTxaSituacion().setText("");
        vista2.getBtnGuardar().setText("Guardar");
        vista2.getTxtCodigoAvance().setText(modelo.maxID() + "");
    }

    public void limpiar2() {
        vista.getTxtCedula().setText("");
        vista.getTxtCodigo().setText("");
        vista.getTxtNombre().setText("");
        int canFilas = vista.getTablaAvances().getRowCount();
        for (int a = canFilas - 1; a >= 0; a--) {
            tabla.removeRow(a);
        }
    }

    public void eliminarAT() {
        if (consulta("Esta seguro de eliminar", "Atencion Terapeutica", "Eliminar")) {
            if (modelo.Elimnar(seleccion())) {
                cargarLista(Integer.parseInt(vista.getTxtCodigo().getText()));
                JOptionPane.showMessageDialog(null, "Datos eliminados");
            } else {
                JOptionPane.showMessageDialog(null, "Error al eliminar");
            }
        }
    }

    public KeyListener mostrarDatos() { // al hacer un enter realizar una acción 
        KeyListener kn = new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
            }

            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    vista.getTxtCedula().setCursor(new Cursor(WAIT_CURSOR));
                    vista.getTxtNombre().setCursor(new Cursor(WAIT_CURSOR));
                    HistorialClinicoDB hcDB = new HistorialClinicoDB();
                    if (!vista.getTxtCodigo().getText().equals("")) {
                        int cod = Integer.parseInt(vista.getTxtCodigo().getText());
                        histID = hcDB.HistId(cod);
                        if (histID == 0) {
                            JOptionPane.showMessageDialog(null, "No se a ingresado el Historial Clinico");
                        } else {
                            planID = plan.planATID(histID);
                            if (planID == 0) {
                                JOptionPane.showMessageDialog(null, "No se a ingresado el Plan de atencion terapeutica");
                            } else {
                                cargarLista(cod);
                            }
                        }
                    }
                    vista.getTxtNombre().setCursor(new Cursor(WAIT_CURSOR));
                    vista.getTxtCedula().setCursor(new Cursor(DEFAULT_CURSOR));
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {

            }
        };
        return kn;
    }
    
    
}
