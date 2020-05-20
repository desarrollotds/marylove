/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package marylove.controlador;

import com.mxrck.autocompleter.TextAutoCompleter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import marylove.DBmodelo.AnamnesisDB;
import marylove.DBmodelo.FamiliaresDB;
import marylove.DBmodelo.FichaAnamnesisBD;
import marylove.DBmodelo.HijosDB;
import marylove.DBmodelo.NacimientoDB;
import marylove.DBmodelo.PadreDB;
import marylove.DBmodelo.jsonDB;
import marylove.models.Json_object_consulta;
import marylove.vista.FichaAnamnesis;
import org.json.simple.parser.ParseException;

/**
 *
 * @author Usuario
 */
public class ControladorFichaAnamnesis extends Validaciones implements ChangeListener {

    private FichaAnamnesisBD modeloFichaAnamnesisBD;
    private final FichaAnamnesis vistaAnamnesis;
    private HijosDB modeloHijosDB;
    private PadreDB modeloPadreDB;
    private FamiliaresDB modeloFamiliaresDB;
    private NacimientoDB modeloNacimientoDB = new NacimientoDB();

    //DECLARAMOS VARIABLES LOCALES PARA VALIDACIONES
    private String accionBtnGuardarVFamiliares;
    private int idFamiliarUpdate;
    private int indiceVentanaCambiada = 0;

    public ControladorFichaAnamnesis(FichaAnamnesis vistaAnamnesis) throws ParseException {
        this.vistaAnamnesis = vistaAnamnesis;
        this.vistaAnamnesis.setLocationRelativeTo(null);
        cargarJsons();
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

        vistaAnamnesis.getJtpPrincipal().addChangeListener(e -> stateChanged(e));
          AnamnesisDB anam=new AnamnesisDB();
        System.out.println("holddddd");
        anam.conectarTodo(Integer.parseInt(vistaAnamnesis.getTxtCodigo().getText()));

    }

    //METODO ESCUCHA PARA JTABBEDPANE
    @Override
    public void stateChanged(ChangeEvent e) {
        accionCambioVentana();//Llamamos al metodo y guardamos el estado anterior
        indiceVentanaCambiada = vistaAnamnesis.getJtpPrincipal().getSelectedIndex();//Seteamos el la nueva ventana seleccionada

    }

    //METODO PARA LA ACCIÓN DEL CAMBIO DE PESTAÑA 
    public void accionCambioVentana() {
        switch (indiceVentanaCambiada) {
            case 0://DATOS DE IDENTIFICACIÓN
                System.out.println("LA SELECCION ANTERIOR FUE DATOS DE IDENTIFICACIÓN");
                //Llamar al metodo de actualización de la clase HijosDB
                //LLamar al metodo de actualización de la clase NacimientoDB

                break;
            case 1://DATOS DE LA MADRE Y PADRE
                System.out.println("LA SELECCION ANTERIOR FUE DATOS DE LA MADRE Y EL PADRE");
                //Crear el método db de datos de la madre
                //Llamar al método de actualización de la clase PadreDB
                //Llamar al método de actualización de la clase HijosDB

                break;
            case 2://COMPOSICIÓN FAMILIAR NNA
                System.out.println("LA SELECCION ANTERIOR FUE COMPOSICIÓN FAMMILIAR NNA");

                break;
            case 3://PERIODO DE EMBARAZO
                System.out.println("LA SELECCION ANTERIOR FUE PERIODO DE EMBARAZO");
                //Llamar al método de actualizarPeriodoEmbarazo en la clase PeriodoEmbarazoDB
                
                
                break;
            case 4://CONDICIONES DE NACIMIENTO 
                System.out.println("LA SELECCION ANTERIOR FUE CONDICIONES DE NACIMIENTO");
                //Llamar al método actualizarConficionesNacimiento en la clase NacimientoDB
                
                break;
            case 5://PRIMEROS DÍAS DE VIDA
                System.out.println("LA SELECCION ANTERIOR FUE PRIMEROS DÍAS DE VIDA");
                break;
            case 6://ALIMENTACIÓN ACTUAL
                System.out.println("LA SELECCION ANTERIOR FUE ALIMENTACIÓN ACTUAL");
                break;
            case 7://DESARROLLO DE MOTOR Y LENGUAJE ACTUAL
                System.out.println("LA SELECCION ANTERIOR FUE DESARROLLO DE MOTOR GRUESO Y LENGUAJE CORPORAL");
                break;
            case 8://SUEÑO Y CONTROL DE ESFÍNTERES
                System.out.println("LA SELECCION ANTERIOR FUE SUEÑO Y CONTROL DE ESFÍNTERES");
                break;
            case 9://ESCOLARIZACIÓN NNA
                System.out.println("LA SELECCION ANTERIOR FUE ESCOLARICACIÓN NNA");
                break;
            case 10://SALUD 
                System.out.println("LA SELECCION ANTERIOR FUE SALUD");
                break;
            case 11://RELACIÓN FAMILIAR 
                System.out.println("LA SELECCION ANTERIOR FUE RELACIÓN FAMMILIAR");
                break;
            case 12://OBSERVACIONES GENERALES
                System.out.println("LA SELECCION ANTERIOR FUE OBSERVACIONES GENERALES");
                break;
            default:
                System.out.println("NO SE CAMBIO DE VENTANA");
                break;
        }
    }

    public void guardarDatos() {
        //Llamamos al metodo para guardar el ultimo estado de la ultima pestaña seleccionada
        accionCambioVentana();

        if (controlarFlujo()) {
            //Validamos si el usuario quiere guardar los datos en su estado actual
            if (JOptionPane.showConfirmDialog(null,
                    "Está a punto de guardar los datos en su estado actual. ¿Desea continuar?", "Confirmar datos", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE) == JOptionPane.YES_OPTION) {
                //Llamar al métodoDB que actualiza los estados
                System.out.println("SE GUARDO XD");
                this.vistaAnamnesis.dispose();
            }
        } else {
            if (JOptionPane.showConfirmDialog(null,
                    "La ficha contiene datos que no han sido llenados ¿Está segur@ que desea guardar los datos en su estado actual?", "Confirmar datos", JOptionPane.OK_CANCEL_OPTION,
                    JOptionPane.QUESTION_MESSAGE) == JOptionPane.YES_OPTION) {
                //Llamer al métodoDB que actualiza los estados
                System.out.println("SE GUARDO XD");
                this.vistaAnamnesis.dispose();
            }
        }
    }

    //EL MÉTODO CONTROLARFLUJO SIRVE PARA VALIDAR SI TODO EL FLUJO DE LA FICHA ESTA LLENO, EN CASO DE ESTARLO RETORNARA TRUE CASO CONTRARIO FALSE
    public boolean controlarFlujo() {
        //VALIDACIÓN Y LLENADO DEL ENCABEZADO
        if (validarEncabezadoFichaAnamnesis()) {
            //VALIDACIÓN 1.1 DATOS DE IDENTIFICACIÓN 
            if (validardatosIdentificacion()) {
                //VALIDACIÓN 1.2 DATOS DE LA MADRE Y DEL PADRE
                if (validardatosPadreMadre()) {
                    //VALIDACIÓN 1.3 SITUACIÓN EN LA QUE INGRESA EL NNA
                    if (validardatosSituacionIngresoNNA()) {
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
    public void cargardatosEncabezadoFichaAnamnesis() {
        modeloHijosDB.setPersona_nombre(vistaAnamnesis.getTxtNombreApellido().getText());//Seteamos el nombre
        modeloHijosDB.setPersona_apellido(vistaAnamnesis.getTxtNombreApellido().getText());//Seteamos el apellido
        modeloHijosDB.setPersona_cedula(vistaAnamnesis.getTxtCedula().getText());
    }

    //CARGAR DATOS: 1.1 DATOS DE IDENTIFICACIÓN - FICHA ANAMNESIS
    public void cargardatosIdentificacion() {
        //Como anteriormente creamos un objeto modelo de la clase HijosDB y estamos guardando datos del mismo nna entoncces procedemos a usarle mismo objeto
        modeloHijosDB.setPersona_fecha_nac(fechaBD(vistaAnamnesis.getJdcFechaNacimientoNNA().getDate().getTime()));
        modeloNacimientoDB.setLugar_nacimiento(vistaAnamnesis.getTxtLugarNacNNA1().getText());

        //Consultamos el id de la nacionalidad seleccionada y guardamos el resultado de en una variable
        String idNacionalidad = consultarIdNacionalidad(vistaAnamnesis.getTxtNacionalidadNNA().getText());
        modeloHijosDB.setPersona_nacionalidad(Integer.parseInt(idNacionalidad));//Ingresamos el id obtenido de la nacionalidad al modelo

        //PENDIENTE VALIDA LA EDAD Y EL COMBO "POSEE CEDULA"
    }

    //CARGAR DATOS: 1.2 DATOS DE LA MADRE Y EL PADRE - FICHA ANAMNESIS
    public void cargardatosPadreMadre() {//Pendiente de cambios------------------------------------------------------------IMPORTANTE
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
    }

    //CARGAR DATOS: 1.3 SITUACIÓN EN LA QUE INGRESA EL NNA - FICHA ANAMNESIS
    public void cargardatosSituacionIngresoNNA() {
        modeloHijosDB.setHijo_estado_ingreso(vistaAnamnesis.getTxaSituacionIngresaNNA().getText());
    }

    //CARGAR DATOS: 1.4 COMPOSICIÓN FAMILIAR DEL NNA - FICHA ANAMNESIS
    public void cargardatosComposicionFamiliarNNA() {
        //El usuario podra ingresar, editar y eliminar familiares de su composición familiar
        //Se cargaran datos a la tabla y luego a la base
    }

    //CARGAR DATOS: 1.5 PERIODO DE EMBARAZO
    public void cargardatosPeriodoEmbarazo() {
    }

    //CARGAR DATOS: 1.6 CONDICIONES DE NACIMIENTO
    public void cargardatosCondicionesNacimiento() {
    }

    //CARGAR DATOS: 1.7 PRIMEROS DÍAS DE VIDA 
    public void cargardatosPrimerosDiasVida() {
    }

    //CARGAR DATOS: 1.8 ALIMENTACIÓN ACTUAL 
    public void cargardatosAlimentacionActual() {
    }

    //CARGAR DATOS: 1.9 DESARROLLO MOTOR Y LENGUAJE ACTUAL
    public void cargardatosDesarrolloMotoLenguajeActual() {
    }

    //CARGAR DATOS: 1.10 SUEÑO Y CONTROL DE ESFÍNTERES 
    public void cargardatosSuenoControlEsfinter() {
    }

    //CARGAR DATOS: 1.11 ESCOLARIZACIÓN NNA 
    public void cargardatosEscolarizacionNNA() {
    }

    //CARGAR DATOS: 1.12 SALUD 
    public void cargardatosSalud() {
    }

    //CARGAR DATOS: 1.13 RELACIÓN FAMILIAR 
    public void cargardatosRelacionFamiliar() {
    }

    //CARGAR DATOS: 1.14 OBSERVACIONES GENERALES
    public void cargardatosObservacionesGenerales() {
    }

    //METODOS------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
    //METODO PARA AUTOCOMPLETAR TEXTFIELD DE NACIONALIDADES
    public void autocompletarListaNacionalidades() {

        //AUTOCOMPLETAR CON EL JSON DE NACIONALIDADES
        TextAutoCompleter completarNacionalidad = new TextAutoCompleter(vistaAnamnesis.getTxtNacionalidadNNA());
        TextAutoCompleter completarNacionalidadPadre = new TextAutoCompleter(vistaAnamnesis.getTxtNacionalidadPadre());
        TextAutoCompleter completarNacionalidadMadre = new TextAutoCompleter(vistaAnamnesis.getTxtNaconalidadMadre());

        for (int i = 0; i < listaNacionalidades.size(); i++) {
            Json_object_consulta obj = listaNacionalidades.get(i);
            completarNacionalidad.addItem(obj.getValor());
            completarNacionalidadPadre.addItem(obj.getValor());
            completarNacionalidadMadre.addItem(obj.getValor());
        }

        //AUTOCOMPLETAR CON EL JSON DE OCUPACIONES
        TextAutoCompleter completarOcupaciones = new TextAutoCompleter(vistaAnamnesis.getTxtFamiliares_ocupacion());

        for (int i = 0; i < listaOcupaciones.size(); i++) {
            Json_object_consulta obj = listaOcupaciones.get(i);
            completarOcupaciones.addItem(obj.getValor());
        }
    }

    //METODO PARA CARGAR LOS JSON EN LA FICHA ANMNESIS
    public void cargarJsons() {
        try {
            //Cargamos la lista de nacionalidades en los componentes que lo usan
            validarJsons();
        } catch (ParseException ex) {
            Logger.getLogger(ControladorFichaAnamnesis.class.getName()).log(Level.SEVERE, null, ex);
        }
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
            if (vistaAnamnesis.getTabComposicionFamiliarNNA().getSelectedRow() > 0) {
                cargarFamiliar_VentanaFamiliares();
                vistaAnamnesis.getFrmFamiliares().setVisible(true);
            } else {
                JOptionPane.showMessageDialog(null, "Para editar un familiar, primero tiene que seleccionarlo y luego dar clic en el botón editar");
            }
        }
    }

    //PRECARGAMOS LOS DATOS DEL REGISTRO QUE SELECCIONAMOS PARA MODIFICAR EN LA VENTANA QUE CONTIENE EL FORMULARIO DE FAMILIARES
    public void cargarFamiliar_VentanaFamiliares() {
        int row = vistaAnamnesis.getTabComposicionFamiliarNNA().getSelectedRow();
        int column = vistaAnamnesis.getTabComposicionFamiliarNNA().getColumnCount();
        FamiliaresDB obj = new FamiliaresDB();

        for (int i = 0; i < column; i++) {
            idFamiliarUpdate = Integer.parseInt(String.valueOf(vistaAnamnesis.getTabComposicionFamiliarNNA().getValueAt(row, i)));
            vistaAnamnesis.getTxtFamiliares_nombres().setText(String.valueOf(vistaAnamnesis.getTabComposicionFamiliarNNA().getValueAt(row, i)));
            vistaAnamnesis.getTxtFamiliares_apellidos().setText(String.valueOf(vistaAnamnesis.getTabComposicionFamiliarNNA().getValueAt(row, i)));

            //Validamos el sexo e ingresamos
            String sexoFamiliar = String.valueOf(vistaAnamnesis.getTabComposicionFamiliarNNA().getValueAt(row, i));
            if (sexoFamiliar.equalsIgnoreCase("M")) {
                vistaAnamnesis.getCbxFamiliares_sexo().setSelectedItem("Masculino");
            } else if (sexoFamiliar.equalsIgnoreCase("F")) {
                vistaAnamnesis.getCbxFamiliares_sexo().setSelectedItem("Femenino");
            } else {
                vistaAnamnesis.getCbxFamiliares_sexo().setSelectedItem("Sin especificar");
            }

            vistaAnamnesis.getTxtFamiliares_edad().setText(String.valueOf(vistaAnamnesis.getTabComposicionFamiliarNNA().getValueAt(row, i)));

            vistaAnamnesis.getCbxFamiliares_estadoCivil().setSelectedItem(String.valueOf(vistaAnamnesis.getTabComposicionFamiliarNNA().getValueAt(row, i)));
            vistaAnamnesis.getTxtFamiliares_parentesco().setText(String.valueOf(vistaAnamnesis.getTabComposicionFamiliarNNA().getValueAt(row, i)));
            vistaAnamnesis.getCbxFamiliares_instruccionAcademica().setSelectedItem(String.valueOf(vistaAnamnesis.getTabComposicionFamiliarNNA().getValueAt(row, i)));
            vistaAnamnesis.getTxtFamiliares_ocupacion().setText(String.valueOf(vistaAnamnesis.getTabComposicionFamiliarNNA().getValueAt(row, i)));
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

        if (accionBtnGuardarVFamiliares.equalsIgnoreCase("Ingresar")) {
            if (anadir_editar_FamiliarNNA()) {
                //METODO DE INSERT A LA BD
                actualizarTblComposicionFamiliar();//Actualizamos la tabla
                vistaAnamnesis.getFrmFamiliares().setVisible(false);
            } else {
                JOptionPane.showMessageDialog(null, "No se pudo ingresar, revise los datos e intente nuevamente");
            }

        } else if (accionBtnGuardarVFamiliares.equalsIgnoreCase("Actualizar")) {
            if (anadir_editar_FamiliarNNA()) {
                //METODO DE UPDATE A LA BD --- USAMOS LA VARIABLE idFamiliarUpdate que contiene el id del registro a ser modificado
                actualizarTblComposicionFamiliar();//Actualizamos la tabla
                vistaAnamnesis.getFrmFamiliares().setVisible(false);
            } else {
                JOptionPane.showMessageDialog(null, "No se pudo actualizar, revise los datos e intente nuevamente");
            }
        } else if (accionBtnGuardarVFamiliares.equalsIgnoreCase("Eliminar")) {
            //LLAMAR AL METODO QUE ELIMINA EL CAMPO DE LA BD
        }
    }

    //METODO PARA AÑADIR FAMILIARES EN LA ESTRUCTURA FAMILIAR DEL NNA
    public boolean anadir_editar_FamiliarNNA() {

        System.out.println("RESULTADO ESTADO CIVIL> " + consultarIdEstadoCivil(vistaAnamnesis.getCbxFamiliares_estadoCivil().getSelectedItem().toString()));
        System.out.println("RESULTADO INSTRUCCION ACADEMICA> " + consultarIdInstruccionAcademica(vistaAnamnesis.getCbxFamiliares_instruccionAcademica().getSelectedItem().toString()));
        //Validamos
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
            return false;
        } else {
            //Seteamos el modelo
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
                return false;
            }

            //Consultamos el id de la instrucción académica seleccionada y lo guardamos en una variable para luego validarla
            String idInstruccionAcad = consultarIdInstruccionAcademica(vistaAnamnesis.getCbxFamiliares_instruccionAcademica().getSelectedItem().toString());
            if (idInstruccionAcad != null) {
                modeloFamiliaresDB.setPersona_nivel_acad(Integer.parseInt(idInstruccionAcad));//CONSULTA EL ID EN EL JSON -REALIZADO
            } else {
                System.out.println("LA INSTRUCCION ACADEMICA INGRESADA ES INCORRECTA");
                return false;
            }
            return true;//Retornará true si todo se cumplió correctamente
        }
    }

    //CONSULTA A LA BD PARA ACTUALIZAR LA TABLA
    public void actualizarTblComposicionFamiliar() {
        //Realizar el db con la consulta SELECT
        //Recorrer la lista resultante y mostrar en la tabla 
    }

    //METODOS DE VALIDACIONES SEPARADOS POR SECCIONES--------------------------------------------------------------------------------------------------------------------------------------
    //VALIDAR ENCABEZADO
    public boolean validarEncabezadoFichaAnamnesis() {
        if (vistaAnamnesis.getTxtNombreApellido().getText() == "") {
            return false;
        } else {
            return true;
        }
    }

    //VALIDACIÓN SECCIÓN: 1.1 DATOS DE IDENTIFICACIÓN - FICHA ANAMNESIS
    public boolean validardatosIdentificacion() {
        if (vistaAnamnesis.getJdcFechaNacimientoNNA().getDate() != null
                || vistaAnamnesis.getTxtLugarNacNNA1().getText() != null
                || vistaAnamnesis.getTxtNacionalidadNNA().getText() != null
                || vistaAnamnesis.getTxtEdadNNA().getText() != null
                || vistaAnamnesis.getCbxPoseeCedula().getSelectedIndex() != 0) {
            //JOptionPane.showMessageDialog(null, "Existen campos sin llenar en la sección -> 1.1 Datos de Identificación <-");
            return false;
        } else {
            return true;
        }
    }

    //VALIDACIÓN SECCIÓN: 1.2 DATOS DE LA MADRE Y EL PADRE - FICHA ANAMNESIS
    public boolean validardatosPadreMadre() {//Pendiente de cambios------------------------------------------------------------IMPORTANTE

        return false;
    }

    //VALIDACIÓN SECCIÓN: 1.3 SITUACIÓN EN LA QUE INGRESA EL NNA - FICHA ANAMNESIS
    public boolean validardatosSituacionIngresoNNA() {
        if (!"".equals(vistaAnamnesis.getTxaSituacionIngresaNNA().getText())) {
            return true;
        } else {
            //JOptionPane.showMessageDialog(null, "Porfavor llene la sección del estado de ingreso del NNA");
            return false;
        }
    }

    //VALIDACIÓN SECCIÓN: 1.4 COMPOSICIÓN FAMILIAR DEL NNA - FICHA ANAMNESIS
    public boolean validardatosComposicionFamiliarNNA() {
        if (vistaAnamnesis.getTabComposicionFamiliarNNA().getRowCount() != 0) {
            return true;
        } else {
            //JOptionPane.showMessageDialog(null, "No se a registrado ninguna composición familiar");
            return false;
        }
    }

    //VALIDACIÓN SECCIÓN: 1.5 PERIODO DE EMBARAZO - FICHA ANAMNESIS
    public boolean validardatosPeriodoEmbarazo() {
        return true;
    }

    //VALIDACIÓN SECCIÓN: 1.6 CONDICIONES DE NACIMIENTO - FICHA ANAMNESIS
    public boolean validardatosCondicionesNacimiento() {
        return true;
    }

    //VALIDACIÓN SECCIÓN: 1.7 PRIMEROS DÍAS DE VIDA - FICHA ANAMNESIS
    public boolean validardatosPrimerosDiasVida() {
        return true;
    }

    //VALIDACIÓN SECCIÓN: 1.8 ALIMENTACIÓN ACTUAL - FICHA ANAMNESIS
    public boolean validardatosAlimentacionActual() {
        return true;
    }

    //VALIDACIÓN SECCIÓN: 1.9 DESARROLLO MOTOR Y LENGUAJE ACTUAL - FICHA ANAMNESIS
    public boolean validardatosDesarrolloMotoLenguajeActual() {
        return true;
    }

    //VALIDACIÓN SECCIÓN: 1.10 SUEÑO Y CONTROL DE ESFÍNTERES - FICHA ANAMNESIS
    public boolean validardatosSuenoControlEsfinter() {
        return true;
    }

    //VALIDACIÓN SECCIÓN: 1.11 ESCOLARIZACIÓN NNA - FICHA ANAMNESIS
    public boolean validardatosEscolarizacionNNA() {
        return true;
    }

    //VALIDACIÓN SECCIÓN: 1.12 SALUD - FICHA ANAMNESIS
    public boolean validardatosSalud() {
        return true;
    }

    //VALIDACIÓN SECCIÓN: 1.13 RELACIÓN FAMILIAR - FICHA ANAMNESIS
    public boolean validardatosRelacionFamiliar() {
        return true;
    }

    //VALIDACIÓN SECCIÓN: 1.14 OBSERVACIONES GENERALES- FICHA ANAMNESIS
    public boolean validardatosObservacionesGenerales() {
        return true;
    }
}
