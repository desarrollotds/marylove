package marylove.controlador;

import java.util.Calendar;
import java.util.GregorianCalendar;
import marylove.DBmodelo.Plan_devidaDB;
import marylove.conexion.Conexion;
import marylove.vista.FichaPlandeVida;

/**
 *
 * @author USUARIO
 */
public class ControladorPlandeVida {

    private final FichaPlandeVida vista;
    private final Plan_devidaDB modelo;
    
    Conexion conex = new Conexion();

    public ControladorPlandeVida(FichaPlandeVida vista, Plan_devidaDB modelo) {
        this.vista = vista;
        this.modelo = modelo;
//        this.vista.setVisible(true);
    }

    public void iniciarControl() {

        Calendar c2 = new GregorianCalendar();
        vista.getDtcFech_elaboracion().setCalendar(c2);
    }
    public void insertaDatos() {
        
    }
    public void borrarDatos() {
        
    }
}
