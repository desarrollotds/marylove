package marylove.models;

import java.util.Date;

public class Agresor extends Persona{

    private int codigo_agresor;
    private int persona_codigo;
    
    //variables extra
    private String parentesco;

    public int getCodigo_agresor() {
        return codigo_agresor;
    }

    public Agresor(String persona_cedula, String persona_nombre, String persona_apellido, Date persona_fecha_nac, String persona_telefono, String persona_celular, char persona_sexo,String parentesco) {
        super(persona_cedula, persona_nombre, persona_apellido, persona_fecha_nac, persona_telefono, persona_celular, persona_sexo);
        this.parentesco=parentesco;
    }

    public String getParentesco() {
        return parentesco;
    }

    public void setParentesco(String parentesco) {
        this.parentesco = parentesco;
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

    public Agresor(int persona_codigo) {
        this.persona_codigo = persona_codigo;
        
    }
    

}
