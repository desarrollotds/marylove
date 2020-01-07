package marylove.models;

public class Llamada {

    private int codigo_llamad, persona_cod, personal_cod;
    private String numero_llamad, fecha_llamad, hora_llamad, notasAdc_llamad;
    private boolean prioridad_llamad;

    public int getCodigo_llamad() {
        return codigo_llamad;
    }

    public void setCodigo_llamad(int codigo_llamad) {
        this.codigo_llamad = codigo_llamad;
    }

    public int getPersona_cod() {
        return persona_cod;
    }

    public void setPersona_cod(int persona_cod) {
        this.persona_cod = persona_cod;
    }

    public int getPersonal_cod() {
        return personal_cod;
    }

    public void setPersonal_cod(int personal_cod) {
        this.personal_cod = personal_cod;
    }

    public String getNumero_llamad() {
        return numero_llamad;
    }

    public void setNumero_llamad(String numero_llamad) {
        this.numero_llamad = numero_llamad;
    }

    public String getFecha_llamad() {
        return fecha_llamad;
    }

    public void setFecha_llamad(String fecha_llamad) {
        this.fecha_llamad = fecha_llamad;
    }

    public String getHora_llamad() {
        return hora_llamad;
    }

    public void setHora_llamad(String hora_llamad) {
        this.hora_llamad = hora_llamad;
    }

    public String getNotasAdc_llamad() {
        return notasAdc_llamad;
    }

    public void setNotasAdc_llamad(String notasAdc_llamad) {
        this.notasAdc_llamad = notasAdc_llamad;
    }

    public boolean isPrioridad_llamad() {
        return prioridad_llamad;
    }

    public void setPrioridad_llamad(boolean prioridad_llamad) {
        this.prioridad_llamad = prioridad_llamad;
    }

}
