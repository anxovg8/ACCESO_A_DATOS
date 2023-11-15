/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ud1.Tarefa1_2_VidalAnxo.Tarefa1_2_VidalAnxo_Ex01_VidalGarcia;

import java.io.IOException;
import java.nio.file.DirectoryIteratorException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

/**
 *
 * @author node
 */
public class Tarea1 {

    public static void main(String[] args) {
        String permisos = "";
        Scanner sc = new Scanner(System.in);
        String nombre = sc.nextLine();
        Path dir = Paths.get(nombre);
        System.out.println("Ficheros del directorio " + dir);
        if (Files.isDirectory(dir)) {
            try (DirectoryStream<Path> stream = Files.newDirectoryStream(dir);) {
                for (Path fichero : stream) {
                    if (fichero.toFile().isDirectory()) {
                        permisos="";
                        permisos += " d";
                        if (fichero.toFile().canRead()) {
                            permisos += "r";
                        }
                        if (fichero.toFile().canWrite()) {
                            permisos += "w";
                        }
                        if (fichero.toFile().canExecute()) {
                            permisos += "x";
                        } else {
                            permisos="";
                        }
                        System.out.println(fichero.getFileName() + permisos);
                       
                    }else{
                        permisos="";
                        if (fichero.toFile().canRead()) {
                            permisos += " r";
                        }
                        if (fichero.toFile().canWrite()) {
                            permisos += "w";
                        }
                        if (fichero.toFile().canExecute()) {
                            permisos += "x";
                        } else {
                            permisos="";
                        }
                        System.out.println(fichero.getFileName() + permisos);
                    }
                    

                }
            } catch (IOException | DirectoryIteratorException ex) {
                System.err.println(ex);
            }
        } else {
            System.err.println(dir.toString() + " no es un directorio");
        }
    }
}
