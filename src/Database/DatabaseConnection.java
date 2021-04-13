package Database;

import java.sql.*;

public class DatabaseConnection {
    private final String DBNAME = "QuatroOpdracht";
    private final String USER = "sa";
    private final String PASSWORD = "12345";
    private final String PORTNR = "1433";

    private Statement stmt = null;
    private Connection con = null;
    private ResultSet rs;

    public ResultSet selectSqlStatement(String SQL) {
        try {
            con = getConnection();
            if (con != null) {
                stmt = con.createStatement();
                rs = stmt.executeQuery(SQL);
                return rs;
            }
        } catch (Exception ignored) {
        }
        return null;
    }

    public void insertSqlStatement(String SQL) {
        try {
            con = getConnection();
            if (con != null) {
                stmt = con.createStatement();
                stmt.executeQuery(SQL);
            }
        } catch (Exception ignored) {
        } finally {
            closeConnection();
        }
    }

    public int updateSqlStatement(String SQL) {
        try {
            con = getConnection();
            if (con != null) {
                stmt = con.createStatement();
                return stmt.executeUpdate(SQL);
            }
        } catch (Exception ignored) {
        } finally {
            closeConnection();
        }
        return 0;
    }

    public Connection getConnection() throws ClassNotFoundException, SQLException {
        String URL = "jdbc:sqlserver://localhost\\SQLEXPRESS;databaseName=" + DBNAME + ";user=" + USER + ";password=" + PASSWORD + ";portNumber=" + PORTNR + ";";
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        return DriverManager.getConnection(URL);
    }

    public void closeConnection() {
        if (rs != null) try {
            rs.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (stmt != null) try {
            stmt.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (con != null) try {
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
