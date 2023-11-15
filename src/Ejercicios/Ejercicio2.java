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
public class Ejercicio2 {

//    Ejercicio 2. Crear tres directorios “Data”, “Data\img” y “Data\\users” en el mismo directorio donde se
//    esté ejecutando el programa empleando rutas relativas.
    public static void main(String[] args) {
        Path userDir = Paths.get(System.getProperty("user.dir"));
//        System.out.println(userDir);

        String dirData = userDir + "/Data";
        String dirImg = dirData + "/img";
        String dirUsers = dirData + "/users";

        File dataDir = new File(dirData);
        File ImgDir = new File(dirImg);
        File UsersDir = new File(dirUsers);

        if (!dataDir.exists()) {
            dataDir.mkdir();
            System.out.println("El directorio " + dataDir + " se ha creado");
            if (!ImgDir.exists()) {
                ImgDir.mkdir();
                System.out.println("El directorio " + ImgDir + " se ha creado");
            }
            if (!UsersDir.exists()) {
                UsersDir.mkdir();
                System.out.println("El directorio " + UsersDir + " se ha creado");
            }
        } else {
            System.out.println("Error al crear los directorio");
        }

    }

}
