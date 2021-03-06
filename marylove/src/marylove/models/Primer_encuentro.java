package marylove.models;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author Usuario
 */
public class Primer_encuentro extends Persona{

    private int primer_codigo;
    private int victima_codigo;
    private String pstIntCrisis_fecha;
    private String pstIntCrisis_estado_emocional;
    private String pstIntCrisis_nivel_riesgo;
    private String pstIntCrisis_valoracionpreliminar;
    private boolean pstIntCrisis_riesgo_suicida;
    private String pstIntCrisis_puntosReelevantes;
    private boolean pstIntCrisis_proceso_psicoterapeutico;
    private boolean pstIntCrisis_asesoria;
    private int psicologo_codigo;
    private String encuentro_estado;
    
    public Primer_encuentro() {
    }

    public Primer_encuentro(int primer_codigo, int victima_codigo, String pstIntCrisis_fecha, String pstIntCrisis_estado_emocional, String pstIntCrisis_nivel_riesgo, String pstIntCrisis_valoracionpreliminar, boolean pstIntCrisis_riesgo_suicida, String pstIntCrisis_puntosReelevantes, boolean pstIntCrisis_proceso_psicoterapeutico, boolean pstIntCrisis_asesoria, int psicologo_codigo) {
        this.primer_codigo = primer_codigo;
        this.victima_codigo = victima_codigo;
        this.pstIntCrisis_fecha = pstIntCrisis_fecha;
        this.pstIntCrisis_estado_emocional = pstIntCrisis_estado_emocional;
        this.pstIntCrisis_nivel_riesgo = pstIntCrisis_nivel_riesgo;
        this.pstIntCrisis_valoracionpreliminar = pstIntCrisis_valoracionpreliminar;
        this.pstIntCrisis_riesgo_suicida = pstIntCrisis_riesgo_suicida;
        this.pstIntCrisis_puntosReelevantes = pstIntCrisis_puntosReelevantes;
        this.pstIntCrisis_proceso_psicoterapeutico = pstIntCrisis_proceso_psicoterapeutico;
        this.pstIntCrisis_asesoria = pstIntCrisis_asesoria;
        this.psicologo_codigo = psicologo_codigo;
    }

    public Primer_encuentro(int victima_codigo, String pstIntCrisis_fecha, String pstIntCrisis_estado_emocional, String pstIntCrisis_nivel_riesgo, String pstIntCrisis_valoracionpreliminar, boolean pstIntCrisis_riesgo_suicida, String pstIntCrisis_puntosReelevantes, boolean pstIntCrisis_proceso_psicoterapeutico, boolean pstIntCrisis_asesoria, int psicologo_codigo) {
        this.victima_codigo = victima_codigo;
        this.pstIntCrisis_fecha = pstIntCrisis_fecha;
        this.pstIntCrisis_estado_emocional = pstIntCrisis_estado_emocional;
        this.pstIntCrisis_nivel_riesgo = pstIntCrisis_nivel_riesgo;
        this.pstIntCrisis_valoracionpreliminar = pstIntCrisis_valoracionpreliminar;
        this.pstIntCrisis_riesgo_suicida = pstIntCrisis_riesgo_suicida;
        this.pstIntCrisis_puntosReelevantes = pstIntCrisis_puntosReelevantes;
        this.pstIntCrisis_proceso_psicoterapeutico = pstIntCrisis_proceso_psicoterapeutico;
        this.pstIntCrisis_asesoria = pstIntCrisis_asesoria;
        this.psicologo_codigo = psicologo_codigo;
    }

    public Primer_encuentro(int primer_codigo, int victima_codigo, String pstIntCrisis_fecha, String pstIntCrisis_estado_emocional, String pstIntCrisis_nivel_riesgo, String pstIntCrisis_valoracionpreliminar, boolean pstIntCrisis_riesgo_suicida, String pstIntCrisis_puntosReelevantes, boolean pstIntCrisis_proceso_psicoterapeutico, boolean pstIntCrisis_asesoria, int psicologo_codigo, String encuentro_estado) {
        this.primer_codigo = primer_codigo;
        this.victima_codigo = victima_codigo;
        this.pstIntCrisis_fecha = pstIntCrisis_fecha;
        this.pstIntCrisis_estado_emocional = pstIntCrisis_estado_emocional;
        this.pstIntCrisis_nivel_riesgo = pstIntCrisis_nivel_riesgo;
        this.pstIntCrisis_valoracionpreliminar = pstIntCrisis_valoracionpreliminar;
        this.pstIntCrisis_riesgo_suicida = pstIntCrisis_riesgo_suicida;
        this.pstIntCrisis_puntosReelevantes = pstIntCrisis_puntosReelevantes;
        this.pstIntCrisis_proceso_psicoterapeutico = pstIntCrisis_proceso_psicoterapeutico;
        this.pstIntCrisis_asesoria = pstIntCrisis_asesoria;
        this.psicologo_codigo = psicologo_codigo;
        this.encuentro_estado = encuentro_estado;
    }

    public String getEncuentro_estado() {
        return encuentro_estado;
    }

    public void setEncuentro_estado(String encuentro_estado) {
        this.encuentro_estado = encuentro_estado;
    }

    public int getPrimer_codigo() {
        return primer_codigo;
    }

    public void setPrimer_codigo(int primer_codigo) {
        this.primer_codigo = primer_codigo;
    }

    public int getVictima_codigo() {
        return victima_codigo;
    }

    public void setVictima_codigo(int victima_codigo) {
        this.victima_codigo = victima_codigo;
    }

    public String getPstIntCrisis_fecha() {
        return pstIntCrisis_fecha;
    }

    public void setPstIntCrisis_fecha(String pstIntCrisis_fecha) {
        this.pstIntCrisis_fecha = pstIntCrisis_fecha;
    }


    public String getPstIntCrisis_estado_emocional() {
        return pstIntCrisis_estado_emocional;
    }

    public void setPstIntCrisis_estado_emocional(String pstIntCrisis_estado_emocional) {
        this.pstIntCrisis_estado_emocional = pstIntCrisis_estado_emocional;
    }

    public String getPstIntCrisis_nivel_riesgo() {
        return pstIntCrisis_nivel_riesgo;
    }

    public void setPstIntCrisis_nivel_riesgo(String pstIntCrisis_nivel_riesgo) {
        this.pstIntCrisis_nivel_riesgo = pstIntCrisis_nivel_riesgo;
    }

    public String getPstIntCrisis_valoracionpreliminar() {
        return pstIntCrisis_valoracionpreliminar;
    }

    public void setPstIntCrisis_valoracionpreliminar(String pstIntCrisis_valoracionpreliminar) {
        this.pstIntCrisis_valoracionpreliminar = pstIntCrisis_valoracionpreliminar;
    }

    public boolean isPstIntCrisis_riesgo_suicida() {
        return pstIntCrisis_riesgo_suicida;
    }

    public void setPstIntCrisis_riesgo_suicida(boolean pstIntCrisis_riesgo_suicida) {
        this.pstIntCrisis_riesgo_suicida = pstIntCrisis_riesgo_suicida;
    }
    public String getPstIntCrisis_puntosReelevantes() {
        return pstIntCrisis_puntosReelevantes;
    }

    public void setPstIntCrisis_puntosReelevantes(String pstIntCrisis_puntosReelevantes) {
        this.pstIntCrisis_puntosReelevantes = pstIntCrisis_puntosReelevantes;
    }

    public boolean isPstIntCrisis_proceso_psicoterapeutico() {
        return pstIntCrisis_proceso_psicoterapeutico;
    }

    public void setPstIntCrisis_proceso_psicoterapeutico(boolean pstIntCrisis_proceso_psicoterapeutico) {
        this.pstIntCrisis_proceso_psicoterapeutico = pstIntCrisis_proceso_psicoterapeutico;
    }

    public boolean isPstIntCrisis_asesoria() {
        return pstIntCrisis_asesoria;
    }

    public void setPstIntCrisis_asesoria(boolean pstIntCrisis_asesoria) {
        this.pstIntCrisis_asesoria = pstIntCrisis_asesoria;
    }

    public int getPsicologo_codigo() {
        return psicologo_codigo;
    }

    public void setPsicologo_codigo(int psicologo_codigo) {
        this.psicologo_codigo = psicologo_codigo;
    }

}
