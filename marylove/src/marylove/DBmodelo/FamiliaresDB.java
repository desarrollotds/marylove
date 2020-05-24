/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package marylove.DBmodelo;

import marylove.controlador.FiltroHijosVictima;
import marylove.models.Familiares;

/**
 *
 * @author Usuario
 */
public class FamiliaresDB extends Familiares{
    public void FamiliaresAnamnesis(){
        String sql="select f.familiares_id,p.persona_nombre, p.persona_apellido,p.persona_sexo, p.persona_estadocivil, f.parentesco,p.persona_ocupacion from familiares f join persona  p using(persona_codigo) where f.hijo_codigo="+FiltroHijosVictima.getCodigo()+";";
    }
    
}
