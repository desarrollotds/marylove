package marylove.models;
public class Victima extends Persona {
    private int victima_codigo,persona_codigo;
    private String victima_estado;

 

    public int getPersona_codigo() {
        return persona_codigo;
    }

    public void setPersona_codigo(int persona_codigo) {
        this.persona_codigo = persona_codigo;
    }
    
    public int getVictima_codigo() {
        return victima_codigo;
    }

    public void setVictima_codigo(int victima_codigo) {
        this.victima_codigo = victima_codigo;
    }

    public String getVictima_estado() {
        return victima_estado;
    }

    public void setVictima_estado(String victima_estado) {
        this.victima_estado = victima_estado;
    }
    
}
