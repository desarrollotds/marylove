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
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.BadLocationException;
import marylove.DBmodelo.ArticulosEntregadosDB;
import marylove.DBmodelo.ArticulosEntregadosPersonalDB;
import marylove.DBmodelo.IngresoDB;
import marylove.DBmodelo.victimaDB;
import marylove.conexion.Conexion;
import marylove.models.ArticulosEntregados;
import marylove.models.ArticulosEntregadosPersonal;
import marylove.models.Ingreso;
import marylove.vista.FichaIngreso;
import marylove.vista.FormaAgregarArticulosPersonal;
import marylove.vista.FormaAgregarArticulosVictima;
import marylove.vista.FormaAgregarHijos;

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
    private Conexion conex;

    DefaultTableModel modeloTab;
    DefaultTableModel modeloTabPers;
    DefaultTableModel modeloTabHijos;

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
        cargarListaArt();
        botonesInavilitado();
        controlTxtArea();
        fechaSistemaIni();
        vistaFichIngreso.getTxtCedula().addKeyListener(enter1(vistaFichIngreso.getTxtCedula(), vistaFichIngreso.getTxtNombresApellidos(), vistaFichIngreso.getTxtCodigo()));

        vistaFichIngreso.getBtnAgregarArticulosVictima().addActionListener(e -> AbrirVentArtBenef());
        vistaAgreArt.getBtnGuardar().addActionListener(e -> InsertarArticulosBenef());
        vistaAgreArt.getBtnCancelar().addActionListener(e -> cancelarBenef());
        vistaAgreArt.getBtnEditar().addActionListener(e -> EditarBtn());

        popTablePer();
        cargarListaArtPers();
        vistaFichIngreso.getBtnAgregarArticulosFundacion().addActionListener(e -> AbrirVentArtPers());
        vistaAgreArtPers.getBtnGuardar().addActionListener(e -> InsertarArticulosPers());
        vistaAgreArtPers.getBtnCancelar().addActionListener(e -> cancelarPers());
        vistaAgreArtPers.getBtnEditarPers().addActionListener(e -> EditarBtnPers());

        vistaFichIngreso.getBtnIngresarHij().addActionListener(e -> abrirVentanHijos());
        vistaFichIngreso.getBtnGuardar().addActionListener(e -> guardarDormRefer());

    }

    public void fechaSistemaIni() {
        Calendar c = new GregorianCalendar();
        vistaFichIngreso.getJdcFecha().setCalendar(c);
    }

    public void ValidarCampo() {
        vistaFichIngreso.getTxtDormitorio().addKeyListener(validarLetras(vistaFichIngreso.getTxtDormitorio()));
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
                artEntModelDB.setArticulo_descripcion(vistaAgreArt.getTxtArticulo().getText());
                artEntModelDB.setArticulo_observaciones(vistaAgreArt.getTxtObsrvaciones().getText());
                artEntModelDB.setArticulo_cantidad(Integer.parseInt(vistaAgreArt.getSpnCantidad().getValue().toString()));

                if (artEntModelDB.insertarArtEntr()) {
                    JOptionPane.showMessageDialog(null, "Datos Insertados Correctamente");
                    vistaFichIngreso.getBtnAgregarArticulosFundacion().setEnabled(true);
                    vistaFichIngreso.getBtnAgregarArticulosVictima().setEnabled(false);
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
        System.out.println("cf" + canFilas);
        for (int i = canFilas - 1; i >= 0; i--) {
            if (i > 0) {
                modeloTab.removeRow(i);
            }
        }

        modeloTab = (DefaultTableModel) vistaFichIngreso.getTblArticulosBeneficiaria().getModel();
        List<ArticulosEntregados> lista;

        try {
            lista = artEntModelDB.listartEnt();
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
                artEntPerModelDB.setArtentper_nombre(vistaAgreArtPers.getTxtArticulo().getText());
                artEntPerModelDB.setArtentper_observaciones(vistaAgreArtPers.getTxtObsrvaciones().getText());
                artEntPerModelDB.setArticulo_cantidad(Integer.parseInt(vistaAgreArtPers.getSpnCantidad().getValue().toString()));

                if (artEntPerModelDB.InsertarArtEntrPers()) {
                    JOptionPane.showMessageDialog(null, "Datos Insertados Correctamente");
                    vistaAgreArtPers.setVisible(false);
                    cargarListaArtPers();
                    vistaFichIngreso.getBtnGuardar().setEnabled(true);
                    botonesInavilitado();
                } else {
                    JOptionPane.showMessageDialog(null, "Error al Ingresar Datos");
                }
            }
        }
    }

    private void cargarListaArtPers() {
        int canFilas = vistaFichIngreso.getTblArticulosFundacion().getRowCount();
        for (int i = canFilas - 1; i >= 0; i--) {
            if (i > 0) {
                modeloTab.removeRow(i);
            }
        }

        modeloTabPers = (DefaultTableModel) vistaFichIngreso.getTblArticulosFundacion().getModel();
        List<ArticulosEntregadosPersonal> lista;

        try {
            lista = artEntPerModelDB.listartEntPers();
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
                modelIngreDB.setAsignacion_dormitorio(vistaFichIngreso.getTxtDormitorio().getText());
                modelIngreDB.setReferidapor(vistaFichIngreso.getTxaReferida().getText());
                if (modelIngreDB.IngresarDormitorioReferido()) {
                    JOptionPane.showMessageDialog(null, "Datos Insertados Correctamente");
                    vistaFichIngreso.getBtnGuardar().setEnabled(false);
                    vistaFichIngreso.getBtnAgregarArticulosVictima().setEnabled(true);
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

    public void agregarHijoas() {
        if (vistFormHij.getTxtCedula().getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Campos Vacios", "Ingrese Valores", JOptionPane.WARNING_MESSAGE);
        } else {
            if (vistFormHij.getTxtNombres().getText().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Campos Vacios", "Ingrese Valores", JOptionPane.WARNING_MESSAGE);
            } else {
                if (vistFormHij.getTxtNombres().getText().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Campos Vacios", "Ingrese Valores", JOptionPane.WARNING_MESSAGE);
                } else {
                    if (vistFormHij.getDcFechaNacimiento().getDate().equals("")) {
                        JOptionPane.showMessageDialog(null, "Campos Vacios", "Ingrese Valores", JOptionPane.WARNING_MESSAGE);
                    } else {
                        if (vistFormHij.getCbxSexo().getSelectedIndex()==0) {
                            JOptionPane.showMessageDialog(null, "Campos Vacios", "Ingrese Valores", JOptionPane.WARNING_MESSAGE);
                        } else {
                            if (vistFormHij.getTxtNombres().getText().isEmpty()) {
                                JOptionPane.showMessageDialog(null, "Campos Vacios", "Ingrese Valores", JOptionPane.WARNING_MESSAGE);
                            } else {

                                modelIngreDB.setAsignacion_dormitorio(vistaFichIngreso.getTxtDormitorio().getText());
                                modelIngreDB.setReferidapor(vistaFichIngreso.getTxaReferida().getText());
                                if (modelIngreDB.IngresarDormitorioReferido()) {
                                    JOptionPane.showMessageDialog(null, "Datos Insertados Correctamente");
                                    vistaFichIngreso.getBtnGuardar().setEnabled(false);
                                    vistaFichIngreso.getBtnAgregarArticulosVictima().setEnabled(true);
                                } else {
                                    JOptionPane.showMessageDialog(null, "Error al Ingresar Datos");
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}
