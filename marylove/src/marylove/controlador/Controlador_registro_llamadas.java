package marylove.controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import javax.swing.DefaultComboBoxModel;
import javax.swing.Timer;
import marylove.DBmodelo.Caracteristicas_violenciaDB;
import marylove.DBmodelo.LlamadaDB;
import marylove.DBmodelo.MotivoDB;
import marylove.DBmodelo.persona_llamadaDB;
import marylove.DBmodelo.x_caracteristicas_agresorDB;
import marylove.DBmodelo.x_motivo_llamadaDB;
import marylove.DBmodelo.x_resultado_llamadaDB;
import marylove.models.Llamada;
import marylove.models.Persona_llamada;
import marylove.models.x_resultado_llamada;
import marylove.vista.VistaRegistroLlamada;

import marylove.models.Resultado;
import marylove.models.x_caracteristicas_agresor;
import marylove.models.x_motivo_llamada;
import org.json.simple.parser.ParseException;

/**
 *
 * @author USUARIO
 */
public class Controlador_registro_llamadas implements ActionListener {

    VistaRegistroLlamada vista;
    DefaultComboBoxModel modelo;// modelo para setear datos en los combos
    ArrayList<Resultado> res;//lista de resultados
    private static int personalcodigo;//variable tomado del login
    //variables globales para el metodo llamada()
    int perllamcod = 0;
    int llamadacoigoID = 0; //variable para insercion en la tabla terceria con coracteristicas

    public Controlador_registro_llamadas(VistaRegistroLlamada vista) {
        this.vista = vista;
        this.vista.getBtnGuardar().addActionListener(this);
        llenarComboResultados();
//        this.vistaRegis_Llamadas.setVisible(true);
//        this.vistaRegis_Llamadas.setResizable(false);
//        this.vistaRegis_Llamadas.setLocationRelativeTo(null);
    }

    public void iniciarControlRLL() {
        Timer tiempo = new Timer(100, new horas());
        tiempo.start();
    }

    public void llamada() throws SQLException {

        LlamadaDB ldb = new LlamadaDB();
        perllamcod = ldb.obtenerIdllamada();
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

//                System.out.println(fecha);
//                String fecha2="2001-12-08";
//                formato = new SimpleDateFormat("yyyy-MM-dd");
//                Date fechaDate = formato.parse(fecha2);
//                vistaRegis_Llamadas.getDatFechaLlamada().setDateFormatString(fecha2);
//                System.out.println(fechaDate);
//                
        }

    }

    public void motivoLlamada() throws SQLException {
        MotivoDB m= new MotivoDB();
        x_motivo_llamadaDB xmldb=new x_motivo_llamadaDB();
        x_motivo_llamada xml;
        LlamadaDB ldb = new LlamadaDB();
        if(vista.getCbViolenciaIntrafamiliar().isSelected()){
            int llamadacodigo = ldb.obtenerIdllamada();
            int motivo=m.obteMotivId("Violencia Intrafamiliar");
        xml= new x_motivo_llamada(llamadacodigo, motivo,"");
        xmldb.insertar_x_motivo_llamada(xml);
        }
        if(vista.getCbViolenciaInstitucional().isSelected()){
            int llamadacodigo = ldb.obtenerIdllamada();
            int motivo=m.obteMotivId("Violencia Intitucional");
        xml= new x_motivo_llamada(llamadacodigo, motivo,"");
        xmldb.insertar_x_motivo_llamada(xml);
        }
        if(vista.getCbAlivioyApoyo().isSelected()){
            int llamadacodigo = ldb.obtenerIdllamada();
            int motivo=m.obteMotivId("Alivio y apoyo");
        xml= new x_motivo_llamada(llamadacodigo, motivo,"");
        xmldb.insertar_x_motivo_llamada(xml);
        }
        if(vista.getCbInformacionCasadeAcojida().isSelected()){
            int llamadacodigo = ldb.obtenerIdllamada();
            int motivo=m.obteMotivId("Información sobre la casa de acogida");
        xml= new x_motivo_llamada(llamadacodigo, motivo,"");
        xmldb.insertar_x_motivo_llamada(xml);
        }
        if(vista.getCbAbusoSexual().isSelected()){
            int llamadacodigo = ldb.obtenerIdllamada();
            int motivo=m.obteMotivId("Abuso sexual");
        xml= new x_motivo_llamada(llamadacodigo, motivo,"");
        xmldb.insertar_x_motivo_llamada(xml);
        }
        if(vista.getCbViolenciaSocial().isSelected()){
            int llamadacodigo = ldb.obtenerIdllamada();
            int motivo=m.obteMotivId("Violencia social");
        xml= new x_motivo_llamada(llamadacodigo, motivo,"");
        xmldb.insertar_x_motivo_llamada(xml);
        }
         if(vista.getCbAtencionPsicologica().isSelected()){
            int llamadacodigo = ldb.obtenerIdllamada();
            int motivo=m.obteMotivId("Atención psicológica");
        xml= new x_motivo_llamada(llamadacodigo, motivo,"");
        xmldb.insertar_x_motivo_llamada(xml);
        }
        if(vista.getCbInformacionOtrasInstituciones().isSelected()){
            int llamadacodigo = ldb.obtenerIdllamada();
            int motivo=m.obteMotivId("Información sobre otras instituciones");
        xml= new x_motivo_llamada(llamadacodigo, motivo,"");
        xmldb.insertar_x_motivo_llamada(xml);
        }
        if(vista.getCbViolacion().isSelected()){
            int llamadacodigo = ldb.obtenerIdllamada();
            int motivo=m.obteMotivId("Violación");
        xml= new x_motivo_llamada(llamadacodigo, motivo,"");
        xmldb.insertar_x_motivo_llamada(xml);
        }
        if(vista.getCbAccesoriaLegal().isSelected()){
            int llamadacodigo = ldb.obtenerIdllamada();
            int motivo=m.obteMotivId("Asesoria legal");
        xml= new x_motivo_llamada(llamadacodigo, motivo,"");
        xmldb.insertar_x_motivo_llamada(xml);
        }
        if(vista.getCbIntentoSuicidio().isSelected()){
            int llamadacodigo = ldb.obtenerIdllamada();
            int motivo=m.obteMotivId("Intento de suicidio");
        xml= new x_motivo_llamada(llamadacodigo, motivo,"");
        xmldb.insertar_x_motivo_llamada(xml);
        }
        if(vista.getCbNoReporta().isSelected()){
            int llamadacodigo = ldb.obtenerIdllamada();
            int motivo=m.obteMotivId("No reporta");
        xml= new x_motivo_llamada(llamadacodigo, motivo,"");
        xmldb.insertar_x_motivo_llamada(xml);
        }
        if(!vista.getTxtOtrosMotivoLlamada().equals("")){
            int llamadacodigo = ldb.obtenerIdllamada();
            int motivo=m.obteMotivId("Otra");
        xml= new x_motivo_llamada(llamadacodigo, motivo,vista.getTxtOtrosMotivoLlamada().getText());
        xmldb.insertar_x_motivo_llamada(xml);
        }
        
        
    }

    public void insertarCaracteristicasViolencia() throws SQLException, ParseException {
        Caracteristicas_violenciaDB c = new Caracteristicas_violenciaDB();
        x_caracteristicas_agresorDB xc = new x_caracteristicas_agresorDB();
        x_caracteristicas_agresor xcv;
        LlamadaDB ldb = new LlamadaDB();
        if (vista.getCbFisica().isSelected()) {
            int re = c.obtenerCaracteristicaId("Física");
            int llamadacodigo = ldb.obtenerIdllamada();
            xcv = new x_caracteristicas_agresor(llamadacodigo, "", "", re);
            xc.isertarRegistroCaracteristica(xcv);
        }
        if (vista.getCbPsicologica().isSelected()) {
            int re = c.obtenerCaracteristicaId("Psicológica");
            int llamadacodigo = ldb.obtenerIdllamada();
            xcv = new x_caracteristicas_agresor(llamadacodigo, "", "", re);
            xc.isertarRegistroCaracteristica(xcv);
        }
        if (vista.getCbLaboral().isSelected()) {
            int re = c.obtenerCaracteristicaId("Laboral");
            int llamadacodigo = ldb.obtenerIdllamada();
            xcv = new x_caracteristicas_agresor(llamadacodigo, "", "", re);
            xc.isertarRegistroCaracteristica(xcv);
        }
        if (vista.getCbEconomica().isSelected()) {
            int re = c.obtenerCaracteristicaId("Económica");
            int llamadacodigo = ldb.obtenerIdllamada();
            xcv = new x_caracteristicas_agresor(llamadacodigo, "", "", re);
            xc.isertarRegistroCaracteristica(xcv);
        }
        if (vista.getCbNegligencia().isSelected()) {
            int re = c.obtenerCaracteristicaId("Negligencia");
            int llamadacodigo = ldb.obtenerIdllamada();
            xcv = new x_caracteristicas_agresor(llamadacodigo, "", "", re);
            xc.isertarRegistroCaracteristica(xcv);
        }
        if (!vista.getTxtOtro_tipo_violencia().equals("")) {
            int re = c.obtenerCaracteristicaIdOtros("Tipo de Violencia");
            int llamadacodigo = ldb.obtenerIdllamada();
            xcv = new x_caracteristicas_agresor(llamadacodigo, "", vista.getTxtOtro_tipo_violencia().getText(), re);
            xc.isertarRegistroCaracteristica(xcv);
        }
        if (vista.getCbNoReportaTipoViolencia().isSelected()) {
            int re = c.obtenerCaracteristicaIdNoreporta("Tipo de Violencia");
            int llamadacodigo = ldb.obtenerIdllamada();
            xcv = new x_caracteristicas_agresor(llamadacodigo, "", "", re);
            xc.isertarRegistroCaracteristica(xcv);
        }
        if (vista.getCbEsposo().isSelected()) {
            int re = c.obtenerCaracteristicaId("Esposo");
            int llamadacodigo = ldb.obtenerIdllamada();
            xcv = new x_caracteristicas_agresor(llamadacodigo, "", "", re);
            xc.isertarRegistroCaracteristica(xcv);
        }
        if (vista.getCbPadre_Madre().isSelected()) {
            int re = c.obtenerCaracteristicaId("Padre/Madre");
            int llamadacodigo = ldb.obtenerIdllamada();
            xcv = new x_caracteristicas_agresor(llamadacodigo, "", "", re);
            xc.isertarRegistroCaracteristica(xcv);
        }
        if (vista.getCbNovio().isSelected()) {
            int re = c.obtenerCaracteristicaId("Novio");
            int llamadacodigo = ldb.obtenerIdllamada();
            xcv = new x_caracteristicas_agresor(llamadacodigo, "", "", re);
            xc.isertarRegistroCaracteristica(xcv);
        }
        if (vista.getCbExPareja().isSelected()) {
            int re = c.obtenerCaracteristicaId("Ex pareja");
            int llamadacodigo = ldb.obtenerIdllamada();
            xcv = new x_caracteristicas_agresor(llamadacodigo, "", "", re);
            xc.isertarRegistroCaracteristica(xcv);
        }
        if (vista.getCbHijo().isSelected()) {
            int re = c.obtenerCaracteristicaId("Hijo");
            int llamadacodigo = ldb.obtenerIdllamada();
            xcv = new x_caracteristicas_agresor(llamadacodigo, "", "", re);
            xc.isertarRegistroCaracteristica(xcv);
        }
        if (vista.getCbJefe().isSelected()) {
            int re = c.obtenerCaracteristicaId("Jefe");
            int llamadacodigo = ldb.obtenerIdllamada();
            xcv = new x_caracteristicas_agresor(llamadacodigo, "", "", re);
            xc.isertarRegistroCaracteristica(xcv);
        }
        if (!vista.getTxtOtrosQuienEsElAgresor().equals("")) {
            int re = c.obtenerCaracteristicaIdOtros("¿Quién es el agresor?");
            int llamadacodigo = ldb.obtenerIdllamada();
            xcv = new x_caracteristicas_agresor(llamadacodigo, "", vista.getTxtOtrosQuienEsElAgresor().getText(), re);
            xc.isertarRegistroCaracteristica(xcv);
        }
        if (vista.getCbNoReportaQuienEsElAgresor().isSelected()) {
            int re = c.obtenerCaracteristicaIdNoreporta("¿Quién es el agresor?");
            int llamadacodigo = ldb.obtenerIdllamada();
            xcv = new x_caracteristicas_agresor(llamadacodigo, "", "", re);
            xc.isertarRegistroCaracteristica(xcv);
        }
        if (vista.getCbAlcolismo().isSelected()) {
            int re = c.obtenerCaracteristicaId("Alcoholismo");
            int llamadacodigo = ldb.obtenerIdllamada();
            xcv = new x_caracteristicas_agresor(llamadacodigo, "", "", re);
            xc.isertarRegistroCaracteristica(xcv);
        }
        if (vista.getCbMigracion().isSelected()) {
            int re = c.obtenerCaracteristicaId("Migracíon");
            int llamadacodigo = ldb.obtenerIdllamada();
            xcv = new x_caracteristicas_agresor(llamadacodigo, "", "", re);
            xc.isertarRegistroCaracteristica(xcv);
        }
        if (vista.getCbCelos().isSelected()) {
            int re = c.obtenerCaracteristicaId("Celos");
            int llamadacodigo = ldb.obtenerIdllamada();
            xcv = new x_caracteristicas_agresor(llamadacodigo, "", "", re);
            xc.isertarRegistroCaracteristica(xcv);
        }
        if (vista.getCbDesempleo().isSelected()) {
            int re = c.obtenerCaracteristicaId("Desempleo");
            int llamadacodigo = ldb.obtenerIdllamada();
            xcv = new x_caracteristicas_agresor(llamadacodigo, "", "", re);
            xc.isertarRegistroCaracteristica(xcv);
        }
        if (vista.getCbInfidelidad().isSelected()) {
            int re = c.obtenerCaracteristicaId("Infidelidad");
            int llamadacodigo = ldb.obtenerIdllamada();
            xcv = new x_caracteristicas_agresor(llamadacodigo, "", "", re);
            xc.isertarRegistroCaracteristica(xcv);
        }
        if (vista.getCbMachismo().isSelected()) {
            int re = c.obtenerCaracteristicaId("Machismo");
            int llamadacodigo = ldb.obtenerIdllamada();
            xcv = new x_caracteristicas_agresor(llamadacodigo, "", "", re);
            xc.isertarRegistroCaracteristica(xcv);
        }
        if (!vista.getTxtOtrosFactoresRiesgo().equals("")) {
            int re = c.obtenerCaracteristicaIdOtros("Factores de Riesgo");
            int llamadacodigo = ldb.obtenerIdllamada();
            xcv = new x_caracteristicas_agresor(llamadacodigo, "", vista.getTxtOtrosQuienEsElAgresor().getText(), re);
            xc.isertarRegistroCaracteristica(xcv);
        }
        if (vista.getCbNoReportaFactoresRiesgo().isSelected()) {
            int re = c.obtenerCaracteristicaIdNoreporta("Factores de Riesgo");
            int llamadacodigo = ldb.obtenerIdllamada();
            xcv = new x_caracteristicas_agresor(llamadacodigo, "", "", re);
            xc.isertarRegistroCaracteristica(xcv);
        }
        if (vista.getCbFracturas().isSelected()) {
            int re = c.obtenerCaracteristicaId("Fracturas");
            int llamadacodigo = ldb.obtenerIdllamada();
            xcv = new x_caracteristicas_agresor(llamadacodigo, "", "", re);
            xc.isertarRegistroCaracteristica(xcv);
        }
        if (vista.getCbMoretones().isSelected()) {
            int re = c.obtenerCaracteristicaId("Moretones");
            int llamadacodigo = ldb.obtenerIdllamada();
            xcv = new x_caracteristicas_agresor(llamadacodigo, "", "", re);
            xc.isertarRegistroCaracteristica(xcv);
        }
        if (vista.getCbHeridas().isSelected()) {
            int re = c.obtenerCaracteristicaId("Heridas");
            int llamadacodigo = ldb.obtenerIdllamada();
            xcv = new x_caracteristicas_agresor(llamadacodigo, "", "", re);
            xc.isertarRegistroCaracteristica(xcv);
        }
        if (vista.getCbAbortos().isSelected()) {
            int re = c.obtenerCaracteristicaId("Abortos");
            int llamadacodigo = ldb.obtenerIdllamada();
            xcv = new x_caracteristicas_agresor(llamadacodigo, "", "", re);
            xc.isertarRegistroCaracteristica(xcv);
        }
        if (vista.getCbContagiosETS().isSelected()) {
            int re = c.obtenerCaracteristicaId("Contagios ETS");
            int llamadacodigo = ldb.obtenerIdllamada();
            xcv = new x_caracteristicas_agresor(llamadacodigo, "", "", re);
            xc.isertarRegistroCaracteristica(xcv);
        }
        if (vista.getCbAlt_Nerviosas().isSelected()) {
            int re = c.obtenerCaracteristicaId("Alt. Nerviosas");
            int llamadacodigo = ldb.obtenerIdllamada();
            xcv = new x_caracteristicas_agresor(llamadacodigo, "", "", re);
            xc.isertarRegistroCaracteristica(xcv);
        }
        if (vista.getCbBajaAutoestima().isSelected()) {
            int re = c.obtenerCaracteristicaId("Baja autoestima");
            int llamadacodigo = ldb.obtenerIdllamada();
            xcv = new x_caracteristicas_agresor(llamadacodigo, "", "", re);
            xc.isertarRegistroCaracteristica(xcv);
        }
        if (vista.getCbDepresion().isSelected()) {
            int re = c.obtenerCaracteristicaId("Depresíon");
            int llamadacodigo = ldb.obtenerIdllamada();
            xcv = new x_caracteristicas_agresor(llamadacodigo, "", "", re);
            xc.isertarRegistroCaracteristica(xcv);
        }
        if (vista.getCbEmbarazoNoDeseado().isSelected()) {
            int re = c.obtenerCaracteristicaId("Embarazo no deseado");
            int llamadacodigo = ldb.obtenerIdllamada();
            xcv = new x_caracteristicas_agresor(llamadacodigo, "", "", re);
            xc.isertarRegistroCaracteristica(xcv);
        }
        if (!vista.getTxtOtroConsecienciasFisicas().equals("")) {
            int re = c.obtenerCaracteristicaIdOtros("Concecuencias Físicas de la Agresíon");
            int llamadacodigo = ldb.obtenerIdllamada();
            xcv = new x_caracteristicas_agresor(llamadacodigo, "", vista.getTxtOtrosQuienEsElAgresor().getText(), re);
            xc.isertarRegistroCaracteristica(xcv);
        }
        if (vista.getCbNoReportaConcecuenciasFisicas().isSelected()) {
            int re = c.obtenerCaracteristicaIdNoreporta("Concecuencias Físicas de la Agresíon");
            int llamadacodigo = ldb.obtenerIdllamada();
            xcv = new x_caracteristicas_agresor(llamadacodigo, "", "", re);
            xc.isertarRegistroCaracteristica(xcv);
        }

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
    //variables globales para el metodo de resultados()
    int llamadacodigoId = 0;
    int resultado = 0;
    String descripcion = "";

    public void resultados() throws SQLException {
        LlamadaDB llama = new LlamadaDB();
        x_resultado_llamadaDB xrldb = new x_resultado_llamadaDB();
        llamadacodigoId = llama.obtenerIdllamada();

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

        String nombre = "", apellido = "", edad, direccion, estado_civil, nacionalidad, comosupollamada;
        int numerohijos = 0;
        boolean trabaja = true;
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
            Persona_llamada pl = new Persona_llamada(nombre, apellido, direccion, nacionalidad, edad, estado_civil, numerohijos, comosupollamada, trabaja);
            persona_llamadaDB pldb = new persona_llamadaDB();
            pldb.ingresarPersona_llamada(pl);
        } catch (Exception e) {
        }

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
