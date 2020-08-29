/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package marylove.controlador;

import com.google.gson.Gson;
import java.awt.Color;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.beans.PropertyChangeEvent;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.table.DefaultTableModel;
import marylove.DBmodelo.AnamnesisDB;
import marylove.DBmodelo.DesarrolloDB;
import marylove.DBmodelo.Detalle_nacimientoDB;
import marylove.DBmodelo.Embarazo_complicacionesDB;
import marylove.DBmodelo.FamiliaresDB;
import marylove.DBmodelo.FichaAnamnesisBD;
import marylove.DBmodelo.HijosDB;
import marylove.DBmodelo.NacimientoDB;
import marylove.DBmodelo.PadreDB;
import marylove.DBmodelo.Post_partoDB;
import marylove.DBmodelo.jsonDB;
import marylove.DBmodelo.victimaDB;
import marylove.DBmodelo.Embarazo_estadoDB;
import marylove.DBmodelo.EscolaridadDB;
import marylove.DBmodelo.InstitucionEducativaDB;
import marylove.DBmodelo.Relacion_familiar_nnaDB;
import marylove.DBmodelo.Salud_nnaDB;
import marylove.DBmodelo.Sueno_control_esfinDB;
import marylove.DBmodelo.x_embarazo_comp1DB;

import marylove.DBmodelo.x_hijos_familiaresDB;
import marylove.models.Anamnesis;
import marylove.models.Embarazo_complicaciones;
import marylove.models.Embarazo_complicaciones_json;
import marylove.models.Familiares;
import marylove.models.Embarazo_estado;
import marylove.models.Hijos;
import marylove.models.InstitucionEducativa;
import marylove.models.Padre;
import marylove.models.Post_parto;
import marylove.models.Salud_nna;
import marylove.models.Victima;
import marylove.models.x_hijos_familiares;
import marylove.vista.FichaAnamnesis;
import org.json.simple.parser.ParseException;

/**
 *
 * @author Usuario
 */
public class ControladorFichaAnamnesis extends Validaciones implements ChangeListener {

    //VARIABLES DEL HILO
    boolean estadoHiloConexion = true;
    int metodoindice = 0;
    //VARIABLES TEMPORALES DE CÓDIGOS

    //VARIABLES DEL CONTROL
    private FichaAnamnesisBD modeloFichaAnamnesisBD = new FichaAnamnesisBD();
    private final FichaAnamnesis vistaAnamnesis;
    private HijosDB modeloHijosDB = new HijosDB();
    private PadreDB modeloPadreDB = new PadreDB();
    private FamiliaresDB modeloFamiliaresDB = new FamiliaresDB();
    private NacimientoDB modeloNacimientoDB = new NacimientoDB();
    private Detalle_nacimientoDB modeloDetalle_nacimientoDB = new Detalle_nacimientoDB();
    private Post_partoDB modeloPost_partoDB = new Post_partoDB();
    private victimaDB modeloVictimaDB = new victimaDB();
    private Embarazo_estadoDB modeloEmbarazo_EstadoDB = new Embarazo_estadoDB();
    private DesarrolloDB modeloDesarrolloDB = new DesarrolloDB();
    private AnamnesisDB modeloAnamnesisDB;
    private Sueno_control_esfinDB modelo_sueno_esfinteresDB = new Sueno_control_esfinDB();
    private EscolaridadDB modelo_EscolaridadDB = new EscolaridadDB();
    private Salud_nnaDB modelo_Salud_nnaDB = new Salud_nnaDB();
    private Relacion_familiar_nnaDB modelo_relacion_familiar_nnaDB = new Relacion_familiar_nnaDB();
    private FiltroHijosVictima filtroHijosVictima = new FiltroHijosVictima();
    private Embarazo_complicacionesDB modelo_Embarazo_complicacionesDB = new Embarazo_complicacionesDB();

    private x_hijos_familiaresDB modelo_x_hijos_familiaresDB = new x_hijos_familiaresDB();
    private InstitucionEducativaDB insDB;
    DefaultTableModel tablaFamiliares;

    //ArrayList--------------------------------------------------------------------------------
    private ArrayList<Embarazo_complicaciones_json> listaembarazocomplicaciones;
    x_embarazo_comp1DB x_emb_comp1db;
    Embarazo_complicaciones_json embarazo_complicaciones_json;
    //-----------------------------------------------------------------------------------------
    //DECLARAMOS VARIABLES LOCALES PARA VALIDACIONES
    private String accionBtnGuardarVFamiliares;
    private int idFamiliarUpdate;
    private int indiceVentanaCambiada = 0;
    DefaultTableModel model;

    private static int codigoVictima;

    public ControladorFichaAnamnesis(FichaAnamnesis vistaAnamnesis) throws Exception {
        this.vistaAnamnesis = vistaAnamnesis;
//        this.vistaAnamnesis.setLocationRelativeTo(null);
//        this.vistaAnamnesis.getFrmFamiliares().setLocationRelativeTo(null);
//        this.vistaAnamnesis.setVisible(true);

    }

    public void inciarControl() {

        FormatoTabla();
        //Acciones de los checkbox de las ventanas
        Listeners_accionesChecks();
        //Añadimos el escucha al jdchooser de fecha de nacimiento para calcular la edad
        vistaAnamnesis.getJdcFechaNacimientoNNA().addPropertyChangeListener((PropertyChangeEvent evt) -> this.propertyChange(evt));

        this.vistaAnamnesis.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        this.vistaAnamnesis.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                confirmarSalida();
            }
        });

        //Les ponemos invisibles temporalmente a los mensajes que se presentarán en el panel de mensajes
        estadosPestanasInvisibles();
        //CARGAMOS LOS JSONS QUE VAMOS A USAR EN LA VISTA
        cargarJsons();

        //actualizarTblComposicionFamiliar();//Se llamara dentro del metodo de cargar datos
        //CONTROL DE BOTONES
        vistaAnamnesis.getBtnGuardar().addActionListener(e -> guardarDatos());
        vistaAnamnesis.getBtnAñadir().addActionListener(e -> mostrarVentanaAnadirFamiliares("Ingresar"));
        vistaAnamnesis.getBtnEditar().addActionListener(e -> mostrarVentanaAnadirFamiliares("Actualizar"));
        vistaAnamnesis.getBtnActualizar().addActionListener(e -> actualizarTblComposicionFamiliar());
        vistaAnamnesis.getBtnFamiliares_anadirFamiliar().addActionListener(e -> accionBtnFormFamiliares());
        vistaAnamnesis.getBtnEliminar().addActionListener(e -> eliminarFamiliarNNA());
        //CONTROLADORES DE FECHAS
        vistaAnamnesis.getJdcFechaElaboracion().setCalendar(Calendar.getInstance());

        //CONTROLES DE TEXTOS
        vistaAnamnesis.getTxtEdadNNA().addKeyListener(validarNumeros(vistaAnamnesis.getTxtEdadNNA()));
        vistaAnamnesis.getTxtEdadPadre().addKeyListener(validarNumeros(vistaAnamnesis.getTxtEdadPadre()));
        vistaAnamnesis.getTxtEdadMadre().addKeyListener(validarNumeros(vistaAnamnesis.getTxtEdadMadre()));
        vistaAnamnesis.getTxtFamiliares_edad().addKeyListener(validarNumeros(vistaAnamnesis.getTxtFamiliares_edad()));
        vistaAnamnesis.getTxtVecesComeDia().addKeyListener(validarNumeros(vistaAnamnesis.getTxtVecesComeDia()));

        //CONTROL DE PESTAÑAS DE LA FICHA
        vistaAnamnesis.getJtpPrincipal().addChangeListener(e -> stateChanged(e));
        vistaAnamnesis.getRbnBeneficiariaMadre_Si().addActionListener(e -> controlarBeneficiariaMadre());
        vistaAnamnesis.getRbnBeneficiariaMadre_No().addActionListener(e -> controlarBeneficiariaMadre());
        AnamnesisDB anam = new AnamnesisDB();
        modeloAnamnesisDB = new AnamnesisDB();
        modeloAnamnesisDB.consultaAnamnesisExist(anam);
        if (C_Menu.confirmar == false) {
            try {
                llenarCamposAnamesis();
            } catch (SQLException ex) {
                Logger.getLogger(ControladorFichaAnamnesis.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else if (AnamnesisDB.existenciafichaAnam == false) {
            JOptionPane.showMessageDialog(vistaAnamnesis, "Se creó una nueva ficha");
        }
        //icono
        vistaAnamnesis.setIconImage(new ImageIcon(getClass().getResource("/iconos/icono1.png")).getImage());
    }

    public void Listeners_accionesChecks() {
        //pestana 4
        vistaAnamnesis.getJcxNoViolencia().addActionListener(e -> valCheck());
        vistaAnamnesis.getJcxNoControles().addActionListener(e -> valCheck());
        vistaAnamnesis.getJcxNoComplicaciones().addActionListener(e -> valCheck());
        vistaAnamnesis.getJcxNoConsume().addActionListener(e -> valCheck());

        vistaAnamnesis.getJcxSiViolencia().addActionListener(e -> valCheck());
        vistaAnamnesis.getJcxSiControles().addActionListener(e -> valCheck());
        vistaAnamnesis.getJcxSiComplicaciones().addActionListener(e -> valCheck());
        vistaAnamnesis.getJcxSiConsume().addActionListener(e -> valCheck());

        vistaAnamnesis.getJcxSiEstudia().addActionListener(e -> valEscolNino());
        vistaAnamnesis.getJcxSiAprendizaje().addActionListener(e -> valEscolNino());
        vistaAnamnesis.getJcxSiNivelacion().addActionListener(e -> valEscolNino());

        vistaAnamnesis.getJcxNoEstudia().addActionListener(e -> valEscolNino());
        vistaAnamnesis.getJcxNoAprendizaje().addActionListener(e -> valEscolNino());
        vistaAnamnesis.getJcxNoNivelacion().addActionListener(e -> valEscolNino());
        //pestania 5
        vistaAnamnesis.getJcxNormal().addActionListener(e -> condiconesNacimiento());
        vistaAnamnesis.getJcxCesarea().addActionListener(e -> condiconesNacimiento());
        // pestana 6 
        vistaAnamnesis.getJcxSiLeche().addActionListener(e -> controlPestaña6());
        vistaAnamnesis.getJcxNoLeche().addActionListener(e -> controlPestaña6());
        // pestania 11 
        vistaAnamnesis.getJcxSiProblemasRespiratorios().addActionListener(e -> checkSalud());
        vistaAnamnesis.getJcxNoProblemasRespiratorios().addActionListener(e -> checkSalud());

        vistaAnamnesis.getJcxSiAlergias().addActionListener(e -> checkSalud());
        vistaAnamnesis.getJcxNoAlergias().addActionListener(e -> checkSalud());

        vistaAnamnesis.getJcxSiNeurologicos().addActionListener(e -> checkSalud());
        vistaAnamnesis.getJcxNoNeurologicos().addActionListener(e -> checkSalud());

        vistaAnamnesis.getJcxSiNerviosos().addActionListener(e -> checkSalud());
        vistaAnamnesis.getJcxNoNerviosos().addActionListener(e -> checkSalud());

        vistaAnamnesis.getJcxSiAborto().addActionListener(e -> valCheck());
        vistaAnamnesis.getJcxNoAborto().addActionListener(e -> valCheck());

        vistaAnamnesis.getJcxSiBiberon().addActionListener(e -> controlPestaña6());
        vistaAnamnesis.getJcxNoBiberon().addActionListener(e -> controlPestaña6());

        vistaAnamnesis.getJcxSiEcopresis().addActionListener(e -> valPestana9());
        vistaAnamnesis.getJcxNoEcopresis().addActionListener(e -> valPestana9());

        vistaAnamnesis.getJcxSiTrabajo().addActionListener(e -> valPestana12());
        vistaAnamnesis.getJcxNoTrabajo().addActionListener(e -> valPestana12());
        vistaAnamnesis.getJcxSiAgrede().addActionListener(e -> valPestana12());
        vistaAnamnesis.getJcxNoAgrede().addActionListener(e -> valPestana12());
    }

    public void estadosPestanasInvisibles() {

        //PONEMOS LA VISIBILIDAD EN FALSE DE LOS MENSAJES 
        vistaAnamnesis.getLblMensajesAnamnesis().setVisible(false);
        vistaAnamnesis.getLblMensajesAnamnesis1().setVisible(false);
        vistaAnamnesis.getLblMensajesAnamnesis2().setVisible(false);
        vistaAnamnesis.getLblMensajesAnamnesis3().setVisible(false);
        vistaAnamnesis.getLblMensajesAnamnesis4().setVisible(false);
        vistaAnamnesis.getLblMensajesAnamnesis5().setVisible(false);
        vistaAnamnesis.getLblMensajesAnamnesis6().setVisible(false);
        vistaAnamnesis.getLblMensajesAnamnesis7().setVisible(false);
        vistaAnamnesis.getLblMensajesAnamnesis8().setVisible(false);
        vistaAnamnesis.getLblMensajesAnamnesis9().setVisible(false);
        vistaAnamnesis.getLblMensajesAnamnesis10().setVisible(false);
        vistaAnamnesis.getLblMensajesAnamnesis11().setVisible(false);
        vistaAnamnesis.getLblMensajesAnamnesis12().setVisible(false);
        vistaAnamnesis.getLblMensajesAnamnesis13().setVisible(false);
        vistaAnamnesis.getLblMensajesAnamnesis14().setVisible(false);
        //PONEMOS LA VISIBILIDAD EN FALSE DE LOS ESTADOS DE CADA MENSAJE
        vistaAnamnesis.getLblMensajesAnamnesisEstado().setVisible(false);
        vistaAnamnesis.getLblMensajesAnamnesisEstado1().setVisible(false);
        vistaAnamnesis.getLblMensajesAnamnesisEstado2().setVisible(false);
        vistaAnamnesis.getLblMensajesAnamnesisEstado3().setVisible(false);
        vistaAnamnesis.getLblMensajesAnamnesisEstado4().setVisible(false);
        vistaAnamnesis.getLblMensajesAnamnesisEstado5().setVisible(false);
        vistaAnamnesis.getLblMensajesAnamnesisEstado6().setVisible(false);
        vistaAnamnesis.getLblMensajesAnamnesisEstado7().setVisible(false);
        vistaAnamnesis.getLblMensajesAnamnesisEstado8().setVisible(false);
        vistaAnamnesis.getLblMensajesAnamnesisEstado9().setVisible(false);
        vistaAnamnesis.getLblMensajesAnamnesisEstado10().setVisible(false);
        vistaAnamnesis.getLblMensajesAnamnesisEstado11().setVisible(false);
        vistaAnamnesis.getLblMensajesAnamnesisEstado12().setVisible(false);
        vistaAnamnesis.getLblMensajesAnamnesisEstado13().setVisible(false);
        vistaAnamnesis.getLblMensajesAnamnesisEstado14().setVisible(false);
    }

    public void llenarCamposAnamesis() throws SQLException {
        FormatoTabla();
        Hijos j = new Hijos();
        modeloHijosDB = new HijosDB();
        modeloHijosDB.HijosAnamnesis(j);
        vistaAnamnesis.getTxtNombre().setText(j.getPersona_nombre());
        System.out.println(j.getPersona_nombre());
        vistaAnamnesis.getTxtApellido().setText(j.getPersona_apellido());
        vistaAnamnesis.getTxtCedula().setText(j.getPersona_cedula());
        //  vistaAnamnesis.getJdcFechaElaboracion().setDate(j.getPersona_fecha_nac());
        if (!j.getPersona_cedula().equals("") || !j.getPersona_cedula().equals(null)) {
            vistaAnamnesis.getCbxPoseeCedula().setSelectedIndex(1);
        } else {
            vistaAnamnesis.getCbxPoseeCedula().setSelectedIndex(2);
        }
        vistaAnamnesis.getTxtEdadNNA().setText(String.valueOf(j.getEdad()));
        vistaAnamnesis.getTxaSituacionIngresaNNA().setText(j.getHijo_estado_ingreso());
        if (j.isHijos_estado() == true) {
            vistaAnamnesis.getCbxPadreAgresor().setSelectedIndex(1);
        } else if (j.isHijos_estado() == false) {
            vistaAnamnesis.getCbxPadreAgresor().setSelectedIndex(2);
        } else {
            vistaAnamnesis.getCbxPadreAgresor().setSelectedIndex(0);
        }
        Victima v = new Victima();
        //vDB = new victimaDB();
        modeloVictimaDB.MadreVictimaAnamnesis(v);
        //Madre
        System.out.println(v.getPersona_nombre());
        vistaAnamnesis.getTxtNombreMadre().setText(v.getPersona_nombre());
        vistaAnamnesis.getTxtApellidoMadre().setText(v.getPersona_apellido());
        vistaAnamnesis.getTxtEdadMadre().setText(String.valueOf(v.getEdad()));
        nombreMadre = v.getPersona_nombre();
        apellidoMadre = v.getPersona_apellido();
        edadMadre = v.getEdad();
        idNacionalidadMadre = v.getPersona_nacionalidad();
        //
        //Padre
        jsonDB claseJsonDB = new jsonDB();
        Padre pa = new Padre();
        modeloPadreDB = new PadreDB();
        modeloPadreDB.PadreAnamnesis(pa);
        // System.out.println(pa.getPersona_nombre());
        vistaAnamnesis.getTxtNombrePadre().setText(pa.getPersona_nombre());
        vistaAnamnesis.getTxtApellidoPadre().setText(pa.getPersona_apellido());
        vistaAnamnesis.getTxtEdadPadre().setText(String.valueOf(pa.getEdad()));

        try {
            // listaNacionalidades = claseJsonDB.obtenerNacionalidades();
            for (int i = 0; i < listaNacionalidades.size(); i++) {
                if (listaNacionalidades.get(i).getId() == j.getPersona_nacionalidad()) {
                    vistaAnamnesis.getJcb_nacionalid_id().setSelectedItem(String.valueOf(listaNacionalidades.get(i).getValor()));
                } else if (listaNacionalidades.get(i).getId() == v.getPersona_nacionalidad()) {
                    vistaAnamnesis.getJcb_nacionalidad_madre().setSelectedItem(String.valueOf(listaNacionalidades.get(i).getValor()));
                } else if (listaNacionalidades.get(i).getId() == pa.getPersona_nacionalidad()) {
                    vistaAnamnesis.getJcb_nacionalidad_padre().setSelectedItem(String.valueOf(listaNacionalidades.get(i).getValor()));
                } else {

                }
            }
        } catch (Exception ex) {
            Logger.getLogger(ControladorFichaAnamnesis.class.getName()).log(Level.SEVERE, null, ex);
        }
        //Familiares
        actualizarTblComposicionFamiliar();
        //CargarTablaFamiliares();
        //EmbarazoEstado
        modeloEmbarazo_EstadoDB = new Embarazo_estadoDB();
        Embarazo_estado EE = new Embarazo_estado();
        modeloEmbarazo_EstadoDB.EmbarazoAnamnesis(EE);

        if (EE.isEmbarazo_planificado() == true) {
            vistaAnamnesis.getCbxEmbarazoPlanificado().setSelectedIndex(1);
        } else if (EE.isEmbarazo_planificado() == false) {
            vistaAnamnesis.getCbxEmbarazoPlanificado().setSelectedIndex(2);
        }
        vistaAnamnesis.getTxtReaccionMama().setText(EE.getEmbarazo_reaccion_madre());
        vistaAnamnesis.getTxtReaccionPapa().setText(EE.getEmbarazo_reaccion_padre());
        vistaAnamnesis.getTxtDondeRealizoControles().setText(EE.getDonde_realizo_controles());
        vistaAnamnesis.getTxtCausasConsumo().setText(EE.getConsumo_causas());
        vistaAnamnesis.getTxtCausasAborto().setText(EE.getAborto_causas());
//Complicaciones embarazo check box
        Embarazo_complicaciones Ec = new Embarazo_complicaciones();
        try {
            modelo_Embarazo_complicacionesDB = new Embarazo_complicacionesDB();
            modelo_Embarazo_complicacionesDB.punto1Anamnesis(Ec);

            for (int i = 0; i < Embarazo_complicacionesDB.ListaEC.size(); i++) {

                //Apartado tipo 1
                if (Embarazo_complicacionesDB.ListaEC.get(i).getEmb_comp_tipo() == 1) {
                    if (Embarazo_complicacionesDB.ListaEC.get(i).getEmb_comp_descripcion().equals("Si")) {
                        vistaAnamnesis.getJcxSiViolencia().setSelected(true);
                    } else if (Embarazo_complicacionesDB.ListaEC.get(i).getEmb_comp_descripcion().equals("No")) {
                        vistaAnamnesis.getJcxNoViolencia().setSelected(true);
                    } else if (Embarazo_complicacionesDB.ListaEC.get(i).getEmb_comp_descripcion().equals("Golpes")) {
                        vistaAnamnesis.getJcxGolpes().setSelected(true);
                    } else if (Embarazo_complicacionesDB.ListaEC.get(i).getEmb_comp_descripcion().equals("Insultos")) {
                        vistaAnamnesis.getJcxInsultos().setSelected(true);
                    } else if (Embarazo_complicacionesDB.ListaEC.get(i).getEmb_comp_descripcion().equals("Negligencia")) {
                        vistaAnamnesis.getJcxNegligencia().setSelected(true);
                    } else if (Embarazo_complicacionesDB.ListaEC.get(i).getEmb_comp_descripcion().equals("En el ámbito laboral")) {
                        vistaAnamnesis.getJcxAmbitoLaboral().setSelected(true);
                    } else if (Embarazo_complicacionesDB.ListaEC.get(i).getEmb_comp_descripcion().equals("Abuso sexual")) {
                        vistaAnamnesis.getJcxAbusoSexual().setSelected(true);
                    }
                }
                //Apartado tipo 2
                if (Embarazo_complicacionesDB.ListaEC.get(i).getEmb_comp_tipo() == 2) {
                    if (Embarazo_complicacionesDB.ListaEC.get(i).getEmb_comp_descripcion().equals("Si")) {
                        vistaAnamnesis.getJcxSiControles().setSelected(true);
                    } else if (Embarazo_complicacionesDB.ListaEC.get(i).getEmb_comp_descripcion().equals("No")) {
                        vistaAnamnesis.getJcxNoControles().setSelected(true);
                    } else if (Embarazo_complicacionesDB.ListaEC.get(i).getEmb_comp_descripcion().equals("Una sola vez")) {
                        vistaAnamnesis.getJcxUnaVez().setSelected(true);
                    } else if (Embarazo_complicacionesDB.ListaEC.get(i).getEmb_comp_descripcion().equals("Mensual")) {
                        vistaAnamnesis.getJcxMensual().setSelected(true);
                    } else if (Embarazo_complicacionesDB.ListaEC.get(i).getEmb_comp_descripcion().equals("Trimestral")) {
                        vistaAnamnesis.getJcxTrimestral().setSelected(true);
                    } else if (Embarazo_complicacionesDB.ListaEC.get(i).getEmb_comp_descripcion().equals("Ninguna")) {
                        vistaAnamnesis.getJcxNinguna().setSelected(true);
                    }
                }
                //Apartado tipo 3
                if (Embarazo_complicacionesDB.ListaEC.get(i).getEmb_comp_tipo() == 3) {
                    if (Embarazo_complicacionesDB.ListaEC.get(i).getEmb_comp_descripcion().equals("Si")) {
                        vistaAnamnesis.getJcxSiComplicaciones().setSelected(true);
                    } else if (Embarazo_complicacionesDB.ListaEC.get(i).getEmb_comp_descripcion().equals("No")) {
                        vistaAnamnesis.getJcxNoComplicaciones().setSelected(true);
                    } else if (Embarazo_complicacionesDB.ListaEC.get(i).getEmb_comp_descripcion().equals("Bajo Peso")) {
                        vistaAnamnesis.getJcxBajoPeso().setSelected(true);
                    } else if (Embarazo_complicacionesDB.ListaEC.get(i).getEmb_comp_descripcion().equals("Hemorragias")) {
                        vistaAnamnesis.getJcxHemorragias().setSelected(true);
                    } else if (Embarazo_complicacionesDB.ListaEC.get(i).getEmb_comp_descripcion().equals("Infecciones")) {
                        vistaAnamnesis.getJcxInfecciones().setSelected(true);
                    } else if (Embarazo_complicacionesDB.ListaEC.get(i).getEmb_comp_descripcion().equals("Preeclampsia")) {
                        vistaAnamnesis.getJcxPreclansia().setSelected(true);
                    } else if (Embarazo_complicacionesDB.ListaEC.get(i).getEmb_comp_descripcion().equals("Otros")) {
                        vistaAnamnesis.getTxtOtraComplicacionEmbarazo().setText(Embarazo_complicacionesDB.getDescripcion_static());
                    }
                }
                //Apartado tipo 4
                if (Embarazo_complicacionesDB.ListaEC.get(i).getEmb_comp_tipo() == 4) {
                    if (Embarazo_complicacionesDB.ListaEC.get(i).getEmb_comp_descripcion().equals("Si")) {
                        vistaAnamnesis.getJcxSiConsume().setSelected(true);
                    } else if (Embarazo_complicacionesDB.ListaEC.get(i).getEmb_comp_descripcion().equals("No")) {
                        vistaAnamnesis.getJcxNoConsume().setSelected(true);
                    } else if (Embarazo_complicacionesDB.ListaEC.get(i).getEmb_comp_descripcion().equals("Tabaco")) {
                        vistaAnamnesis.getJcxTabaco().setSelected(true);
                    } else if (Embarazo_complicacionesDB.ListaEC.get(i).getEmb_comp_descripcion().equals("Alcohol")) {
                        vistaAnamnesis.getJcxAlcohol().setSelected(true);
                    } else if (Embarazo_complicacionesDB.ListaEC.get(i).getEmb_comp_descripcion().equals("Droga")) {
                        vistaAnamnesis.getJcxDroga().setSelected(true);
                    }
                }
                //Apartado tipo 5
                if (Embarazo_complicacionesDB.ListaEC.get(i).getEmb_comp_tipo() == 5) {
                    if (Embarazo_complicacionesDB.ListaEC.get(i).getEmb_comp_descripcion().equals("Si")) {
                        vistaAnamnesis.getJcxSiConsume().setSelected(true);
                    } else if (Embarazo_complicacionesDB.ListaEC.get(i).getEmb_comp_descripcion().equals("No")) {
                        vistaAnamnesis.getJcxNoConsume().setSelected(true);
                    }
                }
            }

        } catch (Exception e) {
            e.getStackTrace();
        }
        //Condiciones Nacimiento
        modeloPost_partoDB = new Post_partoDB();
        Post_parto postp = new Post_parto();

        modeloPost_partoDB.FichaAnamnesisLlenadoCampos(postp);
        System.out.println("siuuuuuu");
        System.out.println(postp.getActitud_madre_no_come());
        vistaAnamnesis.getJcb_mes_alumbramiento().setSelectedIndex(postp.getMes_alumbramiento());
        vistaAnamnesis.getTxtLugarParto().setText(postp.getLugar_nacimiento());
        if (postp.getParto_tipo().equals("Normal")) {
            vistaAnamnesis.getJcxNormal().setSelected(true);
        } else if (postp.getParto_tipo().equals("Cesárea")) {
            vistaAnamnesis.getJcxCesarea().setSelected(true);
        }
        vistaAnamnesis.getTxtMotivoCesarea().setText(postp.getMotivo_cesarea());
        if (postp.isAnestesia() == true) {
            vistaAnamnesis.getJcxSiAnestesia().setSelected(true);
        } else if (postp.isAnestesia() == false) {
            vistaAnamnesis.getJcxNoAnestesia().setSelected(true);
        }
        vistaAnamnesis.getTxtComplicaciones_despues_parto().setText(postp.getComplicaciones_parto());
        if (postp.isLloro_nac() == true) {
            vistaAnamnesis.getJcxSiLloro().setSelected(true);
        } else if (postp.isLloro_nac() == false) {
            vistaAnamnesis.getJcxNoLloro().setSelected(true);
        }
        if (postp.isNecesito_oxigeno() == true) {
            vistaAnamnesis.getJcxSiOxigeno().setSelected(true);
        } else if (postp.isNecesito_oxigeno() == false) {
            vistaAnamnesis.getJcxNoOxigeno().setSelected(true);
        }
        vistaAnamnesis.getTxtTalla().setText(postp.getTalla());
        vistaAnamnesis.getTxtPeso().setText(postp.getPeso());
        if (postp.isSexo_esperado() == true) {
            vistaAnamnesis.getJcxSiSexo().setSelected(true);
        } else if (postp.isSexo_esperado() == false) {
            vistaAnamnesis.getJcxNoSexo().setSelected(true);
        }
        if (postp.getSintomas_after_part().equals("Depresión")) {
            vistaAnamnesis.getJcxDepresion().setSelected(true);
        } else if (postp.getSintomas_after_part().equals("Hipersensibilidad")) {
            vistaAnamnesis.getJcxHipersencibilidad().setSelected(true);
        }

        vistaAnamnesis.getTxtReaccionMadre().setText(postp.getReaccion_madre());
        vistaAnamnesis.getTxtReaccionPadre().setText(postp.getReaccion_padre());
        if (postp.isAlim_leche_mater() == true) {
            vistaAnamnesis.getJcxSiLeche().setSelected(true);
        } else if (postp.isSexo_esperado() == false) {
            vistaAnamnesis.getJcxNoLeche().setSelected(true);
        }
        vistaAnamnesis.getTxtPorqueLeche().setText(postp.getAlim_leche_master_descrip());
        vistaAnamnesis.getTxtEdadDioLeche().setText(postp.getEdad_fin_leche_mater());
        System.out.println("biberon");
        System.out.println(postp.isBiberon());
        if (postp.isBiberon() == true) {
            vistaAnamnesis.getJcxSiBiberon().setSelected(true);
        } else if (postp.isBiberon() == false) {
            vistaAnamnesis.getJcxNoBiberon().setSelected(true);
        }
        vistaAnamnesis.getTxtDesdeEdadBiberon().setText(postp.getBiberon_edad_ini());
        vistaAnamnesis.getTxtHastaEdadBiberon().setText(postp.getBiberon_edad_fin());
        if (postp.isProblemas_succion() == true) {
            vistaAnamnesis.getJcxSiSuccionar().setSelected(true);
        } else if (postp.isProblemas_succion() == false) {
            vistaAnamnesis.getJcxNoSuccionar().setSelected(true);
        }
        vistaAnamnesis.getTxtComoFueDestete().setText(postp.getDestete_descripcion());
        vistaAnamnesis.getTxtEdadSento().setText(postp.getEdad_sentar());
        vistaAnamnesis.getTxtEdadCamino().setText(postp.getEdad_caminar());
        vistaAnamnesis.getTxtEdadPrimerasPalabras().setText(postp.getEdad_primeras_palabras());
        vistaAnamnesis.getTxtInicioSolidos().setText(postp.getEdad_aliment_solido());
        vistaAnamnesis.getTxtVecesComeDia().setText(String.valueOf(postp.getVeces_como_diario()));
        vistaAnamnesis.getTxtComeSolooAcompanhado().setText(postp.getComer_solo_acompanado());
        vistaAnamnesis.getTxtActitudMadre().setText(postp.getActitud_madre_no_come());
        vistaAnamnesis.getJtxtdificultadesAlimentacion().setText(postp.getDificultades_alimentacion());
        // punto 8, 9, 10
        //punto 8
        modeloAnamnesisDB = new AnamnesisDB();
        Anamnesis anam = new Anamnesis();
        modeloAnamnesisDB.llenarcamposAnamnesis(anam);
        if (anam.getDes_motor_grueso().equals("Normal")) {
            vistaAnamnesis.getJcxNormalMotorGrueso().setSelected(true);
        } else if (anam.getDes_motor_grueso().equals("Irregular")) {
            vistaAnamnesis.getJcxIrregularMotorGrueso().setSelected(true);
        }
        if (anam.getDes_motor_fino().equals("Normal")) {
            vistaAnamnesis.getJcxNormalMotorFino().setSelected(true);
        } else if (anam.getDes_motor_fino().equals("Irregular")) {
            vistaAnamnesis.getJcxIrregularMotorFino().setSelected(true);
        }
        if (anam.getCaridad_lenguajes().equals("Claro")) {
            vistaAnamnesis.getJcxClaro().setSelected(true);
        } else if (anam.getCaridad_lenguajes().equals("No muy claro")) {
            vistaAnamnesis.getJcxNoMuyClaro().setSelected(true);
        } else if (anam.getCaridad_lenguajes().equals("No se entiende")) {
            vistaAnamnesis.getJcxNoSeEntiende().setSelected(true);
        }
        vistaAnamnesis.getTxtDificultadEspecifique().setText(anam.getClaridad_lenguajes_descrip());
        vistaAnamnesis.getTxtComoSonMovimientos().setText(anam.getMovimientos());
        vistaAnamnesis.getTxtPsicoSocial().setText(anam.getDes_psico_social());
        vistaAnamnesis.getTxtCognitivo().setText(anam.getDes_cognitivo());
        vistaAnamnesis.getTxtfisico().setText(anam.getDes_fisico());
        //punto 9
        if (anam.isDuerme_toda_noche() == true) {
            vistaAnamnesis.getJcxSiDuerme().setSelected(true);
        } else if (anam.isDuerme_toda_noche() == false) {
            vistaAnamnesis.getJcxNoDuerme().setSelected(true);
        }
        if (anam.isMiedo_dormir_solo() == true) {
            vistaAnamnesis.getJcxSiMiedoDormir().setSelected(true);
        } else if (anam.isMiedo_dormir_solo() == false) {
            vistaAnamnesis.getJcxNoMiedoDormir().setSelected(true);
        }
        if (anam.isPesadillas() == true) {
            vistaAnamnesis.getJcxSiPesadillas().setSelected(true);
        } else if (anam.isPesadillas() == false) {
            vistaAnamnesis.getJcxNoPesadillas().setSelected(true);
        }
        if (anam.isAyuda_bano() == true) {
            vistaAnamnesis.getJcxSiAyudaBanho().setSelected(true);
        } else if (anam.isAyuda_bano() == false) {
            vistaAnamnesis.getJcxNoAyudaBanho().setSelected(true);
        }
        if (anam.isMoja_cama() == true) {
            vistaAnamnesis.getJcxSiMojaCama().setSelected(true);
        } else if (anam.isMoja_cama() == false) {
            vistaAnamnesis.getJcxNoMojaCama().setSelected(true);
        }
        if (anam.isPeriodo_ecopresis() == true) {
            vistaAnamnesis.getJcxSiEcopresis().setSelected(true);
        } else if (anam.isPeriodo_ecopresis() == false) {
            vistaAnamnesis.getJcxNoEcopresis().setSelected(true);
        }
        vistaAnamnesis.getTxtCausaEcopresis().setText(anam.getPeriodo_ecopresis_descrip());
        vistaAnamnesis.getTxtEdadEsfinteres().setText(String.valueOf(anam.getEdad_control_esfinter()));
        vistaAnamnesis.getTxtConQuienDuerme().setText(anam.getAcompanamiento_dormir());
        vistaAnamnesis.getTxtComoDuerme().setText(anam.getComo_es_sueno());
        vistaAnamnesis.getTxtComoDespierta().setText(anam.getDespertar_descripcion());
        //punto 10
        if (anam.isEsc_estudia() == true) {
            vistaAnamnesis.getJcxSiEstudia().setSelected(true);
        } else if (anam.isEsc_estudia() == false) {
            vistaAnamnesis.getJcxNoEstudia().setSelected(true);
        }
        if (anam.isEsc_nna_problem_aprend() == true) {
            vistaAnamnesis.getJcxSiAprendizaje().setSelected(true);
        } else if (anam.isEsc_nna_problem_aprend() == false) {
            vistaAnamnesis.getJcxNoAprendizaje().setSelected(true);
        }
        if (anam.isEsc_asis_prog_apoyo() == true) {
            vistaAnamnesis.getJcxSiNivelacion().setSelected(true);
        } else if (anam.isEsc_asis_prog_apoyo() == false) {
            vistaAnamnesis.getJcxNoNivelacion().setSelected(true);
        }
        //
        vistaAnamnesis.getTxtExpliqueEstudia().setText(anam.getEsc_explicacion());
        //falta nombre institucion

        insDB = new InstitucionEducativaDB();
        InstitucionEducativa ins = new InstitucionEducativa();
        insDB.institucionAnamnesisCampos(ins);
        vistaAnamnesis.getTxtNombreInstitucion().setText(ins.getInst_nombre());
        vistaAnamnesis.getTxtAnhoCursa().setText(anam.getEsc_ultimo_anio_cursado());
        vistaAnamnesis.getTxtAnhoRepite().setText(anam.getEsc_repeticion_anio_causas());
        vistaAnamnesis.getTxtEspecifiqueAprendizaje().setText(anam.getEsc_nna_observaciones());
        vistaAnamnesis.getTxtEspecifiqueNivelacion().setText(anam.getEsc_asis_prog_apoyo_obser());
        //punto 11
        modelo_Salud_nnaDB = new Salud_nnaDB();
        Salud_nna sa = new Salud_nna();
        modelo_Salud_nnaDB.rellenarCamposAnamnesis(sa);
        if (sa.getProblem_familiare().equals("Síndrome de down")) {
            vistaAnamnesis.getJcxSindromeDown().setSelected(true);
        } else if (sa.getProblem_familiare().equals("Epilepsia")) {
            vistaAnamnesis.getJcxEpilepsia().setSelected(true);
        } else if (sa.getProblem_familiare().equals("Alcoholismo")) {
            vistaAnamnesis.getJcxAlcoholismo().setSelected(true);
        } else if (sa.getProblem_familiare().equals("Discapacidad Intelectual")) {
            vistaAnamnesis.getJcxDiscapacidadIntelectual().setSelected(true);
        }
        vistaAnamnesis.getTxtOtroEspecifique().setText(sa.getProblem_familiar_descrip());
        if (sa.isProblem_respiratorio() == true) {
            vistaAnamnesis.getJcxSiProblemasRespiratorios().setSelected(true);
        } else if (sa.isProblem_respiratorio() == false) {
            vistaAnamnesis.getJcxNoProblemasRespiratorios().setSelected(true);
        }
        vistaAnamnesis.getTxtEspecifiqueProblemasRespiratorios().setText(sa.getProblem_resp_descrip());
        if (sa.isProblem_alergias() == true) {
            vistaAnamnesis.getJcxSiAlergias().setSelected(true);
        } else if (sa.isProblem_alergias() == false) {
            vistaAnamnesis.getJcxNoAlergias().setSelected(true);
        }
        vistaAnamnesis.getTxtEspecifiqueAlergias().setText(sa.getProblem_aler_descrip());
        if (sa.isProblem_neurologico() == true) {
            vistaAnamnesis.getJcxSiNeurologicos().setSelected(true);
        } else if (sa.isProblem_neurologico() == false) {
            vistaAnamnesis.getJcxNoNeurologicos().setSelected(true);
        }
        vistaAnamnesis.getTxtEspecifiqueNeurologicos().setText(sa.getProblem_neuro_descrip());
        if (sa.isProblem_nerviosos() == true) {
            vistaAnamnesis.getJcxSiNerviosos().setSelected(true);
        } else if (sa.isProblem_nerviosos() == false) {
            vistaAnamnesis.getJcxNoNerviosos().setSelected(true);
        }
        vistaAnamnesis.getTxtEspecifiqueNerviosos().setText(sa.getProblem_nervi_descrip());
        //punto12
        vistaAnamnesis.getTxtClimaFamiliar().setText(sa.getClima_familiar());
        vistaAnamnesis.getTxtRelacionMadre().setText(sa.getRelacion_madre());
        vistaAnamnesis.getTxtRelacionPadre().setText(sa.getRelacion_padre());
        vistaAnamnesis.getTxtRelacionHermanos().setText(sa.getRelacion_hermanos());
        if (sa.isTrabajo() == true) {
            vistaAnamnesis.getJcxSiTrabajo().setSelected(true);
        } else if (sa.isTrabajo() == false) {
            vistaAnamnesis.getJcxNoTrabajo().setSelected(true);
        }
        vistaAnamnesis.getTxtEnqueaTrabajo().setText(sa.getTrabajo_decrip());
        if (sa.isAgresion_agresor() == true) {
            vistaAnamnesis.getJcxSiAgrede().setSelected(true);
        } else if (sa.isAgresion_agresor() == false) {
            vistaAnamnesis.getJcxNoAgrede().setSelected(true);
        }
        vistaAnamnesis.getTxtFrecuenciaAgresorAgrede().setText(sa.getAgresion_frecuencia());
        vistaAnamnesis.getTxtQueUtiliza().setText(sa.getObjeto_utilizado());
        vistaAnamnesis.getTxtObligacionesenlaFamilia().setText(sa.getObligacion_familiar());
        vistaAnamnesis.getTxtProyeciondelaMadre().setText(sa.getProyeccion_madre());
        vistaAnamnesis.getTxtNecesidadGrupoFamiliar().setText(sa.getNecesidad_inmediata());
        //punto 13
        vistaAnamnesis.getTxAObservaciones().setText(anam.getObservaciones_generales());
        System.out.println("");

        //-----------------------------------------FECHA MOD
        String ultima_modificacion = modeloAnamnesisDB.consultarUltimaFechaMod();
        System.out.println("Fecha modificacion");
        if (ultima_modificacion.equalsIgnoreCase(null)) {
            Timestamp ultFechaMod = new Timestamp(Calendar.getInstance().getTime().getTime());
            vistaAnamnesis.getLblUltiFechaMod().setText(ultFechaMod + "");
        } else {
            vistaAnamnesis.getLblUltiFechaMod().setText(ultima_modificacion);
        }
    }
//Variables para los datos de la victima en caso de que sea la madre
    private String nombreMadre, apellidoMadre;
    private int edadMadre, idNacionalidadMadre;

    public void cargarMadreVictima() {
        Hijos j = new Hijos();
        modeloHijosDB = new HijosDB();
        System.out.println(vistaAnamnesis.getTxtCodigo().getText());
        modeloHijosDB.HijosAnamnesis(j);
        vistaAnamnesis.getTxtNombre().setText(j.getPersona_nombre());
        System.out.println(j.getPersona_nombre());
        vistaAnamnesis.getTxtApellido().setText(j.getPersona_apellido());
        vistaAnamnesis.getTxtCedula().setText(j.getPersona_cedula());
        //  vistaAnamnesis.getJdcFechaElaboracion().setDate(j.getPersona_fecha_nac());
        if (!j.getPersona_cedula().equals("") || !j.getPersona_cedula().equals(null)) {
            vistaAnamnesis.getCbxPoseeCedula().setSelectedIndex(1);
        } else {
            vistaAnamnesis.getCbxPoseeCedula().setSelectedIndex(2);
        }
        vistaAnamnesis.getTxtEdadNNA().setText(String.valueOf(j.getEdad()));

        Victima v = new Victima();
        //vDB = new victimaDB();
        modeloVictimaDB.MadreVictimaAnamnesis(v);
        //Madre
        System.out.println(v.getPersona_nombre());
        nombreMadre = v.getPersona_nombre();
        apellidoMadre = v.getPersona_apellido();
        edadMadre = v.getEdad();
        idNacionalidadMadre = v.getPersona_nacionalidad();
//        vistaAnamnesis.getTxtNombreMadre().setText(v.getPersona_nombre());
//        vistaAnamnesis.getTxtApellidoMadre().setText(v.getPersona_apellido());
//        vistaAnamnesis.getTxtEdadMadre().setText(String.valueOf(v.getEdad()));
    }

    //ArrayList<Json_object_consulta> listaNacionalidades2 = new ArrayList<>();
    public void FormatoTabla() {
        tablaFamiliares = new DefaultTableModel();
        tablaFamiliares.addColumn("Id");
        tablaFamiliares.addColumn("Nombres");
        tablaFamiliares.addColumn("Apellidos");
        tablaFamiliares.addColumn("Sexo");
        tablaFamiliares.addColumn("Estado Civil");
        tablaFamiliares.addColumn("Parentesco");
        tablaFamiliares.addColumn("Ocupacion");
        tablaFamiliares.addColumn("Edad");
        tablaFamiliares.addColumn("Nivel Académico");

        this.vistaAnamnesis.getTabComposicionFamiliarNNA().setModel(tablaFamiliares);
    }

    public void CargarTablaFamiliares() {
        actualizarTblComposicionFamiliar();
//        Familiares f = new Familiares();
//        modeloFamiliaresDB = new FamiliaresDB();
//        modeloFamiliaresDB.FamiliaresAnamnesis(f);
//        String[] datos;
//
//        for (Familiares e : FamiliaresDB.listaFamiliares) {
//            datos = new String[9];
//            datos[0] = e.getFamiliares_id() + "";
//            datos[1] = e.getPersona_nombre() + "";
//            datos[2] = e.getPersona_apellido() + " ";
//            datos[3] = e.getPersona_sexo() + " ";
//            for (int i = 0; i < listaEstadoCivil.size(); i++) {
//                if (listaEstadoCivil.get(i).getId() == e.getPersona_estadocivil()) {
//                    datos[4] = listaEstadoCivil.get(i).getValor() + " ";
//                }
//            }
//
//            datos[5] = e.getParentesco() + " ";
//            for (int i = 0; i < listaOcupaciones.size(); i++) {
//                if (listaOcupaciones.get(i).getId() == e.getPersona_ocupacion()) {
//                    datos[6] = listaOcupaciones.get(i).getValor() + " ";
//                }
//            }
//
//            datos[7] = e.getEdad() + " ";
//
//            this.tablaFamiliares.addRow(datos);
//        }
//        FamiliaresDB.listaFamiliares.clear();
//        vistaAnamnesis.getTabComposicionFamiliarNNA().setModel(this.tablaFamiliares);
    }

    //METODO ESCUCHA PARA JTABBEDPANE
    @Override
    public void stateChanged(ChangeEvent e) {
        accionCambioVentana();//Llamamos al metodo y guardamos el estado anterior
        indiceVentanaCambiada = vistaAnamnesis.getJtpPrincipal().getSelectedIndex();//Seteamos el la nueva ventana seleccionada

    }
    boolean estadoEncabezado = false;

    //METODO PARA LA ACCIÓN DEL CAMBIO DE PESTAÑA 
    public void accionCambioVentana() {
        //formatearModelos();
        if (!estadoEncabezado) {
            mostrarMensajeEstadoPestana(vistaAnamnesis.getLblMensajesAnamnesisEstado(), vistaAnamnesis.getLblMensajesAnamnesis(), validarEncabezadoFichaAnamnesis());
            cargardatosEncabezadoFichaAnamnesis();
            estadoEncabezado = true;
        }

        switch (indiceVentanaCambiada) {
            case 0://DATOS DE IDENTIFICACIÓN--LISTO (VALIDACIONES PENDIENTES DE LOS BOOLEAN E INT)
                mostrarMensajeEstadoPestana(vistaAnamnesis.getLblMensajesAnamnesisEstado1(), vistaAnamnesis.getLblMensajesAnamnesis1(), validardatosIdentificacion());
                cargardatosIdentificacion();
                break;
            case 1://DATOS DE LA MADRE Y PADRE--LISTO
                mostrarMensajeEstadoPestana(vistaAnamnesis.getLblMensajesAnamnesisEstado2(), vistaAnamnesis.getLblMensajesAnamnesis2(), validardatosPadreMadre());
                cargardatosPadreMadre();
                break;
            case 2://COMPOSICIÓN FAMILIAR NNA --LISTO
                //Esta pestaña no necesita updates, solo una validación final.
                mostrarMensajeEstadoPestana(vistaAnamnesis.getLblMensajesAnamnesisEstado3(), vistaAnamnesis.getLblMensajesAnamnesis3(), validardatosComposicionFamiliarNNA());
                break;
            case 3://PERIODO DE EMBARAZO --PENDIENTE
                mostrarMensajeEstadoPestana(vistaAnamnesis.getLblMensajesAnamnesisEstado4(), vistaAnamnesis.getLblMensajesAnamnesis4(), validardatosPeriodoEmbarazo());
                cargardatosPeriodoEmbarazo();
                break;
            case 4://CONDICIONES DE NACIMIENTO  --LISTO
                mostrarMensajeEstadoPestana(vistaAnamnesis.getLblMensajesAnamnesisEstado5(), vistaAnamnesis.getLblMensajesAnamnesis5(), validardatosCondicionesNacimiento());
                cargardatosCondicionesNacimiento();
                break;
            case 5://PRIMEROS DÍAS DE VIDA --LISTO
                mostrarMensajeEstadoPestana(vistaAnamnesis.getLblMensajesAnamnesisEstado6(), vistaAnamnesis.getLblMensajesAnamnesis6(), validardatosPrimerosDiasVida());
                cargardatosPrimerosDiasVida();
                break;
            case 6://ALIMENTACIÓN ACTUAL 
                mostrarMensajeEstadoPestana(vistaAnamnesis.getLblMensajesAnamnesisEstado7(), vistaAnamnesis.getLblMensajesAnamnesis7(), validardatosAlimentacionActual());
                cargardatosAlimentacionActual();
                break;
            case 7://DESARROLLO DE MOTOR Y LENGUAJE ACTUAL
                mostrarMensajeEstadoPestana(vistaAnamnesis.getLblMensajesAnamnesisEstado8(), vistaAnamnesis.getLblMensajesAnamnesis8(), validardatosDesarrolloMotoLenguajeActual());
                cargardatosDesarrolloMotor();
                break;
            case 8://SUEÑO Y CONTROL DE ESFÍNTERES
                mostrarMensajeEstadoPestana(vistaAnamnesis.getLblMensajesAnamnesisEstado9(), vistaAnamnesis.getLblMensajesAnamnesis9(), validardatosSuenoControlEsfinter());
                cargardatos_Suenio_Control_esfin();
                break;
            case 9://ESCOLARIZACIÓN NNA
                mostrarMensajeEstadoPestana(vistaAnamnesis.getLblMensajesAnamnesisEstado10(), vistaAnamnesis.getLblMensajesAnamnesis10(), validardatosEscolarizacionNNA());
                cargardatos_EscolaridadNNA();
                break;
            case 10://SALUD 
                mostrarMensajeEstadoPestana(vistaAnamnesis.getLblMensajesAnamnesisEstado11(), vistaAnamnesis.getLblMensajesAnamnesis11(), validardatosSalud());
                cargardatos_Salud_NNA();
                break;
            case 11://RELACIÓN FAMILIAR 
                mostrarMensajeEstadoPestana(vistaAnamnesis.getLblMensajesAnamnesisEstado12(), vistaAnamnesis.getLblMensajesAnamnesis12(), validardatosRelacionFamiliar());
                cargardatos_Relacion_Familiar_NNA();
                break;
            case 12://OBSERVACIONES GENERALES
                mostrarMensajeEstadoPestana(vistaAnamnesis.getLblMensajesAnamnesisEstado13(), vistaAnamnesis.getLblMensajesAnamnesis13(), validardatosObservacionesGenerales());
                cargardatos_Observaciones_generales();
                break;
            default:
                System.out.println("NO SE CAMBIO DE VENTANA");
                break;
        }
    }

    public void guardarDatos() {
        //Llamamos al metodo para guardar el ultimo estado de la ultima pestaña seleccionada
        accionCambioVentana();
        boolean guardar = false;
        //System.out.println("Contador de hilo = " + contador);
        if (controlarFlujo()) {
            //Validamos si el usuario quiere guardar los datos en su estado actual
            if (JOptionPane.showConfirmDialog(null,
                    "Está a punto de guardar los datos en su estado actual. ¿Desea continuar?", "Confirmar datos", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE) == JOptionPane.YES_OPTION) {
                guardar = true;
            }
        } else {
            if (JOptionPane.showConfirmDialog(null,
                    "La ficha contiene datos que no han sido llenados ¿Está segur@ que desea guardar los datos en su estado actual?", "Confirmar datos", JOptionPane.OK_CANCEL_OPTION,
                    JOptionPane.QUESTION_MESSAGE) == JOptionPane.YES_OPTION) {
                guardar = true;
            }
        }

        //GUARDAMOS SI EL USUARIO A ESCOGIDO QUE SI QUIERE GUARDAR EN CUALQUIERA DE LAS DOS OPCIONES ANTERIORES
        if (guardar) {
            if (modeloAnamnesisDB.actualizacionFichaAnamnesis()) {
                JOptionPane.showMessageDialog(null, "La información fue guardada correctamente");
                if (modeloAnamnesisDB.actualizarFechaMod()) {
                    limpiarFichaAnamnesis();
                    this.vistaAnamnesis.dispose();
                    estadoHiloConexion = false;
                }
            } else {
                JOptionPane.showMessageDialog(null, "No se pudo guardar la información, intentelo nuevamente.");
            }
        }
    }

    //EL MÉTODO CONTROLARFLUJO SIRVE PARA VALIDAR SI TODO EL FLUJO DE LA FICHA ESTA LLENO, EN CASO DE ESTARLO RETORNARA TRUE CASO CONTRARIO FALSE
    public boolean controlarFlujo() {
        //VALIDACIÓN Y LLENADO DEL ENCABEZADO
        if (validarEncabezadoFichaAnamnesis()) {
            //VALIDACIÓN 1.1 DATOS DE IDENTIFICACIÓN 
            if (validardatosIdentificacion()) {
                //VALIDACIÓN 1.2 DATOS DE LA MADRE Y DEL PADRE Y VALIDACIÓN 1.3 SITUACIÓN EN LA QUE INGRESA EL NNA
                if (validardatosPadreMadre()) {
                    //VALIDACIÓN 1.4 COMPOSICIÓN FAMILIAR DEL NNA
                    if (validardatosComposicionFamiliarNNA()) {
                        //VALIDACIÓN 1.5 PERIODO DE EMBARAZO
                        if (validardatosPeriodoEmbarazo()) {
                            //VALIDACIÓN 1.6 CONDICIONES DE NACIMIENTO
                            if (validardatosCondicionesNacimiento()) {
                                //VALIDACION 1.7 PRIMEROS DÍAS DE VIDA
                                if (validardatosPrimerosDiasVida()) {
                                    //VALIDACIÓN 1.8 ALIMENTACIÓN ACTUAL
                                    if (validardatosAlimentacionActual()) {
                                        //VALIDACIÓN 1.9 DESARROLLO MOTOR Y LENGUAJE ACTUAL
                                        if (validardatosDesarrolloMotoLenguajeActual()) {
                                            //VALIDACIÓN 1.10 SUEÑO Y CONTROL DE ESFÍNTERES
                                            if (validardatosSuenoControlEsfinter()) {
                                                //VALIDACIÓN 1.11 ESCOLARIZACIÓN NNA
                                                if (validardatosEscolarizacionNNA()) {
                                                    //VALIDACIÓN 1.12 SALUD
                                                    if (validardatosSalud()) {
                                                        //VALIDACIÓN 1.13 RELACIÓN FAMILIAR
                                                        if (validardatosRelacionFamiliar()) {
                                                            //VALIDACIÓN 1.14 OBSERVACIONES GENERALES
                                                            if (validardatosObservacionesGenerales()) {
                                                                return true;//LA FICHA ESTA TOTALMENTE LLENA Y LISTA PARA GUARDARSE
                                                            } else {
                                                                System.out.println("ERROR EN EL PUNTO 1.14 OBSERVACIONES GENERALES");
                                                                return false;
                                                            }
                                                        } else {
                                                            System.out.println("ERROR EN EL PUNTO 1.13 RELACIÓN FAMILIAR");
                                                            return false;
                                                        }
                                                    } else {
                                                        System.out.println("ERROR EN EL PUNTO 1.12 SALUD");
                                                        return false;
                                                    }
                                                } else {
                                                    System.out.println("ERROR EN EL PUNTO 1.11 ESCOLARIZACIÓN NNA");
                                                    return false;
                                                }
                                            } else {
                                                System.out.println("ERROR EN EL PUNTO 1.10 SUEÑO Y CONTROL DE ESFÍNTERES");
                                                return false;
                                            }
                                        } else {
                                            System.out.println("ERROR EN EL PUNTO 1.9 DESARROLLO MOTOR Y LENGUAJE ACTUAL");
                                            return false;
                                        }
                                    } else {
                                        System.out.println("ERROR EN EL PUNTO 1.8 ALIMENTACIÓN ACTUAL");
                                        return false;
                                    }
                                } else {
                                    System.out.println("ERROR EN EL PUNTO 1.7 PRIMEROS DÍAS DE VIDA");
                                    return false;
                                }
                            } else {
                                System.out.println("ERROR EN EL PUNTO 1.6 CONDICIONES DE NACIMIENTO");
                                return false;
                            }
                        } else {
                            System.out.println("ERROR EN EL PUNTO 1.5 PERIODO DE EMBARAZO");
                            return false;
                        }
                    } else {
                        System.out.println("ERROR EN EL PUNTO 1.4 COMPOSICIÓN FAMILIAR NNA");
                        return false;
                    }
                } else {
                    System.out.println("ERROR EN EL PUNTO 1.2 DATOS DE LA MADRE Y EL PADRE Y 1.3 SITUACIÓN DE INGRESO NNA");
                    return false;
                }
            } else {
                System.out.println("ERROR EN EL PUNTO 1.1 DATOS DE IDENTIFICACIÓN");
                return false;
            }
        } else {
            System.out.println("ERROR EN EL ENCABEZADO DE LA FICHA");
            return false;
        }
    }

    //FORMATEAR MODELOS
    public void formatearModelos() {
        modeloFichaAnamnesisBD = new FichaAnamnesisBD();
        modeloAnamnesisDB = new AnamnesisDB();
        modeloHijosDB = new HijosDB();
        modeloPadreDB = new PadreDB();
        modeloFamiliaresDB = new FamiliaresDB();
        modeloNacimientoDB = new NacimientoDB();
        modeloDetalle_nacimientoDB = new Detalle_nacimientoDB();
        modeloPost_partoDB = new Post_partoDB();
        modeloVictimaDB = new victimaDB();
        modeloEmbarazo_EstadoDB = new Embarazo_estadoDB();
        modeloDesarrolloDB = new DesarrolloDB();
        modelo_sueno_esfinteresDB = new Sueno_control_esfinDB();
        modelo_EscolaridadDB = new EscolaridadDB();
        modelo_Salud_nnaDB = new Salud_nnaDB();
        modelo_relacion_familiar_nnaDB = new Relacion_familiar_nnaDB();
        filtroHijosVictima = new FiltroHijosVictima();
        try {
            modelo_Embarazo_complicacionesDB = new Embarazo_complicacionesDB();
        } catch (SQLException ex) {
            Logger.getLogger(ControladorFichaAnamnesis.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    //ENCABEZADO DE LA FICHA NNA
    public void cargardatosEncabezadoFichaAnamnesis() {
        modeloHijosDB.setPersona_nombre(vistaAnamnesis.getTxtNombreApellido().getText());//Seteamos el nombre
        modeloHijosDB.setPersona_apellido(vistaAnamnesis.getTxtNombreApellido().getText());//Seteamos el apellido
        modeloHijosDB.setPersona_cedula(vistaAnamnesis.getTxtCedula().getText());
        modeloAnamnesisDB.setFechaElaboracion(fechaBD(vistaAnamnesis.getJdcFechaElaboracion().getDate().getTime()));
        if (modeloAnamnesisDB.actualizarEncabezado()) {
            System.out.println("EL ENCABEZADO SE ACTUALIZÓ");
        } else {
            System.out.println("EL ENCABEZADO NO SE ACTUALIZÓ");
        }
    }

    //CARGAR DATOS: 1.1 DATOS DE IDENTIFICACIÓN - FICHA ANAMNESIS
    public void cargardatosIdentificacion() {
        //Como anteriormente creamos un objeto modelo de la clase HijosDB y estamos guardando datos del mismo nna entoncces procedemos a usarle mismo objeto
        //fecha nacimiento
        if (vistaAnamnesis.getJdcFechaNacimientoNNA().getDate() != null) {
            modeloHijosDB.setPersona_fecha_nac(fechaBD(vistaAnamnesis.getJdcFechaNacimientoNNA().getDate().getTime()));
        }
        //lugar de nacimiento
        modeloNacimientoDB.setLugar_nacimiento(vistaAnamnesis.getTxtLugarNacNNA1().getText());
        //Consultamos el id de la nacionalidad seleccionada y guardamos el resultado de en una variable
        //nacionalidad

        modeloHijosDB.setPersona_nacionalidad(vistaAnamnesis.getJcb_nacionalid_id().getSelectedIndex());//Ingresamos el id obtenido de la nacionalidad al modelo

        //ACTUALIZAMOS LA PESTAÑA
        if (modeloAnamnesisDB.actualizarDatosIdentificacion(modeloNacimientoDB, modeloHijosDB)) {
            System.out.println("PESTAÑA 1 ACTUALIZADA");
        } else {
            System.out.println("ERROR AL ACTUALIZAR 1");
        }
        //PENDIENTE VALIDA LA EDAD Y EL COMBO "POSEE CEDULA"
    }

    //CARGAR DATOS: 1.2 DATOS DE LA MADRE Y EL PADRE - FICHA ANAMNESIS
    public void cargardatosPadreMadre() {//Pendiente de cambios------------------------------------------------------------IMPORTANTE
        try {
            if (vistaAnamnesis.getRbnBeneficiariaMadre_No().isSelected()) {
                modeloAnamnesisDB.setNombre_madre(vistaAnamnesis.getTxtNombreMadre().getText());
                modeloAnamnesisDB.setApellido_madre(vistaAnamnesis.getTxtApellidoMadre().getText());
                String edad = vistaAnamnesis.getTxtEdadMadre().getText();
                if (!edad.equalsIgnoreCase("")) {
                    modeloAnamnesisDB.setEdad_madre(Integer.parseInt(edad));
                }

                modeloAnamnesisDB.setNacionalidad_madre(vistaAnamnesis.getJcb_nacionalidad_madre().getSelectedIndex());
            }
        } catch (Exception e) {
            Logger.getLogger(ControladorFichaAnamnesis.class.getName()).log(Level.SEVERE, null, e);
        }
        //nombre padre
        modeloPadreDB.setPersona_nombre(vistaAnamnesis.getTxtNombrePadre().getText());
        //apellido padre
        modeloPadreDB.setPersona_apellido(vistaAnamnesis.getTxtApellidoPadre().getText());
        //nacionalidad padre
        modeloPadreDB.setPersona_nacionalidad(vistaAnamnesis.getJcb_nacionalidad_padre().getSelectedIndex());
        //edad padre
        String edad = vistaAnamnesis.getTxtEdadPadre().getText();
        if (!"".equals(edad)) {
            modeloPadreDB.setEdad(Integer.parseInt(edad));
        }
        //padre agresor
        String padreAgresor;
        if ("Si".equals(vistaAnamnesis.getCbxPadreAgresor().getSelectedItem().toString())) {
            modeloHijosDB.setPadre_agresor(true);
            padreAgresor = "'true'";
        } else if ("No".equals(vistaAnamnesis.getCbxPadreAgresor().getSelectedItem().toString())) {
            modeloHijosDB.setPadre_agresor(false);
            padreAgresor = "'false'";
        } else {
            padreAgresor = "null";
        }

        //CARGAR DATOS: 1.3 SITUACIÓN EN LA QUE INGRESA EL NNA - FICHA ANAMNESIS
        modeloHijosDB.setHijo_estado_ingreso(vistaAnamnesis.getTxaSituacionIngresaNNA().getText());

        //EJECUTAMOS LA ACTUALIZACIÓN DE LA PESTAÑA
        if (vistaAnamnesis.getRbnBeneficiariaMadre_Si().isSelected()) {
            if (modeloAnamnesisDB.actualizarDatosPadre(modeloPadreDB, modeloHijosDB, padreAgresor)) {
                System.out.println("PESTAÑA 2 ACTUALIZADA");
            } else {
                System.out.println("ERROR AL ACTUALIZAR 2");
            }
        } else {
            if (modeloAnamnesisDB.actualizarDatosPadreMadre(modeloPadreDB, modeloHijosDB, padreAgresor)) {
                System.out.println("PESTAÑA 2 ACTUALIZADA");
            } else {
                System.out.println("ERROR AL ACTUALIZAR 2");
            }
        }
    }

    //CARGAR DATOS: 1.4 COMPOSICIÓN FAMILIAR DEL NNA - FICHA ANAMNESIS
    public void cargardatosComposicionFamiliarNNA() {
        //El usuario podra ingresar, editar y eliminar familiares de su composición familiar
        //Se cargaran datos a la tabla y luego a la base
    }

    //CARGAR DATOS: 1.5 PERIODO DE EMBARAZO
    public void cargardatosPeriodoEmbarazo() {
        try {
            complicaciones_embarazo_primer_metodo();
            //complicaciones_embarazo_segundo_metodo();--VALIDACIÓN DE POR MEDIO
            complecaciones_embarazo_tercer_metodo();
        } catch (SQLException ex) {
            Logger.getLogger(ControladorFichaAnamnesis.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void complicaciones_embarazo_primer_metodo() {
        filtroHijosVictima = new FiltroHijosVictima();
        int victima_codigo = filtroHijosVictima.getVictima_codigo_static();//1
        boolean embarazo_planificado = true;//2
        if (vistaAnamnesis.getCbxEmbarazoPlanificado().getSelectedItem().equals("Si")) {
            embarazo_planificado = true;
        }
        if (vistaAnamnesis.getCbxEmbarazoPlanificado().getSelectedItem().equals("No")) {
            embarazo_planificado = false;
        }
        String embarazo_reaccion_padre = vistaAnamnesis.getTxtReaccionPapa().getText();//3
        String embarazo_reaccion_madre = vistaAnamnesis.getTxtReaccionMama().getText();//4

        modeloEmbarazo_EstadoDB = new Embarazo_estadoDB(victima_codigo, embarazo_planificado,
                embarazo_reaccion_padre, embarazo_reaccion_madre);
        try {
            //metodo llenarestadoembarazo
            if (modeloEmbarazo_EstadoDB.update_campos_primer()) {
                System.out.println("ACTUALIZADA PESTAÑA 4");
            } else {
                System.out.println("ERROR AL ACTUALIZAR PESTAÑA 4");
            }
        } catch (SQLException ex) {
            Logger.getLogger(ControladorFichaAnamnesis.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void complicaciones_embarazo_segundo_metodo() throws SQLException {

        x_emb_comp1db = new x_embarazo_comp1DB();
        x_emb_comp1db.primer_insert();
    }

    public void complecaciones_embarazo_tercer_metodo() throws SQLException {
        modelo_Embarazo_complicacionesDB = new Embarazo_complicacionesDB();
        modeloEmbarazo_EstadoDB = new Embarazo_estadoDB();
        listaembarazocomplicaciones = new ArrayList<>();
        modeloAnamnesisDB = new AnamnesisDB();

        if (vistaAnamnesis.getJcxSiViolencia().isSelected()) {
            int emb_comp_id = modelo_Embarazo_complicacionesDB.obtener_id("Si", 1);
            embarazo_complicaciones_json = new Embarazo_complicaciones_json(emb_comp_id, "", true);
            listaembarazocomplicaciones.add(embarazo_complicaciones_json);
        }
        if (vistaAnamnesis.getJcxNoViolencia().isSelected()) {
            int emb_comp_id = modelo_Embarazo_complicacionesDB.obtener_id("No", 1);
            embarazo_complicaciones_json = new Embarazo_complicaciones_json(emb_comp_id, "", true);
            listaembarazocomplicaciones.add(embarazo_complicaciones_json);
        }
        if (vistaAnamnesis.getJcxGolpes().isSelected()) {
            int emb_comp_id = modelo_Embarazo_complicacionesDB.obtener_id("Golpes", 1);
            embarazo_complicaciones_json = new Embarazo_complicaciones_json(emb_comp_id, "", true);
            listaembarazocomplicaciones.add(embarazo_complicaciones_json);
        }
        if (vistaAnamnesis.getJcxInsultos().isSelected()) {
            int emb_comp_id = modelo_Embarazo_complicacionesDB.obtener_id("Insultos", 1);
            embarazo_complicaciones_json = new Embarazo_complicaciones_json(emb_comp_id, "", true);
            listaembarazocomplicaciones.add(embarazo_complicaciones_json);
        }
        if (vistaAnamnesis.getJcxNegligencia().isSelected()) {
            int emb_comp_id = modelo_Embarazo_complicacionesDB.obtener_id("Negligencia", 1);
            embarazo_complicaciones_json = new Embarazo_complicaciones_json(emb_comp_id, "", true);
            listaembarazocomplicaciones.add(embarazo_complicaciones_json);
        }
        if (vistaAnamnesis.getJcxAmbitoLaboral().isSelected()) {
            int emb_comp_id = modelo_Embarazo_complicacionesDB.obtener_id("En el ámbito laboral", 1);
            embarazo_complicaciones_json = new Embarazo_complicaciones_json(emb_comp_id, "", true);
            listaembarazocomplicaciones.add(embarazo_complicaciones_json);
        }
        if (vistaAnamnesis.getJcxAbusoSexual().isSelected()) {
            int emb_comp_id = modelo_Embarazo_complicacionesDB.obtener_id("Abuso sexual", 1);
            embarazo_complicaciones_json = new Embarazo_complicaciones_json(emb_comp_id, "", true);
            listaembarazocomplicaciones.add(embarazo_complicaciones_json);
        }
        if (vistaAnamnesis.getJcxSiControles().isSelected()) {
            int emb_comp_id = modelo_Embarazo_complicacionesDB.obtener_id("Si", 2);
            embarazo_complicaciones_json = new Embarazo_complicaciones_json(emb_comp_id, "", true);
            listaembarazocomplicaciones.add(embarazo_complicaciones_json);
        }
        if (vistaAnamnesis.getJcxNoControles().isSelected()) {
            int emb_comp_id = modelo_Embarazo_complicacionesDB.obtener_id("No", 2);
            embarazo_complicaciones_json = new Embarazo_complicaciones_json(emb_comp_id, "", true);
            listaembarazocomplicaciones.add(embarazo_complicaciones_json);
        }
        if (vistaAnamnesis.getJcxUnaVez().isSelected()) {
            int emb_comp_id = modelo_Embarazo_complicacionesDB.obtener_id("Una sola vez", 2);
            embarazo_complicaciones_json = new Embarazo_complicaciones_json(emb_comp_id, "", true);
            listaembarazocomplicaciones.add(embarazo_complicaciones_json);
        }
        if (vistaAnamnesis.getJcxMensual().isSelected()) {
            int emb_comp_id = modelo_Embarazo_complicacionesDB.obtener_id("Mensual", 2);
            embarazo_complicaciones_json = new Embarazo_complicaciones_json(emb_comp_id, "", true);
            listaembarazocomplicaciones.add(embarazo_complicaciones_json);
        }
        if (vistaAnamnesis.getJcxTrimestral().isSelected()) {
            int emb_comp_id = modelo_Embarazo_complicacionesDB.obtener_id("Trimestral", 2);
            embarazo_complicaciones_json = new Embarazo_complicaciones_json(emb_comp_id, "", true);
            listaembarazocomplicaciones.add(embarazo_complicaciones_json);
        }
        if (vistaAnamnesis.getJcxNinguna().isSelected()) {
            int emb_comp_id = modelo_Embarazo_complicacionesDB.obtener_id("Ninguna", 2);
            embarazo_complicaciones_json = new Embarazo_complicaciones_json(emb_comp_id, "", true);
            listaembarazocomplicaciones.add(embarazo_complicaciones_json);
        }
        String donde_realizo_controles = vistaAnamnesis.getTxtDondeRealizoControles().getText();//1
        if (vistaAnamnesis.getJcxSiComplicaciones().isSelected()) {
            int emb_comp_id = modelo_Embarazo_complicacionesDB.obtener_id("Si", 3);
            embarazo_complicaciones_json = new Embarazo_complicaciones_json(emb_comp_id, "", true);
            listaembarazocomplicaciones.add(embarazo_complicaciones_json);
        }
        if (vistaAnamnesis.getJcxNoComplicaciones().isSelected()) {
            int emb_comp_id = modelo_Embarazo_complicacionesDB.obtener_id("No", 3);
            embarazo_complicaciones_json = new Embarazo_complicaciones_json(emb_comp_id, "", true);
            listaembarazocomplicaciones.add(embarazo_complicaciones_json);
        }
        if (vistaAnamnesis.getJcxBajoPeso().isSelected()) {
            int emb_comp_id = modelo_Embarazo_complicacionesDB.obtener_id("Bajo Peso", 3);
            embarazo_complicaciones_json = new Embarazo_complicaciones_json(emb_comp_id, "", true);
            listaembarazocomplicaciones.add(embarazo_complicaciones_json);
        }
        if (vistaAnamnesis.getJcxHemorragias().isSelected()) {
            int emb_comp_id = modelo_Embarazo_complicacionesDB.obtener_id("Hemorragias", 3);
            embarazo_complicaciones_json = new Embarazo_complicaciones_json(emb_comp_id, "", true);
            listaembarazocomplicaciones.add(embarazo_complicaciones_json);;
        }
        if (vistaAnamnesis.getJcxInfecciones().isSelected()) {
            int emb_comp_id = modelo_Embarazo_complicacionesDB.obtener_id("Infecciones", 3);
            embarazo_complicaciones_json = new Embarazo_complicaciones_json(emb_comp_id, "", true);
            listaembarazocomplicaciones.add(embarazo_complicaciones_json);
        }
        if (vistaAnamnesis.getJcxPreclansia().isSelected()) {
            int emb_comp_id = modelo_Embarazo_complicacionesDB.obtener_id("Preeclampsia", 3);
            embarazo_complicaciones_json = new Embarazo_complicaciones_json(emb_comp_id, "", true);
            listaembarazocomplicaciones.add(embarazo_complicaciones_json);
        }
        if (vistaAnamnesis.getJcxPreclansia().isSelected()) {
            int emb_comp_id = modelo_Embarazo_complicacionesDB.obtener_id("Otros", 3);
            String mater_otro_descrip = vistaAnamnesis.getTxtOtraComplicacionEmbarazo().getText();
            embarazo_complicaciones_json = new Embarazo_complicaciones_json(emb_comp_id, "", true);
            listaembarazocomplicaciones.add(embarazo_complicaciones_json);
        }
        if (vistaAnamnesis.getJcxSiConsume().isSelected()) {
            int emb_comp_id = modelo_Embarazo_complicacionesDB.obtener_id("Si", 4);
            embarazo_complicaciones_json = new Embarazo_complicaciones_json(emb_comp_id, "", true);
            listaembarazocomplicaciones.add(embarazo_complicaciones_json);
        }
        if (vistaAnamnesis.getJcxNoConsume().isSelected()) {
            int emb_comp_id = modelo_Embarazo_complicacionesDB.obtener_id("No", 4);
            embarazo_complicaciones_json = new Embarazo_complicaciones_json(emb_comp_id, "", true);
            listaembarazocomplicaciones.add(embarazo_complicaciones_json);
        }
        if (vistaAnamnesis.getJcxTabaco().isSelected()) {
            int emb_comp_id = modelo_Embarazo_complicacionesDB.obtener_id("Tabaco", 4);
            embarazo_complicaciones_json = new Embarazo_complicaciones_json(emb_comp_id, "", true);
            listaembarazocomplicaciones.add(embarazo_complicaciones_json);
        }
        if (vistaAnamnesis.getJcxAlcohol().isSelected()) {
            int emb_comp_id = modelo_Embarazo_complicacionesDB.obtener_id("Alcohol", 4);
            embarazo_complicaciones_json = new Embarazo_complicaciones_json(emb_comp_id, "", true);
            listaembarazocomplicaciones.add(embarazo_complicaciones_json);
        }
        if (vistaAnamnesis.getJcxDroga().isSelected()) {
            int emb_comp_id = modelo_Embarazo_complicacionesDB.obtener_id("Droga", 4);
            embarazo_complicaciones_json = new Embarazo_complicaciones_json(emb_comp_id, "", true);
            listaembarazocomplicaciones.add(embarazo_complicaciones_json);
        }
        String consumo_causas = vistaAnamnesis.getTxtCausasConsumo().getText();//2
        if (vistaAnamnesis.getJcxSiAborto().isSelected()) {
            int emb_comp_id = modelo_Embarazo_complicacionesDB.obtener_id("Si", 5);
            embarazo_complicaciones_json = new Embarazo_complicaciones_json(emb_comp_id, "", true);
            listaembarazocomplicaciones.add(embarazo_complicaciones_json);
        }
        if (vistaAnamnesis.getJcxNoAborto().isSelected()) {
            int emb_comp_id = modelo_Embarazo_complicacionesDB.obtener_id("No", 5);
            embarazo_complicaciones_json = new Embarazo_complicaciones_json(emb_comp_id, "", true);
            listaembarazocomplicaciones.add(embarazo_complicaciones_json);
        }
        String aborto_causas = vistaAnamnesis.getTxtCausasAborto().getText();

        Embarazo_estadoDB modeloEmbarazo_EstadoDB2 = new Embarazo_estadoDB(donde_realizo_controles, consumo_causas, aborto_causas);
        modeloEmbarazo_EstadoDB2.update_campos_segundo();

        String json_complicaciones = new Gson().toJson(listaembarazocomplicaciones);
        x_emb_comp1db = new x_embarazo_comp1DB(true, json_complicaciones);
        x_emb_comp1db.update_x_embarazo_comp();

    }

    //CARGAR DATOS: 1.6 CONDICIONES DE NACIMIENTO
    public void cargardatosCondicionesNacimiento() {
        //mes alumbramiento
        if (vistaAnamnesis.getJcb_mes_alumbramiento().getSelectedIndex() > 0) {
            modeloNacimientoDB.setMes_alumbramiento(vistaAnamnesis.getJcb_mes_alumbramiento().getSelectedIndex());
        }
        //lugar alumbramiento
        modeloNacimientoDB.setLugar_nacimiento(vistaAnamnesis.getTxtLugarParto().getText());
        //tipo de parto
        if (vistaAnamnesis.getJcxNormal().isSelected()) {
            modeloNacimientoDB.setParto_tipo("Normal");
            //motivo de cesárea
            modeloNacimientoDB.setMotivo_cesarea("");
        } else if (vistaAnamnesis.getJcxCesarea().isSelected()) {
            modeloNacimientoDB.setParto_tipo("Cesárea");
            //motivo de cesárea
            modeloNacimientoDB.setMotivo_cesarea(vistaAnamnesis.getTxtMotivoCesarea().getText());
        }

        //usaron anestesia
        String anestesia;
        if (vistaAnamnesis.getJcxSiAnestesia().isSelected()) {
//            modeloNacimientoDB.setAnestesia(true);
            anestesia = "'true'";
        } else if (vistaAnamnesis.getJcxNoAnestesia().isSelected()) {
//            modeloNacimientoDB.setAnestesia(false);
            anestesia = "'false'";
        } else {
            anestesia = "null";
        }

        //complicaciones despues del parto
        modeloDetalle_nacimientoDB.setComplicaciones_parto(vistaAnamnesis.getTxtComplicaciones_despues_parto().getText());
        //lloro al nacer
        String lloroNac;
        if (vistaAnamnesis.getJcxSiLloro().isSelected()) {
//            modeloDetalle_nacimientoDB.setLloro_nac(true);
            lloroNac = "'true'";
        } else if (vistaAnamnesis.getJcxNoLloro().isSelected()) {
//            modeloDetalle_nacimientoDB.setLloro_nac(false);
            lloroNac = "'false'";
        } else {
            lloroNac = "null";

        }
        //necesito oxigeno
        String necesito_O;
        if (vistaAnamnesis.getJcxSiOxigeno().isSelected()) {
//            modeloDetalle_nacimientoDB.setNecesito_oxigeno(true);
            necesito_O = "'true'";
        } else if (vistaAnamnesis.getJcxNoOxigeno().isSelected()) {
//            modeloDetalle_nacimientoDB.setNecesito_oxigeno(false);
            necesito_O = "'false'";
        } else {
            necesito_O = "null";
        }
        //peso
        modeloDetalle_nacimientoDB.setPeso(vistaAnamnesis.getTxtPeso().getText());
        //talla
        modeloDetalle_nacimientoDB.setTalla(vistaAnamnesis.getTxtTalla().getText());
        //sintomas después del parto
        if (vistaAnamnesis.getJcxDepresion().isSelected()) {
            modeloDetalle_nacimientoDB.setSintomas_after_part("Depresión");
        } else if (vistaAnamnesis.getJcxHipersencibilidad().isSelected()) {
            modeloDetalle_nacimientoDB.setSintomas_after_part("Hipersensibilidad");
        }
        //sexo esperado
        String sexoEsperado;
        if (vistaAnamnesis.getJcxSiSexo().isSelected()) {
//            modeloPost_partoDB.setSexo_esperado(true);
            sexoEsperado = "'true'";
        } else if (vistaAnamnesis.getJcxNoSexo().isSelected()) {
            modeloPost_partoDB.setSexo_esperado(false);
            sexoEsperado = "'false'";
        } else {
            sexoEsperado = "null";
        }
        //reaccion madre
        modeloPost_partoDB.setReaccion_madre(vistaAnamnesis.getTxtReaccionMadre().getText());
        //reaccion padre
        modeloPost_partoDB.setReaccion_padre(vistaAnamnesis.getTxtReaccionPadre().getText());

        //EJECUTAMOS LA SENTENCIA DE ACTUALIZACIÓN DE PESTAÑA
        if (modeloAnamnesisDB.actualizarDatosCondicionesNacimiento(modeloNacimientoDB, modeloDetalle_nacimientoDB, modeloPost_partoDB, anestesia, lloroNac, necesito_O, sexoEsperado)) {
            System.out.println("PESTAÑA 2 ACTUALIZADA 5");
        } else {
            System.out.println("ERROR AL ACTUALIZAR 5");
        }
    }

    //CARGAR DATOS: 1.7 PRIMEROS DÍAS DE VIDA 
    public void cargardatosPrimerosDiasVida() {
        //Leche materna
        String lecheMaterna;
        if (vistaAnamnesis.getJcxSiLeche().isSelected()) {
//            modeloPost_partoDB.setAlim_leche_mater(true);
            lecheMaterna = "'true'";
            modeloPost_partoDB.setAlim_leche_master_descrip("");
        } else if (vistaAnamnesis.getJcxNoLeche().isSelected()) {
//            modeloPost_partoDB.setAlim_leche_mater(false);
            lecheMaterna = "'false'";
            //Leche materna observaciones
            modeloPost_partoDB.setAlim_leche_master_descrip(vistaAnamnesis.getTxtPorqueLeche().getText());
        } else {
            lecheMaterna = "null";
        }
        //edad fin leche materna
        modeloPost_partoDB.setEdad_fin_leche_mater(vistaAnamnesis.getTxtEdadDioLeche().getText());
        //HABLAR SOBRE EL TIPO DE DATO DEL BIBERON
        String usoBiberon;
        if (vistaAnamnesis.getJcxSiBiberon().isSelected()) {
//            modeloPost_partoDB.setBiberon(true);
            usoBiberon = "'true'";
        } else if (vistaAnamnesis.getJcxNoBiberon().isSelected()) {
//            modeloPost_partoDB.setBiberon(false);
            usoBiberon = "'false'";
        } else {
            usoBiberon = "null";
        }
        modeloPost_partoDB.setBiberon_edad_ini(vistaAnamnesis.getTxtDesdeEdadBiberon().getText());
        modeloPost_partoDB.setBiberon_edad_fin(vistaAnamnesis.getTxtHastaEdadBiberon().getText());
        //Dificultades para succionar
        String dificultadSuccion;
        if (vistaAnamnesis.getJcxSiSuccionar().isSelected()) {
//            modeloPost_partoDB.setProblemas_succion(true);
            dificultadSuccion = "'true'";
        } else if (vistaAnamnesis.getJcxNoSuccionar().isSelected()) {
//            modeloPost_partoDB.setProblemas_succion(false);
            dificultadSuccion = "'false'";
        } else {
            dificultadSuccion = "null";
        }
        modeloPost_partoDB.setDestete_descripcion(vistaAnamnesis.getTxtComoFueDestete().getText());
        modeloPost_partoDB.setEdad_sentar(vistaAnamnesis.getTxtEdadSento().getText());
        modeloPost_partoDB.setEdad_caminar(vistaAnamnesis.getTxtEdadCamino().getText());
        modeloPost_partoDB.setEdad_primeras_palabras(vistaAnamnesis.getTxtEdadPrimerasPalabras().getText());

        //EJECUTAMOS LA SENTENCIA
        if (modeloPost_partoDB.actualizarDatosPrimerosDiasVida(lecheMaterna, usoBiberon, dificultadSuccion)) {
            System.out.println("PESTAÑA ACTUALIZADA 6");
        } else {
            System.out.println("ERROR AL ACTUALIZAR 6");
        }
    }

    //CARGAR DATOS: 1.8 ALIMENTACIÓN ACTUAL 
    public void cargardatosAlimentacionActual() {
        formatearModelos();//Formateamos los modelos
        //¿A qué edad inicio su alimentación son sólidos?
        modeloPost_partoDB.setEdad_aliment_solido(vistaAnamnesis.getTxtInicioSolidos().getText());
        //Dificultades de alimentación
        modeloPost_partoDB.setDificultades_alimentacion(vistaAnamnesis.getJtxtdificultadesAlimentacion().getText());
        //Numero de veces que come al día
        if (!"".equals(vistaAnamnesis.getTxtVecesComeDia().getText())) {
            modeloPost_partoDB.setVeces_como_diario(Integer.parseInt(vistaAnamnesis.getTxtVecesComeDia().getText()));
        }
        //come solo o acompañado
        modeloPost_partoDB.setComer_solo_acompanado(vistaAnamnesis.getTxtComeSolooAcompanhado().getText());
        //Actitud de la madre cuando no come
        modeloPost_partoDB.setActitud_madre_no_come(vistaAnamnesis.getTxtActitudMadre().getText());
        //EJECUTAMOS LA SENTENCIA DE ACTUALIZACIÓN
        if (modeloPost_partoDB.actualizarDatosAlimentacionActual(5)) {
            System.out.println("PESTAÑA ACTUALIZADA 7");
        } else {
            System.out.println("ERROR AL ACTUALIZAR 7");
        }
    }

    //CARGAR DATOS: 1.9 DESARROLLO MOTOR Y LENGUAJE ACTUAL
    public void cargardatosDesarrolloMotor() {
        String des_motor_grueso = "";//1
        if (vistaAnamnesis.getJcxNormalMotorGrueso().isSelected()) {
            des_motor_grueso = "Normal";
        } else if (vistaAnamnesis.getJcxIrregularMotorGrueso().isSelected()) {
            des_motor_grueso = "Irregular";
        }
        String des_motor_fino = "";//2
        if (vistaAnamnesis.getJcxNormalMotorFino().isSelected()) {
            des_motor_fino = "Normal";
        } else if (vistaAnamnesis.getJcxIrregularMotorFino().isSelected()) {
            des_motor_fino = "Irregular";
        }
        String movimientos = vistaAnamnesis.getTxtComoSonMovimientos().getText();//3
        String des_psico_social = vistaAnamnesis.getTxtPsicoSocial().getText();//4
        String des_cognitivo = vistaAnamnesis.getTxtCognitivo().getText();//5
        String des_fisico = vistaAnamnesis.getTxtfisico().getText();//6
        String caridad_lenguajes = "";//7
        if (vistaAnamnesis.getJcxClaro().isSelected()) {
            caridad_lenguajes = "Claro";
        } else if (vistaAnamnesis.getJcxNoMuyClaro().isSelected()) {
            caridad_lenguajes = "No muy claro";
        } else if (vistaAnamnesis.getJcxNoSeEntiende().isSelected()) {
            caridad_lenguajes = "No se entiende";
        }
        String claridad_lenguajes_descrip = vistaAnamnesis.getTxtDificultadEspecifique().getText();//8

        modeloDesarrolloDB = new DesarrolloDB(des_motor_grueso, des_motor_fino, movimientos,
                des_psico_social, des_cognitivo, des_fisico, caridad_lenguajes,
                claridad_lenguajes_descrip);
        try {
            //metodo llenar
            if (modeloDesarrolloDB.update_desarrollo()) {
                System.out.println("PESTAÑA ACTUALIZADA 8");
            } else {
                System.out.println("ERROR AL ACTUALIZAR PESTAÑA 8");
            }
        } catch (SQLException ex) {
            Logger.getLogger(ControladorFichaAnamnesis.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    //CARGAR DATOS: 1.10 SUEÑO Y CONTROL DE ESFÍNTERES 
    public void cargardatos_Suenio_Control_esfin() {
        boolean duerme_toda_noche = true;//1
        String duermeTodaNoche;
        if (vistaAnamnesis.getJcxSiDuerme().isSelected()) {
//            duerme_toda_noche = true;
            duermeTodaNoche = "'true'";
        } else if (vistaAnamnesis.getJcxNoDuerme().isSelected()) {
//            duerme_toda_noche = false;
            duermeTodaNoche = "'false'";
        } else {
            duermeTodaNoche = "null";
        }

        boolean miedo_dormir_solo = true;//2
        String miedoDormirSolo;
        if (vistaAnamnesis.getJcxSiMiedoDormir().isSelected()) {
//            miedo_dormir_solo = true;
            miedoDormirSolo = "'true'";
        } else if (vistaAnamnesis.getJcxNoMiedoDormir().isSelected()) {
//            miedo_dormir_solo = false;
            miedoDormirSolo = "'false'";
        } else {
            miedoDormirSolo = "null";
        }

//        String despertar_descripcion = vistaAnamnesis.getTxtComoDespierta().getText();//3
        modelo_sueno_esfinteresDB.setComo_es_sueno(vistaAnamnesis.getTxtComoDuerme().getText());
        modelo_sueno_esfinteresDB.setDespertar_descripcion(vistaAnamnesis.getTxtComoDespierta().getText());
        modelo_sueno_esfinteresDB.setAcompanamiento_dormir(vistaAnamnesis.getTxtConQuienDuerme().getText());
        if (!vistaAnamnesis.getTxtEdadEsfinteres().getText().isEmpty()) {
            modelo_sueno_esfinteresDB.setEdad_control_esfinter(Integer.parseInt(vistaAnamnesis.getTxtEdadEsfinteres().getText()));
        } else {
            modelo_sueno_esfinteresDB.setEdad_control_esfinter(0);
        }

//        boolean pesadillas = true;//4
        String pesadillas;
        if (vistaAnamnesis.getJcxSiPesadillas().isSelected()) {
//            pesadillas = true;
            pesadillas = "'true'";
        } else if (vistaAnamnesis.getJcxNoPesadillas().isSelected()) {
//            pesadillas = false;
            pesadillas = "'false'";
        } else {
            pesadillas = "null";
        }

//        String edadcontrolesfinter = vistaAnamnesis.getTxtEdadEsfinteres().getText();
//        int edad_control_esfinter = Integer.parseInt(edadcontrolesfinter);//5
//        boolean ayuda_bano = true;//6
        String ayudaBano;
        if (vistaAnamnesis.getJcxSiAyudaBanho().isSelected()) {
//            ayuda_bano = true;
            ayudaBano = "'true'";
        } else if (vistaAnamnesis.getJcxNoAyudaBanho().isSelected()) {
//            ayuda_bano = false;
            ayudaBano = "'false'";
        } else {
            ayudaBano = "null";
        }
//        boolean moja_cama = true;//7
        String mojaCama;
        if (vistaAnamnesis.getJcxSiMojaCama().isSelected()) {
//            moja_cama = true;
            mojaCama = "'true'";
        } else if (vistaAnamnesis.getJcxNoMojaCama().isSelected()) {
//            moja_cama = false;
            mojaCama = "'false'";
        } else {
            mojaCama = "null";
        }
        String periodo_ecopresis_descrip = vistaAnamnesis.getTxtCausaEcopresis().getText();//8
        boolean periodo_ecopresis = true;//9
        String periodoEcopresis;
        if (vistaAnamnesis.getJcxSiEcopresis().isSelected()) {
//            periodo_ecopresis = true;
            periodoEcopresis = "'true'";
            modelo_sueno_esfinteresDB.setPeriodo_ecopresis_descrip(vistaAnamnesis.getTxtCausaEcopresis().getText());
        } else if (vistaAnamnesis.getJcxNoEcopresis().isSelected()) {
//            periodo_ecopresis = false;
            periodoEcopresis = "'false'";
            modelo_sueno_esfinteresDB.setPeriodo_ecopresis_descrip(null);
        } else {
            periodoEcopresis = "null";
        }

        String como_es_sueno = vistaAnamnesis.getTxtComoDuerme().getText();//10
        String acompanamiento_dormir = vistaAnamnesis.getTxtConQuienDuerme().getText();//11
//        modelo_sueno_esfinteresDB = new Sueno_control_esfinDB(duerme_toda_noche, miedo_dormir_solo,
//                despertar_descripcion, pesadillas, edad_control_esfinter, ayuda_bano,
//                moja_cama, periodo_ecopresis_descrip, periodo_ecopresis, como_es_sueno,
//                acompanamiento_dormir);
//        String como_es_sueno = vistaAnamnesis.getTxtComoDuerme().getText();//10
//        String acompanamiento_dormir = vistaAnamnesis.getTxtConQuienDuerme().getText();//11
//        modelo_sueno_esfinteresDB = new Sueno_control_esfinDB(duerme_toda_noche, miedo_dormir_solo,
//                despertar_descripcion, pesadillas, edad_control_esfinter, ayuda_bano,
//                moja_cama, periodo_ecopresis_descrip, periodo_ecopresis, como_es_sueno,
//                acompanamiento_dormir);
        //metodo llenarsueno_control_esfin
        try {
            if (modelo_sueno_esfinteresDB.update_sueno_control_esfin(duermeTodaNoche, miedoDormirSolo, pesadillas, ayudaBano, mojaCama, periodoEcopresis)) {
                System.out.println("ACTUALIZADA PESTAÑA 9");
            } else {
                System.out.println("ERROR AL ACTUALIZAR LA PESTAÑA 9");
            }
        } catch (SQLException ex) {
            System.out.println("ERROR EN EL MÉTODO> cargardatos_Suenio_Control_esfin");
            Logger.getLogger(ControladorFichaAnamnesis.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    //CARGAR DATOS: 1.11 ESCOLARIZACIÓN NNA 
    public void cargardatos_EscolaridadNNA() {
        boolean esc_estudia = true;//1
        if (vistaAnamnesis.getJcxSiEstudia().isSelected()) {
            esc_estudia = true;
        }
        if (vistaAnamnesis.getJcxNoEstudia().isSelected()) {
            esc_estudia = false;
        }
        String esc_explicacion = vistaAnamnesis.getTxtExpliqueEstudia().getText();//2
        String esc_repeticion_anio_causas = vistaAnamnesis.getTxtAnhoCursa().getText();//3
        boolean esc_nna_problem_aprend = true;//4
        if (vistaAnamnesis.getJcxSiAprendizaje().isSelected()) {
            esc_nna_problem_aprend = true;
        }
        if (vistaAnamnesis.getJcxNoAprendizaje().isSelected()) {
            esc_nna_problem_aprend = false;
        }
        String esc_nna_observaciones = vistaAnamnesis.getTxtEspecifiqueAprendizaje().getText();//5
        boolean esc_asis_prog_apoyo = true;//6
        if (vistaAnamnesis.getJcxSiNivelacion().isSelected()) {
            esc_asis_prog_apoyo = true;
        }
        if (vistaAnamnesis.getJcxNoNivelacion().isSelected()) {
            esc_asis_prog_apoyo = false;
        }
        String esc_asis_prog_apoyo_obser = vistaAnamnesis.getTxtEspecifiqueNivelacion().getText();//7
        modelo_EscolaridadDB = new EscolaridadDB(esc_estudia, esc_explicacion, esc_repeticion_anio_causas,
                esc_nna_problem_aprend, esc_nna_observaciones, esc_asis_prog_apoyo, esc_asis_prog_apoyo_obser);
        //metodo llenar_escolaridad
        try {
            if (modelo_EscolaridadDB.update_escolaridad()) {
                System.out.println("ACTUALIZADA PESTAÑA 10");
            } else {
                System.out.println("ERROR AL ACTUALIZAR LA PESTAÑA 10");
            }
        } catch (SQLException ex) {
            System.out.println("ERROR EN EL MÉTODO> cargardatos_Suenio_Control_esfin");
            Logger.getLogger(ControladorFichaAnamnesis.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    //CARGAR DATOS: 1.12 SALUD 
    public void cargardatos_Salud_NNA() {

        String problem_familiare = "";//1
        if (vistaAnamnesis.getJcxSindromeDown().isSelected()) {
            problem_familiare = problem_familiare + "Díndrome de Down ";
        }
        if (vistaAnamnesis.getJcxEpilepsia().isSelected()) {
            problem_familiare = problem_familiare + "Epilepsia ";
        }
        if (vistaAnamnesis.getJcxAlcoholismo().isSelected()) {
            problem_familiare = problem_familiare + "Alcoholismo ";
        }
        if (vistaAnamnesis.getJcxDiscapacidadIntelectual().isSelected()) {
            problem_familiare = problem_familiare + "Discapacidad Intelectual ";
        }
        modelo_Salud_nnaDB.setProblem_familiare(problem_familiare);
//        String problem_familiar_descrip = vistaAnamnesis.getTxtOtroEspecifique().getText();//2
//        boolean problem_respiratorio = true;//3
        String problem_respiratorio;
        if (vistaAnamnesis.getJcxSiProblemasRespiratorios().isSelected()) {
            problem_respiratorio = "'true'";
            modelo_Salud_nnaDB.setProblem_resp_descrip(vistaAnamnesis.getTxtEspecifiqueProblemasRespiratorios().getText());
        } else if (vistaAnamnesis.getJcxNoProblemasRespiratorios().isSelected()) {
            problem_respiratorio = "'false'";
            modelo_Salud_nnaDB.setProblem_resp_descrip(null);
        } else {
            problem_respiratorio = "null";
            modelo_Salud_nnaDB.setProblem_resp_descrip(null);
        }
//        String problem_resp_descrip = vistaAnamnesis.getTxtEspecifiqueProblemasRespiratorios().getText();//4
//        boolean problem_alergias = true;//5
        String problem_alergias;
        if (vistaAnamnesis.getJcxSiAlergias().isSelected()) {
            problem_alergias = "'true'";
            modelo_Salud_nnaDB.setProblem_aler_descrip(vistaAnamnesis.getTxtEspecifiqueAlergias().getText());
        } else if (vistaAnamnesis.getJcxNoAlergias().isSelected()) {
            problem_alergias = "'false'";
            modelo_Salud_nnaDB.setProblem_aler_descrip(null);
        } else {
            problem_alergias = "null";
            modelo_Salud_nnaDB.setProblem_aler_descrip(null);
        }

//        String problem_aler_descrip = vistaAnamnesis.getTxtEspecifiqueAlergias().getText();//6
//        boolean problem_neurologico = true;//7
        String problem_neurologico;
        if (vistaAnamnesis.getJcxSiNeurologicos().isSelected()) {
            problem_neurologico = "'true'";
            modelo_Salud_nnaDB.setProblem_neuro_descrip(vistaAnamnesis.getTxtEspecifiqueNeurologicos().getText());
        } else if (vistaAnamnesis.getJcxNoNeurologicos().isSelected()) {
            problem_neurologico = "'false'";
            modelo_Salud_nnaDB.setProblem_neuro_descrip(null);
        } else {
            problem_neurologico = "null";
            modelo_Salud_nnaDB.setProblem_neuro_descrip(null);
        }
//        String problem_neuro_descrip = vistaAnamnesis.getTxtEspecifiqueNeurologicos().getText();//8
//        boolean problem_nerviosos = true;//9
        String problem_nerviosos;
        if (vistaAnamnesis.getJcxSiNerviosos().isSelected()) {
            problem_nerviosos = "'true'";
            modelo_Salud_nnaDB.setProblem_nervi_descrip(vistaAnamnesis.getTxtEspecifiqueNerviosos().getText());
        } else if (vistaAnamnesis.getJcxNoNerviosos().isSelected()) {
            problem_nerviosos = "'false'";
            modelo_Salud_nnaDB.setProblem_nervi_descrip(null);
        } else {
            problem_nerviosos = "null";
            modelo_Salud_nnaDB.setProblem_nervi_descrip(null);
        }
//        String problem_nervi_descrip = vistaAnamnesis.getTxtEspecifiqueNerviosos().getText();//10
//        modelo_Salud_nnaDB = new Salud_nnaDB(problem_familiare, problem_familiar_descrip,
//                problem_respiratorio, problem_resp_descrip, problem_alergias,
//                problem_aler_descrip, problem_neurologico, problem_neuro_descrip,
//                problem_nerviosos, problem_nervi_descrip);
        //metodo llenar salud nna
        try {
            if (modelo_Salud_nnaDB.update_salud_nna(problem_respiratorio, problem_alergias, problem_neurologico, problem_nerviosos)) {
                System.out.println("ACTUALIZADA PESTAÑA 11");
            } else {
                System.out.println("ERROR AL ACTUALIZAR LA PESTAÑA 11");
            }
        } catch (SQLException ex) {
            System.out.println("ERROR EN EL MÉTODO> cargardatos_SaludNNA");
            Logger.getLogger(ControladorFichaAnamnesis.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    //CARGAR DATOS: 1.13 RELACIÓN FAMILIAR 
    public void cargardatos_Relacion_Familiar_NNA() {
        String clima_familiar = vistaAnamnesis.getTxtClimaFamiliar().getText();//1
        String relacion_padre = vistaAnamnesis.getTxtRelacionPadre().getText();//2
        String relacion_madre = vistaAnamnesis.getTxtRelacionMadre().getText();//3
        String relacion_hermanos = vistaAnamnesis.getTxtRelacionHermanos().getText();//4
        boolean trabajo = true;//5
        if (vistaAnamnesis.getJcxSiTrabajo().isSelected()) {
            trabajo = true;
        }
        if (vistaAnamnesis.getJcxNoTrabajo().isSelected()) {
            trabajo = false;
        }
        String trabajo_decrip = vistaAnamnesis.getTxtEnqueaTrabajo().getText();//6
        boolean agresion_agresor = true;//7
        if (vistaAnamnesis.getJcxSiAgrede().isSelected()) {
            agresion_agresor = true;
        }
        if (vistaAnamnesis.getJcxNoAgrede().isSelected()) {
            agresion_agresor = false;
        }
        String agresion_frecuencia = vistaAnamnesis.getTxtFrecuenciaAgresorAgrede().getText();//8
        String objeto_utilizado = vistaAnamnesis.getTxtQueUtiliza().getText();//9
        String obligacion_familiar = vistaAnamnesis.getTxtObligacionesenlaFamilia().getText();//10
        String proyeccion_madre = vistaAnamnesis.getTxtProyeciondelaMadre().getText();//11
        String necesidad_inmediata = vistaAnamnesis.getTxtNecesidadGrupoFamiliar().getText();//12

        modelo_relacion_familiar_nnaDB = new Relacion_familiar_nnaDB(clima_familiar, relacion_padre,
                relacion_madre, relacion_hermanos, trabajo, trabajo_decrip, agresion_agresor,
                agresion_frecuencia, objeto_utilizado, obligacion_familiar, proyeccion_madre,
                necesidad_inmediata);

        //metodo llenar relacion_famniliar_nna
        try {
            if (modelo_relacion_familiar_nnaDB.update_relacion_famili_nna()) {
                System.out.println("ACTUALIZADA PESTAÑA 12");
            } else {
                System.out.println("ERROR AL ACTUALIZAR LA PESTAÑA 12");
            }
        } catch (SQLException ex) {
            System.out.println("ERROR EN EL MÉTODO> cargardatos_Relacion_Familiar_NNA");
            Logger.getLogger(ControladorFichaAnamnesis.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    //CARGAR DATOS: 1.14 OBSERVACIONES GENERALES
    public void cargardatos_Observaciones_generales() {
        formatearModelos();
        String observaciones_generales = vistaAnamnesis.getTxAObservaciones().getText();
        modeloAnamnesisDB.setObservaciones_generales(observaciones_generales);
        if (modeloAnamnesisDB.update_observaciones_generales()) {
            System.out.println("ACTUALIZADA PESTAÑA 13");
        } else {
            System.out.println("ERROR AL ACTUALIZAR LA PESTAÑA 13");
        }
    }

    //METODOS------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
    //METODO PARA CARGAR LOS JSON EN LA FICHA ANMNESIS
    public void cargarJsons() {
        try {
            //Cargamos la lista de nacionalidades en los componentes que lo usan
            validarJsons();
        } catch (ParseException ex) {
            Logger.getLogger(ControladorFichaAnamnesis.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            for (int i = 0; i < listaNacionalidades.size(); i++) {
                vistaAnamnesis.getJcb_nacionalid_id().addItem(listaNacionalidades.get(i).getValor());
                vistaAnamnesis.getJcb_nacionalidad_madre().addItem(listaNacionalidades.get(i).getValor());
                vistaAnamnesis.getJcb_nacionalidad_padre().addItem(listaNacionalidades.get(i).getValor());
            }

            //Cargamos la lista de estado civil en los componentes que lo utilizan
            for (int i = 0; i < listaEstadoCivil.size(); i++) {
                vistaAnamnesis.getCbxFamiliares_estadoCivil().addItem(listaEstadoCivil.get(i).getValor());
            }

            //Cargamos la lista de instrucciones académicas en los componentes que la usan
            for (int i = 0; i < listaInstruccionAcademica.size(); i++) {
                vistaAnamnesis.getCbxFamiliares_instruccionAcademica().addItem(listaInstruccionAcademica.get(i).getValor());
            }

            //Cargamos la lista de ocupaciones en los componentes que la usan
            for (int i = 0; i < listaOcupaciones.size(); i++) {
                vistaAnamnesis.getCbxFamiliares_ocupacion().addItem(listaOcupaciones.get(i).getValor());
            }

            //Cargamos la lista de parentesco de los componentes que la usan
            for (int i = 0; i < listaParentesco.size(); i++) {
                vistaAnamnesis.getCbxFamiliares_parentesco().addItem(listaParentesco.get(i).getValor());
            }
        } catch (Exception e) {
            System.out.println("ERROR>" + e);
        }
    }

    //METODO PARA MOSTRAR LA VENTANA PARA AÑADIR FAMILIARES
    public void mostrarVentanaAnadirFamiliares(String accion) {

        //Formateamos y seteamos la accion a la variable global
        accionBtnGuardarVFamiliares = new String();
        accionBtnGuardarVFamiliares = accion;

        if (accion.equalsIgnoreCase("Ingresar")) {
            vistaAnamnesis.getLblTituloFrmFamiliar().setText("Ingresar Familiar");
            limpiarCamposVentanaFamiliares();
            vistaAnamnesis.getFrmFamiliares().setVisible(true);

        } else if (accion.equalsIgnoreCase("Actualizar")) {
            if (vistaAnamnesis.getTabComposicionFamiliarNNA().getSelectedRow() < 0) {
                JOptionPane.showMessageDialog(null, "Para editar un familiar, primero tiene que seleccionarlo y luego dar clic en el botón editar");
            } else {
                vistaAnamnesis.getLblTituloFrmFamiliar().setText("Actualizar Familiar");
                cargarFamiliar_VentanaFamiliares();
                vistaAnamnesis.getFrmFamiliares().setVisible(true);
            }
        }
    }

    //PRECARGAMOS LOS DATOS DEL REGISTRO QUE SELECCIONAMOS PARA MODIFICAR EN LA VENTANA QUE CONTIENE EL FORMULARIO DE FAMILIARES
    public void cargarFamiliar_VentanaFamiliares() {
        int row = vistaAnamnesis.getTabComposicionFamiliarNNA().getSelectedRow();
        int column = vistaAnamnesis.getTabComposicionFamiliarNNA().getColumnCount();
        FamiliaresDB obj = new FamiliaresDB();

        idFamiliarUpdate = Integer.parseInt(String.valueOf(vistaAnamnesis.getTabComposicionFamiliarNNA().getValueAt(row, 0)));
        vistaAnamnesis.getTxtFamiliares_nombres().setText(String.valueOf(vistaAnamnesis.getTabComposicionFamiliarNNA().getValueAt(row, 1)));
        vistaAnamnesis.getTxtFamiliares_apellidos().setText(String.valueOf(vistaAnamnesis.getTabComposicionFamiliarNNA().getValueAt(row, 2)));

        //Validamos el sexo e ingresamos
        String sexoFamiliar = String.valueOf(vistaAnamnesis.getTabComposicionFamiliarNNA().getValueAt(row, 3));
        if (sexoFamiliar.equalsIgnoreCase("M")) {
            vistaAnamnesis.getCbxFamiliares_sexo().setSelectedItem("Masculino");
        } else if (sexoFamiliar.equalsIgnoreCase("F")) {
            vistaAnamnesis.getCbxFamiliares_sexo().setSelectedItem("Femenino");
        } else {
            vistaAnamnesis.getCbxFamiliares_sexo().setSelectedItem("Sin especificar");
        }
        vistaAnamnesis.getCbxFamiliares_estadoCivil().setSelectedItem(String.valueOf(vistaAnamnesis.getTabComposicionFamiliarNNA().getValueAt(row, 4)));
        vistaAnamnesis.getCbxFamiliares_parentesco().setSelectedItem(String.valueOf(vistaAnamnesis.getTabComposicionFamiliarNNA().getValueAt(row, 5)));
        vistaAnamnesis.getCbxFamiliares_ocupacion().setSelectedItem(String.valueOf(vistaAnamnesis.getTabComposicionFamiliarNNA().getValueAt(row, 6)));
        vistaAnamnesis.getTxtFamiliares_edad().setText(String.valueOf(vistaAnamnesis.getTabComposicionFamiliarNNA().getValueAt(row, 7)));

        vistaAnamnesis.getCbxFamiliares_instruccionAcademica().setSelectedItem(String.valueOf(vistaAnamnesis.getTabComposicionFamiliarNNA().getValueAt(row, 8)));
    }

    //CONTROLAR RADIO BUTTONS DE CONFIRMACIÓN.------------------------------------------------------------------------------------------------------------------------------------------------------------------------REVISAR NO SE SETEA LOS DATOS DE VICTIMA
    public void controlarBeneficiariaMadre() {
        if (vistaAnamnesis.getRbnBeneficiariaMadre_Si().isSelected()) {
            vistaAnamnesis.getTxtNombreMadre().setText(nombreMadre);
            vistaAnamnesis.getTxtApellidoMadre().setText(apellidoMadre);
            vistaAnamnesis.getTxtEdadMadre().setText(edadMadre + "");
            vistaAnamnesis.getJcb_nacionalidad_madre().setSelectedIndex(idNacionalidadMadre);
            //Inavilitamos modificaciones
            vistaAnamnesis.getTxtNombreMadre().setEnabled(false);
            vistaAnamnesis.getTxtApellidoMadre().setEnabled(false);
            vistaAnamnesis.getTxtEdadMadre().setEnabled(false);
            vistaAnamnesis.getJcb_nacionalidad_madre().setEnabled(false);
        } else if (vistaAnamnesis.getRbnBeneficiariaMadre_No().isSelected()) {
            //Habilitamos modificaciones
            vistaAnamnesis.getTxtNombreMadre().setEnabled(true);
            vistaAnamnesis.getTxtApellidoMadre().setEnabled(true);
            vistaAnamnesis.getTxtEdadMadre().setEnabled(true);
            vistaAnamnesis.getJcb_nacionalidad_madre().setEnabled(true);

        }
    }

    //METODO PARA LIMPIAR LOS CAMPOS DE LA VENTANA DE REGISTRO DE FAMILIARES
    public void limpiarCamposVentanaFamiliares() {
        vistaAnamnesis.getTxtFamiliares_nombres().setText("");
        vistaAnamnesis.getTxtFamiliares_apellidos().setText("");
        vistaAnamnesis.getTxtFamiliares_edad().setText("");
        vistaAnamnesis.getCbxFamiliares_parentesco().setSelectedIndex(0);
        vistaAnamnesis.getCbxFamiliares_ocupacion().setSelectedIndex(0);
        vistaAnamnesis.getCbxFamiliares_sexo().setSelectedIndex(0);
        vistaAnamnesis.getCbxFamiliares_estadoCivil().setSelectedIndex(0);
        vistaAnamnesis.getCbxFamiliares_instruccionAcademica().setSelectedIndex(0);
    }

    //METODO DE ACCIÓN PARA EL BOTÓN GUARDAR DE LA VENTANA PARA AÑADIR FAMILIARES
    public void accionBtnFormFamiliares() {

        if (accionBtnGuardarVFamiliares.equalsIgnoreCase("Ingresar")) {
            if (anadir_editar_FamiliarNNA()) {
                //METODO DE INSERT A LA BD
                if (modelo_x_hijos_familiaresDB.ingresar_Familiar_x_Hijo()) {
                    JOptionPane.showMessageDialog(null, "Se ingreso correctamente al familiar", "Familiares", JOptionPane.INFORMATION_MESSAGE);
                    actualizarTblComposicionFamiliar();//Actualizamos la tabla
                    vistaAnamnesis.getFrmFamiliares().setVisible(false);
                } else {
                    JOptionPane.showMessageDialog(null, "Error al ingresar, revise que los datos esten correctamente ingresados", "Familiares", JOptionPane.WARNING_MESSAGE);
                }

            } else {
                JOptionPane.showMessageDialog(null, "No se pudo ingresar, revise los datos e intente nuevamente");
            }
        } else if (accionBtnGuardarVFamiliares.equalsIgnoreCase("Actualizar")) {
            // USAMOS LA VARIABLE idFamiliarUpdate que contiene el id del registro a ser modificado
            if (anadir_editar_FamiliarNNA()) {
                if (modelo_x_hijos_familiaresDB.actualizar_Familiar_x_Hijo()) {
                    JOptionPane.showMessageDialog(null, "El familiar fue actualizado exitosamente");
                    actualizarTblComposicionFamiliar();//Actualizamos la tabla
                    vistaAnamnesis.getFrmFamiliares().setVisible(false);
                } else {
                    JOptionPane.showMessageDialog(null, "Error al actualizar al familiar, revise que los datos esten correctamente ingresados");
                }
            } else {
                JOptionPane.showMessageDialog(null, "No se pudo actualizar, revise los datos e intente nuevamente");
            }
        }
    }

    //METODO PARA ELIMINAR FAMILIAR DE LA COMPOSICIÓN FAMILIAR
    public void eliminarFamiliarNNA() {
        if (vistaAnamnesis.getTabComposicionFamiliarNNA().getSelectedRow() < 0) {
            JOptionPane.showMessageDialog(null, "Para eliminar a un familiar, primero tiene que seleccionarlo y luego dar clic en el botón >>Eliminar<<");
        } else {
            if (JOptionPane.showConfirmDialog(null,
                    "Está a punto de eliminar los datos del familiar con el id "
                    + String.valueOf(vistaAnamnesis.getTabComposicionFamiliarNNA().getValueAt(vistaAnamnesis.getTabComposicionFamiliarNNA().getSelectedRow(), 0)) + ". ¿Está seguro/a de que desea hacerlo?", "Confirmar la eliminación del familiar", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE) == JOptionPane.YES_OPTION) {
                modelo_x_hijos_familiaresDB.setPersona_codigo(Integer.parseInt(String.valueOf(vistaAnamnesis.getTabComposicionFamiliarNNA().getValueAt(vistaAnamnesis.getTabComposicionFamiliarNNA().getSelectedRow(), 0))));
                if (modelo_x_hijos_familiaresDB.eliminar_Familiar_x_Hijo()) {
                    JOptionPane.showMessageDialog(null, "El familiar fue eliminado exitosamente.");
                    actualizarTblComposicionFamiliar();
                } else {
                    JOptionPane.showMessageDialog(null, "No se pudo eliminar al familiar, porfavor vuelva a intentarlo.");
                }
            }
        }
    }

    //METODO PARA AÑADIR FAMILIARES EN LA ESTRUCTURA FAMILIAR DEL NNA
    public boolean anadir_editar_FamiliarNNA() {

        System.out.println("RESULTADO ESTADO CIVIL> " + consultarIdEstadoCivil(vistaAnamnesis.getCbxFamiliares_estadoCivil().getSelectedItem().toString()));
        System.out.println("RESULTADO INSTRUCCION ACADEMICA> " + consultarIdInstruccionAcademica(vistaAnamnesis.getCbxFamiliares_instruccionAcademica().getSelectedItem().toString()));
        //Validamos
        if ("".equals(vistaAnamnesis.getTxtFamiliares_nombres().getText())
                || "".equals(vistaAnamnesis.getTxtFamiliares_nombres().getText())
                || "".equals(vistaAnamnesis.getTxtFamiliares_edad().getText())
                || vistaAnamnesis.getCbxFamiliares_parentesco().getSelectedIndex() == 0
                || vistaAnamnesis.getCbxFamiliares_ocupacion().getSelectedIndex() == 0
                || vistaAnamnesis.getCbxFamiliares_sexo().getSelectedIndex() == 0
                || vistaAnamnesis.getCbxFamiliares_estadoCivil().getSelectedIndex() == 0
                || vistaAnamnesis.getCbxFamiliares_instruccionAcademica().getSelectedIndex() == 0) {
            //Si el condicional se cumple significa que hay campos del formulario sin completar, por lo que le damos aviso al usuario 
            return false;
        } else {
            //Seteamos el modelo
            formatearModelos();
            modelo_x_hijos_familiaresDB.setPersona_codigo(idFamiliarUpdate);
            modelo_x_hijos_familiaresDB.setPersona_nombre(vistaAnamnesis.getTxtFamiliares_nombres().getText());
            modelo_x_hijos_familiaresDB.setPersona_apellido(vistaAnamnesis.getTxtFamiliares_apellidos().getText());
            modelo_x_hijos_familiaresDB.setPersona_ocupacion(Integer.parseInt(consultarIdOcupacion(vistaAnamnesis.getCbxFamiliares_ocupacion().getSelectedItem().toString())));//CONSULTA EL ID EN EL JSON
            modelo_x_hijos_familiaresDB.setParentescoFam(vistaAnamnesis.getCbxFamiliares_parentesco().getSelectedItem().toString());
            modelo_x_hijos_familiaresDB.setEdadFam(Integer.parseInt(vistaAnamnesis.getTxtFamiliares_edad().getText()));
            if (null != vistaAnamnesis.getCbxFamiliares_sexo().getSelectedItem().toString()) {
                switch (vistaAnamnesis.getCbxFamiliares_sexo().getSelectedItem().toString()) {
                    case "Masculino":
                        modelo_x_hijos_familiaresDB.setPersona_sexo('M');
                        break;
                    case "Femenino":
                        modelo_x_hijos_familiaresDB.setPersona_sexo('F');
                        break;
                    case "Sin especificar":
                        modelo_x_hijos_familiaresDB.setPersona_sexo('S');
                        break;
                    default:
                        break;
                }
            }

            //Consultamos el id del estado civil seleccionado y lo guardamos en una variable para luego validarla
            String idEstadoCivil = consultarIdEstadoCivil(vistaAnamnesis.getCbxFamiliares_estadoCivil().getSelectedItem().toString());

            if (idEstadoCivil != null) {
                modelo_x_hijos_familiaresDB.setPersona_estadocivil(Integer.parseInt(idEstadoCivil));//CONSULTA EL ID EN EL JSON -REALIZADO 
            } else {
                System.out.println("EL ESTADO CIVIL INGRESADO ES INCORRECO");
                return false;
            }

            //Consultamos el id de la instrucción académica seleccionada y lo guardamos en una variable para luego validarla
            String idInstruccionAcad = consultarIdInstruccionAcademica(vistaAnamnesis.getCbxFamiliares_instruccionAcademica().getSelectedItem().toString());
            if (idInstruccionAcad != null) {
                modelo_x_hijos_familiaresDB.setPersona_nivel_acad(Integer.parseInt(idInstruccionAcad));//CONSULTA EL ID EN EL JSON -REALIZADO
            } else {
                System.out.println("LA INSTRUCCION ACADEMICA INGRESADA ES INCORRECTA");
                return false;
            }
            return true;//Retornará true si todo se cumplió correctamente
        }
    }

    //CONSULTA A LA BD PARA ACTUALIZAR LA TABLA
    public void actualizarTblComposicionFamiliar() {
        List<x_hijos_familiares> listaFamiliares = modelo_x_hijos_familiaresDB.listar_Familiares_x_Hijo();
        DefaultTableModel modeloTablaFamiliares = (DefaultTableModel) vistaAnamnesis.getTabComposicionFamiliarNNA().getModel();
        int columnas = modeloTablaFamiliares.getColumnCount();
        modeloTablaFamiliares.setRowCount(0);

        if (listaFamiliares.isEmpty()) {
            JOptionPane.showMessageDialog(null, "No existen familiares actualmente");
        } else {
            for (int i = 0; i < listaFamiliares.size(); i++) {
                modeloTablaFamiliares.addRow(new Object[columnas]);
                modeloTablaFamiliares.setValueAt(listaFamiliares.get(i).getPersona_codigo(), i, 0);
                modeloTablaFamiliares.setValueAt(listaFamiliares.get(i).getPersona_nombre(), i, 1);
                modeloTablaFamiliares.setValueAt(listaFamiliares.get(i).getPersona_apellido(), i, 2);
                modeloTablaFamiliares.setValueAt(listaFamiliares.get(i).getPersona_sexo(), i, 3);

                String idEstadoCivil = listaFamiliares.get(i).getPersona_estadocivil() + "";
                if (!idEstadoCivil.equalsIgnoreCase("")) {
                    modeloTablaFamiliares.setValueAt(consultarValorJson(Integer.parseInt(idEstadoCivil), listaEstadoCivil), i, 4);
                }
                modeloTablaFamiliares.setValueAt(listaFamiliares.get(i).getParentescoFam(), i, 5);
                String idOcupacion = listaFamiliares.get(i).getPersona_ocupacion() + "";
                if (!idOcupacion.equalsIgnoreCase("")) {
                    modeloTablaFamiliares.setValueAt(consultarValorJson(Integer.parseInt(idOcupacion), listaOcupaciones), i, 6);
                }
                modeloTablaFamiliares.setValueAt(listaFamiliares.get(i).getEdadFam(), i, 7);
                String idlvlAcademico = listaFamiliares.get(i).getPersona_nivel_acad() + "";
                if (!idlvlAcademico.equalsIgnoreCase("")) {
                    modeloTablaFamiliares.setValueAt(consultarValorJson(Integer.parseInt(idlvlAcademico), listaInstruccionAcademica), i, 8);
                }
            }
            vistaAnamnesis.getTabComposicionFamiliarNNA().setModel(modeloTablaFamiliares);
        }
    }

    public void confirmarSalida() {
        if (JOptionPane.showConfirmDialog(null,
                "¿Está seguro de que desea salir, sin guardar los datos? ",
                "Confirmar cierre de ventana", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE) == JOptionPane.YES_OPTION) {
            modeloAnamnesisDB.actualizarFechaMod();
            limpiarFichaAnamnesis();
            vistaAnamnesis.dispose();
        }
    }

    public void calcularAnioNNA() {
        Calendar fechaActual = Calendar.getInstance();
        int years = fechaActual.get(Calendar.YEAR) - vistaAnamnesis.getJdcFechaNacimientoNNA().getCalendar().get(Calendar.YEAR);
        System.out.println("Año tiene NNA: " + years);
        vistaAnamnesis.getTxtEdadNNA().setText(years + "");
    }

    public void propertyChange(PropertyChangeEvent evt) {
        try {
            if (vistaAnamnesis.getJdcFechaNacimientoNNA().getDate() != null) {
                calcularAnioNNA();
                estadoEncabezado = false;
            }
        } catch (Exception e) {
            System.out.println("error en propertyChange " + e.getMessage());
        }
    }

    //MÉTODO PARA LIMPIAR LA VISTA ANAMNESIS-------------------------------------------------------------------------------------------
    public void limpiarFichaAnamnesis() {
        //1. Datos de identificación
        vistaAnamnesis.getJdcFechaNacimientoNNA().setDate(null);
        vistaAnamnesis.getTxtLugarNacNNA1().setText(null);
        vistaAnamnesis.getJcb_nacionalid_id().setSelectedIndex(0);
        vistaAnamnesis.getCbxPoseeCedula().setSelectedIndex(0);
        vistaAnamnesis.getTxtEdadNNA().setText(null);

        //2. Datos de la madre y padre
        vistaAnamnesis.getRbnBeneficiariaMadre_Si().setSelected(false);
        vistaAnamnesis.getRbnBeneficiariaMadre_No().setSelected(false);

        vistaAnamnesis.getTxtNombreMadre().setText(null);
        vistaAnamnesis.getTxtApellidoMadre().setText(null);
        vistaAnamnesis.getTxtEdadMadre().setText(null);
        vistaAnamnesis.getJcb_nacionalidad_madre().setSelectedIndex(0);
        vistaAnamnesis.getTxtNombrePadre().setText(null);
        vistaAnamnesis.getTxtApellidoPadre().setText(null);
        vistaAnamnesis.getTxtEdadPadre().setText(null);
        vistaAnamnesis.getJcb_nacionalidad_padre().setSelectedIndex(0);
        vistaAnamnesis.getCbxPadreAgresor().setSelectedIndex(0);
        vistaAnamnesis.getTxaSituacionIngresaNNA().setText(null);

        //3. Composición familiar NNA
        vistaAnamnesis.getTabComposicionFamiliarNNA().removeAll();

        //4. Periódo de embarazo
        vistaAnamnesis.getCbxEmbarazoPlanificado().setSelectedIndex(0);
        vistaAnamnesis.getTxtReaccionPapa().setText(null);
        vistaAnamnesis.getTxtReaccionMama().setText(null);

        vistaAnamnesis.getJcxSiViolencia().setSelected(false);
        vistaAnamnesis.getJcxNoViolencia().setSelected(false);
        vistaAnamnesis.getJcxGolpes().setSelected(false);
        vistaAnamnesis.getJcxAbusoSexual().setSelected(false);
        vistaAnamnesis.getJcxInsultos().setSelected(false);
        vistaAnamnesis.getJcxNegligencia().setSelected(false);
        vistaAnamnesis.getJcxAmbitoLaboral().setSelected(false);

        vistaAnamnesis.getJcxSiControles().setSelected(false);
        vistaAnamnesis.getJcxNoControles().setSelected(false);
        vistaAnamnesis.getJcxUnaVez().setSelected(false);
        vistaAnamnesis.getJcxMensual().setSelected(false);
        vistaAnamnesis.getJcxTrimestral().setSelected(false);
        vistaAnamnesis.getJcxNinguna().setSelected(false);

        vistaAnamnesis.getTxtDondeRealizoControles().setText(null);

        vistaAnamnesis.getJcxSiComplicaciones().setSelected(false);
        vistaAnamnesis.getJcxNoComplicaciones().setSelected(false);
        vistaAnamnesis.getJcxBajoPeso().setSelected(false);
        vistaAnamnesis.getJcxHemorragias().setSelected(false);
        vistaAnamnesis.getJcxInfecciones().setSelected(false);
        vistaAnamnesis.getJcxPreclansia().setSelected(false);

        vistaAnamnesis.getTxtOtraComplicacionEmbarazo().setText(null);

        vistaAnamnesis.getJcxSiConsume().setSelected(false);
        vistaAnamnesis.getJcxNoConsume().setSelected(false);
        vistaAnamnesis.getJcxTabaco().setSelected(false);
        vistaAnamnesis.getJcxAlcohol().setSelected(false);
        vistaAnamnesis.getJcxDroga().setSelected(false);

        vistaAnamnesis.getTxtCausasConsumo().setText(null);

        vistaAnamnesis.getJcxSiAborto().setSelected(false);
        vistaAnamnesis.getJcxNoAborto().setSelected(false);
        vistaAnamnesis.getTxtCausasAborto().setText(null);

        //5. Condiciones de nacimiento
        vistaAnamnesis.getJcb_mes_alumbramiento().setSelectedIndex(0);
        vistaAnamnesis.getTxtLugarParto().setText(null);

        vistaAnamnesis.getJcxNormal().setSelected(false);
        vistaAnamnesis.getJcxCesarea().setSelected(false);
        vistaAnamnesis.getTxtMotivoCesarea().setText(null);

        vistaAnamnesis.getJcxSiAnestesia().setSelected(false);
        vistaAnamnesis.getJcxNoAnestesia().setSelected(false);
        vistaAnamnesis.getTxtComplicaciones_despues_parto().setText(null);

        vistaAnamnesis.getJcxSiLloro().setSelected(false);
        vistaAnamnesis.getJcxNoLloro().setSelected(false);
        vistaAnamnesis.getJcxSiOxigeno().setSelected(false);
        vistaAnamnesis.getJcxNoOxigeno().setSelected(false);
        vistaAnamnesis.getJcxDepresion().setSelected(false);
        vistaAnamnesis.getJcxHipersencibilidad().setSelected(false);
        vistaAnamnesis.getJcxSiSexo().setSelected(false);
        vistaAnamnesis.getJcxNoSexo().setSelected(false);

        vistaAnamnesis.getTxtTalla().setText(null);
        vistaAnamnesis.getTxtPeso().setText(null);
        vistaAnamnesis.getTxtReaccionMadre().setText(null);
        vistaAnamnesis.getTxtReaccionPadre().setText(null);

        //6. Primeros dias de vida
        vistaAnamnesis.getJcxSiLeche().setSelected(false);
        vistaAnamnesis.getJcxNoLeche().setSelected(false);
        vistaAnamnesis.getTxtPorqueLeche().setText(null);
        vistaAnamnesis.getTxtEdadDioLeche().setText(null);

        vistaAnamnesis.getJcxSiBiberon().setSelected(false);
        vistaAnamnesis.getJcxNoBiberon().setSelected(false);
        vistaAnamnesis.getTxtDesdeEdadBiberon().setText(null);
        vistaAnamnesis.getTxtHastaEdadBiberon().setText(null);
        vistaAnamnesis.getJcxSiSuccionar().setSelected(false);
        vistaAnamnesis.getJcxNoSuccionar().setSelected(false);

        vistaAnamnesis.getTxtComoFueDestete().setText(null);
        vistaAnamnesis.getTxtEdadSento().setText(null);
        vistaAnamnesis.getTxtEdadCamino().setText(null);
        vistaAnamnesis.getTxtEdadPrimerasPalabras().setText(null);

        //7. Alimentación actual
        vistaAnamnesis.getTxtInicioSolidos().setText(null);
        vistaAnamnesis.getJtxtdificultadesAlimentacion().setText(null);
        vistaAnamnesis.getTxtVecesComeDia().setText(null);
        vistaAnamnesis.getTxtComeSolooAcompanhado().setText(null);
        vistaAnamnesis.getTxtActitudMadre().setText(null);

        //8. Desarrollo motor y del lenguaje actual
        vistaAnamnesis.getJcxNormalMotorGrueso().setSelected(false);
        vistaAnamnesis.getJcxIrregularMotorGrueso().setSelected(false);
        vistaAnamnesis.getJcxNormalMotorFino().setSelected(false);
        vistaAnamnesis.getJcxIrregularMotorFino().setSelected(false);
        vistaAnamnesis.getJcxClaro().setSelected(false);
        vistaAnamnesis.getJcxNoMuyClaro().setSelected(false);
        vistaAnamnesis.getJcxNoSeEntiende().setSelected(false);

        vistaAnamnesis.getTxtDificultadEspecifique().setText(null);
        vistaAnamnesis.getTxtComoSonMovimientos().setText(null);
        vistaAnamnesis.getTxtPsicoSocial().setText(null);
        vistaAnamnesis.getTxtCognitivo().setText(null);
        vistaAnamnesis.getTxtfisico().setText(null);

        //9. Sueño y control de esfinteres
        vistaAnamnesis.getJcxSiDuerme().setSelected(false);
        vistaAnamnesis.getJcxNoDuerme().setSelected(false);
        vistaAnamnesis.getJcxSiMiedoDormir().setSelected(false);
        vistaAnamnesis.getJcxNoMiedoDormir().setSelected(false);
        vistaAnamnesis.getJcxSiPesadillas().setSelected(false);
        vistaAnamnesis.getJcxNoPesadillas().setSelected(false);
        vistaAnamnesis.getJcxSiAyudaBanho().setSelected(false);
        vistaAnamnesis.getJcxNoAyudaBanho().setSelected(false);
        vistaAnamnesis.getJcxSiMojaCama().setSelected(false);
        vistaAnamnesis.getJcxNoMojaCama().setSelected(false);
        vistaAnamnesis.getJcxSiEcopresis().setSelected(false);
        vistaAnamnesis.getJcxNoEcopresis().setSelected(false);

        vistaAnamnesis.getTxtComoDuerme().setText(null);
        vistaAnamnesis.getTxtComoDespierta().setText(null);
        vistaAnamnesis.getTxtConQuienDuerme().setText(null);
        vistaAnamnesis.getTxtEdadEsfinteres().setText(null);
        vistaAnamnesis.getTxtCausaEcopresis().setText(null);

        //10. Escolarización NNA
        vistaAnamnesis.getJcxSiEstudia().setSelected(false);
        vistaAnamnesis.getJcxNoEstudia().setSelected(false);
        vistaAnamnesis.getTxtExpliqueEstudia().setText(null);
        vistaAnamnesis.getTxtNombreInstitucion().setText(null);
        vistaAnamnesis.getTxtAnhoCursa().setText(null);
        vistaAnamnesis.getTxtAnhoRepite().setText(null);

        vistaAnamnesis.getJcxSiAprendizaje().setSelected(false);
        vistaAnamnesis.getJcxNoAprendizaje().setSelected(false);
        vistaAnamnesis.getJcxSiNivelacion().setSelected(false);
        vistaAnamnesis.getJcxNoNivelacion().setSelected(false);
        vistaAnamnesis.getTxtEspecifiqueAprendizaje().setText(null);
        vistaAnamnesis.getTxtEspecifiqueNivelacion().setText(null);

        //11. Salud
        vistaAnamnesis.getJcxSindromeDown().setSelected(false);
        vistaAnamnesis.getJcxEpilepsia().setSelected(false);
        vistaAnamnesis.getJcxAlcoholismo().setSelected(false);
        vistaAnamnesis.getJcxDiscapacidadIntelectual().setSelected(false);
        vistaAnamnesis.getTxtOtroEspecifique().setText(null);

        vistaAnamnesis.getJcxSiProblemasRespiratorios().setSelected(false);
        vistaAnamnesis.getJcxNoProblemasRespiratorios().setSelected(false);
        vistaAnamnesis.getTxtEspecifiqueProblemasRespiratorios().setText(null);

        vistaAnamnesis.getJcxSiAlergias().setSelected(false);
        vistaAnamnesis.getJcxNoAlergias().setSelected(false);
        vistaAnamnesis.getTxtEspecifiqueAlergias().setText(null);

        vistaAnamnesis.getJcxSiNeurologicos().setSelected(false);
        vistaAnamnesis.getJcxNoNeurologicos().setSelected(false);
        vistaAnamnesis.getTxtEspecifiqueNeurologicos().setText(null);

        vistaAnamnesis.getJcxSiNerviosos().setSelected(false);
        vistaAnamnesis.getJcxNoNerviosos().setSelected(false);
        vistaAnamnesis.getTxtEspecifiqueNerviosos().setText(null);

        //12. Relación familiar 
        vistaAnamnesis.getTxtClimaFamiliar().setText(null);
        vistaAnamnesis.getTxtRelacionPadre().setText(null);
        vistaAnamnesis.getTxtRelacionMadre().setText(null);
        vistaAnamnesis.getTxtRelacionHermanos().setText(null);

        vistaAnamnesis.getJcxSiTrabajo().setSelected(false);
        vistaAnamnesis.getJcxNoTrabajo().setSelected(false);
        vistaAnamnesis.getTxtEnqueaTrabajo().setText(null);

        vistaAnamnesis.getJcxSiAgrede().setSelected(false);
        vistaAnamnesis.getJcxNoAgrede().setSelected(false);
        vistaAnamnesis.getTxtFrecuenciaAgresorAgrede().setText(null);
        vistaAnamnesis.getTxtQueUtiliza().setText(null);
        vistaAnamnesis.getTxtObligacionesenlaFamilia().setText(null);
        vistaAnamnesis.getTxtProyeciondelaMadre().setText(null);
        vistaAnamnesis.getTxtNecesidadGrupoFamiliar().setText(null);

        //13. Observaciones generales
        vistaAnamnesis.getTxAObservaciones().setText(null);
    }

    //METODOS DE VALIDACIONES SEPARADOS POR SECCIONES--------------------------------------------------------------------------------------------------------------------------------------
    //METODO PARA MOSTRAR EL PANEL DE MENSAJES SEGUN LA VALIDACION
    public void mostrarMensajeEstadoPestana(JLabel lblestado, JLabel pestana, boolean estado) {

        if (estado) {
            lblestado.setText("[COMPLETADO]");
            lblestado.setForeground(Color.GREEN);
        } else {
            lblestado.setText("[INCOMPLETO]");
            lblestado.setForeground(Color.RED);
        }

        lblestado.setVisible(true);
        pestana.setVisible(true);
    }

    //VALIDAR ENCABEZADO
    public boolean validarEncabezadoFichaAnamnesis() {
        return !(vistaAnamnesis.getTxtNombre().getText().isEmpty()
                || vistaAnamnesis.getTxtApellido().getText().isEmpty()
                || vistaAnamnesis.getTxtCedula().getText().isEmpty()
                || vistaAnamnesis.getTxtCodigo().getText().isEmpty()
                || vistaAnamnesis.getJdcFechaElaboracion().getDate() == null);
    }

    //VALIDACIÓN SECCIÓN: 1.1 DATOS DE IDENTIFICACIÓN - FICHA ANAMNESIS
    public boolean validardatosIdentificacion() {
        return !(vistaAnamnesis.getJdcFechaNacimientoNNA().getDate() == null
                || vistaAnamnesis.getTxtLugarNacNNA1().getText().isEmpty()
                || vistaAnamnesis.getJcb_nacionalid_id().getSelectedIndex() == 0
                || vistaAnamnesis.getTxtEdadNNA().getText().isEmpty()
                || vistaAnamnesis.getCbxPoseeCedula().getSelectedIndex() == 0
                || vistaAnamnesis.getTxtEdadNNA().getText() == "0");
    }

    //VALIDACIÓN SECCIÓN: 1.2 DATOS DE LA MADRE Y EL PADRE - FICHA ANAMNESIS Y VALIDACIÓN SECCIÓN: 1.3 SITUACIÓN EN LA QUE INGRESA EL NNA - FICHA ANAMNESIS 
    public boolean validardatosPadreMadre() { //Pendiente de cambios------------------------------------------------------------IMPORTANTE
        if (vistaAnamnesis.getBtnGrp_BeneficiariaMadre().getSelection() == null) {
            vistaAnamnesis.getRbnBeneficiariaMadre_Si().setSelected(true);
        }

        if (vistaAnamnesis.getTxtNombreMadre().getText().isEmpty()
                || vistaAnamnesis.getTxtApellidoMadre().getText().isEmpty()
                || vistaAnamnesis.getTxtEdadMadre().getText().isEmpty()
                || vistaAnamnesis.getTxtEdadMadre().getText().equalsIgnoreCase("0")
                || vistaAnamnesis.getJcb_nacionalidad_madre().getSelectedIndex() == 0
                || vistaAnamnesis.getTxtNombrePadre().getText().isEmpty()
                || vistaAnamnesis.getTxtApellidoPadre().getText().isEmpty()
                || vistaAnamnesis.getTxtEdadPadre().getText().isEmpty()
                || vistaAnamnesis.getTxtEdadPadre().getText().equalsIgnoreCase("0")
                || vistaAnamnesis.getJcb_nacionalidad_padre().getSelectedIndex() == 0
                || vistaAnamnesis.getCbxPadreAgresor().getSelectedIndex() == 0
                || vistaAnamnesis.getTxaSituacionIngresaNNA().getText().isEmpty()) {
            return false;
        } else {
            return true;
        }
    }

    //VALIDACIÓN SECCIÓN: 1.4 COMPOSICIÓN FAMILIAR DEL NNA - FICHA ANAMNESIS
    public boolean validardatosComposicionFamiliarNNA() {
        if (vistaAnamnesis.getTabComposicionFamiliarNNA().getRowCount() != 0) {
            return true;
        } else {
            return false;
        }
    }
    //validaciones

    //VALIDACIÓN SECCIÓN: 1.5 PERIODO DE EMBARAZO - FICHA ANAMNESIS
    public boolean validardatosPeriodoEmbarazo() {

        if (vistaAnamnesis.getCbxEmbarazoPlanificado().getSelectedIndex() == 0
                || vistaAnamnesis.getTxtReaccionPapa().getText().isEmpty()
                || vistaAnamnesis.getTxtReaccionMama().getText().isEmpty()
                || vistaAnamnesis.getBtnGrp_violenciaEmbarazo().getSelection() == null
                || vistaAnamnesis.getBtnGrp_controlesMedicos().getSelection() == null
                || vistaAnamnesis.getBtnGrp_complicacionesEmbarazo().getSelection() == null
                || vistaAnamnesis.getBtnGrp_consumoDuranteEmbarazo().getSelection() == null
                || vistaAnamnesis.getBtnGrp_tentativasAborto().getSelection() == null) {
            return false;
        } else if (vistaAnamnesis.getJcxSiViolencia().isSelected()
                && !vistaAnamnesis.getJcxGolpes().isSelected()
                && !vistaAnamnesis.getJcxAbusoSexual().isSelected()
                && !vistaAnamnesis.getJcxInsultos().isSelected()
                && !vistaAnamnesis.getJcxNegligencia().isSelected()
                && !vistaAnamnesis.getJcxAmbitoLaboral().isSelected()) {
            return false;
        } else if (vistaAnamnesis.getJcxSiControles().isSelected()
                && !vistaAnamnesis.getJcxUnaVez().isSelected()
                && !vistaAnamnesis.getJcxMensual().isSelected()
                && !vistaAnamnesis.getJcxTrimestral().isSelected()
                && !vistaAnamnesis.getJcxNinguna().isSelected()) {
            return false;
        } else if (vistaAnamnesis.getJcxSiControles().isSelected()
                && vistaAnamnesis.getTxtDondeRealizoControles().getText().isEmpty()) {
            return false;
        } else if (vistaAnamnesis.getJcxSiComplicaciones().isSelected()
                && !vistaAnamnesis.getJcxBajoPeso().isSelected()
                && !vistaAnamnesis.getJcxHemorragias().isSelected()
                && !vistaAnamnesis.getJcxInfecciones().isSelected()
                && !vistaAnamnesis.getJcxPreclansia().isSelected()) {
            return false;
        } else if (vistaAnamnesis.getJcxSiConsume().isSelected()
                && !vistaAnamnesis.getJcxTabaco().isSelected()
                && !vistaAnamnesis.getJcxAlcohol().isSelected()
                && !vistaAnamnesis.getJcxDroga().isSelected()) {
            return false;
        } else if (vistaAnamnesis.getJcxSiConsume().isSelected()
                && vistaAnamnesis.getTxtCausasConsumo().getText().isEmpty()) {
            return false;
        } else if (vistaAnamnesis.getJcxSiAborto().isSelected()
                && vistaAnamnesis.getTxtCausasAborto().getText().isEmpty()) {
            return false;
        } else {
            return true;
        }
    }

//VALIDACIÓN SECCIÓN: 1.6 CONDICIONES DE NACIMIENTO - FICHA ANAMNESIS
    public boolean validardatosCondicionesNacimiento() {
        if (vistaAnamnesis.getJcb_mes_alumbramiento().getSelectedIndex() == 0
                || vistaAnamnesis.getTxtLugarParto().getText().isEmpty()
                || vistaAnamnesis.getBtnGrp_PartoTipo().getSelection() == null
                || vistaAnamnesis.getBtnGrp_anestesia().getSelection() == null
                || vistaAnamnesis.getTxtComplicaciones_despues_parto().getText().isEmpty()
                || vistaAnamnesis.getBtnGrp_lloroNac().getSelection() == null
                || vistaAnamnesis.getBtnGrp_NecesitoO().getSelection() == null
                || vistaAnamnesis.getTxtTalla().getText().isEmpty()
                || vistaAnamnesis.getTxtPeso().getText().isEmpty()
                || vistaAnamnesis.getBtnGrp_SintomaAfterParto().getSelection() == null
                || vistaAnamnesis.getBtnGrp_sexoEsperado().getSelection() == null
                || vistaAnamnesis.getTxtReaccionMadre().getText().isEmpty()
                || vistaAnamnesis.getTxtReaccionPadre().getText().isEmpty()) {
            return false;
        } else if (vistaAnamnesis.getJcxCesarea().isSelected() && vistaAnamnesis.getTxtMotivoCesarea().getText().isEmpty()) {
            return false;
        } else {
            return true;
        }
    }

    //VALIDACIÓN SECCIÓN: 1.7 PRIMEROS DÍAS DE VIDA - FICHA ANAMNESIS
    public boolean validardatosPrimerosDiasVida() {
        if (vistaAnamnesis.getBtnGrp_lecheMaterna().getSelection() == null
                || vistaAnamnesis.getTxtEdadDioLeche().getText().isEmpty()
                || vistaAnamnesis.getBtnGrp_usoBiberon().getSelection() == null
                || vistaAnamnesis.getBtnGrp_dificultadesSuccion().getSelection() == null
                || vistaAnamnesis.getTxtComoFueDestete().getText().isEmpty()
                || vistaAnamnesis.getTxtEdadSento().getText().isEmpty()
                || vistaAnamnesis.getTxtEdadCamino().getText().isEmpty()
                || vistaAnamnesis.getTxtEdadPrimerasPalabras().getText().isEmpty()
                || vistaAnamnesis.getTxtEdadSento().getText().equalsIgnoreCase("0")
                || vistaAnamnesis.getTxtEdadCamino().getText().equalsIgnoreCase("0")
                || vistaAnamnesis.getTxtEdadPrimerasPalabras().getText().equalsIgnoreCase("0")
                || vistaAnamnesis.getTxtEdadDioLeche().getText().equalsIgnoreCase("0")
                || vistaAnamnesis.getTxtDesdeEdadBiberon().getText().equalsIgnoreCase("0")
                || vistaAnamnesis.getTxtHastaEdadBiberon().getText().equalsIgnoreCase("0")) {
            return false;
        } else if (vistaAnamnesis.getJcxSiLeche().isSelected()
                && vistaAnamnesis.getTxtPorqueLeche().getText().isEmpty()) {
            return false;
        } else {
            return true;
        }
    }

    //VALIDACIÓN SECCIÓN: 1.8 ALIMENTACIÓN ACTUAL - FICHA ANAMNESIS
    public boolean validardatosAlimentacionActual() {
        if (vistaAnamnesis.getTxtInicioSolidos().getText().isEmpty()
                || vistaAnamnesis.getTxtVecesComeDia().getText().isEmpty()
                || vistaAnamnesis.getTxtComeSolooAcompanhado().getText().isEmpty()
                || vistaAnamnesis.getTxtActitudMadre().getText().isEmpty()) {
            return false;
        } else { // codigo

            return true;
        }
    }

    //VALIDACIÓN SECCIÓN: 1.9 DESARROLLO MOTOR Y LENGUAJE ACTUAL - FICHA ANAMNESIS
    public boolean validardatosDesarrolloMotoLenguajeActual() {
        if (vistaAnamnesis.getBtnGrp_DmotorGrueso().getSelection() == null
                || vistaAnamnesis.getBtnGrp_DmotoFino().getSelection() == null
                || vistaAnamnesis.getBtnGrp_lenguajeActual().getSelection() == null
                || vistaAnamnesis.getTxtDificultadEspecifique().getText().isEmpty()
                || vistaAnamnesis.getTxtComoSonMovimientos().getText().isEmpty()
                || vistaAnamnesis.getTxtPsicoSocial().getText().isEmpty()
                || vistaAnamnesis.getTxtCognitivo().getText().isEmpty()
                || vistaAnamnesis.getTxtfisico().getText().isEmpty()) {
            return false;
        } else {
            return true;
        }
    }

    //VALIDACIÓN SECCIÓN: 1.10 SUEÑO Y CONTROL DE ESFÍNTERES - FICHA ANAMNESIS
    public boolean validardatosSuenoControlEsfinter() {
        if (vistaAnamnesis.getBtnGrp_duermeTodaNoche().getSelection() == null
                || vistaAnamnesis.getBtnGrp_miedoDormir().getSelection() == null
                || vistaAnamnesis.getBtnGrp_Pesadillas().getSelection() == null
                || vistaAnamnesis.getBtnGrp_ayudaIrBano().getSelection() == null
                || vistaAnamnesis.getBtnGrp_mojaCama().getSelection() == null
                || vistaAnamnesis.getBtnGrp_periodoEcopresi().getSelection() == null
                || vistaAnamnesis.getTxtComoDuerme().getText().isEmpty()
                || vistaAnamnesis.getTxtComoDespierta().getText().isEmpty()
                || vistaAnamnesis.getTxtConQuienDuerme().getText().isEmpty()
                || vistaAnamnesis.getTxtEdadEsfinteres().getText().isEmpty()) {
            return false;
        } else if (vistaAnamnesis.getJcxSiEcopresis().isSelected()) {
            if (vistaAnamnesis.getTxtCausaEcopresis().getText().isEmpty()) {
                return false;
            } else {
                return true;
            }
        } else {
            return true;
        }
    }

    //VALIDACIÓN SECCIÓN: 1.11 ESCOLARIZACIÓN NNA - FICHA ANAMNESIS
    public boolean validardatosEscolarizacionNNA() {

        if (vistaAnamnesis.getBtnGrp_nnaEstudia().getSelection() == null
                || vistaAnamnesis.getTxtNombreInstitucion().getText().isEmpty()
                || vistaAnamnesis.getTxtAnhoCursa().getText().isEmpty()
                || vistaAnamnesis.getTxtAnhoRepite().getText().isEmpty()
                || vistaAnamnesis.getBtnGrp_problemasAprendizaje().getSelection() == null
                || vistaAnamnesis.getBtnGrp_apoyoNivelacion().getSelection() == null) {
            return false;
        }
        if (vistaAnamnesis.getJcxSiAprendizaje().isSelected() && vistaAnamnesis.getTxtEspecifiqueAprendizaje().getText().isEmpty()) {
            return false;
        }
        if (vistaAnamnesis.getJcxSiNivelacion().isSelected() && vistaAnamnesis.getTxtEspecifiqueNivelacion().getText().isEmpty()) {
            return false;
        }
        return true;
    }
//cambios
//VALIDACIÓN SECCIÓN: 1.12 SALUD - FICHA ANAMNESIS

    public boolean validardatosSalud() {
        if (vistaAnamnesis.getTxtClimaFamiliar().getText().isEmpty()
                || vistaAnamnesis.getTxtRelacionMadre().getText().isEmpty()
                || vistaAnamnesis.getTxtRelacionMadre().getText().isEmpty()
                || vistaAnamnesis.getTxtRelacionHermanos().getText().isEmpty()
                || vistaAnamnesis.getTxtEnqueaTrabajo().getText().isEmpty()
                || vistaAnamnesis.getTxtFrecuenciaAgresorAgrede().getText().isEmpty()
                || vistaAnamnesis.getTxtQueUtiliza().getText().isEmpty()
                || vistaAnamnesis.getTxtObligacionesenlaFamilia().getText().isEmpty()
                || vistaAnamnesis.getTxtObligacionesenlaFamilia().getText().isEmpty()
                || vistaAnamnesis.getTxtProyeciondelaMadre().getText().isEmpty()
                | vistaAnamnesis.getTxtNecesidadGrupoFamiliar().getText().isEmpty()) {
            return false;
        }
        if (vistaAnamnesis.getJcxSiTrabajo().isSelected() == false
                && vistaAnamnesis.getJcxNoTrabajo().isSelected() == false
                && vistaAnamnesis.getJcxSiAgrede().isSelected() == false
                && vistaAnamnesis.getJcxNoAgrede().isSelected() == false) {
            return false;
        } else {
            return true;
        }
    }

    //VALIDACIÓN SECCIÓN: 1.13 RELACIÓN FAMILIAR - FICHA ANAMNESIS
    public boolean validardatosRelacionFamiliar() {
        if (vistaAnamnesis.getTxtClimaFamiliar().getText().isEmpty()
                || vistaAnamnesis.getTxtRelacionPadre().getText().isEmpty()
                || vistaAnamnesis.getTxtRelacionMadre().getText().isEmpty()
                || vistaAnamnesis.getTxtRelacionHermanos().getText().isEmpty()
                || vistaAnamnesis.getBtnGrp_trabajoAlgunaVez().getSelection() == null
                || vistaAnamnesis.getBtnGrp_agresorAgredeNNA().getSelection() == null
                || vistaAnamnesis.getTxtObligacionesenlaFamilia().getText().isEmpty()
                || vistaAnamnesis.getTxtProyeciondelaMadre().getText().isEmpty()
                || vistaAnamnesis.getTxtNecesidadGrupoFamiliar().getText().isEmpty()) {
            return false;
        }
        if (vistaAnamnesis.getJcxSiTrabajo().isSelected() && vistaAnamnesis.getTxtEnqueaTrabajo().getText().isEmpty()) {
            return false;
        }
        if (vistaAnamnesis.getJcxSiAgrede().isSelected()) {
            if (vistaAnamnesis.getTxtFrecuenciaAgresorAgrede().getText().isEmpty()
                    || vistaAnamnesis.getTxtQueUtiliza().getText().isEmpty()) {
                return false;
            } else {
                return true;
            }
        }
        return true;
    }

    //VALIDACIÓN SECCIÓN: 1.14 OBSERVACIONES GENERALES- FICHA ANAMNESIS
    public boolean validardatosObservacionesGenerales() {
        if (vistaAnamnesis.getTxAObservaciones().getText().isEmpty()) {
            System.out.println("Observaciones vacias");
            return false;
        } else {
            return true;
        }
    }

    //METODOS DE LOS CHECKBOX PARA ACCIONES EN LA VENTANA ANAMNESIS--------------------------------------------------------------------------------------------------------------------
    //pestania 11
    public void checkSalud() {
        if (vistaAnamnesis.getJcxSiProblemasRespiratorios().isSelected()) {
            vistaAnamnesis.getTxtEspecifiqueProblemasRespiratorios().setEnabled(true);
        }
        if (vistaAnamnesis.getJcxNoProblemasRespiratorios().isSelected()) {
            vistaAnamnesis.getTxtEspecifiqueProblemasRespiratorios().setEnabled(false);
        }
        if (vistaAnamnesis.getJcxSiAlergias().isSelected()) {
            vistaAnamnesis.getTxtEspecifiqueAlergias().setEnabled(true);

        }
        if (vistaAnamnesis.getJcxNoAlergias().isSelected()) {
            vistaAnamnesis.getTxtEspecifiqueAlergias().setEnabled(false);
        }

        if (vistaAnamnesis.getJcxSiNeurologicos().isSelected()) {
            vistaAnamnesis.getTxtEspecifiqueNeurologicos().setEnabled(true);
        }
        if (vistaAnamnesis.getJcxNoNeurologicos().isSelected()) {
            vistaAnamnesis.getTxtEspecifiqueNeurologicos().setEnabled(false);
        }

        if (vistaAnamnesis.getJcxSiNerviosos().isSelected()) {
            vistaAnamnesis.getTxtEspecifiqueNerviosos().setEnabled(true);
        }
        if (vistaAnamnesis.getJcxNoNerviosos().isSelected()) {
            vistaAnamnesis.getTxtEspecifiqueNerviosos().setEnabled(false);
        }

    }

    //pestania 5
    public void condiconesNacimiento() {
        if (vistaAnamnesis.getJcxNormal().isSelected()) {
            vistaAnamnesis.getTxtMotivoCesarea().setEnabled(false);
        }
        if (vistaAnamnesis.getJcxCesarea().isSelected()) {
            vistaAnamnesis.getTxtMotivoCesarea().setEnabled(true);
        }

    }

    public void valCheck() {
        System.out.println("llega al validar check");
        if (vistaAnamnesis.getJcxSiViolencia().isSelected()) {
            System.out.println("caso si");
            vistaAnamnesis.getJcxGolpes().setEnabled(true);
            vistaAnamnesis.getJcxInsultos().setEnabled(true);
            vistaAnamnesis.getJcxAbusoSexual().setEnabled(true);
            vistaAnamnesis.getJcxNegligencia().setEnabled(true);
            vistaAnamnesis.getJcxAmbitoLaboral().setEnabled(true);
        } else if (vistaAnamnesis.getJcxNoViolencia().isSelected()) {
            System.out.println("caso no check");
            vistaAnamnesis.getJcxGolpes().setEnabled(false);
            vistaAnamnesis.getJcxInsultos().setEnabled(false);
            vistaAnamnesis.getJcxAbusoSexual().setEnabled(false);
            vistaAnamnesis.getJcxNegligencia().setEnabled(false);
            vistaAnamnesis.getJcxAmbitoLaboral().setEnabled(false);
        }

        if (vistaAnamnesis.getJcxSiControles().isSelected()) {
            vistaAnamnesis.getJcxUnaVez().setEnabled(true);
            vistaAnamnesis.getJcxMensual().setEnabled(true);
            vistaAnamnesis.getJcxTrimestral().setEnabled(true);
            vistaAnamnesis.getJcxNinguna().setEnabled(true);
            vistaAnamnesis.getTxtDondeRealizoControles().setEnabled(true);
        } else if (vistaAnamnesis.getJcxNoControles().isSelected()) {
            vistaAnamnesis.getJcxUnaVez().setEnabled(false);
            vistaAnamnesis.getJcxMensual().setEnabled(false);
            vistaAnamnesis.getJcxTrimestral().setEnabled(false);
            vistaAnamnesis.getJcxNinguna().setEnabled(false);
            vistaAnamnesis.getTxtDondeRealizoControles().setEnabled(false);

        }

        if (vistaAnamnesis.getJcxSiComplicaciones().isSelected()) {
            vistaAnamnesis.getJcxBajoPeso().setEnabled(true);
            vistaAnamnesis.getJcxHemorragias().setEnabled(true);
            vistaAnamnesis.getJcxInfecciones().setEnabled(true);
            vistaAnamnesis.getJcxPreclansia().setEnabled(true);
            vistaAnamnesis.getTxtOtraComplicacionEmbarazo().setEnabled(true);
        } else if (vistaAnamnesis.getJcxNoComplicaciones().isSelected()) {
            vistaAnamnesis.getJcxBajoPeso().setEnabled(false);
            vistaAnamnesis.getJcxHemorragias().setEnabled(false);
            vistaAnamnesis.getJcxInfecciones().setEnabled(false);
            vistaAnamnesis.getJcxPreclansia().setEnabled(false);
            vistaAnamnesis.getTxtOtraComplicacionEmbarazo().setEnabled(false);

        }

        if (vistaAnamnesis.getJcxSiConsume().isSelected()) {
            vistaAnamnesis.getJcxAlcohol().setEnabled(true);
            vistaAnamnesis.getJcxTabaco().setEnabled(true);
            vistaAnamnesis.getJcxDroga().setEnabled(true);
            vistaAnamnesis.getTxtCausasConsumo().setEnabled(true);
        } else if (vistaAnamnesis.getJcxNoConsume().isSelected()) {
            vistaAnamnesis.getJcxAlcohol().setEnabled(false);
            vistaAnamnesis.getJcxTabaco().setEnabled(false);
            vistaAnamnesis.getJcxDroga().setEnabled(false);
            vistaAnamnesis.getTxtCausasConsumo().setEnabled(false);
        }

        if (vistaAnamnesis.getJcxSiAborto().isSelected()) {
            vistaAnamnesis.getTxtCausasAborto().setEnabled(true);
        } else if (vistaAnamnesis.getJcxNoAborto().isSelected()) {
            vistaAnamnesis.getTxtCausasAborto().setEnabled(false);
        }

    }

    public void valEscolNino() {
        if (vistaAnamnesis.getJcxSiEstudia().isSelected()) {
            vistaAnamnesis.getTxtExpliqueEstudia().setEnabled(true);
        } else if (vistaAnamnesis.getJcxNoEstudia().isSelected()) {
            vistaAnamnesis.getTxtExpliqueEstudia().setEnabled(false);
        }

        if (vistaAnamnesis.getJcxSiAprendizaje().isSelected()) {
            vistaAnamnesis.getTxtEspecifiqueAprendizaje().setEnabled(true);
        } else if (vistaAnamnesis.getJcxNoAprendizaje().isSelected()) {
            vistaAnamnesis.getTxtEspecifiqueAprendizaje().setEnabled(false);

        }

        if (vistaAnamnesis.getJcxSiNivelacion().isSelected()) {
            vistaAnamnesis.getTxtEspecifiqueNivelacion().setEnabled(true);
        } else if (vistaAnamnesis.getJcxSiNivelacion().isSelected()) {
            vistaAnamnesis.getTxtEspecifiqueNivelacion().setEnabled(false);

        }
    }

    public void controlPestaña6() {
        if (vistaAnamnesis.getJcxSiLeche().isSelected()) {
            vistaAnamnesis.getTxtPorqueLeche().setEnabled(false);
        } else if (vistaAnamnesis.getJcxNoLeche().isSelected()) {
            vistaAnamnesis.getTxtPorqueLeche().setEnabled(true);
        }

        if (vistaAnamnesis.getJcxSiBiberon().isSelected()) {
            vistaAnamnesis.getTxtDesdeEdadBiberon().setEnabled(true);
            vistaAnamnesis.getTxtHastaEdadBiberon().setEnabled(true);
        } else if (vistaAnamnesis.getJcxNoBiberon().isSelected()) {
            vistaAnamnesis.getTxtDesdeEdadBiberon().setEnabled(false);
            vistaAnamnesis.getTxtHastaEdadBiberon().setEnabled(false);
        }
    }

    public void valPestana9() {
        if (vistaAnamnesis.getJcxSiEcopresis().isSelected()) {
            vistaAnamnesis.getTxtCausaEcopresis().setEnabled(true);
        } else if (vistaAnamnesis.getJcxNoEcopresis().isSelected()) {
            vistaAnamnesis.getTxtCausaEcopresis().setEnabled(false);
        }
    }

    public void valPestana12() {
        if (vistaAnamnesis.getJcxSiTrabajo().isSelected()) {
            vistaAnamnesis.getTxtEnqueaTrabajo().setEnabled(true);
        } else if (vistaAnamnesis.getJcxNoTrabajo().isSelected()) {
            vistaAnamnesis.getTxtEnqueaTrabajo().setEnabled(false);
        }

        if (vistaAnamnesis.getJcxSiAgrede().isSelected()) {
            vistaAnamnesis.getTxtFrecuenciaAgresorAgrede().setEnabled(true);
            vistaAnamnesis.getTxtQueUtiliza().setEnabled(true);
        } else if (vistaAnamnesis.getJcxNoAgrede().isSelected()) {
            vistaAnamnesis.getTxtFrecuenciaAgresorAgrede().setEnabled(false);
            vistaAnamnesis.getTxtQueUtiliza().setEnabled(false);
        }
    }
    
    
    //------------------------------------------------CONSULTAR DATOS FICHA ANAMNESIS Y CARGARLOS------------------------------------------------------------------------
    //CONSULTAR ENBEZADO Y DATOS DE IDENTIFICACION
    public void consultarDatosEncabezadoIdentificacion(){
        
    }
    
    //CONSULTAR DATOS: DATOS DE LA MADRE Y PADRE
    
    //CONSULTAR DATOS: COMPOSICION FAMILIAR NNA
    
    //CONSULTAR DATOS: PERIODO DE EMBARAZO

    //CONSULTAR DATOS: CONDICIONES DE NACIMIENTO
    
    //CONSULTAR DATOS: PRIMEROS DIAS DE VIDA
    
    //CONSULTAR DATOS: ALIMENTACION ACTUAL
    
    //CONSULTAR DATOS:DESARROLLO MOTOR Y LENGUAJE ACTUAL
    
    //CONSULTAR DATOS: SUEÑO Y CONTROL DE ESFINTERES
    
    //CONSULTAR DATOS: ESCOLARIZACION DE NNA
     
    //CONSULTAR DATOS: SALUD
    
    //CONSULTAR DATOS: RELACION FAMILIAR
    
    //CONSULTAR DATOS OBSERVACIONES GENERALES
    
}
