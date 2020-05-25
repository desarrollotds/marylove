/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package marylove.controlador;

import com.mxrck.autocompleter.TextAutoCompleter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.table.DefaultTableModel;
import marylove.DBmodelo.AnamnesisDB;
import marylove.DBmodelo.Detalle_nacimientoDB;
import marylove.DBmodelo.FamiliaresDB;
import marylove.DBmodelo.FichaAnamnesisBD;
import marylove.DBmodelo.HijosDB;
import marylove.DBmodelo.NacimientoDB;
import marylove.DBmodelo.PadreDB;
import marylove.DBmodelo.Post_partoDB;
import marylove.DBmodelo.jsonDB;
import marylove.DBmodelo.victimaDB;
import marylove.DBmodelo.Embarazo_estadoDB;
import marylove.models.Familiares;
import marylove.models.Embarazo_estado;
import marylove.models.Hijos;
import marylove.models.Json_object_consulta;
import marylove.models.Padre;
import marylove.models.Victima;
import marylove.vista.FichaAnamnesis;
import org.json.simple.parser.ParseException;

/**
 *
 * @author Usuario
 */
public class ControladorFichaAnamnesis extends Validaciones implements ChangeListener {

    private FichaAnamnesisBD modeloFichaAnamnesisBD = new FichaAnamnesisBD();
    private final FichaAnamnesis vistaAnamnesis;
    private HijosDB modeloHijosDB = new HijosDB();
    private PadreDB modeloPadreDB = new PadreDB();
    private FamiliaresDB modeloFamiliaresDB = new FamiliaresDB();
    private NacimientoDB modeloNacimientoDB = new NacimientoDB();
    private Detalle_nacimientoDB modeloDetalle_nacimientoDB = new Detalle_nacimientoDB();
    private Post_partoDB modeloPost_partoDB = new Post_partoDB();
    DefaultTableModel tablaFamiliares;
    //DECLARAMOS VARIABLES LOCALES PARA VALIDACIONES
    private String accionBtnGuardarVFamiliares;
    private int idFamiliarUpdate;
    private int indiceVentanaCambiada = 0;
    victimaDB vDB;
    FamiliaresDB fDB;
   Embarazo_estadoDB EEDB;
    public ControladorFichaAnamnesis(FichaAnamnesis vistaAnamnesis) throws ParseException {
        this.vistaAnamnesis = vistaAnamnesis;
//        this.vistaAnamnesis.setLocationRelativeTo(null);
//        this.vistaAnamnesis.setVisible(true);
//        this.vistaAnamnesis.getFrmFamiliares().setLocationRelativeTo(null);

    }

    public void inciarControl() {
        //CARGAMOS LOS JSONS QUE VAMOS A USAR EN LA VISTA
        cargarJsons();
        //CONTROL DE BOTONES
        vistaAnamnesis.setVisible(true);
        vistaAnamnesis.getBtnGuardar().addActionListener(e -> guardarDatos());
        vistaAnamnesis.getBtnAñadir().addActionListener(e -> mostrarVentanaAnadirFamiliares("Ingresar"));
        vistaAnamnesis.getBtnEditar().addActionListener(e -> mostrarVentanaAnadirFamiliares("Actualizar"));
        vistaAnamnesis.getBtnFamiliares_anadirFamiliar().addActionListener(e -> accionBtnFormFamiliares());

        //CONTROLADORES DE FECHAS
        vistaAnamnesis.getJdcFechaElaboracion().setCalendar(Calendar.getInstance());

        //CONTROLES DE TEXTOS
        vistaAnamnesis.getTxtCedula().addKeyListener(validarCedula(vistaAnamnesis.getTxtCedula()));
        vistaAnamnesis.getTxtEdadNNA().addKeyListener(validarNumeros(vistaAnamnesis.getTxtEdadNNA()));
        vistaAnamnesis.getTxtEdadPadre().addKeyListener(validarNumeros(vistaAnamnesis.getTxtEdadPadre()));
        vistaAnamnesis.getTxtEdadMadre().addKeyListener(validarNumeros(vistaAnamnesis.getTxtEdadMadre()));
        vistaAnamnesis.getTxtFamiliares_edad().addKeyListener(validarNumeros(vistaAnamnesis.getTxtFamiliares_edad()));
        vistaAnamnesis.getTxtVecesComeDia().addKeyListener(validarNumeros(vistaAnamnesis.getTxtVecesComeDia()));

        //CONTROL DE PESTAÑAS DE LA FICHA
        vistaAnamnesis.getJtpPrincipal().addChangeListener(e -> stateChanged(e));
        //AnamnesisDB anam = new AnamnesisDB();
        System.out.println("holddddd");
        // anam.conectarTodo(Integer.parseInt(vistaAnamnesis.getTxtCodigo().getText()));

        llenarCamposAnamesis();
    }

    

public void llenarCamposAnamesis() {
        FormatoTabla();

        Hijos j = new Hijos();
        modeloHijosDB = new HijosDB();
        modeloHijosDB.HijosAnamnesis(j);
        vistaAnamnesis.getTxtNombre().setText(j.getPersona_nombre());
        System.out.println(j.getPersona_nombre());
        vistaAnamnesis.getTxtApellido().setText(j.getPersona_apellido());
        vistaAnamnesis.getTxtCedula().setText(j.getPersona_cedula());
        //  vistaAnamnesis.getJdcFechaElaboracion().setDate(j.getPersona_fecha_nac());
        if (!j.getPersona_cedula().equals("") || !j.getPersona_cedula().equals(null)) {
            vistaAnamnesis.getCbxPoseeCedula().setSelectedIndex(1);
        } else {
            vistaAnamnesis.getCbxPoseeCedula().setSelectedIndex(2);
        }
        vistaAnamnesis.getTxtEdadNNA().setText(String.valueOf(j.getEdad()));
        vistaAnamnesis.getTxaSituacionIngresaNNA().setText(j.getHijo_estado_ingreso());
        if (j.isHijos_estado() == true) {
            vistaAnamnesis.getCbxPadreAgresor().setSelectedIndex(1);
        } else if (j.isHijos_estado() == false) {
            vistaAnamnesis.getCbxPadreAgresor().setSelectedIndex(2);
        } else {
            vistaAnamnesis.getCbxPadreAgresor().setSelectedIndex(0);
        }
        Victima v = new Victima();
        vDB = new victimaDB();
        vDB.MadreVictimaAnamnesis(v);
        //Madre
        System.out.println(v.getPersona_nombre());
        vistaAnamnesis.getTxtNombreMadre().setText(v.getPersona_nombre());
        vistaAnamnesis.getTxtApellidoMadre().setText(v.getPersona_apellido());
        vistaAnamnesis.getTxtEdadMadre().setText(String.valueOf(v.getEdad()));
        //Padre
        jsonDB claseJsonDB = new jsonDB();
        Padre pa = new Padre();
        modeloPadreDB = new PadreDB();
        modeloPadreDB.PadreAnamnesis(pa);
        // System.out.println(pa.getPersona_nombre());
        vistaAnamnesis.getTxtNombrePadre().setText(pa.getPersona_nombre());
        vistaAnamnesis.getTxtApellidoPadre().setText(pa.getPersona_apellido());
        vistaAnamnesis.getTxtEdadPadre().setText(String.valueOf(pa.getEdad()));

        try {
            // listaNacionalidades = claseJsonDB.obtenerNacionalidades();
            for (int i = 0; i < listaNacionalidades.size(); i++) {
                if (listaNacionalidades.get(i).getId() == j.getPersona_nacionalidad()) {
                    vistaAnamnesis.getJcb_nacionalid_id().setSelectedItem(String.valueOf(listaNacionalidades.get(i).getValor()));
                } else if (listaNacionalidades.get(i).getId() == v.getPersona_nacionalidad()) {
                    vistaAnamnesis.getJcb_nacionalidad_madre().setSelectedItem(String.valueOf(listaNacionalidades.get(i).getValor()));
                } else if (listaNacionalidades.get(i).getId() == pa.getPersona_nacionalidad()) {
                    vistaAnamnesis.getJcb_nacionalidad_padre().setSelectedItem(String.valueOf(listaNacionalidades.get(i).getValor()));
                } else {

                }
            }
        } catch (Exception ex) {
            Logger.getLogger(ControladorFichaAnamnesis.class.getName()).log(Level.SEVERE, null, ex);
        }
        //Familiares
        CargarTablaFamiliares();
        //EmbarazoEstado
        EEDB = new Embarazo_estadoDB();
        Embarazo_estado EE = new Embarazo_estado();
        EEDB.EmbarazoAnamnesis(EE);
        
        if (EE.isEmbarazo_planificado() == true) {
            vistaAnamnesis.getCbxEmbarazoPlanificado().setSelectedIndex(1);
        } else if (EE.isEmbarazo_planificado() == false) {
            vistaAnamnesis.getCbxEmbarazoPlanificado().setSelectedIndex(2);
        }
        vistaAnamnesis.getTxtReaccionMama().setText(EE.getEmbarazo_reaccion_madre());
        vistaAnamnesis.getTxtReaccionPapa().setText(EE.getEmbarazo_reaccion_padre());
        vistaAnamnesis.getTxtDondeRealizoControles().setText(EE.getDonde_realizo_controles());
        vistaAnamnesis.getTxtCausasConsumo().setText(EE.getConsumo_causas());
        vistaAnamnesis.getTxtCausasAborto().setText(EE.getAborto_causas()); 

    }

    //ArrayList<Json_object_consulta> listaNacionalidades2 = new ArrayList<>();

    public void FormatoTabla() {
        tablaFamiliares = new DefaultTableModel();
        tablaFamiliares.addColumn("Id");
        tablaFamiliares.addColumn("Nombres");
        tablaFamiliares.addColumn("Apellidos");
        tablaFamiliares.addColumn("Sexo");
        tablaFamiliares.addColumn("Estado Civil");
        tablaFamiliares.addColumn("Parentesco");
        tablaFamiliares.addColumn("Ocupacion");
        tablaFamiliares.addColumn("Edad");

        this.vistaAnamnesis.getTabComposicionFamiliarNNA().setModel(tablaFamiliares);
    }

    public void CargarTablaFamiliares() {
        Familiares f = new Familiares();
        fDB = new FamiliaresDB();
        fDB.FamiliaresAnamnesis(f);
        String[] datos;

        for (Familiares e : FamiliaresDB.listaFamiliares) {
            datos = new String[9];
            datos[0] = e.getFamiliares_id() + "";
            datos[1] = e.getPersona_nombre() + "";
            datos[2] = e.getPersona_apellido() + " ";
            datos[3] = e.getPersona_sexo() + " ";
            for (int i = 0; i < listaEstadoCivil.size(); i++) {
                if (listaEstadoCivil.get(i).getId() == e.getPersona_estadocivil()) {
                    datos[4] = listaEstadoCivil.get(i).getValor() + " ";
                }
            }

            datos[5] = e.getParentesco() + " ";
            for (int i = 0; i < listaOcupaciones.size(); i++) {
                if (listaOcupaciones.get(i).getId() == e.getPersona_ocupacion()) {
                    datos[6] = listaOcupaciones.get(i).getValor() + " ";
                }
            }

            datos[7] = e.getEdad() + " ";

            this.tablaFamiliares.addRow(datos);
        }
        FamiliaresDB.listaFamiliares.clear();
        vistaAnamnesis.getTabComposicionFamiliarNNA().setModel(this.tablaFamiliares);
    }
    // ArrayList<Json_object_consulta> listaNacionalidades = new ArrayList<>();

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
//                String result = validardatosIdentificacion() + "";
//                System.out.println("Validacion pestaña identificacion: " + result);
                System.out.println("LA SELECCION ANTERIOR FUE DATOS DE IDENTIFICACIÓN");
                //Llamar al metodo de ejecución de la función 
                cargardatosIdentificacion();
                System.out.println("LISTO PESTAÑA 1");
                //Llamar al db
                break;
            case 1://DATOS DE LA MADRE Y PADRE

//                String result1 = validardatosPadreMadre() + "";
//                System.out.println("Validacion pestaña datMadreyPadre: " + result1);
                System.out.println("LA SELECCION ANTERIOR FUE DATOS DE LA MADRE Y EL PADRE");

                cargardatosPadreMadre();
                System.out.println("LISTO PESTAÑA 2");
                //Llamar al método que ejecuta la función en anamnesisDB
                break;
            case 2://COMPOSICIÓN FAMILIAR NNA

//                String result2 = validardatosComposicionFamiliarNNA() + "";
//                System.out.println("Validacion pestaña composicion: " + result2);
                System.out.println("LA SELECCION ANTERIOR FUE COMPOSICIÓN FAMMILIAR NNA");
                //Esta pestaña no necesita updates, solo una validación final.

                break;
            case 3://PERIODO DE EMBARAZO
//                String result3 = validardatosPeriodoEmbarazo() + "";
//                System.out.println("los campos no fueron llenados: " + result3);
                System.out.println("LA SELECCION ANTERIOR FUE DE EMBARAZO");

                //Llamar al método de actualizarPeriodoEmbarazo en la clase PeriodoEmbarazoDB
                break;
            case 4://CONDICIONES DE NACIMIENTO 

                //String result4 = validardatosCondicionesNacimiento() + "";
                //System.out.println("Validacion pestaña condiciones: " + result4);
                System.out.println("LA SELECCION ANTERIOR FUE CONDICIONES DE NACIMIENTO");

                cargardatosCondicionesNacimiento();
                System.out.println("LISTO PESTAÑA 5");
                //Llamar al método actualizarConficionesNacimiento en la clase NacimientoDB

                break;
            case 5://PRIMEROS DÍAS DE VIDA

//                String result5 = validardatosPrimerosDiasVida() + "";
//                System.out.println("Validacion pestaña primerosDias: " + result5);
                System.out.println("LA SELECCION ANTERIOR FUE PRIMEROS DÍAS DE VIDA");

                cargardatosPrimerosDiasVida();
                System.out.println("LISTO PESTAÑA 6");
                //Llamar al metodo de ejecución de la consulta en la clase postpartoDB
                break;
            case 6://ALIMENTACIÓN ACTUAL

//                String result6 = validardatosAlimentacionActual() + "";
//                System.out.println("Validacion pestaña alimentacion: " + result6);
                System.out.println("LA SELECCION ANTERIOR FUE ALIMENTACIÓN ACTUAL");

                cargardatosAlimentacionActual();
                System.out.println("LISTO PESTAÑA 7");
                //Llamar al metodo de ejecución de la consulta en la clase postpartoDB
                break;
            case 7://DESARROLLO DE MOTOR Y LENGUAJE ACTUAL

//                String result7 = validardatosDesarrolloMotoLenguajeActual() + "";
//                System.out.println("Validacion pestaña desarrolorMotor: " + result7);
                System.out.println("LA SELECCION ANTERIOR FUE DESARROLLO DE MOTOR GRUESO Y LENGUAJE CORPORAL");
                break;
            case 8://SUEÑO Y CONTROL DE ESFÍNTERES

//                String result8 = validardatosSuenoControlEsfinter() + "";
//                System.out.println("Validacion pestaña suenios: " + result8);
                System.out.println("LA SELECCION ANTERIOR FUE SUEÑO Y CONTROL DE ESFÍNTERES");
                break;
            case 9://ESCOLARIZACIÓN NNA

//                String result9 = validardatosEscolarizacionNNA() + "";
//                System.out.println("Validacion pestaña escolarizacion: " + result9);
                System.out.println("LA SELECCION ANTERIOR FUE ESCOLARICACIÓN NNA");
                break;
            case 10://SALUD 

//                String result10 = validardatosSalud() + "";
//                System.out.println("Validacion pestaña salud: " + result10);
                System.out.println("LA SELECCION ANTERIOR FUE SALUD");
                break;
            case 11://RELACIÓN FAMILIAR 

//                String result11 = validardatosIdentificacion() + "";
//                System.out.println("Validacion pestaña identificacion: " + result11);
                System.out.println("LA SELECCION ANTERIOR FUE RELACIÓN FAMMILIAR");
                break;
            case 12://OBSERVACIONES GENERALES

//                String result12 = validardatosObservacionesGenerales() + "";
//                System.out.println("Validacion pestaña obeservaciones: " + result12);
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

    //FORMATEAR MODELOS
    public void formatearModelos() {
        modeloFichaAnamnesisBD = new FichaAnamnesisBD();
        modeloHijosDB = new HijosDB();
        modeloPadreDB = new PadreDB();
        modeloFamiliaresDB = new FamiliaresDB();
        modeloNacimientoDB = new NacimientoDB();
        modeloDetalle_nacimientoDB = new Detalle_nacimientoDB();
        modeloPost_partoDB = new Post_partoDB();
    }

    //ENCABEZADO DE LA FICHA NNA
    public void cargardatosEncabezadoFichaAnamnesis() {
        modeloHijosDB.setPersona_nombre(vistaAnamnesis.getTxtNombreApellido().getText());//Seteamos el nombre
        modeloHijosDB.setPersona_apellido(vistaAnamnesis.getTxtNombreApellido().getText());//Seteamos el apellido
        modeloHijosDB.setPersona_cedula(vistaAnamnesis.getTxtCedula().getText());
    }

    //CARGAR DATOS: 1.1 DATOS DE IDENTIFICACIÓN - FICHA ANAMNESIS
    public void cargardatosIdentificacion() {
        formatearModelos();//Formateamos los modelos
        //Como anteriormente creamos un objeto modelo de la clase HijosDB y estamos guardando datos del mismo nna entoncces procedemos a usarle mismo objeto
        //fecha nacimiento
        if (vistaAnamnesis.getJdcFechaNacimientoNNA().getDate() != null) {
            modeloHijosDB.setPersona_fecha_nac(fechaBD(vistaAnamnesis.getJdcFechaNacimientoNNA().getDate().getTime()));
        }
        //lugar de nacimiento
        modeloNacimientoDB.setLugar_nacimiento(vistaAnamnesis.getTxtLugarNacNNA1().getText());
        //Consultamos el id de la nacionalidad seleccionada y guardamos el resultado de en una variable
        //nacionalidad
        if (vistaAnamnesis.getJcb_nacionalid_id().getSelectedIndex() > 0) {
            modeloHijosDB.setPersona_nacionalidad(Integer.parseInt(consultarIdNacionalidad(vistaAnamnesis.getJcb_nacionalid_id().getSelectedItem().toString())));//Ingresamos el id obtenido de la nacionalidad al modelo
        }
        //PENDIENTE VALIDA LA EDAD Y EL COMBO "POSEE CEDULA"
    }

    //CARGAR DATOS: 1.2 DATOS DE LA MADRE Y EL PADRE - FICHA ANAMNESIS
    public void cargardatosPadreMadre() {//Pendiente de cambios------------------------------------------------------------IMPORTANTE
        formatearModelos();//Formateamos los modelos
        //nombre padre
        modeloPadreDB.setPersona_nombre(vistaAnamnesis.getTxtNombrePadre().getText());
        //apellido padre
        modeloPadreDB.setPersona_apellido(vistaAnamnesis.getTxtApellidoPadre().getText());
        //nacionalidad padre
        if (vistaAnamnesis.getJcb_nacionalidad_padre().getSelectedIndex() > 0) {
            modeloPadreDB.setPersona_nacionalidad(Integer.parseInt(consultarIdNacionalidad(vistaAnamnesis.getJcb_nacionalidad_padre().getSelectedItem().toString())));
        }
        //edad padre
        String edad = vistaAnamnesis.getTxtEdadPadre().getText();
        if (!"".equals(edad)) {
            modeloPadreDB.setEdad(Integer.parseInt(edad));
        }
        //padre agresor
        if ("Si".equals(vistaAnamnesis.getCbxPadreAgresor().getSelectedItem().toString())) {
            modeloHijosDB.setPadre_agresor(true);
        } else if ("No".equals(vistaAnamnesis.getCbxPadreAgresor().getSelectedItem().toString())) {
            modeloHijosDB.setPadre_agresor(false);
        }

        //CARGAR DATOS: 1.3 SITUACIÓN EN LA QUE INGRESA EL NNA - FICHA ANAMNESIS
        modeloHijosDB.setHijo_estado_ingreso(vistaAnamnesis.getTxaSituacionIngresaNNA().getText());

    }

    //CARGAR DATOS: 1.4 COMPOSICIÓN FAMILIAR DEL NNA - FICHA ANAMNESIS
    public void cargardatosComposicionFamiliarNNA() {
        //El usuario podra ingresar, editar y eliminar familiares de su composición familiar
        //Se cargaran datos a la tabla y luego a la base
    }

    //CARGAR DATOS: 1.5 PERIODO DE EMBARAZO
    public void cargardatosPeriodoEmbarazo() {
        //formatearModelos();//Formateamos los modelos
    }

    //CARGAR DATOS: 1.6 CONDICIONES DE NACIMIENTO
    public void cargardatosCondicionesNacimiento() {
        formatearModelos();//Formateamos los modelos    
        //mes alumbramiento
        if (vistaAnamnesis.getJcb_mes_alumbramiento().getSelectedIndex() > 0) {
            modeloNacimientoDB.setMes_alumbramiento(vistaAnamnesis.getJcb_mes_alumbramiento().getSelectedIndex());
        }
        //lugar alumbramiento
        modeloNacimientoDB.setLugar_nacimiento(vistaAnamnesis.getTxtLugarParto().getText());
        //tipo de parto
        if (vistaAnamnesis.getJcxNormal().isSelected()) {
            modeloNacimientoDB.setParto_tipo("Normal");
        } else if (vistaAnamnesis.getJcxNormal().isSelected()) {
            modeloNacimientoDB.setParto_tipo("Cesárea");
        }
        //motivo de cesárea
        modeloNacimientoDB.setObservaciozes_parto(vistaAnamnesis.getTxtMotivoCesarea().getText());
        //usaron anestesia
        if (vistaAnamnesis.getJcxSiAnestesia().isSelected()) {
            modeloNacimientoDB.setAnestesia(true);
        } else if (vistaAnamnesis.getJcxNoAnestesia().isSelected()) {
            modeloNacimientoDB.setAnestesia(false);
        }
        //lloro al nacer
        if (vistaAnamnesis.getJcxSiLloro().isSelected()) {
            modeloDetalle_nacimientoDB.setLloro_nac(true);
        } else if (vistaAnamnesis.getJcxNoLloro().isSelected()) {
            modeloDetalle_nacimientoDB.setLloro_nac(false);
        }
        //necesito oxigeno
        if (vistaAnamnesis.getJcxSiOxigeno().isSelected()) {
            modeloDetalle_nacimientoDB.setNecesito_oxigeno(true);
        } else if (vistaAnamnesis.getJcxNoOxigeno().isSelected()) {
            modeloDetalle_nacimientoDB.setNecesito_oxigeno(false);
        }
        //peso
        modeloDetalle_nacimientoDB.setPeso(vistaAnamnesis.getTxtPeso().getText());
        //talla
        modeloDetalle_nacimientoDB.setTalla(vistaAnamnesis.getTxtTalla().getText());
        //sintomas después del parto
        if (vistaAnamnesis.getJcxDepresion().isSelected()) {
            modeloDetalle_nacimientoDB.setSintomas_after_part("Depresión");
        } else if (vistaAnamnesis.getJcxHipersencibilidad().isSelected()) {
            modeloDetalle_nacimientoDB.setSintomas_after_part("Hipersensibilidad");
        }
        //sexo esperado
        if (vistaAnamnesis.getJcxSiSexo().isSelected()) {
            modeloPost_partoDB.setSexo_esperado(true);
        } else if (vistaAnamnesis.getJcxNoSexo().isSelected()) {
            modeloPost_partoDB.setSexo_esperado(false);
        }
        //reaccion madre
        modeloPost_partoDB.setReaccion_madre(vistaAnamnesis.getTxtReaccionMadre().getText());
        //reaccion padre
        modeloPost_partoDB.setReaccion_padre(vistaAnamnesis.getTxtReaccionPadre().getText());
    }

    //CARGAR DATOS: 1.7 PRIMEROS DÍAS DE VIDA 
    public void cargardatosPrimerosDiasVida() {
        formatearModelos();//Formateamos los modelos

        if (vistaAnamnesis.getJcxSiLeche().isSelected()) {
            modeloPost_partoDB.setAlim_leche_mater(true);
        } else if (vistaAnamnesis.getJcxNoLeche().isSelected()) {
            modeloPost_partoDB.setAlim_leche_mater(false);
        }
        modeloPost_partoDB.setAlim_leche_master_descrip(vistaAnamnesis.getTxtPorqueLeche().getText());
        modeloPost_partoDB.setEdad_fin_leche_mater(vistaAnamnesis.getTxtEdadDioLeche().getText());
        //HABLAR SOBRE EL TIPO DE DATO DEL BIBERON
        if (vistaAnamnesis.getJcxSiBiberon().isSelected()) {
            modeloPost_partoDB.setBiberon(true);
        } else if (vistaAnamnesis.getJcxNoBiberon().isSelected()) {
            modeloPost_partoDB.setBiberon(false);
        }
        modeloPost_partoDB.setBiberon_edad_ini(vistaAnamnesis.getTxtDesdeEdadBiberon().getText());
        modeloPost_partoDB.setBiberon_edad_fin(vistaAnamnesis.getTxtHastaEdadBiberon().getText());
        if (vistaAnamnesis.getJcxSiSuccionar().isSelected()) {
            modeloPost_partoDB.setProblemas_succion(true);
        } else if (vistaAnamnesis.getJcxNoSuccionar().isSelected()) {
            modeloPost_partoDB.setProblemas_succion(false);
        }
        modeloPost_partoDB.setDestete_descripcion(vistaAnamnesis.getTxtComoFueDestete().getText());
        modeloPost_partoDB.setEdad_sentar(vistaAnamnesis.getTxtEdadSento().getText());
        modeloPost_partoDB.setEdad_caminar(vistaAnamnesis.getTxtEdadCamino().getText());
        modeloPost_partoDB.setEdad_primeras_palabras(vistaAnamnesis.getTxtEdadPrimerasPalabras().getText());

    }

    //CARGAR DATOS: 1.8 ALIMENTACIÓN ACTUAL 
    public void cargardatosAlimentacionActual() {
        formatearModelos();//Formateamos los modelos

        modeloPost_partoDB.setEdad_aliment_solido(vistaAnamnesis.getTxtInicioSolidos().getText());
        modeloPost_partoDB.setDificultades_alimentacion(vistaAnamnesis.getJtxtdificultadesAlimentacion().getText());
        if (!"".equals(vistaAnamnesis.getTxtVecesComeDia().getText())) {
            modeloPost_partoDB.setVeces_como_diario(Integer.parseInt(vistaAnamnesis.getTxtVecesComeDia().getText()));
        }
        modeloPost_partoDB.setComer_solo_acompanado(vistaAnamnesis.getTxtComeSolooAcompanhado().getText());
        modeloPost_partoDB.setActitud_madre_no_come(vistaAnamnesis.getTxtActitudMadre().getText());
    }

    //CARGAR DATOS: 1.9 DESARROLLO MOTOR Y LENGUAJE ACTUAL
    public void cargardatosDesarrolloMotoLenguajeActual() {
        formatearModelos();//Formateamos los modelos

    }

    //CARGAR DATOS: 1.10 SUEÑO Y CONTROL DE ESFÍNTERES 
    public void cargardatosSuenoControlEsfinter() {
        formatearModelos();//Formateamos los modelos
    }

    //CARGAR DATOS: 1.11 ESCOLARIZACIÓN NNA 
    public void cargardatosEscolarizacionNNA() {
        formatearModelos();//Formateamos los modelos
    }

    //CARGAR DATOS: 1.12 SALUD 
    public void cargardatosSalud() {
        formatearModelos();//Formateamos los modelos
    }

    //CARGAR DATOS: 1.13 RELACIÓN FAMILIAR 
    public void cargardatosRelacionFamiliar() {
        formatearModelos();//Formateamos los modelos
    }

    //CARGAR DATOS: 1.14 OBSERVACIONES GENERALES
    public void cargardatosObservacionesGenerales() {
        formatearModelos();//Formateamos los modelos
    }

    //METODOS------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
    //METODO PARA AUTOCOMPLETAR TEXTFIELD DE NACIONALIDADES
    public void autocompletarListaNacionalidades() {
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
        try {
            for (int i = 0; i < listaNacionalidades.size(); i++) {
                vistaAnamnesis.getJcb_nacionalid_id().addItem(listaNacionalidades.get(i).getValor());
                vistaAnamnesis.getJcb_nacionalidad_madre().addItem(listaNacionalidades.get(i).getValor());
                vistaAnamnesis.getJcb_nacionalidad_padre().addItem(listaNacionalidades.get(i).getValor());
            }

            //Cargamos la lista de estado civil en los componentes que lo utilizan
            for (int i = 0; i < listaEstadoCivil.size(); i++) {
                vistaAnamnesis.getCbxFamiliares_estadoCivil().addItem(listaEstadoCivil.get(i).getValor());
            }

            //Cargamos la lista de instrucciones académicas en los componentes que la usan
            for (int i = 0; i < listaInstruccionAcademica.size(); i++) {
                vistaAnamnesis.getCbxFamiliares_instruccionAcademica().addItem(listaInstruccionAcademica.get(i).getValor());
            }
        } catch (Exception e) {
            System.out.println("ERROR>" + e);
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
                || /*vistaAnamnesis.getTxtNacionalidadNNA().getText() != null
                || */ vistaAnamnesis.getTxtEdadNNA().getText() != null
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
    //validaciones

    //VALIDACIÓN SECCIÓN: 1.5 PERIODO DE EMBARAZO - FICHA ANAMNESIS
    public boolean validardatosPeriodoEmbarazo() {
        if (null != vistaAnamnesis.getCbxEmbarazoPlanificado().getSelectedItem().toString()
                || vistaAnamnesis.getTxtReaccionPadre().getText().equals("")
                || vistaAnamnesis.getTxtReaccionMama().getText().equals("")
                || vistaAnamnesis.getTxtDondeRealizoControles().getText().equals("")
                || vistaAnamnesis.getTxtReaccionMama().getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Llene todos los campos");
            return false;
        }
        if (vistaAnamnesis.getJcxSiViolencia().isSelected() == false
                && vistaAnamnesis.getJcxNoViolencia().isSelected() == false
                && vistaAnamnesis.getJcxGolpes().isSelected() == false
                && vistaAnamnesis.getJcxAbusoSexual().isSelected() == false
                && vistaAnamnesis.getJcxInsultos().isSelected() == false
                && vistaAnamnesis.getJcxNegligencia().isSelected() == false
                && vistaAnamnesis.getJcxAmbitoLaboral().isSelected() == false) {
            JOptionPane.showMessageDialog(null, "Seleccine una opcion en sufrio episodios de violencia");
            return false;
            //pregunta realizo controles medicos
        }
        if (vistaAnamnesis.getJcxSiControles().isSelected() == false
                && vistaAnamnesis.getJcxNoControles().isSelected() == false
                && vistaAnamnesis.getJcxMensual().isSelected() == false
                && vistaAnamnesis.getJcxUnaVez().isSelected() == false
                && vistaAnamnesis.getJcxTrimestral().isSelected() == false
                && vistaAnamnesis.getJcxNinguna().isSelected() == false) {

            JOptionPane.showMessageDialog(null, "Seleccine una opcion en realizo controles medicos");
            return false;
            // pregunta complicaciones en el embarazo
        }
        if (vistaAnamnesis.getJcxSiComplicaciones().isSelected() == false
                && vistaAnamnesis.getJcxNoComplicaciones().isSelected() == false
                && vistaAnamnesis.getJcxBajoPeso().isSelected() == false
                && vistaAnamnesis.getJcxHemorragias().isSelected() == false
                && vistaAnamnesis.getJcxInfecciones().isSelected() == false
                && vistaAnamnesis.getJcxNoViolencia().isSelected() == false
                && vistaAnamnesis.getJcxPreclansia().isSelected() == false) {
            JOptionPane.showMessageDialog(null, "Seleccine una opcion en complicaciones de el embarazo");
            return false;
            // pregunta hubo consumo en el embarazo
        }
        if (vistaAnamnesis.getJcxSiConsume().isSelected() == false
                && vistaAnamnesis.getJcxNoConsume().isSelected() == false
                && vistaAnamnesis.getJcxTabaco().isSelected() == false
                && vistaAnamnesis.getJcxAlcohol().isSelected() == false
                && vistaAnamnesis.getJcxDroga().isSelected() == false) {
            JOptionPane.showMessageDialog(null, "Seleccine una opcion si realizo algun tipo de consumo");
            return false;
            // pregunta tentativas de aborto
        }
        if (vistaAnamnesis.getJcxNoViolencia().isSelected() == false
                && vistaAnamnesis.getJcxSiAborto().isSelected() == false
                && vistaAnamnesis.getJcxNoAborto().isSelected() == false) {
            JOptionPane.showMessageDialog(null, "Seleccine una opcion en tentatica de aborto");
            return false;
        } else {
            //codigo
            return true;
        }
    }

    //VALIDACIÓN SECCIÓN: 1.6 CONDICIONES DE NACIMIENTO - FICHA ANAMNESIS
    public boolean validardatosCondicionesNacimiento() {
        if (null != vistaAnamnesis.getCbxEmbarazoPlanificado().getSelectedItem().toString()
                || vistaAnamnesis.getTxtReaccionPadre().getText().equals("")
                || vistaAnamnesis.getTxtReaccionMama().getText().equals("")
                || vistaAnamnesis.getTxtDondeRealizoControles().getText().equals("")
                || vistaAnamnesis.getTxtReaccionMama().getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Llene todos los campos");
            return false;
        }
        if (vistaAnamnesis.getJcxNormal().isSelected() == false
                && vistaAnamnesis.getJcxCesarea().isSelected() == false) {
            JOptionPane.showMessageDialog(null, "Seleccione una opcion en tipo de parto");
            return false;
            // pregunta utilizaon anastesia
        }
        if (vistaAnamnesis.getJcxSiAnestesia().isSelected() == false
                && vistaAnamnesis.getJcxNoAnestesia().isSelected() == false) {
            JOptionPane.showMessageDialog(null, "Seleccione una opcion en utilizaron anestesia");
            return false;
            // pregunta lloro al nacer
        }
        if (vistaAnamnesis.getJcxSiLloro().isSelected() == false
                && vistaAnamnesis.getJcxNoLloro().isSelected() == false) {
            JOptionPane.showMessageDialog(null, "Seleccione una opcion en lloro al nacer");
            return false;
            //  pregunta necesito oxigeno
        }
        if (vistaAnamnesis.getJcxSiOxigeno().isSelected() == false
                && vistaAnamnesis.getJcxNoOxigeno().isSelected() == false) {
            JOptionPane.showMessageDialog(null, "Seleccione una opcion en necesito oxigeno");
            return false;
            // pregunta como se sintio despues del parto
        }
        if (vistaAnamnesis.getJcxDepresion().isSelected() == false
                && vistaAnamnesis.getJcxHipersencibilidad().isSelected() == false) {
            JOptionPane.showMessageDialog(null, "Seleccione una opcion en desoues del parto");
            return false;
            // pregunta fue del sexo esperado
        }
        if (vistaAnamnesis.getJcxSiSexo().isSelected() == false
                && vistaAnamnesis.getJcxNoSexo().isSelected() == false) {
            JOptionPane.showMessageDialog(null, "Seleccione una opcion en fue el sexo esperado");
            return false;
        } else {
            System.out.println("Validacion valida :v");

            return true;
        }
    }

    //VALIDACIÓN SECCIÓN: 1.7 PRIMEROS DÍAS DE VIDA - FICHA ANAMNESIS
    public boolean validardatosPrimerosDiasVida() {
        if (vistaAnamnesis.getTxtPorqueLeche().getText().equals("")
                || vistaAnamnesis.getTxtHastaEdadBiberon().getText().equals("")
                || vistaAnamnesis.getTxtEdadDioLeche().getText().equals("")
                || vistaAnamnesis.getTxtDesdeEdadBiberon().getText().equals("")
                || vistaAnamnesis.getTxtHastaEdadBiberon().getText().equals("")
                || vistaAnamnesis.getTxtComoFueDestete().getText().equals("")
                || vistaAnamnesis.getTxtEdadSento().getText().equals("")
                || vistaAnamnesis.getTxtEdadCamino().getText().equals("")
                || vistaAnamnesis.getTxtEdadPrimerasPalabras().getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Llene todos los campos.");
            return false;
        } // pregunta alimentacion materna
        if (vistaAnamnesis.getJcxSiLeche().isSelected() == false
                && vistaAnamnesis.getJcxNoLeche().isSelected() == false) {
            JOptionPane.showMessageDialog(null, "Seleccione la opcion en alimentacion materna");
            return false;
            // pregunta uso biberon
        }
        if (vistaAnamnesis.getJcxSiBiberon().isSelected() == false
                && vistaAnamnesis.getJcxNoBiberon().isSelected() == false
                && vistaAnamnesis.getJcxAmbos().isSelected() == false) {
            JOptionPane.showMessageDialog(null, "Seleccione la opcion en uso biberon");
            return false;
            // preguntas dificultades para succionar
        }
        if (vistaAnamnesis.getJcxSiSuccionar().isSelected() == false
                && vistaAnamnesis.getJcxNoSuccionar().isSelected() == false) {
            JOptionPane.showMessageDialog(null, "Seleccione la opcion en dificultades al succionar");
            return false;
        } else {
            System.out.println("Validacion correcta");
            return true;
        }
    }

    //VALIDACIÓN SECCIÓN: 1.8 ALIMENTACIÓN ACTUAL - FICHA ANAMNESIS
    public boolean validardatosAlimentacionActual() {
        if (vistaAnamnesis.getTxtInicioSolidos().getText().equals("")
                || vistaAnamnesis.getTxtVecesComeDia().getText().equals("")
                || vistaAnamnesis.getTxtComeSolooAcompanhado().getText().equals("")
                || vistaAnamnesis.getTxtActitudMadre().getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Llene todos los campos.");
            return false;
        } else { // codigo

            return true;
        }
    }

    //VALIDACIÓN SECCIÓN: 1.9 DESARROLLO MOTOR Y LENGUAJE ACTUAL - FICHA ANAMNESIS
    public boolean validardatosDesarrolloMotoLenguajeActual() {
        if (vistaAnamnesis.getTxtDificultadEspecifique().getText().equals("")
                || vistaAnamnesis.getTxtComoSonMovimientos().getText().equals("")
                || vistaAnamnesis.getTxtPsicoSocial().getText().equals("")
                || vistaAnamnesis.getTxtCognitivo().getText().equals("")
                || vistaAnamnesis.getTxtfisico().getText().equals("")) {

            JOptionPane.showMessageDialog(null, "Llene todos los campos.");
            return false;
        }
        if (vistaAnamnesis.getJcxNormalMotorGrueso().isSelected() == false
                && vistaAnamnesis.getJcxIrregularMotorGrueso().isSelected() == false) {
            JOptionPane.showMessageDialog(null, "Seleccione la opcion en desarrollo motor grueso.");
            return false;
            //pregunta motor fino 
        } else if (vistaAnamnesis.getJcxNormalMotorFino().isSelected() == false
                && vistaAnamnesis.getJcxIrregularMotorFino().isSelected() == false) {
            JOptionPane.showMessageDialog(null, "Seleccione la opcion en desarrollo motor fino.");
            return false;
            // pregunta su lenguaje actual es 
        } else if (vistaAnamnesis.getJcxNormal().isSelected() == false
                && vistaAnamnesis.getJcxNoMuyClaro().isSelected() == false
                && vistaAnamnesis.getJcxNoSeEntiende().isSelected() == false) {
            JOptionPane.showMessageDialog(null, "Seleccione la opcion en lenguaje actual.");
            return false;
        } else {
            return true;
        }
    }

    //VALIDACIÓN SECCIÓN: 1.10 SUEÑO Y CONTROL DE ESFÍNTERES - FICHA ANAMNESIS
    public boolean validardatosSuenoControlEsfinter() {
        if (vistaAnamnesis.getTxtComoDuerme().getText().equals("")
                || vistaAnamnesis.getTxtComoDespierta().getText().equals("")
                || vistaAnamnesis.getTxtConQuienDuerme().getText().equals("")
                || vistaAnamnesis.getTxtEdadEsfinteres().getText().equals("")
                || vistaAnamnesis.getTxtEdadEsfinteres().getText().equals("")) {

            JOptionPane.showMessageDialog(null, "Llene todos los campos.");
            return false;
        } // pregunta duerme toda la noche
        if (vistaAnamnesis.getJcxSiDuerme().isSelected() == false
                && vistaAnamnesis.getJcxNoDuerme().isSelected() == false) {
            JOptionPane.showMessageDialog(null, "Seleccione una opcion en duerme toda la noche");
            return false;
            // tiene miedo de dormir
        } else if (vistaAnamnesis.getJcxSiMiedoDormir().isSelected() == false
                && vistaAnamnesis.getJcxNoMiedoDormir().isSelected() == false) {
            JOptionPane.showMessageDialog(null, "Seleccione una opcion en tiene miedo al dormir");
            return false;
            // pregunta tiene pesadillas
        } else if (vistaAnamnesis.getJcxSiPesadillas().isSelected() == false
                && vistaAnamnesis.getJcxNoPesadillas().isSelected() == false) {
            JOptionPane.showMessageDialog(null, "Seleccione una opcion en tiene pesadillas");
            return false;
            //pregunta necesita ayuda para ir al banio
        } else if (vistaAnamnesis.getJcxSiAyudaBanho().isSelected() == false
                && vistaAnamnesis.getJcxNoAyudaBanho().isSelected() == false) {
            JOptionPane.showMessageDialog(null, "Seleccione una opcion en nesecita ayuda para ir al baño");
            return false;
            //pregunta moja la cama
        } else if (vistaAnamnesis.getJcxSiMojaCama().isSelected() == false
                && vistaAnamnesis.getJcxNoMojaCama().isSelected() == false) {
            JOptionPane.showMessageDialog(null, "Seleccione una opcion en moja la cama");
            return false;
            // pregunta presenta periodos de ecopresis
        } else if (vistaAnamnesis.getJcxSiEcopresis().isSelected() == false
                && vistaAnamnesis.getJcxNoEcopresis().isSelected() == false) {
            JOptionPane.showMessageDialog(null, "Seleccione una opcion en periodos de ecopresis");
            return false;
        } else {
            return true;
        }
    }

    //VALIDACIÓN SECCIÓN: 1.11 ESCOLARIZACIÓN NNA - FICHA ANAMNESIS
    public boolean validardatosEscolarizacionNNA() {
        if (vistaAnamnesis.getTxtNombreInstitucion().getText().equals("")
                || vistaAnamnesis.getTxtAnhoCursa().getText().equals("")
                || vistaAnamnesis.getTxtAnhoRepite().getText().equals("")) {
            JOptionPane.showMessageDialog(null, "LLene todos los campos");
            return false;
        }
        //pregunta el NNA estudia
        if (vistaAnamnesis.getJcxSiEstudia().isSelected() == false
                && vistaAnamnesis.getJcxNoEstudia().isSelected() == false) {
            JOptionPane.showMessageDialog(null, "Seleccione una opcion en NNA estudia");
            return false;
        } else if (vistaAnamnesis.getJcxSiAprendizaje().isSelected() == false
                && vistaAnamnesis.getJcxNoAprendizaje().isSelected() == false) {
            // preguntas  problemas de aprendisaje
            JOptionPane.showMessageDialog(null, "Seleccione una opcion en problemas de aprensisaje");
            return false;
        } else if (vistaAnamnesis.getJcxSiNivelacion().isSelected() == false
                && vistaAnamnesis.getJcxNoNivelacion().isSelected() == false) {
            // pregunta se apoyo o nivelacion escolar
            JOptionPane.showMessageDialog(null, "Seleccione una opcion en apoyo o nivelacion escolar");
            return false;
        } else {
//codigo 
            return true;
        }
    }
//cambios
    //VALIDACIÓN SECCIÓN: 1.12 SALUD - FICHA ANAMNESIS

    public boolean validardatosSalud() {
        if (vistaAnamnesis.getTxtClimaFamiliar().getText().equals("")
                || vistaAnamnesis.getTxtRelacionMadre().getText().equals("")
                || vistaAnamnesis.getTxtRelacionMadre().getText().equals("")
                || vistaAnamnesis.getTxtRelacionHermanos().getText().equals("")
                || vistaAnamnesis.getTxtEnqueaTrabajo().getText().equals("")
                || vistaAnamnesis.getTxtFrecuenciaAgresorAgrede().getText().equals("")
                || vistaAnamnesis.getTxtQueUtiliza().getText().equals("")
                || vistaAnamnesis.getTxtObligacionesenlaFamilia().getText().equals("")
                || vistaAnamnesis.getTxtObligacionesenlaFamilia().getText().equals("")
                || vistaAnamnesis.getTxtProyeciondelaMadre().getText().equals("")
                | vistaAnamnesis.getTxtNecesidadGrupoFamiliar().getText().equals("")) {
            return false;
        }
        if (vistaAnamnesis.getJcxSiTrabajo().isSelected() == false
                && vistaAnamnesis.getJcxNoTrabajo().isSelected() == false
                && vistaAnamnesis.getJcxSiAgrede().isSelected() == false
                && vistaAnamnesis.getJcxNoAgrede().isSelected() == false) {
            return false;
        } else {
            return true;
        }
    }

    //VALIDACIÓN SECCIÓN: 1.13 RELACIÓN FAMILIAR - FICHA ANAMNESIS
    public boolean validardatosRelacionFamiliar() {
        if (vistaAnamnesis.getTxtNombreMadre().getText().equals("")
                || vistaAnamnesis.getTxtEdadMadre().getText().equals("")
                || vistaAnamnesis.getTxtApellidoMadre().getText().equals("")/*
                || vistaAnamnesis.getTxtNaconalidadMadre().getText().equals("")*/
                || vistaAnamnesis.getTxtNombrePadre().getText().equals("")
                || vistaAnamnesis.getTxtEdadPadre().getText().equals("")
                || vistaAnamnesis.getTxtApellidoPadre().getText().equals("")/*
                || vistaAnamnesis.getTxtNacionalidadPadre().getText().equals("")*/
                || vistaAnamnesis.getTxAObservaciones().getText().equals("")) {
            JOptionPane.showMessageDialog(null, "llene todos los campos");
            return false;
        } else {
            return true;

        }
    }

    //VALIDACIÓN SECCIÓN: 1.14 OBSERVACIONES GENERALES- FICHA ANAMNESIS
    public boolean validardatosObservacionesGenerales() {
        if (vistaAnamnesis.getTxAObservaciones().getText().equals("")) {
            System.out.println("Obeservaciones vacias");
            return false;
        } else {
            return true;

        }
    }
}
