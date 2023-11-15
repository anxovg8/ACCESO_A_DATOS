/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BD;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;



/**
 *
 * @author node
 */
public class Conectores {
    public static void main(String[] args) {
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
        }catch(ClassNotFoundException ex){
            System.err.println(ex.getMessage());
        }
        
try (Connection con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/universidad", "root","abc123." );
           
                
            Statement stmt = con.createStatement(); ) {
            
            //stmt.execute("create database universidad");
            String tablaprofesores = "CREATE TABLE profesores  (dni VARCHAR(9) not NULL, " +
                   " nombre VARCHAR(255), " + 
                   " edad INTEGER, " + 
                   " PRIMARY KEY ( dni ))"; 
            //stmt.executeUpdate(tablaprofesores);
            
            String insertarprofesor = " INSERT INTO profesores VALUES ( '1234A', 'JOSE', '55')"; 
            String insertarprofesor2 = " INSERT INTO profesores VALUES ( '1234B', 'PEPE', '56')"; 
//            stmt.executeUpdate(insertarprofesor);
            
            String borrartabla = "DROP TABLE profesores";
            
            //stmt.executeUpdate(borrartabla);
            
            String verprofesor = " select * from profesores";
            
            ResultSet rs = stmt.executeQuery(verprofesor);
            
            while (rs.next()){
                 String dni = rs.getString("dni");
                 String nombre = rs.getString("nombre"); 
                 int edad = rs.getInt("edad");
                 System.out.println("-dni :" + dni + " -nombre :" + nombre +" -edad :" + edad);
            }
            
            String modificaredad = "UPDATE profesores SET edad = 12 WHERE DNI='1234A'";
            stmt.executeUpdate(modificaredad);
            /*ResultSet rs2 = stmt.executeQuery(verprofesor);    
                        while (rs2.next()){
                 String dni = rs2.getString("dni");
                 String nombre = rs2.getString("nombre"); 
                 int edad = rs2.getInt("edad");
                 System.out.println(dni + nombre + edad);
            }
            String borrarprofe = "DELETE FROM profesores WHERE DNI='1234A'";
            //stmt.executeUpdate(borrarprofe);
            ResultSet rs3 = stmt.executeQuery(verprofesor);    
            while (rs3.next()){
                 String dni = rs3.getString("dni");
                 String nombre = rs3.getString("nombre"); 
                 int edad = rs3.getInt("edad");
                 System.out.println("borrado: " +dni + nombre + edad);
            }
           */   
                
        } catch (SQLException ex) {
            Logger.getLogger(Conectores.class.getName()).log(Level.SEVERE, null, ex);
        }
     
        
        }
        

    }
    

