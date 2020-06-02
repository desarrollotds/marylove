
package marylove.models;

import java.util.Date;

public class Familiars extends Persona{
    private int familiares_id;
    private int persona_codigoFam;
    private int hijo_codigoFam;
    private String parentescoFam;
    private boolean estadoFam;
    private int edadFam;

    public Familiars(int familiares_id, int persona_codigoFam, int hijo_codigoFam, String parentescoFam, boolean estadoFam, int edadFam) {
        this.familiares_id = familiares_id;
        this.persona_codigoFam = persona_codigoFam;
        this.hijo_codigoFam = hijo_codigoFam;
        this.parentescoFam = parentescoFam;
        this.estadoFam = estadoFam;
        this.edadFam = edadFam;
    }

    public Familiars() {
    }

    public int getFamiliares_id() {
        return familiares_id;
    }

    public void setFamiliares_id(int familiares_id) {
        this.familiares_id = familiares_id;
    }

    public int getPersona_codigoFam() {
        return persona_codigoFam;
    }

    public void setPersona_codigoFam(int persona_codigoFam) {
        this.persona_codigoFam = persona_codigoFam;
    }

    public int getHijo_codigoFam() {
        return hijo_codigoFam;
    }

    public void setHijo_codigoFam(int hijo_codigoFam) {
        this.hijo_codigoFam = hijo_codigoFam;
    }

    public String getParentescoFam() {
        return parentescoFam;
    }

    public void setParentescoFam(String parentescoFam) {
        this.parentescoFam = parentescoFam;
    }

    public boolean isEstadoFam() {
        return estadoFam;
    }

    public void setEstadoFam(boolean estadoFam) {
        this.estadoFam = estadoFam;
    }

    public int getEdadFam() {
        return edadFam;
    }

    public void setEdadFam(int edadFam) {
        this.edadFam = edadFam;
    }
    
    
}
