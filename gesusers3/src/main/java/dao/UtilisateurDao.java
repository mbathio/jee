package dao;

import java.util.ArrayList;
import beans.Utilisateur;

public class UtilisateurDao {
    
    private static int nextId = 1;
    private static final ArrayList<Utilisateur> utilisateurs = new ArrayList<Utilisateur>();
    
    static {
        // Ajouter quelques utilisateurs de test
        ajouter(new Utilisateur("Dupont", "Jean", "jdupont", "password123"));
        ajouter(new Utilisateur("Martin", "Sophie", "smartin", "password456"));
    }
    
    // Récupérer tous les utilisateurs
    public static ArrayList<Utilisateur> lister() {
        return utilisateurs;
    }
    
    // Ajouter un utilisateur
    public static boolean ajouter(Utilisateur utilisateur) {
        utilisateur.setId(nextId++);
        utilisateurs.add(utilisateur);
        return true;
    }
    
    // Supprimer un utilisateur
    public static boolean supprimer(int id) {
        for (int i = 0; i < utilisateurs.size(); i++) {
            if (utilisateurs.get(i).getId() == id) {
                utilisateurs.remove(i);
                return true;
            }
        }
        return false;
    }
    
    // Trouver un utilisateur par son ID
    public static Utilisateur trouver(int id) {
        for (Utilisateur utilisateur : utilisateurs) {
            if (utilisateur.getId() == id) {
                return utilisateur;
            }
        }
        return null;
    }
    
    // Modifier un utilisateur
    public static boolean modifier(Utilisateur utilisateur) {
        for (int i = 0; i < utilisateurs.size(); i++) {
            if (utilisateurs.get(i).getId() == utilisateur.getId()) {
                utilisateurs.set(i, utilisateur);
                return true;
            }
        }
        return false;
    }
}