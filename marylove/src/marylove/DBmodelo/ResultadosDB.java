/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package marylove.DBmodelo;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import marylove.conexion.ConexionHi;
import marylove.models.Resultados;
import marylove.vista.VistaResultados;

/**
 *
 * @author usuario
 */
public class ResultadosDB  extends Resultados{
     private static ArrayList<Resultados> listaPersona = new ArrayList<>();
     private ConexionHi conectar = new ConexionHi();
    public ResultadosDB(String nombre, String tipo, String total) {
        super(nombre, tipo, total);
    }

    public static ArrayList<Resultados> getListaPersona() {
        return listaPersona;
    }

    public static void setListaPersona(ArrayList<Resultados> listaPersona) {
        ResultadosDB.listaPersona = listaPersona;
    }

   
    
    public ResultadosDB() {
      
    }
    
    public ArrayList<Resultados> ListarResultados(VistaResultados vista){
         try {
             String SQL_SELECT = "select  p.persona_nombre ||' '||p.persona_apellido,\n"
                     + "(CASE\n"
                     + " WHEN  e.enc_tipo =1 THEN 'Formulario de Riesgo (EPV-R)'\n"
                     + " WHEN  e.enc_tipo =2 THEN 'Escala evaluación de riesgos de violencia'\n"
                     + " WHEN  e.enc_tipo =3 THEN 'Escala evaluación de nivel de crisis de riesgo'\n"
                     + " END) AS \"Tipo de Encuesta\" ,\n"
                     + " e.total \n"
                     + " from persona p\n"
                     + "join victima v\n"
                     + "on v.persona_codigo=p.persona_codigo\n"
                     + "join escala_prevencion_riesgos epr\n"
                     + "on epr.victima_codigo=v.victima_codigo\n"
                     + "join encuesta e\n"
                     + "on e.epr_codigo=epr.epr_codigo\n"
                     + "where persona_cedula='" + vista.getTxtCedula().getText() + "'";
             
             ResultSet rs = conectar.query(SQL_SELECT);
             
             while (rs.next()) {
               Resultados resultados = new Resultados(rs.getString(1),rs.getString(2),rs.getString(3));
               listaPersona.add(resultados);
             }} catch (SQLException ex) {
             Logger.getLogger(ResultadosDB.class.getName()).log(Level.SEVERE, null, ex);
         }
         return listaPersona;
    }
    
    
    
    
}
