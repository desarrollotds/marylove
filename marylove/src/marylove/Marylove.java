/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package marylove;

import java.sql.SQLException;
import marylove.DBmodelo.*;
import marylove.controlador.*;
import marylove.models.*;
import marylove.vista.*;

/**
 *
 * @author Patricio, modificaciónasdasd 12:09 hola
 */
public class Marylove {

    public static void main(String[] args) throws SQLException, Exception {
        vistaCarga vistCarg = new vistaCarga();
        V_Login lg = new V_Login();
        V_Menu vP = new V_Menu();
        Personal pl = new Personal();
        Persona pr = new Persona();
        personaDB pDB = new personaDB();
        personalDB plDB = new personalDB();
        C_Menu menu = new C_Menu(vP);
        C_Login cl = new C_Login(vistCarg, lg, vP, pl, pr, pDB, plDB, menu);
        cl.iniciaControl();
    }
}
