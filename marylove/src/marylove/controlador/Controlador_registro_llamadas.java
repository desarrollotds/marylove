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
            int llamadacodigo =ldb.getLlamada_static();
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
            int llamadacodigo =ldb.getLlamada_static();
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
