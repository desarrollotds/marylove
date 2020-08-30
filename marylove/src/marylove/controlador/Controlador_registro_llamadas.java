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
public class Controlador_registro_llamadas extends Validaciones implements ActionListener {

    VistaRegistroLlamada v;

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
    

    public void limpiar_campos() {
        v.getCbJornada().setSelectedIndex(0);
        v.getCbxPrioridad().setSelectedIndex(0);
        v.getTxtnumero().setText("");
        v.getTxtNombreVictima().setText("");
        v.getTxtApellidoVictima().setText("");
        v.getSpnEdadVictima().setValue(18);
        v.getTxtDireccionVictima().setText("");
        v.getRbHijosSi().setSelected(false);
        v.getRbHijosNo().setSelected(false);
        v.getSpnNumeroHijos().setValue(0);
        v.getRbHijosNoReporta().setSelected(false);
        v.getRbTrabajaSi().setSelected(false);
        v.getRbTrabajoNo().setSelected(false);
        v.getRbTrabajaNoReporta().setSelected(false);
        v.getTxtComoSupoLineaTelfonica().setText("");
        v.getCbFisica().setSelected(false);
        v.getCbPsicologica().setSelected(false);
        v.getCbLaboral().setSelected(false);
        v.getCbEconomica().setSelected(false);
        v.getCbNegligencia().setSelected(false);
        v.getTxtOtro_tipo_violencia().setText("");
        v.getCbNoReportaTipoViolencia().setSelected(false);
        v.getCbEsposo().setSelected(false);
        v.getCbPadre_Madre().setSelected(false);
        v.getCbNovio().setSelected(false);
        v.getCbExPareja().setSelected(false);
        v.getCbHijo().setSelected(false);
        v.getCbJefe().setSelected(false);
        v.getCbEsposo().setSelected(false);
        v.getTxtOtrosQuienEsElAgresor().setText("");
        v.getCbAlcolismo().setSelected(false);
        v.getCbMigracion().setSelected(false);
        v.getCbCelos().setSelected(false);
        v.getCbDesempleo().setSelected(false);
        v.getCbInfidelidad().setSelected(false);
        v.getCbMachismo().setSelected(false);
        v.getTxtOtrosFactoresRiesgo().setText("");
        v.getCbFracturas().setSelected(false);
        v.getCbMoretones().setSelected(false);
        v.getCbHeridas().setSelected(false);
        v.getCbAbortos().setSelected(false);
        v.getCbContagiosETS().setSelected(false);
        v.getCbAlt_Nerviosas().setSelected(false);
        v.getCbBajaAutoestima().setSelected(false);
        v.getCbDepresion().setSelected(false);
        v.getCbEmbarazoNoDeseado().setSelected(false);
        v.getTxtOtroConsecienciasFisicas().setText("");
        v.getCbViolenciaIntrafamiliar().setSelected(false);
        v.getCbViolenciaInstitucional().setSelected(false);
        v.getCbAlivioyApoyo().setSelected(false);
        v.getCbInformacionCasadeAcojida().setSelected(false);
        v.getCbAbusoSexual().setSelected(false);
        v.getCbViolenciaSocial().setSelected(false);
        v.getCbAtencionPsicologica().setSelected(false);
        v.getCbInformacionOtrasInstituciones().setSelected(false);
        v.getCbViolacion().setSelected(false);
        v.getCbAccesoriaLegal().setSelected(false);
        v.getCbIntentoSuicidio().setSelected(false);
        v.getTxtOtrosMotivoLlamada().setText("");
        v.getCbAnsiosa().setSelected(false);
        v.getCbAsustada().setSelected(false);
        v.getCbNerviosa().setSelected(false);
        v.getCbTranquila().setSelected(false);
        v.getCbLlorosa().setSelected(false);
        v.getCbEnojada().setSelected(false);
        v.getCbHabla().setSelectedIndex(0);
        v.getCbVoz().setSelectedIndex(0);
        v.getTxtOtrosResultado().setText("");
        v.getTxtNotasAdicionalesVictima().setText("");
        v.getTxtCedula().setText("");

    }

    public Controlador_registro_llamadas(VistaRegistroLlamada vista) throws ParseException {
        //VALIDAMOS LA LISTA DE LOS JSON
        validarJsons();
        this.v = vista;
        this.v.getBtnGuardar().addActionListener(this);
//        this.vista.getBtnGenerarCita().addActionListener(e -> abrirCita());
        this.v.getBtnCancelar().addActionListener(this);
        //juegos de check
        //----------------------------------------------------------------------
        //----------------------------------------------------------------------
        v.getTxtNombreVictima().addKeyListener(validarLetras(v.getTxtNombreVictima()));
        v.getTxtApellidoVictima().addKeyListener(validarLetras(v.getTxtApellidoVictima()));
        this.v.getRbHijosSi().addActionListener(new ActionListener() {
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
        this.v.getRbHijosNo().addActionListener(new ActionListener() {
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
        this.v.getRbHijosNoReporta().addActionListener(new ActionListener() {
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
        this.v.getRbTrabajaSi().addActionListener(new ActionListener() {
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
        this.v.getRbTrabajoNo().addActionListener(new ActionListener() {
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
        this.v.getRbTrabajaNoReporta().addActionListener(new ActionListener() {
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
        this.v.getCbNoReportaTipoViolencia().addActionListener(e -> no_reporta_tipo_violencia());
        this.v.getCbFisica().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                apagado_tipo_violencia(vista.getCbFisica());
            }
        });
        this.v.getCbPsicologica().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                apagado_tipo_violencia(vista.getCbPsicologica());
            }
        });
        this.v.getCbLaboral().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                apagado_tipo_violencia(vista.getCbLaboral());
            }
        });
        this.v.getCbEconomica().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                apagado_tipo_violencia(vista.getCbEconomica());
            }
        });
        this.v.getCbNegligencia().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                apagado_tipo_violencia(vista.getCbNegligencia());
            }
        });
        //----------------------------------------------------------------------
        this.v.getCbEsposo().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                apagado_quien_agresor(vista.getCbEsposo());
            }
        });
        this.v.getCbPadre_Madre().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                apagado_quien_agresor(vista.getCbPadre_Madre());
            }
        });
        this.v.getCbNovio().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                apagado_quien_agresor(vista.getCbNovio());
            }
        });
        this.v.getCbExPareja().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                apagado_quien_agresor(vista.getCbExPareja());
            }
        });
        this.v.getCbHijo().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                apagado_quien_agresor(vista.getCbHijo());
            }
        });
        this.v.getCbJefe().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                apagado_quien_agresor(vista.getCbJefe());
            }
        });
        this.v.getCbNoReportaQuienEsElAgresor().addActionListener(e -> no_reporta_quien_agresor());
        //----------------------------------------------------------------------
        this.v.getCbAlcolismo().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                apagado_factores_riesgo(vista.getCbAlcolismo());
            }
        });
        this.v.getCbMigracion().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                apagado_factores_riesgo(vista.getCbMigracion());
            }
        });
        this.v.getCbCelos().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                apagado_factores_riesgo(vista.getCbCelos());
            }
        });
        this.v.getCbDesempleo().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                apagado_factores_riesgo(vista.getCbDesempleo());
            }
        });
        this.v.getCbInfidelidad().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                apagado_factores_riesgo(vista.getCbInfidelidad());
            }
        });
        this.v.getCbMachismo().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                apagado_factores_riesgo(vista.getCbMachismo());
            }
        });
        this.v.getCbNoReportaFactoresRiesgo().addActionListener(e -> no_reporta_factores_riesgos());
        //----------------------------------------------------------------------
        this.v.getCbFracturas().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                apagado_consecuencias_fisicas(vista.getCbFracturas());
            }
        });
        this.v.getCbMoretones().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                apagado_consecuencias_fisicas(vista.getCbMoretones());
            }
        });
        this.v.getCbHeridas().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                apagado_consecuencias_fisicas(vista.getCbHeridas());
            }
        });
        this.v.getCbAbortos().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                apagado_consecuencias_fisicas(vista.getCbAbortos());
            }
        });
        this.v.getCbContagiosETS().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                apagado_consecuencias_fisicas(vista.getCbContagiosETS());
            }
        });
        this.v.getCbAlt_Nerviosas().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                apagado_consecuencias_fisicas(vista.getCbAlt_Nerviosas());
            }
        });
        this.v.getCbBajaAutoestima().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                apagado_consecuencias_fisicas(vista.getCbBajaAutoestima());
            }
        });
        this.v.getCbDepresion().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                apagado_consecuencias_fisicas(vista.getCbDepresion());
            }
        });
        this.v.getCbEmbarazoNoDeseado().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                apagado_consecuencias_fisicas(vista.getCbEmbarazoNoDeseado());
            }
        });
        this.v.getCbNoReportaConcecuenciasFisicas().addActionListener(e -> no_reporta_concecuencias_fisicas());
        //----------------------------------------------------------------------
        this.v.getCbViolenciaIntrafamiliar().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                apagado_motivo_llamada(vista.getCbViolenciaIntrafamiliar());
            }
        });
        this.v.getCbViolenciaInstitucional().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                apagado_motivo_llamada(vista.getCbViolenciaInstitucional());
            }
        });
        this.v.getCbAlivioyApoyo().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                apagado_motivo_llamada(vista.getCbAlivioyApoyo());
            }
        });
        this.v.getCbInformacionCasadeAcojida().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                apagado_motivo_llamada(vista.getCbInformacionCasadeAcojida());
            }
        });
        this.v.getCbAbusoSexual().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                apagado_motivo_llamada(vista.getCbAbusoSexual());
            }
        });
        this.v.getCbViolenciaSocial().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                apagado_motivo_llamada(vista.getCbViolenciaSocial());
            }
        });
        this.v.getCbAtencionPsicologica().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                apagado_motivo_llamada(vista.getCbAtencionPsicologica());
            }
        });
        this.v.getCbInformacionOtrasInstituciones().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                apagado_motivo_llamada(vista.getCbViolacion());
            }
        });
        this.v.getCbViolacion().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                apagado_motivo_llamada(vista.getCbAccesoriaLegal());
            }
        });
        this.v.getCbAccesoriaLegal().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                apagado_motivo_llamada(vista.getCbIntentoSuicidio());
            }
        });
        this.v.getCbIntentoSuicidio().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                apagado_motivo_llamada(vista.getCbInformacionOtrasInstituciones());
            }
        });
        this.v.getCbNoReporta().addActionListener(e -> no_reporta_motivos_llamada());
        //----------------------------------------------------------------------
        llenarComboResultados();
        try {
            llenarComboNacionalidades();
            llenarEstadoCivil();
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
            v.getCbNoReporta().setEnabled(false);
        } else {
            v.getCbNoReporta().setEnabled(true);
        }
        if (this.v.getCbViolenciaIntrafamiliar().isSelected() || this.v.getCbViolenciaInstitucional().isSelected()
                || this.v.getCbAlivioyApoyo().isSelected() || this.v.getCbInformacionCasadeAcojida().isSelected()
                || this.v.getCbAbusoSexual().isSelected() || this.v.getCbViolenciaSocial().isSelected()
                || this.v.getCbAtencionPsicologica().isSelected() || this.v.getCbViolacion().isSelected()
                || this.v.getCbAccesoriaLegal().isSelected() || this.v.getCbIntentoSuicidio().isSelected()
                || this.v.getCbInformacionOtrasInstituciones().isSelected()) {
            this.v.getCbNoReporta().setEnabled(false);
        } else {
            this.v.getCbNoReporta().setEnabled(true);
        }
    }

    public void apagado_consecuencias_fisicas(JCheckBox hh) {
        if (hh.isSelected()) {
            v.getCbNoReportaConcecuenciasFisicas().setEnabled(false);
        } else {
            v.getCbNoReportaConcecuenciasFisicas().setEnabled(true);
        }
        if (this.v.getCbFracturas().isSelected() || this.v.getCbMoretones().isSelected()
                || this.v.getCbHeridas().isSelected() || this.v.getCbAbortos().isSelected()
                || this.v.getCbContagiosETS().isSelected() || this.v.getCbAlt_Nerviosas().isSelected()
                || this.v.getCbBajaAutoestima().isSelected() || this.v.getCbDepresion().isSelected()
                || this.v.getCbEmbarazoNoDeseado().isSelected()) {
            this.v.getCbNoReportaConcecuenciasFisicas().setEnabled(false);
        } else {
            this.v.getCbNoReportaConcecuenciasFisicas().setEnabled(true);
        }
    }

    public void apagado_factores_riesgo(JCheckBox hh) {
        if (hh.isSelected()) {
            v.getCbNoReportaFactoresRiesgo().setEnabled(false);
        } else {
            v.getCbNoReportaFactoresRiesgo().setEnabled(true);
        }
        if (this.v.getCbAlcolismo().isSelected() || this.v.getCbMigracion().isSelected()
                || this.v.getCbCelos().isSelected() || this.v.getCbDesempleo().isSelected()
                || this.v.getCbInfidelidad().isSelected() || this.v.getCbMachismo().isSelected()) {
            this.v.getCbNoReportaFactoresRiesgo().setEnabled(false);
        } else {
            this.v.getCbNoReportaFactoresRiesgo().setEnabled(true);
        }
    }

    public void apagado_quien_agresor(JCheckBox hh) {
        if (hh.isSelected()) {
            v.getCbNoReportaQuienEsElAgresor().setEnabled(false);
        } else {
            v.getCbNoReportaQuienEsElAgresor().setEnabled(true);
        }
        if (this.v.getCbEsposo().isSelected() || this.v.getCbPadre_Madre().isSelected()
                || this.v.getCbNovio().isSelected() || this.v.getCbExPareja().isSelected()
                || this.v.getCbHijo().isSelected() || this.v.getCbJefe().isSelected()) {
            this.v.getCbNoReportaQuienEsElAgresor().setEnabled(false);
        } else {
            this.v.getCbNoReportaQuienEsElAgresor().setEnabled(true);
        }

    }

    public void apagado_tipo_violencia(JCheckBox hj) {
        if (hj.isSelected()) {
            v.getCbNoReportaTipoViolencia().setEnabled(false);
        } else {
            v.getCbNoReportaTipoViolencia().setEnabled(true);
        }
        if (this.v.getCbFisica().isSelected() || this.v.getCbPsicologica().isSelected()
                || this.v.getCbLaboral().isSelected() || this.v.getCbNegligencia().isSelected()
                || this.v.getCbEconomica().isSelected()) {
            this.v.getCbNoReportaTipoViolencia().setEnabled(false);
        } else {
            this.v.getCbNoReportaTipoViolencia().setEnabled(true);
        }
    }
    //------------------------------------------------------------------------------------------------------------
    //-------------------------------------------------------------------------------------------------------------
    //--------------------------------------------------------------------------------------------------------------

    public void no_reporta_tipo_violencia() {
        if (v.getCbNoReportaTipoViolencia().isSelected()) {
            v.getCbFisica().setEnabled(false);
            v.getCbPsicologica().setEnabled(false);
            v.getCbLaboral().setEnabled(false);
            v.getCbEconomica().setEnabled(false);
            v.getCbNegligencia().setEnabled(false);
            v.getTxtOtro_tipo_violencia().setEnabled(false);
        } else {
            v.getCbFisica().setEnabled(true);
            v.getCbPsicologica().setEnabled(true);
            v.getCbLaboral().setEnabled(true);
            v.getCbEconomica().setEnabled(true);
            v.getCbNegligencia().setEnabled(true);
            v.getTxtOtro_tipo_violencia().setEnabled(true);
        }
    }

    public void no_reporta_quien_agresor() {
        if (v.getCbNoReportaQuienEsElAgresor().isSelected()) {
            v.getCbEsposo().setEnabled(false);
            v.getCbPadre_Madre().setEnabled(false);
            v.getCbNovio().setEnabled(false);
            v.getCbExPareja().setEnabled(false);
            v.getCbHijo().setEnabled(false);
            v.getCbJefe().setEnabled(false);
            v.getTxtOtrosQuienEsElAgresor().setEnabled(false);
        } else {
            v.getCbEsposo().setEnabled(true);
            v.getCbPadre_Madre().setEnabled(true);
            v.getCbNovio().setEnabled(true);
            v.getCbExPareja().setEnabled(true);
            v.getCbHijo().setEnabled(true);
            v.getCbJefe().setEnabled(true);
            v.getCbEsposo().setEnabled(true);
            v.getTxtOtrosQuienEsElAgresor().setEnabled(true);
        }
    }

    public void no_reporta_factores_riesgos() {

        if (v.getCbNoReportaFactoresRiesgo().isSelected()) {
            v.getCbAlcolismo().setEnabled(false);
            v.getCbMigracion().setEnabled(false);
            v.getCbCelos().setEnabled(false);
            v.getCbDesempleo().setEnabled(false);
            v.getCbInfidelidad().setEnabled(false);
            v.getCbMachismo().setEnabled(false);
            v.getTxtOtrosFactoresRiesgo().setEnabled(false);
        } else {
            v.getCbAlcolismo().setEnabled(true);
            v.getCbMigracion().setEnabled(true);
            v.getCbCelos().setEnabled(true);
            v.getCbDesempleo().setEnabled(true);
            v.getCbInfidelidad().setEnabled(true);
            v.getCbMachismo().setEnabled(true);
            v.getTxtOtrosFactoresRiesgo().setEnabled(true);
        }
    }

    public void no_reporta_concecuencias_fisicas() {
        if (v.getCbNoReportaConcecuenciasFisicas().isSelected()) {
            v.getCbFracturas().setEnabled(false);
            v.getCbMoretones().setEnabled(false);
            v.getCbHeridas().setEnabled(false);
            v.getCbAbortos().setEnabled(false);
            v.getCbContagiosETS().setEnabled(false);
            v.getCbAlt_Nerviosas().setEnabled(false);
            v.getCbBajaAutoestima().setEnabled(false);
            v.getCbDepresion().setEnabled(false);
            v.getCbEmbarazoNoDeseado().setEnabled(false);
            v.getTxtOtroConsecienciasFisicas().setEnabled(false);
        } else {
            v.getCbFracturas().setEnabled(true);
            v.getCbMoretones().setEnabled(true);
            v.getCbHeridas().setEnabled(true);
            v.getCbAbortos().setEnabled(true);
            v.getCbContagiosETS().setEnabled(true);
            v.getCbAlt_Nerviosas().setEnabled(true);
            v.getCbBajaAutoestima().setEnabled(true);
            v.getCbDepresion().setEnabled(true);
            v.getCbEmbarazoNoDeseado().setEnabled(true);
            v.getTxtOtroConsecienciasFisicas().setEnabled(true);
        }

    }

    public void no_reporta_motivos_llamada() {

        if (v.getCbNoReporta().isSelected()) {
            v.getCbViolenciaIntrafamiliar().setEnabled(false);
            v.getCbViolenciaInstitucional().setEnabled(false);
            v.getCbAlivioyApoyo().setEnabled(false);
            v.getCbInformacionCasadeAcojida().setEnabled(false);
            v.getCbAbusoSexual().setEnabled(false);
            v.getCbViolenciaSocial().setEnabled(false);
            v.getCbAtencionPsicologica().setEnabled(false);
            v.getCbInformacionOtrasInstituciones().setEnabled(false);
            v.getCbViolacion().setEnabled(false);
            v.getCbAccesoriaLegal().setEnabled(false);
            v.getCbIntentoSuicidio().setEnabled(false);
            v.getTxtOtrosMotivoLlamada().setEditable(false);
        } else {
            v.getCbViolenciaIntrafamiliar().setEnabled(true);
            v.getCbViolenciaInstitucional().setEnabled(true);
            v.getCbAlivioyApoyo().setEnabled(true);
            v.getCbInformacionCasadeAcojida().setEnabled(true);
            v.getCbAbusoSexual().setEnabled(true);
            v.getCbViolenciaSocial().setEnabled(true);
            v.getCbAtencionPsicologica().setEnabled(true);
            v.getCbInformacionOtrasInstituciones().setEnabled(true);
            v.getCbViolacion().setEnabled(true);
            v.getCbAccesoriaLegal().setEnabled(true);
            v.getCbIntentoSuicidio().setEnabled(true);
            v.getTxtOtrosMotivoLlamada().setEditable(true);
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
        v.getPbarGRLL().setVisible(false);
        v.getPbarGRLL().setMaximum(9);
        v.getPbarGRLL().setMinimum(0);
        v.getPbarGRLL().setStringPainted(true);
    }

    public Controlador_registro_llamadas() throws Exception {
    }

    public void llamada() throws SQLException {
        persona_llamadaDB pldb = new persona_llamadaDB();
        LlamadaDB ldb = new LlamadaDB();
        perllamcod = persona_llamadaDB.getPersona_llamada_static();
        int dia = v.getDatFechaLlamada().getCalendar().get(Calendar.DAY_OF_YEAR);
        int mes = v.getDatFechaLlamada().getCalendar().get(Calendar.MONTH);
        int anio = v.getDatFechaLlamada().getCalendar().get(Calendar.YEAR);
        String fecha = anio + "-" + mes + "-" + dia;
        System.out.println(fecha);
        Llamada l = new Llamada(perllamcod, v.getTxtnumero().getText(), fecha,
                v.getCbJornada().getSelectedItem().toString(),
                v.getCbxPrioridad().getSelectedItem().toString(),
                personalcodigo, v.getTxtNotasAdicionalesVictima().getText());
        llamadacoigoID = ldb.insertarLlmada(l);
//    ldb.insertarLlmada(l);

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource().equals(v.getBtnGuardar())) {
            try {
//                System.out.println(fecha);
//                String fecha2="2001-12-08";
//                formato = new SimpleDateFormat("yyyy-MM-dd");
//                Date fechaDate = formato.parse(fecha2);
//                vistaRegis_Llamadas.getDatFechaLlamada().setDateFormatString(fecha2);
//                System.out.println(fechaDate);
                v.getPbarGRLL().setVisible(true);
                if (comprobaciones()) {
                    v.getPbarGRLL().setValue(1);
                    JOptionPane.showMessageDialog(v, "Guardando Datos...");
                    v.getPbarGRLL().setValue(3);
                    datosDeInformcion();
                    llamada();
                    v.getPbarGRLL().setValue(4);
                    motivoLlamada();
                    v.getPbarGRLL().setValue(6);
                    estadoPsico();
                    v.getPbarGRLL().setValue(7);
                    CaracteristicasViolencia();
                    resultados();
                    v.getPbarGRLL().setValue(8);
                    limpiar_campos();
                    JOptionPane.showMessageDialog(v, "Datos Guardados Corretamente");
                    v.getPbarGRLL().setValue(9);
                }

//                
            } catch (SQLException ex) {
                Logger.getLogger(Controlador_registro_llamadas.class
                        .getName()).log(Level.SEVERE, null, ex);
                
                    v.getPbarGRLL().setValue(9);
            } catch (ParseException ex) {
                Logger.getLogger(Controlador_registro_llamadas.class
                        .getName()).log(Level.SEVERE, null, ex);
                
                    v.getPbarGRLL().setValue(9);
            }
        }
        v.getPbarGRLL().setVisible(false);
        //boton generar cita
        if (e.getSource().equals(v.getBtnGenerarCita())) {

        }

    }

    public void estadoPsico() throws SQLException {
        EstadoPsicoEmoDB epedb = new EstadoPsicoEmoDB();
        x_llamad_estad_psicoDB xllepDB;

        LlamadaDB ldb = new LlamadaDB();
        if (v.getCbAnsiosa().isSelected()) {
            int re = epedb.obtenerIdEstado("Ansiosa", 1);
            int llamadacodigo = ldb.obtenerIdllamada();
            xllepDB = new x_llamad_estad_psicoDB(llamadacodigo, re);
//xllep = new x_llamada_estado_psico(llamadacodigo,0, re);
            xllepDB.insertar();
        }
        if (v.getCbAsustada().isSelected()) {
            int re = epedb.obtenerIdEstado("Asustada", 1);
            int llamadacodigo = ldb.getLlamada_static();
            xllepDB = new x_llamad_estad_psicoDB(llamadacodigo, re);
            xllepDB.insertar();

        }
        if (v.getCbNerviosa().isSelected()) {
            int re = epedb.obtenerIdEstado("Nerviosa", 1);
            int llamadacodigo = ldb.getLlamada_static();
            xllepDB = new x_llamad_estad_psicoDB(llamadacodigo, re);
            xllepDB.insertar();
        }
        if (v.getCbTranquila().isSelected()) {
            int re = epedb.obtenerIdEstado("Tranquila", 1);
            int llamadacodigo = ldb.getLlamada_static();
            xllepDB = new x_llamad_estad_psicoDB(llamadacodigo, re);
            xllepDB.insertar();
        }
        if (v.getCbLlorosa().isSelected()) {
            int re = epedb.obtenerIdEstado("Llorosa", 1);
            int llamadacodigo = ldb.getLlamada_static();
            xllepDB = new x_llamad_estad_psicoDB(llamadacodigo, re);
            xllepDB.insertar();
        }
        if (v.getCbEnojada().isSelected()) {
            int re = epedb.obtenerIdEstado("Enojada", 1);
            int llamadacodigo = ldb.getLlamada_static();
            xllepDB = new x_llamad_estad_psicoDB(llamadacodigo, re);
            xllepDB.insertar();
        }

        int re = epedb.obtenerIdEstado(v.getCbHabla().getSelectedItem().toString(), 2);
        int llamadacodigo = ldb.getLlamada_static();
        xllepDB = new x_llamad_estad_psicoDB(llamadacodigo, re);
        xllepDB.insertar();

        int re2 = epedb.obtenerIdEstado(v.getCbVoz().getSelectedItem().toString(), 3);
        int llamadacodigo2 = ldb.getLlamada_static();
        xllepDB = new x_llamad_estad_psicoDB(llamadacodigo2, re2);
        xllepDB.insertar();

    }

    public void motivoLlamada() throws SQLException {
        MotivoDB m = new MotivoDB();
        x_motivo_llamadaDB xmldb;

        LlamadaDB ldb = new LlamadaDB();
        if (v.getCbViolenciaIntrafamiliar().isSelected()) {
            int llamadacodigo = ldb.getLlamada_static();
            int motivo = m.obteMotivId("Violencia Intrafamiliar");
            xmldb = new x_motivo_llamadaDB(llamadacodigo, motivo, "");
            xmldb.insertar_x_motivo_llamada();

        }
        if (v.getCbViolenciaInstitucional().isSelected()) {
            int llamadacodigo = ldb.getLlamada_static();
            int motivo = m.obteMotivId("Violencia Intitucional");
            xmldb = new x_motivo_llamadaDB(llamadacodigo, motivo, "");
            xmldb.insertar_x_motivo_llamada();
        }
        if (v.getCbAlivioyApoyo().isSelected()) {
            int llamadacodigo = ldb.getLlamada_static();
            int motivo = m.obteMotivId("Alivio y apoyo");
            xmldb = new x_motivo_llamadaDB(llamadacodigo, motivo, "");
            xmldb.insertar_x_motivo_llamada();
        }
        if (v.getCbInformacionCasadeAcojida().isSelected()) {
            int llamadacodigo = ldb.getLlamada_static();
            int motivo = m.obteMotivId("Información sobre la casa de acogida");
            xmldb = new x_motivo_llamadaDB(llamadacodigo, motivo, "");
            xmldb.insertar_x_motivo_llamada();
        }
        if (v.getCbAbusoSexual().isSelected()) {
            int llamadacodigo = ldb.getLlamada_static();
            int motivo = m.obteMotivId("Abuso sexual");
            xmldb = new x_motivo_llamadaDB(llamadacodigo, motivo, "");
            xmldb.insertar_x_motivo_llamada();
        }
        if (v.getCbViolenciaSocial().isSelected()) {
            int llamadacodigo = ldb.getLlamada_static();
            int motivo = m.obteMotivId("Violencia social");
            xmldb = new x_motivo_llamadaDB(llamadacodigo, motivo, "");
            xmldb.insertar_x_motivo_llamada();
        }
        if (v.getCbAtencionPsicologica().isSelected()) {
            int llamadacodigo = ldb.getLlamada_static();
            int motivo = m.obteMotivId("Atención psicológica");
            xmldb = new x_motivo_llamadaDB(llamadacodigo, motivo, "");
            xmldb.insertar_x_motivo_llamada();
        }
        if (v.getCbInformacionOtrasInstituciones().isSelected()) {
            int llamadacodigo = ldb.getLlamada_static();
            int motivo = m.obteMotivId("Información sobre otras instituciones");
            xmldb = new x_motivo_llamadaDB(llamadacodigo, motivo, "");
            xmldb.insertar_x_motivo_llamada();
        }
        if (v.getCbViolacion().isSelected()) {
            int llamadacodigo = ldb.getLlamada_static();
            int motivo = m.obteMotivId("Violación");
            xmldb = new x_motivo_llamadaDB(llamadacodigo, motivo, "");
            xmldb.insertar_x_motivo_llamada();
        }
        if (v.getCbAccesoriaLegal().isSelected()) {
            int llamadacodigo = ldb.getLlamada_static();
            int motivo = m.obteMotivId("Asesoría legal");
            xmldb = new x_motivo_llamadaDB(llamadacodigo, motivo, "");
            xmldb.insertar_x_motivo_llamada();
        }
        if (v.getCbIntentoSuicidio().isSelected()) {
            int llamadacodigo = ldb.getLlamada_static();
            int motivo = m.obteMotivId("Intento de suicidio");
            xmldb = new x_motivo_llamadaDB(llamadacodigo, motivo, "");
            xmldb.insertar_x_motivo_llamada();
        }
        if (v.getCbNoReporta().isSelected()) {
            int llamadacodigo = ldb.getLlamada_static();
            int motivo = m.obteMotivId("No reporta");
            xmldb = new x_motivo_llamadaDB(llamadacodigo, motivo, "");
            xmldb.insertar_x_motivo_llamada();
        }
        if (!v.getTxtOtrosMotivoLlamada().equals("")) {
            int llamadacodigo = ldb.getLlamada_static();
            int motivo = m.obteMotivId("Otra");
            xmldb = new x_motivo_llamadaDB(llamadacodigo, motivo, v.getTxtOtrosMotivoLlamada().getText());
            xmldb.insertar_x_motivo_llamada();
        }

    }

    public void CaracteristicasViolencia() throws SQLException, ParseException {

        Caracteristicas_violenciaDB c = new Caracteristicas_violenciaDB();
        x_caracteristicas_agresorDB xc;
        LlamadaDB ldb = new LlamadaDB();
        Llamada_riesgosDB lrdb;

        if (v.getCbFisica().isSelected()) {
            int re = c.obtener_id("Física", 1);
            int llamadacodigo = LlamadaDB.getLlamada_static();
            xc = new x_caracteristicas_agresorDB(llamadacodigo, "", "", re);
            xc.isertarRegistroCaracteristica();
        }
        if (v.getCbPsicologica().isSelected()) {
            int re = c.obtener_id("Psicológica", 1);
            int llamadacodigo = LlamadaDB.getLlamada_static();
            xc = new x_caracteristicas_agresorDB(llamadacodigo, "", "", re);
            xc.isertarRegistroCaracteristica();
        }
        if (v.getCbLaboral().isSelected()) {
            int re = c.obtener_id("Laboral", 1);
            int llamadacodigo = LlamadaDB.getLlamada_static();
            xc = new x_caracteristicas_agresorDB(llamadacodigo, "", "", re);
            xc.isertarRegistroCaracteristica();
        }
        if (v.getCbEconomica().isSelected()) {
            int re = c.obtener_id("Económica", 1);
            int llamadacodigo = LlamadaDB.getLlamada_static();
            xc = new x_caracteristicas_agresorDB(llamadacodigo, "", "", re);
            xc.isertarRegistroCaracteristica();
        }
        if (v.getCbNegligencia().isSelected()) {
            int re = c.obtener_id("Negligencia", 1);
            int llamadacodigo = LlamadaDB.getLlamada_static();
            xc = new x_caracteristicas_agresorDB(llamadacodigo, "", "", re);
            xc.isertarRegistroCaracteristica();
        }
        if (!v.getTxtOtro_tipo_violencia().getText().equals("")) {
            int re = c.obtener_id("Otra", 1);
            int llamadacodigo = LlamadaDB.getLlamada_static();
            xc = new x_caracteristicas_agresorDB(llamadacodigo, "", v.getTxtOtro_tipo_violencia().getText(), re);
            xc.isertarRegistroCaracteristica();
        }
        if (v.getCbNoReportaTipoViolencia().isSelected()) {
            int re = c.obtener_id("No reporta", 1);
            int llamadacodigo = LlamadaDB.getLlamada_static();
            xc = new x_caracteristicas_agresorDB(llamadacodigo, "", "", re);
            xc.isertarRegistroCaracteristica();
        }
        if (v.getCbEsposo().isSelected()) {
            int re = c.obtener_id("Esposo", 2);
            int llamadacodigo = LlamadaDB.getLlamada_static();
            xc = new x_caracteristicas_agresorDB(llamadacodigo, "", "", re);
            xc.isertarRegistroCaracteristica();
        }
        if (v.getCbPadre_Madre().isSelected()) {
            int re = c.obtener_id("Padre/Madre", 2);
            int llamadacodigo = LlamadaDB.getLlamada_static();
            xc = new x_caracteristicas_agresorDB(llamadacodigo, "", "", re);
            xc.isertarRegistroCaracteristica();
        }
        if (v.getCbNovio().isSelected()) {
            int re = c.obtener_id("Novio", 2);
            int llamadacodigo = LlamadaDB.getLlamada_static();
            xc = new x_caracteristicas_agresorDB(llamadacodigo, "", "", re);
            xc.isertarRegistroCaracteristica();
        }
        if (v.getCbExPareja().isSelected()) {
            int re = c.obtener_id("Ex pareja", 2);
            int llamadacodigo = LlamadaDB.getLlamada_static();
            xc = new x_caracteristicas_agresorDB(llamadacodigo, "", "", re);
            xc.isertarRegistroCaracteristica();
        }
        if (v.getCbHijo().isSelected()) {
            int re = c.obtener_id("Hijo", 2);
            int llamadacodigo = LlamadaDB.getLlamada_static();
            xc = new x_caracteristicas_agresorDB(llamadacodigo, "", "", re);
            xc.isertarRegistroCaracteristica();
        }
        if (v.getCbJefe().isSelected()) {
            int re = c.obtener_id("Jefe", 2);
            int llamadacodigo = LlamadaDB.getLlamada_static();
            xc = new x_caracteristicas_agresorDB(llamadacodigo, "", "", re);
            xc.isertarRegistroCaracteristica();
        }
        if (!v.getTxtOtrosQuienEsElAgresor().getText().equals("")) {
            int re = c.obtener_id("Otra", 2);
            int llamadacodigo = ldb.getLlamada_static();
            xc = new x_caracteristicas_agresorDB(llamadacodigo, "", v.getTxtOtrosQuienEsElAgresor().getText(), re);
            xc.isertarRegistroCaracteristica();
        }
        if (v.getCbNoReportaQuienEsElAgresor().isSelected()) {
            int re = c.obtener_id("No reporta", 2);
            int llamadacodigo = LlamadaDB.getLlamada_static();
            xc = new x_caracteristicas_agresorDB(llamadacodigo, "", "", re);
            xc.isertarRegistroCaracteristica();
        }
        if (v.getCbAlcolismo().isSelected()) {
            int re = c.obtener_id("Alcoholismo", 3);
            int llamadacodigo = LlamadaDB.getLlamada_static();
            xc = new x_caracteristicas_agresorDB(llamadacodigo, "", "", re);
            xc.isertarRegistroCaracteristica();
        }
        if (v.getCbMigracion().isSelected()) {
            int re = c.obtener_id("Migración", 3);
            int llamadacodigo = LlamadaDB.getLlamada_static();
            xc = new x_caracteristicas_agresorDB(llamadacodigo, "", "", re);
            xc.isertarRegistroCaracteristica();
        }
        if (v.getCbCelos().isSelected()) {
            int re = c.obtener_id("Celos", 3);
            int llamadacodigo = LlamadaDB.getLlamada_static();
            xc = new x_caracteristicas_agresorDB(llamadacodigo, "", "", re);
            xc.isertarRegistroCaracteristica();
        }
        if (v.getCbDesempleo().isSelected()) {
            int re = c.obtener_id("Desempleo", 3);
            int llamadacodigo = LlamadaDB.getLlamada_static();
            xc = new x_caracteristicas_agresorDB(llamadacodigo, "", "", re);
            xc.isertarRegistroCaracteristica();
        }
        if (v.getCbInfidelidad().isSelected()) {
            int re = c.obtener_id("Infidelidad", 3);
            int llamadacodigo = LlamadaDB.getLlamada_static();
            xc = new x_caracteristicas_agresorDB(llamadacodigo, "", "", re);
            xc.isertarRegistroCaracteristica();
        }
        if (v.getCbMachismo().isSelected()) {
            int re = c.obtener_id("Machismo", 3);
            int llamadacodigo = LlamadaDB.getLlamada_static();
            xc = new x_caracteristicas_agresorDB(llamadacodigo, "", "", re);
            xc.isertarRegistroCaracteristica();
        }
        if (!v.getTxtOtrosFactoresRiesgo().getText().equals("")) {
            int re = c.obtener_id("Otra", 3);
            int llamadacodigo = LlamadaDB.getLlamada_static();
            xc = new x_caracteristicas_agresorDB(llamadacodigo, "", v.getTxtOtrosQuienEsElAgresor().getText(), re);
            xc.isertarRegistroCaracteristica();
        }
        if (v.getCbNoReportaFactoresRiesgo().isSelected()) {
            int re = c.obtener_id("No reporta", 3);
            int llamadacodigo = LlamadaDB.getLlamada_static();
            xc = new x_caracteristicas_agresorDB(llamadacodigo, "", "", re);
            xc.isertarRegistroCaracteristica();
        }
        if (v.getCbFracturas().isSelected()) {
            int re = c.obtener_id("Fracturas", 4);
            int llamadacodigo = LlamadaDB.getLlamada_static();
            xc = new x_caracteristicas_agresorDB(llamadacodigo, "", "", re);
            xc.isertarRegistroCaracteristica();
        }
        if (v.getCbMoretones().isSelected()) {
            int re = c.obtener_id("Moretones", 4);
            int llamadacodigo = LlamadaDB.getLlamada_static();
            xc = new x_caracteristicas_agresorDB(llamadacodigo, "", "", re);
            xc.isertarRegistroCaracteristica();
        }
        if (v.getCbHeridas().isSelected()) {
            int re = c.obtener_id("Heridas", 4);
            int llamadacodigo = LlamadaDB.getLlamada_static();
            xc = new x_caracteristicas_agresorDB(llamadacodigo, "", "", re);
            xc.isertarRegistroCaracteristica();
        }
        if (v.getCbAbortos().isSelected()) {
            int re = c.obtener_id("Abortos", 4);
            int llamadacodigo = LlamadaDB.getLlamada_static();
            xc = new x_caracteristicas_agresorDB(llamadacodigo, "", "", re);
            xc.isertarRegistroCaracteristica();
        }
        if (v.getCbContagiosETS().isSelected()) {
            int re = c.obtener_id("Contagios ETS", 4);
            int llamadacodigo = LlamadaDB.getLlamada_static();
            xc = new x_caracteristicas_agresorDB(llamadacodigo, "", "", re);
            xc.isertarRegistroCaracteristica();
        }
        if (v.getCbAlt_Nerviosas().isSelected()) {
            int re = c.obtener_id("Alt. Nerviosas", 4);
            int llamadacodigo = LlamadaDB.getLlamada_static();
            xc = new x_caracteristicas_agresorDB(llamadacodigo, "", "", re);
            xc.isertarRegistroCaracteristica();
        }
        if (v.getCbBajaAutoestima().isSelected()) {
            int re = c.obtener_id("Baja autoestima", 4);
            int llamadacodigo = LlamadaDB.getLlamada_static();
            xc = new x_caracteristicas_agresorDB(llamadacodigo, "", "", re);
            xc.isertarRegistroCaracteristica();
        }
        if (v.getCbDepresion().isSelected()) {
            int re = c.obtener_id("Depresión", 4);
            int llamadacodigo = LlamadaDB.getLlamada_static();
            xc = new x_caracteristicas_agresorDB(llamadacodigo, "", "", re);
            xc.isertarRegistroCaracteristica();
        }
        if (v.getCbEmbarazoNoDeseado().isSelected()) {
            int re = c.obtener_id("Embarazo no deseado", 4);
            int llamadacodigo = LlamadaDB.getLlamada_static();
            xc = new x_caracteristicas_agresorDB(llamadacodigo, "", "", re);
            xc.isertarRegistroCaracteristica();
        }
        if (!v.getTxtOtroConsecienciasFisicas().getText().equals("")) {
            int re = c.obtener_id("Otra", 4);
            int llamadacodigo = LlamadaDB.getLlamada_static();
            xc = new x_caracteristicas_agresorDB(llamadacodigo, "", v.getTxtOtrosQuienEsElAgresor().getText(), re);
            xc.isertarRegistroCaracteristica();
        }
        if (v.getCbNoReportaConcecuenciasFisicas().isSelected()) {
            int re = c.obtener_id("No reporta", 4);
            int llamadacodigo = LlamadaDB.getLlamada_static();
            xc = new x_caracteristicas_agresorDB(llamadacodigo, "", "", re);
            xc.isertarRegistroCaracteristica();
        }
        int llamada_codigo = LlamadaDB.getLlamada_static();
        frecuencia = v.getCbFrecuenciaAgresion().getSelectedItem().toString();
        nacionalidad = v.getCbNacionalidadAgresor().getSelectedItem().toString();
        lrdb = new Llamada_riesgosDB(llamada_codigo, frecuencia, nacionalidad);
        lrdb.insertarLlamadaRiesgos();

    }

    public boolean comprobaciones() {

        if (v.getDatFechaLlamada().getDate() != null) {

            if (v.getCbJornada().getSelectedIndex() != 0) {

                if (v.getCbxPrioridad().getSelectedIndex() != 0) {

                    return true;

                } else {
                    JOptionPane.showMessageDialog(v, "Selecione una prioridad, porfavor.");
                    return false;
                }

            } else {
                JOptionPane.showMessageDialog(v, "Selecione una hora, porfavor.");
                return false;
            }

        } else {
            JOptionPane.showMessageDialog(v, "Selecione una fecha, porfavor.");
            return false;
        }

    }

    public void llenarEstadoCivil() throws ParseException, SQLException {
        modelo = new DefaultComboBoxModel();

        for (Json_object_consulta o : listaEstadoCivil) {
            modelo.addElement(o.getValor());
        }
        v.getCbxEstadoCivilVictima().setModel(modelo);
    }

    public void llenarComboNacionalidades() throws ParseException, SQLException {
        modelo = new DefaultComboBoxModel();

        for (Json_object_consulta o : listaNacionalidades) {
            modelo.addElement(o.getValor());
        }
        v.getCbNacionalidadAgresor().setModel(modelo);
        v.getCbnacionalidadVictima().setModel(modelo);
    }

    public void llenarComboResultados() {//llenado del combo resultados
        modelo = new DefaultComboBoxModel();
        persona_llamadaDB p = new persona_llamadaDB();
        res = p.listaResultados();
        for (Resultado o : res) {
            modelo.addElement(o.getResultado_nombre());
        }
        v.getCbReultados().setModel(modelo);
    }

    public void resultados() throws SQLException {
        LlamadaDB llama = new LlamadaDB();
        x_resultado_llamadaDB xrldb = new x_resultado_llamadaDB();
        llamadacodigoId = llama.getLlamada_static();

        if (!v.getTxtOtrosResultado().getText().equals("")) {
            resultado = v.getCbReultados().getSelectedIndex() + 1;
            descripcion = v.getTxtOtrosResultado().getText();
            x_resultado_llamada xrl = new x_resultado_llamada(llamadacodigoId, resultado, descripcion);
            xrldb.ingresarResultados(xrl);

        } else {
            resultado = v.getCbReultados().getSelectedIndex() + 1;
            x_resultado_llamada xrl = new x_resultado_llamada(llamadacodigoId, resultado, "");
            xrldb.ingresarResultados(xrl);
        }

    }

    public void datosDeInformcion() {

        String nombre = "", apellido = "", edad = "", direccion = "", estado_civil = "", nacionalidad = "", comosupollamada = "", cde_cod = "";
        int numerohijos = 0;
        boolean trabaja = true;
        Persona_llamada pl;
        try {
            nombre = v.getTxtNombreVictima().getText().toUpperCase();
            apellido = v.getTxtApellidoVictima().getText().toUpperCase();
            edad = v.getSpnEdadVictima().getValue().toString();
            System.out.println(edad);
            direccion = v.getTxtDireccionVictima().getText();
            nacionalidad = v.getCbnacionalidadVictima().getSelectedItem().toString();
            estado_civil = v.getCbxEstadoCivilVictima().getSelectedItem().toString();
            numerohijos = Integer.parseInt(v.getSpnNumeroHijos().getValue().toString());
            comosupollamada = v.getTxtComoSupoLineaTelfonica().getText();
            if (v.getRbTrabajaSi().isSelected()) {
                trabaja = true;
            }
            if (v.getRbTrabajaNoReporta().isSelected()) {
                trabaja = false;
            }
            if (v.getRbTrabajoNo().isSelected()) {
                trabaja = false;
            }

        } catch (Exception e) {
        }
        cde_cod = v.getTxtCedula().getText();
        pl = new Persona_llamada(nombre, apellido, direccion, nacionalidad, edad, estado_civil, numerohijos, comosupollamada, trabaja, cde_cod);
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
