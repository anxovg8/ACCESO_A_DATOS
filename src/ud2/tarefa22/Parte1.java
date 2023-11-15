/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ud2.tarefa22;

import java.sql.SQLException;
import java.util.Scanner;

/**
 *
 * @author node
 */
public class Parte1 {

    public static void main(String[] args) throws SQLException {
        OperacionesBasicasGranja bd = new OperacionesBasicasGranja();
        bd.abrirConexion();

        String menu1 = "-------------------------------\n"
                + "1-GRANJERO\n"
                + "2-CONSTRUCCIÓN\n"
                + "3-TRACTOR\n"
                + "-------------------------------";
       // System.out.println(menu1);

        Scanner sc = new Scanner(System.in);

        String opcion = "0";

        while (!(Integer.parseInt(opcion) >= 4)) {
            System.out.println("Elija la opcion");
            System.out.println(menu1);
            opcion = sc.next();
            switch (opcion) {
                case "1":
                    System.out.println("GRANJERO");
                    String menuG = "-------------------------------\n"
                            + "1-Añadir granjero\n"
                            + "2-Modificar granjero\n"
                            + "3-Borrar granjero\n"
                            + "4-Consultar granjero\n"
                            + "5-Salir\n"
                            + "-------------------------------";
                    //System.out.println(menuG);
                    String opcionG = "0";
                    while (!(Integer.parseInt(opcionG) >= 5)) {
                        System.out.println(menuG);
                        System.out.println("Elija la opcion");
                        opcionG = sc.next();
                        switch (opcionG) {
                            case "1":
                                System.out.println("Crear granjero");
                                System.out.println("id:");
                                int idN = sc.nextInt();
                                System.out.println("nombre:");
                                String nombreN = String.valueOf(sc.next());
                                //nombreN =sc.nextLine();
                                System.out.println("descripcion:");
                                String descipcionN = String.valueOf(sc.next());
                                System.out.println("dinero:");
                                float dineroN = Float.parseFloat(sc.next());
                                System.out.println("puntos:");
                                int puntosN = Integer.parseInt(sc.next());
                                System.out.println("nivel:");
                                int nivelN = Integer.parseInt(sc.next());
                                Granjero g = new Granjero(idN, nombreN, descipcionN, dineroN, puntosN, nivelN);
                                bd.crearGranjero(g);
                                break;
                            case "2":
                                System.out.println("Modificar granjero");
                                System.out.println("id:");
                                System.out.println("id:");
                                int idM = sc.nextInt();
                                System.out.println("nombre:");
                                String nombreM = String.valueOf(sc.next());
                                //nombreN =sc.nextLine();
                                System.out.println("descripcion:");
                                String descipcionM = String.valueOf(sc.next());
                                System.out.println("dinero:");
                                float dineroM = Float.parseFloat(sc.next());
                                System.out.println("puntos:");
                                int puntosM = Integer.parseInt(sc.next());
                                System.out.println("nivel:");
                                int nivelM = Integer.parseInt(sc.next());
                                bd.modificarGranjero(idM, nombreM, descipcionM, dineroM, puntosM, nivelM);
                                break;
                            case "3":
                                System.out.println("Borrado Granjero");
                                System.out.println("id que va a ser borrado");
                                int idB = sc.nextInt();
                                bd.eliminarGranjero(idB);
                                break;
                            case "4":
                                System.out.println("Consulta datos de un granjero");
                                System.out.println("id del granjero a consultar:");
                                int idC = sc.nextInt();
                                System.out.println(bd.consultaDatosG(idC));
                                break;
                            case "5":
                                break;
                        }

                    }

                    break;
                case "2":
                    System.out.println("CONSTRUCCIÓN");
                    String menuC = "-------------------------------\n"
                            + "1-Añadir construccion\n"
                            + "2-Modificar construccion\n"
                            + "3-Borrar construccion\n"
                            + "4-Consultar construccion\n"
                            + "5-Salir\n"
                            + "-------------------------------";
                    System.out.println(menuC);
                    String opcionC = "0";
                    while (!(Integer.parseInt(opcionC) >= 5)) {
                        System.out.println("Elija una opcion");
                        opcionC = sc.next();
                        switch (opcionC) {
                            case "1":
                                System.out.println("Crear construccion");
                                System.out.println("id:");
                                int idC = sc.nextInt();
                                System.out.println("nombre:");
                                String nombreC = String.valueOf(sc.next());
                                System.out.println("precio:");
                                float precioC = Float.parseFloat(sc.next());
                                System.out.println("id granjero:");
                                int id_gC = Integer.parseInt(sc.next());
                                Construccion c = new Construccion(idC, nombreC, precioC, id_gC);
                                bd.crearConstruccion(c);
                                opcionC = "0";
                                break;
                            case "2":
                                System.out.println("Modificar construccion");
                                System.out.println("id:");
                                int idcM = sc.nextInt();
                                System.out.println("nombre:");
                                String nombrecM = String.valueOf(sc.next());
                                System.out.println("precio:");
                                float preciocM = Float.parseFloat(sc.next());
                                System.out.println("id granjero:");
                                int id_gcM = Integer.parseInt(sc.next());
                                bd.modificarConstruccion(idcM, nombrecM, preciocM, id_gcM);
                                opcionC = "0";
                                break;
                            case "3":
                                System.out.println("Borrado Construccion");
                                System.out.println("id que va a ser borrado");
                                int idcB = sc.nextInt();
                                bd.eliminarConstruccion(idcB);
                                opcionC = "0";
                                break;
                            case "4":
                                System.out.println("Consulta datos de un construccion");
                                System.out.println("id de la construccion a consultar:");
                                int idcC = sc.nextInt();
                                System.out.println(bd.consultaConstruccion(idcC));
                                opcionC = "0";
                                break;
                            case "5":
                                break;

                        }
                    }
                    break;
                case "3":
                    System.out.println("TRACTOR");
                    String menuT = "-------------------------------\n"
                            + "1-Añadir tractor\n"
                            + "2-Consultar tractor\n"
                            + "3-Borrar tractor\n"
                            + "4-Modificar tractor\n"
                            + "5-Salir\n"
                            + "-------------------------------";
                    System.out.println(menuT);

                    String opcionT = "0";
                    while (!(Integer.parseInt(opcionT) >= 5)) {
                        System.out.println("Elija una opcion");
                        opcionT = sc.next();
                        switch (opcionT) {
                            case "1":
                                System.out.println("Crear Tractor");
                                System.out.println("id:");
                                int idT = sc.nextInt();
                                System.out.println("modelo(rural,cosechar,carreras):");
                                String modeloT = String.valueOf(sc.next());
                                System.out.println("velocidad:");
                                int velocidadT = Integer.parseInt(sc.next());
                                System.out.println("precio venta:");
                                float precio_ventaT = Float.parseFloat(sc.next());
                                System.out.println("id construccion:");
                                int id_construccionT = Integer.parseInt(sc.next());

                                Tractor t = new Tractor(idT, modeloT, velocidadT, precio_ventaT, id_construccionT);
                                bd.crearTractor(t);
                                break;
                            case "2":
                                System.out.println("Modificar Tractor");
                                System.out.println("id:");
                                int idmT = sc.nextInt();
                                System.out.println("modelo(rural,cosechar,carreras):");
                                String modelomT = String.valueOf(sc.next());
                                System.out.println("velocidad:");
                                int velocidadmT = Integer.parseInt(sc.next());
                                System.out.println("precio venta:");
                                float precio_ventamT = Float.parseFloat(sc.next());
                                System.out.println("id construccion:");
                                int id_construccionmT = Integer.parseInt(sc.next());
                                bd.modificarTractor(idmT, modelomT, velocidadmT, precio_ventamT, id_construccionmT);
                                break;
                            case "3":
                                System.out.println("Borrar Tractor");
                                System.out.println("id que va a ser borrado");
                                int idtB = sc.nextInt();
                                bd.eliminarTractor(idtB);
                                break;
                            case "4":
                                System.out.println("Consulta datos de un tractor");
                                System.out.println("id del tractor a consultar:");
                                int idtC = sc.nextInt();
                                System.out.println(bd.consultarTractor(idtC));
                                break;
                            case "5":
                                break;
                        }
                    }
                    break;
                case "4":
                    break;

            }
        }

    }

}
