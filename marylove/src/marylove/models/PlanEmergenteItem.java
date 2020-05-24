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
    private String apreciacioninicial1;
    private String accionesinmediatas;
    private String accionesinmediatas1;
    private String item_fecha;
    private String item_fecha1;
     private String apreciacioninicial2;
    private String apreciacioninicial3;
    private String accionesinmediatas2;
    private String accionesinmediatas3;
    private String item_fecha2;
    private String item_fecha3;
    private String modalidad_nombre;
    private String emergente_id;

    public PlanEmergenteItem() {
    }

  

    public PlanEmergenteItem(long item_id, String apreciacioninicial, String apreciacioninicial1, String accionesinmediatas, String accionesinmediatas1, String item_fecha, String item_fecha1, String modalidad_nombre) {
        this.item_id = item_id;
        this.apreciacioninicial = apreciacioninicial;
        this.apreciacioninicial1 = apreciacioninicial1;
        this.accionesinmediatas = accionesinmediatas;
        this.accionesinmediatas1 = accionesinmediatas1;
        this.item_fecha = item_fecha;
        this.item_fecha1 = item_fecha1;
        this.modalidad_nombre = modalidad_nombre;
    }

    public PlanEmergenteItem(long item_id, String apreciacioninicial, String apreciacioninicial1, String accionesinmediatas, String accionesinmediatas1, String item_fecha, String item_fecha1, String apreciacioninicial2, String apreciacioninicial3, String accionesinmediatas2, String accionesinmediatas3, String item_fecha2, String item_fecha3, String modalidad_nombre) {
        this.item_id = item_id;
        this.apreciacioninicial = apreciacioninicial;
        this.apreciacioninicial1 = apreciacioninicial1;
        this.accionesinmediatas = accionesinmediatas;
        this.accionesinmediatas1 = accionesinmediatas1;
        this.item_fecha = item_fecha;
        this.item_fecha1 = item_fecha1;
        this.apreciacioninicial2 = apreciacioninicial2;
        this.apreciacioninicial3 = apreciacioninicial3;
        this.accionesinmediatas2 = accionesinmediatas2;
        this.accionesinmediatas3 = accionesinmediatas3;
        this.item_fecha2 = item_fecha2;
        this.item_fecha3 = item_fecha3;
        this.modalidad_nombre = modalidad_nombre;
    }

    public PlanEmergenteItem(long item_id, String apreciacioninicial, String apreciacioninicial1, String accionesinmediatas, String accionesinmediatas1, String item_fecha, String item_fecha1, String apreciacioninicial2, String apreciacioninicial3, String accionesinmediatas2, String accionesinmediatas3, String item_fecha2, String item_fecha3, String modalidad_nombre, String emergente_id) {
        this.item_id = item_id;
        this.apreciacioninicial = apreciacioninicial;
        this.apreciacioninicial1 = apreciacioninicial1;
        this.accionesinmediatas = accionesinmediatas;
        this.accionesinmediatas1 = accionesinmediatas1;
        this.item_fecha = item_fecha;
        this.item_fecha1 = item_fecha1;
        this.apreciacioninicial2 = apreciacioninicial2;
        this.apreciacioninicial3 = apreciacioninicial3;
        this.accionesinmediatas2 = accionesinmediatas2;
        this.accionesinmediatas3 = accionesinmediatas3;
        this.item_fecha2 = item_fecha2;
        this.item_fecha3 = item_fecha3;
        this.modalidad_nombre = modalidad_nombre;
        this.emergente_id = emergente_id;
    }

    public String getEmergente_id() {
        return emergente_id;
    }

    public void setEmergente_id(String emergente_id) {
        this.emergente_id = emergente_id;
    }
    

    public String getApreciacioninicial2() {
        return apreciacioninicial2;
    }

    public void setApreciacioninicial2(String apreciacioninicial2) {
        this.apreciacioninicial2 = apreciacioninicial2;
    }

    public String getApreciacioninicial3() {
        return apreciacioninicial3;
    }

    public void setApreciacioninicial3(String apreciacioninicial3) {
        this.apreciacioninicial3 = apreciacioninicial3;
    }

    public String getAccionesinmediatas2() {
        return accionesinmediatas2;
    }

    public void setAccionesinmediatas2(String accionesinmediatas2) {
        this.accionesinmediatas2 = accionesinmediatas2;
    }

    public String getAccionesinmediatas3() {
        return accionesinmediatas3;
    }

    public void setAccionesinmediatas3(String accionesinmediatas3) {
        this.accionesinmediatas3 = accionesinmediatas3;
    }

    public String getItem_fecha2() {
        return item_fecha2;
    }

    public void setItem_fecha2(String item_fecha2) {
        this.item_fecha2 = item_fecha2;
    }

    public String getItem_fecha3() {
        return item_fecha3;
    }

    public void setItem_fecha3(String item_fecha3) {
        this.item_fecha3 = item_fecha3;
    }

    public String getApreciacioninicial1() {
        return apreciacioninicial1;
    }

    public void setApreciacioninicial1(String apreciacioninicial1) {
        this.apreciacioninicial1 = apreciacioninicial1;
    }

    public String getAccionesinmediatas1() {
        return accionesinmediatas1;
    }

    public void setAccionesinmediatas1(String accionesinmediatas1) {
        this.accionesinmediatas1 = accionesinmediatas1;
    }

    public String getItem_fecha1() {
        return item_fecha1;
    }

    public void setItem_fecha1(String item_fecha1) {
        this.item_fecha1 = item_fecha1;
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