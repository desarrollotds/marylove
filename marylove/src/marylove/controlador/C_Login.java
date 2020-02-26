package marylove.controlador;

import AppPackage.AnimationClass;
import javax.swing.JOptionPane;
import marylove.DBmodelo.personaDB;
import marylove.DBmodelo.personalDB;
import marylove.conexion.Conexion;
import marylove.models.Persona;
import marylove.models.Personal;
import marylove.vista.V_Login;
import marylove.vista.V_Menu;

public class C_Login {

    private V_Login login;
    private V_Menu vistaPrincipal;
    private Personal pel;
    private Persona pr;
    private personaDB pDB;
    private personalDB plDB;
    private Conexion conex;

    public C_Login(V_Login login, V_Menu vistaPrincipal, Personal pel, Persona pr, personaDB pDB, personalDB plDB, Conexion conex) {
        this.login = login;
        this.vistaPrincipal = vistaPrincipal;
        this.pel = pel;
        this.pr = pr;
        this.pDB = pDB;
        this.plDB = plDB;
        this.conex = conex;
        login.setVisible(true);
    }

    public void iniciaControl() {
        login.getBtnIngraso().addActionListener(e -> ingreso());
        login.getBtnConfirmar().addActionListener(e -> Verificar());
        login.getBtnGuardar().addActionListener(e -> Guardar());
        login.getBtnAtras().addActionListener(e -> Atras());
        login.getBtnRegistrar().addActionListener(e -> Registrar());
        login.getBtnEntrar().addActionListener(e -> entrar());
        login.getBtnCancelarCon().addActionListener(e -> cancelar());
    }

    public void entrar() {
        if (login.getTxtUsuario().getText().equals("mariaamor") && login.getPswContra().getText().equals("123")) {
            vistaPrincipal.setVisible(true);
            login.setVisible(false);
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
        imagen.jLabelXLeft(1200, 840, 10, 5, login.getLblNuevoUsuairo());
        imagen.jLabelXLeft(1200, 780, 10, 5, login.getLblNombre());
        imagen.jLabelXLeft(1200, 780, 10, 5, login.getLblCedula());
        imagen.jLabelXLeft(1200, 780, 10, 5, login.getLblProfesion());
        imagen.jLabelXLeft(1200, 780, 10, 5, login.getLblContraseña());
        imagen.jTextFieldXLeft(1200, 780, 10, 5, login.getTxtNombre());
        imagen.jTextFieldXLeft(1200, 780, 10, 5, login.getTxtCedula());
//        imagen.jTextFieldXLeft(1200, 780, 10, 5, login.getTxtProfesion());
        Animacion.Animacion.mover_izquierda(1200, 780, 10, 5, login.getCbxProfeciones());
        imagen.jTextFieldXLeft(1200, 780, 10, 5, login.getTxtContraseña());
        imagen.jButtonXLeft(1200, 770, 10, 5, login.getBtnGuardar());
        imagen.jButtonXLeft(1200, 900, 10, 5, login.getBtnAtras());
    }

    public void Verificar() {
        if (login.getTxtConfirmacionUsu().getText().equalsIgnoreCase("maria") && login.getTxtConfirmacionContra().getText().equalsIgnoreCase("amor")) {
            Confirmar();
        } else {
            System.out.println("ERROR");

        }
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
        Animacion.Animacion.mover_derecha(780, 1200, 10, 5, login.getCbxProfeciones());
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
        Animacion.Animacion.mover_derecha(780, 1200, 10, 5, login.getCbxProfeciones());
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

    public void datosPersonal(int cod) {
        pel.setPersonal_usuario(login.getTxtUserIngre().getText());
        pel.setPersonal_contra(login.getTxtContraseña().getText());
        pel.setPersona_codigo(cod);

    }

    public void datosPersona() {
        if (pDB.verifiCed(conex, login.getTxtCedula().getText())) {
            JOptionPane.showMessageDialog(null, "Debe Ingresar a la Persona");
            login.getDlgIPersonal().setVisible(true);
            login.setTxtIngPCedula(login.getTxtCedula());
            pr.setPersona_nombre(login.getTxtIngPNombre().getText());
            pr.setPersona_apellido(login.getTxtIngPApellido().getText());
            pr.setPersona_cedula(login.getTxtIngPCedula().getText());
            pr.setPersona_celular(login.getTxtPCel().getText());
            pr.setPersona_telefono(login.getTxtPTelef().getText());
            pr.setPersona_fecha_nac(login.getJdcFechN().getDateFormatString());
        } else {

        }
    }

}
