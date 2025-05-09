package forms;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

import beans.Utilisateur;
import dao.UtilisateurDao;

public class AuthentificationForm {
	private static final String CHAMP_LOGIN = "login";
	private static final String CHAMP_PASSWORD = "password";

	private String login;
	private HttpServletRequest request;
	private Utilisateur utilisateur;

	public AuthentificationForm(HttpServletRequest request) {
		this.request = request;
	}

	public boolean authentifier() {
		login = getParameter(CHAMP_LOGIN);
		String password = getParameter(CHAMP_PASSWORD);

		if ("admin".equals(login) && "passer".equals(password)) {
			utilisateur = new Utilisateur("ADMIN", "ADMIN", "ADMIN", "ADMIN");
		} else {
			utilisateur = UtilisateurDao.get(login);
			if (utilisateur != null && !utilisateur.getPassword().equals(password)) {
				utilisateur = null;
			}
		}

		if (utilisateur != null) {
			HttpSession session = request.getSession();
			session.setAttribute("utilisateur", utilisateur);
			return true;
		}

		return false;
	}

	private String getParameter(String parametre) {
		String valeur = request.getParameter(parametre);
		return (valeur == null || valeur.trim().isEmpty()) ? null : valeur.trim();
	}

	public String getLogin() {
		return login;
	}

	public Utilisateur getUtilisateur() {
		return utilisateur;
	}
}
