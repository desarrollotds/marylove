package marylove.models;

/**
 *
 * @author LENOVO
 */
public class Plan_Recursos {
    private int plan_recursos_codigo;
    private int codigo_victima;
    private String fecha_elaboracion;
    private String alter_resol_nesi;
    private String monto_actual; //en la base es un campo money
    private int personal_codigo;

    public Plan_Recursos() {
    }

    public Plan_Recursos(int plan_recursos_codigo, int codigo_victima, String fecha_elaboracion, String alter_resol_nesi, String monto_actual, int personal_codigo) {
        this.plan_recursos_codigo = plan_recursos_codigo;
        this.codigo_victima = codigo_victima;
        this.fecha_elaboracion = fecha_elaboracion;
        this.alter_resol_nesi = alter_resol_nesi;
        this.monto_actual = monto_actual;
        this.personal_codigo = personal_codigo;
    }

    public int getPlan_recursos_codigo() {
        return plan_recursos_codigo;
    }

    public void setPlan_recursos_codigo(int plan_recursos_codigo) {
        this.plan_recursos_codigo = plan_recursos_codigo;
    }

    public int getCodigo_victima() {
        return codigo_victima;
    }

    public void setCodigo_victima(int codigo_victima) {
        this.codigo_victima = codigo_victima;
    }

    public String getFecha_elaboracion() {
        return fecha_elaboracion;
    }

    public void setFecha_elaboracion(String fecha_elaboracion) {
        this.fecha_elaboracion = fecha_elaboracion;
    }

    public String getAlter_resol_nesi() {
        return alter_resol_nesi;
    }

    public void setAlter_resol_nesi(String alter_resol_nesi) {
        this.alter_resol_nesi = alter_resol_nesi;
    }

    public String getMonto_actual() {
        return monto_actual;
    }

    public void setMonto_actual(String monto_actual) {
        this.monto_actual = monto_actual;
    }

    public int getPersonal_codigo() {
        return personal_codigo;
    }

    public void setPersonal_codigo(int personal_codigo) {
        this.personal_codigo = personal_codigo;
    }

    
    
    
}
