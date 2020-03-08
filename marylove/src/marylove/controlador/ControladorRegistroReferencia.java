/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package marylove.controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import marylove.DBmodelo.jsonDB;
import marylove.DBmodelo.personaDB;
import marylove.DBmodelo.persona_llamadaDB;
import marylove.models.Json_object_consulta;
import marylove.models.Persona;
import marylove.vista.Ficharegistroyreferencia;
import marylove.vista.VistaConsultaPersona;
import org.json.simple.parser.ParseException;

/**
 *
 * @author Unos conejos muy sospechosos
 */
public class ControladorRegistroReferencia extends Validaciones implements ActionListener {

    Ficharegistroyreferencia vista;
    private static int ID_persona_llamada;
    //variables globales para los metodos
    persona_llamadaDB pldb;
    DefaultComboBoxModel modelo;
    ArrayList<Json_object_consulta> jocarray;
    jsonDB jo = new jsonDB();
    personaDB pdb;
    ArrayList<Persona> personaescogida;
//variables staticas fotando en el programa
    public static int persona_cod;

    public ControladorRegistroReferencia(Ficharegistroyreferencia vista) throws ParseException {
        this.vista = vista;
        this.vista.setLocationRelativeTo(null);
        this.vista.setVisible(true);
        this.vista.setResizable(false);
        this.vista.getBtnAgregarAgresores().addActionListener(this);
        this.vista.getBtnAgregarHijos().addActionListener(this);
        this.vista.getBtnCancelar().addActionListener(this);
        this.vista.getBtnGuardar().addActionListener(this);
        this.vista.getBtnGuardarPersona().addActionListener(this);
        this.vista.getBtn_buscar_cedula().addActionListener(this);
        this.vista.getBtn_buscar_codigo().addActionListener(this);
        this.vista.getBtnListadoPerReis().addActionListener(this);

        //bloqueados por defecto por la ruta de citas.
        this.vista.getBtn_buscar_cedula().setEnabled(false);
        this.vista.getBtn_buscar_codigo().setEnabled(false);
        this.vista.getBtnListadoPerReis().setEnabled(false);
        this.vista.getBtnCancelarPersona().setEnabled(false);
        this.vista.getBtnEliminarPersona().setEnabled(false);
        this.vista.getBtnModificarPersona().setEnabled(false);
        this.vista.getBtnAgregarAgresores().setEnabled(false);
        this.vista.getBtnAgregarHijos().setEnabled(false);
        //inicializacion de combos
        comboEstadoCivil();
        comboInstruccion();
        comboNacionalidad();
        comboOcupacion();
        comboParentesco();
        this.vista.getBtnGuardar().setEnabled(false);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(vista.getBtnGuardarPersona())) {
            if (validacionesPersona()) {
                DatosPersonales();
                this.vista.getBtnGuardar().setEnabled(true);
                this.vista.getBtnAgregarAgresores().setEnabled(true);
                this.vista.getBtnAgregarHijos().setEnabled(true);
            }
        }
        if (e.getSource().equals(vista.getBtn_buscar_codigo())) {
            try {
                setearXcodigo();
            } catch (SQLException ex) {
                Logger.getLogger(ControladorRegistroReferencia.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        if (e.getSource().equals(vista.getBtnListadoPerReis())) {
            VistaConsultaPersona o = new VistaConsultaPersona();
            ControladorBuscarPersona u = new ControladorBuscarPersona(o);
        }
        if (e.getSource().equals(vista.getBtnGuardar())) {

        }
        if (e.getSource().equals(vista.getBtnCancelar())) {

        }
        if (e.getSource().equals(vista.getBtnAgregarAgresores())) {

        }
        if (e.getSource().equals(vista.getBtnAgregarHijos())) {

        }
    }

    //combos-------------------------------------------------------------------
    public void comboInstruccion() throws ParseException {
        modelo = new DefaultComboBoxModel();
        jocarray = jo.obtenerInstruccines();
        for (Json_object_consulta o : jocarray) {
            modelo.addElement(o.getValor());
        }
        vista.getCbxInstruccion().setModel(modelo);

    }

    public void comboEstadoCivil() throws ParseException {
        modelo = new DefaultComboBoxModel();
        jocarray = jo.obtenerEstadoCivil();
        for (Json_object_consulta o : jocarray) {
            modelo.addElement(o.getValor());
        }
        vista.getCbxEstadoCivill().setModel(modelo);

    }

    public void comboOcupacion() throws ParseException {
        modelo = new DefaultComboBoxModel();
        jocarray = jo.obtenerOcupaciones();
        for (Json_object_consulta o : jocarray) {
            modelo.addElement(o.getValor());
        }
        vista.getCbxOcupacion().setModel(modelo);

    }

    public void comboNacionalidad() throws ParseException {
        modelo = new DefaultComboBoxModel();
        jocarray = jo.obtenerNacionalidades();
        for (Json_object_consulta o : jocarray) {
            modelo.addElement(o.getValor());
        }
        vista.getCbxNacionalidad().setModel(modelo);
        vista.getCbxPais().setModel(modelo);
    }

    public void comboParentesco() throws ParseException {
        modelo = new DefaultComboBoxModel();
        jocarray = jo.obtenerParntescoEspecifico();
        for (Json_object_consulta o : jocarray) {
            modelo.addElement(o.getValor());
        }
        vista.getCbxprentesco().setModel(modelo);

    }

    //partes---------------------------------------------------------------------------
    public void DatosPersonales() {
        String intrucOtros = "";

        long fecha_nacimiento = vista.getDcFechaNacimiento().getDate().getTime();
        Date fecha = fechaBD(fecha_nacimiento);
        int estadocivil = vista.getCbxEstadoCivill().getSelectedIndex() + 1;

        char sexo = vista.getCbSexo().getSelectedItem().toString().charAt(0);
        int ocupacion = vista.getCbxOcupacion().getSelectedIndex() + 1;
        int nacionalidad = vista.getCbxNacionalidad().getSelectedIndex() + 1;
        int nivelacademico = vista.getCbxInstruccion().getSelectedIndex() + 1;
        int estamigratorio = vista.getCbxEstadoMigratrorio().getSelectedIndex() + 1;

        pdb = new personaDB(vista.getTxtCedula().getText(),
                vista.getTxtNombrePersona().getText(), vista.getTxtApellidoPersona().getText(),
                fecha, ocupacion, nivelacademico, estamigratorio,
                vista.getTxtTelefonoPersona().getText(), vista.getTxtCelular().getText(),
                estadocivil, nacionalidad, true, sexo, vista.getTxtinstruccionOtros().getText(),
                vista.getTxtLugarTrabajo().getText(), vista.getTxtReferencia().getText());
        pdb.ingresarPersona();

    }

    public void insertarDomicilio() {

    }

    public void setearXcodigo() throws SQLException {
        pdb = new personaDB();
        System.out.println(vista.getTxtCodigoPersona().getText());
        if (vista.getTxtCodigoPersona().getText().matches("[0-9]*")) {
            System.out.println(vista.getTxtCodigoPersona().getText());
            String p = vista.getTxtCodigoPersona().getText();
            personaescogida = pdb.obtenerPersonaCodigo(p);
            for (Persona o : personaescogida) {
                String rei = vista.getTxtCodigoPersona().getText();
                int cod = Integer.parseInt(rei);
                if (o.getPersona_codigo() == cod) {
                    vista.getTxtCedula().setText(o.getPersona_cedula());
                    vista.getTxtNombrePersona().setText(o.getPersona_nombre());
                    vista.getTxtApellidos().setText(o.getPersona_apellido());

                }

            }

        } else {
            JOptionPane.showMessageDialog(vista, "Ingreso: Solo numeros...");
        }

    }

    public boolean validacionesPersona() {
        if (vista.getTxtCedula().getText().matches("[0-9]*")) {
            if (vista.getDcFechaNacimiento() != null) {
                if (vista.getTxtCelular().getText().matches("[0-9]*") && vista.getTxtCelular().getText().length() >= 10 && vista.getTxtCelular().getText().length() <= 13) {
                    if (!vista.getTxtApellidoPersona().getText().matches("[0-9]*")) {
                        if (!vista.getTxtNombrePersona().getText().matches("[0-9]*")) {
                            if (vista.getTxtTelefonoPersona().getText().matches("[0-9]*")) {
                                return true;
                            } else {
                                JOptionPane.showMessageDialog(vista, "Ingreso: solo letras");
                                vista.getTxtCelular().setText("");
                                return false;
                            }

                        } else {
                            JOptionPane.showMessageDialog(vista, "Ingreso: solo letras");
                            vista.getTxtNombrePersona().setText("");
                            return false;
                        }
                    } else {
                        JOptionPane.showMessageDialog(vista, "Ingreso: solo letras");
                        vista.getTxtApellidoPersona().setText("");
                        return false;
                    }
                } else {
                    JOptionPane.showMessageDialog(vista, "Ingreso: solo números");
                    vista.getTxtCelular().setText("");
                    return false;
                }
            } else {
                JOptionPane.showMessageDialog(vista, "Ingrese una fecha");
                return false;
            }
        } else {
            JOptionPane.showMessageDialog(vista, "Ingreso: solo números");
            vista.getTxtCedula().setText("");
            return false;
        }
    }

}
