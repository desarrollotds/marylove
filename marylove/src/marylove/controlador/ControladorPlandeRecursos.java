package marylove.controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPopupMenu;
import javax.swing.table.DefaultTableModel;
import marylove.DBmodelo.Cuentas_DiariasDB;
import marylove.DBmodelo.Monto_DisponeDB;
import marylove.DBmodelo.Monto_NecesitaDB;
import marylove.DBmodelo.Plan_deRecursosDB;
import marylove.DBmodelo.personalDB;
import static marylove.controlador.C_Login.personal_cod;
import marylove.models.Cuentas_Diarias;
import marylove.models.Monto_Dispone;
import marylove.models.Monto_Necesita;
import marylove.vista.VistaPlanRecursos;
import marylove.vista.vistaCuentasDiarias;
import marylove.vista.vistaGastosPrioritarios;
import org.json.simple.parser.ParseException;

/**
 *
 * @author USUARIO
 */
public class ControladorPlandeRecursos extends Validaciones {

    personalDB perDB = new personalDB();
    DefaultTableModel modeloTabGastP;
    DefaultTableModel modeloCutD;
    private VistaPlanRecursos vista;

    private Monto_DisponeDB montDispModlDB;
    private Monto_NecesitaDB montNecesModelDB;
    private Cuentas_DiariasDB cuentDiariasModelDB;

    private Monto_Dispone montDMdel;
    private Monto_Necesita montNMdel;
    private Cuentas_Diarias cuentDMdel;

    private vistaCuentasDiarias vistCuentD;
    private vistaGastosPrioritarios vistGastPrio;

    Plan_deRecursosDB modelo = new Plan_deRecursosDB();

    public ControladorPlandeRecursos(VistaPlanRecursos vista, Monto_DisponeDB montDispModlDB, Monto_NecesitaDB montNecesModelDB, Cuentas_DiariasDB cuentDiariasModelDB, Monto_Dispone montDMdel, Monto_Necesita montNMdel, Cuentas_Diarias cuentDMdel, vistaCuentasDiarias vistCuentD, vistaGastosPrioritarios vistGastPrio) throws ParseException {
        this.vista = vista;
        this.montDispModlDB = montDispModlDB;
        this.montNecesModelDB = montNecesModelDB;
        this.cuentDiariasModelDB = cuentDiariasModelDB;
        this.montDMdel = montDMdel;
        this.montNMdel = montNMdel;
        this.cuentDMdel = cuentDMdel;
        this.vistCuentD = vistCuentD;
        this.vistGastPrio = vistGastPrio;
    }

    public void iniciarControlRecursos() {

        popTableCuentD();

        vista.getTxtMontoActual().addKeyListener(validarNumeros(vista.getTxtMontoActual()));
        vista.getTxtNombre().addKeyListener(validarLetras(vista.getTxtNombre()));
        vista.getTxtCodigovictima().addKeyListener(validarNumeros(vista.getTxtCodigovictima()));
        vista.getTxtCedula().addKeyListener(validarCedula(vista.getTxtCedula()));
        vista.getTxtmonto().addKeyListener(validarNumeros(vista.getTxtmonto()));
        vista.getBtnGuardarPlanRecursos().addActionListener(e -> insertarDatosRecursos());
        vista.getTxtCedula().addKeyListener(enter1(vista.getTxtCedula(), vista.getTxtNombre(), vista.getTxtCodigovictima()));

        Calendar c2 = new GregorianCalendar();
        vista.getDatFechaPlanRecursos().setCalendar(c2);
        vistCuentD.getDatFechaCuentaDiaria().setCalendar(c2);

        vista.getBtnActualizar().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (vista.getTxtCodigovictima().getText().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Debe Ingresar Cédula", "Error", JOptionPane.ERROR_MESSAGE);
                } else {
                    Actualizar();
                }
            }
        });
        vista.getBtnAgregarMonto().addActionListener(e -> abrirVentGastosPrioritarios());
        vistGastPrio.getBtnGuardarGastosyRecursos().addActionListener(e -> datosmontoDisponible());

        vista.getBtnNuevoCuentasDiarias().addActionListener(e -> abrirVentCuentasDiarias());
        vistCuentD.getBtnGuardarCuentasDiarias().addActionListener(e -> datoscuentaDiarias());
        vistCuentD.getBtnEditar().addActionListener(e -> EditarBtnCuentDi());
        //vistGastPrio.getBtnEditar().addActionListener(e -> EditarBtnObjGen());
        //vistGastPrio.getBtnGuardarGastosyRecursos().addActionListener(e -> datosmontoNecesita());
    }

    public void abrirPlanRecursos() {
        vista.setVisible(true);
        vista.setLocationRelativeTo(null);
    }

    public void abrirVentGastosPrioritarios() {
        vistGastPrio.setVisible(true);
        vistGastPrio.setLocationRelativeTo(null);
        //vistGastPrio.getBtnEditar().setEnabled(false);
        vistGastPrio.getBtnGuardarGastosyRecursos().setEnabled(true);
    }

    public void abrirVentCuentasDiarias() {
        vistCuentD.setVisible(true);
        vistCuentD.setLocationRelativeTo(null);
        vistCuentD.getBtnGuardarCuentasDiarias().setEnabled(true);
    }

    public void Actualizar() {
        cargaListaCuentasDiarias();
    }

    public void insertarDatosRecursos() {
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
        }
    }

   public void datoscuentaDiarias() {
        System.out.println("entr");
        //Cuentas Diarias
        if (vistCuentD.getDatFechaCuentaDiaria().getDate()== null) {
            JOptionPane.showMessageDialog(null, "Campos Vacios", "Ingrese Valores", JOptionPane.WARNING_MESSAGE);
        } else {
            if (vistCuentD.getTxtgastoCuentaDia().getText().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Campos Vacios", "Ingrese Valores", JOptionPane.WARNING_MESSAGE);
            } else {
                if (vistCuentD.getTxtsaldoCuentaDia().getText().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Campos Vacios", "Ingrese Valores", JOptionPane.WARNING_MESSAGE);
                } else {
                    if (vistCuentD.getTxtaDescrip().getText().isEmpty()) {
                        JOptionPane.showMessageDialog(null, "Campos Vacios", "Ingrese Valores", JOptionPane.WARNING_MESSAGE);
                    } else {
                        System.out.println("1");
                        cuentDiariasModelDB.setPlan_recusos_codigo(modelo.maxId());
                        cuentDiariasModelDB.setFecha_cuenta(obtenerFecha(vistCuentD.getDatFechaCuentaDiaria()));
                        cuentDiariasModelDB.setGasto(vistCuentD.getTxtgastoCuentaDia().getText());
                        cuentDiariasModelDB.setSaldo(vistCuentD.getTxtsaldoCuentaDia().getText());
                        cuentDiariasModelDB.setDescripcion(vistCuentD.getTxtaDescrip().getText());

                        if (cuentDiariasModelDB.Ingresar_CuentasDiarias) {
                            System.out.println("2");
                            JOptionPane.showMessageDialog(null, "Datos Insertados Correctamente");
                            cargaListaCuentasDiarias();
                            vistCuentD.setVisible(false);
                        } else {
                            JOptionPane.showMessageDialog(null, "Error al Ingresar Datos");
                        }
                    }
                }
            }
        }
    }
    public void cargaListaCuentasDiarias() {
        System.out.println("entra2");
        int canFilas = vista.getTblCuentasDiarias().getRowCount();
        for (int i = canFilas - 1; i >= 0; i--) {
            if (i != 0) {
                modeloCutD.removeRow(i);              
            }
            System.out.println(i);       
        }
        modeloCutD = (DefaultTableModel) vista.getTblCuentasDiarias().getModel();
        List<Cuentas_Diarias> lista;
        try {
            System.out.println("entr2.2");
            lista = cuentDiariasModelDB.listacuentasDiarias(Integer.parseInt(vista.getTxtCodigovictima().getText()));
            int columnas = modeloCutD.getColumnCount();
            for (int i = 0; i < lista.size(); i++) {
                System.out.println(lista.size());
                modeloCutD.addRow(new Object[columnas]);
                vista.getTblCuentasDiarias().setValueAt(lista.get(i).getCuentas_diarias_codigo(), i, 0);
                vista.getTblCuentasDiarias().setValueAt(lista.get(i).getFecha_cuenta(), i, 1);
                vista.getTblCuentasDiarias().setValueAt(lista.get(i).getGasto(), i, 2);
                //fila del codigo responsable 
                vista.getTblCuentasDiarias().setValueAt(lista.get(i).getDescripcion(), i, 3);
                vista.getTblCuentasDiarias().setValueAt(lista.get(i).getSaldo(), i, 4);
            }
        } catch (Exception ex) {
            System.out.println("Error en controlplan de recursos metodo cargaListaCuentasDiarias(): " + ex.getMessage());
        }
    }
    public void popTableCuentD() {
        JPopupMenu pM = new JPopupMenu();
        JMenuItem itemEdit = new JMenuItem("EDITAR");
        itemEdit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                EditarCuentaDiaria();
                abrirVentCuentasDiarias();
                vistCuentD.getBtnEditar().setEnabled(true);
                vistCuentD.getDatFechaCuentaDiaria().setEnabled(false);
                vistCuentD.getBtnGuardarCuentasDiarias().setEnabled(false);
            }
        });
        pM.add(itemEdit);
        vista.getTblCuentasDiarias().setComponentPopupMenu(pM);
    }
    public void EditarCuentaDiaria() {
        DefaultTableModel modeloTabla = (DefaultTableModel) vista.getTblCuentasDiarias().getModel();
        int fsel = vista.getTblCuentasDiarias().getSelectedRow();
        if (fsel == -1) {
            JOptionPane.showMessageDialog(null, "Seleccione una fila ó Actualize lista", "Verificación", JOptionPane.WARNING_MESSAGE);
        } else {
            String cod= modeloTabla.getValueAt(vista.getTblCuentasDiarias().getSelectedRow(), 0).toString();
            //Date fecha = modeloTabla.getValueAt(vista.getTblCuentasDiarias().getSelectedRow(), 1).toString();
            String gastos = modeloTabla.getValueAt(vista.getTblCuentasDiarias().getSelectedRow(), 2).toString();
            String descrip = modeloTabla.getValueAt(vista.getTblCuentasDiarias().getSelectedRow(), 3).toString();
            String saldo = modeloTabla.getValueAt(vista.getTblCuentasDiarias().getSelectedRow(), 4).toString();
            
            vistCuentD.getLblCodigo().setText(cod);
            //vistCuentD.getDatFechaCuentaDiaria().setCalendar(fecha);
            vistCuentD.getTxtgastoCuentaDia().setText(gastos);
            vistCuentD.getTxtaDescrip().setText(descrip);
            vistCuentD.getTxtsaldoCuentaDia().setText(saldo);
            vistCuentD.setTitle("Editar Cuenta Diaria");
        }
    }
     public void EditarBtnCuentDi() {
         System.out.println("editarsi");
         cuentDiariasModelDB.setCuentas_diarias_codigo(Integer.parseInt(vistCuentD.getLblCodigo().getText()));
        //cuentDiariasModelDB.setFecha_cuenta(fecha_cuenta);
        cuentDiariasModelDB.setGasto(vistCuentD.getTxtgastoCuentaDia().getText());
        cuentDiariasModelDB.setDescripcion(vistCuentD.getTxtaDescrip().getText());
        cuentDiariasModelDB.setSaldo(vistCuentD.getTxtsaldoCuentaDia().getText());
        if (cuentDiariasModelDB.actualizarCuentasDiarias()) {
            JOptionPane.showMessageDialog(null, "Editado correctamente");
            vistCuentD.setVisible(false);
            cargaListaCuentasDiarias();

            vistCuentD.getTxtaDescrip().setText("");
            vistCuentD.getTxtgastoCuentaDia().setText("");
            vistCuentD.getTxtsaldoCuentaDia().setText("");
        } else {
            JOptionPane.showMessageDialog(null, "Error al actualizar Datos Editarbtn");
        }
    }

    public void datosmontoDisponible() {
        System.out.println("entr");
        //MontoDisponible
        if (vistGastPrio.getTxtMdAlimen().getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Campos Vacios", "Ingrese Valores", JOptionPane.WARNING_MESSAGE);
        } else {
            if (vistGastPrio.getTxtMdVivienda().getText().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Campos Vacios", "Ingrese Valores", JOptionPane.WARNING_MESSAGE);
            } else {
                if (vistGastPrio.getTxtMdEduc().getText().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Campos Vacios", "Ingrese Valores", JOptionPane.WARNING_MESSAGE);
                } else {
                    if (vistGastPrio.getTxtMdTransp().getText().isEmpty()) {
                        JOptionPane.showMessageDialog(null, "Campos Vacios", "Ingrese Valores", JOptionPane.WARNING_MESSAGE);
                    } else {
                        System.out.println("1");
                        montDispModlDB.setPlan_recursos_int(modelo.maxId());
                        montDispModlDB.setVivienda_monto(vistGastPrio.getTxtMdVivienda().getText());
                        montDispModlDB.setAlimentacion_monto(vistGastPrio.getTxtMdAlimen().getText());
                        montDispModlDB.setEducacion_monto(vistGastPrio.getTxtMdEduc().getText());
                        montDispModlDB.setTransporte_monto(vistGastPrio.getTxtMdTransp().getText());

                        if (montDispModlDB.Ingresar_MontoDispone()) {
                            JOptionPane.showMessageDialog(null, "Datos Insertados Correctamente");
                            cargaListaMontoDisp();
                            vistGastPrio.setVisible(false);
                        } else {
                            JOptionPane.showMessageDialog(null, "Error al Ingresar Datos");
                        }
                    }
                }
            }
        }
    }
    public void cargaListaMontoDisp() {
        int canFilas = vista.getTblGastosyRecursos().getRowCount();
        for (int i = canFilas - 1; i >= 0; i--) {
            if (i != 0) {
                modeloTabGastP.removeRow(i);
                
            }
        }
        modeloTabGastP = (DefaultTableModel) vista.getTblGastosyRecursos().getModel();
        List<Monto_Dispone> lista;

        try {
            lista = montDispModlDB.listaMontoDispone(Integer.parseInt(vista.getTxtCodigovictima().getText()));
            int columnas = modeloTabGastP.getColumnCount();
            for (int i = 0; i < lista.size(); i++) {
                modeloTabGastP.addRow(new Object[columnas]);
                vista.getTblGastosyRecursos().setValueAt(lista.get(i).getVivienda_monto(), i, 1);
                vista.getTblGastosyRecursos().setValueAt(lista.get(i).getAlimentacion_monto(), i, 1);
                //fila del codigo responsable 
                vista.getTblGastosyRecursos().setValueAt(lista.get(i).getEducacion_monto(), i, 1);
                vista.getTblGastosyRecursos().setValueAt(lista.get(i).getTransporte_monto(), i, 1);

            }

        } catch (Exception ex) {
            System.out.println("Error en plan de recursos metodo cargaListaMontoDisp(): " + ex.getMessage());
        }
    }
//    public void datosmontoNecesita() {
//        System.out.println("entr");
//        //MontoDisponible
//        if (vistGastPrio.getTxtMnAlimentacion().getText().isEmpty()) {
//            JOptionPane.showMessageDialog(null, "Campos Vacios", "Ingrese Valores", JOptionPane.WARNING_MESSAGE);
//        } else {
//            if (vistGastPrio.getTxtMnVivienda().getText().isEmpty()) {
//                JOptionPane.showMessageDialog(null, "Campos Vacios", "Ingrese Valores", JOptionPane.WARNING_MESSAGE);
//            } else {
//                if (vistGastPrio.getTxtMnEducacion().getText().isEmpty()) {
//                    JOptionPane.showMessageDialog(null, "Campos Vacios", "Ingrese Valores", JOptionPane.WARNING_MESSAGE);
//                } else {
//                    if (vistGastPrio.getTxtMnTransporte().getText().isEmpty()) {
//                        JOptionPane.showMessageDialog(null, "Campos Vacios", "Ingrese Valores", JOptionPane.WARNING_MESSAGE);
//                    } else {
//                        System.out.println("1");
//                        montNecesModelDB.setPlan_recursos_int(modelo.maxId());
//                        montNecesModelDB.setVivienda_monto(vistGastPrio.getTxtMdVivienda().getText());
//                        montNecesModelDB.setAlimentacion_monto(vistGastPrio.getTxtMdAlimen().getText());
//                        montNecesModelDB.setEducacion_monto(vistGastPrio.getTxtMdEduc().getText());
//                        montNecesModelDB.setTransporte_monto(vistGastPrio.getTxtMdTransp().getText());
//
//                        if (montNecesModelDB.Ingresar_MontoNecesita()) {
//                            JOptionPane.showMessageDialog(null, "Datos Insertados Correctamente");
//                            cargaListaMontoNecesi();
//                            vistGastPrio.setVisible(false);
//                        } else {
//                            JOptionPane.showMessageDialog(null, "Error al Ingresar Datos");
//                        }
//                    }
//                }
//            }
//        }
//    }
//    public void cargaListaMontoNecesi() {
//        int canFilas = vista.getTblGastosyRecursos().getRowCount();
//        for (int i = canFilas - 1; i >= 0; i--) {
//            if (i != 0) {
//                modeloTabGastP.removeRow(i);
//            }
//
//        }
//
//        modeloTabGastP = (DefaultTableModel) vista.getTblGastosyRecursos().getModel();
//        List<Monto_Necesita> lista;
//
//        try {
//            lista = montNecesModelDB.listaMontoNecesita(Integer.parseInt(vista.getTxtCodigovictima().getText()));
//            int columnas = modeloTabGastP.getColumnCount();
//            for (int i = 0; i < lista.size(); i++) {
//                modeloTabGastP.addRow(new Object[columnas]);
//                vista.getTblGastosyRecursos().setValueAt(lista.get(i).getVivienda_monto(), i, 1);
//                vista.getTblGastosyRecursos().setValueAt(lista.get(i).getAlimentacion_monto(), i, 1);
//                //fila del codigo responsable 
//                vista.getTblGastosyRecursos().setValueAt(lista.get(i).getEducacion_monto(), i, 1);
//                vista.getTblGastosyRecursos().setValueAt(lista.get(i).getTransporte_monto(), i, 1);
//
//            }
//
//        } catch (Exception ex) {
//            System.out.println("Error en plan de recursos metodo cargaListaMontoNecesi(): " + ex.getMessage());
//        }
//    }
}
