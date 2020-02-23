package marylove.models;

public class x_caracteristicas_agresor {
private int x_coract_id;
private int llamada_codigo;
private String registro_observaciones;
private int caracteristica_descripcion;
private int caracteristica_id;

    public x_caracteristicas_agresor() {
    }

    public x_caracteristicas_agresor(int llamada_codigo, String registro_observaciones, int caracteristica_descripcion, int caracteristica_id) {
        this.llamada_codigo = llamada_codigo;
        this.registro_observaciones = registro_observaciones;
        this.caracteristica_descripcion = caracteristica_descripcion;
        this.caracteristica_id = caracteristica_id;
    }
    

    public int getX_coract_id() {
        return x_coract_id;
    }

    public void setX_coract_id(int x_coract_id) {
        this.x_coract_id = x_coract_id;
    }

    public int getLlamada_codigo() {
        return llamada_codigo;
    }

    public void setLlamada_codigo(int llamada_codigo) {
        this.llamada_codigo = llamada_codigo;
    }

    public String getRegistro_observaciones() {
        return registro_observaciones;
    }

    public void setRegistro_observaciones(String registro_observaciones) {
        this.registro_observaciones = registro_observaciones;
    }

    public int getCaracteristica_descripcion() {
        return caracteristica_descripcion;
    }

    public void setCaracteristica_descripcion(int caracteristica_descripcion) {
        this.caracteristica_descripcion = caracteristica_descripcion;
    }

    

    public int getCaracteristica_id() {
        return caracteristica_id;
    }

    public void setCaracteristica_id(int caracteristica_id) {
        this.caracteristica_id = caracteristica_id;
    }


}
