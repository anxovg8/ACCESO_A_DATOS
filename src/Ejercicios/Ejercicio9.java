/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ejercicios;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author node
 */
public class Ejercicio9 {
//    Ejercicio 9: Guardar el fichero “Productos.xml” en el directorio del programa y emplear el flujo de
//    entrada con buffer (FileReader y BufferedReader) para imprimir por consola el contenido del fichero.
    public static void main(String[] args) {
        try(BufferedReader lector = new BufferedReader(new FileReader("Productos.xml"))){
            String linea;
            while((linea=lector.readLine()) !=null){
                System.out.println(linea);
            }
        } catch (FileNotFoundException ex) {
            System.err.println(ex.getMessage());
        } catch (IOException ex) {
            System.err.println(ex.getMessage());
        }
    }
}
