/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ud1.Tarefa1_2_VidalAnxo.Tarefa1_2VidalAnxo_Ex07_VidalGarcía;

import static ud1.Tarefa1_2_VidalAnxo.Tarefa1_2VidalAnxo_Ex07_VidalGarcía.Minishell.*;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

/**
 *
 * @author alumno
 */
public class Principal {

    private static String directorioActual = System.getProperty("user.dir");

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print(directorioActual + ">");

        String opciones = "";
        String condicion = "";
        String directorio = "";
        Path dir = Paths.get(directorio);
        while (!opciones.equals("exit")) {
            //System.out.println("Que desea hacer?");

            opciones = sc.nextLine();
            String[] ops = opciones.split(" ");
            switch (ops[0]) {
                case "ls":
                    System.out.print(directorioActual + ">");
                    //System.out.println("Introduzca el nombre de su directorio: ");
                    //String directorio = sc.nextLine();
                    //Path dir = Paths.get(directorio);
                    if (ops.length > 1) {
                        directorioActual = ops[1];
                        String nombreDir = directorioActual;
                        ls(directorioActual);
                    }else{
                        String nombreDir = directorioActual;
                        ls(directorioActual);
                    }

                    //System.out.println("Quiere continuar?");
                    System.out.print(directorioActual + ">");
                    

                    break;
                case "cd":
                    //System.out.print(directorioActual + ">");
                    //System.out.println("Introduzca el nombre del directorio al que quiere acceder ");
                    //directorio = sc.nextLine();
                    //dir = Paths.get(directorio);
                    cd(ops[1]);
                    directorioActual = ops[1];
                    //System.out.println("Quiere continuar?");
                    System.out.print(directorioActual + ">");
                    
                    break;
                case "cat":
                    System.out.print(directorioActual + ">");
                    System.out.println("nombre File");
                    //String nombreFile = sc.nextLine();
                    cat(ops[1]);
                    //System.out.println("Quiere continuar?");
                    System.out.print(directorioActual + ">");
                    
                    break;
                case "exit":
                    System.out.println("Saliendo del shell");
                    break;
            }
        }
    }

}
    