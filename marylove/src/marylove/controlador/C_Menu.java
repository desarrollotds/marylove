package marylove.controlador;

import AppPackage.AnimationClass;
import java.sql.SQLException;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import marylove.DBmodelo.*;
import marylove.conexion.Conexion;
import static marylove.controlador.C_Login.personal_cod;
import static marylove.controlador.C_Login.usuario;
import marylove.models.*;
import marylove.vista.*;
import org.json.simple.parser.ParseException;

public class C_Menu {

    private V_Menu menu;

    // ficha legal 
    FichaLegal vLegal = new FichaLegal();
    Ficha_Legal modeloLegal = new Ficha_Legal();
    ;
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
    CitaDB modeloCita = new CitaDB();
    ControladorCitas contCitas = new ControladorCitas(vistaCita);

    // evalucion plan de vida
    FichaEvaluacionPlandeVida vistaEvaPlanVid = new FichaEvaluacionPlandeVida();
    DefinicionObjetivosGeneralDB objGenModelDB = new DefinicionObjetivosGeneralDB();
    DefinicionObjetivosEspecificosDB objEspecModelDB = new DefinicionObjetivosEspecificosDB();
    DefinicionObjetivosGeneral objGenMOdel = new DefinicionObjetivosGeneral();
    DefinicionObjetivosEspecifico objEspecMdel = new DefinicionObjetivosEspecifico();
    VistaDefinicionObjetivosEspecifico vistaObjEsp = new VistaDefinicionObjetivosEspecifico();
    vistaAgregarObjetivoGenera vistaObjGene = new vistaAgregarObjetivoGenera();
    ControlEvaluacionPlanVida contEPV = new ControlEvaluacionPlanVida(vistaEvaPlanVid, objGenModelDB, objEspecModelDB, objGenMOdel, objEspecMdel, vistaObjEsp, vistaObjGene);

    // Avances proceso terapeutico
    IngresoAvanceProceTerapeuticoDB modeloAPrT = new IngresoAvanceProceTerapeuticoDB();
    IngresoAvancesProcesoTerapeutico vistaAPrT = new IngresoAvancesProcesoTerapeutico();
    CtrlIngresoAvanceProceTerapeutico contAPrT = new CtrlIngresoAvanceProceTerapeutico(modeloAPrT, vistaAPrT);
    
    // Plan atencion terapeutica
    FichaPlanAtencionTerapeutica vFAtT = new FichaPlanAtencionTerapeutica();
    PlanAtencionTerapeuticoDB mFAtT = new PlanAtencionTerapeuticoDB();
    ControladorPlanAtencionTerapeutica contFAtT = new ControladorPlanAtencionTerapeutica(vFAtT, mFAtT);
    
    //Plan Evalucion Proceso Terapeutico
    IngresoAvanceProceTerapeuticoDB mEvPrT = new IngresoAvanceProceTerapeuticoDB();
    FichaEvolucionProcesoTerapeutico vEvPrT = new FichaEvolucionProcesoTerapeutico();
    CtrlFichaEvaluacionProcesoTerapeutico contEvPrT = new CtrlFichaEvaluacionProcesoTerapeutico(mEvPrT, vEvPrT);
    
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
    ControladorFichaEgreso contFEgr = new ControladorFichaEgreso(dir,egresoModel,vistaEgres, egresoModelDb, dirDB);
    
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
    x_respuestas  respuestas = new x_respuestas();
    ControladorFichaR1 contR1 = new ControladorFichaR1(vistaR1, respuestas,fRlDB);
    
    // Plan de vida
    FichaPlandeVida vPVida = new FichaPlandeVida();
    Plan_devidaDB mPVida = new Plan_devidaDB();
    DefinicionObjetivosGeneralDB objGeModelDB = new DefinicionObjetivosGeneralDB();
    DefinicionObjetivosEspecificosDB objEspeModelDB = new DefinicionObjetivosEspecificosDB();
    DefinicionObjetivosGeneral objGeMOdel = new DefinicionObjetivosGeneral();
    DefinicionObjetivosEspecifico objEspeMdel = new DefinicionObjetivosEspecifico();
    VistaDefinicionObjetivosEspecifico vistObjEsp = new VistaDefinicionObjetivosEspecifico();
    vistaAgregarObjetivoGenera vistObjGene = new vistaAgregarObjetivoGenera();
    ControladorPlandeVida contPVida = new ControladorPlandeVida(vPVida, mPVida, objGeModelDB, objEspeModelDB, objGeMOdel, objEspeMdel, vistObjEsp, vistObjGene);
    
    // registro llamada
    VistaRegistroLlamada vLlamada = new VistaRegistroLlamada();
    Controlador_registro_llamadas contLlamada;
    
    //plan de recursos
    VistaPlanRecursos vpr = new VistaPlanRecursos();
    Plan_deRecursosDB mPRDB = new Plan_deRecursosDB();
    ControladorPlandeRecursos contR = new ControladorPlandeRecursos(vpr, mPRDB);
    
    Conexion conex = new Conexion();

    int accLG = 1;
    int accIN = 1;
    int accPs = 1;
    int accTS = 1;

    public C_Menu(V_Menu menu) {
        this.menu = menu;
    }

    public void iniciaControl() throws ParseException, SQLException {
        if (personal_cod != 0) {
            control();
            control2();
        }
        menu.getBtnsoc().addActionListener(e -> Trabajo());
        menu.getBtnleg().addActionListener(e -> Legal());
        menu.getBtnpsico().addActionListener(e -> psicologia());
        menu.getBtninf().addActionListener(e -> infanto());

//        menu.getBtnMenu().addActionListener(e -> menu());
        menu.getBtnMLegal1().addActionListener(e -> abriPanelVistas(vLegal.getPnlPFL()));
        menu.getBtnMLegal2().addActionListener(e -> abriPanelVistas(vFRA.getJpFondo()));
        menu.getBtnPPriEn().addActionListener(e -> abriPanelVistas(vFPE.getPnlPrimerEncuentro()));
        menu.getBtnPHistCli().addActionListener(e -> abriPanelVistas(vistaHC.getPnlFchHisCli()));
        menu.getBtnRegistro().addActionListener(e -> abriPanelVistas(vFRR.getPlRegistroReferencia()));
        menu.getBtnCita().addActionListener(e -> abriPanelVistas(vistaCita.getPanelCitas()));
        menu.getBtnTRecur().addActionListener(e -> abriPanelVistas(vpr.getPlRecursos()));
//        menu.getBtnEvalPlVida().addActionListener(e -> abriPanelVistas(vistaEvaPlanVid));
        menu.getBtnPProcT().addActionListener(e -> abriPanelVistas(vEvPrT.getPanelFichaEvaluacionProceTera()));
        menu.getBtnPPlanTera().addActionListener(e -> abriPanelVistas(vFAtT.getPnlPAtTer()));
        menu.getBtnIplanD().addActionListener(e -> abriPanelVistas(vPVida.getPlPlandeVida()));

        menu.getLabuser().setText(usuario);
        menu.getLabperlCod().setText("" + personal_cod);
        obtenerPerfil();
    }

    public void control() {
        cFL.iniCFLegal();
        cFRA.iniciarCFichaRegusActu();
        ctrl.iniciarControlador();
        contPE.iniciarControl();
        contHC.inicialCHistClini();
        contCitas.iniciarControl();
        contEPV.iniciCtrlEvaluacionPlanVida();
        contAPrT.iniciarControl();
        contFAtT.iniciarControlador();
        contEvPrT.iniciarControlador();
        contFEgr.iniciCtrlEgreso();
        contIngr.inciarCtrlFichIngreso();
        contR1.iniciarComponentes();
        contPVida.iniciarControl();
        contR.iniciarControlRecursos();
    }

    public void control2() throws ParseException, SQLException {

        contRR = new ControladorRegistroReferencia(vFRR);
        contAgHj = new ControladorAgregarHijos(vFomAgHj);
        contDat = new ControladorDatosIniciales();
        try {
            contAgAs = new ControladorAgregarAgresores(vistaAgAs);
            contAgIsEd = new ControladorAgregarInstitucionEduc(vAgIsEd);
            contLlamada = new Controlador_registro_llamadas(vLlamada);
        } catch (ParseException ex) {
            System.out.println("ERROR Parse en el control 2" + ex.getMessage());
        }
        contAgFaml = new ControladorAgregarFamiliar(vistaAgFamil, tablaFamiliares);
        contBP = new ControladorBuscarPersona(vConsPer);
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

    public void MV() {

    }

    public void Trabajo() {
        AnimationClass trab = new AnimationClass();
        if (accTS == 1) {
            trab.jButtonXRight(0, 200, 10, 5, menu.getBtnTPlanR());
            trab.jButtonXRight(0, 200, 10, 5, menu.getBtnTAuto());
            trab.jButtonXRight(0, 200, 10, 5, menu.getBtnTRecur());
            Animacion.Animacion.mover_derecha(0, 200, 10, 5, menu.getBtnEvalPlVida());
            accTS = 2;
        } else if (accTS == 2) {
            trab.jButtonXLeft(200, 0, 10, 5, menu.getBtnTPlanR());
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
            inf.jButtonXLeft(200, 0, 10, 5, menu.getBtnIplanE());
            inf.jButtonXLeft(200, 0, 10, 5, menu.getBtnIproinf());
            accIN = 1;
        } else if (accIN == 1) {
            inf.jButtonXRight(0, 200, 10, 5, menu.getBtnIplanD());
            inf.jButtonXRight(0, 200, 10, 5, menu.getBtnIplanE());
            inf.jButtonXRight(0, 200, 10, 5, menu.getBtnIproinf());
            accIN = 2;
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
        cPerfil = adb.verifiUserA(conex, personal_cod);
        if (cPerfil != 0) {
            // abogada
            menu.getBtnpsico().setEnabled(false);
            menu.getBtninf().setEnabled(false);
            menu.getBtnsoc().setEnabled(false);
        } else {
            cPerfil = tsDB.verifiUserT(conex, personal_cod);
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
            System.out.println("este error " + e.getMessage());
        }
    }
}
