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
import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPopupMenu;
import javax.swing.table.DefaultTableModel;
import marylove.DBmodelo.Plan_devidaDB;
import marylove.DBmodelo.PvObjetivosEspecDB;
import marylove.DBmodelo.PvObjetivosGeneDB;
import static marylove.controlador.C_Login.personal_cod;
import marylove.models.Plan_de_Vida;
import marylove.models.Pv_objeticos_especificos;
import marylove.models.Pv_objetivos_gene;
import marylove.test_x_text;
import marylove.vista.FichaPlandeVida;
import marylove.vista.VistaDefinicionObjetivosEspecifico;
import marylove.vista.VistaFiltroVistaVictima;
import marylove.vista.vistaAgregarObjetivoGenera;

/**
 *
 * @author USUARIO
 */
public class ControladorPlandeVida extends Validaciones {

    DefaultTableModel modeloTabOE;
    DefaultTableModel modeloTabOG;
    DefaultTableModel modeloTabEdit;
    DefaultTableModel modeloTabDlgOE;
    DefaultTableModel modeloTabDlgOG;
    private FichaPlandeVida vista;
    private PvObjetivosGeneDB objGeModlDB;
    private PvObjetivosEspecDB objEspeModelDB;
    private Pv_objetivos_gene objGeMOdel;
    private Pv_objeticos_especificos objEspeMdel;
    private VistaDefinicionObjetivosEspecifico vistObjEsp;
    private vistaAgregarObjetivoGenera vistObjGene;

    Plan_devidaDB modelo = new Plan_devidaDB();

    public ControladorPlandeVida(FichaPlandeVida vista, PvObjetivosGeneDB objGeModlDB, PvObjetivosEspecDB objEspeModelDB, Pv_objetivos_gene objGeMOdel, Pv_objeticos_especificos objEspeMdel, VistaDefinicionObjetivosEspecifico vistObjEsp, vistaAgregarObjetivoGenera vistObjGene) throws Exception {
        this.vista = vista;
        this.objGeModlDB = objGeModlDB;
        this.objEspeModelDB = objEspeModelDB;
        this.objGeMOdel = objGeMOdel;
        this.objEspeMdel = objEspeMdel;
        this.vistObjEsp = vistObjEsp;
        this.vistObjGene = vistObjGene;
    }

    public void iniciarControl() {
        inciaBtnBloqueados();
        validaciones();
        popTableObjGen();
        popTableObjEsp();
        popTable();
        //validaciones
        vista.getTxtNombre().setToolTipText("Antes de buscar debe limpiar los campos");
        vista.getTxtNombre().addKeyListener(enter1(vista.getTxtCedula(), vista.getTxtNombre(), vista.getTxtCodigo()));
        vista.getTxtNombre().addKeyListener(validarLetras(vista.getTxtNombre()));
        vista.getTxtCodigo().addKeyListener(validarNumeros(vista.getTxtCodigo()));
//        vista.getTxtCedula().addKeyListener(validarCedula(vista.getTxtCedula()));
        vista.getTxtCedula().setToolTipText("Antes de buscar debe limpiar los campos");
        vista.getTxtCedula().addKeyListener(enter1(vista.getTxtCedula(), vista.getTxtNombre(), vista.getTxtCodigo()));
        // veridicar()
        vista.getTxtNombre().addKeyListener(verificar());
        vista.getTxtCedula().addKeyListener(verificar());
// ya da cargada la fecha
        Calendar c2 = new GregorianCalendar();
        vista.getDtcFecha().setCalendar(c2);
        //solo se actualizara si tiene ingresada la cedula 
        vista.getBtnActualizar().addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                if (vista.getTxtCodigo().getText().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Debe Ingresar Cédula", "Error", JOptionPane.ERROR_MESSAGE);
                } else {
                    Actualizar();
                }
            }
        });
        //botones objetivosEspecificos
        vista.getBtnObjetivosEspecificos().addActionListener(e -> abrirVentObjEspecificos());
        vistObjEsp.getBtnGuardar().addActionListener(e -> datosObjEsp());
        vistObjEsp.getBtnEditar().addActionListener(e -> EditarBtnObjEsp());
        //vistObjEsp.getBtnCancelar().addActionListener(e -> CancelarObjEsp());
        //botones objt Generales
        vista.getBtnObjetivoGeneral().addActionListener(e -> abrirVentObjeGenerales());
        vistObjGene.getBtnEditar().addActionListener(e -> EditarBtnObjGen());
        vistObjGene.getBtnGuardar().addActionListener(e -> datosObjGen());
        //vistObjGene.getBtnCancelar().addActionListener(e -> CancelarObjGen());
        // guardar datos en la tabla plan de vida
        vista.getBtnGuardarplanVida().addActionListener(e -> ingresarPlanVida());
        vista.getBtnNNA().addActionListener(e -> abrirVentNNA());

        vista.getBtnVerRegist1().addActionListener(e -> AbrirEditarIngresarPlanVida());
        vista.getBtnActulizartbl().addActionListener(e -> cargarListaEditIngPlanVid());
        vista.getBtnOk().addActionListener(e -> EditarBtn());
        vista.getBtnCancelarEdit().addActionListener(e -> botonCancelarJDg(vista.getjDlgEdit()));
        vista.getBtnCanelarRegl().addActionListener(e -> botonCancelarJDg(vista.getjDlgEditTbl()));
        vista.getBtnBuscar1().addActionListener(e -> eventobuscarTexto());

    }

//    public void Buscar() {
//        eventobuscarObjEspecificos();
//        eventobuscarObjGen();
//    }
    public void cancelar(JFrame vista) {
        vista.setVisible(false);
    }

    public void botonCancelarJDg(JDialog canVista) {
        canVista.setVisible(false);
    }

    public void abrirDlgVistas(JDialog dlgVist) {
        dlgVist.setVisible(true);
        dlgVist.setSize(1200, 700);
        dlgVist.setIconImage(new ImageIcon(getClass().getResource("/iconos/icono1.png")).getImage());
    }

    public void inciaBtnBloqueados() {
        vista.getTxtNombre().setEnabled(false);
        vista.getTxtCodigo().setEnabled(false);
        vista.getBtnObjetivoGeneral().setEnabled(false);
        vista.getBtnObjetivosEspecificos().setEnabled(false);
    }

    public void abrirPlaVida() {
        vista.setVisible(true);
        vista.setLocationRelativeTo(null);
        //icono
        vista.setIconImage(new ImageIcon(getClass().getResource("/iconos/icono1.png")).getImage());
    }

    public void abrirVentObjEspecificos() {
        vistObjEsp.setVisible(true);
        vistObjEsp.setLocationRelativeTo(null);
        vistObjEsp.getBtnEditar().setEnabled(false);
        vistObjEsp.getBtnGuardar().setEnabled(true);
        vistObjEsp.setIconImage(new ImageIcon(getClass().getResource("/iconos/icono1.png")).getImage());
    }

    public void abrirVentObjeGenerales() {
        vistObjGene.setVisible(true);
        vistObjGene.setLocationRelativeTo(null);
        vistObjGene.getBtnEditar().setEnabled(false);
        vistObjGene.getBtnGuardar().setEnabled(true);
        vistObjGene.setIconImage(new ImageIcon(getClass().getResource("/iconos/icono1.png")).getImage());
    }

    public void abrirVentNNA() {
        try {
            VistaFiltroVistaVictima vistafv = new VistaFiltroVistaVictima();
            FiltroHijosVictima filtro = new FiltroHijosVictima(vistafv);
            vistafv.setVisible(true);
            vistafv.setTitle("Registro de Niños,Niñas y Adolecentes");
            vistafv.setLocationRelativeTo(null);
            vistafv.getBtnAFormu().setEnabled(false);
            vistafv.getJcb_editar().setEnabled(false);
            vistafv.getJcb_nuevo().setEnabled(false);
            vistafv.setIconImage(new ImageIcon(getClass().getResource("/iconos/icono1.png")).getImage());
        } catch (Exception ex) {
            Logger.getLogger(test_x_text.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void validaciones() {
        vistObjGene.getTxtTiempo().addKeyListener(validarNumeros(vistObjGene.getTxtTiempo()));
        vistObjEsp.getTxtTiempo().addKeyListener(validarNumeros(vistObjEsp.getTxtTiempo()));
    }

    public void limpiarObjEsp() {
        vistObjEsp.getTxtObjEspecifico().setText("");
        vistObjEsp.getTxtActividad().setText("");
        vistObjEsp.getTxtTiempo().setText("");
        vistObjEsp.getTxtApoyoDe().setText("");
        vistObjEsp.getTxtSupuestoAmenaza().setText("");
    }

    public void limpiarObjGen() {
        vistObjGene.getTxtObjGeneral().setText("");
        vistObjGene.getTxtTiempo().setText("");
        vistObjGene.getTxtObservaciones().setText("");
    }

    public void Actualizar() {
        cargaListaObjEspe();
        cargaListaObjGen();
    }

    public void CancelarObjEsp() {
        vistObjEsp.setVisible(false);
        limpiarObjEsp();
    }

    public void CancelarObjGen() {
        vistObjGene.setVisible(false);
        limpiarObjGen();
    }

    public void limpiarPlanVida() {
        vista.getTxtComSiente().setText("");
        vista.getTxtComoseVe().setText("");
        vista.getTxtComoleGustariasuVida().setText("");
        vista.getTxaVisionUFA().setText("");
    }

    public void ingresarPlanVida() {
        if (vista.getDtcFecha().getDate() == null
                || vista.getDtcFechaProximaEvaluacion().getDate() == null
                || vista.getTxtComSiente().getText().equals("")
                || vista.getTxtCedula().getText().equals("")
                || vista.getTxtNombre().getText().equals("")
                || vista.getTxtCodigo().getText().equals("")
                || vista.getTxtComoseVe().getText().equals("")
                || vista.getTxtComoleGustariasuVida().getText().equals("")
                || vista.getTxaVisionUFA().getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Llene todos los campos");
        } else {
            if (vista.getDtcFecha().getDate() == null) {
                JOptionPane.showMessageDialog(null, "Campos Vacios", "Ingrese Valores", JOptionPane.WARNING_MESSAGE);
            } else {
                if (vista.getDtcFechaProximaEvaluacion().getDate() == null) {
                    vista.getBtnGuardarplanVida().setEnabled(true);
                    JOptionPane.showMessageDialog(null, "Fecha de Evaluación vacio", "Ingrese Valores", JOptionPane.WARNING_MESSAGE);
                } else {
                    modelo.setVictima_codigo(Integer.parseInt(vista.getTxtCodigo().getText()));
                    modelo.setFecha_elaboracion(obtenerFecha(vista.getDtcFecha()));
                    modelo.setFecha_prox_evaluacion(obtenerFecha(vista.getDtcFechaProximaEvaluacion()));
                    modelo.setComosesiente(vista.getTxtComSiente().getText());
                    modelo.setComoseve(vista.getTxtComoseVe().getText());
                    modelo.setComolegustariasuvida(vista.getTxtComoleGustariasuVida().getText());
                    //metodo par el salto de linea de textArea
                    controlArea(vista.getTxaVisionUFA());
                    modelo.setVision_equipo_ufa(vista.getTxaVisionUFA().getText());

                    if (modelo.Ingresar_Plandevida()) {
                        JOptionPane.showMessageDialog(null, "Dato Insertado Correctamente");
                        vista.getBtnObjetivoGeneral().setEnabled(true);
                        vista.getBtnObjetivosEspecificos().setEnabled(true);
                        limpiarPlanVida();
                    } else {
                        JOptionPane.showMessageDialog(null, "Error al Ingresar Datos");
                    }

                }
            }
        }
    }

    public void AbrirEditarIngresarPlanVida() {
        vista.getjDlgEditTbl().setVisible(true);
        vista.getjDlgEditTbl().setSize(1200, 700);
        vista.getjDlgEditTbl().setLocationRelativeTo(null);
        cargarListaEditIngPlanVid();
    }

    private void cargarListaEditIngPlanVid() {
        int canFilas = vista.getTblEditar().getRowCount();
        for (int i = canFilas - 1; i >= 0; i--) {
            if (i > 0) {
                modeloTabEdit.removeRow(i);
            }
        }
        modeloTabEdit = (DefaultTableModel) vista.getTblEditar().getModel();
        List<Plan_de_Vida> lista;
        try {
            lista = modelo.listarPlanVid();
            int columnas = modeloTabEdit.getColumnCount();
            for (int i = 0; i < lista.size(); i++) {
                modeloTabEdit.addRow(new Object[columnas]);
                vista.getTblEditar().setValueAt(lista.get(i).getPlan_de_vida_codigo(), i, 0);
                vista.getTblEditar().setValueAt(lista.get(i).getPersona_cedula(), i, 1);
                vista.getTblEditar().setValueAt(lista.get(i).getPersona_nombre() + " " + lista.get(i).getPersona_apellido(), i, 2);
                vista.getTblEditar().setValueAt(lista.get(i).getComosesiente(), i, 3);
                vista.getTblEditar().setValueAt(lista.get(i).getComoseve(), i, 4);
                vista.getTblEditar().setValueAt(lista.get(i).getComolegustariasuvida(), i, 5);
                vista.getTblEditar().setValueAt(lista.get(i).getVision_equipo_ufa(), i, 6);
                vista.getTblEditar().setValueAt(lista.get(i).getFecha_elaboracion(), i, 7);
                vista.getTblEditar().setValueAt(lista.get(i).getFecha_prox_evaluacion(), i, 8);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ControladorFichaIngreso.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void AbrirEditarPlanVid() {
        vista.getjDlgEdit().setVisible(true);
        vista.getjDlgEdit().setSize(880, 400);
        vista.getjDlgEdit().setLocationRelativeTo(null);

    }

    public void popTable() {
        JPopupMenu pM = new JPopupMenu();
        JMenuItem itemEdit = new JMenuItem("EDITAR");
        JMenuItem itemEliminar = new JMenuItem("ELIMINAR");
        itemEdit.addActionListener((ActionEvent e) -> {
            Editar();
        });
        itemEliminar.addActionListener((ActionEvent e) -> {
            eliminarPlanVida();
        });
        pM.add(itemEdit);
        pM.add(itemEliminar);
        vista.getTblEditar().setComponentPopupMenu(pM);
    }

    public void Editar() {
        DefaultTableModel modeloTabla = (DefaultTableModel) vista.getTblEditar().getModel();
        int fsel = vista.getTblEditar().getSelectedRow();
        if (fsel == -1) {
            JOptionPane.showMessageDialog(null, "Seleccione una fila ó Actualize lista", "Verificación", JOptionPane.WARNING_MESSAGE);
        } else {
            String cod = modeloTabla.getValueAt(vista.getTblEditar().getSelectedRow(), 0).toString();
            String comoseSinte = modeloTabla.getValueAt(vista.getTblEditar().getSelectedRow(), 3).toString();
            String alcanzaObj = modeloTabla.getValueAt(vista.getTblEditar().getSelectedRow(), 4).toString();
            String dificultadesEnc = modeloTabla.getValueAt(vista.getTblEditar().getSelectedRow(), 5).toString();
            String vision = modeloTabla.getValueAt(vista.getTblEditar().getSelectedRow(), 6).toString();

            vista.getLblCodEdit().setText(cod);
            vista.getTxtComSienteEdit().setText(comoseSinte);
            vista.getTxtCmoseveEdit().setText(alcanzaObj);
            vista.getTxtcomlegustariavidaEdit().setText(dificultadesEnc);
            vista.getTxaVisionEdit().setText(vision);
            System.out.println("getTxt.setetxt" + vision);

            vista.getjDlgEdit().setTitle("Editar Plan de Vida");
            AbrirEditarPlanVid();
        }
    }

    public void EditarBtn() {
        modelo.setPlan_de_vida_codigo(Integer.parseInt(vista.getLblCodEdit().getText()));
        modelo.setComosesiente(vista.getTxtComSienteEdit().getText());
        modelo.setComoseve(vista.getTxtCmoseveEdit().getText());
        modelo.setComolegustariasuvida(vista.getTxtcomlegustariavidaEdit().getText());
        modelo.setVision_equipo_ufa(vista.getTxaVisionEdit().getText());

        if (modelo.actualizar()) {
            JOptionPane.showMessageDialog(null, "Datos actualizados correctamente");
            vista.getjDlgEdit().setVisible(false);
            cargarListaEditIngPlanVid();

            vista.getTxtComSienteEdit().setText("");
            vista.getTxtComSienteEdit().setText("");
            vista.getTxtcomlegustariavidaEdit().setText("");
            vista.getTxaVisionEdit().setText("");
        } else {
            JOptionPane.showMessageDialog(null, "Error al actualizar Datos.");
        }
    }

    public void eventobuscarTexto() {
        System.out.println("buscando");
        int canFilas = vista.getTblEditar().getRowCount();
        for (int i = canFilas - 1; i >= 0; i--) {
            modeloTabEdit.removeRow(i);
        }

        modeloTabEdit = (DefaultTableModel) vista.getTblEditar().getModel();
        List<Plan_de_Vida> lista;
        try {
            lista = modelo.buscarTextoPlanVid(vista.getTxtBuscar().getText().toUpperCase());
            System.out.println("letra: " + vista.getTxtBuscar().getText().toUpperCase());
            int columnas = modeloTabEdit.getColumnCount();
            for (int i = 0; i < lista.size(); i++) {
                modeloTabEdit.addRow(new Object[columnas]);
                vista.getTblEditar().setValueAt(lista.get(i).getPlan_de_vida_codigo(), i, 0);
                vista.getTblEditar().setValueAt(lista.get(i).getPersona_cedula(), i, 1);
                vista.getTblEditar().setValueAt(lista.get(i).getPersona_nombre() + " " + lista.get(i).getPersona_apellido(), i, 2);
                vista.getTblEditar().setValueAt(lista.get(i).getComosesiente(), i, 3);
                vista.getTblEditar().setValueAt(lista.get(i).getComoseve(), i, 4);
                vista.getTblEditar().setValueAt(lista.get(i).getComolegustariasuvida(), i, 5);
                vista.getTblEditar().setValueAt(lista.get(i).getVision_equipo_ufa(), i, 6);
                vista.getTblEditar().setValueAt(lista.get(i).getFecha_elaboracion(), i, 7);
                vista.getTblEditar().setValueAt(lista.get(i).getFecha_prox_evaluacion(), i, 8);
            }
            if (vista.getTxtBuscar().getText().length() == 0) {
                cargarListaEditIngPlanVid();
            }

        } catch (SQLException ex) {
            Logger.getLogger(ControladorPlandeVida.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
    }
    //--------------------------------Eliminar-------------------------------------

    private void eliminarPlanVida() {
        int fsel = vista.getTblEditar().getSelectedRow();
        if (fsel == -1) {
            JOptionPane.showMessageDialog(null, "Seleccione una fila para eliminar ó Actualiza la lista.", "Verificación", JOptionPane.WARNING_MESSAGE);
        } else {
            int desicion = JOptionPane.showConfirmDialog(null, "Esta seguro de que desea Borrar este Registro?");
            if (desicion == JOptionPane.YES_OPTION) {
                DefaultTableModel modeloTabla = (DefaultTableModel) vista.getTblEditar().getModel();
                String cod = modeloTabla.getValueAt(vista.getTblEditar().getSelectedRow(), 0).toString();
                modelo.setPlan_de_vida_codigo(Integer.parseInt(cod));
                System.out.println(cod);
                if (modelo.eliminarPlanVid()) {
                    JOptionPane.showMessageDialog(null, "Dato borrado correctamente");
                    cargarListaEditIngPlanVid();
                } else {
                    JOptionPane.showMessageDialog(null, "Dato no borrado");
                }
            }

        }
    }

    public void datosObjEsp() {
        if (vistObjEsp.getTxtObjEspecifico().getText().equals("")
                || vistObjEsp.getTxtActividad().getText().equals("")
                || vistObjEsp.getTxtTiempo().getText().equals("")
                || vistObjEsp.getTxtApoyoDe().getText().equals("")
                || vistObjEsp.getTxtSupuestoAmenaza().getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Llene todos los campos");
        } else {
            System.out.println("1");
            objEspeModelDB.setPlan_de_vida(modelo.maxId());
            objEspeModelDB.setPersonal_codigo(modelo.verifiUserP(personal_cod));
            objEspeModelDB.setObejtivosEspecificos(vistObjEsp.getTxtObjEspecifico().getText());
            objEspeModelDB.setActividad(vistObjEsp.getTxtActividad().getText());
            objEspeModelDB.setTiempo(vistObjEsp.getTxtTiempo().getText());
            objEspeModelDB.setApoyode(vistObjEsp.getTxtApoyoDe().getText());
            objEspeModelDB.setSupu_amenazas(vistObjEsp.getTxtSupuestoAmenaza().getText());

            if (objEspeModelDB.insertarPvObjectivEspecif()) {
                JOptionPane.showMessageDialog(null, "Datos Insertados Correctamente");
                cargaListaObjEspe();
                vistObjEsp.setVisible(false);
                limpiarObjEsp();
            } else {
                JOptionPane.showMessageDialog(null, "Error al Ingresar Datos");
            }
        }
    }

    public void cargaListaObjEspe() {
        int canFilas = vista.getTabObjetivosEspecificos().getRowCount();
        for (int i = canFilas - 1; i >= 0; i--) {
            if (i != 0) {
                modeloTabOE.removeRow(i);
            }

        }
        modeloTabOE = (DefaultTableModel) vista.getTabObjetivosEspecificos().getModel();
        List<Pv_objeticos_especificos> lista;
        try {
            lista = objEspeModelDB.listarPvObjetivEsp(Integer.parseInt(vista.getTxtCodigo().getText()));
            int columnas = modeloTabOE.getColumnCount();
            for (int i = 0; i < lista.size(); i++) {
                modeloTabOE.addRow(new Object[columnas]);
                vista.getTabObjetivosEspecificos().setValueAt(lista.get(i).getObj_espe_codigo(), i, 0);
                vista.getTabObjetivosEspecificos().setValueAt(lista.get(i).getObejtivosEspecificos(), i, 1);
                vista.getTabObjetivosEspecificos().setValueAt(lista.get(i).getPersonal_codigo(), i, 2);
                vista.getTabObjetivosEspecificos().setValueAt(lista.get(i).getActividad(), i, 3);
                vista.getTabObjetivosEspecificos().setValueAt(lista.get(i).getTiempo(), i, 4);
                vista.getTabObjetivosEspecificos().setValueAt(lista.get(i).getApoyode(), i, 5);
                vista.getTabObjetivosEspecificos().setValueAt(lista.get(i).getSupu_amenazas(), i, 6);
            }
        } catch (Exception ex) {
            System.out.println("Error en plan de vida metodo cargaListaObjEspe(): " + ex.getMessage());
        }
    }

    public void popTableObjEsp() {
        JPopupMenu pM = new JPopupMenu();
        JMenuItem itemEdit = new JMenuItem("EDITAR");
        JMenuItem itemEliminar = new JMenuItem("ELIMINAR");
        itemEdit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                EditarObjEsp();
                abrirVentObjEspecificos();
                vistObjEsp.getBtnEditar().setEnabled(true);
                vistObjEsp.getBtnGuardar().setEnabled(false);
            }
        });
        itemEliminar.addActionListener((ActionEvent e) -> {
            eliminarObjetoEspecifico();
        });
        pM.add(itemEdit);
        pM.add(itemEliminar);
        vista.getTabObjetivosEspecificos().setComponentPopupMenu(pM);
    }

    public void EditarObjEsp() {
        DefaultTableModel modeloTabla = (DefaultTableModel) vista.getTabObjetivosEspecificos().getModel();
        int fsel = vista.getTabObjetivosEspecificos().getSelectedRow();
        if (fsel == -1) {
            JOptionPane.showMessageDialog(null, "Seleccione una fila ó Actualize lista", "Verificación", JOptionPane.WARNING_MESSAGE);
        } else {
            String cod = modeloTabla.getValueAt(vista.getTabObjetivosEspecificos().getSelectedRow(), 0).toString();
            String ObjetivoEsp = modeloTabla.getValueAt(vista.getTabObjetivosEspecificos().getSelectedRow(), 1).toString();
            String res = modeloTabla.getValueAt(vista.getTabObjetivosEspecificos().getSelectedRow(), 2).toString();
            String activ = modeloTabla.getValueAt(vista.getTabObjetivosEspecificos().getSelectedRow(), 3).toString();
            String tiemp = modeloTabla.getValueAt(vista.getTabObjetivosEspecificos().getSelectedRow(), 4).toString();
            String apoyo = modeloTabla.getValueAt(vista.getTabObjetivosEspecificos().getSelectedRow(), 5).toString();
            String supuest = modeloTabla.getValueAt(vista.getTabObjetivosEspecificos().getSelectedRow(), 6).toString();

            vistObjEsp.getLblCodigo().setText(cod);
            vistObjEsp.getTxtObjEspecifico().setText(ObjetivoEsp);
            vistObjEsp.getTxtResponsable().setText(res);
            vistObjEsp.getTxtActividad().setText(activ);
            vistObjEsp.getTxtTiempo().setText(tiemp);
            vistObjEsp.getTxtApoyoDe().setText(apoyo);
            vistObjEsp.getTxtSupuestoAmenaza().setText(supuest);
            vistObjEsp.setTitle("Editar Objetivos Especificos");
        }
    }

    public void EditarBtnObjEsp() {
        objEspeModelDB.setObj_espe_codigo(Integer.parseInt(vistObjEsp.getLblCodigo().getText()));
        objEspeModelDB.setObejtivosEspecificos(vistObjEsp.getTxtObjEspecifico().getText());
        objEspeModelDB.setActividad(vistObjEsp.getTxtActividad().getText());
        objEspeModelDB.setTiempo(vistObjEsp.getTxtTiempo().getText());
        objEspeModelDB.setApoyode(vistObjEsp.getTxtApoyoDe().getText());
        objEspeModelDB.setSupu_amenazas(vistObjEsp.getTxtSupuestoAmenaza().getText());
        if (objEspeModelDB.actualizarPvObjEsp()) {
            JOptionPane.showMessageDialog(null, "Editado Objetivos Especificos correctamente");
            vistObjEsp.setVisible(false);
            cargaListaObjEspe();

            vistObjEsp.getTxtObjEspecifico().setText("");
            vistObjEsp.getTxtActividad().setText("");
            vistObjEsp.getTxtTiempo().setText("");
            vistObjEsp.getTxtApoyoDe().setText("");
            vistObjEsp.getTxtSupuestoAmenaza().setText("");

        } else {
            JOptionPane.showMessageDialog(null, "Error al actualizar Datos.");

        }
    }
    //--------------------------------Eliminar objetivo Escifico-------------------------------------

    private void eliminarObjetoEspecifico() {
        int fsel = vista.getTabObjetivosEspecificos().getSelectedRow();
        if (fsel == -1) {
            JOptionPane.showMessageDialog(null, "Seleccione una fila para eliminar ó Actualiza la lista.", "Verificación", JOptionPane.WARNING_MESSAGE);
        } else {
            int desicion = JOptionPane.showConfirmDialog(null, "Esta seguro de que desea Borrar este Registro?");
            if (desicion == JOptionPane.YES_OPTION) {
                DefaultTableModel modeloTabla = (DefaultTableModel) vista.getTabObjetivosEspecificos().getModel();
                String cod = modeloTabla.getValueAt(vista.getTabObjetivosEspecificos().getSelectedRow(), 0).toString();
                objEspeModelDB.setObj_espe_codigo(Integer.parseInt(cod));
                System.out.println(cod);
                if (objEspeModelDB.eliminarObEsp()) {
                    JOptionPane.showMessageDialog(null, "Dato borrado correctamente");
                    cargaListaObjEspe();
                } else {
                    JOptionPane.showMessageDialog(null, "Dato no borrado");
                }
            }

        }
    }

    public void datosObjGen() {
        if (vistObjGene.getTxtObjGeneral().getText().equals("")
                || vistObjGene.getTxtTiempo().getText().equals("")
                || vistObjGene.getTxtObservaciones().getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Llene todos los campos");
        } else {
            objGeModlDB.setPlanvida_codigo(modelo.maxId());
            objGeModlDB.setPersonal_codigo(modelo.verifiUserP(personal_cod));
            objGeModlDB.setObejtivoGeneral(vistObjGene.getTxtObjGeneral().getText());
            objGeModlDB.setTiempo(vistObjGene.getTxtTiempo().getText());
            objGeModlDB.setObservaciones(vistObjGene.getTxtObservaciones().getText());

            if (objGeModlDB.insertarPvObjeGen()) {
                JOptionPane.showMessageDialog(null, "Datos Insertados Correctamente");
                cargaListaObjGen();
                vistObjGene.setVisible(false);
                limpiarObjGen();
            } else {
                JOptionPane.showMessageDialog(null, "Error al Ingresar Datos");
            }
        }

    }

    public void cargaListaObjGen() {
        int canFilas = vista.getTabObjetivoGeneral().getRowCount();
        for (int i = canFilas - 1; i >= 0; i--) {
            modeloTabOG.removeRow(i);
        }

        modeloTabOG = (DefaultTableModel) vista.getTabObjetivoGeneral().getModel();
        List<Pv_objetivos_gene> lista;

        try {
            System.out.println(vista.getTxtCodigo().getText());
            lista = objGeModlDB.listarPvObjeGen(Integer.parseInt(vista.getTxtCodigo().getText()));

            int columnas = modeloTabOG.getColumnCount();
            for (int i = 0; i < lista.size(); i++) {
                modeloTabOG.addRow(new Object[columnas]);
                vista.getTabObjetivoGeneral().setValueAt(lista.get(i).getObj_codigo_gene(), i, 0);
                vista.getTabObjetivoGeneral().setValueAt(lista.get(i).getObejtivoGeneral(), i, 1);
                vista.getTabObjetivoGeneral().setValueAt(lista.get(i).getPersonal_codigo(), i, 2);
                vista.getTabObjetivoGeneral().setValueAt(lista.get(i).getTiempo(), i, 3);
                vista.getTabObjetivoGeneral().setValueAt(lista.get(i).getObservaciones(), i, 4);
            }
        } catch (Exception ex) {
            System.out.println("Error en plan de vida objetivogeneral_controlador: " + ex.getMessage());
        }
    }

    public void popTableObjGen() {
        JPopupMenu pM = new JPopupMenu();
        JMenuItem itemEdit = new JMenuItem("EDITAR");
        JMenuItem itemEliminar = new JMenuItem("ELIMINAR");
        itemEdit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                EditarObjGen();
                abrirVentObjeGenerales();
                vistObjGene.getBtnEditar().setEnabled(true);
                vistObjGene.getBtnGuardar().setEnabled(false);
            }
        });
        itemEliminar.addActionListener((ActionEvent e) -> {
            eliminarObjetoGeneral();
        });
        pM.add(itemEdit);
        pM.add(itemEliminar);
        vista.getTabObjetivoGeneral().setComponentPopupMenu(pM);
    }

    public void EditarObjGen() {
        DefaultTableModel modeloTabla = (DefaultTableModel) vista.getTabObjetivoGeneral().getModel();
        int fsel = vista.getTabObjetivoGeneral().getSelectedRow();
        if (fsel == -1) {
            JOptionPane.showMessageDialog(null, "Seleccione una fila ó Actualize lista", "Verificación", JOptionPane.WARNING_MESSAGE);
        } else {
            String cod = modeloTabla.getValueAt(vista.getTabObjetivoGeneral().getSelectedRow(), 0).toString();
            String ObjetivoGen = modeloTabla.getValueAt(vista.getTabObjetivoGeneral().getSelectedRow(), 1).toString();
            String res = modeloTabla.getValueAt(vista.getTabObjetivoGeneral().getSelectedRow(), 2).toString();
            String tiempo = modeloTabla.getValueAt(vista.getTabObjetivoGeneral().getSelectedRow(), 3).toString();
            String obser = modeloTabla.getValueAt(vista.getTabObjetivoGeneral().getSelectedRow(), 4).toString();

            vistObjGene.getLblCodigo().setText(cod);
            vistObjGene.getTxtObjGeneral().setText(ObjetivoGen);
            vistObjGene.getTxtResponsable().setText(res);
            vistObjGene.getTxtTiempo().setText(tiempo);
            vistObjGene.getTxtObservaciones().setText(obser);

            vistObjGene.setTitle("Editar Objetivos Generales");
        }
    }

    public void EditarBtnObjGen() {
        objGeModlDB.setObj_codigo_gene(Integer.parseInt(vistObjGene.getLblCodigo().getText()));
        objGeModlDB.setObejtivoGeneral(vistObjGene.getTxtObjGeneral().getText());
        objGeModlDB.setTiempo(vistObjGene.getTxtTiempo().getText());
        objGeModlDB.setObservaciones(vistObjGene.getTxtObservaciones().getText());

        if (objGeModlDB.actualizarPvObjGen()) {
            JOptionPane.showMessageDialog(null, "Datos Editados correctamente");
            vistObjGene.setVisible(false);
            cargaListaObjGen();
            vistObjGene.getTxtObjGeneral().setText("");
            vistObjGene.getTxtTiempo().setText("");
            vistObjGene.getTxtObservaciones().setText("");
        } else {
            JOptionPane.showMessageDialog(null, "Error al actualizar Datos.");

        }
    }

    //--------------------------------Eliminar objetivo general-------------------------------------
    private void eliminarObjetoGeneral() {
        int fsel = vista.getTabObjetivoGeneral().getSelectedRow();
        if (fsel == -1) {
            JOptionPane.showMessageDialog(null, "Seleccione una fila para eliminar ó Actualiza la lista.", "Verificación", JOptionPane.WARNING_MESSAGE);
        } else {
            int desicion = JOptionPane.showConfirmDialog(null, "Esta seguro de que desea Borrar este Registro?");
            if (desicion == JOptionPane.YES_OPTION) {
                DefaultTableModel modeloTabla = (DefaultTableModel) vista.getTabObjetivoGeneral().getModel();
                String cod = modeloTabla.getValueAt(vista.getTabObjetivoGeneral().getSelectedRow(), 0).toString();
                objGeModlDB.setObj_codigo_gene(Integer.parseInt(cod));
                System.out.println(cod);
                if (objGeModlDB.eliminarObjGen()) {
                    JOptionPane.showMessageDialog(null, "Dato borrado correctamente");
                    cargaListaObjGen();
                } else {
                    JOptionPane.showMessageDialog(null, "Dato no borrado");
                }
            }

        }
    }
    
    public KeyListener verificar() { // al hacer un enter realizar una acción 
        KeyListener kn = new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
            }
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    if (!vista.getTxtCodigo().getText().equals("")) {
                        int vic = Integer.parseInt(vista.getTxtCodigo().getText());
                        if (modelo.idvic(vic)) {
                            vista.getBtnGuardarplanVida().setEnabled(false);
                            JOptionPane.showMessageDialog(vista, "Datos de benficiaria ya ingresados");
                            AbrirEditarIngresarPlanVida();
                            vista.getTxtBuscar().setText(vista.getTxtCedula().getText());
                             eventobuscarTexto();
                        }else{
                            vista.getBtnGuardarplanVida().setEnabled(true);
                        }
                    }
                }
            }
            @Override
            public void keyReleased(KeyEvent e) {

            }
        };
        return kn;
    }
}
