/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ud2.tarefa22;

import java.sql.SQLException;

/**
 *
 * @author node
 */
public class Parte2 {
    public static void main(String[] args) throws SQLException {
        OperacionesBasicasGranja bd = new OperacionesBasicasGranja();
        
        bd.abrirConexion();
        bd.listarConstruccionesPorG(1);
        bd.aumentoPrecioRural();
        bd.listarPlantacionesPorGranjero(1);
        bd.cerrarConexion();
    }
}
