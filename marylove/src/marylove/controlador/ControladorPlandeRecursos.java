package marylove.controlador;

import java.sql.SQLException;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import marylove.DBmodelo.Cuentas_DiariasDB;
import marylove.DBmodelo.Monto_DisponeDB;
import marylove.DBmodelo.Monto_NecesitaDB;
import marylove.DBmodelo.Plan_deRecursosDB;
import marylove.DBmodelo.personalDB;
import static marylove.controlador.C_Login.personal_cod;
import marylove.models.Monto_Dispone;
import marylove.vista.VistaPlanRecursos;

/**
 *
 * @author USUARIO
 */
public class ControladorPlandeRecursos extends Validaciones {
    
   
    personalDB perDB = new personalDB();
    DefaultTableModel modeloTabRecursosyGastos;
    private Monto_DisponeDB montDispDB;
    private Monto_NecesitaDB montNecesDB;
    private Cuentas_DiariasDB cuentDiariasDB;
    private final VistaPlanRecursos vista;
    private final Plan_deRecursosDB modelo;

    public ControladorPlandeRecursos(Monto_DisponeDB montDispDB, Monto_NecesitaDB montNecesDB, Cuentas_DiariasDB cuentDiariasDB, VistaPlanRecursos vista, Plan_deRecursosDB modelo) throws Exception{
        this.montDispDB = montDispDB;
        this.montNecesDB = montNecesDB;
        this.cuentDiariasDB = cuentDiariasDB;
        this.vista = vista;
        this.modelo = modelo;
    }
    public void iniciarControlRecursos(){
        vista.getBtnAgregarMonto().setEnabled(false);
        vista.setLocationRelativeTo(null);
        vista.getTxtMontoActual().addKeyListener(validarNumeros(vista.getTxtMontoActual()));
        vista.getTxtNombre().addKeyListener(validarLetras(vista.getTxtNombre()));
        vista.getTxtCodigovictima().addKeyListener(validarNumeros(vista.getTxtCodigovictima()));
        vista.getTxtCedula().addKeyListener(validarCedula(vista.getTxtCedula()));
        vista.getTxtmonto().addKeyListener(validarNumeros(vista.getTxtmonto()));
        vista.getBtnGuardarPlanRecursos().addActionListener(e -> insertarDatosRecursos());
        vista.getTxtCedula().addKeyListener(enter1(vista.getTxtCedula(), vista.getTxtNombre(), vista.getTxtCodigovictima()));
        vista.getBtnAgregarMonto().addActionListener(e -> muestraDialogo(0));
        vista.getBtnGuardarGastosyRecursos().addActionListener(e -> cargaLista());
        
                
        Calendar c2 = new GregorianCalendar();
        vista.getDatFechaPlanRecursos().setCalendar(c2);
    }
    public void muestraDialogo(int b) {
        if (b == 0) {//Agregar Monto
            vista.getDlgPlanRecursoMontos().setLocationRelativeTo(null);
             vista.getDlgPlanRecursoMontos().setTitle("Ingresar Monto que Necesita y Dispone");
            vista.getDlgPlanRecursoMontos().setVisible(true);
        }
    }
    public void insertarDatosRecursos(){
        //Insertado de la tabla de plan de recursos
        if (vista.getTxtMontoActual().getText().equals("")
                || vista.getTxaResolverNecesidades().getText().equals("")
                || vista.getDatFechaPlanRecursos().getCalendar().equals("")) {
            JOptionPane.showMessageDialog(null, "Llene todos los campos");
        } else {
            modelo.setCodigo_victima(Integer.parseInt(vista.getTxtCodigovictima().getText()));
            modelo.setMonto_actual(vista.getTxtMontoActual().getText());
            modelo.setFecha_elaboracion(obtenerFecha(vista.getDatFechaPlanRecursos()));
            modelo.setAlter_resol_nesi(vista.getTxaResolverNecesidades().getText()); 
            modelo.setPersonal_codigo(modelo.verifiUserP(personal_cod));
            if (modelo.Ingresar_PlanRecursos()) {
                    JOptionPane.showMessageDialog(null, "Datos Insertado Correctamente");       
                } else {
                    JOptionPane.showMessageDialog(null, "Error al Ingresar Datos");
                }
            ;
        }
    }
    
    public void borrarDatos(){
        
    }
    // cargar la tabla de monto que necesita y dispone pero no funciona
     private void cargaLista() {
        int canFilas = vista.getTblGastosyRecursos().getRowCount();
        for (int i = canFilas - 1; i >= 0; i--) {
            modeloTabRecursosyGastos.removeRow(i);
            System.out.println(i);
        }
        modeloTabRecursosyGastos = (DefaultTableModel) vista.getTblGastosyRecursos().getModel();
        List<Monto_Dispone> lista;
        try {
            lista = montDispDB.listaMontoDispone(Integer.parseInt(vista.getTxtCodigovictima().getText()));
            int columnas = modeloTabRecursosyGastos.getColumnCount();
            for (int i = 0; i < lista.size(); i++) {
                modeloTabRecursosyGastos.addRow(new Object[columnas]);
                vista.getTblGastosyRecursos().setValueAt(lista.get(i).getVivienda_monto(), i, 0);
                vista.getTblGastosyRecursos().setValueAt(lista.get(i).getAlimentacion_monto(), i, 1);
                vista.getTblGastosyRecursos().setValueAt(lista.get(i).getEducacion_monto(), i, 2);
                vista.getTblGastosyRecursos().setValueAt(lista.get(i).getTransporte_monto(), i, 3);
            }
            System.out.println("registros cargardos "+ lista.size());
            //vista.getLbltexto().setText("Cargados: " + lista.size() + " registros");
        } catch (SQLException ex) {
            Logger.getLogger(ControladorPlandeRecursos.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}
