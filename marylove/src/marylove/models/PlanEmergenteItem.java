/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package marylove.models;

import java.util.Date;

/**
 *
 * @author Alumno
 */
public class PlanEmergenteItem extends PlanEmergente {
    private long item_id;

    
    private String apreciacioninicial;
    private String accionesinmediatas;
    private String item_feha;
    private String modalidad_nombre;

    public PlanEmergenteItem() {
    }

    public PlanEmergenteItem(long item_id, String apreciacioninicial, String accionesinmediatas, String item_feha, String modalidad_nombre, int victima_codigo, String emergente_fecha, int personal_codigo) {
        super(victima_codigo, emergente_fecha, personal_codigo);
        this.item_id = item_id;
        this.apreciacioninicial = apreciacioninicial;
        this.accionesinmediatas = accionesinmediatas;
        this.item_feha = item_feha;
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

    public String getItem_feha() {
        return item_feha;
    }

    public void setItem_feha(String item_feha) {
        this.item_feha = item_feha;
    }

    public String getModalidad_nombre() {
        return modalidad_nombre;
    }

    public void setModalidad_nombre(String modalidad_nombre) {
        this.modalidad_nombre = modalidad_nombre;
    }

  

   
  

}