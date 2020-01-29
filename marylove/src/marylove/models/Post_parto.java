/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package marylove.models;

/**
 *
 * @author icrv9
 */
public class Post_parto {
private int Post_parto_id;
private String Sensación_post_parto;
private boolean Sexo_esperado;
private String reacción_padre;
private String reacción_madre;
private String alim_leche_master;
private String alim_leche_master_descrip;
private int alim_leche_master_edad_ini;
private int alim_leche_master_fin;
private String problemas_succion;
private String destete_descripcion;
private int edad_sentar;
private int edad_caminar;
private int edad_primeras_palabras;
private int edad_aliment_solido;
private String dificultades_alimentacion;
private int veces_como_diario;
private String actitud_madre_no_come;
private String comer_solo_acompañado;

    public Post_parto() {
    }

    public Post_parto(int Post_parto_id, String Sensación_post_parto, boolean Sexo_esperado, String reacción_padre, String reacción_madre, String alim_leche_master, String alim_leche_master_descrip, int alim_leche_master_edad_ini, int alim_leche_master_fin, String problemas_succion, String destete_descripcion, int edad_sentar, int edad_caminar, int edad_primeras_palabras, int edad_aliment_solido, String dificultades_alimentacion, int veces_como_diario, String actitud_madre_no_come, String comer_solo_acompañado) {
        this.Post_parto_id = Post_parto_id;
        this.Sensación_post_parto = Sensación_post_parto;
        this.Sexo_esperado = Sexo_esperado;
        this.reacción_padre = reacción_padre;
        this.reacción_madre = reacción_madre;
        this.alim_leche_master = alim_leche_master;
        this.alim_leche_master_descrip = alim_leche_master_descrip;
        this.alim_leche_master_edad_ini = alim_leche_master_edad_ini;
        this.alim_leche_master_fin = alim_leche_master_fin;
        this.problemas_succion = problemas_succion;
        this.destete_descripcion = destete_descripcion;
        this.edad_sentar = edad_sentar;
        this.edad_caminar = edad_caminar;
        this.edad_primeras_palabras = edad_primeras_palabras;
        this.edad_aliment_solido = edad_aliment_solido;
        this.dificultades_alimentacion = dificultades_alimentacion;
        this.veces_como_diario = veces_como_diario;
        this.actitud_madre_no_come = actitud_madre_no_come;
        this.comer_solo_acompañado = comer_solo_acompañado;
    }

    public int getPost_parto_id() {
        return Post_parto_id;
    }

    public void setPost_parto_id(int Post_parto_id) {
        this.Post_parto_id = Post_parto_id;
    }

    public String getSensación_post_parto() {
        return Sensación_post_parto;
    }

    public void setSensación_post_parto(String Sensación_post_parto) {
        this.Sensación_post_parto = Sensación_post_parto;
    }

    public boolean isSexo_esperado() {
        return Sexo_esperado;
    }

    public void setSexo_esperado(boolean Sexo_esperado) {
        this.Sexo_esperado = Sexo_esperado;
    }

    public String getReacción_padre() {
        return reacción_padre;
    }

    public void setReacción_padre(String reacción_padre) {
        this.reacción_padre = reacción_padre;
    }

    public String getReacción_madre() {
        return reacción_madre;
    }

    public void setReacción_madre(String reacción_madre) {
        this.reacción_madre = reacción_madre;
    }

    public String getAlim_leche_master() {
        return alim_leche_master;
    }

    public void setAlim_leche_master(String alim_leche_master) {
        this.alim_leche_master = alim_leche_master;
    }

    public String getAlim_leche_master_descrip() {
        return alim_leche_master_descrip;
    }

    public void setAlim_leche_master_descrip(String alim_leche_master_descrip) {
        this.alim_leche_master_descrip = alim_leche_master_descrip;
    }

    public int getAlim_leche_master_edad_ini() {
        return alim_leche_master_edad_ini;
    }

    public void setAlim_leche_master_edad_ini(int alim_leche_master_edad_ini) {
        this.alim_leche_master_edad_ini = alim_leche_master_edad_ini;
    }

    public int getAlim_leche_master_fin() {
        return alim_leche_master_fin;
    }

    public void setAlim_leche_master_fin(int alim_leche_master_fin) {
        this.alim_leche_master_fin = alim_leche_master_fin;
    }

    public String getProblemas_succion() {
        return problemas_succion;
    }

    public void setProblemas_succion(String problemas_succion) {
        this.problemas_succion = problemas_succion;
    }

    public String getDestete_descripcion() {
        return destete_descripcion;
    }

    public void setDestete_descripcion(String destete_descripcion) {
        this.destete_descripcion = destete_descripcion;
    }

    public int getEdad_sentar() {
        return edad_sentar;
    }

    public void setEdad_sentar(int edad_sentar) {
        this.edad_sentar = edad_sentar;
    }

    public int getEdad_caminar() {
        return edad_caminar;
    }

    public void setEdad_caminar(int edad_caminar) {
        this.edad_caminar = edad_caminar;
    }

    public int getEdad_primeras_palabras() {
        return edad_primeras_palabras;
    }

    public void setEdad_primeras_palabras(int edad_primeras_palabras) {
        this.edad_primeras_palabras = edad_primeras_palabras;
    }

    public int getEdad_aliment_solido() {
        return edad_aliment_solido;
    }

    public void setEdad_aliment_solido(int edad_aliment_solido) {
        this.edad_aliment_solido = edad_aliment_solido;
    }

    public String getDificultades_alimentacion() {
        return dificultades_alimentacion;
    }

    public void setDificultades_alimentacion(String dificultades_alimentacion) {
        this.dificultades_alimentacion = dificultades_alimentacion;
    }

    public int getVeces_como_diario() {
        return veces_como_diario;
    }

    public void setVeces_como_diario(int veces_como_diario) {
        this.veces_como_diario = veces_como_diario;
    }

    public String getActitud_madre_no_come() {
        return actitud_madre_no_come;
    }

    public void setActitud_madre_no_come(String actitud_madre_no_come) {
        this.actitud_madre_no_come = actitud_madre_no_come;
    }

    public String getComer_solo_acompañado() {
        return comer_solo_acompañado;
    }

    public void setComer_solo_acompañado(String comer_solo_acompañado) {
        this.comer_solo_acompañado = comer_solo_acompañado;
    }

}

