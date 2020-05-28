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
import javax.swing.JCheckBox;
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
public class Controlador_registro_llamadas implements ActionListener  {

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
        //juegos de check
        //----------------------------------------------------------------------
        //----------------------------------------------------------------------
        this.vista.getRbHijosSi().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (vista.getRbHijosSi().isSelected()) {
                    vista.getRbHijosNo().setEnabled(false);
                    vista.getRbHijosNoReporta().setEnabled(false);
                } else {
                    vista.getRbHijosNo().setEnabled(true);
                    vista.getRbHijosNoReporta().setEnabled(true);

                }
            }
        });
        this.vista.getRbHijosNo().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (vista.getRbHijosNo().isSelected()) {
                    vista.getRbHijosNoReporta().setEnabled(false);
                    vista.getSpnNumeroHijos().setEnabled(false);
                    vista.getRbHijosSi().setEnabled(false);
                    vista.getSpnNumeroHijos().setValue(0);
                } else {
                    vista.getRbHijosSi().setEnabled(true);
                    vista.getRbHijosNoReporta().setEnabled(true);
                    vista.getSpnNumeroHijos().setEnabled(true);
                }
            }
        });
        this.vista.getRbHijosNoReporta().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (vista.getRbHijosNoReporta().isSelected()) {
                    vista.getRbHijosSi().setEnabled(false);
                    vista.getRbHijosNo().setEnabled(false);
                    vista.getSpnNumeroHijos().setEnabled(false);
                    vista.getSpnNumeroHijos().setValue(0);
                } else {
                    vista.getRbHijosSi().setEnabled(true);
                    vista.getRbHijosNo().setEnabled(true);
                    vista.getSpnNumeroHijos().setEnabled(true);
                }
            }
        });
        //----------------------------------------------------------------------
        this.vista.getRbTrabajaSi().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (vista.getRbTrabajaSi().isSelected()) {
                    vista.getRbTrabajaNoReporta().setEnabled(false);
                    vista.getRbTrabajoNo().setEnabled(false);
                } else {
                    vista.getRbTrabajaNoReporta().setEnabled(true);
                    vista.getRbTrabajoNo().setEnabled(true);
                }
            }
        });
        this.vista.getRbTrabajoNo().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (vista.getRbTrabajoNo().isSelected()) {
                    vista.getRbTrabajaSi().setEnabled(false);
                    vista.getRbTrabajaNoReporta().setEnabled(false);
                } else {
                    vista.getRbTrabajaNoReporta().setEnabled(true);
                    vista.getRbTrabajaSi().setEnabled(true);
                }
            }
        });
        this.vista.getRbTrabajaNoReporta().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (vista.getRbTrabajaNoReporta().isSelected()) {
                    vista.getRbTrabajaSi().setEnabled(false);
                    vista.getRbTrabajoNo().setEnabled(false);
                } else {
                    vista.getRbTrabajaSi().setEnabled(true);
                    vista.getRbTrabajoNo().setEnabled(true);
                }
            }
        });
        //----------------------------------------------------------------------
        this.vista.getCbNoReportaTipoViolencia().addActionListener(e -> no_reporta_tipo_violencia());
        this.vista.getCbFisica().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                apagado_tipo_violencia(vista.getCbFisica());
            }
        });
        this.vista.getCbPsicologica().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                apagado_tipo_violencia(vista.getCbPsicologica());
            }
        });
        this.vista.getCbLaboral().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                apagado_tipo_violencia(vista.getCbLaboral());
            }
        });
        this.vista.getCbEconomica().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                apagado_tipo_violencia(vista.getCbEconomica());
            }
        });
        this.vista.getCbNegligencia().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                apagado_tipo_violencia(vista.getCbNegligencia());
            }
        });
        //----------------------------------------------------------------------
        this.vista.getCbEsposo().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                apagado_quien_agresor(vista.getCbEsposo());
            }
        });
        this.vista.getCbPadre_Madre().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                apagado_quien_agresor(vista.getCbPadre_Madre());
            }
        });
        this.vista.getCbNovio().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                apagado_quien_agresor(vista.getCbNovio());
            }
        });
        this.vista.getCbExPareja().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                apagado_quien_agresor(vista.getCbExPareja());
            }
        });
        this.vista.getCbHijo().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                apagado_quien_agresor(vista.getCbHijo());
            }
        });
        this.vista.getCbJefe().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                apagado_quien_agresor(vista.getCbJefe());
            }
        });
        this.vista.getCbNoReportaQuienEsElAgresor().addActionListener(e -> no_reporta_quien_agresor());
        //----------------------------------------------------------------------
        this.vista.getCbAlcolismo().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                apagado_factores_riesgo(vista.getCbAlcolismo());
            }
        });
        this.vista.getCbMigracion().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                apagado_factores_riesgo(vista.getCbMigracion());
            }
        });
        this.vista.getCbCelos().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                apagado_factores_riesgo(vista.getCbCelos());
            }
        });
        this.vista.getCbDesempleo().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                apagado_factores_riesgo(vista.getCbDesempleo());
            }
        });
        this.vista.getCbInfidelidad().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                apagado_factores_riesgo(vista.getCbInfidelidad());
            }
        });
        this.vista.getCbMachismo().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                apagado_factores_riesgo(vista.getCbMachismo());
            }
        });
        this.vista.getCbNoReportaFactoresRiesgo().addActionListener(e -> no_reporta_factores_riesgos());
        //----------------------------------------------------------------------
        this.vista.getCbFracturas().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                apagado_consecuencias_fisicas(vista.getCbFracturas());
            }
        });
        this.vista.getCbMoretones().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                apagado_consecuencias_fisicas(vista.getCbMoretones());
            }
        });
        this.vista.getCbHeridas().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                apagado_consecuencias_fisicas(vista.getCbHeridas());
            }
        });
        this.vista.getCbAbortos().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                apagado_consecuencias_fisicas(vista.getCbAbortos());
            }
        });
        this.vista.getCbContagiosETS().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                apagado_consecuencias_fisicas(vista.getCbContagiosETS());
            }
        });
        this.vista.getCbAlt_Nerviosas().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                apagado_consecuencias_fisicas(vista.getCbAlt_Nerviosas());
            }
        });
        this.vista.getCbBajaAutoestima().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                apagado_consecuencias_fisicas(vista.getCbBajaAutoestima());
            }
        });
        this.vista.getCbDepresion().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                apagado_consecuencias_fisicas(vista.getCbDepresion());
            }
        });
        this.vista.getCbEmbarazoNoDeseado().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                apagado_consecuencias_fisicas(vista.getCbEmbarazoNoDeseado());
            }
        });
        this.vista.getCbNoReportaConcecuenciasFisicas().addActionListener(e -> no_reporta_concecuencias_fisicas());
        //----------------------------------------------------------------------
        this.vista.getCbViolenciaIntrafamiliar().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                apagado_motivo_llamada(vista.getCbViolenciaIntrafamiliar());
            }
        });
        this.vista.getCbViolenciaInstitucional().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                apagado_motivo_llamada(vista.getCbViolenciaInstitucional());
            }
        });
        this.vista.getCbAlivioyApoyo().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                apagado_motivo_llamada(vista.getCbAlivioyApoyo());
            }
        });
        this.vista.getCbInformacionCasadeAcojida().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                apagado_motivo_llamada(vista.getCbInformacionCasadeAcojida());
            }
        });
        this.vista.getCbAbusoSexual().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                apagado_motivo_llamada(vista.getCbAbusoSexual());
            }
        });
        this.vista.getCbViolenciaSocial().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                apagado_motivo_llamada(vista.getCbViolenciaSocial());
            }
        });
        this.vista.getCbAtencionPsicologica().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                apagado_motivo_llamada(vista.getCbAtencionPsicologica());
            }
        });
        this.vista.getCbInformacionOtrasInstituciones().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                apagado_motivo_llamada(vista.getCbViolacion());
            }
        });
        this.vista.getCbViolacion().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                apagado_motivo_llamada(vista.getCbAccesoriaLegal());
            }
        });
        this.vista.getCbAccesoriaLegal().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                apagado_motivo_llamada(vista.getCbIntentoSuicidio());
            }
        });
        this.vista.getCbIntentoSuicidio().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                apagado_motivo_llamada(vista.getCbInformacionOtrasInstituciones());
            }
        });
        this.vista.getCbNoReporta().addActionListener(e -> no_reporta_motivos_llamada());
        //----------------------------------------------------------------------
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
    //------------------------------------------------------------------------------------------------------------
    //-------------------------------------------------------------------------------------------------------------
    //--------------------------------------------------------------------------------------------------------------

    public void apagado_motivo_llamada(JCheckBox hh) {
        if (hh.isSelected()) {
            vista.getCbNoReporta().setEnabled(false);
        } else {
            vista.getCbNoReporta().setEnabled(true);
        }
        if (this.vista.getCbViolenciaIntrafamiliar().isSelected() || this.vista.getCbViolenciaInstitucional().isSelected()
                || this.vista.getCbAlivioyApoyo().isSelected() || this.vista.getCbInformacionCasadeAcojida().isSelected()
                || this.vista.getCbAbusoSexual().isSelected() || this.vista.getCbViolenciaSocial().isSelected()
                || this.vista.getCbAtencionPsicologica().isSelected() || this.vista.getCbViolacion().isSelected()
                || this.vista.getCbAccesoriaLegal().isSelected() || this.vista.getCbIntentoSuicidio().isSelected()
                || this.vista.getCbInformacionOtrasInstituciones().isSelected()) {
            this.vista.getCbNoReporta().setEnabled(false);
        } else {
            this.vista.getCbNoReporta().setEnabled(true);
        }
    }

    public void apagado_consecuencias_fisicas(JCheckBox hh) {
        if (hh.isSelected()) {
            vista.getCbNoReportaConcecuenciasFisicas().setEnabled(false);
        } else {
            vista.getCbNoReportaConcecuenciasFisicas().setEnabled(true);
        }
        if (this.vista.getCbFracturas().isSelected() || this.vista.getCbMoretones().isSelected()
                || this.vista.getCbHeridas().isSelected() || this.vista.getCbAbortos().isSelected()
                || this.vista.getCbContagiosETS().isSelected() || this.vista.getCbAlt_Nerviosas().isSelected()
                || this.vista.getCbBajaAutoestima().isSelected() || this.vista.getCbDepresion().isSelected()
                || this.vista.getCbEmbarazoNoDeseado().isSelected()) {
            this.vista.getCbNoReportaConcecuenciasFisicas().setEnabled(false);
        } else {
            this.vista.getCbNoReportaConcecuenciasFisicas().setEnabled(true);
        }
    }

    public void apagado_factores_riesgo(JCheckBox hh) {
        if (hh.isSelected()) {
            vista.getCbNoReportaFactoresRiesgo().setEnabled(false);
        } else {
            vista.getCbNoReportaFactoresRiesgo().setEnabled(true);
        }
        if (this.vista.getCbAlcolismo().isSelected() || this.vista.getCbMigracion().isSelected()
                || this.vista.getCbCelos().isSelected() || this.vista.getCbDesempleo().isSelected()
                || this.vista.getCbInfidelidad().isSelected() || this.vista.getCbMachismo().isSelected()) {
            this.vista.getCbNoReportaFactoresRiesgo().setEnabled(false);
        } else {
            this.vista.getCbNoReportaFactoresRiesgo().setEnabled(true);
        }
    }

    public void apagado_quien_agresor(JCheckBox hh) {
        if (hh.isSelected()) {
            vista.getCbNoReportaQuienEsElAgresor().setEnabled(false);
        } else {
            vista.getCbNoReportaQuienEsElAgresor().setEnabled(true);
        }
        if (this.vista.getCbEsposo().isSelected() || this.vista.getCbPadre_Madre().isSelected()
                || this.vista.getCbNovio().isSelected() || this.vista.getCbExPareja().isSelected()
                || this.vista.getCbHijo().isSelected() || this.vista.getCbJefe().isSelected()) {
            this.vista.getCbNoReportaQuienEsElAgresor().setEnabled(false);
        } else {
            this.vista.getCbNoReportaQuienEsElAgresor().setEnabled(true);
        }

    }

    public void apagado_tipo_violencia(JCheckBox hj) {
        if (hj.isSelected()) {
            vista.getCbNoReportaTipoViolencia().setEnabled(false);
        } else {
            vista.getCbNoReportaTipoViolencia().setEnabled(true);
        }
        if (this.vista.getCbFisica().isSelected() || this.vista.getCbPsicologica().isSelected()
                || this.vista.getCbLaboral().isSelected() || this.vista.getCbNegligencia().isSelected()
                || this.vista.getCbEconomica().isSelected()) {
            this.vista.getCbNoReportaTipoViolencia().setEnabled(false);
        } else {
            this.vista.getCbNoReportaTipoViolencia().setEnabled(true);
        }
    }
    //------------------------------------------------------------------------------------------------------------
    //-------------------------------------------------------------------------------------------------------------
    //--------------------------------------------------------------------------------------------------------------

    public void no_reporta_tipo_violencia() {
        if (vista.getCbNoReportaTipoViolencia().isSelected()) {
            vista.getCbFisica().setEnabled(false);
            vista.getCbPsicologica().setEnabled(false);
            vista.getCbLaboral().setEnabled(false);
            vista.getCbEconomica().setEnabled(false);
            vista.getCbNegligencia().setEnabled(false);
            vista.getTxtOtro_tipo_violencia().setEnabled(false);
        } else {
            vista.getCbFisica().setEnabled(true);
            vista.getCbPsicologica().setEnabled(true);
            vista.getCbLaboral().setEnabled(true);
            vista.getCbEconomica().setEnabled(true);
            vista.getCbNegligencia().setEnabled(true);
            vista.getTxtOtro_tipo_violencia().setEnabled(true);
        }
    }

    public void no_reporta_quien_agresor() {
        if (vista.getCbNoReportaQuienEsElAgresor().isSelected()) {
            vista.getCbEsposo().setEnabled(false);
            vista.getCbPadre_Madre().setEnabled(false);
            vista.getCbNovio().setEnabled(false);
            vista.getCbExPareja().setEnabled(false);
            vista.getCbHijo().setEnabled(false);
            vista.getCbJefe().setEnabled(false);
            vista.getTxtOtrosQuienEsElAgresor().setEnabled(false);
        } else {
            vista.getCbEsposo().setEnabled(true);
            vista.getCbPadre_Madre().setEnabled(true);
            vista.getCbNovio().setEnabled(true);
            vista.getCbExPareja().setEnabled(true);
            vista.getCbHijo().setEnabled(true);
            vista.getCbJefe().setEnabled(true);
            vista.getCbEsposo().setEnabled(true);
            vista.getTxtOtrosQuienEsElAgresor().setEnabled(true);
        }
    }

    public void no_reporta_factores_riesgos() {

        if (vista.getCbNoReportaFactoresRiesgo().isSelected()) {
            vista.getCbAlcolismo().setEnabled(false);
            vista.getCbMigracion().setEnabled(false);
            vista.getCbCelos().setEnabled(false);
            vista.getCbDesempleo().setEnabled(false);
            vista.getCbInfidelidad().setEnabled(false);
            vista.getCbMachismo().setEnabled(false);
            vista.getTxtOtrosFactoresRiesgo().setEnabled(false);
        } else {
            vista.getCbAlcolismo().setEnabled(true);
            vista.getCbMigracion().setEnabled(true);
            vista.getCbCelos().setEnabled(true);
            vista.getCbDesempleo().setEnabled(true);
            vista.getCbInfidelidad().setEnabled(true);
            vista.getCbMachismo().setEnabled(true);
            vista.getTxtOtrosFactoresRiesgo().setEnabled(true);
        }
    }

    public void no_reporta_concecuencias_fisicas() {
        if (vista.getCbNoReportaConcecuenciasFisicas().isSelected()) {
            vista.getCbFracturas().setEnabled(false);
            vista.getCbMoretones().setEnabled(false);
            vista.getCbHeridas().setEnabled(false);
            vista.getCbAbortos().setEnabled(false);
            vista.getCbContagiosETS().setEnabled(false);
            vista.getCbAlt_Nerviosas().setEnabled(false);
            vista.getCbBajaAutoestima().setEnabled(false);
            vista.getCbDepresion().setEnabled(false);
            vista.getCbEmbarazoNoDeseado().setEnabled(false);
            vista.getTxtOtroConsecienciasFisicas().setEnabled(false);
        } else {
            vista.getCbFracturas().setEnabled(true);
            vista.getCbMoretones().setEnabled(true);
            vista.getCbHeridas().setEnabled(true);
            vista.getCbAbortos().setEnabled(true);
            vista.getCbContagiosETS().setEnabled(true);
            vista.getCbAlt_Nerviosas().setEnabled(true);
            vista.getCbBajaAutoestima().setEnabled(true);
            vista.getCbDepresion().setEnabled(true);
            vista.getCbEmbarazoNoDeseado().setEnabled(true);
            vista.getTxtOtroConsecienciasFisicas().setEnabled(true);
        }

    }

    public void no_reporta_motivos_llamada() {

        if (vista.getCbNoReporta().isSelected()) {
            vista.getCbViolenciaIntrafamiliar().setEnabled(false);
            vista.getCbViolenciaInstitucional().setEnabled(false);
            vista.getCbAlivioyApoyo().setEnabled(false);
            vista.getCbInformacionCasadeAcojida().setEnabled(false);
            vista.getCbAbusoSexual().setEnabled(false);
            vista.getCbViolenciaSocial().setEnabled(false);
            vista.getCbAtencionPsicologica().setEnabled(false);
            vista.getCbInformacionOtrasInstituciones().setEnabled(false);
            vista.getCbViolacion().setEnabled(false);
            vista.getCbAccesoriaLegal().setEnabled(false);
            vista.getCbIntentoSuicidio().setEnabled(false);
            vista.getTxtOtrosMotivoLlamada().setEditable(false);
        } else {
            vista.getCbViolenciaIntrafamiliar().setEnabled(true);
            vista.getCbViolenciaInstitucional().setEnabled(true);
            vista.getCbAlivioyApoyo().setEnabled(true);
            vista.getCbInformacionCasadeAcojida().setEnabled(true);
            vista.getCbAbusoSexual().setEnabled(true);
            vista.getCbViolenciaSocial().setEnabled(true);
            vista.getCbAtencionPsicologica().setEnabled(true);
            vista.getCbInformacionOtrasInstituciones().setEnabled(true);
            vista.getCbViolacion().setEnabled(true);
            vista.getCbAccesoriaLegal().setEnabled(true);
            vista.getCbIntentoSuicidio().setEnabled(true);
            vista.getTxtOtrosMotivoLlamada().setEditable(true);
        }

    }
    //------------------------------------------------------------------------------------------------------------
    //-------------------------------------------------------------------------------------------------------------
    //--------------------------------------------------------------------------------------------------------------

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

    public Controlador_registro_llamadas() {
    }

    public void llamada() throws SQLException {
        persona_llamadaDB pldb = new persona_llamadaDB();
        LlamadaDB ldb = new LlamadaDB();
        perllamcod = pldb.getPersona_llamada_static();
        int dia = vista.getDatFechaLlamada().getCalendar().get(Calendar.DAY_OF_YEAR);
        int mes = vista.getDatFechaLlamada().getCalendar().get(Calendar.MONTH);
        int anio = vista.getDatFechaLlamada().getCalendar().get(Calendar.YEAR);
        String fecha = anio + "-" + mes + "-" + dia;
        System.out.println(fecha);
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
            int llamadacodigo = ldb.getLlamada_static();
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
            int llamadacodigo = ldb.getLlamada_static();
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
