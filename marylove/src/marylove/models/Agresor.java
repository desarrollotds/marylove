package marylove.models;

public class Agresor {

    private int codigo_agresor;
    private int persona_codigo;

    public int getCodigo_agresor() {
        return codigo_agresor;
    }

    public void setCodigo_agresor(int codigo_agresor) {
        this.codigo_agresor = codigo_agresor;
    }

    public int getPersona_codigo() {
        return persona_codigo;
    }

    public void setPersona_codigo(int persona_codigo) {
        this.persona_codigo = persona_codigo;
    }

    public Agresor() {
    }

    public Agresor(int codigo_agresor, int persona_codigo) {
        this.codigo_agresor = codigo_agresor;
        this.persona_codigo = persona_codigo;
    }

}
