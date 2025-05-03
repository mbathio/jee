package dao;

import java.util.ArrayList;

import beans.Utilisateur;

public class UtilisateurDao 
{
	
	private static int nexId=1;
	
	private static final ArrayList<Utilisateur> utilisateurs = new ArrayList<Utilisateur>();
	
	//static {
		//utilisateurs.add(new Utilisateur(nexId, "assad", "Ahmed", "AssadAhmed", "Assad77109"));
	//	utilisateurs.add(new Utilisateur(nexId, "abdou", "Ahmed", "abdouAhmed", "Abdou771"));
	//}

	public static ArrayList<Utilisateur> lister()
	{
		return utilisateurs;
		
	}
	
	public static boolean ajouter(Utilisateur utilisateur)
	{
		utilisateur.setId(nexId++);
		utilisateurs.add(utilisateur);
		return true;
		
	}

	public static boolean supprimer(int id) {
		
		for (Utilisateur utilisateur : utilisateurs) {
			if(utilisateur.getId()== id) {
				utilisateurs.remove(utilisateur);
				return true;
			}
			
		}
		return false;
		
	}
	
public static boolean modifier(Utilisateur updateUser) 
{
		
		for (Utilisateur utilisateur : utilisateurs) 
		{
			if(utilisateur.getId()== updateUser.getId()) 
			{
			  utilisateur.setNom(updateUser.getNom());
			  utilisateur.setPrenom(updateUser.getPrenom());
			  utilisateur.setLogin(updateUser.getLogin());
			  utilisateur.setPassword(updateUser.getPassword());
				return true;
			}
			
		}
		return false;
		
		
	}

public static Utilisateur get(int id) {
	
	for (Utilisateur utilisateur : utilisateurs) {
		if(utilisateur.getId()== id) {
			
			return utilisateur;
		}
		
	}
	return null;
	
}
}
