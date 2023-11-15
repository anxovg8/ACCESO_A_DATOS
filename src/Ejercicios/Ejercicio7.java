/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ejercicios;

import java.io.FileWriter;
import java.io.IOException;

/**
 *
 * @author node
 */
public class Ejercicio7 {
//    Ejercicio 7: Agregar al fichero “Hello.txt” las líneas “Texto formateado 1” y “Texto formateado 2”.

    public static void main(String[] args) throws IOException {
        FileWriter fw = new FileWriter("Hello.txt", true);

        fw.write("Texto formateado 1\n");
        fw.write("Texto formateado 2\n");

        fw.close();
    }
}
