/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ud2.tarefa25;

import java.sql.SQLException;

/**
 *
 * @author node
 */
public class Main {
    public static void main(String[] args) throws SQLException {
        BDManager bd = new BDManager();
        bd.abrirConexion();
//        bd.mostrarInformacion();
       // bd.mostrarInfoTablas();
        //bd.datosTabla(null, "departamento");
        //bd.infoProcedures();
        //bd.clavesPrimarias(null, "departamento");
//        bd.clavesForaneas(null, "departamento");
       //bd.infoFunciones();
       //bd.limitesConectores();
       //bd.infoTranssacciones();
       //bd.infoConsulta("select * from empregado");
        bd.cerrarConexion();
    }
    
}
