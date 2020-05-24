/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package marylove.DBmodelo;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import marylove.conexion.ConexionHi;

import marylove.models.Padre;
import marylove.vista.FichaAnamnesis;

/**
 *
 * @author Usuario
 */
public class PadreDB extends Padre {

     ResultSet re = null;
    int cod = 0;

    ConexionHi conectar = new ConexionHi();

    //METODOS DE LA FICHA ANAMNESIS----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
    //1.2 DATOS DE LA MADRE Y PADRE
    public boolean actualizacionDatosPadreMadre(int persona_codigo) {
        String sql = "UPDATE persona SET"
                + " persona_nombre = '" + getPersona_fecha_nac() + "'"
                + ", persona_apellido = '" + getPersona_apellido() + "'"
                + ", persona_nacionalidad = " + getPersona_nacionalidad() + ""
                + "WHERE persona_codigo = " + persona_codigo;

        if (conectar.noQuery(sql) == true) {
            System.out.println("1.2 Se actualizaron los datos del padre (Ubicación de método: PadreDB)");
            return true;
        } else {
            System.out.println("Error 1.2 No se pudo actualizar los datos del padre (Ubicación del método: PadreDB)");
            return false;
        }
    }

    public void PadreAnamnesis(Padre p) {
        String sql = "select  p.persona_nombre, p.persona_apellido,p.persona_nacionalidad, Extract(year from age( current_date , p.persona_fecha_nac)) from padre pa join persona p using (persona_codigo) join hijos h using (padre_id) where h.hijo_codigo=" + FichaAnamnesis.txtCodigo.getText() + ";";
        System.out.println(sql);
        try {
            re = conectar.query(sql);
            while (re.next()) {
                System.out.println("hollllll");
                p.setPersona_nombre(re.getString(1));
                p.setPersona_apellido(re.getString(2));
                p.setPersona_nacionalidad(re.getInt(3));
                p.setEdad(Integer.parseInt(String.valueOf(re.getString(4))));
            }
            System.out.println(p.getEdad());
        } catch (SQLException ex) {
            Logger.getLogger(PadreDB.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
