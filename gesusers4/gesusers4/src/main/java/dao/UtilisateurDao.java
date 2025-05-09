package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import beans.Utilisateur;

public class UtilisateurDao {
    
    private static final String CREATE_USER_PSQL = "INSERT INTO utilisateur (nom, prenom, login, password) VALUES (?, ?, ?, ?)";
    private static final String DELETE_USER_PSQL = "DELETE FROM utilisateur WHERE id = ?";
    private static final String UPDATE_USER_PSQL = "UPDATE utilisateur SET nom = ?, prenom = ?, login = ?, password = ? WHERE id = ?";
    private static final String GET_USER_PSQL = "SELECT * FROM utilisateur WHERE id = ?";
    
    public static List<Utilisateur> lister() {
        List<Utilisateur> utilisateurs = new ArrayList<>();
        String SQL = "SELECT * FROM utilisateur";

        try (Connection connection = ConnectionProvider.getInstance();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(SQL)) {

            while (resultSet.next()) {
                Utilisateur utilisateur = new Utilisateur(
                    resultSet.getInt("id"),
                    resultSet.getString("nom"),
                    resultSet.getString("prenom"),
                    resultSet.getString("login"),
                    resultSet.getString("password")
                );
                utilisateurs.add(utilisateur);
            }
        } catch (SQLException e) {
            System.err.println("Erreur lors de la récupération des utilisateurs : " + e.getMessage());
        }
        return utilisateurs;
    }

    public static boolean ajouter(Utilisateur utilisateur) {
        try (Connection connection = ConnectionProvider.getInstance();
             PreparedStatement preparedStatement = connection.prepareStatement(CREATE_USER_PSQL)) {

            preparedStatement.setString(1, utilisateur.getNom());
            preparedStatement.setString(2, utilisateur.getPrenom());
            preparedStatement.setString(3, utilisateur.getLogin());
            preparedStatement.setString(4, utilisateur.getPassword());

            return preparedStatement.executeUpdate() == 1;
        } catch (SQLException e) {
            System.err.println("Erreur lors de l'ajout de l'utilisateur : " + e.getMessage());
            return false;
        }
    }

    public static boolean supprimer(int id) {
        try (Connection connection = ConnectionProvider.getInstance();
             PreparedStatement preparedStatement = connection.prepareStatement(DELETE_USER_PSQL)) {

            preparedStatement.setInt(1, id);
            return preparedStatement.executeUpdate() == 1;
        } catch (SQLException e) {
            System.err.println("Erreur lors de la suppression de l'utilisateur : " + e.getMessage());
            return false;
        }
    }

    public static boolean modifier(Utilisateur updateUser) {
        try (Connection connection = ConnectionProvider.getInstance();
             PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_USER_PSQL)) {

            preparedStatement.setString(1, updateUser.getNom());
            preparedStatement.setString(2, updateUser.getPrenom());
            preparedStatement.setString(3, updateUser.getLogin());
            preparedStatement.setString(4, updateUser.getPassword());
            preparedStatement.setInt(5, updateUser.getId());

            return preparedStatement.executeUpdate() == 1;
        } catch (SQLException e) {
            System.err.println("Erreur lors de la modification de l'utilisateur : " + e.getMessage());
            return false;
        }
    }

    public static Utilisateur get(int id) {
        try (Connection connection = ConnectionProvider.getInstance();
             PreparedStatement preparedStatement = connection.prepareStatement(GET_USER_PSQL)) {

            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                return new Utilisateur(
                    resultSet.getInt("id"),
                    resultSet.getString("nom"),
                    resultSet.getString("prenom"),
                    resultSet.getString("login"),
                    resultSet.getString("password")
                );
            }
        } catch (SQLException e) {
            System.err.println("Erreur lors de la récupération de l'utilisateur : " + e.getMessage());
        }
        return null;
    }

    public static Utilisateur get(String login) {
        String SQL = "SELECT * FROM utilisateur WHERE login = ?";

        try (Connection connection = ConnectionProvider.getInstance();
             PreparedStatement preparedStatement = connection.prepareStatement(SQL)) {

            preparedStatement.setString(1, login);
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                return new Utilisateur(
                    resultSet.getInt("id"),
                    resultSet.getString("nom"),
                    resultSet.getString("prenom"),
                    resultSet.getString("login"),
                    resultSet.getString("password")
                );
            }
        } catch (SQLException e) {
            System.err.println("Erreur lors de la récupération de l'utilisateur : " + e.getMessage());
        }
        return null;
    }

}
