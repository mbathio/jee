package servlets;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;

@WebServlet("/update")
public class UpdateUser extends HttpServlet 
{
	private static final String VUE_UPDATE_UTILISATEUR = "/WEB-INF/modifierUtilisateurs.jsp";

}
