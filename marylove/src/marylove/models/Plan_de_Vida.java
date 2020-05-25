package marylove.models;

/**
 *
 * @author LENOVO
 */
public class Plan_de_Vida {
   private int plan_de_vida_codigo;
   private int victima_codigo;
   private String fecha_elaboracion;
   private String fecha_prox_evaluacion;
   private String comosesiente;
   private String comoseve;
   private String comolegustariasuvida;
   private String vision_equipo_ufa;

    public Plan_de_Vida() {
    }

    public Plan_de_Vida(int plan_de_vida_codigo, int victima_codigo, String fecha_elaboracion, String fecha_prox_evaluacion, String comosesiente, String comoseve, String comolegustariasuvida, String vision_equipo_ufa) {
        this.plan_de_vida_codigo = plan_de_vida_codigo;
        this.victima_codigo = victima_codigo;
        this.fecha_elaboracion = fecha_elaboracion;
        this.fecha_prox_evaluacion = fecha_prox_evaluacion;
        this.comosesiente = comosesiente;
        this.comoseve = comoseve;
        this.comolegustariasuvida = comolegustariasuvida;
        this.vision_equipo_ufa = vision_equipo_ufa;
    }

    public String getVision_equipo_ufa() {
        return vision_equipo_ufa;
    }

    public void setVision_equipo_ufa(String vision_equipo_ufa) {
        this.vision_equipo_ufa = vision_equipo_ufa;
    }

    

    public int getPlan_de_vida_codigo() {
        return plan_de_vida_codigo;
    }

    public void setPlan_de_vida_codigo(int plan_de_vida_codigo) {
        this.plan_de_vida_codigo = plan_de_vida_codigo;
    }

    public int getVictima_codigo() {
        return victima_codigo;
    }

    public void setVictima_codigo(int victima_codigo) {
        this.victima_codigo = victima_codigo;
    }

    public String getFecha_elaboracion() {
        return fecha_elaboracion;
    }

    public void setFecha_elaboracion(String fecha_elaboracion) {
        this.fecha_elaboracion = fecha_elaboracion;
    }

    public String getFecha_prox_evaluacion() {
        return fecha_prox_evaluacion;
    }

    public void setFecha_prox_evaluacion(String fecha_prox_evaluacion) {
        this.fecha_prox_evaluacion = fecha_prox_evaluacion;
    }

    public String getComosesiente() {
        return comosesiente;
    }

    public void setComosesiente(String comosesiente) {
        this.comosesiente = comosesiente;
    }

    public String getComoseve() {
        return comoseve;
    }

    public void setComoseve(String comoseve) {
        this.comoseve = comoseve;
    }

    public String getComolegustariasuvida() {
        return comolegustariasuvida;
    }

    public void setComolegustariasuvida(String comolegustariasuvida) {
        this.comolegustariasuvida = comolegustariasuvida;
    }

   
}

   