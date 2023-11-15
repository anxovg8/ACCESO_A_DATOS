/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ud1.Tarefa1_2_VidalAnxo.Tarefa1_2VidalAnxo_Ex07_VidalGarcía;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 *
 * @author alumno
 */
public class Minishell {
    private static String directorioActual;
    
    public Minishell(){
        directorioActual = System.getProperty("user.dir");
    }
    
    public static void ls(String nombreDir) {
        Path dir = Paths.get(nombreDir);
        String permisos = "";
        if (Files.isDirectory(dir)) {
            try ( DirectoryStream<Path> steam = Files.newDirectoryStream(dir);) {
                for (Path fichero : steam) {
                    //System.out.println(fichero.getFileName());
                    permisos = "";
                    if (fichero.toFile().isDirectory()) {
                        permisos = "d";
                        if (fichero.toFile().canRead()) {
                            permisos += "r";
                        }
                        if (fichero.toFile().canWrite()) {
                            permisos += "w";
                        }
                        if (fichero.toFile().canExecute()) {
                            permisos += "x";

                        }

                    } else {
                        if (fichero.toFile().canRead()) {
                            permisos += "r";
                        }
                        if (fichero.toFile().canWrite()) {
                            permisos += "w";
                        }
                        if (fichero.toFile().canExecute()) {
                            permisos += "x";
                        }

                    }
                    System.out.println(fichero + " " + permisos);
                }

            } catch (IOException ex) {
                System.out.println(ex.getMessage());
            }

        }

    }
    
    public static void cd(String dir){
        File newDir = new File(dir);
        
        if(newDir.isAbsolute()){
            if(newDir.isDirectory()){
                directorioActual = newDir.getAbsolutePath();
            }else{
                System.out.println("El directorio "+dir+" no existe");
            }
        }else{
            File newRelativo = new File(directorioActual,dir);
            if(newRelativo.isDirectory()){
                directorioActual = newRelativo.getAbsolutePath();
            }else{
                System.out.println("El directorio "+dir+" no existe");
            }
        }
        
        
    }
    
    public static void cat(String nombreFile){
        File file = new File(directorioActual, nombreFile);
        
        if(file.isFile()){
            try(BufferedReader lector = new BufferedReader(new FileReader(file))){
                String linea;
                while((linea = lector.readLine())!=null ){
                    System.out.println(linea);
                }
            } catch (IOException ex) {
                System.err.println(ex.getMessage());
            }
        }else{
            System.out.println("El archivo "+file+" no existe.");
        }
        
        
    }
    
    
    
}
