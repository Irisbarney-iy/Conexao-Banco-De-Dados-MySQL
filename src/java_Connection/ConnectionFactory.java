package java_Connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
    public static Connection createConnection() throws SQLException {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new SQLException("Driver não encontrado: " + e.getMessage());
        }

        String url = "jdbc:mysql://localhost:3306/meu_trabalho"; 
        String user = "root"; 
        String password = "root2204"; 

        return DriverManager.getConnection(url, user, password);
    }
}