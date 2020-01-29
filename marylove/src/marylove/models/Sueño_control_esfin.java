
package marylove.models;

/**
 *
 * @author icrv9
 */
public class Sueño_control_esfin {
private int sucoes_id;
private boolean duerme_toda_noche;
private boolean miedo_dormir_solo;
private String despertar_descripcion;
private boolean pesadillas;
private int acompañamiento_dormir;//relacion con la tabla prametros
private int edad_control_esfinter;
private boolean ayuda_baño;
private boolean moja_cama;
private String periodo_ecopresis_descrip;

    public int getSucoes_id() {
        return sucoes_id;
    }

    public void setSucoes_id(int sucoes_id) {
        this.sucoes_id = sucoes_id;
    }

    public boolean isDuerme_toda_noche() {
        return duerme_toda_noche;
    }

    public void setDuerme_toda_noche(boolean duerme_toda_noche) {
        this.duerme_toda_noche = duerme_toda_noche;
    }

    public boolean isMiedo_dormir_solo() {
        return miedo_dormir_solo;
    }

    public void setMiedo_dormir_solo(boolean miedo_dormir_solo) {
        this.miedo_dormir_solo = miedo_dormir_solo;
    }

    public String getDespertar_descripcion() {
        return despertar_descripcion;
    }

    public void setDespertar_descripcion(String despertar_descripcion) {
        this.despertar_descripcion = despertar_descripcion;
    }

    public boolean isPesadillas() {
        return pesadillas;
    }

    public void setPesadillas(boolean pesadillas) {
        this.pesadillas = pesadillas;
    }

    public int getAcompañamiento_dormir() {
        return acompañamiento_dormir;
    }

    public void setAcompañamiento_dormir(int acompañamiento_dormir) {
        this.acompañamiento_dormir = acompañamiento_dormir;
    }

    public int getEdad_control_esfinter() {
        return edad_control_esfinter;
    }

    public void setEdad_control_esfinter(int edad_control_esfinter) {
        this.edad_control_esfinter = edad_control_esfinter;
    }

    public boolean isAyuda_baño() {
        return ayuda_baño;
    }

    public void setAyuda_baño(boolean ayuda_baño) {
        this.ayuda_baño = ayuda_baño;
    }

    public boolean isMoja_cama() {
        return moja_cama;
    }

    public void setMoja_cama(boolean moja_cama) {
        this.moja_cama = moja_cama;
    }

    public String getPeriodo_ecopresis_descrip() {
        return periodo_ecopresis_descrip;
    }

    public void setPeriodo_ecopresis_descrip(String periodo_ecopresis_descrip) {
        this.periodo_ecopresis_descrip = periodo_ecopresis_descrip;
    }

    public Sueño_control_esfin(int sucoes_id, boolean duerme_toda_noche, boolean miedo_dormir_solo, String despertar_descripcion, boolean pesadillas, int acompañamiento_dormir, int edad_control_esfinter, boolean ayuda_baño, boolean moja_cama, String periodo_ecopresis_descrip) {
        this.sucoes_id = sucoes_id;
        this.duerme_toda_noche = duerme_toda_noche;
        this.miedo_dormir_solo = miedo_dormir_solo;
        this.despertar_descripcion = despertar_descripcion;
        this.pesadillas = pesadillas;
        this.acompañamiento_dormir = acompañamiento_dormir;
        this.edad_control_esfinter = edad_control_esfinter;
        this.ayuda_baño = ayuda_baño;
        this.moja_cama = moja_cama;
        this.periodo_ecopresis_descrip = periodo_ecopresis_descrip;
    }

    public Sueño_control_esfin(boolean duerme_toda_noche, boolean miedo_dormir_solo, String despertar_descripcion, boolean pesadillas, int acompañamiento_dormir, int edad_control_esfinter, boolean ayuda_baño, boolean moja_cama, String periodo_ecopresis_descrip) {
        this.duerme_toda_noche = duerme_toda_noche;
        this.miedo_dormir_solo = miedo_dormir_solo;
        this.despertar_descripcion = despertar_descripcion;
        this.pesadillas = pesadillas;
        this.acompañamiento_dormir = acompañamiento_dormir;
        this.edad_control_esfinter = edad_control_esfinter;
        this.ayuda_baño = ayuda_baño;
        this.moja_cama = moja_cama;
        this.periodo_ecopresis_descrip = periodo_ecopresis_descrip;
    }

    public Sueño_control_esfin() {
    }

}
