package marylove.controlador;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JDialog;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPopupMenu;
import javax.swing.JSpinner;
import javax.swing.table.DefaultTableModel;
import marylove.DBmodelo.ArticulosEntregadosDB;
import marylove.DBmodelo.ArticulosEntregadosPersonalDB;
import marylove.DBmodelo.HijosDB;
import marylove.DBmodelo.IngresoDB;
import static marylove.controlador.C_Login.personal_cod;
import marylove.models.ArticulosEntregados;
import marylove.models.ArticulosEntregadosPersonal;
import marylove.models.Hijos;
import marylove.models.Ingreso;
import marylove.vista.FichaIngreso;
import marylove.vista.FormaAgregarArticulosPersonal;
import marylove.vista.FormaAgregarArticulosVictima;
import marylove.vista.FormaAgregarHijos;
import marylove.vista.V_Login;
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

    HijosDB hijoModelDB = new HijosDB();
    V_Login vistaLogin = new V_Login();

    DefaultTableModel modeloTab;
    DefaultTableModel modeloTabPers;
    DefaultTableModel modeloTabHijos;

    public ControladorFichaIngreso(FormaAgregarArticulosVictima vistaAgreArtBenef, ArticulosEntregados artiEntModel, ArticulosEntregadosDB artEntModelDB, ArticulosEntregadosPersonal artEntPerModel, ArticulosEntregadosPersonalDB artEntPerModelDB, FichaIngreso vistaFichIngreso, FormaAgregarArticulosPersonal vistaAgreArt, IngresoDB modelIngreDB, FormaAgregarHijos vistFormHij) throws ParseException {
        this.vistaAgreArtBenef = vistaAgreArtBenef;
        this.artiEntModel = artiEntModel;
        this.artEntModelDB = artEntModelDB;
        this.artEntPerModel = artEntPerModel;
        this.artEntPerModelDB = artEntPerModelDB;
        this.vistaFichIngreso = vistaFichIngreso;
        this.vistaAgreArt = vistaAgreArt;
        this.modelIngreDB = modelIngreDB;
        this.vistFormHij = vistFormHij;
    }

    public void inciarCtrlFichIngreso() {
        //AbrirVentanFichIng();

        botonesInavilitado();
        controlTxtArea();
        fechaSistemaIni();
        cargarRegstros();
        inicializaPopTables();

        vistaFichIngreso.getBtnDlgActualizar().addActionListener(e -> listarArtEntEditCargarDlg());
        vistaFichIngreso.getBtnRefresHijos().addActionListener(e -> listarHijosEditCargar());
        vistaFichIngreso.getBtnRefreshArtEntBenef().addActionListener(e -> listarArtEntBenefEditCargarDlg());
        vistaFichIngreso.getBtnRefreshDorRef().addActionListener(e -> listarDormiRefEditCargar());

        vistaFichIngreso.getBtnBuscar().addActionListener(e -> realizarBusquedas());
        vistaFichIngreso.getTxtCedula().addKeyListener(enter1(vistaFichIngreso.getTxtCedula(), vistaFichIngreso.getTxtNombresApellidos(), vistaFichIngreso.getTxtCodigo()));

        vistaFichIngreso.getBtnAgregarArticulosVictima().addActionListener(e -> AbrirVentBenef());
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
        vistaAgreArtBenef.getBtnCancelar().addActionListener(e -> cancelarBenef());
//        vistaAgreArt.getBtnEditar().addActionListener(e -> EditarArtEntBtn());
        vistaAgreArtBenef.getBtnEditar().addActionListener(e -> EditarBtnArtBenfDg());

        vistaFichIngreso.getBtnAgregarArticulosFundacion().addActionListener(e -> AbrirVentArtPers());

        vistaAgreArt.getBtnCancelar().addActionListener(e -> cancelarPers());
        vistaAgreArt.getBtnEditarPers().addActionListener(e -> EditarArtEntBtn());

        vistaFichIngreso.getBtnIngresarHij().addActionListener(e -> abrirVentanHijos());

        vistaFichIngreso.getBtnVerRegistros().addActionListener(e -> AbrirVerRegistros());
        vistaFichIngreso.getBtnEdit().addActionListener(e -> BtnEdiDorRef());
        vistaFichIngreso.getBtnCancelarEdit().addActionListener(e -> CancelarDlg(vistaFichIngreso.getDlgEditar()));

        vistaFichIngreso.getBtnActualizar().addActionListener((ActionEvent e) -> {
            if (vistaFichIngreso.getTxtCodigo().getText().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Debe Ingresar Cédula", "Error", JOptionPane.ERROR_MESSAGE);
            } else {
                actualizar();
            }
        });
        
        vistaFichIngreso.getBtnNuevo().addActionListener(e-> NuevoRegCleanAll());
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
        DefaultTableModel tblArtBen = (DefaultTableModel) vistaFichIngreso.getTblArticulosBeneficiaria().getModel();
        DefaultTableModel tblArt = (DefaultTableModel) vistaFichIngreso.getTblArticulosFundacion().getModel();
        DefaultTableModel tblHij = (DefaultTableModel) vistaFichIngreso.getTblHijos().getModel();
        tblArtBen.setRowCount(0);
        tblArt.setRowCount(0);
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
        popTableHijosPerIng();

    }

    public void cargarRegstros() {
        listarArtEntBenefEditCargarDlg();
        listarArtEntEditCargarDlg();
        listarDormiRefEditCargar();
        listarHijosEditCargar();
    }

    public void actualizar() {
        cargarListaArtBenef();
        cargarListaArt();
        listarHijos();
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
        vistaFichIngreso.getDlgRegistro().setSize(1200, 600);
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
            String observ = modeloTabla.getValueAt(vistaFichIngreso.getTblArticulosBeneficiaria().getSelectedRow(), 2).toString();
            String cantidad = modeloTabla.getValueAt(vistaFichIngreso.getTblArticulosBeneficiaria().getSelectedRow(), 3).toString();

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
            vistaFichIngreso.getLblCant().setText("Cargados: " + lista.size() + " registros");
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
                    JOptionPane.showMessageDialog(null, "Datos Insertados Correctamente");
//                    vistaFichIngreso.getBtnAgregarArticulosFundacion().setEnabled(true);
//                    vistaFichIngreso.getBtnAgregarArticulosVictima().setEnabled(false);
                    vistaFichIngreso.getBtnGuardar().setEnabled(false);
                    vistaAgreArt.setVisible(false);
                    cargarListaArt();
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
                    JOptionPane.showMessageDialog(null, "Datos Insertados Correctamente");
                    vistaAgreArtBenef.setVisible(false);
                    cargarListaArtBenef();
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
            vistaFichIngreso.getLblCant1().setText("Cargados: " + lista.size() + " registros");

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

        });
        pM.add(itemEdit);
        pM.add(itemEli);
        vistaFichIngreso.getTblArticulosFundacion().setComponentPopupMenu(pM);
    }

    public void popTableHijosPerIng() {
        JPopupMenu pM = new JPopupMenu();
        JMenuItem itemEdit = new JMenuItem("EDITAR");
        JMenuItem itemElim = new JMenuItem("ELIMINAR");
        itemEdit.addActionListener((ActionEvent e) -> {
            EditarHijAcomp();
        });
        itemElim.addActionListener((ActionEvent e) -> {
            eliminarHijoAcompa();
        });
        pM.add(itemEdit);
        pM.add(itemElim);
        vistaFichIngreso.getTblHijos1().setComponentPopupMenu(pM);

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
            vistaFichIngreso.getLblCant1().setText("Cargados: " + lista.size() + " registros");

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
            String observ = modeloTabla.getValueAt(vistaFichIngreso.getTblArticulosFundacion().getSelectedRow(), 2).toString();
            String cantidad = modeloTabla.getValueAt(vistaFichIngreso.getTblArticulosFundacion().getSelectedRow(), 3).toString();

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
                    modelIngreDB.setVictima_codigo(Integer.parseInt(vistaFichIngreso.getTxtCodigo().getText()));
//                modelIngreDB.setPersonal_codigo(persModelDB.obtenerCodIn(vistaLogin.getTxtUsuario().getText(), vistaLogin.getPswContra().getText()));
                    modelIngreDB.setPersonal_codigo(modelIngreDB.verifiUserP(personal_cod));
                    modelIngreDB.setAsignacion_dormitorio(vistaFichIngreso.getTxtDormitorio().getText());
                    modelIngreDB.setReferidapor(vistaFichIngreso.getTxaReferida().getText());
                    modelIngreDB.setIngreso_fecha(vistaFichIngreso.getJdcFecha().getDate());
                    if (modelIngreDB.IngresarDormitorioReferido()) {
                        vistaFichIngreso.getLblCodigoIngreso().setText(Integer.toString(modelIngreDB.maxId()));
                        vistaFichIngreso.getLblCodigoEntBenef().setText(Integer.toString(modelIngreDB.maxId()));
                        vistaFichIngreso.getLblCodigoArtEntFund().setText(Integer.toString(modelIngreDB.maxId()));
                        vistaFichIngreso.getLblCodHijoa().setText(Integer.toString(modelIngreDB.maxId()));

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

    public void abrirVentanHijos() {
        vistFormHij.setVisible(true);
        vistFormHij.setLocationRelativeTo(null);
    }

    public void listarHijos() {
        DefaultTableModel tb = (DefaultTableModel) vistaFichIngreso.getTblHijos().getModel();
        int a = vistaFichIngreso.getTblHijos().getRowCount() - 1;
        for (int i = a; i >= 0; i--) {
            tb.removeRow(tb.getRowCount() - 1);
        }

        modeloTabHijos = (DefaultTableModel) vistaFichIngreso.getTblHijos().getModel();
        List<Hijos> lista;

        try {
            lista = hijoModelDB.listarHijos();
//            lista = artEntModelDB.listartEnt(Integer.parseInt(vistaFichIngreso.getTxtCodigo().getText()));
            int columnas = modeloTabHijos.getColumnCount();
            for (int i = 0; i < lista.size(); i++) {
                modeloTabHijos.addRow(new Object[columnas]);
                vistaFichIngreso.getTblHijos().setValueAt(lista.get(i).getHijo_codigo(), i, 0);
                vistaFichIngreso.getTblHijos().setValueAt(lista.get(i).getPersona_nombre() + " " + lista.get(i).getPersona_apellido(), i, 1);
                vistaFichIngreso.getTblHijos().setValueAt(lista.get(i).getPersona_fecha_nac(), i, 2);
                //falta parentesco

            }
            vistaFichIngreso.getLblCant1().setText("Cargados: " + lista.size() + " registros");

        } catch (Exception ex) {
            Logger.getLogger(ControladorFichaIngreso.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void BuscarHijos() {
        DefaultTableModel modeloTabEdit = null;
        DefaultTableModel tb = (DefaultTableModel) vistaFichIngreso.getTblHijos1().getModel();
        int a = vistaFichIngreso.getTblHijos1().getRowCount() - 1;
        for (int i = a; i >= 0; i--) {
            tb.removeRow(tb.getRowCount() - 1);
        }

        modeloTabEdit = (DefaultTableModel) vistaFichIngreso.getTblHijos1().getModel();
        List<Hijos> lista;
        try {
            lista = hijoModelDB.BuscarHijos(vistaFichIngreso.getTxtDlgBusar().getText());
            int columnas = modeloTabEdit.getColumnCount();
            for (int i = 0; i < lista.size(); i++) {
                modeloTabEdit.addRow(new Object[columnas]);
                vistaFichIngreso.getTblHijos1().setValueAt(lista.get(i).getHijo_codigo(), i, 0);
                vistaFichIngreso.getTblHijos1().setValueAt(lista.get(i).getPersona_cedula(), i, 1);
                vistaFichIngreso.getTblHijos1().setValueAt(lista.get(i).getPersona_nombre() + " " + lista.get(i).getPersona_apellido(), i, 2);
                vistaFichIngreso.getTblHijos1().setValueAt(lista.get(i).getPersona_fecha_nac(), i, 3);
                vistaFichIngreso.getTblHijos1().setValueAt(lista.get(i).getEdad(), i, 4);
                //falta parentesco
            }
            if (vistaFichIngreso.getTxtDlgBusar().getText().length() == 0) {
                listarHijosEditCargar();
            }

        } catch (Exception ex) {
            Logger.getLogger(ControladorFichaIngreso.class.getName()).log(Level.SEVERE, null, ex);
        }
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
            vistaFichIngreso.getLblCant1().setText("Cargados: " + lista.size() + " registros");

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
            vistaFichIngreso.getLblCant1().setText("Cargados: " + lista.size() + " registros");

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
        BuscarHijos();
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

    private void eliminarHijoAcompa() {
        int fsel = vistaFichIngreso.getTblHijos1().getSelectedRow();
        if (fsel == -1) {
            JOptionPane.showMessageDialog(null, "Seleccione una fila para eliminar ó Actualiza la lista.", "Verificación", JOptionPane.WARNING_MESSAGE);
        } else {
            int desicion = JOptionPane.showConfirmDialog(null, "Esta seguro de que desea Borrar este Registro?");
            if (desicion == JOptionPane.YES_OPTION) {
                DefaultTableModel modeloTabla = (DefaultTableModel) vistaFichIngreso.getTblHijos1().getModel();
                String cod = modeloTabla.getValueAt(vistaFichIngreso.getTblHijos1().getSelectedRow(), 0).toString();
                hijoModelDB.setHijo_codigo(Integer.parseInt(cod));
                if (hijoModelDB.eliminarHijos()) {
                    JOptionPane.showMessageDialog(null, "Dato borrado correctamente");
                    listarHijos();
                } else {
                    JOptionPane.showMessageDialog(null, "Dato no borrado");
                }
            }

        }///puesto
        //puesto
    }

    ///////////////////Editar ///////////////////////////Editar /////////////////
    public void AbrVenEditDorRef() {
        vistaFichIngreso.getDlgEditar().setVisible(true);
        vistaFichIngreso.getDlgEditar().setSize(800, 300);
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
    public void listarHijosEditCargar() {
        DefaultTableModel tb = (DefaultTableModel) vistaFichIngreso.getTblHijos1().getModel();
        int a = vistaFichIngreso.getTblHijos1().getRowCount() - 1;
        for (int i = a; i >= 0; i--) {
            tb.removeRow(tb.getRowCount() - 1);
        }

        DefaultTableModel modeloTabHijosEC = (DefaultTableModel) vistaFichIngreso.getTblHijos1().getModel();
        List<Hijos> lista;

        try {
            lista = hijoModelDB.listarHijos();
            int columnas = modeloTabHijosEC.getColumnCount();
            for (int i = 0; i < lista.size(); i++) {
                modeloTabHijosEC.addRow(new Object[columnas]);
                vistaFichIngreso.getTblHijos1().setValueAt(lista.get(i).getHijo_codigo(), i, 0);
                vistaFichIngreso.getTblHijos1().setValueAt(lista.get(i).getPersona_nombre(), i, 1);
                vistaFichIngreso.getTblHijos1().setValueAt(lista.get(i).getPersona_apellido(), i, 2);
                vistaFichIngreso.getTblHijos1().setValueAt(lista.get(i).getPersona_cedula(), i, 3);
                vistaFichIngreso.getTblHijos1().setValueAt(lista.get(i).getPersona_fecha_nac(), i, 4);
                vistaFichIngreso.getTblHijos1().setValueAt(lista.get(i).getEdad(), i, 5);
                //falta parentesco
                vistaFichIngreso.getTblHijos1().setValueAt(lista.get(i).getPersona_sexo(), i, 7);
                //institucion educativa
                vistaFichIngreso.getTblHijos1().setValueAt(lista.get(i).getPersona_nivel_acad(), i, 8);
                vistaFichIngreso.getTblHijos1().setValueAt(lista.get(i).getHijo_anioescolar(), i, 9);

            }
            vistaFichIngreso.getLblCant1().setText("Cargados: " + lista.size() + " registros");

        } catch (Exception ex) {
            Logger.getLogger(ControladorFichaIngreso.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void EditarHijAcomp() {
        DefaultTableModel modeloTabla = (DefaultTableModel) vistaFichIngreso.getTblHijos1().getModel();
        int fsel = vistaFichIngreso.getTblHijos1().getSelectedRow();
        if (fsel == -1) {
            JOptionPane.showMessageDialog(null, "Seleccione una fila ó Actualize lista", "Verificación", JOptionPane.WARNING_MESSAGE);
        } else {
            String cod = modeloTabla.getValueAt(vistaFichIngreso.getTblHijos1().getSelectedRow(), 0).toString();
            String dor = modeloTabla.getValueAt(vistaFichIngreso.getTblHijos1().getSelectedRow(), 3).toString();
            String ref = modeloTabla.getValueAt(vistaFichIngreso.getTblHijos1().getSelectedRow(), 4).toString();

            vistaFichIngreso.getLblCodEdit().setText(cod);
            vistaFichIngreso.getTxtDormiEdit().setText(dor);
            vistaFichIngreso.getTxaReferidaEdit().setText(ref);
            AbrVenEditDorRef();
            vistaFichIngreso.setTitle("Editar Dormitorio Referencia");
        }
    }
    
    
}
