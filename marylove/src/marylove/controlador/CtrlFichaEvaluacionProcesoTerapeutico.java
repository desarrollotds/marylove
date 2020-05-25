/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package marylove.controlador;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import marylove.DBmodelo.IngresoAvanceProceTerapeuticoDB;

import marylove.models.ArticulosEntregados;
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
    DefaultTableModel tabla;

    public CtrlFichaEvaluacionProcesoTerapeutico(IngresoAvanceProceTerapeuticoDB modelo, FichaEvolucionProcesoTerapeutico vista) throws Exception {
        this.modelo = modelo;
        this.vista = vista;
    }

    public void iniciarControlador() {
        // validaciones 
        vista.getTxtCodigo().addKeyListener(validarNumeros(vista.getTxtCodigo()));
        vista.getTxtCedula().addKeyListener(validarCedula(vista.getTxtCedula()));
        vista.getTxtNombre().addKeyListener(validarLetras(vista.getTxtNombre()));
        
//        vista.getTxtCodigo().setText("" + modelo.maxID());
//        abrirVentana();
        vista.getBtnAgregar().addActionListener(e -> {
            try {
                System.out.println("entra a ventana 2");
                abrirVentana2();
            } catch (Exception ex) {
                 System.out.println("erroral abrir venta de ingreso: " + ex);
            }
        });
        vista.getTxtCedula().addKeyListener(enter1(vista.getTxtCedula(),vista.getTxtNombre(), vista.getTxtCodigo()));
        vista.getTxtCedula().addKeyListener(mostrarDatos());
    }

    public void abrirVentana() {
        vista.setVisible(true);
        vista.setLocationRelativeTo(null);

    }

    public void cargarLista(int cod) {
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
                vista.getLabelCantidad().setText("Cargados: " + lista.size() + " registros");
            }else{
                JOptionPane.showMessageDialog(null, "No se a ingresado el Historial Clinico");
            }

        } catch (Exception ex) {
            System.out.println("error: " + ex);
            Logger.getLogger(ControladorFichaIngreso.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
    }

//    public void cargarLista() {
//        tabla = (DefaultTableModel) vista.getTablaAvances().getModel();
//        List<IngresoAvanceProceTeraputico> lista;
//        int canFilas = vista.getTablaAvances().getRowCount();
//        for (int i = canFilas -1; i >= 0; i--) {
//            tabla.removeRow(i);
//        }
//        try {
//            
//        
//        tabla= (DefaultTableModel) vista.getTablaAvances().getModel();  
//        lista = modelo.obtenerRegisAct(Integer.parseInt(vista.getTxtCodigo().getText()));
//        int columnas=tabla.getColumnCount();
//        for (int a = 0; a < lista.size(); a++) {
//            tabla.addRow(new Object[columnas]);
//            vista.getTablaAvances().setValueAt(lista.get(a).getAvances_codigo(), a, 0);
//            vista.getTablaAvances().setValueAt(lista.get(a).getAvances_intervencion(), a, 1);  
//            vista.getTablaAvances().setValueAt(lista.get(a).getAvances_situacion(), a, 2);
//            vista.getTablaAvances().setValueAt(lista.get(a).getAvancesFecha(), a, 3);
//        }
//        } catch (Exception e) {
//            System.out.println("Error: " +e.getMessage());
//        }
//    }
    public void abrirVentana2() throws Exception {
        IngresoAvanceProceTerapeuticoDB modelo2 = new IngresoAvanceProceTerapeuticoDB();
        IngresoAvancesProcesoTerapeutico vista2 = new IngresoAvancesProcesoTerapeutico();
        CtrlIngresoAvanceProceTerapeutico control = new CtrlIngresoAvanceProceTerapeutico(modelo2, vista2);
        vista2.setVisible(true);
        control.iniciarControl();
    }
    public KeyListener mostrarDatos() { // al hacer un enter realizar una acción 
        KeyListener kn = new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
            }

            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    if (!vista.getTxtCodigo().getText().equals("")) {
                            cargarLista(Integer.parseInt(vista.getTxtCodigo().getText()));
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
