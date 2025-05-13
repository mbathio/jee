package servlets;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.ServletException;

import java.io.IOException;

import beans.Utilisateur;
import dao.UtilisateurDao;
import forms.UserForm;

@WebServlet("/add")
public class AddUser extends HttpServlet
{
    // Correct path to match the actual file name
    private static final String VUE_AJOUT_UTILISATEUR = "/WEB-INF/ajouterUtilisateurs.jsp";
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        getServletContext().getRequestDispatcher(VUE_AJOUT_UTILISATEUR).forward(request, response);
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        // Utilisation de UserForm pour une meilleure validation
        UserForm form = new UserForm(request);
        if (form.ajouter()) {
            // Rediriger vers la liste des utilisateurs en cas de succès
            response.sendRedirect(request.getContextPath() + "/list");
        } else {
            // En cas d'erreur, afficher les erreurs sur la page du formulaire
            request.setAttribute("form", form);
            getServletContext().getRequestDispatcher(VUE_AJOUT_UTILISATEUR).forward(request, response);
        }
    }
}