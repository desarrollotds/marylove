package marylove.models;

public class Hijos {
private int persona_codigo, hijo_codigo, victima_codigo,institucion_codigo,padre_id,nacimiento_id, postParto_id;
private String anioEsc_hijo,estado_hijo,estadoIng_hijo;
private boolean padre_agresor;

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

    public int getPadre_id() {
        return padre_id;
    }

    public void setPadre_id(int padre_id) {
        this.padre_id = padre_id;
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

    public String getAnioEsc_hijo() {
        return anioEsc_hijo;
    }

    public void setAnioEsc_hijo(String anioEsc_hijo) {
        this.anioEsc_hijo = anioEsc_hijo;
    }

    public String getEstado_hijo() {
        return estado_hijo;
    }

    public void setEstado_hijo(String estado_hijo) {
        this.estado_hijo = estado_hijo;
    }

    public String getEstadoIng_hijo() {
        return estadoIng_hijo;
    }

    public void setEstadoIng_hijo(String estadoIng_hijo) {
        this.estadoIng_hijo = estadoIng_hijo;
    }

    public boolean isPadre_agresor() {
        return padre_agresor;
    }

    public void setPadre_agresor(boolean padre_agresor) {
        this.padre_agresor = padre_agresor;
    }

}
