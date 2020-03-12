package marylove.controlador;

import java.util.Calendar;
import java.util.GregorianCalendar;
import marylove.DBmodelo.Plan_devidaDB;
import marylove.vista.FichaPlandeVida;

/**
 *
 * @author USUARIO
 */
public class ControladorPlandeVida extends Validaciones{

    private final FichaPlandeVida vista;
    private final Plan_devidaDB modelo;

    public ControladorPlandeVida(FichaPlandeVida vista, Plan_devidaDB modelo) {
        this.vista = vista;
        this.modelo = modelo;
    }

    public void iniciarControl() {
        vista.getTxtNombre().addKeyListener(validarLetras(vista.getTxtNombre()));
        vista.getTxtCodigo().addKeyListener(validarNumeros(vista.getTxtCodigo()));
        vista.getTxtCedula().addKeyListener(validarCedula(vista.getTxtCedula()));
        vista.getTxtCedula().addKeyListener(enter1(vista.getTxtCedula(), vista.getTxtNombre(), vista.getTxtCodigo()));
        Calendar c2 = new GregorianCalendar();
        vista.getDtcFecha().setCalendar(c2);
    }
    public void insertaDatos() {
        
        
    }
    public void borrarDatos() {
        
    }
}
