package marylove.models;

public class x_caracteristicas_agresor {

    private int x_caract_id;
    private int llamada_codigo;
    private String registro_observaciones;
    private String caracteristica_descripcion;
    private int caracteristica_id;
   

    public x_caracteristicas_agresor() {
    }

    public x_caracteristicas_agresor(int llamada_codigo, String registro_observaciones, String caracteristica_descripcion, int caracteristica_id) {
        this.llamada_codigo = llamada_codigo;
        this.registro_observaciones = registro_observaciones;
        this.caracteristica_descripcion = caracteristica_descripcion;
        this.caracteristica_id = caracteristica_id;
        
    }


    
    public int getX_caract_id() {
        return x_caract_id;
    }

    public void setX_caract_id(int x_coract_id) {
        this.x_caract_id = x_coract_id;
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

    public String getCaracteristica_descripcion() {
        return caracteristica_descripcion;
    }

    public void setCaracteristica_descripcion(String caracteristica_descripcion) {
        this.caracteristica_descripcion = caracteristica_descripcion;
    }

    public int getCaracteristica_id() {
        return caracteristica_id;
    }

    public void setCaracteristica_id(int caracteristica_id) {
        this.caracteristica_id = caracteristica_id;
    }

}
