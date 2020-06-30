package marylove.DBmodelo;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import marylove.conexion.ConexionHi;
import marylove.models.ArticulosEntregados;

/**
 *
 * @author usuario
 */
public class ArticulosEntregadosDB extends ArticulosEntregados {

    ConexionHi conectar = new ConexionHi();

    public ArticulosEntregadosDB(int articulo_id, int ingreso_id, String articulo_descripcion, String articulo_observaciones, int articulo_cantidad, String articulo_estado) {
        super(articulo_id, ingreso_id, articulo_descripcion, articulo_observaciones, articulo_cantidad, articulo_estado);
    }

    public ArticulosEntregadosDB(int articulo_id, int ingreso_id, String articulo_descripcion, String articulo_observaciones, int articulo_cantidad, String articulo_estado, int persona_codigo, String persona_cedula, String persona_nombre, String persona_apellido, Date persona_fecha_nac, int persona_ocupacion, int persona_nivel_acad, int persona_est_migr, String persona_telefono, String persona_celular, int persona_estadocivil, int persona_nacionalidad, boolean persona_estado_actual, char persona_sexo, String persona_nivel_acad_otros, String persona_lugar_trabajo, String persona_referencia, int edad) {
        super(articulo_id, ingreso_id, articulo_descripcion, articulo_observaciones, articulo_cantidad, articulo_estado, persona_codigo, persona_cedula, persona_nombre, persona_apellido, persona_fecha_nac, persona_ocupacion, persona_nivel_acad, persona_est_migr, persona_telefono, persona_celular, persona_estadocivil, persona_nacionalidad, persona_estado_actual, persona_sexo, persona_nivel_acad_otros, persona_lugar_trabajo, persona_referencia, edad);
    }

    public ArticulosEntregadosDB(int articulo_id, int ingreso_id, String articulo_descripcion, String articulo_observaciones, int articulo_cantidad, String articulo_estado, String persona_cedula, String persona_nombre, String persona_apellido, Date persona_fecha_nac, String persona_telefono, String persona_celular, char persona_sexo) {
        super(articulo_id, ingreso_id, articulo_descripcion, articulo_observaciones, articulo_cantidad, articulo_estado, persona_cedula, persona_nombre, persona_apellido, persona_fecha_nac, persona_telefono, persona_celular, persona_sexo);
    }

    public ArticulosEntregadosDB(int articulo_id, int ingreso_id, String articulo_descripcion, String articulo_observaciones, int articulo_cantidad, String articulo_estado, String persona_cedula, String persona_nombre, String persona_apellido, String persona_telefono, String persona_celular) {
        super(articulo_id, ingreso_id, articulo_descripcion, articulo_observaciones, articulo_cantidad, articulo_estado, persona_cedula, persona_nombre, persona_apellido, persona_telefono, persona_celular);
    }

    public ArticulosEntregadosDB(int articulo_id, int ingreso_id, String articulo_descripcion, String articulo_observaciones, int articulo_cantidad, String articulo_estado, String persona_cedula, String persona_nombre, String persona_apellido, Date persona_fecha_nac, char persona_sexo) {
        super(articulo_id, ingreso_id, articulo_descripcion, articulo_observaciones, articulo_cantidad, articulo_estado, persona_cedula, persona_nombre, persona_apellido, persona_fecha_nac, persona_sexo);
    }

    public ArticulosEntregadosDB(int articulo_id, int ingreso_id, String articulo_descripcion, String articulo_observaciones, int articulo_cantidad, String articulo_estado, int persona_codigo, String persona_cedula, String persona_nombre, String persona_apellido, Date persona_fecha_nac, int persona_ocupacion, int persona_nivel_acad, int persona_est_migr, String persona_telefono, String persona_celular, int persona_estadocivil, int persona_nacionalidad, boolean persona_estado_actual, char persona_sexo, String persona_nivel_acad_otros, String persona_lugar_trabajo, String persona_referencia) {
        super(articulo_id, ingreso_id, articulo_descripcion, articulo_observaciones, articulo_cantidad, articulo_estado, persona_codigo, persona_cedula, persona_nombre, persona_apellido, persona_fecha_nac, persona_ocupacion, persona_nivel_acad, persona_est_migr, persona_telefono, persona_celular, persona_estadocivil, persona_nacionalidad, persona_estado_actual, persona_sexo, persona_nivel_acad_otros, persona_lugar_trabajo, persona_referencia);
    }

    public ArticulosEntregadosDB(int articulo_id, int ingreso_id, String articulo_descripcion, String articulo_observaciones, int articulo_cantidad, String articulo_estado, String persona_cedula, String persona_nombre, String persona_apellido, Date persona_fecha_nac, int persona_ocupacion, int persona_nivel_acad, int persona_est_migr, String persona_telefono, String persona_celular, int persona_estadocivil, int persona_nacionalidad, boolean persona_estado_actual, char persona_sexo, String persona_nivel_acad_otros, String persona_lugar_trabajo, String persona_referencia) {
        super(articulo_id, ingreso_id, articulo_descripcion, articulo_observaciones, articulo_cantidad, articulo_estado, persona_cedula, persona_nombre, persona_apellido, persona_fecha_nac, persona_ocupacion, persona_nivel_acad, persona_est_migr, persona_telefono, persona_celular, persona_estadocivil, persona_nacionalidad, persona_estado_actual, persona_sexo, persona_nivel_acad_otros, persona_lugar_trabajo, persona_referencia);
    }

    public ArticulosEntregadosDB() {
    }

    

    public List<ArticulosEntregados> listartEnt(int cod) throws SQLException {
        List<ArticulosEntregados> listartEnt = new ArrayList<ArticulosEntregados>();
        String sql = "select * from articulo_entregados ae \n"
                + "join ingreso i\n"
                + "on ae.ingreso_id = i.ingreso_id\n"
                + "where i.victima_codigo='" + cod + "'"
                + "and articulo_estado = 'a';";
        ResultSet rs = conectar.query(sql);
        try {
            while (rs.next()) {
                ArticulosEntregados p = new ArticulosEntregados();
                p.setArticulo_id(rs.getInt("articulo_id"));
                p.setArticulo_descripcion(rs.getString("articulo_descripcion"));
                p.setArticulo_observaciones(rs.getString("articulo_observaciones"));
                p.setArticulo_cantidad(rs.getInt("articulo_cantidad"));
                listartEnt.add(p);
            }
            rs.close();
            return listartEnt;
        } catch (SQLException ex) {
            Logger.getLogger(ConexionHi.class.getName()).log(Level.SEVERE, null, ex);
            conectar.cerrarConexion();
            return null;
        }

    }

    public boolean insertarArtEntr() throws SQLException {
        String sql = "INSERT INTO articulo_entregados(ingreso_id,articulo_descripcion, articulo_observaciones,articulo_cantidad, articulo_estado)";
        sql += "VALUES";
        sql += " (" + getIngreso_id() + ",' " + getArticulo_descripcion() + " ',' " + getArticulo_observaciones() + " ',' " + getArticulo_cantidad() + "','a')";
        return conectar.noQuery(sql);
    }

    public boolean actualizarEditArtEnt() {
        String sql = "UPDATE articulo_entregados SET ";
        sql += "articulo_descripcion='" + getArticulo_descripcion() + "', ";
        sql += "articulo_observaciones='" + getArticulo_observaciones() + "', ";
        sql += "articulo_cantidad='" + getArticulo_cantidad() + "'";
        sql += " WHERE articulo_id='" + getArticulo_id() + "'";
        return conectar.noQuery(sql);
    }

    public List<ArticulosEntregados> listarArtEntTodo() {
        List<ArticulosEntregados> listarArtEnt = new ArrayList<>();
        String sql = "select ae.articulo_id, pe.persona_cedula, pe.persona_nombre, pe.persona_apellido, ae.articulo_descripcion, ae.articulo_observaciones, ae.articulo_cantidad\n"
                + "from victima vc join persona as pe on vc.persona_codigo = pe.persona_codigo inner join ingreso i\n"
                + "on i.victima_codigo = vc.victima_codigo inner join articulo_entregados ae on ae.ingreso_id = i.ingreso_id"
                + " where articulo_estado = 'a'; ";
        ResultSet rs = conectar.query(sql);
        try {
            while (rs.next()) {
                ArticulosEntregados i = new ArticulosEntregados();
                i.setArticulo_id(rs.getInt("articulo_id"));
                i.setPersona_cedula(rs.getString("persona_cedula"));
                i.setPersona_nombre(rs.getString("persona_nombre"));
                i.setPersona_apellido(rs.getString("persona_apellido"));
                i.setArticulo_descripcion(rs.getString("articulo_descripcion"));
                i.setArticulo_observaciones(rs.getString("articulo_observaciones"));
                i.setArticulo_cantidad(rs.getInt("articulo_cantidad"));
                listarArtEnt.add(i);
            }
            rs.close();
            return listarArtEnt;
        } catch (SQLException ex) {
            Logger.getLogger(ConexionHi.class.getName()).log(Level.SEVERE, null, ex);
            conectar.cerrarConexion();
            return null;
        }
    }
    
    public List<ArticulosEntregados> BuscarArtEnt(String texto) {
        List<ArticulosEntregados> listarArtEnt = new ArrayList<>();
        String sql = "select ae.articulo_id, pe.persona_cedula, pe.persona_nombre, pe.persona_apellido, ae.articulo_descripcion, ae.articulo_observaciones, ae.articulo_cantidad\n"
                + "from victima vc join persona as pe on vc.persona_codigo = pe.persona_codigo inner join ingreso i\n"
                + "on i.victima_codigo = vc.victima_codigo inner join articulo_entregados ae on ae.ingreso_id = i.ingreso_id\n"
                + "where articulo_estado = 'a ' and pe.persona_cedula like '" + texto + "%'\n"
                + " or pe.persona_nombre like '" + texto + "%'\n"
                + " or pe.persona_apellido like '" + texto + "%';";
        ResultSet rs = conectar.query(sql);
        try {
            while (rs.next()) {
                ArticulosEntregados i = new ArticulosEntregados();
                i.setArticulo_id(rs.getInt("articulo_id"));
                i.setPersona_cedula(rs.getString("persona_cedula"));
                i.setPersona_nombre(rs.getString("persona_nombre"));
                i.setPersona_apellido(rs.getString("persona_apellido"));
                i.setArticulo_descripcion(rs.getString("articulo_descripcion"));
                i.setArticulo_observaciones(rs.getString("articulo_observaciones"));
                i.setArticulo_cantidad(rs.getInt("articulo_cantidad"));
                listarArtEnt.add(i);
            }
            rs.close();
            return listarArtEnt;
        } catch (SQLException ex) {
            Logger.getLogger(ConexionHi.class.getName()).log(Level.SEVERE, null, ex);
            conectar.cerrarConexion();
            return null;
        }
    }
    
    public boolean eliminarArtEnt() {
        String sql = "UPDATE articulo_entregados SET articulo_estado = 'd' WHERE articulo_id='" + getArticulo_id()+ "'";
        return conectar.noQuery(sql) == true;
    }
}
