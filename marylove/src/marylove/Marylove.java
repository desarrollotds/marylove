/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package marylove;

import java.sql.SQLException;
import marylove.controlador.ControladorAgendamientoCitas;
import marylove.vista.FichaAgendamientoCitas;

/**
 *
 * @author Patricio, modificaciónasdasd 12:09
 */
public class Marylove {

    public static void main(String[] args) throws SQLException, Exception {
//         Caracteristicas_violenciaDB c= new Caracteristicas_violenciaDB();
////         ArrayList<Json_object_consulta> jocarray=c.obtenerTitulos();
////         for (Json_object_consulta o: jocarray) {
////             System.out.println(o.getId()+" "+o.getValor());
////
////        }
//         int caractitulo=c.obtenerCaracteristicaIdOtros("¿Quién es el agresor?");
//         System.out.println(caractitulo);

//        Caracteristicas_violenciaDB cvdb = new Caracteristicas_violenciaDB();
//        int o=cvdb.obtenerCaracteristicaId("Física");
//        System.out.println(o);
//        VistaRegistroLlamada v = new VistaRegistroLlamada();
//        Controlador_registro_llamadas ce = new Controlador_registro_llamadas(v);
//        Conexion conectar = new Conexion();
//        FichaPrimerEncuentro Vista_1_Encuentro = new FichaPrimerEncuentro();
//        Primer_encuentro Modelo_1_Encuentro = new Primer_encuentro();
//        ControladorPrimerEncuentro Primere = new ControladorPrimerEncuentro(Vista_1_Encuentro, Modelo_1_Encuentro, conectar);
//        Primere.iniciarControl();
//        FichaLegal fl = new FichaLegal();
//        Ficha_Legal f_l = new Ficha_Legal();
//        V_Login lg = new V_Login();
//        V_Menu vP = new V_Menu();
//        Personal pl = new Personal();
//        Persona pr = new Persona();
//        personaDB pDB = new personaDB();
//        personalDB plDB = new personalDB();
//        Conexion cx = new Conexion();
//        C_Login cl = new C_Login(lg, vP, pl, pr, pDB, plDB, cx);
//        cl.iniciaControl();
          FichaAgendamientoCitas i= new FichaAgendamientoCitas();
          ControladorAgendamientoCitas io= new ControladorAgendamientoCitas(i);
//        Ficharegistroyreferencia vistaRegisRef = new Ficharegistroyreferencia();
//        VistaCita vistCit = new VistaCita();
//        formularioR1 Vfr1 = new formularioR1();
//        VistaRegistroLlamada v1 = new VistaRegistroLlamada();
//        FichaPrimerEncuentro Vista_1_Encuentro = new FichaPrimerEncuentro();
//        FormaAgregarArticulosVictima vistaAgreArt = new FormaAgregarArticulosVictima();
//        ArticulosEntregados artiEntModel = new ArticulosEntregados();
//        ArticulosEntregadosDB artEntModelDB = new ArticulosEntregadosDB();
//        ArticulosEntregadosPersonal artEntPerModel = new ArticulosEntregadosPersonal();
//        ArticulosEntregadosPersonalDB artEntPerModelDB = new ArticulosEntregadosPersonalDB();
//        FichaIngreso vistaFichIngreso = new FichaIngreso();
//        Controlador_registro_llamadas cem = new Controlador_registro_llamadas(v1);
//        FormaAgregarArticulosPersonal fAgreArtPers = new FormaAgregarArticulosPersonal();
//        ControladorFichaIngreso ctrlFichIng = new ControladorFichaIngreso(vistaAgreArt, artiEntModel, artEntModelDB, artEntPerModel, artEntPerModelDB, vistaFichIngreso, fAgreArtPers);
//        ControladorMenu menu = new ControladorMenu(ctrlFichIng, vP, vistaRegisRef, v1, vistCit, Vfr1, Vista_1_Encuentro, cem);
//        menu.iniciarContrl();
//        
//        FichaPrimerEncuentro vt = new FichaPrimerEncuentro();
//        primer_EncuentroDB md = new primer_EncuentroDB();
//        ControladorPrimerEncuentro ctp= new ControladorPrimerEncuentro(vt, md);
//        ctp.iniciarControl();

//        Persona_llamadaDB plbd=new Persona_llamadaDB();
//        ArrayList<Resultado>r=plbd.listaResultados();
//        for (Resultado o: r) {
//            System.out.println(o.getResultado_id()+"-----"+o.getResultado_nombre());
//        }
//        Persona p = new Persona("0107314361", "mura",
//                "", "1993-02-14", 1, 1, 1, 1, 1, "092345678", "09234567", true,'F');
//        PersonaDB pdb=new PersonaDB();
    }

}
