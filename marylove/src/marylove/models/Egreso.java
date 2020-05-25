package marylove.models;

import java.io.FileInputStream;
import java.util.Date;

public class Egreso extends Persona{

    private int egreso_codigo;
    private int victima_codigo;
    private Date egreso_fecha;
    private String egreso_situacion;
    FileInputStream fis;
    int longBytes;
    private byte[] croquis;
    private String canton;
    private String provincia;
    private String per_refe_parentesco;
    private String telefono;
    private int personal_codigo;
    private String direccion;
    private String egresoEstaso;

    public Egreso(int egreso_codigo, int victima_codigo, Date egreso_fecha, String egreso_situacion, FileInputStream fis, int longBytes, byte[] croquis, String canton, String provincia, String per_refe_parentesco, String telefono, int personal_codigo, String direccion, String egresoEstaso) {
        this.egreso_codigo = egreso_codigo;
        this.victima_codigo = victima_codigo;
        this.egreso_fecha = egreso_fecha;
        this.egreso_situacion = egreso_situacion;
        this.fis = fis;
        this.longBytes = longBytes;
        this.croquis = croquis;
        this.canton = canton;
        this.provincia = provincia;
        this.per_refe_parentesco = per_refe_parentesco;
        this.telefono = telefono;
        this.personal_codigo = personal_codigo;
        this.direccion = direccion;
        this.egresoEstaso = egresoEstaso;
    }

    public Egreso(int egreso_codigo, int victima_codigo, Date egreso_fecha, String egreso_situacion, FileInputStream fis, int longBytes, byte[] croquis, String canton, String provincia, String per_refe_parentesco, String telefono, int personal_codigo, String direccion, String egresoEstaso, int persona_codigo, String persona_cedula, String persona_nombre, String persona_apellido, Date persona_fecha_nac, int persona_ocupacion, int persona_nivel_acad, int persona_est_migr, String persona_telefono, String persona_celular, int persona_estadocivil, int persona_nacionalidad, boolean persona_estado_actual, char persona_sexo, String persona_nivel_acad_otros, String persona_lugar_trabajo, String persona_referencia, int edad) {
        super(persona_codigo, persona_cedula, persona_nombre, persona_apellido, persona_fecha_nac, persona_ocupacion, persona_nivel_acad, persona_est_migr, persona_telefono, persona_celular, persona_estadocivil, persona_nacionalidad, persona_estado_actual, persona_sexo, persona_nivel_acad_otros, persona_lugar_trabajo, persona_referencia, edad);
        this.egreso_codigo = egreso_codigo;
        this.victima_codigo = victima_codigo;
        this.egreso_fecha = egreso_fecha;
        this.egreso_situacion = egreso_situacion;
        this.fis = fis;
        this.longBytes = longBytes;
        this.croquis = croquis;
        this.canton = canton;
        this.provincia = provincia;
        this.per_refe_parentesco = per_refe_parentesco;
        this.telefono = telefono;
        this.personal_codigo = personal_codigo;
        this.direccion = direccion;
        this.egresoEstaso = egresoEstaso;
    }

    public Egreso(int egreso_codigo, int victima_codigo, Date egreso_fecha, String egreso_situacion, FileInputStream fis, int longBytes, byte[] croquis, String canton, String provincia, String per_refe_parentesco, String telefono, int personal_codigo, String direccion, String egresoEstaso, String persona_cedula, String persona_nombre, String persona_apellido, Date persona_fecha_nac, String persona_telefono, String persona_celular, char persona_sexo) {
        super(persona_cedula, persona_nombre, persona_apellido, persona_fecha_nac, persona_telefono, persona_celular, persona_sexo);
        this.egreso_codigo = egreso_codigo;
        this.victima_codigo = victima_codigo;
        this.egreso_fecha = egreso_fecha;
        this.egreso_situacion = egreso_situacion;
        this.fis = fis;
        this.longBytes = longBytes;
        this.croquis = croquis;
        this.canton = canton;
        this.provincia = provincia;
        this.per_refe_parentesco = per_refe_parentesco;
        this.telefono = telefono;
        this.personal_codigo = personal_codigo;
        this.direccion = direccion;
        this.egresoEstaso = egresoEstaso;
    }

    public Egreso(int egreso_codigo, int victima_codigo, Date egreso_fecha, String egreso_situacion, FileInputStream fis, int longBytes, byte[] croquis, String canton, String provincia, String per_refe_parentesco, String telefono, int personal_codigo, String direccion, String egresoEstaso, String persona_cedula, String persona_nombre, String persona_apellido, String persona_telefono, String persona_celular) {
        super(persona_cedula, persona_nombre, persona_apellido, persona_telefono, persona_celular);
        this.egreso_codigo = egreso_codigo;
        this.victima_codigo = victima_codigo;
        this.egreso_fecha = egreso_fecha;
        this.egreso_situacion = egreso_situacion;
        this.fis = fis;
        this.longBytes = longBytes;
        this.croquis = croquis;
        this.canton = canton;
        this.provincia = provincia;
        this.per_refe_parentesco = per_refe_parentesco;
        this.telefono = telefono;
        this.personal_codigo = personal_codigo;
        this.direccion = direccion;
        this.egresoEstaso = egresoEstaso;
    }

    public Egreso(int egreso_codigo, int victima_codigo, Date egreso_fecha, String egreso_situacion, FileInputStream fis, int longBytes, byte[] croquis, String canton, String provincia, String per_refe_parentesco, String telefono, int personal_codigo, String direccion, String egresoEstaso, String persona_cedula, String persona_nombre, String persona_apellido, Date persona_fecha_nac, char persona_sexo) {
        super(persona_cedula, persona_nombre, persona_apellido, persona_fecha_nac, persona_sexo);
        this.egreso_codigo = egreso_codigo;
        this.victima_codigo = victima_codigo;
        this.egreso_fecha = egreso_fecha;
        this.egreso_situacion = egreso_situacion;
        this.fis = fis;
        this.longBytes = longBytes;
        this.croquis = croquis;
        this.canton = canton;
        this.provincia = provincia;
        this.per_refe_parentesco = per_refe_parentesco;
        this.telefono = telefono;
        this.personal_codigo = personal_codigo;
        this.direccion = direccion;
        this.egresoEstaso = egresoEstaso;
    }

    public Egreso(int egreso_codigo, int victima_codigo, Date egreso_fecha, String egreso_situacion, FileInputStream fis, int longBytes, byte[] croquis, String canton, String provincia, String per_refe_parentesco, String telefono, int personal_codigo, String direccion, String egresoEstaso, int persona_codigo, String persona_cedula, String persona_nombre, String persona_apellido, Date persona_fecha_nac, int persona_ocupacion, int persona_nivel_acad, int persona_est_migr, String persona_telefono, String persona_celular, int persona_estadocivil, int persona_nacionalidad, boolean persona_estado_actual, char persona_sexo, String persona_nivel_acad_otros, String persona_lugar_trabajo, String persona_referencia) {
        super(persona_codigo, persona_cedula, persona_nombre, persona_apellido, persona_fecha_nac, persona_ocupacion, persona_nivel_acad, persona_est_migr, persona_telefono, persona_celular, persona_estadocivil, persona_nacionalidad, persona_estado_actual, persona_sexo, persona_nivel_acad_otros, persona_lugar_trabajo, persona_referencia);
        this.egreso_codigo = egreso_codigo;
        this.victima_codigo = victima_codigo;
        this.egreso_fecha = egreso_fecha;
        this.egreso_situacion = egreso_situacion;
        this.fis = fis;
        this.longBytes = longBytes;
        this.croquis = croquis;
        this.canton = canton;
        this.provincia = provincia;
        this.per_refe_parentesco = per_refe_parentesco;
        this.telefono = telefono;
        this.personal_codigo = personal_codigo;
        this.direccion = direccion;
        this.egresoEstaso = egresoEstaso;
    }

    public Egreso(int egreso_codigo, int victima_codigo, Date egreso_fecha, String egreso_situacion, FileInputStream fis, int longBytes, byte[] croquis, String canton, String provincia, String per_refe_parentesco, String telefono, int personal_codigo, String direccion, String egresoEstaso, String persona_cedula, String persona_nombre, String persona_apellido, Date persona_fecha_nac, int persona_ocupacion, int persona_nivel_acad, int persona_est_migr, String persona_telefono, String persona_celular, int persona_estadocivil, int persona_nacionalidad, boolean persona_estado_actual, char persona_sexo, String persona_nivel_acad_otros, String persona_lugar_trabajo, String persona_referencia) {
        super(persona_cedula, persona_nombre, persona_apellido, persona_fecha_nac, persona_ocupacion, persona_nivel_acad, persona_est_migr, persona_telefono, persona_celular, persona_estadocivil, persona_nacionalidad, persona_estado_actual, persona_sexo, persona_nivel_acad_otros, persona_lugar_trabajo, persona_referencia);
        this.egreso_codigo = egreso_codigo;
        this.victima_codigo = victima_codigo;
        this.egreso_fecha = egreso_fecha;
        this.egreso_situacion = egreso_situacion;
        this.fis = fis;
        this.longBytes = longBytes;
        this.croquis = croquis;
        this.canton = canton;
        this.provincia = provincia;
        this.per_refe_parentesco = per_refe_parentesco;
        this.telefono = telefono;
        this.personal_codigo = personal_codigo;
        this.direccion = direccion;
        this.egresoEstaso = egresoEstaso;
    }

    public Egreso() {
    }

    public String getEgresoEstaso() {
        return egresoEstaso;
    }

    public void setEgresoEstaso(String egresoEstaso) {
        this.egresoEstaso = egresoEstaso;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public int getEgreso_codigo() {
        return egreso_codigo;
    }

    public void setEgreso_codigo(int egreso_codigo) {
        this.egreso_codigo = egreso_codigo;
    }

    public int getVictima_codigo() {
        return victima_codigo;
    }

    public void setVictima_codigo(int victima_codigo) {
        this.victima_codigo = victima_codigo;
    }

    public Date getEgreso_fecha() {
        return egreso_fecha;
    }

    public void setEgreso_fecha(Date egreso_fecha) {
        this.egreso_fecha = egreso_fecha;
    }

    public String getEgreso_situacion() {
        return egreso_situacion;
    }

    public void setEgreso_situacion(String egreso_situacion) {
        this.egreso_situacion = egreso_situacion;
    }

    public FileInputStream getFis() {
        return fis;
    }

    public void setFis(FileInputStream fis) {
        this.fis = fis;
    }

    public int getLongBytes() {
        return longBytes;
    }

    public void setLongBytes(int longBytes) {
        this.longBytes = longBytes;
    }

    public byte[] getCroquis() {
        return croquis;
    }

    public void setCroquis(byte[] croquis) {
        this.croquis = croquis;
    }

    public String getCanton() {
        return canton;
    }

    public void setCanton(String canton) {
        this.canton = canton;
    }

    public String getProvincia() {
        return provincia;
    }

    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }

    public String getPer_refe_parentesco() {
        return per_refe_parentesco;
    }

    public void setPer_refe_parentesco(String per_refe_parentesco) {
        this.per_refe_parentesco = per_refe_parentesco;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public int getPersonal_codigo() {
        return personal_codigo;
    }

    public void setPersonal_codigo(int personal_codigo) {
        this.personal_codigo = personal_codigo;
    }
  
}