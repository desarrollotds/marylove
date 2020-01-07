package models;
public class Personal {
private String usuario_personal,contrasenia_personal;
private int codigo_perosonal, persona_codigo;

    public String getUsuario_personal() {
        return usuario_personal;
    }

    public void setUsuario_personal(String usuario_personal) {
        this.usuario_personal = usuario_personal;
    }

    public String getContrasenia_personal() {
        return contrasenia_personal;
    }

    public void setContrasenia_personal(String contrasenia_personal) {
        this.contrasenia_personal = contrasenia_personal;
    }

    public int getCodigo_perosonal() {
        return codigo_perosonal;
    }

    public void setCodigo_perosonal(int codigo_perosonal) {
        this.codigo_perosonal = codigo_perosonal;
    }

    public int getPersona_codigo() {
        return persona_codigo;
    }

    public void setPersona_codigo(int persona_codigo) {
        this.persona_codigo = persona_codigo;
    }

}
