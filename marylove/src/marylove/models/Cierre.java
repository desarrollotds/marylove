
package marylove.models;

/**
 *
 * @author vasquez
 */
public class Cierre {
    private int cierre_id;
    private int legal_id;
    private String notifi_dilig;
    private String fecha_limite;
    private String observacion;
    private String fecha_cierre;

    public Cierre() {
    }

    public Cierre(int cierre_id, int legal_id, String notifi_dilig, String fecha_limite, String observacion, String fecha_cierre) {
        this.cierre_id = cierre_id;
        this.legal_id = legal_id;
        this.notifi_dilig = notifi_dilig;
        this.fecha_limite = fecha_limite;
        this.observacion = observacion;
        this.fecha_cierre = fecha_cierre;
    }
    
    

    public int getCierre_id() {
        return cierre_id;
    }

    public void setCierre_id(int cierre_id) {
        this.cierre_id = cierre_id;
    }

    public int getLegal_id() {
        return legal_id;
    }

    public void setLegal_id(int legal_id) {
        this.legal_id = legal_id;
    }

    public String getNotifi_dilig() {
        return notifi_dilig;
    }

    public void setNotifi_dilig(String notifi_dilig) {
        this.notifi_dilig = notifi_dilig;
    }

    public String getFecha_limite() {
        return fecha_limite;
    }

    public void setFecha_limite(String fecha_limite) {
        this.fecha_limite = fecha_limite;
    }

    public String getObservacion() {
        return observacion;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }

    public String getFecha_cierre() {
        return fecha_cierre;
    }

    public void setFecha_cierre(String fecha_cierre) {
        this.fecha_cierre = fecha_cierre;
    }
    
    
}
