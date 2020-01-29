package marylove.models;

import java.util.Date;

public class Llamada {

    private int llamda_codigo;
    private int per_codigo;
    private String llamda_numero;
    private Date llamada_fecha;
    private String llamada_hora;
    private boolean llamada_prioridad;
    private int personal_codigo;
    private String notas_adicionales;

    public Llamada() {
    }

    public Llamada(int llamda_codigo, int per_codigo, String llamda_numero, Date llamada_fecha, String llamada_hora, boolean llamada_prioridad, int personal_codigo, String notas_adicionales) {
        this.llamda_codigo = llamda_codigo;
        this.per_codigo = per_codigo;
        this.llamda_numero = llamda_numero;
        this.llamada_fecha = llamada_fecha;
        this.llamada_hora = llamada_hora;
        this.llamada_prioridad = llamada_prioridad;
        this.personal_codigo = personal_codigo;
        this.notas_adicionales = notas_adicionales;
    }

    public int getLlamda_codigo() {
        return llamda_codigo;
    }

    public void setLlamda_codigo(int llamda_codigo) {
        this.llamda_codigo = llamda_codigo;
    }

    public int getPer_codigo() {
        return per_codigo;
    }

    public void setPer_codigo(int per_codigo) {
        this.per_codigo = per_codigo;
    }

    public String getLlamda_numero() {
        return llamda_numero;
    }

    public void setLlamda_numero(String llamda_numero) {
        this.llamda_numero = llamda_numero;
    }

    public Date getLlamada_fecha() {
        return llamada_fecha;
    }

    public void setLlamada_fecha(Date llamada_fecha) {
        this.llamada_fecha = llamada_fecha;
    }

    public String getLlamada_hora() {
        return llamada_hora;
    }

    public void setLlamada_hora(String llamada_hora) {
        this.llamada_hora = llamada_hora;
    }

    public boolean isLlamada_prioridad() {
        return llamada_prioridad;
    }

    public void setLlamada_prioridad(boolean llamada_prioridad) {
        this.llamada_prioridad = llamada_prioridad;
    }

    public int getPersonal_codigo() {
        return personal_codigo;
    }

    public void setPersonal_codigo(int personal_codigo) {
        this.personal_codigo = personal_codigo;
    }

    public String getNotas_adicionales() {
        return notas_adicionales;
    }

    public void setNotas_adicionales(String notas_adicionales) {
        this.notas_adicionales = notas_adicionales;
    }

}
