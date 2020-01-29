package marylove.models;

public class Hijos {

    private int persona_codigo;
    private int hijo_codigo;
    private int victima_codigo;
    private int institucion_codigo;
    private String hijo_anioescolar;
    private String hijo_estado;
    private int padre_id;
    private boolean padre_agresor;
    private String hijo_estado_ingreso;
    private int nacimiento_id;
    private int postParto_id;

    public Hijos() {
    }

    public Hijos(int persona_codigo, int hijo_codigo, int victima_codigo, int institucion_codigo, String hijo_anioescolar, String hijo_estado, int padre_id, boolean padre_agresor, String hijo_estado_ingreso, int nacimiento_id, int postParto_id) {
        this.persona_codigo = persona_codigo;
        this.hijo_codigo = hijo_codigo;
        this.victima_codigo = victima_codigo;
        this.institucion_codigo = institucion_codigo;
        this.hijo_anioescolar = hijo_anioescolar;
        this.hijo_estado = hijo_estado;
        this.padre_id = padre_id;
        this.padre_agresor = padre_agresor;
        this.hijo_estado_ingreso = hijo_estado_ingreso;
        this.nacimiento_id = nacimiento_id;
        this.postParto_id = postParto_id;
    }

    public int getPersona_codigo() {
        return persona_codigo;
    }

    public void setPersona_codigo(int persona_codigo) {
        this.persona_codigo = persona_codigo;
    }

    public int getHijo_codigo() {
        return hijo_codigo;
    }

    public void setHijo_codigo(int hijo_codigo) {
        this.hijo_codigo = hijo_codigo;
    }

    public int getVictima_codigo() {
        return victima_codigo;
    }

    public void setVictima_codigo(int victima_codigo) {
        this.victima_codigo = victima_codigo;
    }

    public int getInstitucion_codigo() {
        return institucion_codigo;
    }

    public void setInstitucion_codigo(int institucion_codigo) {
        this.institucion_codigo = institucion_codigo;
    }

    public String getHijo_anioescolar() {
        return hijo_anioescolar;
    }

    public void setHijo_anioescolar(String hijo_anioescolar) {
        this.hijo_anioescolar = hijo_anioescolar;
    }

    public String getHijo_estado() {
        return hijo_estado;
    }

    public void setHijo_estado(String hijo_estado) {
        this.hijo_estado = hijo_estado;
    }

    public int getPadre_id() {
        return padre_id;
    }

    public void setPadre_id(int padre_id) {
        this.padre_id = padre_id;
    }

    public boolean isPadre_agresor() {
        return padre_agresor;
    }

    public void setPadre_agresor(boolean padre_agresor) {
        this.padre_agresor = padre_agresor;
    }

    public String getHijo_estado_ingreso() {
        return hijo_estado_ingreso;
    }

    public void setHijo_estado_ingreso(String hijo_estado_ingreso) {
        this.hijo_estado_ingreso = hijo_estado_ingreso;
    }

    public int getNacimiento_id() {
        return nacimiento_id;
    }

    public void setNacimiento_id(int nacimiento_id) {
        this.nacimiento_id = nacimiento_id;
    }

    public int getPostParto_id() {
        return postParto_id;
    }

    public void setPostParto_id(int postParto_id) {
        this.postParto_id = postParto_id;
    }

}
