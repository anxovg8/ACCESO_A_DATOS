/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ejercicios;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author node
 */
public class Ejercicio12 {
//    Ejercicio 12: Crea un objeto del tipo Alumno donde se almacene su nombre, sus 2 apellidos y su nota
//    media.
//        1. Serializa el alumno en un array de bytes (byte[]) y muestra el resultado por pantalla.
//        2. Deserializa un alumno serializado y muestra el resultado por pantalla.

    public static void main(String[] args) {
        Alumno a1 = new Alumno("Anxo", "Vidal", "García", 10.0);
        byte[] alumnos;
        alumnos =serializarAlumno(a1);
        
        for(byte b :alumnos){
            System.out.println(b+" ");
        }
        
        Alumno a2 = deserializarAlumno(alumnos);
        System.out.println(a2.toString());
    }

    private static byte[] serializarAlumno(Alumno a) {
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        try (ObjectOutputStream obs = new ObjectOutputStream(bos)) {
            obs.writeObject(a);
        } catch (IOException ex) {
            System.err.println(ex.getMessage());
        }
        return bos.toByteArray();
    }
    
    private static Alumno deserializarAlumno(byte[] byteArray){
        ByteArrayInputStream bis = new ByteArrayInputStream(byteArray);
        try(ObjectInputStream ois = new ObjectInputStream(bis)){
            return (Alumno) ois.readObject();
        } catch (IOException | ClassNotFoundException ex) {
            System.err.println(ex.getMessage());
        }
        return null;
    }
}
