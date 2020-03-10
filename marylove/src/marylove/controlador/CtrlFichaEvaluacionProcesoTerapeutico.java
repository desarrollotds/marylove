/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package marylove.controlador;

import java.util.List;
import javax.swing.table.DefaultTableModel;
import marylove.DBmodelo.IngresoAvanceProceTerapeuticoDB;
import marylove.conexion.Conexion;
import marylove.models.IngresoAvanceProceTeraputico;
import marylove.vista.FichaEvolucionProcesoTerapeutico;
import marylove.vista.IngresoAvancesProcesoTerapeutico;

/**
 *
 * @author LENOVO
 */
public class CtrlFichaEvaluacionProcesoTerapeutico extends Validaciones{
    private IngresoAvanceProceTerapeuticoDB modelo;
    private FichaEvolucionProcesoTerapeutico vista;
    DefaultTableModel tabla;
    Conexion cx = new Conexion();

    public CtrlFichaEvaluacionProcesoTerapeutico(IngresoAvanceProceTerapeuticoDB modelo, FichaEvolucionProcesoTerapeutico vista) {
        this.modelo = modelo;
        this.vista = vista;
    }
    
    public void iniciarControlador (){
        vista.getTxtCodigo().setText(""+modelo.maxID());
        abrirVentana();
        cargarLista();
        vista.getBtnAgregar().addActionListener(e->abrirVentana2());
        vista.getTxtNombre().addKeyListener(enter2(vista.getTxtNombre(), vista.getTxtCodigo()));
    }
    public void abrirVentana (){
        vista.setVisible(true);
        vista.setLocationRelativeTo(null);
        
    }

    public void cargarLista() {
        tabla = (DefaultTableModel) vista.getTablaAvances().getModel();
        List<IngresoAvanceProceTeraputico> lista;
        int canFilas = vista.getTablaAvances().getRowCount();
        for (int i = canFilas -1; i >= 0; i--) {
            tabla.removeRow(i);
        }
        try {
            
        
        tabla= (DefaultTableModel) vista.getTablaAvances().getModel();  
        lista = modelo.obtenerRegisAct(Integer.parseInt(vista.getTxtCodigo().getText()));
        int columnas=tabla.getColumnCount();
        for (int a = 0; a < lista.size(); a++) {
            tabla.addRow(new Object[columnas]);
            vista.getTablaAvances().setValueAt(lista.get(a).getAvances_codigo(), a, 0);
            vista.getTablaAvances().setValueAt(lista.get(a).getAvances_intervencion(), a, 1);  
            vista.getTablaAvances().setValueAt(lista.get(a).getAvances_situacion(), a, 2);
            vista.getTablaAvances().setValueAt(lista.get(a).getAvancesFecha(), a, 3);
        }
        } catch (Exception e) {
            System.out.println("Error: " +e.getMessage());
        }
    }
    
    public void abrirVentana2(){
        IngresoAvanceProceTerapeuticoDB modelo2 = new IngresoAvanceProceTerapeuticoDB();
        IngresoAvancesProcesoTerapeutico vista2 = new IngresoAvancesProcesoTerapeutico();
        CtrlIngresoAvanceProceTerapeutico control = new CtrlIngresoAvanceProceTerapeutico(modelo2, vista2);
        control.iniciarControl();
    }
    


}
