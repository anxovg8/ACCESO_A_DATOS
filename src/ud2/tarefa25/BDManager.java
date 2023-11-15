/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ud2.tarefa25;

import BD.Conectores;
import com.mysql.cj.jdbc.DatabaseMetaData;
import com.mysql.cj.jdbc.result.ResultSetMetaData;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.ResultSet;
import java.sql.PreparedStatement;

/**
 *
 * @author node
 */
public class BDManager {

    private Connection con;
    private Statement stmt;
    private DatabaseMetaData dmd;

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
     * Método que muestra la información de los metadatos
     *
     * @throws SQLException
     */
    public void mostrarInformacion() throws SQLException {

        this.dmd = (DatabaseMetaData) con.getMetaData();
        String nomeSXBD = dmd.getDatabaseProductName();
        String nVersionSXBD = dmd.getDatabaseProductVersion();
        int nVersionPrincipal = dmd.getDatabaseMajorVersion();
        int nVersionSecundaria = dmd.getDatabaseMinorVersion();
        String nomeConector = dmd.getDriverName();
        int numVersionPrincipalConector = dmd.getDriverMajorVersion();
        int numVersionSecundariaConector = dmd.getDriverMinorVersion();
        String nomeVersionConector = dmd.getDriverVersion();
        String url = dmd.getURL();
        String nomeUser = dmd.getUserName();
        boolean lectura = dmd.isReadOnly();

        System.out.println("Nome SXBD: " + nomeSXBD);
        System.out.println("Numero version SXBD: " + nVersionSXBD);
        System.out.println("Numero version principal: " + nVersionPrincipal);
        System.out.println("Numero version secundaria: " + nVersionSecundaria);
        System.out.println("Nome conector: " + nomeConector);
        System.out.println("Numero version principal conector: " + numVersionPrincipalConector);
        System.out.println("Numero version secundaria conector: " + numVersionSecundariaConector);
        System.out.println("Nome version conector: " + nomeVersionConector);
        System.out.println("URL: " + url);
        System.out.println("Nome de usuario: " + nomeUser);
        System.out.println("lectura? " + lectura);

    }

    //EXERCICIO 2
    /**
     * Método que muertra la información de las tablas de la BBDD bdempresa
     *
     * @throws SQLException
     */
    public void mostrarInfoTablas() throws SQLException {

        this.dmd = (DatabaseMetaData) con.getMetaData();
        String[] tipos = new String[2];
        tipos[0] = "TABLE";
        tipos[1] = "SYSTEM TABLE";
        ResultSet tablas = dmd.getTables("bdempresa", null, "%", tipos);
        while (tablas.next()) {
            System.out.println("NOMBRE: " + tablas.getString("TABLE_NAME") + " TIPO: " + tablas.getString("TABLE_TYPE") + " ESQUEMA: " + tablas.getString("TABLE_SCHEM") + " CATÁLOGO: " + tablas.getString("TABLE_CAT"));

        }
    }

    /**
     * Método que muestra los datos de una tabla
     *
     * @param nombreSquema
     * @param nombreTabla
     * @throws SQLException
     */
    public void datosTabla(String nombreSquema, String nombreTabla) throws SQLException {
        this.dmd = (DatabaseMetaData) con.getMetaData();

        ResultSet tablas = dmd.getColumns("bdempresa", nombreSquema, nombreTabla, "%");

        System.out.println(nombreTabla);
        while (tablas.next()) {

            String nomCol = tablas.getString("COLUMN_NAME");
            String tipoDatos = tablas.getString("TYPE_NAME");
            int tamanhoCol = tablas.getInt("COLUMN_SIZE");
            boolean isNullable = tablas.getInt("NULLABLE") == DatabaseMetaData.columnNullable;

            System.out.println("NOMBRE COLUMNA: " + nomCol + " TIPO DATOS: " + tipoDatos + " TAMAÑO COLUMNA: " + tamanhoCol + " ES NULL: " + isNullable);

        }
    }

    /**
     * Método que muestra procedimientos
     *
     * @throws SQLException
     */
    public void infoProcedures() throws SQLException {
        this.dmd = (DatabaseMetaData) con.getMetaData();
        ResultSet procedures = dmd.getProcedures("bdempresa", null, "%");

        while (procedures.next()) {
            String nomPro = procedures.getString("PROCEDURE_NAME");
            String squema = procedures.getString("PROCEDURE_SCHEM");
            String catalogo = procedures.getString("PROCEDURE_CAT");
            short tipoP = procedures.getShort("PROCEDURE_TYPE");

            System.out.println("NOMBRE: " + nomPro + " SQUEMA: " + squema + " CATALOGO: " + catalogo + " TIPO: " + tipoP);
            System.out.println("\n");

        }

    }

    /**
     * Método que muestra las primary keys de una tabla
     *
     * @param nombreSquema
     * @param nombreTabla
     * @throws SQLException
     */
    public void clavesPrimarias(String nombreSquema, String nombreTabla) throws SQLException {
        this.dmd = (DatabaseMetaData) con.getMetaData();

        ResultSet tablas = dmd.getExportedKeys("bdempresa", nombreSquema, nombreTabla);
        System.out.println(nombreTabla);
        while (tablas.next()) {
            String nomeCol = tablas.getString("PKCOLUMN_NAME");
            System.out.println("Clave primaria " + nomeCol);

        }
    }

    /**
     * Método que muestra las foreign keys de una tabla
     *
     * @param nombreSquema
     * @param nombreTabla
     * @throws SQLException
     */
    public void clavesForaneas(String nombreSquema, String nombreTabla) throws SQLException {
        this.dmd = (DatabaseMetaData) con.getMetaData();

        ResultSet tablas = dmd.getImportedKeys("bdempresa", nombreSquema, nombreTabla);

        System.out.println(nombreTabla);

        while (tablas.next()) {
            String nameTableFK = tablas.getString("FKTABLE_NAME");
            String nameColFK = tablas.getString("FKCOLUMN_NAME");
            String nameTableFK2 = tablas.getString("PKTABLE_NAME");
            String nameColFK2 = tablas.getString("PKCOLUMN_NAME");
            System.out.println("NOME TABLA REFERENCIA: " + nameTableFK + " COLUMNA CLAVE FORANEA: " + nameColFK + "\nTABLA REFERENCIA " + nameTableFK2 + " PRIMARY KEY REFERENCIA " + nameColFK2);
        }

    }

    //EXERCICIO 3
    /**
     * Método que devuelve la informacion de las funciones
     *
     * @throws SQLException
     */
    public void infoFunciones() throws SQLException {
        this.dmd = (DatabaseMetaData) con.getMetaData();

        String funCAD = dmd.getCatalogSeparator();
        String funTime = dmd.getTimeDateFunctions();
        String funMath = dmd.getNumericFunctions();
        String funReservadas = dmd.getSQLKeywords();
        String funDelimitar = dmd.getIdentifierQuoteString();
        String funComodin = dmd.getSearchStringEscape();
        boolean llamarPro = dmd.allProceduresAreCallable();
        boolean seleccionTable = dmd.allTablesAreSelectable();

        System.out.println("Funciones de cadena: " + funCAD);
        System.out.println("Funciones data e hora: " + funTime);
        System.out.println("Funciones matematicas: " + funMath);
        System.out.println("Funciones con palabras reservadas: " + funReservadas);
        System.out.println("Funciones que delimitan: " + funDelimitar);
        System.out.println("Funciones comodin:" + funComodin);
        System.out.println("Callable procedures: " + llamarPro);
        System.out.println("Seleccionar Tablas: " + seleccionTable);

    }

    //EXERCICIO 4 
    public void limitesConectores() throws SQLException {
        this.dmd = (DatabaseMetaData) con.getMetaData();

        int conexionesSimul = dmd.getMaxConnections();
        int sentenciasSimul = dmd.getMaxStatements();
        int numMaxTablesSelect = dmd.getMaxTablesInSelect();
        int longMaxTableName = dmd.getMaxTableNameLength();
        int longMaxColName = dmd.getMaxColumnNameLength();
        int longMaxSentenceName = dmd.getMaxStatementLength();
        int longNomPro = dmd.getMaxProcedureNameLength();
        int longFila = dmd.getMaxRowSize();

        System.out.println("Conexiones simultaneas: " + conexionesSimul);
        System.out.println("Sentencias simultaneas: " + sentenciasSimul);
        System.out.println("Numero máximo de tablas en un select: " + numMaxTablesSelect);
        System.out.println("Longitud máxima nome tabla: " + longMaxTableName);
        System.out.println("Longitud máxima nome COLUMNA: " + longMaxColName);
        System.out.println("Longitud máxima nome SENTENCIA: " + longMaxSentenceName);
        System.out.println("Longitud máxima nome PROCEDURE: " + longNomPro);
        System.out.println("Longitud máxima nome FILA: " + longFila);
        System.out.println("GROUP BY: " + dmd.getMaxColumnsInGroupBy());
        System.out.println("SELECT: " + dmd.getMaxColumnsInSelect());
        System.out.println("ORDER BY: " + dmd.getMaxColumnsInOrderBy());
    }

    //EXERCICIO 5
    public void infoTranssacciones() throws SQLException {
        this.dmd = (DatabaseMetaData) con.getMetaData();
        System.out.println("Soporta transacciones? " + dmd.supportsTransactions());
        System.out.println("Aislamiento: " + dmd.getDefaultTransactionIsolation());
        System.out.println("soportan"
                + "sentenzas de manipulación de datos e de definición de datos dentro das transaccións? " + dmd.supportsDataDefinitionAndDataManipulationTransactions());
    }

    //EXERCICIO 6
    public void infoSoporteCaracteristicas() throws SQLException {
        this.dmd = (DatabaseMetaData) con.getMetaData();

        System.out.println("soportada a orde ALTER TABLE con ADD COLUMN: " + dmd.supportsAlterTableWithAddColumn());
        System.out.println("AS? " + dmd.supportsColumnAliasing());
        System.out.println("NULL NOT NULL: " + dmd.nullPlusNonNullIsNull());
        System.out.println("Soporta conversacions entre tipos de datos? " + dmd.supportsConvert());
        System.out.println("soportan os nomes de táboas  correlacionadas" + dmd.supportsTableCorrelationNames());
        System.out.println("soporta  o  uso  dunha  columna  que  non  está  na  instrución  SELECT"
                + "nunha  cláusula  ORDER  BY" + dmd.supportsOrderByUnrelated());
        System.out.println(" soporta  a  cláusula  GROUP  BY" + dmd.supportsGroupBy());
        System.out.println(" admite  o  uso  dunha "
                + "columna  que  non  está  na  instrución  SELECT  nunha  cláusula  GROUP  BY" + dmd.supportsGroupByUnrelated());
        System.out.println("soportan  as cláusulas LIKE" + dmd.supportsLikeEscapeClause());
        System.out.println("soportan os outer joins:" + dmd.supportsOuterJoins());
        System.out.println("EXIST" + dmd.supportsSubqueriesInExists());
        System.out.println("IN" + dmd.supportsSubqueriesInIns());
        System.out.println("expresións cuantificadas" + dmd.supportsSubqueriesInQuantifieds());

    }

    //EXERCICIO 7
    public void infoConsulta(String consulta) throws SQLException {
        this.dmd = (DatabaseMetaData) con.getMetaData();
        PreparedStatement ps = con.prepareStatement(consulta);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            ResultSetMetaData rsmd = (ResultSetMetaData) rs.getMetaData();
            int numColumnas = rsmd.getColumnCount();
            System.out.println("Numero de columnas recuperadas: " + rsmd.getColumnCount());
            for (int i = 1; i <= numColumnas; i++) {
                System.out.println("Columna " + i + ":");
                System.out.println("  Nome: " + rsmd.getColumnName(i));
                System.out.println("  Tipo: " + rsmd.getColumnTypeName(i));
                System.out.println("  Tamaño: " + rsmd.getColumnDisplaySize(i));
                System.out.println("  Admite nulos: " + (rsmd.isNullable(i) == ResultSetMetaData.columnNullable ? "Si" : "Non"));
                System.out.println();
            }
        }

    }
}
