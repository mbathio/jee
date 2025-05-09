package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import servlets.DBConnection;
import beans.Utilisateur;

public class UtilisateurDao {
    
    // Récupérer tous les utilisateurs
    public static ArrayList<Utilisateur> lister() {
        ArrayList<Utilisateur> utilisateurs = new ArrayList<>();
        
        try {
            Connection conn = DBConnection.getConnection();
            Statement statement = conn.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM utilisateurs ORDER BY id");
            
            while (resultSet.next()) {
                Utilisateur utilisateur = new Utilisateur();
                utilisateur.setId(resultSet.getInt("id"));
                utilisateur.setNom(resultSet.getString("nom"));
                utilisateur.setPrenom(resultSet.getString("prenom"));
                utilisateur.setLogin(resultSet.getString("login"));
                utilisateur.setPassword(resultSet.getString("password"));
                
                utilisateurs.add(utilisateur);
            }
            
            resultSet.close();
            statement.close();
            
        } catch (SQLException | ClassNotFoundException e) {
            System.err.println("Erreur lors de la récupération des utilisateurs : " + e.getMessage());
        }
        
        return utilisateurs;
    }
    
    // Ajouter un utilisateur
    public static boolean ajouter(Utilisateur utilisateur) {
        boolean success = false;
        
        try {
            Connection conn = DBConnection.getConnection();
            String query = "INSERT INTO utilisateurs (nom, prenom, login, password) VALUES (?, ?, ?, ?)";
            PreparedStatement ps = conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            
            ps.setString(1, utilisateur.getNom());
            ps.setString(2, utilisateur.getPrenom());
            ps.setString(3, utilisateur.getLogin());
            ps.setString(4, utilisateur.getPassword());
            
            int result = ps.executeUpdate();
            
            if (result > 0) {
                // Récupérer l'ID généré automatiquement
                ResultSet generatedKeys = ps.getGeneratedKeys();
                if (generatedKeys.next()) {
                    utilisateur.setId(generatedKeys.getInt(1));
                    success = true;
                }
                generatedKeys.close();
            }
            
            ps.close();
            
        } catch (SQLException | ClassNotFoundException e) {
            System.err.println("Erreur lors de l'ajout de l'utilisateur : " + e.getMessage());
        }
        
        return success;
    }
    
    // Supprimer un utilisateur
    public static boolean supprimer(int id) {
        boolean success = false;
        
        try {
            Connection conn = DBConnection.getConnection();
            String query = "DELETE FROM utilisateurs WHERE id = ?";
            PreparedStatement ps = conn.prepareStatement(query);
            
            ps.setInt(1, id);
            
            int result = ps.executeUpdate();
            success = (result > 0);
            
            ps.close();
            
        } catch (SQLException | ClassNotFoundException e) {
            System.err.println("Erreur lors de la suppression de l'utilisateur : " + e.getMessage());
        }
        
        return success;
    }
    
    // Trouver un utilisateur par son ID
    public static Utilisateur trouver(int id) {
        Utilisateur utilisateur = null;
        
        try {
            Connection conn = DBConnection.getConnection();
            String query = "SELECT * FROM utilisateurs WHERE id = ?";
            PreparedStatement ps = conn.prepareStatement(query);
            
            ps.setInt(1, id);
            
            ResultSet resultSet = ps.executeQuery();
            
            if (resultSet.next()) {
                utilisateur = new Utilisateur();
                utilisateur.setId(resultSet.getInt("id"));
                utilisateur.setNom(resultSet.getString("nom"));
                utilisateur.setPrenom(resultSet.getString("prenom"));
                utilisateur.setLogin(resultSet.getString("login"));
                utilisateur.setPassword(resultSet.getString("password"));
            }
            
            resultSet.close();
            ps.close();
            
        } catch (SQLException | ClassNotFoundException e) {
            System.err.println("Erreur lors de la recherche de l'utilisateur : " + e.getMessage());
        }
        
        return utilisateur;
    }
    
    // Modifier un utilisateur
    public static boolean modifier(Utilisateur utilisateur) {
        boolean success = false;
        
        try {
            Connection conn = DBConnection.getConnection();
            String query = "UPDATE utilisateurs SET nom = ?, prenom = ?, login = ?, password = ? WHERE id = ?";
            PreparedStatement ps = conn.prepareStatement(query);
            
            ps.setString(1, utilisateur.getNom());
            ps.setString(2, utilisateur.getPrenom());
            ps.setString(3, utilisateur.getLogin());
            ps.setString(4, utilisateur.getPassword());
            ps.setInt(5, utilisateur.getId());
            
            int result = ps.executeUpdate();
            success = (result > 0);
            
            ps.close();
            
        } catch (SQLException | ClassNotFoundException e) {
            System.err.println("Erreur lors de la modification de l'utilisateur : " + e.getMessage());
        }
        
        return success;
    }
}