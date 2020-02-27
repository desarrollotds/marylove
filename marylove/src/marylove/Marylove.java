/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package marylove;

import java.sql.SQLException;
import marylove.DBmodelo.Caracteristicas_violenciaDB;
import marylove.DBmodelo.personaDB;
import marylove.DBmodelo.personalDB;
import marylove.conexion.Conexion;
import marylove.controlador.C_Login;
import marylove.controlador.ControladorPrimerEncuentro;
import marylove.controlador.Controlador_registro_llamadas;
import marylove.controlador.controlFichaLegal;
import marylove.models.*;
import marylove.vista.*;

/**
 *
 * @author Patricio, modificaciónasdasd 12:09
 */
public class Marylove {

    /**
     * @param args the command line arguments
     * @throws java.sql.SQLException
     */
    public static void main(String[] args) throws SQLException, Exception {
//         Caracteristicas_violenciaDB c= new Caracteristicas_violenciaDB();
////         ArrayList<Json_object_consulta> jocarray=c.obtenerTitulos();
////         for (Json_object_consulta o: jocarray) {
////             System.out.println(o.getId()+" "+o.getValor());
////
////        }
//         int caractitulo=c.obtenerCaracteristicaIdOtros("¿Quién es el agresor?");
//         System.out.println(caractitulo);

//        Caracteristicas_violenciaDB cvdb = new Caracteristicas_violenciaDB();
//        int o=cvdb.obtenerCaracteristicaId("Física");
//        System.out.println(o);
//        VistaRegistroLlamada v= new VistaRegistroLlamada();
//        Controlador_registro_llamadas ce= new Controlador_registro_llamadas(v);
//        Conexion conectar = new Conexion();
//        FichaPrimerEncuentro Vista_1_Encuentro = new FichaPrimerEncuentro();
//        Primer_encuentro Modelo_1_Encuentro = new Primer_encuentro();
//        ControladorPrimerEncuentro Primere = new ControladorPrimerEncuentro(Vista_1_Encuentro, Modelo_1_Encuentro, conectar);
//        Primere.iniciarControl();
        FichaLegal fl = new FichaLegal();
        Ficha_Legal f_l = new Ficha_Legal();

        V_Login lg = new V_Login();
        V_Menu vP = new V_Menu();
        Personal pl = new Personal();
        Persona pr = new Persona();
        personaDB pDB = new personaDB();
        personalDB plDB = new personalDB();
        Conexion cx = new Conexion();
        C_Login cl = new C_Login(lg, vP, pl, pr, pDB, plDB, cx);
        cl.iniciaControl();
//        Persona_llamadaDB plbd=new Persona_llamadaDB();
//        ArrayList<Resultado>r=plbd.listaResultados();
//        for (Resultado o: r) {
//            System.out.println(o.getResultado_id()+"-----"+o.getResultado_nombre());
//        }
//        Persona p = new Persona("0107314361", "mura",
//                "", "1993-02-14", 1, 1, 1, 1, 1, "092345678", "09234567", true,'F');
//        PersonaDB pdb=new PersonaDB();
    }

}
