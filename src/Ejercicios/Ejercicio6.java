/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ejercicios;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 *
 * @author node
 */
public class Ejercicio6 {
//    Ejercicio 6: Escribir en un fichero “Hello.txt” la cadena “Hello file!” empleando la clase FileWriter y
//    el método write(). Probar a escribirlo 6 veces con un bucle.
    public static void main(String[] args) throws IOException {
//        try(BufferedWriter escritor = new BufferedWriter(new FileWriter("Hello.txt"))){
//            for(int i=0;i<6;i++){
//                escritor.write("Hello file!");
//                escritor.newLine();
//            }
//        }catch(IOException ex){
//            System.err.println(ex.getMessage());
//        }
        
        try (FileWriter fw = new FileWriter("Hello.txt")) {
            
            for(int i=0;i<6;i++){
                fw.write("Hello File"+"\n");
                
            }
            fw.close();
        }
        
    }
    
}
