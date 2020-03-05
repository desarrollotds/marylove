
package marylove.models;

/**
 *
 * @author vasquez
 */
public class Educadora {
    private int educadora_codigo;
    private int personal_codigo;

    public Educadora() {
    }

    public Educadora(int educadora_codigo, int personal_codigo) {
        this.educadora_codigo = educadora_codigo;
        this.personal_codigo = personal_codigo;
    }    
    
    public int getEducadora_codigo() {
        return educadora_codigo;
    }

    public void setEducadora_codigo(int educadora_codigo) {
        this.educadora_codigo = educadora_codigo;
    }

    public int getPersonal_codigo() {
        return personal_codigo;
    }

    public void setPersonal_codigo(int personal_codigo) {
        this.personal_codigo = personal_codigo;
    }
    
    
}
