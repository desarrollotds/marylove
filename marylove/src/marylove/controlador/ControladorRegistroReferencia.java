/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package marylove.controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import marylove.DBmodelo.ContactoEmergenciaDB;
import marylove.DBmodelo.DireccionDB;
import marylove.DBmodelo.DireccionPersonaDB;
import marylove.DBmodelo.HijosDB;
import marylove.DBmodelo.jsonDB;
import marylove.DBmodelo.personaDB;
import marylove.DBmodelo.persona_llamadaDB;
import marylove.DBmodelo.victimaDB;
import marylove.models.Json_object_consulta;
import marylove.models.Persona;
import marylove.vista.Ficharegistroyreferencia;
import marylove.vista.VistaConsultaPersona;
import org.json.simple.parser.ParseException;

/**
 *
 * @author Unos conejos muy sospechosos
 */
public class ControladorRegistroReferencia extends Validaciones implements ActionListener, ItemListener {

    Ficharegistroyreferencia v;
    public static int ID_persona_llamada;
    public static int ID_persona_victima;
    //variables globales para los metodos
    persona_llamadaDB pldb;
    DefaultComboBoxModel modelo;
    ArrayList<Json_object_consulta> jocarray;
    jsonDB jo = new jsonDB();
    personaDB pdb;
    victimaDB vdb;
    DireccionDB ddb;
    DireccionPersonaDB dpdb;
    ContactoEmergenciaDB cedb;
    ArrayList<Persona> personaescogida;
//variables staticas fotando en el programa
    DefaultTableModel tabla;

    public ControladorRegistroReferencia(Ficharegistroyreferencia v) {
        this.v = v;
//        this.v.setLocationRelativeTo(null);
//        this.v.setVisible(true);
//        this.v.setResizable(false);
        this.v.getBtnAgregarAgresores().addActionListener(this);
        this.v.getBtnAgregarHijos().addActionListener(this);
        this.v.getBtnCancelar().addActionListener(this);
        this.v.getBtnGuardar().addActionListener(this);
        this.v.getBtnGuardarPersona().addActionListener(this);
        this.v.getBtn_buscar_cedula().addActionListener(this);
        this.v.getBtn_buscar_codigo().addActionListener(this);
        this.v.getBtnListadoPerReis().addActionListener(this);
        this.v.getCbxInstruccion().addItemListener(this);
        //bloqueados por defecto por la ruta de citas.
        this.v.getBtn_buscar_cedula().setEnabled(false);
        this.v.getBtn_buscar_codigo().setEnabled(false);
        this.v.getBtnListadoPerReis().setEnabled(false);
        this.v.getBtnCancelarPersona().setEnabled(false);
        this.v.getBtnEliminarPersona().setEnabled(false);
        this.v.getBtnModificarPersona().setEnabled(false);
        this.v.getBtnAgregarAgresores().setEnabled(false);
        this.v.getBtnAgregarHijos().setEnabled(false);
        //inicializacion de combos
        try {
            comboEstadoCivil();
            comboInstruccion();
            comboNacionalidad();
            comboOcupacion();
            comboParentesco();

        } catch (ParseException px) {
            System.out.println("error " + px.getMessage());
        }
        //tabla hijo
        modeloTabla();
        HijosDB hijo = new HijosDB();
        hijo.arrayHijos.clear();
        hijo.consultaHijosVictimas();
        insertarTabla();
        this.v.getBtnGuardar().setEnabled(false);

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

    public void insertarTabla() {
        limpiarTabla();
        HijosDB hijos = new HijosDB();

        String[] datos;
        for (HijosDB elem : hijos.arrayHijos) {
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

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(v.getBtnGuardarPersona())) {
            if (validacionesPersona()) {
                DatosPersonales();
//                ID_persona_victima=pdb;
                this.v.getBtnGuardar().setEnabled(true);
                this.v.getBtnAgregarAgresores().setEnabled(true);
                this.v.getBtnAgregarHijos().setEnabled(true);

            }
        }
        if (e.getSource().equals(v.getBtn_buscar_codigo())) {
            try {
                setearXcodigo();
            } catch (SQLException ex) {
                Logger.getLogger(ControladorRegistroReferencia.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        if (e.getSource().equals(v.getBtnListadoPerReis())) {
            VistaConsultaPersona o = new VistaConsultaPersona();
            ControladorBuscarPersona u = new ControladorBuscarPersona(o);
        }
        if (e.getSource().equals(v.getBtnGuardar())) {

        }
        if (e.getSource().equals(v.getBtnCancelar())) {

        }
        if (e.getSource().equals(v.getBtnAgregarAgresores())) {

        }
        if (e.getSource().equals(v.getBtnAgregarHijos())) {

        }
    }

    //combos-------------------------------------------------------------------
    public void comboInstruccion() throws ParseException {
        modelo = new DefaultComboBoxModel();
        jocarray = jo.obtenerInstruccines();
        for (Json_object_consulta o : jocarray) {
            modelo.addElement(o.getValor());
        }
        v.getCbxInstruccion().setModel(modelo);

    }

    public void comboEstadoCivil() throws ParseException {
        modelo = new DefaultComboBoxModel();
        jocarray = jo.obtenerEstadoCivil();
        for (Json_object_consulta o : jocarray) {
            modelo.addElement(o.getValor());
        }
        v.getCbxEstadoCivill().setModel(modelo);

    }

    public void comboOcupacion() throws ParseException {
        modelo = new DefaultComboBoxModel();
        jocarray = jo.obtenerOcupaciones();
        for (Json_object_consulta o : jocarray) {
            modelo.addElement(o.getValor());
        }
        v.getCbxOcupacion().setModel(modelo);

    }

    public void comboNacionalidad() throws ParseException {
        modelo = new DefaultComboBoxModel();
        jocarray = jo.obtenerNacionalidades();
        for (Json_object_consulta o : jocarray) {
            modelo.addElement(o.getValor());
        }
        v.getCbxNacionalidad().setModel(modelo);
        v.getCbxPais().setModel(modelo);
    }

    public void comboParentesco() throws ParseException {
        modelo = new DefaultComboBoxModel();
        jocarray = jo.obtenerParntescoEspecifico();
        for (Json_object_consulta o : jocarray) {
            modelo.addElement(o.getValor());
        }
        v.getCbxprentesco().setModel(modelo);

    }

    //partes---------------------------------------------------------------------------
    public void DatosPersonales() {
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
        pdb.ingresarPersona();
        vdb= new victimaDB(marylove.DBmodelo.personaDB.persona_codigo_static, "true");
        vdb.insertarVictima();

    }
    public void insertarContactoEmerg() throws SQLException{
        pdb= new personaDB("", v.getTxtNombreContacto().getText(), 
                v.getTxtApellidoContacto().getText(),
                v.getTxtTelefonoContacto().getText(),
                v.getTxtCelularContacto().getText());
        pdb.ingresarPersonaContacEmerg();
        cedb= new ContactoEmergenciaDB(v.getCbxprentesco().getSelectedItem().toString(),
                marylove.DBmodelo.personaDB.persona_cont_emerg_static,
                marylove.DBmodelo.personaDB.persona_codigo_static, 
                v.getTxtDomicilioContacto().getText());
    
    
    }

    public void insertarDomicilio() {
        ddb= new DireccionDB(v.getTxtCalle().getText(), v.getTxtInterseccion().getText(), 
                v.getTxtNumeroCasa().getText(), v.getTxtBarrio().getText(),
                v.getTxtParroquia().getText(), v.getTxtCiudad().getText(),
                v.getTxtReferencia().getText(), v.getTxtProvincia().getText(), 
                v.getCbxPais().getSelectedItem().toString(), true);
        ddb.insertaDireccion();
        dpdb = new DireccionPersonaDB(marylove.DBmodelo.personaDB.persona_codigo_static, marylove.DBmodelo.DireccionDB.direccion_codigo_static);
        dpdb.insertarDireccionD();
    }

    public void setearXcodigo() throws SQLException {
        pdb = new personaDB();
        System.out.println(v.getTxtCodigoPersona().getText());
        if (v.getTxtCodigoPersona().getText().matches("[0-9]*")) {
            System.out.println(v.getTxtCodigoPersona().getText());
            String p = v.getTxtCodigoPersona().getText();
            personaescogida = pdb.obtenerPersonaCodigo(p);
            for (Persona o : personaescogida) {
                String rei = v.getTxtCodigoPersona().getText();
                int cod = Integer.parseInt(rei);
                if (o.getPersona_codigo() == cod) {
                    v.getTxtCedula().setText(o.getPersona_cedula());
                    v.getTxtNombrePersona().setText(o.getPersona_nombre());
                    v.getTxtApellidos().setText(o.getPersona_apellido());

                }

            }

        } else {
            JOptionPane.showMessageDialog(v, "Ingreso: Solo numeros...");
        }

    }

    public boolean validacionesPersona() {
        if (v.getTxtCedula().getText().matches("[0-9]*")) {
            if (v.getDcFechaNacimiento() != null) {
                if (v.getTxtCelular().getText().matches("[0-9]*") && v.getTxtCelular().getText().length() >= 10 && v.getTxtCelular().getText().length() <= 13) {
                    if (!v.getTxtApellidoPersona().getText().matches("[0-9]*")) {
                        if (!v.getTxtNombrePersona().getText().matches("[0-9]*")) {
                            if (v.getTxtTelefonoPersona().getText().matches("[0-9]*")) {
                                return true;
                            } else {
                                JOptionPane.showMessageDialog(v, "Ingreso: solo letras");
                                v.getTxtCelular().setText("");
                                return false;
                            }

                        } else {
                            JOptionPane.showMessageDialog(v, "Ingreso: solo letras");
                            v.getTxtNombrePersona().setText("");
                            return false;
                        }
                    } else {
                        JOptionPane.showMessageDialog(v, "Ingreso: solo letras");
                        v.getTxtApellidoPersona().setText("");
                        return false;
                    }
                } else {
                    JOptionPane.showMessageDialog(v, "Ingreso: solo números");
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
