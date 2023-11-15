/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ejercicios;

import java.io.File;
import java.io.IOException;

/**
 *
 * @author node
 */
public class Ejercicio3 {
    public static void main(String[] args) throws IOException {
        String ruta = "C:\\Users\\node\\Documents\\NetBeansProjects\\Acceso a datos\\Data\\users";
        String ruta1 = "C:\\Users\\node\\Documents\\NetBeansProjects\\Acceso a datos\\Data\\users\\user1.txt";
        File directorio = new File(ruta);
        File user1 = new File(ruta1);
        
        if(!directorio.exists()){
            directorio.mkdir();
            System.out.println(directorio+" se ha creado");
            user1.createNewFile();
        }else{
            System.out.println("El "+directorio+" ya existe");
            user1.createNewFile();
            System.out.println("El archivo "+user1+" ha sido creado");
        }
    }
    
    
}
