package marylove.controlador;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import marylove.DBmodelo.CoordinadoraDB;
import marylove.DBmodelo.DirectoraDB;
import marylove.DBmodelo.EducadoraDB;
import marylove.DBmodelo.HistorialClinicoDB;
import marylove.DBmodelo.PlanEmergente2DB;
import marylove.DBmodelo.PlanEmergenteDB;
import marylove.DBmodelo.Trabajo_SocialDB;
import marylove.DBmodelo.abogadaDB;
import marylove.DBmodelo.psicologoDB;
import static marylove.controlador.C_Login.personal_cod;
import marylove.models.HistorialClinico;
import marylove.models.Persona;
import marylove.models.PlanEmergente;
import marylove.models.PlanEmergenteItem;
import marylove.vista.FichaHistoriaClinica;
import static marylove.vista.Ficharegistroyreferencia.txtCedula;
import marylove.vista.VistaPlanEmergente;

public class ControladorPlanEmergente extends Validaciones {

    private VistaPlanEmergente vista;
    private PlanEmergenteDB modeloDB;
    private PlanEmergente2DB modeloDB2;
    C_Login login;

    Calendar cal = new GregorianCalendar();

    static int codigoPlan;

    public ControladorPlanEmergente(VistaPlanEmergente vista, PlanEmergenteDB modeloDB, PlanEmergente2DB modeloDB2) throws Exception {
        this.vista = vista;
        this.modeloDB = modeloDB;
        this.modeloDB2 = modeloDB2;
    }

    public void vistaver() {
        vista.setVisible(true);
        vista.setLocationRelativeTo(null);
    }

    public void iniciarControlador() {
        GuardarTxtArea();
        limpiarPlan();
        vistaver();
        obtenerFechaSistema();
        vista.getTxtCedula().addKeyListener(enter1(vista.getTxtCedula(), vista.getTxtNombrePlanEmergente(), vista.getTxtCodigoPlanEmergente()));
        vista.getBntGuardarPlanEmergente().addActionListener(e -> {
            try {
                datoso();
            } catch (SQLException ex) {
                Logger.getLogger(ControladorPlanEmergente.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
        vista.getBntLimpiar().addActionListener(e -> limpiarPlan());
       vista.getBntCancelar().addActionListener(e->limpiarTodo());
        vista.getTxtCodigoPersonal().setText("" + personal_cod);
        vista.setIconImage(new ImageIcon(getClass().getResource("/iconos/icono1.png")).getImage());

    }

    public void GuardarTxtArea() {
        controlArea(vista.getTxtAIPsicologia());
        controlArea(vista.getTxtACCIInfantoJuvenil());
        controlArea(vista.getTxtACCILegal());
        controlArea(vista.getTxtACCITrabajoSocial());
        controlArea(vista.getTxtAIInfantoJuvenil());
        controlArea(vista.getTxtAILegal());
        controlArea(vista.getTxtAIPsicologia());
        controlArea(vista.getTxtAITrabajoSocial());

    }

    public void datoso() throws SQLException {
//modeloDB.maxID1(Integer.parseInt(vista.getTxtCodigoPlanEmergente().getText()));
        try {
            modeloDB2.obtenetSelect(Integer.parseInt(vista.getTxtCodigoPlanEmergente().getText()));
        modeloDB2.setVictima_codigo(Integer.parseInt(vista.getTxtCodigoPlanEmergente().getText()));
        modeloDB2.setPersonal_codigo(personal_cod);
        modeloDB.setApreciacioninicial(vista.getTxtAIPsicologia().getText());
        modeloDB.setApreciacioninicial1(vista.getTxtAITrabajoSocial().getText());
        modeloDB.setApreciacioninicial2(vista.getTxtAILegal().getText());
        modeloDB.setApreciacioninicial3(vista.getTxtAIInfantoJuvenil().getText());

        //////////////////////////////////////////////////////////////////////////////
        modeloDB.setAccionesinmediatas(vista.getTxtACCIPsicologia().getText());
        modeloDB.setAccionesinmediatas1(vista.getTxtACCITrabajoSocial().getText());
        modeloDB.setAccionesinmediatas2(vista.getTxtACCILegal().getText());
        modeloDB.setAccionesinmediatas3(vista.getTxtACCIInfantoJuvenil().getText());
        /////////////////////////////////////////////////////////////////////////
        modeloDB2.setEmergente_fecha(obtenerFecha(vista.getjDateFechaPlanEmergente()));
        modeloDB.setItem_fecha1(obtenerFecha(vista.getjDateTrabajoSocial()));
        modeloDB.setItem_fecha3(obtenerFecha(vista.getjDateInfantoJuvenil()));
        modeloDB.setItem_fecha2(obtenerFecha(vista.getjDateLegal()));
        modeloDB.setItem_fecha(obtenerFecha(vista.getjDatePsicologia()));
        /////////////////////////////////////////////////////////////////////////

        if (modeloDB.ingresarPSI() && modeloDB.ingresarTRA() && modeloDB.ingresarLEG() && modeloDB.ingresarINFA() && modeloDB2.ingresarPlan2()) {
            JOptionPane.showMessageDialog(null, "DATOS GUARDADOS CORRECTAMENTE");
        } else {
            JOptionPane.showMessageDialog(null, "ERROR.........");
        }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "No se guardaron los datos \nVerfique los campos.Pueden existir campos vacios", "Información", JOptionPane.WARNING_MESSAGE);
        }

    }

//        
    public void obtenerFechaSistema() {
        vista.getjDatePsicologia().setCalendar(cal);
        vista.getjDateFechaPlanEmergente().setCalendar(cal);
        vista.getjDateInfantoJuvenil().setCalendar(cal);
        vista.getjDateTrabajoSocial().setCalendar(cal);
        vista.getjDateLegal().setCalendar(cal);

    }

    public void limpiarPlan() {

        vista.getTxtACCIInfantoJuvenil().setText("");
        vista.getTxtACCILegal().setText("");
        vista.getTxtACCIPsicologia().setText("");
        vista.getTxtACCITrabajoSocial().setText("");
        vista.getTxtAIInfantoJuvenil().setText("");
        vista.getTxtAILegal().setText("");
        vista.getTxtAIPsicologia().setText("");
        vista.getTxtAITrabajoSocial().setText("");
        vista.getjDateFechaPlanEmergente().setCalendar(cal);
        vista.getjDateInfantoJuvenil().setCalendar(cal);
        vista.getjDateLegal().setCalendar(cal);
        vista.getjDatePsicologia().setCalendar(cal);
        vista.getjDateTrabajoSocial().setCalendar(cal);

    }
    public void limpiarTodo(){
        limpiarPlan();
        vista.getTxtCedula().setText("");
        vista.getTxtNombrePlanEmergente().setText("");
        vista.getTxtCodigoPlanEmergente().setText("");
    }


}
