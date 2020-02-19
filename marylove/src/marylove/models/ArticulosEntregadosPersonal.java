package marylove.models;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import marylove.conexion.Conexion;

/**
 *
 * @author Alumno
 */
public class ArticulosEntregadosPersonal {

    private int artentper_id;
    private int ingreso_id;
    private String artentper_nombre;
    private String artentper_observaciones;
    private int articulo_cantidad;
    Conexion conn;

    public ArticulosEntregadosPersonal(int artentper_id, int ingreso_id, String artentper_nombre, String artentper_observaciones, int articulo_cantidad) {
        this.artentper_id = artentper_id;
        this.ingreso_id = ingreso_id;
        this.artentper_nombre = artentper_nombre;
        this.artentper_observaciones = artentper_observaciones;
        this.articulo_cantidad = articulo_cantidad;
    }

    public ArticulosEntregadosPersonal() {
    }

    public int getArtentper_id() {
        return artentper_id;
    }

    public void setArtentper_id(int artentper_id) {
        this.artentper_id = artentper_id;
    }

    public int getIngreso_id() {
        return ingreso_id;
    }

    public void setIngreso_id(int ingreso_id) {
        this.ingreso_id = ingreso_id;
    }

    public String getArtentper_nombre() {
        return artentper_nombre;
    }

    public void setArtentper_nombre(String artentper_nombre) {
        this.artentper_nombre = artentper_nombre;
    }

    public String getArtentper_observaciones() {
        return artentper_observaciones;
    }

    public void setArtentper_observaciones(String artentper_observaciones) {
        this.artentper_observaciones = artentper_observaciones;
    }

    public int getArticulo_cantidad() {
        return articulo_cantidad;
    }

    public void setArticulo_cantidad(int articulo_cantidad) {
        this.articulo_cantidad = articulo_cantidad;
    }

    public void IngresarArticulosPersonal(ArticulosEntregadosPersonal articulosentregadospersonal) {
        try {
            conn = new Conexion();

            PreparedStatement ps;
            String sql = "INSERT INTO public.articulo_entregados"
                    + "(articulo_id, ingreso_id, articulo_descripcion, articulo_observaciones,articulo_cantidad) "
                    + "VALUES (?, ?, ?, ?, ?)";
            ps = conn.getConection().prepareStatement(sql);
            ps.execute();
            JOptionPane.showMessageDialog(null, "Articulo Agregado Correctamente");
            conn.cerrarConexion();
        } catch (SQLException ex) {
            Logger.getLogger(Persona.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public ArrayList<ArticulosEntregadosPersonal> listarArticulos() {
        ArrayList<ArticulosEntregadosPersonal> articulos;
        articulos = new ArrayList();
        try {
            conn = new Conexion();
            String sql = "SELECT artentper_id, ingreso_id, artentper_nombre, artentper_observaciones, articulo_cantidad "
                    + "FROM public.articulo_entre_personal";

            PreparedStatement ps = conn.getConection().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {

                System.out.println(rs.getString(1));

            }
        } catch (SQLException ex) {
            Logger.getLogger(Persona.class.getName()).log(Level.SEVERE, null, ex);
        }

        return articulos;
    }

}
