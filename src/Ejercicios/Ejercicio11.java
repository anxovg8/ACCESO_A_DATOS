/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ejercicios;

import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Properties;

/**
 *
 * @author node
 */
public class Ejercicio11 {
//    Ejercicio 11: Escribe un fichero de configuración en el escritorio que almacene las siguientes
//    propiedades:
//        url = http://google.com
//        port = 80
//        secure = true
//    Debes poder obtener estas propiedades del fichero e imprimir por pantalla el resultado.
    
    public static void main(String[] args) {
        Path home = Paths.get(System.getProperty("user.home"));
        String fichero = home + "/Desktop/propiedades.txt";
        
        Properties propiedades = new Properties();
        
        try{
            propiedades.load(new FileInputStream(fichero));
            String url = propiedades.getProperty("url");
            String port = propiedades.getProperty("port");
            String secure = propiedades.getProperty("secure");
            
            System.out.println("URL: "+url);
            System.out.println("Puerto: "+port);
            System.out.println("Seguro: "+secure);
            
        }catch(IOException ex){
            System.err.println(ex.getMessage());
        }
    }
}
