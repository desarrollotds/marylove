package marylove.models;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;


/**
 *
 * @author Alumno
 */
public class ArticulosEntregados  extends Persona {

    private int articulo_id;
    private int ingreso_id;
    private String articulo_descripcion;
    private String articulo_observaciones;
    private int articulo_cantidad;

    public ArticulosEntregados(int articulo_id, int ingreso_id, String articulo_descripcion, String articulo_observaciones, int articulo_cantidad) {
        this.articulo_id = articulo_id;
        this.ingreso_id = ingreso_id;
        this.articulo_descripcion = articulo_descripcion;
        this.articulo_observaciones = articulo_observaciones;
        this.articulo_cantidad = articulo_cantidad;
    }

    public ArticulosEntregados(int articulo_id, int ingreso_id, String articulo_descripcion, String articulo_observaciones, int articulo_cantidad, String persona_cedula, String persona_nombre, String persona_apellido, Date persona_fecha_nac, String persona_telefono, String persona_celular, char persona_sexo) {
        super(persona_cedula, persona_nombre, persona_apellido, persona_fecha_nac, persona_telefono, persona_celular, persona_sexo);
        this.articulo_id = articulo_id;
        this.ingreso_id = ingreso_id;
        this.articulo_descripcion = articulo_descripcion;
        this.articulo_observaciones = articulo_observaciones;
        this.articulo_cantidad = articulo_cantidad;
    }

    public ArticulosEntregados(int articulo_id, int ingreso_id, String articulo_descripcion, String articulo_observaciones, int articulo_cantidad, String persona_cedula, String persona_nombre, String persona_apellido, String persona_telefono, String persona_celular) {
        super(persona_cedula, persona_nombre, persona_apellido, persona_telefono, persona_celular);
        this.articulo_id = articulo_id;
        this.ingreso_id = ingreso_id;
        this.articulo_descripcion = articulo_descripcion;
        this.articulo_observaciones = articulo_observaciones;
        this.articulo_cantidad = articulo_cantidad;
    }

    public ArticulosEntregados(int articulo_id, int ingreso_id, String articulo_descripcion, String articulo_observaciones, int articulo_cantidad, String persona_cedula, String persona_nombre, String persona_apellido, Date persona_fecha_nac, char persona_sexo) {
        super(persona_cedula, persona_nombre, persona_apellido, persona_fecha_nac, persona_sexo);
        this.articulo_id = articulo_id;
        this.ingreso_id = ingreso_id;
        this.articulo_descripcion = articulo_descripcion;
        this.articulo_observaciones = articulo_observaciones;
        this.articulo_cantidad = articulo_cantidad;
    }

    public ArticulosEntregados(int articulo_id, int ingreso_id, String articulo_descripcion, String articulo_observaciones, int articulo_cantidad, int persona_codigo, String persona_cedula, String persona_nombre, String persona_apellido, Date persona_fecha_nac, int persona_ocupacion, int persona_nivel_acad, int persona_est_migr, String persona_telefono, String persona_celular, int persona_estadocivil, int persona_nacionalidad, boolean persona_estado_actual, char persona_sexo, String persona_nivel_acad_otros, String persona_lugar_trabajo, String persona_referencia) {
        super(persona_codigo, persona_cedula, persona_nombre, persona_apellido, persona_fecha_nac, persona_ocupacion, persona_nivel_acad, persona_est_migr, persona_telefono, persona_celular, persona_estadocivil, persona_nacionalidad, persona_estado_actual, persona_sexo, persona_nivel_acad_otros, persona_lugar_trabajo, persona_referencia);
        this.articulo_id = articulo_id;
        this.ingreso_id = ingreso_id;
        this.articulo_descripcion = articulo_descripcion;
        this.articulo_observaciones = articulo_observaciones;
        this.articulo_cantidad = articulo_cantidad;
    }

    public ArticulosEntregados(int articulo_id, int ingreso_id, String articulo_descripcion, String articulo_observaciones, int articulo_cantidad, String persona_cedula, String persona_nombre, String persona_apellido, Date persona_fecha_nac, int persona_ocupacion, int persona_nivel_acad, int persona_est_migr, String persona_telefono, String persona_celular, int persona_estadocivil, int persona_nacionalidad, boolean persona_estado_actual, char persona_sexo, String persona_nivel_acad_otros, String persona_lugar_trabajo, String persona_referencia) {
        super(persona_cedula, persona_nombre, persona_apellido, persona_fecha_nac, persona_ocupacion, persona_nivel_acad, persona_est_migr, persona_telefono, persona_celular, persona_estadocivil, persona_nacionalidad, persona_estado_actual, persona_sexo, persona_nivel_acad_otros, persona_lugar_trabajo, persona_referencia);
        this.articulo_id = articulo_id;
        this.ingreso_id = ingreso_id;
        this.articulo_descripcion = articulo_descripcion;
        this.articulo_observaciones = articulo_observaciones;
        this.articulo_cantidad = articulo_cantidad;
    }

    public ArticulosEntregados() {
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
