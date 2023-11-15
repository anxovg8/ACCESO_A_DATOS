/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ud1.Tarefa1_2_VidalAnxo.Tarefa1_2_VidalAnxo_Ex03_VidalGarcia;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author node
 */
public class Tarea3 {

    public final static String correcto = "TTTFFFTTTFTFTFTFTFTF";

    public static void main(String[] args) {
        ArrayList<Alumno> alumnos = new ArrayList();
        System.out.println("Introduzca la ruta del fichero");
        Scanner sc = new Scanner(System.in);
        String ruta = sc.nextLine();
        String linea = "";
        String[] al = null;
        Double nota = 0.0;
        char[] correccion = correcto.toCharArray();
        try (BufferedReader lector = new BufferedReader(new FileReader(ruta))) {
            while ((linea = lector.readLine()) != null) {
                al = linea.split("-");
                String id = al[0];
                String resultado = al[1];
                Alumno alumno = new Alumno(id, resultado);
                alumnos.add(alumno);
            }
            for (int i = 0; i < alumnos.size(); i++) {
                for (int j = 0; j < correccion.length; j++) {
                    if (alumnos.get(i).result()[j] == correccion[j]) {
                        nota += 0.5;
                    } else if (alumnos.get(i).result()[j] != correccion[j]) {
                        nota -= 0.15;
                    }
                    alumnos.get(i).setNota((double)Math.round(nota * 100d) / 100d); 
                    
                }
               nota = 0.0;
            }
            for (int i = 0; i < alumnos.size(); i++) {
                System.out.println(alumnos.get(i).toString());
            }

        } catch (IOException e) {
            System.err.println(e.getMessage());

        }

    }
}
