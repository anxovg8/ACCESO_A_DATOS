/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ud1.Tarefa1_2_VidalAnxo.Tarefa1_2_VidalAnxo_Ex02_VidalGarcia;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/**
 *
 * @author node
 */
public class Tarea2 {

    public static void main(String[] args) {
        System.out.println("Introduzca la ruta del fichero");
        Scanner sc = new Scanner(System.in);
        String ruta = sc.nextLine();
        ArrayList<String> lista = new ArrayList();
        try (BufferedReader lector = new BufferedReader(new FileReader(ruta))) {
            String linea;
            while ((linea = lector.readLine()) != null) {
                lista.add(linea);
            }
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
        Collections.sort(lista);
        for (String nombre : lista) {
            System.out.println(nombre);
        }
    }
}
    