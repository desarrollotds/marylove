package marylove.controlador;

import java.util.Calendar;
import java.util.GregorianCalendar;
import marylove.DBmodelo.Plan_deRecursosDB;
import marylove.DBmodelo.psicologoDB;
import marylove.conexion.Conexion;
import marylove.vista.VistaPlanRecursos;

/**
 *
 * @author USUARIO
 */
public class ControladordeRecursos extends Validaciones {
    
    private Conexion conex;
    psicologoDB pDB = new psicologoDB();
    private final VistaPlanRecursos vista;
    private final Plan_deRecursosDB modelo;

    public ControladordeRecursos(VistaPlanRecursos vista, Plan_deRecursosDB modelo) {
        this.vista = vista;
        this.modelo = modelo;
    }
    public void iniciarControlRecursos(){
        vista.getTxtNombre().addKeyListener(validarLetras(vista.getTxtNombre()));
        vista.getTxtCodigovictima().addKeyListener(validarNumeros(vista.getTxtCodigovictima()));
        vista.getTxtCedula().addKeyListener(validarCedula(vista.getTxtCedula()));
        
        
        Calendar c2 = new GregorianCalendar();
        vista.getDatFechaPlanRecursos().setCalendar(c2);
    }
    
    public void insertarDatosRecursos(){
        
    }
    
    public void borrarDatos(){
        
    }
}
