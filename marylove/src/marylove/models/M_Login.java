
package marylove.models;

public class M_Login {
    private String Usuario;
    private String Contraseña1;
    private String Nombre;
    private String Apellido;
    private String Cedula;
    private String Profesion;
    private String Contraseña2;

    public M_Login(String Usuario, String Contraseña1, String Nombre, String Apellido, String Cedula, String Profesion, String Contraseña2) {
        this.Usuario = Usuario;
        this.Contraseña1 = Contraseña1;
        this.Nombre = Nombre;
        this.Apellido = Apellido;
        this.Cedula = Cedula;
        this.Profesion = Profesion;
        this.Contraseña2 = Contraseña2;
    }

    public M_Login() {
    }

    public String getUsuario() {
        return Usuario;
    }

    public void setUsuario(String Usuario) {
        this.Usuario = Usuario;
    }

    public String getContraseña1() {
        return Contraseña1;
    }

    public void setContraseña1(String Contraseña1) {
        this.Contraseña1 = Contraseña1;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public String getApellido() {
        return Apellido;
    }

    public void setApellido(String Apellido) {
        this.Apellido = Apellido;
    }

    public String getCedula() {
        return Cedula;
    }

    public void setCedula(String Cedula) {
        this.Cedula = Cedula;
    }

    public String getProfesion() {
        return Profesion;
    }

    public void setProfesion(String Profesion) {
        this.Profesion = Profesion;
    }

    public String getContraseña2() {
        return Contraseña2;
    }

    public void setContraseña2(String Contraseña2) {
        this.Contraseña2 = Contraseña2;
    }
    
    
}
