/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ejercicios;

import java.io.File;

/**
 *
 * @author node
 */
public class Ejercicio1 {
    public static void main(String[] args) {
        //Path home = Paths.get(System.getProperty("user.home"));
        String ruta = "C:\\Users\\node\\Desktop\\Prueba1";
        File directorio = new File(ruta);
        boolean creado = false;
        
        if(directorio.exists()){
            System.out.println("El directorio "+ruta+" ya existe");
        }else{
            //Crea un directorio
            creado = directorio.mkdir();
        }
        if(creado){
            System.out.println("El directorio "+ruta+" se ha creado satisfactoriamente");
        }else{
            System.out.println("El directorio no se ha creado");
        }
       
    }
    
}
