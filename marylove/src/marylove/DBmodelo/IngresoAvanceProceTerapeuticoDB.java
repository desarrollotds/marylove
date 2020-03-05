/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package marylove.DBmodelo;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import marylove.conexion.Conexion;
import marylove.models.IngresoAvanceProceTeraputico;
import marylove.vista.IngresoAvancesProcesoTerapeutico;

/**
 *
 * @author LENOVO
 */
public class IngresoAvanceProceTerapeuticoDB extends IngresoAvanceProceTeraputico{
    PreparedStatement ps;
    ResultSet re = null;
    Conexion conectar = new Conexion();

    public IngresoAvanceProceTerapeuticoDB() {
    }

    public IngresoAvanceProceTerapeuticoDB(int avances_codigo, int plan_at_codigo, String avancesFecha, String avances_situacion, String avances_intervencion) {
        super(avances_codigo, plan_at_codigo, avancesFecha, avances_situacion, avances_intervencion);
    }

     public boolean insetarAvance(){
         boolean ingreso=true;
         try {
             String sql="INSERT INTO avances_terapeuticos (avances_fecha, avances_situacion, avances_situacion)"
                     + "VALUES"
                     + "('"+getAvancesFecha()+"','"+getAvances_situacion()+"','"+getAvances_intervencion()+"')";
             ps=conectar.conectarBD().prepareStatement(sql);
             ps.execute();
             ingreso=false;
         } catch (SQLException ex) {
             System.out.println("Error: "+ex.getMessage());
             ingreso=false;
         }
         conectar.cerrarConexion();
         return ingreso;
     }
}
