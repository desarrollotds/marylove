/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package marylove.controlador;

import java.sql.ResultSet;
import javax.swing.table.DefaultTableModel;
import marylove.DBmodelo.BitacoraDB;
import marylove.conexion.ConexionHi;

/**
 *
 * @author usuario
 */
public class SentenciasSelect {

      private ConexionHi conn = new ConexionHi();
   
    ExportarExcel excel = new ExportarExcel();
     DefaultTableModel modelo= new DefaultTableModel();

    public SentenciasSelect() {
    }
    
    //METODO PARA OBTENER LOS VALORES DEL REPORTE GENERAL
    public DefaultTableModel ReporteGeneral(){
        
        String sql= "SELECT\n"
                    + " p.persona_nombre||' '|| p.persona_apellido AS \"Compañera\",\n"
                    + " (CASE\n"
                    + " WHEN  i.ingreso_fecha  IS NULL THEN ''\n"
                    + " ELSE i.ingreso_fecha||''\n"
                    + " END) AS \"Fecha Ingreso\" ,\n"
                    + " (CASE\n"
                    + " WHEN  e.egreso_fecha  IS NULL THEN ''\n"
                    + " ELSE e.egreso_fecha||''\n"
                    + " END) AS \"Fecha Egreso\" ,\n"
                    + " (select par_valores->xra.parentesco->>'valor' from parametros where par_id = 9) AS \"Agresor\",\n"
                    + " (select par_valores->p.persona_nacionalidad->>'valor' from parametros where par_id = 3) AS \"Nacionalidad\",\n"
                    + " (CASE\n"
                    + " WHEN d.dir_provincia  IS NULL THEN ''\n"
                    + " ELSE d.dir_provincia||''\n"
                    + " END) AS \"Provincia\" ,\n"
                    + " (CASE\n"
                    + " WHEN d.dir_ciudad  IS NULL THEN ''\n"
                    + " ELSE d.dir_ciudad||''\n"
                    + " END) AS \"Ciudad\" ,\n"
                    + " (CASE\n"
                    + " WHEN d.dir_parroquia  IS NULL THEN ''\n"
                    + " ELSE d.dir_parroquia||''\n"
                    + " END) AS \"Parroquia\" ,\n"
                    + " (CASE\n"
                    + " WHEN  ((current_date-p.persona_fecha_nac)/365)  IS NULL THEN ''\n"
                    + " ELSE ((current_date-p.persona_fecha_nac)/365)||''\n"
                    + " END) AS \"Años\" ,\n"
                    + " (select par_valores->p.persona_nivel_acad->>'valor' from parametros where par_id = 5) AS \"Instruccion\",\n"
                    + " (select par_valores->p.persona_ocupacion->>'valor' from parametros where par_id = 7) AS \"Ocupacion\",\n"
                    + " (select par_valores->p.persona_estadocivil->>'valor' from parametros where par_id = 4) AS \"Estado Civil\",\n"
                    + " (SELECT\n"
                    + " COUNT(*)\n"
                    + " FROM\n"
                    + " hijos h \n"
                    + " WHERE\n"
                    + " h.victima_codigo =v.victima_codigo) AS \"NNA Responsables\",\n"
                    + " (CASE\n"
                    + " WHEN  p1.persona_nombre || ' '||p1.persona_apellido  IS NULL THEN ''\n"
                    + " ELSE p1.persona_nombre || ' '||p1.persona_apellido\n"
                    + " END)\n"
                    + " AS \" NNA\",\n"
                    + " (CASE\n"
                    + " WHEN p1.persona_sexo IS NULL THEN ''\n"
                    + " ELSE p1.persona_sexo||''\n"
                    + " END) AS \"Sexo\" ,\n"
                    + " (CASE\n"
                    + " WHEN p1.persona_fecha_nac  IS NULL THEN ''\n"
                    + " ELSE p1.persona_fecha_nac||''\n"
                    + " END) AS \"Fecha de Nacimiento\" ,\n"
                    + " (CASE\n"
                    + " WHEN  ((current_date-p1.persona_fecha_nac)/365)  IS NULL THEN ''\n"
                    + " ELSE ((current_date-p1.persona_fecha_nac)/365)||''\n"
                    + " END) AS \"Años NNA \" ,\n"
                    + " (CASE\n"
                    + " WHEN  h.hijo_anioescolar IS NULL THEN ''\n"
                    + " ELSE  h.hijo_anioescolar||''\n"
                    + " END) AS \"Año Escolar\" ,\n"
                    + " (CASE\n"
                    + " WHEN ie.inst_nombre IS NULL THEN ''\n"
                    + " ELSE ie.inst_nombre||''\n"
                    + " END) AS \"Institucion Educativa\" \n"
                    + "\n"
                    + " FROM\n"
                    + " persona p\n"
                    + " JOIN \n"
                    + " victima v\n"
                    + " ON \n"
                    + " v.persona_codigo = p.persona_codigo\n"
                    + " JOIN\n"
                    + " ingreso i\n"
                    + " ON \n"
                    + " i.victima_codigo = v.victima_codigo\n"
                    + " LEFT JOIN\n"
                    + " egreso e\n"
                    + " ON\n"
                    + " e.victima_codigo = v.victima_codigo\n"
                    + " LEFT JOIN\n"
                    + " direccion_persona dp\n"
                    + " ON\n"
                    + " p.persona_codigo = dp.persona_codigo\n"
                    + " LEFT JOIN \n"
                    + " direccion d\n"
                    + " ON \n"
                    + " d.dir_codigo = dp.dir_domicilio\n"
                    + " LEFT JOIN  hijos h\n"
                    + " ON h.victima_codigo = v.victima_codigo\n"
                    + " LEFT JOIN persona p1\n"
                    + " ON p1.persona_codigo = h.persona_codigo\n"
                    + " LEFT JOIN \n"
                    + " institucion_educativa ie\n"
                    + " ON ie.inst_codigo = h.institucion_codigo\n"
                    + " LEFT JOIN registro_referencia rr\n"
                    + " ON\n"
                    + " v.victima_codigo = rr.victima_codigo\n"
                    + " LEFT  JOIN x_registro_agresor xra\n"
                    + " ON\n"
                    + " xra.registroreferencia_codigo =rr.registroreferencia_codigo \n"
                    + "LEFT JOIN \n"
                    + " agresor a\n"
                    + " ON a.agresor_codigo = xra.agresor_codigo\n"
                    + "WHERE extract (year from i.ingreso_fecha) = 2017"
                    + " ORDER BY \n"
                    + " v.victima_codigo, i.ingreso_fecha\n";
        try {
            ResultSet res = conn.query(sql);
            String []cabecera={"Nombre", "F.Ingreso", "F.Egreso", "Agresor", "Nacionalidad", "Provincia", "Ciudad", "Parroquia", "Años", "Instruccion",
            "Ocupación", "Estado Civil ", "#NNA", "NNA", "Sexo", "F.Nacimiento", "Años", "Año Escolar", "Institución Educativa"};
                
           modelo.setColumnIdentifiers(cabecera);
                  modelo.addRow(cabecera);
                while (res.next()) {
                  
                    modelo.addRow(new Object[]{res.getString(1), res.getString(2), res.getString(3),
                        res.getString(4), res.getString(5), res.getString(6),
                        res.getString(7), res.getString(8), res.getString(9),
                        res.getString(10), res.getString(11), res.getString(12),
                        res.getString(13), res.getString(14), res.getString(15),
                        res.getString(16), res.getString(17), res.getString(18), res.getString(19)});
                }
        } catch (Exception e) {
        }
        return  modelo;
    }
    
    //METODO  PARA OBTENER LOS VALORES DE BITACORA
    
    public DefaultTableModel ReporteBitacora(){
        BitacoraDB bitacora = new BitacoraDB();
        String []cabecera = {"Personal","Fecha","Descripción"};
        modelo.addRow(cabecera);
        modelo=bitacora.ObtenerRegistros("1234567899");
        
        return modelo;
        
    }
}
