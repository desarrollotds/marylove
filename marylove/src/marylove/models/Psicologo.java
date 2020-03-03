package marylove.models;

public class Psicologo{

    private int codigo_psic;
    private int personal_cod;

    public Psicologo(int codigo_psic, int personal_cod) {
        this.codigo_psic = codigo_psic;
        this.personal_cod = personal_cod;
    }

    public Psicologo() {
    }
    

    public int getCodigo_psic() {
        return codigo_psic;
    }

    public void setCodigo_psic(int codigo_psic) {
        this.codigo_psic = codigo_psic;
    }

    public int getPersonal_cod() {
        return personal_cod;
    }

    public void setPersonal_cod(int personal_cod) {
        this.personal_cod = personal_cod;
    }

}
