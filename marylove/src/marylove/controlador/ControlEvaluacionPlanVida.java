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
import marylove.DBmodelo.EvaluacionPlanVidaDB;
import marylove.DBmodelo.PercepcionFamiliarDB;
import marylove.conexion.Conexion;
import static marylove.controlador.C_Login.personal_cod;
import marylove.models.DefinicionObjetivosEspecifico;
import marylove.models.DefinicionObjetivosGeneral;
import marylove.models.PercepcionFamiliar;
import marylove.vista.FichaEvaluacionPlandeVida;
import marylove.vista.VistaDefinicionObjetivosEspecifico;
import marylove.vista.vistaAgregarObjetivoGenera;

public class ControlEvaluacionPlanVida extends Validaciones {

    private Conexion conex;
    DefaultTableModel modeloTabOE;
    DefaultTableModel modeloTabOG;
    DefaultTableModel modeloTabEdit;
    private FichaEvaluacionPlandeVida vistaEvaPlanVid;
    private DefinicionObjetivosGeneralDB objGenModelDB;
    private DefinicionObjetivosEspecificosDB objEspecModelDB;
    private DefinicionObjetivosGeneral objGenMOdel;
    private DefinicionObjetivosEspecifico objEspecMdel;
    private VistaDefinicionObjetivosEspecifico vistaObjEsp;
    private vistaAgregarObjetivoGenera vistaObjGene;

    EvaluacionPlanVidaDB evalPlModelDB = new EvaluacionPlanVidaDB();
    PercepcionFamiliarDB perFamilModelDB = new PercepcionFamiliarDB();

    public ControlEvaluacionPlanVida(FichaEvaluacionPlandeVida vistaEvaPlanVid, DefinicionObjetivosGeneralDB objGenModelDB, DefinicionObjetivosEspecificosDB objEspecModelDB, DefinicionObjetivosGeneral objGenMOdel, DefinicionObjetivosEspecifico objEspecMdel, VistaDefinicionObjetivosEspecifico vistaObjEsp, vistaAgregarObjetivoGenera vistaObjGene) {

        this.vistaEvaPlanVid = vistaEvaPlanVid;
        this.objGenModelDB = objGenModelDB;
        this.objEspecModelDB = objEspecModelDB;
        this.objGenMOdel = objGenMOdel;
        this.objEspecMdel = objEspecMdel;
        this.vistaObjEsp = vistaObjEsp;
        this.vistaObjGene = vistaObjGene;
    }

    public void iniciCtrlEvaluacionPlanVida() {
        abrirEvaPlaVida();
        fechaSistemaIni();
        inciaBtnBloqueados();
        validaciones();
        popTable();
        popTableObjGen();
        popTableObjEsp();
        
        vistaEvaPlanVid.getTxtCedula().addKeyListener(enter1(vistaEvaPlanVid.getTxtCedula(), vistaEvaPlanVid.getTxtNombre(), vistaEvaPlanVid.getTxtCodigo()));

        vistaEvaPlanVid.getBtnObjetivosEspecificos().addActionListener(e -> abrirVentObjEspecificos());
        vistaEvaPlanVid.getBtnObjetivoGeneral().addActionListener(e -> abrirVentObjeGenerales());
        vistaEvaPlanVid.getBtnVerRegist().addActionListener(e -> AbrirEditaringresarPercepcion());
//        vistaEvaPlanVid.getBtnActualizar().addActionListener(e -> Actualizar());
        vistaEvaPlanVid.getBtnActualizar().addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                if (vistaEvaPlanVid.getTxtCodigo().getText().isEmpty()) {
                    JOptionPane.showMessageDialog(null,"Debe Ingresar Cédula", "Error", JOptionPane.ERROR_MESSAGE);
                }else{
                    Actualizar();
                }
            }

        });
        
        vistaObjEsp.getBtnGuardar().addActionListener(e -> datosObjEsp());
        vistaObjEsp.getBtnEditar().addActionListener(e -> EditarBtnObjEsp());
        
        
        vistaObjGene.getBtnEditar().addActionListener(e-> EditarBtnObjGen());
        vistaObjGene.getBtnGuardar().addActionListener(e -> datosObjGen());

        vistaEvaPlanVid.getBtnGuradar().addActionListener(e -> ingresarEvalPlanVida());
        vistaEvaPlanVid.getBtnGuradrarDesa().addActionListener(e -> ingresarPercepcionFamiliarDes());
        
        vistaEvaPlanVid.getBtnOk().addActionListener(e-> EditarBtn());
        

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

    public void Actualizar(){
        cargaListaObjEspe();
        cargaListaObjGen();
    }
    
    public void datosObjEsp() {
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
        int canFilas = vistaEvaPlanVid.getTabObjetivosEspecificos().getRowCount();
        for (int i = canFilas - 1; i >= 0; i--) {
            if (i != 0) {
                modeloTabOE.removeRow(i);
            }

        }

        modeloTabOE = (DefaultTableModel) vistaEvaPlanVid.getTabObjetivosEspecificos().getModel();
        List<DefinicionObjetivosEspecifico> lista;

        try {
            lista = objEspecModelDB.listartObjetiv(Integer.parseInt(vistaEvaPlanVid.getTxtCodigo().getText()));
            int columnas = modeloTabOE.getColumnCount();
            for (int i = 0; i < lista.size(); i++) {
                modeloTabOE.addRow(new Object[columnas]);
                vistaEvaPlanVid.getTabObjetivosEspecificos().setValueAt(lista.get(i).getDefinicion_id(), i, 0);
                vistaEvaPlanVid.getTabObjetivosEspecificos().setValueAt(lista.get(i).getObjetivosEspecificos(), i, 1);
                //fila del codigo responsable 
                vistaEvaPlanVid.getTabObjetivosEspecificos().setValueAt(lista.get(i).getActividad(), i, 3);
                vistaEvaPlanVid.getTabObjetivosEspecificos().setValueAt(lista.get(i).getTiempo(), i, 4);
                vistaEvaPlanVid.getTabObjetivosEspecificos().setValueAt(lista.get(i).getApoyode(), i, 5);
                vistaEvaPlanVid.getTabObjetivosEspecificos().setValueAt(lista.get(i).getSupuestosAmenazas(), i, 6);
            }

        } catch (SQLException ex) {
            Logger.getLogger(ControladorFichaIngreso.class.getName()).log(Level.SEVERE, null, ex);
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
                vistaObjEsp.getBtnEditar().setEnabled(true);
                vistaObjEsp.getBtnGuardar().setEnabled(false);
            }
        });
        pM.add(itemEdit);
        vistaEvaPlanVid.getTabObjetivosEspecificos().setComponentPopupMenu(pM);
    }
    
    public void EditarObjEsp() {
        DefaultTableModel modeloTabla = (DefaultTableModel) vistaEvaPlanVid.getTabObjetivosEspecificos().getModel();
        int fsel = vistaEvaPlanVid.getTabObjetivosEspecificos().getSelectedRow();
        if (fsel == -1) {
            JOptionPane.showMessageDialog(null, "Seleccione una fila ó Actualize lista", "Verificación", JOptionPane.WARNING_MESSAGE);
        } else {
            String cod = modeloTabla.getValueAt(vistaEvaPlanVid.getTabObjetivosEspecificos().getSelectedRow(), 0).toString();
            String ObjetivoEsp = modeloTabla.getValueAt(vistaEvaPlanVid.getTabObjetivosEspecificos().getSelectedRow(), 1).toString();
            //falta responsable
            String activ = modeloTabla.getValueAt(vistaEvaPlanVid.getTabObjetivosEspecificos().getSelectedRow(), 3).toString();
            String tiemp = modeloTabla.getValueAt(vistaEvaPlanVid.getTabObjetivosEspecificos().getSelectedRow(), 4).toString();
            String apoyo = modeloTabla.getValueAt(vistaEvaPlanVid.getTabObjetivosEspecificos().getSelectedRow(), 4).toString();
            String supuest = modeloTabla.getValueAt(vistaEvaPlanVid.getTabObjetivosEspecificos().getSelectedRow(), 4).toString();

            vistaObjEsp.getLblCodigo().setText(cod);
            vistaObjEsp.getTxtObjEspecifico().setText(ObjetivoEsp);
            vistaObjEsp.getTxtActividad().setText(activ);
            vistaObjEsp.getTxtTiempo().setText(tiemp);
            vistaObjEsp.getTxtApoyoDe().setText(apoyo);
            vistaObjEsp.getTxtSupuestoAmenaza().setText(supuest);
            vistaObjEsp.setTitle("Editar Objetivos Especificos");
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
    public void datosObjGen() {
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
            lista = objGenModelDB.listartObjeGen(Integer.parseInt(vistaEvaPlanVid.getTxtCodigo().getText()));
            
            int columnas = modeloTabOG.getColumnCount();
            for (int i = 0; i < lista.size(); i++) {
                modeloTabOG.addRow(new Object[columnas]);
                vistaEvaPlanVid.getTabObjetivoGeneral().setValueAt(lista.get(i).getDefiniciong_id(), i, 0);
                vistaEvaPlanVid.getTabObjetivoGeneral().setValueAt(lista.get(i).getObjetivo_general(), i, 1);
                //fila del codigo responsable 
                vistaEvaPlanVid.getTabObjetivoGeneral().setValueAt(lista.get(i).getTiempo(), i, 3);
                vistaEvaPlanVid.getTabObjetivoGeneral().setValueAt(lista.get(i).getObservaciones(), i, 4);
            }

        } catch (SQLException ex) {
            Logger.getLogger(ControladorFichaIngreso.class.getName()).log(Level.SEVERE, null, ex);
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
                vistaObjGene.getBtnEditar().setEnabled(true);
                vistaObjGene.getBtnGuardar().setEnabled(false);
            }
        });
        pM.add(itemEdit);
        vistaEvaPlanVid.getTabObjetivoGeneral().setComponentPopupMenu(pM);
    }
    
    public void EditarObjGen() {
        DefaultTableModel modeloTabla = (DefaultTableModel) vistaEvaPlanVid.getTabObjetivoGeneral().getModel();
        int fsel = vistaEvaPlanVid.getTabObjetivoGeneral().getSelectedRow();
        if (fsel == -1) {
            JOptionPane.showMessageDialog(null, "Seleccione una fila ó Actualize lista", "Verificación", JOptionPane.WARNING_MESSAGE);
        } else {
            String cod = modeloTabla.getValueAt(vistaEvaPlanVid.getTabObjetivoGeneral().getSelectedRow(), 0).toString();
            String ObjetivoGen = modeloTabla.getValueAt(vistaEvaPlanVid.getTabObjetivoGeneral().getSelectedRow(), 1).toString();
            //falta responsable
            String tiempo = modeloTabla.getValueAt(vistaEvaPlanVid.getTabObjetivoGeneral().getSelectedRow(), 3).toString();
            String obser = modeloTabla.getValueAt(vistaEvaPlanVid.getTabObjetivoGeneral().getSelectedRow(), 4).toString();

            vistaObjGene.getLblCodigo().setText(cod);
            vistaObjGene.getTxtObjGeneral().setText(ObjetivoGen);
            vistaObjGene.getTxtTiempo().setText(tiempo);
            vistaObjGene.getTxtObservaciones().setText(obser);

            vistaObjGene.setTitle("Editar Objetivos Generales");
        }
    }
    
    public void EditarBtnObjGen() {
        objGenModelDB.setDefiniciong_id(Integer.parseInt(vistaObjGene.getLblCodigo().getText()));
        objGenModelDB.setObjetivo_general(vistaObjGene.getTxtObjGeneral().getText());
        objGenModelDB.setTiempo(vistaObjGene.getTxtTiempo().getText());
        objGenModelDB.setObservaciones(vistaObjGene.getTxtObservaciones().getText());

        if (objGenModelDB.actualizarObjGen()) {
            JOptionPane.showMessageDialog(null, "Datos Editados correctamente");
            vistaObjGene.setVisible(false);
            cargaListaObjGen();
            
             vistaObjGene.getTxtObjGeneral().setText("");
             vistaObjGene.getTxtTiempo().setText("");
             vistaObjGene.getTxtObservaciones().setText("");
             
        } else {
            JOptionPane.showMessageDialog(null, "Error al actualizar Datos.");

        }
    }

    //////////Evaluacion Plan de Vida
    public void ingresarEvalPlanVida() {
        if (vistaEvaPlanVid.getDtcFecha().getDate() == null) {
            JOptionPane.showMessageDialog(null, "Campos Vacios", "Ingrese Valores", JOptionPane.WARNING_MESSAGE);
        } else {
            if (vistaEvaPlanVid.getDtcFecha1().getDate()==null) {
                JOptionPane.showMessageDialog(null, "Fecha de Evaluación vacio", "Ingrese Valores", JOptionPane.WARNING_MESSAGE);
            } else {
                evalPlModelDB.setVictima_codigo(Integer.parseInt(vistaEvaPlanVid.getTxtCodigo().getText()));
                evalPlModelDB.setPersonal_codigo(evalPlModelDB.verifiUserP(personal_cod));
                evalPlModelDB.setEvaluacion_fecha(obtenerFecha(vistaEvaPlanVid.getDtcFecha()));
                evalPlModelDB.setEvaluacion_proxima(obtenerFecha(vistaEvaPlanVid.getDtcFecha1()));
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

    //////////Percepcion Familiar
    public void ingresarPercepcionFamiliarDes() {
        if (vistaEvaPlanVid.getTxtComSiente().getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Campos Vacios", "Ingrese Valores", JOptionPane.WARNING_MESSAGE);
        } else {
            if (vistaEvaPlanVid.getTxtObjPlaned().getText().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Campos Vacios", "Ingrese Valores", JOptionPane.WARNING_MESSAGE);
            } else {
                if (vistaEvaPlanVid.getTxtDificEncontrados().getText().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Campos Vacios", "Ingrese Valores", JOptionPane.WARNING_MESSAGE);
                } else {
                    perFamilModelDB.setEvaluacion_id(evalPlModelDB.maxId());
                    perFamilModelDB.setComoSeSiente(vistaEvaPlanVid.getTxtComSiente().getText());
                    perFamilModelDB.setAlcanzoObjetivosComo(vistaEvaPlanVid.getTxtObjPlaned().getText());
                    perFamilModelDB.setDificultadesEncontradas(vistaEvaPlanVid.getTxtDificEncontrados().getText());
                    //falta TxArea 
                    if (perFamilModelDB.IngresarPercepcionFamil()) {
                        JOptionPane.showMessageDialog(null, "Dato Insertado Correctamente");
                    } else {
                        JOptionPane.showMessageDialog(null, "Error al Ingresar Datos, Vuelva a intentar");
                    }
                }
            }
        }
    }

    public void AbrirEditaringresarPercepcion() {
        vistaEvaPlanVid.getjDlgEditTbl().setVisible(true);
        vistaEvaPlanVid.getjDlgEditTbl().setLocationRelativeTo(null);
        vistaEvaPlanVid.getjDlgEditTbl().setSize(980, 513);
        cargarListaEditIngPercepcion();
    }

    private void cargarListaEditIngPercepcion() {
        vistaEvaPlanVid.getLblNombre().setText("Nombre: " + vistaEvaPlanVid.getTxtNombre().toString());
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
                vistaEvaPlanVid.getTblEditar().setValueAt(lista.get(i).getComoSeSiente(), i, 1);
                vistaEvaPlanVid.getTblEditar().setValueAt(lista.get(i).getAlcanzoObjetivosComo(), i, 2);
                vistaEvaPlanVid.getTblEditar().setValueAt(lista.get(i).getDificultadesEncontradas(), i, 3);

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
        itemEdit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Editar();
                AbrirEditarPercepcion();
            }
        });
        pM.add(itemEdit);
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

            vistaEvaPlanVid.getLblCodEdit().setText(cod);
            vistaEvaPlanVid.getTxtComSienteEdit().setText(comoseSinte);
            vistaEvaPlanVid.getTxtObjPlanedEdit().setText(alcanzaObj);
            vistaEvaPlanVid.getTxtDificEncontradosEdit().setText(dificultadesEnc);

            vistaEvaPlanVid.getjDlgEdit().setTitle("Editar Arítuculos Entregados");
        }
    }

    public void EditarBtn() {
        perFamilModelDB.setPercepcion_id(Integer.parseInt(vistaEvaPlanVid.getLblCodEdit().getText()));
        perFamilModelDB.setComoSeSiente(vistaEvaPlanVid.getTxtComSienteEdit().getText());
        perFamilModelDB.setAlcanzoObjetivosComo(vistaEvaPlanVid.getTxtObjPlanedEdit().getText());
        perFamilModelDB.setDificultadesEncontradas(vistaEvaPlanVid.getTxtDificEncontradosEdit().getText());

        if (perFamilModelDB.actualizarPerFam()) {
            JOptionPane.showMessageDialog(null, "Datos actualizados correctamente");
            vistaEvaPlanVid.getjDlgEdit().setVisible(false);
            cargarListaEditIngPercepcion();
            
            vistaEvaPlanVid.getTxtComSienteEdit().setText("");
            vistaEvaPlanVid.getTxtObjPlanedEdit().setText("");
            vistaEvaPlanVid.getTxtDificEncontradosEdit().setText("");
        } else {
            JOptionPane.showMessageDialog(null, "Error al actualizar Datos.");

        }
    }
}
