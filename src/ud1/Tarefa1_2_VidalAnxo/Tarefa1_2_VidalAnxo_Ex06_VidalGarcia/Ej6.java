/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ud1.Tarefa1_2_VidalAnxo.Tarefa1_2_VidalAnxo_Ex06_VidalGarcia;

import java.io.IOException;
import java.nio.file.DirectoryIteratorException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

/**
 *
 * @author alumno
 */
public class Ej6 {

    public static void main(String[] args) throws IOException {
        ej6();
    }

    public static void ej6() throws IOException {
        Scanner sc = new Scanner(System.in);
        String nombre = sc.nextLine();
        Path dir = Paths.get(nombre);
        mostrar(dir);

    }

    private static void mostrar(Path dir) throws IOException {

        if (Files.isDirectory(dir)) {
            try ( DirectoryStream<Path> stream = Files.newDirectoryStream(dir)) {
                for (Path fichero : stream) {
                    if (Files.isDirectory(fichero)) {
                        obtenerPermisos(fichero);
                        System.out.println("Dentro de directorio " + fichero);
                        mostrar(fichero);
                    } else {
                        obtenerPermisos(fichero);

                    }
                }
            } catch (IOException | DirectoryIteratorException ex) {
                System.err.println(ex);
            }
        }
    }

    private static void obtenerPermisos(Path fichero) throws IOException {
        System.out.println("\t" + fichero.getFileName()
                + (Files.isDirectory(fichero) ? " directorio" : " archivo")
                + (Files.isExecutable(fichero) ? " x" : "-")
                + (Files.isHidden(fichero) ? "r" : "-")
                + (Files.isReadable(fichero) ? "w" : "-"));
    }
}
