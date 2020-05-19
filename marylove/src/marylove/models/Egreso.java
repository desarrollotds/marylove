package marylove.models;

import java.io.FileInputStream;
import java.util.Date;

public class Egreso {

    private int egreso_codigo;
    private int victima_codigo;
    private Date egreso_fecha;
    private String egreso_situacion;
    FileInputStream fis;
    int longBytes;
    private byte croquis;
    private String canton;
    private String provincia;
    private String per_refe_parentesco;
    private String telefono;
    private int personal_codigo;

    public Egreso(int victima_codigo, Date egreso_fecha, String egreso_situacion, byte croquis, String canton, String provincia, String per_refe_parentesco, String telefono, int personal_codigo) {
        this.victima_codigo = victima_codigo;
        this.egreso_fecha = egreso_fecha;
        this.egreso_situacion = egreso_situacion;
        this.croquis = croquis;
        this.canton = canton;
        this.provincia = provincia;
        this.per_refe_parentesco = per_refe_parentesco;
        this.telefono = telefono;
        this.personal_codigo = personal_codigo;
    }

    public Egreso() {
    }

    public Egreso(int victima_codigo, Date egreso_fecha, String egreso_situacion, FileInputStream fis, int longBytes, byte croquis, String canton, String provincia, String per_refe_parentesco, String telefono, int personal_codigo) {
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
    }

    public Egreso(int egreso_codigo, int victima_codigo, Date egreso_fecha, String egreso_situacion, FileInputStream fis, int longBytes, byte croquis, String canton, String provincia, String per_refe_parentesco, String telefono, int personal_codigo) {
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

    public byte getCroquis() {
        return croquis;
    }

    public void setCroquis(byte croquis) {
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