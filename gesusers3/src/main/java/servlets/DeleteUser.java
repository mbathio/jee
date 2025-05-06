package servlets;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.ServletException;

import java.io.IOException;

import dao.UtilisateurDao;

@WebServlet("/delete")
public class DeleteUser extends HttpServlet {
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Récupérer l'ID de l'utilisateur à supprimer
        String idParam = request.getParameter("id");
        
        if (idParam != null && !idParam.isEmpty()) {
            try {
                int id = Integer.parseInt(idParam);
                
                // Utiliser la méthode DAO pour supprimer l'utilisateur
                UtilisateurDao.supprimer(id);
                
            } catch (NumberFormatException e) {
                // Gérer l'erreur si l'ID n'est pas un nombre
                request.setAttribute("erreur", "ID d'utilisateur invalide");
            }
        }
        
        // Rediriger vers la liste des utilisateurs
        response.sendRedirect(request.getContextPath() + "/list");
    }
}