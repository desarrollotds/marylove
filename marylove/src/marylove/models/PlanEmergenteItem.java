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
    private int emergencia_id;
    private String apreciacioninicial;
    private Date item_feha;
    private String modalidad_nombre;

    public PlanEmergenteItem() {
    }

    public PlanEmergenteItem(long item_id, int emergencia_id, String apreciacioninicial, Date item_feha, String modalidad_nombre, long emergente_id, int victima_codigo, Date emergente_fecha, int personal_codigo) {
        super(emergente_id, victima_codigo, emergente_fecha, personal_codigo);
        this.item_id = item_id;
        this.emergencia_id = emergencia_id;
        this.apreciacioninicial = apreciacioninicial;
        this.item_feha = item_feha;
        this.modalidad_nombre = modalidad_nombre;
    }

    public long getItem_id() {
        return item_id;
    }

    public void setItem_id(long item_id) {
        this.item_id = item_id;
    }

    public int getEmergencia_id() {
        return emergencia_id;
    }

    public void setEmergencia_id(int emergencia_id) {
        this.emergencia_id = emergencia_id;
    }

    public String getApreciacioninicial() {
        return apreciacioninicial;
    }

    public void setApreciacioninicial(String apreciacioninicial) {
        this.apreciacioninicial = apreciacioninicial;
    }

    public Date getItem_feha() {
        return item_feha;
    }

    public void setItem_feha(Date item_feha) {
        this.item_feha = item_feha;
    }

    public String getModalidad_nombre() {
        return modalidad_nombre;
    }

    public void setModalidad_nombre(String modalidad_nombre) {
        this.modalidad_nombre = modalidad_nombre;
    }
  
}
