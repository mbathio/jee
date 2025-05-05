package servlets;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.ServletException;

import java.io.IOException;
import java.util.ArrayList;

import beans.Utilisateur;
import dao.UtilisateurDao;

@WebServlet("/update")
public class UpdateUser extends HttpServlet 
{
    private static final String VUE_UPDATE_UTILISATEUR = "/WEB-INF/modifierUtilisateur.jsp";

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        // Récupérer l'ID de l'utilisateur à modifier
        String idParam = request.getParameter("id");
        
        if (idParam != null && !idParam.isEmpty()) {
            try {
                int id = Integer.parseInt(idParam);
                
                // Récupérer la liste des utilisateurs
                ArrayList<Utilisateur> utilisateurs = UtilisateurDao.lister();
                
                // Chercher l'utilisateur avec l'ID correspondant
                for (Utilisateur utilisateur : utilisateurs) {
                    if (utilisateur.getId() == id) {
                        request.setAttribute("utilisateur", utilisateur);
                        break;
                    }
                }
            } catch (NumberFormatException e) {
                // Gérer l'erreur si l'ID n'est pas un nombre
                request.setAttribute("erreur", "ID d'utilisateur invalide");
            }
        }
        
        getServletContext().getRequestDispatcher(VUE_UPDATE_UTILISATEUR).forward(request, response);
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        // Récupérer les paramètres du formulaire
        String idParam = request.getParameter("id");
        String nom = request.getParameter("nom");
        String prenom = request.getParameter("prenom");
        String login = request.getParameter("login");
        String password = request.getParameter("password");
        
        if (idParam != null && !idParam.isEmpty()) {
            try {
                int id = Integer.parseInt(idParam);
                
                // Récupérer la liste des utilisateurs
                ArrayList<Utilisateur> utilisateurs = UtilisateurDao.lister();
                
                // Chercher et mettre à jour l'utilisateur avec l'ID correspondant
                for (Utilisateur utilisateur : utilisateurs) {
                    if (utilisateur.getId() == id) {
                        utilisateur.setNom(nom);
                        utilisateur.setPrenom(prenom);
                        utilisateur.setLogin(login);
                        utilisateur.setPassword(password);
                        break;
                    }
                }
            } catch (NumberFormatException e) {
                // Gérer l'erreur si l'ID n'est pas un nombre
                request.setAttribute("erreur", "ID d'utilisateur invalide");
            }
        }
        
        // Rediriger vers la liste des utilisateurs
        response.sendRedirect(request.getContextPath() + "/list");
    }
}