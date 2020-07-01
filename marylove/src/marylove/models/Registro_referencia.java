
package marylove.models;

public class Registro_referencia{
private int registrireferencia_codigo;
private int victima_codigo;
private String	evidencias_agresion;
private int ayuda_codigo;
private boolean	registra_agresioncontinua; 
private boolean llamada_lineaapoyo;
private String frecuencia_agresion;
    public Registro_referencia() {
    }

    public Registro_referencia(int victima_codigo, String evidencias_agresion,  int ayuda_codigo, boolean registra_agresioncontinua, boolean llamada_lineaapoyo, String frecuencia_agresion) {
        this.victima_codigo = victima_codigo;
        this.evidencias_agresion = evidencias_agresion;
        this.ayuda_codigo = ayuda_codigo;
        this.registra_agresioncontinua = registra_agresioncontinua;
        this.llamada_lineaapoyo = llamada_lineaapoyo;
        this.frecuencia_agresion = frecuencia_agresion;
    }

    public boolean isLlamada_lineaapoyo() {
        return llamada_lineaapoyo;
    }

    public void setLlamada_lineaapoyo(boolean llamada_lineaapoyo) {
        this.llamada_lineaapoyo = llamada_lineaapoyo;
    }

    public String getFrecuencia_agresion() {
        return frecuencia_agresion;
    }

    public void setFrecuencia_agresion(String frecuencia_agresion) {
        this.frecuencia_agresion = frecuencia_agresion;
    }


    public int getRegistrireferencia_codigo() {
        return registrireferencia_codigo;
    }

    public void setRegistrireferencia_codigo(int registrireferencia_codigo) {
        this.registrireferencia_codigo = registrireferencia_codigo;
    }

    public int getVictima_codigo() {
        return victima_codigo;
    }

    public void setVictima_codigo(int victima_codigo) {
        this.victima_codigo = victima_codigo;
    }

    public String getEvidencias_agresion() {
        return evidencias_agresion;
    }

    public void setEvidencias_agresion(String evidencias_agresion) {
        this.evidencias_agresion = evidencias_agresion;
    }

    public int getAyuda_codigo() {
        return ayuda_codigo;
    }

    public void setAyuda_codigo(int ayuda_codigo) {
        this.ayuda_codigo = ayuda_codigo;
    }

    public boolean isRegistra_agresioncontinua() {
        return registra_agresioncontinua;
    }

    public void setRegistra_agresioncontinua(boolean registra_agresioncontinua) {
        this.registra_agresioncontinua = registra_agresioncontinua;
    }
}

