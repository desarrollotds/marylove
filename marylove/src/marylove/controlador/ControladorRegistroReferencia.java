package marylove.controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import marylove.DBmodelo.AgresorDB;
import marylove.DBmodelo.Ayuda_anteriorDB;
import marylove.DBmodelo.Caracteristicas_violenciaDB;
import marylove.DBmodelo.CitaDB;
import marylove.DBmodelo.ContactoEmergenciaDB;
import marylove.DBmodelo.DireccionDB;
import marylove.DBmodelo.DireccionPersonaDB;
import marylove.DBmodelo.HijosDB;
import marylove.DBmodelo.Registro_referenciaDB;
import marylove.DBmodelo.jsonDB;
import marylove.DBmodelo.personaDB;
import marylove.DBmodelo.persona_llamadaDB;
import marylove.DBmodelo.victimaDB;
import marylove.DBmodelo.x_detalle_violenciaDB;
import marylove.DBmodelo.x_registro_agresorDB;
import marylove.models.Json_object_consulta;
import marylove.models.Persona;
import marylove.models.Persona_llamada;
import marylove.vista.Ficharegistroyreferencia;
import marylove.vista.FormaAgregarAgresores;
import marylove.vista.FormaAgregarHijos;
import marylove.vista.VistaConsultaPersona;
import org.json.simple.parser.ParseException;

/**
 *
 * @author Unos conejos muy sospechosos
 */
public class ControladorRegistroReferencia extends Validaciones implements ActionListener, ItemListener {

    Ficharegistroyreferencia v;

    //variables globales para los metodos
    persona_llamadaDB pldb;
    DefaultComboBoxModel modelo;
    ArrayList<Json_object_consulta> jocarray;
    jsonDB jo = new jsonDB();
    AgresorDB adb;
    HijosDB hdb;
    personaDB pdb;
    victimaDB vdb;
    DireccionDB ddb;
    DireccionPersonaDB dpdb;
    ContactoEmergenciaDB cedb;
    Registro_referenciaDB rrdb;
    Caracteristicas_violenciaDB cvdb;
    Ayuda_anteriorDB aadb;
    CitaDB cdb;
    ControladorAgregarAgresores caa;
    ArrayList<Persona> personaescogida;
    ArrayList<Persona_llamada> lista;
    x_registro_agresorDB xradb;
    x_detalle_violenciaDB xdvdb;
    boolean agrecon;
    boolean lineapoyo;
//variables staticas fotando en el programa
    DefaultTableModel tabla;
    //variables staticas de la clase
    private static String esta_persona_guarda = "nueva";

    public ControladorRegistroReferencia(Ficharegistroyreferencia v) throws Exception {
        this.v = v;
//        this.v.setLocationRelativeTo(null);
//        this.v.setVisible(true);
//        this.v.setResizable(false);
        validarJsons();
        this.v.getBtnAgregarAgresores().addActionListener(this);
        this.v.getBtnAgregarHijos().addActionListener(this);
        this.v.getBtnCancelar().addActionListener(this);
        this.v.getBtnGuardar().addActionListener(this);
        this.v.getBtnGuardarPersona().addActionListener(this);
        this.v.getBtn_buscar_cedula().addActionListener(this);
        this.v.getBtn_buscar_codigo().addActionListener(this);
        this.v.getBtnListadoPerReis().addActionListener(this);
        this.v.getBtnModificarPersona().addActionListener(this);
        this.v.getBtnEliminarPersona().addActionListener(this);
        this.v.getCbxInstruccion().addItemListener(this);
        //bloqueados por defecto por la ruta de citas.
//        this.v.getBtn_buscar_cedula().setEnabled(false);
        this.v.getBtn_buscar_codigo().setEnabled(false);
        this.v.getBtnListadoPerReis().setEnabled(false);
        this.v.getBtnCancelarPersona().setEnabled(false);
        this.v.getBtnEliminarPersona().setEnabled(false);
        this.v.getBtnModificarPersona().setEnabled(false);
        this.v.getBtnAgregarAgresores().setEnabled(false);
        this.v.getBtnAgregarHijos().setEnabled(false);
        //lista personas_llamadas
        pldb = new persona_llamadaDB();
        lista = pldb.lista_personas();
        //inicializacion de combos
        try {
//            validarJsons();
            comboEstadoCivil();
            comboInstruccion();
            comboNacionalidad();
            comboOcupacion();
            comboParentesco();
            comboEstadoMigratorio();

        } catch (ParseException px) {
            System.out.println("error " + px.getMessage());
        }
        //tabla hijo

        this.v.getBtn_buscar_codigo().setVisible(false);
        modeloTabla();
        HijosDB hijo = new HijosDB();
        hdb.getArrayHijos().clear();
        hijo.consultaHijosVictimas();
        insertarTabla();
        //tabla agresor
        modeloTablaAgresor();
        AgresorDB agredb = new AgresorDB();
        agredb.consultaAgresorVictimas();
        insertarTablaAgresores();

        this.v.getBtnGuardar().setEnabled(false);
        //metodos iniciales
        rrdb = new Registro_referenciaDB();
        rrdb.ingresar_registro_referencia();
        // radio button posee cedula

    }

    public void modeloTablaAgresor() {
        tabla = new DefaultTableModel();
        tabla.addColumn("Cedula");
        tabla.addColumn("Nombre");
        tabla.addColumn("Apellido");
        tabla.addColumn("Fecha Nacimiento");
        tabla.addColumn("Telefono");
        tabla.addColumn("Celular");
        tabla.addColumn("Sexo");
        tabla.addColumn("Parentesco");

        this.v.getTablaAgresores().setModel(tabla);
    }

    public void modeloTabla() {
        tabla = new DefaultTableModel();
        tabla.addColumn("Cedula");
        tabla.addColumn("Nombre");
        tabla.addColumn("Apellido");
        tabla.addColumn("Sexo");
        tabla.addColumn("Fecha Nacimiento");
        this.v.getTblHijos().setModel(tabla);
//TblHijos
    }

    public void limpiarTabla() {
        try {

            int fila = tabla.getRowCount();
            for (int i = 0; i < fila; i++) {
                tabla.removeRow(0);
            }
            int cantfila = v.getTblHijos().getRowCount();
            for (int i = cantfila - 1; i >= 0; i--) {
                tabla.removeRow(i);
            }
        } catch (Exception e) {
            System.out.println("Sin Datos ");
        }

    }

    public void limpiarTablaAgresores() {
        try {

            int fila = tabla.getRowCount();
            for (int i = 0; i < fila; i++) {
                tabla.removeRow(0);
            }
            int cantfila = v.getTablaAgresores().getRowCount();
            for (int i = cantfila - 1; i >= 0; i--) {
                tabla.removeRow(i);
            }
        } catch (Exception e) {
            System.out.println("Sin Datos ");
        }

    }

    public void insertarTabla() {
        limpiarTabla();
        HijosDB hijos = new HijosDB();

        String[] datos;
        for (HijosDB elem : hdb.getArrayHijos()) {
            datos = new String[5];
            datos[0] = elem.getPersona_cedula() + "";
            datos[1] = elem.getPersona_nombre() + "";
            datos[2] = elem.getPersona_apellido() + "";
            datos[3] = elem.getPersona_sexo() + "";
            datos[4] = elem.getPersona_fecha_nac() + "";
            tabla.addRow(datos);
        }
        v.getTblHijos().setModel(tabla);

    }

    public void insertarTablaAgresores() {
        limpiarTabla();
        adb = new AgresorDB();
        adb.consultaAgresorVictimas();
        String[] datos;
        for (AgresorDB e : adb.getAgresores()) {
            datos = new String[5];
            datos[0] = e.getPersona_cedula() + "";
            datos[1] = e.getPersona_nombre() + "";
            datos[2] = e.getPersona_apellido() + "";
            datos[3] = e.getPersona_fecha_nac() + "";
            datos[4] = e.getPersona_telefono() + "";
            datos[5] = e.getPersona_celular() + "";
            datos[6] = e.getPersona_sexo() + "";
            datos[7] = e.getParentesco() + "";
            tabla.addRow(datos);
        }
        v.getTablaAgresores().setModel(tabla);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        //boton cancelar
        if (e.getSource().equals(v.getBtnCancelar())) {
            this.v.dispose();

        }
        //boton Guardar Persona
        if (e.getSource().equals(v.getBtnGuardarPersona())) {
            if (esta_persona_guarda.equals("modificar")) {

                if (validacionesPersona()) {
                    try {
                        datos_personales_modificar();
                        v.getBtnAgregarAgresores().setEnabled(true);
                        v.getBtnAgregarHijos().setEnabled(true);
                        v.getBtnEliminarPersona().setEnabled(true);
                        v.getBtnModificarPersona().setEnabled(true);
                        v.getBtnCancelarPersona().setEnabled(false);
                        v.getBtnGuardarPersona().setEnabled(false);
                        v.getTxtCedula().setEditable(true);
                        v.getTxtCodigoPersona().setEditable(true);
                    } catch (SQLException ex) {
                        Logger.getLogger(ControladorRegistroReferencia.class.getName()).log(Level.SEVERE, null, ex);
                    }

                }

            }
            if (esta_persona_guarda.equals("nueva")) {

                if (validacionesPersona()) {
                    try {
                        DatosPersonales();
                    } catch (SQLException ex) {
                        Logger.getLogger(ControladorRegistroReferencia.class.getName()).log(Level.SEVERE, null, ex);
                    }
//                ID_persona_victima=pdb;
                    this.v.getBtnGuardar().setEnabled(true);
                    this.v.getBtnAgregarAgresores().setEnabled(true);
                    this.v.getBtnAgregarHijos().setEnabled(true);
                    JOptionPane.showMessageDialog(this.v, "Victima guardada correctamente. Ya puede agregar hijos!");
                }

            }
        }

        //boton  buscar_persona_codigo
        if (e.getSource().equals(v.getBtn_buscar_codigo())) {
//            try {
//                setearXcodigo();
//                v.getBtnModificarPersona().setEnabled(true);
//                v.getBtnEliminarPersona().setEnabled(true);
//                esta_persona_guarda = "modificar";
//            } catch (SQLException ex) {
//                Logger.getLogger(ControladorRegistroReferencia.class.getName()).log(Level.SEVERE, null, ex);
//            } catch (java.text.ParseException ex) {
//                Logger.getLogger(ControladorRegistroReferencia.class.getName()).log(Level.SEVERE, null, ex);
//            }
        }

        //boton buscar_persona_cedula
        if (e.getSource().equals(v.getBtn_buscar_cedula())) {
            try {
                setearXcedula();
                v.getBtnModificarPersona().setEnabled(true);
                v.getBtnEliminarPersona().setEnabled(true);
                
            } catch (SQLException ex) {
                Logger.getLogger(ControladorRegistroReferencia.class.getName()).log(Level.SEVERE, null, ex);
            } catch (java.text.ParseException ex) {
                Logger.getLogger(ControladorRegistroReferencia.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        //boton modificar persona
        if (e.getSource().equals(v.getBtnModificarPersona())) {
            v.getBtnAgregarAgresores().setEnabled(false);
            v.getBtnAgregarHijos().setEnabled(false);
            v.getBtnEliminarPersona().setEnabled(false);
            v.getBtnModificarPersona().setEnabled(false);
            v.getBtnCancelarPersona().setEnabled(true);
            v.getBtnGuardarPersona().setEnabled(true);
            v.getTxtCedula().setEditable(false);
            v.getTxtCodigoPersona().setEditable(false);
            esta_persona_guarda = "modificar";
        }

        //boton cancelar persona
        if (e.getSource().equals(v.getBtnCancelarPersona())) {
            v.getBtnAgregarAgresores().setEnabled(true);
            v.getBtnAgregarHijos().setEnabled(true);
            v.getBtnEliminarPersona().setEnabled(false);
            v.getBtnModificarPersona().setEnabled(false);
            v.getBtnCancelarPersona().setEnabled(false);
            v.getBtnGuardarPersona().setEnabled(true);
            v.getTxtCedula().setEditable(true);
            v.getTxtCodigoPersona().setEditable(true);
            JOptionPane.showMessageDialog(null, "Accion Cancelada. No necesita guardar...");

            esta_persona_guarda = "nueva";

        }
        // boton eliminar persona
        if (e.getSource().equals(v.getBtnEliminarPersona())) {
            int reply = JOptionPane.showConfirmDialog(null, "Seguro que desea eliminar a esta persona?", "Confirme", JOptionPane.YES_NO_OPTION);
            if (reply == JOptionPane.YES_OPTION) {
                pdb.eliminarPersonaCodigo();
                JOptionPane.showMessageDialog(null, "Eliminado");

            } else {
                JOptionPane.showMessageDialog(null, "Accion Cancelada");
            }

        }

        //boton listado personas registradas
        if (e.getSource().equals(v.getBtnListadoPerReis())) {
            VistaConsultaPersona o = new VistaConsultaPersona();
            ControladorBuscarPersona u = new ControladorBuscarPersona(o);
        }

        //cancelar modificacion de persona
        if (e.getSource().equals(v.getBtnCancelar())) {
            v.getBtnCancelarPersona().setEnabled(true);

        }

        //boton agregar agresores
        if (e.getSource().equals(v.getBtnAgregarAgresores())) {
            try {
                FormaAgregarAgresores faa = new FormaAgregarAgresores();
                ControladorAgregarAgresores caa = new ControladorAgregarAgresores(faa);
                faa.setVisible(true);
                faa.setLocationRelativeTo(null);
                faa.setResizable(false);
            } catch (ParseException ex) {
                Logger.getLogger(ControladorRegistroReferencia.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        //boton agregar hijos
        if (e.getSource().equals(v.getBtnAgregarHijos())) {

            try {

                FormaAgregarHijos fah = new FormaAgregarHijos();
                ControladorAgregarHijos cah = new ControladorAgregarHijos(fah);
                fah.setVisible(true);
                fah.setLocationRelativeTo(null);
                fah.setResizable(false);

            } catch (ParseException ex) {
                Logger.getLogger(ControladorRegistroReferencia.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex) {
                Logger.getLogger(ControladorRegistroReferencia.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
        //boton guardar 
        if (e.getSource().equals(v.getBtnGuardar())) {
            if (validaciones_contacto_emergencia()) {
                if (v.getTxtTelefonoAyuda().getText().matches("[0-9]*") && v.getTxtTelefonoAyuda().getText().length() <= 10) {
                    if (v.getTxtFrecuencia().getText().matches("[a-zA-Z]*")) {
                        try {
                            insertar_domicilio();
                            insertar_contacto_emerg();
                            ayuda_anterior();
                            factoresRiesgo();
                            detalle_agresion();
                            registro_refrencia_update();
                            JOptionPane.showMessageDialog(null, "Registro Guardado Exitosamente");
                            v.dispose();
                        } catch (SQLException ex) {
                            Logger.getLogger(ControladorRegistroReferencia.class.getName()).log(Level.SEVERE, null, ex);
                        } catch (ParseException ex) {
                            Logger.getLogger(ControladorRegistroReferencia.class.getName()).log(Level.SEVERE, null, ex);
                        }

                    } else {
                        JOptionPane.showMessageDialog(null, "Registro No Guardado | Caso a Registrar: campo Fecuencia de la Agresión \n(solo puede contener letras)");
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Registro No Guardado | Ayuda Anterior campo Telefono \n(solo puede contener números)");
                }
            }

        }
        //----------------------------------------------------------------------juego lineaa de apoyo
        if (v.getRbSiLlamaLineaApoyo().isSelected()) {
            v.getRbNOLlamaLineaApoyo().setEnabled(false);
        } else {
            v.getRbNOLlamaLineaApoyo().setEnabled(true);
        }
        if (v.getRbNOLlamaLineaApoyo().isSelected()) {
            v.getRbSiLlamaLineaApoyo().setEnabled(false);
        } else {
            v.getRbSiLlamaLineaApoyo().setEnabled(true);
        }
        //----------------------------------------------------------------------juego lineaa de apoyo
        if (v.getRbSiContinuaAgresion().isSelected()) {
            v.getRbNoContinuaAgresion().setEnabled(false);
        } else {
            v.getRbNoContinuaAgresion().setEnabled(true);
        }
        if (v.getRbNoContinuaAgresion().isSelected()) {
            v.getRbSiContinuaAgresion().setEnabled(false);
        } else {
            v.getRbSiContinuaAgresion().setEnabled(true);
        }
    }

    //combos-------------------------------------------------------------------
    public void comboInstruccion() throws ParseException {
        modelo = new DefaultComboBoxModel();
        jocarray = listaInstruccionAcademica;
        for (Json_object_consulta o : jocarray) {
            modelo.addElement(o.getValor());
        }
        v.getCbxInstruccion().setModel(modelo);

    }

    public void comboEstadoCivil() throws ParseException {
        modelo = new DefaultComboBoxModel();
        jocarray = listaEstadoCivil;
        for (Json_object_consulta o : jocarray) {
            modelo.addElement(o.getValor());
        }
        v.getCbxEstadoCivill().setModel(modelo);

    }

    public void comboEstadoMigratorio() throws ParseException {
        modelo = new DefaultComboBoxModel();
        jocarray = listaEstadoMigratorio;
        for (Json_object_consulta o : jocarray) {
            modelo.addElement(o.getValor());
        }
        v.getCbxEstadoMigratrorio().setModel(modelo);

    }

    public void comboOcupacion() throws ParseException {
        modelo = new DefaultComboBoxModel();
        jocarray = listaOcupaciones;
        for (Json_object_consulta o : jocarray) {
            modelo.addElement(o.getValor());
        }
        v.getCbxOcupacion().setModel(modelo);

    }

    public void comboNacionalidad() throws ParseException {
        modelo = new DefaultComboBoxModel();
        jocarray = listaNacionalidades;
        for (Json_object_consulta o : jocarray) {
            modelo.addElement(o.getValor());
        }
        v.getCbxNacionalidad().setModel(modelo);
        v.getCbxPais().setModel(modelo);
    }

    public void comboParentesco() throws ParseException {
        modelo = new DefaultComboBoxModel();
        jocarray = listaParentesco;
        for (Json_object_consulta o : jocarray) {
            modelo.addElement(o.getValor());
        }
        v.getCbxprentesco().setModel(modelo);

    }

    //metodos adicionales
    public void verificar_x_eliminar() {
        pdb = new personaDB();
        if (!this.v.getTxtCedula().getText().equals("") && this.v.getTxtCedula().getText().matches("[0-9]*") && v.getTxtCedula().getText().length() <= 13 && !v.getTxtCodigoPersona().equals("") && v.getTxtCodigoPersona().getText().matches("[0-9]*")) {

        } else {
            JOptionPane.showMessageDialog(null, "Eliminación no Realizada");
        }

    }

    //partes---------------------------------------------------------------------------
    public void DatosPersonales() throws SQLException {
        String intrucOtros = "";

        long fecha_nacimiento = v.getDcFechaNacimiento().getDate().getTime();
        Date fecha = fechaBD(fecha_nacimiento);
        int estadocivil = v.getCbxEstadoCivill().getSelectedIndex() + 1;

        char sexo = v.getCbSexo().getSelectedItem().toString().charAt(0);
        int ocupacion = v.getCbxOcupacion().getSelectedIndex() + 1;
        int nacionalidad = v.getCbxNacionalidad().getSelectedIndex() + 1;
        int nivelacademico = v.getCbxInstruccion().getSelectedIndex() + 1;
        int estamigratorio = v.getCbxEstadoMigratrorio().getSelectedIndex() + 1;

        pdb = new personaDB(v.getTxtCedula().getText(),
                v.getTxtNombrePersona().getText(), v.getTxtApellidoPersona().getText(),
                fecha, ocupacion, nivelacademico, estamigratorio,
                v.getTxtTelefonoPersona().getText(), v.getTxtCelularPersona().getText(),
                estadocivil, nacionalidad, true, sexo, v.getTxtinstruccionOtros().getText(),
                v.getTxtLugarTrabajo().getText(), v.getTxtReferencia().getText());
        pdb.ingresarPersona();
        vdb = new victimaDB(personaDB.getPersona_codigo_static(), true);
        vdb.insertarVictima();
        //pdb.modificarPersona(personaDB.getPersona_codigo_static());
    }

    public void datos_personales_modificar() throws SQLException {
        String intrucOtros = "";

        long fecha_nacimiento = v.getDcFechaNacimiento().getDate().getTime();
        Date fecha = fechaBD(fecha_nacimiento);
        int estadocivil = v.getCbxEstadoCivill().getSelectedIndex() + 1;

        char sexo = v.getCbSexo().getSelectedItem().toString().charAt(0);
        int ocupacion = v.getCbxOcupacion().getSelectedIndex() + 1;
        int nacionalidad = v.getCbxNacionalidad().getSelectedIndex() + 1;
        int nivelacademico = v.getCbxInstruccion().getSelectedIndex() + 1;
        int estamigratorio = v.getCbxEstadoMigratrorio().getSelectedIndex() + 1;

        pdb = new personaDB(v.getTxtCedula().getText(),
                v.getTxtNombrePersona().getText(), v.getTxtApellidoPersona().getText(),
                fecha, ocupacion, nivelacademico, estamigratorio,
                v.getTxtTelefonoPersona().getText(), v.getTxtCelular().getText(),
                estadocivil, nacionalidad, true, sexo, v.getTxtinstruccionOtros().getText(),
                v.getTxtLugarTrabajo().getText(), v.getTxtReferencia().getText());
        pdb.modificarPersona(personaDB.getPersona_codigo_static());
        vdb = new victimaDB(personaDB.getPersona_codigo_static(), true);
        vdb.insertarVictima();
    }

    public void insertar_contacto_emerg() throws SQLException {
        pdb = new personaDB("", v.getTxtNombreContacto().getText(),
                v.getTxtApellidoContacto().getText(),
                v.getTxtTelefonoContacto().getText(),
                v.getTxtCelularContacto().getText());
        pdb.ingresarPersonaContacEmerg();
        cedb = new ContactoEmergenciaDB(v.getCbxprentesco().getSelectedItem().toString(),
                personaDB.getPersona_cont_emerg_static(),
                personaDB.getPersona_codigo_static(),
                v.getTxtDomicilioContacto().getText());

    }

    public void insertar_domicilio() throws SQLException {
        ddb = new DireccionDB(v.getTxtCalle().getText(), v.getTxtInterseccion().getText(),
                v.getTxtNumeroCasa().getText(), v.getTxtBarrio().getText(),
                v.getTxtParroquia().getText(), v.getTxtCiudad().getText(),
                v.getTxtReferencia().getText(), v.getTxtProvincia().getText(),
                v.getCbxPais().getSelectedItem().toString(), true);
        ddb.insertaDireccion();
        dpdb = new DireccionPersonaDB(personaDB.getPersona_codigo_static(), DireccionDB.getDireccion_codigo_static());
        dpdb.insertarDireccionD();
    }

    public void regsitroReferencia() {
        cdb = new CitaDB();
        if (v.getRbSiContinuaAgresion().isSelected()) {
            agrecon = true;
        } else {
            agrecon = false;
        }
        if (v.getRbSiLlamaLineaApoyo().isSelected()) {
            lineapoyo = true;
        } else {
            lineapoyo = false;
        }
        rrdb = new Registro_referenciaDB(victimaDB.getCodigo_victima_static(),
                v.getTaEvidencias().getText(), CitaDB.getCita_codigo_insert(),
                Ayuda_anteriorDB.getAyuda_anterior_static(), agrecon, lineapoyo,
                v.getTxtFrecuencia().getText());

    }

    public void ayuda_anterior() throws SQLException {//antes de registro y referencia

        aadb = new Ayuda_anteriorDB(v.getTxtNombreAyuda().getText(), v.getTxtTelefonoAyuda().getText(),
                v.getTxtConsulta().getText(), v.getTxtAtencion().getText(), v.getTxtContactoAyuda().getText());
        aadb.insertarAyudaAnterior();

    }

    public void factoresRiesgo() throws SQLException, ParseException {
        cvdb = new Caracteristicas_violenciaDB();
        xradb = new x_registro_agresorDB();

        if (v.getChkAlcoholismo().isSelected()) {
            int cid = cvdb.obtener_id("Alcoholismo", 6);
            xdvdb = new x_detalle_violenciaDB(x_registro_agresorDB.getRegistro_agresor_static(), cid, "");
            xdvdb.ingresar_detalle_violencia();
        }
        if (v.getChkDesempleo().isSelected()) {
            int cid = cvdb.obtener_id("Desempleo", 6);
            xdvdb = new x_detalle_violenciaDB(x_registro_agresorDB.getRegistro_agresor_static(), cid, "");
            xdvdb.ingresar_detalle_violencia();
        }
        if (v.getChkCelos().isSelected()) {
            int cid = cvdb.obtener_id("Celos", 6);
            xdvdb = new x_detalle_violenciaDB(x_registro_agresorDB.getRegistro_agresor_static(), cid, "");
            xdvdb.ingresar_detalle_violencia();
        }
        if (v.getChkInfidelidad().isSelected()) {
            int cid = cvdb.obtener_id("Infidelidad", 6);
            xdvdb = new x_detalle_violenciaDB(x_registro_agresorDB.getRegistro_agresor_static(), cid, "");
            xdvdb.ingresar_detalle_violencia();
        }
        if (v.getChkMigracion().isSelected()) {
            int cid = cvdb.obtener_id("Migración", 6);
            xdvdb = new x_detalle_violenciaDB(x_registro_agresorDB.getRegistro_agresor_static(), cid, "");
            xdvdb.ingresar_detalle_violencia();
        }
        if (v.getChkDrogas().isSelected()) {
            int cid = cvdb.obtener_id("Drogas", 6);
            xdvdb = new x_detalle_violenciaDB(x_registro_agresorDB.getRegistro_agresor_static(), cid, "");
            xdvdb.ingresar_detalle_violencia();
        }
        if (!v.getTxtOtrosFactores().getText().equals("")) {
            int cid = cvdb.obtener_id("Otra", 6);
            xdvdb = new x_detalle_violenciaDB(x_registro_agresorDB.getRegistro_agresor_static(), cid, v.getTxtOtrosFactores().getText());
            xdvdb.ingresar_detalle_violencia();
        }
    }

    public void detalle_agresion() throws SQLException, ParseException {

        //Detalle de la Agresión
        cvdb = new Caracteristicas_violenciaDB();
        xradb = new x_registro_agresorDB();
        if (v.getChkFisica().isSelected()) {
            int cid = cvdb.obtener_id("Física", 5);
            xdvdb = new x_detalle_violenciaDB(x_registro_agresorDB.getRegistro_agresor_static(), cid, "");
            xdvdb.ingresar_detalle_violencia();
        }
        if (v.getChkPsicologica().isSelected()) {
            int cid = cvdb.obtener_id("Psicológica", 5);
            xdvdb = new x_detalle_violenciaDB(x_registro_agresorDB.getRegistro_agresor_static(), cid, "");
            xdvdb.ingresar_detalle_violencia();
        }
        if (v.getChkSexual().isSelected()) {
            int cid = cvdb.obtener_id("Sexual", 5);
            xdvdb = new x_detalle_violenciaDB(x_registro_agresorDB.getRegistro_agresor_static(), cid, "");
            xdvdb.ingresar_detalle_violencia();
        }
        if (v.getChkAcoso().isSelected()) {
            int cid = cvdb.obtener_id("Acoso", 5);
            xdvdb = new x_detalle_violenciaDB(x_registro_agresorDB.getRegistro_agresor_static(), cid, "");
            xdvdb.ingresar_detalle_violencia();
        }
        if (v.getChkOmision().isSelected()) {
            int cid = cvdb.obtener_id("Omisión", 5);
            xdvdb = new x_detalle_violenciaDB(x_registro_agresorDB.getRegistro_agresor_static(), cid, "");
            xdvdb.ingresar_detalle_violencia();
        }
        if (v.getChkViolacion().isSelected()) {
            int cid = cvdb.obtener_id("Violación", 5);
            xdvdb = new x_detalle_violenciaDB(x_registro_agresorDB.getRegistro_agresor_static(), cid, "");
            xdvdb.ingresar_detalle_violencia();
        }
        if (v.getChkEconomica().isSelected()) {
            int cid = cvdb.obtener_id("Económica", 5);
            xdvdb = new x_detalle_violenciaDB(x_registro_agresorDB.getRegistro_agresor_static(), cid, "");
            xdvdb.ingresar_detalle_violencia();
        }
        if (v.getChkIntimidacion().isSelected()) {
            int cid = cvdb.obtener_id("Intimidación", 5);
            xdvdb = new x_detalle_violenciaDB(x_registro_agresorDB.getRegistro_agresor_static(), cid, "");
            xdvdb.ingresar_detalle_violencia();
        }
        if (!v.getTxtOtrosCasos().getText().equals("")) {
            int cid = cvdb.obtener_id("Otra", 5);
            xdvdb = new x_detalle_violenciaDB(x_registro_agresorDB.getRegistro_agresor_static(), cid, v.getTxtOtrosFactores().getText());
            xdvdb.ingresar_detalle_violencia();
        }

    }

    public void registro_refrencia_update() {

        boolean agresion_continua = false;
        if (v.getRbSiContinuaAgresion().isSelected()) {
            agresion_continua = true;
        }
        if (v.getRbNoContinuaAgresion().isSelected()) {
            agresion_continua = false;
        }
        boolean linea = false;
        if (v.getRbSiLlamaLineaApoyo().isSelected()) {
            linea = true;
        }
        if (v.getRbNOLlamaLineaApoyo().isSelected()) {
            linea = false;
        }

        rrdb = new Registro_referenciaDB(victimaDB.getCodigo_victima_static(),
                v.getTaEvidencias().getText(), CitaDB.getCita_codigo_insert(),
                Ayuda_anteriorDB.getAyuda_anterior_static(), agresion_continua, linea,
                v.getTxtFrecuencia().getText());
        rrdb.registr_referencia_update(Registro_referenciaDB.getRegistro_referencia_static());

    }

    public void setearXcodigo() throws SQLException, java.text.ParseException {
        pdb = new personaDB();
        System.out.println(v.getTxtCodigoPersona().getText());
        if (v.getTxtCodigoPersona().getText().matches("[0-9]*")) {
            System.out.println(v.getTxtCodigoPersona().getText());
            String p = v.getTxtCodigoPersona().getText();

            //validacion de nulo
            if (pdb.obtenerPersonaCodigo(p) != null) {
                personaescogida = pdb.obtenerPersonaCodigo(p);
                for (Persona o : personaescogida) {
                    String rei = v.getTxtCodigoPersona().getText();
                    int cod = Integer.parseInt(rei);
                    if (o.getPersona_codigo() == cod) {
                        v.getTxtCedula().setText(o.getPersona_cedula());
                        //nombre
                        v.getTxtNombrePersona().setText(o.getPersona_nombre());
                        //apellido
                        v.getTxtApellidos().setText(o.getPersona_apellido());
                        //fecha de nacimiento
                        java.util.Date date2 = new SimpleDateFormat("yyyy-MM-dd").parse(o.getPersona_fecha_nac().toString());
                        v.getDcFechaNacimiento().setDate(date2);
                        //estado civil
                        v.getCbxEstadoCivill().setSelectedIndex(o.getPersona_estadocivil());
                        //i=nivel academico/instruccion
                        if (o.getPersona_nivel_acad() == 7) {
                            v.getCbxInstruccion().setSelectedIndex(o.getPersona_nivel_acad());
                            v.getTxtinstruccionOtros().setText(o.getPersona_nivel_acad_otros());
                        } else {
                            v.getCbxInstruccion().setSelectedIndex(o.getPersona_nivel_acad());
                        }
                        //lugar de trabajo
                        v.getTxtLugarTrabajo().setText(o.getPersona_lugar_trabajo());
                        //referencia
                        v.getTxtReferencia().setText(o.getPersona_referencia());
                        //estado migratorio
                        v.getCbxEstadoMigratrorio().setSelectedIndex(o.getPersona_est_migr());
                        //sexo
                        switch (o.getPersona_sexo()) {
                            case 'F':
                                v.getCbSexo().setSelectedIndex(0);
                                break;
                            case 'M':
                                v.getCbSexo().setSelectedIndex(1);
                                break;
                            case '?':
                                v.getCbSexo().setSelectedIndex(2);
                                break;

                        }
                        //ocupacion
                        v.getCbxOcupacion().setSelectedIndex(o.getPersona_ocupacion());
                        //nacionalidad
                        v.getCbxNacionalidad().setSelectedIndex(o.getPersona_nacionalidad());
                        //celular
                        v.getTxtCelularPersona().setText(o.getPersona_celular());
                        //telefono
                        v.getTxtTelefonoPersona().setText(o.getPersona_telefono());

                    }

                }

            } else {
                JOptionPane.showMessageDialog(v, "Persona no registrada...");
            }
        } else {
            JOptionPane.showMessageDialog(v, "Ingreso: Solo numeros...");
        }

    }

    public void setearXcedula() throws SQLException, java.text.ParseException {

        // Con caja de texto
        String seleccion = v.getTxtCedula().getText();
        pdb = new personaDB();
        
        int c = 0;
        //validacion nulo
        if (v.txtCedula.getText() != null) {

            for (Persona_llamada o : lista) {
                if (seleccion.equals(o.getPer_cedu_cod())) {
                    v.getTxtNombrePersona().setText(o.getPer_nombre());
                    v.getTxtApellidoPersona().setText(o.getPer_apellido());
                    v.getCbxNacionalidad().setSelectedItem(o.getPer_nacionalidad());
                    v.getCbxEstadoCivill().setSelectedItem(o.getPer_estado_civil());
                    

                } else {
                    c++;
                }

            }
            if (c == lista.size()) {
                JOptionPane.showMessageDialog(null, "Cedula/Codigo no registrado...\n(asegúrese que no lleve espacion espacios)");
                
            } else {
                esta_persona_guarda = "modificar";
            }
        }

    }

    public boolean validacionesPersona() {

        if (v.getTxtCedula().getText().matches("[0-9]*")) {
            if (v.getDcFechaNacimiento() != null) {
                if (v.getTxtCedula().getText().matches("[0-9]*") && v.getTxtCedula().getText().length() == 10) {
                    if (!v.getTxtApellidoPersona().getText().matches("[0-9]*")) {
                        if (!v.getTxtNombrePersona().getText().matches("[0-9]*")) {
                            if (v.getTxtTelefonoPersona().getText().matches("[0-9]*")) {
                                if (v.getTxtCelularPersona().getText().matches("[0-9]*")) {
                                    return true;
                                } else {
                                    JOptionPane.showMessageDialog(v, "Celular invalido--Ingreso: solo letras");
                                    v.getTxtCelularPersona().setText("");
                                    return false;
                                }
                            } else {
                                JOptionPane.showMessageDialog(v, "Telefono invalido--Ingreso: solo letras");
                                v.getTxtTelefonoPersona().setText("");
                                return false;
                            }

                        } else {
                            JOptionPane.showMessageDialog(v, "Nombre invalido--Ingreso: solo letras");
                            v.getTxtNombrePersona().setText("");
                            return false;
                        }
                    } else {
                        JOptionPane.showMessageDialog(v, "Apellido invalido--Ingreso: solo letras");
                        v.getTxtApellidoPersona().setText("");
                        return false;
                    }
                } else {
                    JOptionPane.showMessageDialog(v, "Cedula/Codigo invalido--Ingreso: solo números");
                    v.getTxtCelular().setText("");
                    return false;
                }
            } else {
                JOptionPane.showMessageDialog(v, "Ingrese una fecha");
                return false;
            }
        } else {
            JOptionPane.showMessageDialog(v, "Ingreso: solo números");
            v.getTxtCedula().setText("");
            return false;
        }

    }

    public boolean validar_persona_codigo() {

        if (v.getDcFechaNacimiento() != null) {
            if (v.getTxtCedula().getText().length() == 10) {
                if (!v.getTxtApellidoPersona().getText().matches("[0-9]*")) {
                    if (!v.getTxtNombrePersona().getText().matches("[0-9]*")) {
                        if (v.getTxtTelefonoPersona().getText().matches("[0-9]*")) {
                            if (v.getTxtCelularPersona().getText().matches("[0-9]*")) {
                                return true;
                            } else {
                                JOptionPane.showMessageDialog(v, "Celular invalido--Ingreso: solo letras");
                                v.getTxtCelularPersona().setText("");
                                return false;
                            }
                        } else {
                            JOptionPane.showMessageDialog(v, "Telefono invalido--Ingreso: solo letras");
                            v.getTxtTelefonoPersona().setText("");
                            return false;
                        }

                    } else {
                        JOptionPane.showMessageDialog(v, "Nombre invalido--Ingreso: solo letras");
                        v.getTxtNombrePersona().setText("");
                        return false;
                    }
                } else {
                    JOptionPane.showMessageDialog(v, "Apellido invalido--Ingreso: solo letras");
                    v.getTxtApellidoPersona().setText("");
                    return false;
                }
            } else {
                JOptionPane.showMessageDialog(v, "Cedula/Codigo invalido--Ingreso: 10 dijitos");
                v.getTxtCelular().setText("");
                return false;
            }
        } else {
            JOptionPane.showMessageDialog(v, "Ingrese una fecha");
            return false;
        }

    }

    public boolean validaciones_contacto_emergencia() {

        if (v.getTxtNombreContacto().getText().matches("[a-zA-Z]*")) {
            if (v.getTxtApellidoContacto().getText().matches("[a-zA-Z]*")) {
                if (v.getTxtTelefonoContacto().getText().matches("[0-9]*") && v.getTxtTelefonoContacto().getText().length() <= 10) {
                    if (v.getTxtCelularContacto().getText().matches("[0-9]*") && v.getTxtCelularContacto().getText().length() == 10) {
                        return true;
                    } else {
                        JOptionPane.showMessageDialog(null, "Contacto de Emergencia: campo Celular (solo puede contener números)");
                        return false;
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Contacto de Emergencia: campo Telefono/Fijo (solo puede contener números)");
                    return false;
                }
            } else {
                JOptionPane.showMessageDialog(null, "Contacto de Emergencia: campo Apellido (solo puede contener letras)");
                return false;
            }
        } else {
            JOptionPane.showMessageDialog(null, "Contacto de Emergencia: campo Nombre (solo puede contener letras)");
            return false;
        }

    }

    @Override
    public void itemStateChanged(ItemEvent e) {

        if (e.getItem().equals("Otra")) {
            v.getTxtinstruccionOtros().setEnabled(true);
        } else {
            v.getTxtinstruccionOtros().setEnabled(true);
            v.getTxtinstruccionOtros().setText("");
        }

    }

}
