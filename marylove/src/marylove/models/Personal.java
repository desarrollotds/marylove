package marylove.models;
public class Personal {
private int personal_codigo;
private String personal_usuario ;
private String personal_contra ;
private int  persona_codigo;

    public Personal() {
    }

    public Personal(int personal_codigo, String personal_usuario, String personal_contra, int persona_codigo) {
        this.personal_codigo = personal_codigo;
        this.personal_usuario = personal_usuario;
        this.personal_contra = personal_contra;
        this.persona_codigo = persona_codigo;
    }

    public int getPersonal_codigo() {
        return personal_codigo;
    }

    public void setPersonal_codigo(int personal_codigo) {
        this.personal_codigo = personal_codigo;
    }

    public String getPersonal_usuario() {
        return personal_usuario;
    }

    public void setPersonal_usuario(String personal_usuario) {
        this.personal_usuario = personal_usuario;
    }

    public String getPersonal_contra() {
        return personal_contra;
    }

    public void setPersonal_contra(String personal_contra) {
        this.personal_contra = personal_contra;
    }

    public int getPersona_codigo() {
        return persona_codigo;
    }

    public void setPersona_codigo(int persona_codigo) {
        this.persona_codigo = persona_codigo;
    }
   
}
