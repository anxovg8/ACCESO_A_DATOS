package ud2.tarefa24;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
import BD.Conectores;
import com.mysql.cj.jdbc.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.ResultSet;
import java.sql.Types;

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
     * @throws
     */
    public void cerrarConexion() throws SQLException {
        stmt.close();
        con.close();
    }

    //EXERCICIO 1
    /**
     * Método que sube el salario de los empleados que pertenecen a un
     * determinado departamento
     *
     * @param subida cantidad que se le sube al salario
     * @param NombreDepartamento nombre del departamento al cual se le va a
     * hacer una subida de salario
     * @throws SQLException
     */
    public void subirPrecioEmpregados(int subida, String NombreDepartamento) throws SQLException {
        String updateSalario = "UPDATE empregado INNER JOSQLExceptionIN departamento ON empregado.Num_departamento_pertenece = departamento.Num_Departamento SET Salario=Salario+" + subida + "WHERE departamento.Nome_Departemento = " + NombreDepartamento + "";
        PreparedStatement ps = con.prepareStatement(updateSalario);
        ps.executeUpdate();
    }

    /**
     * Método que sirve para crear un nuevo departamento
     *
     * @param numeroDepartamento
     * @param nombreDepartamento
     * @param NSSDirige
     * @throws SQLException
     */
    public void inserirDepartamento(int numeroDepartamento, String nombreDepartamento, String NSSDirige) throws SQLException {

        LocalDate localDate = LocalDate.now();
        Date date = Date.from(localDate.atStartOfDay(ZoneId.systemDefault()).toInstant());
        String insercion = "INSERT INTO departamento (Num_Departamento,Nome_Departamento,NSS_Dirige,Data_direccion) VALUES (?,?,?," + date + ")";

        PreparedStatement ps = con.prepareStatement(insercion);

        ps.setInt(1, numeroDepartamento);
        ps.setString(2, nombreDepartamento);
        ps.setString(3, NSSDirige);

    }

    /**
     * Método que sirve para eliminar un empregado de un proxecto
     *
     * @param NSSEmpregado
     * @param numeroProxecto
     */
    public void borrarEmpregadoDeProxecto(String NSSEmpregado, int numeroProxecto) {
        String consultaSQL = "DELETE FROM empregado_proxecto WHERE NSS_Empregado = " + NSSEmpregado + " AND Num_proxecto = " + numeroProxecto + "";
        PreparedStatement sentencia = null;

        try {
            sentencia = con.prepareStatement(consultaSQL);
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

    //EXERCICIO 2
    public void mostrarEmpregadosPorLocalidade(String localidade) {
        ArrayList<String> empregados = new ArrayList();

        String consulta = "SELECT e.nome AS Nombre,e.apelido_1 AS Apellido1,e.apelido_2 AS Apellido2,e.localidade AS Localidad,e.salario AS Salario,e.data_nacemento AS FechaNacimiento, "
                + "jefe.nome AS NombreJefe,d.nome_departamento AS NombreDepartamento "
                + "FROM empregado e "
                + "INNER JOIN empregado jefe ON e.nss_supervisa = jefe.NSS "
                + "INNER JOIN departamento d ON e.Num_departamento_pertenece = d.Num_departamento "
                + "WHERE e.localidade = '" + localidade + "'";

        PreparedStatement ps = null;
        ResultSet resultado = null;

        try {
            ps = con.prepareStatement(consulta);
            resultado = ps.executeQuery();
            while (resultado.next()) {
                empregados.add(resultado.getString(1) + " " + resultado.getString(2) + " " + resultado.getString(3) + " " + resultado.getString(4) + " " + resultado.getFloat(5) + " " + resultado.getString(6) + " Nombre Jefe: " + resultado.getString(7) + " " + resultado.getString(8));
            }
            for (String s : empregados) {
                System.out.println(s);
            }
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

    //EXERCICIO 3
    /**
     * Método que cambia el departamento que controla un proxecto
     *
     * @param nombreDepartamento
     * @param nombreProxecto
     * @throws SQLException
     */
    public void cambiarDepartamentoDeProxecto(String nombreDepartamento, String nombreProxecto) throws SQLException {
        String consultaSQL = "UPDATE proxecto p"
                + "INNER JOIN departameto d ON d.nome_departamento = '" + nombreDepartamento + "'"
                + "SET p.numero_departamento = d.num_departamento"
                + "WHERE p.nome_proxecto = '" + nombreProxecto + "'";
        PreparedStatement ps = con.prepareStatement(consultaSQL);
        ps.executeUpdate();

    }

    /**
     * Método que crea un nuevo proxecto;
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
     * Método que borra un proxecto
     *
     * @param num_proxecto
     */
    public void borrarProxecto(int num_proxecto) {
        String consultaDELETE = "DELETE FROM proxecto WHERE Num_proxecto ='" + num_proxecto + "'";
        String consultaDELETE2 = "DELETE FROM empregado_proxecto WHERE Num_proxecto ='" + num_proxecto + "'";
        PreparedStatement ps = null;
        PreparedStatement ps2 = null;
        try {
            ps = con.prepareStatement(consultaDELETE);
            ps = con.prepareStatement(consultaDELETE2);
            ps.executeUpdate();
            ps2.executeUpdate();
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
            if (ps2 != null) {
                try {
                    ps2.close();

                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        }
    }

    //EXERCICIO 4
    /**
     * Método que devuelve una lista de proxectos
     *
     * @param Nombre_departamento
     * @return
     */
    public ArrayList<Proxecto> listaProxectos(String Nombre_departamento) {
        Proxecto p = null;
        ArrayList<Proxecto> proxecto = new ArrayList();
        PreparedStatement ps = null;
        ResultSet resultado = null;
        String consulta = "SELECT * FROM proxecto p INNER JOIN departamento d ON p.Numero_departamento = d.Num_departamento WHERE d.Nome_departamento = '" + Nombre_departamento + "'";
        try {
            ps = con.prepareStatement(consulta);

            resultado = ps.executeQuery();
            while (resultado.next()) {
                p = new Proxecto(resultado.getInt(1), resultado.getString(2), resultado.getString(3), resultado.getInt(4));
                proxecto.add(p);
            }
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

        return proxecto;
    }

    //EXERCICIO 5
    //A
    /**
     * Método que cambia el domicilio de un empleado
     *
     * @param NSS
     * @param rua
     * @param numero
     * @param piso
     * @param CP
     * @param Localidade
     * @throws SQLException
     */
    public void cambioDomicilioEmpleado(String NSS, String rua, int numero, String piso, String CP, String Localidade) throws SQLException {
        String callProcedure = "{call pr_cambioDomicilio(?,?,?,?,?,?)}";
        CallableStatement cs = (CallableStatement) con.prepareCall(callProcedure);
        cs.setString(1, NSS);
        cs.setString(2, rua);
        cs.setInt(3, numero);
        cs.setString(4, piso);
        cs.setString(5, CP);
        cs.setString(6, Localidade);
        cs.execute();

    }

    //B
    /**
     * Método que muestra los datos de un depatamento
     *
     * @param numero
     * @return
     * @throws SQLException
     */
    public Proxecto datosProxecto(int numero) throws SQLException {
        String callProcedure = "{call pr_DatosProxectos(?,?,?,?)}";
        CallableStatement cs = (CallableStatement) con.prepareCall(callProcedure);
        cs.setInt(1, numero);
        cs.execute();
        cs.registerOutParameter(2, Types.VARCHAR);
        cs.registerOutParameter(3, Types.VARCHAR);
        cs.registerOutParameter(4, Types.INTEGER);

        String a = cs.getString(2);
        String b = cs.getString(3);
        int c = cs.getInt(4);

        Proxecto p = new Proxecto(cs.getInt(1), a, b, c);
        return p;
    }

    //C
    /**
     * Método que devuelve los datos de los departamentos que controlan cierto
     * número de proyecto
     *
     * @param numero
     * @throws SQLException
     */
    public void datosDepartamentosControl(int numero) throws SQLException {
        String callProcedure = "{call pr_DepartControlaProxec(?)}";
        CallableStatement cs = (CallableStatement) con.prepareCall(callProcedure);
        cs.setInt(1, numero);
        ResultSet resultado = cs.executeQuery();

        while (resultado.next()) {
            System.out.println(resultado.getString("num_departamento") + " " + resultado.getString("nome_departamento") + " " + resultado.getString("nss_dirige") + " " + resultado.getString("data_direccion"));
        }

    }

    public void funcionCont(String nombre) throws SQLException {
        String consulta = "SELECT fn_DatosProxectos('" + nombre + "')";
        PreparedStatement ps = con.prepareStatement(consulta);
        ResultSet resultado = ps.executeQuery();
        resultado.next();
        System.out.println("Numero de empregados= " + resultado.getString(1));

    }

    public boolean insertarProyecto(Proxecto proxecto) {
        try {

            if (!existeProyecto(proxecto.getNum_proxecto(), proxecto.getNome_proxecto())) {

                if (existeDepartamento(proxecto.getNumero_departamento())) {

                    String sql = "INSERT INTO PROXECTO (Num_proxecto, Nome_proxecto, Lugar, Numero_departamento) VALUES (?, ?, ?, ?)";
                    try (PreparedStatement statement = con.prepareStatement(sql, ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE)) {
                        statement.setInt(1, proxecto.getNum_proxecto());
                        statement.setString(2, proxecto.getNome_proxecto());
                        statement.setString(3, proxecto.getLugar());
                        statement.setInt(4, proxecto.getNumero_departamento());
                        statement.executeUpdate();
                        return true;
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    private boolean existeProyecto(int numProyecto, String nombreProyecto) throws SQLException {
        String sql = "SELECT * FROM PROXECTO";
        try (PreparedStatement statement = con.prepareStatement(sql, ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY)) {
            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    if (resultSet.getInt("Num_proxecto") == numProyecto && resultSet.getString("Nome_proxecto").equals(nombreProyecto)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private boolean existeDepartamento(int numDepartamento) throws SQLException {
        String sql = "SELECT * FROM DEPARTAMENTO WHERE Num_Departamento = ?";
        try (PreparedStatement statement = con.prepareStatement(sql)) {
            statement.setInt(1, numDepartamento);
            try (ResultSet resultSet = statement.executeQuery()) {
                return resultSet.next();
            }
        }
    }
        public void incrementarSueldoDepa(Integer incre, Integer nuDep) {
        try {
            Statement s = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            try (ResultSet rs = s.executeQuery("select nss, salario, num_departamento_pertenece from empregado")) {
                while (rs.next()) {
                    if (nuDep.equals(rs.getInt("num_departamento_pertenece"))) {
                        int salario = rs.getInt("salario");
                        rs.updateInt("salario", salario + incre);
                        rs.updateRow();
                    }
                }
            }

        } catch (SQLException ex) {
            Logger.getLogger(BDManager.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
            public void verDeFormaEnrevesada(int cantProx) {
        try {
            Statement s = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
            ResultSet rs = s.executeQuery("select nombre, localidade, apelido_1, apelida_2, nss, salario, count(p.num_proxecto) as cantPro from empregado e "
                    + "inner join empregado_proxecto ep on nss = nss_empregado "
                    + "inner join proxecto p on p.num_proxecto =  ep.num_proxecto "
                    + "group by e.nss "
                    + "having count(p.num_proxecto) >= " + cantProx);
            
            System.out.println("Primero:");
            rs.beforeFirst();
            rs.next();
            leerRsEmpre(rs, cantProx);
            
            System.out.println("Ultimo:");
            rs.afterLast();
            rs.previous();
            leerRsEmpre(rs, cantProx);
            
            System.out.println("Penultimo:");
            rs.previous();
            leerRsEmpre(rs, cantProx);
            
            System.out.println("Todo a la inversa:");
            rs.afterLast();
            while(rs.previous()){
                leerRsEmpre(rs, cantProx);
            }
        } catch (SQLException ex) {
            Logger.getLogger(BDManager.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    private void leerRsEmpre(ResultSet rs, int cantProx) {
        try {
            if (cantProx <= rs.getInt("cantPro")) {
                String loca = rs.getString("localidade");
                String nome = rs.getString("nombre") + " ," + rs.getString("apelido_1") + ", " + rs.getString("apelida_2");
                String nss = rs.getString("nss");
                String salario = rs.getString("salario");
                System.out.println("Nss: " + nss);
                System.out.println("Nome: " + nome);
                System.out.println("Localidade: " + loca);
                System.out.println("Salario: " + salario);
                System.out.println("--------------------------");
            }
        } catch (SQLException ex) {
            System.out.println("No existe.");
        }
    }
}
