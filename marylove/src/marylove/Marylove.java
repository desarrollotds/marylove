/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package marylove;

import marylove.controlador.ControladorMenu;
import marylove.controlador.login.Login;
import marylove.vista.FrmLogin;
import marylove.vista.VistaMenuPrincipal;
/**
 *
 * @author Patricio
 */
public class Marylove {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        VistaMenuPrincipal vistaMenu = new VistaMenuPrincipal();
        ControladorMenu cm = new ControladorMenu(vistaMenu);
       
        
        
    }
    
}
