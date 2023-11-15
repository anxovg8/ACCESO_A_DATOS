/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ejercicios;

import java.io.File;
import java.io.IOException;

import java.util.Date;

/**
 *
 * @author node
 */
public class Ejercicio4 {
    //Ejercicio 4. Cambiar la fecha de modificación del fichero “user1.txt” a : 7/03/2017 18:33:00
    public static void main(String[] args) throws IOException {
        String ruta = "C:\\Users\\node\\Documents\\NetBeansProjects\\Acceso a datos\\Data\\users\\user1.txt";
        File user1 = new File(ruta);
        Date dt = new Date();
       
        dt.setYear(117);
        dt.setDate(07);
        dt.setMonth(3);
        
        dt.setHours(18);
        dt.setMinutes(33);
        dt.setSeconds(00);
        user1.setLastModified(dt.getTime());

    }
}
