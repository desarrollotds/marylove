package marylove.controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
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
import marylove.vista.vistaMontoDisp;
import marylove.vista.vistaMontoNeces;
import org.json.simple.parser.ParseException;

/**
 *
 * @author USUARIO
 */
public class ControladorPlandeRecursos extends Validaciones {

    personalDB perDB = new personalDB();
    DefaultTableModel modeloTabMDisp;
    DefaultTableModel modeloTabMNec;
    DefaultTableModel modeloCutD;
    private VistaPlanRecursos vista;

    private Monto_DisponeDB montDispModlDB;
    private Monto_NecesitaDB montNecesModelDB;
    private Cuentas_DiariasDB cuentDiariasModelDB;

    private Monto_Dispone montDMdel;
    private Monto_Necesita montNMdel;
    private Cuentas_Diarias cuentDMdel;

    private vistaCuentasDiarias vistCuentD;
    private vistaMontoDisp vistMdis;
    private vistaMontoNeces vistaMNes;

    Plan_deRecursosDB modelo = new Plan_deRecursosDB();

    public ControladorPlandeRecursos(VistaPlanRecursos vista, Monto_DisponeDB montDispModlDB, Monto_NecesitaDB montNecesModelDB, Cuentas_DiariasDB cuentDiariasModelDB, Monto_Dispone montDMdel, Monto_Necesita montNMdel, Cuentas_Diarias cuentDMdel, vistaCuentasDiarias vistCuentD, vistaMontoDisp vistMdis, vistaMontoNeces vistaMNes) throws ParseException {
        this.vista = vista;
        this.montDispModlDB = montDispModlDB;
        this.montNecesModelDB = montNecesModelDB;
        this.cuentDiariasModelDB = cuentDiariasModelDB;
        this.montDMdel = montDMdel;
        this.montNMdel = montNMdel;
        this.cuentDMdel = cuentDMdel;
        this.vistCuentD = vistCuentD;
        this.vistMdis = vistMdis;
        this.vistaMNes = vistaMNes;
    }

    

    public void iniciarControlRecursos() {

        popTableCuentD();
        popTableMontoDisp();
        popTableMNecs();
        ValidarMonto();

//        vista.getTxtMontoActual().addKeyListener(validarNumeros(vista.getTxtMontoActual()));
        vista.getTxtNombre().addKeyListener(validarLetras(vista.getTxtNombre()));
        vista.getTxtCodigovictima().addKeyListener(validarNumeros(vista.getTxtCodigovictima()));
        vista.getTxtCedula().addKeyListener(validarCedula(vista.getTxtCedula()));
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
        vista.getBtnActualizar_Montos().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (vista.getTxtCodigovictima().getText().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Debe Ingresar Cédula", "Error", JOptionPane.ERROR_MESSAGE);
                } else {
                    ActuMontos();
                }
            }
        });
        //componetes para Agregar Monto Dispone
        vista.getBtnAgregarMonto().addActionListener(e -> abrirVentMontoDisponible());
        vista.getBtnAgregarMontoNeces().addActionListener(e -> abrirVentMontoNecesita());
        vistMdis.getBtnGuardar().addActionListener(e -> datosmontoDispone());
        vistMdis.getBtnEditar().addActionListener(e -> EditarBtnMontoDisp());
        //componetes para Agregar Monto Necesita
        vista.getBtnAgregarMontoNeces().addActionListener(e -> abrirVentMontoNecesita());
        vistaMNes.getBtnGuardar().addActionListener(e -> datosmontoNecesita());
        vistaMNes.getBtnEditar().addActionListener(e -> EditarBtnMtNeces());
        //componetes para Agregar Cuentas Diarias
        vista.getBtnNuevoCuentasDiarias().addActionListener(e -> abrirVentCuentasDiarias());
        vistCuentD.getBtnGuardarCuentasDiarias().addActionListener(e -> datoscuentaDiarias());
        vistCuentD.getBtnEditar().addActionListener(e -> EditarBtnCuentDi());
    }

    public void abrirPlanRecursos() {
        vista.setVisible(true);
        vista.setLocationRelativeTo(null);
    }

    public void abrirVentMontoDisponible() {
        vistMdis.setVisible(true);
        vistMdis.setLocationRelativeTo(null);
        vistMdis.getBtnEditar().setEnabled(false);
        vistMdis.getBtnGuardar().setEnabled(true);
        vistMdis.setIconImage(new ImageIcon(getClass().getResource("/iconos/icono1.png")).getImage());
    }

    public void abrirVentMontoNecesita() {
        vistaMNes.setVisible(true);
        vistaMNes.setLocationRelativeTo(null);
        vistaMNes.getBtnEditar().setEnabled(false);
        vistaMNes.getBtnGuardar().setEnabled(true);
        vistaMNes.setIconImage(new ImageIcon(getClass().getResource("/iconos/icono1.png")).getImage());
    }

    public void abrirVentCuentasDiarias() {
        vistCuentD.setVisible(true);
        vistCuentD.setLocationRelativeTo(null);
        vistCuentD.getBtnEditar().setEnabled(false);
        vistCuentD.getBtnGuardarCuentasDiarias().setEnabled(true);
        vistCuentD.setIconImage(new ImageIcon(getClass().getResource("/iconos/icono1.png")).getImage());
    }
    public void ValidarMonto(){//metodo para validar los numeros con un punto. (123.43)
        //montodisp
        vistMdis.getTxtMdVivienda().addKeyListener(validarMontos(vistMdis.getTxtMdVivienda()));
        vistMdis.getTxtMdAlimen().addKeyListener(validarMontos(vistMdis.getTxtMdAlimen()));
        vistMdis.getTxtMdEduc().addKeyListener(validarMontos(vistMdis.getTxtMdEduc()));
        vistMdis.getTxtMdTransp().addKeyListener(validarMontos(vistMdis.getTxtMdTransp()));
        //montoNece
        vistaMNes.getTxtMnVivienda().addKeyListener(validarMontos(vistaMNes.getTxtMnVivienda()));
        vistaMNes.getTxtMnAlimentacion().addKeyListener(validarMontos(vistaMNes.getTxtMnAlimentacion()));
        vistaMNes.getTxtMnEducacion().addKeyListener(validarMontos(vistaMNes.getTxtMnEducacion()));
        vistaMNes.getTxtMnTransporte().addKeyListener(validarMontos(vistaMNes.getTxtMnTransporte()));
        //CuentaDia
        vistCuentD.getTxtgastoCuentaDia().addKeyListener(validarMontos(vistCuentD.getTxtgastoCuentaDia()));
        vistCuentD.getTxtsaldoCuentaDia().addKeyListener(validarMontos(vistCuentD.getTxtsaldoCuentaDia()));
        //planRecur
        vista.getTxtMontoActual().addKeyListener(validarMontos(vista.getTxtMontoActual()));
    }

    public void Actualizar() {
        cargaListaCuentasDiarias();
    }
    public void ActuMontos(){
        cargaListaMontoDisp();
        cargaListaMontoNeces();
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
        if (vistCuentD.getDatFechaCuentaDiaria().getDate() == null) {
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

                        if (cuentDiariasModelDB.Ingresar_CuentasDiarias()) {
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
            String cod = modeloTabla.getValueAt(vista.getTblCuentasDiarias().getSelectedRow(), 0).toString();
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

    public void datosmontoDispone() {
        System.out.println("entr");
        //MontoDisponible
        if (vistMdis.getTxtMdAlimen().getText().equals("")
                || vistMdis.getTxtMdVivienda().getText().equals("")
                || vistMdis.getTxtMdEduc().getText().equals("")
                || vistMdis.getTxtMdTransp().getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Llene todos los campos");
        } else {
            System.out.println("1");
            // datos Monto Dispone
            montDispModlDB.setPlan_recursos_int(modelo.maxId());
            montDispModlDB.setVivienda_monto(vistMdis.getTxtMdVivienda().getText());
            montDispModlDB.setAlimentacion_monto(vistMdis.getTxtMdAlimen().getText());
            montDispModlDB.setEducacion_monto(vistMdis.getTxtMdEduc().getText());
            montDispModlDB.setTransporte_monto(vistMdis.getTxtMdTransp().getText());

            if (montDispModlDB.Ingresar_MontoDispone()) {
                JOptionPane.showMessageDialog(null, "Datos Insertados Correctamente");
                cargaListaMontoDisp();
                vistMdis.setVisible(false);
            } else {
                JOptionPane.showMessageDialog(null, "Error al Ingresar Datos");
            }
        }
    }

    public void cargaListaMontoDisp() {
        int canFilas = vista.getTblMontoDisponible().getRowCount();
        for (int i = canFilas - 1; i >= 0; i--) {
            if (i != 0) {
                modeloTabMDisp.removeRow(i);
            }

        }
        modeloTabMDisp = (DefaultTableModel) vista.getTblMontoDisponible().getModel();
        List<Monto_Dispone> lista;
        try {
            lista = montDispModlDB.listaMontoDispone(Integer.parseInt(vista.getTxtCodigovictima().getText()));
            int columnas = modeloTabMDisp.getColumnCount();
            for (int i = 0; i < lista.size(); i++) {
                modeloTabMDisp.addRow(new Object[columnas]);
                vista.getTblMontoDisponible().setValueAt(lista.get(i).getMonto_dispone_codigo(), i, 0);
                vista.getTblMontoDisponible().setValueAt(lista.get(i).getVivienda_monto(), i, 1);
                vista.getTblMontoDisponible().setValueAt(lista.get(i).getAlimentacion_monto(), i, 2);
                vista.getTblMontoDisponible().setValueAt(lista.get(i).getEducacion_monto(), i, 3);
                vista.getTblMontoDisponible().setValueAt(lista.get(i).getTransporte_monto(), i, 4);
                //falta el total
            }
        } catch (Exception ex) {
            System.out.println("Error en plan de vida metodo cargaListaMontoDisp(): " + ex.getMessage());
        }
    }

    public void popTableMontoDisp() {
        JPopupMenu pM = new JPopupMenu();
        JMenuItem itemEdit = new JMenuItem("EDITAR");
        itemEdit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                EditarMontoDisp();
                abrirVentMontoDisponible();
                vistMdis.getBtnEditar().setEnabled(true);
                vistMdis.getBtnGuardar().setEnabled(false);
            }
        });
        pM.add(itemEdit);
        vista.getTblMontoDisponible().setComponentPopupMenu(pM);
    }

    public void EditarMontoDisp() {
        DefaultTableModel modeloTabla = (DefaultTableModel) vista.getTblMontoDisponible().getModel();
        int fsel = vista.getTblMontoDisponible().getSelectedRow();
        if (fsel == -1) {
            JOptionPane.showMessageDialog(null, "Seleccione una fila ó Actualize lista", "Verificación", JOptionPane.WARNING_MESSAGE);
        } else {
            String cod = modeloTabla.getValueAt(vista.getTblMontoDisponible().getSelectedRow(), 0).toString();
            String vivi = modeloTabla.getValueAt(vista.getTblMontoDisponible().getSelectedRow(), 1).toString();
            String alim = modeloTabla.getValueAt(vista.getTblMontoDisponible().getSelectedRow(), 2).toString();
            String edu = modeloTabla.getValueAt(vista.getTblMontoDisponible().getSelectedRow(), 3).toString();
            String transp = modeloTabla.getValueAt(vista.getTblMontoDisponible().getSelectedRow(), 4).toString();

            vistMdis.getLblCodigo().setText(cod);
            vistMdis.getTxtMdVivienda().setText(vivi);
            vistMdis.getTxtMdAlimen().setText(alim);
            vistMdis.getTxtMdEduc().setText(edu);
            vistMdis.getTxtMdTransp().setText(transp);
            vistMdis.setTitle("Editar Monto Disponible");
        }
    }

    public void EditarBtnMontoDisp() {
        montDispModlDB.setMonto_dispone_codigo(Integer.parseInt(vistMdis.getLblCodigo().getText()));
        montDispModlDB.setVivienda_monto(vistMdis.getTxtMdVivienda().getText());
        montDispModlDB.setAlimentacion_monto(vistMdis.getTxtMdAlimen().getText());
        montDispModlDB.setEducacion_monto(vistMdis.getTxtMdEduc().getText());
        montDispModlDB.setTransporte_monto(vistMdis.getTxtMdTransp().getText());
        if (montDispModlDB.actualizarMontoDisponible()) {
            JOptionPane.showMessageDialog(null, "Editado Monto Disponible correctamente");
            vistMdis.setVisible(false);
            cargaListaMontoDisp();

            vistMdis.getTxtMdVivienda().setText("");
            vistMdis.getTxtMdAlimen().setText("");
            vistMdis.getTxtMdEduc().setText("");
            vistMdis.getTxtMdTransp().setText("");

        } else {
            JOptionPane.showMessageDialog(null, "Error al actualizar Datos.");

        }
    }
    public void datosmontoNecesita() {
        System.out.println("entr");
        //MontoNecesita
        if (vistaMNes.getTxtMnAlimentacion().getText().equals("")
                || vistaMNes.getTxtMnVivienda().getText().equals("")
                || vistaMNes.getTxtMnEducacion().getText().equals("")
                || vistaMNes.getTxtMnTransporte().getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Llene todos los campos");
        } else {
            System.out.println("1");
            //datos Monto Necesita
            montNecesModelDB.setPlan_recursos_int(modelo.maxId());
            montNecesModelDB.setVivienda_monto(vistaMNes.getTxtMnVivienda().getText());
            montNecesModelDB.setAlimentacion_monto(vistaMNes.getTxtMnAlimentacion().getText());
            montNecesModelDB.setEducacion_monto(vistaMNes.getTxtMnEducacion().getText());
            montNecesModelDB.setTransporte_monto(vistaMNes.getTxtMnTransporte().getText());

            if (montNecesModelDB.Ingresar_MontoNecesita()) {
                JOptionPane.showMessageDialog(null, "Datos Insertados Correctamente");
                cargaListaMontoNeces();
                vistaMNes.setVisible(false);
            } else {
                JOptionPane.showMessageDialog(null, "Error al Ingresar Datos");
            }
        }
    }

    public void cargaListaMontoNeces() {
        int canFilas = vista.getTblMontoNecesita().getRowCount();
        for (int i = canFilas - 1; i >= 0; i--) {
            if (i != 0) {
                modeloTabMNec.removeRow(i);
            }

        }
        modeloTabMNec = (DefaultTableModel) vista.getTblMontoNecesita().getModel();
        List<Monto_Necesita> lista;
        try {
            lista = montNecesModelDB.listaMontoNecesita(Integer.parseInt(vista.getTxtCodigovictima().getText()));
            int columnas = modeloTabMNec.getColumnCount();
            for (int i = 0; i < lista.size(); i++) {
                modeloTabMNec.addRow(new Object[columnas]);
                vista.getTblMontoNecesita().setValueAt(lista.get(i).getMonto_nesecita_codigo(), i, 0);
                vista.getTblMontoNecesita().setValueAt(lista.get(i).getVivienda_monto(), i, 1);
                vista.getTblMontoNecesita().setValueAt(lista.get(i).getAlimentacion_monto(), i, 2);
                vista.getTblMontoNecesita().setValueAt(lista.get(i).getEducacion_monto(), i, 3);
                vista.getTblMontoNecesita().setValueAt(lista.get(i).getTransporte_monto(), i, 4);
            }
        } catch (Exception ex) {
            System.out.println("Error en plan de vida metodo cargaListaMontoNeces(): " + ex.getMessage());
        }
    }

    public void popTableMNecs() {
        JPopupMenu pM = new JPopupMenu();
        JMenuItem itemEdit = new JMenuItem("EDITAR");
        itemEdit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                EditarMNeces();
                abrirVentMontoNecesita();
                vistaMNes.getBtnEditar().setEnabled(true);
                vistaMNes.getBtnGuardar().setEnabled(false);
            }
        });
        pM.add(itemEdit);
        vista.getTblMontoNecesita().setComponentPopupMenu(pM);
    }

    public void EditarMNeces() {
        DefaultTableModel modeloTabla = (DefaultTableModel) vista.getTblMontoNecesita().getModel();
        int fsel = vista.getTblMontoNecesita().getSelectedRow();
        if (fsel == -1) {
            JOptionPane.showMessageDialog(null, "Seleccione una fila ó Actualize lista", "Verificación", JOptionPane.WARNING_MESSAGE);
        } else {
            String cod = modeloTabla.getValueAt(vista.getTblMontoNecesita().getSelectedRow(), 0).toString();
            String vivienda = modeloTabla.getValueAt(vista.getTblMontoNecesita().getSelectedRow(), 1).toString();
            String alimentacion = modeloTabla.getValueAt(vista.getTblMontoNecesita().getSelectedRow(), 2).toString();
            String eduacion = modeloTabla.getValueAt(vista.getTblMontoNecesita().getSelectedRow(), 3).toString();
            String transporte = modeloTabla.getValueAt(vista.getTblMontoNecesita().getSelectedRow(), 4).toString();

            vistaMNes.getLblCodigo().setText(cod);
            vistaMNes.getTxtMnVivienda().setText(vivienda);
            vistaMNes.getTxtMnAlimentacion().setText(alimentacion);
            vistaMNes.getTxtMnEducacion().setText(eduacion);
            vistaMNes.getTxtMnTransporte().setText(transporte);
            vistaMNes.setTitle("Editar Monto  Necesita");
        }
    }

    public void EditarBtnMtNeces() {
        montNecesModelDB.setMonto_nesecita_codigo(Integer.parseInt(vistaMNes.getLblCodigo().getText()));
        montNecesModelDB.setVivienda_monto(vistaMNes.getTxtMnVivienda().getText());
        montNecesModelDB.setAlimentacion_monto(vistaMNes.getTxtMnAlimentacion().getText());
        montNecesModelDB.setEducacion_monto(vistaMNes.getTxtMnEducacion().getText());
        montNecesModelDB.setTransporte_monto(vistaMNes.getTxtMnTransporte().getText());
        if (montNecesModelDB.actualizarMontoDisponible()) {
            JOptionPane.showMessageDialog(null, "Editado Monto Necesita correctamente");
            vistaMNes.setVisible(false);
            cargaListaMontoNeces();

            vistaMNes.getTxtMnVivienda().setText("");
            vistaMNes.getTxtMnAlimentacion().setText("");
            vistaMNes.getTxtMnEducacion().setText("");
            vistaMNes.getTxtMnTransporte().setText("");

        } else {
            JOptionPane.showMessageDialog(null, "Error al actualizar Datos.");

        }
    }
}
