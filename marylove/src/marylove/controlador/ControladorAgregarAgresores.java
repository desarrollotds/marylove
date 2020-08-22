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
import marylove.DBmodelo.AgresorDB;
import marylove.DBmodelo.DireccionDB;
import marylove.DBmodelo.DireccionPersonaDB;
import marylove.DBmodelo.Registro_referenciaDB;
import marylove.DBmodelo.jsonDB;
import marylove.DBmodelo.personaDB;
import marylove.DBmodelo.x_registro_agresorDB;
import marylove.models.Direccion;
import marylove.models.Json_object_consulta;
import marylove.models.Persona;
import marylove.vista.FormaAgregarAgresores;
import org.json.simple.parser.ParseException;

/**
 *
 * @author Unos conejos muy sospechosos
 *
 */
public class ControladorAgregarAgresores extends Validaciones implements ActionListener, ItemListener {

    private FormaAgregarAgresores v;
    //variables globales para los metodos

    //variables static
    private static int parentesco_static;

    //variables globales
    DireccionDB op;
    int direccionId;
    personaDB pdb;
    DireccionPersonaDB dpdb;
    DefaultComboBoxModel modelo;
    AgresorDB adb;
    ArrayList<Json_object_consulta> jocarray;
    jsonDB jo = new jsonDB();
    x_registro_agresorDB xradb;
    //variables de validacion;
    String cedulabuscaexiste = "";

    public ControladorAgregarAgresores() throws Exception {
    }

    public ControladorAgregarAgresores(FormaAgregarAgresores vista) throws ParseException {
        this.v = vista;
        validarJsons();
//        this.vista.setVisible(true);
//        this.vista.setLocationRelativeTo(null);
        this.v.setResizable(false);
        this.v.getBtnCancelar().addActionListener(this);
        this.v.getBtnGuardar().addActionListener(this);
        this.v.getBtnBuscar().addActionListener(this);
        this.v.getCbxNivelacad().addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {

                if (e.getStateChange() == ItemEvent.SELECTED) {
                    if (v.getCbxNivelacad().getSelectedItem().toString().equals("Otra")) {
                        v.getTxtinstruccionOtros().setEnabled(true);
                        v.getTxtinstruccionOtros().setEditable(true);
                    } else {
                        v.getTxtinstruccionOtros().setEditable(false);
                        v.getTxtinstruccionOtros().setEditable(false);
                    }

                }
            }
        });
        vista.getTxtinstruccionOtros().setEnabled(false);
        comboNivelAcad();
        comboNacionalidad();
        comboOcupa();
        comboParentesco();
        comboEstadoMigratorio();
    }

    public void comboNacionalidad() throws ParseException {
        modelo = new DefaultComboBoxModel();
        jocarray = listaNacionalidades;
        for (Json_object_consulta o : jocarray) {
            modelo.addElement(o.getValor());
        }
        v.getCbxPais().setModel(modelo);
        v.getCbxNacionalidad().setModel(modelo);

    }

    public void comboParentesco() throws ParseException {
        modelo = new DefaultComboBoxModel();
        jocarray = listaParentesco;
        for (Json_object_consulta o : jocarray) {
            modelo.addElement(o.getValor());
        }
        v.getCbxParentesco().setModel(modelo);

    }

    public void comboNivelAcad() throws ParseException {
        modelo = new DefaultComboBoxModel();
        jocarray = listaInstruccionAcademica;
        for (Json_object_consulta o : jocarray) {
            modelo.addElement(o.getValor());
        }
        v.getCbxNivelacad().setModel(modelo);

    }

    public void comboOcupa() throws ParseException {
        modelo = new DefaultComboBoxModel();
        jocarray = listaOcupaciones;
        for (Json_object_consulta o : jocarray) {
            modelo.addElement(o.getValor());
        }
        v.getCbxOcupacion().setModel(modelo);

    }

    public void comboEstadoMigratorio() throws ParseException {
        modelo = new DefaultComboBoxModel();
        jocarray = listaEstadoMigratorio;
        for (Json_object_consulta o : jocarray) {
            modelo.addElement(o.getValor());
        }
        v.getCbxEstadomigra().setModel(modelo);

    }

    @Override
    public void actionPerformed(ActionEvent e){
        pdb = new personaDB();
        if (e.getSource().equals(v.getBtnBuscar())) {
            System.out.println("Prueba.....entra al metodo");
            try {
                if (pdb.askIdBase(v.getTxtCedula().getText())) {
                    
                    if (personaDB.getPersona_agresor_encontrada_static().getPersona_cedula().equals("no_one")) {
                    cedulabuscaexiste = "";
                    } else {
                    cedulabuscaexiste = "existe";
                    setearXCedula();
                    }
                    
                } else {
                    cedulabuscaexiste = "";
                }
            } catch (SQLException ex) {
                Logger.getLogger(ControladorAgregarAgresores.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        if (e.getSource().equals(v.getBtnGuardar())) {
            try {
                if (cedulabuscaexiste.equals("existe") && validaciones_datos_personales()) {
                    x_registro_agresor_second();
                }
                if (cedulabuscaexiste.equals("") && validaciones_datos_personales()) {

                    DatosPersonales();
                    ingresarDireccion();
                    insetarDireccionPersona();
                    x_registro_agresor();
                    limpiar();
                }

            } catch (SQLException ex) {
                Logger.getLogger(ControladorAgregarAgresores.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        if (e.getSource().equals(v.getBtnCancelar())) {

            v.dispose();

        }
    }

    public void setearXCedula() throws SQLException {
        Persona p = personaDB.getPersona_agresor_encontrada_static();
        if (v.getTxtCedula().getText().equals(p.getPersona_cedula())) {
            v.getTxtCedula().setText(p.getPersona_cedula());
            v.getTxtNombre().setText(p.getPersona_nombre());
            v.getTxtApellido().setText(p.getPersona_apellido());
            v.getTxtDireccionTrabajo().setText(p.getPersona_lugar_trabajo());
            v.getTxtTelefono().setText(p.getPersona_telefono());
            v.getTxtCelular().setText(p.getPersona_celular());
            v.getCbxNacionalidad().setSelectedIndex(p.getPersona_nacionalidad());
            v.getCbxOcupacion().setSelectedIndex(p.getPersona_ocupacion());
            v.getCbxNivelacad().setSelectedIndex(p.getPersona_nivel_acad());
            v.getCbxEstadomigra().setSelectedIndex(p.getPersona_est_migr());
            v.getCbxSexo().setSelectedItem(p.getPersona_sexo());
            if (op.getDirectionBase(p.getPersona_codigo())) {
                if (DireccionDB.getDireccion_econtrada_estatic().getCalle_dir().equals("no_one")) {
                
                } else {
                Direccion d = DireccionDB.getDireccion_econtrada_estatic();
                v.getTxtCalle().setText(d.getCalle_dir());
                v.getTxtNCasa().setText(d.getDir_num_casa());
                v.getTxtParroquia().setText(d.getDir_parroquia());
                v.getTxtReferencia().setText(d.getDir_referencias());
                v.getTxtInterseccion().setText(d.getDir_interseccion());
                v.getTxtBarrio().setText(d.getDir_barrio());
                v.getTxtCiudad().setText(d.getDir_ciudad());
                v.getTxtProvincia().setText(d.getProvincia());
                v.getCbxPais().setSelectedItem(d.getPais());
                }
                

            }

        }
    }

    public void limpiar() {
        v.getTxtCedula().setText("");
        v.getTxtNombre().setText("");
        v.getTxtApellido().setText("");
        v.getTxtDireccionTrabajo().setText("");
        v.getTxtTelefono().setText("");
        v.getTxtCelular().setText("");
        v.getCbxParentesco().setSelectedIndex(0);
        v.getCbxNacionalidad().setSelectedIndex(0);
        v.getCbxOcupacion().setSelectedIndex(0);
        v.getCbxNivelacad().setSelectedIndex(0);
        v.getCbxEstadomigra().setSelectedIndex(0);
        v.getCbxSexo().setSelectedIndex(0);
        v.getTxtCalle().setText("");
        v.getTxtNCasa().setText("");
        v.getTxtParroquia().setText("");
        v.getTxtReferencia().setText("");
        v.getTxtInterseccion().setText("");
        v.getTxtBarrio().setText("");
        v.getTxtCiudad().setText("");
        v.getTxtProvincia().setText("");
        v.getCbxPais().setSelectedIndex(0);
    }

    public void x_registro_agresor() throws SQLException {

        xradb = new x_registro_agresorDB(AgresorDB.getAgresor_codigo_static(), Registro_referenciaDB.getRegistro_referencia_static(), v.getCbxParentesco().getSelectedIndex() + 1);
        xradb.ingresarX_registro_agresor();
    }
    public void x_registro_agresor_second() throws SQLException {
        adb = new AgresorDB();
        Persona p = personaDB.getPersona_agresor_encontrada_static();
        adb.insertarAgresor(p.getPersona_codigo());
        xradb = new x_registro_agresorDB(AgresorDB.getAgresor_codigo_static(), Registro_referenciaDB.getRegistro_referencia_static(), v.getCbxParentesco().getSelectedIndex() + 1);
        xradb.ingresarX_registro_agresor();
    }

    public boolean validaciones_datos_personales() throws SQLException {
        
            if (v.getTxtCedula().getText().length() == 10) {
                if (v.getTxtNombre().getText().matches("[a-zA-z]*")) {
                    if (v.getTxtApellido().getText().matches("[a-zA-Z]*")) {
                        if (v.getDcFechanacimiento() != null) {
                            if (v.getTxtTelefono().getText().matches("[0-9]*") && v.getTxtTelefono().getText().length() <= 10) {
                                if (v.getTxtCelular().getText().matches("[0-9]*") && v.getTxtCelular().getText().length() <= 10) {
                                    if (v.getDcFechanacimiento().getCalendar().getTime() != null) {
                                        return true;
                                    } else {
                                        JOptionPane.showMessageDialog(null, "Selecione una fecha...");
                                        return false;
                                    }

                                } else {
                                    JOptionPane.showMessageDialog(v, "Celular Invalido...");
                                    v.getTxtCelular().setText("");
                                    return false;
                                }
                            } else {
                                JOptionPane.showMessageDialog(v, "Telefono Invalido...");
                                v.getTxtTelefono().setText("");
                                return false;
                            }
                        } else {
                            JOptionPane.showMessageDialog(v, "Selecciones una fecha de nacimiento...");
                            return false;
                        }
                    } else {
                        JOptionPane.showMessageDialog(v, "Apellido Invalido...");
                        v.getTxtApellido().setText("");
                        return false;
                    }
                } else {
                    JOptionPane.showMessageDialog(v, "Nombre Invalido...");
                    v.getTxtNombre().setText("");
                    return false;
                }
            } else {
                JOptionPane.showMessageDialog(v, "Cedula Invalida...");
                v.getTxtCedula().setText("");
                return false;
            }
        

    }

    public void DatosPersonales() throws SQLException {
        String intrucOtros = "";

        long fecha_nacimiento = v.getDcFechanacimiento().getDate().getTime();
        Date fecha = fechaBD(fecha_nacimiento);

        int ocupacion = v.getCbxOcupacion().getSelectedIndex() + 1;
        int nacionalidad = v.getCbxNacionalidad().getSelectedIndex() + 1;
        int nivelacademico = v.getCbxNivelacad().getSelectedIndex() + 1;
        int estamigratorio = v.getCbxEstadomigra().getSelectedIndex() + 1;
        int estadocivil = 0;
        char sex = v.getCbxSexo().getSelectedItem().toString().charAt(0);
        pdb = new personaDB(v.getTxtCedula().getText(),
                v.getTxtNombre().getText(), v.getTxtApellido().getText(),
                fecha, ocupacion, nivelacademico, estamigratorio,
                v.getTxtTelefono().getText(), v.getTxtCelular().getText(),
                estadocivil, nacionalidad, true, sex, v.getTxtinstruccionOtros().getText(),
                v.getTxtDireccionTrabajo().getText(), v.getTxtReferencia().getText());
        pdb.ingresarPersonaAgresor();
        adb = new AgresorDB();
        adb.insertarAgresor(personaDB.getPersona_agresor_static());
        parentesco_static = v.getCbxParentesco().getSelectedIndex() + 1;
    }

    public void insetarDireccionPersona() throws SQLException {
        pdb = new personaDB();
        op = new DireccionDB();
        int dir = DireccionDB.getDireccion_codigo_static();
        int per = personaDB.getPersona_agresor_static();
        dpdb = new DireccionPersonaDB(per, dir);
        dpdb.insertarDireccionD();
    }

    public void ingresarDireccion() throws SQLException {
        op = new DireccionDB(v.getTxtCalle().getText(), v.getTxtInterseccion().getText(),
                v.getTxtNCasa().getText(), v.getTxtBarrio().getText(), v.getTxtParroquia().getText(),
                v.getTxtCiudad().getText(), v.getTxtReferencia().getText(), v.getTxtProvincia().getText(),
                v.getCbxPais().getSelectedItem().toString(), true);
        op.insertaDireccion();

    }

    public void finals() {
        JOptionPane.showMessageDialog(v, "Agresor Agregado");

    }

    @Override
    public void itemStateChanged(ItemEvent e) {
        if (e.getStateChange() == ItemEvent.SELECTED) {
            if (v.getCbxNivelacad().getSelectedItem().toString().equals(modelo)) {
                v.getTxtinstruccionOtros().setEnabled(true);
            } else {
                v.getTxtinstruccionOtros().setEnabled(false);
                v.getTxtinstruccionOtros().setText("");
            }

        }
    }

    public static int getParentesco_static() {
        return parentesco_static;
    }

    public static void setParentesco_static(int parentesco_static) {
        ControladorAgregarAgresores.parentesco_static = parentesco_static;
    }

}
