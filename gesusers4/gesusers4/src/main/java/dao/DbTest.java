package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DbTest {
    public static void main(String[] args) {
        try {
            // Chargement du driver JDBC
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Connexion à la base de données
            Connection connection = DriverManager.getConnection(
                "jdbc:mysql://localhost/tp_php?useSSL=false&serverTimezone=UTC", 
                "root", // Remplace par ton nom d'utilisateur
                ""      // Remplace par ton mot de passe si nécessaire
            );

            // Création d'un statement
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM utilisateur");

            // Parcours des résultats
            while (resultSet.next()) {
                System.out.println("ID : " + resultSet.getInt("id"));
                System.out.println("Nom : " + resultSet.getString("nom"));
                System.out.println("Prénom : " + resultSet.getString("prenom"));
                System.out.println("Login : " + resultSet.getString("login"));
                System.out.println("Password : " + resultSet.getString("password"));
                System.out.println("=====================================");
            }

            // Fermeture des ressources
            resultSet.close();
            statement.close();
            connection.close();
            
        } catch (ClassNotFoundException e) {
            System.err.println("Erreur : Pilote JDBC introuvable !");
            e.printStackTrace();
        } catch (SQLException e) {
            System.err.println("Erreur SQL : " + e.getMessage());
            e.printStackTrace();
        }
    }
}
