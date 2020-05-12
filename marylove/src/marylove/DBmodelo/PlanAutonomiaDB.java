/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package marylove.DBmodelo;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import marylove.conexion.Conexion;
import marylove.models.HistorialClinico;
import marylove.models.Plan_Autonomia;

/**
 *
 * @author vasquez
 */
public class PlanAutonomiaDB extends Plan_Autonomia{
    
    PreparedStatement ps;
    ResultSet re = null;
    
    Conexion con = new Conexion();

    public PlanAutonomiaDB() {
    }

    public PlanAutonomiaDB(int autonomia_codigo, int codigo_victima, String fecha_elaboacion, String proceso_evalua, String autonomia_econo, String estabilidad_salud, String procesos_educativos, String factor_riesgo, String redes_seguras, String fecha_egreso, int persona_codigo) {
        super(autonomia_codigo, codigo_victima, fecha_elaboacion, proceso_evalua, autonomia_econo, estabilidad_salud, procesos_educativos, factor_riesgo, redes_seguras, fecha_egreso, persona_codigo);
    }

    
    
    public boolean ingresarPAutonomia(Plan_Autonomia pau){
        boolean ingre=true;
        try {
            String sql = "INSERT INTO public.plan_autonomia (victima_codigo, "
                    + "fecha_elaboracion, procesoevalucion, autonomiaeconomica, estabilidadsaludfym, procesoseducativos,"
                    +" redesseguras, factorriesgo, fecha_egreso, personal_codigo"
                    + " VALUES (" + pau.getCodigo_victima() + ","+pau.getFecha_elaboacion()
                    + ",'" + pau.getProceso_evalua() + "','" + pau.getAutonomia_econo() + "','"+pau.getEstabilidad_salud()
                    + "','"+ pau.getProcesos_educativos() +"','"+pau.getRedes_seguras()
                    +"','"+pau.getFactor_riesgo()+"', "+pau.getFecha_egreso()+", "+pau.getPersona_codigo()+" );";
            ps = con.conectarBD().prepareStatement(sql);
            ps.execute();
            ingre = true;

        } catch (SQLException ex) {
            System.out.println("ERROR al ingresar Plan de autonomia: "+ex.getMessage());
            ingre = false;
        }
        con.cerrarConexion();
        return ingre; 
    }
    
    public Plan_Autonomia obtenetDatos(int ced){
        Plan_Autonomia plan = new Plan_Autonomia();
        try {
            String sql = "select * from plan_autonomia where victima_codigo = '"+ced+"';";
            ps = con.conectarBD().prepareStatement(sql);
            re = ps.executeQuery();
            while (re.next()) {
                plan.setCodigo_victima(re.getInt(1));
                plan.setFecha_elaboacion(obtenerFecha(re.getDate(2)));
                plan.setProceso_evalua(re.getString(3));
                plan.setAutonomia_econo(re.getString(4));
                plan.setEstabilidad_salud(re.getString(5));
                plan.setProcesos_educativos(re.getString(6));
                plan.setRedes_seguras(re.getString(7));
                plan.setFactor_riesgo(re.getString(8));
                plan.setFecha_egreso(obtenerFecha(re.getDate(9)));
            }
        } catch (SQLException ex) {
            System.out.println("error al obtener datos del plan de autonomia "+ex.getMessage());
        }
        con.cerrarConexion();
        return plan;
    }
    
    public boolean actualizar(Plan_Autonomia pa) {
        try {
            String sql = "UPDATE plan_autonomia SET ";
            sql += "fecha_elaboracion = " + pa.getFecha_elaboacion() + " , ";
            sql += "procesoevalucion = '" + pa.getProceso_evalua() + "', ";
            sql += "autonomiaeconomica = '" + pa.getAutonomia_econo() + "', ";
            sql += "estabilidadsaludfym = '" + pa.getEstabilidad_salud() + "', ";
            sql += "procesoseducativos = '" + pa.getProcesos_educativos() + "', ";
            sql += "redesseguras = '" + pa.getRedes_seguras() + "', ";
            sql += "factorriesgo = '" + pa.getFactor_riesgo() + "', ";
            sql += "fecha_egreso = " + pa.getFecha_egreso() + " , ";
            sql += "personal_codigo = '" + pa.getPersona_codigo() + "', ";
            sql += "WHERE victima_codigo = " + pa.getCodigo_victima() + ";";
            ps = con.conectarBD().prepareStatement(sql);
            ps.execute();
            con.cerrarConexion();
            return true;
        } catch (SQLException ex) {
            System.out.println("Error al editar Plan de autonomia " + ex.getMessage());
            con.cerrarConexion();
            return false;
        }
    }
    public String obtenerFecha(Date fech) {
        String fecha2 = "";
        SimpleDateFormat NFormat = new SimpleDateFormat("yyyy/MM/dd");
        fecha2 = NFormat.format(fech);
        return fecha2;
    }
}
