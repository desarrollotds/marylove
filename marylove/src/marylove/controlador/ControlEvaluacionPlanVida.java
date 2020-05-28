package marylove.controlador;

import java.awt.event.ActionEvent;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPopupMenu;
import javax.swing.table.DefaultTableModel;
import marylove.DBmodelo.DefinicionObjetivosEspecificosDB;
import marylove.DBmodelo.DefinicionObjetivosGeneralDB;
import marylove.DBmodelo.EvaluacionPlanVidaDB;
import marylove.DBmodelo.PercepcionFamiliarDB;
import static marylove.controlador.C_Login.personal_cod;
import marylove.models.DefinicionObjetivosEspecifico;
import marylove.models.DefinicionObjetivosGeneral;
import marylove.models.PercepcionFamiliar;
import marylove.vista.FichaEvaluacionPlandeVida;
import marylove.vista.VistaDefinicionObjetivosEspecifico;
import marylove.vista.vistaAgregarObjetivoGenera;
import javax.swing.JTable;
import marylove.test_x_text;
import marylove.vista.VistaFiltroVistaVictima;
import org.json.simple.parser.ParseException;

public class ControlEvaluacionPlanVida extends Validaciones {

    DefaultTableModel modeloTabOE;
    DefaultTableModel modeloTabOG;
    DefaultTableModel modeloTabEdit;
    DefaultTableModel modeloTabDlgOE;
    DefaultTableModel modeloTabDlgOG;
    private final FichaEvaluacionPlandeVida vistaEvaPlanVid;
    private final DefinicionObjetivosGeneralDB objGenModelDB;
    private final DefinicionObjetivosEspecificosDB objEspecModelDB;
    private final DefinicionObjetivosGeneral objGenMOdel;
    private final DefinicionObjetivosEspecifico objEspecMdel;
    private final VistaDefinicionObjetivosEspecifico vistaObjEsp;
    private final vistaAgregarObjetivoGenera vistaObjGene;
    private final VistaFiltroVistaVictima vistaNna;

    EvaluacionPlanVidaDB evalPlModelDB = new EvaluacionPlanVidaDB();
    PercepcionFamiliarDB perFamilModelDB = new PercepcionFamiliarDB();

    public ControlEvaluacionPlanVida(FichaEvaluacionPlandeVida vistaEvaPlanVid, DefinicionObjetivosGeneralDB objGenModelDB, DefinicionObjetivosEspecificosDB objEspecModelDB, DefinicionObjetivosGeneral objGenMOdel, DefinicionObjetivosEspecifico objEspecMdel, VistaDefinicionObjetivosEspecifico vistaObjEsp, vistaAgregarObjetivoGenera vistaObjGene, VistaFiltroVistaVictima vistaNna) throws ParseException {
        this.vistaEvaPlanVid = vistaEvaPlanVid;
        this.objGenModelDB = objGenModelDB;
        this.objEspecModelDB = objEspecModelDB;
        this.objGenMOdel = objGenMOdel;
        this.objEspecMdel = objEspecMdel;
        this.vistaObjEsp = vistaObjEsp;
        this.vistaObjGene = vistaObjGene;
        this.vistaNna = vistaNna;
    }

    public void iniciCtrlEvaluacionPlanVida() {
        //abrirEvaPlaVida();
        fechaSistemaIni();
        inciaBtnBloqueados();
        validaciones();
        cargaListaObjEspeDlg();
        cargaListaObjGenDlg();
        inizializarPopTable();

        vistaEvaPlanVid.getTxtCedula().addKeyListener(enter1(vistaEvaPlanVid.getTxtCedula(), vistaEvaPlanVid.getTxtNombre(), vistaEvaPlanVid.getTxtCodigo()));
        vistaEvaPlanVid.getBtnBuscar().addActionListener(e -> Buscar());
        vistaEvaPlanVid.getBtnBuscar1().addActionListener(e -> eventobuscarTexto());
        vistaEvaPlanVid.getBtnObjetivosEspecificos().addActionListener(e -> abrirVentObjEspecificos());
        vistaEvaPlanVid.getBtnObjetivoGeneral().addActionListener(e -> abrirVentObjeGenerales());
        vistaEvaPlanVid.getBtnVerRegist().addActionListener(e -> AbrirEditaringresarPercepcion());
        vistaEvaPlanVid.getBtnActulizartbl().addActionListener(e -> cargarListaEditIngPercepcion());

        vistaEvaPlanVid.getBtnActualizar().addActionListener((ActionEvent e) -> {
            if (vistaEvaPlanVid.getTxtCodigo().getText().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Debe Ingresar Cédula", "Error", JOptionPane.ERROR_MESSAGE);
            } else {
                Actualizar();
            }
        });

        vistaObjEsp.getBtnGuardar().addActionListener(e -> {
            try {
                datosObjEsp();
            } catch (SQLException ex) {
                Logger.getLogger(ControlEvaluacionPlanVida.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
        vistaObjEsp.getBtnEditar().addActionListener(e -> EditarBtnObjEsp());

        vistaObjGene.getBtnEditar().addActionListener(e -> EditarBtnObjGen());
        vistaObjGene.getBtnGuardar().addActionListener(e -> {
            try {
                datosObjGen();
            } catch (SQLException ex) {
                Logger.getLogger(ControlEvaluacionPlanVida.class.getName()).log(Level.SEVERE, null, ex);
            }
        });

        vistaEvaPlanVid.getBtnGuradar().addActionListener(e -> {
            try {
                ingresarEvalPlanVida();
            } catch (SQLException ex) {
                Logger.getLogger(ControlEvaluacionPlanVida.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
        vistaEvaPlanVid.getBtnGuradrarDesa().addActionListener(e -> {
            try {
                ingresarPercepcionFamiliarDes();
            } catch (SQLException ex) {
                Logger.getLogger(ControlEvaluacionPlanVida.class.getName()).log(Level.SEVERE, null, ex);
            }
        });

        vistaEvaPlanVid.getBtnOk().addActionListener(e -> EditarBtn());
        vistaEvaPlanVid.getBtnCancelarEdit().addActionListener(e -> botonCancelarJDg(vistaEvaPlanVid.getjDlgEdit()));
        vistaEvaPlanVid.getBtnCanelarRegl().addActionListener(e -> botonCancelarJDg(vistaEvaPlanVid.getjDlgEditTbl()));
        vistaEvaPlanVid.getBtnVerReg().addActionListener(e -> abrirDlgVistas(vistaEvaPlanVid.getDlgObjGenEsp()));
        vistaEvaPlanVid.getBtnActDlg().addActionListener(e -> cargaListaObjEspeDlg());
        vistaEvaPlanVid.getBtnActDlg().addActionListener(e -> cargaListaObjGenDlg());

        vistaObjEsp.getBtnCancelar().addActionListener(e -> cancelar(vistaObjEsp));
        vistaObjGene.getBtnCancelar().addActionListener(e -> cancelar(vistaObjGene));

        vistaEvaPlanVid.getBtnNna().addActionListener(e -> AbrVentNna());

    }

    public void AbrVentNna() {
        try {
            VistaFiltroVistaVictima vista = new VistaFiltroVistaVictima();
            FiltroHijosVictima filtro = new FiltroHijosVictima(vista);
            vista.setVisible(true);
            vista.setLocationRelativeTo(null);
            vista.getBtnAFormu().setEnabled(false);
        } catch (Exception ex) {
            Logger.getLogger(test_x_text.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void Buscar() {
        eventobuscarObjEspecificos();
        eventobuscarObjGen();
    }

    public void inizializarPopTable() {
        popTable();
        popTableObjEsp();
        popTableObjEspDlg();
        popTableObjGen();
        popTableObjGenDlg();
    }

    public void cancelar(JFrame vista) {
        vista.setVisible(false);
    }

    public void botonCancelarJDg(JDialog canVista) {
        canVista.setVisible(false);
    }

    public void abrirDlgVistas(JDialog dlgVist) {
        dlgVist.setVisible(true);
    }

    public void inciaBtnBloqueados() {
        vistaEvaPlanVid.getTxtNombre().setEnabled(false);
        vistaEvaPlanVid.getTxtCodigo().setEnabled(false);
        vistaEvaPlanVid.getBtnObjetivoGeneral().setEnabled(false);
        vistaEvaPlanVid.getBtnObjetivosEspecificos().setEnabled(false);
        vistaEvaPlanVid.getBtnGuradrarDesa().setEnabled(false);
    }

    public void fechaSistemaIni() {
        Calendar c = new GregorianCalendar();
        vistaEvaPlanVid.getDtcFecha().setCalendar(c);
    }

    public void abrirEvaPlaVida() {
        vistaEvaPlanVid.setVisible(true);
        vistaEvaPlanVid.setLocationRelativeTo(null);
    }

    public void abrirVentObjEspecificos() {
        vistaObjEsp.setVisible(true);
        vistaObjEsp.setLocationRelativeTo(null);
        vistaObjEsp.getBtnEditar().setEnabled(false);
        vistaObjEsp.getBtnGuardar().setEnabled(true);
    }

    public void abrirVentObjeGenerales() {
        vistaObjGene.setVisible(true);
        vistaObjGene.setLocationRelativeTo(null);
        vistaObjGene.getBtnEditar().setEnabled(false);
        vistaObjGene.getBtnGuardar().setEnabled(true);
    }

    public void validaciones() {
        vistaObjGene.getTxtTiempo().addKeyListener(validarNumeros(vistaObjGene.getTxtTiempo()));
        vistaObjEsp.getTxtTiempo().addKeyListener(validarNumeros(vistaObjEsp.getTxtTiempo()));
    }

    public void Actualizar() {
        cargaListaObjEspe();
        cargaListaObjGen();
    }

    public void limpiarObjEsp() {
        vistaObjEsp.getTxtObjEspecifico().setText("");
        vistaObjEsp.getTxtActividad().setText("");
        vistaObjEsp.getTxtTiempo().setText("");
        vistaObjEsp.getTxtApoyoDe().setText("");
        vistaObjEsp.getTxtSupuestoAmenaza().setText("");
    }

    public void datosObjEsp() throws SQLException {
        if (vistaObjEsp.getTxtObjEspecifico().getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Campos Vacios", "Ingrese Valores", JOptionPane.WARNING_MESSAGE);
        } else {
            if (vistaObjEsp.getTxtActividad().getText().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Campos Vacios", "Ingrese Valores", JOptionPane.WARNING_MESSAGE);
            } else {
                if (vistaObjEsp.getTxtTiempo().getText().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Campos Vacios", "Ingrese Valores", JOptionPane.WARNING_MESSAGE);
                } else {
                    if (vistaObjEsp.getTxtApoyoDe().getText().isEmpty()) {
                        JOptionPane.showMessageDialog(null, "Campos Vacios", "Ingrese Valores", JOptionPane.WARNING_MESSAGE);
                    } else {
                        if (vistaObjEsp.getTxtSupuestoAmenaza().getText().isEmpty()) {
                            JOptionPane.showMessageDialog(null, "Campos Vacios", "Ingrese Valores", JOptionPane.WARNING_MESSAGE);
                        } else {
                            objEspecModelDB.setEvaluacion_id(evalPlModelDB.maxId());
                            objEspecModelDB.setResponsoble(evalPlModelDB.verifiUserP(personal_cod));
                            objEspecModelDB.setObjetivosEspecificos(vistaObjEsp.getTxtObjEspecifico().getText());
                            objEspecModelDB.setActividad(vistaObjEsp.getTxtActividad().getText());
                            objEspecModelDB.setTiempo(vistaObjEsp.getTxtTiempo().getText());
                            objEspecModelDB.setApoyode(vistaObjEsp.getTxtApoyoDe().getText());
                            objEspecModelDB.setSupuestosAmenazas(vistaObjEsp.getTxtSupuestoAmenaza().getText());

                            if (objEspecModelDB.insertarObjectivEspecif()) {
                                JOptionPane.showMessageDialog(null, "Datos Insertados Correctamente");
                                cargaListaObjEspe();
                                vistaObjEsp.setVisible(false);
                                limpiarObjEsp();
                            } else {
                                JOptionPane.showMessageDialog(null, "Error al Ingresar Datos");
                            }
                        }
                    }
                }
            }
        }
    }

    public void cargaListaObjEspeDlg() {
        int canFilas = vistaEvaPlanVid.getDlgtblObjEsp().getRowCount();
        for (int i = canFilas - 1; i >= 0; i--) {
            if (i != 0) {
                modeloTabDlgOE.removeRow(i);
            }
        }
        modeloTabDlgOE = (DefaultTableModel) vistaEvaPlanVid.getDlgtblObjEsp().getModel();
        List<DefinicionObjetivosEspecifico> lista;

        try {
            lista = objEspecModelDB.listartObjetiv();
            int columnas = modeloTabDlgOE.getColumnCount();

            for (int i = 0; i < lista.size(); i++) {
                modeloTabDlgOE.addRow(new Object[columnas]);
                vistaEvaPlanVid.getDlgtblObjEsp().setValueAt(lista.get(i).getDefinicion_id(), i, 0);
                vistaEvaPlanVid.getDlgtblObjEsp().setValueAt(lista.get(i).getPersona_cedula(), i, 1);
                vistaEvaPlanVid.getDlgtblObjEsp().setValueAt(lista.get(i).getPersona_nombre() + " " + lista.get(i).getPersona_nombre(), i, 2);
                vistaEvaPlanVid.getDlgtblObjEsp().setValueAt(lista.get(i).getObjetivosEspecificos(), i, 3);
                vistaEvaPlanVid.getDlgtblObjEsp().setValueAt(lista.get(i).getResponsoble(), i, 4);
                vistaEvaPlanVid.getDlgtblObjEsp().setValueAt(lista.get(i).getActividad(), i, 5);
                vistaEvaPlanVid.getDlgtblObjEsp().setValueAt(lista.get(i).getTiempo(), i, 6);
                vistaEvaPlanVid.getDlgtblObjEsp().setValueAt(lista.get(i).getApoyode(), i, 7);
                vistaEvaPlanVid.getDlgtblObjEsp().setValueAt(lista.get(i).getSupuestosAmenazas(), i, 8);
            }

        } catch (SQLException ex) {
            Logger.getLogger(ControladorFichaIngreso.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void cargaListaObjEspe() {
        DefaultTableModel tb = (DefaultTableModel) vistaEvaPlanVid.getTabObjetivosEspecificos().getModel();
        int a = vistaEvaPlanVid.getTabObjetivosEspecificos().getRowCount() - 1;
        for (int i = a; i >= 0; i--) {
            tb.removeRow(tb.getRowCount() - 1);
        }

        modeloTabOE = (DefaultTableModel) vistaEvaPlanVid.getTabObjetivosEspecificos().getModel();
        List<DefinicionObjetivosEspecifico> lista;

        try {
            lista = objEspecModelDB.listartObjetiv();
            int columnas = modeloTabOE.getColumnCount();
            for (int i = 0; i < lista.size(); i++) {
                modeloTabOE.addRow(new Object[columnas]);
                vistaEvaPlanVid.getTabObjetivosEspecificos().setValueAt(lista.get(i).getDefinicion_id(), i, 0);
                vistaEvaPlanVid.getTabObjetivosEspecificos().setValueAt(lista.get(i).getPersona_cedula(), i, 1);
                vistaEvaPlanVid.getTabObjetivosEspecificos().setValueAt(lista.get(i).getPersona_nombre() + " " + lista.get(i).getPersona_nombre(), i, 2);
                vistaEvaPlanVid.getTabObjetivosEspecificos().setValueAt(lista.get(i).getObjetivosEspecificos(), i, 3);
                vistaEvaPlanVid.getTabObjetivosEspecificos().setValueAt(lista.get(i).getResponsoble(), i, 4);
                vistaEvaPlanVid.getTabObjetivosEspecificos().setValueAt(lista.get(i).getActividad(), i, 5);
                vistaEvaPlanVid.getTabObjetivosEspecificos().setValueAt(lista.get(i).getTiempo(), i, 6);
                vistaEvaPlanVid.getTabObjetivosEspecificos().setValueAt(lista.get(i).getApoyode(), i, 7);
                vistaEvaPlanVid.getTabObjetivosEspecificos().setValueAt(lista.get(i).getSupuestosAmenazas(), i, 8);
            }

        } catch (SQLException ex) {
            Logger.getLogger(ControladorFichaIngreso.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void eventobuscarObjEspecificos() {
        System.out.println("buscando");
        DefaultTableModel tb = (DefaultTableModel) vistaEvaPlanVid.getDlgtblObjEsp().getModel();
        int a = vistaEvaPlanVid.getDlgtblObjEsp().getRowCount() - 1;
        for (int i = a; i >= 0; i--) {
            tb.removeRow(tb.getRowCount() - 1);
        }

        modeloTabOE = (DefaultTableModel) vistaEvaPlanVid.getDlgtblObjEsp().getModel();
        List<DefinicionObjetivosEspecifico> lista;
        //  modelo.setIdpersona(vista.getTxtBuscar().getText());
        try {
            lista = objEspecModelDB.buscarObjEsp(vistaEvaPlanVid.getTxtBuscarOGenEsp().getText());
            System.out.println("letra: " + vistaEvaPlanVid.getTxtBuscar().getText());
            int columnas = modeloTabOE.getColumnCount();
            for (int i = 0; i < lista.size(); i++) {
                modeloTabOE.addRow(new Object[columnas]);
                vistaEvaPlanVid.getDlgtblObjEsp().setValueAt(lista.get(i).getDefinicion_id(), i, 0);
                vistaEvaPlanVid.getDlgtblObjEsp().setValueAt(lista.get(i).getPersona_cedula(), i, 1);
                vistaEvaPlanVid.getDlgtblObjEsp().setValueAt(lista.get(i).getPersona_nombre() + " " + lista.get(i).getPersona_nombre(), i, 2);
                vistaEvaPlanVid.getDlgtblObjEsp().setValueAt(lista.get(i).getObjetivosEspecificos(), i, 1);
                vistaEvaPlanVid.getDlgtblObjEsp().setValueAt(lista.get(i).getResponsoble(), i, 2);
                vistaEvaPlanVid.getDlgtblObjEsp().setValueAt(lista.get(i).getActividad(), i, 3);
                vistaEvaPlanVid.getDlgtblObjEsp().setValueAt(lista.get(i).getTiempo(), i, 4);
                vistaEvaPlanVid.getDlgtblObjEsp().setValueAt(lista.get(i).getApoyode(), i, 5);
                vistaEvaPlanVid.getDlgtblObjEsp().setValueAt(lista.get(i).getSupuestosAmenazas(), i, 6);
            }
            if (vistaEvaPlanVid.getTxtBuscarOGenEsp().getText().length() == 0) {
                System.out.println("entra");
                cargaListaObjEspe();
            }

        } catch (SQLException ex) {
            Logger.getLogger(ControlEvaluacionPlanVida.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void popTableObjEspDlg() {
        DefaultTableModel modeloTblObjEspDlg = null;
        JPopupMenu pM = new JPopupMenu();
        JMenuItem itemEdit = new JMenuItem("EDITAR");
        JMenuItem itemEliminar = new JMenuItem("ELIMINAR");
        itemEdit.addActionListener((ActionEvent e) -> {
            EditarObjEsp(modeloTblObjEspDlg, vistaEvaPlanVid.getDlgtblObjEsp());
            vistaObjEsp.getBtnEditar().setEnabled(true);
            vistaObjEsp.getBtnGuardar().setEnabled(false);
        });
        itemEliminar.addActionListener((ActionEvent e) -> {
            eliminarObjEsp(modeloTblObjEspDlg, vistaEvaPlanVid.getDlgtblObjEsp());
        });
        pM.add(itemEdit);
        pM.add(itemEliminar);
        vistaEvaPlanVid.getDlgtblObjEsp().setComponentPopupMenu(pM);
    }

    public void popTableObjEsp() {
        DefaultTableModel modeloTblObjEsp = null;
        JPopupMenu pM = new JPopupMenu();
        JMenuItem itemEdit = new JMenuItem("EDITAR");
        JMenuItem itemElim = new JMenuItem("ELIMINAR");
        itemEdit.addActionListener((ActionEvent e) -> {
            EditarObjEsp(modeloTblObjEsp, vistaEvaPlanVid.getTabObjetivosEspecificos());
            vistaObjEsp.getBtnEditar().setEnabled(true);
            vistaObjEsp.getBtnGuardar().setEnabled(false);
        });
        itemElim.addActionListener((ActionEvent e) -> {
            eliminarObjEsp(modeloTblObjEsp, vistaEvaPlanVid.getTabObjetivosEspecificos());
        });
        pM.add(itemEdit);
        pM.add(itemElim);
        vistaEvaPlanVid.getTabObjetivosEspecificos().setComponentPopupMenu(pM);
    }

    public void EditarObjEsp(DefaultTableModel modeloTabla, JTable tabla) {
        modeloTabla = (DefaultTableModel) tabla.getModel();
        int fsel = tabla.getSelectedRow();
        if (fsel == -1) {
            JOptionPane.showMessageDialog(null, "Seleccione una fila ó Actualize lista", "Verificación", JOptionPane.WARNING_MESSAGE);
        } else {

            String cod = modeloTabla.getValueAt(tabla.getSelectedRow(), 0).toString();
            String ObjetivoEsp = modeloTabla.getValueAt(tabla.getSelectedRow(), 3).toString();
            String res = modeloTabla.getValueAt(tabla.getSelectedRow(), 4).toString();
            String activ = modeloTabla.getValueAt(tabla.getSelectedRow(), 5).toString();
            String tiemp = modeloTabla.getValueAt(tabla.getSelectedRow(), 6).toString();
            String apoyo = modeloTabla.getValueAt(tabla.getSelectedRow(), 7).toString();
            String supuest = modeloTabla.getValueAt(tabla.getSelectedRow(), 8).toString();

            vistaObjEsp.getLblCodigo().setText(cod);
            vistaObjEsp.getTxtObjEspecifico().setText(ObjetivoEsp);
            vistaObjEsp.getTxtResponsable().setText(res);
            vistaObjEsp.getTxtActividad().setText(activ);
            vistaObjEsp.getTxtTiempo().setText(tiemp);
            vistaObjEsp.getTxtApoyoDe().setText(apoyo);
            vistaObjEsp.getTxtSupuestoAmenaza().setText(supuest);
            vistaObjEsp.setTitle("Editar Objetivos Especificos");
            abrirVentObjEspecificos();
        }
    }

    public void EditarBtnObjEsp() {
        objEspecModelDB.setDefinicion_id(Integer.parseInt(vistaObjEsp.getLblCodigo().getText()));
        objEspecModelDB.setObjetivosEspecificos(vistaObjEsp.getTxtObjEspecifico().getText());
        objEspecModelDB.setActividad(vistaObjEsp.getTxtActividad().getText());
        objEspecModelDB.setTiempo(vistaObjEsp.getTxtTiempo().getText());
        objEspecModelDB.setApoyode(vistaObjEsp.getTxtApoyoDe().getText());
        objEspecModelDB.setSupuestosAmenazas(vistaObjEsp.getTxtSupuestoAmenaza().getText());
        if (objEspecModelDB.actualizarObjEsp()) {
            JOptionPane.showMessageDialog(null, "Editado Objetivos Especificos correctamente");
            vistaObjEsp.setVisible(false);
            cargaListaObjEspe();
            cargaListaObjEspeDlg();

            vistaObjEsp.getTxtObjEspecifico().setText("");
            vistaObjEsp.getTxtActividad().setText("");
            vistaObjEsp.getTxtTiempo().setText("");
            vistaObjEsp.getTxtApoyoDe().setText("");
            vistaObjEsp.getTxtSupuestoAmenaza().setText("");

        } else {
            JOptionPane.showMessageDialog(null, "Error al actualizar Datos.");

        }
    }

    ////////////////////////////////////////////////77
    public void limpiarObjGen() {
        vistaObjGene.getTxtObjGeneral().setText("");
        vistaObjGene.getTxtTiempo().setText("");
        vistaObjGene.getTxtObservaciones().setText("");
    }

    public void datosObjGen() throws SQLException {
        if (vistaObjGene.getTxtObjGeneral().getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Campos Vacios", "Ingrese Valores", JOptionPane.WARNING_MESSAGE);
        } else {
            if (vistaObjGene.getTxtTiempo().getText().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Campos Vacios", "Ingrese Valores", JOptionPane.WARNING_MESSAGE);
            } else {
                if (vistaObjGene.getTxtObservaciones().getText().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Campos Vacios", "Ingrese Valores", JOptionPane.WARNING_MESSAGE);
                } else {
                    objGenModelDB.setEvaluacion_id(evalPlModelDB.maxId());
                    objGenModelDB.setResponsable(evalPlModelDB.verifiUserP(personal_cod));
                    objGenModelDB.setObjetivo_general(vistaObjGene.getTxtObjGeneral().getText());
                    objGenModelDB.setTiempo(vistaObjGene.getTxtTiempo().getText());
                    objGenModelDB.setObservaciones(vistaObjGene.getTxtObservaciones().getText());

                    if (objGenModelDB.insertarObjeGen()) {
                        JOptionPane.showMessageDialog(null, "Datos Insertados Correctamente");
                        cargaListaObjGen();
                        vistaObjGene.setVisible(false);
                        limpiarObjGen();
                    } else {
                        JOptionPane.showMessageDialog(null, "Error al Ingresar Datos");
                    }
                }
            }
        }
    }

    public void cargaListaObjGen() {
        int canFilas = vistaEvaPlanVid.getTabObjetivoGeneral().getRowCount();
        for (int i = canFilas - 1; i >= 0; i--) {
            modeloTabOG.removeRow(i);
        }

        modeloTabOG = (DefaultTableModel) vistaEvaPlanVid.getTabObjetivoGeneral().getModel();
        List<DefinicionObjetivosGeneral> lista;

        try {
            System.out.println(vistaEvaPlanVid.getTxtCodigo().getText());
            //lista = objGenModelDB.listartObjeGen(Integer.parseInt(vistaEvaPlanVid.getTxtCodigo().getText()));
            lista = objGenModelDB.listartObjeGen();
            int columnas = modeloTabOG.getColumnCount();
            for (int i = 0; i < lista.size(); i++) {
                modeloTabOG.addRow(new Object[columnas]);
                vistaEvaPlanVid.getTabObjetivoGeneral().setValueAt(lista.get(i).getDefiniciong_id(), i, 0);
                vistaEvaPlanVid.getTabObjetivoGeneral().setValueAt(lista.get(i).getPersona_cedula(), i, 1);
                vistaEvaPlanVid.getTabObjetivoGeneral().setValueAt(lista.get(i).getPersona_nombre() + " " + lista.get(i).getPersona_nombre(), i, 2);
                vistaEvaPlanVid.getTabObjetivoGeneral().setValueAt(lista.get(i).getObjetivo_general(), i, 3);
                vistaEvaPlanVid.getTabObjetivoGeneral().setValueAt(lista.get(i).getResponsable(), i, 4);
                vistaEvaPlanVid.getTabObjetivoGeneral().setValueAt(lista.get(i).getTiempo(), i, 5);
                vistaEvaPlanVid.getTabObjetivoGeneral().setValueAt(lista.get(i).getObservaciones(), i, 6);
            }

        } catch (SQLException ex) {
            Logger.getLogger(ControladorFichaIngreso.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void cargaListaObjGenDlg() {
        int canFilas = vistaEvaPlanVid.getDlgTblObjGen().getRowCount();
        for (int i = canFilas - 1; i >= 0; i--) {
            modeloTabDlgOG.removeRow(i);
        }

        modeloTabDlgOG = (DefaultTableModel) vistaEvaPlanVid.getDlgTblObjGen().getModel();
        List<DefinicionObjetivosGeneral> lista;

        try {
            System.out.println(vistaEvaPlanVid.getTxtCodigo().getText());
            //lista = objGenModelDB.listartObjeGen(Integer.parseInt(vistaEvaPlanVid.getTxtCodigo().getText()));
            lista = objGenModelDB.listartObjeGen();
            int columnas = modeloTabDlgOG.getColumnCount();
            for (int i = 0; i < lista.size(); i++) {
                modeloTabDlgOG.addRow(new Object[columnas]);
                vistaEvaPlanVid.getDlgTblObjGen().setValueAt(lista.get(i).getDefiniciong_id(), i, 0);
                vistaEvaPlanVid.getDlgTblObjGen().setValueAt(lista.get(i).getPersona_cedula(), i, 1);
                vistaEvaPlanVid.getDlgTblObjGen().setValueAt(lista.get(i).getPersona_nombre() + " " + lista.get(i).getPersona_nombre(), i, 2);
                vistaEvaPlanVid.getDlgTblObjGen().setValueAt(lista.get(i).getObjetivo_general(), i, 3);
                vistaEvaPlanVid.getDlgTblObjGen().setValueAt(lista.get(i).getResponsable(), i, 4);
                vistaEvaPlanVid.getDlgTblObjGen().setValueAt(lista.get(i).getTiempo(), i, 5);
                vistaEvaPlanVid.getDlgTblObjGen().setValueAt(lista.get(i).getObservaciones(), i, 6);
            }

        } catch (SQLException ex) {
            Logger.getLogger(ControladorFichaIngreso.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void eventobuscarObjGen() {
        System.out.println("buscando");
        int canFilas = vistaEvaPlanVid.getDlgTblObjGen().getRowCount();
        for (int i = canFilas - 1; i >= 0; i--) {
            modeloTabDlgOG.removeRow(i);
        }

        modeloTabDlgOG = (DefaultTableModel) vistaEvaPlanVid.getDlgTblObjGen().getModel();
        List<DefinicionObjetivosGeneral> lista;
        //  modelo.setIdpersona(vista.getTxtBuscar().getText());
        try {
            lista = objGenModelDB.buscarObjGen(vistaEvaPlanVid.getTxtBuscarOGenEsp().getText().toUpperCase());
            System.out.println("letra: " + vistaEvaPlanVid.getTxtBuscar().getText().toUpperCase());
            int columnas = modeloTabDlgOG.getColumnCount();
            for (int i = 0; i < lista.size(); i++) {
                modeloTabDlgOG.addRow(new Object[columnas]);
                vistaEvaPlanVid.getDlgTblObjGen().setValueAt(lista.get(i).getDefiniciong_id(), i, 0);
                vistaEvaPlanVid.getDlgTblObjGen().setValueAt(lista.get(i).getPersona_cedula(), i, 1);
                vistaEvaPlanVid.getDlgTblObjGen().setValueAt(lista.get(i).getPersona_nombre() + " " + lista.get(i).getPersona_nombre(), i, 2);
                vistaEvaPlanVid.getDlgTblObjGen().setValueAt(lista.get(i).getObjetivo_general(), i, 3);
                vistaEvaPlanVid.getDlgTblObjGen().setValueAt(lista.get(i).getResponsable(), i, 4);
                vistaEvaPlanVid.getDlgTblObjGen().setValueAt(lista.get(i).getTiempo(), i, 5);
                vistaEvaPlanVid.getDlgTblObjGen().setValueAt(lista.get(i).getObservaciones(), i, 6);
            }
            if (vistaEvaPlanVid.getTxtBuscarOGenEsp().getText().length() == 0) {
                System.out.println("entra");
                cargaListaObjGen();
            }

        } catch (SQLException ex) {
            Logger.getLogger(ControlEvaluacionPlanVida.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void popTableObjGen() {
        DefaultTableModel modeloTblObjGen = null;
        JPopupMenu pM = new JPopupMenu();
        JMenuItem itemEdit = new JMenuItem("EDITAR");
        JMenuItem itemEliminar = new JMenuItem("ELIMINAR");
        itemEdit.addActionListener((ActionEvent e) -> {
            EditarObjGen(modeloTblObjGen, vistaEvaPlanVid.getTabObjetivoGeneral());
            vistaObjGene.getBtnEditar().setEnabled(true);
            vistaObjGene.getBtnGuardar().setEnabled(false);
        });
        itemEliminar.addActionListener((ActionEvent e) -> {
            eliminarObjGen(modeloTblObjGen, vistaEvaPlanVid.getTabObjetivoGeneral());
        });
        pM.add(itemEdit);
        pM.add(itemEliminar);
        vistaEvaPlanVid.getTabObjetivoGeneral().setComponentPopupMenu(pM);
    }

    public void popTableObjGenDlg() {
        DefaultTableModel modeloTblObjGenDlg = null;
        JPopupMenu pM = new JPopupMenu();
        JMenuItem itemEdit = new JMenuItem("EDITAR");
        JMenuItem itemEliminar = new JMenuItem("ELIMINAR");
        itemEdit.addActionListener((ActionEvent e) -> {
            EditarObjGen(modeloTblObjGenDlg, vistaEvaPlanVid.getDlgTblObjGen());
            vistaObjGene.getBtnEditar().setEnabled(true);
            vistaObjGene.getBtnGuardar().setEnabled(false);
        });
        itemEliminar.addActionListener((ActionEvent e) -> {
            eliminarObjGen(modeloTblObjGenDlg, vistaEvaPlanVid.getDlgTblObjGen());
        });
        pM.add(itemEdit);
        pM.add(itemEliminar);
        vistaEvaPlanVid.getDlgTblObjGen().setComponentPopupMenu(pM);
    }

    public void EditarObjGen(DefaultTableModel modeloTabla, JTable tabla) {
        modeloTabla = (DefaultTableModel) tabla.getModel();
        int fsel = tabla.getSelectedRow();
        if (fsel == -1) {
            JOptionPane.showMessageDialog(null, "Seleccione una fila ó Actualize lista", "Verificación", JOptionPane.WARNING_MESSAGE);
        } else {
            String cod = modeloTabla.getValueAt(tabla.getSelectedRow(), 0).toString();
            String ObjetivoGen = modeloTabla.getValueAt(tabla.getSelectedRow(), 3).toString();
            String res = modeloTabla.getValueAt(tabla.getSelectedRow(), 4).toString();
            String tiempo = modeloTabla.getValueAt(tabla.getSelectedRow(), 5).toString();
            String obser = modeloTabla.getValueAt(tabla.getSelectedRow(), 6).toString();

            vistaObjGene.getLblCodigo().setText(cod);
            vistaObjGene.getTxtObjGeneral().setText(ObjetivoGen);
            vistaObjGene.getTxtResponsable().setText(res);
            vistaObjGene.getTxtTiempo().setText(tiempo);
            vistaObjGene.getTxtObservaciones().setText(obser);
            abrirVentObjeGenerales();
            vistaObjGene.setTitle("Editar Objetivos Generales");
        }
    }

    public void EditarBtnObjGen() {
        objGenModelDB.setDefiniciong_id(Integer.parseInt(vistaObjGene.getLblCodigo().getText()));
        objGenModelDB.setObjetivo_general(vistaObjGene.getTxtObjGeneral().getText());
        objGenModelDB.setTiempo(vistaObjGene.getTxtTiempo().getText());
        objGenModelDB.setObservaciones(vistaObjGene.getTxtObservaciones().getText());

        if (objGenModelDB.actualizarObjGen()) {
            cargaListaObjGen();
            cargaListaObjGenDlg();
            JOptionPane.showMessageDialog(null, "Datos Editados correctamente");
            vistaObjGene.setVisible(false);
            vistaObjGene.getTxtObjGeneral().setText("");
            vistaObjGene.getTxtTiempo().setText("");
            vistaObjGene.getTxtObservaciones().setText("");
        } else {
            JOptionPane.showMessageDialog(null, "Error al actualizar Datos.");

        }
    }

    //////////Evaluacion Plan de Vida
    public void ingresarEvalPlanVida() throws SQLException {
        if (vistaEvaPlanVid.getTxtCedula().getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Ingrese primero cédula y presione 'Enter'", "Ingrese Valores", JOptionPane.ERROR_MESSAGE);
        } else {
            if (vistaEvaPlanVid.getDtcFecha().getDate() == null) {
                JOptionPane.showMessageDialog(null, "Ingrese Fecha", "Ingrese Valores", JOptionPane.WARNING_MESSAGE);
            } else {
                if (vistaEvaPlanVid.getDtcFechaEval().getDate() == null) {
                    JOptionPane.showMessageDialog(null, "Ingrese Fecha de Evaluación", "Ingrese Valores", JOptionPane.WARNING_MESSAGE);
                } else {
                    evalPlModelDB.setVictima_codigo(Integer.parseInt(vistaEvaPlanVid.getTxtCodigo().getText()));
                    evalPlModelDB.setPersonal_codigo(evalPlModelDB.verifiUserP(personal_cod));
                    evalPlModelDB.setEvaluacion_fecha(obtenerFecha(vistaEvaPlanVid.getDtcFecha()));
                    evalPlModelDB.setEvaluacion_proxima(obtenerFecha(vistaEvaPlanVid.getDtcFechaEval()));
                    if (evalPlModelDB.IngresarEvaluacionPlaVida()) {
                        JOptionPane.showMessageDialog(null, "Dato Insertado Correctamente");
                        vistaEvaPlanVid.getBtnObjetivoGeneral().setEnabled(true);
                        vistaEvaPlanVid.getBtnObjetivosEspecificos().setEnabled(true);
                        vistaEvaPlanVid.getBtnGuradrarDesa().setEnabled(true);
                    } else {
                        JOptionPane.showMessageDialog(null, "Error al Ingresar Datos");
                    }
                }
            }
        }
    }

    //////////Percepcion Familiar
    public void ingresarPercepcionFamiliarDes() throws SQLException {
        if (vistaEvaPlanVid.getTxtComSiente().getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Campos Vacios", "Ingrese Valores", JOptionPane.WARNING_MESSAGE);
        } else {
            if (vistaEvaPlanVid.getTxtObjPlaned().getText().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Ingrese objetivos", "Ingrese Valores", JOptionPane.WARNING_MESSAGE);
            } else {
                if (vistaEvaPlanVid.getTxtDificEncontrados().getText().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Ingrese dificultades", "Ingrese Valores", JOptionPane.WARNING_MESSAGE);
                } else {
                    if (vistaEvaPlanVid.getTxaVision1().getText().isEmpty()) {
                        JOptionPane.showMessageDialog(null, "Ingrese visión del equipo", "Ingrese Valores", JOptionPane.WARNING_MESSAGE);
                    } else {
                        perFamilModelDB.setEvaluacion_id(evalPlModelDB.maxId());
                        perFamilModelDB.setComoSeSiente(vistaEvaPlanVid.getTxtComSiente().getText());
                        perFamilModelDB.setAlcanzoObjetivosComo(vistaEvaPlanVid.getTxtObjPlaned().getText());
                        perFamilModelDB.setDificultadesEncontradas(vistaEvaPlanVid.getTxtDificEncontrados().getText());
                        perFamilModelDB.setVisionUnionFamiliar(vistaEvaPlanVid.getTxaVision1().getText());
                        if (perFamilModelDB.IngresarPercepcionFamil()) {
                            JOptionPane.showMessageDialog(null, "Dato Insertado Correctamente");
                        } else {
                            JOptionPane.showMessageDialog(null, "Error al Ingresar Datos, Vuelva a intentar");
                        }
                    }
                }
            }
        }
    }

    public void AbrirEditaringresarPercepcion() {
        vistaEvaPlanVid.getjDlgEditTbl().setVisible(true);
        vistaEvaPlanVid.getjDlgEditTbl().setSize(1200, 700);
        vistaEvaPlanVid.getjDlgEditTbl().setLocationRelativeTo(null);
        cargarListaEditIngPercepcion();
    }

    private void cargarListaEditIngPercepcion() {
        int canFilas = vistaEvaPlanVid.getTblEditar().getRowCount();
        for (int i = canFilas - 1; i >= 0; i--) {
            if (i > 0) {
                modeloTabEdit.removeRow(i);
            }
        }

        modeloTabEdit = (DefaultTableModel) vistaEvaPlanVid.getTblEditar().getModel();
        List<PercepcionFamiliar> lista;

        try {
            lista = perFamilModelDB.listarPerFam();
            int columnas = modeloTabEdit.getColumnCount();
            for (int i = 0; i < lista.size(); i++) {
                modeloTabEdit.addRow(new Object[columnas]);
                vistaEvaPlanVid.getTblEditar().setValueAt(lista.get(i).getPercepcion_id(), i, 0);
                vistaEvaPlanVid.getTblEditar().setValueAt(lista.get(i).getPersona_cedula(), i, 1);
                vistaEvaPlanVid.getTblEditar().setValueAt(lista.get(i).getPersona_nombre()+" "+lista.get(i).getPersona_apellido(), i, 2);
                vistaEvaPlanVid.getTblEditar().setValueAt(lista.get(i).getComoSeSiente(), i, 3);
                vistaEvaPlanVid.getTblEditar().setValueAt(lista.get(i).getAlcanzoObjetivosComo(), i, 4);
                vistaEvaPlanVid.getTblEditar().setValueAt(lista.get(i).getDificultadesEncontradas(), i, 5);
                vistaEvaPlanVid.getTblEditar().setValueAt(lista.get(i).getVisionUnionFamiliar(), i, 6);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ControladorFichaIngreso.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void AbrirEditarPercepcion() {
        vistaEvaPlanVid.getjDlgEdit().setVisible(true);
        vistaEvaPlanVid.getjDlgEdit().setLocationRelativeTo(null);
        vistaEvaPlanVid.getjDlgEdit().setSize(980, 513);
    }

    public void popTable() {
        JPopupMenu pM = new JPopupMenu();
        JMenuItem itemEdit = new JMenuItem("EDITAR");
        JMenuItem itemEliminar = new JMenuItem("ELIMINAR");
        itemEdit.addActionListener((ActionEvent e) -> {
            Editar();
        });
        itemEliminar.addActionListener((ActionEvent e) -> {
            eliminarPercepcionFamily();
        });
        pM.add(itemEdit);
        pM.add(itemEliminar);
        vistaEvaPlanVid.getTblEditar().setComponentPopupMenu(pM);
    }

    public void Editar() {
        DefaultTableModel modeloTabla = (DefaultTableModel) vistaEvaPlanVid.getTblEditar().getModel();
        int fsel = vistaEvaPlanVid.getTblEditar().getSelectedRow();
        if (fsel == -1) {
            JOptionPane.showMessageDialog(null, "Seleccione una fila ó Actualize lista", "Verificación", JOptionPane.WARNING_MESSAGE);
        } else {
            String cod = modeloTabla.getValueAt(vistaEvaPlanVid.getTblEditar().getSelectedRow(), 0).toString();
            String comoseSinte = modeloTabla.getValueAt(vistaEvaPlanVid.getTblEditar().getSelectedRow(), 1).toString();
            String alcanzaObj = modeloTabla.getValueAt(vistaEvaPlanVid.getTblEditar().getSelectedRow(), 2).toString();
            String dificultadesEnc = modeloTabla.getValueAt(vistaEvaPlanVid.getTblEditar().getSelectedRow(), 3).toString();
            String vision = modeloTabla.getValueAt(vistaEvaPlanVid.getTblEditar().getSelectedRow(), 4).toString();

            vistaEvaPlanVid.getLblCodEdit().setText(cod);
            vistaEvaPlanVid.getTxtComSienteEdit().setText(comoseSinte);
            vistaEvaPlanVid.getTxtObjPlanedEdit().setText(alcanzaObj);
            vistaEvaPlanVid.getTxtDificEncontradosEdit().setText(dificultadesEnc);
            vistaEvaPlanVid.getTxaVision1().setText(vision);

            vistaEvaPlanVid.getjDlgEdit().setTitle("Editar Arítuculos Entregados");
            AbrirEditarPercepcion();
        }
    }

    public void EditarBtn() {
        perFamilModelDB.setPercepcion_id(Integer.parseInt(vistaEvaPlanVid.getLblCodEdit().getText()));
        perFamilModelDB.setComoSeSiente(vistaEvaPlanVid.getTxtComSienteEdit().getText());
        perFamilModelDB.setAlcanzoObjetivosComo(vistaEvaPlanVid.getTxtObjPlanedEdit().getText());
        perFamilModelDB.setDificultadesEncontradas(vistaEvaPlanVid.getTxtDificEncontradosEdit().getText());
        perFamilModelDB.setVisionUnionFamiliar(vistaEvaPlanVid.getTxaVision1().getText());

        if (perFamilModelDB.actualizarPerFam()) {
            JOptionPane.showMessageDialog(null, "Datos actualizados correctamente");
            vistaEvaPlanVid.getjDlgEdit().setVisible(false);
            cargarListaEditIngPercepcion();

            vistaEvaPlanVid.getTxtComSienteEdit().setText("");
            vistaEvaPlanVid.getTxtObjPlanedEdit().setText("");
            vistaEvaPlanVid.getTxtDificEncontradosEdit().setText("");
            vistaEvaPlanVid.getTxaVision1().setText("");
        } else {
            JOptionPane.showMessageDialog(null, "Error al actualizar Datos.");
        }
    }

    public void eventobuscarTexto() {
        System.out.println("buscando");
        int canFilas = vistaEvaPlanVid.getTblEditar().getRowCount();
        for (int i = canFilas - 1; i >= 0; i--) {
            modeloTabEdit.removeRow(i);
        }

        modeloTabEdit = (DefaultTableModel) vistaEvaPlanVid.getTblEditar().getModel();
        List<PercepcionFamiliar> lista;
        try {
            lista = perFamilModelDB.buscarTextoPercepcionFam(vistaEvaPlanVid.getTxtBuscar().getText().toUpperCase());
            System.out.println("letra: " + vistaEvaPlanVid.getTxtBuscar().getText().toUpperCase());
            int columnas = modeloTabEdit.getColumnCount();
            for (int i = 0; i < lista.size(); i++) {
                modeloTabEdit.addRow(new Object[columnas]);
                vistaEvaPlanVid.getTblEditar().setValueAt(lista.get(i).getPercepcion_id(), i, 0);
                vistaEvaPlanVid.getTblEditar().setValueAt(lista.get(i).getPersona_cedula(), i, 1);
                vistaEvaPlanVid.getTblEditar().setValueAt(lista.get(i).getPersona_nombre()+" "+lista.get(i).getPersona_apellido(), i, 2);
                vistaEvaPlanVid.getTblEditar().setValueAt(lista.get(i).getComoSeSiente(), i, 1);
                vistaEvaPlanVid.getTblEditar().setValueAt(lista.get(i).getAlcanzoObjetivosComo(), i, 2);
                vistaEvaPlanVid.getTblEditar().setValueAt(lista.get(i).getDificultadesEncontradas(), i, 3);
                vistaEvaPlanVid.getTblEditar().setValueAt(lista.get(i).getVisionUnionFamiliar(), i, 4);
            }
            if (vistaEvaPlanVid.getTxtBuscar().getText().length() == 0) {
                cargarListaEditIngPercepcion();
            }

        } catch (SQLException ex) {
            Logger.getLogger(ControlEvaluacionPlanVida.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
    }

    //--------------------------------Eliminar-------------------------------------
    private void eliminarPercepcionFamily() {

        int fsel = vistaEvaPlanVid.getTblEditar().getSelectedRow();
        if (fsel == -1) {
            JOptionPane.showMessageDialog(null, "Seleccione una fila para eliminar ó Actualiza la lista.", "Verificación", JOptionPane.WARNING_MESSAGE);
        } else {
            int desicion = JOptionPane.showConfirmDialog(null, "Esta seguro de que desea Borrar este Registro?");
            if (desicion == JOptionPane.YES_OPTION) {
                DefaultTableModel modeloTabla = (DefaultTableModel) vistaEvaPlanVid.getTblEditar().getModel();
                String cod = modeloTabla.getValueAt(vistaEvaPlanVid.getTblEditar().getSelectedRow(), 0).toString();
                perFamilModelDB.setPercepcion_id(Integer.parseInt(cod));
                System.out.println(cod);
                if (perFamilModelDB.eliminarPerFamily()) {
                    JOptionPane.showMessageDialog(null, "Dato borrado correctamente");
                    cargarListaEditIngPercepcion();
                } else {
                    JOptionPane.showMessageDialog(null, "Dato no borrado");
                }
            }

        }
    }

    private void eliminarObjGen(DefaultTableModel modeloTabla, JTable tabla) {

        int fsel = tabla.getSelectedRow();
        if (fsel == -1) {
            JOptionPane.showMessageDialog(null, "Seleccione una fila para eliminar ó Actualiza la lista.", "Verificación", JOptionPane.WARNING_MESSAGE);
        } else {
            int desicion = JOptionPane.showConfirmDialog(null, "Esta seguro de que desea Borrar este Registro?");
            if (desicion == JOptionPane.YES_OPTION) {
                modeloTabla = (DefaultTableModel) tabla.getModel();
                String cod = modeloTabla.getValueAt(tabla.getSelectedRow(), 0).toString();
                objGenModelDB.setDefiniciong_id(Integer.parseInt(cod));
                System.out.println(cod);
                if (objGenModelDB.eliminarObjGen()) {
                    JOptionPane.showMessageDialog(null, "Dato borrado correctamente");
                    cargaListaObjGen();
                    cargaListaObjGenDlg();
                } else {
                    JOptionPane.showMessageDialog(null, "Dato no borrado");
                }
            }

        }
    }

    private void eliminarObjEsp(DefaultTableModel modeloTabla, JTable tabla) {
        int fsel = tabla.getSelectedRow();
        if (fsel == -1) {
            JOptionPane.showMessageDialog(null, "Seleccione una fila para eliminar ó Actualiza la lista.", "Verificación", JOptionPane.WARNING_MESSAGE);
        } else {
            int desicion = JOptionPane.showConfirmDialog(null, "Esta seguro de que desea Borrar este Registro?");
            if (desicion == JOptionPane.YES_OPTION) {
                modeloTabla = (DefaultTableModel) tabla.getModel();
                String cod = modeloTabla.getValueAt(tabla.getSelectedRow(), 0).toString();
                objEspecModelDB.setDefinicion_id(Integer.parseInt(cod));
                if (objEspecModelDB.eliminarObEsp()) {
                    JOptionPane.showMessageDialog(null, "Dato borrado correctamente");
                    cargaListaObjEspe();
                    cargaListaObjEspeDlg();
                } else {
                    JOptionPane.showMessageDialog(null, "Dato no borrado");
                }
            }

        }
    }

    //-------------------------------NNA----------------------------------------
    //-------------------------------------------------------------------------
}
