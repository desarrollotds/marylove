package marylove.models;

public class Agresor {

    private int codigo_agresor;
    private int persona_codigo;
    private int parentesco;

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

    public int getParentesco() {
        return parentesco;
    }

    public void setParentesco(int parentesco) {
        this.parentesco = parentesco;
    }

    public Agresor(int persona_codigo, int parentesco) {
        this.persona_codigo = persona_codigo;
        this.parentesco = parentesco;
    }
    

}
