package models;
public class InstitucionEducativa {
private int codigo_inst, dir_codigo;
private String  nombre_inst, telefono_inst, tipo_inst;

    public int getCodigo_inst() {
        return codigo_inst;
    }

    public void setCodigo_inst(int codigo_inst) {
        this.codigo_inst = codigo_inst;
    }

    public int getDir_codigo() {
        return dir_codigo;
    }

    public void setDir_codigo(int dir_codigo) {
        this.dir_codigo = dir_codigo;
    }

    public String getNombre_inst() {
        return nombre_inst;
    }

    public void setNombre_inst(String nombre_inst) {
        this.nombre_inst = nombre_inst;
    }

    public String getTelefono_inst() {
        return telefono_inst;
    }

    public void setTelefono_inst(String telefono_inst) {
        this.telefono_inst = telefono_inst;
    }

    public String getTipo_inst() {
        return tipo_inst;
    }

    public void setTipo_inst(String tipo_inst) {
        this.tipo_inst = tipo_inst;
    }

}
