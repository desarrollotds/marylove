package marylove.controlador;

import AppPackage.AnimationClass;
import javax.swing.JOptionPane;
import marylove.DBmodelo.Trabajo_SocialDB;
import marylove.DBmodelo.abogadaDB;
import marylove.DBmodelo.psicologoDB;
import marylove.conexion.Conexion;
import static marylove.controlador.C_Login.personal_cod;
import static marylove.controlador.C_Login.usuario;
import marylove.vista.V_Menu;

public class C_Menu {

    private V_Menu menu;
    private Conexion conex;

    public C_Menu(V_Menu menu, Conexion conex) {
        this.menu = menu;
        this.conex = conex;
    }

    public void iniciaControl() {
        menu.getBtnMenu().addActionListener(e -> menu());
        obtenerPerfil();
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
        int user = personal_cod;
        int cPerfil;
        System.out.println("perfil en menu: " + personal_cod);
        System.out.println("usuario en menu: " + usuario);
        cPerfil = adb.verifiUserA(conex, user);
        if (cPerfil != 0) {
            // abogada
            menu.getBtnpsico().setEnabled(false);
            menu.getBtninf().setEnabled(false);
            menu.getBtnsoc().setEnabled(false);
        } else {
            cPerfil = tsDB.verifiUserT(conex, user);
            if (cPerfil != 0) {
                // tranajo social 
                menu.getBtnpsico().setEnabled(false);
                menu.getBtninf().setEnabled(false);
                menu.getBtnleg().setEnabled(false);
            } else {
                cPerfil = psdb.verifiUserP(conex, user);
                if (cPerfil != 0) {
                    // psicologa
                    menu.getBtnsoc().setEnabled(false);
                    menu.getBtninf().setEnabled(false);
                    menu.getBtnleg().setEnabled(false);
                } else {
                    // Eduacdora
                    if (false) {
                        
                    }else{
                        System.out.println("Direccion o Coordinacion");
                    }
                }
            }
        }
    }
}
