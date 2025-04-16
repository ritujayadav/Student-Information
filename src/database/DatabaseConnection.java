package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {

    private static final String DB_URL = "jdbc:mysql://localhost:3306/ssid";
    private static final String USER = "root"; 
    private static final String PASSWORD = "yadav2003"; 

    public static Connection getConnection() throws SQLException {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver"); 
            return DriverManager.getConnection(DB_URL, USER, PASSWORD); 
        } catch (ClassNotFoundException | SQLException e) {
            throw new SQLException("Error while establishing database connection.", e);
        }
    }
}
