/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package marylove.models;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import marylove.conexion.Conexion;

/**
 *
 * @author Danny
 */
public class x_resultado_llamada {
    private int resultadollamada_codigo;
    private int llamada_codigo;
    private int resultado_id;
    private String resultadollamada_descripcion;
    private Conexion conn;
    

    public int getResultadollamada_codigo() {
        return resultadollamada_codigo;
    }

    public void setResultadollamada_codigo(int resultadollamada_codigo) {
        this.resultadollamada_codigo = resultadollamada_codigo;
    }

    public int getLlamada_codigo() {
        return llamada_codigo;
    }

    public void setLlamada_codigo(int llamada_codigo) {
        this.llamada_codigo = llamada_codigo;
    }

    public int getResultado_id() {
        return resultado_id;
    }

    public void setResultado_id(int resultado_id) {
        this.resultado_id = resultado_id;
    }

    public String getResultadollamada_descripcion() {
        return resultadollamada_descripcion;
    }

    public void setResultadollamada_descripcion(String resultadollamada_descripcion) {
        this.resultadollamada_descripcion = resultadollamada_descripcion;
    }

    public x_resultado_llamada(int resultadollamada_codigo, int llamada_codigo, int resultado_id, String resultadollamada_descripcion) {
        this.resultadollamada_codigo = resultadollamada_codigo;
        this.llamada_codigo = llamada_codigo;
        this.resultado_id = resultado_id;
        this.resultadollamada_descripcion = resultadollamada_descripcion;
    }

    public x_resultado_llamada() {
    }

    public x_resultado_llamada(int llamada_codigo, int resultado_id, String resultadollamada_descripcion) {
        this.llamada_codigo = llamada_codigo;
        this.resultado_id = resultado_id;
        this.resultadollamada_descripcion = resultadollamada_descripcion;
    }

    
}

