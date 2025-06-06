package servlet;

import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/connexion") 
public class Connexion extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private static final String VALID_LOGIN = "admin";
    private static final String VALID_PASSWORD = "passer";
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Vérifier si l'utilisateur est déjà connecté
        HttpSession session = request.getSession(false);
        if (session != null && session.getAttribute("user") != null) {
            // Rediriger vers le tableau de bord s'il est déjà connecté
            response.sendRedirect(request.getContextPath() + "/dashboard.jsp");
            return;
        }
        
        // Sinon, afficher la page de connexion
        this.getServletContext().getRequestDispatcher("/WEB-INF/connexion.jsp").forward(request, response);
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        // Récupérer les paramètres du formulaire
        String login = request.getParameter("login");
        String password = request.getParameter("password");
        String message;
        
        // Valider les identifiants
        if (login != null && password != null) {
            if (login.equals(VALID_LOGIN) && password.equals(VALID_PASSWORD)) {
                // Create session on successful login
                HttpSession session = request.getSession();
                session.setAttribute("user", login);
                
                message = "<span style='color: green'>Connexion réussie !</span>";
                
                // Rediriger vers le tableau de bord après connexion réussie
                response.sendRedirect(request.getContextPath() + "/dashboard.jsp");
                return;
            } else {
                message = "<span style='color: red'>Échec de connexion. Login ou mot de passe incorrect.</span>";
            }
        } else {
            message = "<span style='color: orange'>Veuillez saisir vos identifiants.</span>";
        }
        
        // Transmettre le message à la JSP
        request.setAttribute("message", message);
        
        // Forward to the login page
        this.getServletContext().getRequestDispatcher("/WEB-INF/connexion.jsp").forward(request, response);
    }
}