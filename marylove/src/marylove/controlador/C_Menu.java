package marylove.controlador;

import java.awt.Cursor;
import static java.awt.Cursor.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowStateListener;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import marylove.DBmodelo.*;
import static marylove.controlador.C_Login.personal_cod;
import static marylove.controlador.C_Login.usuario;

import marylove.models.*;
import marylove.vista.*;

public class C_Menu {

    private V_Menu menu;

    // ficha legal 
    FichaLegal vLegal = new FichaLegal();
    int nctrhleg = 0;

    // ficha Registro Actuaciones
    FichaRegistroActuaciones vFRA = new FichaRegistroActuaciones();
    int nctrhregac = 0;

    // Plan emergente
    VistaPlanEmergente vista = new VistaPlanEmergente();
    int nctrhplem = 0;

    // primer encuentro
    FichaPrimerEncuentro vFPE = new FichaPrimerEncuentro();
    int nctrhpenc = 0;

    // Historia Clinica
    FichaHistoriaClinica vistaHC = new FichaHistoriaClinica();
    int nctrhhiscli = 0;

    //Ficha Registro Referencia
    Ficharegistroyreferencia vFRR = new Ficharegistroyreferencia();
    int nctrhRRef = 0;

    // citas
    VistaCita vistaCita = new VistaCita();
    int nctrhCit = 0;

    // evalucion plan de vida
    FichaEvaluacionPlandeVida vistaEvaPlanVid = new FichaEvaluacionPlandeVida();
    int nctrhEPV = 0;

    // Avances proceso terapeutico
//    IngresoAvanceProceTerapeuticoDB modeloAPrT = new IngresoAvanceProceTerapeuticoDB();
//    CtrlIngresoAvanceProceTerapeutico contAPrT = new CtrlIngresoAvanceProceTerapeutico(modeloAPrT, vistaAPrT);
    // Plan atencion terapeutica
    FichaPlanAtencionTerapeutica vFAtT = new FichaPlanAtencionTerapeutica();
    int nctrhPAT = 0;

    //Plan Evalucion Proceso Terapeutico
    FichaEvolucionProcesoTerapeutico vEvPrT = new FichaEvolucionProcesoTerapeutico();
    int nctrhEPT = 0;

//    // agregar agresor
//    FormaAgregarAgresores vistaAgAs = new FormaAgregarAgresores();
//    ControladorAgregarAgresores contAgAs;
    // datos iniciales 
    VistaDatosIniciales vDatosIni = new VistaDatosIniciales();
    ControladorDatosIniciales contDat = new ControladorDatosIniciales();

    //agregar familia
    VistaAgregarFamiliar vistaAgFamil = new VistaAgregarFamiliar(vDatosIni);
    JTable tablaFamiliares = new JTable();
    ControladorAgregarFamiliar contAgFaml;

    //agregar hijos
    FormaAgregarHijos vFomAgHj = new FormaAgregarHijos();
    ControladorAgregarHijos contAgHj;
    int nctrAgHj = 0;

//    // agregar institucion educativa
//    FormaAgregarInstitucionEduc vAgIsEd = new FormaAgregarInstitucionEduc();
//    ControladorAgregarInstitucionEduc contAgIsEd;
    // buscar persona
    VistaConsultaPersona vConsPer = new VistaConsultaPersona();
    ControladorBuscarPersona contBP;

    //Ficha Egreso
    FichaEgreso vistaEgres = new FichaEgreso();
    EgresoDB egresoModelDb = new EgresoDB();
    int nctrhEgr = 0;

    // Ficha ingreso
    FichaIngreso vistaFichIngreso = new FichaIngreso();
    int nctrhFIng = 0;

// ficha R1
    formularioR1 vistaR1 = new formularioR1();
    int nctrhR1 = 0;

    // Plan de vida
    FichaPlandeVida vPVida = new FichaPlandeVida();
    int nctrhPvid = 0;

    // registro llamada
    VistaRegistroLlamada vLlamada = new VistaRegistroLlamada();
    int nctrhRllam = 0;

    //plan de recursos
    VistaPlanRecursos vpr = new VistaPlanRecursos();
    int nctrhRec = 0;

    // plan de autonomia
    VistaPlanAutonomía vPAuton = new VistaPlanAutonomía();
    int ctrhpanaut = 0;

    // Anamnesis
    FichaAnamnesis vistaAnamnesis = new FichaAnamnesis();
    ControladorFichaAnamnesis ctrAnamn = new ControladorFichaAnamnesis(vistaAnamnesis);
    int ctrhAnam = 0;
    // reportes
    ViewReports vreportes = new ViewReports();
    int nctrhRept = 0;

    // Bitacora
    VistaBitacora vbitacora = new VistaBitacora();
    int nctrhBit = 0;

    //filtro hijos victima
    VistaFiltroVistaVictima vfv = new VistaFiltroVistaVictima();
    int nctrhFhv = 0;

    // formulario R2
    formuR2 vFR2 = new formuR2();
    int nctrhFR2 = 0;

    // formulario R3
    FichaFormularioR3 vFR3 = new FichaFormularioR3();
    int nctrhFR3 = 0;

    //Resultados
    VistaResultados vistRes = new VistaResultados();
    int nctrhResul = 0;

    int accLG = 1;
    int accIN = 1;
    int accPs = 1;
    int accTS = 1;
    int accRep = 1;

    private JPanel muestraPanel = null;

    int prog = 0;

    public C_Menu(V_Menu menu) throws Exception {
        this.menu = menu;
    }

    public void opcionesVentana() {
        try {
            String[] botones = {"Cerrar Session", "Cerrar Aplicacion", "Cancelar"};
            int x = JOptionPane.showOptionDialog(null, "Que desea hacer ?", "Acciones del Sitema", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.WARNING_MESSAGE, null, botones, botones[0]);
            if (x == 0) {
                vistaCarga vistCarg = new vistaCarga();
                V_Login lg = new V_Login();
                V_Menu vP = new V_Menu();
                Personal pl = new Personal();
                Persona pr = new Persona();
                personaDB pDB = new personaDB();
                personalDB plDB = new personalDB();
                C_Menu menu1 = new C_Menu(vP);
                C_Login cl = new C_Login(vistCarg, lg, vP, pl, pr, pDB, plDB, menu1);
                JOptionPane.showMessageDialog(null, "Espere por favor ....");
                menu.dispose();
                cl.iniciaControl();
                System.out.println("session cerrada");
            } else if (x == 1) {
                System.out.println("Saliendo ....");
                System.exit(0);
            }
        } catch (Exception e) {
            System.out.println("Error capturado: " + e.getMessage());
            System.out.println("Cauda: " + e.getCause());
        }

    }

    public void iniciaControl() {
        this.menu.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                try {
                    opcionesVentana();
                } catch (Exception ex) {
                    Logger.getLogger(C_Menu.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

            @Override
            public void windowActivated(WindowEvent e) {
                try {
                    if (muestraPanel != null) {
                        abriPanelVistas(muestraPanel);
                    }
                } catch (Exception ex) {
                    System.out.println("error al adaptar el panel " + ex.getMessage());
                }
            }
        });
        this.menu.addWindowStateListener(new WindowStateListener() {
            @Override
            public void windowStateChanged(WindowEvent e) {
                if (muestraPanel != null) {
                    abriPanelVistas(muestraPanel);
                }
            }
        });
        menu.getBtnCerrar().addActionListener(e -> opcionesVentana());
        obtenerPerfil();
        ocultarInf();
        ocultarLeg();
        ocultarPS();
        ocultarRep();
        ocultarTr();
        menu.getPgbMenu().setVisible(false);

        menu.getPgbMenu().setMaximum(9);
        menu.getPgbMenu().setMinimum(0);
        menu.getPgbMenu().setStringPainted(true);

        menu.getBtnsoc().addActionListener(e -> {
            Trabajo();
        });
        menu.getBtnleg().addActionListener(e -> {
            Legal();
        });
        menu.getBtnpsico().addActionListener(e -> {
            psicologia();
        });
        menu.getBtninf().addActionListener(e -> {
            infanto();
        });

        menu.getBtnMLegal1().addActionListener(e -> {
            menu.getBtnMLegal1().setCursor(new Cursor(WAIT_CURSOR));
            control(1);
            abriPanelVistas(vLegal.getPnlPFL());
        });
        menu.getBtnMLegal2().addActionListener(e -> {
            menu.getBtnMLegal2().setCursor(new Cursor(WAIT_CURSOR));
            control(2);
            abriPanelVistas(vFRA.getJpFondo());
        });
        menu.getBtnMformR2().addActionListener(e -> {
            menu.getBtnMformR2().setCursor(new Cursor(WAIT_CURSOR));
            control(3);
            vista.setVisible(true);
        });
        menu.getBtnPPriEn().addActionListener(e -> {
            menu.getBtnPPriEn().setCursor(new Cursor(WAIT_CURSOR));
            control(4);
            abriPanelVistas(vFPE.getPnlPrimerEncuentro());
        });
        menu.getBtnPHistCli().addActionListener(e -> {
            menu.getBtnPHistCli().setCursor(new Cursor(WAIT_CURSOR));
            control(5);
            abriPanelVistas(vistaHC.getPnlFchHisCli());
        });
        menu.getBtnCita().addActionListener(e -> {
            menu.getBtnCita().setCursor(new Cursor(WAIT_CURSOR));
            control(6);
            abriPanelVistas(vistaCita.getPanelCitas());
        });
        vLlamada.getBtnGenerarCita().addActionListener(e -> {
            menu.getBtnCita().setCursor(new Cursor(WAIT_CURSOR));
            control(6);
            abriPanelVistas(vistaCita.getPanelCitas());
        });
        menu.getBtnEvalPlVida().addActionListener(e -> {
            menu.getBtnEvalPlVida().setCursor(new Cursor(WAIT_CURSOR));
            control(7);
            abriPanelVistas(vistaEvaPlanVid.getPnlEvaluPV());
        });
        menu.getBtnPPlanTera().addActionListener(e -> {
            menu.getBtnPPlanTera().setCursor(new Cursor(WAIT_CURSOR));
            control(9);
            abriPanelVistas(vFAtT.getPnlPAtTer());
        });
        menu.getBtnPProcT().addActionListener(e -> {
            menu.getBtnPProcT().setCursor(new Cursor(WAIT_CURSOR));
            control(10);
            abriPanelVistas(vEvPrT.getPanelFichaEvaluacionProceTera());
        });
        menu.getBtnTAuto().addActionListener(e -> {
            menu.getBtnTAuto().setCursor(new Cursor(WAIT_CURSOR));
            control(11);
            abriPanelVistas(vPAuton.getPnlPlanAuton());
        });
        menu.getBtnMingreso().addActionListener(e -> {
            menu.getBtnMingreso().setCursor(new Cursor(WAIT_CURSOR));
            control(12);
            abriPanelVistas(vistaFichIngreso.getPnlFichaIngre());
        });
        menu.getBtnIplanD().addActionListener(e -> {
            menu.getBtnIplanD().setCursor(new Cursor(WAIT_CURSOR));
            control(22);
            abriPanelVistas(vfv.getPanelFondo());
        });
        menu.getBtnllamada().addActionListener(e -> {
            menu.getBtnllamada().setCursor(new Cursor(WAIT_CURSOR));
            control(14);
            abriPanelVistas(vLlamada.getPnlLlamadas());
        });
        menu.getBtnMegreso().addActionListener(e -> {
            menu.getBtnMegreso().setCursor(new Cursor(WAIT_CURSOR));
            control(15);
            abriPanelVistas(vistaEgres.getPanelEgreso());
        });
        menu.getBtnTRecur().addActionListener(e -> {
            menu.getBtnTRecur().setCursor(new Cursor(WAIT_CURSOR));
            control(16);
            abriPanelVistas(vpr.getPlRecursos());
        });
        menu.getBtnTPlanV().addActionListener(e -> {
            menu.getBtnTPlanV().setCursor(new Cursor(WAIT_CURSOR));
            control(17);
            abriPanelVistas(vPVida.getPlPlandeVida());
        });
        menu.getBtnMformR1().addActionListener(e -> {
            menu.getBtnMformR1().setCursor(new Cursor(WAIT_CURSOR));
            control(18);
            abriPanelVistas(vistaR1.getPnlfr1());
        });
        menu.getBtnRegistro().addActionListener(e -> {
            menu.getBtnRegistro().setCursor(new Cursor(WAIT_CURSOR));
            control(19);
            abriPanelVistas(vFRR.getPlRegistroReferencia());
        });
        menu.getBtnReportes().addActionListener(e -> {
            menu.getBtnReportes().setCursor(new Cursor(WAIT_CURSOR));
            control(20);
            abrirReportes(1);
        });
        menu.getBtnMBitacora().addActionListener(e -> {
            menu.getBtnMBitacora().setCursor(new Cursor(WAIT_CURSOR));
            control(21);
            abriPanelVistas(vbitacora.getPnlPrincipal());
        });

        //menu.getBtnMreprot1().addActionListener(e -> {);
        menu.getBtnMreport2().addActionListener(e -> {
            menu.getBtnMreport2().setCursor(new Cursor(WAIT_CURSOR));
            control(24);
            abriPanelVistas(vFR2.getPnaelFormulario2());
        });
        menu.getBtnMreportGn().addActionListener(e -> {
            menu.getBtnMreportGn().setCursor(new Cursor(WAIT_CURSOR));
            control(23);
            abriPanelVistas(vFR3.getPnlFR3());
        });
        vFRR.getBtnAgregarHijos().addActionListener(e -> control(25));

        vistaFichIngreso.getBtnAgreAcomp().addActionListener(e -> {
            if (vistaFichIngreso.getCbxParent1().getSelectedItem().toString().equals("Hijo/a") && !vistaFichIngreso.getTxtCodigo().getText().equals("")) {
                control(25);
                vFomAgHj.setVisible(true);
                vFomAgHj.setLocationRelativeTo(null);
                vFomAgHj.setResizable(false);
            }
        });
        vistaAnamnesis.getBtnCancelar().addActionListener(e -> {
            String botones[] = {"Si", "No"};
            int seleccion = JOptionPane.showOptionDialog(null, "Seguro que desea salir del controlador" + " " + "Revisar si guardo los datos", "Seleccione Si o No", 0, 0, null, botones, null);
            if (seleccion == JOptionPane.YES_OPTION) {
                abriPanelVistas(vfv.getPanelFondo());
            }
        });
        vfv.getBtnAFormu().addActionListener(e -> {
            int row = vfv.getTablahijos().getSelectedRow();

            if (row >= 0) {
                String cod = String.valueOf(vfv.getTablahijos().getValueAt(row, 0));
                System.out.println("CODIGO: " + cod);
                if (!estadoControl) {

                    AnamnesisDB anamnesisdb = new AnamnesisDB();
                    estadoControl = true;
                    System.out.println("Hijo codigo C menu: " + cod);
                    if (JOptionPane.showConfirmDialog(null, "¿Desea crear una ficha de anamnesis para el NNA?", "Confirmar creación", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE) == JOptionPane.YES_OPTION) {
                        if (anamnesisdb.consultaAnamnesisExist(Integer.parseInt(cod))) {
                            if (JOptionPane.showConfirmDialog(null, "El NNA ya tiene una ficha. ¿Desea editar esa ficha?", "Confirmar Edición", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE) == JOptionPane.YES_OPTION) {
                                confirmar = false;
                                vistaAnamnesis.txtCodigo.setText(cod);
                                vistaAnamnesis.txtCodigo.setEditable(false);
                                control(26);
                                abriPanelVistas(vistaAnamnesis.getPanelFondo());
                            }
                        } else {
                            confirmar = true;
                            vistaAnamnesis.txtCodigo.setText(cod);
                            vistaAnamnesis.txtCodigo.setEditable(false);
                            control(26);
                            abriPanelVistas(vistaAnamnesis.getPanelFondo());
                        }
                    }
                    estadoControl = false;
                }
            } else {
                JOptionPane.showMessageDialog(null, "Para abrir una ficha, primero seleccione a una NNA, seguido de clic en >>Abrir Ficha<<", "Confirmar ayuda", JOptionPane.WARNING_MESSAGE);
            }
        });
        menu.getBtnResultadosFormu().addActionListener(e -> {
            menu.getBtnResultadosFormu().setCursor(new Cursor(WAIT_CURSOR));
            control(27);
            vistRes.setVisible(true);
            vistRes.setLocationRelativeTo(null);
        });
        menu.getLabuser().setText(usuario);
        menu.getLabperlCod().setText("" + personal_cod);

        //icono
        menu.setIconImage(new ImageIcon(getClass().getResource("/iconos/icono1.png")).getImage());
        menu.setTitle("Ventana Principal *Menu*");
        if (personal_cod != 0) {
            control2();
        }
    }
    boolean estadoControl = false;
    static public boolean confirmar;

    public void control(int ctn) {
        try {
            switch (ctn) {
                case 1:
                    if (nctrhleg == 0) {
                        nctrhleg++;
                        ctrLegal.start();
                    } else {
                        menu.getBtnMLegal1().setCursor(new Cursor(DEFAULT_CURSOR));
                    }
                    break;
                case 2:
                    if (nctrhregac == 0) {
                        nctrhregac++;
                        ctrRegisAct.start();
                    } else {
                        menu.getBtnMLegal2().setCursor(new Cursor(DEFAULT_CURSOR));
                    }
                    break;
                case 3:
                    if (nctrhplem == 0) {
                        nctrhplem++;
                        ctrPlanEmer.start();
                    } else {
                        menu.getBtnMformR2().setCursor(new Cursor(DEFAULT_CURSOR));
                    }
                    break;
                case 4:
                    if (nctrhpenc == 0) {
                        nctrhpenc++;
                        ctrHPE.start();
                    } else {
                        menu.getBtnPPriEn().setCursor(new Cursor(DEFAULT_CURSOR));
                    }
                    break;
                case 5:
                    if (nctrhhiscli == 0) {
                        nctrhhiscli++;
                        ctrHistCli.start();
                    } else {
                        menu.getBtnPHistCli().setCursor(new Cursor(DEFAULT_CURSOR));
                    }
                    break;
                case 6:
                    if (nctrhCit == 0) {
                        nctrhCit++;
                        ctrHCitas.start();
                    } else {
                        menu.getBtnCita().setCursor(new Cursor(DEFAULT_CURSOR));
                    }
                    break;
                case 7:
                    if (nctrhEPV == 0) {
                        nctrhEPV++;
                        ctrHEPVida.start();
                    } else {
                        menu.getBtnEvalPlVida().setCursor(new Cursor(DEFAULT_CURSOR));
                    }
                    break;
                case 8:
//                    contAPrT.iniciarControl();
                    break;
                case 9:
                    if (nctrhPAT == 0) {
                        nctrhPAT++;
                        ctrHPAtT.start();
                    } else {
                        menu.getBtnPPlanTera().setCursor(new Cursor(DEFAULT_CURSOR));
                    }
                    break;
                case 10:
                    if (nctrhEPT == 0) {
                        nctrhEPT++;
                        ctrHEPTr.start();
                    } else {
                        menu.getBtnPProcT().setCursor(new Cursor(DEFAULT_CURSOR));
                    }
                    break;
                case 11:
                    if (ctrhpanaut == 0) {
                        ctrhpanaut++;
                        ctrPlanAT.start();
                    } else {
                        menu.getBtnTAuto().setCursor(new Cursor(DEFAULT_CURSOR));
                    }
                    break;
                case 12:
                    if (nctrhFIng == 0) {
                        nctrhFIng++;
                        ctrHFIngreso.start();
                    } else {
                        menu.getBtnMingreso().setCursor(new Cursor(DEFAULT_CURSOR));
                    }
                    break;
                case 13:
//                    ctrAnamn.inciarControl();
                    break;
                case 14:
                    if (nctrhRllam == 0) {
                        nctrhRllam++;
                        ctrHRLlamada.start();
                    } else {
                        menu.getBtnllamada().setCursor(new Cursor(DEFAULT_CURSOR));
                    }
                    break;
                case 15:
                    if (nctrhEgr == 0) {
                        nctrhEgr++;
                        ctrHEgreso.start();
                    } else {
                        menu.getBtnMegreso().setCursor(new Cursor(DEFAULT_CURSOR));
                    }
                    break;
                case 16:
                    if (nctrhRec == 0) {
                        nctrhRec++;
                        ctrHPRecursos.start();
                    } else {
                        menu.getBtnTRecur().setCursor(new Cursor(DEFAULT_CURSOR));
                    }
                    break;
                case 17:
                    if (nctrhPvid == 0) {
                        nctrhPvid++;
                        ctrHPVida.start();
                    } else {
                        menu.getBtnTPlanV().setCursor(new Cursor(DEFAULT_CURSOR));
                    }
                    break;
                case 18:
                    if (nctrhR1 == 0) {
                        nctrhR1++;
                        ctrHR1.start();
                    } else {
                        menu.getBtnMformR1().setCursor(new Cursor(DEFAULT_CURSOR));
                    }
                    break;
                case 19:
                    if (nctrhRRef == 0) {
                        nctrhRRef++;
                        ctrHRReferen.start();
                    } else {
                        menu.getBtnRegistro().setCursor(new Cursor(DEFAULT_CURSOR));
                    }
                    break;
                case 20:
                    if (nctrhRept == 0) {
                        nctrhRept++;
                        ctrHReporte.start();
                    } else {
                        menu.getBtnReportes().setCursor(new Cursor(DEFAULT_CURSOR));
                    }
                    break;
                case 21:
                    if (nctrhBit == 0) {
                        nctrhBit++;
                        ctrHBitacora.start();
                    } else {
                        menu.getBtnMBitacora().setCursor(new Cursor(DEFAULT_CURSOR));
                    }
                    break;
                case 22:
                    if (nctrhFhv == 0) {
                        nctrhFhv++;
                        ctrHFHijosV.start();
                    } else {
                        menu.getBtnIplanD().setCursor(new Cursor(DEFAULT_CURSOR));
                    }
                    break;
                case 23:
                    if (nctrhFR3 == 0) {
                        nctrhFR3++;
                        ctrHFR3.start();
                    } else {
                        menu.getBtnMreportGn().setCursor(new Cursor(DEFAULT_CURSOR));
                    }
                    break;
                case 24:
                    if (nctrhFR2 == 0) {
                        nctrhFR2++;
                        ctrHFR2.start();
                    } else {
                        menu.getBtnMreport2().setCursor(new Cursor(DEFAULT_CURSOR));
                    }
                    break;
                case 25:
                    if (nctrAgHj == 0) {
                        nctrAgHj++;
                        ctrHAgHi.start();
                    }
                    break;
                case 26:
                    if (ctrhAnam == 0) {
                        ctrhAnam++;
                        ctrHAnam.start();
                    } else {
                        ctrAnamn.accionInicialFicha();
//                        ctrAnamn.cargarMadreVictima();
                    }
                    break;
                case 27:
                    if (nctrhResul == 0) {
                        nctrhResul++;
                        ctrHResult.start();
                    } else {
                        menu.getBtnResultadosFormu().setCursor(new Cursor(DEFAULT_CURSOR));
                    }
                    break;
                default:
                    System.out.println("controladores no ingresados");
                    break;
            }
        } catch (Exception ex) {
            Logger.getLogger(C_Menu.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("ERROR en el control " + ex.getMessage());
        }
    }

    public void control2() {
        try {
            contBP = new ControladorBuscarPersona(vConsPer);
//            contAgIsEd = new ControladorAgregarInstitucionEduc(vAgIsEd);

            contAgFaml = new ControladorAgregarFamiliar(vistaAgFamil, tablaFamiliares);
//            contAgAs = new ControladorAgregarAgresores(vistaAgAs);
        } catch (Exception ex) {
            System.out.println("ERROR en el control 2 " + ex.getMessage());
        }
    }

    // abrir reportes
    public void abrirReportes(int rep) {
        switch (rep) {
            case 1:
                vreportes.setVisible(true);
                vreportes.setLocationRelativeTo(null);
                break;
            case 2:
                break;
            case 3:
                break;
        }
    }
//    public void menu() {
//
//        AnimationClass men = new AnimationClass();
//        men.jLabelXRight(-200, 20, 10, 5, menu.getLblpsico());
//        men.jLabelXRight(-200, 0, 10, 5, menu.getLblsoc());
//        men.jLabelXRight(-200, 30, 10, 5, menu.getLblleg());
//        men.jLabelXRight(-200, 25, 10, 5, menu.getLblinf());
//
//        men.jButtonXRight(-200, 0, 10, 5, menu.getBtnpsico());
//        men.jButtonXRight(-200, 0, 10, 5, menu.getBtnleg());
//        men.jButtonXRight(-200, 0, 10, 5, menu.getBtnsoc());
//        men.jButtonXRight(-200, 0, 10, 5, menu.getBtninf());
//
//        men.jLabelXLeft(20, -200, 10, 5, menu.getLblpsico());
//        men.jLabelXLeft(0, -200, 10, 5, menu.getLblsoc());
//        men.jLabelXLeft(30, -200, 10, 5, menu.getLblleg());
//        men.jLabelXLeft(25, -200, 10, 5, menu.getLblinf());
//
//        men.jButtonXLeft(0, -200, 10, 5, menu.getBtnpsico());
//        men.jButtonXLeft(0, -200, 10, 5, menu.getBtnleg());
//        men.jButtonXLeft(0, -200, 10, 5, menu.getBtnsoc());
//        men.jButtonXLeft(0, -200, 10, 5, menu.getBtninf());
//    }

    public void psicologia() {

        if (accPs == 1) {
            mostrarPS();
            mostrarRep();
            accPs = 2;
        } else if (accPs == 2) {
            ocultarPS();
            ocultarRep();
            accPs = 1;
        }
    }

    public void mostrarPS() {
        menu.getBtnPHistCli().setVisible(true);
        menu.getBtnPPriEn().setVisible(true);
        menu.getBtnPPlanTera().setVisible(true);
        menu.getBtnPProcT().setVisible(true);
    }

    public void ocultarPS() {
        menu.getBtnPHistCli().setVisible(false);
        menu.getBtnPPriEn().setVisible(false);
        menu.getBtnPPlanTera().setVisible(false);
        menu.getBtnPProcT().setVisible(false);
    }

    public void Trabajo() {
        if (accTS == 1) {
            mostrarTr();
            accTS = 2;
        } else if (accTS == 2) {
            ocultarTr();
            accTS = 1;
        }
    }

    public void mostrarTr() {
        menu.getBtnTPlanV().setVisible(true);
        menu.getBtnTAuto().setVisible(true);
        menu.getBtnTRecur().setVisible(true);
        menu.getBtnEvalPlVida().setVisible(true);
    }

    public void ocultarTr() {
        menu.getBtnTPlanV().setVisible(false);
        menu.getBtnTAuto().setVisible(false);
        menu.getBtnTRecur().setVisible(false);
        menu.getBtnEvalPlVida().setVisible(false);
    }

    public void Legal() {
        if (accLG == 2) {
            ocultarLeg();
            accLG = 1;
        } else if (accLG == 1) {
            mostrarLeg();
            accLG = 2;
        }
    }

    public void mostrarLeg() {
        menu.getBtnMLegal1().setVisible(true);
        menu.getBtnMLegal2().setVisible(true);
    }

    public void ocultarLeg() {
        menu.getBtnMLegal1().setVisible(false);
        menu.getBtnMLegal2().setVisible(false);
    }

    public void infanto() {
        if (accIN == 2) {
            ocultarInf();
            accIN = 1;
        } else if (accIN == 1) {
            mostrarInf();
            accIN = 2;
        }
    }

    public void mostrarInf() {
        menu.getBtnIplanD().setVisible(true);
    }

    public void ocultarInf() {
        menu.getBtnIplanD().setVisible(false);
    }

    public void Reportes() {
        if (accRep == 2) {
            ocultarRep();
            accRep = 1;
        } else if (accRep == 1) {
            mostrarRep();
            accRep = 2;
        }
    }

    public void mostrarRep() {
        menu.getLabmenuF().setVisible(true);
        menu.getBtnMformR1().setVisible(true);
        menu.getBtnMreport2().setVisible(true);
        menu.getBtnMreportGn().setVisible(true);
        menu.getBtnResultadosFormu().setVisible(true);
    }

    public void ocultarRep() {
        menu.getLabmenuF().setVisible(false);
        menu.getBtnMformR1().setVisible(false);
        menu.getBtnMreport2().setVisible(false);
        menu.getBtnMreportGn().setVisible(false);
        menu.getBtnResultadosFormu().setVisible(false);
    }

    public void obtenerPerfil() {
        abogadaDB adb = new abogadaDB();
        Trabajo_SocialDB tsDB = new Trabajo_SocialDB();
        psicologoDB psdb = new psicologoDB();
        EducadoraDB eDB = new EducadoraDB();
        CoordinadoraDB cDB = new CoordinadoraDB();
        DirectoraDB dDB = new DirectoraDB();
        int cPerfil;
        cPerfil = adb.verifiUserA(personal_cod);
        if (cPerfil != 0) {
            // abogada
            menu.getBtnpsico().setEnabled(false);
            menu.getBtninf().setEnabled(false);
            menu.getBtnsoc().setEnabled(false);
            menu.getBtnResultadosFormu().setEnabled(false);
        } else {
            cPerfil = tsDB.verifiUserT(personal_cod);
            if (cPerfil != 0) {
                // tranajo social 
                menu.getBtnpsico().setEnabled(false);
                menu.getBtninf().setEnabled(false);
                menu.getBtnleg().setEnabled(false);
                menu.getBtnResultadosFormu().setEnabled(false);

            } else {
                cPerfil = psdb.verifiUserP(personal_cod);
                if (cPerfil != 0) {
                    // psicologa
                    menu.getBtnsoc().setEnabled(false);
                    menu.getBtninf().setEnabled(false);
                    menu.getBtnleg().setEnabled(false);
                } else {
                    cPerfil = eDB.verifiUserE(personal_cod);
                    if (cPerfil != 0) {
                        menu.getBtnsoc().setEnabled(false);
                        menu.getBtnpsico().setEnabled(false);
                        menu.getBtnleg().setEnabled(false);
                        menu.getBtnResultadosFormu().setEnabled(false);
                    } else {
                        System.out.println("Direccion o Coordinacion");
                    }
                }
            }
        }
    }

    private void abriPanelVistas(JPanel panel) {
        try {
            panel.setLocation(2, 2);
            JScrollPane scrollpane;
            scrollpane = new JScrollPane();
            scrollpane.setBounds(0, 0, menu.getPanelVistas().getWidth(), menu.getPanelVistas().getHeight());
            scrollpane.setViewportView(panel);
            menu.getPanelVistas().removeAll();
            menu.getPanelVistas().add(scrollpane);
            menu.getPanelVistas().revalidate();
            muestraPanel = panel;
        } catch (Exception e) {
            System.out.println("error al cargar vista " + e.getMessage());
        }
    }

    Thread ctrLegal = new Thread() {
        @Override
        public void run() {
            try {
                menu.getPgbMenu().setVisible(true);
                menu.getPgbMenu().setValue(1);
                Ficha_Legal modeloLegal = new Ficha_Legal();
                fichaLegalDB flDB = new fichaLegalDB();
                menu.getPgbMenu().setValue(3);
                controlFichaLegal cFL = new controlFichaLegal(vLegal, modeloLegal, flDB);
                menu.getPgbMenu().setValue(5);
                cFL.iniCFLegal();
                menu.getPgbMenu().setValue(7);
                menu.getBtnMLegal1().setCursor(new Cursor(DEFAULT_CURSOR));
                menu.getPgbMenu().setValue(9);
                menu.getPgbMenu().setVisible(false);
            } catch (Exception ex) {
                System.out.println("error en el hilo de control Ficha legal: " + ex.getMessage());
            }
        }
    };
    Thread ctrHistCli = new Thread() {
        @Override
        public void run() {
            try {
                menu.getPgbMenu().setVisible(true);
                menu.getPgbMenu().setValue(1);
                HistorialClinico modeloHC = new HistorialClinico();
                HistorialClinicoDB hcDB = new HistorialClinicoDB();
                menu.getPgbMenu().setValue(3);
                ControlHistorialClinico contHC = new ControlHistorialClinico(vistaHC, modeloHC, hcDB);
                menu.getPgbMenu().setValue(5);
                contHC.inicialCHistClini();
                menu.getPgbMenu().setValue(7);
                menu.getBtnPHistCli().setCursor(new Cursor(DEFAULT_CURSOR));
                menu.getPgbMenu().setValue(9);
                menu.getPgbMenu().setVisible(false);
            } catch (Exception ex) {
                System.out.println("error en el hilo de control Historial Clinico: " + ex.getMessage());
            }
        }
    };
    Thread ctrRegisAct = new Thread() {
        @Override
        public void run() {
            try {
                menu.getPgbMenu().setVisible(true);
                menu.getPgbMenu().setValue(1);
                Cierre mC = new Cierre();
                CierreDB cDB = new CierreDB();
                Register_Actuaciones mRA = new Register_Actuaciones();
                menu.getPgbMenu().setValue(3);
                RegisActuacionesDB raDB = new RegisActuacionesDB();
                ControlFichaRegisActu cFRA = new ControlFichaRegisActu(vFRA, mC, cDB, mRA, raDB);
                menu.getPgbMenu().setValue(5);
                cFRA.iniciarCFichaRegusActu();
                menu.getPgbMenu().setValue(7);
                menu.getBtnMLegal2().setCursor(new Cursor(DEFAULT_CURSOR));
                menu.getPgbMenu().setValue(9);
                menu.getPgbMenu().setVisible(false);
            } catch (Exception ex) {
                System.out.println("error en el hilo de control Ficha Registro Actuaciones: " + ex.getMessage());
            }
        }
    };
    Thread ctrPlanAT = new Thread() {
        @Override
        public void run() {
            try {
                menu.getPgbMenu().setVisible(true);
                menu.getPgbMenu().setValue(1);
                Plan_Autonomia mPAuton = new Plan_Autonomia();
                PlanAutonomiaDB planADB = new PlanAutonomiaDB();
                menu.getPgbMenu().setValue(3);
                controlPlanAutonomia controlPA = new controlPlanAutonomia(vPAuton, mPAuton, planADB);
                menu.getPgbMenu().setValue(5);
                controlPA.iniciarCAutonomia();
                menu.getPgbMenu().setValue(7);
                menu.getBtnTAuto().setCursor(new Cursor(DEFAULT_CURSOR));
                menu.getPgbMenu().setValue(9);
                menu.getPgbMenu().setVisible(false);
            } catch (Exception ex) {
                System.out.println("error en el hilo de control Plan de Autonomia: " + ex.getMessage());
            }
        }
    };
    Thread ctrPlanEmer = new Thread() {
        @Override
        public void run() {
            try {
                menu.getPgbMenu().setVisible(true);
                menu.getPgbMenu().setValue(1);
                PlanEmergenteDB modeloDB = new PlanEmergenteDB();
                PlanEmergente2DB modeloDB2 = new PlanEmergente2DB();
                menu.getPgbMenu().setValue(3);
                ControladorPlanEmergente ctrl = new ControladorPlanEmergente(vista, modeloDB, modeloDB2);
                menu.getPgbMenu().setValue(5);
                ctrl.iniciarControlador();
                menu.getPgbMenu().setValue(7);
                menu.getBtnMformR2().setCursor(new Cursor(DEFAULT_CURSOR));
                menu.getPgbMenu().setValue(9);
                menu.getPgbMenu().setVisible(false);
            } catch (Exception ex) {
                System.out.println("error en el hilo de control Plan Emergente: " + ex.getMessage());
            }
        }
    };
    Thread ctrHPE = new Thread() {
        @Override
        public void run() {
            try {
                menu.getPgbMenu().setVisible(true);
                menu.getPgbMenu().setValue(1);
                primer_EncuentroDB peDB = new primer_EncuentroDB();
                menu.getPgbMenu().setValue(3);
                ControladorPrimerEncuentro contPE = new ControladorPrimerEncuentro(vFPE, peDB);
                menu.getPgbMenu().setValue(5);
                contPE.iniciarControl();
                menu.getPgbMenu().setValue(7);
                menu.getBtnPPriEn().setCursor(new Cursor(DEFAULT_CURSOR));
                menu.getPgbMenu().setValue(9);
                menu.getPgbMenu().setVisible(false);
            } catch (Exception ex) {
                System.out.println("error en el hilo de control Primer Encuentro: " + ex.getMessage());
            }
        }
    };
    Thread ctrHCitas = new Thread() {
        @Override
        public void run() {
            try {
                menu.getPgbMenu().setVisible(true);
                menu.getPgbMenu().setValue(1);
                menu.getPgbMenu().setValue(3);
                ControladorCitas contCitas = new ControladorCitas(vistaCita);
                menu.getPgbMenu().setValue(5);
                contCitas.iniciarControl();
                menu.getPgbMenu().setValue(7);
                menu.getBtnCita().setCursor(new Cursor(DEFAULT_CURSOR));
                menu.getPgbMenu().setValue(9);
                menu.getPgbMenu().setVisible(false);
            } catch (Exception ex) {
                System.out.println("error en el hilo de control Citas: " + ex.getMessage());
            }
        }
    };
    Thread ctrHEPVida = new Thread() {
        @Override
        public void run() {
            try {
                menu.getPgbMenu().setVisible(true);
                menu.getPgbMenu().setValue(1);
                DefinicionObjetivosGeneralDB objGenModelDB = new DefinicionObjetivosGeneralDB();
                DefinicionObjetivosEspecificosDB objEspecModelDB = new DefinicionObjetivosEspecificosDB();
                menu.getPgbMenu().setValue(3);
                DefinicionObjetivosGeneral objGenMOdel = new DefinicionObjetivosGeneral();
                DefinicionObjetivosEspecifico objEspecMdel = new DefinicionObjetivosEspecifico();
                VistaDefinicionObjetivosEspecifico vistaObjEsp = new VistaDefinicionObjetivosEspecifico();
                menu.getPgbMenu().setValue(5);
                vistaAgregarObjetivoGenera vistaObjGene = new vistaAgregarObjetivoGenera();
                VistaFiltroVistaVictima vistanna = new VistaFiltroVistaVictima();
                menu.getPgbMenu().setValue(7);
                ControlEvaluacionPlanVida contEPV = new ControlEvaluacionPlanVida(vistaEvaPlanVid, objGenModelDB, objEspecModelDB, objGenMOdel, objEspecMdel, vistaObjEsp, vistaObjGene, vistanna);
                menu.getPgbMenu().setValue(8);
                contEPV.iniciCtrlEvaluacionPlanVida();
                menu.getBtnEvalPlVida().setCursor(new Cursor(DEFAULT_CURSOR));
                menu.getPgbMenu().setValue(9);
                menu.getPgbMenu().setVisible(false);
            } catch (Exception ex) {
                System.out.println("error en el hilo de control Plan de Autonomia: " + ex.getMessage());
            }
        }
    };
    Thread ctrHPAtT = new Thread() {
        @Override
        public void run() {
            try {
                menu.getPgbMenu().setVisible(true);
                menu.getPgbMenu().setValue(1);
                PlanAtencionTerapeuticoDB mFAtT = new PlanAtencionTerapeuticoDB();
                menu.getPgbMenu().setValue(5);
                ControladorPlanAtencionTerapeutica contFAtT = new ControladorPlanAtencionTerapeutica(vFAtT, mFAtT);
                menu.getPgbMenu().setValue(7);
                contFAtT.iniciarControlador();
                menu.getBtnPPlanTera().setCursor(new Cursor(DEFAULT_CURSOR));
                menu.getPgbMenu().setValue(9);
                menu.getPgbMenu().setVisible(false);
            } catch (Exception ex) {
                System.out.println("error en el hilo de control Plan Atencion Terapeutica: " + ex.getMessage());
            }
        }
    };
    Thread ctrHEPTr = new Thread() {
        @Override
        public void run() {
            try {
                menu.getPgbMenu().setVisible(true);
                menu.getPgbMenu().setValue(1);
                IngresoAvanceProceTerapeuticoDB mEvPrT = new IngresoAvanceProceTerapeuticoDB();
                IngresoAvancesProcesoTerapeutico vistaAPrT = new IngresoAvancesProcesoTerapeutico();
                VistaReportesAvancesTerapeuticos vistareportes = new VistaReportesAvancesTerapeuticos();
                menu.getPgbMenu().setValue(5);
                CtrlFichaEvaluacionProcesoTerapeutico contEvPrT = new CtrlFichaEvaluacionProcesoTerapeutico(mEvPrT, vEvPrT, vistaAPrT, vistareportes);
                menu.getPgbMenu().setValue(7);
                contEvPrT.iniciarControlador();
                menu.getBtnPProcT().setCursor(new Cursor(DEFAULT_CURSOR));
                menu.getPgbMenu().setValue(9);
                menu.getPgbMenu().setVisible(false);
            } catch (Exception ex) {
                System.out.println("error en el hilo de control Evalucion Proceso Terapeuticos: " + ex.getMessage());
            }
        }
    };
    Thread ctrHFIngreso = new Thread() {
        @Override
        public void run() {
            try {
                menu.getPgbMenu().setVisible(true);
                menu.getPgbMenu().setValue(1);
                FormaAgregarArticulosVictima vistaAgreArt = new FormaAgregarArticulosVictima();
                ArticulosEntregados artiEntModel = new ArticulosEntregados();
                ArticulosEntregadosDB artEntModelDB = new ArticulosEntregadosDB();
                menu.getPgbMenu().setValue(3);
                ArticulosEntregadosPersonal artEntPerModel = new ArticulosEntregadosPersonal();
                ArticulosEntregadosPersonalDB artEntPerModelDB = new ArticulosEntregadosPersonalDB();
                FormaAgregarArticulosPersonal vistaAgreArtPers = new FormaAgregarArticulosPersonal();
                IngresoDB modelIngreDB = new IngresoDB();
                VistaFamiliares vistFam = new VistaFamiliares();
                menu.getPgbMenu().setValue(5);
                ControladorFichaIngreso contIngr = new ControladorFichaIngreso(vistaAgreArt, artiEntModel, artEntModelDB, artEntPerModel, artEntPerModelDB, vistaFichIngreso, vistaAgreArtPers, modelIngreDB, vFomAgHj, vistFam, egresoModelDb);
                menu.getPgbMenu().setValue(7);
                contIngr.inciarCtrlFichIngreso();
                menu.getBtnMingreso().setCursor(new Cursor(DEFAULT_CURSOR));
                menu.getPgbMenu().setValue(9);
                menu.getPgbMenu().setVisible(false);
            } catch (Exception ex) {
                System.out.println("error en el hilo de control Ficha Ingreso: " + ex.getMessage());
            }
        }
    };
    Thread ctrHRLlamada = new Thread() {
        @Override
        public void run() {
            try {
                menu.getPgbMenu().setVisible(true);
                menu.getPgbMenu().setValue(1);
                menu.getPgbMenu().setValue(3);
                Controlador_registro_llamadas contLlamada = new Controlador_registro_llamadas(vLlamada);
                menu.getPgbMenu().setValue(6);
                contLlamada.iniciarControlRLL();
                menu.getBtnllamada().setCursor(new Cursor(DEFAULT_CURSOR));
                menu.getPgbMenu().setValue(9);
                menu.getPgbMenu().setVisible(false);
            } catch (Exception ex) {
                System.out.println("error en el hilo de control Registro Llamada: " + ex.getMessage());
            }
        }
    };
    Thread ctrHEgreso = new Thread() {
        @Override
        public void run() {
            try {
                menu.getPgbMenu().setVisible(true);
                menu.getPgbMenu().setValue(2);
                Direccion dir = new Direccion();
                Egreso egresoModel = new Egreso();
                menu.getPgbMenu().setValue(3);
                DireccionDB dirDB = new DireccionDB();
                ControladorFichaEgreso contFEgr = new ControladorFichaEgreso(dir, egresoModel, vistaEgres, egresoModelDb, dirDB);
                menu.getPgbMenu().setValue(5);
                contFEgr.iniciCtrlEgreso();
                menu.getBtnMegreso().setCursor(new Cursor(DEFAULT_CURSOR));
                menu.getPgbMenu().setValue(9);
                menu.getPgbMenu().setVisible(false);
            } catch (Exception ex) {
                System.out.println("error en el hilo de control Egreso: " + ex.getMessage());
            }
        }
    };
    Thread ctrHPRecursos = new Thread() {
        @Override
        public void run() {
            try {
                menu.getPgbMenu().setVisible(true);
                menu.getPgbMenu().setValue(2);
                Monto_DisponeDB montDispModlDB = new Monto_DisponeDB();
                Monto_NecesitaDB montNecesModelDB = new Monto_NecesitaDB();
                Cuentas_DiariasDB cuentDiariasModelDB = new Cuentas_DiariasDB();
                menu.getPgbMenu().setValue(4);
                Monto_Dispone montDMdel = new Monto_Dispone();
                Monto_Necesita montNMdel = new Monto_Necesita();
                Cuentas_Diarias cuentDMdel = new Cuentas_Diarias();
                vistaCuentasDiarias vistCuentD = new vistaCuentasDiarias();
                menu.getPgbMenu().setValue(5);
                vistaMontoDisp vistMdis = new vistaMontoDisp();
                vistaMontoNeces vistaMNes = new vistaMontoNeces();
                ControladorPlandeRecursos contR = new ControladorPlandeRecursos(vpr, montDispModlDB, montNecesModelDB, cuentDiariasModelDB, montDMdel, montNMdel, cuentDMdel, vistCuentD, vistMdis, vistaMNes);
                menu.getPgbMenu().setValue(7);
                contR.iniciarControlRecursos();
                menu.getBtnTRecur().setCursor(new Cursor(DEFAULT_CURSOR));
                menu.getPgbMenu().setValue(9);
                menu.getPgbMenu().setVisible(false);
            } catch (Exception ex) {
                System.out.println("error en el hilo de control Plan de Recursos: " + ex.getMessage());
            }
        }
    };
    Thread ctrHRReferen = new Thread() {
        @Override
        public void run() {
            try {
                menu.getPgbMenu().setVisible(true);
                menu.getPgbMenu().setValue(2);
                menu.getPgbMenu().setValue(5);
                ControladorRegistroReferencia contRR = new ControladorRegistroReferencia(vFRR);
                menu.getPgbMenu().setValue(7);
                menu.getBtnRegistro().setCursor(new Cursor(DEFAULT_CURSOR));
                menu.getPgbMenu().setValue(9);
                menu.getPgbMenu().setVisible(false);
            } catch (Exception ex) {
                System.out.println("error en el hilo de control Regustro Referencias: " + ex.getMessage());
            }
        }
    };
    Thread ctrHPVida = new Thread() {
        @Override
        public void run() {
            try {
                menu.getPgbMenu().setVisible(true);
                menu.getPgbMenu().setValue(2);
                PvObjetivosGeneDB objGenModlDB = new PvObjetivosGeneDB();
                PvObjetivosEspecDB objEspeModelDB = new PvObjetivosEspecDB();
                Pv_objeticos_especificos objEspeMdel = new Pv_objeticos_especificos();
                menu.getPgbMenu().setValue(3);
                Pv_objetivos_gene objGeMOdel = new Pv_objetivos_gene();
                VistaDefinicionObjetivosEspecifico vistObjEsp = new VistaDefinicionObjetivosEspecifico();
                vistaAgregarObjetivoGenera vistObjGene = new vistaAgregarObjetivoGenera();
                menu.getPgbMenu().setValue(5);
                ControladorPlandeVida contPVida = new ControladorPlandeVida(vPVida, objGenModlDB, objEspeModelDB, objGeMOdel, objEspeMdel, vistObjEsp, vistObjGene);
                menu.getPgbMenu().setValue(7);
                contPVida.iniciarControl();
                menu.getBtnTPlanV().setCursor(new Cursor(DEFAULT_CURSOR));
                menu.getPgbMenu().setValue(9);
                menu.getPgbMenu().setVisible(false);
            } catch (Exception ex) {
                System.out.println("error en el hilo de control Plan de Vida: " + ex.getMessage());
            }
        }
    };
    Thread ctrHR1 = new Thread() {
        @Override
        public void run() {
            try {
                menu.getPgbMenu().setVisible(true);
                menu.getPgbMenu().setValue(2);
                FichaR1DB fRlDB = new FichaR1DB();
                x_respuestas respuestas = new x_respuestas();
                ControladorFichaR1 contR1 = new ControladorFichaR1(vistaR1, respuestas, fRlDB);
                menu.getPgbMenu().setValue(5);
                contR1.iniciarComponentes();
                menu.getBtnMformR1().setCursor(new Cursor(DEFAULT_CURSOR));
                menu.getPgbMenu().setValue(9);
                menu.getPgbMenu().setVisible(false);
            } catch (Exception ex) {
                System.out.println("error en el hilo de control Formulario R1: " + ex.getMessage());
            }
        }
    };
    Thread ctrHReporte = new Thread() {
        @Override
        public void run() {
            try {
                menu.getPgbMenu().setVisible(true);
                menu.getPgbMenu().setValue(1);
                menu.getPgbMenu().setValue(5);
                ControladorViewReportes ctrreport = new ControladorViewReportes(vreportes);
                menu.getPgbMenu().setValue(7);
                menu.getBtnReportes().setCursor(new Cursor(DEFAULT_CURSOR));
                menu.getPgbMenu().setValue(9);
                menu.getPgbMenu().setVisible(false);
            } catch (Exception ex) {
                System.out.println("error en el hilo de control Reportes: " + ex.getMessage());
            }
        }
    };
    Thread ctrHBitacora = new Thread() {
        @Override
        public void run() {
            try {
                menu.getPgbMenu().setVisible(true);
                menu.getPgbMenu().setValue(1);
                menu.getPgbMenu().setValue(5);
                ControladorBitacora ctrBit = new ControladorBitacora(vbitacora);
                menu.getPgbMenu().setValue(7);
                menu.getBtnMBitacora().setCursor(new Cursor(DEFAULT_CURSOR));
                menu.getPgbMenu().setValue(9);
                menu.getPgbMenu().setVisible(false);
            } catch (Exception ex) {
                System.out.println("error en el hilo de control Bitacora: " + ex.getMessage());
            }
        }
    };
    Thread ctrHFHijosV = new Thread() {
        @Override
        public void run() {
            try {
                menu.getPgbMenu().setVisible(true);
                menu.getPgbMenu().setValue(1);
                menu.getPgbMenu().setValue(5);
                FiltroHijosVictima ctrFHV = new FiltroHijosVictima(vfv);
                menu.getPgbMenu().setValue(7);
                menu.getBtnIplanD().setCursor(new Cursor(DEFAULT_CURSOR));
                menu.getPgbMenu().setValue(9);
                menu.getPgbMenu().setVisible(false);
            } catch (Exception ex) {
                System.out.println("error en el hilo de control Fitro Hijos: " + ex.getMessage());
            }
        }
    };
    Thread ctrHFR3 = new Thread() {
        @Override
        public void run() {
            try {
                menu.getPgbMenu().setVisible(true);
                menu.getPgbMenu().setValue(1);
                menu.getPgbMenu().setValue(5);
                controlFormularioR3 ctrFR3 = new controlFormularioR3(vFR3);
                menu.getPgbMenu().setValue(7);
                ctrFR3.iniciarCtr();
                menu.getBtnMreportGn().setCursor(new Cursor(DEFAULT_CURSOR));
                menu.getPgbMenu().setValue(9);
                menu.getPgbMenu().setVisible(false);
            } catch (Exception ex) {
                System.out.println("error en el hilo de control Fitro Hijos: " + ex.getMessage());
            }
        }
    };
    Thread ctrHFR2 = new Thread() {
        @Override
        public void run() {
            try {
                menu.getPgbMenu().setVisible(true);
                menu.getPgbMenu().setValue(1);
                menu.getPgbMenu().setValue(5);
                ControlFormularioR2 ctrFR2 = new ControlFormularioR2(vFR2);
                menu.getPgbMenu().setValue(7);
                ctrFR2.iniciarControl();
                menu.getBtnMreport2().setCursor(new Cursor(DEFAULT_CURSOR));
                menu.getPgbMenu().setValue(9);
                menu.getPgbMenu().setVisible(false);
            } catch (Exception ex) {
                System.out.println("error en el hilo de control Fitro Hijos: " + ex.getMessage());
            }
        }
    };
    Thread ctrHAgHi = new Thread() {
        @Override
        public void run() {
            try {
                contAgHj = new ControladorAgregarHijos(vFomAgHj);
            } catch (Exception ex) {
                System.out.println("error en el hilo de control Agregar Hijos: " + ex.getMessage());
            }
        }
    };
    Thread ctrHAnam = new Thread() {
        @Override
        public void run() {
            try {
                menu.getPgbMenu().setVisible(true);
                menu.getPgbMenu().setValue(1);
                menu.getPgbMenu().setValue(5);
                ctrAnamn.inciarControl();
                menu.getPgbMenu().setValue(7);
                ctrAnamn.accionInicialFicha();
                menu.getPgbMenu().setValue(9);
                menu.getPgbMenu().setVisible(false);
            } catch (SQLException ex) {
                System.out.println("error en el hilo de control Anamnesis: " + ex.getMessage());
            }
        }
    };
    Thread ctrHResult = new Thread() {
        @Override
        public void run() {
            try {
                menu.getPgbMenu().setVisible(true);
                menu.getPgbMenu().setValue(1);
                menu.getPgbMenu().setValue(5);
                ControladorFichaResultados ctrResult = new ControladorFichaResultados(vistRes);
                menu.getPgbMenu().setValue(7);
                ctrResult.inicializador();
                menu.getPgbMenu().setValue(9);
                menu.getPgbMenu().setVisible(false);
                menu.getBtnResultadosFormu().setCursor(new Cursor(DEFAULT_CURSOR));
            } catch (Exception ex) {
                System.out.println("error en el hilo de control Fitro Hijos: " + ex.getMessage());
            }
        }
    };
}
