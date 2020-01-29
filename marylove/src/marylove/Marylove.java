/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package marylove;

import java.sql.SQLException;
import marylove.controlador.ControladorMenu;
import marylove.controlador.Controlador_registro_llamadas;
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
import marylove.vista.formularioR1;

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
        //hola
        VistaMenuPrincipal vMenu = new VistaMenuPrincipal();
        Ficharegistroyreferencia regRef = new Ficharegistroyreferencia();
        Registro_referencia modelRef = new Registro_referencia();
        FormaAgregarHijos vistaRegHijos = new FormaAgregarHijos();
        VistaRegistroLlamadas vistaLlamadas = new VistaRegistroLlamadas();
        formularioR1 FormularioR1 = new formularioR1();
        Controlador_registro_llamadas cotrLlamadas = new Controlador_registro_llamadas(vistaLlamadas);
        CtrlRegistroReferencia crtlRef = new CtrlRegistroReferencia(regRef,modelRef,vistaRegHijos); 
        ControladorMenu cm = new ControladorMenu(vMenu,regRef, crtlRef, vistaLlamadas, FormularioR1,cotrLlamadas);
        cm.iniciarContrl();
    }

}


