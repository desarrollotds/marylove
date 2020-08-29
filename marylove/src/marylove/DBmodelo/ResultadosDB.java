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
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import marylove.conexion.ConexionHi;
import marylove.models.Resultados;
import marylove.vista.VistaResultados;

/**
 *
 * @author usuario
 */
public class ResultadosDB extends Resultados {

    private ConexionHi conectar = new ConexionHi();
    private boolean validacion;
    private boolean validacion_resultados;

    public ResultadosDB(String nombre, String tipo, String total) {
        super(nombre, tipo, total);
    }

  
    
    public ResultadosDB() {

    }

    public DefaultTableModel ListarResultados(String cedula) {
        DefaultTableModel model = new DefaultTableModel();
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
                    + "where persona_cedula='" + cedula + "'";

            ResultSet rs = conectar.query(SQL_SELECT);
              model.setColumnIdentifiers(new Object[]{"Compañera", "Tipo de Encuesta", "Total"});
            validacion_resultados = false;
            while (rs.next()) {
                   validacion_resultados = true;
                model.addRow(new Object[]{rs.getString(1), rs.getString(2), rs.getString(3)});
            }
        } catch (SQLException ex) {
            Logger.getLogger(ResultadosDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return model;
      
    }

    public void ObtenerRegistro(String cedula, int tipoficha) {
        try {
            String SQL_SELECT = "select  p.persona_nombre ||' '||p.persona_apellido,e.enc_tipo, e.total\n"
                    + "from persona p\n"
                    + "join victima v\n"
                    + "on v.persona_codigo=p.persona_codigo\n"
                    + "join escala_prevencion_riesgos epr\n"
                    + "on epr.victima_codigo=v.victima_codigo\n"
                    + "join encuesta e\n"
                    + "on e.epr_codigo=epr.epr_codigo\n"
                    + "where p.persona_cedula='" + cedula + "'\n"
                    + "and e.enc_tipo=" + tipoficha;
            validacion = false;
            ResultSet rs = conectar.query(SQL_SELECT);
            while (rs.next()) {
                validacion = true;
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Surgió un error", "Información", JOptionPane.ERROR_MESSAGE);
        }

    }

    public boolean isValidacion() {
        return validacion;
    }

    public void setValidacion(boolean validacion) {
        this.validacion = validacion;
    }

    public boolean isValidacion_resultados() {
        return validacion_resultados;
    }

    public void setValidacion_resultados(boolean validacion_resultados) {
        this.validacion_resultados = validacion_resultados;
    }
    

}
