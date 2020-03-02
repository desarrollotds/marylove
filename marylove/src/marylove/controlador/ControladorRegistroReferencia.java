/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package marylove.controlador;

import marylove.DBmodelo.persona_llamadaDB;
import marylove.vista.Ficharegistroyreferencia;

/**
 *
 * @author Asus
 */
public class ControladorRegistroReferencia {
    Ficharegistroyreferencia vista;
    private static int ID_persona_llamada;
    persona_llamadaDB pldb;

    public ControladorRegistroReferencia(Ficharegistroyreferencia vista) {
        this.vista=vista;
        
    }
    
}
