/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package marylove;

import java.sql.SQLException;
import java.util.ArrayList;
import marylove.controlador.C_Login;
import marylove.controlador.ControladorFichaIngreso;
import marylove.controlador.ControladorMenu;
import marylove.controlador.Controlador_registro_llamadas;
import marylove.controlador.CtrlRegistroReferencia;
import marylove.models.*;
//import marylove.controlador.ControladorMenu;
import marylove.controlador.login.Login;
import marylove.vista.FichaCitas;
import marylove.vista.FichaIngreso;
import marylove.vista.FichaPrimerEncuentro;
import marylove.vista.Ficharegistroyreferencia;
import marylove.vista.FormaAgregarHijos;
import marylove.vista.FrmLogin;
import marylove.vista.V_Login;
import marylove.vista.V_Menu;
import marylove.vista.VistaCita;
import marylove.vista.VistaMenuPrincipal;
import marylove.vista.VistaRegistroLlamada;
import marylove.vista.formularioR1;

/**
 *
 * @author Patricio, modificaciónasdasd 12:09
 */
public class Marylove {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws SQLException, Exception {
//        VistaRegistroLlamada vrl =new VistaRegistroLlamada();
//        Controlador_registro_llamadas crl=new Controlador_registro_llamadas(vrl);
//        crl.iniciarControlRLL();

//            Llamada l= new Llamada();
//            int nu=l.obtenerId();
//            System.out.println(nu);
//        ArrayList<String> cedulas = new ArrayList<>();
//Coneccion c = new Coneccion();
        //c.crearConexion();
        //hola
//        Persona p = new Persona("1401201401", "Isais",
//                "Rodriguez", "1993-02-14", 1, 1, 1, 1, 1, "092345678", "09234567", true);
//        p.ingresarPersona(p);
//        cedulas=p.listaCedulas();
//       p.actualizarPersona(p);
        V_Login VL = new V_Login();
        V_Menu vMenu = new V_Menu();
        C_Login CL = new C_Login(VL, vMenu);
        CL.iniciaControl();
        //ttotototototot
//        ControladorMenu controller = new ControladorMenu(vMenu);
        Ficharegistroyreferencia regRef = new Ficharegistroyreferencia();
//        Registro_referencia modelRef = new Registro_referencia();
        InstitucionEducativa InstEdu = new InstitucionEducativa();
        FormaAgregarHijos vistaRegHijos = new FormaAgregarHijos();
        Hijos hj= new Hijos();
        VistaCita vcitas= new VistaCita();
        FichaCitas fCitas = new FichaCitas();
        VistaRegistroLlamada vistaLlamadas = new VistaRegistroLlamada();
        formularioR1 FormularioR1 = new formularioR1();
        RegistroReferenciaDb regRefDB = new RegistroReferenciaDb();
        Controlador_registro_llamadas FormularioR2 = new Controlador_registro_llamadas(vistaLlamadas);
        CtrlRegistroReferencia crtlRef = new CtrlRegistroReferencia(regRef, regRefDB, vistaRegHijos, InstEdu, hj); 
        FichaPrimerEncuentro fpEncuentro = new FichaPrimerEncuentro();
        ControladorMenu cm = new ControladorMenu(vMenu, regRef,crtlRef, vistaLlamadas, FormularioR1, FormularioR2, vcitas, fpEncuentro);
        cm.iniciarContrl();
        //nuevo paquete
        

    }

}
