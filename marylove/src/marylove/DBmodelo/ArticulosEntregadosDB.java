package marylove.DBmodelo;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
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

    ConexionHi conectar;// = new ConexionHi();

    public ArticulosEntregadosDB() {
    }
    
    public ArticulosEntregadosDB(int articulo_id, int ingreso_id, String articulo_descripcion, String articulo_observaciones, int articulo_cantidad) {
        super(articulo_id, ingreso_id, articulo_descripcion, articulo_observaciones, articulo_cantidad);
    }

    public List<ArticulosEntregados> listartEnt(int cod) throws SQLException {
        List<ArticulosEntregados> listartEnt = new ArrayList<ArticulosEntregados>();
        String sql = "select * from articulo_entregados ae \n" +
                     "join ingreso i\n" +
                     "on ae.ingreso_id = i.ingreso_id\n" +
                     "where i.victima_codigo='"+cod+"';";
//        sql += "order by 1";
        ResultSet rs = conectar.query(sql);
        try {
            while (rs.next()) {
                ArticulosEntregados p = new ArticulosEntregados();
//                p.setArticulo_descripcion(rs.getInt("ruc"));
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
            return null;
        }

    }

    public boolean insertarArtEntr() {
        String sql = "INSERT INTO articulo_entregados(ingreso_id,articulo_descripcion, articulo_observaciones,articulo_cantidad)";
        sql += "VALUES";
        sql += " (" +getIngreso_id() + ",' " +getArticulo_descripcion() + " ',' " + getArticulo_observaciones() + " ',' " + getArticulo_cantidad() + "')";
        PreparedStatement ps = conectar.getPs(sql);
        if (conectar.noQuery(sql) == null) {
            return true;
        } else {
            return false;
        }
    }
    
    public boolean actualizarEditArtEnt() {
        String sql = "UPDATE articulo_entregados SET ";
        sql += "articulo_descripcion='" + getArticulo_descripcion() + "', ";
        sql += "articulo_observaciones='" + getArticulo_observaciones()+ "', ";
        sql += "articulo_cantidad='" + getArticulo_cantidad()+ "'";
        sql += " WHERE articulo_id='" + getArticulo_id()+ "'";

        if (conectar.noQuery(sql) == null) {
            return true;
        } else {
            return false;
        }
    }
}
