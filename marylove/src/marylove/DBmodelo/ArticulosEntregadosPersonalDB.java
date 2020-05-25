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
import marylove.models.ArticulosEntregadosPersonal;

public class ArticulosEntregadosPersonalDB extends ArticulosEntregadosPersonal {

    ConexionHi conectar= new ConexionHi();

    public ArticulosEntregadosPersonalDB(int artentper_id, int ingreso_id, String artentper_nombre, String artentper_observaciones, int articulo_cantidad, String articulo_estado) {
        super(artentper_id, ingreso_id, artentper_nombre, artentper_observaciones, articulo_cantidad, articulo_estado);
    }

    public ArticulosEntregadosPersonalDB(int artentper_id, int ingreso_id, String artentper_nombre, String artentper_observaciones, int articulo_cantidad, String articulo_estado, int persona_codigo, String persona_cedula, String persona_nombre, String persona_apellido, Date persona_fecha_nac, int persona_ocupacion, int persona_nivel_acad, int persona_est_migr, String persona_telefono, String persona_celular, int persona_estadocivil, int persona_nacionalidad, boolean persona_estado_actual, char persona_sexo, String persona_nivel_acad_otros, String persona_lugar_trabajo, String persona_referencia, int edad) {
        super(artentper_id, ingreso_id, artentper_nombre, artentper_observaciones, articulo_cantidad, articulo_estado, persona_codigo, persona_cedula, persona_nombre, persona_apellido, persona_fecha_nac, persona_ocupacion, persona_nivel_acad, persona_est_migr, persona_telefono, persona_celular, persona_estadocivil, persona_nacionalidad, persona_estado_actual, persona_sexo, persona_nivel_acad_otros, persona_lugar_trabajo, persona_referencia, edad);
    }

    public ArticulosEntregadosPersonalDB(int artentper_id, int ingreso_id, String artentper_nombre, String artentper_observaciones, int articulo_cantidad, String articulo_estado, String persona_cedula, String persona_nombre, String persona_apellido, Date persona_fecha_nac, String persona_telefono, String persona_celular, char persona_sexo) {
        super(artentper_id, ingreso_id, artentper_nombre, artentper_observaciones, articulo_cantidad, articulo_estado, persona_cedula, persona_nombre, persona_apellido, persona_fecha_nac, persona_telefono, persona_celular, persona_sexo);
    }

    public ArticulosEntregadosPersonalDB(int artentper_id, int ingreso_id, String artentper_nombre, String artentper_observaciones, int articulo_cantidad, String articulo_estado, String persona_cedula, String persona_nombre, String persona_apellido, String persona_telefono, String persona_celular) {
        super(artentper_id, ingreso_id, artentper_nombre, artentper_observaciones, articulo_cantidad, articulo_estado, persona_cedula, persona_nombre, persona_apellido, persona_telefono, persona_celular);
    }

    public ArticulosEntregadosPersonalDB(int artentper_id, int ingreso_id, String artentper_nombre, String artentper_observaciones, int articulo_cantidad, String articulo_estado, String persona_cedula, String persona_nombre, String persona_apellido, Date persona_fecha_nac, char persona_sexo) {
        super(artentper_id, ingreso_id, artentper_nombre, artentper_observaciones, articulo_cantidad, articulo_estado, persona_cedula, persona_nombre, persona_apellido, persona_fecha_nac, persona_sexo);
    }

    public ArticulosEntregadosPersonalDB(int artentper_id, int ingreso_id, String artentper_nombre, String artentper_observaciones, int articulo_cantidad, String articulo_estado, int persona_codigo, String persona_cedula, String persona_nombre, String persona_apellido, Date persona_fecha_nac, int persona_ocupacion, int persona_nivel_acad, int persona_est_migr, String persona_telefono, String persona_celular, int persona_estadocivil, int persona_nacionalidad, boolean persona_estado_actual, char persona_sexo, String persona_nivel_acad_otros, String persona_lugar_trabajo, String persona_referencia) {
        super(artentper_id, ingreso_id, artentper_nombre, artentper_observaciones, articulo_cantidad, articulo_estado, persona_codigo, persona_cedula, persona_nombre, persona_apellido, persona_fecha_nac, persona_ocupacion, persona_nivel_acad, persona_est_migr, persona_telefono, persona_celular, persona_estadocivil, persona_nacionalidad, persona_estado_actual, persona_sexo, persona_nivel_acad_otros, persona_lugar_trabajo, persona_referencia);
    }

    public ArticulosEntregadosPersonalDB(int artentper_id, int ingreso_id, String artentper_nombre, String artentper_observaciones, int articulo_cantidad, String articulo_estado, String persona_cedula, String persona_nombre, String persona_apellido, Date persona_fecha_nac, int persona_ocupacion, int persona_nivel_acad, int persona_est_migr, String persona_telefono, String persona_celular, int persona_estadocivil, int persona_nacionalidad, boolean persona_estado_actual, char persona_sexo, String persona_nivel_acad_otros, String persona_lugar_trabajo, String persona_referencia) {
        super(artentper_id, ingreso_id, artentper_nombre, artentper_observaciones, articulo_cantidad, articulo_estado, persona_cedula, persona_nombre, persona_apellido, persona_fecha_nac, persona_ocupacion, persona_nivel_acad, persona_est_migr, persona_telefono, persona_celular, persona_estadocivil, persona_nacionalidad, persona_estado_actual, persona_sexo, persona_nivel_acad_otros, persona_lugar_trabajo, persona_referencia);
    }

    public ArticulosEntregadosPersonalDB() {
    }

    

    public boolean InsertarArtEntrPers() throws SQLException {
        String sql = "INSERT INTO articulo_entre_personal(ingreso_id,artentper_nombre, artentper_observaciones,articulo_cantidad, articulo_estado)";
        sql += "VALUES";
        sql += " (" + getIngreso_id() + ",' " + getArtentper_nombre() + " ',' " + getArtentper_observaciones() + " ',' " + getArticulo_cantidad() + "','a')";
        PreparedStatement ps = conectar.getConnection().prepareStatement(sql);
        if (conectar.noQuery(sql) == true) {
            return true;
        } else {
            return false;
        }
    }

    public List<ArticulosEntregadosPersonal> listartEntPers(int cod) throws SQLException {
        List<ArticulosEntregadosPersonal> listartEntPers = new ArrayList<>();
        String sql = "select * from articulo_entre_personal aep \n"
                + "join ingreso i\n"
                + "on aep.ingreso_id = i.ingreso_id\n"
                + "where i.victima_codigo='" + cod + "'"
                + " and articulo_estado = 'a';";
//        sql += "order by 1";
        ResultSet rs = conectar.query(sql);
        try {
            while (rs.next()) {
                ArticulosEntregadosPersonal p = new ArticulosEntregadosPersonal();
//                p.setArticulo_descripcion(rs.getInt("ruc"));
                p.setArtentper_id(rs.getInt("artentper_id"));
                p.setArtentper_nombre(rs.getString("artentper_nombre"));
                p.setArtentper_observaciones(rs.getString("artentper_observaciones"));
                p.setArticulo_cantidad(rs.getInt("articulo_cantidad"));
                listartEntPers.add(p);
            }
            rs.close();
            return listartEntPers;
        } catch (SQLException ex) {
            Logger.getLogger(ConexionHi.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }

    }

    public boolean actualizarEditArtEntPers() {
        String sql = "UPDATE articulo_entre_personal SET ";
        sql += "artentper_nombre='" + getArtentper_nombre() + "', ";
        sql += "artentper_observaciones='" + getArtentper_observaciones() + "', ";
        sql += "articulo_cantidad='" + getArticulo_cantidad() + "'";
        sql += " WHERE artentper_id='" + getArtentper_id() + "'";

        if (conectar.noQuery(sql) == true) {
            return true;
        } else {
            return false;
        }
    }

    public List<ArticulosEntregadosPersonal> listarArtEntBenef() {
        List<ArticulosEntregadosPersonal> listarArtEntBenef = new ArrayList<>();
        String sql = "select aep.artentper_id, pe.persona_cedula, pe.persona_nombre, pe.persona_apellido, aep.artentper_nombre, aep.artentper_observaciones, aep.articulo_cantidad\n"
                + "from articulo_entre_personal aep join ingreso as i on aep.ingreso_id = i.ingreso_id\n"
                + "inner join  victima vc on i.victima_codigo = vc.victima_codigo inner join persona pe on\n"
                + "vc.persona_codigo = pe.persona_codigo"
                + " where articulo_estado = 'a'; ";
        ResultSet rs = conectar.query(sql);
        try {
            while (rs.next()) {
                ArticulosEntregadosPersonal i = new ArticulosEntregadosPersonal();
                i.setArtentper_id(rs.getInt("artentper_id"));
                i.setPersona_cedula("persona_cedula");
                i.setPersona_nombre(rs.getString("persona_nombre"));
                i.setPersona_apellido(rs.getString("persona_apellido"));
                i.setArtentper_nombre(rs.getString("articulo_descripcion"));
                i.setArticulo_cantidad(rs.getInt("articulo_observaciones"));
                i.setArtentper_observaciones(rs.getString("articulo_cantidad"));
                listarArtEntBenef.add(i);
            }
            rs.close();
            conectar.cerrarConexion();
            return listarArtEntBenef;
        } catch (SQLException ex) {
            Logger.getLogger(ConexionHi.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
    
    public List<ArticulosEntregadosPersonal> BuscarArtEntBenef(String texto) {
        List<ArticulosEntregadosPersonal> listarArtEntBenef = new ArrayList<>();
        String sql = "select aep.artentper_id, pe.persona_cedula, pe.persona_nombre, pe.persona_apellido, aep.artentper_nombre, aep.artentper_observaciones, aep.articulo_cantidad\n"
                + "from articulo_entre_personal aep join ingreso as i on aep.ingreso_id = i.ingreso_id\n"
                + "inner join  victima vc on i.victima_codigo = vc.victima_codigo inner join persona pe on\n"
                + "vc.persona_codigo = pe.persona_codigo \n"
                + "where articulo_estado = 'a' and pe.persona_cedula like '" + texto + "%'\n"
                + " or pe.persona_nombre like '" + texto + "%'\n"
                + " or pe.persona_apellido like '" + texto + "%';";
        ResultSet rs = conectar.query(sql);
        try {
            while (rs.next()) {
                ArticulosEntregadosPersonal i = new ArticulosEntregadosPersonal();
                i.setArtentper_id(rs.getInt("artentper_id"));
                i.setPersona_cedula("persona_cedula");
                i.setPersona_nombre(rs.getString("persona_nombre"));
                i.setPersona_apellido(rs.getString("persona_apellido"));
                i.setArtentper_nombre(rs.getString("articulo_descripcion"));
                i.setArticulo_cantidad(rs.getInt("articulo_observaciones"));
                i.setArtentper_observaciones(rs.getString("articulo_cantidad"));
                listarArtEntBenef.add(i);
            }
            rs.close();
            conectar.cerrarConexion();
            return listarArtEntBenef;
        } catch (SQLException ex) {
            Logger.getLogger(ConexionHi.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
    
    public boolean eliminarArtEntPers() {
        String sql = "UPDATE articulo_entre_personal SET articulo_estado = 'd' WHERE artentper_id='" + getArtentper_id()+ "'";
        if (conectar.noQuery(sql) == true) {
            return true;
        } else {
            return false;
        }
    }
}
