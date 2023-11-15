/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ud2.tarefa33;

import BD.Conectores;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.ResultSet;

/**
 *
 * @author node
 */
public class BDManager {

    private Connection con;
    private Statement stmt;

    /**
     * abrir conexion
     *
     * @return true SI se abre conexion
     * @throws SQLException
     */
    public boolean abrirConexion() throws SQLException {
        boolean salida = false;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            System.err.println(ex.getMessage());
        }
        try {

            con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/bdempresa", "root", "abc123.");
            stmt = con.createStatement();
            salida = true;
        } catch (SQLException ex) {
            Logger.getLogger(Conectores.class.getName()).log(Level.SEVERE, null, ex);
        }
        return salida;
    }

    /**
     * cerrar conexion
     *
     * @throws SQLException
     */
    public void cerrarConexion() throws SQLException {
        stmt.close();
        con.close();
    }

    /**
     * Metodo que hace un UPDATE a un empleado de la tabla empregados de nuestra
     * BD
     *
     * @param nombre
     * @param apellido1
     * @param apellido2
     * @param NSS
     * @param rua
     * @param Num_rua
     * @param piso
     * @param cp
     * @param localidade
     * @param data_necemento
     * @param salario
     * @param sexo
     * @param NSS_Supervisa
     * @param Num_departamento
     */
    public void actualizarDatosEmpregado(String nombre, String apellido1, String apellido2, String NSS, String rua, int Num_rua, String piso, String cp, String localidade, String data_necemento, float salario, String sexo, String NSS_Supervisa, int Num_departamento) {
        String sentenciaSQL = "UPDATE empregado SET Nome = ? ,Apelido_1 = ?,Apelido_2 = ?,Rua = ?,Numero_rua = ?,Piso = ?,CP = ?,Localidade = ?,Data_nacemento = ?,Salario = ?,Sexo = ?,NSS_Supervisa = ?,Num_departamento = ? WHERE NSS = ?";
        PreparedStatement ps = null;
        try {
            ps = con.prepareStatement(sentenciaSQL);
            ps.setString(1, nombre);
            ps.setString(2, apellido1);
            ps.setString(3, apellido2);
            ps.setString(4, rua);
            ps.setInt(5, Num_rua);
            ps.setString(6, piso);
            ps.setString(7, cp);
            ps.setString(8, localidade);
            ps.setString(9, data_necemento);
            ps.setFloat(10, salario);
            ps.setString(11, sexo);
            ps.setString(12, NSS_Supervisa);
            ps.setInt(13, Num_departamento);
            ps.setString(14, NSS);
            ps.executeUpdate();
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        } finally {
            if (ps != null) {
                try {
                    ps.close();

                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        }
    }

    /**
     * Metodo que crea un nuevo proxecto
     *
     * @param p
     * @throws SQLException
     */
    public void crearNuevoProxecto(Proxecto p) throws SQLException {
        int num_proxecto = p.getNum_proxecto();
        String nombre = p.getNome_proxecto();
        String lugar = p.getLugar();
        int num_dep = p.getNumero_departamento();

        String insercion = "INSERT INTO proxecto (Num_proxecto,Nome_proxecto,Lugar,Numero_departamento) VALUES(?,?,?,?)";

        PreparedStatement ps = con.prepareStatement(insercion);

        ps.setInt(1, num_proxecto);
        ps.setString(2, nombre);
        ps.setString(3, lugar);
        ps.setInt(4, num_dep);
        ps.executeUpdate();
        ps.close();
    }

    /**
     * Metodo que consulta los datod de un empleado y los imprime en pantalla
     *
     * @param NSS
     * @return
     */
    public Empregado consultaEmpleado(String NSS) {
        Empregado e = null;
        String consultaSQL = "SELECT * from empregado WHERE NSS = ?";
        PreparedStatement sentencia = null;
        ResultSet resultado = null;

        try {
            sentencia = con.prepareStatement(consultaSQL);
            sentencia.setString(1, NSS);
            resultado = sentencia.executeQuery();
            while (resultado.next()) {
                e = new Empregado(resultado.getString("Nome"), resultado.getString("Apelido_1"), resultado.getString("Apelido_1"), resultado.getString("NSS"), resultado.getString("Rua"), resultado.getInt(6), resultado.getString("Piso"), resultado.getString("CP"), resultado.getString("Localidade"), resultado.getString("Data_nacemeto"), resultado.getFloat(11), resultado.getString("Sexo"), resultado.getString("NSS_Supervisa"), resultado.getInt(14));
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
        return e;
    }

    /**
     * Metodo que consulta los datos de un departamento y los imprime en
     * pantalla
     *
     * @param Num_Departamento
     * @return
     */
    public Departamento consultaDepartamento(int Num_Departamento) {
        Departamento d = null;
        String consultaSQL = "SELECT * from departamento WHERE Num_Departamento = ?";
        PreparedStatement sentencia = null;
        ResultSet resultado = null;

        try {
            sentencia = con.prepareStatement(consultaSQL);
            sentencia.setInt(1, Num_Departamento);
            resultado = sentencia.executeQuery();
            while (resultado.next()) {
                d = new Departamento(resultado.getInt(1), resultado.getString("Nome_Departamento"), resultado.getString("NSS_dirige"), resultado.getString("Data_direccion"));
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
        return d;
    }

    /**
     * Metodo que consulta los datos de un proxecto y los imprime en pantalla
     *
     * @param Num_proxecto
     * @return
     */
    public Proxecto consultaProxecto(int Num_proxecto) {
        Proxecto p = null;
        String consultaSQL = "SELECT * from proxecto WHERE Num_proxecto = ?";
        PreparedStatement sentencia = null;
        ResultSet resultado = null;

        try {
            sentencia = con.prepareStatement(consultaSQL);
            sentencia.setInt(1, Num_proxecto);
            resultado = sentencia.executeQuery();
            while (resultado.next()) {
                p = new Proxecto(resultado.getInt(1), resultado.getString("Nome_proxecto"), resultado.getString("Lugar"), resultado.getInt(4));
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
        return p;
    }

    /**
     * Este método crea una nueva tabla llamada lugar Lugar en la BBDD
     */
    public void crearTablaLugar() throws SQLException {
        String crearTablaLugar = "CREATE TABLE IF NOT EXISTS Lugar (Lugar VARCHAR(20) PRIMARY KEY, Numero_Departamento INTEGER,FOREIGN KEY (Numero_Departamento) REFERENCES DEPARTAMENTO (Num_Departamento) )";
        stmt.executeUpdate(crearTablaLugar);

        //String claveForanea1 = "ALTER TABLE Lugar ADD CONSTRAINT K_LUGAR_PROXECTO FOREIGN KEY (Lugar) REFERENCES PROXECTO (Lugar)";
        //String claveForanea2 = "ALTER TABLE  Lugar ADD CONSTRAINT  K_LUGAR_DEPARTAMENTO FOREIGN KEY (Numero_Departamento) REFERENCES DEPARTAMENTO (Num_Departamento)";
        //stmt.execute(claveForanea1);
        //stmt.execute(claveForanea2);

        ResultSet resultado = null;

        String insercion = "INSERT INTO Lugar (Lugar,Numero_Departamento) VALUES(?,?)";
        PreparedStatement ps = con.prepareStatement(insercion);
        String datosAInsertar = "SELECT Lugar,COUNT(Numero_Departamento) FROM proxecto INNER JOIN departamento ON proxecto.Numero_departamento = departamento.Num_Departamento GROUP BY Lugar";
        PreparedStatement ps2 = con.prepareStatement(datosAInsertar);
        resultado = ps2.executeQuery();
        while (resultado.next()) {
            ps.setString(1, resultado.getString(1));
            ps.setInt(2, resultado.getInt(2));
            ps.executeUpdate();
        }
        
    }
}
