/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ejercicios;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

/**
 *
 * @author node
 */
public class Ejercicio8 {
//    Ejercicio 8: Repetir el ejercicio anterior empleando un buffer.
    public static void main(String[] args) {
        try(BufferedWriter escritor = new BufferedWriter(new FileWriter("Hello.txt",true))){
            escritor.write("Texto formateado 1\n");
            escritor.write("Texto formateado 2\n");
        }catch(IOException ex){
            System.err.println(ex.getMessage());
        }
    }
}
