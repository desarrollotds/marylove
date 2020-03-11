package marylove.DBmodelo;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import marylove.conexion.ConexionHi;
import marylove.models.Hijos;

public class HijosDB extends Hijos {
    //VARIABLES STATIC
     public static List<HijosDB> arrayHijos=new ArrayList<>();
     
     //variabñes DB
    public static int codigopersona = 0;
    private ConexionHi conn;
    private String sql = "";
    PreparedStatement ps;
    ResultSet re;

    public HijosDB(int persona_codigo, int victima_codigo, String hijo_anioescolar, int institucion_codigo, String persona_cedula, String persona_nombre, String persona_apellido, Date persona_fecha_nac, char persona_sexo) {
        super(persona_codigo, victima_codigo, hijo_anioescolar, institucion_codigo, persona_cedula, persona_nombre, persona_apellido, persona_fecha_nac, persona_sexo);
    }
  public HijosDB(String persona_cedula, String persona_nombre, String persona_apellido, Date persona_fecha_nac, char persona_sexo) {
        super(persona_cedula, persona_nombre, persona_apellido, persona_fecha_nac, persona_sexo);
    }
     public HijosDB() {
    }
    
    

    public boolean agregarPrsonaHijo() throws SQLException {
        conn = new ConexionHi();
        sql = "INSERT INTO public.persona( persona_cedula, persona_nombre, persona_apellido,"
                + " persona_fecha_nac, persona_nivel_acad, persona_estado_actual, persona_sexo"
                + " )VALUES ( '" + getPersona_cedula() + "', "
                + "'" + getPersona_nombre() + "', '" + getPersona_apellido() + "', '" + getPersona_fecha_nac() + "', "
                + ", " + getPersona_nivel_acad() + ", 'true','" + getPersona_sexo() + "') returning persona_codigo;";
        ps = conn.getConnection().prepareStatement(sql);
        re = ps.executeQuery();
        conn.CerrarConexion();
        while (re.next()) {
            codigopersona = re.getInt(1);
        }
        return true;

    }

    public boolean insetarHijo() throws SQLException {

        conn = new ConexionHi();

        sql = "INSERT INTO public.persona( persona_codigo, victima_codigo, hijo_anioescolar "
                + " )VALUES (" + codigopersona + ", " + marylove.DBmodelo.victimaDB.codigo_victima + "," + getHijo_anioescolar();
        ps = conn.getConnection().prepareStatement(sql);
        ps.execute();
        conn.CerrarConexion();
        return true;
    }
     public boolean consultaHijosVictimas(){
        try {
             conn = new ConexionHi();
        sql="select p.persona_cedula, p.persona_nombre, p.persona_apellido, p.persona_sexo, p.persona_fecha_nac from persona p,  hijos h where h.victima_codigo="+marylove.DBmodelo.victimaDB.codigo_victima+" and h.persona_codigo=p.persona_codigo ";
        ps = conn.getConnection().prepareStatement(sql);
        re = ps.executeQuery();
        conn.CerrarConexion();
        HijosDB hijos;
        while (re.next()) {
            hijos =new HijosDB();
            hijos.setPersona_cedula(re.getString(1));
            hijos.setPersona_nombre(re.getString(2));
            hijos.setPersona_apellido(re.getString(3));
            hijos.setPersona_sexo(re.getString(4).charAt(0));
            hijos.setPersona_fecha_nac(re.getDate(5));
            arrayHijos.add(hijos);
            
        }
        } catch (Exception e) {
            e.getStackTrace();
        }
       
        return true;
    }

}
