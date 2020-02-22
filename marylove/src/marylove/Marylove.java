/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package marylove;

import java.sql.SQLException;
import java.util.ArrayList;
import marylove.DBmodelo.Persona_llamadaDB;
import marylove.controlador.Controlador_registro_llamadas;
import marylove.models.Resultado;
import marylove.vista.VistaRegistroLlamada;

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
        VistaRegistroLlamada v= new VistaRegistroLlamada();
        Controlador_registro_llamadas c= new Controlador_registro_llamadas(v);
        
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
