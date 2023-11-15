/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ud1.Tarefa1_2_VidalAnxo.Tarefa1_2_VidalAnxo_Ex06_VidalGarcia;

import java.io.File;
import java.io.IOException;
import java.nio.file.DirectoryIteratorException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;
/**
 *
 * @author 
 */
public class Recursividad {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        
        System.out.println("Introduzca el Path:");
        String path = teclado.nextLine();
        teclado.close();
        
        Path dir = Paths.get(path);
        System.out.println("Ficheros del directorio " + dir);
        
        if (Files.isDirectory(dir)) {
            try (DirectoryStream<Path> stream = Files.newDirectoryStream(dir);){
                for (Path fichero: stream) {
                    if(Files.isDirectory(fichero)){
                        System.out.println("dir " + fichero.getFileName() + "\t");
                        int cont = 1;
                        listar(fichero, cont);
                    }else{
                        File ficheroP = fichero.toFile();
                        String permisos = "-";

                        if(ficheroP.canRead()){
                            permisos += "r";
                        }else{
                            permisos += "-";
                        }

                        if(ficheroP.canWrite()){
                            permisos += "w";
                        }else{
                            permisos += "-";
                        }

                        if(ficheroP.canExecute()){
                            permisos += "x";
                        }else{
                            permisos += "-";
                        }
                        
                        System.out.println(permisos + " " + fichero.getFileName());
                    }
                }
            }catch (IOException | DirectoryIteratorException ex) {
                System.err.println(ex);
            }
        } else {
            System.err.println(dir.toString()+" no es un directorio");
        }
    }
    
    public static void listar(Path fichero, int cont){
        try (DirectoryStream<Path> stream = Files.newDirectoryStream(fichero);){
            for (Path fichero2: stream) {
                if(Files.isDirectory(fichero2)){
                    for (int i = 0; i < cont; i++) {
                        System.out.print("\t");
                    }
                    System.out.print("dir " + fichero2.getFileName() + "\n");
                    cont++;
                    listar(fichero2, cont);
                }else{
                    File ficheroP = fichero.toFile();
                    String permisos = "-";

                    if(ficheroP.canRead()){
                        permisos += "r";
                    }else{
                        permisos += "-";
                    }

                    if(ficheroP.canWrite()){
                        permisos += "w";
                    }else{
                        permisos += "-";
                    }

                    if(ficheroP.canExecute()){
                        permisos += "x";
                    }else{
                        permisos += "-";
                    }
                    for (int i = 0; i < cont; i++) {
                        System.out.print("\t");
                    }
                    System.out.print(permisos + " " + fichero.getFileName() + "\n");
                }
            }
        }catch (IOException | DirectoryIteratorException ex) {
            System.err.println(ex);
        } 
    }
}
