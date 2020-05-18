package marylove.models;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;


/**
 *
 * @author Alumno
 */
public class ArticulosEntregados   {

    private int articulo_id;
    private int ingreso_id;
    private String articulo_descripcion;
    private String articulo_observaciones;
    private int articulo_cantidad;


    public ArticulosEntregados() {
    }

    public ArticulosEntregados(int articulo_id, int ingreso_id, String articulo_descripcion, String articulo_observaciones, int articulo_cantidad) {
        this.articulo_id = articulo_id;
        this.ingreso_id = ingreso_id;
        this.articulo_descripcion = articulo_descripcion;
        this.articulo_observaciones = articulo_observaciones;
        this.articulo_cantidad = articulo_cantidad;
    }

    public int getArticulo_id() {
        return articulo_id;
    }

    public void setArticulo_id(int articulo_id) {
        this.articulo_id = articulo_id;
    }

    public int getIngreso_id() {
        return ingreso_id;
    }

    public void setIngreso_id(int ingreso_id) {
        this.ingreso_id = ingreso_id;
    }

    public String getArticulo_descripcion() {
        return articulo_descripcion;
    }

    public void setArticulo_descripcion(String articulo_descripcion) {
        this.articulo_descripcion = articulo_descripcion;
    }

    public String getArticulo_observaciones() {
        return articulo_observaciones;
    }

    public void setArticulo_observaciones(String articulo_observaciones) {
        this.articulo_observaciones = articulo_observaciones;
    }

    public int getArticulo_cantidad() {
        return articulo_cantidad;
    }

    public void setArticulo_cantidad(int articulo_cantidad) {
        this.articulo_cantidad = articulo_cantidad;
    }

}
