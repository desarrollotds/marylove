package marylove.DBmodelo;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import marylove.conexion.ConexionHi;
import marylove.models.Hijos;

public class HijosDB extends Hijos {

    public static int codigopersona = 0;
    private ConexionHi conn;
    private String sql = "";
    PreparedStatement ps;
    ResultSet re;

    public HijosDB() {
    }

    public boolean agregarPrsonaHijo() throws SQLException {
        conn = new ConexionHi();
        sql = "INSERT INTO public.persona( persona_cedula, persona_nombre, persona_apellido,"
                + " persona_fecha_nac, persona_nivel_acad, persona_estado_actual, persona_sexo"
                + " )VALUES ( '" + getPersona_cedula() + "', "
                + "'" + getPersona_nombre() + "', '" + getPersona_apellido() + "', '" + getPersona_fecha_nac() + "', "
                + ", " + getPersona_nivel_acad() + ", 'true','" + getPersona_sexo() + "')returning persona_codigo;";
        ps = conn.getConnection().prepareStatement(sql);
        re = ps.executeQuery();
        conn.CerrarConexion();
        while (re.next()) {
            codigopersona = re.getInt(1);
        }
        return true;

    }

    public boolean insetarHijo() {
        conn= new ConexionHi();
        sql="";
    return true;
                }

}
