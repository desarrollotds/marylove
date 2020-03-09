package marylove.controlador;

import AppPackage.AnimationClass;
import java.util.ArrayList;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import marylove.DBmodelo.*;
import marylove.conexion.Conexion;
import marylove.models.*;
import marylove.vista.*;
import org.json.simple.parser.ParseException;

public class C_Login extends Validaciones {

    private V_Login login;
    private V_Menu vistaPrincipal;
    private Personal pel;
    private Persona pr;
    private personaDB pDB;
    private personalDB plDB;
    private C_Menu menu;
    private Conexion conex;

    public static int personal_cod;
    public static String usuario;

    DefaultComboBoxModel modelo;// modelo para setear datos en los combos

    abogadaDB adb = new abogadaDB();
    Trabajo_SocialDB tsDB = new Trabajo_SocialDB();
    psicologoDB psdb = new psicologoDB();
    EducadoraDB eDB = new EducadoraDB();
    CoordinadoraDB cDB = new CoordinadoraDB();
    DirectoraDB dDB = new DirectoraDB();

    public C_Login() {
    }

    public C_Login(V_Login login, V_Menu vistaPrincipal, Personal pel, Persona pr, personaDB pDB, personalDB plDB, C_Menu menu, Conexion conex) {
        this.login = login;
        this.vistaPrincipal = vistaPrincipal;
        this.pel = pel;
        this.pr = pr;
        this.pDB = pDB;
        this.plDB = plDB;
        this.menu = menu;
        this.conex = conex;
        login.setVisible(true);
    }

    public void iniciaControl() {
        // validacion de ingreso en text
        login.getTxtCedula().addKeyListener(validarCedula(login.getTxtCedula()));
        login.getTxtIngPCedula().addKeyListener(validarCedula(login.getTxtIngPCedula()));
        login.getTxtPCel().addKeyListener(validarCelular(login.getTxtPCel()));
        login.getTxtPTelef().addKeyListener(validarCelular(login.getTxtPTelef()));
        login.getTxtIngPNombre().addKeyListener(validarLetras(login.getTxtIngPNombre()));
        login.getTxtIngPApellido().addKeyListener(validarLetras(login.getTxtIngPApellido()));

        ingresarComboBox();
        login.getBtnIngraso().addActionListener(e -> ingreso());
        login.getBtnConfirmar().addActionListener(e -> Verificar());
        login.getBtnGuardar().addActionListener(e -> guardarPersonal());
        login.getBtnAtras().addActionListener(e -> Atras());
        login.getBtnRegistrar().addActionListener(e -> Registrar());
        login.getBtnEntrar().addActionListener(e -> entrar());
        login.getBtnCancelarCon().addActionListener(e -> cancelar());
        login.getBtnPCancel().addActionListener(e -> cancelar());
        login.getBtnPCancel().addActionListener(e -> bajarIngrePersonal());
        login.getBtnPGuard().addActionListener(e -> guardarPersona());

    }

    public void entrar() {
        int oUser = plDB.obtenerCod(conex, login.getTxtUsuario().getText(), login.getPswContra().getText());
        if (oUser != 0) {
            personal_cod = oUser;
            usuario = login.getTxtUsuario().getText();
            login.setVisible(false);
            vistaPrincipal.setVisible(true);
            menu.iniciaControl();
        } else {
            JOptionPane.showMessageDialog(null, "No existe el usuario");
        }
    }

    public void ingreso() {
        //salida
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
        conf.jTextFieldYDown(-200, 140, 10, 5, login.getTxtConfirmacionContra());
        conf.jButtonYDown(-200, 190, 10, 5, login.getBtnConfirmar());
        conf.jButtonYDown(-200, 190, 10, 5, login.getBtnCancelarCon());
        conf.jLabelYDown(-200, 80, 5, 10, login.getLblIcoUsu());
        conf.jLabelYDown(-200, 140, 5, 10, login.getLblIconoCon());
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
        conf.jTextFieldYUp(140, -200, 5, 10, login.getTxtConfirmacionContra());
        conf.jButtonYUp(190, -200, 5, 10, login.getBtnConfirmar());
        conf.jButtonYUp(190, -200, 5, 10, login.getBtnCancelarCon());
        conf.jLabelYUp(80, -200, 5, 10, login.getLblIcoUsu());
        conf.jLabelYUp(140, -200, 5, 10, login.getLblIconoCon());

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
        Animacion.Animacion.subir(520, 80, 10, 5, login.getLblIngreNPersl());
        Animacion.Animacion.subir(520, 110, 10, 5, login.getLabPCed());
        Animacion.Animacion.subir(520, 110, 10, 5, login.getTxtIngPCedula());
        Animacion.Animacion.subir(520, 140, 10, 5, login.getLabPNomb());
        Animacion.Animacion.subir(520, 140, 10, 5, login.getTxtIngPNombre());
        Animacion.Animacion.subir(520, 170, 10, 5, login.getLabPApell());
        Animacion.Animacion.subir(520, 170, 10, 5, login.getTxtIngPApellido());
        Animacion.Animacion.subir(520, 200, 10, 5, login.getLabPTelef());
        Animacion.Animacion.subir(520, 200, 10, 5, login.getTxtPTelef());
        Animacion.Animacion.subir(520, 230, 10, 5, login.getLabPCelu());
        Animacion.Animacion.subir(520, 230, 10, 5, login.getTxtPCel());
        Animacion.Animacion.subir(520, 260, 10, 5, login.getTxtIPLuegTrab());
        Animacion.Animacion.subir(520, 260, 10, 5, login.getLabLugarTrab());
        Animacion.Animacion.subir(520, 295, 10, 5, login.getLabPFechN());
        Animacion.Animacion.subir(520, 295, 10, 5, login.getJdcFechN());
        Animacion.Animacion.subir(520, 325, 10, 5, login.getCmbPEstCivil());
        Animacion.Animacion.subir(520, 325, 10, 5, login.getCmbPSexo());
        Animacion.Animacion.subir(520, 355, 10, 5, login.getCmbPEstaMigra());
        Animacion.Animacion.subir(520, 355, 10, 5, login.getCmbPNacional());
        Animacion.Animacion.subir(520, 385, 10, 5, login.getCmbPNivelAcad());
        Animacion.Animacion.subir(520, 385, 10, 5, login.getCmbPOcup());
        Animacion.Animacion.subir(520, 425, 10, 5, login.getLabNAO());
        Animacion.Animacion.subir(520, 425, 10, 5, login.getTxtNAO());
        Animacion.Animacion.subir(520, 460, 10, 5, login.getBtnPGuard());
        Animacion.Animacion.subir(520, 460, 10, 5, login.getBtnPCancel());
    }

    public void bajarIngrePersonal() {
        Animacion.Animacion.bajar(80, 600, 10, 5, login.getLblIngreNPersl());
        Animacion.Animacion.bajar(110, 600, 10, 5, login.getLabPCed());
        Animacion.Animacion.bajar(110, 600, 10, 5, login.getTxtIngPCedula());
        Animacion.Animacion.bajar(140, 600, 10, 5, login.getLabPNomb());
        Animacion.Animacion.bajar(140, 600, 10, 5, login.getTxtIngPNombre());
        Animacion.Animacion.bajar(170, 600, 10, 5, login.getLabPApell());
        Animacion.Animacion.bajar(170, 600, 10, 5, login.getTxtIngPApellido());
        Animacion.Animacion.bajar(200, 600, 10, 5, login.getLabPTelef());
        Animacion.Animacion.bajar(200, 600, 10, 5, login.getTxtPTelef());
        Animacion.Animacion.bajar(230, 600, 10, 5, login.getLabPCelu());
        Animacion.Animacion.bajar(230, 600, 10, 5, login.getTxtPCel());
        Animacion.Animacion.bajar(265, 600, 10, 5, login.getTxtIPLuegTrab());
        Animacion.Animacion.bajar(265, 600, 10, 5, login.getLabLugarTrab());
        Animacion.Animacion.bajar(295, 600, 10, 5, login.getLabPFechN());
        Animacion.Animacion.bajar(295, 600, 10, 5, login.getJdcFechN());
        Animacion.Animacion.bajar(225, 600, 10, 5, login.getCmbPEstCivil());
        Animacion.Animacion.bajar(225, 600, 10, 5, login.getCmbPSexo());
        Animacion.Animacion.bajar(355, 600, 10, 5, login.getCmbPEstaMigra());
        Animacion.Animacion.bajar(355, 600, 10, 5, login.getCmbPNacional());
        Animacion.Animacion.bajar(385, 600, 10, 5, login.getCmbPNivelAcad());
        Animacion.Animacion.bajar(385, 600, 10, 5, login.getCmbPOcup());
        Animacion.Animacion.bajar(425, 600, 10, 5, login.getLabNAO());
        Animacion.Animacion.bajar(425, 600, 10, 5, login.getTxtNAO());
        Animacion.Animacion.bajar(470, 600, 10, 5, login.getBtnPGuard());
        Animacion.Animacion.bajar(470, 600, 10, 5, login.getBtnPCancel());
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

    public void cancelar() {
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

        AnimationClass conf = new AnimationClass();
        conf.jLabelYUp(30, -200, 10, 5, login.getLblConfirmacion());
        conf.jLabelYUp(60, -200, 5, 10, login.getLblConfirmacion1());
        conf.jLabelYUp(120, -200, 5, 10, login.getLblConfirmacion2());
        conf.jLabelYUp(90, -200, 5, 10, login.getLblConfirmacion3());
        conf.jLabelYUp(80, -200, 5, 10, login.getLblIcoUsu());
        conf.jTextFieldYUp(80, -200, 10, 5, login.getTxtConfirmacionUsu());
        conf.jTextFieldYUp(140, -200, 5, 10, login.getTxtConfirmacionContra());
        conf.jButtonYUp(190, -200, 5, 10, login.getBtnConfirmar());
        conf.jButtonYUp(190, -200, 5, 10, login.getBtnCancelarCon());
        conf.jLabelYUp(80, -200, 5, 10, login.getLblIcoUsu());
        conf.jLabelYUp(140, -200, 5, 10, login.getLblIconoCon());

    }

    public Personal datosPersonal(int cod) {
        pel.setPersonal_usuario(login.getTxtUserIngre().getText());
        pel.setPersonal_contra(login.getTxtContraseña().getText());
        pel.setPersona_codigo(cod);
        return pel;

    }

    public void guardarPersonal() {
        if (!plDB.verifiUser(conex, login.getTxtUserIngre().getText()).equals("")) {
            JOptionPane.showMessageDialog(null, "Nombre de usuario ya existe");
        } else {
            if (plDB.verifContra(conex, login.getTxtUserIngre().getText(), login.getTxtContraseña().getText()) == 0) {

                if (plDB.ingrePersonal(conex, datosPersonal(pDB.obtenerCod(login.getTxtCedula().getText())))) {
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
        try {
            pr.setPersona_fecha_nac(fechaBD(login.getJdcFechN().getDate().getTime()));
        } catch (Exception e) {
            System.out.println("ERROR ingreso FECHA " + e.getMessage());
        }
        //pr.setPersona_est_migr(login.getCmbPEstaMigra().getSelectedIndex());
        pr.setPersona_est_migr(1);
        pr.setPersona_estadocivil(login.getCmbPEstCivil().getSelectedIndex());
        pr.setPersona_sexo(sex);
        //pr.setPersona_nivel_acad(login.getCmbPNivelAcad().getSelectedIndex());
        pr.setPersona_nivel_acad(1);
        pr.setPersona_nacionalidad(login.getCmbPNacional().getSelectedIndex());
        //pr.setPersona_ocupacion(login.getCmbPOcup().getSelectedIndex());
        pr.setPersona_ocupacion(1);
        login.getTxtCedula().setText(login.getTxtIngPCedula().getText());
        return pr;
    }

    public void Verificar() {
//        if (login.getTxtConfirmacionUsu().getText().equals("maria") && login.getTxtConfirmacionContra().getText().equals("amor")) {
//            subirIngrePersonal();
//            Confirmar();
//        }
        int user = plDB.obtenerCod(conex, login.getTxtConfirmacionUsu().getText(), login.getTxtConfirmacionContra().getText());
        if (user != 0 && registroVerif(user)) {
            subirIngrePersonal();
            Confirmar();
        } else {
            JOptionPane.showMessageDialog(null, "Usuario o Contraseña incorrecta");
        }
    }

    public void guardarPersona() {

    }

    public void ingresarComboBox() {
        llenarCBXEstCivil();
        llenarCBXNaco();
    }

    public void llenarCBXNaco() {
        try {
            modelo = new DefaultComboBoxModel();
            Caracteristicas_violenciaDB ccc = new Caracteristicas_violenciaDB();
            ArrayList<Json_object_consulta> json;
            json = ccc.obtenerNacionalidades();
            modelo.addElement(login.getCmbPNacional().getModel().getElementAt(0));
            for (Json_object_consulta o : json) {
                modelo.addElement(o.getValor());
            }
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
            login.getCmbPEstCivil().setModel(modelo);
        } catch (ParseException ex) {
            System.out.println("Error al llenar Combo Estado civil " + ex.getMessage());
        }
    }

    public void perfil(String user, String pass) {
        switch (login.getCbxProfesiones().getSelectedIndex()) {
            case (0):
                dDB.setPersonal_codigo(plDB.obtenerCod(conex, user, pass));
                dDB.ingreDirectora(dDB);
                break;
            case (1):
                cDB.setPersonal_codigo(plDB.obtenerCod(conex, user, pass));
                eDB.ingreEducadora(conex, eDB);
                break;
            case (2):
                eDB.setPersonal_codigo(plDB.obtenerCod(conex, user, pass));
                eDB.ingreEducadora(conex, eDB);
                break;
            case (3):
                // legal

                adb.setPersonal_codigo(plDB.obtenerCod(conex, user, pass));
                adb.ingreAbogada(conex, adb);
                break;
            case (4):
                // Trabajo Social

                tsDB.setPersonal_codigo(plDB.obtenerCod(conex, user, pass));
                tsDB.ingreTrabSocial(conex, tsDB);
                break;
            case (5):
                //psicologia

                psdb.setPersonal_cod(plDB.obtenerCod(conex, user, pass));
                psdb.ingrePsicologo(psdb);
                break;
            default:
                System.out.println("no encontrada");
        }
    }

    // metodo para verficar el usuario que ingresa a registrar
    public boolean registroVerif(int cod) {
        boolean direc = true;
        int cPerfil;
        cPerfil = adb.verifiUserA(conex, cod);
        if (cPerfil != 0) {
            // abogada
            direc = false;
        } else {
            cPerfil = tsDB.verifiUserT(conex, cod);
            if (cPerfil != 0) {
                // tranajo social 
                direc = false;
            } else {
                cPerfil = psdb.verifiUserP(cod);
                if (cPerfil != 0) {
                    // psicologa
                    direc = false;
                } else {
                    // Eduacdora
                    cPerfil = eDB.verifiUserE(conex, cod);
                    if (cPerfil != 0) {
                        direc = false;
                    } else {
                        cPerfil = cDB.verifiUserC(cod);
                        if (cPerfil != 0) {
                            direc = true;
                        } else {
                            cPerfil = dDB.verifiUserD(cod);
                            if (cPerfil != 0) {
                                direc = true;
                            } else {
                                System.out.println("no puede ingresar");
                            }
                        }
                    }
                }
            }
        }
        return direc;
    }
}
