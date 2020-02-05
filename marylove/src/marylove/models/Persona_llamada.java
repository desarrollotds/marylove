package marylove.models;
/**
 *
 * @author icrv9
 */
public class Persona_llamada {

    private int per_codigo;
    private String per_nombre;
    private String per_apellido;
    private String per_rango_edad;
    private String per_estado_civil;
    private int per_numerohijos;
    private String per_cargo;

    public Persona_llamada() {
    }

    public Persona_llamada(int per_codigo, String per_nombre, String per_apellido, String per_rango_edad, String per_estado_civil, int per_numerohijos, String per_cargo) {
        this.per_codigo = per_codigo;
        this.per_nombre = per_nombre;
        this.per_apellido = per_apellido;
        this.per_rango_edad = per_rango_edad;
        this.per_estado_civil = per_estado_civil;
        this.per_numerohijos = per_numerohijos;
        this.per_cargo = per_cargo;
    }

    public int getPer_codigo() {
        return per_codigo;
    }

    public void setPer_codigo(int per_codigo) {
        this.per_codigo = per_codigo;
    }

    public String getPer_nombre() {
        return per_nombre;
    }

    public void setPer_nombre(String per_nombre) {
        this.per_nombre = per_nombre;
    }

    public String getPer_apellido() {
        return per_apellido;
    }

    public void setPer_apellido(String per_apellido) {
        this.per_apellido = per_apellido;
    }

    public String getPer_rango_edad() {
        return per_rango_edad;
    }

    public void setPer_rango_edad(String per_rango_edad) {
        this.per_rango_edad = per_rango_edad;
    }

    public String getPer_estado_civil() {
        return per_estado_civil;
    }

    public void setPer_estado_civil(String per_estado_civil) {
        this.per_estado_civil = per_estado_civil;
    }

    public int getPer_numerohijos() {
        return per_numerohijos;
    }

    public void setPer_numerohijos(int per_numerohijos) {
        this.per_numerohijos = per_numerohijos;
    }

    public String getPer_cargo() {
        return per_cargo;
    }

    public void setPer_cargo(String per_cargo) {
        this.per_cargo = per_cargo;
    }

}

