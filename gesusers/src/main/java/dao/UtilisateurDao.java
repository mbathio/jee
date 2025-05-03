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
} 