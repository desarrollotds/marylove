package marylove.controlador;

import AppPackage.AnimationClass;
import java.awt.Cursor;
import static java.awt.Cursor.*;
import java.text.ParseException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
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
    Ficha_Legal modeloLegal = new Ficha_Legal();
    fichaLegalDB flDB = new fichaLegalDB();
    controlFichaLegal cFL = new controlFichaLegal(vLegal, modeloLegal, flDB);

    // ficha Registro Actuaciones
    FichaRegistroActuaciones vFRA = new FichaRegistroActuaciones();
    Cierre mC = new Cierre();
    CierreDB cDB = new CierreDB();
    Register_Actuaciones mRA = new Register_Actuaciones();
    RegisActuacionesDB raDB = new RegisActuacionesDB();
    ControlFichaRegisActu cFRA = new ControlFichaRegisActu(vFRA, mC, cDB, mRA, raDB);

    // Plan emergente
    VistaPlanEmergente vista = new VistaPlanEmergente();
    PlanEmergenteDB modeloDB = new PlanEmergenteDB();
    PlanEmergente2DB modeloDB2 = new PlanEmergente2DB();
    ControladorPlanEmergente ctrl = new ControladorPlanEmergente(vista, modeloDB, modeloDB2);

    // primer encuentro
    FichaPrimerEncuentro vFPE = new FichaPrimerEncuentro();
    primer_EncuentroDB peDB = new primer_EncuentroDB();
    ControladorPrimerEncuentro contPE = new ControladorPrimerEncuentro(vFPE, peDB);

    // Historia Clinica
    FichaHistoriaClinica vistaHC = new FichaHistoriaClinica();
    HistorialClinico modeloHC = new HistorialClinico();
    HistorialClinicoDB hcDB = new HistorialClinicoDB();
    ControlHistorialClinico contHC = new ControlHistorialClinico(vistaHC, modeloHC, hcDB);

    //Ficha Registro Referencia
    Ficharegistroyreferencia vFRR = new Ficharegistroyreferencia();
    ControladorRegistroReferencia contRR;

    // citas
    VistaCita vistaCita = new VistaCita();
    ControladorCitas contCitas = new ControladorCitas(vistaCita);

    // evalucion plan de vida
    FichaEvaluacionPlandeVida vistaEvaPlanVid = new FichaEvaluacionPlandeVida();
    DefinicionObjetivosGeneralDB objGenModelDB = new DefinicionObjetivosGeneralDB();
    DefinicionObjetivosEspecificosDB objEspecModelDB = new DefinicionObjetivosEspecificosDB();
    DefinicionObjetivosGeneral objGenMOdel = new DefinicionObjetivosGeneral();
    DefinicionObjetivosEspecifico objEspecMdel = new DefinicionObjetivosEspecifico();
    VistaDefinicionObjetivosEspecifico vistaObjEsp = new VistaDefinicionObjetivosEspecifico();
    vistaAgregarObjetivoGenera vistaObjGene = new vistaAgregarObjetivoGenera();
    VistaFiltroVistaVictima vistanna = new VistaFiltroVistaVictima();
    ControlEvaluacionPlanVida contEPV = new ControlEvaluacionPlanVida(vistaEvaPlanVid, objGenModelDB, objEspecModelDB, objGenMOdel, objEspecMdel, vistaObjEsp, vistaObjGene, vistanna);

    // Avances proceso terapeutico
//    IngresoAvanceProceTerapeuticoDB modeloAPrT = new IngresoAvanceProceTerapeuticoDB();
    IngresoAvancesProcesoTerapeutico vistaAPrT = new IngresoAvancesProcesoTerapeutico();
//    CtrlIngresoAvanceProceTerapeutico contAPrT = new CtrlIngresoAvanceProceTerapeutico(modeloAPrT, vistaAPrT);

    // Plan atencion terapeutica
    FichaPlanAtencionTerapeutica vFAtT = new FichaPlanAtencionTerapeutica();
    PlanAtencionTerapeuticoDB mFAtT = new PlanAtencionTerapeuticoDB();
    ControladorPlanAtencionTerapeutica contFAtT = new ControladorPlanAtencionTerapeutica(vFAtT, mFAtT);

    //Plan Evalucion Proceso Terapeutico
    IngresoAvanceProceTerapeuticoDB mEvPrT = new IngresoAvanceProceTerapeuticoDB();
    FichaEvolucionProcesoTerapeutico vEvPrT = new FichaEvolucionProcesoTerapeutico();
    CtrlFichaEvaluacionProcesoTerapeutico contEvPrT = new CtrlFichaEvaluacionProcesoTerapeutico(mEvPrT, vEvPrT,vistaAPrT);

    // agregar agresor
    FormaAgregarAgresores vistaAgAs = new FormaAgregarAgresores();
    ControladorAgregarAgresores contAgAs;

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

    // agregar institucion educativa
    FormaAgregarInstitucionEduc vAgIsEd = new FormaAgregarInstitucionEduc();
    ControladorAgregarInstitucionEduc contAgIsEd;

    // buscar persona
    VistaConsultaPersona vConsPer = new VistaConsultaPersona();
    ControladorBuscarPersona contBP;

    //Ficha Egreso
    Direccion dir = new Direccion();
    Egreso egresoModel = new Egreso();
    FichaEgreso vistaEgres = new FichaEgreso();
    EgresoDB egresoModelDb = new EgresoDB();
    DireccionDB dirDB = new DireccionDB();
    ControladorFichaEgreso contFEgr = new ControladorFichaEgreso(dir, egresoModel, vistaEgres, egresoModelDb, dirDB);

    // Ficha ingreso
    FormaAgregarArticulosVictima vistaAgreArt = new FormaAgregarArticulosVictima();
    ArticulosEntregados artiEntModel = new ArticulosEntregados();
    ArticulosEntregadosDB artEntModelDB = new ArticulosEntregadosDB();
    ArticulosEntregadosPersonal artEntPerModel = new ArticulosEntregadosPersonal();
    ArticulosEntregadosPersonalDB artEntPerModelDB = new ArticulosEntregadosPersonalDB();
    FichaIngreso vistaFichIngreso = new FichaIngreso();
    FormaAgregarArticulosPersonal vistaAgreArtPers = new FormaAgregarArticulosPersonal();
    IngresoDB modelIngreDB = new IngresoDB();
    ControladorFichaIngreso contIngr = new ControladorFichaIngreso(vistaAgreArt, artiEntModel, artEntModelDB, artEntPerModel, artEntPerModelDB, vistaFichIngreso, vistaAgreArtPers, modelIngreDB, vFomAgHj);

    // ficha R1
    formularioR1 vistaR1 = new formularioR1();
    FichaR1DB fRlDB = new FichaR1DB();
    x_respuestas respuestas = new x_respuestas();
    ControladorFichaR1 contR1 = new ControladorFichaR1(vistaR1, respuestas, fRlDB);

    // Plan de vida
    FichaPlandeVida vPVida = new FichaPlandeVida();
    PvObjetivosGeneDB objGenModlDB = new PvObjetivosGeneDB();
    PvObjetivosEspecDB objEspeModelDB = new PvObjetivosEspecDB();
    Pv_objeticos_especificos objEspeMdel = new Pv_objeticos_especificos();
    Pv_objetivos_gene objGeMOdel = new Pv_objetivos_gene();
    VistaDefinicionObjetivosEspecifico vistObjEsp = new VistaDefinicionObjetivosEspecifico();
    vistaAgregarObjetivoGenera vistObjGene = new vistaAgregarObjetivoGenera();
    ControladorPlandeVida contPVida = new ControladorPlandeVida(vPVida, objGenModlDB, objEspeModelDB, objGeMOdel, objEspeMdel, vistObjEsp, vistObjGene);

    // registro llamada
    VistaRegistroLlamada vLlamada = new VistaRegistroLlamada();
    Controlador_registro_llamadas contLlamada;

    //plan de recursos
    VistaPlanRecursos vpr = new VistaPlanRecursos();
    Monto_DisponeDB montDispModlDB = new Monto_DisponeDB();
    Monto_NecesitaDB montNecesModelDB = new Monto_NecesitaDB();
    Cuentas_DiariasDB cuentDiariasModelDB = new Cuentas_DiariasDB();
    Monto_Dispone montDMdel = new Monto_Dispone();
    Monto_Necesita montNMdel = new Monto_Necesita();
    Cuentas_Diarias cuentDMdel = new Cuentas_Diarias();
    vistaCuentasDiarias vistCuentD = new vistaCuentasDiarias();
    vistaMontoDisp vistMdis = new vistaMontoDisp();
    vistaMontoNeces vistaMNes = new vistaMontoNeces();
    ControladorPlandeRecursos contR = new ControladorPlandeRecursos(vpr, montDispModlDB, montNecesModelDB, cuentDiariasModelDB, montDMdel, montNMdel, cuentDMdel, vistCuentD, vistMdis, vistaMNes);

    // plan de autonomia
    VistaPlanAutonomía vPAuton = new VistaPlanAutonomía();
    Plan_Autonomia mPAuton = new Plan_Autonomia();
    PlanAutonomiaDB planADB = new PlanAutonomiaDB();
    controlPlanAutonomia controlPA = new controlPlanAutonomia(vPAuton, mPAuton, planADB);

//    // Anamnesis
//    FichaAnamnesis vistaAnamnesis = new FichaAnamnesis();
//    ControladorFichaAnamnesis ctrAnamn = new ControladorFichaAnamnesis(vistaAnamnesis);

    // reportes
    VistaReportes vreportes = new VistaReportes();
    ControlReporte ctrreport;
    
    // Bitacora
    VistaBitacora vbitacora = new VistaBitacora();
    ControladorBitacora ctrBit;
    
    //filtro hijos victima
    VistaFiltroVistaVictima vfv = new VistaFiltroVistaVictima();
    FiltroHijosVictima ctrFHV;

    int accLG = 1;
    int accIN = 1;
    int accPs = 1;
    int accTS = 1;
    int accRep = 1;

    public C_Menu(V_Menu menu) throws Exception {
        this.menu = menu;
    }

    public void iniciaControl() {

        obtenerPerfil();

        menu.getBtnsoc().addActionListener(e -> Trabajo());
        menu.getBtnleg().addActionListener(e -> Legal());
        menu.getBtnpsico().addActionListener(e -> psicologia());
        menu.getBtninf().addActionListener(e -> infanto());
        
        menu.getBtnMLegal1().addActionListener(e -> {menu.getBtnMLegal1().setCursor(new Cursor(WAIT_CURSOR)); control(1); abriPanelVistas(vLegal.getPnlPFL()); menu.getBtnMLegal1().setCursor(new Cursor(DEFAULT_CURSOR));});
        menu.getBtnMLegal2().addActionListener(e -> {menu.getBtnMLegal2().setCursor(new Cursor(WAIT_CURSOR)); control(2); abriPanelVistas(vFRA.getJpFondo());menu.getBtnMLegal2().setCursor(new Cursor(DEFAULT_CURSOR));});
        menu.getBtnPPriEn().addActionListener(e -> {menu.getBtnPPriEn().setCursor(new Cursor(WAIT_CURSOR)); control(4); abriPanelVistas(vFPE.getPnlPrimerEncuentro()); menu.getBtnPPriEn().setCursor(new Cursor(DEFAULT_CURSOR));});
        menu.getBtnPHistCli().addActionListener(e -> {menu.getBtnPHistCli().setCursor(new Cursor(WAIT_CURSOR)); control(5); abriPanelVistas(vistaHC.getPnlFchHisCli()); menu.getBtnPHistCli().setCursor(new Cursor(DEFAULT_CURSOR));});
        menu.getBtnCita().addActionListener(e -> {menu.getBtnCita().setCursor(new Cursor(WAIT_CURSOR)); control(6); abriPanelVistas(vistaCita.getPanelCitas()); menu.getBtnCita().setCursor(new Cursor(DEFAULT_CURSOR));});
        menu.getBtnEvalPlVida().addActionListener(e -> {menu.getBtnEvalPlVida().setCursor(new Cursor(WAIT_CURSOR)); control(7); abriPanelVistas(vistaEvaPlanVid.getPnlEvaluPV()); menu.getBtnEvalPlVida().setCursor(new Cursor(DEFAULT_CURSOR));});
        menu.getBtnPPlanTera().addActionListener(e -> {menu.getBtnPPlanTera().setCursor(new Cursor(WAIT_CURSOR)); control(9); abriPanelVistas(vFAtT.getPnlPAtTer()); menu.getBtnPPlanTera().setCursor(new Cursor(DEFAULT_CURSOR));});
        menu.getBtnPProcT().addActionListener(e -> {menu.getBtnPProcT().setCursor(new Cursor(WAIT_CURSOR)); control(10); abriPanelVistas(vEvPrT.getPanelFichaEvaluacionProceTera()); menu.getBtnPProcT().setCursor(new Cursor(DEFAULT_CURSOR));});
        menu.getBtnTAuto().addActionListener(e -> {menu.getBtnTAuto().setCursor(new Cursor(WAIT_CURSOR)); control(11); abriPanelVistas(vPAuton.getPnlPlanAuton()); menu.getBtnTAuto().setCursor(new Cursor(DEFAULT_CURSOR));});
        menu.getBtnMingreso().addActionListener(e -> {menu.getBtnMingreso().setCursor(new Cursor(WAIT_CURSOR)); control(12); abriPanelVistas(vistaFichIngreso.getPnlFichaIngre()); menu.getBtnMingreso().setCursor(new Cursor(DEFAULT_CURSOR));});
        menu.getBtnIplanD().addActionListener(e -> {menu.getBtnIplanD().setCursor(new Cursor(WAIT_CURSOR)); control(22); abriPanelVistas(vfv.getPanelFondo()); menu.getBtnIplanD().setCursor(new Cursor(DEFAULT_CURSOR));});
        menu.getBtnllamada().addActionListener(e -> {menu.getBtnllamada().setCursor(new Cursor(WAIT_CURSOR)); control(14); abriPanelVistas(vLlamada.getPnlLlamadas()); menu.getBtnllamada().setCursor(new Cursor(DEFAULT_CURSOR));});
        menu.getBtnMegreso().addActionListener(e -> {menu.getBtnMegreso().setCursor(new Cursor(WAIT_CURSOR)); control(15); abriPanelVistas(vistaEgres.getPanelEgreso()); menu.getBtnMegreso().setCursor(new Cursor(DEFAULT_CURSOR));});
        menu.getBtnTRecur().addActionListener(e -> {menu.getBtnTRecur().setCursor(new Cursor(WAIT_CURSOR)); control(16); abriPanelVistas(vpr.getPlRecursos()); menu.getBtnTRecur().setCursor(new Cursor(DEFAULT_CURSOR));});
        menu.getBtnTPlanV().addActionListener(e -> {menu.getBtnTPlanV().setCursor(new Cursor(WAIT_CURSOR)); control(17); abriPanelVistas(vPVida.getPlPlandeVida()); menu.getBtnTPlanV().setCursor(new Cursor(DEFAULT_CURSOR));});
        menu.getBtnMformR1().addActionListener(e -> {menu.getBtnMformR1().setCursor(new Cursor(WAIT_CURSOR)); control(18); abriPanelVistas(vistaR1.getPnlfr1()); menu.getBtnMformR1().setCursor(new Cursor(DEFAULT_CURSOR));});
        menu.getBtnRegistro().addActionListener(e -> {menu.getBtnRegistro().setCursor(new Cursor(WAIT_CURSOR)); control(19); abriPanelVistas(vFRR.getPlRegistroReferencia()); menu.getBtnRegistro().setCursor(new Cursor(DEFAULT_CURSOR));});
        menu.getBtnReportes().addActionListener(e -> {menu.getBtnReportes().setCursor(new Cursor(WAIT_CURSOR)); control(20); abrirReportes(1); menu.getBtnReportes().setCursor(new Cursor(DEFAULT_CURSOR));});
        menu.getBtnMBitacora().addActionListener(e -> {menu.getBtnMBitacora().setCursor(new Cursor(WAIT_CURSOR)); control(21); abriPanelVistas(vbitacora.getPnlPrincipal()); menu.getBtnMBitacora().setCursor(new Cursor(DEFAULT_CURSOR));});

        
        menu.getBtnMreprot1().addActionListener(e -> abrirReportes(1));
        menu.getBtnMreport2().addActionListener(e -> abrirReportes(2));
        menu.getBtnMreportGn().addActionListener(e -> abrirReportes(3));

        menu.getLabuser().setText(usuario);
        menu.getLabperlCod().setText("" + personal_cod);
        
        //icono
        menu.setIconImage(new ImageIcon(getClass().getResource("/iconos/icono1.png")).getImage());
       menu.setTitle("Ventana Principal *Menu*");
        if (personal_cod != 0) {
            control2();
        }
    }

    public void control(int ctn) {
        try {
            switch (ctn) {
                case 1:
                    cFL.iniCFLegal();
                    break;
                case 2:
                    cFRA.iniciarCFichaRegusActu();
                    break;
                case 3:
                    ctrl.iniciarControlador();
                    break;
                case 4:
                    contPE.iniciarControl();
                    break;
                case 5:
                    contHC.inicialCHistClini();
                    break;
                case 6:
                    contCitas.iniciarControl();
                    break;
                case 7:
                    contEPV.iniciCtrlEvaluacionPlanVida();
                    break;
                case 8:
//                    contAPrT.iniciarControl();
                    break;
                case 9:
                    contFAtT.iniciarControlador();
                    break;
                case 10:
                    contEvPrT.iniciarControlador();
                    break;
                case 11:
                    controlPA.iniciarCAutonomia();
                    break;
                case 12:
                    contIngr.inciarCtrlFichIngreso();
                    break;
                case 13:
//                    ctrAnamn.inciarControl();
                    break;
                case 14:
                    contLlamada = new Controlador_registro_llamadas(vLlamada);
                    contLlamada.iniciarControlRLL();
                    break;
                case 15:
                    contFEgr.iniciCtrlEgreso();
                    break;
                case 16:
                    contR.iniciarControlRecursos();
                    break;
                case 17:
                    contPVida.iniciarControl();
                    break;
                case 18:
                    contR1.iniciarComponentes();
                    break;
                case 19: {
                    try {
                        contRR = new ControladorRegistroReferencia(vFRR);
                    } catch (Exception ex) {
                        System.out.println("error en el controlador de registro referencia");;
                    }
                }
                break;
                case 20:
                    ctrreport = new ControlReporte(vreportes);
                    break;
                case 21:
                    ctrBit= new ControladorBitacora(vbitacora);
                    break;
                case 22:
                    ctrFHV = new FiltroHijosVictima(vfv);
                    break;
                default:
                    System.out.println("controladores no ingresados");
                    break;
            }
        } catch (ParseException | org.json.simple.parser.ParseException ex) {
            System.out.println("ERROR en el control " + ex.getMessage());
        }
    }

    public void control2() {
        try {
            contBP = new ControladorBuscarPersona(vConsPer);
            contAgIsEd = new ControladorAgregarInstitucionEduc(vAgIsEd);
            contAgHj = new ControladorAgregarHijos(vFomAgHj);
            contAgFaml = new ControladorAgregarFamiliar(vistaAgFamil, tablaFamiliares);
            contAgAs = new ControladorAgregarAgresores(vistaAgAs);
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
        AnimationClass men = new AnimationClass();

        if (accPs == 1) {
            men.jButtonXRight(0, 200, 10, 5, menu.getBtnPHistCli());
            men.jButtonXRight(0, 200, 10, 5, menu.getBtnPPriEn());
            men.jButtonXRight(0, 200, 10, 5, menu.getBtnPPlanTera());
            men.jButtonXRight(0, 200, 10, 5, menu.getBtnPProcT());
            accPs = 2;
        } else if (accPs == 2) {
            men.jButtonXLeft(200, 0, 10, 5, menu.getBtnPHistCli());
            men.jButtonXLeft(200, 0, 10, 5, menu.getBtnPPriEn());
            men.jButtonXLeft(200, 0, 10, 5, menu.getBtnPPlanTera());
            men.jButtonXLeft(200, 0, 10, 5, menu.getBtnPProcT());
            accPs = 1;
        }

    }

    public void Trabajo() {
        AnimationClass trab = new AnimationClass();
        if (accTS == 1) {
            trab.jButtonXRight(0, 200, 10, 5, menu.getBtnTPlanV());
            trab.jButtonXRight(0, 200, 10, 5, menu.getBtnTAuto());
            trab.jButtonXRight(0, 200, 10, 5, menu.getBtnTRecur());
            Animacion.Animacion.mover_derecha(0, 200, 10, 5, menu.getBtnEvalPlVida());
            accTS = 2;
        } else if (accTS == 2) {
            trab.jButtonXLeft(200, 0, 10, 5, menu.getBtnTPlanV());
            trab.jButtonXLeft(200, 0, 10, 5, menu.getBtnTAuto());
            trab.jButtonXLeft(200, 0, 10, 5, menu.getBtnTRecur());
            Animacion.Animacion.mover_izquierda(200, 0, 10, 5, menu.getBtnEvalPlVida());
            accTS = 1;
        }

    }

    public void Legal() {
        if (accLG == 2) {
            Animacion.Animacion.mover_izquierda(200, 0, 10, 5, menu.getBtnMLegal1());
            Animacion.Animacion.mover_izquierda(200, 0, 10, 5, menu.getBtnMLegal2());
            accLG = 1;
        } else if (accLG == 1) {
            Animacion.Animacion.mover_derecha(0, 200, 10, 5, menu.getBtnMLegal1());
            Animacion.Animacion.mover_derecha(0, 200, 10, 5, menu.getBtnMLegal2());
            accLG = 2;
        }
    }

    public void infanto() {
        AnimationClass inf = new AnimationClass();
        if (accIN == 2) {
            inf.jButtonXLeft(200, 0, 10, 5, menu.getBtnIplanD());
//            inf.jButtonXLeft(200, 0, 10, 5, menu.getBtnIplanE());
//            inf.jButtonXLeft(200, 0, 10, 5, menu.getBtnIproinf());
            accIN = 1;
        } else if (accIN == 1) {
            inf.jButtonXRight(0, 200, 10, 5, menu.getBtnIplanD());
//            inf.jButtonXRight(0, 200, 10, 5, menu.getBtnIplanE());
//            inf.jButtonXRight(0, 200, 10, 5, menu.getBtnIproinf());
            accIN = 2;
        }

    }

    public void Reportes() {
        if (accRep == 2) {
            Animacion.Animacion.mover_izquierda(200, 0, 10, 5, menu.getBtnMreprot1());
            Animacion.Animacion.mover_izquierda(200, 0, 10, 5, menu.getBtnMreport2());
            Animacion.Animacion.mover_izquierda(200, 0, 10, 5, menu.getBtnMreportGn());
            accRep = 1;
        } else if (accRep == 1) {
            Animacion.Animacion.mover_derecha(0, 200, 10, 5, menu.getBtnMreprot1());
            Animacion.Animacion.mover_derecha(0, 200, 10, 5, menu.getBtnMreport2());
            Animacion.Animacion.mover_derecha(0, 200, 10, 5, menu.getBtnMreportGn());
            accRep = 2;
        }

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
        } else {
            cPerfil = tsDB.verifiUserT(personal_cod);
            if (cPerfil != 0) {
                // tranajo social 
                menu.getBtnpsico().setEnabled(false);
                menu.getBtninf().setEnabled(false);
                menu.getBtnleg().setEnabled(false);
            } else {
                cPerfil = psdb.verifiUserP(personal_cod);
                if (cPerfil != 0) {
                    // psicologa
                    menu.getBtnsoc().setEnabled(false);
                    menu.getBtninf().setEnabled(false);
                    menu.getBtnleg().setEnabled(false);
                } else {
                    cPerfil = cDB.verifiUserC(personal_cod);
                    if (cPerfil != 0) {
                        menu.getBtnsoc().setEnabled(false);
                        menu.getBtnpsico().setEnabled(false);
                        menu.getBtnleg().setEnabled(false);
                    } else {
                        System.out.println("Direccion o Coordinacion");
                    }
                }
            }
        }
    }

    private void abriPanelVistas(JPanel panel) {
        try {
//            panel.setSize(715, 600);
            panel.setLocation(2, 2);
            JScrollPane scrollpane;
            scrollpane = new JScrollPane();
            scrollpane.setBounds(0, 0, menu.getPanelVistas().getWidth(), menu.getPanelVistas().getHeight());
            scrollpane.setViewportView(panel);
            menu.getPanelVistas().removeAll();
            menu.getPanelVistas().add(scrollpane);
            menu.getPanelVistas().revalidate();
            menu.getPanelVistas().repaint();
        } catch (Exception e) {
            System.out.println("error al cargar vista " + e.getMessage());
        }
    }
}
