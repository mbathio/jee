package servlet;

import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

// Annotation pour configurer l'URL de la servlet
@WebServlet("/table")
public class Multiplication extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Définir le type de contenu de la réponse
        response.setContentType("text/html;charset=UTF-8");

        // Récupérer le paramètre "nombre" depuis l'URL
        String nombreParam = request.getParameter("nombre");
        try {
            // Convertir le paramètre en entier
            int nombre = Integer.parseInt(nombreParam);

            // Générer la table de multiplication
            StringBuilder tableHtml = new StringBuilder("<html><head><title>Table de multiplication</title></head><body>");
            tableHtml.append("<h1>Table de multiplication pour ").append(nombre).append("</h1>");
            tableHtml.append("<ul>");
            for (int i = 1; i <= 10; i++) {
                tableHtml.append("<li>").append(nombre).append(" x ").append(i).append(" = ").append(nombre * i).append("</li>");
            }
            tableHtml.append("</ul>");
            tableHtml.append("</body></html>");

            // Envoyer la réponse au client
            response.getWriter().write(tableHtml.toString());
        } catch (NumberFormatException e) {
            // Gérer le cas où le paramètre "nombre" n'est pas valide
            response.getWriter().write("<html><body><h1>Erreur : veuillez fournir un nombre valide.</h1></body></html>");
        }
    }
}
