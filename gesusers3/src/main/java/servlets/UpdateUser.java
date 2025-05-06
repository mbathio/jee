package servlets;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.ServletException;

import java.io.IOException;

import beans.Utilisateur;
import dao.UtilisateurDao;
import forms.UserForm;

@WebServlet("/update")
public class UpdateUser extends HttpServlet 
{
    // Correction to match the actual file name
    private static final String VUE_UPDATE_UTILISATEUR = "/WEB-INF/modifierUtilisateur.jsp";

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        // Récupérer l'ID de l'utilisateur à modifier
        String idParam = request.getParameter("id");
        
        if (idParam != null && !idParam.isEmpty()) {
            try {
                int id = Integer.parseInt(idParam);
                
                // Utiliser la méthode DAO pour trouver l'utilisateur
                Utilisateur utilisateur = UtilisateurDao.trouver(id);
                
                if (utilisateur != null) {
                    request.setAttribute("utilisateur", utilisateur);
                } else {
                    request.setAttribute("erreur", "Utilisateur non trouvé");
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
        // Utilisation de UserForm pour une meilleure validation
        UserForm form = new UserForm(request);
        if (form.modifie()) {
            // Rediriger vers la liste des utilisateurs en cas de succès
            response.sendRedirect(request.getContextPath() + "/list");
        } else {
            // En cas d'erreur, afficher les erreurs sur la page du formulaire
            request.setAttribute("form", form);
            request.setAttribute("utilisateur", form.getUtilisateur());
            getServletContext().getRequestDispatcher(VUE_UPDATE_UTILISATEUR).forward(request, response);
        }
    }
}