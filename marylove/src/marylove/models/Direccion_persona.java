
package marylove.models;

/**
 *
 * @author icrv9
 */
public class Direccion_persona extends Direccion{
    
    private int dirper_id;
    private int persona_codigo;
    private int dir_domicilio;

    public Direccion_persona(int dirper_id, int persona_codigo, int dir_domicilio) {
        this.dirper_id = dirper_id;
        this.persona_codigo = persona_codigo;
        this.dir_domicilio = dir_domicilio;
    }
    
    public Direccion_persona() {
    }

    public Direccion_persona(int persona_codigo, int dir_domicilio) {
        this.persona_codigo = persona_codigo;
        this.dir_domicilio = dir_domicilio;
    }

    public int getDirper_id() {
        return dirper_id;
    }

    public void setDirper_id(int dirper_id) {
        this.dirper_id = dirper_id;
    }

    public int getPersona_codigo() {
        return persona_codigo;
    }

    public void setPersona_codigo(int persona_codigo) {
        this.persona_codigo = persona_codigo;
    }

    public int getDir_domicilio() {
        return dir_domicilio;
    }

    public void setDir_domicilio(int dir_domicilio) {
        this.dir_domicilio = dir_domicilio;
    }

    
    
}


