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
import javax.swing.text.BadLocationException;
import marylove.DBmodelo.AgregarHijosDB;
import marylove.DBmodelo.ArticulosEntregadosDB;
import marylove.DBmodelo.ArticulosEntregadosPersonalDB;
import marylove.DBmodelo.IngresoDB;
import marylove.DBmodelo.personalDB;
import marylove.DBmodelo.psicologoDB;
import marylove.DBmodelo.victimaDB;
import marylove.conexion.Conexion;
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

    private FormaAgregarArticulosVictima vistaAgreArt;
    private ArticulosEntregados artiEntModel;
    private ArticulosEntregadosDB artEntModelDB;
    private ArticulosEntregadosPersonal artEntPerModel;
    private ArticulosEntregadosPersonalDB artEntPerModelDB;
    private FichaIngreso vistaFichIngreso;
    private FormaAgregarArticulosPersonal vistaAgreArtPers;
    private IngresoDB modelIngreDB;
    private FormaAgregarHijos vistFormHij;
    personalDB persModelDB = new personalDB();
    V_Login vistaLogin = new V_Login();
    AgregarHijosDB modelAgreHijDB;

    Conexion conex = new Conexion();
    DefaultTableModel modeloTab;
    DefaultTableModel modeloTabPers;
    DefaultTableModel modeloTabHijos;
    //ndaa

    public ControladorFichaIngreso(FormaAgregarArticulosVictima vistaAgreArt, ArticulosEntregados artiEntModel, ArticulosEntregadosDB artEntModelDB, ArticulosEntregadosPersonal artEntPerModel, ArticulosEntregadosPersonalDB artEntPerModelDB, FichaIngreso vistaFichIngreso, FormaAgregarArticulosPersonal vistaAgreArtPers, IngresoDB modelIngreDB, FormaAgregarHijos vistFormHij) {
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
        popTable();

        botonesInavilitado();
        controlTxtArea();
        fechaSistemaIni();
        vistaFichIngreso.getTxtCedula().addKeyListener(enter1(vistaFichIngreso.getTxtCedula(), vistaFichIngreso.getTxtNombresApellidos(), vistaFichIngreso.getTxtCodigo()));

        vistaFichIngreso.getBtnAgregarArticulosVictima().addActionListener(e -> AbrirVentArtBenef());
        vistaAgreArt.getBtnGuardar().addActionListener(e -> InsertarArticulosBenef());
        vistaAgreArt.getBtnCancelar().addActionListener(e -> cancelarBenef());
        vistaAgreArt.getBtnEditar().addActionListener(e -> EditarBtn());

        popTablePer();

        vistaFichIngreso.getBtnAgregarArticulosFundacion().addActionListener(e -> AbrirVentArtPers());
        vistaAgreArtPers.getBtnGuardar().addActionListener(e -> InsertarArticulosPers());
        vistaAgreArtPers.getBtnCancelar().addActionListener(e -> cancelarPers());
        vistaAgreArtPers.getBtnEditarPers().addActionListener(e -> EditarBtnPers());

        vistaFichIngreso.getBtnIngresarHij().addActionListener(e -> abrirVentanHijos());
        vistaFichIngreso.getBtnGuardar().addActionListener(e -> guardarDormRefer());

        vistaFichIngreso.getBtnActualizar().addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                if (vistaFichIngreso.getTxtCodigo().getText().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Debe Ingresar Cédula", "Error", JOptionPane.ERROR_MESSAGE);
                } else {
                    actualizar();
                }
            }

        });

    }

    public void actualizar() {
        cargarListaArt();
        cargarListaArtPers();
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

    public void cancelarBenef() {
        vistaAgreArt.getTxtArticulo().setText("");
        vistaAgreArt.getTxtObsrvaciones().setText("");
        vistaAgreArt.getSpnCantidad().setValue(0);
        vistaAgreArt.setVisible(false);
    }

    public void popTable() {
        JPopupMenu pM = new JPopupMenu();
        JMenuItem itemEdit = new JMenuItem("EDITAR");
        itemEdit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Editar();
                AbrirVentArtBenef2();
            }
        });
        pM.add(itemEdit);
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

    public void InsertarArticulosBenef() {
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

    public void InsertarArticulosPers() {
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
        int a = vistaFichIngreso.getTblArticulosFundacion().getRowCount()-1;;
        
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

    public void popTablePer() {
        JPopupMenu pM = new JPopupMenu();
        JMenuItem itemEdit = new JMenuItem("EDITAR");
        itemEdit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                AbrirVentArtPers2();
                EditarPers();
            }
        });
        pM.add(itemEdit);
        vistaFichIngreso.getTblArticulosFundacion().setComponentPopupMenu(pM);
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

    public void guardarDormRefer() {
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
        int a = vistaFichIngreso.getTblHijos().getRowCount() - 1;;
        for (int i = a; i >= 0; i--) {
            tb.removeRow(tb.getRowCount() - 1);
        }

        modeloTabHijos = (DefaultTableModel) vistaFichIngreso.getTblHijos().getModel();
        List<Hijos> lista;

        try {
            lista = modelAgreHijDB.listarHij(Integer.parseInt(vistaFichIngreso.getTxtCodigo().getText()));
            int columnas = modeloTabHijos.getColumnCount();
            for (int i = 0; i < lista.size(); i++) {
                modeloTabHijos.addRow(new Object[columnas]);
                vistaFichIngreso.getTblHijos().setValueAt(lista.get(i).getHijo_codigo(), i, 0);
                vistaFichIngreso.getTblHijos().setValueAt(lista.get(i).getPersona_nombre(), i, 1);
                vistaFichIngreso.getTblHijos().setValueAt(lista.get(i).getPersona_apellido(), i, 2);
                vistaFichIngreso.getTblHijos().setValueAt(lista.get(i).getPersona_fecha_nac(), i, 3);

            }
            vistaFichIngreso.getLblCant1().setText("Cargados: " + lista.size() + " registros");

        } catch (SQLException ex) {
            Logger.getLogger(ControladorFichaIngreso.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
