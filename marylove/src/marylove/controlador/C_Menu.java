package marylove.controlador;

import AppPackage.AnimationClass;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import marylove.DBmodelo.*;
import marylove.conexion.Conexion;
import static marylove.controlador.C_Login.personal_cod;
import static marylove.controlador.C_Login.usuario;
import marylove.models.*;
import marylove.vista.*;

public class C_Menu {

    private V_Menu menu;
    private Conexion conex;

    // ficha legal 
    private FichaLegal vLegal;

    // ficha Registro Actuaciones
    private FichaRegistroActuaciones vFRA;
    private ControlFichaRegisActu cFRA;
    private controlFichaLegal cFL;

    VistaPlanEmergente vista = new VistaPlanEmergente();
    PlanEmergenteDB modeloDB = new PlanEmergenteDB();
    PlanEmergente2DB modeloDB2 = new PlanEmergente2DB();
    ControladorPlanEmergente ctrl = new ControladorPlanEmergente(vista, modeloDB, modeloDB2);
    
    FichaPrimerEncuentro vFPE = new FichaPrimerEncuentro();
    primer_EncuentroDB peDB= new primer_EncuentroDB();
    ControladorPrimerEncuentro contPE = new ControladorPrimerEncuentro(vFPE,peDB);
            

    

    int accLG = 1;
    int accIN = 1;
    int accPs = 1;
    int accTS = 1;

    public C_Menu(V_Menu menu, Conexion conex, FichaLegal vLegal, FichaRegistroActuaciones vFRA, ControlFichaRegisActu cFRA, controlFichaLegal cFL) {
        this.menu = menu;
        this.conex = conex;
        this.vLegal = vLegal;
        this.vFRA = vFRA;
        this.cFRA = cFRA;
        this.cFL = cFL;
    }

    public void iniciaControl() {
        menu.getLabuser().setText(usuario);
        menu.getLabperlCod().setText("" + personal_cod);
        obtenerPerfil();

        menu.getBtnsoc().addActionListener(e -> Trabajo());
        menu.getBtnleg().addActionListener(e -> Legal());
        menu.getBtnpsico().addActionListener(e -> psicologia());
        menu.getBtninf().addActionListener(e -> infanto());

//        menu.getBtnMenu().addActionListener(e -> menu());
        menu.getBtnMLegal1().addActionListener(e -> abriPanelVistas(vLegal.getPnlPFL()));
        menu.getBtnMLegal2().addActionListener(e -> abriPanelVistas(vFRA.getJpFondo()));
        menu.getBtnPPriEn().addActionListener(e -> abriPanelVistas(vFPE.getPnlPrimerEncuentro()));

        control();
    }

    public void control() {
        cFL.iniCFLegal();
        cFRA.iniciarCFichaRegusActu();
        ctrl.iniciarControlador ();
        contPE.iniciarControl();
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
            accTS = 2;
        } else if (accTS == 2) {
            trab.jButtonXLeft(200, 0, 10, 5, menu.getBtnTPlanR());
            trab.jButtonXLeft(200, 0, 10, 5, menu.getBtnTAuto());
            trab.jButtonXLeft(200, 0, 10, 5, menu.getBtnTRecur());
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
