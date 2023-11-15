/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ud1.Tarefa1_2_VidalAnxo.Tarefa1_2_VidalAnxo_Ex04_VidalGarcia;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

/**
 *
 * @author node
 */
public class Tarea4 {

    public static void main(String[] args) {
        System.out.println("Introduzca la ruta del fichero");
        Scanner sc = new Scanner(System.in);
        String ruta = sc.nextLine();
        Path dir = Paths.get(ruta);
        ArrayList<Marca> cochicos = new ArrayList();
        String[] mod = null;
        String linea = "";
        String nombre = "";
        String modelo = "";
        String modelo2 = "";
        Marca m = null;
        ArrayList<Marca> auxiliar = new ArrayList();
        ArrayList<Marca> definitiva = new ArrayList();
        int contador = 0;
        List<String> modelos = null;
        try (BufferedReader lector = new BufferedReader(new FileReader(ruta));) {
            
            while ((linea = lector.readLine()) != null) {
                mod = linea.split(" ");
                nombre = mod[0];
                modelo = mod[1];
                for (int i = 0; i < modelo.length(); i++) {
                    if (mod.length > 2) {
                        modelo2 = mod[2];

                        m = new Marca(nombre, modelo.concat(" " + modelo2));
                    } else {
                        m = new Marca(nombre, modelo);

                    }
                }

                cochicos.add(m);
            }
            System.out.println(cochicos.toString());
            auxiliar = (ArrayList<Marca>) cochicos.clone();

            Map<String, List<String>> marcas = new HashMap<>();

            // Itera sobre la lista de coches y agrupa los modelos por marca
            for (Marca coche : cochicos) {
                String marca = coche.getNombre();
                String model = coche.getModelos();

                if (marcas.containsKey(marca)) {
                    marcas.get(marca).add(model);
                } else {
                    modelos = new ArrayList<>();
                    modelos.add(model);
                    marcas.put(marca, modelos);
                }

            }
            System.out.println(marcas.toString());

            BufferedWriter writer = new BufferedWriter(new FileWriter("C:/marcas.txt"));

            for (Map.Entry<String, List<String>> entry : marcas.entrySet()) {
                String marca = entry.getKey();
                List<String> modeloss = entry.getValue();

                writer.write(marca + ": " + String.join(", ", modeloss));
                writer.newLine();
            }

            writer.close();

        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }

}
