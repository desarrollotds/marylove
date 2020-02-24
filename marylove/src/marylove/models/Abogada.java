
package marylove.models;

/**
 *
 * @author vasquez
 */
public class Abogada {
    private int abogada_id;
    private int personal_codigo;

    public Abogada() {
    }

    public Abogada(int abogada_codigo, int personal_id) {
        this.abogada_id = abogada_id;
        this.personal_codigo = personal_codigo;
    }
    

    public int getPersonal_codigo() {
        return personal_codigo;
    }

    public void setPersonal_codigo(int personal_codigo) {
        this.personal_codigo = personal_codigo;
    }

    public int getAbogada_id() {
        return abogada_id;
    }

    public void setAbogada_id(int abogada_id) {
        this.abogada_id = abogada_id;
    }
    
    
}
