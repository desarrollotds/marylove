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
        
        Ficharegistroyreferencia g = new Ficharegistroyreferencia();
        ControladorRegistroReferencia hj = new ControladorRegistroReferencia(g);
//        FormaAgregarInstitucionEduc h= new FormaAgregarInstitucionEduc();
//        ControladorAgregarInstitucionEduc ju= new ControladorAgregarInstitucionEduc(h);
//          FormaAgregarAgresores j=new FormaAgregarAgresores();
//          ControladorAgregarAgresores jj= new ControladorAgregarAgresores(j);
        
        }
    

}
