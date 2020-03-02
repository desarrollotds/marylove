/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package marylove.DBmodelo;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import marylove.conexion.Conexion;
import marylove.models.ArticulosEntregadosPersonal;

/**
 *
 * @author usuario
 */
public class ArticulosEntregadosPersonalDB extends ArticulosEntregadosPersonal {

    Conexion conectar = new Conexion();

    public ArticulosEntregadosPersonalDB(int artentper_id, int ingreso_id, String artentper_nombre, String artentper_observaciones, int articulo_cantidad) {
        super(artentper_id, ingreso_id, artentper_nombre, artentper_observaciones, articulo_cantidad);
    }

    public ArticulosEntregadosPersonalDB() {
    }

    public boolean InsertarArtEntrPers() {
        String sql = "INSERT INTO articulo_entre_personal(artentper_nombre, artentper_observaciones,articulo_cantidad)";
        sql += "VALUES";
        sql += " ('" + getArtentper_nombre() + " ',' " + getArtentper_observaciones()+ " ',' " + getArticulo_cantidad() + "')";
        PreparedStatement ps = conectar.getPs(sql);
        if (conectar.noQuery(sql) == null) {
            return true;
        } else {
            return false;
        }
    }
    
     public List<ArticulosEntregadosPersonal> listartEntPers() throws SQLException {
        List<ArticulosEntregadosPersonal> listartEntPers = new ArrayList<ArticulosEntregadosPersonal>();
        String sql = "select* from articulo_entre_personal";
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
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }

    }
     
     public boolean actualizarEditArtEntPers() {
        String sql = "UPDATE articulo_entre_personal SET ";
        sql += "artentper_nombre='" + getArtentper_nombre() + "', ";
        sql += "artentper_observaciones='" + getArtentper_observaciones()+ "', ";
        sql += "articulo_cantidad='" + getArticulo_cantidad()+ "'";
        sql += " WHERE artentper_id='" + getArtentper_id()+ "'";

        if (conectar.noQuery(sql) == null) {
            return true;
        } else {
            return false;
        }
    }

}
