package servlet;

import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/inscription")
public class Inscription extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        // Afficher le formulaire d'inscription
        this.getServletContext().getRequestDispatcher("/WEB-INF/inscription.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        // Définir l'encodage pour les caractères accentués
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");

        // Récupérer les paramètres du formulaire
        String nom = request.getParameter("nom");
        String prenom = request.getParameter("prenom");
        String password = request.getParameter("password");
        String email = request.getParameter("email");
        String message;

        // Validation basique des données
        if (nom == null || nom.trim().isEmpty() ||
            prenom == null || prenom.trim().isEmpty() ||
            password == null || password.trim().isEmpty() ||
            email == null || email.trim().isEmpty()) {
            
            message = "<span style='color: red'>Tous les champs sont obligatoires.</span>";
            request.setAttribute("message", message);
            this.getServletContext().getRequestDispatcher("/WEB-INF/inscription.jsp").forward(request, response);
            return;
        }

        try {
            // Simulation d'un enregistrement réussi
            message = "<span style='color: green'>Inscription réussie pour " + prenom + " " + nom + "</span>";
            request.setAttribute("message", message);
            
            // Rediriger vers la page de connexion avec un message de succès
            request.setAttribute("message", message);
            this.getServletContext().getRequestDispatcher("/WEB-INF/connexion.jsp").forward(request, response);

        } catch (Exception e) {
            // Gestion des erreurs
            message = "<span style='color: red'>Une erreur est survenue : " + e.getMessage() + "</span>";
            request.setAttribute("message", message);
            this.getServletContext().getRequestDispatcher("/WEB-INF/inscription.jsp").forward(request, response);
        }
    }
}