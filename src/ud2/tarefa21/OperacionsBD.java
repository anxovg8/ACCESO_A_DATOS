/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ud2.tarefa21;

import BD.Conectores;
import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author node
 */
public class OperacionsBD {

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

            con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/alumnos", "root", "abc123.");

            stmt = con.createStatement();
            stmt.execute("create DATABASE  if NOT EXISTS alumnos");

            String crearTabla = "CREATE TABLE if NOT EXISTS alumnos  "
                    + "(dni VARCHAR(9) not NULL, "
                    + " nombre VARCHAR(255), "
                    + "apellido VARCHAR(255),"
                    + " edad INTEGER, "
                    + " PRIMARY KEY ( dni ))";
            stmt.executeUpdate(crearTabla);
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

    public void anadirAlumno(Alumno a) throws SQLException {

        String Vdni = a.getDni();
        String Vnombre = a.getNombre();
        String Vapellidos = a.getApellidos();
        Integer Vedad = a.getEdad();

        String insercion = "INSERT INTO alumnos (dni,nombre,apellido,edad) VALUES(?,?,?,?)";

        PreparedStatement ps = con.prepareStatement(insercion);
        ps.setString(1, Vdni);
        ps.setString(2, Vnombre);
        ps.setString(3, Vapellidos);
        ps.setInt(4, Vedad);
        ps.executeUpdate();
        ps.close();

    }

    public Alumno consultaAlumno(String dni) throws SQLException {

        Alumno a = null;
        String consultaSQL = "SELECT * from alumnos WHERE dni = ?";
        PreparedStatement sentencia = null;
        ResultSet resultado = null;

        try {
            sentencia = con.prepareStatement(consultaSQL);
            sentencia.setString(1, dni);
            resultado = sentencia.executeQuery();
            while (resultado.next()) {
                a = new Alumno(resultado.getString("dni"), resultado.getString("nombre"), resultado.getString("apellido"), resultado.getInt(4));
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
        //System.out.println(a.toString());

        return a;
    }

    public void borraAlumno(String dni) {
        Alumno a = null;
        String consultaSQL = "DELETE FROM alumnos WHERE dni = ?";
        PreparedStatement sentencia = null;

        try {
            sentencia = con.prepareStatement(consultaSQL);
            sentencia.setString(1, dni);
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

    public void modificaAlumno(String nDni, String nNombre, String nApellido, int nEdad) {
        String sentenciaSQL = "UPDATE alumnos SET nombre = ? ,apellido = ?,edad = ? WHERE dni = ?";
        PreparedStatement sentencia = null;

        try {
            sentencia = con.prepareStatement(sentenciaSQL);

            sentencia.setString(1, nNombre);
            sentencia.setString(2, nApellido);
            sentencia.setInt(3, nEdad);
            sentencia.setString(4, nDni);
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

    public ArrayList<Alumno> listadoAlumno() {
        ArrayList<Alumno> alumnado = new ArrayList();
        String consultaSQL = "SELECT * from alumnos";
        PreparedStatement sentencia = null;
        ResultSet resultado = null;
        try {
            sentencia = con.prepareStatement(consultaSQL);
            resultado = sentencia.executeQuery();
            while (resultado.next()) {
                alumnado.add(new Alumno(resultado.getString("dni"), resultado.getString("nombre"), resultado.getString("apellido"), resultado.getInt("edad")));
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
        return alumnado;
    }

}
