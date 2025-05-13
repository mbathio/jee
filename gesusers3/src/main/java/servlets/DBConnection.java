package servlets;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
    // Paramètres de connexion à la base de données
    private static final String URL = "jdbc:mysql://localhost:3306/gesusers";
    private static final String USER = "root";
    private static final String PASSWORD = "";
    
    // Instance unique de la connexion
    private static Connection connection = null;
    
    // Empêcher l'instanciation directe
    private DBConnection() {}
    
    // Méthode pour obtenir la connexion
    public static Connection getConnection() throws SQLException, ClassNotFoundException {
        if (connection == null || connection.isClosed()) {
            try {
                // Charger le driver JDBC
                Class.forName("com.mysql.cj.jdbc.Driver");
                
                // Établir la connexion
                connection = DriverManager.getConnection(URL, USER, PASSWORD);
            } catch (ClassNotFoundException e) {
                System.err.println("Driver JDBC MySQL introuvable : " + e.getMessage());
                throw e;
            } catch (SQLException e) {
                System.err.println("Erreur de connexion à la base de données : " + e.getMessage());
                throw e;
            }
        }
        return connection;
    }
    
    // Méthode pour fermer la connexion
    public static void closeConnection() {
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                System.err.println("Erreur lors de la fermeture de la connexion : " + e.getMessage());
            }
        }
    }
}