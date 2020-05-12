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
import marylove.DBmodelo.DefinicionObjetivosEspecificosDB;
import marylove.DBmodelo.DefinicionObjetivosGeneralDB;
import marylove.DBmodelo.Plan_devidaDB;
import marylove.conexion.Conexion;
import static marylove.controlador.C_Login.personal_cod;
import marylove.models.DefinicionObjetivosEspecifico;
import marylove.models.DefinicionObjetivosGeneral;
import marylove.models.PercepcionFamiliar;
import marylove.vista.FichaPlandeVida;
import marylove.vista.VistaDefinicionObjetivosEspecifico;
import marylove.vista.vistaAgregarObjetivoGenera;

/**
 *
 * @author USUARIO
 */
public class ControladorPlandeVida extends Validaciones {

    private final FichaPlandeVida vista;
    private final Plan_devidaDB modelo;
    private Conexion conex;
    DefaultTableModel modeloTabOE;
    DefaultTableModel modeloTabOG;
    DefaultTableModel modeloTabEdit;
    private DefinicionObjetivosGeneralDB objGeModelDB;
    private DefinicionObjetivosEspecificosDB objEspeModelDB;
    private DefinicionObjetivosGeneral objGeMOdel;
    private DefinicionObjetivosEspecifico objEspeMdel;
    private VistaDefinicionObjetivosEspecifico vistObjEsp;
    private vistaAgregarObjetivoGenera vistObjGene;

    public ControladorPlandeVida(FichaPlandeVida vista, Plan_devidaDB modelo, DefinicionObjetivosGeneralDB objGeModelDB, DefinicionObjetivosEspecificosDB objEspeModelDB, DefinicionObjetivosGeneral objGeMOdel, DefinicionObjetivosEspecifico objEspeMdel, VistaDefinicionObjetivosEspecifico vistObjEsp, vistaAgregarObjetivoGenera vistObjGene) {
        this.vista = vista;
        this.modelo = modelo;
        this.objGeModelDB = objGeModelDB;
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
        popTableObjGen();
        popTableObjEsp();
        vista.getTxtNombre().addKeyListener(validarLetras(vista.getTxtNombre()));
        vista.getTxtCodigo().addKeyListener(validarNumeros(vista.getTxtCodigo()));
        vista.getTxtCedula().addKeyListener(validarCedula(vista.getTxtCedula()));
        vista.getTxtCedula().addKeyListener(enter1(vista.getTxtCedula(), vista.getTxtNombre(), vista.getTxtCodigo()));
        Calendar c2 = new GregorianCalendar();
        vista.getDtcFecha().setCalendar(c2);
        vista.getBtnObjetivosEspecificos().addActionListener(e -> abrirVentObjEspecificos());
        vista.getBtnObjetivoGeneral().addActionListener(e -> abrirVentObjeGenerales());
        vistObjEsp.getBtnGuardar ().addActionListener(e -> datosObjEsp());
    vistObjEsp.getBtnEditar ().addActionListener(e -> EditarBtnObjEsp());
    vistObjGene.getBtnEditar ().addActionListener(e-> EditarBtnObjGen());
    vistObjGene.getBtnGuardar ().addActionListener(e -> datosObjGen());
    vista.getBtnGuardar().addActionListener(e -> ingresarPlanVida());

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

    public void Actualizar(){
        cargaListaObjEspe();
        cargaListaObjGen();
    }
    
    public void datosObjEsp() {
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
                            //objEspeModelDB.setEvaluacion_id(evalPlModelDB.maxId());
                            //objEspeModelDB.setResponsoble(modelo.verifiUserP(personal_cod));
                            objEspeModelDB.setObjetivosEspecificos(vistObjEsp.getTxtObjEspecifico().getText());
                            objEspeModelDB.setActividad(vistObjEsp.getTxtActividad().getText());
                            objEspeModelDB.setTiempo(vistObjEsp.getTxtTiempo().getText());
                            objEspeModelDB.setApoyode(vistObjEsp.getTxtApoyoDe().getText());
                            objEspeModelDB.setSupuestosAmenazas(vistObjEsp.getTxtSupuestoAmenaza().getText());

                            if (objEspeModelDB.insertarObjectivEspecif()) {
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
        List<DefinicionObjetivosEspecifico> lista;

        try {
            lista = objEspeModelDB.listartObjetiv(Integer.parseInt(vista.getTxtCodigo().getText()));
            int columnas = modeloTabOE.getColumnCount();
            for (int i = 0; i < lista.size(); i++) {
                modeloTabOE.addRow(new Object[columnas]);
                vista.getTabObjetivosEspecificos().setValueAt(lista.get(i).getDefinicion_id(), i, 0);
                vista.getTabObjetivosEspecificos().setValueAt(lista.get(i).getObjetivosEspecificos(), i, 1);
                //fila del codigo responsable 
                vista.getTabObjetivosEspecificos().setValueAt(lista.get(i).getActividad(), i, 3);
                vista.getTabObjetivosEspecificos().setValueAt(lista.get(i).getTiempo(), i, 4);
                vista.getTabObjetivosEspecificos().setValueAt(lista.get(i).getApoyode(), i, 5);
                vista.getTabObjetivosEspecificos().setValueAt(lista.get(i).getSupuestosAmenazas(), i, 6);

}

        } catch (Exception ex) {
            System.out.println("Error en plan de vida: "+ ex.getMessage());
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
        objEspeModelDB.setDefinicion_id(Integer.parseInt(vistObjEsp.getLblCodigo().getText()));
        objEspeModelDB.setObjetivosEspecificos(vistObjEsp.getTxtObjEspecifico().getText());
        objEspeModelDB.setActividad(vistObjEsp.getTxtActividad().getText());
        objEspeModelDB.setTiempo(vistObjEsp.getTxtTiempo().getText());
        objEspeModelDB.setApoyode(vistObjEsp.getTxtApoyoDe().getText());
        objEspeModelDB.setSupuestosAmenazas(vistObjEsp.getTxtSupuestoAmenaza().getText());
        if (objEspeModelDB.actualizarObjEsp()) {
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
                    //objGeModelDB.setEvaluacion_id(modelo.maxId());
                    //objGeModelDB.setResponsable(modelo.verifiUserP(personal_cod));
                    objGeModelDB.setObjetivo_general(vistObjGene.getTxtObjGeneral().getText());
                    objGeModelDB.setTiempo(vistObjGene.getTxtTiempo().getText());
                    objGeModelDB.setObservaciones(vistObjGene.getTxtObservaciones().getText());

                    if (objGeModelDB.insertarObjeGen()) {
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
        List<DefinicionObjetivosGeneral> lista;

        try {
            System.out.println(vista.getTxtCodigo().getText());
            lista = objGeModelDB.listartObjeGen(Integer.parseInt(vista.getTxtCodigo().getText()));
            
            int columnas = modeloTabOG.getColumnCount();
            for (int i = 0; i < lista.size(); i++) {
                modeloTabOG.addRow(new Object[columnas]);
                vista.getTabObjetivoGeneral().setValueAt(lista.get(i).getDefiniciong_id(), i, 0);
                vista.getTabObjetivoGeneral().setValueAt(lista.get(i).getObjetivo_general(), i, 1);
                //fila del codigo responsable 
                vista.getTabObjetivoGeneral().setValueAt(lista.get(i).getTiempo(), i, 3);
                vista.getTabObjetivoGeneral().setValueAt(lista.get(i).getObservaciones(), i, 4);

}

        } catch (SQLException ex) {
            Logger.getLogger(ControladorFichaIngreso.class  

.getName()).log(Level.SEVERE, null, ex);
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
        objGeModelDB.setDefiniciong_id(Integer.parseInt(vistObjGene.getLblCodigo().getText()));
        objGeModelDB.setObjetivo_general(vistObjGene.getTxtObjGeneral().getText());
        objGeModelDB.setTiempo(vistObjGene.getTxtTiempo().getText());
        objGeModelDB.setObservaciones(vistObjGene.getTxtObservaciones().getText());

        if (objGeModelDB.actualizarObjGen()) {
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

    public void ingresarPlanVida() {
        if (vista.getDtcFecha().getDate() == null) {
            JOptionPane.showMessageDialog(null, "Campos Vacios", "Ingrese Valores", JOptionPane.WARNING_MESSAGE);
        } else {
            if (vista.getDtcFechaEvaluacion().getDate()==null) {
                JOptionPane.showMessageDialog(null, "Fecha de Evaluación vacio", "Ingrese Valores", JOptionPane.WARNING_MESSAGE);
            } else {
                modelo.setVictima_codigo(Integer.parseInt(vista.getTxtCodigo().getText()));
                modelo.setFecha_elaboracion(obtenerFecha(vista.getDtcFecha()));
                modelo.setFecha_prox_evaluacion(obtenerFecha(vista.getDtcFechaEvaluacion()));
                modelo.setComosesiente(vista.getTxtComSiente().getText());
                modelo.setComoseve(vista.getTxtComoseVe().getText());
                modelo.setComolegustariasuvida(vista.getTxtComoleGustariasuVida().getText());
                if (modelo.Ingresar_Plandevida()) {
                    JOptionPane.showMessageDialog(null, "Dato Insertado Correctamente");
                    vista.getBtnObjetivoGeneral().setEnabled(true);
                    vista.getBtnObjetivosEspecificos().setEnabled(true);
                    //vista.getBtnGuradrarDesa().setEnabled(true);
                } else {
                    JOptionPane.showMessageDialog(null, "Error al Ingresar Datos");
                }
            }
        }
    }
}


