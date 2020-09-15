/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package marylove.controlador;

import java.sql.ResultSet;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import marylove.DBmodelo.BitacoraDB;
import marylove.DBmodelo.ResultadosDB;
import marylove.conexion.ConexionHi;

/**
 *
 * @author usuario
 */
public class SentenciasSelect {

    private ConexionHi conn = new ConexionHi();

    ExportarExcel excel = new ExportarExcel();
    DefaultTableModel modelo;

    public SentenciasSelect() {
    }

    //METODO PARA OBTENER LOS VALORES DEL REPORTE GENERAL
    public DefaultTableModel ReporteGeneral(String anio) {
        modelo = new DefaultTableModel();
        String sql = " SELECT p.persona_nombre||' '|| p.persona_apellido AS \"Compañera\",\n"
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
                + " (SELECT COUNT(*) FROM hijos h WHERE h.victima_codigo =v.victima_codigo) AS \"NNA Responsables\",\n"
                + " (CASE\n"
                + " WHEN  p1.persona_nombre || ' '||p1.persona_apellido  IS NULL THEN ''\n"
                + " ELSE p1.persona_nombre || ' '||p1.persona_apellido\n"
                + " END) AS \" NNA\",\n"
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
                + " FROM persona p\n"
                + " JOIN  victima v\n"
                + " ON v.persona_codigo = p.persona_codigo\n"
                + " LEFT JOIN ingreso i\n"
                + " ON i.victima_codigo = v.victima_codigo\n"
                + " LEFT JOIN egreso e\n"
                + " ON e.victima_codigo = v.victima_codigo\n"
                + " LEFT JOIN direccion_persona dp\n"
                + " ON p.persona_codigo = dp.persona_codigo\n"
                + " LEFT JOIN  direccion d\n"
                + " ON d.dir_codigo = dp.dir_domicilio\n"
                + " LEFT JOIN  hijos h\n"
                + " ON h.victima_codigo = v.victima_codigo\n"
                + " LEFT JOIN persona p1\n"
                + " ON p1.persona_codigo = h.persona_codigo\n"
                + " LEFT JOIN \n"
                + " institucion_educativa ie\n"
                + " ON ie.inst_codigo = h.institucion_codigo\n"
                + " LEFT JOIN registro_referencia rr\n"
                + " ON v.victima_codigo = rr.victima_codigo\n"
                + " LEFT  JOIN x_registro_agresor xra\n"
                + " ON xra.registroreferencia_codigo =rr.registroreferencia_codigo \n"
                + "LEFT JOIN agresor a\n"
                + " ON a.agresor_codigo = xra.agresor_codigo\n"
                + "WHERE extract (year from i.ingreso_fecha) ='" + anio + "'\n"
                + " ORDER BY v.victima_codigo, i.ingreso_fecha";
        try {
            ResultSet res = conn.query(sql);
            String[] cabecera = {"Nombre", "F.Ingreso", "F.Egreso", "Agresor", "Nacionalidad", "Provincia", "Ciudad", "Parroquia", "Años", "Instruccion",
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
            JOptionPane.showMessageDialog(null, "Surgió un error inesperado", "Información", JOptionPane.ERROR_MESSAGE);
        }
        return modelo;
    }

    //METODO  PARA OBTENER LOS VALORES DE BITACORA
    public DefaultTableModel ReporteBitacora(String cedula,String fecha) {
        modelo = new DefaultTableModel();
        String sql = "SELECT \n"
                + "b.bitacora_date ,b.bitacora_situacion,\n"
                + "b.bitacora_accion_realizada, b.bitacora_resultado,\n"
                + "p.persona_nombre ||' '||p.persona_apellido,\n"
                + "p1.persona_nombre ||'  '|| p1.persona_apellido\n"
                + "FROM public.bitacora b\n"
                + "JOIN personal per\n"
                + "USING (personal_codigo)\n"
                + "JOIN persona p\n"
                + "ON p.persona_codigo = per.persona_codigo\n"
                + "JOIN victima v \n"
                + "USING (victima_codigo)\n"
                + "JOIN persona p1\n"
                + "ON p1.persona_codigo = v.persona_codigo\n"
                + "WHERE p1.persona_cedula = '"+cedula+"'\n"
                + "AND b.bitacora_date = '"+fecha+"'";
        String[] cabecera = {"Fecha", "Situación", "Acción Realizada", "Resultado","Personal","Beneficiaria"};
        try {
            ResultSet res = conn.query(sql);
            modelo.setColumnIdentifiers(cabecera);
            modelo.addRow(cabecera);
            while (res.next()) {
                modelo.addRow(new Object[]{res.getString(1), res.getString(2), res.getString(3), res.getString(4), res.getString(5), res.getString(6)});
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Surgió un error inesperado", "Información", JOptionPane.ERROR_MESSAGE);
        }

        return modelo;
    }

    //METODO PARA OBTENER LOS VALORES DE LOS FORMULARIOS
    public DefaultTableModel ReporteFormularios(String cedula) {
        modelo = new DefaultTableModel();
        String sql = "select  p.persona_nombre ||' '||p.persona_apellido,\n"
                + "                    (CASE\n"
                + "                    WHEN  e.enc_tipo =1 THEN 'Formulario de Riesgo (EPV-R)'\n"
                + "                    WHEN  e.enc_tipo =2 THEN 'Escala evaluación de riesgos de violencia'\n"
                + "                     WHEN  e.enc_tipo =3 THEN 'Escala evaluación de nivel de crisis de riesgo'\n"
                + "                    END) AS \"Tipo de Encuesta\" ,\n"
                + "                    e.total \n"
                + "                    from persona p\n"
                + "                    join victima v\n"
                + "                   on v.persona_codigo=p.persona_codigo\n"
                + "                    join escala_prevencion_riesgos epr\n"
                + "                    on epr.victima_codigo=v.victima_codigo\n"
                + "                    join encuesta e\n"
                + "                    on e.epr_codigo=epr.epr_codigo\n"
                + "                    where persona_cedula='" + cedula + "';";

        String[] cabecera = {"Beneficiaria", "Encuesta", "Total"};
        try {
            ResultSet res = conn.query(sql);
            modelo.setColumnIdentifiers(cabecera);
            modelo.addRow(cabecera);
            while (res.next()) {
                modelo.addRow(new Object[]{res.getString(1), res.getString(2), res.getString(3)});
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Surgió un error inesperado", "Información", JOptionPane.ERROR_MESSAGE);
        }
        return modelo;

    }

    //METODO PARA OBTENER LOS REPORTE POR AÑO
    public DefaultTableModel ReporteAnio(String anio) {
        modelo = new DefaultTableModel();
        String sql = "SELECT v.victima_codigo as \"N\",\n"
                + "p.persona_nombre ||'  '||p.persona_apellido as \"Nombre\",\n"
                + "i.ingreso_fecha as \"Fecha de ingreso\",\n"
                + "e.egreso_fecha as \"Fecha de egreso\",\n"
                + "(select count(*) from hijos h where h.victima_codigo =v.victima_codigo  )as NNA ,\n"
                + "(SELECT CASE WHEN (select v1.victima_embarazo from victima v1  where v.victima_codigo=  v1.victima_codigo and  v1.victima_embarazo = true) IS NOT\n"
                + "NULL THEN  '1'   ELSE  '' END) as \"Embarazo\",\n"
                + "(SELECT CASE WHEN (select rf.llamada_lineaapoyo from registro_referencia rf where  v.victima_codigo = rf.victima_codigo  and rf.llamada_lineaapoyo = true) IS NOT\n"
                + "NULL THEN  '1'   ELSE  '' END) as \"llamanda a la linea\",\n"
                + "(select count(*)from registro_referencia rf where  v.victima_codigo = rf.victima_codigo ) as \"Binvenida\",\n"
                + "\n"
                + "(select count(*) from plan_emergente pe where v.victima_codigo = pe.victima_codigo)as \"plan emergente\",\n"
                + "(select count(*) from plan_vida pv where v.victima_codigo = pv.victima_codigo)as \"plan de vida\",\n"
                + "(select count(*) from evaluacion_plan_vida epv  where v.victima_codigo = epv.victima_codigo)as \"Evaluacion plan de vida\",\n"
                + "(select count(*) from plan_autonomia pa where v.victima_codigo = pa.victima_codigo)as \"plan de autonimia\"\n"
                + "from persona p\n"
                + "join victima v\n"
                + "on v.persona_codigo = p.persona_codigo\n"
                + "join ingreso i\n"
                + "on i.victima_codigo = v.victima_codigo\n"
                + "left join egreso e\n"
                + "on e.victima_codigo = v.victima_codigo\n"
                + " WHERE extract (year from i.ingreso_fecha) ='" + anio + "'";
        try {

            ResultSet res = conn.query(sql);
            String[] cabecera = {"N", "Nombre", "F.Ingreso", "F.Egreso", "NNA", "Embarazo", "Llamada linea apoyo", "Bienvenida", "Plan Emergente",
                "Plan de vida", "Evaluacion plan vida", "Plan de autonimia"};
            modelo.setColumnIdentifiers(cabecera);
            modelo.addRow(cabecera);
            while (res.next()) {

                modelo.addRow(new Object[]{res.getString(1), res.getString(2), res.getString(3),
                    res.getString(4), res.getString(5), res.getString(6),
                    res.getString(7), res.getString(8), res.getString(9),
                    res.getString(10), res.getString(11), res.getString(12)});
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Surgió un error inesperado", "Información", JOptionPane.ERROR_MESSAGE);
        }
        return modelo;
    }
//-----------------------------CONSULTA ENCABEZADO Y PESTAÑA 1: DATOS DE IDENTIFICACION-----------------------------------

    public DefaultTableModel ReporteAnamnesisDP(String ID) {
        modelo = new DefaultTableModel();
        String sql = "SELECT\n"
                + "	per.persona_cedula,\n"
                + "	per.persona_nombre,\n"
                + "	per.persona_apellido,\n"
                + "	per.persona_fecha_nac,\n"
                + "	per.persona_nacionalidad,\n"
                + "	anam.fecha_creacion,\n"
                + "	nac.lugar_nacimiento\n"
                + "FROM anamnesis anam\n"
                + "JOIN hijos hij ON hij.hijo_codigo = anam.hijo_codigo\n"
                + "JOIN persona per ON hij.persona_codigo = per.persona_codigo\n"
                + "JOIN nacimiento nac ON nac.nacimiento_codigo = anam.nacimiento_codigo\n"
                + "WHERE anam.anamnesis_id ='" + ID + "'";
        try {

            ResultSet res = conn.query(sql);
            String[] cabecera = {"Cedula", "Nombre", "Apellido", "Fecha de Nacimiento", "Nacionalidad", "Fecha de Creación", "Lugar de Nacimiento"};
            modelo.setColumnIdentifiers(cabecera);
            modelo.addRow(cabecera);
            while (res.next()) {

                modelo.addRow(new Object[]{res.getString(1), res.getString(2), res.getString(3),
                    res.getString(4), res.getString(5), res.getString(6), res.getString(7)});
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Surgió un error inesperado", "Información", JOptionPane.ERROR_MESSAGE);
        }
        return modelo;
    }

//-------------------------------------CONSULTA PESTAÑA 2: DATOS DE PADRE Y MADRE-------------------------------------------
    public DefaultTableModel AnamnesisDPM(String ID) {
        modelo = new DefaultTableModel();
        String sql = "SELECT\n"
                + "	anam.nombre_madre,\n"
                + "	anam.apellido_madre,\n"
                + "	anam.edad_madre,\n"
                + "	(select par_valores->anam.nacionalidad_madre->>'valor' from parametros where par_id = 3),\n"
                + "	per.persona_nombre,\n"
                + "	per.persona_apellido,\n"
                + "	(select par_valores->per.persona_nacionalidad->>'valor' from parametros where par_id = 3),\n"
                + "	pa.edad,\n"
                + "	(CASE\n"
                + "	WHEN hij.padre_agresor IS true THEN 'SI'\n"
                + "	ELSE 'NO'\n"
                + "	END),\n"
                + "	hij.hijo_estado_ingreso\n"
                + "FROM anamnesis anam\n"
                + "JOIN hijos hij ON hij.hijo_codigo = anam.hijo_codigo\n"
                + "JOIN padre pa ON pa.padre_id = hij.padre_id\n"
                + "JOIN persona per ON per.persona_codigo = pa.persona_codigo\n"
                + "WHERE anam.anamnesis_id = '" + ID + "'";
        try {

            ResultSet res = conn.query(sql);
            String[] cabecera = {"Nombre Madre", "Apellido Madre", "Edad Madre", "Nacionalidad Madre", "Nombre Padre",
                "Apellido Padre", "Nacionalidad Padre", "Edad Padre", "Padre Agresor", "Estado de Ingreso NNA"};
            modelo.setColumnIdentifiers(cabecera);
            modelo.addRow(cabecera);
            while (res.next()) {

                modelo.addRow(new Object[]{res.getString(1), res.getString(2), res.getString(3),
                    res.getString(4), res.getString(5), res.getString(6), res.getString(7),
                    res.getString(8), res.getString(9), res.getString(10)});
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Surgió un error inesperado", "Información", JOptionPane.ERROR_MESSAGE);
        }
        return modelo;
    }

//-------------------------------------CONSULTA PESTAÑA 3: COMPOSICION FAMILIAR-------------------------------------------
    public DefaultTableModel AnamnesisCF() {
        modelo = new DefaultTableModel();
        String sql = "SELECT \n"
                + "	p.persona_nombre, \n"
                + "	p.persona_apellido, \n"
                + "	p.persona_sexo,  \n"
                + "	(select par_valores->p.persona_estadocivil->>'valor' from parametros where par_id = 4),\n"
                + "    f.parentesco,  \n"
                + "	(select par_valores->p.persona_ocupacion->>'valor' from parametros where par_id = 7),\n"
                + "	f.edad, \n"
                + "	(select par_valores->p.persona_nivel_acad->>'valor' from parametros where par_id = 5)\n"
                + "	\n"
                + "FROM persona p\n"
                + "JOIN familiares f ON f.persona_codigo = p.persona_codigo\n"
                + "JOIN x_hijo_familiares xhf ON f.familiares_id = xhf.familiares_codigo\n"
                + "WHERE xhf.hijo_codigo = 1\n"
                + "AND p.persona_estado_actual = 'true'\n"
                + "AND f.estado = 'true'";
        try {

            ResultSet res = conn.query(sql);
            String[] cabecera = {"Nombre", "Apellido", "Sexo", "Estado Civil", "Parentesco",
                "Ocupación", "Edad", "Instrucción Academica"};
            modelo.setColumnIdentifiers(cabecera);
            modelo.addRow(cabecera);
            while (res.next()) {

                modelo.addRow(new Object[]{res.getString(1), res.getString(2), res.getString(3),
                    res.getString(4), res.getString(5), res.getString(6), res.getString(7),
                    res.getString(8)});
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Surgió un error inesperado", "Información", JOptionPane.ERROR_MESSAGE);
        }
        return modelo;

    }

//-------------------------------------CONSULTA PESTAÑA 4: PERIODO DE EMBARAZO-------------------------------------------
    public DefaultTableModel AnamnesisPE(String ID) {
        modelo = new DefaultTableModel();
        String sql = "SELECT  \n"
                + "	(CASE\n"
                + "	 WHEN ee.embarazo_planificado IS true THEN 'SI'\n"
                + "     ELSE 'NO'\n"
                + "     END),\n"
                + "	ee.embarazo_reaccion_padre, \n"
                + "	ee.embarazo_reaccion_madre, \n"
                + "	ee.donde_realizo_controles, \n"
                + "	ee.consumo_causas, \n"
                + "	ee.aborto_causas, \n"
                + "	(CASE\n"
                + "	 WHEN ee.embarazo_estado IS true THEN 'SI'\n"
                + "     ELSE 'NO'\n"
                + "     END),\n"
                + "	xec.embarazo_id, \n"
                + "	(CASE\n"
                + "	 WHEN xec.estado IS true THEN 'SI'\n"
                + "     ELSE 'NO'\n"
                + "     END),\n"
                + "	xec.json_complicaciones\n"
                + "FROM public.embarazo_estado ee \n"
                + "JOIN public.x_embarazo_comp xec ON ee.embarazo_id=xec.embarazo_id\n"
                + "JOIN public.anamnesis ana ON ana.embarazo_id=ee.embarazo_id\n"
                + "WHERE ana.anamnesis_id ='" + ID + "'";
        try {

            ResultSet res = conn.query(sql);
            String[] cabecera = {"Embarazo Planificado", "Reacción Padre", "Reacción Madre", "Lugar de Controles", "Causas de Cosumo",
                "Causas de Aborto ", "Estado", "Embarazo_id", "Estado del Embarazo", "Complicaciones"};
            modelo.setColumnIdentifiers(cabecera);
            modelo.addRow(cabecera);
            while (res.next()) {

                modelo.addRow(new Object[]{res.getString(1), res.getString(2), res.getString(3),
                    res.getString(4), res.getString(5), res.getString(6), res.getString(7),
                    res.getString(8), res.getString(9), res.getString(10)});
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Surgió un error inesperado", "Información", JOptionPane.ERROR_MESSAGE);
        }
        return modelo;

    }

//-------------------------------------CONSULTA PESTAÑA 5: CONDICIONES DE NACIMIENTO-------------------------------------------
    public DefaultTableModel AnamnesisCN(String ID) {
        modelo = new DefaultTableModel();
        String sql = "SELECT\n"
                + "	nac.mes_alumbramiento,\n"
                + "	(CASE\n"
                + "    WHEN nac.anestesia IS true THEN 'SI'\n"
                + "    ELSE 'NO'\n"
                + "    END),\n"
                + "	nac.lugar_nacimiento,\n"
                + "	nac.parto_tipo,\n"
                + "	nac.motivo_cesarea,\n"
                + "	detNac.complicaciones_parto,\n"
                + "	detNac.peso,\n"
                + "	detNac.talla,\n"
                + "	(CASE\n"
                + "    WHEN detNac.lloro_nac IS true THEN 'SI'\n"
                + "    ELSE 'NO'\n"
                + "    END),\n"
                + "	(CASE\n"
                + "    WHEN detNac.necesito_oxigeno IS true THEN 'SI'\n"
                + "    ELSE 'NO'\n"
                + "    END),\n"
                + "	detNac.sintomas_after_part,\n"
                + "	(CASE\n"
                + "    WHEN pp.sexo_esperado IS true THEN 'SI'\n"
                + "    ELSE 'NO'\n"
                + "    END),\n"
                + "	pp.reaccion_padre,\n"
                + "	pp.reaccion_madre\n"
                + "FROM anamnesis anam\n"
                + "JOIN nacimiento nac ON nac.nacimiento_codigo = anam.nacimiento_codigo\n"
                + "JOIN detalle_nacimiento detNac ON detNac.nacimiento_codigo = nac.nacimiento_codigo \n"
                + "JOIN post_parto pp ON pp.post_parto_id = anam.post_parto_id\n"
                + "WHERE anam.anamnesis_id ='" + ID + "'";
        try {

            ResultSet res = conn.query(sql);
            String[] cabecera = {"Mes Alumbramiento", "Anestesia", "Lugar de Nacimiento", "Tipo de Parto", "Motivos de cesarea",
                "Complicaciones del Parto", "Peso", "Talla", "Lloró al nacer", "Necesitó cesarea", "Sintomas post parto",
                "Sexo Esperado", "Reacción Padre", "Reacción Madre"};
            modelo.setColumnIdentifiers(cabecera);
            modelo.addRow(cabecera);
            while (res.next()) {

                modelo.addRow(new Object[]{res.getString(1), res.getString(2), res.getString(3),
                    res.getString(4), res.getString(5), res.getString(6), res.getString(7),
                    res.getString(8), res.getString(9), res.getString(10),
                    res.getString(11), res.getString(12), res.getString(13), res.getString(14)});
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Surgió un error inesperado", "Información", JOptionPane.ERROR_MESSAGE);
        }
        return modelo;
    }

//-------------------------------------CONSULTA PESTAÑA 6: PRIMEROS DIAS DE VIDA-------------------------------------------
    public DefaultTableModel AnamnesisPDV(String ID) {
        modelo = new DefaultTableModel();
        String sql = "SELECT\n"
                + "	pp.alim_leche_mater_descrip,\n"
                + "	pp.destete_descripcion,\n"
                + "	pp.edad_sentar,\n"
                + "	pp.edad_caminar,\n"
                + "	pp.edad_primeras_palabras,\n"
                + "	pp.edad_fin_leche_mater,\n"
                + "	(CASE\n"
                + "     WHEN pp.biberon IS true THEN 'SI'\n"
                + "     ELSE 'NO'\n"
                + "     END),\n"
                + "	pp.biberon_edad_ini,\n"
                + "	pp.biberon_edad_fin,\n"
                + "	(CASE\n"
                + "     WHEN pp.alim_leche_mater IS true THEN 'SI'\n"
                + "     ELSE 'NO'\n"
                + "     END),\n"
                + "	(CASE\n"
                + "     WHEN pp.problemas_succion IS true THEN 'SI'\n"
                + "     ELSE 'NO'\n"
                + "     END)\n"
                + "FROM anamnesis anam\n"
                + "JOIN post_parto pp ON pp.post_parto_id = anam.post_parto_id\n"
                + "WHERE anam.anamnesis_id ='" + ID + "'";
        try {

            ResultSet res = conn.query(sql);
            String[] cabecera = {"Descrippcion Leche Materna", "Descripcion Destete", "Edad Sentar", "Edad Caminar", "Primeras Palabras",
                "Acabó de amamantar ", "Usó biberon", "Edad inicio biberon", "Edad fin biberon", "Alimenta con leche materna", "Problemas de succión"};
            modelo.setColumnIdentifiers(cabecera);
            modelo.addRow(cabecera);
            while (res.next()) {

                modelo.addRow(new Object[]{res.getString(1), res.getString(2), res.getString(3),
                    res.getString(4), res.getString(5), res.getString(6), res.getString(7),
                    res.getString(8), res.getString(9), res.getString(10), res.getString(11)});
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Surgió un error inesperado", "Información", JOptionPane.ERROR_MESSAGE);
        }
        return modelo;

    }

//-------------------------------------CONSULTA PESTAÑA 7: ALIMENTACION ACTUAL--------------------------------------------
    public DefaultTableModel AnamnesisAA(String ID) {
        modelo = new DefaultTableModel();
        String sql = " SELECT\n"
                + "	pp.edad_aliment_solido,\n"
                + "	pp.dificultades_alimentacion,\n"
                + "	pp.veces_como_diario,\n"
                + "	pp.comer_solo_acompanado,\n"
                + "	pp.actitud_madre_no_come\n"
                + "FROM anamnesis anam\n"
                + "JOIN post_parto pp ON pp.post_parto_id = anam.post_parto_id\n"
                + "WHERE anam.anamnesis_id ='" + ID + "'";
        try {

            ResultSet res = conn.query(sql);
            String[] cabecera = {"Edad come solidos", "Dificultades de Alimentación", "Cuantas veces como al día", "Come solo o acompañado", "Sensación de la madre si no come"};
            modelo.setColumnIdentifiers(cabecera);
            modelo.addRow(cabecera);
            while (res.next()) {

                modelo.addRow(new Object[]{res.getString(1), res.getString(2), res.getString(3),
                    res.getString(4), res.getString(5)});
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Surgió un error inesperado", "Información", JOptionPane.ERROR_MESSAGE);
        }
        return modelo;
    }

//-------------------------------------CONSULTA PESTAÑA 8: DESARROLLO MOTOR--------------------------------------------
    public DefaultTableModel AnamnesisDM(String ID) {
        modelo = new DefaultTableModel();
        String sql = "SELECT\n"
                + "	d.des_motor_grueso,\n"
                + "	d.des_motor_fino,\n"
                + "	d.movimientos,\n"
                + "	d.des_psico_social,\n"
                + "	d.des_cognitivo,\n"
                + "	d.des_fisico,\n"
                + "	d.caridad_lenguajes,\n"
                + "	d.claridad_lenguajes_descrip\n"
                + "FROM anamnesis anam\n"
                + "JOIN desarrollo d ON d.desarrollo_id = anam.desarrollo_id\n"
                + "WHERE anam.anamnesis_id ='" + ID + "'";
        try {

            ResultSet res = conn.query(sql);
            String[] cabecera = {"Desarrollo Motor Grueso", "Desarrollo Motor Fino", "Movimientos", "Descripción Psico-social",
                "Descripción Cognito", "Descripcion Fisico", "Claridad Lenguajes", "Descripción Claridad Lenguajes"};
            modelo.setColumnIdentifiers(cabecera);
            modelo.addRow(cabecera);
            while (res.next()) {

                modelo.addRow(new Object[]{res.getString(1), res.getString(2), res.getString(3),
                    res.getString(4), res.getString(5), res.getString(6), res.getString(7), res.getString(8)});
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Surgió un error inesperado", "Información", JOptionPane.ERROR_MESSAGE);
        }
        return modelo;
    }

//-------------------------------CONSULTA PESTAÑA 9: SUEÑO Y CONTROL DE ESFINTERES------------------------------------------
    public DefaultTableModel AnamnesisSCE(String ID) {
        modelo = new DefaultTableModel();
        String sql = "SELECT	\n"
                + "	(CASE\n"
                + "     WHEN sce.duerme_toda_noche IS true THEN 'SI'\n"
                + "     ELSE 'NO'\n"
                + "     END),\n"
                + "	(CASE\n"
                + "     WHEN sce.miedo_dormir_solo IS true THEN 'SI'\n"
                + "     ELSE 'NO'\n"
                + "     END),\n"
                + "	sce.despertar_descripcion,\n"
                + "	(CASE\n"
                + "     WHEN 	sce.pesadillas IS true THEN 'SI'\n"
                + "     ELSE 'NO'\n"
                + "     END),\n"
                + "	sce.edad_control_esfinter,\n"
                + "	(CASE\n"
                + "     WHEN sce.ayuda_bano IS true THEN 'SI'\n"
                + "     ELSE 'NO'\n"
                + "     END),\n"
                + "	(CASE\n"
                + "     WHEN sce.moja_cama IS true THEN 'SI'\n"
                + "     ELSE 'NO'\n"
                + "     END),\n"
                + "	sce.periodo_ecopresis_descrip,\n"
                + "	(CASE\n"
                + "     WHEN sce.periodo_ecopresis IS true THEN 'SI'\n"
                + "     ELSE 'NO'\n"
                + "     END),\n"
                + "	sce.como_es_sueno,\n"
                + "	sce.acompanamiento_dormir\n"
                + "FROM anamnesis anam\n"
                + "JOIN sueno_control_esfin sce ON sce.sucoes_id = anam.sucoes_id\n"
                + "WHERE anam.anamnesis_id ='" + ID + "'";
        try {

            ResultSet res = conn.query(sql);
            String[] cabecera = {"Duerme toda la noche", "Tiene miedo a dormir solo", "Descripcion Despertar", "Tiene pesadillas", "Edad Control Esfinter",
                "Necesita ayuda en el baño", "Moja la cama", "Descripcion Periodo", "Tienes periodo ..", "Como es el sueño", "Acompañante"};
            modelo.setColumnIdentifiers(cabecera);
            modelo.addRow(cabecera);
            while (res.next()) {

                modelo.addRow(new Object[]{res.getString(1), res.getString(2), res.getString(3),
                    res.getString(4), res.getString(5), res.getString(6), res.getString(7),
                    res.getString(8), res.getString(9), res.getString(10),
                    res.getString(11)});
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Surgió un error inesperado", "Información", JOptionPane.ERROR_MESSAGE);
        }
        return modelo;

    }
//-------------------------------CONSULTA PESTAÑA 10: ESCOLARIZACION NNA------------------------------------------

    public DefaultTableModel AnamnesisENNA(String ID) {
        modelo = new DefaultTableModel();
        String sql = "SELECT \n"
                + "	(CASE\n"
                + "     WHEN es.esc_estudia IS true THEN 'SI'\n"
                + "     ELSE 'NO'\n"
                + "     END),\n"
                + "	es.esc_explicacion, \n"
                + "	es.esc_repeticion_anio_causas, \n"
                + "	(CASE\n"
                + "     WHEN es.esc_nna_problem_aprend IS true THEN 'SI'\n"
                + "     ELSE 'NO'\n"
                + "     END),\n"
                + "	es.esc_nna_observaciones, \n"
                + "	(CASE\n"
                + "     WHEN es.esc_asis_prog_apoyo IS true THEN 'SI'\n"
                + "     ELSE 'NO'\n"
                + "     END),\n"
                + "	es.esc_asis_prog_apoyo_obser, \n"
                + "	(CASE\n"
                + "     WHEN es.esc_estado IS true THEN 'SI'\n"
                + "     ELSE 'NO'\n"
                + "     END),\n"
                + "	es.esc_ultimo_anio_cursado\n"
                + "FROM public.escolaridad es \n"
                + "JOIN public.anamnesis ana ON es.escolaridad_id=ana.escolaridad_id \n"
                + "WHERE anamnesis_id = '" + ID + "'";
        try {

            ResultSet res = conn.query(sql);
            String[] cabecera = {"Estudia", "Explicación Escolaridad", "Repitió Años", "Problemas de aprendizaje", "Observaciones",
                "Programa de apoyo", "Observaciones Programa de apoyo", "Estado", "Ultimo año cursado"};
            modelo.setColumnIdentifiers(cabecera);
            modelo.addRow(cabecera);
            while (res.next()) {

                modelo.addRow(new Object[]{res.getString(1), res.getString(2), res.getString(3),
                    res.getString(4), res.getString(5), res.getString(6), res.getString(7),
                    res.getString(8), res.getString(9)});
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Surgió un error inesperado", "Información", JOptionPane.ERROR_MESSAGE);
        }
        return modelo;
    }
//---------------------------------------CONSULTA PESTAÑA 11: SALUD NNA--------------------------------------------------

    public DefaultTableModel AnamnesisSNNA(String ID) {
        modelo = new DefaultTableModel();
        String sql = "SELECT \n"
                + "	s.problem_familiar,\n"
                + "	s.problem_familiar_descrip,\n"
                + "	(CASE\n"
                + "     WHEN s.problem_respiratorio IS true THEN 'SI'\n"
                + "     ELSE 'NO'\n"
                + "     END),\n"
                + "	s.problem_resp_descrip,\n"
                + "	(CASE\n"
                + "     WHEN s.problem_alergias IS true THEN 'SI'\n"
                + "     ELSE 'NO'\n"
                + "     END),\n"
                + "	s.problem_aler_descrip,\n"
                + "	(CASE\n"
                + "     WHEN s.problem_neurologico IS true THEN 'SI'\n"
                + "     ELSE 'NO'\n"
                + "     END),\n"
                + "	s.problem_neuro_descrip,\n"
                + "	(CASE\n"
                + "     WHEN s.problem_nerviosos IS true THEN 'SI'\n"
                + "     ELSE 'NO'\n"
                + "     END),\n"
                + "	s.problem_nervi_descrip\n"
                + "FROM anamnesis anam\n"
                + "JOIN salud_nna s ON s.salud_nna_id = anam.salud_nna_id\n"
                + "WHERE anam.anamnesis_id ='" + ID + "'";
        try {

            ResultSet res = conn.query(sql);
            String[] cabecera = {"Problemas Familiares", "Descripcion", "Problemas Respiratorios", "Descripcion", "Alergias",
                "Descripcion", "Problemas Neurologicos", "Descripcion", "Problemas nerviosos", "Descripcion"};
            modelo.setColumnIdentifiers(cabecera);
            modelo.addRow(cabecera);
            while (res.next()) {

                modelo.addRow(new Object[]{res.getString(1), res.getString(2), res.getString(3),
                    res.getString(4), res.getString(5), res.getString(6), res.getString(7),
                    res.getString(8), res.getString(9), res.getString(10)});
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Surgió un error inesperado", "Información", JOptionPane.ERROR_MESSAGE);
        }
        return modelo;

    }
//---------------------------------------CONSULTA PESTAÑA 12: RELACION FAMILIAR--------------------------------------------------

    public DefaultTableModel AnamnesisRF(String ID) {
        modelo = new DefaultTableModel();
        String sql = "SELECT \n"
                + "	rf.clima_familiar,\n"
                + "	rf.relacion_padre,\n"
                + "	rf.relacion_madre,\n"
                + "	rf.relacion_hermanos,\n"
                + "	(CASE\n"
                + "     WHEN 	rf.trabajo IS true THEN 'SI'\n"
                + "     ELSE 'NO'\n"
                + "     END),\n"
                + "	rf.trabajo_decrip,\n"
                + "	(CASE\n"
                + "     WHEN 	rf.agresion_agresor IS true THEN 'SI'\n"
                + "     ELSE 'NO'\n"
                + "     END),\n"
                + "	rf.objeto_utilizado,\n"
                + "	rf.obligacion_familiar,\n"
                + "	rf.proyeccion_madre,\n"
                + "	rf.necesidad_inmediata,\n"
                + "	rf.agresion_frecuencia\n"
                + "FROM anamnesis anam\n"
                + "JOIN relacion_familiar_nna rf ON rf.rela_famili_nna_id = anam.rela_famili_nna_id\n"
                + "WHERE anam.anamnesis_id ='" + ID + "'";
        try {

            ResultSet res = conn.query(sql);
            String[] cabecera = {"Clima Familiar", "Relación Padre", "Relación Madre", "Relación Hermanos", "Trabajo",
                "Trabajo Descripción", "Agresor", "Objetivo Utilizado", "Obligación Familiar", "Proyección Madre", "Necesidad Inmediata", "Frecuencia Agresión"};
            modelo.setColumnIdentifiers(cabecera);
            modelo.addRow(cabecera);
            while (res.next()) {

                modelo.addRow(new Object[]{res.getString(1), res.getString(2), res.getString(3),
                    res.getString(4), res.getString(5), res.getString(6), res.getString(7),
                    res.getString(8), res.getString(9), res.getString(10), res.getString(11), res.getString(12)});
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Surgió un error inesperado", "Información", JOptionPane.ERROR_MESSAGE);
        }
        return modelo;
    }
//---------------------------------------CONSULTA PESTAÑA 13: OBSERVACIONES---------------------------------------------------

    public DefaultTableModel AnamnesisO(String ID) {
        modelo = new DefaultTableModel();
        String sql = "SELECT \n"
                + "	observaciones_generales\n"
                + "FROM anamnesis\n"
                + "WHERE anamnesis_id = '" + ID + "'";
        try {

            ResultSet res = conn.query(sql);
            String[] cabecera = {"Obsrvaciones"};
            modelo.setColumnIdentifiers(cabecera);
            modelo.addRow(cabecera);
            while (res.next()) {

                modelo.addRow(new Object[]{res.getString(1)});
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Surgió un error inesperado", "Información", JOptionPane.ERROR_MESSAGE);
        }
        return modelo;

    }

    //REPORTE PRIMER ENCUENTRO
    public DefaultTableModel PrimerEncuentro(String cedula) {
        modelo = new DefaultTableModel();
        String sql = "select per.persona_nombre, per.persona_apellido, epv.pstintcrisis_estado_emocional,epv.pstintcrisis_nivel_riesgo,\n"
                + "epv.pstintcrisis_valoracionpreliminar,\n"
                + "(CASE\n"
                + "WHEN  epv.pstintcrisis_riesgo_suicida  IS true  THEN 'SI'\n"
                + "ELSE 'NO'\n"
                + "END) AS \"Riesgo Suicida\" ,\n"
                + "epv.pstintcrisis_puntosreelevantes, \n"
                + "(CASE\n"
                + "WHEN  epv.pstintcrisis_proceso_psicoterapeutico  IS true  THEN 'SI'\n"
                + "ELSE 'NO'\n"
                + "END) AS \"Proceso \" ,\n"
                + "(CASE\n"
                + "WHEN  epv.pstintcrisis_proceso_psicoterapeutico  IS true  THEN 'SI'\n"
                + "ELSE 'NO'\n"
                + "END) AS \"Proceso Terapeutico \" ,\n"
                + " epv.pstintcrisis_fecha \n"
                + "from primer_encuentro epv\n"
                + "join victima vc\n"
                + " on epv.victima_codigo = vc.victima_codigo inner join persona per\n"
                + " on vc.persona_codigo = per.persona_codigo\n"
                + " where primer_encuentro_estado = 'a'\n"
                + " and per.persona_cedula='" + cedula + "'";
        try {

            ResultSet res = conn.query(sql);
            String[] cabecera = {"Nombre", "Apellido", "Estado Emocional", "Nivel de Riesgo", "Valoración Preliminar",
                "Riesgo Suicida", "Puntos relevantes", "Proceso", "Proceso Terapeutico", "Fecha"};
            modelo.setColumnIdentifiers(cabecera);
            modelo.addRow(cabecera);
            while (res.next()) {

                modelo.addRow(new Object[]{res.getString(1), res.getString(2), res.getString(3),
                    res.getString(4), res.getString(5), res.getString(6), res.getString(7),
                    res.getString(8), res.getString(9), res.getString(10)});
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Surgió un error inesperado", "Información", JOptionPane.ERROR_MESSAGE);
        }
        return modelo;

    }

    //AVANCES TERAPEUTICOS
    public DefaultTableModel Avances_Terapeuticos(String cedula, String fecha) {
        modelo = new DefaultTableModel();
        String sql = "SELECT p.persona_nombre||' '|| p.persona_apellido as \"Victima\", avances_situacion, avances_intervencion, avances_fecha\n"
                + "FROM avances_terapeuticos\n"
                + "JOIN ficha_plan_atencion_terapeuta fpa\n"
                + "using (plan_at_codigo)\n"
                + "join historial_clinico hc\n"
                + "using (hist_id)\n"
                + "join victima v\n"
                + "on v.victima_codigo = hc.victima_codigo\n"
                + "join persona p\n"
                + "on p.persona_codigo = v.persona_codigo\n"
                + "where p.persona_cedula='" + cedula + "'\n"
                + "and avances_fecha ='" + fecha + "'";
        try {

            ResultSet res = conn.query(sql);
            String[] cabecera = {"Beneficiaria", "Situación", "Intervención", "Fecha"};
            modelo.setColumnIdentifiers(cabecera);
            modelo.addRow(cabecera);
            while (res.next()) {

                modelo.addRow(new Object[]{res.getString(1), res.getString(2), res.getString(3),
                    res.getString(4)});
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Surgió un error inesperado", "Información", JOptionPane.ERROR_MESSAGE);
        }
        return modelo;
    }

    //PLAN ATENCION TERAPEUTICA
    public DefaultTableModel PlanAtencion(String cedula) {
        modelo = new DefaultTableModel();
        String sql = "SELECT  p.persona_nombre||' '||p.persona_apellido as \"Victima\" , plan_at_fecha, plan_at_encuadre_terapeuta, plan_at_obj_atencion,\n"
                + "plan_at_derechos_victima, plan_at_estrategias_rep, plan_at_compromisos_terap\n"
                + "FROM ficha_plan_atencion_terapeuta\n"
                + "join historial_clinico hc\n"
                + "using (hist_id)\n"
                + "join victima v\n"
                + "on v.victima_codigo = hc.victima_codigo\n"
                + "join persona p\n"
                + "on p.persona_codigo = v.persona_codigo\n"
                + "where p.persona_cedula='" + cedula + "'";
        try {

            ResultSet res = conn.query(sql);
            String[] cabecera = {"Beneficiaria", "Fecha", "Encuadre Terapeutico", "Objetivo de la Atención", "Derechos Concuicados de la Victima", "Estrategias", "Compromisos"};
            modelo.setColumnIdentifiers(cabecera);
            modelo.addRow(cabecera);
            while (res.next()) {

                modelo.addRow(new Object[]{res.getString(1), res.getString(2), res.getString(3),
                    res.getString(4), res.getString(5), res.getString(6), res.getString(7)});
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Surgió un error inesperado", "Información", JOptionPane.ERROR_MESSAGE);
        }
        return modelo;
    }

    //PLAN EMERGENTE
    public DefaultTableModel PlanEmergente(String cedula, String fecha) {
        modelo = new DefaultTableModel();
        String sql = "select p.persona_nombre ||' '|| p.persona_apellido as \"Victima\",\n"
                + "pei.apreciacioninicial, pei.accionesinmediatas,pei.modalidad_nombre,\n"
                + "p1.persona_nombre ||' '|| p1.persona_apellido as \"Personal\",\n"
                + " pe.emergente_fecha \n"
                + "from plan_emergente pe\n"
                + "join victima v\n"
                + "using(victima_codigo)\n"
                + "join persona p\n"
                + "on p.persona_codigo = v.persona_codigo\n"
                + "join plan_emerg_item pei\n"
                + "using (emergente_id)\n"
                + "join personal per\n"
                + "using (personal_codigo)\n"
                + "join persona p1\n"
                + "on p1.persona_codigo = per.persona_codigo\n"
                + "where p.persona_cedula = '" + cedula + "'\n"
                + "and pe.emergente_fecha= '" + fecha + "'";
        try {

            ResultSet res = conn.query(sql);
            String[] cabecera = {"Beneficiaria", "Apreciación Inicial", "Acciones Inmediatas", "Modalidad", "Personal", "Fecha"};
            modelo.setColumnIdentifiers(cabecera);
            modelo.addRow(cabecera);
            while (res.next()) {

                modelo.addRow(new Object[]{res.getString(1), res.getString(2), res.getString(3),
                    res.getString(4), res.getString(5), res.getString(6)});
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Surgió un error inesperado", "Información", JOptionPane.ERROR_MESSAGE);
        }
        return modelo;
    }

    //HISTORIAL CLINICO
    public DefaultTableModel HistorialClinico(String cedula) {
        modelo = new DefaultTableModel();
        String sql = "SELECT  p.persona_nombre||' '||p.persona_apellido as \"Victima\", hc.demanda, hc.demanda_implicita, \n"
                + "hc.historial_violencia, hc.prub_descrip,  hc.conducta, hc.func_cogni_sensorio, hc.estado_consciencia, hc.orientacion, hc.memoria,\n"
                + "hc.atencion_concentracion,hc.apart_gene_conduct, hc.afectividad, hc.funciones_ment_superior, hc.motivo_consulta, hc.diagnos_infor, hc.diagnos_diferencial,\n"
                + "hc.personality_descrip,hc.senala_tecnicas,hc.recomendaciones, hc.biog_psico_perso,p1.persona_nombre ||' '||p1.persona_nombre as \" Personal\"\n"
                + "FROM historial_clinico hc\n"
                + "JOIN victima v\n"
                + "ON v.victima_codigo = hc.victima_codigo\n"
                + "JOIN persona p\n"
                + "ON v.persona_codigo = p.persona_codigo\n"
                + "JOIN psicologo psi\n"
                + "ON psi.psicologo_codigo = hc.psicologo_codigo\n"
                + "JOIN personal per\n"
                + "ON per.personal_codigo = psi.personal_codigo\n"
                + "JOIN persona p1\n"
                + "ON p1.persona_codigo = per.persona_codigo\n"
                + "where p.persona_cedula='" + cedula + "'";
        try {
            ResultSet res = conn.query(sql);
            String[] cabecera = {"Beneficiaria", "Demanda", "Tipo de Violencia", "Historial Violencia", "Pruebas Psicologicas y resultados", "Conducta",
                "Funciones Coginitivas", "Estado de conciencia", "Orientación", "Memoria", "Atención y Concentración", "Sensopercepción ", "Afectividad",
                "Funciones Mentales Superiores", "Formulación dinamica del problema", "Diagnostico Informal", "Diagnostico Diferencial", "Descripción de la Personalidad",
                "Señalamineto de Tecnicas", "Recomendaciones", "Biografía Psicologica Personal"};

            modelo.setColumnIdentifiers(cabecera);
            modelo.addRow(cabecera);
            while (res.next()) {

                modelo.addRow(new Object[]{res.getString(1), res.getString(2), res.getString(3),
                    res.getString(4), res.getString(5), res.getString(6),
                    res.getString(7), res.getString(8), res.getString(9),
                    res.getString(10), res.getString(11), res.getString(12),
                    res.getString(13), res.getString(14), res.getString(15),
                    res.getString(16), res.getString(17), res.getString(18),
                    res.getString(19), res.getString(20), res.getString(21)});
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Surgió un error inesperado", "Información", JOptionPane.ERROR_MESSAGE);
        }
        return modelo;
    }

    // FICHA LEGAL
    public DefaultTableModel FichaLegal(String cedula) {
        modelo = new DefaultTableModel();
        String sql = "select p.persona_nombre ||' '|| p.persona_apellido AS \"VICTIMA\",\n"
                + "fl.motivo_consulta,fl.relacion_hechos,fl.aspectos_reelevantes,fl.fecha_elaboracion,\n"
                + "p1.persona_nombre||' '||p1.persona_apellido AS \"ABOGADA\"\n"
                + "from ficha_legal fl\n"
                + "join victima v\n"
                + "on v.victima_codigo= fl.victima_codigo\n"
                + "join persona p\n"
                + "on p.persona_codigo = v.persona_codigo\n"
                + "join abogada ab\n"
                + "on ab.abogada_id = fl.abogada_id\n"
                + "join personal per\n"
                + "on per.personal_codigo = ab.personal_codigo\n"
                + "join persona p1\n"
                + "on p1.persona_codigo = per.persona_codigo\n"
                + "where p.persona_cedula='" + cedula + "'";
        try {

            ResultSet res = conn.query(sql);
            String[] cabecera = {"Beneficiaria", "Motivo Consulta", "Relación Hechos", "Aspecto relevantes", "Fecha", "Abogada"};
            modelo.setColumnIdentifiers(cabecera);
            modelo.addRow(cabecera);
            while (res.next()) {

                modelo.addRow(new Object[]{res.getString(1), res.getString(2), res.getString(3),
                    res.getString(4), res.getString(5), res.getString(6)});
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Surgió un error inesperado", "Información", JOptionPane.ERROR_MESSAGE);
        }
        return modelo;
    }
}
