/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package marylove.models;

import java.util.Date;

/**
 *
 * @author LENOVO
 */
public class Plan_de_Vida {
   private int victima_codigo;
   private Date evaluacion_fecha;
   private Date evaluacion_proxima_fecha;
   private int personal_codigo;

    public Plan_de_Vida(int victima_codigo, Date evaluacion_fecha, Date evaluacion_proxima_fecha, int personal_codigo) {
        this.victima_codigo = victima_codigo;
        this.evaluacion_fecha = evaluacion_fecha;
        this.evaluacion_proxima_fecha = evaluacion_proxima_fecha;
        this.personal_codigo = personal_codigo;
    }
   
   
}
