/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ud2.tarefa22;

import BD.Conectores;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author node
 */
public class OperacionesBasicasGranja {
    
    private Connection con;
    private Statement stmt;
    
    public boolean abrirConexion() throws SQLException {
        boolean salida = false;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            System.err.println(ex.getMessage());
        }
        try {
            
            con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/farmville", "root", "abc123.");
            stmt = con.createStatement();
            salida = true;
        } catch (SQLException ex) {
            Logger.getLogger(Conectores.class.getName()).log(Level.SEVERE, null, ex);
        }
        return salida;
    }
    
    public void cerrarConexion() throws SQLException {
        stmt.close();
        con.close();
    }

    //OPERACIONES GRANJERO
    /*
    Crear granjero
     */
    public void crearGranjero(Granjero g) throws SQLException  {
        int id = g.getId();
        String nombre = g.getNombre();
        String descripcion = g.getDescripcion();
        float dinero = g.getDinero();
        int puntos = g.getPuntos();
        int nivel = g.getNivel();
        String insercion = "INSERT INTO granjeros (id,nombre,descripcion,dinero,puntos,nivel) VALUES(?,?,?,?,?,?)";
        
        PreparedStatement ps = con.prepareStatement(insercion);
        ps.setInt(1, id);
        ps.setString(2, nombre);
        ps.setString(3, descripcion);
        ps.setFloat(4, dinero);
        ps.setInt(5, puntos);
        ps.setInt(6, nivel);
        ps.executeUpdate();
        ps.close();
    }

    /*
    Modificar granjero
     */
    public void modificarGranjero(int id, String nombre, String descripcion, float dinero, int puntos, int nivel) {
        String sentenciaSQL = "UPDATE granjeros SET nombre = ?,descripcion = ?,dinero = ? ,puntos = ?, nivel = ? WHERE id = ?";
        PreparedStatement sentencia = null;
        
        try {
            sentencia = con.prepareStatement(sentenciaSQL);
            sentencia.setString(1, nombre);
            sentencia.setString(2, descripcion);
            sentencia.setFloat(3, dinero);
            sentencia.setInt(4, puntos);
            sentencia.setInt(5, nivel);
            sentencia.setInt(6, id);
            sentencia.executeUpdate();
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        } finally {
            if (sentencia != null) {
                try {
                    sentencia.close();
                    
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        }
    }

    /*
    Eliminar granjero
     */
    public void eliminarGranjero(int id) {
        String consultaSQL = "DELETE FROM granjeros WHERE id = ?";
        PreparedStatement sentencia = null;
        
        try {
            sentencia = con.prepareStatement(consultaSQL);
            sentencia.setInt(1, id);
            sentencia.executeUpdate();
            
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        } finally {
            if (sentencia != null) {
                try {
                    sentencia.close();
                    
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        }
    }

    /*
    Consulta datos granjero
     */
    public Granjero consultaDatosG(int id) {
        Granjero g = null;
        String consultaSQL = "SELECT * from granjeros WHERE id = ?";
        PreparedStatement sentencia = null;
        ResultSet resultado = null;
        
        try {
            sentencia = con.prepareStatement(consultaSQL);
            sentencia.setInt(1, id);
            resultado = sentencia.executeQuery();
            while (resultado.next()) {
                g = new Granjero(resultado.getInt(1), resultado.getString("nombre"), resultado.getString("descripcion"), resultado.getFloat(4), resultado.getInt(5), resultado.getInt(6));
            }
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        } finally {
            if (sentencia != null) {
                try {
                    sentencia.close();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        }
        return g;
    }

    //OPERACIONES CONSTRUCCION
    /*
    Crear construcción
     */
    public void crearConstruccion(Construccion c) throws SQLException {
        int id = c.getId();
        String nombre = c.getNombre();
        float precio = c.getPrecio();
        int idGranjero = c.getId_granjero();
        
        String insercion = "INSERT INTO construcciones (id,nombre,precio,id_granjero) VALUES(?,?,?,?)";
        PreparedStatement ps = con.prepareStatement(insercion);
        ps.setInt(1, id);
        ps.setString(2, nombre);
        ps.setFloat(3, precio);
        ps.setFloat(4, idGranjero);
        String updateDinero = "UPDATE granjeros SET dinero=dinero-" + c.getPrecio() + " WHERE id=" + c.getId_granjero() + "";
        PreparedStatement update = con.prepareStatement(updateDinero);
        
        ps.executeUpdate();
        update.executeUpdate();
        ps.close();
        update.close();
        
    }

    /*
    Modificar construccion
     */
    public void modificarConstruccion(int id, String nombre, float precio, int id_granjero) {
        String sentenciaSQL = "UPDATE construcciones SET nombre = ?,precio = ? ,id_granjero = ? WHERE id = ?";
        PreparedStatement sentencia = null;
        
        try {
            sentencia = con.prepareStatement(sentenciaSQL);
            sentencia.setString(1, nombre);
            sentencia.setFloat(2, precio);
            sentencia.setInt(3, id_granjero);
            sentencia.setInt(4, id);
            sentencia.executeUpdate();
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        } finally {
            if (sentencia != null) {
                try {
                    sentencia.close();
                    
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        }
        
    }

    /*
    Eliminar construccion
     */
    public void eliminarConstruccion(int id) {
        String consultaSQL = "DELETE FROM construcciones WHERE id = ?";
        PreparedStatement sentencia = null;
        
        try {
            sentencia = con.prepareStatement(consultaSQL);
            sentencia.setInt(1, id);
            sentencia.executeUpdate();
            
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        } finally {
            if (sentencia != null) {
                try {
                    sentencia.close();
                    
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        }
    }

    /*
    Consulta datos construccion
     */
    public Construccion consultaConstruccion(int id) {
        Construccion c = null;
        String consultaSQL = "SELECT * from construcciones WHERE id = ?";
        PreparedStatement sentencia = null;
        ResultSet resultado = null;
        
        try {
            sentencia = con.prepareStatement(consultaSQL);
            sentencia.setInt(1, id);
            resultado = sentencia.executeQuery();
            while (resultado.next()) {
                c = new Construccion(resultado.getInt(1), resultado.getString("nombre"), resultado.getFloat(3), resultado.getInt(4));
            }
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        } finally {
            if (sentencia != null) {
                try {
                    sentencia.close();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        }
        return c;
    }

    //OPERACIONES TRACTOR
    /*
    Crear tractor
     */
    public void crearTractor(Tractor t) throws SQLException {
        int id = t.getId();
        String modelo = t.getModelo();
        int velocidad = t.getVelocidad();
        float precio_venta = t.getPrecio_venta();
        int id_construccion = t.getId_construccion();
        
        String insercion = "INSERT INTO tractores (id,modelo,velocidad,precio_venta,id_construccion) VALUES(?,?,?,?,?)";
        PreparedStatement ps = con.prepareStatement(insercion);
        ps.setInt(1, id);
        ps.setString(2, modelo);
        ps.setInt(3, velocidad);
        ps.setFloat(4, precio_venta);
        ps.setInt(5, id_construccion);
        
        ps.executeUpdate();
        ps.close();
    }

    /*
    Modificar tractor
     */
    public void modificarTractor(int id, String modelo, int velocidad, float precio_venta, int id_construccion) {
        String sentenciaSQL = "UPDATE tractores SET modelo = ?,velocidad = ?,precio_venta = ? ,id_granjero = ? WHERE id = ?";
        PreparedStatement sentencia = null;
        
        try {
            sentencia = con.prepareStatement(sentenciaSQL);
            sentencia.setString(1, modelo);
            sentencia.setInt(2, velocidad);
            sentencia.setFloat(3, precio_venta);
            sentencia.setInt(4, id_construccion);
            sentencia.setInt(5, id);
            sentencia.executeUpdate();
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        } finally {
            if (sentencia != null) {
                try {
                    sentencia.close();
                    
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        }
    }

    /*
    Eliminar tractor
     */
    public void eliminarTractor(int id) {
        String consultaSQL = "DELETE FROM tractores WHERE id = ?";
        PreparedStatement sentencia = null;
        
        try {
            sentencia = con.prepareStatement(consultaSQL);
            sentencia.setInt(1, id);
            sentencia.executeUpdate();
            
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        } finally {
            if (sentencia != null) {
                try {
                    sentencia.close();
                    
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        }
    }

    /*
    Consulta datos tractor
     */
    public Tractor consultarTractor(int id) {
        Tractor t = null;
        String consultaSQL = "SELECT * from tractores WHERE id = ?";
        PreparedStatement sentencia = null;
        ResultSet resultado = null;
        
        try {
            sentencia = con.prepareStatement(consultaSQL);
            sentencia.setInt(1, id);
            resultado = sentencia.executeQuery();
            while (resultado.next()) {
                t = new Tractor(resultado.getInt(1), resultado.getString("modelo"), resultado.getInt(3), resultado.getFloat(4), resultado.getInt(5));
            }
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        } finally {
            if (sentencia != null) {
                try {
                    sentencia.close();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        }
        return t;
    }
    
    
    /*
    Lista construcciones por granjero
    */
    public void listarConstruccionesPorG(int id){
        try{
        String consultaSQL="SELECT granjeros.nombre,COUNT(construcciones.id) AS cantidad FROM granjeros INNER JOIN construcciones ON granjeros.id=construcciones.id_granjero WHERE granjeros.id=?";
        PreparedStatement ps = con.prepareStatement(consultaSQL);
        ps.setInt(1, id);
        ResultSet resultado = ps.executeQuery();
        
        if(resultado.next()){
            String nombreGranjero = resultado.getString("nombre");
            int cantidadConstrucciones = resultado.getInt("cantidad");
            System.out.println("El granjero "+nombreGranjero+" tiene "+cantidadConstrucciones+" construcciones.");
        }else{
            System.out.println("Granjero no encontrado");
        }
        
        }catch(SQLException ex){
            ex.printStackTrace();
        }
        
    }
    /*
    Aumento de precio
    */
    public void aumentoPrecioRural() throws SQLException{
        String consulta = "UPDATE tractores SET precio_venta=precio_venta * 1.10 WHERE modelo='rural'";
        PreparedStatement ps = con.prepareStatement(consulta);
        ps.executeUpdate();
    }
    
    /*
    Listar construcciones por tractor
    */
    
    public void listarConstruccionesPorTractor(int idT){
        try{
            String consultaSQL = "SELECT t.id,t.modelo,COUNT(c.id) AS cantidad FROM tractores t INNER JOIN construcciones c ON t.id=c.id_tractor WHERE t.id=?";
            PreparedStatement ps = con.prepareStatement(consultaSQL);
            ps.setInt(1, idT);
            ResultSet resultado = ps.executeQuery();
            if(resultado.next()){
                int idTractor = resultado.getInt("id");
                String modeloTractor = resultado.getString("modelo");
                int cantidadConstrucciones = resultado.getInt("cantidad");
                System.out.println("El tractor "+idTractor+" de tipo "+modeloTractor+" realiza "+ cantidadConstrucciones+" construcciones.");
            }else{
                System.out.println("Tractor no encontrado");
            }
        }catch(SQLException ex){
            ex.printStackTrace();
        }
    }
    
    /*
    Plantaciones de cada granjero
    */
    
    public void listarPlantacionesPorGranjero(int idG){
        try{
            String consultaSQL = "SELECT g.nombre AS nombre_granjero,p.nombre AS nombre_plantacion,p.proxima_cosecha FROM granjeros g INNER JOIN plantaciones p ON g.id = p.id_granjero WHERE g.id=?";
            PreparedStatement ps = con.prepareStatement(consultaSQL);
            ps.setInt(1, idG);
            ResultSet resultado = ps.executeQuery();
            
            while(resultado.next()){
                String nombreGranjero = resultado.getString("nombre_granjero");
                String nombrePlantacion = resultado.getString("nombre_plantacion");
                String proximaCosecha = resultado.getString("proxima_cosecha");
                System.out.println("El granjero "+ nombreGranjero +" plantó "+ nombrePlantacion + " el día "+proximaCosecha);
                
            }
            ps.close();
            
        }catch(SQLException ex){
            ex.printStackTrace();
        }
    }
    
}
