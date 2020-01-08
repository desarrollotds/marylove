package marylove.models;
public class ContactoEmergencia {
private int codigo_contE,per_codigo;
private String parentesco_contE;

    public int getCodigo_contE() {
        return codigo_contE;
    }

    public void setCodigo_contE(int codigo_contE) {
        this.codigo_contE = codigo_contE;
    }

    public int getPer_codigo() {
        return per_codigo;
    }

    public void setPer_codigo(int per_codigo) {
        this.per_codigo = per_codigo;
    }

    public String getParentesco_contE() {
        return parentesco_contE;
    }

    public void setParentesco_contE(String parentesco_contE) {
        this.parentesco_contE = parentesco_contE;
    }

}
