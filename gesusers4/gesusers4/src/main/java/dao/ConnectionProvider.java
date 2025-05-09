package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionProvider {

    public static Connection getInstance() throws SQLException {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/tp_php", "root", "");

            return connection;
        } catch (ClassNotFoundException e) {
            System.err.println("errreur de Chargement");;
        }

        return null;
    }
}
