/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package marylove.DBmodelo;

import marylove.conexion.ConexionHi;
import marylove.models.Padre;

/**
 *
 * @author Usuario
 */
public class PadreDB extends Padre {

    ConexionHi conectar = new ConexionHi();

    //METODOS DE LA FICHA ANAMNESIS----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
    //1.2 DATOS DE LA MADRE Y PADRE
    public boolean actualizacionDatosPadreMadre() {
        String sql = "UPDATE persona SET"
                + " persona_nombre = '" + getPersona_fecha_nac() + "'"
                + ", persona_apellido = '"+getPersona_apellido()+"'"
                + ", persona_nacionalidad = " + getPersona_nacionalidad() + ""
                + "WHERE persona_codigo = " + getPersona_codigo();

        if (conectar.noQuery(sql) == null) {
            System.out.println("1.2 Se actualizaron los datos del padre (Ubicación de método: PadreDB)");
            return true;
        } else {
            System.out.println("Error 1.2 No se pudo actualizar los datos del padre (Ubicación del método: PadreDB)");
            return false;
        }
    }
}
