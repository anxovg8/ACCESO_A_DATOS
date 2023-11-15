/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ud2.tarefa24;

import java.sql.SQLException;


/**
 *
 * @author node
 */
public class Main {

    public static void main(String[] args) throws SQLException {
        BDManager bd = new BDManager();
        bd.abrirConexion();
        //bd.mostrarEmpregadosPorLocalidade("Vigo");
        //System.out.println(bd.listaProxectos("TÉCNICO"));
        //System.out.println(bd.datosProxecto(2));
        bd.funcionCont("TÉCNICO");
        Proxecto p = new Proxecto(1, "XESTION DE PERSOAL", "VIGO", 4);
        bd.insertarProyecto(p);
        bd.cerrarConexion();

        
    }
}
