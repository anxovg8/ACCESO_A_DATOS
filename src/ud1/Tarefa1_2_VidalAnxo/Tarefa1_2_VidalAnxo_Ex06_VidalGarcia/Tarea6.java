/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ud1.Tarefa1_2_VidalAnxo.Tarefa1_2_VidalAnxo_Ex06_VidalGarcia;

import java.io.File;
import java.io.IOException;
import java.nio.file.DirectoryIteratorException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author node
 */
public class Tarea6 {

    /*
    directorio manipulado
    C:\DP
     */
    public static String nombre = "";
    public static String permisos = "";
    public static Path fichero = null;

    public static void main(String[] args) throws NullPointerException, IOException {
        ArrayList<Path> stack = new ArrayList();
        permisos = "";
        Scanner sc = new Scanner(System.in);
        System.out.println("Introduzca el nombre de su directorio");
        nombre = sc.nextLine();
        Path dir = Paths.get(nombre);
        System.out.println("Ficheros del directorio " + dir);
        if (Files.isDirectory(dir)) {
            try (DirectoryStream<Path> stream = Files.newDirectoryStream(dir);) {
                for (Path fichero : stream) {
                    if (fichero.toFile().isDirectory()) {
                        recursividad(fichero);
                        stack.add(fichero);
                        permisos = "";
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
                            permisos = "";
                        }
                        System.out.println(fichero.getFileName() + permisos);
                        
                    } else {
                        permisos = "";
                        if (fichero.toFile().canRead()) {
                            permisos += " r";
                        }
                        if (fichero.toFile().canWrite()) {
                            permisos += "w";
                        }
                        if (fichero.toFile().canExecute()) {
                            permisos += "x";
                        } else {
                            permisos = "";
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

    public static void recursividad(Path f) throws IOException {
        if (Files.isDirectory(f)) {
            try (DirectoryStream<Path> stream = Files.newDirectoryStream(f);) {
                for (Path fichero : stream) {
                    if (fichero.toFile().isDirectory()) {
                        
                        permisos = "";
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
                            permisos = "";
                        }
                        System.out.println("    "+fichero.getFileName() + permisos);
                    } else {
                        permisos = "";
                        if (fichero.toFile().canRead()) {
                            permisos += " r";
                        }
                        if (fichero.toFile().canWrite()) {
                            permisos += "w";
                        }
                        if (fichero.toFile().canExecute()) {
                            permisos += "x";
                        } else {
                            permisos = "";
                        }
                        System.out.println("    "+fichero.getFileName() + permisos);
                    }

                }
            } catch (IOException | DirectoryIteratorException ex) {
                System.err.println(ex);
            }
        } else {
            System.err.println(f.toString() + " no es un directorio");
        }

    }
}

    

