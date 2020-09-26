package marylove.controlador;

import AppPackage.AnimationClass;
import java.awt.Color;
import java.awt.Cursor;
import static java.awt.Cursor.*;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import marylove.DBmodelo.*;
import marylove.models.*;
import marylove.vista.*;
import org.json.simple.parser.ParseException;

public class C_Login extends Validaciones {

    public static int personal_cod;
    public static String usuario;

    private V_Login login;
    private V_Menu vistaPrincipal;
    private Personal pel;
    private Persona pr;
    private personaDB pDB;
    private personalDB plDB;
    private C_Menu menu;
    private vistaCarga vistCarg;
    DefaultComboBoxModel modelo;// modelo para setear datos en los combos

    abogadaDB adb = new abogadaDB();
    Trabajo_SocialDB tsDB = new Trabajo_SocialDB();
    psicologoDB psdb = new psicologoDB();
    EducadoraDB eDB = new EducadoraDB();
    CoordinadoraDB cDB = new CoordinadoraDB();
    DirectoraDB dDB = new DirectoraDB();

    DefaultTableModel modeloTab;
    int carg = 0;

    controlAbrir ctrAbrir;

    public C_Login() throws Exception {
    }

    //
    public C_Login(vistaCarga vistCarg, V_Login login, V_Menu vistaPrincipal, Personal pel, Persona pr, personaDB pDB, personalDB plDB, C_Menu menu) throws Exception {
        this.vistCarg = vistCarg;
        this.login = login;
        this.vistaPrincipal = vistaPrincipal;
        this.pel = pel;
        this.pr = pr;
        this.pDB = pDB;
        this.plDB = plDB;
        this.menu = menu;
        login.setVisible(true);
        login.setLocationRelativeTo(null);
        bajarIngrePersonal();
        login.getTxtConfirmacionContra().setVisible(false);
    }

    public void iniciaControl() {
        // validacion de ingreso en text
        login.getTxtCedula().addKeyListener(validarCedula(login.getTxtCedula()));
        login.getTxtIngPCedula().addKeyListener(validarCedula(login.getTxtIngPCedula()));
        login.getTxtPCel().addKeyListener(validarCelular(login.getTxtPCel()));
        login.getTxtPTelef().addKeyListener(validarCelular(login.getTxtPTelef()));
        login.getTxtIngPNombre().addKeyListener(validarLetras(login.getTxtIngPNombre()));
        login.getTxtIngPApellido().addKeyListener(validarLetras(login.getTxtIngPApellido()));

        login.getTxtBuscarPer().addKeyListener(buscar());

        login.getBtnIngraso().addActionListener(e -> {
            if (comprobarConexion()) {
                ingreso();
            }
        });
        login.getBtnConfirmar().addActionListener(e -> {
            login.getBtnConfirmar().setCursor(new Cursor(WAIT_CURSOR));
            Verificar();
            login.getBtnConfirmar().setCursor(new Cursor(DEFAULT_CURSOR));
        });
        login.getBtnGuardar().addActionListener(e -> {
            login.getBtnGuardar().setCursor(new Cursor(WAIT_CURSOR));
            guardarPersonal();
            limpiarUSER();
            login.getBtnGuardar().setCursor(new Cursor(DEFAULT_CURSOR));
        });
//        login.getBtnAtras().addActionListener(e -> Atras());
        login.getBtnRegistrar().addActionListener(e -> {
            if (comprobarConexion()) {
                Registrar();
            }
        });
        login.getBtnEntrar().addActionListener(e -> {
            try {
                login.getBtnEntrar().setCursor(new Cursor(WAIT_CURSOR));
                entrar();
                login.getBtnEntrar().setCursor(new Cursor(DEFAULT_CURSOR));
            } catch (Exception ex) {
                System.out.println("error en el boton entrar " + ex.getMessage());
            }
        });
        login.getBtnCancelarCon().addActionListener(e -> cancelar(1));
        login.getBtnPCancel().addActionListener(e -> {
            cancelar(1);
            bajarIngrePersonal();
        });
        login.getBtnPGuard().addActionListener(e -> {
            login.getBtnPGuard().setCursor(new Cursor(WAIT_CURSOR));
            guardarPersona();
            login.getBtnPGuard().setCursor(new Cursor(DEFAULT_CURSOR));
        });
        login.getBtnPersonal().addActionListener(e -> {
            login.getBtnPersonal().setCursor(new Cursor(WAIT_CURSOR));
            Listar();
            login.getBtnPersonal().setCursor(new Cursor(DEFAULT_CURSOR));
        });
        login.getBtnSelecPer().addActionListener(e -> {
            login.getBtnSelecPer().setCursor(new Cursor(WAIT_CURSOR));
            selecPer();
            login.getBtnSelecPer().setCursor(new Cursor(DEFAULT_CURSOR));
        });
        login.getBtnGuarE().addActionListener(e -> {
            login.getBtnGuarE().setCursor(new Cursor(WAIT_CURSOR));
            editUser();
            login.getBtnGuarE().setCursor(new Cursor(DEFAULT_CURSOR));
        });
        login.getBtnCancEd().addActionListener(e -> borraBusqueda());
        login.setTitle("Ventana de Inicio/Registro");

        //icono
        login.setIconImage(new ImageIcon(getClass().getResource("/iconos/icono1.png")).getImage());
    }

    public Image getIconImage() {
        Image retValue = Toolkit.getDefaultToolkit().
                getImage(ClassLoader.getSystemResource("iconos/ventana.png"));

        return retValue;
    }

    public void entrar() throws Exception {
        int oUser = plDB.obtenerCod(login.getTxtUsuario().getText(), login.getPswContra().getText());
        if (oUser != 0) {
            ctrAbrir = new controlAbrir(vistCarg);
            personal_cod = oUser;
            usuario = login.getTxtUsuario().getText();
            login.setVisible(false);
            ctrAbrir.iniciarControl();
            controlHilo.start();
        } else {
            JOptionPane.showMessageDialog(null, "Las credenciales ingresadas son incorrectas.", "Información", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void ingreso() {
        //salida
        login.getLablogo().setVisible(true);
        AnimationClass image = new AnimationClass();
        image.jLabelXRight(-200, 70, 10, 5, login.getLblUsu1());
        image.jLabelXRight(-200, 20, 10, 5, login.getLblUsu2());
        image.jLabelXRight(-200, 20, 10, 5, login.getLblUsuario());
        image.jLabelXRight(-200, 20, 10, 5, login.getLblContra());
        image.jLabelXRight(-200, 20, 10, 5, login.getLblContra1());
        image.jTextFieldXRight(-200, 50, 10, 5, login.getTxtUsuario());
        image.jPasswordFieldXRight(-200, 50, 10, 5, login.getPswContra());
        image.jButtonXRight(-200, 20, 10, 5, login.getBtnEntrar());
        image.jButtonXRight(-200, 120, 10, 5, login.getBtnRegistrar());

        //Regreso
        AnimationClass imagen = new AnimationClass();
        imagen.jLabelXLeft(70, -200, 10, 5, login.getLblUsu1());
        imagen.jLabelXLeft(20, -200, 10, 5, login.getLblUsu2());
        imagen.jLabelXLeft(20, -200, 10, 5, login.getLblUsuario());
        imagen.jLabelXLeft(20, -200, 10, 5, login.getLblContra());
        imagen.jLabelXLeft(20, -200, 10, 5, login.getLblContra1());
        imagen.jTextFieldXLeft(50, -200, 10, 5, login.getTxtUsuario());
        imagen.jPasswordFieldXLeft(50, -200, 10, 5, login.getPswContra());
        imagen.jButtonXLeft(20, -200, 10, 5, login.getBtnEntrar());
        imagen.jButtonXLeft(120, -200, 10, 5, login.getBtnRegistrar());

    }

    public void Registrar() {
        login.getLablogo().setVisible(false);
        AnimationClass imagen = new AnimationClass();
        imagen.jLabelXLeft(70, -200, 10, 5, login.getLblUsu1());
        imagen.jLabelXLeft(20, -200, 10, 5, login.getLblUsu2());
        imagen.jLabelXLeft(20, -200, 10, 5, login.getLblUsuario());
        imagen.jLabelXLeft(20, -200, 10, 5, login.getLblContra());
        imagen.jLabelXLeft(20, -200, 10, 5, login.getLblContra1());
        imagen.jTextFieldXLeft(50, -200, 10, 5, login.getTxtUsuario());
        imagen.jPasswordFieldXLeft(50, -200, 10, 5, login.getPswContra());
        imagen.jButtonXLeft(20, -200, 10, 5, login.getBtnEntrar());
        imagen.jButtonXLeft(120, -200, 10, 5, login.getBtnRegistrar());
        login.getBtnIngraso().setEnabled(true);
        AnimationClass conf = new AnimationClass();
        conf.jLabelYDown(-200, 30, 5, 10, login.getLblConfirmacion());
        conf.jLabelYDown(-200, 60, 5, 10, login.getLblConfirmacion1());
        conf.jLabelYDown(-200, 120, 10, 5, login.getLblConfirmacion2());
        conf.jLabelYDown(-200, 90, 10, 5, login.getLblConfirmacion3());
        conf.jTextFieldYDown(-200, 80, 10, 5, login.getTxtConfirmacionUsu());
//        conf.jPasswordFieldYDown(-200, 140, 10, 5, login.getTxtConfirmacionContra());
        login.getTxtConfirmacionContra().setVisible(true);
        conf.jButtonYDown(-200, 190, 10, 5, login.getBtnConfirmar());
        conf.jButtonYDown(-200, 190, 10, 5, login.getBtnCancelarCon());
        conf.jLabelYDown(-200, 80, 5, 10, login.getLblIcoUsu());
        conf.jLabelYDown(-200, 140, 5, 10, login.getLblIconoCon());
        Animacion.Animacion.subir(550, 240, 10, 5, login.getBtnPersonal());
    }

    public void Confirmar() {
        login.getBtnIngraso().setEnabled(true);
        AnimationClass imagen = new AnimationClass();

        //para mover la imagen de la fundacion Maria Amor
        imagen.jLabelXLeft(230, -60, 10, 5, login.getLblMaria());

        AnimationClass conf = new AnimationClass();
        conf.jLabelYUp(30, -200, 10, 5, login.getLblConfirmacion());
        conf.jLabelYUp(60, -200, 5, 10, login.getLblConfirmacion1());
        conf.jLabelYUp(120, -200, 5, 10, login.getLblConfirmacion2());
        conf.jLabelYUp(90, -200, 5, 10, login.getLblConfirmacion3());
        conf.jLabelYUp(80, -200, 5, 10, login.getLblIcoUsu());
        conf.jTextFieldYUp(80, -200, 10, 5, login.getTxtConfirmacionUsu());
//        conf.jPasswordFieldYUp(140, -200, 5, 10, login.getTxtConfirmacionContra());
        login.getTxtConfirmacionContra().setVisible(false);
        conf.jButtonYUp(190, -200, 5, 10, login.getBtnConfirmar());
        conf.jButtonYUp(190, -200, 5, 10, login.getBtnCancelarCon());
        conf.jLabelYUp(80, -200, 5, 10, login.getLblIcoUsu());
        conf.jLabelYUp(140, -200, 5, 10, login.getLblIconoCon());
        Animacion.Animacion.bajar(250, 540, 10, 5, login.getBtnPersonal());
        //para mover el registro
    }

    public void registroUser() {
        AnimationClass imagen = new AnimationClass();
        imagen.jLabelXLeft(1200, 840, 10, 5, login.getLblNuevoUsuairo());
        imagen.jLabelXLeft(1200, 780, 10, 5, login.getLblNombre());
        imagen.jLabelXLeft(1200, 780, 10, 5, login.getLblCedula());
        imagen.jLabelXLeft(1200, 780, 10, 5, login.getLblProfesion());
        imagen.jLabelXLeft(1200, 780, 10, 5, login.getLblContraseña());
        imagen.jTextFieldXLeft(1200, 780, 10, 5, login.getTxtNombre());
        imagen.jTextFieldXLeft(1200, 780, 10, 5, login.getTxtCedula());
        Animacion.Animacion.mover_izquierda(1200, 780, 10, 5, login.getCbxProfesiones());
        imagen.jTextFieldXLeft(1200, 780, 10, 5, login.getTxtContraseña());
        imagen.jButtonXLeft(1200, 770, 10, 5, login.getBtnGuardar());
        imagen.jButtonXLeft(1200, 900, 10, 5, login.getBtnAtras());
    }

    public void subirIngrePersonal() {
//        Animacion.Animacion.subir(520, 80, 10, 5, login.getLblIngreNPersl());
//        Animacion.Animacion.subir(520, 110, 10, 5, login.getLabPCed());
//        Animacion.Animacion.subir(520, 110, 10, 5, login.getTxtIngPCedula());
//        Animacion.Animacion.subir(520, 140, 10, 5, login.getLabPNomb());
//        Animacion.Animacion.subir(520, 140, 10, 5, login.getTxtIngPNombre());
//        Animacion.Animacion.subir(520, 170, 10, 5, login.getLabPApell());
//        Animacion.Animacion.subir(520, 170, 10, 5, login.getTxtIngPApellido());
//        Animacion.Animacion.subir(520, 200, 10, 5, login.getLabPTelef());
//        Animacion.Animacion.subir(520, 200, 10, 5, login.getTxtPTelef());
//        Animacion.Animacion.subir(520, 230, 10, 5, login.getLabPCelu());
//        Animacion.Animacion.subir(520, 230, 10, 5, login.getTxtPCel());
//        Animacion.Animacion.subir(520, 260, 10, 5, login.getTxtIPLuegTrab());
//        Animacion.Animacion.subir(520, 260, 10, 5, login.getLabLugarTrab());
////        Animacion.Animacion.subir(520, 295, 10, 5, login.getLabPFechN());
////        Animacion.Animacion.subir(520, 295, 10, 5, login.getJdcFechN());
//        Animacion.Animacion.subir(520, 325, 10, 5, login.getCmbPEstCivil());
//        Animacion.Animacion.subir(520, 325, 10, 5, login.getCmbPSexo());
//        Animacion.Animacion.subir(520, 355, 10, 5, login.getCmbPEstaMigra());
//        Animacion.Animacion.subir(520, 355, 10, 5, login.getCmbPNacional());
//        Animacion.Animacion.subir(520, 385, 10, 5, login.getCmbPNivelAcad());
//        Animacion.Animacion.subir(520, 385, 10, 5, login.getCmbPOcup());
//        Animacion.Animacion.subir(520, 425, 10, 5, login.getLabNAO());
//        Animacion.Animacion.subir(520, 425, 10, 5, login.getTxtNAO());
//        Animacion.Animacion.subir(520, 460, 10, 5, login.getBtnPGuard());
//        Animacion.Animacion.subir(520, 460, 10, 5, login.getBtnPCancel());
        login.getLblIngreNPersl().setVisible(true);
        login.getLabPCed().setVisible(true);
        login.getTxtIngPCedula().setVisible(true);
        login.getLabPNomb().setVisible(true);
        login.getTxtIngPNombre().setVisible(true);
        login.getLabPApell().setVisible(true);
        login.getTxtIngPApellido().setVisible(true);
        login.getLabPTelef().setVisible(true);
        login.getTxtPTelef().setVisible(true);
        login.getLabPCelu().setVisible(true);
        login.getTxtPCel().setVisible(true);
        login.getTxtIPLuegTrab().setVisible(true);
        login.getLabLugarTrab().setVisible(true);
        login.getLabPFechN().setVisible(true);
        login.getJdcFechN().setVisible(true);
        login.getCmbPEstCivil().setVisible(true);
        login.getCmbPSexo().setVisible(true);
        login.getCmbPEstaMigra().setVisible(true);
        login.getCmbPNacional().setVisible(true);
        login.getCmbPNivelAcad().setVisible(true);
        login.getCmbPOcup().setVisible(true);
        login.getLabNAO().setVisible(true);
        login.getTxtNAO().setVisible(true);
        login.getBtnPGuard().setVisible(true);
        login.getBtnPCancel().setVisible(true);
    }

    public void bajarIngrePersonal() {
//        Animacion.Animacion.bajar(80, 600, 10, 5, login.getLblIngreNPersl());
//        Animacion.Animacion.bajar(110, 600, 10, 5, login.getLabPCed());
//        Animacion.Animacion.bajar(110, 600, 10, 5, login.getTxtIngPCedula());
//        Animacion.Animacion.bajar(140, 600, 10, 5, login.getLabPNomb());
//        Animacion.Animacion.bajar(140, 600, 10, 5, login.getTxtIngPNombre());
//        Animacion.Animacion.bajar(170, 600, 10, 5, login.getLabPApell());
//        Animacion.Animacion.bajar(170, 600, 10, 5, login.getTxtIngPApellido());
//        Animacion.Animacion.bajar(200, 600, 10, 5, login.getLabPTelef());
//        Animacion.Animacion.bajar(200, 600, 10, 5, login.getTxtPTelef());
//        Animacion.Animacion.bajar(230, 600, 10, 5, login.getLabPCelu());
//        Animacion.Animacion.bajar(230, 600, 10, 5, login.getTxtPCel());
//        Animacion.Animacion.bajar(265, 600, 10, 5, login.getTxtIPLuegTrab());
//        Animacion.Animacion.bajar(265, 600, 10, 5, login.getLabLugarTrab());
//        Animacion.Animacion.bajar(295, 600, 10, 5, login.getLabPFechN());
//        Animacion.Animacion.bajar(295, 600, 10, 5, login.getJdcFechN());
//        Animacion.Animacion.bajar(225, 600, 10, 5, login.getCmbPEstCivil());
//        Animacion.Animacion.bajar(225, 600, 10, 5, login.getCmbPSexo());
//        Animacion.Animacion.bajar(355, 600, 10, 5, login.getCmbPEstaMigra());
//        Animacion.Animacion.bajar(355, 600, 10, 5, login.getCmbPNacional());
//        Animacion.Animacion.bajar(385, 600, 10, 5, login.getCmbPNivelAcad());
//        Animacion.Animacion.bajar(385, 600, 10, 5, login.getCmbPOcup());
//        Animacion.Animacion.bajar(425, 600, 10, 5, login.getLabNAO());
//        Animacion.Animacion.bajar(425, 600, 10, 5, login.getTxtNAO());
//        Animacion.Animacion.bajar(470, 600, 10, 5, login.getBtnPGuard());
//        Animacion.Animacion.bajar(470, 600, 10, 5, login.getBtnPCancel());
        login.getLblIngreNPersl().setVisible(false);
        login.getLabPCed().setVisible(false);
        login.getTxtIngPCedula().setVisible(false);
        login.getLabPNomb().setVisible(false);
        login.getTxtIngPNombre().setVisible(false);
        login.getLabPApell().setVisible(false);
        login.getTxtIngPApellido().setVisible(false);
        login.getLabPTelef().setVisible(false);
        login.getTxtPTelef().setVisible(false);
        login.getLabPCelu().setVisible(false);
        login.getTxtPCel().setVisible(false);
        login.getTxtIPLuegTrab().setVisible(false);
        login.getLabLugarTrab().setVisible(false);
        login.getLabPFechN().setVisible(false);
        login.getJdcFechN().setVisible(false);
        login.getCmbPEstCivil().setVisible(false);
        login.getCmbPSexo().setVisible(false);
        login.getCmbPEstaMigra().setVisible(false);
        login.getCmbPNacional().setVisible(false);
        login.getCmbPNivelAcad().setVisible(false);
        login.getCmbPOcup().setVisible(false);
        login.getLabNAO().setVisible(false);
        login.getTxtNAO().setVisible(false);
        login.getBtnPGuard().setVisible(false);
        login.getBtnPCancel().setVisible(false);
    }

    public void Guardar() {
        AnimationClass imagen = new AnimationClass();
        imagen.jLabelXRight(840, 1200, 10, 5, login.getLblNuevoUsuairo());
        imagen.jLabelXRight(780, 1200, 10, 5, login.getLblNombre());
        imagen.jLabelXRight(780, 1200, 10, 5, login.getLblCedula());
        imagen.jLabelXRight(780, 1200, 10, 5, login.getLblProfesion());
        imagen.jLabelXRight(780, 1200, 10, 5, login.getLblContraseña());
        imagen.jTextFieldXRight(780, 1200, 10, 5, login.getTxtNombre());
        imagen.jTextFieldXRight(780, 1200, 10, 5, login.getTxtCedula());
        Animacion.Animacion.mover_derecha(780, 1200, 10, 5, login.getCbxProfesiones());
        imagen.jTextFieldXRight(780, 1200, 10, 5, login.getTxtContraseña());
        imagen.jButtonXRight(770, 1200, 10, 5, login.getBtnGuardar());
        imagen.jButtonXRight(900, 1200, 10, 5, login.getBtnAtras());
        imagen.jLabelXRight(-60, 230, 10, 5, login.getLblMaria());
        //HAbilitar boton
        login.getBtnIngreso().setEnabled(true);

        AnimationClass image = new AnimationClass();
        image.jLabelXRight(-200, 70, 10, 5, login.getLblUsu1());
        image.jLabelXRight(-200, 20, 10, 5, login.getLblUsu2());
        image.jLabelXRight(-200, 20, 10, 5, login.getLblUsuario());
        image.jLabelXRight(-200, 20, 10, 5, login.getLblContra());
        image.jLabelXRight(-200, 20, 10, 5, login.getLblContra1());
        image.jTextFieldXRight(-200, 50, 10, 5, login.getTxtUsuario());
        image.jPasswordFieldXRight(-200, 50, 10, 5, login.getPswContra());
        image.jButtonXRight(-200, 20, 10, 5, login.getBtnEntrar());
        image.jButtonXRight(-200, 120, 10, 5, login.getBtnRegistrar());

    }

    public void Atras() {
        AnimationClass imagen = new AnimationClass();
        imagen.jLabelXRight(840, 1200, 10, 5, login.getLblNuevoUsuairo());
        imagen.jLabelXRight(780, 1200, 10, 5, login.getLblNombre());
        imagen.jLabelXRight(780, 1200, 10, 5, login.getLblCedula());
        imagen.jLabelXRight(780, 1200, 10, 5, login.getLblProfesion());
        imagen.jLabelXRight(780, 1200, 10, 5, login.getLblContraseña());
        imagen.jTextFieldXRight(780, 1200, 10, 5, login.getTxtNombre());
        imagen.jTextFieldXRight(780, 1200, 10, 5, login.getTxtCedula());
//        imagen.jTextFieldXRight(780,1200,  10, 5, login.getTxtProfesion());
        Animacion.Animacion.mover_derecha(780, 1200, 10, 5, login.getCbxProfesiones());
        imagen.jTextFieldXRight(780, 1200, 10, 5, login.getTxtContraseña());
        imagen.jButtonXRight(770, 1200, 10, 5, login.getBtnGuardar());
        imagen.jButtonXRight(900, 1200, 10, 5, login.getBtnAtras());
        imagen.jLabelXRight(-60, 230, 10, 5, login.getLblMaria());
        login.getBtnIngreso().setEnabled(true);

        AnimationClass image = new AnimationClass();
        image.jLabelXRight(-200, 70, 10, 5, login.getLblUsu1());
        image.jLabelXRight(-200, 20, 10, 5, login.getLblUsu2());
        image.jLabelXRight(-200, 20, 10, 5, login.getLblUsuario());
        image.jLabelXRight(-200, 20, 10, 5, login.getLblContra());
        image.jLabelXRight(-200, 20, 10, 5, login.getLblContra1());
        image.jTextFieldXRight(-200, 50, 10, 5, login.getTxtUsuario());
        image.jPasswordFieldXRight(-200, 50, 10, 5, login.getPswContra());
        image.jButtonXRight(-200, 20, 10, 5, login.getBtnEntrar());
        image.jButtonXRight(-200, 120, 10, 5, login.getBtnRegistrar());

    }

    public void cancelar(int s) {
        if (s == 1) {
            AnimationClass image = new AnimationClass();
            image.jLabelXRight(-200, 70, 10, 5, login.getLblUsu1());
            image.jLabelXRight(-200, 20, 10, 5, login.getLblUsu2());
            image.jLabelXRight(-200, 20, 10, 5, login.getLblUsuario());
            image.jLabelXRight(-200, 20, 10, 5, login.getLblContra());
            image.jLabelXRight(-200, 20, 10, 5, login.getLblContra1());
            image.jTextFieldXRight(-200, 50, 10, 5, login.getTxtUsuario());
            image.jPasswordFieldXRight(-200, 50, 10, 5, login.getPswContra());
            image.jButtonXRight(-200, 20, 10, 5, login.getBtnEntrar());
            image.jButtonXRight(-200, 120, 10, 5, login.getBtnRegistrar());
            s = 2;
        }
        if (s == 2) {
            AnimationClass conf = new AnimationClass();
            conf.jLabelYUp(30, -200, 10, 5, login.getLblConfirmacion());
            conf.jLabelYUp(60, -200, 5, 10, login.getLblConfirmacion1());
            conf.jLabelYUp(120, -200, 5, 10, login.getLblConfirmacion2());
            conf.jLabelYUp(90, -200, 5, 10, login.getLblConfirmacion3());
            conf.jLabelYUp(80, -200, 5, 10, login.getLblIcoUsu());
            conf.jTextFieldYUp(80, -200, 10, 5, login.getTxtConfirmacionUsu());
//            conf.jPasswordFieldYUp(140, -200, 5, 10, login.getTxtConfirmacionContra());
            login.getTxtConfirmacionContra().setVisible(false);
            conf.jButtonYUp(190, -200, 5, 10, login.getBtnConfirmar());
            conf.jButtonYUp(190, -200, 5, 10, login.getBtnCancelarCon());
            conf.jLabelYUp(80, -200, 5, 10, login.getLblIcoUsu());
            conf.jLabelYUp(140, -200, 5, 10, login.getLblIconoCon());
            Animacion.Animacion.bajar(240, 550, 10, 5, login.getBtnPersonal());
            limpiarVer();
        }

    }

    public Personal datosPersonal(int cod) {
        pel.setPersonal_usuario(login.getTxtUserIngre().getText());
        pel.setPersonal_contra(login.getTxtContraseña().getText());
        pel.setPersona_codigo(cod);
        return pel;

    }

    public void guardarPersonal() {
        if (!plDB.verifiUser(login.getTxtUserIngre().getText()).equals("")) {
            JOptionPane.showMessageDialog(null, "Nombre de usuario ya existe");
        } else {
            if (plDB.verifContra(login.getTxtUserIngre().getText(), login.getTxtContraseña().getText()) == 0) {

                if (plDB.ingrePersonal(datosPersonal(pDB.obtenerCod(login.getTxtCedula().getText())))) {
                    perfil(login.getTxtUserIngre().getText(), login.getTxtContraseña().getText());
                    Guardar();
                } else {
                    JOptionPane.showMessageDialog(null, "Usuario no ingresado");
                }
            } else {
                JOptionPane.showMessageDialog(null, "Contraseña no valida");
            }
        }
    }

    public Persona datosPersona() {
        String sexo = login.getCmbPSexo().getSelectedItem().toString();
        char sex = sexo.charAt(0);

        pr.setPersona_nombre(login.getTxtIngPNombre().getText());
        pr.setPersona_apellido(login.getTxtIngPApellido().getText());
        pr.setPersona_cedula(login.getTxtIngPCedula().getText());
        pr.setPersona_celular(login.getTxtPCel().getText());
        pr.setPersona_telefono(login.getTxtPTelef().getText());
        pr.setPersona_lugar_trabajo(login.getTxtIPLuegTrab().getText());
        pr.setPersona_nivel_acad_otros(login.getTxtNAO().getText());
        try {
            pr.setPersona_fecha_nac(fechaBD(login.getJdcFechN().getDate().getTime()));
        } catch (Exception e) {
            System.out.println("ERROR ingreso FECHA " + e.getMessage());
        }
        pr.setPersona_est_migr(login.getCmbPEstaMigra().getSelectedIndex());
        pr.setPersona_estadocivil(login.getCmbPEstCivil().getSelectedIndex());
        pr.setPersona_sexo(sex);
        pr.setPersona_nivel_acad(login.getCmbPNivelAcad().getSelectedIndex());
        pr.setPersona_nacionalidad(login.getCmbPNacional().getSelectedIndex());
        pr.setPersona_ocupacion(login.getCmbPOcup().getSelectedIndex());
        login.getTxtCedula().setText(login.getTxtIngPCedula().getText());
        return pr;
    }

    public void Verificar() {
        int user = plDB.obtenerCod(login.getTxtConfirmacionUsu().getText(), login.getTxtConfirmacionContra().getText());
        if (user != 0) {
            if (registroVerif(user)) {
                ingresarComboBox();
                subirIngrePersonal();
                Confirmar();
                limpiarVer();
            }
        } else {
            JOptionPane.showMessageDialog(null, "Usuario o Contraseña incorrecta");
        }
    }

    public void guardarPersona() {

        if (login.getTxtIngPCedula().getText().equals("") || login.getTxtIngPNombre().getText().equals("")
                || login.getTxtIngPApellido().getText().equals("")
                || login.getTxtPCel().getText().equals("") || login.getTxtIPLuegTrab().getText().equals("")) {

            JOptionPane.showMessageDialog(null, "Datos necesarios no ingresados");
        } else {
            if (pDB.personaBYCedula((login.getTxtIngPCedula().getText()))) {
                if (login.getCmbPSexo().getSelectedIndex() != 0 && login.getCmbPEstCivil().getSelectedIndex() != 0 && login.getCmbPNivelAcad().getSelectedIndex() != 0 && login.getCmbPNacional().getSelectedIndex() != 0 && login.getCmbPOcup().getSelectedIndex() != 0) {
                    if (pDB.ingrePersona2(datosPersona())) {
                        registroUser();
                        login.getTxtCedula().setText(login.getTxtIngPCedula().getText());
                        bajarIngrePersonal();
                        limpiarINP();
                    } else {
                        JOptionPane.showMessageDialog(login, "Error al ingresar los datos intente nuevamente");
                    }
                } else {
                    JOptionPane.showMessageDialog(login, "Seleccionar todos los datos");
                }
            } else {
                JOptionPane.showMessageDialog(login, "Cedula de persona ya ingresada");
            }
        }
    }

    // metodos para llenar los combox con los json 
    public void ingresarComboBox() {
        if (carg == 0) {
            carg++;
            llenarCBXEstCivil();
            llenarCBXNaco();
            llenarCBXOcupacion();
            llenarCBXNivelA();
            llenarCBXEstaMigr();
        }
    }

    public void llenarCBXNaco() {
        try {
            modelo = new DefaultComboBoxModel();
            jsonDB jDB = new jsonDB();
            ArrayList<Json_object_consulta> json;
            json = jDB.obtenerNacionalidades();
            modelo.addElement(login.getCmbPNacional().getModel().getElementAt(0));
            for (Json_object_consulta o : json) {
                modelo.addElement(o.getValor());
            }
            modelo.removeElementAt(1);
            login.getCmbPNacional().setModel(modelo);
        } catch (ParseException ex) {
            System.out.println("Error al llenar Combo Nacionalidad " + ex.getMessage());
        }
    }

    public void llenarCBXEstCivil() {
        try {
            modelo = new DefaultComboBoxModel();
            jsonDB jDB = new jsonDB();
            ArrayList<Json_object_consulta> json;
            json = jDB.obtenerEstadoCivil();
            modelo.addElement(login.getCmbPEstCivil().getModel().getElementAt(0));
            for (Json_object_consulta o : json) {
                modelo.addElement(o.getValor());
            }
//            modelo.removeElement(1);
            login.getCmbPEstCivil().setModel(modelo);
        } catch (ParseException ex) {
            System.out.println("Error al llenar Combo Estado civil " + ex.getMessage());
        }
    }

    public void llenarCBXOcupacion() {
        try {
            modelo = new DefaultComboBoxModel();
            jsonDB jDB = new jsonDB();
            ArrayList<Json_object_consulta> json;
            json = jDB.obtenerOcupaciones();
            modelo.addElement(login.getCmbPOcup().getModel().getElementAt(0));
            for (Json_object_consulta o : json) {
                modelo.addElement(o.getValor());
            }
            modelo.removeElementAt(1);
            login.getCmbPOcup().setModel(modelo);
        } catch (ParseException ex) {
            System.out.println("Error al llenar Combo Ocupacion " + ex.getMessage());
        }
    }

    public void llenarCBXNivelA() {
        try {
            modelo = new DefaultComboBoxModel();
            jsonDB jDB = new jsonDB();
            ArrayList<Json_object_consulta> json;
            json = jDB.obtenerInstruccines();
            modelo.addElement(login.getCmbPNivelAcad().getModel().getElementAt(0));
            for (Json_object_consulta o : json) {
                modelo.addElement(o.getValor());
            }
            modelo.removeElementAt(1);
            login.getCmbPNivelAcad().setModel(modelo);
        } catch (ParseException ex) {
            System.out.println("Error al llenar Combo Nivel academico " + ex.getMessage());
        }
    }

    public void llenarCBXEstaMigr() {
        try {
            modelo = new DefaultComboBoxModel();
            jsonDB jDB = new jsonDB();
            ArrayList<Json_object_consulta> json;
            json = jDB.obtener_estado_migratorio();
            modelo.addElement(login.getCmbPEstaMigra().getModel().getElementAt(0));
            for (Json_object_consulta o : json) {
                modelo.addElement(o.getValor());
            }
            modelo.removeElementAt(1);
            login.getCmbPEstaMigra().setModel(modelo);
        } catch (ParseException ex) {
            System.out.println("Error al llenar Combo Estado migratorio " + ex.getMessage());
        }
    }

    // metodo para ingresar el tipo de usuario ingresado
    public void perfil(String user, String pass) {
        switch (login.getCbxProfesiones().getSelectedIndex()) {
            case (0):
                dDB.setPersonal_codigo(plDB.obtenerCod(user, pass));
                dDB.ingreDirectora(dDB);
                break;
            case (1):
                cDB.setPersonal_codigo(plDB.obtenerCod(user, pass));
                cDB.ingreCoodinadora(cDB);
                break;
            case (2):
                eDB.setPersonal_codigo(plDB.obtenerCod(user, pass));
                eDB.ingreEducadora(eDB);
                break;
            case (3):
                // legal
                adb.setPersonal_codigo(plDB.obtenerCod(user, pass));
                adb.ingreAbogada(adb);
                break;
            case (4):
                // Trabajo Social
                tsDB.setPersonal_codigo(plDB.obtenerCod(user, pass));
                tsDB.ingreTrabSocial(tsDB);
                break;
            case (5):
                //psicologia
                psdb.setPersonal_cod(plDB.obtenerCod(user, pass));
                psdb.ingrePsicologo(psdb);
                break;
            default:
                System.out.println("no encontrada");
        }
    }

    // metodo para verficar el usuario que ingresa a registrar
    public boolean registroVerif(int cod) {
        boolean direc = false;
        int cPerfil;
        cPerfil = cDB.verifiUserC(cod);
        if (cPerfil != 0) {
            direc = true;
        } else {
            cPerfil = dDB.verifiUserD(cod);
            if (cPerfil != 0) {
                direc = true;
            } else {
                JOptionPane.showMessageDialog(null, "Usuario o Contraseña incorrecta/n Usuario no permitido");
            }
        }
        return direc;
    }

    public void Listar() { // listar los distintos usuarios de la aplicacion para editar usuario o contraseña

        int user = plDB.obtenerCod(login.getTxtConfirmacionUsu().getText(), login.getTxtConfirmacionContra().getText());
        if (user != 0 && registroVerif(user)) {
            cancelar(2);
            login.getJdgEditPerl().setVisible(true);
            login.getJdgEditPerl().setSize(550, 470);
            login.getJdgEditPerl().setLocationRelativeTo(null);
            motarTAB();
            limpiarVer();
        } else {
            JOptionPane.showMessageDialog(null, "Usuario o Contraseña incorrecta");
        }

    }

    public void limpiarVer() {
        login.getTxtConfirmacionUsu().setText("");
        login.getTxtConfirmacionContra().setText("");
    }

    public void motarTAB() { // metodo para mostra la lista del personal en un JTable
        List<Personal> listPel;
        try {
            int canFilas = login.getTabPersonal().getRowCount();
            for (int a = canFilas - 1; a >= 0; a--) {
                modeloTab.removeRow(a);
            }
            modeloTab = (DefaultTableModel) login.getTabPersonal().getModel();
            listPel = plDB.obtenerPersonal();
            int columnas = modeloTab.getColumnCount();
            for (int i = 0; i < listPel.size(); i++) {
                modeloTab.addRow(new Object[columnas]);
                login.getTabPersonal().setValueAt(listPel.get(i).getPersonal_codigo(), i, 0);
                login.getTabPersonal().setValueAt(listPel.get(i).getPersona_nombre(), i, 1);
                login.getTabPersonal().setValueAt(listPel.get(i).getPersonal_usuario(), i, 2);
                login.getTabPersonal().setValueAt(listPel.get(i).getPersonal_contra(), i, 3);
            }
        } catch (Exception e) {
            System.out.println("error al cargar tablas " + e.getMessage());
        }
    }

    public void selecPer() {
        DefaultTableModel moTablaP = (DefaultTableModel) login.getTabPersonal().getModel();
        int fsel = login.getTabPersonal().getSelectedRow();
        if (fsel == -1) {
            JOptionPane.showMessageDialog(null, "Seleccione una fila lista", "Verificación", JOptionPane.WARNING_MESSAGE);
        } else {
            login.getJlbIDPer().setText(moTablaP.getValueAt(login.getTabPersonal().getSelectedRow(), 0).toString());
            login.getTxtUserPerE().setText(moTablaP.getValueAt(login.getTabPersonal().getSelectedRow(), 2).toString());
            login.getTxtpassPerE().setText(moTablaP.getValueAt(login.getTabPersonal().getSelectedRow(), 3).toString());
        }
    }

    public void editUser() {
        if (!(login.getTxtUserPerE().getText().equals("") && login.getTxtpassPerE().getText().equals(""))) {
            Personal psl = new Personal();
            psl.setPersonal_codigo(Integer.parseInt(login.getJlbIDPer().getText()));
            psl.setPersonal_usuario(login.getTxtUserPerE().getText());
            psl.setPersonal_contra(login.getTxtpassPerE().getText());
            if (plDB.editPers(psl)) {
                login.getJdgEditPerl().setVisible(false);
            } else {
                JOptionPane.showMessageDialog(null, "Error al editar", "Verificación", JOptionPane.WARNING_MESSAGE);
            }

        } else {
            JOptionPane.showMessageDialog(null, "Campos vacios", "Verificación", JOptionPane.WARNING_MESSAGE);
        }
    }

    public void buscarP(String aguja) {
        List<Personal> listPel;
        try {
            int canFilas = login.getTabPersonal().getRowCount();
            for (int a = canFilas - 1; a >= 0; a--) {
                modeloTab.removeRow(a);
            }
            modeloTab = (DefaultTableModel) login.getTabPersonal().getModel();
            listPel = plDB.buscarPersonal(aguja);
            int columnas = modeloTab.getColumnCount();
            for (int i = 0; i < listPel.size(); i++) {
                modeloTab.addRow(new Object[columnas]);
                login.getTabPersonal().setValueAt(listPel.get(i).getPersonal_codigo(), i, 0);
                login.getTabPersonal().setValueAt(listPel.get(i).getPersona_nombre(), i, 1);
                login.getTabPersonal().setValueAt(listPel.get(i).getPersonal_usuario(), i, 2);
                login.getTabPersonal().setValueAt(listPel.get(i).getPersonal_contra(), i, 3);
            }
        } catch (Exception e) {
            System.out.println("error al cargar tablas " + e.getMessage());
        }
    }

    public KeyListener buscar() { // al hacer un enter realizar una acción de busqueda al usuario
        KeyListener kn = new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
            }

            @Override
            public void keyPressed(KeyEvent e) {
                login.getTxtBuscarPer().setCursor(new Cursor(WAIT_CURSOR));
                buscarP(login.getTxtBuscarPer().getText());
                login.getTxtBuscarPer().setCursor(new Cursor(DEFAULT_CURSOR));
            }

            @Override
            public void keyReleased(KeyEvent e) {

            }
        };
        return kn;
    }

    public void borraBusqueda() {
        login.getJlbIDPer().setText("000");
        login.getTxtUserPerE().setText("");
        login.getTxtpassPerE().setText("");
    }
    Thread controlHilo = new Thread() {
        @Override
        public void run() {
            menu.iniciaControl();
            vistaPrincipal.setVisible(true);
            vistaPrincipal.setLocationRelativeTo(null);
        }
    };

    private void limpiarINP() {
        login.getTxtIngPCedula().setText("");
        login.getTxtIngPNombre().setText("");
        login.getTxtIngPApellido().setText("");
        login.getTxtPCel().setText("");
        login.getTxtPTelef().setText("");
        login.getTxtIPLuegTrab().setText("");
        login.getCbxProfesiones().setSelectedIndex(0);
        login.getCmbPEstCivil().setSelectedIndex(0);
        login.getCmbPEstaMigra().setSelectedIndex(0);
        login.getCmbPNacional().setSelectedIndex(0);
        login.getCmbPNivelAcad().setSelectedIndex(0);
        login.getCmbPOcup().setSelectedIndex(0);
        login.getCmbPSexo().setSelectedIndex(0);
    }

    private void limpiarUSER() {
        login.getTxtUserIngre().setText("");
        login.getTxtCedula().setText("");
        login.getTxtContraseña().setText("");
    }
}
