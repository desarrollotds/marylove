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
}
