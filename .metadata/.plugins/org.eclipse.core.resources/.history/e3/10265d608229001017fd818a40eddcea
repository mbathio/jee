package servlets;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.ServletException;

import java.io.IOException;

import beans.Utilisateur;
import dao.UtilisateurDao;

@WebServlet("/add")
public class AddUser extends HttpServlet
{
    private static final String VUE_AJOUT_UTILISATEUR = "/WEB-INF/ajouterUtilisateur.jsp";
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        getServletContext().getRequestDispatcher(VUE_AJOUT_UTILISATEUR).forward(request, response);
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        // Récupérer les paramètres du formulaire
        String nom = request.getParameter("nom");
        String prenom = request.getParameter("prenom");
        String login = request.getParameter("login");
        String password = request.getParameter("password");
        
        // Créer un nouvel utilisateur
        Utilisateur utilisateur = new Utilisateur(nom, prenom, login, password);
        
        // Ajouter l'utilisateur à la base de données
        UtilisateurDao.ajouter(utilisateur);
        
        // Rediriger vers la liste des utilisateurs
        response.sendRedirect(request.getContextPath() + "/list");
    }
}