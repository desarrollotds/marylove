
package marylove.models;

import java.util.Date;

public class x_hijos_familiares extends Familiars {
    private int XhijosFamili_id;
    private int XfamiliaresId;
    private int XhijoCodig;

    public x_hijos_familiares(int XhijosFamili_id, int XfamiliaresId, int XhijoCodig, int familiares_id, int persona_codigoFam, int hijo_codigoFam, String parentescoFam, boolean estadoFam, int edadFam) {
        super(familiares_id, persona_codigoFam, hijo_codigoFam, parentescoFam, estadoFam, edadFam);
        this.XhijosFamili_id = XhijosFamili_id;
        this.XfamiliaresId = XfamiliaresId;
        this.XhijoCodig = XhijoCodig;
    }

    public x_hijos_familiares(int XhijosFamili_id, int XfamiliaresId, int XhijoCodig, int familiares_id, int persona_codigoFam, int hijo_codigoFam, String parentescoFam, boolean estadoFam, int edadFam, String persona_nombre, String persona_apellido, Date persona_fecha_nac, int persona_ocupacion, int persona_nivel_acad, int persona_estadocivil, char persona_sexo) {
        super(familiares_id, persona_codigoFam, hijo_codigoFam, parentescoFam, estadoFam, edadFam, persona_nombre, persona_apellido, persona_fecha_nac, persona_ocupacion, persona_nivel_acad, persona_estadocivil, persona_sexo);
        this.XhijosFamili_id = XhijosFamili_id;
        this.XfamiliaresId = XfamiliaresId;
        this.XhijoCodig = XhijoCodig;
    }

    public x_hijos_familiares(int XhijosFamili_id, int XfamiliaresId, int XhijoCodig, int familiares_id, int persona_codigoFam, int hijo_codigoFam, String parentescoFam, boolean estadoFam, int edadFam, int persona_codigo, String persona_cedula, String persona_nombre, String persona_apellido, Date persona_fecha_nac, int persona_ocupacion, int persona_nivel_acad, int persona_est_migr, String persona_telefono, String persona_celular, int persona_estadocivil, int persona_nacionalidad, boolean persona_estado_actual, char persona_sexo, String persona_nivel_acad_otros, String persona_lugar_trabajo, String persona_referencia, int edad) {
        super(familiares_id, persona_codigoFam, hijo_codigoFam, parentescoFam, estadoFam, edadFam, persona_codigo, persona_cedula, persona_nombre, persona_apellido, persona_fecha_nac, persona_ocupacion, persona_nivel_acad, persona_est_migr, persona_telefono, persona_celular, persona_estadocivil, persona_nacionalidad, persona_estado_actual, persona_sexo, persona_nivel_acad_otros, persona_lugar_trabajo, persona_referencia, edad);
        this.XhijosFamili_id = XhijosFamili_id;
        this.XfamiliaresId = XfamiliaresId;
        this.XhijoCodig = XhijoCodig;
    }

    public x_hijos_familiares(int XhijosFamili_id, int XfamiliaresId, int XhijoCodig, int familiares_id, int persona_codigoFam, int hijo_codigoFam, String parentescoFam, boolean estadoFam, int edadFam, String persona_cedula, String persona_nombre, String persona_apellido, Date persona_fecha_nac, String persona_telefono, String persona_celular, char persona_sexo) {
        super(familiares_id, persona_codigoFam, hijo_codigoFam, parentescoFam, estadoFam, edadFam, persona_cedula, persona_nombre, persona_apellido, persona_fecha_nac, persona_telefono, persona_celular, persona_sexo);
        this.XhijosFamili_id = XhijosFamili_id;
        this.XfamiliaresId = XfamiliaresId;
        this.XhijoCodig = XhijoCodig;
    }

    public x_hijos_familiares(int XhijosFamili_id, int XfamiliaresId, int XhijoCodig, int familiares_id, int persona_codigoFam, int hijo_codigoFam, String parentescoFam, boolean estadoFam, int edadFam, String persona_cedula, String persona_nombre, String persona_apellido, String persona_telefono, String persona_celular) {
        super(familiares_id, persona_codigoFam, hijo_codigoFam, parentescoFam, estadoFam, edadFam, persona_cedula, persona_nombre, persona_apellido, persona_telefono, persona_celular);
        this.XhijosFamili_id = XhijosFamili_id;
        this.XfamiliaresId = XfamiliaresId;
        this.XhijoCodig = XhijoCodig;
    }

    public x_hijos_familiares(int XhijosFamili_id, int XfamiliaresId, int XhijoCodig, int familiares_id, int persona_codigoFam, int hijo_codigoFam, String parentescoFam, boolean estadoFam, int edadFam, String persona_cedula, String persona_nombre, String persona_apellido, Date persona_fecha_nac, char persona_sexo) {
        super(familiares_id, persona_codigoFam, hijo_codigoFam, parentescoFam, estadoFam, edadFam, persona_cedula, persona_nombre, persona_apellido, persona_fecha_nac, persona_sexo);
        this.XhijosFamili_id = XhijosFamili_id;
        this.XfamiliaresId = XfamiliaresId;
        this.XhijoCodig = XhijoCodig;
    }

    public x_hijos_familiares(int XhijosFamili_id, int XfamiliaresId, int XhijoCodig, int familiares_id, int persona_codigoFam, int hijo_codigoFam, String parentescoFam, boolean estadoFam, int edadFam, int persona_codigo, String persona_cedula, String persona_nombre, String persona_apellido, Date persona_fecha_nac, int persona_ocupacion, int persona_nivel_acad, int persona_est_migr, String persona_telefono, String persona_celular, int persona_estadocivil, int persona_nacionalidad, boolean persona_estado_actual, char persona_sexo, String persona_nivel_acad_otros, String persona_lugar_trabajo, String persona_referencia) {
        super(familiares_id, persona_codigoFam, hijo_codigoFam, parentescoFam, estadoFam, edadFam, persona_codigo, persona_cedula, persona_nombre, persona_apellido, persona_fecha_nac, persona_ocupacion, persona_nivel_acad, persona_est_migr, persona_telefono, persona_celular, persona_estadocivil, persona_nacionalidad, persona_estado_actual, persona_sexo, persona_nivel_acad_otros, persona_lugar_trabajo, persona_referencia);
        this.XhijosFamili_id = XhijosFamili_id;
        this.XfamiliaresId = XfamiliaresId;
        this.XhijoCodig = XhijoCodig;
    }

    public x_hijos_familiares(int XhijosFamili_id, int XfamiliaresId, int XhijoCodig, int familiares_id, int persona_codigoFam, int hijo_codigoFam, String parentescoFam, boolean estadoFam, int edadFam, String persona_cedula, String persona_nombre, String persona_apellido, Date persona_fecha_nac, int persona_ocupacion, int persona_nivel_acad, int persona_est_migr, String persona_telefono, String persona_celular, int persona_estadocivil, int persona_nacionalidad, boolean persona_estado_actual, char persona_sexo, String persona_nivel_acad_otros, String persona_lugar_trabajo, String persona_referencia) {
        super(familiares_id, persona_codigoFam, hijo_codigoFam, parentescoFam, estadoFam, edadFam, persona_cedula, persona_nombre, persona_apellido, persona_fecha_nac, persona_ocupacion, persona_nivel_acad, persona_est_migr, persona_telefono, persona_celular, persona_estadocivil, persona_nacionalidad, persona_estado_actual, persona_sexo, persona_nivel_acad_otros, persona_lugar_trabajo, persona_referencia);
        this.XhijosFamili_id = XhijosFamili_id;
        this.XfamiliaresId = XfamiliaresId;
        this.XhijoCodig = XhijoCodig;
    }

    public x_hijos_familiares(int XhijosFamili_id, int XfamiliaresId, int XhijoCodig) {
        this.XhijosFamili_id = XhijosFamili_id;
        this.XfamiliaresId = XfamiliaresId;
        this.XhijoCodig = XhijoCodig;
    }

    public x_hijos_familiares() {
    }

    public int getXhijosFamili_id() {
        return XhijosFamili_id;
    }

    public void setXhijosFamili_id(int XhijosFamili_id) {
        this.XhijosFamili_id = XhijosFamili_id;
    }

    public int getXfamiliaresId() {
        return XfamiliaresId;
    }

    public void setXfamiliaresId(int XfamiliaresId) {
        this.XfamiliaresId = XfamiliaresId;
    }

    public int getXhijoCodig() {
        return XhijoCodig;
    }

    public void setXhijoCodig(int XhijoCodig) {
        this.XhijoCodig = XhijoCodig;
    }

    
}
