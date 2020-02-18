package marylove.models;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import marylove.conexion.Conexion;


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
    Conexion conn;

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

    public void IngresarArticulos(ArticulosEntregados articulosentregados) {
        try {
            conn = new Conexion();

            PreparedStatement ps;
            String sql = "INSERT INTO public.articulo_entre_personal"
                    + "(artentper_id, ingreso_id, artentper_nombre, artentper_observaciones, articulo_cantidad)"
                    + "VALUES (?, ?, ?, ?,?)";
            ps = conn.getConection().prepareStatement(sql);
            ps.execute();
            JOptionPane.showMessageDialog(null,"Articulo Agregado Correctamente");
            conn.cerrarConexion();
        } catch (SQLException ex) {
            Logger.getLogger(Persona.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    
    public ArrayList <ArticulosEntregados> ListarArticulos(){
        ArrayList<ArticulosEntregados> articulos;
        articulos = new ArrayList();
        try {
            conn = new Conexion();
            String sql = "SELECT articulo_id, ingreso_id, articulo_descripcion, articulo_observaciones,articulo_cantidad"
                    + "FROM public.articulo_entregados;";

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
