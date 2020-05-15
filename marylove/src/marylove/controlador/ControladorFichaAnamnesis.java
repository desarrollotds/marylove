/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package marylove.controlador;

import com.mxrck.autocompleter.AutoCompleter;
import com.mxrck.autocompleter.TextAutoCompleter;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import marylove.DBmodelo.FamiliaresDB;
import marylove.DBmodelo.FichaAnamnesisBD;
import marylove.DBmodelo.HijosDB;
import marylove.DBmodelo.NacimientoDB;
import marylove.DBmodelo.PadreDB;
import marylove.DBmodelo.jsonDB;
import marylove.conexion.Conexion;
import marylove.models.Json_object_consulta;
import marylove.vista.FichaAnamnesis;
import org.json.simple.parser.ParseException;
import sun.awt.image.VSyncedBSManager;

/**
 *
 * @author Usuario
 */
public class ControladorFichaAnamnesis extends Validaciones {

    private Conexion con = new Conexion();
    private FichaAnamnesisBD modeloFichaAnamnesisBD;
    private FichaAnamnesis vistaAnamnesis;
    private HijosDB modeloHijosDB;
    private PadreDB modeloPadreDB;
    private FamiliaresDB modeloFamiliaresDB;
    private jsonDB claseJsonDB = new jsonDB();
    private NacimientoDB modeloNacimientoDB = new NacimientoDB();

    //DECLARAMOS LAS LISTAS QUE CONTIENEN LOS VALORES DE LOS DISTINTOS JSONS QUE USARÁ LA FICHA
    private final ArrayList<Json_object_consulta> listaNacionalidades = claseJsonDB.obtenerNacionalidades();
    private final ArrayList<Json_object_consulta> listaEstadoCivil = claseJsonDB.obtenerEstadoCivil();
    private final ArrayList<Json_object_consulta> listaInstruccionAcademica = claseJsonDB.obtenerInstruccines();

    //DECLARAMOS VARIABLES LOCALES PARA VALIDACIONES
    private String accionBtnGuardarVFamiliares;

    public ControladorFichaAnamnesis(FichaAnamnesis vistaAnamnesis) throws ParseException {
        this.vistaAnamnesis = vistaAnamnesis;
        this.vistaAnamnesis.setLocationRelativeTo(null);
        this.vistaAnamnesis.setVisible(true);
        this.vistaAnamnesis.getFrmFamiliares().setLocationRelativeTo(null);

    }

    public void inciarControl() {
        //CARGAMOS LOS JSONS QUE VAMOS A USAR EN LA VISTA
        cargarJsons();

        //CONTROL DE BOTONES
        vistaAnamnesis.getBtnGuardar().addActionListener(e -> guardarDatos());
        vistaAnamnesis.getBtnAñadir().addActionListener(e -> mostrarVentanaAnadirFamiliares("Ingresar"));
        vistaAnamnesis.getBtnEditar().addActionListener(e -> mostrarVentanaAnadirFamiliares("Actualizar"));
        vistaAnamnesis.getBtnFamiliares_anadirFamiliar().addActionListener(e -> accionBtnFormFamiliares());

        //CONTROLADORES DE FECHAS
        vistaAnamnesis.getJdcFechaElaboracion().setCalendar(Calendar.getInstance());

        //CONTROLES DE TEXTOS
        vistaAnamnesis.getTxtCedula().addKeyListener(validarCedula(vistaAnamnesis.getTxtCedula()));

    }

    public void guardarDatos() {
        String n1 = consultarIdNacionalidad(vistaAnamnesis.getTxtNacionalidadNNA().getText());
        String n2 = consultarIdNacionalidad(vistaAnamnesis.getTxtNacionalidadPadre().getText());
        String n3 = consultarIdNacionalidad(vistaAnamnesis.getTxtNaconalidadMadre().getText());
        System.out.println("RESULTADO NACIONALIDAD> " + n1);
        System.out.println("RESULTADO NACIONALIDAD PADRE> " + n2);
        System.out.println("RESULTADO NACIONALIDAD MADRE> " + n3);
    }

    public boolean controlarFlujo() {
        //VALIDACIÓN Y LLENADO DEL ENCABEZADO
        if (encabezadoFichaAnamnesis() == true) {
            //VALIDACIÓN 1.1 DATOS DE IDENTIFICACIÓN 
            if (datosIdentificacion() == true) {
                //VALIDACIÓN 1.2 DATOS DE LA MADRE Y DEL PADRE
                if (datosPadreMadre() == true) {
                    //VALIDACIÓN 1.3 SITUACIÓN EN LA QUE INGRESA EL NNA
                    if (situacionIngresoNNA() == true) {
                        //VALIDACIÓN 1.4 COMPOSICIÓN FAMILIAR DEL NNA
                        return true;
                    } else {
                        System.out.println("ERROR EN EL PUNTO 1.3 SITUACIÓN DE INGRESO DEL NNA");
                        return false;
                    }
                } else {
                    System.out.println("ERROR EN EL PUNTO 1.2 DATOS DE LA MADRE Y EL PADRE");
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

    //ENCABEZADO DE LA FICHA NNA
    public boolean encabezadoFichaAnamnesis() {
        if (vistaAnamnesis.getTxtNombreApellido().getText() == "") {
            JOptionPane.showMessageDialog(null, "Ingrese el nombre del niño, niña o adolescente al cuál se esta realizando la encuesta");
            return false;
        } else {
            modeloHijosDB.setPersona_nombre(vistaAnamnesis.getTxtNombreApellido().getText());//Seteamos el nombre
            modeloHijosDB.setPersona_apellido(vistaAnamnesis.getTxtNombreApellido().getText());//Seteamos el apellido
            modeloHijosDB.setPersona_cedula(vistaAnamnesis.getTxtCedula().getText());
            return true;
        }
    }

    //1.1 DATOS DE IDENTIFICACIÓN - FICHA ANAMNESIS
    public boolean datosIdentificacion() {
        if (vistaAnamnesis.getJdcFechaNacimientoNNA().getDate() != null
                || vistaAnamnesis.getTxtLugarNacNNA1().getText() != null
                || vistaAnamnesis.getTxtNacionalidadNNA().getText() != null
                || vistaAnamnesis.getTxtEdadNNA().getText() != null
                || vistaAnamnesis.getCbxPoseeCedula().getSelectedIndex() != 0) {
            JOptionPane.showMessageDialog(null, "Existen campos sin llenar en la sección -> 1.1 Datos de Identificación <-");
            return false;
        } else {
            //Como anteriormente creamos un objeto modelo de la clase HijosDB y estamos guardando datos del mismo nna entoncces procedemos a usarle mismo objeto
            modeloHijosDB.setPersona_fecha_nac(fechaBD(vistaAnamnesis.getJdcFechaNacimientoNNA().getDate().getTime()));
            modeloNacimientoDB.setLugar_nacimiento(vistaAnamnesis.getTxtLugarNacNNA1().getText());
            //Consultamos el id de la nacionalidad seleccionada y guardamos el resultado de en una variable
            String idNacionalidad = consultarIdNacionalidad(vistaAnamnesis.getTxtNacionalidadNNA().getText());
            if (idNacionalidad != null) {//En caso de que si tengamos una resultado 
                modeloHijosDB.setPersona_nacionalidad(Integer.parseInt(idNacionalidad));//Ingresamos el id obtenido de la nacionalidad al modelo

                //PENDIENTE VALIDA LA EDAD Y EL COMBO "POSEE CEDULA"
                return true;
            } else {
                JOptionPane.showMessageDialog(null, "La nacionalidad ingresada es incorrecta");
                return false;
            }
        }
    }

    //1.2 DATOS DE LA MADRE Y EL PADRE - FICHA ANAMNESIS
    public boolean datosPadreMadre() {//Pendiente de cambios------------------------------------------------------------IMPORTANTE
        modeloPadreDB = new PadreDB();
        modeloPadreDB.setPersona_apellido(vistaAnamnesis.getTxtNombrePadre().getText());
        modeloPadreDB.setPersona_nacionalidad(0);//INGRESO DESDE EL JSON
        //edad por verse

        if (vistaAnamnesis.getCbxPadreAgresor().getSelectedItem().toString() == "Si") {
            modeloHijosDB.setPadre_agresor(true);
        } else {
            modeloHijosDB.setPadre_agresor(false);
        }

        modeloHijosDB.setHijo_estado_ingreso(vistaAnamnesis.getTxaSituacionIngresaNNA().getText());

        return false;
    }

    //1.3 SITUACIÓN EN LA QUE INGRESA EL NNA - FICHA ANAMNESIS
    public boolean situacionIngresoNNA() {
        if (!"".equals(vistaAnamnesis.getTxaSituacionIngresaNNA().getText())) {
            modeloHijosDB.setHijo_estado_ingreso(vistaAnamnesis.getTxaSituacionIngresaNNA().getText());
            return true;
        } else {
            JOptionPane.showMessageDialog(null, "Porfavor llene la sección del estado de ingreso del NNA");
            return false;
        }
    }

    //1.4 COMPOSICIÓN FAMILIAR DEL NNA - FICHA ANAMNESIS
    public boolean composicionFamiliarNNA() {
        if (vistaAnamnesis.getTabComposicionFamiliarNNA().getRowCount() != 0) {
            //El usuario podra ingresar, editar y eliminar familiares de su composición familiar
            return true;
        } else {
            JOptionPane.showMessageDialog(null, "No se a registrado ninguna composición familiar");
            return false;
        }
    }

    //METODOS--------------------------------------------------------------------------------------------------------
    //METODO PARA CONSULTAR EL ID DE UNA NACIONALIDAD SELECCIONADA
    public String consultarIdNacionalidad(String nacionalidad) {
        for (int i = 0; i < listaNacionalidades.size(); i++) {
            Json_object_consulta obj = listaNacionalidades.get(i);

            System.out.println("VALOR: " + obj.getValor());

            if (obj.getValor().equalsIgnoreCase(nacionalidad)) {
                System.out.println("ID DE NACIONALIDAD:" + obj.getId());
                return obj.getId() + "";
            }
        }
        return null;
    }

    //METODO PARA CONSULTAR EL ID DE UN ESTADO CIVIL SELECCIONADO
    public String consultarIdEstadoCivil(String estadocivil) {
        for (int i = 0; i < listaEstadoCivil.size(); i++) {
            Json_object_consulta obj = listaEstadoCivil.get(i);

            System.out.println("VALOR: " + obj.getValor());

            if (obj.getValor().equalsIgnoreCase(estadocivil)) {
                System.out.println("ID DE ESTADO CIVIL:" + obj.getId());
                return obj.getId() + "";
            }
        }
        return null;
    }

    //METODO PARA CONSULTAR EL ID DE UNA INSTRUCCION ACADEMICA SELECCIONADA
    public String consultarIdInstruccionAcademica(String instruccionA) {
        for (int i = 0; i < listaInstruccionAcademica.size(); i++) {
            Json_object_consulta obj = listaInstruccionAcademica.get(i);

            System.out.println("VALOR: " + obj.getValor());

            if (obj.getValor().equalsIgnoreCase(instruccionA)) {
                System.out.println("ID DE LA INSTRUCCION ACADEMICA ES:" + obj.getId());
                return obj.getId() + "";
            }
        }
        return null;
    }

    //METODO PARA AUTOCOMPLETAR TEXTFIELD DE NACIONALIDADES
    public void autocompletarListaNacionalidades() {
        TextAutoCompleter completarNacionalidad = new TextAutoCompleter(vistaAnamnesis.getTxtNacionalidadNNA());
        TextAutoCompleter completarNacionalidadPadre = new TextAutoCompleter(vistaAnamnesis.getTxtNacionalidadPadre());
        TextAutoCompleter completarNacionalidadMadre = new TextAutoCompleter(vistaAnamnesis.getTxtNaconalidadMadre());

        for (int i = 0; i < listaNacionalidades.size(); i++) {
            Json_object_consulta obj = listaNacionalidades.get(i);
            completarNacionalidad.addItem(obj.getValor());
            completarNacionalidadPadre.addItem(obj.getValor());
            completarNacionalidadMadre.addItem(obj.getValor());
        }
    }

    public void cargarJsons() {
        //Cargamos la lista de nacionalidades en los componentes que lo usan
        autocompletarListaNacionalidades();

        //Cargamos la lista de estado civil en los componentes que lo utilizan
        for (int i = 0; i < listaEstadoCivil.size(); i++) {
            vistaAnamnesis.getCbxFamiliares_estadoCivil().addItem(listaEstadoCivil.get(i).getValor());
        }

        //Cargamos la lista de instrucciones académicas en los componentes que la usan
        for (int i = 0; i < listaInstruccionAcademica.size(); i++) {
            vistaAnamnesis.getCbxFamiliares_instruccionAcademica().addItem(listaInstruccionAcademica.get(i).getValor());
        }
    }

    //METODO PARA MOSTRAR LA VENTANA PARA AÑADIR FAMILIARES
    public void mostrarVentanaAnadirFamiliares(String accion) {

        //Formateamos y seteamos la accion a la variable global
        accionBtnGuardarVFamiliares = new String();
        accionBtnGuardarVFamiliares = accion;

        if (accion.equalsIgnoreCase("Ingresar")) {

            limpiarCamposVentanaFamiliares();
            vistaAnamnesis.getFrmFamiliares().setVisible(true);
        } else if (accion.equalsIgnoreCase("Actualizar")) {

            //LLAMAR AL METODO DE CARGA DE DATOS DESDE LA TABLA
        }
    }

    //METODO PARA LIMPIAR LOS CAMPOS DE LA VENTANA DE REGISTRO DE FAMILIARES
    public void limpiarCamposVentanaFamiliares() {
        vistaAnamnesis.getTxtFamiliares_nombres().setText("");
        vistaAnamnesis.getTxtFamiliares_apellidos().setText("");
        vistaAnamnesis.getTxtFamiliares_edad().setText("");
        vistaAnamnesis.getTxtFamiliares_parentesco().setText("");
        vistaAnamnesis.getTxtFamiliares_ocupacion().setText("");
        vistaAnamnesis.getCbxFamiliares_sexo().setSelectedIndex(0);
        vistaAnamnesis.getCbxFamiliares_estadoCivil().setSelectedIndex(0);
        vistaAnamnesis.getCbxFamiliares_instruccionAcademica().setSelectedIndex(0);
    }

    //METODO DE ACCIÓN PARA EL BOTÓN GUARDAR DE LA VENTANA PARA AÑADIR FAMILIARES
    public void accionBtnFormFamiliares() {

        anadir_editar_FamiliarNNA();//Extraemos los datos de la ventana de registro de familiares

        if (accionBtnGuardarVFamiliares.equalsIgnoreCase("Ingresar")) {
            //METODO DE INSERT A LA BD
        } else if (accionBtnGuardarVFamiliares.equalsIgnoreCase("Actualizar")) {
            //METODO DE UPDATE A LA BD
        }
    }

    //METODO PARA AÑADIR FAMILIARES EN LA ESTRUCTURA FAMILIAR DEL NNA
    public void anadir_editar_FamiliarNNA() {

        System.out.println("RESULTADO ESTADO CIVIL> " + consultarIdEstadoCivil(vistaAnamnesis.getCbxFamiliares_estadoCivil().getSelectedItem().toString()));
        System.out.println("RESULTADO INSTRUCCION ACADEMICA> " + consultarIdInstruccionAcademica(vistaAnamnesis.getCbxFamiliares_instruccionAcademica().getSelectedItem().toString()));

        if (vistaAnamnesis.getTxtFamiliares_nombres().getText() != null
                || vistaAnamnesis.getTxtFamiliares_nombres().getText() != null
                || vistaAnamnesis.getTxtFamiliares_edad().getText() != null
                || vistaAnamnesis.getTxtFamiliares_parentesco().getText() != null
                || vistaAnamnesis.getTxtFamiliares_ocupacion().getText() != null
                || vistaAnamnesis.getCbxFamiliares_sexo().getSelectedIndex() == 0
                || vistaAnamnesis.getCbxFamiliares_estadoCivil().getSelectedIndex() == 0
                || vistaAnamnesis.getCbxFamiliares_instruccionAcademica().getSelectedIndex() == 0) {
            //Si el condicional se cumple significa que hay campos del formulario sin completar, por lo que le damos aviso al usuario 
            JOptionPane.showMessageDialog(null, "No se pudo guardar al familiar porque existen campos que no han sido completados");

        } else {
            modeloFamiliaresDB = new FamiliaresDB();
            modeloFamiliaresDB.setPersona_nombre(vistaAnamnesis.getTxtFamiliares_nombres().getText());
            modeloFamiliaresDB.setPersona_apellido(vistaAnamnesis.getTxtFamiliares_apellidos().getText());
            modeloFamiliaresDB.setPersona_ocupacion(0);//CONSULTA EL ID EN EL JSON
            modeloFamiliaresDB.setParentesco(vistaAnamnesis.getTxtFamiliares_parentesco().getText());

            if (null != vistaAnamnesis.getCbxFamiliares_sexo().getSelectedItem().toString()) {
                switch (vistaAnamnesis.getCbxFamiliares_sexo().getSelectedItem().toString()) {
                    case "Masculino":
                        modeloFamiliaresDB.setPersona_sexo('M');
                        break;
                    case "Femenino":
                        modeloFamiliaresDB.setPersona_sexo('F');
                        break;
                    case "Sin especificar":
                        modeloFamiliaresDB.setPersona_sexo('S');
                        break;
                    default:
                        break;
                }
            }

            //Consultamos el id del estado civil seleccionado y lo guardamos en una variable para luego validarla
            String idEstadoCivil = consultarIdEstadoCivil(vistaAnamnesis.getCbxFamiliares_estadoCivil().getSelectedItem().toString());

            if (idEstadoCivil != null) {
                modeloFamiliaresDB.setPersona_estadocivil(Integer.parseInt(idEstadoCivil));//CONSULTA EL ID EN EL JSON -REALIZADO 
            } else {
                System.out.println("EL ESTADO CIVIL INGRESADO ES INCORRECO");
            }

            //Consultamos el id de la instrucción académica seleccionada y lo guardamos en una variable para luego validarla
            String idInstruccionAcad = consultarIdInstruccionAcademica(vistaAnamnesis.getCbxFamiliares_instruccionAcademica().getSelectedItem().toString());
            if (idInstruccionAcad != null) {
            modeloFamiliaresDB.setPersona_nivel_acad(Integer.parseInt(idInstruccionAcad));//CONSULTA EL ID EN EL JSON -REALIZADO
            }else{
                System.out.println("LA INSTRUCCION ACADEMICA INGRESADA ES INCORRECTA");
            }
        }
    }
}
