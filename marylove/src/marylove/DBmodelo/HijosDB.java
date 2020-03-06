
package marylove.DBmodelo;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import marylove.conexion.Conexion;
import marylove.models.Hijos;
import marylove.models.Ingreso;
import marylove.models.Persona;

public class HijosDB extends Hijos {
    private Conexion conectar;

    public HijosDB() {
    }

    public HijosDB(int persona_codigo, int hijo_codigo, int victima_codigo, int institucion_codigo, String hijo_anioescolar, String hijo_estado, int padre_id, boolean padre_agresor, String hijo_estado_ingreso) {
        super(persona_codigo, hijo_codigo, victima_codigo, institucion_codigo, hijo_anioescolar, hijo_estado, padre_id, padre_agresor, hijo_estado_ingreso);
    }
   

    
    
}
