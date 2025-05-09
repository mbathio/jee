package forms;

import java.util.HashMap;
import java.util.Map;

import beans.Utilisateur;
import dao.UtilisateurDao;
import jakarta.servlet.http.HttpServletRequest;

public class UserForm {
    private static final String CHAMP_ID = "id";
    private static final String CHAMP_NOM = "nom";
    private static final String CHAMP_PRENOM = "prenom";
    private static final String CHAMP_LOGIN = "login";
    private static final String CHAMP_PASSWORD = "password";
    private static final String CHAMP_PASSWORD_BIS = "passwordBis";
    private static final String EMPTY_FIELD_MESSAGE = "Vous devez renseigner ces champs";
    private static final String DIFFERENT_PASSWORDS_MESSAGE = "Les mots de passe ne sont pas identiques";
    private static final String ADD_USER_SUCCESS_MESSAGE = "L'ajout a été effectué avec succès";
    private static final String ADD_USER_FAILLURE_MESSAGE = "Échec de l'ajout";
    private static final String ADD_UTILISATEUR = "Utilisateur Introuvable";
    private static final String UPDATE_USER_SUCCESS_MESSAGE = "Modification réussie";
    private static final String UPDATE_USER_FAILLURE_MESSAGE = "Échec de la modification";
    
    private boolean status;
    private String statusMessage;
    private Utilisateur utilisateur;
    private Map<String, String> erreurs;
    private HttpServletRequest request;
    
    public UserForm(HttpServletRequest request) {
        this.request = request;
        this.erreurs = new HashMap<String, String>();
    }
    
    public boolean ajouter() {
        String nom = this.getParameter(CHAMP_NOM);
        String prenom = this.getParameter(CHAMP_PRENOM);
        String login = this.getParameter(CHAMP_LOGIN);
        String password = this.getParameter(CHAMP_PASSWORD);
        
        this.status = false;
        this.utilisateur = new Utilisateur(nom, prenom, login, password);
        
        this.validerChamp(CHAMP_NOM, CHAMP_PRENOM, CHAMP_LOGIN, CHAMP_PASSWORD, CHAMP_PASSWORD_BIS);
        this.validerPassword();
        
        if(this.erreurs.isEmpty()) {
            this.status = UtilisateurDao.ajouter(utilisateur);
            this.statusMessage = this.status ? ADD_USER_SUCCESS_MESSAGE : ADD_USER_FAILLURE_MESSAGE;
        }
        return this.status;
    }
    
    public boolean modifie() {
        String id = request.getParameter(CHAMP_ID);
        this.status = false;
        
        // Validate ID and get user
        if(id != null && id.matches("\\d+")) {
            this.utilisateur = UtilisateurDao.get(Integer.parseInt(id));
        }
        
        // Check if user exists
        if(this.utilisateur == null) {
            this.statusMessage = ADD_UTILISATEUR;
            return false;
        }
        
        String nom = this.getParameter(CHAMP_NOM);
        String prenom = this.getParameter(CHAMP_PRENOM);
        String login = this.getParameter(CHAMP_LOGIN);
        String password = this.getParameter(CHAMP_PASSWORD);
        String passwordBis = this.getParameter(CHAMP_PASSWORD_BIS);
        
        this.validerChamp(CHAMP_NOM, CHAMP_PRENOM, CHAMP_LOGIN, CHAMP_PASSWORD, CHAMP_PASSWORD_BIS);
        this.validerPassword();
        
        if(this.erreurs.isEmpty()) {
            this.utilisateur.setNom(nom);
            this.utilisateur.setPrenom(prenom);
            this.utilisateur.setLogin(login);
            this.utilisateur.setPassword(password);
            
            this.status = UtilisateurDao.modifier(utilisateur);
            this.statusMessage = this.status ? UPDATE_USER_SUCCESS_MESSAGE : UPDATE_USER_FAILLURE_MESSAGE;
        }
        
        return this.status;
    }
    
    public boolean supprimer() {
        return UserForm.supprimer(request);
    }
    
    public static boolean supprimer(HttpServletRequest request) {
        String id = request.getParameter(CHAMP_ID);
        
        if(id != null && id.matches("\\d+")) {
            return UtilisateurDao.supprimer(Integer.parseInt(id));
        }
        return false;
    }
    
    private String getParameter(String parameter) {
        String value = request.getParameter(parameter);
        return (value == null || value.isBlank()) ? null : value.trim();
    }
    
    private void validerChamp(String... champs) {
        for (String champ : champs) {
            if(this.getParameter(champ) == null) {
                this.erreurs.put(champ, EMPTY_FIELD_MESSAGE);
            }
        }
    }
    
    private void validerPassword() {
        String password = this.getParameter(CHAMP_PASSWORD);
        String passwordBis = this.getParameter(CHAMP_PASSWORD_BIS);
        
        if(password != null && !password.equals(passwordBis)) {
            this.erreurs.put(CHAMP_PASSWORD, DIFFERENT_PASSWORDS_MESSAGE);
            this.erreurs.put(CHAMP_PASSWORD_BIS, DIFFERENT_PASSWORDS_MESSAGE);
        }
    }
    
    public Utilisateur getUtilisateur() {
        return utilisateur;
    }
    
    public Map<String, String> getErreurs() {
        return erreurs;
    }
    
    public boolean isStatus() {
        return status;
    }
    
    public String getStatusMessage() {
        return statusMessage;
    }
}