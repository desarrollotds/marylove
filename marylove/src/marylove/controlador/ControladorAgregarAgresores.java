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
import marylove.models.Json_object_consulta;
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

    public ControladorAgregarAgresores() throws Exception {
    }
    
    public ControladorAgregarAgresores(FormaAgregarAgresores vista) throws ParseException {
        this.v = vista;
//        this.vista.setVisible(true);
//        this.vista.setLocationRelativeTo(null);
        this.v.setResizable(false);
        this.v.getBtnCancelar().addActionListener(this);
        this.v.getBtnGuardar().addActionListener(this);
        this.v.getCbxNivelacad().addItemListener(this);
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
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(v.getBtnGuardar())) {
            try {
                if (validaciones_datos_personales()) {

                    DatosPersonales();
                    ingresarDireccion();
                    insetarDireccionPersona();
                    x_registro_agresor();
                    v.dispose();
                }

            } catch (SQLException ex) {
                Logger.getLogger(ControladorAgregarAgresores.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        if (e.getSource().equals(v.getBtnCancelar())) {

            v.dispose();

        }
    }
    public void x_registro_agresor() throws SQLException {
        
        xradb= new x_registro_agresorDB(AgresorDB.getAgresor_codigo_static(),Registro_referenciaDB.getRegistro_referencia_static(),v.getCbxParentesco().getSelectedIndex()+1);
        xradb.ingresarX_registro_agresor();
    }

    public boolean validaciones_datos_personales() {
        if (v.getTxtCedula().getText().length()==10) {
            if (v.getTxtNombre().getText().matches("[a-zA-z]*")) {
                if (v.getTxtApellido().getText().matches("[a-zA-Z]*")) {
                    if (v.getDcFechanacimiento()!=null) {
                        if (v.getTxtTelefono().getText().matches("[0-9]*") && v.getTxtTelefono().getText().length()<=10) {
                            if (v.getTxtCelular().getText().matches("[0-9]*") && v.getTxtCelular().getText().length()<=10) {
                                return true;
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
            JOptionPane.showMessageDialog(v,"Nombre Invalido...");
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
        parentesco_static=v.getCbxParentesco().getSelectedIndex()+1;
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
        v.dispose();
    }

    @Override
    public void itemStateChanged(ItemEvent e) {
        if (e.getItem().equals("Otra")) {

            v.getTxtinstruccionOtros().setEnabled(true);
        } else {
            v.getTxtinstruccionOtros().setEnabled(false);
            v.getTxtinstruccionOtros().setText("");
        }

    }

    public static int getParentesco_static() {
        return parentesco_static;
    }

    public static void setParentesco_static(int parentesco_static) {
        ControladorAgregarAgresores.parentesco_static = parentesco_static;
    }
    

}
