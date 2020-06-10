
package marylove.models;

import java.util.Date;

public class x_hijos_familiares extends Familiars {
    private int XhijosFamili_id;
    private int XfamiliaresId;
    private int XhijoCodig;

    public x_hijos_familiares(int XhijosFamili_id, int XfamiliaresId, int XhijoCodig, int familiares_id, int persona_codigoFam, int hijo_codigoFam, String parentescoFam, boolean estadoFam, int edadFam) {
        super(familiares_id, persona_codigoFam, hijo_codigoFam, parentescoFam, estadoFam, edadFam);
        this.XhijosFamili_id = XhijosFamili_id;
        this.XfamiliaresId = XfamiliaresId;
        this.XhijoCodig = XhijoCodig;
    }

   
    public x_hijos_familiares() {
    }

    public int getXhijosFamili_id() {
        return XhijosFamili_id;
    }

    public void setXhijosFamili_id(int XhijosFamili_id) {
        this.XhijosFamili_id = XhijosFamili_id;
    }

    public int getXfamiliaresId() {
        return XfamiliaresId;
    }

    public void setXfamiliaresId(int XfamiliaresId) {
        this.XfamiliaresId = XfamiliaresId;
    }

    public int getXhijoCodig() {
        return XhijoCodig;
    }

    public void setXhijoCodig(int XhijoCodig) {
        this.XhijoCodig = XhijoCodig;
    }

    
}
