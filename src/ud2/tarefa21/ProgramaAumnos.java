/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ud2.tarefa21;

import java.sql.SQLException;
import java.util.Scanner;
import static javax.swing.text.html.HTML.Tag.S;

/**
 *
 * @author node
 */
public class ProgramaAumnos {

    public static void main(String[] args) throws SQLException {
        //Alumno a = new Alumno("111", "anxo", "vidal", 22);
        OperacionsBD bd = new OperacionsBD();
        bd.abrirConexion();
        String dni = "";
        String nombre = "";
        String apellido = "";
        int edad = 0;
        String menu = "-------------------------------\n"
                + "1-Añadir alumno\n"
                + "2-Consultar alumno\n"
                + "3-Borrar alumno\n"
                + "4-Modificar alumno\n"
                + "5-Lista alumnos\n"
                + "6-Salir\n"
                + "-------------------------------";
        System.out.println(menu);
        System.out.println("Elija la opcion");
        Scanner sc = new Scanner(System.in);


String opcion="0";
        while (!(Integer.parseInt(opcion)>=6)) {
            
            opcion = sc.nextLine();
            System.out.println(menu);

            switch (opcion) {
                case "1":
                    System.out.println("Añadir alumno");
                    System.out.println("Introduzca el dni");
                    dni = sc.nextLine();
                    System.out.println("Introduzca el nombre");
                    nombre = sc.nextLine();
                    System.out.println("Introduzca el apellido");
                    apellido = sc.nextLine();
                    System.out.println("Introduzca la edad");
                    edad = Integer.parseInt(sc.nextLine());
                    Alumno a = new Alumno(dni, nombre, apellido, edad);
                    bd.anadirAlumno(a);
                    break;
                case "2":
                    System.out.println("Consulta de alumno");
                    System.out.println("Introduzca el dni");
                    String dniC = sc.nextLine();
                    System.out.println(bd.consultaAlumno(dniC));
                    break;
                case "3":
                    System.out.println("Borrado de alumno");
                    System.out.println("Introduzca el dni del alumno que desea borrar");
                    String dniB = sc.nextLine();
                    bd.borraAlumno(dniB);
                    break;
                case "4":
                    System.out.println("Modificar alumno");
                    System.out.println("Introduzca el dni");
                    dni = sc.nextLine();
                    System.out.println("Introduzca el nombre");
                    nombre = sc.nextLine();
                    System.out.println("Introduzca el apellido");
                    apellido = sc.nextLine();
                    System.out.println("Introduzca la edad");
                    edad = Integer.parseInt(sc.nextLine());
                    bd.modificaAlumno(dni, nombre, apellido, edad);
                    break;
                case "5":
                    System.out.println("Lista alumnado");
                    System.out.println(bd.listadoAlumno());
                    break;
                case "6":
                    break;

            }
        }
        

        
       
    }
}
