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
    private String Sensacion_post_parto;
    private boolean Sexo_esperado;
    private String reaccion_padre;
    private String reaccion_madre;
    private String alim_leche_master;
    private String alim_leche_master_descrip;
    private String problemas_succion;
    private String destete_descripcion;
    private int edad_sentar;
    private int edad_caminar;
    private int edad_primeras_palabras;
    private int edad_aliment_solido;
    private String dificultades_alimentacion;
    private int veces_como_diario;
    private String actitud_madre_no_come;
    private String comer_solo_acompanado;
    private boolean post_parto_estado;
    private String edad_fin_leche_mater;
    private boolean biberon;
    private String biberon_edad_ini;
    private String biberon_edad_fin;
            
    public Post_parto() {
    }

    public Post_parto(int Post_parto_id, String Sensacion_post_parto, boolean Sexo_esperado, String reaccion_padre, String reaccion_madre, String alim_leche_master, String alim_leche_master_descrip, String problemas_succion, String destete_descripcion, int edad_sentar, int edad_caminar, int edad_primeras_palabras, int edad_aliment_solido, String dificultades_alimentacion, int veces_como_diario, String actitud_madre_no_come, String comer_solo_acompanado, boolean post_parto_estado, String edad_fin_leche_mater, boolean biberon, String biberon_edad_ini, String biberon_edad_fin) {
        this.Post_parto_id = Post_parto_id;
        this.Sensacion_post_parto = Sensacion_post_parto;
        this.Sexo_esperado = Sexo_esperado;
        this.reaccion_padre = reaccion_padre;
        this.reaccion_madre = reaccion_madre;
        this.alim_leche_master = alim_leche_master;
        this.alim_leche_master_descrip = alim_leche_master_descrip;
        this.problemas_succion = problemas_succion;
        this.destete_descripcion = destete_descripcion;
        this.edad_sentar = edad_sentar;
        this.edad_caminar = edad_caminar;
        this.edad_primeras_palabras = edad_primeras_palabras;
        this.edad_aliment_solido = edad_aliment_solido;
        this.dificultades_alimentacion = dificultades_alimentacion;
        this.veces_como_diario = veces_como_diario;
        this.actitud_madre_no_come = actitud_madre_no_come;
        this.comer_solo_acompanado = comer_solo_acompanado;
        this.post_parto_estado = post_parto_estado;
        this.edad_fin_leche_mater = edad_fin_leche_mater;
        this.biberon = biberon;
        this.biberon_edad_ini = biberon_edad_ini;
        this.biberon_edad_fin = biberon_edad_fin;
    }

    public Post_parto(int Post_parto_id, String Sensacion_post_parto, boolean Sexo_esperado, String reaccion_padre, String reaccion_madre, String alim_leche_master, String alim_leche_master_descrip, String problemas_succion, String destete_descripcion, int edad_sentar, int edad_caminar, int edad_primeras_palabras, int edad_aliment_solido, String dificultades_alimentacion, int veces_como_diario, String actitud_madre_no_come, String comer_solo_acompanado, String edad_fin_leche_mater, boolean biberon, String biberon_edad_ini, String biberon_edad_fin) {
        this.Post_parto_id = Post_parto_id;
        this.Sensacion_post_parto = Sensacion_post_parto;
        this.Sexo_esperado = Sexo_esperado;
        this.reaccion_padre = reaccion_padre;
        this.reaccion_madre = reaccion_madre;
        this.alim_leche_master = alim_leche_master;
        this.alim_leche_master_descrip = alim_leche_master_descrip;
        this.problemas_succion = problemas_succion;
        this.destete_descripcion = destete_descripcion;
        this.edad_sentar = edad_sentar;
        this.edad_caminar = edad_caminar;
        this.edad_primeras_palabras = edad_primeras_palabras;
        this.edad_aliment_solido = edad_aliment_solido;
        this.dificultades_alimentacion = dificultades_alimentacion;
        this.veces_como_diario = veces_como_diario;
        this.actitud_madre_no_come = actitud_madre_no_come;
        this.comer_solo_acompanado = comer_solo_acompanado;
        this.edad_fin_leche_mater = edad_fin_leche_mater;
        this.biberon = biberon;
        this.biberon_edad_ini = biberon_edad_ini;
        this.biberon_edad_fin = biberon_edad_fin;
    }

    public Post_parto(String Sensacion_post_parto, boolean Sexo_esperado, String reaccion_padre, String reaccion_madre, String alim_leche_master, String alim_leche_master_descrip, String problemas_succion, String destete_descripcion, int edad_sentar, int edad_caminar, int edad_primeras_palabras, int edad_aliment_solido, String dificultades_alimentacion, int veces_como_diario, String actitud_madre_no_come, String comer_solo_acompanado, String edad_fin_leche_mater, boolean biberon, String biberon_edad_ini, String biberon_edad_fin) {
        this.Sensacion_post_parto = Sensacion_post_parto;
        this.Sexo_esperado = Sexo_esperado;
        this.reaccion_padre = reaccion_padre;
        this.reaccion_madre = reaccion_madre;
        this.alim_leche_master = alim_leche_master;
        this.alim_leche_master_descrip = alim_leche_master_descrip;
        this.problemas_succion = problemas_succion;
        this.destete_descripcion = destete_descripcion;
        this.edad_sentar = edad_sentar;
        this.edad_caminar = edad_caminar;
        this.edad_primeras_palabras = edad_primeras_palabras;
        this.edad_aliment_solido = edad_aliment_solido;
        this.dificultades_alimentacion = dificultades_alimentacion;
        this.veces_como_diario = veces_como_diario;
        this.actitud_madre_no_come = actitud_madre_no_come;
        this.comer_solo_acompanado = comer_solo_acompanado;
        this.edad_fin_leche_mater = edad_fin_leche_mater;
        this.biberon = biberon;
        this.biberon_edad_ini = biberon_edad_ini;
        this.biberon_edad_fin = biberon_edad_fin;
    }

    public int getPost_parto_id() {
        return Post_parto_id;
    }

    public void setPost_parto_id(int Post_parto_id) {
        this.Post_parto_id = Post_parto_id;
    }

    public String getSensacion_post_parto() {
        return Sensacion_post_parto;
    }

    public void setSensacion_post_parto(String Sensacion_post_parto) {
        this.Sensacion_post_parto = Sensacion_post_parto;
    }

    public boolean isSexo_esperado() {
        return Sexo_esperado;
    }

    public void setSexo_esperado(boolean Sexo_esperado) {
        this.Sexo_esperado = Sexo_esperado;
    }

    public String getReaccion_padre() {
        return reaccion_padre;
    }

    public void setReaccion_padre(String reaccion_padre) {
        this.reaccion_padre = reaccion_padre;
    }

    public String getReaccion_madre() {
        return reaccion_madre;
    }

    public void setReaccion_madre(String reaccion_madre) {
        this.reaccion_madre = reaccion_madre;
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

    public String getComer_solo_acompanado() {
        return comer_solo_acompanado;
    }

    public void setComer_solo_acompanado(String comer_solo_acompanado) {
        this.comer_solo_acompanado = comer_solo_acompanado;
    }

    public boolean isPost_parto_estado() {
        return post_parto_estado;
    }

    public void setPost_parto_estado(boolean post_parto_estado) {
        this.post_parto_estado = post_parto_estado;
    }

    public String getEdad_fin_leche_mater() {
        return edad_fin_leche_mater;
    }

    public void setEdad_fin_leche_mater(String edad_fin_leche_mater) {
        this.edad_fin_leche_mater = edad_fin_leche_mater;
    }

    public boolean isBiberon() {
        return biberon;
    }

    public void setBiberon(boolean biberon) {
        this.biberon = biberon;
    }

    public String getBiberon_edad_ini() {
        return biberon_edad_ini;
    }

    public void setBiberon_edad_ini(String biberon_edad_ini) {
        this.biberon_edad_ini = biberon_edad_ini;
    }

    public String getBiberon_edad_fin() {
        return biberon_edad_fin;
    }

    public void setBiberon_edad_fin(String biberon_edad_fin) {
        this.biberon_edad_fin = biberon_edad_fin;
    }

}