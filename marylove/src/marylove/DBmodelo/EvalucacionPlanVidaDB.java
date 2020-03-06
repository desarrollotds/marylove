
package marylove.DBmodelo;

import java.util.Date;
import marylove.models.EvaluacionPlanVida;

public class EvalucacionPlanVidaDB extends EvaluacionPlanVida{

    public EvalucacionPlanVidaDB() {
    }

    public EvalucacionPlanVidaDB(int evaluacion_id, int victima_codigo, Date evaluacion_fecha, Date evaluacion_proxima, int personal_codigo) {
        super(evaluacion_id, victima_codigo, evaluacion_fecha, evaluacion_proxima, personal_codigo);
    }
    
}
