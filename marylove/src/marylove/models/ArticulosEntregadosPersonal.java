package marylove.models;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;


/**
 *
 * @author Alumno
 */
public class ArticulosEntregadosPersonal extends Persona{

    private int artentper_id;
    private int ingreso_id;
    private String artentper_nombre;
    private String artentper_observaciones;
    private int articulo_cantidad;

    public ArticulosEntregadosPersonal(int artentper_id, int ingreso_id, String artentper_nombre, String artentper_observaciones, int articulo_cantidad) {
        this.artentper_id = artentper_id;
        this.ingreso_id = ingreso_id;
        this.artentper_nombre = artentper_nombre;
        this.artentper_observaciones = artentper_observaciones;
        this.articulo_cantidad = articulo_cantidad;
    }

    public ArticulosEntregadosPersonal(int artentper_id, int ingreso_id, String artentper_nombre, String artentper_observaciones, int articulo_cantidad, String persona_cedula, String persona_nombre, String persona_apellido, Date persona_fecha_nac, String persona_telefono, String persona_celular, char persona_sexo) {
        super(persona_cedula, persona_nombre, persona_apellido, persona_fecha_nac, persona_telefono, persona_celular, persona_sexo);
        this.artentper_id = artentper_id;
        this.ingreso_id = ingreso_id;
        this.artentper_nombre = artentper_nombre;
        this.artentper_observaciones = artentper_observaciones;
        this.articulo_cantidad = articulo_cantidad;
    }

    public ArticulosEntregadosPersonal(int artentper_id, int ingreso_id, String artentper_nombre, String artentper_observaciones, int articulo_cantidad, String persona_cedula, String persona_nombre, String persona_apellido, String persona_telefono, String persona_celular) {
        super(persona_cedula, persona_nombre, persona_apellido, persona_telefono, persona_celular);
        this.artentper_id = artentper_id;
        this.ingreso_id = ingreso_id;
        this.artentper_nombre = artentper_nombre;
        this.artentper_observaciones = artentper_observaciones;
        this.articulo_cantidad = articulo_cantidad;
    }

    public ArticulosEntregadosPersonal(int artentper_id, int ingreso_id, String artentper_nombre, String artentper_observaciones, int articulo_cantidad, String persona_cedula, String persona_nombre, String persona_apellido, Date persona_fecha_nac, char persona_sexo) {
        super(persona_cedula, persona_nombre, persona_apellido, persona_fecha_nac, persona_sexo);
        this.artentper_id = artentper_id;
        this.ingreso_id = ingreso_id;
        this.artentper_nombre = artentper_nombre;
        this.artentper_observaciones = artentper_observaciones;
        this.articulo_cantidad = articulo_cantidad;
    }

    public ArticulosEntregadosPersonal(int artentper_id, int ingreso_id, String artentper_nombre, String artentper_observaciones, int articulo_cantidad, int persona_codigo, String persona_cedula, String persona_nombre, String persona_apellido, Date persona_fecha_nac, int persona_ocupacion, int persona_nivel_acad, int persona_est_migr, String persona_telefono, String persona_celular, int persona_estadocivil, int persona_nacionalidad, boolean persona_estado_actual, char persona_sexo, String persona_nivel_acad_otros, String persona_lugar_trabajo, String persona_referencia) {
        super(persona_codigo, persona_cedula, persona_nombre, persona_apellido, persona_fecha_nac, persona_ocupacion, persona_nivel_acad, persona_est_migr, persona_telefono, persona_celular, persona_estadocivil, persona_nacionalidad, persona_estado_actual, persona_sexo, persona_nivel_acad_otros, persona_lugar_trabajo, persona_referencia);
        this.artentper_id = artentper_id;
        this.ingreso_id = ingreso_id;
        this.artentper_nombre = artentper_nombre;
        this.artentper_observaciones = artentper_observaciones;
        this.articulo_cantidad = articulo_cantidad;
    }

    public ArticulosEntregadosPersonal(int artentper_id, int ingreso_id, String artentper_nombre, String artentper_observaciones, int articulo_cantidad, String persona_cedula, String persona_nombre, String persona_apellido, Date persona_fecha_nac, int persona_ocupacion, int persona_nivel_acad, int persona_est_migr, String persona_telefono, String persona_celular, int persona_estadocivil, int persona_nacionalidad, boolean persona_estado_actual, char persona_sexo, String persona_nivel_acad_otros, String persona_lugar_trabajo, String persona_referencia) {
        super(persona_cedula, persona_nombre, persona_apellido, persona_fecha_nac, persona_ocupacion, persona_nivel_acad, persona_est_migr, persona_telefono, persona_celular, persona_estadocivil, persona_nacionalidad, persona_estado_actual, persona_sexo, persona_nivel_acad_otros, persona_lugar_trabajo, persona_referencia);
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
