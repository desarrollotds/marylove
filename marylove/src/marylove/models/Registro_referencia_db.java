
package marylove.models;

public class Registro_referencia_db extends Persona {

    public Registro_referencia_db() {
    }

    public Registro_referencia_db(int persona_codigo, String persona_cedula, String persona_nombre, String persona_apellido, String persona_fecha_nac, int persona_estadocivil, int persona_nacionalidad, int persona_ocupacion, int persona_nivel_acad, int persona_est_migr, String persona_telefono, String persona_celular, int dir_codigo, boolean persona_estado_actual) {
        super(persona_codigo, persona_cedula, persona_nombre, persona_apellido, persona_fecha_nac, persona_estadocivil, persona_nacionalidad, persona_ocupacion, persona_nivel_acad, persona_est_migr, persona_telefono, persona_celular, dir_codigo, persona_estado_actual);
    }

    public Registro_referencia_db(String persona_cedula, String persona_nombre, String persona_apellido, String persona_fecha_nac, int persona_estadocivil, int persona_nacionalidad, int persona_ocupacion, int persona_nivel_acad, int persona_est_migr, String persona_telefono, String persona_celular, int dir_codigo) {
        super(persona_cedula, persona_nombre, persona_apellido, persona_fecha_nac, persona_estadocivil, persona_nacionalidad, persona_ocupacion, persona_nivel_acad, persona_est_migr, persona_telefono, persona_celular, dir_codigo);
    }

    public Registro_referencia_db(String persona_cedula, String persona_nombre, String persona_apellido, String persona_fecha_nac, int persona_estadocivil, int persona_nacionalidad, int persona_ocupacion, int persona_nivel_acad, int persona_est_migr, String persona_telefono, String persona_celular, int dir_codigo, boolean persona_estado_actual) {
        super(persona_cedula, persona_nombre, persona_apellido, persona_fecha_nac, persona_estadocivil, persona_nacionalidad, persona_ocupacion, persona_nivel_acad, persona_est_migr, persona_telefono, persona_celular, dir_codigo, persona_estado_actual);
    }
    
//    public void list<datosBeneficiario> listaVeneficiario() throws SQLException{
//        List<Persona> listaVeneficiario = new ArrayList<Persona>
//        try{
//            while(){
//            
//            }
//        }catch(SQLException ex){
//        
//        }
//    }
    
}
