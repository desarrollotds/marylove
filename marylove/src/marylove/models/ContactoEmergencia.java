package marylove.models;

public class ContactoEmergencia {

    private int cont_codigo;
    private String cont_parentesco;
    private int per_codigo;
    private String cont_numero_celular;
    private int per_rela_codigo;
    private String cont_domicilio;
    private String cont_numero_telefono;
    
    public ContactoEmergencia() {
    }

    public ContactoEmergencia(String cont_parentesco, int per_codigo, String cont_numero_celular, int per_rela_codigo, String cont_domicilio, String cont_numero_telefono) {
        this.cont_parentesco = cont_parentesco;
        this.per_codigo = per_codigo;
        this.cont_numero_celular = cont_numero_celular;
        this.per_rela_codigo = per_rela_codigo;
        this.cont_domicilio = cont_domicilio;
        this.cont_numero_telefono = cont_numero_telefono;
    }

    public int getCont_codigo() {
        return cont_codigo;
    }

    public void setCont_codigo(int cont_codigo) {
        this.cont_codigo = cont_codigo;
    }

    public String getCont_parentesco() {
        return cont_parentesco;
    }

    public void setCont_parentesco(String cont_parentesco) {
        this.cont_parentesco = cont_parentesco;
    }

    public int getPer_codigo() {
        return per_codigo;
    }

    public void setPer_codigo(int per_codigo) {
        this.per_codigo = per_codigo;
    }

    public String getCont_numero_celular() {
        return cont_numero_celular;
    }

    public void setCont_numero_celular(String cont_numero_celular) {
        this.cont_numero_celular = cont_numero_celular;
    }

    public int getPer_rela_codigo() {
        return per_rela_codigo;
    }

    public void setPer_rela_codigo(int per_rela_codigo) {
        this.per_rela_codigo = per_rela_codigo;
    }

    public String getCont_domicilio() {
        return cont_domicilio;
    }

    public void setCont_domicilio(String cont_domicilio) {
        this.cont_domicilio = cont_domicilio;
    }

    public String getCont_numero_telefono() {
        return cont_numero_telefono;
    }

    public void setCont_numero_telefono(String cont_numero_telefono) {
        this.cont_numero_telefono = cont_numero_telefono;
    }
 
 
    
}
