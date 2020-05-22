/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package marylove.controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import marylove.DBmodelo.DesarrolloDB;
import marylove.DBmodelo.Embarazo_complicacionesDB;
import marylove.DBmodelo.Embarazo_estadoDB;
import marylove.DBmodelo.EscolaridadDB;
import marylove.DBmodelo.FichaAnamnesisBD;
import marylove.DBmodelo.HijosDB;
import marylove.DBmodelo.Relacion_familiar_nnaDB;
import marylove.DBmodelo.Salud_nnaDB;
import marylove.DBmodelo.Sueno_control_esfinDB;
import marylove.DBmodelo.x_embarazo_compDB;
import marylove.vista.FichaAnamnesis;
import org.json.simple.parser.ParseException;

/**
 *
 * @author Usuario
 */
public class ControladorFichaAnamnesisNew implements ActionListener {

    private FichaAnamnesis v;
    private FichaAnamnesisBD modeloAnamnesisBD;
    DesarrolloDB ddb;
    Sueno_control_esfinDB scedb;
    HijosDB hdb = new HijosDB();
    Embarazo_estadoDB eedb;
    EscolaridadDB edb;
    Salud_nnaDB snnadb;
    Relacion_familiar_nnaDB rfnnadb;
    FiltroHijosVictima fhv;
    Embarazo_complicacionesDB ecdb;
    x_embarazo_compDB xedb;
    private static int codigoVictima;

    public ControladorFichaAnamnesisNew() throws Exception {
    }

    public ControladorFichaAnamnesisNew(FichaAnamnesis v, FichaAnamnesisBD modeloAnamnesisBD, DesarrolloDB ddb, Sueno_control_esfinDB scedb, Embarazo_estadoDB eedb, EscolaridadDB edb, Salud_nnaDB snnadb, Relacion_familiar_nnaDB rfnnadb, FiltroHijosVictima fhv, Embarazo_complicacionesDB ecdb, x_embarazo_compDB xedb) throws ParseException, Exception {
        this.v = v;
        this.modeloAnamnesisBD = modeloAnamnesisBD;
        this.ddb = ddb;
        this.scedb = scedb;
        this.eedb = eedb;
        this.edb = edb;
        this.snnadb = snnadb;
        this.rfnnadb = rfnnadb;
        this.fhv = fhv;
        this.ecdb = ecdb;
        this.xedb = xedb;
    }

    public ControladorFichaAnamnesisNew(FichaAnamnesis v) {
        this.v = v;

        //desarrollo
        this.v.getJcxNormalMotorGrueso().addActionListener(this);
        this.v.getJcxIrregularMotorGrueso().addActionListener(this);
        this.v.getJcxNormalMotorFino().addActionListener(this);
        this.v.getJcxIrregularMotorFino().addActionListener(this);
        this.v.getJcxClaro().addActionListener(this);
        this.v.getJcxNoMuyClaro().addActionListener(this);
        this.v.getJcxNoSeEntiende().addActionListener(this);
        //seuno_control_esfin
        this.v.getJcxSiDuerme().addActionListener(this);
        this.v.getJcxNoDuerme().addActionListener(this);
        this.v.getJcxSiMiedoDormir().addActionListener(this);
        this.v.getJcxNoMiedoDormir().addActionListener(this);
        this.v.getJcxSiPesadillas().addActionListener(this);
        this.v.getJcxNoPesadillas().addActionListener(this);
        this.v.getJcxSiAyudaBanho().addActionListener(this);
        this.v.getJcxNoAyudaBanho().addActionListener(this);
        this.v.getJcxSiMojaCama().addActionListener(this);
        this.v.getJcxNoMojaCama().addActionListener(this);
        this.v.getJcxSiEcopresis().addActionListener(this);
        this.v.getJcxNoEcopresis().addActionListener(this);
        //escolaridad
        this.v.getJcxSiEstudia().addActionListener(this);
        this.v.getJcxNoEstudia().addActionListener(this);
        this.v.getJcxSiAprendizaje().addActionListener(this);
        this.v.getJcxNoAprendizaje().addActionListener(this);
        this.v.getJcxSiNivelacion().addActionListener(this);
        this.v.getJcxNoNivelacion().addActionListener(this);
        //salud_nna
        this.v.getJcxSiProblemasRespiratorios().addActionListener(this);
        this.v.getJcxNoProblemasRespiratorios().addActionListener(this);
        this.v.getJcxSiAlergias().addActionListener(this);
        this.v.getJcxNoAlergias().addActionListener(this);
        this.v.getJcxSiNeurologicos().addActionListener(this);
        this.v.getJcxNoNeurologicos().addActionListener(this);
        this.v.getJcxSiNerviosos().addActionListener(this);
        this.v.getJcxNoNerviosos().addActionListener(this);
        //relacion_familira_nna
        this.v.getJcxSiTrabajo().addActionListener(this);
        this.v.getJcxNoTrabajo().addActionListener(this);
        this.v.getJcxSiAgrede().addActionListener(this);
        this.v.getJcxNoAgrede().addActionListener(this);
        //periodo de enbarazo
        this.v.getJcxSiViolencia().addActionListener(this);
        this.v.getJcxNoViolencia().addActionListener(this);
        this.v.getJcxSiControles().addActionListener(this);
        this.v.getJcxNoControles().addActionListener(this);
        this.v.getJcxSiComplicaciones().addActionListener(this);
        this.v.getJcxNoComplicaciones().addActionListener(this);
        this.v.getJcxSiConsume().addActionListener(this);
        this.v.getJcxNoConsume().addActionListener(this);
        this.v.getJcxSiAborto().addActionListener(this);
        this.v.getJcxNoAborto().addActionListener(this);
        System.out.println(codigoVictima);
        //igual la variable estatica con la que genere la ventana anterior
        // this.v.getTxtAnhoCursa().setText(hdb.obtener_anioescolar(Integer.parseInt(v.txtCodigo.getText())));
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        //---------------------------------------------juego violencia durante embarazo
        if (v.getJcxSiViolencia().isSelected()) {
            v.getJcxNoViolencia().setEnabled(false);
        } else {
            v.getJcxNoViolencia().setEnabled(true);
        }
        if (v.getJcxNoViolencia().isSelected()) {
            v.getJcxSiViolencia().setEnabled(false);
            v.getJcxGolpes().setEnabled(false);
            v.getJcxAbusoSexual().setEnabled(false);
            v.getJcxInsultos().setEnabled(false);
            v.getJcxNegligencia().setEnabled(false);
            v.getJcxAmbitoLaboral().setEnabled(false);
        } else {
            v.getJcxSiViolencia().setEnabled(true);
            v.getJcxGolpes().setEnabled(true);
            v.getJcxAbusoSexual().setEnabled(true);
            v.getJcxInsultos().setEnabled(true);
            v.getJcxNegligencia().setEnabled(true);
            v.getJcxAmbitoLaboral().setEnabled(true);
        }
        //---------------------------------------------juego controles medicos
        if (v.getJcxSiControles().isSelected()) {
            v.getJcxNoControles().setEnabled(false);
            v.getJcxNinguna().setEnabled(false);
        } else {

        }
        if (v.getJcxNoControles().isSelected()) {
            v.getJcxSiControles().setEnabled(false);
            v.getJcxUnaVez().setEnabled(false);
            v.getJcxMensual().setEnabled(false);
            v.getJcxTrimestral().setEnabled(false);
            v.getJcxNinguna().setSelected(true);
            v.getTxtDondeRealizoControles().setEnabled(false);
        } else {
            v.getJcxSiControles().setEnabled(true);
            v.getJcxUnaVez().setEnabled(true);
            v.getJcxMensual().setEnabled(true);
            v.getJcxTrimestral().setEnabled(true);
            v.getJcxNinguna().setSelected(false);
            v.getTxtDondeRealizoControles().setEnabled(true);
        }
        //---------------------------------------------juego complicaciones embarazo
        if (v.getJcxSiComplicaciones().isSelected()) {
            v.getJcxNoComplicaciones().setEnabled(false);
        } else {

        }
        if (v.getJcxNoComplicaciones().isSelected()) {
            v.getJcxSiComplicaciones().setEnabled(false);
            v.getJcxBajoPeso().setEnabled(false);
            v.getJcxHemorragias().setEnabled(false);
            v.getJcxInfecciones().setEnabled(false);
            v.getJcxPreclansia().setEnabled(false);
            v.getTxtOtraComplicacionEmbarazo().setEditable(false);
        } else {
            v.getJcxSiComplicaciones().setEnabled(true);
            v.getJcxBajoPeso().setEnabled(true);
            v.getJcxHemorragias().setEnabled(true);
            v.getJcxInfecciones().setEnabled(true);
            v.getJcxPreclansia().setEnabled(true);
            v.getTxtOtraComplicacionEmbarazo().setEditable(true);
        }
        //---------------------------------------------juego consumo
        if (v.getJcxSiConsume().isSelected()) {
            v.getJcxNoConsume().setEnabled(false);
        } else {

        }
        if (v.getJcxNoConsume().isSelected()) {
            v.getJcxSiConsume().setEnabled(false);
            v.getJcxTabaco().setEnabled(false);
            v.getJcxAlcohol().setEnabled(false);
            v.getJcxDroga().setEnabled(false);
            v.getTxtCausasConsumo().setEditable(false);
        } else {
            v.getJcxSiConsume().setEnabled(true);
            v.getJcxTabaco().setEnabled(true);
            v.getJcxAlcohol().setEnabled(true);
            v.getJcxDroga().setEnabled(true);
            v.getTxtCausasConsumo().setEditable(true);
        }
        //---------------------------------------------juego aborto
        if (v.getJcxSiAborto().isSelected()) {
            v.getJcxNoAborto().setEnabled(false);
        } else {
            v.getJcxNoAborto().setEnabled(true);
        }
        if (v.getJcxNoAborto().isSelected()) {
            v.getJcxSiAborto().setEnabled(false);
            v.getTxtCausasAborto().setEnabled(false);
        } else {
            v.getJcxSiAborto().setEnabled(true);
            v.getTxtCausasAborto().setEnabled(true);
        }
        //---------------------------------------------juego motor grueso
        if (v.getJcxNormalMotorGrueso().isSelected()) {
            v.getJcxIrregularMotorGrueso().setEnabled(false);
        } else {
            v.getJcxIrregularMotorGrueso().setEnabled(true);
        }
        if (v.getJcxIrregularMotorGrueso().isSelected()) {
            v.getJcxNormalMotorGrueso().setEnabled(false);
        } else {
            v.getJcxNormalMotorGrueso().setEnabled(true);
        }
        //---------------------------------------------juego motor fino 
        if (v.getJcxNormalMotorFino().isSelected()) {
            v.getJcxIrregularMotorFino().setEnabled(false);
        } else {
            v.getJcxIrregularMotorFino().setEnabled(true);
        }
        if (v.getJcxIrregularMotorFino().isSelected()) {
            v.getJcxNormalMotorFino().setEnabled(false);
        } else {
            v.getJcxNormalMotorFino().setEnabled(true);
        }
        //----------------------------------------------juego claridad lenguajes
        if (v.getJcxClaro().isSelected()) {//claro
            v.getJcxNoMuyClaro().setEnabled(false);
            v.getJcxNoSeEntiende().setEnabled(false);
        } else {
            v.getJcxNoMuyClaro().setEnabled(true);
            v.getJcxNoSeEntiende().setEnabled(true);
        }
        if (v.getJcxNoMuyClaro().isSelected()) {//no muy claro
            v.getJcxClaro().setEnabled(false);
            v.getJcxNoSeEntiende().setEnabled(false);
        } else {
            v.getJcxClaro().setEnabled(true);
            v.getJcxNoSeEntiende().setEnabled(true);
        }
        if (v.getJcxNoSeEntiende().isSelected()) {//no se entiende
            v.getJcxNoMuyClaro().setEnabled(false);
            v.getJcxClaro().setEnabled(false);
        } else {
            v.getJcxNoMuyClaro().setEnabled(true);
            v.getJcxClaro().setEnabled(true);
        }
        //---------------------------------------------juego duerme toda la noche
        if (v.getJcxSiDuerme().isSelected()) {
            v.getJcxNoDuerme().setEnabled(false);
        } else {
            v.getJcxNoDuerme().setEnabled(true);
        }
        if (v.getJcxNoDuerme().isSelected()) {
            v.getJcxSiDuerme().setEnabled(false);
        } else {
            v.getJcxSiDuerme().setEnabled(true);
        }
        //---------------------------------------------juego miedo a dormir solo
        if (v.getJcxSiMiedoDormir().isSelected()) {
            v.getJcxNoMiedoDormir().setEnabled(false);
        } else {
            v.getJcxNoMiedoDormir().setEnabled(true);
        }
        if (v.getJcxNoMiedoDormir().isSelected()) {
            v.getJcxSiMiedoDormir().setEnabled(false);
        } else {
            v.getJcxSiMiedoDormir().setEnabled(true);
        }
        //---------------------------------------------juego pesadillas
        if (v.getJcxSiPesadillas().isSelected()) {
            v.getJcxNoPesadillas().setEnabled(false);
        } else {
            v.getJcxNoPesadillas().setEnabled(true);
        }
        if (v.getJcxNoPesadillas().isSelected()) {
            v.getJcxSiPesadillas().setEnabled(false);
        } else {
            v.getJcxSiPesadillas().setEnabled(true);
        }
        //---------------------------------------------juego ayuda para ir al banio
        if (v.getJcxSiAyudaBanho().isSelected()) {
            v.getJcxNoAyudaBanho().setEnabled(false);
        } else {
            v.getJcxNoAyudaBanho().setEnabled(true);
        }
        if (v.getJcxNoAyudaBanho().isSelected()) {
            v.getJcxSiAyudaBanho().setEnabled(false);
        } else {
            v.getJcxSiAyudaBanho().setEnabled(true);
        }
        //---------------------------------------------juego periodo ecopresis
        if (v.getJcxSiEcopresis().isSelected()) {
            v.getJcxNoEcopresis().setEnabled(false);
        } else {
            v.getJcxNoEcopresis().setEnabled(true);
        }
        if (v.getJcxNoEcopresis().isSelected()) {
            v.getJcxSiEcopresis().setEnabled(false);
        } else {
            v.getJcxSiEcopresis().setEnabled(true);
        }
        //---------------------------------------------juego moja cama
        if (v.getJcxSiMojaCama().isSelected()) {
            v.getJcxNoMojaCama().setEnabled(false);
        } else {
            v.getJcxNoMojaCama().setEnabled(true);
        }
        if (v.getJcxNoMojaCama().isSelected()) {
            v.getJcxSiMojaCama().setEnabled(false);
        } else {
            v.getJcxSiMojaCama().setEnabled(true);
        }
        //----------------------------------------------juego estudia
        if (v.getJcxSiEstudia().isSelected()) {
            v.getJcxNoEstudia().setEnabled(false);
        } else {
            v.getJcxNoEstudia().setEnabled(true);
        }
        if (v.getJcxNoEstudia().isSelected()) {
            v.getJcxSiEstudia().setEnabled(false);
        } else {
            v.getJcxSiEstudia().setEnabled(true);
        }
        //----------------------------------------------juego problemas aprendizaje
        if (v.getJcxSiAprendizaje().isSelected()) {
            v.getJcxNoAprendizaje().setEnabled(false);
        } else {
            v.getJcxNoAprendizaje().setEnabled(true);
        }
        if (v.getJcxNoAprendizaje().isSelected()) {
            v.getJcxSiAprendizaje().setEnabled(false);
        } else {
            v.getJcxSiAprendizaje().setEnabled(true);
        }
        //----------------------------------------------juego apoyo o nivelacion
        if (v.getJcxSiNivelacion().isSelected()) {
            v.getJcxNoNivelacion().setEnabled(false);
        } else {
            v.getJcxNoNivelacion().setEnabled(true);
        }
        if (v.getJcxNoNivelacion().isSelected()) {
            v.getJcxSiNivelacion().setEnabled(false);
        } else {
            v.getJcxSiNivelacion().setEnabled(true);
        }
        //----------------------------------------------juego respiratorios
        if (v.getJcxSiProblemasRespiratorios().isSelected()) {
            v.getJcxNoProblemasRespiratorios().setEnabled(false);
        } else {
            v.getJcxNoProblemasRespiratorios().setEnabled(true);
        }
        if (v.getJcxNoProblemasRespiratorios().isSelected()) {
            v.getJcxSiProblemasRespiratorios().setEnabled(false);
        } else {
            v.getJcxSiProblemasRespiratorios().setEnabled(true);
        }
        //----------------------------------------------juego alergias
        if (v.getJcxSiAlergias().isSelected()) {
            v.getJcxNoAlergias().setEnabled(false);
        } else {
            v.getJcxNoAlergias().setEnabled(true);
        }
        if (v.getJcxNoAlergias().isSelected()) {
            v.getJcxSiAlergias().setEnabled(false);
        } else {
            v.getJcxSiAlergias().setEnabled(true);
        }
        //----------------------------------------------juego neurologicos
        if (v.getJcxSiNeurologicos().isSelected()) {
            v.getJcxNoNeurologicos().setEnabled(false);
        } else {
            v.getJcxNoNeurologicos().setEnabled(true);
        }
        if (v.getJcxNoNeurologicos().isSelected()) {
            v.getJcxSiNeurologicos().setEnabled(false);
        } else {
            v.getJcxSiNeurologicos().setEnabled(true);
        }
        //----------------------------------------------juego nerviosos
        if (v.getJcxSiNerviosos().isSelected()) {
            v.getJcxNoNerviosos().setEnabled(false);
        } else {
            v.getJcxNoNerviosos().setEnabled(true);
        }
        if (v.getJcxNoNerviosos().isSelected()) {
            v.getJcxSiNerviosos().setEnabled(false);
        } else {
            v.getJcxSiNerviosos().setEnabled(true);
        }
        //----------------------------------------------juego trabajo
        if (v.getJcxSiTrabajo().isSelected()) {
            v.getJcxNoTrabajo().setEnabled(false);
        } else {
            v.getJcxNoTrabajo().setEnabled(true);
        }
        if (v.getJcxNoTrabajo().isSelected()) {
            v.getJcxSiTrabajo().setEnabled(false);
        } else {
            v.getJcxSiTrabajo().setEnabled(true);
        }
        //----------------------------------------------juego agrede
        if (v.getJcxSiAgrede().isSelected()) {
            v.getJcxNoAgrede().setEnabled(false);
        } else {
            v.getJcxNoAgrede().setEnabled(true);
        }
        if (v.getJcxNoAgrede().isSelected()) {
            v.getJcxSiAgrede().setEnabled(false);
        } else {
            v.getJcxSiAgrede().setEnabled(true);
        }
    }

    public void iniciarControl() {

    }

    public boolean complicaciones_embarazo_primer_metodo() throws SQLException {
        fhv = new FiltroHijosVictima();
        int victima_codigo = fhv.getVictima_codigo_static();//1
        boolean embarazo_planificado = true;//2
        if (v.getCbxEmbarazoPlanificado().getSelectedItem().equals("Si")) {
            embarazo_planificado = true;
        }
        if (v.getCbxEmbarazoPlanificado().getSelectedItem().equals("No")) {
            embarazo_planificado = false;
        }
        String embarazo_reaccion_padre = v.getTxtReaccionPapa().getText();//3
        String embarazo_reaccion_madre = v.getTxtReaccionMama().getText();//4

        eedb = new Embarazo_estadoDB(victima_codigo, embarazo_planificado,
                embarazo_reaccion_padre, embarazo_reaccion_madre);
        //metodo llenarestadoembarazo
        if (eedb.llenarEmbarazoEstado()) {
            return true;
        } else {
            return false;
        }
    }
    
    public void complicaciones_embarazo_segundo_metodo() throws SQLException{
       ecdb = new Embarazo_complicacionesDB();
        eedb = new Embarazo_estadoDB();
        if (v.getJcxSiViolencia().isSelected() || !v.getJcxSiViolencia().isSelected()) {
            int emb_comp_id = ecdb.obtener_id("Si", 1);
            xedb = new x_embarazo_compDB(eedb.getEmbarazo_id_static(), emb_comp_id, false);
            xedb.primer_insert();
        }
        if (v.getJcxNoViolencia().isSelected() || !v.getJcxNoViolencia().isSelected()) {
            int emb_comp_id = ecdb.obtener_id("No", 1);
            xedb = new x_embarazo_compDB(eedb.getEmbarazo_id_static(), emb_comp_id, false);
            xedb.primer_insert();
        }
        if (v.getJcxGolpes().isSelected() || !v.getJcxGolpes().isSelected()) {
            int emb_comp_id = ecdb.obtener_id("Golpes", 1);
            xedb = new x_embarazo_compDB(eedb.getEmbarazo_id_static(), emb_comp_id, false);
            xedb.primer_insert();
        }
        if (v.getJcxInsultos().isSelected() || !v.getJcxInsultos().isSelected()) {
            int emb_comp_id = ecdb.obtener_id("Insultos", 1);
            xedb = new x_embarazo_compDB(eedb.getEmbarazo_id_static(), emb_comp_id, false);
            xedb.primer_insert();
        }
        if (v.getJcxNegligencia().isSelected() || !v.getJcxNegligencia().isSelected()) {
            int emb_comp_id = ecdb.obtener_id("Negligencia", 1);
            xedb = new x_embarazo_compDB(eedb.getEmbarazo_id_static(), emb_comp_id,  false);
            xedb.primer_insert();
        }
        if (v.getJcxAmbitoLaboral().isSelected() || !v.getJcxAmbitoLaboral().isSelected()) {
            int emb_comp_id = ecdb.obtener_id("En el ámbito laboral", 1);
            xedb = new x_embarazo_compDB(eedb.getEmbarazo_id_static(), emb_comp_id,  false);
            xedb.primer_insert();
        }
        if (v.getJcxAbusoSexual().isSelected() || !v.getJcxAbusoSexual().isSelected()) {
            int emb_comp_id = ecdb.obtener_id("Abuso sexual", 1);
            xedb = new x_embarazo_compDB(eedb.getEmbarazo_id_static(), emb_comp_id,  false);
            xedb.primer_insert();
        }
        if (v.getJcxSiControles().isSelected() || !v.getJcxSiControles().isSelected()) {
            int emb_comp_id = ecdb.obtener_id("Si", 2);
            xedb = new x_embarazo_compDB(eedb.getEmbarazo_id_static(), emb_comp_id,  false);
            xedb.primer_insert();
        }
        if (v.getJcxNoControles().isSelected() || !v.getJcxNoControles().isSelected()) {
            int emb_comp_id = ecdb.obtener_id("No", 2);
            xedb = new x_embarazo_compDB(eedb.getEmbarazo_id_static(), emb_comp_id,  false);
            xedb.primer_insert();
        }
        if (v.getJcxUnaVez().isSelected() || !v.getJcxUnaVez().isSelected()) {
            int emb_comp_id = ecdb.obtener_id("Una sola vez", 2);
            xedb = new x_embarazo_compDB(eedb.getEmbarazo_id_static(), emb_comp_id,  false);
            xedb.primer_insert();
        }
        if (v.getJcxMensual().isSelected() || !v.getJcxMensual().isSelected()) {
            int emb_comp_id = ecdb.obtener_id("Mensual", 2);
            xedb = new x_embarazo_compDB(eedb.getEmbarazo_id_static(), emb_comp_id, false);
            xedb.primer_insert();
        }
        if (v.getJcxTrimestral().isSelected() || !v.getJcxTrimestral().isSelected()) {
            int emb_comp_id = ecdb.obtener_id("Trimestral", 2);
            xedb = new x_embarazo_compDB(eedb.getEmbarazo_id_static(), emb_comp_id,  false);
            xedb.primer_insert();
        }
        if (v.getJcxNinguna().isSelected() || !v.getJcxNinguna().isSelected()) {
            int emb_comp_id = ecdb.obtener_id("Ninguna", 2);
            xedb = new x_embarazo_compDB(eedb.getEmbarazo_id_static(), emb_comp_id,  false);
            xedb.primer_insert();
        }
        if (v.getJcxSiComplicaciones().isSelected() || !v.getJcxSiComplicaciones().isSelected()) {
            int emb_comp_id = ecdb.obtener_id("Si", 3);
            xedb = new x_embarazo_compDB(eedb.getEmbarazo_id_static(), emb_comp_id,false);
            xedb.primer_insert();
        }
        if (v.getJcxNoComplicaciones().isSelected() || !v.getJcxNoComplicaciones().isSelected()) {
            int emb_comp_id = ecdb.obtener_id("No", 3);
            xedb = new x_embarazo_compDB(eedb.getEmbarazo_id_static(), emb_comp_id, false);
            xedb.primer_insert();
        }
        if (v.getJcxBajoPeso().isSelected() || !v.getJcxBajoPeso().isSelected()) {
            int emb_comp_id = ecdb.obtener_id("Bajo Peso", 3);
            xedb = new x_embarazo_compDB(eedb.getEmbarazo_id_static(), emb_comp_id, false);
            xedb.primer_insert();
        }
        if (v.getJcxHemorragias().isSelected() || !v.getJcxHemorragias().isSelected()) {
            int emb_comp_id = ecdb.obtener_id("Hemorragias", 3);
            xedb = new x_embarazo_compDB(eedb.getEmbarazo_id_static(), emb_comp_id,  false);
            xedb.primer_insert();
        }
        if (v.getJcxInfecciones().isSelected() || !v.getJcxInfecciones().isSelected()) {
            int emb_comp_id = ecdb.obtener_id("Infecciones", 3);
            xedb = new x_embarazo_compDB(eedb.getEmbarazo_id_static(), emb_comp_id, false);
            xedb.primer_insert();
        }
        if (v.getJcxPreclansia().isSelected() || !v.getJcxPreclansia().isSelected()) {
            int emb_comp_id = ecdb.obtener_id("Preeclampsia", 3);
            xedb = new x_embarazo_compDB(eedb.getEmbarazo_id_static(), emb_comp_id, false);
            xedb.primer_insert();
        }
        if (v.getJcxPreclansia().isSelected() || !v.getJcxPreclansia().isSelected()) {
            int emb_comp_id = ecdb.obtener_id("Otros", 3);
            String mater_otro_descrip = v.getTxtOtraComplicacionEmbarazo().getText();
            xedb = new x_embarazo_compDB(eedb.getEmbarazo_id_static(), emb_comp_id, false);
            xedb.primer_insert();
        }
        if (v.getJcxSiConsume().isSelected() || !v.getJcxSiConsume().isSelected()) {
            int emb_comp_id = ecdb.obtener_id("Si", 4);
            xedb = new x_embarazo_compDB(eedb.getEmbarazo_id_static(), emb_comp_id, false);
            xedb.primer_insert();
        }
        if (v.getJcxNoConsume().isSelected() || !v.getJcxNoConsume().isSelected()) {
            int emb_comp_id = ecdb.obtener_id("No", 4);
            xedb = new x_embarazo_compDB(eedb.getEmbarazo_id_static(), emb_comp_id, false);
            xedb.primer_insert();
        }
        if (v.getJcxTabaco().isSelected() || !v.getJcxTabaco().isSelected()) {
            int emb_comp_id = ecdb.obtener_id("Tabaco", 4);
            xedb = new x_embarazo_compDB(eedb.getEmbarazo_id_static(), emb_comp_id, false);
            xedb.primer_insert();
        }
        if (v.getJcxAlcohol().isSelected() || !v.getJcxAlcohol().isSelected()) {
            int emb_comp_id = ecdb.obtener_id("Alcohol", 4);
            xedb = new x_embarazo_compDB(eedb.getEmbarazo_id_static(), emb_comp_id, false);
            xedb.primer_insert();
        }
        if (v.getJcxDroga().isSelected() || !v.getJcxDroga().isSelected()) {
            int emb_comp_id = ecdb.obtener_id("Droga", 4);
            xedb = new x_embarazo_compDB(eedb.getEmbarazo_id_static(), emb_comp_id, false);
            xedb.primer_insert();
        }
        if (v.getJcxSiAborto().isSelected() || !v.getJcxSiAborto().isSelected()) {
            int emb_comp_id = ecdb.obtener_id("Si", 5);
            xedb = new x_embarazo_compDB(eedb.getEmbarazo_id_static(), emb_comp_id, false);
            xedb.primer_insert();
        }
        if (v.getJcxNoAborto().isSelected() || !v.getJcxNoAborto().isSelected()) {
            int emb_comp_id = ecdb.obtener_id("No", 5);
            xedb = new x_embarazo_compDB(eedb.getEmbarazo_id_static(), emb_comp_id, false);
            xedb.primer_insert();
        }
        
    }

    public void complecaciones_embarazo_tercer_metodo() throws SQLException {
        ecdb = new Embarazo_complicacionesDB();
        eedb = new Embarazo_estadoDB();
        if (v.getJcxSiViolencia().isSelected()) {
            int emb_comp_id = ecdb.obtener_id("Si", 1);
            xedb = new x_embarazo_compDB(eedb.getEmbarazo_id_static(), emb_comp_id, "", true);
            xedb.update_x_embarazo_comp(eedb.getEmbarazo_id_static(), emb_comp_id);
        }
        if (v.getJcxNoViolencia().isSelected()) {
            int emb_comp_id = ecdb.obtener_id("No", 1);
            xedb = new x_embarazo_compDB(eedb.getEmbarazo_id_static(), emb_comp_id, "", true);
            xedb.update_x_embarazo_comp(eedb.getEmbarazo_id_static(), emb_comp_id);
        }
        if (v.getJcxGolpes().isSelected()) {
            int emb_comp_id = ecdb.obtener_id("Golpes", 1);
            xedb = new x_embarazo_compDB(eedb.getEmbarazo_id_static(), emb_comp_id, "", true);
            xedb.update_x_embarazo_comp(eedb.getEmbarazo_id_static(), emb_comp_id);
        }
        if (v.getJcxInsultos().isSelected()) {
            int emb_comp_id = ecdb.obtener_id("Insultos", 1);
            xedb = new x_embarazo_compDB(eedb.getEmbarazo_id_static(), emb_comp_id, "", true);
            xedb.update_x_embarazo_comp(eedb.getEmbarazo_id_static(), emb_comp_id);
        }
        if (v.getJcxNegligencia().isSelected()) {
            int emb_comp_id = ecdb.obtener_id("Negligencia", 1);
            xedb = new x_embarazo_compDB(eedb.getEmbarazo_id_static(), emb_comp_id, "", true);
            xedb.update_x_embarazo_comp(eedb.getEmbarazo_id_static(), emb_comp_id);
        }
        if (v.getJcxAmbitoLaboral().isSelected()) {
            int emb_comp_id = ecdb.obtener_id("En el ámbito laboral", 1);
            xedb = new x_embarazo_compDB(eedb.getEmbarazo_id_static(), emb_comp_id, "", true);
            xedb.update_x_embarazo_comp(eedb.getEmbarazo_id_static(), emb_comp_id);
        }
        if (v.getJcxAbusoSexual().isSelected()) {
            int emb_comp_id = ecdb.obtener_id("Abuso sexual", 1);
            xedb = new x_embarazo_compDB(eedb.getEmbarazo_id_static(), emb_comp_id, "", true);
            xedb.update_x_embarazo_comp(eedb.getEmbarazo_id_static(), emb_comp_id);
        }
        if (v.getJcxSiControles().isSelected()) {
            int emb_comp_id = ecdb.obtener_id("Si", 2);
            xedb = new x_embarazo_compDB(eedb.getEmbarazo_id_static(), emb_comp_id, "", true);
            xedb.update_x_embarazo_comp(eedb.getEmbarazo_id_static(), emb_comp_id);
        }
        if (v.getJcxNoControles().isSelected()) {
            int emb_comp_id = ecdb.obtener_id("No", 2);
            xedb = new x_embarazo_compDB(eedb.getEmbarazo_id_static(), emb_comp_id, "", true);
            xedb.update_x_embarazo_comp(eedb.getEmbarazo_id_static(), emb_comp_id);
        } 
        if (v.getJcxUnaVez().isSelected()) {
            int emb_comp_id = ecdb.obtener_id("Una sola vez", 2);
            xedb = new x_embarazo_compDB(eedb.getEmbarazo_id_static(), emb_comp_id, "", true);
            xedb.update_x_embarazo_comp(eedb.getEmbarazo_id_static(), emb_comp_id); 
        }
        if (v.getJcxMensual().isSelected()) {
            int emb_comp_id = ecdb.obtener_id("Mensual", 2);
            xedb = new x_embarazo_compDB(eedb.getEmbarazo_id_static(), emb_comp_id, "", true);
            xedb.update_x_embarazo_comp(eedb.getEmbarazo_id_static(), emb_comp_id); 
        }
        if (v.getJcxTrimestral().isSelected()) {
            int emb_comp_id = ecdb.obtener_id("Trimestral", 2);
            xedb = new x_embarazo_compDB(eedb.getEmbarazo_id_static(), emb_comp_id, "", true);
            xedb.update_x_embarazo_comp(eedb.getEmbarazo_id_static(), emb_comp_id); 
        }
        if (v.getJcxNinguna().isSelected()) {
            int emb_comp_id = ecdb.obtener_id("Ninguna", 2);
            xedb = new x_embarazo_compDB(eedb.getEmbarazo_id_static(), emb_comp_id, "", true);
            xedb.update_x_embarazo_comp(eedb.getEmbarazo_id_static(), emb_comp_id); 
        }
        String donde_realizo_controles = v.getTxtDondeRealizoControles().getText();//1
        if (v.getJcxSiComplicaciones().isSelected()) {
            int emb_comp_id = ecdb.obtener_id("Si", 3);
            xedb = new x_embarazo_compDB(eedb.getEmbarazo_id_static(), emb_comp_id, "", true);
            xedb.update_x_embarazo_comp(eedb.getEmbarazo_id_static(), emb_comp_id); 
        }
        if (v.getJcxNoComplicaciones().isSelected()) {
            int emb_comp_id = ecdb.obtener_id("No", 3);
            xedb = new x_embarazo_compDB(eedb.getEmbarazo_id_static(), emb_comp_id, "", true);
            xedb.update_x_embarazo_comp(eedb.getEmbarazo_id_static(), emb_comp_id); 
        }
        if (v.getJcxBajoPeso().isSelected()) {
            int emb_comp_id = ecdb.obtener_id("Bajo Peso", 3);
            xedb = new x_embarazo_compDB(eedb.getEmbarazo_id_static(), emb_comp_id, "", true);
            xedb.update_x_embarazo_comp(eedb.getEmbarazo_id_static(), emb_comp_id); 
        }
        if (v.getJcxHemorragias().isSelected()) {
            int emb_comp_id = ecdb.obtener_id("Hemorragias", 3);
            xedb = new x_embarazo_compDB(eedb.getEmbarazo_id_static(), emb_comp_id, "", true);
            xedb.update_x_embarazo_comp(eedb.getEmbarazo_id_static(), emb_comp_id); 
        }
        if (v.getJcxInfecciones().isSelected()) {
            int emb_comp_id = ecdb.obtener_id("Infecciones", 3);
            xedb = new x_embarazo_compDB(eedb.getEmbarazo_id_static(), emb_comp_id, "", true);
            xedb.update_x_embarazo_comp(eedb.getEmbarazo_id_static(), emb_comp_id); 
        }
        if (v.getJcxPreclansia().isSelected()) {
            int emb_comp_id = ecdb.obtener_id("Preeclampsia", 3);
            xedb = new x_embarazo_compDB(eedb.getEmbarazo_id_static(), emb_comp_id, "", true);
            xedb.update_x_embarazo_comp(eedb.getEmbarazo_id_static(), emb_comp_id);
        }
        if (v.getJcxPreclansia().isSelected()) {
            int emb_comp_id = ecdb.obtener_id("Otros", 3);
            String mater_otro_descrip = v.getTxtOtraComplicacionEmbarazo().getText();
            xedb = new x_embarazo_compDB(eedb.getEmbarazo_id_static(), emb_comp_id, mater_otro_descrip, true);
            xedb.update_x_embarazo_comp(eedb.getEmbarazo_id_static(), emb_comp_id);
        }
        if (v.getJcxSiConsume().isSelected()) {
            int emb_comp_id = ecdb.obtener_id("Si", 4);
            xedb = new x_embarazo_compDB(eedb.getEmbarazo_id_static(), emb_comp_id, "", true);
            xedb.update_x_embarazo_comp(eedb.getEmbarazo_id_static(), emb_comp_id);
        }
        if (v.getJcxNoConsume().isSelected()) {
            int emb_comp_id = ecdb.obtener_id("No", 4);
            xedb = new x_embarazo_compDB(eedb.getEmbarazo_id_static(), emb_comp_id, "", true);
            xedb.update_x_embarazo_comp(eedb.getEmbarazo_id_static(), emb_comp_id);
        }
        if (v.getJcxTabaco().isSelected()) {
            int emb_comp_id = ecdb.obtener_id("Tabaco", 4);
            xedb = new x_embarazo_compDB(eedb.getEmbarazo_id_static(), emb_comp_id, "", true);
            xedb.update_x_embarazo_comp(eedb.getEmbarazo_id_static(), emb_comp_id);
        }
        if (v.getJcxAlcohol().isSelected()) {
            int emb_comp_id = ecdb.obtener_id("Alcohol", 4);
            xedb = new x_embarazo_compDB(eedb.getEmbarazo_id_static(), emb_comp_id, "", true);
            xedb.update_x_embarazo_comp(eedb.getEmbarazo_id_static(), emb_comp_id);
        }
        if (v.getJcxDroga().isSelected()) {
            int emb_comp_id = ecdb.obtener_id("Droga", 4);
            xedb = new x_embarazo_compDB(eedb.getEmbarazo_id_static(), emb_comp_id, "", true);
            xedb.update_x_embarazo_comp(eedb.getEmbarazo_id_static(), emb_comp_id);
        }
        String consumo_causas = v.getTxtCausasConsumo().getText();//2
        if (v.getJcxSiAborto().isSelected()) {
            int emb_comp_id = ecdb.obtener_id("Si", 5);
            xedb = new x_embarazo_compDB(eedb.getEmbarazo_id_static(), emb_comp_id, "", true);
            xedb.update_x_embarazo_comp(eedb.getEmbarazo_id_static(), emb_comp_id);
        }
        if (v.getJcxNoAborto().isSelected()) {
            int emb_comp_id = ecdb.obtener_id("No", 5);
            xedb = new x_embarazo_compDB(eedb.getEmbarazo_id_static(), emb_comp_id, "", true);
            xedb.update_x_embarazo_comp(eedb.getEmbarazo_id_static(), emb_comp_id);
        }
        String aborto_causas = v.getTxtCausasAborto().getText();

        Embarazo_estadoDB eedb2 = new Embarazo_estadoDB(donde_realizo_controles, consumo_causas, aborto_causas);
        eedb2.update_campos(eedb.getEmbarazo_id_static());

    }

    public boolean insertar_desarrolo() throws SQLException {
        String des_motor_grueso = "";//1
        if (v.getJcxNormalMotorGrueso().isSelected()) {
            des_motor_grueso = "Normal";
        }
        if (v.getJcxIrregularMotorGrueso().isSelected()) {
            des_motor_grueso = "Irregular";
        }
        String des_motor_fino = "";//2
        if (v.getJcxNormalMotorFino().isSelected()) {
            des_motor_fino = "Normal";
        }
        if (v.getJcxIrregularMotorFino().isSelected()) {
            des_motor_fino = "Irregular";
        }
        String movimientos = v.getTxtComoSonMovimientos().getText();//3
        String des_psico_social = v.getTxtPsicoSocial().getText();//4
        String des_cognitivo = v.getTxtCognitivo().getText();//5
        String des_fisico = v.getTxtfisico().getText();//6
        String caridad_lenguajes = "";//7
        if (v.getJcxClaro().isSelected()) {
            caridad_lenguajes = "Claro";
        }
        if (v.getJcxNoMuyClaro().isSelected()) {
            caridad_lenguajes = "Na muy claro";
        }
        if (v.getJcxNoSeEntiende().isSelected()) {
            caridad_lenguajes = "No se entiende";
        }
        String claridad_lenguajes_descrip = v.getTxtDificultadEspecifique().getText();//8

        ddb = new DesarrolloDB(des_motor_grueso, des_motor_fino, movimientos,
                des_psico_social, des_cognitivo, des_fisico, caridad_lenguajes,
                claridad_lenguajes_descrip);
        //metodo llenar
        if (ddb.llenarDesarrollo()) {
            return true;
        } else {
            return false;
        }

    }

    public boolean insertar_suenio_control_esfin() throws SQLException {
        boolean duerme_toda_noche = true;//1
        if (v.getJcxSiDuerme().isSelected()) {
            duerme_toda_noche = true;
        }
        if (v.getJcxNoDuerme().isSelected()) {
            duerme_toda_noche = false;
        }
        boolean miedo_dormir_solo = true;//2
        if (v.getJcxSiMiedoDormir().isSelected()) {
            miedo_dormir_solo = true;
        }
        if (v.getJcxNoMiedoDormir().isSelected()) {
            miedo_dormir_solo = false;
        }
        String despertar_descripcion = v.getTxtComoDespierta().getText();//3
        boolean pesadillas = true;//4
        if (v.getJcxSiPesadillas().isSelected()) {
            pesadillas = true;
        }
        if (v.getJcxNoPesadillas().isSelected()) {
            pesadillas = false;
        }
        String edadcontrolesfinter = v.getTxtEdadEsfinteres().getText();
        int edad_control_esfinter = Integer.parseInt(edadcontrolesfinter);//5
        boolean ayuda_bano = true;//6
        if (v.getJcxSiAyudaBanho().isSelected()) {
            ayuda_bano = true;
        }
        if (v.getJcxNoAyudaBanho().isSelected()) {
            ayuda_bano = false;
        }
        boolean moja_cama = true;//7
        if (v.getJcxSiMojaCama().isSelected()) {
            moja_cama = true;
        }
        if (v.getJcxNoMojaCama().isSelected()) {
            moja_cama = false;
        }
        String periodo_ecopresis_descrip = v.getTxtCausaEcopresis().getText();//8
        boolean periodo_ecopresis = true;//9
        if (v.getJcxSiEcopresis().isSelected()) {
            periodo_ecopresis = true;
        }
        if (v.getJcxNoEcopresis().isSelected()) {
            periodo_ecopresis = false;
        }
        String como_es_sueno = v.getTxtComoDuerme().getText();//10
        String acompanamiento_dormir = v.getTxtConQuienDuerme().getText();//11
        scedb = new Sueno_control_esfinDB(duerme_toda_noche, miedo_dormir_solo,
                despertar_descripcion, pesadillas, edad_control_esfinter, ayuda_bano,
                moja_cama, periodo_ecopresis_descrip, periodo_ecopresis, como_es_sueno,
                acompanamiento_dormir);
        //metodo llenarsueno_control_esfin
        if (scedb.llenarSuenoControlEsfinter()) {
            return true;
        } else {
            return false;
        }

    }

    public boolean insertar_escolaridad() throws SQLException {
        boolean esc_estudia = true;//1
        if (v.getJcxSiEstudia().isSelected()) {
            esc_estudia = true;
        }
        if (v.getJcxNoEstudia().isSelected()) {
            esc_estudia = false;
        }
        String esc_explicacion = v.getTxtExpliqueEstudia().getText();//2
        String esc_repeticion_anio_causas = v.getTxtAnhoCursa().getText();//3
        boolean esc_nna_problem_aprend = true;//4
        if (v.getJcxSiAprendizaje().isSelected()) {
            esc_nna_problem_aprend = true;
        }
        if (v.getJcxNoAprendizaje().isSelected()) {
            esc_nna_problem_aprend = false;
        }
        String esc_nna_observaciones = v.getTxtEspecifiqueAprendizaje().getText();//5
        boolean esc_asis_prog_apoyo = true;//6
        if (v.getJcxSiNivelacion().isSelected()) {
            esc_asis_prog_apoyo = true;
        }
        if (v.getJcxNoNivelacion().isSelected()) {
            esc_asis_prog_apoyo = false;
        }
        String esc_asis_prog_apoyo_obser = v.getTxtEspecifiqueNivelacion().getText();//7
        edb = new EscolaridadDB(esc_estudia, esc_explicacion, esc_repeticion_anio_causas,
                esc_nna_problem_aprend, esc_nna_observaciones, esc_asis_prog_apoyo, esc_asis_prog_apoyo_obser);
        //metodo llenar_escolaridad
        if (edb.llenarEscolaridad()) {
            return true;
        } else {
            return false;
        }
    }

    public boolean insertar_salud_nna() throws SQLException {

        String problem_familiare = "";//1
        if (v.getJcxSindromeDown().isSelected()) {
            problem_familiare = problem_familiare + "Díndrome de Down ";
        }
        if (v.getJcxEpilepsia().isSelected()) {
            problem_familiare = problem_familiare + "Epilepsia ";
        }
        if (v.getJcxAlcoholismo().isSelected()) {
            problem_familiare = problem_familiare + "Alcoholismo ";
        }
        if (v.getJcxDiscapacidadIntelectual().isSelected()) {
            problem_familiare = problem_familiare + "Discapacidad Intelectual ";
        }
        String problem_familiar_descrip = v.getTxtOtroEspecifique().getText();//2
        boolean problem_respiratorio = true;//3
        if (v.getJcxSiProblemasRespiratorios().isSelected()) {
            problem_respiratorio = true;
        }
        if (v.getJcxNoProblemasRespiratorios().isSelected()) {
            problem_respiratorio = false;
        }
        String problem_resp_descrip = v.getTxtEspecifiqueProblemasRespiratorios().getText();//4
        boolean problem_alergias = true;//5
        if (v.getJcxSiAlergias().isSelected()) {
            problem_alergias = true;
        }
        if (v.getJcxNoAlergias().isSelected()) {
            problem_alergias = false;
        }
        String problem_aler_descrip = v.getTxtEspecifiqueAlergias().getText();//6
        boolean problem_neurologico = true;//7
        if (v.getJcxSiNeurologicos().isSelected()) {
            problem_neurologico = true;
        }
        if (v.getJcxNoNeurologicos().isSelected()) {
            problem_neurologico = false;
        }
        String problem_neuro_descrip = v.getTxtEspecifiqueNeurologicos().getText();//8
        boolean problem_nerviosos = true;//9
        if (v.getJcxSiNerviosos().isSelected()) {
            problem_nerviosos = true;
        }
        if (v.getJcxNoNerviosos().isSelected()) {
            problem_nerviosos = true;
        }
        String problem_nervi_descrip = v.getTxtEspecifiqueNerviosos().getText();//10
        snnadb = new Salud_nnaDB(problem_familiare, problem_familiar_descrip,
                problem_respiratorio, problem_resp_descrip, problem_alergias,
                problem_aler_descrip, problem_neurologico, problem_neuro_descrip,
                problem_nerviosos, problem_nervi_descrip);
        //metodo llenar salud nna
        if (snnadb.llenarSaludNNA()) {
            return true;
        } else {
            return false;
        }

    }

    public boolean insertar_relacion_familiar_nna() throws SQLException {
        String clima_familiar = v.getTxtClimaFamiliar().getText();//1
        String relacion_padre = v.getTxtRelacionPadre().getText();//2
        String relacion_madre = v.getTxtRelacionMadre().getText();//3
        String relacion_hermanos = v.getTxtRelacionHermanos().getText();//4
        boolean trabajo = true;//5
        if (v.getJcxSiTrabajo().isSelected()) {
            trabajo = true;
        }
        if (v.getJcxNoTrabajo().isSelected()) {
            trabajo = false;
        }
        String trabajo_decrip = v.getTxtEnqueaTrabajo().getText();//6
        boolean agresion_agresor = true;//7
        if (v.getJcxSiAgrede().isSelected()) {
            agresion_agresor = true;
        }
        if (v.getJcxNoAgrede().isSelected()) {
            agresion_agresor = false;
        }
        String agresion_frecuencia = v.getTxtFrecuenciaAgresorAgrede().getText();//8
        String objeto_utilizado = v.getTxtQueUtiliza().getText();//9
        String obligacion_familiar = v.getTxtObligacionesenlaFamilia().getText();//10
        String proyeccion_madre = v.getTxtProyeciondelaMadre().getText();//11
        String necesidad_inmediata = v.getTxtNecesidadGrupoFamiliar().getText();//12

        rfnnadb = new Relacion_familiar_nnaDB(clima_familiar, relacion_padre,
                relacion_madre, relacion_hermanos, trabajo, trabajo_decrip, agresion_agresor,
                agresion_frecuencia, objeto_utilizado, obligacion_familiar, proyeccion_madre,
                necesidad_inmediata);

        //metodo llenar relacion_famniliar_nna
        if (rfnnadb.llenarRelacionFamiliarNNA()) {
            return true;
        } else {
            return false;
        }

    }

}
