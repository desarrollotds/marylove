/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package marylove;

import java.sql.SQLException;
import marylove.controlador.ControladorMenu;
import marylove.controlador.CtrlRegistroReferencia;
import marylove.models.*;
//import marylove.controlador.ControladorMenu;
import marylove.controlador.login.Login;
import marylove.vista.FichaPrimerEncuentro;
import marylove.vista.Ficharegistroyreferencia;
import marylove.vista.FormaAgregarHijos;
import marylove.vista.FrmLogin;
import marylove.vista.VistaMenuPrincipal;
import marylove.vista.VistaRegistroLlamadas;

/**
 *
 * @author Patricio, modificaciónasdasd 12:09
 */
public class Marylove {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws SQLException {
        Coneccion c = new Coneccion();
        c.crearConexion();
        // modificado por Willian
        VistaMenuPrincipal vMenu = new VistaMenuPrincipal();
        Ficharegistroyreferencia regRef = new Ficharegistroyreferencia();
        Registro_referencia modelRef = new Registro_referencia();
        FormaAgregarHijos vistaRegHijos = new FormaAgregarHijos();
        VistaRegistroLlamadas vistaLlamadas = new VistaRegistroLlamadas();
        CtrlRegistroReferencia crtlRef = new CtrlRegistroReferencia(regRef,modelRef,vistaRegHijos); 
        ControladorMenu cm = new ControladorMenu(vMenu, regRef, crtlRef, vistaLlamadas);
        cm.iniciarContrl();
    }

}


