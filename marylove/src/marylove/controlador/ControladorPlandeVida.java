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
import marylove.DBmodelo.Plan_devidaDB;
import marylove.DBmodelo.PvObjetivosEspecDB;
import marylove.DBmodelo.PvObjetivosGeneDB;
import marylove.conexion.Conexion;
import static marylove.controlador.C_Login.personal_cod;
import marylove.models.Pv_objeticos_especificos;
import marylove.models.Pv_objetivos_gene;
import marylove.vista.FichaPlandeVida;
import marylove.vista.VistaDefinicionObjetivosEspecifico;
import marylove.vista.vistaAgregarObjetivoGenera;

/**
 *
 * @author USUARIO
 */
public class ControladorPlandeVida extends Validaciones {

    private Conexion conex;
    DefaultTableModel modeloTabOE;
    DefaultTableModel modeloTabOG;
    DefaultTableModel modeloTabEdit;
    private FichaPlandeVida vista;
    private PvObjetivosGeneDB objGeModlDB;
    private PvObjetivosEspecDB objEspeModelDB;
    private Pv_objetivos_gene objGeMOdel;
    private Pv_objeticos_especificos objEspeMdel;
    private VistaDefinicionObjetivosEspecifico vistObjEsp;
    private vistaAgregarObjetivoGenera vistObjGene;

    Plan_devidaDB modelo = new Plan_devidaDB();

    public ControladorPlandeVida(FichaPlandeVida vista, PvObjetivosGeneDB objGeModlDB, PvObjetivosEspecDB objEspeModelDB, Pv_objetivos_gene objGeMOdel, Pv_objeticos_especificos objEspeMdel, VistaDefinicionObjetivosEspecifico vistObjEsp, vistaAgregarObjetivoGenera vistObjGene) {
        this.vista = vista;
        this.objGeModlDB = objGeModlDB;
        this.objEspeModelDB = objEspeModelDB;
        this.objGeMOdel = objGeMOdel;
        this.objEspeMdel = objEspeMdel;
        this.vistObjEsp = vistObjEsp;
        this.vistObjGene = vistObjGene;
    }
 
    public void iniciarControl() {
        cargaListaObjEspe();
//        abrirPlaVida();
        inciaBtnBloqueados();
        validaciones();
        //popTable();
        popTableObjGen();
        popTableObjEsp();
        vista.getTxtNombre().addKeyListener(validarLetras(vista.getTxtNombre()));
        vista.getTxtCodigo().addKeyListener(validarNumeros(vista.getTxtCodigo()));
        vista.getTxtCedula().addKeyListener(validarCedula(vista.getTxtCedula()));
        vista.getTxtCedula().addKeyListener(enter1(vista.getTxtCedula(), vista.getTxtNombre(), vista.getTxtCodigo()));
        Calendar c2 = new GregorianCalendar();
        vista.getDtcFecha().setCalendar(c2);
        vista.getBtnActualizar().addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                if (vista.getTxtCodigo().getText().isEmpty()) {
                    JOptionPane.showMessageDialog(null,"Debe Ingresar Cédula", "Error", JOptionPane.ERROR_MESSAGE);
                }else{
                    Actualizar();
                }
            }
        });
        vista.getBtnObjetivosEspecificos().addActionListener(e -> abrirVentObjEspecificos());
        vista.getBtnObjetivoGeneral().addActionListener(e -> abrirVentObjeGenerales());
        vistObjEsp.getBtnGuardar().addActionListener(e -> datosObjEsp());
        vistObjEsp.getBtnEditar().addActionListener(e -> EditarBtnObjEsp());
        vistObjGene.getBtnEditar().addActionListener(e -> EditarBtnObjGen());
        vistObjGene.getBtnGuardar().addActionListener(e -> datosObjGen());
        vista.getBtnGuardarplanVida().addActionListener(e -> ingresarPlanVida());
    }

    public void inciaBtnBloqueados() {
        vista.getTxtNombre().setEnabled(false);
        vista.getTxtCodigo().setEnabled(false);
        vista.getBtnObjetivoGeneral().setEnabled(false);
        vista.getBtnObjetivosEspecificos().setEnabled(false);
        //vista.getBtnGuardarplanVida().setEnabled(false);
    }

    public void abrirPlaVida() {
        vista.setVisible(true);
        vista.setLocationRelativeTo(null);
    }

    public void abrirVentObjEspecificos() {
        vistObjEsp.setVisible(true);
        vistObjEsp.setLocationRelativeTo(null);
        vistObjEsp.getBtnEditar().setEnabled(false);
        vistObjEsp.getBtnGuardar().setEnabled(true);
    }

    public void abrirVentObjeGenerales() {
        vistObjGene.setVisible(true);
        vistObjGene.setLocationRelativeTo(null);
        vistObjGene.getBtnEditar().setEnabled(false);
        vistObjGene.getBtnGuardar().setEnabled(true);
    }

    public void validaciones() {
        vistObjGene.getTxtTiempo().addKeyListener(validarNumeros(vistObjGene.getTxtTiempo()));
        vistObjEsp.getTxtTiempo().addKeyListener(validarNumeros(vistObjEsp.getTxtTiempo()));
    }
    public void ingresarPlanVida() {
        if (vista.getDtcFecha().getDate()== null
                || vista.getDtcFechaProximaEvaluacion().getDate() == null
                || vista.getTxtComSiente().getText().equals("")
                || vista.getTxtComoseVe().getText().equals("")
                || vista.getTxtComoleGustariasuVida().getText().equals("")) {
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
                if (modelo.Ingresar_Plandevida()) {
                    JOptionPane.showMessageDialog(null, "Dato Insertado Correctamente");
                    vista.getBtnObjetivoGeneral().setEnabled(true);
                    vista.getBtnObjetivosEspecificos().setEnabled(true);
                    
                } else {
                    JOptionPane.showMessageDialog(null, "Error al Ingresar Datos");
                }
            }
        }
    }
    }

    public void Actualizar() {
        cargaListaObjEspe();
        cargaListaObjGen();
    }

    public void datosObjEsp() {
        System.out.println("entr");
        if (vistObjEsp.getTxtObjEspecifico().getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Campos Vacios", "Ingrese Valores", JOptionPane.WARNING_MESSAGE);
        } else {
            if (vistObjEsp.getTxtActividad().getText().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Campos Vacios", "Ingrese Valores", JOptionPane.WARNING_MESSAGE);
            } else {
                if (vistObjEsp.getTxtTiempo().getText().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Campos Vacios", "Ingrese Valores", JOptionPane.WARNING_MESSAGE);
                } else {
                    if (vistObjEsp.getTxtApoyoDe().getText().isEmpty()) {
                        JOptionPane.showMessageDialog(null, "Campos Vacios", "Ingrese Valores", JOptionPane.WARNING_MESSAGE);
                    } else {
                        if (vistObjEsp.getTxtSupuestoAmenaza().getText().isEmpty()) {
                            JOptionPane.showMessageDialog(null, "Campos Vacios", "Ingrese Valores", JOptionPane.WARNING_MESSAGE);
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
                            } else {
                                JOptionPane.showMessageDialog(null, "Error al Ingresar Datos");
                            }
                        }
                    }
                }
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
                //fila del codigo responsable 
                vista.getTabObjetivosEspecificos().setValueAt(lista.get(i).getActividad(), i, 3);
                vista.getTabObjetivosEspecificos().setValueAt(lista.get(i).getTiempo(), i, 4);
                vista.getTabObjetivosEspecificos().setValueAt(lista.get(i).getApoyode(), i, 5);
                vista.getTabObjetivosEspecificos().setValueAt(lista.get(i).getSupu_amenazas(), i, 6);

            }

        } catch (Exception ex) {
            System.out.println("Error en plan de vida objetivoespecifico_controlador: " + ex.getMessage());
        }
    }

    public void popTableObjEsp() {
        JPopupMenu pM = new JPopupMenu();
        JMenuItem itemEdit = new JMenuItem("EDITAR");
        itemEdit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                EditarObjEsp();
                abrirVentObjEspecificos();
                vistObjEsp.getBtnEditar().setEnabled(true);
                vistObjEsp.getBtnGuardar().setEnabled(false);
            }
        });
        pM.add(itemEdit);
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
            //falta responsable
            String activ = modeloTabla.getValueAt(vista.getTabObjetivosEspecificos().getSelectedRow(), 3).toString();
            String tiemp = modeloTabla.getValueAt(vista.getTabObjetivosEspecificos().getSelectedRow(), 4).toString();
            String apoyo = modeloTabla.getValueAt(vista.getTabObjetivosEspecificos().getSelectedRow(), 4).toString();
            String supuest = modeloTabla.getValueAt(vista.getTabObjetivosEspecificos().getSelectedRow(), 4).toString();

            vistObjEsp.getLblCodigo().setText(cod);
            vistObjEsp.getTxtObjEspecifico().setText(ObjetivoEsp);
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

    public void datosObjGen() {
        if (vistObjGene.getTxtObjGeneral().getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Campos Vacios", "Ingrese Valores", JOptionPane.WARNING_MESSAGE);
        } else {
            if (vistObjGene.getTxtTiempo().getText().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Campos Vacios", "Ingrese Valores", JOptionPane.WARNING_MESSAGE);
            } else {
                if (vistObjGene.getTxtObservaciones().getText().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Campos Vacios", "Ingrese Valores", JOptionPane.WARNING_MESSAGE);
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
                    } else {
                        JOptionPane.showMessageDialog(null, "Error al Ingresar Datos");
                    }
                }
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
                //fila del codigo responsable 
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
        itemEdit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                EditarObjGen();
                abrirVentObjeGenerales();
                vistObjGene.getBtnEditar().setEnabled(true);
                vistObjGene.getBtnGuardar().setEnabled(false);
            }
        });
        pM.add(itemEdit);
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
            //falta responsable
            String tiempo = modeloTabla.getValueAt(vista.getTabObjetivoGeneral().getSelectedRow(), 3).toString();
            String obser = modeloTabla.getValueAt(vista.getTabObjetivoGeneral().getSelectedRow(), 4).toString();

            vistObjGene.getLblCodigo().setText(cod);
            vistObjGene.getTxtObjGeneral().setText(ObjetivoGen);
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
}


