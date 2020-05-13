/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package marylove.controlador;

import marylove.DBmodelo.FichaAnamnesisBD;
import marylove.DBmodelo.HijosDB;
import marylove.DBmodelo.NacimientoDB;
import marylove.conexion.Conexion;
import marylove.vista.FichaAnamnesis;

/**
 *
 * @author Usuario
 */
public class ControladorFichaAnamnesis extends Validaciones{
    private Conexion con = new Conexion();
    private FichaAnamnesisBD modeloFichaAnamnesisBD;
    private FichaAnamnesis vistaAnamnesis;

    public ControladorFichaAnamnesis() {
    }
    
    public void inciarComponenetes(){
        
    }
    
    public void datosIdentificacion(){
       HijosDB modeloHijosDB = new HijosDB();
        modeloHijosDB.setPersona_fecha_nac(fechaBD(vistaAnamnesis.getJdcFechaNacimientoNNA().getDate().getTime()));
        modeloHijosDB.setPersona_nacionalidad(0);//INGRESAREMOS EL ID DE LA NACIONALIDAD QUE EXISTE EN EL JSON DE NACIONALIDADES

        NacimientoDB modeloNacimientoDB = new NacimientoDB();
        modeloNacimientoDB.setLugar_nacimiento(vistaAnamnesis.getTxtLugarNacNNA1().getText());
    }
}
