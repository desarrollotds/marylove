
package marylove.models;

import java.util.Date;

public class EvaluacionPlanVida {
   private int evaluacion_id;
   private int victima_codigo; 
   private Date evaluacion_fecha;
   private Date evaluacion_proxima;
   private int personal_codigo;

    public EvaluacionPlanVida() {
    }

    public EvaluacionPlanVida(int evaluacion_id, int victima_codigo, Date evaluacion_fecha, Date evaluacion_proxima, int personal_codigo) {
        this.evaluacion_id = evaluacion_id;
        this.victima_codigo = victima_codigo;
        this.evaluacion_fecha = evaluacion_fecha;
        this.evaluacion_proxima = evaluacion_proxima;
        this.personal_codigo = personal_codigo;
    }

    public int getEvaluacion_id() {
        return evaluacion_id;
    }

    public void setEvaluacion_id(int evaluacion_id) {
        this.evaluacion_id = evaluacion_id;
    }

    public int getVictima_codigo() {
        return victima_codigo;
    }

    public void setVictima_codigo(int victima_codigo) {
        this.victima_codigo = victima_codigo;
    }

    public Date getEvaluacion_fecha() {
        return evaluacion_fecha;
    }

    public void setEvaluacion_fecha(Date evaluacion_fecha) {
        this.evaluacion_fecha = evaluacion_fecha;
    }

    public Date getEvaluacion_proxima() {
        return evaluacion_proxima;
    }

    public void setEvaluacion_proxima(Date evaluacion_proxima) {
        this.evaluacion_proxima = evaluacion_proxima;
    }

    public int getPersonal_codigo() {
        return personal_codigo;
    }

    public void setPersonal_codigo(int personal_codigo) {
        this.personal_codigo = personal_codigo;
    }
      
   
}
