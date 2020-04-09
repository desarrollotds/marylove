
package marylove.models;

public class PercepcionFamiliar {
    private int percepcion_id;
    private int evaluacion_id;
    private String comoSeSiente;
    private String alcanzoObjetivosComo;
    private String dificultadesEncontradas;

    public PercepcionFamiliar(int percepcion_id, int evaluacion_id, String comoSeSiente, String alcanzoObjetivosComo, String dificultadesEncontradas) {
        this.percepcion_id = percepcion_id;
        this.evaluacion_id = evaluacion_id;
        this.comoSeSiente = comoSeSiente;
        this.alcanzoObjetivosComo = alcanzoObjetivosComo;
        this.dificultadesEncontradas = dificultadesEncontradas;
    }

    public PercepcionFamiliar() {
    }

    public int getPercepcion_id() {
        return percepcion_id;
    }

    public void setPercepcion_id(int percepcion_id) {
        this.percepcion_id = percepcion_id;
    }

    public int getEvaluacion_id() {
        return evaluacion_id;
    }

    public void setEvaluacion_id(int evaluacion_id) {
        this.evaluacion_id = evaluacion_id;
    }

    public String getComoSeSiente() {
        return comoSeSiente;
    }

    public void setComoSeSiente(String comoSeSiente) {
        this.comoSeSiente = comoSeSiente;
    }

    public String getAlcanzoObjetivosComo() {
        return alcanzoObjetivosComo;
    }

    public void setAlcanzoObjetivosComo(String alcanzoObjetivosComo) {
        this.alcanzoObjetivosComo = alcanzoObjetivosComo;
    }

    public String getDificultadesEncontradas() {
        return dificultadesEncontradas;
    }

    public void setDificultadesEncontradas(String dificultadesEncontradas) {
        this.dificultadesEncontradas = dificultadesEncontradas;
    }

    
    
}
