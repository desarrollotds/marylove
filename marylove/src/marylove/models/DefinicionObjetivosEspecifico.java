
package marylove.models;

public class DefinicionObjetivosEspecifico {
    private int definicion_id;
    private int evaluacion_id;
    private String objetivosEspecificos;
    private String actividad;
    private String tiempo;
    private String apoyode;
    private String supuestosAmenazas;
    private int responsoble;

    public DefinicionObjetivosEspecifico() {
    }

    public DefinicionObjetivosEspecifico(int definicion_id, int evaluacion_id, String objetivosEspecificos, String actividad, String tiempo, String apoyode, String supuestosAmenazas, int responsoble) {
        this.definicion_id = definicion_id;
        this.evaluacion_id = evaluacion_id;
        this.objetivosEspecificos = objetivosEspecificos;
        this.actividad = actividad;
        this.tiempo = tiempo;
        this.apoyode = apoyode;
        this.supuestosAmenazas = supuestosAmenazas;
        this.responsoble = responsoble;
    }

    public int getResponsoble() {
        return responsoble;
    }

    public void setResponsoble(int responsoble) {
        this.responsoble = responsoble;
    }

    public int getDefinicion_id() {
        return definicion_id;
    }

    public void setDefinicion_id(int definicion_id) {
        this.definicion_id = definicion_id;
    }

    public int getEvaluacion_id() {
        return evaluacion_id;
    }

    public void setEvaluacion_id(int evaluacion_id) {
        this.evaluacion_id = evaluacion_id;
    }

    public String getObjetivosEspecificos() {
        return objetivosEspecificos;
    }

    public void setObjetivosEspecificos(String objetivosEspecificos) {
        this.objetivosEspecificos = objetivosEspecificos;
    }

    public String getActividad() {
        return actividad;
    }

    public void setActividad(String actividad) {
        this.actividad = actividad;
    }

    public String getTiempo() {
        return tiempo;
    }

    public void setTiempo(String tiempo) {
        this.tiempo = tiempo;
    }

    public String getApoyode() {
        return apoyode;
    }

    public void setApoyode(String apoyode) {
        this.apoyode = apoyode;
    }

    public String getSupuestosAmenazas() {
        return supuestosAmenazas;
    }

    public void setSupuestosAmenazas(String supuestosAmenazas) {
        this.supuestosAmenazas = supuestosAmenazas;
    }
    
    
}
