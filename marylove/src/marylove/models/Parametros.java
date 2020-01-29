package marylove.models;

public class Parametros {

    private int par_id;
    private String par_valores;
    private String par_nombre;

    public Parametros() {
    }

    public Parametros(int par_id, String par_valores, String par_nombre) {
        this.par_id = par_id;
        this.par_valores = par_valores;
        this.par_nombre = par_nombre;
    }

    public int getPar_id() {
        return par_id;
    }

    public void setPar_id(int par_id) {
        this.par_id = par_id;
    }

    public String getPar_valores() {
        return par_valores;
    }

    public void setPar_valores(String par_valores) {
        this.par_valores = par_valores;
    }

    public String getPar_nombre() {
        return par_nombre;
    }

    public void setPar_nombre(String par_nombre) {
        this.par_nombre = par_nombre;
    }

}
