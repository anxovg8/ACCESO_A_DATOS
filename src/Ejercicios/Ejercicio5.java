/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ejercicios;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 *
 * @author node
 */
public class Ejercicio5 {
//    Ejercicio 5. Crear un directorio “PruebaMultiPlataforma” en el directorio “home” del usuario activo del
//    SO. Esto ha de ser dinámico para cualquier SO que ejecute la aplicación.

    public static void main(String[] args) {
        Path home = Paths.get(System.getProperty("user.home"));
        String pruebaMultiPlataforma = home + "/PruebaMultiPlataforma";
        File pMP = new File(pruebaMultiPlataforma);
        String so = System.getProperty("os.name").toLowerCase();

        if (so.contains("win")) {
            System.out.println("Su sistema operativo es Windows");
            if (!pMP.exists()) {

                pMP.mkdir();
                System.out.println("El directorio " + pMP + " se ha creado");
            } else {
                System.out.println("El directorio " + pMP + " ya existe");
            }
        } else if (so.contains("nux")) {
            System.out.println("Su sistema operativo es Linux");
            if (!pMP.exists()) {

                pMP.mkdir();
                System.out.println("El directorio " + pMP + " se ha creado");
            } else {
                System.out.println("El directorio " + pMP + " ya existe");
            }
        }
    }
}
