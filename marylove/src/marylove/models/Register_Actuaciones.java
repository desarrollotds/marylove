
package marylove.models;

import java.util.Date;

/**
 *
 * @author vasquez
 */
public class Register_Actuaciones extends Ficha_Legal{
    private int reg_id;
    private int legal_id;
    private String notf_dilig;
    private String fecha_limite;
    private String observ;

    public Register_Actuaciones() {
    }

    public int getReg_id() {
        return reg_id;
    }

    public void setReg_id(int reg_id) {
        this.reg_id = reg_id;
    }

    public int getLegal_id() {
        return legal_id;
    }

    public void setLegal_id(int legal_id) {
        this.legal_id = legal_id;
    }

    public String getNotf_dilig() {
        return notf_dilig;
    }

    public void setNotf_dilig(String notf_dilig) {
        this.notf_dilig = notf_dilig;
    }

    public String getFecha_limite() {
        return fecha_limite;
    }

    public void setFecha_limite(String fecha_limite) {
        this.fecha_limite = fecha_limite;
    }

    public String getObserv() {
        return observ;
    }

    public void setObserv(String observ) {
        this.observ = observ;
    }
    
}
