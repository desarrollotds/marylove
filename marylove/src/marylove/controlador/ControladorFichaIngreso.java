package marylove.controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
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

public class ControladorFichaIngreso extends Validaciones {

    private final FormaAgregarArticulosVictima vistaAgreArt;
    private final ArticulosEntregados artiEntModel;
    private final ArticulosEntregadosDB artEntModelDB;
    private final ArticulosEntregadosPersonal artEntPerModel;
    private final ArticulosEntregadosPersonalDB artEntPerModelDB;
    private final FichaIngreso vistaFichIngreso;
    private final FormaAgregarArticulosPersonal vistaAgreArtPers;
    private final IngresoDB modelIngreDB;
    private final FormaAgregarHijos vistFormHij;

    HijosDB hijoModelDB = new HijosDB();
    V_Login vistaLogin = new V_Login();

    DefaultTableModel modeloTab;
    DefaultTableModel modeloTabPers;
    DefaultTableModel modeloTabHijos;

    public ControladorFichaIngreso(FormaAgregarArticulosVictima vistaAgreArt, ArticulosEntregados artiEntModel, ArticulosEntregadosDB artEntModelDB, ArticulosEntregadosPersonal artEntPerModel, ArticulosEntregadosPersonalDB artEntPerModelDB, FichaIngreso vistaFichIngreso, FormaAgregarArticulosPersonal vistaAgreArtPers, IngresoDB modelIngreDB, FormaAgregarHijos vistFormHij) throws Exception {
        this.vistaAgreArt = vistaAgreArt;
        this.artiEntModel = artiEntModel;
        this.artEntModelDB = artEntModelDB;
        this.artEntPerModel = artEntPerModel;
        this.artEntPerModelDB = artEntPerModelDB;
        this.vistaFichIngreso = vistaFichIngreso;
        this.vistaAgreArtPers = vistaAgreArtPers;
        this.modelIngreDB = modelIngreDB;
        this.vistFormHij = vistFormHij;
    }

    public void inciarCtrlFichIngreso() {
        AbrirVentanFichIng();
        realizarBusquedas();
        botonesInavilitado();
        controlTxtArea();
        fechaSistemaIni();
        actualizarDlgTbl();
        inicializaPopTables();
        realizarBusquedas();

        vistaFichIngreso.getTxtCedula().addKeyListener(enter1(vistaFichIngreso.getTxtCedula(), vistaFichIngreso.getTxtNombresApellidos(), vistaFichIngreso.getTxtCodigo()));

        vistaFichIngreso.getBtnAgregarArticulosVictima().addActionListener(e -> AbrirVentArtBenef());
        vistaAgreArt.getBtnGuardar().addActionListener(e -> {
            try {
                InsertarArticulosBenef();
            } catch (SQLException ex) {
                Logger.getLogger(ControladorFichaIngreso.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
        vistaAgreArtPers.getBtnGuardar().addActionListener(e -> {
            try {
                InsertarArticulosPers();
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
        vistaAgreArt.getBtnCancelar().addActionListener(e -> cancelarBenef());
        vistaAgreArt.getBtnEditar().addActionListener(e -> EditarBtn());

        vistaFichIngreso.getBtnAgregarArticulosFundacion().addActionListener(e -> AbrirVentArtPers());
        
        vistaAgreArtPers.getBtnCancelar().addActionListener(e -> cancelarPers());
        vistaAgreArtPers.getBtnEditarPers().addActionListener(e -> EditarBtnPers());

        vistaFichIngreso.getBtnIngresarHij().addActionListener(e -> abrirVentanHijos());
        
        vistaFichIngreso.getBtnDlgActualizar().addActionListener(e -> actualizarDlgTbl());
        vistaFichIngreso.getBtnVerRegistros().addActionListener(e -> AbrirVerRegistros());

        vistaFichIngreso.getBtnActualizar().addActionListener((ActionEvent e) -> {
            if (vistaFichIngreso.getTxtCodigo().getText().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Debe Ingresar Cédula", "Error", JOptionPane.ERROR_MESSAGE);
            } else {
                actualizar();
            }
        });

    }

    public void actualizar() {
        cargarListaArt();
        cargarListaArtPers();
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
        vistaAgreArt.getSpnCantidad().addKeyListener(validarNumJsp(vistaAgreArt.getSpnCantidad()));
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

    public void AbrirVentArtBenef() {
        vistaAgreArt.setVisible(true);
        vistaAgreArt.setLocationRelativeTo(null);
        vistaAgreArt.getTxtArticulo().setText("");
        vistaAgreArt.getTxtObsrvaciones().setText("");
        vistaAgreArt.getSpnCantidad().setValue(0);
        vistaAgreArt.getBtnEditar().setEnabled(false);
        vistaAgreArt.getBtnGuardar().setEnabled(true);

    }

    public void AbrirVentArtBenef2() {
        vistaAgreArt.setVisible(true);
        vistaAgreArt.setLocationRelativeTo(null);
        vistaAgreArt.getBtnGuardar().setEnabled(false);
    }

    public void AbrirVerRegistros() {
        vistaFichIngreso.getDlgRegistro().setVisible(true);
        vistaFichIngreso.getDlgRegistro().setSize(1200, 600);
        vistaFichIngreso.getDlgRegistro().setLocationRelativeTo(null);
    }

    public void cancelarBenef() {
        vistaAgreArt.getTxtArticulo().setText("");
        vistaAgreArt.getTxtObsrvaciones().setText("");
        vistaAgreArt.getSpnCantidad().setValue(0);
        vistaAgreArt.setVisible(false);
    }

    public void popTable() {
        JPopupMenu pM = new JPopupMenu();
        JMenuItem itemEdit = new JMenuItem("EDITAR");
        JMenuItem itemElim = new JMenuItem("BORRAR");
        itemEdit.addActionListener((ActionEvent e) -> {
            Editar();
        });
        itemElim.addActionListener((ActionEvent e) -> {
            
        });
        pM.add(itemEdit);
        pM.add(itemElim);
        vistaFichIngreso.getTblArticulosBeneficiaria().setComponentPopupMenu(pM);
    }

    public void Editar() {
        DefaultTableModel modeloTabla = (DefaultTableModel) vistaFichIngreso.getTblArticulosBeneficiaria().getModel();
        int fsel = vistaFichIngreso.getTblArticulosBeneficiaria().getSelectedRow();
        if (fsel == -1) {
            JOptionPane.showMessageDialog(null, "Seleccione una fila ó Actualize lista", "Verificación", JOptionPane.WARNING_MESSAGE);
        } else {
            String cod = modeloTabla.getValueAt(vistaFichIngreso.getTblArticulosBeneficiaria().getSelectedRow(), 0).toString();
            String nombreArt = modeloTabla.getValueAt(vistaFichIngreso.getTblArticulosBeneficiaria().getSelectedRow(), 1).toString();
            String observ = modeloTabla.getValueAt(vistaFichIngreso.getTblArticulosBeneficiaria().getSelectedRow(), 2).toString();
            String cantidad = modeloTabla.getValueAt(vistaFichIngreso.getTblArticulosBeneficiaria().getSelectedRow(), 3).toString();

            vistaAgreArt.getLblCodVic().setText(cod);
            vistaAgreArt.getTxtArticulo().setText(nombreArt);
            vistaAgreArt.getTxtObsrvaciones().setText(observ);
            vistaAgreArt.getSpnCantidad().setValue(Integer.parseInt(cantidad));

            vistaAgreArt.setTitle("Editar Arítuculos Entregados");
            AbrirVentArtBenef2();
            vistaAgreArt.getBtnEditar().setEnabled(true);
            vistaAgreArt.getBtnGuardar().setEnabled(false);

        }
    }

    public void controlTxtArea() {
        controlArea(vistaFichIngreso.getTxaReferida());
    }

    public void EditarBtn() {
        artEntModelDB.setArticulo_id(Integer.parseInt(vistaAgreArt.getLblCodVic().getText()));
        artEntModelDB.setArticulo_descripcion(vistaAgreArt.getTxtArticulo().getText());
        artEntModelDB.setArticulo_observaciones(vistaAgreArt.getTxtObsrvaciones().getText());
        artEntModelDB.setArticulo_cantidad(Integer.parseInt(vistaAgreArt.getSpnCantidad().getValue().toString()));

        if (artEntModelDB.actualizarEditArtEnt()) {
            JOptionPane.showMessageDialog(null, "Datos actualizados correctamente");
            vistaAgreArt.setVisible(false);
            cargarListaArt();
        } else {
            JOptionPane.showMessageDialog(null, "Error al actualizar Datos.");

        }
    }

    public void InsertarArticulosBenef() throws SQLException {
        if (vistaAgreArt.getTxtArticulo().getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Campos Vacios", "Ingrese Valores", JOptionPane.WARNING_MESSAGE);
        } else {
            if (vistaAgreArt.getTxtObsrvaciones().getText().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Campos Vacios", "Ingrese Valores", JOptionPane.WARNING_MESSAGE);
            } else {
                artEntModelDB.setIngreso_id(Integer.parseInt(vistaFichIngreso.getLblCodigoEntBenef().getText()));
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

    private void cargarListaArt() {
        int canFilas = vistaFichIngreso.getTblArticulosBeneficiaria().getRowCount();
        for (int i = canFilas - 1; i >= 0; i--) {
            if (i > 0) {
                modeloTab.removeRow(i);
            }
        }

        modeloTab = (DefaultTableModel) vistaFichIngreso.getTblArticulosBeneficiaria().getModel();
        List<ArticulosEntregados> lista;

        try {
            lista = artEntModelDB.listartEnt(Integer.parseInt(vistaFichIngreso.getTxtCodigo().getText()));
            int columnas = modeloTab.getColumnCount();
            for (int i = 0; i < lista.size(); i++) {
                modeloTab.addRow(new Object[columnas]);
                vistaFichIngreso.getTblArticulosBeneficiaria().setValueAt(lista.get(i).getArticulo_id(), i, 0);
                vistaFichIngreso.getTblArticulosBeneficiaria().setValueAt(lista.get(i).getArticulo_descripcion(), i, 1);
                vistaFichIngreso.getTblArticulosBeneficiaria().setValueAt(lista.get(i).getArticulo_observaciones(), i, 2);
                vistaFichIngreso.getTblArticulosBeneficiaria().setValueAt(lista.get(i).getArticulo_cantidad(), i, 3);

            }
            vistaFichIngreso.getLblCant().setText("Cargados: " + lista.size() + " registros");

        } catch (SQLException ex) {
            Logger.getLogger(ControladorFichaIngreso.class
                    .getName()).log(Level.SEVERE, null, ex);
        }

    }

    ////////////////////////////////////////////
    public void AbrirVentArtPers() {
        vistaAgreArtPers.setVisible(true);
        vistaAgreArtPers.setLocationRelativeTo(null);
        vistaAgreArtPers.getTxtArticulo().setText("");
        vistaAgreArtPers.getTxtObsrvaciones().setText("");
        vistaAgreArtPers.getSpnCantidad().setValue(0);
        vistaAgreArtPers.getBtnEditarPers().setEnabled(false);
        vistaAgreArtPers.getBtnGuardar().setEnabled(true);
    }

    public void AbrirVentArtPers2() {
        vistaAgreArtPers.setVisible(true);
        vistaAgreArtPers.setLocationRelativeTo(null);
        vistaAgreArtPers.getBtnGuardar().setEnabled(false);
    }

    public void cancelarPers() {
        vistaAgreArtPers.getTxtArticulo().setText("");
        vistaAgreArtPers.getTxtObsrvaciones().setText("");
        vistaAgreArtPers.getSpnCantidad().setValue(0);
        vistaAgreArtPers.setVisible(false);
    }

    public void InsertarArticulosPers() throws SQLException {
        if (vistaAgreArtPers.getTxtArticulo().getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Campos Vacios", "Ingrese Valores", JOptionPane.WARNING_MESSAGE);
        } else {
            if (vistaAgreArtPers.getTxtObsrvaciones().getText().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Campos Vacios", "Ingrese Valores", JOptionPane.WARNING_MESSAGE);
            } else {
                artEntPerModelDB.setIngreso_id(Integer.parseInt(vistaFichIngreso.getLblCodigoArtEntFund().getText()));
                artEntPerModelDB.setArtentper_nombre(vistaAgreArtPers.getTxtArticulo().getText());
                artEntPerModelDB.setArtentper_observaciones(vistaAgreArtPers.getTxtObsrvaciones().getText());
                artEntPerModelDB.setArticulo_cantidad(Integer.parseInt(vistaAgreArtPers.getSpnCantidad().getValue().toString()));

                if (artEntPerModelDB.InsertarArtEntrPers()) {
                    JOptionPane.showMessageDialog(null, "Datos Insertados Correctamente");
                    vistaAgreArtPers.setVisible(false);
                    cargarListaArtPers();
                    vistaFichIngreso.getBtnGuardar().setEnabled(true);
                    //botonesInavilitado();
                } else {
                    JOptionPane.showMessageDialog(null, "Error al Ingresar Datos");
                }
            }
        }
    }

    private void cargarListaArtPers() {
        int canFilas = vistaFichIngreso.getTblArticulosFundacion().getRowCount();
//        System.out.println("cantidad de filas "+canFilas);
//        for (int i = canFilas - 1; i >= 0; i--) {
//            if (i >= 0) {
//                System.out.println("i: "+i);
//                modeloTab.removeRow(i);
//            }
//        }
        DefaultTableModel tb = (DefaultTableModel) vistaFichIngreso.getTblArticulosFundacion().getModel();
        int a = vistaFichIngreso.getTblArticulosFundacion().getRowCount() - 1;

        for (int i = a; i >= 0; i--) {
            tb.removeRow(tb.getRowCount() - 1);
        }

        modeloTabPers = (DefaultTableModel) vistaFichIngreso.getTblArticulosFundacion().getModel();
        List<ArticulosEntregadosPersonal> lista;

        try {
            lista = artEntPerModelDB.listartEntPers(Integer.parseInt(vistaFichIngreso.getTxtCodigo().getText()));
            int columnas = modeloTabPers.getColumnCount();
            for (int i = 0; i < lista.size(); i++) {
                modeloTabPers.addRow(new Object[columnas]);
                vistaFichIngreso.getTblArticulosFundacion().setValueAt(lista.get(i).getArtentper_id(), i, 0);
                vistaFichIngreso.getTblArticulosFundacion().setValueAt(lista.get(i).getArtentper_nombre(), i, 1);
                vistaFichIngreso.getTblArticulosFundacion().setValueAt(lista.get(i).getArtentper_observaciones(), i, 2);
                vistaFichIngreso.getTblArticulosFundacion().setValueAt(lista.get(i).getArticulo_cantidad(), i, 3);

            }
            vistaFichIngreso.getLblCant1().setText("Cargados: " + lista.size() + " registros");

        } catch (SQLException ex) {
            Logger.getLogger(ControladorFichaIngreso.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    
    public void inicializaPopTables(){
        popTable();
        popTableArtEntBenef();
        popTableDormRef();
        popTableEntFund();
        popTableHijosPerIng();
        popTablePer();
    }

    public void popTablePer() {
        JPopupMenu pM = new JPopupMenu();
        JMenuItem itemEdit = new JMenuItem("EDITAR");
        JMenuItem itemEli = new JMenuItem("ELIMINAR");
        itemEdit.addActionListener((ActionEvent e) -> {
            EditarPers();
        });
        itemEli.addActionListener((ActionEvent e) -> {
            
        });
        pM.add(itemEdit);
        pM.add(itemEli);
        vistaFichIngreso.getTblArticulosFundacion().setComponentPopupMenu(pM);
    }

    public void popTableDormRef() {
        JPopupMenu pM = new JPopupMenu();
        JMenuItem itemEdit = new JMenuItem("EDITAR");
        JMenuItem itemElim = new JMenuItem("ELIMINAR");
        itemEdit.addActionListener((ActionEvent e) -> {
            EditarPers();
        });
        
        itemElim.addActionListener((ActionEvent e) -> {
            eliminarDormit();
        });
        pM.add(itemEdit);
        pM.add(itemElim);
        vistaFichIngreso.getTblDorRef().setComponentPopupMenu(pM);
    }

    public void popTableArtEntBenef() {
        JPopupMenu pM = new JPopupMenu();
        JMenuItem itemEdit = new JMenuItem("EDITAR");
        JMenuItem itemElim = new JMenuItem("ELIMINAR");
        itemEdit.addActionListener((ActionEvent e) -> {
            EditarPers();
        });
        itemElim.addActionListener((ActionEvent e) -> {
            eliminarArtEntBen();
        });
        pM.add(itemEdit);
        pM.add(itemElim);
        vistaFichIngreso.getTblArticulosBeneficiaria1().setComponentPopupMenu(pM);
    }

    public void popTableEntFund() {
        JPopupMenu pM = new JPopupMenu();
        JMenuItem itemEdit = new JMenuItem("EDITAR");
        JMenuItem itemElim = new JMenuItem("ELIMINAR");
        itemEdit.addActionListener((ActionEvent e) -> {
            EditarPers();
        });
        itemElim.addActionListener((ActionEvent e) -> {
            eliminarArtEntFund();
        });
        pM.add(itemEdit);
        pM.add(itemElim);
        vistaFichIngreso.getTblArticulosFundacion1().setComponentPopupMenu(pM);
    }

    public void popTableHijosPerIng() {
        JPopupMenu pM = new JPopupMenu();
        JMenuItem itemEdit = new JMenuItem("EDITAR");
        JMenuItem itemElim = new JMenuItem("ELIMINAR");
        itemEdit.addActionListener((ActionEvent e) -> {
            EditarPers();
        });
        itemElim.addActionListener((ActionEvent e) -> {
            eliminarHijoAcompa();
        });
        pM.add(itemEdit);
        pM.add(itemElim);
        vistaFichIngreso.getTblHijos1().setComponentPopupMenu(pM);
    }

    public void EditarPers() {
        DefaultTableModel modeloTabla = (DefaultTableModel) vistaFichIngreso.getTblArticulosFundacion().getModel();
        int fsel = vistaFichIngreso.getTblArticulosFundacion().getSelectedRow();
        if (fsel == -1) {
            JOptionPane.showMessageDialog(null, "Seleccione una fila ó Actualize lista", "Verificación", JOptionPane.WARNING_MESSAGE);
        } else {
            String cod = modeloTabla.getValueAt(vistaFichIngreso.getTblArticulosFundacion().getSelectedRow(), 0).toString();
            String nombreArt = modeloTabla.getValueAt(vistaFichIngreso.getTblArticulosFundacion().getSelectedRow(), 1).toString();
            String observ = modeloTabla.getValueAt(vistaFichIngreso.getTblArticulosFundacion().getSelectedRow(), 2).toString();
            String cantidad = modeloTabla.getValueAt(vistaFichIngreso.getTblArticulosFundacion().getSelectedRow(), 3).toString();

            vistaAgreArtPers.getLblCodPers().setText(cod);
            vistaAgreArtPers.getTxtArticulo().setText(nombreArt);
            vistaAgreArtPers.getTxtObsrvaciones().setText(observ);
            vistaAgreArtPers.getSpnCantidad().setValue(Integer.parseInt(cantidad));
            AbrirVentArtPers2();
            vistaAgreArtPers.setTitle("Editar Arítuculos Entregados");
            vistaAgreArtPers.getBtnEditarPers().setEnabled(true);
            vistaAgreArtPers.getBtnGuardar().setEnabled(false);
        }
    }

    public void EditarBtnPers() {
        artEntPerModelDB.setArtentper_id(Integer.parseInt(vistaAgreArtPers.getLblCodPers().getText()));
        artEntPerModelDB.setArtentper_nombre(vistaAgreArtPers.getTxtArticulo().getText());
        artEntPerModelDB.setArtentper_observaciones(vistaAgreArtPers.getTxtObsrvaciones().getText());
        artEntPerModelDB.setArticulo_cantidad(Integer.parseInt(vistaAgreArtPers.getSpnCantidad().getValue().toString()));

        if (artEntPerModelDB.actualizarEditArtEntPers()) {
            JOptionPane.showMessageDialog(null, "Datos actualizados correctamente");
            vistaAgreArtPers.setVisible(false);
            cargarListaArtPers();
        } else {
            JOptionPane.showMessageDialog(null, "Error al actualizar Datos.");

        }
    }

    public void guardarDormRefer() throws SQLException {
        if (vistaFichIngreso.getTxtDormitorio().getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Campos Vacios", "Ingrese Valores", JOptionPane.WARNING_MESSAGE);
        } else {
            if (vistaFichIngreso.getTxaReferida().getText().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Campos Vacios", "Ingrese Valores", JOptionPane.WARNING_MESSAGE);
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
            int columnas = modeloTabHijos.getColumnCount();
            for (int i = 0; i < lista.size(); i++) {
                modeloTabHijos.addRow(new Object[columnas]);
                vistaFichIngreso.getTblHijos().setValueAt(lista.get(i).getHijo_codigo(), i, 0);
                vistaFichIngreso.getTblHijos().setValueAt(lista.get(i).getPersona_nombre(), i, 1);
                vistaFichIngreso.getTblHijos().setValueAt(lista.get(i).getPersona_apellido(), i, 2);
                vistaFichIngreso.getTblHijos().setValueAt(lista.get(i).getPersona_fecha_nac(), i, 3);
                //falta parentesco

            }
            vistaFichIngreso.getLblCant1().setText("Cargados: " + lista.size() + " registros");

        } catch (Exception ex) {
            Logger.getLogger(ControladorFichaIngreso.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    //-----------------------cargar tablas editar ----------------------------------
    public void actualizarDlgTbl() {
        listarHijosEditCargar();
        listarDormiRefEditCargar();
        listarArtEntEditCargar();
        listarArtEntBenefEditCargar();
    }

    public void listarHijosEditCargar() {
        DefaultTableModel tb = (DefaultTableModel) vistaFichIngreso.getTblHijos1().getModel();
        int a = vistaFichIngreso.getTblHijos1().getRowCount() - 1;;
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
                vistaFichIngreso.getTblHijos1().setValueAt(lista.get(i).getPersona_fecha_nac(), i, 3);
                //falta parentesco

            }
            vistaFichIngreso.getLblCant1().setText("Cargados: " + lista.size() + " registros");

        } catch (Exception ex) {
            Logger.getLogger(ControladorFichaIngreso.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void listarDormiRefEditCargar() {
        DefaultTableModel tb = (DefaultTableModel) vistaFichIngreso.getTblDorRef().getModel();
        int a = vistaFichIngreso.getTblDorRef().getRowCount() - 1;;
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

    public void listarArtEntEditCargar() {
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

    public void listarArtEntBenefEditCargar() {
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

    // ------------------------Eventos buscar ---------------------------------------
    
    public void realizarBusquedas(){
        BuscarArtEntBenef();
        BuscarArtFun();
        BuscarDormiRef();
        BuscarHijos();
    }
    
    public void BuscarDormiRef() {
        vistaFichIngreso.getTxtDlgBusar().addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
                //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public void keyPressed(KeyEvent e) {
                //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public void keyReleased(KeyEvent e) {
                DefaultTableModel modeloTabEdit = null;
                int canFilas = vistaFichIngreso.getTblDorRef().getRowCount();
                for (int i = canFilas - 1; i >= 0; i--) {
                    modeloTabEdit.removeRow(i);
                }

                modeloTabEdit = (DefaultTableModel) vistaFichIngreso.getTblDorRef().getModel();
                List<Ingreso> lista;
                //  modelo.setIdpersona(vista.getTxtBuscar().getText());
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
        });

    }

    public void BuscarHijos() {
        vistaFichIngreso.getTxtDlgBusar().addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
                //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public void keyPressed(KeyEvent e) {
                //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public void keyReleased(KeyEvent e) {
                DefaultTableModel modeloTabEdit = null;
                int canFilas = vistaFichIngreso.getTblHijos1().getRowCount();
                for (int i = canFilas - 1; i >= 0; i--) {
                    modeloTabEdit.removeRow(i);
                }

                modeloTabEdit = (DefaultTableModel) vistaFichIngreso.getTblHijos1().getModel();
                List<Hijos> lista;
                //  modelo.setIdpersona(vista.getTxtBuscar().getText());
                try {
                    lista = hijoModelDB.BuscarHijos(vistaFichIngreso.getTxtDlgBusar().getText());
                    int columnas = modeloTabEdit.getColumnCount();
                    for (int i = 0; i < lista.size(); i++) {
                        modeloTabEdit.addRow(new Object[columnas]);
                        vistaFichIngreso.getTblHijos1().setValueAt(lista.get(i).getHijo_codigo(), i, 0);
                        vistaFichIngreso.getTblHijos1().setValueAt(lista.get(i).getPersona_cedula(), i, 1);
                        vistaFichIngreso.getTblHijos1().setValueAt(lista.get(i).getPersona_nombre(), i, 2);
                        vistaFichIngreso.getTblHijos1().setValueAt(lista.get(i).getPersona_apellido(), i, 3);
                        vistaFichIngreso.getTblHijos1().setValueAt(lista.get(i).getPersona_fecha_nac(), i, 4);
                        //falta parentesco
                    }
                    if (vistaFichIngreso.getTxtDlgBusar().getText().length() == 0) {
                        listarHijosEditCargar();
                    }

                } catch (Exception ex) {
                    Logger.getLogger(ControladorFichaIngreso.class.getName()).log(Level.SEVERE, null, ex);
                }

            }
        });

    }

    public void BuscarArtFun() {
        vistaFichIngreso.getTxtDlgBusar().addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
                //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public void keyPressed(KeyEvent e) {
                //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public void keyReleased(KeyEvent e) {
                DefaultTableModel modeloTabEdit = null;
                int canFilas = vistaFichIngreso.getTblArticulosFundacion1().getRowCount();
                for (int i = canFilas - 1; i >= 0; i--) {
                    modeloTabEdit.removeRow(i);
                }

                modeloTabEdit = (DefaultTableModel) vistaFichIngreso.getTblArticulosFundacion1().getModel();
                List<ArticulosEntregadosPersonal> lista;
                //  modelo.setIdpersona(vista.getTxtBuscar().getText());
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
                        listarArtEntEditCargar();
                    }

                } catch (Exception ex) {
                    Logger.getLogger(ControladorFichaIngreso.class.getName()).log(Level.SEVERE, null, ex);
                }

            }
        });

    }

    public void BuscarArtEntBenef() {
        vistaFichIngreso.getTxtDlgBusar().addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
                //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public void keyPressed(KeyEvent e) {
                //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public void keyReleased(KeyEvent e) {
                DefaultTableModel modeloTabEdit = null;
                int canFilas = vistaFichIngreso.getTblArticulosBeneficiaria1().getRowCount();
                for (int i = canFilas - 1; i >= 0; i--) {
                    modeloTabEdit.removeRow(i);
                }

                modeloTabEdit = (DefaultTableModel) vistaFichIngreso.getTblArticulosBeneficiaria1().getModel();
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
                        listarArtEntBenefEditCargar();
                    }

                } catch (Exception ex) {
                    Logger.getLogger(ControladorFichaIngreso.class.getName()).log(Level.SEVERE, null, ex);
                }

            }
        });
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
                    listarArtEntBenefEditCargar();
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
                    listarArtEntEditCargar();
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

        }
    }
}
