package beans;

public class Utilisateur {
 private int id;
 private String nom, prenom, password, login;
 
public Utilisateur(int id, String nom, String prenom, String password, String login) {
	super();
	this.id = id;
	this.nom = nom;
	this.prenom = prenom;
	this.password = password;
	this.login = login;
}



public Utilisateur(String nom, String prenom, String password, String login) {
	this.nom = nom;
	this.prenom = prenom;
	this.password = password;
	this.login = login;
}



public Utilisateur() {
	
}

public int getId() {
	return id;
}

public void setId(int id) {
	this.id = id;
}

public String getNom() {
	return nom;
}

public void setNom(String nom) {
	this.nom = nom;
}

public String getPrenom() {
	return prenom;
}

public void setPrenom(String prenom) {
	this.prenom = prenom;
}

public String getPassword() {
	return password;
}

public void setPassword(String password) {
	this.password = password;
}

public String getLogin() {
	return login;
}

public void setLogin(String login) {
	this.login = login;
}
 

 
}
