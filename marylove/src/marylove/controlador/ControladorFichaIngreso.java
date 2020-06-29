package marylove.controlador;

import com.toedter.calendar.JDateChooser;
import java.awt.Cursor;
import static java.awt.Cursor.DEFAULT_CURSOR;
import static java.awt.Cursor.WAIT_CURSOR;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPopupMenu;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import marylove.DBmodelo.ArticulosEntregadosDB;
import marylove.DBmodelo.ArticulosEntregadosPersonalDB;
import marylove.DBmodelo.FamiliarsDB;
import marylove.DBmodelo.HijosDB;
import marylove.DBmodelo.IngresoDB;
import marylove.DBmodelo.jsonDB;
import marylove.DBmodelo.victimaDB;
import static marylove.controlador.C_Login.personal_cod;
import marylove.models.ArticulosEntregados;
import marylove.models.ArticulosEntregadosPersonal;
import marylove.models.Familiars;
import marylove.models.Hijos;
import marylove.models.Ingreso;
import marylove.models.Json_object_consulta;
import marylove.vista.FichaIngreso;
import marylove.vista.FormaAgregarArticulosPersonal;
import marylove.vista.FormaAgregarArticulosVictima;
import marylove.vista.FormaAgregarHijos;
import marylove.vista.V_Login;
import marylove.vista.VistaFamiliares;
import org.json.simple.parser.ParseException;

public class ControladorFichaIngreso extends Validaciones {

    private final FormaAgregarArticulosVictima vistaAgreArtBenef;
    private final ArticulosEntregados artiEntModel;
    private final ArticulosEntregadosDB artEntModelDB;
    private final ArticulosEntregadosPersonal artEntPerModel;
    private final ArticulosEntregadosPersonalDB artEntPerModelDB;
    private final FichaIngreso vistaFichIngreso;
    private final FormaAgregarArticulosPersonal vistaAgreArt;
    private final IngresoDB modelIngreDB;
    private final FormaAgregarHijos vistFormHij;
    private final VistaFamiliares vistaFamily;
    public static int codVic;
    public static int ban = 1;

    HijosDB hijoModelDB = new HijosDB();
    V_Login vistaLogin = new V_Login();
    FamiliarsDB famModelDb = new FamiliarsDB();
    jsonDB jo = new jsonDB();
    ArrayList<Json_object_consulta> jocarray;

    DefaultComboBoxModel modelComb;
    DefaultTableModel modeloTab;
    DefaultTableModel modeloTabPers;
    DefaultTableModel modeloTabHijos;

    public ControladorFichaIngreso(FormaAgregarArticulosVictima vistaAgreArtBenef, ArticulosEntregados artiEntModel, ArticulosEntregadosDB artEntModelDB, ArticulosEntregadosPersonal artEntPerModel, ArticulosEntregadosPersonalDB artEntPerModelDB, FichaIngreso vistaFichIngreso, FormaAgregarArticulosPersonal vistaAgreArt, IngresoDB modelIngreDB, FormaAgregarHijos vistFormHij, VistaFamiliares vistaFamily) throws ParseException {
        this.vistaAgreArtBenef = vistaAgreArtBenef;
        this.artiEntModel = artiEntModel;
        this.artEntModelDB = artEntModelDB;
        this.artEntPerModel = artEntPerModel;
        this.artEntPerModelDB = artEntPerModelDB;
        this.vistaFichIngreso = vistaFichIngreso;
        this.vistaAgreArt = vistaAgreArt;
        this.modelIngreDB = modelIngreDB;
        this.vistFormHij = vistFormHij;
        this.vistaFamily = vistaFamily;
    }

    public void inciarCtrlFichIngreso() throws ParseException {
        ban = 1;
        vistaFichIngreso.getTxtCedula().addKeyListener(enter1(vistaFichIngreso.getTxtCedula(), vistaFichIngreso.getTxtNombresApellidos(), vistaFichIngreso.getTxtCodigo()));
        vistaFichIngreso.getTxtNombresApellidos().addKeyListener(enter1(vistaFichIngreso.getTxtCedula(), vistaFichIngreso.getTxtNombresApellidos(), vistaFichIngreso.getTxtCodigo()));
        vistaFichIngreso.getTxtCedula().addKeyListener(DetectEnt(vistaFichIngreso.getTxtCedula()));
        vistaFichIngreso.getTxtCedula().addKeyListener(enterllenar());
        vistaFichIngreso.getTxtNombresApellidos().addKeyListener(enterllenar());
        botonesInavilitado();
        controlTxtArea();
        fechaSistemaIni();
        cargarRegstros();
        inicializaPopTables();
        llenarcomboParentescoFam();
        inicIcon();
        vistaAgreArtBenef.getBtnCancelar().addActionListener(e -> cancelarBenef());
        vistaAgreArtBenef.getBtnEditar().addActionListener(e -> EditarBtnArtBenfDg());
        vistaAgreArt.getBtnCancelar().addActionListener(e -> cancelarPers());
        vistaAgreArt.getBtnEditarPers().addActionListener(e -> EditarArtEntBtn());
        vistaFichIngreso.getBtnRefAll().addActionListener(e -> cargarRegstros());
        vistaFichIngreso.getBtnDlgActualizar().addActionListener(e -> listarArtEntEditCargarDlg());
        vistaFichIngreso.getBtnRefreshArtEntBenef().addActionListener(e -> listarArtEntBenefEditCargarDlg());
        vistaFichIngreso.getBtnRefreshDorRef().addActionListener(e -> listarDormiRefEditCargar());
        vistaFichIngreso.getBtnBuscar().addActionListener(e -> realizarBusquedas());
        vistaFichIngreso.getBtnAgregarArticulosVictima().addActionListener(e -> AbrirVentBenef());
        vistaFichIngreso.getBtnNuevo().addActionListener(e -> NuevoRegCleanAll());
        vistaFichIngreso.getBtnAgregarArticulosFundacion().addActionListener(e -> AbrirVentArtPers());
        vistaFichIngreso.getBtnVerRegistros().addActionListener(e -> AbrirVerRegistros());
        vistaFichIngreso.getBtnEdit().addActionListener(e -> BtnEdiDorRef());
        vistaFichIngreso.getBtnCancelarEdit().addActionListener(e -> CancelarDlg(vistaFichIngreso.getDlgEditar()));
        vistaFichIngreso.getBtnRefresHijos2().addActionListener(e -> listFamAcompHijDlg());
        vistaFichIngreso.getBtnRefresHijos1().addActionListener(e -> listFamAcompDlg());
        vistaFamily.getBtnCancelar().addActionListener(e -> cancelFamily());
        vistaFichIngreso.getBtnActHijAco().addActionListener(e -> {
            if (!vistaFichIngreso.getTxtCodigo().getText().equals("")) {
                listFamAcomp();
            } else {
                JOptionPane.showMessageDialog(null, "Debe Ingresar Cédula", "Error", JOptionPane.ERROR_MESSAGE);
            }
        });
        vistaAgreArtBenef.getBtnGuardar().addActionListener(e -> {
            try {
                InsertarArticulosPers();
            } catch (SQLException ex) {
                Logger.getLogger(ControladorFichaIngreso.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
        vistaAgreArt.getBtnGuardar().addActionListener(e -> {
            try {
                InsertarArticulos();
            } catch (SQLException ex) {
                Logger.getLogger(ControladorFichaIngreso.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
        vistaFichIngreso.getBtnGuardar().addActionListener(e -> {
            try {
                guardarDormRefer();
            } catch (SQLException ex) {
                Logger.getLogger(ControladorFichaIngreso.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
        vistaFichIngreso.getBtnActualizar().addActionListener((ActionEvent e) -> {
            if (vistaFichIngreso.getTxtCodigo().getText().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Debe Ingresar Cédula", "Error", JOptionPane.ERROR_MESSAGE);
            } else {
                actualizar();
            }
        });
//        vistaFichIngreso.getBtnAgreAcomp().addActionListener(((e) -> {
//            if (vistaFichIngreso.getTxtCodigo().getText().isEmpty()) {
//                JOptionPane.showMessageDialog(null, "Debe Ingresar Cédula y presione Enter", "Error", JOptionPane.ERROR_MESSAGE);
//                vistaFamily.setVisible(false);
//            } else {
//                listFamAcomp();
//            }
//        }));
        vistaFichIngreso.getBtnAgreAcomp().addActionListener(e -> {
            if (vistaFichIngreso.getTxtCodigo().getText().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Debe Ingresar Cédula y presione Enter", "Error", JOptionPane.ERROR_MESSAGE);
//                vistaFamily.setVisible(false);
            } else {
                if (vistaFichIngreso.getCbxParent1().getSelectedItem().toString().equals("Seleccione...")) {
                    JOptionPane.showMessageDialog(null, "Seleccione una opción", "Error", JOptionPane.WARNING_MESSAGE);
                } else {
//                listFamAcomp();
                    if (vistaFichIngreso.getCbxParent1().getSelectedItem().toString().equals("Hijo/a")) {
//                abrirVentanHijos();
                    } else {
                        vistaFamily.getTxtVFParentesco().setText(vistaFichIngreso.getCbxParent1().getSelectedItem().toString());
                        vistaFamily.getTxtVFParentesco().setEnabled(false);
                        abrVenFamily();
                    }
                }
            }

        });
        vistaFamily.getBtnGuardar().addActionListener(e -> {
            try {
                InsertarFamily();
                listFamAcomp();
            } catch (SQLException ex) {
                Logger.getLogger(ControladorFichaIngreso.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
        vistaFichIngreso.getBtnGuardar1().addActionListener(e -> {
            try {
                BtnEditAcomp();
            } catch (SQLException ex) {
                Logger.getLogger(ControladorFichaIngreso.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
    }

    public void inicIcon() {
        vistaFichIngreso.setIconImage(new ImageIcon(getClass().getResource("/iconos/icono1.png")).getImage());
        vistaAgreArt.setIconImage(new ImageIcon(getClass().getResource("/iconos/icono1.png")).getImage());
        vistaAgreArtBenef.setIconImage(new ImageIcon(getClass().getResource("/iconos/icono1.png")).getImage());
        vistaFamily.setIconImage(new ImageIcon(getClass().getResource("/iconos/icono1.png")).getImage());
        vistFormHij.setIconImage(new ImageIcon(getClass().getResource("/iconos/icono1.png")).getImage());
        vistaFichIngreso.getDlgEditar().setIconImage(new ImageIcon(getClass().getResource("/iconos/icono1.png")).getImage());
        vistaFichIngreso.getDlgEditarAcomp().setIconImage(new ImageIcon(getClass().getResource("/iconos/icono1.png")).getImage());
        vistaFichIngreso.getDlgEditarHijosAcom().setIconImage(new ImageIcon(getClass().getResource("/iconos/icono1.png")).getImage());
        vistaFichIngreso.getDlgRegistro().setIconImage(new ImageIcon(getClass().getResource("/iconos/icono1.png")).getImage());

    }

    public void cancelFamily() {
        vistaFamily.setVisible(false);
        famModelDb.setPersona_cedula((""));
        famModelDb.setPersona_nombre("");
        famModelDb.setPersona_apellido("");
    }

    public KeyListener DetectEnt(JTextField txt) {
        KeyListener kn = new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
            }

            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER && !vistaFichIngreso.getTxtCodigo().getText().isEmpty()) {
                    codVic = Integer.parseInt(vistaFichIngreso.getTxtCodigo().getText());
                    vistaFichIngreso.getBtnGuardar().setEnabled(true);
                    vistaFichIngreso.getBtnAgregarArticulosVictima().setEnabled(true);
                    vistaFichIngreso.getBtnAgregarArticulosFundacion().setEnabled(true);
                    ban = 1;
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {
            }
        };
        return kn;
    }

    public void NuevoRegCleanAll() {
        vistaFichIngreso.getBtnNuevo().setEnabled(true);
        vistaFichIngreso.getLblCodigoIngreso().setText("");
        vistaFichIngreso.getLblCodigoEntBenef().setText("");
        vistaFichIngreso.getLblCodigoArtEntFund().setText("");
        vistaFichIngreso.getLblCodHijoa().setText("");
        vistaFichIngreso.getTxtCedula().setText("");
        vistaFichIngreso.getTxtNombresApellidos().setText("");
        vistaFichIngreso.getTxtCodigo().setText("");
        vistaFichIngreso.getTxtDormitorio().setText("");
        vistaFichIngreso.getTxaReferida().setText("");
        vistaFichIngreso.getBtnAgregarArticulosVictima().setEnabled(false);
        vistaFichIngreso.getBtnAgregarArticulosFundacion().setEnabled(false);
        DefaultTableModel tblArtBen = (DefaultTableModel) vistaFichIngreso.getTblArticulosBeneficiaria().getModel();
        tblArtBen.setRowCount(0);
        DefaultTableModel tblArt = (DefaultTableModel) vistaFichIngreso.getTblArticulosFundacion().getModel();
        tblArt.setRowCount(0);
        DefaultTableModel tblHij = (DefaultTableModel) vistaFichIngreso.getTblHijos().getModel();
        tblHij.setRowCount(0);
    }

    public void CancelarDlg(JDialog dlg) {
        dlg.setVisible(false);
    }

    public void inicializaPopTables() {
        popTableArtBeneficiaria();
        popTableArtiFunda();
        popTableDormRef();
        popTableArtEntBenefDlg();
        popTableEntFundDlg();
        popTableFamAco();
        popTableAcomHijo();
    }

    public void cargarRegstros() {
        listarArtEntBenefEditCargarDlg();
        listarArtEntEditCargarDlg();
        listarDormiRefEditCargar();
        listFamAcompDlg();
        listFamAcompHijDlg();
    }

    public void actualizar() {
        cargarListaArtBenef();
        cargarListaArt();
    }

    public void fechaSistemaIni() {
        Calendar c = new GregorianCalendar();
        vistaFichIngreso.getJdcFecha().setCalendar(c);
    }

    public KeyListener validarNumJsp(JSpinner numero) { // metodo para validar el ingreso de numeros 
        KeyListener kn = new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
                char val = e.getKeyChar();
                if (val < '0' || val > '9') {
                    e.consume();
                }
            }

            @Override
            public void keyPressed(KeyEvent e) {
            }

            @Override
            public void keyReleased(KeyEvent e) {

            }
        };
        return kn;
    }

    public void ValidarCampo() {
        vistaAgreArtBenef.getSpnCantidad().addKeyListener(validarNumJsp(vistaAgreArtBenef.getSpnCantidad()));
        vistaFichIngreso.getTxtDormitorio().addKeyListener(validarLetras(vistaFichIngreso.getTxtDormitorio()));
        vistaFichIngreso.getTxtCodigo().setEnabled(false);
        vistaFichIngreso.getTxtNombresApellidos().setEnabled(false);
        vistaFichIngreso.getTxCed().addKeyListener(validarNumeros(vistaFichIngreso.getTxCed()));
        vistaFichIngreso.getTxtNom().addKeyListener(validarLetras(vistaFichIngreso.getTxtNom()));
        vistaFichIngreso.getTxtApell().addKeyListener(validarLetras(vistaFichIngreso.getTxtApell()));
        vistaFamily.getTxCed().addKeyListener(validarNumeros(vistaFamily.getTxCed()));
        vistaFamily.getTxtNom().addKeyListener(validarLetras(vistaFamily.getTxtNom()));
        vistaFamily.getTxtApell().addKeyListener(validarLetras(vistaFamily.getTxtApell()));
    }

    public void botonesInavilitado() {
        vistaFichIngreso.getBtnAgregarArticulosVictima().setEnabled(false);
        vistaFichIngreso.getBtnAgregarArticulosFundacion().setEnabled(false);

        //JOptionPane.showMessageDialog(null, "Demaciados caracteres (49)", "Verificacion", JOptionPane.WARNING_MESSAGE);
    }

    public void AbrirVentanFichIng() {
        vistaFichIngreso.setVisible(true);
        vistaFichIngreso.setLocationRelativeTo(null);
    }

    public void AbrirVentBenef() {
        vistaAgreArtBenef.setVisible(true);
        vistaAgreArtBenef.setLocationRelativeTo(null);
        vistaAgreArtBenef.getTxtArticulo().setText("");
        vistaAgreArtBenef.getTxtObsrvaciones().setText("");
        vistaAgreArtBenef.getSpnCantidad().setValue(0);
        vistaAgreArtBenef.getBtnEditar().setEnabled(false);
        vistaAgreArtBenef.getBtnGuardar().setEnabled(true);
    }

    public void AbrirVentArtBenef2() {
        vistaAgreArtBenef.setVisible(true);
        vistaAgreArtBenef.setLocationRelativeTo(null);
        vistaAgreArtBenef.getBtnGuardar().setEnabled(false);
    }

    public void AbrirVerRegistros() {
        vistaFichIngreso.getDlgRegistro().setVisible(true);
        vistaFichIngreso.getDlgRegistro().setSize(1200, 700);
        vistaFichIngreso.getDlgRegistro().setLocationRelativeTo(null);
    }

    public void cancelarBenef() {
        vistaAgreArtBenef.getTxtArticulo().setText("");
        vistaAgreArtBenef.getTxtObsrvaciones().setText("");
        vistaAgreArtBenef.getSpnCantidad().setValue(0);
        vistaAgreArtBenef.setVisible(false);
    }

    // -------------------------------editar Artirculos beneficiario----------------
    //-------------------------------------------------------------------------------
    public void popTableArtBeneficiaria() {
        JPopupMenu pM = new JPopupMenu();
        JMenuItem itemEdit = new JMenuItem("EDITAR");
        JMenuItem itemElim = new JMenuItem("BORRAR");
        itemEdit.addActionListener((ActionEvent e) -> {
            EditarArtBenf();
        });
        itemElim.addActionListener((ActionEvent e) -> {

        });
        pM.add(itemEdit);
        pM.add(itemElim);
        vistaFichIngreso.getTblArticulosBeneficiaria().setComponentPopupMenu(pM);
    }

    public void EditarArtBenf() {
        DefaultTableModel modeloTabla = (DefaultTableModel) vistaFichIngreso.getTblArticulosBeneficiaria().getModel();
        int fsel = vistaFichIngreso.getTblArticulosBeneficiaria().getSelectedRow();
        if (fsel == -1) {
            JOptionPane.showMessageDialog(null, "Seleccione una fila ó Actualize lista", "Verificación", JOptionPane.WARNING_MESSAGE);
        } else {
            String cod = modeloTabla.getValueAt(vistaFichIngreso.getTblArticulosBeneficiaria().getSelectedRow(), 0).toString();
            String nombreArt = modeloTabla.getValueAt(vistaFichIngreso.getTblArticulosBeneficiaria().getSelectedRow(), 1).toString();
            String cantidad = modeloTabla.getValueAt(vistaFichIngreso.getTblArticulosBeneficiaria().getSelectedRow(), 2).toString();
            String observ = modeloTabla.getValueAt(vistaFichIngreso.getTblArticulosBeneficiaria().getSelectedRow(), 3).toString();

            vistaAgreArtBenef.getLblCodVic().setText(cod);
            vistaAgreArtBenef.getTxtArticulo().setText(nombreArt);
            vistaAgreArtBenef.getTxtObsrvaciones().setText(observ);
            vistaAgreArtBenef.getSpnCantidad().setValue(Integer.parseInt(cantidad));

            vistaAgreArtBenef.setTitle("Editar Arítuculos Benficiario");
            AbrirVentArtBenef2();
            vistaAgreArtBenef.getBtnEditar().setEnabled(true);
            vistaAgreArtBenef.getBtnGuardar().setEnabled(false);
        }
    }

    private void cargarListaArtBenef() {
        int canFilas = vistaFichIngreso.getTblArticulosBeneficiaria().getRowCount();
        for (int i = canFilas - 1; i >= 0; i--) {
            if (i > 0) {
                modeloTab.removeRow(i);
            }
        }
        modeloTab = (DefaultTableModel) vistaFichIngreso.getTblArticulosBeneficiaria().getModel();
        List<ArticulosEntregadosPersonal> lista;
        try {
            lista = artEntPerModelDB.listartEntPers(Integer.parseInt(vistaFichIngreso.getTxtCodigo().getText()));
            int columnas = modeloTab.getColumnCount();
            for (int i = 0; i < lista.size(); i++) {
                modeloTab.addRow(new Object[columnas]);
                vistaFichIngreso.getTblArticulosBeneficiaria().setValueAt(lista.get(i).getArtentper_id(), i, 0);
                vistaFichIngreso.getTblArticulosBeneficiaria().setValueAt(lista.get(i).getArtentper_nombre(), i, 1);
                vistaFichIngreso.getTblArticulosBeneficiaria().setValueAt(lista.get(i).getArticulo_cantidad(), i, 2);
                vistaFichIngreso.getTblArticulosBeneficiaria().setValueAt(lista.get(i).getArtentper_observaciones(), i, 3);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ControladorFichaIngreso.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void controlTxtArea() {
        controlArea(vistaFichIngreso.getTxaReferida());
    }

    public void EditarArtEntBtn() {
        artEntModelDB.setArticulo_id(Integer.parseInt(vistaAgreArt.getLblCodPers().getText()));
        artEntModelDB.setArticulo_descripcion(vistaAgreArt.getTxtArticulo().getText());
        artEntModelDB.setArticulo_observaciones(vistaAgreArt.getTxtObsrvaciones().getText());
        artEntModelDB.setArticulo_cantidad(Integer.parseInt(vistaAgreArt.getSpnCantidad().getValue().toString()));

        if (artEntModelDB.actualizarEditArtEnt()) {
            JOptionPane.showMessageDialog(null, "Datos actualizados correctamente");
            vistaAgreArt.setVisible(false);
            listarArtEntEditCargarDlg();
            cargarListaArt();
        } else {
            JOptionPane.showMessageDialog(null, "Error al actualizar Datos.");
        }
    }

    public void InsertarArticulos() throws SQLException {
        if (vistaAgreArt.getTxtArticulo().getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Campos Vacios", "Ingrese Valores", JOptionPane.WARNING_MESSAGE);
        } else {
            if (vistaAgreArt.getTxtObsrvaciones().getText().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Campos Vacios", "Ingrese Valores", JOptionPane.WARNING_MESSAGE);
            } else {
                artEntModelDB.setIngreso_id(Integer.parseInt(vistaFichIngreso.getLblCodigoArtEntFund().getText()));
                artEntModelDB.setArticulo_descripcion(vistaAgreArt.getTxtArticulo().getText());
                artEntModelDB.setArticulo_observaciones(vistaAgreArt.getTxtObsrvaciones().getText());
                artEntModelDB.setArticulo_cantidad(Integer.parseInt(vistaAgreArt.getSpnCantidad().getValue().toString()));

                if (artEntModelDB.insertarArtEntr()) {
                    cargarListaArt();
                    JOptionPane.showMessageDialog(null, "Datos Insertados Correctamente");
//                    vistaFichIngreso.getBtnAgregarArticulosFundacion().setEnabled(true);
//                    vistaFichIngreso.getBtnAgregarArticulosVictima().setEnabled(false);
                    vistaFichIngreso.getBtnGuardar().setEnabled(false);
                    vistaAgreArt.setVisible(false);
                    cargarListaArt();
                    listarArtEntEditCargarDlg();
                } else {
                    JOptionPane.showMessageDialog(null, "Error al Ingresar Datos");
                }
            }
        }
    }

    //---------------------------- Articulos personales
    public void AbrirVentArtPers() {
        vistaAgreArt.setVisible(true);
        vistaAgreArt.setLocationRelativeTo(null);
        vistaAgreArt.getTxtArticulo().setText("");
        vistaAgreArt.getTxtObsrvaciones().setText("");
        vistaAgreArt.getSpnCantidad().setValue(0);
        vistaAgreArt.getBtnEditarPers().setEnabled(false);
        vistaAgreArt.getBtnGuardar().setEnabled(true);
    }

    public void AbrirVentArtPers2() {
        vistaAgreArt.setVisible(true);
        vistaAgreArt.setLocationRelativeTo(null);
        vistaAgreArt.getBtnGuardar().setEnabled(false);
    }

    public void cancelarPers() {
        vistaAgreArt.getTxtArticulo().setText("");
        vistaAgreArt.getTxtObsrvaciones().setText("");
        vistaAgreArt.getSpnCantidad().setValue(0);
        vistaAgreArt.setVisible(false);
    }

    public void InsertarArticulosPers() throws SQLException {
        if (vistaAgreArtBenef.getTxtArticulo().getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Ingrese Artículo", "Ingrese Valores", JOptionPane.WARNING_MESSAGE);
        } else {
            if (vistaAgreArtBenef.getTxtObsrvaciones().getText().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Ingrese Observaciones", "Ingrese Valores", JOptionPane.WARNING_MESSAGE);
            } else {
                artEntPerModelDB.setIngreso_id(Integer.parseInt(vistaFichIngreso.getLblCodigoEntBenef().getText()));
                artEntPerModelDB.setArtentper_nombre(vistaAgreArtBenef.getTxtArticulo().getText());
                artEntPerModelDB.setArtentper_observaciones(vistaAgreArtBenef.getTxtObsrvaciones().getText());
                artEntPerModelDB.setArticulo_cantidad(Integer.parseInt(vistaAgreArtBenef.getSpnCantidad().getValue().toString()));

                if (artEntPerModelDB.InsertarArtEntrPers()) {
                    cargarListaArtBenef();
                    JOptionPane.showMessageDialog(null, "Datos Insertados Correctamente");
                    vistaAgreArtBenef.setVisible(false);
                    listarArtEntBenefEditCargarDlg();
                    vistaFichIngreso.getBtnGuardar().setEnabled(true);
                    //botonesInavilitado();
                } else {
                    JOptionPane.showMessageDialog(null, "Error al Ingresar Datos");
                }
            }
        }
    }

    private void cargarListaArt() {
        DefaultTableModel tb = (DefaultTableModel) vistaFichIngreso.getTblArticulosFundacion().getModel();
        int a = vistaFichIngreso.getTblArticulosFundacion().getRowCount() - 1;

        for (int i = a; i >= 0; i--) {
            tb.removeRow(tb.getRowCount() - 1);
        }
        modeloTabPers = (DefaultTableModel) vistaFichIngreso.getTblArticulosFundacion().getModel();
        List<ArticulosEntregados> lista;
        try {
            lista = artEntModelDB.listartEnt(Integer.parseInt(vistaFichIngreso.getTxtCodigo().getText()));
            int columnas = modeloTabPers.getColumnCount();
            for (int i = 0; i < lista.size(); i++) {
                modeloTabPers.addRow(new Object[columnas]);
                vistaFichIngreso.getTblArticulosFundacion().setValueAt(lista.get(i).getArticulo_id(), i, 0);
                vistaFichIngreso.getTblArticulosFundacion().setValueAt(lista.get(i).getArticulo_descripcion(), i, 1);
                vistaFichIngreso.getTblArticulosFundacion().setValueAt(lista.get(i).getArticulo_cantidad(), i, 2);
                vistaFichIngreso.getTblArticulosFundacion().setValueAt(lista.get(i).getArticulo_observaciones(), i, 3);
            }

        } catch (SQLException ex) {
            Logger.getLogger(ControladorFichaIngreso.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void popTableArtiFunda() {
        JPopupMenu pM = new JPopupMenu();
        JMenuItem itemEdit = new JMenuItem("EDITAR");
        JMenuItem itemEli = new JMenuItem("ELIMINAR");
        itemEdit.addActionListener((ActionEvent e) -> {
            EditarArtFun();
        });
        itemEli.addActionListener((ActionEvent e) -> {
            eliminarArtEntFund();
        });
        pM.add(itemEdit);
        pM.add(itemEli);
        vistaFichIngreso.getTblArticulosFundacion().setComponentPopupMenu(pM);
    }

    //--------------------------benefeciario jDialog
    //--------------------------------------------------------------------------
    public void popTableArtEntBenefDlg() {
        JPopupMenu pM = new JPopupMenu();
        JMenuItem itemEdit = new JMenuItem("EDITAR");
        JMenuItem itemElim = new JMenuItem("ELIMINAR");
        itemEdit.addActionListener((ActionEvent e) -> {
            EditarArtBeneDlg();
        });
        itemElim.addActionListener((ActionEvent e) -> {
            eliminarArtEntBen();
        });
        pM.add(itemEdit);
        pM.add(itemElim);
        vistaFichIngreso.getTblArticulosBeneficiaria1().setComponentPopupMenu(pM);
    }

    public void listarArtEntBenefEditCargarDlg() {
        DefaultTableModel tb = (DefaultTableModel) vistaFichIngreso.getTblArticulosBeneficiaria1().getModel();
        int a = vistaFichIngreso.getTblArticulosBeneficiaria1().getRowCount() - 1;
        for (int i = a; i >= 0; i--) {
            tb.removeRow(tb.getRowCount() - 1);
        }

        DefaultTableModel modeloTabHijosEC = (DefaultTableModel) vistaFichIngreso.getTblArticulosBeneficiaria1().getModel();
        List<ArticulosEntregadosPersonal> lista;

        try {
            lista = artEntPerModelDB.listarArtEntBenef();
            int columnas = modeloTabHijosEC.getColumnCount();
            for (int i = 0; i < lista.size(); i++) {
                modeloTabHijosEC.addRow(new Object[columnas]);
                vistaFichIngreso.getTblArticulosBeneficiaria1().setValueAt(lista.get(i).getArtentper_id(), i, 0);
                vistaFichIngreso.getTblArticulosBeneficiaria1().setValueAt(lista.get(i).getPersona_cedula(), i, 1);
                vistaFichIngreso.getTblArticulosBeneficiaria1().setValueAt(lista.get(i).getPersona_nombre() + " " + lista.get(i).getPersona_apellido(), i, 2);
                vistaFichIngreso.getTblArticulosBeneficiaria1().setValueAt(lista.get(i).getArtentper_nombre(), i, 3);
                vistaFichIngreso.getTblArticulosBeneficiaria1().setValueAt(lista.get(i).getArticulo_cantidad(), i, 4);
                vistaFichIngreso.getTblArticulosBeneficiaria1().setValueAt(lista.get(i).getArtentper_observaciones(), i, 5);
            }
        } catch (Exception ex) {
            Logger.getLogger(ControladorFichaIngreso.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void EditarArtBeneDlg() {
        DefaultTableModel modeloTabla = (DefaultTableModel) vistaFichIngreso.getTblArticulosBeneficiaria1().getModel();
        int fsel = vistaFichIngreso.getTblArticulosBeneficiaria1().getSelectedRow();
        if (fsel == -1) {
            JOptionPane.showMessageDialog(null, "Seleccione una fila ó Actualize lista", "Verificación", JOptionPane.WARNING_MESSAGE);
        } else {
            String cod = modeloTabla.getValueAt(vistaFichIngreso.getTblArticulosBeneficiaria1().getSelectedRow(), 0).toString();
            String Art = modeloTabla.getValueAt(vistaFichIngreso.getTblArticulosBeneficiaria1().getSelectedRow(), 3).toString();
            String can = modeloTabla.getValueAt(vistaFichIngreso.getTblArticulosBeneficiaria1().getSelectedRow(), 4).toString();
            String obs = modeloTabla.getValueAt(vistaFichIngreso.getTblArticulosBeneficiaria1().getSelectedRow(), 5).toString();

            vistaAgreArtBenef.getLblCodVic().setText(cod);
            vistaAgreArtBenef.getTxtArticulo().setText(Art);
            vistaAgreArtBenef.getTxtObsrvaciones().setText(obs);
            vistaAgreArtBenef.getSpnCantidad().setValue(Integer.parseInt(can));
            AbrirVentArtBenef2();
            vistaAgreArtBenef.setTitle("Editar Arítuculos Entregados");
            vistaAgreArtBenef.getBtnEditar().setEnabled(true);
            vistaAgreArtBenef.getBtnGuardar().setEnabled(false);
        }
    }

    public void EditarBtnArtBenfDg() {
        artEntPerModelDB.setArtentper_id(Integer.parseInt(vistaAgreArtBenef.getLblCodVic().getText()));
        artEntPerModelDB.setArtentper_nombre(vistaAgreArtBenef.getTxtArticulo().getText());
        artEntPerModelDB.setArtentper_observaciones(vistaAgreArtBenef.getTxtObsrvaciones().getText());
        artEntPerModelDB.setArticulo_cantidad(Integer.parseInt(vistaAgreArtBenef.getSpnCantidad().getValue().toString()));

        if (artEntPerModelDB.actualizarEditArtEntPers()) {
            JOptionPane.showMessageDialog(null, "Datos actualizados correctamente");
            vistaAgreArtBenef.setVisible(false);
            listarArtEntBenefEditCargarDlg();
        } else {
            JOptionPane.showMessageDialog(null, "Error al actualizar Datos.");

        }
    }

    public void EditarArtFunDlg() {
        DefaultTableModel modeloTabla = (DefaultTableModel) vistaFichIngreso.getTblArticulosFundacion1().getModel();
        int fsel = vistaFichIngreso.getTblArticulosFundacion1().getSelectedRow();
        if (fsel == -1) {
            JOptionPane.showMessageDialog(null, "Seleccione una fila ó Actualize lista", "Verificación", JOptionPane.WARNING_MESSAGE);
        } else {
            String cod = modeloTabla.getValueAt(vistaFichIngreso.getTblArticulosFundacion1().getSelectedRow(), 0).toString();
            String nombreArt = modeloTabla.getValueAt(vistaFichIngreso.getTblArticulosFundacion1().getSelectedRow(), 3).toString();
            String cantidad = modeloTabla.getValueAt(vistaFichIngreso.getTblArticulosFundacion1().getSelectedRow(), 4).toString();
            String observ = modeloTabla.getValueAt(vistaFichIngreso.getTblArticulosFundacion1().getSelectedRow(), 5).toString();

            vistaAgreArt.getLblCodPers().setText(cod);
            vistaAgreArt.getTxtArticulo().setText(nombreArt);
            vistaAgreArt.getTxtObsrvaciones().setText(observ);
            vistaAgreArt.getSpnCantidad().setValue(Integer.parseInt(cantidad));
            AbrirVentArtPers2();
            vistaAgreArt.setTitle("Editar Arítuculos Entregados Fundacion");
            vistaAgreArt.getBtnEditarPers().setEnabled(true);
            vistaAgreArt.getBtnGuardar().setEnabled(false);
        }
    }

    public void EditarArtFun() {
        DefaultTableModel modeloTabla = (DefaultTableModel) vistaFichIngreso.getTblArticulosFundacion().getModel();
        int fsel = vistaFichIngreso.getTblArticulosFundacion().getSelectedRow();
        if (fsel == -1) {
            JOptionPane.showMessageDialog(null, "Seleccione una fila ó Actualize lista", "Verificación", JOptionPane.WARNING_MESSAGE);
        } else {
            String cod = modeloTabla.getValueAt(vistaFichIngreso.getTblArticulosFundacion().getSelectedRow(), 0).toString();
            String nombreArt = modeloTabla.getValueAt(vistaFichIngreso.getTblArticulosFundacion().getSelectedRow(), 1).toString();
            String cantidad = modeloTabla.getValueAt(vistaFichIngreso.getTblArticulosFundacion().getSelectedRow(), 2).toString();
            String observ = modeloTabla.getValueAt(vistaFichIngreso.getTblArticulosFundacion().getSelectedRow(), 3).toString();

            vistaAgreArt.getLblCodPers().setText(cod);
            vistaAgreArt.getTxtArticulo().setText(nombreArt);
            vistaAgreArt.getTxtObsrvaciones().setText(observ);
            vistaAgreArt.getSpnCantidad().setValue(Integer.parseInt(cantidad));
            AbrirVentArtPers2();
            vistaAgreArt.setTitle("Editar Arítuculos Entregados");
            vistaAgreArt.getBtnEditarPers().setEnabled(true);
            vistaAgreArt.getBtnGuardar().setEnabled(false);
        }
    }

    public void EditarBtnArtEntrPer() {
        artEntPerModelDB.setArtentper_id(Integer.parseInt(vistaAgreArt.getLblCodPers().getText()));
        artEntPerModelDB.setArtentper_nombre(vistaAgreArt.getTxtArticulo().getText());
        artEntPerModelDB.setArtentper_observaciones(vistaAgreArt.getTxtObsrvaciones().getText());
        artEntPerModelDB.setArticulo_cantidad(Integer.parseInt(vistaAgreArt.getSpnCantidad().getValue().toString()));

        if (artEntPerModelDB.actualizarEditArtEntPers()) {
            JOptionPane.showMessageDialog(null, "Datos actualizados correctamente");
            vistaAgreArt.setVisible(false);
            cargarListaArtBenef();
            listarArtEntBenefEditCargarDlg();
        } else {
            JOptionPane.showMessageDialog(null, "Error al actualizar Datos.");
        }
    }
//------------------Dormitorio Referido

    public void popTableDormRef() {
        JPopupMenu pM = new JPopupMenu();
        JMenuItem itemEdit = new JMenuItem("EDITAR");
        JMenuItem itemElim = new JMenuItem("ELIMINAR");
        itemEdit.addActionListener((ActionEvent e) -> {
            EditarDorRef();
        });

        itemElim.addActionListener((ActionEvent e) -> {
            eliminarDormit();
        });
        pM.add(itemEdit);
        pM.add(itemElim);
        vistaFichIngreso.getTblDorRef().setComponentPopupMenu(pM);
    }

    public void guardarDormRefer() throws SQLException {
        if (vistaFichIngreso.getTxtCedula().getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Ingrese cédula", "Ingrese Valores", JOptionPane.WARNING_MESSAGE);
        } else {
            if (vistaFichIngreso.getTxtDormitorio().getText().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Ingrese dormitorio", "Ingrese Valores", JOptionPane.WARNING_MESSAGE);
            } else {
                if (vistaFichIngreso.getTxaReferida().getText().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Ingrese referido", "Ingrese Valores", JOptionPane.WARNING_MESSAGE);
                } else {
                    if (vistaFichIngreso.getJdcFecha().getDate() == null) {
                        JOptionPane.showMessageDialog(null, "Ingrese la fecha", "Ingrese Valores", JOptionPane.WARNING_MESSAGE);
                    } else {
                        modelIngreDB.setVictima_codigo(Integer.parseInt(vistaFichIngreso.getTxtCodigo().getText()));
//                modelIngreDB.setPersonal_codigo(persModelDB.obtenerCodIn(vistaLogin.getTxtUsuario().getText(), vistaLogin.getPswContra().getText()));
                        modelIngreDB.setPersonal_codigo(modelIngreDB.verifiUserP(personal_cod));
                        modelIngreDB.setAsignacion_dormitorio(vistaFichIngreso.getTxtDormitorio().getText());
                        modelIngreDB.setReferidapor(vistaFichIngreso.getTxaReferida().getText());
                        modelIngreDB.setIngreso_fecha(Fecha4(vistaFichIngreso.getJdcFecha()));
                        if (modelIngreDB.IngresarDormitorioReferido()) {
                            vistaFichIngreso.getLblCodigoIngreso().setText(Integer.toString(modelIngreDB.maxId()));
                            vistaFichIngreso.getLblCodHijoa().setText(Integer.toString(modelIngreDB.maxId()));
                            vistaFichIngreso.getLblCodigoEntBenef().setText(Integer.toString(modelIngreDB.maxId()));
                            vistaFichIngreso.getLblCodigoArtEntFund().setText(Integer.toString(modelIngreDB.maxId()));
                            JOptionPane.showMessageDialog(null, "Datos Insertados Correctamente");
                            vistaFichIngreso.getBtnGuardar().setEnabled(false);
                            vistaFichIngreso.getBtnAgregarArticulosVictima().setEnabled(true);
                            vistaFichIngreso.getBtnAgregarArticulosFundacion().setEnabled(true);
                        } else {
                            JOptionPane.showMessageDialog(null, "Error al Ingresar Datos");
                        }
                    }
                }
            }
        }
    }

    public void abrirVentanHijos() {
        vistFormHij.setVisible(true);
        vistFormHij.setLocationRelativeTo(null);
    }

    public void listarDormiRefEditCargar() {
        DefaultTableModel tb = (DefaultTableModel) vistaFichIngreso.getTblDorRef().getModel();
        int a = vistaFichIngreso.getTblDorRef().getRowCount() - 1;
        for (int i = a; i >= 0; i--) {
            tb.removeRow(tb.getRowCount() - 1);
        }

        DefaultTableModel modeloTabHijosEC = (DefaultTableModel) vistaFichIngreso.getTblDorRef().getModel();
        List<Ingreso> lista;

        try {
            lista = modelIngreDB.listarDormRefEdit();
            int columnas = modeloTabHijosEC.getColumnCount();
            for (int i = 0; i < lista.size(); i++) {
                modeloTabHijosEC.addRow(new Object[columnas]);
                vistaFichIngreso.getTblDorRef().setValueAt(lista.get(i).getIngreso_id(), i, 0);
                vistaFichIngreso.getTblDorRef().setValueAt(lista.get(i).getPersona_cedula(), i, 1);
                vistaFichIngreso.getTblDorRef().setValueAt(lista.get(i).getPersona_nombre() + " " + lista.get(i).getPersona_apellido(), i, 2);
                vistaFichIngreso.getTblDorRef().setValueAt(lista.get(i).getAsignacion_dormitorio(), i, 3);
                vistaFichIngreso.getTblDorRef().setValueAt(lista.get(i).getReferidapor(), i, 4);
                vistaFichIngreso.getTblDorRef().setValueAt(lista.get(i).getIngreso_fecha(), i, 5);
            }

        } catch (Exception ex) {
            Logger.getLogger(ControladorFichaIngreso.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    // ----------------------arituclos Entregado fundacion jDialog------------------------
    //           ---------------------------------------------------
    public void popTableEntFundDlg() {
        JPopupMenu pM = new JPopupMenu();
        JMenuItem itemEdit = new JMenuItem("EDITAR");
        JMenuItem itemElim = new JMenuItem("ELIMINAR");
        itemEdit.addActionListener((ActionEvent e) -> {
            EditarArtFunDlg();
        });
        itemElim.addActionListener((ActionEvent e) -> {
            eliminarArtEntFund();
        });
        pM.add(itemEdit);
        pM.add(itemElim);
        vistaFichIngreso.getTblArticulosFundacion1().setComponentPopupMenu(pM);
    }

    public void listarArtEntEditCargarDlg() {
        DefaultTableModel tb = (DefaultTableModel) vistaFichIngreso.getTblArticulosFundacion1().getModel();
        int a = vistaFichIngreso.getTblArticulosFundacion1().getRowCount() - 1;
        for (int i = a; i >= 0; i--) {
            tb.removeRow(tb.getRowCount() - 1);
        }

        DefaultTableModel modeloTabHijosEC = (DefaultTableModel) vistaFichIngreso.getTblArticulosFundacion1().getModel();
        List<ArticulosEntregados> lista;

        try {
            lista = artEntModelDB.listarArtEntTodo();
            int columnas = modeloTabHijosEC.getColumnCount();
            for (int i = 0; i < lista.size(); i++) {
                modeloTabHijosEC.addRow(new Object[columnas]);
                vistaFichIngreso.getTblArticulosFundacion1().setValueAt(lista.get(i).getArticulo_id(), i, 0);
                vistaFichIngreso.getTblArticulosFundacion1().setValueAt(lista.get(i).getPersona_cedula(), i, 1);
                vistaFichIngreso.getTblArticulosFundacion1().setValueAt(lista.get(i).getPersona_nombre() + " " + lista.get(i).getPersona_apellido(), i, 2);
                vistaFichIngreso.getTblArticulosFundacion1().setValueAt(lista.get(i).getArticulo_descripcion(), i, 3);
                vistaFichIngreso.getTblArticulosFundacion1().setValueAt(lista.get(i).getArticulo_cantidad(), i, 4);
                vistaFichIngreso.getTblArticulosFundacion1().setValueAt(lista.get(i).getArticulo_observaciones(), i, 5);
            }
        } catch (Exception ex) {
            Logger.getLogger(ControladorFichaIngreso.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void BuscarArtEntFundacionDlg() {
        DefaultTableModel tb = (DefaultTableModel) vistaFichIngreso.getTblArticulosFundacion1().getModel();
        int a = vistaFichIngreso.getTblArticulosFundacion1().getRowCount() - 1;
        for (int i = a; i >= 0; i--) {
            tb.removeRow(tb.getRowCount() - 1);
        }

        DefaultTableModel modeloTabEdit = (DefaultTableModel) vistaFichIngreso.getTblArticulosFundacion1().getModel();
        List<ArticulosEntregados> lista;
        //  modelo.setIdpersona(vista.getTxtBuscar().getText());
        try {
            lista = artEntModelDB.BuscarArtEnt(vistaFichIngreso.getTxtDlgBusar().getText());
            int columnas = modeloTabEdit.getColumnCount();
            for (int i = 0; i < lista.size(); i++) {
                modeloTabEdit.addRow(new Object[columnas]);
                vistaFichIngreso.getTblArticulosFundacion1().setValueAt(lista.get(i).getArticulo_id(), i, 0);
                vistaFichIngreso.getTblArticulosFundacion1().setValueAt(lista.get(i).getPersona_cedula(), i, 1);
                vistaFichIngreso.getTblArticulosFundacion1().setValueAt(lista.get(i).getPersona_nombre() + " " + lista.get(i).getPersona_apellido(), i, 2);
                vistaFichIngreso.getTblArticulosFundacion1().setValueAt(lista.get(i).getArticulo_descripcion(), i, 3);
                vistaFichIngreso.getTblArticulosFundacion1().setValueAt(lista.get(i).getArticulo_cantidad(), i, 4);
                vistaFichIngreso.getTblArticulosFundacion1().setValueAt(lista.get(i).getArticulo_observaciones(), i, 5);
            }
            if (vistaFichIngreso.getTxtDlgBusar().getText().length() == 0) {
                listarArtEntBenefEditCargarDlg();
            }
        } catch (Exception ex) {
            Logger.getLogger(ControladorFichaIngreso.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    // ------------------------Eventos buscar ---------------------------------------
    public void realizarBusquedas() {
        BuscarArtEntFundacionDlg();
        BuscarArtBeneficDlg();
        BuscarDormiRef();
        BuscarAcompFaml();
        BuscarlistFamAcompHijDlg();
    }

    public void BuscarDormiRef() {
        DefaultTableModel modeloTabEdit = null;
        DefaultTableModel tb = (DefaultTableModel) vistaFichIngreso.getTblDorRef().getModel();
        int a = vistaFichIngreso.getTblDorRef().getRowCount() - 1;
        for (int i = a; i >= 0; i--) {
            tb.removeRow(tb.getRowCount() - 1);
        }

        modeloTabEdit = (DefaultTableModel) vistaFichIngreso.getTblDorRef().getModel();
        List<Ingreso> lista;
        try {
            lista = modelIngreDB.BuscarDormRefEdit(vistaFichIngreso.getTxtDlgBusar().getText());
            int columnas = modeloTabEdit.getColumnCount();
            for (int i = 0; i < lista.size(); i++) {
                modeloTabEdit.addRow(new Object[columnas]);
                vistaFichIngreso.getTblDorRef().setValueAt(lista.get(i).getIngreso_id(), i, 0);
                vistaFichIngreso.getTblDorRef().setValueAt(lista.get(i).getPersona_cedula(), i, 1);
                vistaFichIngreso.getTblDorRef().setValueAt(lista.get(i).getPersona_nombre() + " " + lista.get(i).getPersona_apellido(), i, 2);
                vistaFichIngreso.getTblDorRef().setValueAt(lista.get(i).getAsignacion_dormitorio(), i, 3);
                vistaFichIngreso.getTblDorRef().setValueAt(lista.get(i).getReferidapor(), i, 4);
                vistaFichIngreso.getTblDorRef().setValueAt(lista.get(i).getIngreso_fecha(), i, 5);
            }
            if (vistaFichIngreso.getTxtDlgBusar().getText().length() == 0) {
                listarDormiRefEditCargar();
            }

        } catch (Exception ex) {
            Logger.getLogger(ControladorFichaIngreso.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void BuscarArtBeneficDlg() {
        System.out.println("lleg al metodo buscar beneficiario");
        modeloTab = (DefaultTableModel) vistaFichIngreso.getTblArticulosBeneficiaria1().getModel();
        int canFilas = vistaFichIngreso.getTblArticulosBeneficiaria1().getRowCount();
        for (int i = canFilas - 1; i >= 0; i--) {
            modeloTab.removeRow(i);
        }

        DefaultTableModel modeloTabEdit = (DefaultTableModel) vistaFichIngreso.getTblArticulosBeneficiaria1().getModel();
        List<ArticulosEntregadosPersonal> lista;
        try {
            lista = artEntPerModelDB.BuscarArtEntBenef(vistaFichIngreso.getTxtDlgBusar().getText());
            int columnas = modeloTabEdit.getColumnCount();
            for (int i = 0; i < lista.size(); i++) {
                modeloTabEdit.addRow(new Object[columnas]);
                vistaFichIngreso.getTblArticulosBeneficiaria1().setValueAt(lista.get(i).getArtentper_id(), i, 0);
                vistaFichIngreso.getTblArticulosBeneficiaria1().setValueAt(lista.get(i).getPersona_cedula(), i, 1);
                vistaFichIngreso.getTblArticulosBeneficiaria1().setValueAt(lista.get(i).getPersona_nombre() + " " + lista.get(i).getPersona_apellido(), i, 2);
                vistaFichIngreso.getTblArticulosBeneficiaria1().setValueAt(lista.get(i).getArtentper_nombre(), i, 3);
                vistaFichIngreso.getTblArticulosBeneficiaria1().setValueAt(lista.get(i).getArticulo_cantidad(), i, 4);
                vistaFichIngreso.getTblArticulosBeneficiaria1().setValueAt(lista.get(i).getArtentper_observaciones(), i, 5);
            }
            if (vistaFichIngreso.getTxtDlgBusar().getText().length() == 0) {
                listarArtEntBenefEditCargarDlg();
            }
        } catch (Exception ex) {
            Logger.getLogger(ControladorFichaIngreso.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void eliminarDormit() {

        int fsel = vistaFichIngreso.getTblDorRef().getSelectedRow();
        if (fsel == -1) {
            JOptionPane.showMessageDialog(null, "Seleccione una fila para eliminar ó Actualiza la lista.", "Verificación", JOptionPane.WARNING_MESSAGE);
        } else {
            int desicion = JOptionPane.showConfirmDialog(null, "Esta seguro de que desea Borrar este Registro?");
            if (desicion == JOptionPane.YES_OPTION) {
                DefaultTableModel modeloTabla = (DefaultTableModel) vistaFichIngreso.getTblDorRef().getModel();
                String cod = modeloTabla.getValueAt(vistaFichIngreso.getTblDorRef().getSelectedRow(), 0).toString();
                modelIngreDB.setIngreso_id(Integer.parseInt(cod));
                if (modelIngreDB.eliminarIngreso()) {
                    JOptionPane.showMessageDialog(null, "Dato borrado correctamente");
                    listarDormiRefEditCargar();
                } else {
                    JOptionPane.showMessageDialog(null, "Dato no borrado");
                }
            }

        }
    }

    private void eliminarArtEntBen() {
        int fsel = vistaFichIngreso.getTblArticulosBeneficiaria1().getSelectedRow();
        if (fsel == -1) {
            JOptionPane.showMessageDialog(null, "Seleccione una fila para eliminar ó Actualiza la lista.", "Verificación", JOptionPane.WARNING_MESSAGE);
        } else {
            int desicion = JOptionPane.showConfirmDialog(null, "Esta seguro de que desea Borrar este Registro?");
            if (desicion == JOptionPane.YES_OPTION) {
                DefaultTableModel modeloTabla = (DefaultTableModel) vistaFichIngreso.getTblArticulosBeneficiaria1().getModel();
                String cod = modeloTabla.getValueAt(vistaFichIngreso.getTblArticulosBeneficiaria1().getSelectedRow(), 0).toString();
                artEntPerModelDB.setArtentper_id(Integer.parseInt(cod));
                if (artEntPerModelDB.eliminarArtEntPers()) {
                    JOptionPane.showMessageDialog(null, "Dato borrado correctamente");
                    listarArtEntBenefEditCargarDlg();
                } else {
                    JOptionPane.showMessageDialog(null, "Dato no borrado");
                }
            }

        }
    }

    private void eliminarArtEntFund() {
        int fsel = vistaFichIngreso.getTblArticulosFundacion1().getSelectedRow();
        if (fsel == -1) {
            JOptionPane.showMessageDialog(null, "Seleccione una fila para eliminar ó Actualiza la lista.", "Verificación", JOptionPane.WARNING_MESSAGE);
        } else {
            int desicion = JOptionPane.showConfirmDialog(null, "Esta seguro de que desea Borrar este Registro?");
            if (desicion == JOptionPane.YES_OPTION) {
                DefaultTableModel modeloTabla = (DefaultTableModel) vistaFichIngreso.getTblArticulosFundacion1().getModel();
                String cod = modeloTabla.getValueAt(vistaFichIngreso.getTblArticulosFundacion1().getSelectedRow(), 0).toString();
                artEntModelDB.setArticulo_id(Integer.parseInt(cod));
                if (artEntModelDB.eliminarArtEnt()) {
                    JOptionPane.showMessageDialog(null, "Dato borrado correctamente");
                    listarArtEntEditCargarDlg();
                } else {
                    JOptionPane.showMessageDialog(null, "Dato no borrado");
                }
            }
        }
    }

    ///////////////////Editar ///////////////////////////Editar /////////////////
    public void AbrVenEditDorRef() {
        vistaFichIngreso.getDlgEditar().setVisible(true);
        vistaFichIngreso.getDlgEditar().setSize(700, 350);
        vistaFichIngreso.getDlgEditar().setLocationRelativeTo(null);
    }

    public void EditarDorRef() {
        DefaultTableModel modeloTabla = (DefaultTableModel) vistaFichIngreso.getTblDorRef().getModel();
        int fsel = vistaFichIngreso.getTblDorRef().getSelectedRow();
        if (fsel == -1) {
            JOptionPane.showMessageDialog(null, "Seleccione una fila ó Actualize lista", "Verificación", JOptionPane.WARNING_MESSAGE);
        } else {
            String cod = modeloTabla.getValueAt(vistaFichIngreso.getTblDorRef().getSelectedRow(), 0).toString();
            String dor = modeloTabla.getValueAt(vistaFichIngreso.getTblDorRef().getSelectedRow(), 3).toString();
            String ref = modeloTabla.getValueAt(vistaFichIngreso.getTblDorRef().getSelectedRow(), 4).toString();

            vistaFichIngreso.getLblCodEdit().setText(cod);
            vistaFichIngreso.getTxtDormiEdit().setText(dor);
            vistaFichIngreso.getTxaReferidaEdit().setText(ref);
            AbrVenEditDorRef();
            vistaFichIngreso.setTitle("Editar Dormitorio Referencia");
        }
    }

    public void limVenEditar() {
        vistaFichIngreso.getLblCodEdit().setText("");
        vistaFichIngreso.getTxtDormiEdit().setText("");
        vistaFichIngreso.getTxaReferidaEdit().setText("");
    }

    public void BtnEdiDorRef() {
        modelIngreDB.setIngreso_id(Integer.parseInt(vistaFichIngreso.getLblCodEdit().getText()));
        modelIngreDB.setAsignacion_dormitorio(vistaFichIngreso.getTxtDormiEdit().getText());
        modelIngreDB.setReferidapor(vistaFichIngreso.getTxaReferidaEdit().getText());

        if (modelIngreDB.actualizar()) {
            JOptionPane.showMessageDialog(null, "Datos actualizados correctamente");
            vistaFichIngreso.getDlgEditar().setVisible(false);
            limVenEditar();
            listarDormiRefEditCargar();
        } else {
            JOptionPane.showMessageDialog(null, "Error al actualizar Datos.");
        }
    }

    //------------------------------Editar Ventna hijos jDialog-------------------------
    //--------------------------------------------------------------------------
    //----------------------- hijos jDialog ----------------------------------
    public void abriVenEditHij() {
        vistaFichIngreso.getDlgEditarHijosAcom().setVisible(true);
        vistaFichIngreso.getDlgEditarHijosAcom().setSize(300, 450);
        vistaFichIngreso.getDlgEditarHijosAcom().setLocationRelativeTo(null);
    }

    // ---------------------------------control Familiares --------------------------
    //----------------------------------------------------------------------------
    public void abrVenFamily() {
        vistaFamily.setVisible(true);
        vistaFamily.setLocationRelativeTo(null);
        vistaFamily.setResizable(false);
    }

    public void popTableFamAco() {
        JPopupMenu pM = new JPopupMenu();
        JMenuItem itemEdit = new JMenuItem("EDITAR");
        JMenuItem itemElim = new JMenuItem("ELIMINAR");
        itemEdit.addActionListener((ActionEvent e) -> {
            try {
                EditarAcomp();
            } catch (java.text.ParseException ex) {
                Logger.getLogger(ControladorFichaIngreso.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
        itemElim.addActionListener((ActionEvent e) -> {
            elimiFamAcomp();
        });
        pM.add(itemEdit);
        pM.add(itemElim);
        vistaFichIngreso.getTblAcomp().setComponentPopupMenu(pM);
    }

    public void popTableAcomHijo() {
        JPopupMenu pM = new JPopupMenu();
        JMenuItem itemEdit = new JMenuItem("EDITAR");
        JMenuItem itemElim = new JMenuItem("ELIMINAR");
        itemEdit.addActionListener((ActionEvent e) -> {
            try {
                JOptionPane.showMessageDialog(null, "No se puede editar", "Editar HIjos", JOptionPane.WARNING_MESSAGE);
            } catch (Exception ex) {
                Logger.getLogger(ControladorFichaIngreso.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
        itemElim.addActionListener((ActionEvent e) -> {
            elimiAcomHijo();
        });
        pM.add(itemEdit);
        pM.add(itemElim);
        vistaFichIngreso.getTblAcomp1().setComponentPopupMenu(pM);
    }

    public void InsertarFamily() throws SQLException {
        if (vistaFamily.getTxCed().getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Ingrese cédula", "Ingrese Valores", JOptionPane.WARNING_MESSAGE);
        } else {
            if (vistaFamily.getTxtNom().getText().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Ingrese nombre", "Ingrese Valores", JOptionPane.WARNING_MESSAGE);
            } else {
                if (vistaFamily.getTxtApell().getText().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Ingrese apelllido", "Ingrese Valores", JOptionPane.WARNING_MESSAGE);
                } else {
                    if (vistaFamily.getDtcFechNac().getDate() == null) {
                        JOptionPane.showMessageDialog(null, "Ingrese fecha de nacimiento", "Ingrese Valores", JOptionPane.WARNING_MESSAGE);
                    } else {

                        famModelDb.setPersona_cedula((vistaFamily.getTxCed().getText()));
                        famModelDb.setPersona_nombre(vistaFamily.getTxtNom().getText());
                        famModelDb.setPersona_apellido(vistaFamily.getTxtApell().getText());
                        famModelDb.setPersona_fecha_nac(Fecha4(vistaFamily.getDtcFechNac()));
                        famModelDb.setParentescoFam(vistaFichIngreso.getCbxParent1().getSelectedItem().toString());
                        try {
                            if (famModelDb.IngresarFamily() && !vistaFichIngreso.getTxtCodigo().getText().isEmpty()) {
                                int vic = Integer.parseInt(vistaFichIngreso.getTxtCodigo().getText());
                                int faml = famModelDb.IngresarFamily2();
                                if (faml != 0) {
                                    int id = famModelDb.maxIdVF();
                                    if (famModelDb.inserVICFAM(faml, vic)) {
                                        if (famModelDb.EdadIngresarFamily3()) {
                                            listFamAcomp();
                                            listFamAcompDlg();
                                            JOptionPane.showMessageDialog(null, "Datos Insertados Correctamente");
                                            vistaFamily.setVisible(false);
                                        }
                                    }
                                }
                            } else {
                                JOptionPane.showMessageDialog(null, "Error al Ingresar Datos, vuelva a intentar");
                            }
                        } catch (Exception ex) {
                            JOptionPane.showMessageDialog(null, "Error al Ingresar Datos, vuelva a intentar");
                            System.out.println("error: " + ex);
                        }
                    }
                }
            }
        }
    }

    public Date Fecha4(JDateChooser fech) {
        Date dat = fech.getDate();
        long d = dat.getTime();
        java.sql.Date fecha = new java.sql.Date(d);
        return fecha;

    }

    public Date obtenerFecha3(JDateChooser fech) {
        SimpleDateFormat NFormt = new SimpleDateFormat("yyyy-MM-dd");
        String fechaJ = NFormt.format(fech.getDate());
        Date fecha = null;
        try {
            fecha = NFormt.parse(fechaJ);
            vistaFichIngreso.getDtcFechNac().setDate(fecha);
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        return fecha;
    }

    public void llenarcomboParentescoFam() throws org.json.simple.parser.ParseException {
        modelComb = new DefaultComboBoxModel();
        jocarray = jo.obtenerParntesco();
        for (Json_object_consulta o : jocarray) {
            modelComb.addElement(o.getValor());
        }
        vistaFichIngreso.getCbxParent1().setModel(modelComb);
        vistaFichIngreso.getCbxParent().setModel(modelComb);
    }

    public void listFamAcomp() {
        System.out.println("entra en listar hijos");
        DefaultTableModel tb = (DefaultTableModel) vistaFichIngreso.getTblHijos().getModel();
        int a = vistaFichIngreso.getTblHijos().getRowCount() - 1;
        for (int i = a; i >= 0; i--) {
            tb.removeRow(tb.getRowCount() - 1);
        }
        modeloTabHijos = (DefaultTableModel) vistaFichIngreso.getTblHijos().getModel();
        List<Familiars> lista;
        List<Hijos> listHijos;
        try {
            lista = famModelDb.obtenerFamil(Integer.parseInt(vistaFichIngreso.getTxtCodigo().getText()));
            listHijos = hijoModelDB.obtenListHijos(Integer.parseInt(vistaFichIngreso.getTxtCodigo().getText()));
            int columnas = modeloTabHijos.getColumnCount();
            int i = 0;
            for (i = 0; i < lista.size(); i++) {
                System.out.println("acompañantes");
                modeloTabHijos.addRow(new Object[columnas]);
                vistaFichIngreso.getTblHijos().setValueAt(lista.get(i).getFamiliares_id(), i, 0);
                vistaFichIngreso.getTblHijos().setValueAt(lista.get(i).getPersona_nombre(), i, 1);
                vistaFichIngreso.getTblHijos().setValueAt(lista.get(i).getPersona_fecha_nac(), i, 2);
                vistaFichIngreso.getTblHijos().setValueAt(lista.get(i).getEdad(), i, 3);
                vistaFichIngreso.getTblHijos().setValueAt(lista.get(i).getParentescoFam(), i, 4);
            }
            columnas = modeloTabHijos.getColumnCount();
            for (int j = 0; j < listHijos.size(); j++) {
                modeloTabHijos.addRow(new Object[columnas]);
                vistaFichIngreso.getTblHijos().setValueAt(listHijos.get(j).getHijo_codigo(), i, 0);
                vistaFichIngreso.getTblHijos().setValueAt(listHijos.get(j).getPersona_nombre() + " " + listHijos.get(j).getPersona_apellido(), i, 1);
                vistaFichIngreso.getTblHijos().setValueAt(listHijos.get(j).getPersona_fecha_nac(), i, 2);
                vistaFichIngreso.getTblHijos().setValueAt(listHijos.get(j).getEdad(), i, 3);
                vistaFichIngreso.getTblHijos().setValueAt("Hijo", i, 4);
                i++;
            }
        } catch (Exception ex) {
            System.out.println("Error al ingresar familiares en la tabla " + ex.getMessage());
        }
    }

    public void limpCanFamAcom() {
        vistaFamily.getTxCed().setText("");
        vistaFamily.getTxtNom().setText("");
        vistaFamily.getTxtApell().setText("");
    }

    public void listFamAcompHijDlg() {
        DefaultTableModel tb = (DefaultTableModel) vistaFichIngreso.getTblAcomp1().getModel();
        int a = vistaFichIngreso.getTblAcomp1().getRowCount() - 1;
        for (int i = a; i >= 0; i--) {
            tb.removeRow(tb.getRowCount() - 1);
        }
        modeloTabHijos = (DefaultTableModel) vistaFichIngreso.getTblAcomp1().getModel();
        List<Hijos> listHijosAll;
        listHijosAll = hijoModelDB.obtenListHijosAll();
        try {
            int columnas = modeloTabHijos.getColumnCount();
            if (!listHijosAll.equals(null)) {
                for (int j = 0; j < listHijosAll.size(); j++) {
                    modeloTabHijos.addRow(new Object[columnas]);
                    vistaFichIngreso.getTblAcomp1().setValueAt(listHijosAll.get(j).getHijo_codigo(), j, 0);
                    vistaFichIngreso.getTblAcomp1().setValueAt(listHijosAll.get(j).getPersona_cedula(), j, 1);
                    vistaFichIngreso.getTblAcomp1().setValueAt(listHijosAll.get(j).getPersona_nombre(), j, 2);
                    vistaFichIngreso.getTblAcomp1().setValueAt(listHijosAll.get(j).getPersona_apellido(), j, 3);
                    vistaFichIngreso.getTblAcomp1().setValueAt(listHijosAll.get(j).getPersona_fecha_nac(), j, 4);
                    vistaFichIngreso.getTblAcomp1().setValueAt(listHijosAll.get(j).getEdad(), j, 5);
                    vistaFichIngreso.getTblAcomp1().setValueAt("Hijo", j, 6);
                }
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Ocurrió un error al cargar lista de hijos");
        }
    }

    public void BuscarlistFamAcompHijDlg() {
        DefaultTableModel tb = (DefaultTableModel) vistaFichIngreso.getTblAcomp1().getModel();
        int a = vistaFichIngreso.getTblAcomp1().getRowCount() - 1;
        for (int i = a; i >= 0; i--) {
            tb.removeRow(tb.getRowCount() - 1);
        }
        modeloTabHijos = (DefaultTableModel) vistaFichIngreso.getTblAcomp1().getModel();
        List<Hijos> listHijosAll;
        try {
            listHijosAll = hijoModelDB.BuscarListHijosAll(vistaFichIngreso.getTxtDlgBusar().getText());
            int columnas = modeloTabHijos.getColumnCount();
            for (int j = 0; j < listHijosAll.size(); j++) {
                modeloTabHijos.addRow(new Object[columnas]);
                vistaFichIngreso.getTblAcomp1().setValueAt(listHijosAll.get(j).getHijo_codigo(), j, 0);
                vistaFichIngreso.getTblAcomp1().setValueAt(listHijosAll.get(j).getPersona_cedula(), j, 1);
                vistaFichIngreso.getTblAcomp1().setValueAt(listHijosAll.get(j).getPersona_nombre(), j, 2);
                vistaFichIngreso.getTblAcomp1().setValueAt(listHijosAll.get(j).getPersona_apellido(), j, 3);
                vistaFichIngreso.getTblAcomp1().setValueAt(listHijosAll.get(j).getPersona_fecha_nac(), j, 4);
                vistaFichIngreso.getTblAcomp1().setValueAt(listHijosAll.get(j).getEdad(), j, 5);
                vistaFichIngreso.getTblAcomp1().setValueAt("Hijo", j, 6);
            }
        } catch (Exception ex) {
            Logger.getLogger(ControladorFichaIngreso.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void listFamAcompDlg() {
        DefaultTableModel tb = (DefaultTableModel) vistaFichIngreso.getTblAcomp().getModel();
        int a = vistaFichIngreso.getTblAcomp().getRowCount() - 1;
        for (int i = a; i >= 0; i--) {
            tb.removeRow(tb.getRowCount() - 1);
        }
        modeloTabHijos = (DefaultTableModel) vistaFichIngreso.getTblAcomp().getModel();
        List<Familiars> lista;
        try {
            lista = famModelDb.obtenerFamilAll();
            int columnas = modeloTabHijos.getColumnCount();
            for (int i = 0; i < lista.size(); i++) {
                modeloTabHijos.addRow(new Object[columnas]);
                vistaFichIngreso.getTblAcomp().setValueAt(lista.get(i).getFamiliares_id(), i, 0);
                vistaFichIngreso.getTblAcomp().setValueAt(lista.get(i).getPersona_cedula(), i, 1);
                vistaFichIngreso.getTblAcomp().setValueAt(lista.get(i).getPersona_nombre(), i, 2);
                vistaFichIngreso.getTblAcomp().setValueAt(lista.get(i).getPersona_apellido(), i, 3);
                vistaFichIngreso.getTblAcomp().setValueAt(lista.get(i).getPersona_fecha_nac(), i, 4);
                vistaFichIngreso.getTblAcomp().setValueAt(lista.get(i).getEdad(), i, 5);
                vistaFichIngreso.getTblAcomp().setValueAt(lista.get(i).getParentescoFam(), i, 6);
            }
        } catch (Exception ex) {
            Logger.getLogger(ControladorFichaIngreso.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void abrEditAcom() {
        vistaFichIngreso.getDlgEditarAcomp().setVisible(true);
        vistaFichIngreso.getDlgEditarAcomp().setSize(550, 360);
        vistaFichIngreso.getDlgEditarAcomp().setLocationRelativeTo(null);
    }

    public void EditarAcomp() throws java.text.ParseException {
        DefaultTableModel modeloTabla = (DefaultTableModel) vistaFichIngreso.getTblAcomp().getModel();
        int fsel = vistaFichIngreso.getTblAcomp().getSelectedRow();
        if (fsel == -1) {
            JOptionPane.showMessageDialog(null, "Seleccione una fila ó Actualize lista", "Verificación", JOptionPane.WARNING_MESSAGE);
        } else {
            String cod = modeloTabla.getValueAt(vistaFichIngreso.getTblAcomp().getSelectedRow(), 0).toString();
            String ced = modeloTabla.getValueAt(vistaFichIngreso.getTblAcomp().getSelectedRow(), 1).toString();
            String nom = modeloTabla.getValueAt(vistaFichIngreso.getTblAcomp().getSelectedRow(), 2).toString();
            String ape = modeloTabla.getValueAt(vistaFichIngreso.getTblAcomp().getSelectedRow(), 3).toString();
            String FchNac = modeloTabla.getValueAt(vistaFichIngreso.getTblAcomp().getSelectedRow(), 4).toString();
//            String edad = modeloTabla.getValueAt(vistaFichIngreso.getTblAcomp().getSelectedRow(), 5).toString();
            String parentes = modeloTabla.getValueAt(vistaFichIngreso.getTblAcomp().getSelectedRow(), 6).toString();
            vistaFichIngreso.getLblCodAcomp().setText(cod);
            vistaFichIngreso.getTxCed().setText(ced);
            vistaFichIngreso.getTxtNom().setText(nom);
            vistaFichIngreso.getTxtApell().setText(ape);
            vistaFichIngreso.getDtcFechNac().setCalendar(putFechJDchos(FchNac));
            vistaFichIngreso.getCbxParent().setSelectedItem(parentes);
            abrEditAcom();
            vistaFichIngreso.getDlgEditarAcomp().setTitle("Editar datos persona acompañante");
        }
    }

    public Calendar putFechJDchos(String fech) throws java.text.ParseException {
        Calendar cal = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("yyy-MM-dd");
        cal.setTime(sdf.parse(fech));
        return cal;
    }

    public void BtnEditAcomp() throws SQLException {
        famModelDb.setFamiliares_id(Integer.parseInt(vistaFichIngreso.getLblCodAcomp().getText()));
        famModelDb.setPersona_cedula(vistaFichIngreso.getTxCed().getText());
        famModelDb.setPersona_nombre(vistaFichIngreso.getTxtNom().getText());
        famModelDb.setPersona_apellido(vistaFichIngreso.getTxtApell().getText());
        famModelDb.setPersona_fecha_nac(Fecha4(vistaFichIngreso.getDtcFechNac()));
        famModelDb.setParentescoFam(vistaFichIngreso.getCbxParent().getSelectedItem().toString());

        if (famModelDb.actualizarPerAcomp()) {
            if (famModelDb.actuFamlyAcomp()) {
                JOptionPane.showMessageDialog(null, "Datos actualizados correctamente");
                vistaFichIngreso.getDlgEditarAcomp().setVisible(false);
                listFamAcompDlg();
                listFamAcomp();
            }
        } else {
            JOptionPane.showMessageDialog(null, "Error al actualizar Datos.");
        }
    }

    public void BuscarAcompFaml() {
        DefaultTableModel tb = (DefaultTableModel) vistaFichIngreso.getTblAcomp().getModel();
        int a = vistaFichIngreso.getTblAcomp().getRowCount() - 1;
        for (int i = a; i >= 0; i--) {
            tb.removeRow(tb.getRowCount() - 1);
        }
        modeloTabHijos = (DefaultTableModel) vistaFichIngreso.getTblAcomp().getModel();
        List<Familiars> lista;
        try {
            lista = famModelDb.AcompFamilBuscar(vistaFichIngreso.getTxtDlgBusar().getText());
            int columnas = modeloTabHijos.getColumnCount();
            for (int i = 0; i < lista.size(); i++) {
                modeloTabHijos.addRow(new Object[columnas]);
                vistaFichIngreso.getTblAcomp().setValueAt(lista.get(i).getFamiliares_id(), i, 0);
                vistaFichIngreso.getTblAcomp().setValueAt(lista.get(i).getPersona_cedula(), i, 1);
                vistaFichIngreso.getTblAcomp().setValueAt(lista.get(i).getPersona_nombre(), i, 2);
                vistaFichIngreso.getTblAcomp().setValueAt(lista.get(i).getPersona_apellido(), i, 3);
                vistaFichIngreso.getTblAcomp().setValueAt(lista.get(i).getPersona_fecha_nac(), i, 4);
                vistaFichIngreso.getTblAcomp().setValueAt(lista.get(i).getEdad(), i, 5);
                vistaFichIngreso.getTblAcomp().setValueAt(lista.get(i).getParentescoFam(), i, 6);
            }
        } catch (Exception ex) {
            Logger.getLogger(ControladorFichaIngreso.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void elimiAcomHijo() {
        int fsel = vistaFichIngreso.getTblAcomp1().getSelectedRow();
        if (fsel == -1) {
            JOptionPane.showMessageDialog(null, "Seleccione una fila para eliminar ó Actualiza la lista.", "Verificación", JOptionPane.WARNING_MESSAGE);
        } else {
            int desicion = JOptionPane.showConfirmDialog(null, "Esta seguro de que desea Borrar este Registro?");
            if (desicion == JOptionPane.YES_OPTION) {
                DefaultTableModel modeloTabla = (DefaultTableModel) vistaFichIngreso.getTblAcomp1().getModel();
                String cod = modeloTabla.getValueAt(vistaFichIngreso.getTblAcomp1().getSelectedRow(), 0).toString();
                hijoModelDB.setHijo_codigo(Integer.parseInt(cod));
                if (hijoModelDB.eliminarHijos()) {
                    JOptionPane.showMessageDialog(null, "Dato borrado correctamente");
                    listFamAcompHijDlg();
                } else {
                    JOptionPane.showMessageDialog(null, "Dato no borrado");
                }
            }
        }
    }

    private void elimiFamAcomp() {
        int fsel = vistaFichIngreso.getTblAcomp().getSelectedRow();
        if (fsel == -1) {
            JOptionPane.showMessageDialog(null, "Seleccione una fila para eliminar ó Actualiza la lista.", "Verificación", JOptionPane.WARNING_MESSAGE);
        } else {
            int desicion = JOptionPane.showConfirmDialog(null, "Esta seguro de que desea Borrar este Registro?");
            if (desicion == JOptionPane.YES_OPTION) {
                DefaultTableModel modeloTabla = (DefaultTableModel) vistaFichIngreso.getTblAcomp().getModel();
                String cod = modeloTabla.getValueAt(vistaFichIngreso.getTblAcomp().getSelectedRow(), 0).toString();
                famModelDb.setFamiliares_id(Integer.parseInt(cod));
                if (famModelDb.eliminarFamAcom()) {
                    JOptionPane.showMessageDialog(null, "Dato borrado correctamente");
                    listFamAcompDlg();
                } else {
                    JOptionPane.showMessageDialog(null, "Dato no borrado");
                }
            }
        }
    }

    public KeyListener enterllenar() { // al hacer un enter realizar una acción 
        KeyListener kn = new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
            }

            @Override
            public void keyPressed(KeyEvent e) {
                victimaDB vDB = new victimaDB();
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    vistaFichIngreso.getTxtCedula().setCursor(new Cursor(WAIT_CURSOR));
                    vistaFichIngreso.getTxtNombresApellidos().setCursor(new Cursor(WAIT_CURSOR));
                    if (!vistaFichIngreso.getTxtCodigo().getText().equals("")) {
                        listFamAcomp();
                        int cod = modelIngreDB.ingreId(Integer.parseInt(vistaFichIngreso.getTxtCodigo().getText()));
                        if (cod != 0) {
                            vistaFichIngreso.getLblCodigoArtEntFund().setText(Integer.toString(cod));
                            vistaFichIngreso.getLblCodigoEntBenef().setText(Integer.toString(cod));
                            cargarListaArtBenef();
                            cargarListaArt();
                        } else {
                            vistaFichIngreso.getBtnAgregarArticulosVictima().setEnabled(false);
                            vistaFichIngreso.getBtnAgregarArticulosFundacion().setEnabled(false);
                        }
                    }
                    vistaFichIngreso.getTxtNombresApellidos().setCursor(new Cursor(DEFAULT_CURSOR));
                    vistaFichIngreso.getTxtCedula().setCursor(new Cursor(DEFAULT_CURSOR));
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {
            }
        };
        return kn;
    }
}
