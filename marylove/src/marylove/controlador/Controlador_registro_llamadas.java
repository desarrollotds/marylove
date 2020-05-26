package marylove.controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.Timer;
import marylove.DBmodelo.Caracteristicas_violenciaDB;
import marylove.DBmodelo.EstadoPsicoEmoDB;
import marylove.DBmodelo.LlamadaDB;
import marylove.DBmodelo.Llamada_riesgosDB;
import marylove.DBmodelo.MotivoDB;
import marylove.DBmodelo.persona_llamadaDB;
import marylove.DBmodelo.x_caracteristicas_agresorDB;
import marylove.DBmodelo.x_llamad_estad_psicoDB;
import marylove.DBmodelo.x_motivo_llamadaDB;
import marylove.DBmodelo.x_resultado_llamadaDB;
import marylove.models.Json_object_consulta;
import marylove.models.Llamada;
import marylove.models.Persona_llamada;
import marylove.models.x_resultado_llamada;
import marylove.vista.VistaRegistroLlamada;
import static marylove.controlador.C_Login.personal_cod;
import marylove.models.Resultado;
import marylove.vista.FichaAgendamientoCitas;
import marylove.vista.VistaCita;
import org.json.simple.parser.ParseException;

/**
 *
 * @author USUARIO
 */
public class Controlador_registro_llamadas implements ActionListener {

    VistaRegistroLlamada vista;

    DefaultComboBoxModel modelo;// modelo para setear datos en los combos
    ArrayList<Resultado> res;//lista de resultados
    private static int personalcodigo = personal_cod;//variable tomado del login
    //variables globales para el metodo llamada()
    int perllamcod = 0;
    int llamadacoigoID = 0; //variable para insercion en la tabla terceria con coracteristicas
    String frecuencia = "";
    String nacionalidad = "";
    Caracteristicas_violenciaDB ccc;
    ArrayList<Json_object_consulta> json;
    //variables globales para el metodo de resultados()
    int llamadacodigoId = 0;
    int resultado = 0;
    String descripcion = "";

    public Controlador_registro_llamadas(VistaRegistroLlamada vista) throws ParseException {
        this.vista = vista;
        this.vista.getBtnGuardar().addActionListener(this);
        this.vista.getBtnGenerarCita().addActionListener(e -> abrirCita());
        this.vista.getBtnCancelar().addActionListener(this);
        //juegos de check
        //----------------------------------------------------------------------
        this.vista.getRbHijosSi().addActionListener(this);
        this.vista.getRbHijosNo().addActionListener(this);
        this.vista.getRbHijosNoReporta().addActionListener(this);
        //----------------------------------------------------------------------
        this.vista.getRbTrabajaSi().addActionListener(this);
        this.vista.getRbTrabajoNo().addActionListener(this);
        this.vista.getRbTrabajaNoReporta().addActionListener(this);
        //----------------------------------------------------------------------
        this.vista.getCbNoReportaTipoViolencia().addActionListener(this);
        this.vista.getCbFisica().addActionListener(this);
        this.vista.getCbPsicologica().addActionListener(this);
        this.vista.getCbLaboral().addActionListener(this);
        this.vista.getCbEconomica().addActionListener(this);
        this.vista.getCbNegligencia().addActionListener(this);
        //----------------------------------------------------------------------
        this.vista.getCbEsposo().addActionListener(this);
        this.vista.getCbPadre_Madre().addActionListener(this);
        this.vista.getCbNovio().addActionListener(this);
        this.vista.getCbExPareja().addActionListener(this);
        this.vista.getCbHijo().addActionListener(this);
        this.vista.getCbJefe().addActionListener(this);
        this.vista.getCbNoReportaQuienEsElAgresor().addActionListener(this);
        //----------------------------------------------------------------------
        this.vista.getCbAlcolismo().addActionListener(this);
        this.vista.getCbMigracion().addActionListener(this);
        this.vista.getCbCelos().addActionListener(this);
        this.vista.getCbDesempleo().addActionListener(this);
        this.vista.getCbInfidelidad().addActionListener(this);
        this.vista.getCbMachismo().addActionListener(this);
        this.vista.getCbNoReportaFactoresRiesgo().addActionListener(this);
        //----------------------------------------------------------------------
        this.vista.getCbFracturas().addActionListener(this);
        this.vista.getCbMoretones().addActionListener(this);
        this.vista.getCbHeridas().addActionListener(this);
        this.vista.getCbAbortos().addActionListener(this);
        this.vista.getCbContagiosETS().addActionListener(this);
        this.vista.getCbAlt_Nerviosas().addActionListener(this);
        this.vista.getCbBajaAutoestima().addActionListener(this);
        this.vista.getCbDepresion().addActionListener(this);
        this.vista.getCbEmbarazoNoDeseado().addActionListener(this);
        this.vista.getCbNoReportaConcecuenciasFisicas().addActionListener(this);
        //----------------------------------------------------------------------
        this.vista.getCbViolenciaIntrafamiliar().addActionListener(this);
        this.vista.getCbViolenciaInstitucional().addActionListener(this);
        this.vista.getCbAlivioyApoyo().addActionListener(this);
        this.vista.getCbInformacionCasadeAcojida().addActionListener(this);
        this.vista.getCbAbusoSexual().addActionListener(this);
        this.vista.getCbViolenciaSocial().addActionListener(this);
        this.vista.getCbAtencionPsicologica().addActionListener(this);
        this.vista.getCbInformacionOtrasInstituciones().addActionListener(this);
        this.vista.getCbViolacion().addActionListener(this);
        this.vista.getCbAccesoriaLegal().addActionListener(this);
        this.vista.getCbIntentoSuicidio().addActionListener(this);
        this.vista.getCbNoReporta().addActionListener(this);
        //----------------------------------------------------------------------
        llenarComboResultados();
        try {
            llenarComboNacionalidades();
        } catch (SQLException ex) {
            System.out.println("error al llenar las nacionalidades");
        }
//        this.vistaRegis_Llamadas.setVisible(true);
//        this.vistaRegis_Llamadas.setResizable(false);
//        this.vistaRegis_Llamadas.setLocationRelativeTo(null);
        vista.getTxtOperador().setText(personalcodigo + "");

    }

    public void abrirCita() {
        try {
            VistaCita vistaCita = new VistaCita();
            ControladorCitas controladorCitas = new ControladorCitas(vistaCita);
            vistaCita.setVisible(true);
            vistaCita.setResizable(false);
            vistaCita.setLocationRelativeTo(null);
            controladorCitas.iniciarControl();
        } catch (Exception ex) {
            System.out.println("error al cargar citas en la llamada");;
        }
    }

    public void iniciarControlRLL() {
        Timer tiempo = new Timer(100, new horas());
        tiempo.start();
    }

    public void llamada() throws SQLException {
        persona_llamadaDB pldb = new persona_llamadaDB();
        LlamadaDB ldb = new LlamadaDB();
        perllamcod = pldb.getPersona_llamada_static();
        int dia = vista.getDatFechaLlamada().getCalendar().get(Calendar.DAY_OF_YEAR);
        int mes = vista.getDatFechaLlamada().getCalendar().get(Calendar.MONTH);
        int anio = vista.getDatFechaLlamada().getCalendar().get(Calendar.YEAR);
        String fecha = anio + "-" + mes + "-" + dia;
        Llamada l = new Llamada(perllamcod, vista.getTxtnumero().getText(), fecha,
                vista.getCbJornada().getSelectedItem().toString(),
                vista.getCbxPrioridad().getSelectedItem().toString(),
                personalcodigo, vista.getTxtNotasAdicionalesVictima().getText());
        llamadacoigoID = ldb.insertarLlmada(l);
//    ldb.insertarLlmada(l);

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource().equals(vista.getBtnGuardar())) {
            try {
//                System.out.println(fecha);
//                String fecha2="2001-12-08";
//                formato = new SimpleDateFormat("yyyy-MM-dd");
//                Date fechaDate = formato.parse(fecha2);
//                vistaRegis_Llamadas.getDatFechaLlamada().setDateFormatString(fecha2);
//                System.out.println(fechaDate);
                if (comprobaciones()) {
                    JOptionPane.showMessageDialog(vista, "Funciona");
                    datosDeInformcion();
                    llamada();
                    motivoLlamada();
                    estadoPsico();
                    CaracteristicasViolencia();
                    resultados();

                }

//                
            } catch (SQLException ex) {
                Logger.getLogger(Controlador_registro_llamadas.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ParseException ex) {
                Logger.getLogger(Controlador_registro_llamadas.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        //boton generar cita
        if (e.getSource().equals(vista.getBtnGenerarCita())) {
            
        }
        //----------------------------------------------------------------------juego hijos
        if (this.vista.getRbHijosSi().isSelected()) {
            this.vista.getRbHijosNo().setEnabled(false);
            this.vista.getRbHijosNoReporta().setEnabled(false);
        } else {
            this.vista.getRbHijosNo().setEnabled(true);
            this.vista.getRbHijosNoReporta().setEnabled(true);

        }
        if (this.vista.getRbHijosNo().isSelected()) {
            this.vista.getRbHijosNoReporta().setEnabled(false);
            this.vista.getSpnNumeroHijos().setEnabled(false);
            this.vista.getRbHijosSi().setEnabled(false);
        } else {
            this.vista.getRbHijosSi().setEnabled(true);
            this.vista.getRbHijosNoReporta().setEnabled(true);
            this.vista.getSpnNumeroHijos().setEnabled(true);
        }
        if (this.vista.getRbHijosNoReporta().isSelected()) {
            this.vista.getRbHijosSi().setEnabled(false);
            this.vista.getRbHijosNo().setEnabled(false);
            this.vista.getSpnNumeroHijos().setEnabled(false);
        } else {
            this.vista.getRbHijosSi().setEnabled(true);
            this.vista.getRbHijosNo().setEnabled(true);
            this.vista.getSpnNumeroHijos().setEnabled(true);
        }
        //----------------------------------------------------------------------juego trabaja
        if (this.vista.getRbTrabajaSi().isSelected()) {
            this.vista.getRbTrabajaNoReporta().setEnabled(false);
            this.vista.getRbTrabajoNo().setEnabled(false);
        } else {
            this.vista.getRbTrabajaNoReporta().setEnabled(true);
            this.vista.getRbTrabajoNo().setEnabled(true);
        }
        if (this.vista.getRbTrabajaNoReporta().isSelected()) {
            this.vista.getRbTrabajaSi().setEnabled(false);
            this.vista.getRbTrabajoNo().setEnabled(false);
        } else {
            this.vista.getRbTrabajaSi().setEnabled(true);
            this.vista.getRbTrabajoNo().setEnabled(true);
        }
        if (this.vista.getRbTrabajoNo().isSelected()) {
            this.vista.getRbTrabajaSi().setEnabled(false);
            this.vista.getRbTrabajaNoReporta().setEnabled(false);
        } else {
            this.vista.getRbTrabajaNoReporta().setEnabled(true);
            this.vista.getRbTrabajaSi().setEnabled(true);
        }
        //----------------------------------------------------------------------juego tipo violencia
        if (this.vista.getCbNoReportaTipoViolencia().isSelected()) {
            this.vista.getCbFisica().setEnabled(false);
            this.vista.getCbPsicologica().setEnabled(false);
            this.vista.getCbLaboral().setEnabled(false);
            this.vista.getCbEconomica().setEnabled(false);
            this.vista.getCbNegligencia().setEnabled(false);
            this.vista.getTxtOtro_tipo_violencia().setEnabled(false);
        } else {
            this.vista.getCbFisica().setEnabled(true);
            this.vista.getCbPsicologica().setEnabled(true);
            this.vista.getCbLaboral().setEnabled(true);
            this.vista.getCbEconomica().setEnabled(true);
            this.vista.getCbNegligencia().setEnabled(true);
            this.vista.getTxtOtro_tipo_violencia().setEnabled(true);
        }
        if ( this.vista.getCbFisica().isSelected()){
            this.vista.getCbNoReportaTipoViolencia().setEnabled(false);
        } else {
            this.vista.getCbNoReportaTipoViolencia().setEnabled(true);
        }
        if ( this.vista.getCbPsicologica().isSelected()){
            this.vista.getCbNoReportaTipoViolencia().setEnabled(false);
        } else {
            this.vista.getCbNoReportaTipoViolencia().setEnabled(true);
        }
        if ( this.vista.getCbLaboral().isSelected()){
            this.vista.getCbNoReportaTipoViolencia().setEnabled(false);
        } else {
            this.vista.getCbNoReportaTipoViolencia().setEnabled(true);
        }
        if (  this.vista.getCbNegligencia().isSelected()){
            this.vista.getCbNoReportaTipoViolencia().setEnabled(false);
        } else {
            this.vista.getCbNoReportaTipoViolencia().setEnabled(true);
        }
        if ( this.vista.getCbEconomica().isSelected()){
            this.vista.getCbNoReportaTipoViolencia().setEnabled(false);
        } else {
            this.vista.getCbNoReportaTipoViolencia().setEnabled(true);
        }
        
        //----------------------------------------------------------------------juego quies es el agresor
        if (this.vista.getCbNoReportaQuienEsElAgresor().isSelected()) {
            this.vista.getCbEsposo().setEnabled(false);
            this.vista.getCbPadre_Madre().setEnabled(false);
            this.vista.getCbNovio().setEnabled(false);
            this.vista.getCbExPareja().setEnabled(false);
            this.vista.getCbHijo().setEnabled(false);
            this.vista.getCbJefe().setEnabled(false);
            this.vista.getTxtOtrosQuienEsElAgresor().setEnabled(false);
        } else {
            this.vista.getCbEsposo().setEnabled(true);
            this.vista.getCbPadre_Madre().setEnabled(true);
            this.vista.getCbNovio().setEnabled(true);
            this.vista.getCbExPareja().setEnabled(true);
            this.vista.getCbHijo().setEnabled(true);
            this.vista.getCbJefe().setEnabled(true);
            this.vista.getTxtOtrosQuienEsElAgresor().setEnabled(true);
        }
        if ( this.vista.getCbEsposo().isSelected()) {
            this.vista.getCbNoReportaQuienEsElAgresor().setEnabled(false);
        } else {
            this.vista.getCbNoReportaQuienEsElAgresor().setEnabled(true);
        }
        if ( this.vista.getCbPadre_Madre().isSelected()) {
            this.vista.getCbNoReportaQuienEsElAgresor().setEnabled(false);
        } else {
            this.vista.getCbNoReportaQuienEsElAgresor().setEnabled(true);
        }
        if ( this.vista.getCbNovio().isSelected()) {
            this.vista.getCbNoReportaQuienEsElAgresor().setEnabled(false);
        } else {
            this.vista.getCbNoReportaQuienEsElAgresor().setEnabled(true);
        }
        if ( this.vista.getCbExPareja().isSelected()) {
            this.vista.getCbNoReportaQuienEsElAgresor().setEnabled(false);
        } else {
            this.vista.getCbNoReportaQuienEsElAgresor().setEnabled(true);
        }
        if ( this.vista.getCbHijo().isSelected()) {
            this.vista.getCbNoReportaQuienEsElAgresor().setEnabled(false);
        } else {
            this.vista.getCbNoReportaQuienEsElAgresor().setEnabled(true);
        }
        if ( this.vista.getCbJefe().isSelected()) {
            this.vista.getCbNoReportaQuienEsElAgresor().setEnabled(false);
        } else {
            this.vista.getCbNoReportaQuienEsElAgresor().setEnabled(true);
        }
        
        //----------------------------------------------------------------------juego factores riesgo
        if (this.vista.getCbNoReportaFactoresRiesgo().isSelected()) {
            this.vista.getCbAlcolismo().setEnabled(false);
            this.vista.getCbMigracion().setEnabled(false);
            this.vista.getCbCelos().setEnabled(false);
            this.vista.getCbDesempleo().setEnabled(false);
            this.vista.getCbInfidelidad().setEnabled(false);
            this.vista.getCbMachismo().setEnabled(false);
            this.vista.getTxtOtrosFactoresRiesgo().setEnabled(false);
        } else {
            this.vista.getCbAlcolismo().setEnabled(true);
            this.vista.getCbMigracion().setEnabled(true);
            this.vista.getCbCelos().setEnabled(true);
            this.vista.getCbDesempleo().setEnabled(true);
            this.vista.getCbInfidelidad().setEnabled(true);
            this.vista.getCbMachismo().setEnabled(true);
            this.vista.getTxtOtrosFactoresRiesgo().setEnabled(true);
        }
        if ( this.vista.getCbAlcolismo().isSelected()) {
            this.vista.getCbNoReportaFactoresRiesgo().setEnabled(false);
        } else {
            this.vista.getCbNoReportaFactoresRiesgo().setEnabled(true);
        }
        if ( this.vista.getCbMigracion().isSelected()) {
            this.vista.getCbNoReportaFactoresRiesgo().setEnabled(false);
        } else {
            this.vista.getCbNoReportaFactoresRiesgo().setEnabled(true);
        }
        if ( this.vista.getCbCelos().isSelected()) {
            this.vista.getCbNoReportaFactoresRiesgo().setEnabled(false);
        } else {
            this.vista.getCbNoReportaFactoresRiesgo().setEnabled(true);
        }
        if ( this.vista.getCbDesempleo().isSelected()) {
            this.vista.getCbNoReportaFactoresRiesgo().setEnabled(false);
        } else {
            this.vista.getCbNoReportaFactoresRiesgo().setEnabled(true);
        }
        if ( this.vista.getCbInfidelidad().isSelected()) {
            this.vista.getCbNoReportaFactoresRiesgo().setEnabled(false);
        } else {
            this.vista.getCbNoReportaFactoresRiesgo().setEnabled(true);
        }
        if ( this.vista.getCbMachismo().isSelected()) {
            this.vista.getCbNoReportaFactoresRiesgo().setEnabled(false);
        } else {
            this.vista.getCbNoReportaFactoresRiesgo().setEnabled(true);
        }
        //----------------------------------------------------------------------juegos conceciencias fisicas agrecion
        if (this.vista.getCbNoReportaConcecuenciasFisicas().isSelected()) {
            this.vista.getCbFracturas().setEnabled(false);
            this.vista.getCbMoretones().setEnabled(false);
            this.vista.getCbHeridas().setEnabled(false);
            this.vista.getCbAbortos().setEnabled(false);
            this.vista.getCbContagiosETS().setEnabled(false);
            this.vista.getCbAlt_Nerviosas().setEnabled(false);
            this.vista.getCbBajaAutoestima().setEnabled(false);
            this.vista.getCbDepresion().setEnabled(false);
            this.vista.getCbEmbarazoNoDeseado().setEnabled(false);
            this.vista.getTxtOtroConsecienciasFisicas().setEnabled(false);
        } else {
            this.vista.getCbFracturas().setEnabled(true);
            this.vista.getCbMoretones().setEnabled(true);
            this.vista.getCbHeridas().setEnabled(true);
            this.vista.getCbAbortos().setEnabled(true);
            this.vista.getCbContagiosETS().setEnabled(true);
            this.vista.getCbAlt_Nerviosas().setEnabled(true);
            this.vista.getCbBajaAutoestima().setEnabled(true);
            this.vista.getCbDepresion().setEnabled(true);
            this.vista.getCbEmbarazoNoDeseado().setEnabled(true);
            this.vista.getTxtOtroConsecienciasFisicas().setEnabled(true);
        }
        if ( this.vista.getCbFracturas().isSelected()) {
            this.vista.getCbNoReportaConcecuenciasFisicas().setEnabled(false);
        } else {
            this.vista.getCbNoReportaConcecuenciasFisicas().setEnabled(true);
        }
        if (  this.vista.getCbMoretones().isSelected()) {
            this.vista.getCbNoReportaConcecuenciasFisicas().setEnabled(false);
        } else {
            this.vista.getCbNoReportaConcecuenciasFisicas().setEnabled(true);
        }
        if ( this.vista.getCbHeridas().isSelected()) {
            this.vista.getCbNoReportaConcecuenciasFisicas().setEnabled(false);
        } else {
            this.vista.getCbNoReportaConcecuenciasFisicas().setEnabled(true);
        }
        if ( this.vista.getCbAbortos().isSelected()) {
            this.vista.getCbNoReportaConcecuenciasFisicas().setEnabled(false);
        } else {
            this.vista.getCbNoReportaConcecuenciasFisicas().setEnabled(true);
        }
        if ( this.vista.getCbContagiosETS().isSelected()) {
            this.vista.getCbNoReportaConcecuenciasFisicas().setEnabled(false);
        } else {
            this.vista.getCbNoReportaConcecuenciasFisicas().setEnabled(true);
        }
        if ( this.vista.getCbAlt_Nerviosas().isSelected()) {
            this.vista.getCbNoReportaConcecuenciasFisicas().setEnabled(false);
        } else {
            this.vista.getCbNoReportaConcecuenciasFisicas().setEnabled(true);
        }
        if (  this.vista.getCbBajaAutoestima().isSelected()) {
            this.vista.getCbNoReportaConcecuenciasFisicas().setEnabled(false);
        } else {
            this.vista.getCbNoReportaConcecuenciasFisicas().setEnabled(true);
        }
        if ( this.vista.getCbDepresion().isSelected()) {
            this.vista.getCbNoReportaConcecuenciasFisicas().setEnabled(false);
        } else {
            this.vista.getCbNoReportaConcecuenciasFisicas().setEnabled(true);
        }
        if ( this.vista.getCbEmbarazoNoDeseado().isSelected()) {
            this.vista.getCbNoReportaConcecuenciasFisicas().setEnabled(false);
        } else {
            this.vista.getCbNoReportaConcecuenciasFisicas().setEnabled(true);
        }
        //----------------------------------------------------------------------juego motivo llamada
        if (this.vista.getCbNoReporta().isSelected()) {
            this.vista.getCbViolenciaIntrafamiliar().setEnabled(false);
            this.vista.getCbViolenciaInstitucional().setEnabled(false);
            this.vista.getCbAlivioyApoyo().setEnabled(false);                 
            this.vista.getCbInformacionCasadeAcojida().setEnabled(false);
            this.vista.getCbAbusoSexual().setEnabled(false);
            this.vista.getCbViolenciaSocial().setEnabled(false);
            this.vista.getCbAtencionPsicologica().setEnabled(false);
            this.vista.getCbInformacionOtrasInstituciones().setEnabled(false);
            this.vista.getCbViolacion().setEnabled(false);
            this.vista.getCbAccesoriaLegal().setEnabled(false); 
            this.vista.getCbIntentoSuicidio().setEnabled(false);
            this.vista.getTxtOtrosMotivoLlamada().setEditable(false);
        } else {
            this.vista.getCbViolenciaIntrafamiliar().setEnabled(true);
            this.vista.getCbViolenciaInstitucional().setEnabled(true);
            this.vista.getCbAlivioyApoyo().setEnabled(true);                 
            this.vista.getCbInformacionCasadeAcojida().setEnabled(true);
            this.vista.getCbAbusoSexual().setEnabled(true);
            this.vista.getCbViolenciaSocial().setEnabled(true);
            this.vista.getCbAtencionPsicologica().setEnabled(true);
            this.vista.getCbInformacionOtrasInstituciones().setEnabled(true);
            this.vista.getCbViolacion().setEnabled(true);
            this.vista.getCbAccesoriaLegal().setEnabled(true); 
            this.vista.getCbIntentoSuicidio().setEnabled(true);
            this.vista.getTxtOtrosMotivoLlamada().setEditable(true);
        }
        if ( this.vista.getCbViolenciaIntrafamiliar().isSelected()) {
            this.vista.getCbNoReporta().setEnabled(false);
        } else {
            this.vista.getCbNoReporta().setEnabled(true);
        }
        if (this.vista.getCbViolenciaInstitucional().isSelected()) {
            this.vista.getCbNoReporta().setEnabled(false);
        } else {
            this.vista.getCbNoReporta().setEnabled(true);
        }
        if ( this.vista.getCbAlivioyApoyo().isSelected()) {
            this.vista.getCbNoReporta().setEnabled(false);
        } else {
            this.vista.getCbNoReporta().setEnabled(true);
        }
        if (this.vista.getCbInformacionCasadeAcojida().isSelected()) {
            this.vista.getCbNoReporta().setEnabled(false);
        } else {
            this.vista.getCbNoReporta().setEnabled(true);
        }
        if (this.vista.getCbAbusoSexual().isSelected()) {
            this.vista.getCbNoReporta().setEnabled(false);
        } else {
            this.vista.getCbNoReporta().setEnabled(true);
        }
        if ( this.vista.getCbViolenciaSocial().isSelected()) {
            this.vista.getCbNoReporta().setEnabled(false);
        } else {
            this.vista.getCbNoReporta().setEnabled(true);
        }
        if (this.vista.getCbAtencionPsicologica().isSelected()) {
            this.vista.getCbNoReporta().setEnabled(false);
        } else {
            this.vista.getCbNoReporta().setEnabled(true);
        }
        if (this.vista.getCbViolacion().isSelected()) {
            this.vista.getCbNoReporta().setEnabled(false);
        } else {
            this.vista.getCbNoReporta().setEnabled(true);
        }
        if ( this.vista.getCbAccesoriaLegal().isSelected()) {
            this.vista.getCbNoReporta().setEnabled(false);
        } else {
            this.vista.getCbNoReporta().setEnabled(true);
        }
        if (this.vista.getCbIntentoSuicidio().isSelected()) {
            this.vista.getCbNoReporta().setEnabled(false);
        } else {
            this.vista.getCbNoReporta().setEnabled(true);
        }
        if (this.vista.getCbInformacionOtrasInstituciones().isSelected()) {
            this.vista.getCbNoReporta().setEnabled(false);
        } else {
            this.vista.getCbNoReporta().setEnabled(true);
        }
        
    }

    public void estadoPsico() throws SQLException {
        EstadoPsicoEmoDB epedb = new EstadoPsicoEmoDB();
        x_llamad_estad_psicoDB xllepDB;

        LlamadaDB ldb = new LlamadaDB();
        if (vista.getCbAnsiosa().isSelected()) {
            int re = epedb.obtenerIdEstado("Ansiosa", 1);
            int llamadacodigo = ldb.obtenerIdllamada();
            xllepDB = new x_llamad_estad_psicoDB(llamadacodigo, re);
//xllep = new x_llamada_estado_psico(llamadacodigo,0, re);
            xllepDB.insertar();
        }
        if (vista.getCbAsustada().isSelected()) {
            int re = epedb.obtenerIdEstado("Asustada", 1);
            int llamadacodigo = ldb.getLlamada_static();
            xllepDB = new x_llamad_estad_psicoDB(llamadacodigo, re);
            xllepDB.insertar();

        }
        if (vista.getCbNerviosa().isSelected()) {
            int re = epedb.obtenerIdEstado("Nerviosa", 1);
            int llamadacodigo = ldb.getLlamada_static();
            xllepDB = new x_llamad_estad_psicoDB(llamadacodigo, re);
            xllepDB.insertar();
        }
        if (vista.getCbTranquila().isSelected()) {
            int re = epedb.obtenerIdEstado("Tranquila", 1);
            int llamadacodigo = ldb.getLlamada_static();
            xllepDB = new x_llamad_estad_psicoDB(llamadacodigo, re);
            xllepDB.insertar();
        }
        if (vista.getCbLlorosa().isSelected()) {
            int re = epedb.obtenerIdEstado("Llorosa", 1);
            int llamadacodigo = ldb.getLlamada_static();
            xllepDB = new x_llamad_estad_psicoDB(llamadacodigo, re);
            xllepDB.insertar();
        }
        if (vista.getCbEnojada().isSelected()) {
            int re = epedb.obtenerIdEstado("Enojada", 1);
            int llamadacodigo = ldb.getLlamada_static();
            xllepDB = new x_llamad_estad_psicoDB(llamadacodigo, re);
            xllepDB.insertar();
        }

        int re = epedb.obtenerIdEstado(vista.getCbHabla().getSelectedItem().toString(), 2);
        int llamadacodigo = ldb.getLlamada_static();
        xllepDB = new x_llamad_estad_psicoDB(llamadacodigo, re);
        xllepDB.insertar();

        int re2 = epedb.obtenerIdEstado(vista.getCbVoz().getSelectedItem().toString(), 3);
        int llamadacodigo2 = ldb.getLlamada_static();
        xllepDB = new x_llamad_estad_psicoDB(llamadacodigo2, re2);
        xllepDB.insertar();

    }

    public void motivoLlamada() throws SQLException {
        MotivoDB m = new MotivoDB();
        x_motivo_llamadaDB xmldb;

        LlamadaDB ldb = new LlamadaDB();
        if (vista.getCbViolenciaIntrafamiliar().isSelected()) {
            int llamadacodigo = ldb.getLlamada_static();
            int motivo = m.obteMotivId("Violencia Intrafamiliar");
            xmldb = new x_motivo_llamadaDB(llamadacodigo, motivo, "");
            xmldb.insertar_x_motivo_llamada();

        }
        if (vista.getCbViolenciaInstitucional().isSelected()) {
            int llamadacodigo = ldb.getLlamada_static();
            int motivo = m.obteMotivId("Violencia Intitucional");
            xmldb = new x_motivo_llamadaDB(llamadacodigo, motivo, "");
            xmldb.insertar_x_motivo_llamada();
        }
        if (vista.getCbAlivioyApoyo().isSelected()) {
            int llamadacodigo = ldb.getLlamada_static();
            int motivo = m.obteMotivId("Alivio y apoyo");
            xmldb = new x_motivo_llamadaDB(llamadacodigo, motivo, "");
            xmldb.insertar_x_motivo_llamada();
        }
        if (vista.getCbInformacionCasadeAcojida().isSelected()) {
            int llamadacodigo = ldb.getLlamada_static();
            int motivo = m.obteMotivId("Información sobre la casa de acogida");
            xmldb = new x_motivo_llamadaDB(llamadacodigo, motivo, "");
            xmldb.insertar_x_motivo_llamada();
        }
        if (vista.getCbAbusoSexual().isSelected()) {
            int llamadacodigo = ldb.getLlamada_static();
            int motivo = m.obteMotivId("Abuso sexual");
            xmldb = new x_motivo_llamadaDB(llamadacodigo, motivo, "");
            xmldb.insertar_x_motivo_llamada();
        }
        if (vista.getCbViolenciaSocial().isSelected()) {
            int llamadacodigo = ldb.getLlamada_static();
            int motivo = m.obteMotivId("Violencia social");
            xmldb = new x_motivo_llamadaDB(llamadacodigo, motivo, "");
            xmldb.insertar_x_motivo_llamada();
        }
        if (vista.getCbAtencionPsicologica().isSelected()) {
            int llamadacodigo = ldb.getLlamada_static();
            int motivo = m.obteMotivId("Atención psicológica");
            xmldb = new x_motivo_llamadaDB(llamadacodigo, motivo, "");
            xmldb.insertar_x_motivo_llamada();
        }
        if (vista.getCbInformacionOtrasInstituciones().isSelected()) {
            int llamadacodigo = ldb.getLlamada_static();
            int motivo = m.obteMotivId("Información sobre otras instituciones");
            xmldb = new x_motivo_llamadaDB(llamadacodigo, motivo, "");
            xmldb.insertar_x_motivo_llamada();
        }
        if (vista.getCbViolacion().isSelected()) {
            int llamadacodigo = ldb.getLlamada_static();
            int motivo = m.obteMotivId("Violación");
            xmldb = new x_motivo_llamadaDB(llamadacodigo, motivo, "");
            xmldb.insertar_x_motivo_llamada();
        }
        if (vista.getCbAccesoriaLegal().isSelected()) {
            int llamadacodigo = ldb.getLlamada_static();
            int motivo = m.obteMotivId("Asesoría legal");
            xmldb = new x_motivo_llamadaDB(llamadacodigo, motivo, "");
            xmldb.insertar_x_motivo_llamada();
        }
        if (vista.getCbIntentoSuicidio().isSelected()) {
            int llamadacodigo = ldb.getLlamada_static();
            int motivo = m.obteMotivId("Intento de suicidio");
            xmldb = new x_motivo_llamadaDB(llamadacodigo, motivo, "");
            xmldb.insertar_x_motivo_llamada();
        }
        if (vista.getCbNoReporta().isSelected()) {
            int llamadacodigo = ldb.getLlamada_static();
            int motivo = m.obteMotivId("No reporta");
            xmldb = new x_motivo_llamadaDB(llamadacodigo, motivo, "");
            xmldb.insertar_x_motivo_llamada();
        }
        if (!vista.getTxtOtrosMotivoLlamada().equals("")) {
            int llamadacodigo = ldb.getLlamada_static();
            int motivo = m.obteMotivId("Otra");
            xmldb = new x_motivo_llamadaDB(llamadacodigo, motivo, vista.getTxtOtrosMotivoLlamada().getText());
            xmldb.insertar_x_motivo_llamada();
        }

    }

    public void CaracteristicasViolencia() throws SQLException, ParseException {

        Caracteristicas_violenciaDB c = new Caracteristicas_violenciaDB();
        x_caracteristicas_agresorDB xc;
        LlamadaDB ldb = new LlamadaDB();
        Llamada_riesgosDB lrdb;

        if (vista.getCbFisica().isSelected()) {
            int re = c.obtener_id("Física", 1);
            int llamadacodigo = LlamadaDB.getLlamada_static();
            xc = new x_caracteristicas_agresorDB(llamadacodigo, "", "", re);
            xc.isertarRegistroCaracteristica();
        }
        if (vista.getCbPsicologica().isSelected()) {
            int re = c.obtener_id("Psicológica", 1);
            int llamadacodigo = LlamadaDB.getLlamada_static();
            xc = new x_caracteristicas_agresorDB(llamadacodigo, "", "", re);
            xc.isertarRegistroCaracteristica();
        }
        if (vista.getCbLaboral().isSelected()) {
            int re = c.obtener_id("Laboral", 1);
            int llamadacodigo = LlamadaDB.getLlamada_static();
            xc = new x_caracteristicas_agresorDB(llamadacodigo, "", "", re);
            xc.isertarRegistroCaracteristica();
        }
        if (vista.getCbEconomica().isSelected()) {
            int re = c.obtener_id("Económica", 1);
            int llamadacodigo = LlamadaDB.getLlamada_static();
            xc = new x_caracteristicas_agresorDB(llamadacodigo, "", "", re);
            xc.isertarRegistroCaracteristica();
        }
        if (vista.getCbNegligencia().isSelected()) {
            int re = c.obtener_id("Negligencia", 1);
            int llamadacodigo = LlamadaDB.getLlamada_static();
            xc = new x_caracteristicas_agresorDB(llamadacodigo, "", "", re);
            xc.isertarRegistroCaracteristica();
        }
        if (!vista.getTxtOtro_tipo_violencia().getText().equals("")) {
            int re = c.obtener_id("TOtra", 1);
            int llamadacodigo = LlamadaDB.getLlamada_static();
            xc = new x_caracteristicas_agresorDB(llamadacodigo, "", vista.getTxtOtro_tipo_violencia().getText(), re);
            xc.isertarRegistroCaracteristica();
        }
        if (vista.getCbNoReportaTipoViolencia().isSelected()) {
            int re = c.obtener_id("No reporta", 1);
            int llamadacodigo = LlamadaDB.getLlamada_static();
            xc = new x_caracteristicas_agresorDB(llamadacodigo, "", "", re);
            xc.isertarRegistroCaracteristica();
        }
        if (vista.getCbEsposo().isSelected()) {
            int re = c.obtener_id("Esposo", 2);
            int llamadacodigo = LlamadaDB.getLlamada_static();
            xc = new x_caracteristicas_agresorDB(llamadacodigo, "", "", re);
            xc.isertarRegistroCaracteristica();
        }
        if (vista.getCbPadre_Madre().isSelected()) {
            int re = c.obtener_id("Padre/Madre", 2);
            int llamadacodigo = LlamadaDB.getLlamada_static();
            xc = new x_caracteristicas_agresorDB(llamadacodigo, "", "", re);
            xc.isertarRegistroCaracteristica();
        }
        if (vista.getCbNovio().isSelected()) {
            int re = c.obtener_id("Novio", 2);
            int llamadacodigo = LlamadaDB.getLlamada_static();
            xc = new x_caracteristicas_agresorDB(llamadacodigo, "", "", re);
            xc.isertarRegistroCaracteristica();
        }
        if (vista.getCbExPareja().isSelected()) {
            int re = c.obtener_id("Ex pareja", 2);
            int llamadacodigo = LlamadaDB.getLlamada_static();
            xc = new x_caracteristicas_agresorDB(llamadacodigo, "", "", re);
            xc.isertarRegistroCaracteristica();
        }
        if (vista.getCbHijo().isSelected()) {
            int re = c.obtener_id("Hijo", 2);
            int llamadacodigo = LlamadaDB.getLlamada_static();
            xc = new x_caracteristicas_agresorDB(llamadacodigo, "", "", re);
            xc.isertarRegistroCaracteristica();
        }
        if (vista.getCbJefe().isSelected()) {
            int re = c.obtener_id("Jefe", 2);
            int llamadacodigo = LlamadaDB.getLlamada_static();
            xc = new x_caracteristicas_agresorDB(llamadacodigo, "", "", re);
            xc.isertarRegistroCaracteristica();
        }
        if (!vista.getTxtOtrosQuienEsElAgresor().getText().equals("")) {
            int re = c.obtener_id("Otra", 2);
            int llamadacodigo = ldb.getLlamada_static();
            xc = new x_caracteristicas_agresorDB(llamadacodigo, "", vista.getTxtOtrosQuienEsElAgresor().getText(), re);
            xc.isertarRegistroCaracteristica();
        }
        if (vista.getCbNoReportaQuienEsElAgresor().isSelected()) {
            int re = c.obtener_id("No reporta", 2);
            int llamadacodigo = LlamadaDB.getLlamada_static();
            xc = new x_caracteristicas_agresorDB(llamadacodigo, "", "", re);
            xc.isertarRegistroCaracteristica();
        }
        if (vista.getCbAlcolismo().isSelected()) {
            int re = c.obtener_id("Alcoholismo", 3);
            int llamadacodigo = LlamadaDB.getLlamada_static();
            xc = new x_caracteristicas_agresorDB(llamadacodigo, "", "", re);
            xc.isertarRegistroCaracteristica();
        }
        if (vista.getCbMigracion().isSelected()) {
            int re = c.obtener_id("Migración", 3);
            int llamadacodigo = LlamadaDB.getLlamada_static();
            xc = new x_caracteristicas_agresorDB(llamadacodigo, "", "", re);
            xc.isertarRegistroCaracteristica();
        }
        if (vista.getCbCelos().isSelected()) {
            int re = c.obtener_id("Celos", 3);
            int llamadacodigo = LlamadaDB.getLlamada_static();
            xc = new x_caracteristicas_agresorDB(llamadacodigo, "", "", re);
            xc.isertarRegistroCaracteristica();
        }
        if (vista.getCbDesempleo().isSelected()) {
            int re = c.obtener_id("Desempleo", 3);
            int llamadacodigo = LlamadaDB.getLlamada_static();
            xc = new x_caracteristicas_agresorDB(llamadacodigo, "", "", re);
            xc.isertarRegistroCaracteristica();
        }
        if (vista.getCbInfidelidad().isSelected()) {
            int re = c.obtener_id("Infidelidad", 3);
            int llamadacodigo = LlamadaDB.getLlamada_static();
            xc = new x_caracteristicas_agresorDB(llamadacodigo, "", "", re);
            xc.isertarRegistroCaracteristica();
        }
        if (vista.getCbMachismo().isSelected()) {
            int re = c.obtener_id("Machismo", 3);
            int llamadacodigo = LlamadaDB.getLlamada_static();
            xc = new x_caracteristicas_agresorDB(llamadacodigo, "", "", re);
            xc.isertarRegistroCaracteristica();
        }
        if (!vista.getTxtOtrosFactoresRiesgo().getText().equals("")) {
            int re = c.obtener_id("Otra", 3);
            int llamadacodigo = LlamadaDB.getLlamada_static();
            xc = new x_caracteristicas_agresorDB(llamadacodigo, "", vista.getTxtOtrosQuienEsElAgresor().getText(), re);
            xc.isertarRegistroCaracteristica();
        }
        if (vista.getCbNoReportaFactoresRiesgo().isSelected()) {
            int re = c.obtener_id("No reporta", 3);
            int llamadacodigo = LlamadaDB.getLlamada_static();
            xc = new x_caracteristicas_agresorDB(llamadacodigo, "", "", re);
            xc.isertarRegistroCaracteristica();
        }
        if (vista.getCbFracturas().isSelected()) {
            int re = c.obtener_id("Fracturas", 4);
            int llamadacodigo = LlamadaDB.getLlamada_static();
            xc = new x_caracteristicas_agresorDB(llamadacodigo, "", "", re);
            xc.isertarRegistroCaracteristica();
        }
        if (vista.getCbMoretones().isSelected()) {
            int re = c.obtener_id("Moretones", 4);
            int llamadacodigo = LlamadaDB.getLlamada_static();
            xc = new x_caracteristicas_agresorDB(llamadacodigo, "", "", re);
            xc.isertarRegistroCaracteristica();
        }
        if (vista.getCbHeridas().isSelected()) {
            int re = c.obtener_id("Heridas", 4);
            int llamadacodigo = LlamadaDB.getLlamada_static();
            xc = new x_caracteristicas_agresorDB(llamadacodigo, "", "", re);
            xc.isertarRegistroCaracteristica();
        }
        if (vista.getCbAbortos().isSelected()) {
            int re = c.obtener_id("Abortos", 4);
            int llamadacodigo = LlamadaDB.getLlamada_static();
            xc = new x_caracteristicas_agresorDB(llamadacodigo, "", "", re);
            xc.isertarRegistroCaracteristica();
        }
        if (vista.getCbContagiosETS().isSelected()) {
            int re = c.obtener_id("Contagios ETS", 4);
            int llamadacodigo = LlamadaDB.getLlamada_static();
            xc = new x_caracteristicas_agresorDB(llamadacodigo, "", "", re);
            xc.isertarRegistroCaracteristica();
        }
        if (vista.getCbAlt_Nerviosas().isSelected()) {
            int re = c.obtener_id("Alt. Nerviosas", 4);
            int llamadacodigo = LlamadaDB.getLlamada_static();
            xc = new x_caracteristicas_agresorDB(llamadacodigo, "", "", re);
            xc.isertarRegistroCaracteristica();
        }
        if (vista.getCbBajaAutoestima().isSelected()) {
            int re = c.obtener_id("Baja autoestima", 4);
            int llamadacodigo = LlamadaDB.getLlamada_static();
            xc = new x_caracteristicas_agresorDB(llamadacodigo, "", "", re);
            xc.isertarRegistroCaracteristica();
        }
        if (vista.getCbDepresion().isSelected()) {
            int re = c.obtener_id("Depresión", 4);
            int llamadacodigo = LlamadaDB.getLlamada_static();
            xc = new x_caracteristicas_agresorDB(llamadacodigo, "", "", re);
            xc.isertarRegistroCaracteristica();
        }
        if (vista.getCbEmbarazoNoDeseado().isSelected()) {
            int re = c.obtener_id("Embarazo no deseado", 4);
            int llamadacodigo = LlamadaDB.getLlamada_static();
            xc = new x_caracteristicas_agresorDB(llamadacodigo, "", "", re);
            xc.isertarRegistroCaracteristica();
        }
        if (!vista.getTxtOtroConsecienciasFisicas().getText().equals("")) {
            int re = c.obtener_id("Otra", 4);
            int llamadacodigo = LlamadaDB.getLlamada_static();
            xc = new x_caracteristicas_agresorDB(llamadacodigo, "", vista.getTxtOtrosQuienEsElAgresor().getText(), re);
            xc.isertarRegistroCaracteristica();
        }
        if (vista.getCbNoReportaConcecuenciasFisicas().isSelected()) {
            int re = c.obtener_id("No reporta", 4);
            int llamadacodigo = LlamadaDB.getLlamada_static();
            xc = new x_caracteristicas_agresorDB(llamadacodigo, "", "", re);
            xc.isertarRegistroCaracteristica();
        }
        int llamada_codigo = LlamadaDB.getLlamada_static();
        frecuencia = vista.getCbFrecuenciaAgresion().getSelectedItem().toString();
        nacionalidad = vista.getCbNacionalidadAgresor().getSelectedItem().toString();
        lrdb = new Llamada_riesgosDB(llamada_codigo, frecuencia, nacionalidad);
        lrdb.insertarLlamadaRiesgos();

    }

    public boolean comprobaciones() {

        if (vista.getDatFechaLlamada().getDate() != null) {

            if (vista.getCbJornada().getSelectedIndex() != 0) {

                if (vista.getCbxPrioridad().getSelectedIndex() != 0) {

                    return true;

                } else {
                    JOptionPane.showMessageDialog(vista, "Selecione una prioridad, porfavor.");
                    return false;
                }

            } else {
                JOptionPane.showMessageDialog(vista, "Selecione una hora, porfavor.");
                return false;
            }

        } else {
            JOptionPane.showMessageDialog(vista, "Selecione una fecha, porfavor.");
            return false;
        }

    }

    public void llenarComboNacionalidades() throws ParseException, SQLException {
        modelo = new DefaultComboBoxModel();
        ccc = new Caracteristicas_violenciaDB();
        json = ccc.obtenerNacionalidades();
        for (Json_object_consulta o : json) {
            modelo.addElement(o.getValor());
        }
        vista.getCbNacionalidadAgresor().setModel(modelo);
        vista.getCbnacionalidadVictima().setModel(modelo);
    }

    public void llenarComboResultados() {//llenado del combo resultados
        modelo = new DefaultComboBoxModel();
        persona_llamadaDB p = new persona_llamadaDB();
        res = p.listaResultados();
        for (Resultado o : res) {
            modelo.addElement(o.getResultado_nombre());
        }
        vista.getCbReultados().setModel(modelo);
    }

    public void resultados() throws SQLException {
        LlamadaDB llama = new LlamadaDB();
        x_resultado_llamadaDB xrldb = new x_resultado_llamadaDB();
        llamadacodigoId = llama.getLlamada_static();

        if (!vista.getTxtOtrosResultado().getText().equals("")) {
            resultado = vista.getCbReultados().getSelectedIndex() + 1;
            descripcion = vista.getTxtOtrosResultado().getText();
            x_resultado_llamada xrl = new x_resultado_llamada(llamadacodigoId, resultado, descripcion);
            xrldb.ingresarResultados(xrl);

        } else {
            resultado = vista.getCbReultados().getSelectedIndex() + 1;
            x_resultado_llamada xrl = new x_resultado_llamada(llamadacodigoId, resultado, "");
            xrldb.ingresarResultados(xrl);
        }

    }

    public void datosDeInformcion() {

        String nombre = "", apellido = "", edad = "", direccion = "", estado_civil = "", nacionalidad = "", comosupollamada = "";
        int numerohijos = 0;
        boolean trabaja = true;
        Persona_llamada pl;
        try {
            if (vista.getTxtNombreVictima().getText().matches("[A-Z a-z]*")) {
                nombre = vista.getTxtNombreVictima().getText().toUpperCase();
            } else {

            }
            if (vista.getTxtApellidoVictima().getText().matches("[A-Z a-z]*")) {
                apellido = vista.getTxtApellidoVictima().getText().toUpperCase();
            } else {

            }
            edad = vista.getSpnEdadVictima().getValue().toString();
            System.out.println(edad);
            direccion = vista.getTxtDireccionVictima().getText();
            nacionalidad = vista.getCbnacionalidadVictima().getSelectedItem().toString();
            estado_civil = vista.getCbxEstadoCivilVictima().getSelectedItem().toString();
            numerohijos = Integer.parseInt(vista.getSpnNumeroHijos().getValue().toString());
            comosupollamada = vista.getTxtComoSupoLineaTelfonica().getText();
            if (vista.getRbTrabajaSi().isSelected()) {
                trabaja = true;
            }
            if (vista.getRbTrabajaNoReporta().isSelected()) {
                trabaja = false;
            }
            if (vista.getRbTrabajoNo().isSelected()) {
                trabaja = false;
            }

        } catch (Exception e) {
        }
        pl = new Persona_llamada(nombre, apellido, direccion, nacionalidad, edad, estado_civil, numerohijos, comosupollamada, trabaja);
        persona_llamadaDB pldb = new persona_llamadaDB();
        pldb.ingresarPersona_llamada(pl);
    }

    class horas implements ActionListener { // metodo para tomar la hora actual y mostrar

        @Override
        public void actionPerformed(ActionEvent e) {
            Date hora = new Date();
            String pmAm = "hh:mm:ss a";
            SimpleDateFormat forHora = new SimpleDateFormat(pmAm);
            Calendar hoy = Calendar.getInstance();
            // vistaRegis_Llamadas.getJlbHoraActu().setText(String.format(forHora.format(hora), hoy));
        }
    }
}
