/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package marylove.models;

/**
 *
 * @author LENOVO
 */
public class Cuentas_Diarias {
    private int cuentas_diarias_codigo;
    private int plan_recusos_codigo;
    private String fecha_cuenta;
    private String gasto; //en la base esta como money
    private String descripcion;
    private String saldo; // en la base esta como money

    public Cuentas_Diarias(int cuentas_diarias_codigo, int plan_recusos_codigo, String fecha_cuenta, String gasto, String descripcion, String saldo) {
        this.cuentas_diarias_codigo = cuentas_diarias_codigo;
        this.plan_recusos_codigo = plan_recusos_codigo;
        this.fecha_cuenta = fecha_cuenta;
        this.gasto = gasto;
        this.descripcion = descripcion;
        this.saldo = saldo;
    }

    public Cuentas_Diarias() {
    }

    public int getCuentas_diarias_codigo() {
        return cuentas_diarias_codigo;
    }

    public void setCuentas_diarias_codigo(int cuentas_diarias_codigo) {
        this.cuentas_diarias_codigo = cuentas_diarias_codigo;
    }

    public int getPlan_recusos_codigo() {
        return plan_recusos_codigo;
    }

    public void setPlan_recusos_codigo(int plan_recusos_codigo) {
        this.plan_recusos_codigo = plan_recusos_codigo;
    }

    public String getFecha_cuenta() {
        return fecha_cuenta;
    }

    public void setFecha_cuenta(String fecha_cuenta) {
        this.fecha_cuenta = fecha_cuenta;
    }

    public String getGasto() {
        return gasto;
    }

    public void setGasto(String gasto) {
        this.gasto = gasto;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getSaldo() {
        return saldo;
    }

    public void setSaldo(String saldo) {
        this.saldo = saldo;
    }
     
}
