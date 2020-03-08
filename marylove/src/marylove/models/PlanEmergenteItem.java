/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package marylove.models;

import java.util.Date;

/**
 *
 * @autsdefssddshor Alumno
 */
public class PlanEmergenteItem  {
    private long item_id;

    
    private String apreciacioninicial;
    private String accionesinmediatas;
    private String item_fecha;
    private String modalidad_nombre;

    public PlanEmergenteItem() {
    }

    public PlanEmergenteItem(long item_id, String apreciacioninicial, String accionesinmediatas, String item_fecha, String modalidad_nombre, int victima_codigo, String emergente_fecha, int personal_codigo) {
        this.item_id = item_id;
        this.apreciacioninicial = apreciacioninicial;
        this.accionesinmediatas = accionesinmediatas;
        this.item_fecha = item_fecha;
        this.modalidad_nombre = modalidad_nombre;
    }

    

    public long getItem_id() {
        return item_id;
    }

    public void setItem_id(long item_id) {
        this.item_id = item_id;
    }

    public String getApreciacioninicial() {
        return apreciacioninicial;
    }

    public void setApreciacioninicial(String apreciacioninicial) {
        this.apreciacioninicial = apreciacioninicial;
    }

    public String getAccionesinmediatas() {
        return accionesinmediatas;
    }

    public void setAccionesinmediatas(String accionesinmediatas) {
        this.accionesinmediatas = accionesinmediatas;
    }

    public String getItem_fecha() {
        return item_fecha;
    }

    public void setItem_fecha(String item_fecha) {
        this.item_fecha = item_fecha;
    }

    public String getModalidad_nombre() {
        return modalidad_nombre;
    }

    public void setModalidad_nombre(String modalidad_nombre) {
        this.modalidad_nombre = modalidad_nombre;
    }

  

   
  

}