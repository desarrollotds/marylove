/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package marylove;

import java.sql.SQLException;
import marylove.controlador.ControladorRegistroReferencia;
import marylove.vista.*;

/**
 *
 * @author Patricio, modificaciónasdasd 12:09
 */
public class Marylove {

    public static void main(String[] args) throws SQLException, Exception {

FichaRegistroyReferencia g= new FichaRegistroyReferencia();
ControladorRegistroReferencia h=new ControladorRegistroReferencia(g);



    }

}
