package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/inscription")
public class Inscription extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Définir le type de contenu de la réponse
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        // Récupérer les paramètres du formulaire
        String nom = request.getParameter("nom");
        String prenom = request.getParameter("prenom");
        String password = request.getParameter("password");
        String email = request.getParameter("email");

        // Validation basique des données
        if (nom == null || nom.trim().isEmpty() ||
            prenom == null || prenom.trim().isEmpty() ||
            password == null || password.trim().isEmpty() ||
            email == null || email.trim().isEmpty()) {
            
            // Réponse en cas de champ manquant
            out.println("<html><body>");
            out.println("<h2>Erreur d'inscription</h2>");
            out.println("<p>Tous les champs sont obligatoires.</p>");
            out.println("<a href='inscription.jsp'>Retour</a>");
            out.println("</body></html>");
            return;
        }

        // Ici, vous pourriez ajouter une logique de validation plus avancée
        // Par exemple, vérifier la longueur du mot de passe, le format de l'email, etc.

        try {
            // Simulation d'un enregistrement 
            // Réponse de succès
            out.println("<html><body>");
            out.println("<h2>Inscription réussie</h2>");
            out.println("<p>Bienvenue, " + nom + " " + prenom + "</p>");
            out.println("<a href='connexion.jsp'>Se connecter</a>");
            out.println("</body></html>");

        } catch (Exception e) {
            // Gestion des erreurs
            out.println("<html><body>");
            out.println("<h2>Erreur lors de l'inscription</h2>");
            out.println("<p>Une erreur est survenue : " + e.getMessage() + "</p>");
            out.println("<a href='inscription.jsp'>Réessayer</a>");
            out.println("</body></html>");
        }
    }
}