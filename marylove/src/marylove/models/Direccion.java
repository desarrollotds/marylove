package marylove.models;

public class Direccion {

    private int dir_codigo;
    private String calle_dir;
    private String dir_interseccion;
    private String dir_num_casa;
    private String dir_barrio;
    private String dir_parroquia;
    private String dir_ciudad;
    private String dir_referencias;
    private String dir_estado;

    public Direccion() {
    }

    public Direccion(int dir_codigo, String calle_dir, String dir_interseccion, String dir_num_casa, String dir_barrio, String dir_parroquia, String dir_ciudad, String dir_referencias, String dir_estado) {
        this.dir_codigo = dir_codigo;
        this.calle_dir = calle_dir;
        this.dir_interseccion = dir_interseccion;
        this.dir_num_casa = dir_num_casa;
        this.dir_barrio = dir_barrio;
        this.dir_parroquia = dir_parroquia;
        this.dir_ciudad = dir_ciudad;
        this.dir_referencias = dir_referencias;
        this.dir_estado = dir_estado;
    }

    public int getDir_codigo() {
        return dir_codigo;
    }

    public void setDir_codigo(int dir_codigo) {
        this.dir_codigo = dir_codigo;
    }

    public String getCalle_dir() {
        return calle_dir;
    }

    public void setCalle_dir(String calle_dir) {
        this.calle_dir = calle_dir;
    }

    public String getDir_interseccion() {
        return dir_interseccion;
    }

    public void setDir_interseccion(String dir_interseccion) {
        this.dir_interseccion = dir_interseccion;
    }

    public String getDir_num_casa() {
        return dir_num_casa;
    }

    public void setDir_num_casa(String dir_num_casa) {
        this.dir_num_casa = dir_num_casa;
    }

    public String getDir_barrio() {
        return dir_barrio;
    }

    public void setDir_barrio(String dir_barrio) {
        this.dir_barrio = dir_barrio;
    }

    public String getDir_parroquia() {
        return dir_parroquia;
    }

    public void setDir_parroquia(String dir_parroquia) {
        this.dir_parroquia = dir_parroquia;
    }

    public String getDir_ciudad() {
        return dir_ciudad;
    }

    public void setDir_ciudad(String dir_ciudad) {
        this.dir_ciudad = dir_ciudad;
    }

    public String getDir_referencias() {
        return dir_referencias;
    }

    public void setDir_referencias(String dir_referencias) {
        this.dir_referencias = dir_referencias;
    }

    public String getDir_estado() {
        return dir_estado;
    }

    public void setDir_estado(String dir_estado) {
        this.dir_estado = dir_estado;
    }

}
