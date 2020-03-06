
package marylove.models;

public class DefinicionObjetivosGeneral {
    private int definiciong_id;
    private int evaluacion_id;
    private String objetivo_general;
    private int responsable;
    private String tiempo;
    private String observaciones;

    public DefinicionObjetivosGeneral() {
    }

    public DefinicionObjetivosGeneral(int definiciong_id, int evaluacion_id, String objetivo_general, int responsable, String tiempo, String observaciones) {
        this.definiciong_id = definiciong_id;
        this.evaluacion_id = evaluacion_id;
        this.objetivo_general = objetivo_general;
        this.responsable = responsable;
        this.tiempo = tiempo;
        this.observaciones = observaciones;
    }

    public int getDefiniciong_id() {
        return definiciong_id;
    }

    public void setDefiniciong_id(int definiciong_id) {
        this.definiciong_id = definiciong_id;
    }

    public int getEvaluacion_id() {
        return evaluacion_id;
    }

    public void setEvaluacion_id(int evaluacion_id) {
        this.evaluacion_id = evaluacion_id;
    }

    public String getObjetivo_general() {
        return objetivo_general;
    }

    public void setObjetivo_general(String objetivo_general) {
        this.objetivo_general = objetivo_general;
    }

    public int getResponsable() {
        return responsable;
    }

    public void setResponsable(int responsable) {
        this.responsable = responsable;
    }

    public String getTiempo() {
        return tiempo;
    }

    public void setTiempo(String tiempo) {
        this.tiempo = tiempo;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }
    
    
}
