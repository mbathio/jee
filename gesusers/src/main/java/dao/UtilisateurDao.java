package dao;

import java.util.ArrayList;

import beans.Utilisateur;

public class UtilisateurDao
{
    private static int nextId = 1;
    private static final ArrayList<Utilisateur> utilisateurs = new ArrayList<Utilisateur>();
    
    public static ArrayList<Utilisateur> lister()
    {
        return utilisateurs;
    }
    
    public static boolean ajouter(Utilisateur utilisateur)
    {
        utilisateur.setId(nextId++);
        utilisateurs.add(utilisateur);
        return true;
    }
    
    public static boolean supprimer(int id)
    {
        for (int i = 0; i < utilisateurs.size(); i++) {
            if (utilisateurs.get(i).getId() == id) {
                utilisateurs.remove(i);
                return true;
            }
        }
        return false;
    }
    
    public static Utilisateur trouver(int id)
    {
        for (Utilisateur utilisateur : utilisateurs) {
            if (utilisateur.getId() == id) {
                return utilisateur;
            }
        }
        return null;
    }
    
    public static boolean modifier(Utilisateur utilisateur)
    {
        for (int i = 0; i < utilisateurs.size(); i++) {
            if (utilisateurs.get(i).getId() == utilisateur.getId()) {
                utilisateurs.set(i, utilisateur);
                return true;
            }
        }
        return false;
    }
}