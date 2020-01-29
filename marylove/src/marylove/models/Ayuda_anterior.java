/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package marylove.models;

/**
 *
 * @author icrv9
 */
public class Ayuda_anterior {
private int ayuda_codigo;
private String	ayuda_nombre;
private int ayuda_tipo;
private String ayuda_telefono;
private String ayuda_motivo;
private String ayuda_atencion;
private int  registroreferencia_codigo;

    public Ayuda_anterior() {
    }

    public Ayuda_anterior(int ayuda_codigo, String ayuda_nombre, int ayuda_tipo, String ayuda_telefono, String ayuda_motivo, String ayuda_atencion, int registroreferencia_codigo) {
        this.ayuda_codigo = ayuda_codigo;
        this.ayuda_nombre = ayuda_nombre;
        this.ayuda_tipo = ayuda_tipo;
        this.ayuda_telefono = ayuda_telefono;
        this.ayuda_motivo = ayuda_motivo;
        this.ayuda_atencion = ayuda_atencion;
        this.registroreferencia_codigo = registroreferencia_codigo;
    }

    public int getAyuda_codigo() {
        return ayuda_codigo;
    }

    public void setAyuda_codigo(int ayuda_codigo) {
        this.ayuda_codigo = ayuda_codigo;
    }

    public String getAyuda_nombre() {
        return ayuda_nombre;
    }

    public void setAyuda_nombre(String ayuda_nombre) {
        this.ayuda_nombre = ayuda_nombre;
    }

    public int getAyuda_tipo() {
        return ayuda_tipo;
    }

    public void setAyuda_tipo(int ayuda_tipo) {
        this.ayuda_tipo = ayuda_tipo;
    }

    public String getAyuda_telefono() {
        return ayuda_telefono;
    }

    public void setAyuda_telefono(String ayuda_telefono) {
        this.ayuda_telefono = ayuda_telefono;
    }

    public String getAyuda_motivo() {
        return ayuda_motivo;
    }

    public void setAyuda_motivo(String ayuda_motivo) {
        this.ayuda_motivo = ayuda_motivo;
    }

    public String getAyuda_atencion() {
        return ayuda_atencion;
    }

    public void setAyuda_atencion(String ayuda_atencion) {
        this.ayuda_atencion = ayuda_atencion;
    }

    public int getRegistroreferencia_codigo() {
        return registroreferencia_codigo;
    }

    public void setRegistroreferencia_codigo(int registroreferencia_codigo) {
        this.registroreferencia_codigo = registroreferencia_codigo;
    }

}

