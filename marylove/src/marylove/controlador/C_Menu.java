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
    private Ficha_Legal mLegal;
    private fichaLegalDB flDB;
    private controlFichaLegal cFL;

    public C_Menu(V_Menu menu, Conexion conex, FichaLegal vLegal, Ficha_Legal mLegal, fichaLegalDB flDB, controlFichaLegal cFL) {
        this.menu = menu;
        this.conex = conex;
        this.vLegal = vLegal;
        this.mLegal = mLegal;
        this.flDB = flDB;
        this.cFL = cFL;
    }

    public void iniciaControl() {
        menu.getLabuser().setText(usuario);
        menu.getLabperlCod().setText("" + personal_cod);
        obtenerPerfil();
        menu.getBtnMenu().addActionListener(e -> menu());
        menu.getBtnleg().addActionListener(e -> abriPanelVistas(vLegal.getPnlPFL()));

        // control de la ficha legal
        cFL.iniCFLegal();
//        menu.getBtnConfirmar().addActionListener(e -> Verificar());
//        menu.getBtnGuardar().addActionListener(e -> Guardar());
//        menu.getBtnAtras().addActionListener(e -> Atras());
//        hbgasidhiausbf
    }

    public void menu() {

        AnimationClass men = new AnimationClass();
        men.jLabelXRight(-200, 20, 10, 5, menu.getLblpsico());
        men.jLabelXRight(-200, 0, 10, 5, menu.getLblsoc());
        men.jLabelXRight(-200, 30, 10, 5, menu.getLblleg());
        men.jLabelXRight(-200, 25, 10, 5, menu.getLblinf());

        men.jButtonXRight(-200, 0, 10, 5, menu.getBtnpsico());
        men.jButtonXRight(-200, 0, 10, 5, menu.getBtnleg());
        men.jButtonXRight(-200, 0, 10, 5, menu.getBtnsoc());
        men.jButtonXRight(-200, 0, 10, 5, menu.getBtninf());

        men.jLabelXLeft(20, -200, 10, 5, menu.getLblpsico());
        men.jLabelXLeft(0, -200, 10, 5, menu.getLblsoc());
        men.jLabelXLeft(30, -200, 10, 5, menu.getLblleg());
        men.jLabelXLeft(25, -200, 10, 5, menu.getLblinf());

        men.jButtonXLeft(0, -200, 10, 5, menu.getBtnpsico());
        men.jButtonXLeft(0, -200, 10, 5, menu.getBtnleg());
        men.jButtonXLeft(0, -200, 10, 5, menu.getBtnsoc());
        men.jButtonXLeft(0, -200, 10, 5, menu.getBtninf());
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
                cPerfil = psdb.verifiUserP(conex, personal_cod);
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
        panel.setSize(1500, 870);
        panel.setLocation(2, 2);
        JScrollPane scrollpane;
        scrollpane = new JScrollPane();
        scrollpane.setBounds(0, 0, menu.getPanelVistas().getWidth(), menu.getPanelVistas().getHeight());
        scrollpane.setViewportView(panel);
        menu.getPanelVistas().removeAll();
        menu.getPanelVistas().add(scrollpane);
        menu.getPanelVistas().revalidate();
        menu.getPanelVistas().repaint();
    }
}
