/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package marylove.models;

/**
 *
 * @author Danny
 */
public class x_registro_agresor {
    
    private int regrsitroagresor_codigo;
    private int agresor_codigo;
    private int registroreferencia_codigo;
    private int parentesco;

    public x_registro_agresor() {
    }

    public x_registro_agresor(int agresor_codigo, int registroreferencia_codigo, int parentesco) {
        this.agresor_codigo = agresor_codigo;
        this.registroreferencia_codigo = registroreferencia_codigo;
        this.parentesco = parentesco;
    }
    
    public int getRegrsitroagresor_codigo() {
        return regrsitroagresor_codigo;
    }

    public void setRegrsitroagresor_codigo(int regrsitroagresor_codigo) {
        this.regrsitroagresor_codigo = regrsitroagresor_codigo;
    }

    public int getAgresor_codigo() {
        return agresor_codigo;
    }

    public void setAgresor_codigo(int agresor_codigo) {
        this.agresor_codigo = agresor_codigo;
    }

    public int getRegistroreferencia_codigo() {
        return registroreferencia_codigo;
    }

    public void setRegistroreferencia_codigo(int registroreferencia_codigo) {
        this.registroreferencia_codigo = registroreferencia_codigo;
    }

    public int getParentesco() {
        return parentesco;
    }

    public void setParentesco(int parentesco) {
        this.parentesco = parentesco;
    }

    
    
}
