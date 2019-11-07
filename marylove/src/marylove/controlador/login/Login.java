/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package marylove.controlador.login;

import marylove.vista.login.FrmLogin;

/**
 *
 * @author Patricio
 */
public class Login {
    // <editor-fold defaultstate="collapsed" desc="VISTA"> //</editor-fold> PARA DOCUMENTAR
    private FrmLogin vista;
    //aqui modelo;

    public Login(FrmLogin vista) {
        this.vista = vista;
        vista.setVisible(true);
        vista.setTitle("LOGIN");
        
    }
    
}
